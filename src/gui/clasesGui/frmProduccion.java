package gui.clasesGui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;

public class frmProduccion {
    private JPanel jpaPrincipal;
    private JPanel jpaTitulo;
    private JLabel lblTitulo;
    private JPanel jpaContenido;
    private JTextField textField1;
    private JPanel jpaBotones;
    private JTable tblDatos;
    private JScrollPane sclPanDatos;
    private JPanel jpaDatos;
    private JButton btnRegistrar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnListar;
    private JButton btnLeerCombo;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel modelo;
}
