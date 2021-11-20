package negocio.clases;

import datos.clasesDatos.PersonaDatos;
import recursos.clases.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaNegocio {

    public List<Persona> Leer() throws Exception {
        List<Persona> listaPersonas = new ArrayList<>();
        try {
            listaPersonas = PersonaDatos.leerPersona();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaPersonas;
    }

    public String insertar(Persona pPersona) throws Exception {
        String respuesta = "Error";
        try {
            //validaciones:

            respuesta = PersonaDatos.InsertarPersona(pPersona);
            if (respuesta == null) {
                respuesta = "Guardado Exitosamente";
            }
        } catch (Exception e) {
            respuesta = e.getMessage();
        }
        return respuesta;
    }

    public void actualizar(Persona pPersona) throws Exception {
        try {
            //validaciones:

            PersonaDatos.ActualizarPersona(pPersona);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void eliminar(Persona pPersona) throws Exception {
        try {

            PersonaDatos.EliminarPersona(pPersona);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Persona> buscar(Persona pPersona) throws Exception {
        List<Persona> listaPersonas = new ArrayList<>();
        try {

            listaPersonas = PersonaDatos.BuscarPersona(pPersona);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaPersonas;
    }
}
