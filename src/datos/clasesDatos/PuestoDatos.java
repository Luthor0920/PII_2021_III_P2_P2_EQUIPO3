package datos.clasesDatos;

import datos.conexion.Conexion;
import recursos.clases.Puesto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PuestoDatos {
    public static String InsertarPuesto(Puesto pPuesto) throws SQLException {
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Puesto VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pPuesto.getCodigo());
            ps.setString(2, pPuesto.getNombre());
            ps.setInt(3, pPuesto.getNumeroEstaciones());
            ps.setString(4, pPuesto.getEstudioMinimo());
            ps.setInt(5, pPuesto.getCantidadEmpleados());
            ps.setDate(6, new java.sql.Date(pPuesto.getFechaInicio().getTime()));
            ps.setString(7, pPuesto.getUniforme());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<Puesto> leerPuesto() throws SQLException{
        List<Puesto> listaPuesto = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT Codigo, Nombre, NumeroEstaciones, EstudioMinimo, CantidadEmpleado, FechaInicio, Uniforme " +
                    "FROM Puesto";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Puesto puesto = new Puesto();
                puesto.setCodigo(rs.getLong(1));
                puesto.setNombre(rs.getString(2));
                puesto.setNumeroEstaciones(rs.getInt(3));
                puesto.setEstudioMinimo(rs.getString(4));
                puesto.setCantidadEmpleados(rs.getInt(5));
                puesto.setFechaInicio(rs.getDate(6));
                puesto.setUniforme(rs.getString(7));
                listaPuesto.add(puesto);
            }
            rs.close();
            st.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaPuesto;
    }
    public static String ActualizarPuesto(Puesto pPuesto) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Puesto SET Nombre = ?, NumeroEstaciones = ?, EstudioMinimo = ?, CantidadEmpleado = ?" +
                    ", FechaInicio = ?, Uniforme = ? WHERE Codigo = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, pPuesto.getNombre());
            ps.setInt(2, pPuesto.getNumeroEstaciones());
            ps.setString(3, pPuesto.getEstudioMinimo());
            ps.setInt(4, pPuesto.getCantidadEmpleados());
            ps.setDate(5, new java.sql.Date(pPuesto.getFechaInicio().getTime()));
            ps.setString(6, pPuesto.getUniforme());
            ps.setLong(7, pPuesto.getCodigo());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static String EliminarPuesto(Puesto pPuesto) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Puesto WHERE Codigo = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pPuesto.getCodigo());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            throw new SQLException(e.getMessage());
        }
        return null;
    }
    public static List<Puesto> BuscarPuesto(Puesto pPuesto) throws SQLException{
        List<Puesto> listaPuesto = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "SELECT Codigo, Nombre, NumeroEstaciones, EstudioMinimo, CantidadEmpleado, FechaInicio, Uniforme " +
                    "FROM Puesto WHERE UPPER(Nombre) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%"+pPuesto.getNombre().toUpperCase()+"%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    Puesto puesto = new Puesto();
                    puesto.setCodigo(rs.getLong(1));
                    puesto.setNombre(rs.getString(2));
                    puesto.setNumeroEstaciones(rs.getInt(3));
                    puesto.setEstudioMinimo(rs.getString(4));
                    puesto.setCantidadEmpleados(rs.getInt(5));
                    puesto.setFechaInicio(rs.getDate(6));
                    puesto.setUniforme(rs.getString(7));
                    listaPuesto.add(puesto);
                }while (rs.next());
            }else{
                throw new SQLException("Error: No se encontro coincidencia");
            }
            rs.close();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaPuesto;
    }
}
