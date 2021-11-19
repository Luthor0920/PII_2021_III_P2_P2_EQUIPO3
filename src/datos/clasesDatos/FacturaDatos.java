package datos.clasesDatos;

import datos.conexion.Conexion;
import recursos.clases.Factura;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDatos {
    //CRUD Create, Read, Update, Delete
    public static String IngresarFactura(Factura pFactura) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Factura VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pFactura.getNumeroFactura());
            ps.setString(2, pFactura.getCliente());
            ps.setString(3, pFactura.getEmpleado());
            ps.setDate(4, new java.sql.Date(pFactura.getFecha().getTime()));
            ps.setString(5, pFactura.getProducto());
            ps.setInt(6, pFactura.getCantidad());
            ps.setDouble(7, pFactura.getSubTotal());
            ps.setDouble(8, pFactura.getISV());
            ps.setDouble(9, pFactura.getTotalPagar());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }
    public static List<Factura> leerFactura() throws SQLException{
        List<Factura> listaFactura = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT NumeroFactura, Cliente, Empleado, Fecha, Producto, Cantidad, SubTotal, ISV, TotalPagar" +
                    "FROM Factura";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Factura factura = new Factura();
                factura.setNumeroFactura(rs.getLong(1));
                factura.setCliente(rs.getString(2));
                factura.setEmpleado(rs.getString(3));
                factura.setFecha(rs.getDate(4));
                factura.setProducto(rs.getString(5));
                factura.setCantidad(rs.getInt(6));
                factura.setSubTotal(rs.getDouble(7));
                factura.setISV(rs.getDouble(8));
                factura.setTotalPagar(rs.getDouble(9));
                listaFactura.add(factura);
            }
            st.close();
            rs.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaFactura;
    }
    public static String ActualizarFactura(Factura pFactura) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Factura SET Cliente = ?, Empleado = ?, Fecha = ?, Producto = ?, Cantidad = ?," +
                    "SubTotal = ?, ISV = ?, TotalPagar = ? WHERE NumeroFactura = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, pFactura.getCliente());
            ps.setString(2, pFactura.getEmpleado());
            ps.setDate(3, new java.sql.Date(pFactura.getFecha().getTime()));
            ps.setString(4, pFactura.getProducto());
            ps.setInt(5, pFactura.getCantidad());
            ps.setDouble(6, pFactura.getSubTotal());
            ps.setDouble(7, pFactura.getISV());
            ps.setDouble(8, pFactura.getTotalPagar());
            ps.setLong(9, pFactura.getNumeroFactura());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }
    public static String EliminarFactura(Factura pFactura) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Factura WHERE NumeroCuenta = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pFactura.getNumeroFactura());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }
    public static List<Factura> BuscarFactura(Factura pFactura)throws SQLException{
        List<Factura> listaFactura = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "SELECT NumeroFactura, Cliente, Empleado, Fecha, Producto, Cantidad, SubTotal, ISV, TotalPagar" +
                    "FROM Factura WHERE NumeroFactura LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pFactura.getNumeroFactura());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    Factura factura = new Factura();
                    factura.setNumeroFactura(rs.getLong(1));
                    factura.setCliente(rs.getString(2));
                    factura.setEmpleado(rs.getString(3));
                    factura.setFecha(rs.getDate(4));
                    factura.setProducto(rs.getString(5));
                    factura.setCantidad(rs.getInt(6));
                    factura.setSubTotal(rs.getDouble(7));
                    factura.setISV(rs.getDouble(8));
                    factura.setTotalPagar(rs.getDouble(9));
                    listaFactura.add(factura);
                }while(rs.next());
            }else{
                throw new SQLException("No se encontro coincidencia");
            }
            ps.close();
            rs.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaFactura;
    }
}
