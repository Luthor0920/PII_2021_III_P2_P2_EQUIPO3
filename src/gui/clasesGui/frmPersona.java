package gui.clasesGui;

import negocio.clases.PersonaNegocio;
import recursos.clases.Item;
import recursos.clases.Persona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class frmPersona {
    private JPanel jpaPrincipal;
    private JPanel jpaTitulo;
    private JLabel Persona;
    private JPanel jpaContenido;
    private JTextField txtDNI;
    private JTextField txtNombre;
    private JTextField txtFechaNacimiento;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JTextField txtEdad;
    private JComboBox cboComboPersona;
    private JPanel jpaBotones;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JButton btnLeerCombo;
    private JPanel jpaDatos;
    private JScrollPane sclPanDatos;
    private JTable tblDatos;
    private JLabel lblDNI;
    private JLabel lblNombre;
    private JLabel lblFechaNacimiento;
    private JLabel lblDireccion;
    private JLabel lblTelefono;
    private JLabel lblCorreo;
    private JLabel lblEdad;
    private JLabel lblPersona;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modelo;

    public frmPersona() {
        iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Persona persona = new Persona();
                    persona.setDNI(Long.parseLong(txtDNI.getText()));
                    persona.setNombre(txtNombre.getText());
                    persona.setFechaNacimiento(convertirFormatoTextoFecha(txtFechaNacimiento.getText()));
                    persona.setDireccion(txtDireccion.getText());
                    persona.setTelefono(Long.parseLong(txtTelefono.getText()));
                    persona.setCorreo(txtCorreo.getText());
                    persona.setEdad(Integer.parseInt(txtEdad.getText()));
                    String respuesta = new PersonaNegocio().insertar(persona);
                    if (!respuesta.contains("Error")) {
                        JOptionPane.showMessageDialog(null, "Guardado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarComboPersonas();
                        limpiar();
                    }
                    else
                        throw new Exception(respuesta);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        txtFechaNacimiento.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH))) {
                    JOptionPane.showMessageDialog(null, "Porfavor ingrese una fecha correcta.");
                    e.consume(); //permite que no se detone, o que se escriba lo que se ha typeado
                    //super.keyTyped(e);
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Persona persona = new Persona();
                    persona.setDNI(Long.parseLong(txtDNI.getText()));
                    persona.setNombre(txtNombre.getText());
                    persona.setFechaNacimiento(convertirFormatoTextoFecha(txtFechaNacimiento.getText()));
                    persona.setDireccion(txtDireccion.getText());
                    persona.setTelefono(Long.parseLong(txtTelefono.getText()));
                    persona.setCorreo(txtCorreo.getText());
                    persona.setEdad(Integer.parseInt(txtEdad.getText()));
                    new PersonaNegocio().actualizar(persona);
                    leerDatos();
                    limpiar();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leerDatos();
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Persona personaBuscar = new Persona();
                    personaBuscar.setNombre(txtNombre.getText());
                    List<Persona> listaPersonas = new PersonaNegocio().buscar(personaBuscar);
                    modelo.setRowCount(0);
                    for (Persona persona: listaPersonas) {
                        Object[] registroLeido= {
                                persona.getDNI(),
                                persona.getNombre(),
                                sdf.format(persona.getFechaNacimiento()),
                                persona.getDireccion(),
                                persona.getTelefono(),
                                persona.getCorreo(),
                                persona.getEdad()
                        };
                        modelo.addRow(registroLeido);
                    }
                    tblDatos.setModel(modelo);
                    limpiar();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int confirmar = JOptionPane.showConfirmDialog(null,
                            "Esta seguro que desea eliminar el registro?",
                            "Eliminar Precaucion", JOptionPane.WARNING_MESSAGE);
                    if (confirmar == JOptionPane.YES_OPTION) {
                        Persona persona = new Persona();
                        persona.setDNI(Long.parseLong(txtDNI.getText()));
                        persona.setNombre(txtNombre.getText());
                        persona.setFechaNacimiento(convertirFormatoTextoFecha(txtFechaNacimiento.getText()));
                        persona.setDireccion(txtDireccion.getText());
                        persona.setTelefono(Long.parseLong(txtTelefono.getText()));
                        persona.setCorreo(txtCorreo.getText());
                        persona.setEdad(Integer.parseInt(txtEdad.getText()));
                        new PersonaNegocio().eliminar(persona);
                        leerDatos();
                        llenarComboPersonas();
                        limpiar();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tblDatos.getSelectedRow();
                txtDNI.setText(modelo.getValueAt(filaSeleccionada, 0).toString());
                txtNombre.setText(modelo.getValueAt(filaSeleccionada, 1).toString());
                txtFechaNacimiento.setText(modelo.getValueAt(filaSeleccionada, 2).toString());
                txtDireccion.setText(modelo.getValueAt(filaSeleccionada, 3).toString());
                txtTelefono.setText(modelo.getValueAt(filaSeleccionada, 4).toString());
                txtCorreo.setText(modelo.getValueAt(filaSeleccionada, 5).toString());
                txtEdad.setText(modelo.getValueAt(filaSeleccionada, 6).toString());

            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboComboPersona.getSelectedItem();
                long itemPersona = ((Item)objeto).getCodigo(); //(DNI)
                JOptionPane.showMessageDialog(null, itemPersona);
            }
        });
    }

    private void iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Fecha de Nacimiento");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Correo");
        modelo.addColumn("Edad");
        leerDatos();
        llenarComboPersonas();
    }

    private void leerDatos() {
        try {
            List<Persona> listaPersonas = new PersonaNegocio().Leer();
            modelo.setRowCount(0);
            for (Persona persona: listaPersonas) {
                Object[] registroLeido= {
                        persona.getDNI(),
                        persona.getNombre(),
                        sdf.format(persona.getFechaNacimiento()),
                        persona.getDireccion(),
                        persona.getTelefono(),
                        persona.getCorreo(),
                        persona.getEdad()
                };
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarComboPersonas() {
        try {
            List<Persona> listaPersonas = new PersonaNegocio().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Persona persona: listaPersonas) {
                Item item= new Item(persona.getDNI(), persona.getNombre());
                modeloCombo.addElement(item);
            }
            cboComboPersona.setModel(modeloCombo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Date convertirFormatoTextoFecha(String textoFecha) {
        Date fecha = null;
        try {
            fecha = sdf.parse(textoFecha);
        } catch (ParseException pe) {
            JOptionPane.showMessageDialog(null, pe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return fecha;
    }

    private void limpiar() {
        txtDNI.setText("");
        txtNombre.setText("");
        txtFechaNacimiento.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtEdad.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Personas");
        frame.setContentPane(new frmPersona().jpaPrincipal);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
