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
            String sql = "INSERT INTO Empleado VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pEmpleado.getCodigo());
            ps.setLong(2, pEmpleado.getDNI());
            ps.setString(3, pEmpleado.getNombre());
            ps.setString(4, pEmpleado.getPuesto());
            ps.setDouble(5, pEmpleado.getSueldo());
            ps.setDate(6, new java.sql.Date(pEmpleado.getFechaIngreso().getTime()));
            ps.setString(7, pEmpleado.getNivelAcademico());
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
            String sql = "SELECT Codigo, DNI, Nombre, Puesto, Sueldo, FechaIngreso, NivelAcademico FROM Empleado";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Empleado empleado = new Empleado();
                empleado.setCodigo(rs.getLong(1));
                empleado.setDNI(rs.getLong(2));
                empleado.setNombre(rs.getString(3));
                empleado.setPuesto(rs.getString(4));
                empleado.setSueldo(rs.getDouble(5));
                empleado.setFechaIngreso(rs.getDate(6));
                empleado.setNivelAcademico(rs.getString(7));
                listaEmpleado.add(empleado);
            }
            rs.close();
            st.close();
            cn.close();
        }catch (Exception e){
            //e.printStackTrace();
            throw new SQLException(e.getMessage());
        }
        return listaEmpleado;
    }
    public static String ActualizarEmpleado(Empleado pEmpleado) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Empleado SET DNI = ?, Nombre = ?, Puesto = ?, Sueldo = ?, FechaIngreso = ?, " +
                    "NivelAcademico = ? WHERE Codigo = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pEmpleado.getDNI());
            ps.setString(2, pEmpleado.getNombre());
            ps.setString(3, pEmpleado.getPuesto());
            ps.setDouble(4, pEmpleado.getSueldo());
            ps.setDate(5, new java.sql.Date(pEmpleado.getFechaIngreso().getTime()));
            ps.setString(6, pEmpleado.getNivelAcademico());
            ps.setLong(7, pEmpleado.getCodigo());
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
    public static List<Empleado> BuscarEmpleado(Empleado pEmpleado) throws SQLException{
        List<Empleado> listaEmpleado = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "SELECT Codigo, DNI, Nombre, Puesto, Sueldo, FechaIngreso, NivelAcademico FROM Empleado WHERE " +
                    "UPPER(Nombre) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + pEmpleado.getNombre().toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    Empleado empleado = new Empleado();
                    empleado.setCodigo(rs.getLong(1));
                    empleado.setDNI(rs.getLong(2));
                    empleado.setNombre(rs.getString(3));
                    empleado.setPuesto(rs.getString(4));
                    empleado.setSueldo(rs.getDouble(5));
                    empleado.setFechaIngreso(rs.getDate(6));
                    empleado.setNivelAcademico(rs.getString(7));
                    listaEmpleado.add(empleado);
                }while(rs.next());
            }
            else
                throw new SQLException("Error: No se encontro coincidencia.");

            rs.close();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaEmpleado;
    }
}
