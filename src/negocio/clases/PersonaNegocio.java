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
        Long telefono = pPersona.getTelefono();
        int digitos=0;
        try {
            //validaciones:
            if (String.valueOf(pPersona.getDNI()).isEmpty()) {
                throw new Exception("Error: El DNI no debe estar vacio.");
            }
            if (pPersona.getDNI() <= 0) {
                throw new Exception("Error: El DNI no puede ser menor a 0.");
            }
            if (String.valueOf(pPersona.getDNI()).length() < 13) {
                throw new Exception("Error: El DNI es demasiado corto.");
            }
            if (String.valueOf(pPersona.getDNI()).length() > 13) {
                throw new Exception("Error: El DNI es muy largo.");
            }
            if (pPersona.getNombre().isEmpty()) {
                throw new Exception("Error: El nombre no debe estar vacio.");
            }
            if (pPersona.getNombre().length() < 3) {
                throw new Exception("Error: Nombre Incorrecto.");
            }
            if (pPersona.getFechaNacimiento().toString().isEmpty()) {
                throw new Exception("Error: La fecha no debe estar vacia.");
            }
            if (pPersona.getFechaNacimiento().getYear() > 2021) {
                throw new Exception("Error: Fecha invalida.");
            }
            if (telefono == null) {
                throw new Exception("Error: El numero de telefono no debe estar vacio.");
            }
            else if (pPersona.getTelefono() < 0) {
                throw new Exception("Error: Numero de telefono invalido.");
            } else {
                while (telefono != 0) {
                    telefono = telefono/10;
                    digitos++;
                }
            }
            if (digitos < 8) {
                throw new Exception("Error: El numero de telefono es muy corto.");
            }
            if (digitos > 8) {
                throw new Exception("Error: El numero de telefono es demasiado largo.");
            }
            if (pPersona.getCorreo().isEmpty()) {
                throw new Exception("Error: El correo no debe estar vacio.");
            }
            if (pPersona.getCorreo().length() < 6) {
                throw new Exception("Error: Correo incorrecto.");
            }
            if (String.valueOf(pPersona.getEdad()).isEmpty()) {
                throw new Exception("Error: La edad no debe estar vacia.");
            }
            if (pPersona.getEdad() < 0) {
                throw new Exception("Error: La edad no puede ser < 0.");
            }
            if (String.valueOf(pPersona.getEdad()).length() > 3) {
                throw new Exception("Error: Edad incorrecta.");
            }

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
        Long telefono = pPersona.getTelefono();
        int digitos=0;
        try {
            //validaciones:
            if (String.valueOf(pPersona.getDNI()).isEmpty()) {
                throw new Exception("Error: El DNI no debe estar vacio.");
            }
            if (pPersona.getDNI() <= 0) {
                throw new Exception("Error: El DNI no puede ser menor a 0.");
            }
            if (String.valueOf(pPersona.getDNI()).length() < 13) {
                throw new Exception("Error: El DNI es demasiado corto.");
            }
            if (String.valueOf(pPersona.getDNI()).length() > 13) {
                throw new Exception("Error: El DNI es muy largo.");
            }
            if (pPersona.getNombre().isEmpty()) {
                throw new Exception("Error: El nombre no debe estar vacio.");
            }
            if (pPersona.getNombre().length() < 3) {
                throw new Exception("Error: Nombre Incorrecto.");
            }
            if (pPersona.getFechaNacimiento().toString().isEmpty()) {
                throw new Exception("Error: La fecha no debe estar vacia.");
            }
            if (pPersona.getFechaNacimiento().getYear() > 2021) {
                throw new Exception("Error: Fecha invalida.");
            }
            if (telefono == null) {
                throw new Exception("Error: El numero de telefono no debe estar vacio.");
            }
            else if (pPersona.getTelefono() < 0) {
                throw new Exception("Error: Numero de telefono invalido.");
            } else {
                while (telefono != 0) {
                    telefono = telefono/10;
                    digitos++;
                }
            }
            if (digitos < 8) {
                throw new Exception("Error: El numero de telefono es muy corto.");
            }
            if (digitos > 8) {
                throw new Exception("Error: El numero de telefono es demasiado largo.");
            }
            if (pPersona.getCorreo().isEmpty()) {
                throw new Exception("Error: El correo no debe estar vacio.");
            }
            if (pPersona.getCorreo().length() < 6) {
                throw new Exception("Error: Correo incorrecto.");
            }
            if (String.valueOf(pPersona.getEdad()).isEmpty()) {
                throw new Exception("Error: La edad no debe estar vacia.");
            }
            if (pPersona.getEdad() < 0) {
                throw new Exception("Error: La edad no puede ser < 0.");
            }
            if (String.valueOf(pPersona.getEdad()).length() > 3) {
                throw new Exception("Error: Edad incorrecta.");
            }

            PersonaDatos.ActualizarPersona(pPersona);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void eliminar(Persona pPersona) throws Exception {
        try {
            if (String.valueOf(pPersona.getDNI()).isEmpty()) {
                throw new Exception("Error: El DNI no debe estar vacio.");
            }
            else if (pPersona.getDNI() <= 0) {
                throw new Exception("Error: DNI Invalido.");
            }
            if (String.valueOf(pPersona.getDNI()).length() < 13) {
                throw new Exception("Error: El DNI es demasiado corto.");
            }
            if (String.valueOf(pPersona.getDNI()).length() > 13) {
                throw new Exception("Error: El DNI es muy largo.");
            }

            PersonaDatos.EliminarPersona(pPersona);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Persona> buscar(Persona pPersona) throws Exception {
        List<Persona> listaPersonas = new ArrayList<>();
        try {
            if (pPersona.getNombre().isEmpty()) {
                throw new Exception("Error: El nombre no debe estar vacio.");
            }
            if (pPersona.getNombre().length() < 3) {
                throw new Exception("Error: Nombre Incorrecto.");
            }

            listaPersonas = PersonaDatos.BuscarPersona(pPersona);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaPersonas;
    }
}
