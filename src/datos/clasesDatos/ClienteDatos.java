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
            String sql = "INSERT INTO Cliente VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pCliente.getCodigo());
            ps.setLong(2, pCliente.getDNI());
            ps.setString(3, pCliente.getNombre());
            ps.setString(4, pCliente.getTipoCliente());
            ps.setString(5, pCliente.getOcupacion());
            ps.setString(6, pCliente.getRecurrencia());
            ps.setString(7, pCliente.getTallaCamisa());
            ps.setInt(8, pCliente.getTallaPantalon());
            ps.setString(9, pCliente.getReferencia());
            ps.execute();
            ps.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }
    public static List<Cliente> leerCliente() throws SQLException{
        List<Cliente> listaCliente = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Codigo, DNI, Nombre, TipoCliente, Ocupacion, Recurrencia, TallaCamisa, " +
                    "TallaPantalon, Referencia FROM Cliente";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getLong(1));
                cliente.setDNI(rs.getLong(2));
                cliente.setNombre(rs.getString(3));
                cliente.setTipoCliente(rs.getString(4));
                cliente.setOcupacion(rs.getString(5));
                cliente.setRecurrencia(rs.getString(6));
                cliente.setTallaCamisa(rs.getString(7));
                cliente.setTallaPantalon(rs.getInt(8));
                cliente.setReferencia(rs.getString(9));
                listaCliente.add(cliente);
            }
            rs.close();
            cn.close();
        }catch(Exception e){
            //e.printStackTrace();
            throw new SQLException(e.getMessage());
        }
        return listaCliente;
    }
    public static String ActualizarCliente(Cliente pCliente) throws SQLException {
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Cliente SET DNI = ?, Nombre = ?, TipoCliente= ?, Ocupacion = ?, Recurrencia = ?, TallaCamisa = ?, " +
                    "TallaPantalon = ?, Referencia = ? WHERE Codigo = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pCliente.getDNI());
            ps.setString(2, pCliente.getNombre());
            ps.setString(3, pCliente.getTipoCliente());
            ps.setString(4, pCliente.getOcupacion());
            ps.setString(5, pCliente.getRecurrencia());
            ps.setString(6, pCliente.getTallaCamisa());
            ps.setInt(7, pCliente.getTallaPantalon());
            ps.setString(8, pCliente.getReferencia());
            ps.setLong(9, pCliente.getCodigo());
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
    public static List<Cliente> BuscarCliente(Cliente pCliente) throws SQLException{
        List<Cliente> listaCliente = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "SELECT Codigo, DNI, Nombre, TipoCliente, Ocupacion, Recurrencia, TallaCamisa, " +
                    "TallaPantalon, Referencia FROM Cliente WHERE UPPER(Nombre) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1,"%"+pCliente.getNombre().toUpperCase()+"%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    Cliente cliente = new Cliente();
                    cliente.setCodigo(rs.getLong(1));
                    cliente.setDNI(rs.getLong(2));
                    cliente.setNombre(rs.getString(3));
                    cliente.setTipoCliente(rs.getString(4));
                    cliente.setOcupacion(rs.getString(5));
                    cliente.setRecurrencia(rs.getString(6));
                    cliente.setTallaCamisa(rs.getString(7));
                    cliente.setTallaPantalon(rs.getInt(8));
                    cliente.setReferencia(rs.getString(9));
                    listaCliente.add(cliente);
                }while(rs.next());
            }else{
                throw new SQLException("No se encontro coincidencia");
            }
            rs.close();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaCliente;
    }
}
