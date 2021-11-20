package gui.clasesGui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

public class frmFactura {
    private JPanel jpaPrincipal;
    private JPanel jpaContenido;
    private JTextField textField1;
    private JComboBox cboComboFactura;
    private JTextField textField2;
    private JLabel lblFactura;
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
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modelo;

}
