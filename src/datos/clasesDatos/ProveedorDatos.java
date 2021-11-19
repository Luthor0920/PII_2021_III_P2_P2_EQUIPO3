package datos.clasesDatos;

import datos.conexion.Conexion;
import recursos.clases.Proveedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDatos {
    //CRUD Create, Read, Update, Delete
    public static String IngresarProveedor(Proveedor pProveedor){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Proveedor VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pProveedor.getCodigo());
            ps.setString(2, pProveedor.getNombre());
            ps.setString(3, pProveedor.getDireccion());
            ps.setLong(4, pProveedor.getTelefono());
            ps.setDate(5, new java.sql.Date(pProveedor.getFechaInicio().getTime()));
            ps.setString(6, pProveedor.getCorreo());
            ps.setString(7, pProveedor.getTipoProveedor());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }
    public static List<Proveedor> leerProveedor() throws SQLException{
        List<Proveedor> listaProveedor = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "SELECT CodigoProveedor, NombreProveedor, Direccion, Telefono, FechaInicio, Email, " +
                    "TipoProveedor FROM Proveedor";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Proveedor proveedor = new Proveedor();
                proveedor.setCodigo(rs.getLong(1));
                proveedor.setNombre(rs.getString(2));
                proveedor.setDireccion(rs.getString(3));
                proveedor.setTelefono(rs.getLong(4));
                proveedor.setFechaInicio(rs.getDate(5));
                proveedor.setCorreo(rs.getString(6));
                proveedor.setTipoProveedor(rs.getString(7));
                listaProveedor.add(proveedor);
            }
            rs.close();
            st.close();
            cn.close();
        }catch (Exception e){
            //e.printStackTrace();
            throw new SQLException(e.getMessage());
        }
        return listaProveedor;
    }
    public static String ActualizarProveedor(Proveedor pProveedor) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Proveedor SET NombreProveedor = ?, Direccion = ?, Telefono = ?, FechaInicio = ?" +
                    ", Email = ?, TipoProveedor = ? WHERE CodigoProveedor = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, pProveedor.getNombre());
            ps.setString(2, pProveedor.getDireccion());
            ps.setLong(3, pProveedor.getTelefono());
            ps.setDate(4, new java.sql.Date(pProveedor.getFechaInicio().getTime()));
            ps.setString(5, pProveedor.getCorreo());
            ps.setString(6, pProveedor.getTipoProveedor());
            ps.setLong(7, pProveedor.getCodigo());
            ps.execute();
            ps.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }
    public static String EliminarProveedor(Proveedor pProveedor) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Proveedor WHERE CodigoProveedor = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pProveedor.getCodigo());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }

    public static List<Proveedor> BuscarProveedor(Proveedor pProveedor) throws SQLException {
        List<Proveedor> listaProveedores = new ArrayList<>();
        try {
            Connection cn = Conexion.obtenerConexion();
            String sql = "SELECT CodigoProveedor, NombreProveedor, Direccion, Telefono, FechaInicio, Email, " +
                    "TipoProveedor FROM Proveedor WHERE UPPER(NombreProveedor) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%" + pProveedor.getNombre().toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                do {
                    Proveedor proveedor = new Proveedor();
                    proveedor.setCodigo(rs.getLong(1));
                    proveedor.setNombre(rs.getString(2));
                    proveedor.setDireccion(rs.getString(3));
                    proveedor.setTelefono(rs.getLong(4));
                    proveedor.setFechaInicio(rs.getDate(5));
                    proveedor.setCorreo(rs.getString(6));
                    proveedor.setTipoProveedor(rs.getString(7));
                    listaProveedores.add(proveedor);
                } while (rs.next());
            }
            else {
                throw new SQLException("Error: No se encontro coincidencia.");
            }
            cn.close();
            rs.close();
            ps.close();

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return listaProveedores;
    }
}
