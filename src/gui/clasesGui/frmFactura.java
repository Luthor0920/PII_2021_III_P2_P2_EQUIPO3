package gui.clasesGui;

import negocio.clases.ClienteNegocio;
import negocio.clases.EmpleadoNegocio;
import negocio.clases.FacturaNegocio;
import negocio.clases.ProduccionNegocio;
import recursos.clases.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class frmFactura {
    private JPanel jpaPrincipal;
    private JPanel jpaContenido;
    private JTextField txtNumeroFactura;
    private JLabel lblFecha;
    private JPanel jpaBotones;
    private JPanel jpaTitulo;
    private JLabel lblTitulo;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JButton btnLeerCombo;
    private JTable tblDatos;
    private JPanel jpaDatos;
    private JScrollPane sclPanDatos;
    private JComboBox cboCliente;
    private JComboBox cboEmpleado;
    private JTextField txtProducto;
    private JTextField txtCantidad;
    private JButton btnGenerarFactura;
    private JComboBox cboComboFactura;
    private JLabel lblNumeroFactura;
    private JTextField txtFecha;
    private JLabel lblCliente;
    private JLabel lblEmpleado;
    private JLabel lblProducto;
    private JLabel lblCantidad;
    private JLabel lblFactura;
    private JLabel lblTotalPagar;
    private JTextField txtTotalPagar;
    private JComboBox cboProduccion;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modelo;
    private double Precio;
    private static double ISV = 0.12;

    public frmFactura() {
        iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtTotalPagar.getText().isEmpty())
                        throw new Exception("Error: El total a pagar no debe estar vacio.");
                    Factura factura = new Factura();
                    factura.setNumeroFactura(Long.parseLong(txtNumeroFactura.getText()));
                    factura.setCliente(cboCliente.getSelectedItem().toString());
                    factura.setEmpleado(cboEmpleado.getSelectedItem().toString());
                    factura.setFecha(convertirFormatoTextoFecha(txtFecha.getText()));
                    factura.setProducto(cboProduccion.getSelectedItem().toString());
                    factura.setCantidad(Integer.parseInt(txtCantidad.getText()));
                    factura.setISV(ISV);
                    factura.setSubTotal((Integer.parseInt(txtCantidad.getText())) * Precio);
                    double isv = (Integer.parseInt(txtCantidad.getText()) * Precio) * ISV;
                    factura.setTotalPagar(((Integer.parseInt(txtCantidad.getText())) * Precio) + isv);
                    String respuesta = new FacturaNegocio().IngresarFactura(factura);
                    if (!respuesta.contains("Error")) {
                        JOptionPane.showMessageDialog(null, "Guardado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarComboFactura();
                        llenarComboEmpleado();
                        llenarComboCliente();
                        llenarComboProducto();
                        limpiar();
                    }
                    else
                        throw new Exception(respuesta);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        txtFecha.addKeyListener(new KeyAdapter() {
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
        txtTotalPagar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                JOptionPane.showMessageDialog(null, "Debe generar la factura.");
                e.consume();
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtTotalPagar.getText().isEmpty())
                        throw new Exception("Error: El total a pagar no debe estar vacio.");
                    Factura factura = new Factura();
                    factura.setNumeroFactura(Long.parseLong(txtNumeroFactura.getText()));
                    factura.setCliente(cboCliente.getSelectedItem().toString());
                    factura.setEmpleado(cboEmpleado.getSelectedItem().toString());
                    factura.setFecha(convertirFormatoTextoFecha(txtFecha.getText()));
                    factura.setProducto(cboProduccion.getSelectedItem().toString());
                    factura.setCantidad(Integer.parseInt(txtCantidad.getText()));
                    factura.setISV(ISV);
                    factura.setSubTotal((Integer.parseInt(txtCantidad.getText())) * Precio);
                    double isv = (Integer.parseInt(txtCantidad.getText()) * Precio) * ISV;
                    factura.setTotalPagar(((Integer.parseInt(txtCantidad.getText())) * Precio) + isv);
                    new FacturaNegocio().Actualizar(factura);
                    leerDatos();
                    llenarComboCliente();
                    llenarComboEmpleado();
                    llenarComboProducto();
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
                    Factura facturaBuscar = new Factura();
                    facturaBuscar.setNumeroFactura(Long.parseLong(txtNumeroFactura.getText()));
                    List<Factura> listaFactura = new FacturaNegocio().Buscar(facturaBuscar);
                    modelo.setRowCount(0);
                    for (Factura factura: listaFactura) {
                        Object[] registroLeido= {
                                factura.getNumeroFactura(),
                                factura.getCliente(),
                                factura.getEmpleado(),
                                sdf.format(factura.getFecha()),
                                factura.getProducto(),
                                factura.getCantidad(),
                                factura.getTotalPagar()
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
                        Factura factura = new Factura();
                        factura.setNumeroFactura(Long.parseLong(txtNumeroFactura.getText()));
                        factura.setCliente(cboCliente.getSelectedItem().toString());
                        factura.setEmpleado(cboEmpleado.getSelectedItem().toString());
                        factura.setFecha(convertirFormatoTextoFecha(txtFecha.getText()));
                        factura.setProducto(cboProduccion.getSelectedItem().toString());
                        factura.setCantidad(Integer.parseInt(txtCantidad.getText()));
                        factura.setISV(ISV);
                        factura.setSubTotal((Integer.parseInt(txtCantidad.getText())) * Precio);
                        double isv = (Integer.parseInt(txtCantidad.getText()) * Precio) * ISV;
                        factura.setTotalPagar(((Integer.parseInt(txtCantidad.getText())) * Precio) + isv);
                        new FacturaNegocio().Eliminar(factura);
                        leerDatos();
                        llenarComboFactura();
                        llenarComboCliente();
                        llenarComboEmpleado();
                        llenarComboProducto();
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
                DefaultComboBoxModel modeloCliente = new DefaultComboBoxModel();
                DefaultComboBoxModel modeloEmpleado = new DefaultComboBoxModel();
                DefaultComboBoxModel modeloProducto = new DefaultComboBoxModel();

                txtNumeroFactura.setText(modelo.getValueAt(filaSeleccionada, 0).toString());
                modeloCliente.addElement(modelo.getValueAt(filaSeleccionada, 1));
                cboCliente.setModel(modeloCliente);
                modeloEmpleado.addElement(modelo.getValueAt(filaSeleccionada, 2));
                cboEmpleado.setModel(modeloEmpleado);
                txtFecha.setText(modelo.getValueAt(filaSeleccionada, 3).toString());
                modeloProducto.addElement(modelo.getValueAt(filaSeleccionada, 4));
                cboProduccion.setModel(modeloProducto);
                txtCantidad.setText(modelo.getValueAt(filaSeleccionada, 5).toString());
                txtTotalPagar.setText("");
            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboComboFactura.getSelectedItem();
                long itemFactura = ((Item)objeto).getCodigo();
                JOptionPane.showMessageDialog(null, itemFactura);
            }
        });
        btnGenerarFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtCantidad.getText().isEmpty())
                        throw new Exception("Error: La cantidad no debe estar vacia.");
                    if (Integer.parseInt(txtCantidad.getText()) <= 0)
                        throw new Exception("Error: La cantidad no debe ser <= 0");

                    double Subtotal = Integer.parseInt(txtCantidad.getText()) * Precio;
                    String subTotal = String.valueOf(Subtotal);
                    double isv = Subtotal * ISV;
                    double total_pagar = Subtotal + isv;
                    String totalPagar = String.valueOf(total_pagar);
                    if (total_pagar == 0)
                        throw new Exception("Error: Seleccione el Producto.");
                    JOptionPane.showMessageDialog(null, "ISV: 12% \nSubTotal: L " + subTotal + "\nTotal a Pagar: L " + totalPagar, "Factura", JOptionPane.INFORMATION_MESSAGE);
                    txtTotalPagar.setText(totalPagar);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        cboProduccion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Object objeto = cboProduccion.getSelectedItem();
                    double precio = ((Item)objeto).getPrecio();
                    Precio = precio;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void iniciar() {
        try {
            modelo = (DefaultTableModel) tblDatos.getModel();
            modelo.addColumn("Numero de Factura");
            modelo.addColumn("Cliente");
            modelo.addColumn("Empleado");
            modelo.addColumn("Fecha");
            modelo.addColumn("Producto");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Total a Pagar");
            leerDatos();
            llenarComboFactura();
            llenarComboCliente();
            llenarComboEmpleado();
            llenarComboProducto();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void leerDatos() {
        try {
            List<Factura> listaFacturas = new FacturaNegocio().leer();
            modelo.setRowCount(0);
            for (Factura factura: listaFacturas) {
                Object[] registroLeido= {
                        factura.getNumeroFactura(),
                        factura.getCliente(),
                        factura.getEmpleado(),
                        sdf.format(factura.getFecha()),
                        factura.getProducto(),
                        factura.getCantidad(),
                        factura.getTotalPagar()
                };
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarComboFactura() {
        try {
            List<Factura> listaFacturas = new FacturaNegocio().leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Factura factura: listaFacturas) {
                Item item = new Item(factura.getNumeroFactura(), factura.getCliente());
                modeloCombo.addElement(item);
            }
            cboComboFactura.setModel(modeloCombo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarComboCliente() {
        try {
            List<Cliente> listaClientes = new ClienteNegocio().leer();
            DefaultComboBoxModel modeloCliente = new DefaultComboBoxModel();
            for (Cliente cliente: listaClientes) {
                Item item = new Item(cliente.getCodigo(), cliente.getNombre());
                modeloCliente.addElement(item);
            }
            cboCliente.setModel(modeloCliente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarComboEmpleado() {
        try {
            List<Empleado> listaEmpleados = new EmpleadoNegocio().leer();
            DefaultComboBoxModel modeloEmpleado = new DefaultComboBoxModel();
            for (Empleado empleado: listaEmpleados) {
                Item item = new Item(empleado.getCodigo(), empleado.getNombre());
                modeloEmpleado.addElement(item);
            }
            cboEmpleado.setModel(modeloEmpleado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarComboProducto() {
        try {
             List<Produccion> listaProduccion = new ProduccionNegocio().leer();
             DefaultComboBoxModel modeloProduccion = new DefaultComboBoxModel();
             for (Produccion produccion: listaProduccion){
                 Item item = new Item(produccion.getCostoPrenda(), produccion.getTipoPrenda() + " - " + produccion.getDiseñoPrenda());
                 modeloProduccion.addElement(item);
             }
             cboProduccion.setModel(modeloProduccion);
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
        txtNumeroFactura.setText("");
        txtFecha.setText("");
        txtCantidad.setText("");
        txtTotalPagar.setText("");
    }

    public static void main() {
        JFrame frame = new JFrame("Factura");
        frame.setContentPane(new frmFactura().jpaPrincipal);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
