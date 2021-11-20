package gui.clasesGui;

import negocio.clases.ProveedorNegocio;
import recursos.clases.Item;
import recursos.clases.Proveedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class frmProduccion {
    private JPanel jpaPrincipal;
    private JPanel jpaTitulo;
    private JLabel lblTitulo;
    private JPanel jpaContenido;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtFechaInicio;
    private JTextField txtCorreo;
    private JTextField txtTipoProveedor;
    private JComboBox cboComboProveedor;
    private JLabel lblCodigo;
    private JLabel lblNombre;
    private JLabel lblDireccion;
    private JLabel lblTelefono;
    private JLabel lblFechaInicio;
    private JLabel lblCorreo;
    private JLabel lblTipoProveedor;
    private JLabel lblComboProveedor;
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
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modelo;

    public frmProduccion() {
        iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                   Proveedor proveedor = new Proveedor();
                   proveedor.setCodigo(Long.parseLong(txtCodigo.getText()));
                   proveedor.setNombre(txtNombre.getText());
                   proveedor.setDireccion(txtDireccion.getText());
                   proveedor.setTelefono(Long.parseLong(txtTelefono.getText()));
                   proveedor.setFechaInicio(convertirFormatoTextoFecha(txtFechaInicio.getText()));
                   proveedor.setCorreo(txtCorreo.getText());
                   proveedor.setTipoProveedor(txtTipoProveedor.getText());
                   String respuesta = new ProveedorNegocio().insertar(proveedor);
                   if (!respuesta.contains("Error")) {
                       JOptionPane.showMessageDialog(null,"Guardado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                       leerDatos();
                       llenarComboProveedor();
                   }
                   else
                       throw new Exception(respuesta);
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
                    Proveedor proveedor = new Proveedor();
                    proveedor.setCodigo(Long.parseLong(txtCodigo.getText()));
                    proveedor.setNombre(txtNombre.getText());
                    proveedor.setDireccion(txtDireccion.getText());
                    proveedor.setTelefono(Long.parseLong(txtTelefono.getText()));
                    proveedor.setFechaInicio(convertirFormatoTextoFecha(txtFechaInicio.getText()));
                    proveedor.setCorreo(txtCorreo.getText());
                    proveedor.setTipoProveedor(txtTipoProveedor.getText());
                    new ProveedorNegocio().actualizar(proveedor);
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
                    Proveedor buscarProveedor = new Proveedor();
                    buscarProveedor.setNombre(txtNombre.getText());
                    List<Proveedor> listaProveedores = new ProveedorNegocio().buscar(buscarProveedor);
                    modelo.setRowCount(0);
                    for (Proveedor proveedor: listaProveedores) {
                        Object[] registroLeido= {
                                proveedor.getCodigo(),
                                proveedor.getNombre(),
                                proveedor.getDireccion(),
                                proveedor.getTelefono(),
                                sdf.format(proveedor.getFechaInicio()),
                                proveedor.getCorreo(),
                                proveedor.getTipoProveedor()
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
                            "Eliminar Precaucion", JOptionPane.WARNING_MESSAGE);
                    if (confirmar == JOptionPane.YES_OPTION) {
                        Proveedor proveedor = new Proveedor();
                        proveedor.setCodigo(Long.parseLong(txtCodigo.getText()));
                        proveedor.setNombre(txtNombre.getText());
                        proveedor.setDireccion(txtDireccion.getText());
                        proveedor.setTelefono(Long.parseLong(txtTelefono.getText()));
                        proveedor.setFechaInicio(convertirFormatoTextoFecha(txtFechaInicio.getText()));
                        proveedor.setCorreo(txtCorreo.getText());
                        proveedor.setTipoProveedor(txtTipoProveedor.getText());
                        new ProveedorNegocio().eliminar(proveedor);
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
                txtCodigo.setText(modelo.getValueAt(filaSeleccionada,0).toString());
                txtNombre.setText(modelo.getValueAt(filaSeleccionada, 1).toString());
                txtDireccion.setText(modelo.getValueAt(filaSeleccionada,2).toString());
                txtTelefono.setText(modelo.getValueAt(filaSeleccionada,3).toString());
                txtFechaInicio.setText(modelo.getValueAt(filaSeleccionada,4).toString());
                txtCorreo.setText(modelo.getValueAt(filaSeleccionada,5).toString());
                txtTipoProveedor.setText(modelo.getValueAt(filaSeleccionada,6).toString());
            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboComboProveedor.getSelectedItem();
                long itemProveedor = ((Item)objeto).getCodigo();
                JOptionPane.showMessageDialog(null,itemProveedor);
            }
        });
    }

    private void iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Fecha de Inicio");
        modelo.addColumn("Correo");
        modelo.addColumn("Tipo de Proveedor");
        leerDatos();
        llenarComboProveedor();
    }

    private void leerDatos() {
        try {
            List<Proveedor> listaProveedores = new ProveedorNegocio().Leer();
            modelo.setRowCount(0);
            for (Proveedor proveedor: listaProveedores) {
                Object[] registroLeido= {
                        proveedor.getCodigo(),
                        proveedor.getNombre(),
                        proveedor.getDireccion(),
                        proveedor.getTelefono(),
                        sdf.format(proveedor.getFechaInicio()),
                        proveedor.getCorreo(),
                        proveedor.getTipoProveedor()
                };
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarComboProveedor() {
        try {
            List<Proveedor> listaProveedores = new ProveedorNegocio().Leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Proveedor proveedor: listaProveedores) {
                Item item = new Item(
                        proveedor.getCodigo(), proveedor.getNombre()
                );
                modeloCombo.addElement(item);
            }
            cboComboProveedor.setModel(modeloCombo);
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
        JFrame frame = new JFrame("frmProduccion");
        frame.setContentPane(new frmProduccion().jpaPrincipal);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
