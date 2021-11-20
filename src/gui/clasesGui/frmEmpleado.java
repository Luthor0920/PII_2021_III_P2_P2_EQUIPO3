package gui.clasesGui;

import negocio.clases.EmpleadoNegocio;
import negocio.clases.PersonaNegocio;
import recursos.clases.Empleado;
import recursos.clases.Item;
import recursos.clases.Persona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class frmEmpleado {
    private JPanel jpaPrincipal;
    private JPanel jpaTitulo;
    private JLabel lblTitulo;
    private JPanel jpaContenido;
    private JTextField txtCodigo;
    private JComboBox cboNombre;
    private JTextField txtDNI;
    private JTextField txtPuesto;
    private JTextField txtSueldo;
    private JTextField txtFechaIngreso;
    private JTextField txtNivelAcademico;
    private JComboBox cboComboEmpleado;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JButton btnLeerCombo;
    private JTable tblDatos;
    private JPanel jpaBotones;
    private JPanel jpaDatos;
    private JScrollPane sclPanDatos;
    private JLabel lblCodigo;
    private JLabel lblNombre;
    private JLabel lblDNI;
    private JLabel lblPuesto;
    private JLabel lblSueldo;
    private JLabel lblFechaIngreso;
    private JLabel lblNivelAcademico;
    private JLabel lblEmpleado;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modelo;

    public frmEmpleado() {
        iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Empleado empleado = new Empleado();
                    empleado.setCodigo(Long.parseLong(txtCodigo.getText()));
                    empleado.setNombre(cboNombre.getSelectedItem().toString());
                    empleado.setDNI(Long.parseLong(txtDNI.getText()));
                    empleado.setPuesto(txtPuesto.getText());
                    empleado.setSueldo(Double.parseDouble(txtSueldo.getText()));
                    empleado.setFechaIngreso(convertirFormatoTextoFecha(txtFechaIngreso.getText()));
                    empleado.setNivelAcademico(txtNivelAcademico.getText());
                    String respuesta = new EmpleadoNegocio().insertar(empleado);
                    if (!respuesta.contains("Error")) {
                        JOptionPane.showMessageDialog(null, "Guardado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarComboEmpleado();
                    }
                    else
                        throw new Exception(respuesta);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        txtFechaIngreso.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH))) {
                    JOptionPane.showMessageDialog(null, "Porfavor ingrese una fecha correcta.");
                    e.consume();
                    //super.keyTyped(e);
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Empleado empleado = new Empleado();
                    empleado.setCodigo(Long.parseLong(txtCodigo.getText()));
                    empleado.setNombre(cboNombre.getSelectedItem().toString());
                    empleado.setDNI(Long.parseLong(txtDNI.getText()));
                    empleado.setPuesto(txtPuesto.getText());
                    empleado.setSueldo(Double.parseDouble(txtSueldo.getText()));
                    empleado.setFechaIngreso(convertirFormatoTextoFecha(txtFechaIngreso.getText()));
                    empleado.setNivelAcademico(txtNivelAcademico.getText());
                    new EmpleadoNegocio().actualizar(empleado);
                    leerDatos();
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
                    Empleado empleadoBuscar = new Empleado();
                    empleadoBuscar.setNombre(cboNombre.getSelectedItem().toString());
                    List<Empleado> listaEmpleados = new EmpleadoNegocio().buscar(empleadoBuscar);
                    modelo.setRowCount(0);
                    for (Empleado empleado: listaEmpleados) {
                        Object[] registroLeido= {
                                empleado.getCodigo(),
                                empleado.getNombre(),
                                empleado.getDNI(),
                                empleado.getPuesto(),
                                empleado.getSueldo(),
                                sdf.format(empleado.getFechaIngreso()),
                                empleado.getNivelAcademico()
                        };
                        modelo.addRow(registroLeido);
                    }
                    tblDatos.setModel(modelo);

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
                            "Eliminar Precaucion",
                            JOptionPane.WARNING_MESSAGE);
                    if (confirmar == JOptionPane.YES_OPTION) {
                        Empleado empleado = new Empleado();
                        empleado.setCodigo(Long.parseLong(txtCodigo.getText()));
                        empleado.setNombre(cboNombre.getSelectedItem().toString());
                        empleado.setDNI(Long.parseLong(txtDNI.getText()));
                        empleado.setPuesto(txtPuesto.getText());
                        empleado.setSueldo(Double.parseDouble(txtSueldo.getText()));
                        empleado.setFechaIngreso(convertirFormatoTextoFecha(txtFechaIngreso.getText()));
                        empleado.setNivelAcademico(txtNivelAcademico.getText());
                        new EmpleadoNegocio().eliminar(empleado);
                        leerDatos();
                        llenarComboEmpleado();
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
                DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();

                txtCodigo.setText(modelo.getValueAt(filaSeleccionada, 0).toString());
                modeloCombo.addElement(modelo.getValueAt(filaSeleccionada, 1));
                cboNombre.setModel(modeloCombo);
                txtDNI.setText(modelo.getValueAt(filaSeleccionada,2).toString());
                txtPuesto.setText(modelo.getValueAt(filaSeleccionada,3).toString());
                txtSueldo.setText(modelo.getValueAt(filaSeleccionada, 4).toString());
                txtFechaIngreso.setText(modelo.getValueAt(filaSeleccionada,5).toString());
                txtNivelAcademico.setText(modelo.getValueAt(filaSeleccionada, 6).toString());
            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboComboEmpleado.getSelectedItem();
                long itemEmpleado = ((Item)objeto).getCodigo();
                JOptionPane.showMessageDialog(null, itemEmpleado);
            }
        });
        cboNombre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Object objeto = cboNombre.getSelectedItem();
                    long dni = ((Item)objeto).getCodigo();

                    txtDNI.setText(String.valueOf(dni));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Errpr", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        txtDNI.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                JOptionPane.showMessageDialog(null, "Seleccione el DNI.");
                e.consume();
            }
        });
    }

    private void iniciar() {
        try {
            modelo = (DefaultTableModel) tblDatos.getModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("DNI");
            modelo.addColumn("Puesto");
            modelo.addColumn("Sueldo");
            modelo.addColumn("Fecha de Ingreso");
            modelo.addColumn("Nivel Academico");
            leerDatos();
            llenarComboEmpleado();
            llenarComboNombre();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void leerDatos() {
        try {
            List<Empleado> listaEmpleados = new EmpleadoNegocio().leer();
            modelo.setRowCount(0);
            for (Empleado empleado: listaEmpleados) {
                Object[] registroLeido= {
                        empleado.getCodigo(),
                        empleado.getNombre(),
                        empleado.getDNI(),
                        empleado.getPuesto(),
                        empleado.getSueldo(),
                        sdf.format(empleado.getFechaIngreso()),
                        empleado.getNivelAcademico()
                };
                modelo.addColumn(registroLeido);
            }
            tblDatos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarComboEmpleado() {
        try {
            List<Empleado> listaEmpleados = new EmpleadoNegocio().leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Empleado empleado: listaEmpleados) {
                Item item = new Item(empleado.getCodigo(), empleado.getNombre());
                modeloCombo.addElement(item);
            }
            cboComboEmpleado.setModel(modeloCombo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarComboNombre() {
        try {
            List<Persona> listaPersonas = new PersonaNegocio().Leer();
            DefaultComboBoxModel modeloDNI = new DefaultComboBoxModel();
            for (Persona persona: listaPersonas) {
                Item item = new Item(persona.getDNI(), persona.getNombre());
                modeloDNI.addElement(item);
            }
            cboNombre.setModel(modeloDNI);
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Empleados");
        frame.setContentPane(new frmEmpleado().jpaPrincipal);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
