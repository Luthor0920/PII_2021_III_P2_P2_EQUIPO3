package gui.clasesGui;

import negocio.clases.PersonaNegocio;
import negocio.clases.PuestoNegocio;
import recursos.clases.Item;
import recursos.clases.Puesto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class frmPuesto {
    private JPanel jpaPrincipal;
    private JLabel lblTitulo;
    private JTextField txtCodigo;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JButton btnLeerCombo;
    private JTable tblDatos;
    private JScrollPane sclPanDatos;
    private JPanel jpaDatos;
    private JPanel jpaBotones;
    private JPanel jpaContenido;
    private JPanel jpaTitulo;
    private JTextField txtNombre;
    private JTextField txtEstaciones;
    private JTextField txtEstudioMinimo;
    private JTextField txtCantEmpleados;
    private JRadioButton rbtSi;
    private JRadioButton rbtNo;
    private JComboBox cboPuesto;
    private JLabel lblCodigo;
    private JLabel lblNombre;
    private JLabel lblEstaciones;
    private JLabel lblEstudioMinimo;
    private JLabel lblCantEmpleados;
    private JLabel lblUniforme;
    private JLabel lblPuesto;
    private JTextField txtFechaInicio;
    private JLabel lblFechaInicio;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modelo;

    public frmPuesto() {
        iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Puesto puesto = new Puesto();
                    puesto.setCodigo(Long.parseLong(txtCodigo.getText()));
                    puesto.setNombre(txtNombre.getText());
                    puesto.setNumeroEstaciones(Integer.parseInt(txtEstaciones.getText()));
                    puesto.setEstudioMinimo(txtEstudioMinimo.getText());
                    puesto.setCantidadEmpleados(Integer.parseInt(txtCantEmpleados.getText()));
                    puesto.setFechaInicio(convertirFormatoTextoFecha(txtFechaInicio.getText()));
                    String uniforme="";
                    if (rbtSi.isSelected())
                        uniforme = "SI";
                    else if (rbtNo.isSelected())
                        uniforme = "NO";
                    puesto.setUniforme(uniforme);
                    String respuesta = new PuestoNegocio().InsertarPuesto(puesto);
                    if (!respuesta.contains("Error")) {
                        JOptionPane.showMessageDialog(null, "Guardado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarComboPuesto();
                        limpiar();
                    }
                    else {
                        throw new Exception(respuesta);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Puesto puesto = new Puesto();
                    puesto.setCodigo(Long.parseLong(txtCodigo.getText()));
                    puesto.setNombre(txtNombre.getText());
                    puesto.setNumeroEstaciones(Integer.parseInt(txtEstaciones.getText()));
                    puesto.setEstudioMinimo(txtEstudioMinimo.getText());
                    puesto.setCantidadEmpleados(Integer.parseInt(txtCantEmpleados.getText()));
                    puesto.setFechaInicio(convertirFormatoTextoFecha(txtFechaInicio.getText()));
                    String uniforme="";
                    if (rbtSi.isSelected())
                        uniforme = "SI";
                    else if (rbtNo.isSelected())
                        uniforme = "NO";
                    puesto.setUniforme(uniforme);
                    new PuestoNegocio().Actualizar(puesto);
                    leerDatos();
                    limpiar();
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
                    Puesto puestoBuscar = new Puesto();
                    puestoBuscar.setNombre(txtNombre.getText());
                    List<Puesto> listaPuestos = new PuestoNegocio().Buscar(puestoBuscar);
                    modelo.setRowCount(0);
                    for (Puesto puesto: listaPuestos) {
                        Object[] registroLeido= {
                                puesto.getCodigo(),
                                puesto.getNombre(),
                                puesto.getNumeroEstaciones(),
                                puesto.getEstudioMinimo(),
                                puesto.getCantidadEmpleados(),
                                sdf.format(puesto.getFechaInicio()),
                                puesto.getUniforme()
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
                        Puesto puesto = new Puesto();
                        puesto.setCodigo(Long.parseLong(txtCodigo.getText()));
                        puesto.setNombre(txtNombre.getText());
                        puesto.setNumeroEstaciones(Integer.parseInt(txtEstaciones.getText()));
                        puesto.setEstudioMinimo(txtEstudioMinimo.getText());
                        puesto.setCantidadEmpleados(Integer.parseInt(txtCantEmpleados.getText()));
                        puesto.setFechaInicio(convertirFormatoTextoFecha(txtFechaInicio.getText()));
                        String uniforme="";
                        if (rbtSi.isSelected())
                            uniforme = "SI";
                        else if (rbtNo.isSelected())
                            uniforme = "NO";
                        puesto.setUniforme(uniforme);
                        new PuestoNegocio().Eliminar(puesto);
                        leerDatos();
                        llenarComboPuesto();
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
                txtCodigo.setText(modelo.getValueAt(filaSeleccionada, 0).toString());
                txtNombre.setText(modelo.getValueAt(filaSeleccionada, 1).toString());
                txtEstaciones.setText(modelo.getValueAt(filaSeleccionada, 2).toString());
                txtEstudioMinimo.setText(modelo.getValueAt(filaSeleccionada, 3).toString());
                txtCantEmpleados.setText(modelo.getValueAt(filaSeleccionada, 4).toString());
                txtFechaInicio.setText(modelo.getValueAt(filaSeleccionada, 5).toString());
            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboPuesto.getSelectedItem();
                long itemPuesto = ((Item)objeto).getCodigo();
                JOptionPane.showMessageDialog(null, itemPuesto);
            }
        });
    }

    private void iniciar() {
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Numero de Estaciones");
        modelo.addColumn("Estudio Minimo");
        modelo.addColumn("Cantidad de Empleados");
        modelo.addColumn("Fecha de Inicio");
        modelo.addColumn("Uso de Uniforme");
        leerDatos();
        llenarComboPuesto();
    }

    private void leerDatos() {
        try {
            List<Puesto> listaPuestos = new PuestoNegocio().leer();
            modelo.setRowCount(0);
            for (Puesto puesto: listaPuestos) {
                Object[] registroLeido= {
                        puesto.getCodigo(),
                        puesto.getNombre(),
                        puesto.getNumeroEstaciones(),
                        puesto.getEstudioMinimo(),
                        puesto.getCantidadEmpleados(),
                        sdf.format(puesto.getFechaInicio()),
                        puesto.getUniforme()
                };
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarComboPuesto() {
        try {
            List<Puesto> listaPuestos = new PuestoNegocio().leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Puesto puesto: listaPuestos) {
                Item item = new Item(puesto.getCodigo(), puesto.getNombre());
                modeloCombo.addElement(item);
            }
            cboPuesto.setModel(modeloCombo);
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
        txtCodigo.setText("");
        txtNombre.setText("");
        txtEstaciones.setText("");
        txtEstudioMinimo.setText("");
        txtCantEmpleados.setText("");
        txtFechaInicio.setText("");
    }

    public static void main() {
        JFrame frame = new JFrame("Puesto");
        frame.setContentPane(new frmPuesto().jpaPrincipal);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
