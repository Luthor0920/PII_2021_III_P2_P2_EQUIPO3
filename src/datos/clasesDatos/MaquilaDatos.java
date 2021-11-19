package datos.clasesDatos;

import datos.conexion.Conexion;
import recursos.clases.Maquila;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaquilaDatos {
    //CRUD Create, Read, Update, Delete
    public static String InsertarMaquila(Maquila pMaquila) throws SQLException {
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Maquila VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pMaquila.getCodigo());
            ps.setString(2, pMaquila.getNombre());
            ps.setString(3, pMaquila.getDireccion());
            ps.setDate(4, new java.sql.Date(pMaquila.getFechaInicio().getTime()));
            ps.setLong(5, pMaquila.getTelefono());
            ps.setString(6, pMaquila.getCorreo());
            ps.setInt(7, pMaquila.getCantidadEmpleados());
            ps.execute();
            ps.close();
            cn.close();
        }catch(SQLException e){
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
        return null;
    }
    public static List<Maquila> leerMaquila() throws SQLException{
        List<Maquila> listaMaquila = new ArrayList<>();
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "SELECT Codigo, Nombre, Direccion, FechaInicio, Telefono, Email, CantidadEmpleados " +
                    "FROM Maquila";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Maquila maquila = new Maquila();
                maquila.setCodigo(rs.getLong(1));
                maquila.setNombre(rs.getString(2));
                maquila.setDireccion(rs.getString(3));
                maquila.setFechaInicio(rs.getDate(4));
                maquila.setTelefono(rs.getLong(5));
                maquila.setCorreo(rs.getString(6));
                maquila.setCantidadEmpleados(rs.getInt(7));
                listaMaquila.add(maquila);
            }
            st.close();
            rs.close();
            cn.close();
        }catch (SQLException e){
            //e.printStackTrace();
            throw new SQLException(e.getMessage());
        }
        return listaMaquila;
    }
    public static String ActualizarMaquila(Maquila pMaquila) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Maquila SET Nombre = ?, Direccion = ?, FechaInicio = ?, Telefono = ?, " +
                    "Email = ?, CantidadEmpleados = ? WHERE Codigo = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, pMaquila.getNombre());
            ps.setString(2, pMaquila.getDireccion());
            ps.setDate(3, new java.sql.Date(pMaquila.getFechaInicio().getTime()));
            ps.setLong(4, pMaquila.getTelefono());
            ps.setString(5, pMaquila.getCorreo());
            ps.setInt(6, pMaquila.getCantidadEmpleados());
            ps.setLong(7, pMaquila.getCodigo());
            ps.execute();
            ps.close();
            cn.close();
        }catch (SQLException e){
            //e.printStackTrace();
            //return "Error "+e.getMessage();
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static String EliminarMaquila(Maquila pMaquila) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Maquila WHERE Codigo = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pMaquila.getCodigo());
            ps.execute();
            ps.close();
            cn.close();
        }catch (SQLException e){
            e.printStackTrace();
            return "Error " + e.getMessage();
        }
        return null;
    }
    public static List<Maquila> BuscarMaquila(Maquila pMaquila) throws SQLException {
        List<Maquila> listaMaquila = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "SELECT Codigo, Nombre, Direccion, FechaInicio, Telefono, Email, CantidadEmpleados " +
                    "FROM Maquila WHERE UPPER(Nombre) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + pMaquila.getNombre().toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do{
                    Maquila maquila = new Maquila();
                    maquila.setCodigo(rs.getLong(1));
                    maquila.setNombre(rs.getString(2));
                    maquila.setDireccion(rs.getString(3));
                    maquila.setFechaInicio(rs.getDate(4));
                    maquila.setTelefono(rs.getLong(5));
                    maquila.setCorreo(rs.getString(6));
                    maquila.setCantidadEmpleados(rs.getInt(7));
                    listaMaquila.add(maquila);
                }while(rs.next());
            }else{
                throw new SQLException("Error: no se encontró coincidencia");
            }
            rs.close();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaMaquila;
    }
}
