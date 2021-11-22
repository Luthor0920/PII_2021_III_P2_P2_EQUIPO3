package datos.clasesDatos;

import datos.conexion.Conexion;
import recursos.clases.Produccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduccionDatos {
    //CRUD Create, Reade, Update, Delete
    public static String InsertarProduccion(Produccion pProduccion) throws SQLException {
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Produccion VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pProduccion.getCodigoPrenda());
            ps.setLong(2, pProduccion.getCodigoLote());
            ps.setInt(3, pProduccion.getCantidadPrenda());
            ps.setString(4, pProduccion.getDiseñoPrenda());
            ps.setString(5, pProduccion.getTipoPrenda());
            ps.setString(6, pProduccion.getTallaPrenda());
            ps.setDouble(7, pProduccion.getCostoPrenda());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }
    public static List<Produccion> leerProduccion() throws SQLException{
        List<Produccion> listaProduccion = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT CodigoPrenda, CodigoLote, CantidadPrenda, DiseñoPrenda, TipoPrenda, TallaPrenda, " +
                    "PrecioPrenda FROM Produccion";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Produccion produccion = new Produccion();
                produccion.setCodigoPrenda(rs.getLong(1));
                produccion.setCodigoLote(rs.getLong(2));
                produccion.setCantidadPrenda(rs.getInt(3));
                produccion.setDiseñoPrenda(rs.getString(4));
                produccion.setTipoPrenda(rs.getString(5));
                produccion.setTallaPrenda(rs.getString(6));
                produccion.setCostoPrenda(rs.getDouble(7));
                listaProduccion.add(produccion);
            }
            rs.close();
            st.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaProduccion;
    }
    public static String ActualizarProduccion(Produccion pProduccion) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Produccion SET CodigoPrenda = ?, CantidadPrenda = ?, DiseñoPrenda = ?, TipoPrenda = ?" +
                    ", TallaPrenda = ?, PrecioPrenda = ? WHERE CodigoPrenda = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pProduccion.getCodigoLote());
            ps.setInt(2, pProduccion.getCantidadPrenda());
            ps.setString(3, pProduccion.getDiseñoPrenda());
            ps.setString(4, pProduccion.getTipoPrenda());
            ps.setString(5, pProduccion.getTallaPrenda());
            ps.setDouble(6, pProduccion.getCostoPrenda());
            ps.setLong(7, pProduccion.getCodigoPrenda());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }
    public static String EliminarProduccion(Produccion pProduccion) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Produccion WHERE CodigoPrenda = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pProduccion.getCodigoPrenda());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }
    public static List<Produccion> BuscarProduccion(Produccion pProduccion) throws SQLException{
        List<Produccion> listaProduccion = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "SELECT CodigoPrenda, CodigoLote, CantidadPrenda, DiseñoPrenda, TipoPrenda, TallaPrenda," +
                    "PrecioPrenda FROM Produccion WHERE CodigoPrenda LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, Long.parseLong("%"+pProduccion.getCodigoPrenda()+"%"));
            ResultSet rs = ps.getResultSet();
            if (rs.next()) {
                do{
                    Produccion produccion = new Produccion();
                    produccion.setCodigoPrenda(rs.getLong(1));
                    produccion.setCodigoLote(rs.getLong(2));
                    produccion.setCantidadPrenda(rs.getInt(3));
                    produccion.setDiseñoPrenda(rs.getString(4));
                    produccion.setTipoPrenda(rs.getString(5));
                    produccion.setTallaPrenda(rs.getString(6));
                    produccion.setCostoPrenda(rs.getDouble(7));
                    listaProduccion.add(produccion);
                }while(rs.next());
            }else{
                throw new SQLException("No se encontró coincidencia");
            }
            rs.close();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaProduccion;
    }
}
