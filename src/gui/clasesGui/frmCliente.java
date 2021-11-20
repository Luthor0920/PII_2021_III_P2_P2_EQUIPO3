package gui.clasesGui;

import negocio.clases.ClienteNegocio;
import negocio.clases.PersonaNegocio;
import recursos.clases.Cliente;
import recursos.clases.Item;
import recursos.clases.Persona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class frmCliente {
    private JPanel jpaPrincipal;
    private JPanel jpaTitulo;
    private JLabel lblTitulo;
    private JPanel jpaContenido;
    private JTextField txtCodigo;
    private JTextField txtDNI;
    private JTextField txtOcupacion;
    private JTextField txtRecurrencia;
    private JTextField txtTallaCamisa;
    private JTextField txtTallaPantalon;
    private JTextField txtReferencia;
    private JComboBox cboNombre;
    private JComboBox cboTipoCliente;
    private JComboBox cboComboCliente;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JButton btnLeerCombo;
    private JTable tblDatos;
    private JPanel jpaDatos;
    private JScrollPane sclPanDatos;
    private JPanel jpaBotones;
    private JLabel lblCodigo;
    private JLabel lblNombre;
    private JLabel lblDNI;
    private JLabel lblTipoCliente;
    private JLabel lblOcupacion;
    private JLabel lblRecurrencia;
    private JLabel lblTallaCamisa;
    private JLabel lblTallaPantalon;
    private JLabel lblReferencia;
    private JLabel lblCliente;
    private JTextField txtTipoCliente;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modelo;

    public frmCliente() {
        iniciar();
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cliente cliente = new Cliente();
                    cliente.setCodigo(Long.parseLong(txtCodigo.getText()));
                    cliente.setDNI(Long.parseLong(txtDNI.getText()));
                    cliente.setNombre(cboNombre.getSelectedItem().toString());
                    cliente.setTipoCliente(txtTipoCliente.getText());
                    cliente.setOcupacion(txtOcupacion.getText());
                    cliente.setRecurrencia(txtRecurrencia.getText());
                    cliente.setTallaCamisa(txtTallaCamisa.getText());
                    cliente.setTallaPantalon(Integer.parseInt(txtTallaPantalon.getText()));
                    cliente.setReferencia(txtReferencia.getText());
                    String respuesta = new ClienteNegocio().insertar(cliente);
                    if (!respuesta.contains("Error")) {
                        JOptionPane.showMessageDialog(null, "Guardado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        leerDatos();
                        llenarComboClientes();
                    }
                    else
                        throw new Exception(respuesta);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Errpr", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cliente cliente = new Cliente();
                    cliente.setCodigo(Long.parseLong(txtCodigo.getText()));
                    cliente.setDNI(Long.parseLong(txtDNI.getText()));
                    cliente.setNombre(cboNombre.getSelectedItem().toString());
                    cliente.setTipoCliente(txtTipoCliente.getText());
                    cliente.setOcupacion(txtOcupacion.getText());
                    cliente.setRecurrencia(txtRecurrencia.getText());
                    cliente.setTallaCamisa(txtTallaCamisa.getText());
                    cliente.setTallaPantalon(Integer.parseInt(txtTallaPantalon.getText()));
                    cliente.setReferencia(txtReferencia.getText());
                    new ClienteNegocio().actualizar(cliente);
                    leerDatos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Errpr", JOptionPane.ERROR_MESSAGE);
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
                    Cliente clienteBuscar = new Cliente();
                    clienteBuscar.setNombre(txtDNI.getText());
                    List<Cliente> listaClientes = new ClienteNegocio().buscar(clienteBuscar);
                    modelo.setRowCount(0);
                    for (Cliente cliente: listaClientes) {
                        Object[] registroLeido= {
                                cliente.getCodigo(),
                                cliente.getDNI(),
                                cliente.getNombre(),
                                cliente.getTipoCliente(),
                                cliente.getOcupacion(),
                                cliente.getRecurrencia(),
                                cliente.getTallaCamisa(),
                                cliente.getTallaPantalon(),
                                cliente.getReferencia()
                        };
                        modelo.addRow(registroLeido);
                    }
                    tblDatos.setModel(modelo);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Errpr", JOptionPane.ERROR_MESSAGE);
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
                        Cliente cliente = new Cliente();
                        cliente.setCodigo(Long.parseLong(txtCodigo.getText()));
                        cliente.setDNI(Long.parseLong(txtDNI.getText()));
                        cliente.setNombre(cboNombre.getSelectedItem().toString());
                        cliente.setTipoCliente(txtTipoCliente.getText());
                        cliente.setOcupacion(txtOcupacion.getText());
                        cliente.setRecurrencia(txtRecurrencia.getText());
                        cliente.setTallaCamisa(txtTallaCamisa.getText());
                        cliente.setTallaPantalon(Integer.parseInt(txtTallaPantalon.getText()));
                        cliente.setReferencia(txtReferencia.getText());
                        new ClienteNegocio().eliminar(cliente);
                        leerDatos();
                        llenarComboClientes();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Errpr", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tblDatos.getSelectedRow();
                DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();

                txtCodigo.setText(modelo.getValueAt(filaSeleccionada, 0).toString());
                txtDNI.setText(modelo.getValueAt(filaSeleccionada, 1).toString());
                modeloCombo.addElement(modelo.getValueAt(filaSeleccionada, 2));
                cboNombre.setModel(modeloCombo);
                txtTipoCliente.setText(modelo.getValueAt(filaSeleccionada, 3).toString());
                txtOcupacion.setText(modelo.getValueAt(filaSeleccionada, 4).toString());
                txtRecurrencia.setText(modelo.getValueAt(filaSeleccionada,5).toString());
                txtTallaCamisa.setText(modelo.getValueAt(filaSeleccionada, 6).toString());
                txtTallaPantalon.setText(modelo.getValueAt(filaSeleccionada, 7).toString());
                txtReferencia.setText(modelo.getValueAt(filaSeleccionada, 8).toString());
            }
        });
        btnLeerCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object objeto = cboComboCliente.getSelectedItem();
                long itemCliente = ((Item)objeto).getCodigo();
                JOptionPane.showMessageDialog(null, itemCliente);
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
        modelo = (DefaultTableModel) tblDatos.getModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo de Cliente");
        modelo.addColumn("Ocupacion");
        modelo.addColumn("Recurrencia");
        modelo.addColumn("Talla de Camisa");
        modelo.addColumn("Talla de Pantalon");
        modelo.addColumn("Referencia");
        leerDatos();
        llenarComboClientes();
        llenarComboDNI();
    }

    private void leerDatos() {
        try {
            List<Cliente> listaClientes = new ClienteNegocio().leer();
            modelo.setRowCount(0);
            for (Cliente cliente: listaClientes) {
                Object[] registroLeido= {
                        cliente.getCodigo(),
                        cliente.getDNI(),
                        cliente.getNombre(),
                        cliente.getTipoCliente(),
                        cliente.getOcupacion(),
                        cliente.getRecurrencia(),
                        cliente.getTallaCamisa(),
                        cliente.getTallaPantalon(),
                        cliente.getReferencia()
                };
                modelo.addRow(registroLeido);
            }
            tblDatos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Errpr", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarComboClientes() {
        try {
            List<Cliente> listaClientes = new ClienteNegocio().leer();
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (Cliente cliente: listaClientes) {
                Item item = new Item(cliente.getCodigo(), cliente.getNombre());
                modeloCombo.addElement(item);
            }
            cboComboCliente.setModel(modeloCombo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void llenarComboDNI() {
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Clientes");
        frame.setContentPane(new frmCliente().jpaPrincipal);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
