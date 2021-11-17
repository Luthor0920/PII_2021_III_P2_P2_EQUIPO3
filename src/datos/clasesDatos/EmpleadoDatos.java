package datos.clasesDatos;

import datos.conexion.Conexion;
import recursos.clases.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDatos {
    //CRUD Create, Read, Update, Delete
    public static String IngresarEmpleado(Empleado pEmpleado) throws SQLException {
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Empleado VALUES (?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pEmpleado.getCodigo());
            ps.setString(2, pEmpleado.getPuesto());
            ps.setDouble(3, pEmpleado.getSueldo());
            ps.setDate(4, new java.sql.Date(pEmpleado.getFechaIngreso().getTime()));
            ps.setString(5, pEmpleado.getNivelAcademico());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }
    public static List<Empleado> leerEmpleado() throws  SQLException{
        List<Empleado> listaEmpleado = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Codigo, Puesto, Sueldo, FechaIngreso, NivelAcademico FROM Empleado";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Empleado empleado = new Empleado();
                empleado.setCodigo(rs.getLong(1));
                empleado.setPuesto(rs.getString(2));
                empleado.setSueldo(rs.getDouble(3));
                empleado.setFechaIngreso(rs.getDate(4));
                empleado.setNivelAcademico(rs.getString(5));
                listaEmpleado.add(empleado);
            }
            rs.close();
            st.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaEmpleado;
    }
    public static String ActualizarEmpleado(Empleado pEmpleado) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Empleado SET Puesto = ?, Sueldo = ?, FechaIngreso = ?, NivelAcademico = ?" +
                    "WHERE Codigo = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, pEmpleado.getPuesto());
            ps.setDouble(2, pEmpleado.getSueldo());
            ps.setDate(3, new java.sql.Date(pEmpleado.getFechaIngreso().getTime()));
            ps.setString(4, pEmpleado.getNivelAcademico());
            ps.setLong(5, pEmpleado.getCodigo());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }
    public static String EliminarEmpleado(Empleado pEmpleado) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Empleado WHERE Codigo = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pEmpleado.getCodigo());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }
}
