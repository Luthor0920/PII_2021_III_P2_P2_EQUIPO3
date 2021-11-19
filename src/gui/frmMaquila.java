package gui;

import negocio.clases.MaquilaNegocio;
import recursos.clases.Item;
import recursos.clases.Maquila;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class frmMaquila {
    private JLabel lblCodigo;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JTextField txtFechaInicio;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JPanel jpaBotones;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JButton btnLeerCombo;
    private JLabel lblNombre;
    private JLabel lblDireccion;
    private JLabel lblFechaInicio;
    private JLabel lblTelefono;
    private JLabel lblCorreo;
    private JTextField txtCantEmpleados;
    private JLabel lblCantEmpleados;
    private JPanel jpaContenido;
    private JPanel jpaTitulo;
    private JPanel jpaPrincipal;
    private JPanel jpaDatos;
    private JScrollPane sclPanDatos;
    private JTable tblDatos;
    private JComboBox cboComboMaquila;
    private JLabel lblCombo;
    private JLabel lblTitulo;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modelo;

    public frmMaquila() {
        iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Maquila maquila = new Maquila();
                    maquila.setCodigo(Long.parseLong(txtCodigo.getText()));
                    maquila.setNombre(txtNombre.getText());
                    maquila.setDireccion(txtDireccion.getText());
                    maquila.setFechaInicio(convertirFormatoTextoFecha(txtFechaInicio.getText()));
                    maquila.setTelefono(Long.parseLong(txtTelefono.getText()));
                    maquila.setCorreo(txtCorreo.getText());
                    maquila.setCantidadEmpleados(Integer.parseInt(txtCantEmpleados.getText()));
                    String respuesta = new MaquilaNegocio().insertar(maquila);
                    if (!respuesta.contains("Error")) {
                        JOptionPane.showMessageDialog(null,"Guardado.", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        //llenarComboMaquilas();
                    }
                    else
                        throw new Exception(respuesta);
                    llenarComboMaquilas();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        txtFechaInicio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH))) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese una fecha correcta.");
                    e.consume();
                }
                //super.keyTyped(e);
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Maquila maquila = new Maquila();
                    maquila.setCodigo(Long.parseLong(txtCodigo.getText()));
                    maquila.setNombre(txtNombre.getText());
                    maquila.setDireccion(txtDireccion.getText());
                    maquila.setFechaInicio(convertirFormatoTextoFecha(txtFechaInicio.getText()));
                    maquila.setTelefono(Long.parseLong(txtTelefono.getText()));
                    maquila.setCorreo(txtCorreo.getText());
                    maquila.setCantidadEmpleados(Integer.parseInt(txtCantEmpleados.getText()));
                    new MaquilaNegocio().actualizar(maquila);
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
                    Maquila maquilaBuscar = new Maquila();
                    maquilaBuscar.setNombre(txtNombre.getText());
                    List<Maquila> listaMaquilas = new MaquilaNegocio().buscar(maquilaBuscar);
                    modelo.setRowCount(0);
                    for (Maquila maquila: listaMaquilas) {
                        Object[] registroLeido= {
                                maquila.getCodigo(),
                                maquila.getNombre(),
                                maquila.getDireccion(),
                                sdf.format(maquila.getFechaInicio()),
                                maquila.getTelefono(),
                                maquila.getCorreo(),
                                maquila.getCantidadEmpleados()
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
                            "Eliminar Precacion", JOptionPane.WARNING_MESSAGE);
                    if (confirmar == JOptionPane.YES_OPTION) {
                        Maquila maquila = new Maquila();
                        maquila.setCodigo(Long.parseLong(txtCodigo.getText()));
                        maquila.setNombre(txtNombre.getText());
                        maquila.setDireccion(txtDireccion.getText());
                        maquila.setFechaInicio(convertirFormatoTextoFecha(txtFechaInicio.getText()));
                        maquila.setTelefono(Long.parseLong(txtTelefono.getText()));
                        maquila.setCorreo(txtCorreo.getText());
                        maquila.setCantidadEmpleados(Integer.parseInt(txtCantEmpleados.getText()));
                        new MaquilaNegocio().eliminar(maquila);
                        leerDatos();
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
                txtCodigo.setText(modelo.getValueAt(filaSeleccionada, 0).toString());
                txtNombre.setText(modelo.getValueAt(filaSeleccionada, 1).toString());
                txtDireccion.setText(modelo.getValueAt(filaSeleccionada, 2).toString());
                txtFechaInicio.setText(modelo.getValueAt(filaSeleccionada, 3).toString());
                txtTelefono.setText(modelo.getValueAt(filaSeleccionada, 4).toString());
                txtCorreo.setText(modelo.getValueAt(filaSeleccionada, 5).toString());
                txtCantEmpleados.setText(modelo.getValueAt(filaSeleccionada, 6).toString());
            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboComboMaquila.getSelectedItem();
                long itemMaquila = ((Item)objeto).getCodigo();
                JOptionPane.showMessageDialog(null, itemMaquila);
            }
        });
    }

    private void iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Fecha de Inicio");
        modelo.addColumn("Telefono");
        modelo.addColumn("Correo");
        modelo.addColumn("Cantidad de Empleados");
        leerDatos();
        llenarComboMaquilas();
    }
    private void leerDatos() {
        try {
            List<Maquila> listaMaquilas = new MaquilaNegocio().Leer();
            modelo.setRowCount(0);
            for (Maquila maquila: listaMaquilas) {
                Object[] registroLeido= {
                        maquila.getCodigo(),
                        maquila.getNombre(),
                        maquila.getDireccion(),
                        sdf.format(maquila.getFechaInicio()),
                        maquila.getTelefono(),
                        maquila.getCorreo(),
                        maquila.getCantidadEmpleados()
                };
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarComboMaquilas() {
        try {
            List<Maquila> listaMaquilas = new MaquilaNegocio().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Maquila maquila: listaMaquilas) {
                Item item = new Item(
                        maquila.getCodigo(), maquila.getNombre()
                );
                modeloCombo.addElement(item);
            }
            cboComboMaquila.setModel(modeloCombo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Date convertirFormatoTextoFecha(String txtFecha) {
        Date fecha = null;
        try {
            fecha = sdf.parse(txtFecha);
        } catch (ParseException pe) {
            JOptionPane.showMessageDialog(null, pe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return fecha;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("frmMaquila");
        frame.setContentPane(new frmMaquila().jpaPrincipal);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
