package gui.clasesGui;

import jdk.nashorn.internal.scripts.JO;
import negocio.clases.ProduccionNegocio;
import recursos.clases.Item;
import recursos.clases.Produccion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class frmProduccion {
    private JPanel jpaPrincipal;
    private JTextField txtCodigoPrenda;
    private JTextField txtCodigoLote;
    private JTextField txtCantidad;
    private JRadioButton rbtEstampado;
    private JRadioButton rbtLiso;
    private JRadioButton rbtCamisa;
    private JRadioButton rbtPantalon;
    private JTextField txtTalla;
    private JTextField txtPrecio;
    private JComboBox cboComboProduccion;
    private JTable tblDatos;
    private JPanel jpaTitulo;
    private JLabel lblTitulo;
    private JPanel jpaContenido;
    private JLabel lblCodigoPrenda;
    private JLabel lblCodigoLote;
    private JLabel lblCantidad;
    private JLabel lblDiseñoPrenda;
    private JLabel lblTipoPrenda;
    private JLabel lblTalla;
    private JLabel lblPrecio;
    private JLabel lblProduccion;
    private JPanel jpaDatos;
    private JScrollPane sclPanDatos;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JButton btnLeerCombo;
    private JPanel jpaBotones;
    DefaultTableModel modelo;


    public frmProduccion() {
        iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Produccion produccion = new Produccion();
                    produccion.setCodigoPrenda(Long.parseLong(txtCodigoPrenda.getText()));
                    produccion.setCodigoLote(Long.parseLong(txtCodigoLote.getText()));
                    produccion.setCantidadPrenda(Integer.parseInt(txtCantidad.getText()));
                    String diseño="";
                    double precio=0;
                    if (rbtEstampado.isSelected()) {
                        diseño = rbtEstampado.getText();
                        precio += 120;
                    } else if (rbtLiso.isSelected()) {
                        diseño = rbtLiso.getText();
                        precio += 100;
                    }
                    produccion.setDiseñoPrenda(diseño);
                    String tipo="";
                    if (rbtCamisa.isSelected()) {
                        tipo = rbtCamisa.getText();
                        precio += 120;
                    } else if (rbtPantalon.isSelected()) {
                        tipo = rbtPantalon.getText();
                        precio += 145;
                    }
                    txtPrecio.setText(String.valueOf(precio));
                    produccion.setTipoPrenda(tipo);
                    produccion.setTallaPrenda(txtTalla.getText());
                    produccion.setCostoPrenda(Double.parseDouble(txtPrecio.getText()));
                    String respuesta = new ProduccionNegocio().InsertarProduccion(produccion);
                    if (!respuesta.contains("Error")) {
                        JOptionPane.showMessageDialog(null, "Guardado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarComboProduccion();
                        limpiar();
                    }
                    else
                        throw new Exception(respuesta);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Produccion produccion = new Produccion();
                    produccion.setCodigoPrenda(Long.parseLong(txtCodigoPrenda.getText()));
                    produccion.setCodigoLote(Long.parseLong(txtCodigoLote.getText()));
                    produccion.setCantidadPrenda(Integer.parseInt(txtCantidad.getText()));
                    String diseño="";
                    double precio=0;
                    if (rbtEstampado.isSelected()) {
                        diseño = rbtEstampado.getText();
                        precio += 120;
                    } else if (rbtLiso.isSelected()) {
                        diseño = rbtLiso.getText();
                        precio += 100;
                    }
                    produccion.setDiseñoPrenda(diseño);
                    String tipo="";
                    if (rbtCamisa.isSelected()) {
                        tipo = rbtCamisa.getText();
                        precio += 120;
                    } else if (rbtPantalon.isSelected()) {
                        tipo = rbtPantalon.getText();
                        precio += 145;
                    }
                    txtPrecio.setText(String.valueOf(precio));
                    produccion.setTipoPrenda(tipo);
                    produccion.setTallaPrenda(txtTalla.getText());
                    produccion.setCostoPrenda(Double.parseDouble(txtPrecio.getText()));
                    new ProduccionNegocio().Actualizar(produccion);
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
                    Produccion produccionBuscar = new Produccion();
                    produccionBuscar.setCodigoPrenda(Long.parseLong(txtCodigoPrenda.getText()));
                    List<Produccion> listaProduccion = new ProduccionNegocio().Buscar(produccionBuscar);
                    modelo.setRowCount(0);
                    for (Produccion produccion: listaProduccion) {
                        Object[] registroLeido= {
                                produccion.getCodigoPrenda(),
                                produccion.getCodigoLote(),
                                produccion.getCantidadPrenda(),
                                produccion.getDiseñoPrenda(),
                                produccion.getTipoPrenda(),
                                produccion.getTallaPrenda(),
                                produccion.getCostoPrenda()
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
                        Produccion produccion = new Produccion();
                        produccion.setCodigoPrenda(Long.parseLong(txtCodigoPrenda.getText()));
                        produccion.setCodigoLote(Long.parseLong(txtCodigoLote.getText()));
                        produccion.setCantidadPrenda(Integer.parseInt(txtCantidad.getText()));
                        String diseño="";
                        double precio=0;
                        if (rbtEstampado.isSelected()) {
                            diseño = rbtEstampado.getText();
                            precio += 120;
                        } else if (rbtLiso.isSelected()) {
                            diseño = rbtLiso.getText();
                            precio += 100;
                        }
                        produccion.setDiseñoPrenda(diseño);
                        String tipo="";
                        if (rbtCamisa.isSelected()) {
                            tipo = rbtCamisa.getText();
                            precio += 120;
                        } else if (rbtPantalon.isSelected()) {
                            tipo = rbtPantalon.getText();
                            precio += 145;
                        }
                        txtPrecio.setText(String.valueOf(precio));
                        produccion.setTipoPrenda(tipo);
                        produccion.setTallaPrenda(txtTalla.getText());
                        produccion.setCostoPrenda(Double.parseDouble(txtPrecio.getText()));
                        new ProduccionNegocio().Eliminar(produccion);
                        leerDatos();
                        llenarComboProduccion();
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
                txtCodigoPrenda.setText(modelo.getValueAt(filaSeleccionada, 0).toString());
                txtCodigoLote.setText(modelo.getValueAt(filaSeleccionada, 1).toString());
                txtCantidad.setText(modelo.getValueAt(filaSeleccionada, 2).toString());
                txtTalla.setText(modelo.getValueAt(filaSeleccionada, 5).toString());
                txtPrecio.setText(modelo.getValueAt(filaSeleccionada, 6).toString());
            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboComboProduccion.getSelectedItem();
                long itemProduccion = ((Item)objeto).getCodigo();
                JOptionPane.showMessageDialog(null, itemProduccion);
            }
        });
        txtPrecio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                JOptionPane.showMessageDialog(null, "Seleccione el tipo de Prenda.");
                e.consume();
            }
        });

    }

    private void iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Codigo de Prenda");
        modelo.addColumn("Codigo de Lote");
        modelo.addColumn("Cantidad de Prenda");
        modelo.addColumn("Diseño de Prenda");
        modelo.addColumn("Tipo de Prenda");
        modelo.addColumn("Talla de Prenda");
        modelo.addColumn("Precio");
        leerDatos();
        llenarComboProduccion();
    }

    private void leerDatos() {
        try {
            List<Produccion> listaProduccion = new ProduccionNegocio().leer();
            modelo.setRowCount(0);
            for (Produccion produccion: listaProduccion) {
                Object[] registroLeido= {
                        produccion.getCodigoPrenda(),
                        produccion.getCodigoLote(),
                        produccion.getCantidadPrenda(),
                        produccion.getDiseñoPrenda(),
                        produccion.getTipoPrenda(),
                        produccion.getTallaPrenda(),
                        produccion.getCostoPrenda()
                };
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarComboProduccion() {
        try {
            List<Produccion> listaProduccion = new ProduccionNegocio().leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Produccion produccion: listaProduccion) {
                Item item = new Item(produccion.getCodigoPrenda(), produccion.getTipoPrenda() + " - " + produccion.getDiseñoPrenda());
                modeloCombo.addElement(item);
            }
            cboComboProduccion.setModel(modeloCombo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiar() {
        txtCodigoPrenda.setText("");
        txtCodigoLote.setText("");
        txtCantidad.setText("");
        txtTalla.setText("");
        txtPrecio.setText("");
    }

    public static void main() {
        JFrame frame = new JFrame("Produccion");
        frame.setContentPane(new frmProduccion().jpaPrincipal);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
