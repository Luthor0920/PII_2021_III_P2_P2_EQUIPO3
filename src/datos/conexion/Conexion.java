package datos.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String USUARIO = "sa";
    private static final String CLAVE = "Ujcv.2021";
    public static Connection obtenerConexion() {
        try {
            String URL = "jdbc:sqlserver://192.168.106.214:1433;dataBaseName=PII_2021_III_P2_P2_EQUIPO3;";
            Connection cn = DriverManager.getConnection(URL, USUARIO, CLAVE);
            return cn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
