package datos.clasesDatos;

import datos.conexion.Conexion;
import recursos.clases.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDatos {
    //CRUD Create-Read-Update-Delete
    public static String InsertarPersona(Persona pPersona) throws SQLException {
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "INSERT INTO Persona VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pPersona.getDNI());
            ps.setString(2, pPersona.getNombre());
            ps.setDate(3, new java.sql.Date(pPersona.getFechaNacimiento().getTime()));
            ps.setString(4, pPersona.getDireccion());
            ps.setLong(5, pPersona.getTelefono());
            ps.setString(6, pPersona.getCorreo());
            ps.setInt(7, pPersona.getEdad());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }
    public static List<Persona> leerPersona() throws SQLException {
        List<Persona> listaPersonas = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            Statement st = cn.createStatement();
            String sql = "SELECT DNI, Nombre, FechaNacimiento, Direccion, Telefono, Email, Edad FROM Persona";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                Persona persona = new Persona();
                persona.setDNI(rs.getLong(1));
                persona.setNombre(rs.getString(2));
                persona.setFechaNacimiento(rs.getDate(3));
                persona.setDireccion(rs.getString(4));
                persona.setTelefono(rs.getLong(5));
                persona.setCorreo(rs.getString(6));
                persona.setEdad(rs.getInt(7));
                listaPersonas.add(persona);
            }
            rs.close();
            st.close();
            cn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaPersonas;
    }
    public static String ActualizarPersona(Persona pPersona) throws SQLException {
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "UPDATE Persona SET Nombre = ?, FechaNacimiento = ?, Direccion = ?, Telefono = ?," +
                    "Email = ?, Edad = ? WHERE DNI = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, pPersona.getNombre());
            ps.setDate(2, new java.sql.Date(pPersona.getFechaNacimiento().getTime()));
            ps.setString(3, pPersona.getDireccion());
            ps.setLong(4, pPersona.getTelefono());
            ps.setString(5, pPersona.getCorreo());
            ps.setInt(6, pPersona.getEdad());
            ps.setLong(7, pPersona.getDNI());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }
    public static String EliminarPersona(Persona pPersona) throws SQLException{
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "DELETE FROM Persona WHERE DNI = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setLong(1, pPersona.getDNI());
            ps.execute();
            ps.close();
            cn.close();
        }catch (Exception e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
        return null;
    }
    public  static List<Persona> BuscarPersona(Persona pPersona) throws SQLException{
        List<Persona> listaPersona = new ArrayList<>();
        try{
            Connection cn = Conexion.obtenerConexion();
            String sql = "SELECT DNI, Nombre, FechaNacimiento, Direccion, Telefono, Email, Edad FROM Persona" +
                    "WHERE UPPER(Nombre) LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "%"+pPersona.getNombre().toUpperCase()+"%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                do{
                    Persona persona = new Persona();
                    persona.setDNI(rs.getLong(1));
                    persona.setNombre(rs.getString(2));
                    persona.setFechaNacimiento(rs.getDate(3));
                    persona.setDireccion(rs.getString(4));
                    persona.setTelefono(rs.getLong(5));
                    persona.setCorreo(rs.getString(6));
                    persona.setEdad(rs.getInt(7));
                    listaPersona.add(persona);
                }while(rs.next());
            }else{
                throw new SQLException("Error no se encontró coincidencia");
            }
            rs.close();
            ps.close();
            cn.close();
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return listaPersona;
    }
}
