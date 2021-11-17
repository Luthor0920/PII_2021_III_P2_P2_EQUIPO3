package datos.clasesDatos;

import datos.conexion.Conexion;
import recursos.clases.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDatos {
    //CRUD Create, Read, Update, Delete
    public static String InsertarCliente(Cliente pCliente) throws SQLException {
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Cliente VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pCliente.getCodigo());
            ps.setString(2, pCliente.getTipoCliente());
            ps.setString(3, pCliente.getOcupacion());
            ps.setString(4, pCliente.getRecurrencia());
            ps.setString(5, pCliente.getTallaCamisa());
            ps.setInt(6, pCliente.getTallaPantalon());
            ps.setString(7, pCliente.getReferencia());
            ps.execute();
            ps.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }
    public static List<Cliente> leerCliente(Cliente pCliente) throws SQLException{
        List<Cliente> listaCliente = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Codigo, TipoCliente, Ocupacion, Recurrencia, TallaCamisa, " +
                    "TallaPantalon, Referencia FROM Cliente";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getLong(1));
                cliente.setTipoCliente(rs.getString(2));
                cliente.setOcupacion(rs.getString(3));
                cliente.setRecurrencia(rs.getString(4));
                cliente.setTallaCamisa(rs.getString(5));
                cliente.setTallaPantalon(rs.getInt(6));
                cliente.setReferencia(rs.getString(7));
                listaCliente.add(cliente);
            }
            rs.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaCliente;
    }
    public static String ActualizarCliente(Cliente pCliente) throws SQLException {
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Cliente SET TipoCliente= ?, Ocupacion = ?, Recurrencia = ?, TallaCamisa = ?" +
                    "TallaPantalon = ?, Referencia = ? WHERE Codigo = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, pCliente.getTipoCliente());
            ps.setString(2, pCliente.getOcupacion());
            ps.setString(3, pCliente.getRecurrencia());
            ps.setString(4, pCliente.getTallaCamisa());
            ps.setInt(5, pCliente.getTallaPantalon());
            ps.setString(6, pCliente.getReferencia());
            ps.setLong(7, pCliente.getCodigo());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }
    public static String EliminarCliente(Cliente pCliente){
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Cliente WHERE Codigo = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pCliente.getCodigo());
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
