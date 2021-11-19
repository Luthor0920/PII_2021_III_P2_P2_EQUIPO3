package negocio.clases;

import datos.clasesDatos.MaquilaDatos;
import recursos.clases.Maquila;

import java.util.ArrayList;
import java.util.List;

public class MaquilaNegocio {

    public List<Maquila> Leer() throws Exception {
        List<Maquila> listaMaquilas = new ArrayList<>();
        try {
            listaMaquilas = MaquilaDatos.leerMaquila();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaMaquilas;
    }

    public String insertar(Maquila pMaquila) {
        String respuesta = "Error";
        int digitos=0;
        Long codigo = pMaquila.getCodigo();
        Long telefono = pMaquila.getTelefono();
        Integer cantidad = new Integer(pMaquila.getCantidadEmpleados());
        try {
            //validaciones
            if (codigo == null) {
                throw new Exception("Error: El codigo no debe estar vacio.");
            }
            if (pMaquila.getCodigo() <= 0) {
                throw new Exception("Error: El codigo no debe ser menor a 0.");
            }
            if (pMaquila.getNombre().isEmpty()) {
                throw new Exception("Error: El nombre no debe estar vacio.");
            }
            if (pMaquila.getNombre().length() < 3) {
                throw new Exception("Error: Nombre Incorrecto.");
            }
            if (pMaquila.getDireccion().isEmpty()) {
                throw new Exception("Error: La direccion no debe estar vacia.");
            }
            if (pMaquila.getDireccion().length() < 3) {
                throw new Exception("Error: Direccion invalida.");
            }
            if (pMaquila.getFechaInicio().toString().isEmpty()) {
                throw new Exception("Error: La fecha no debe estar vacia.");
            }
            if (pMaquila.getFechaInicio().getYear() > 2021) {
                throw new Exception("Error: Fecha invalida.");
            }
            if (telefono == null) {
                throw new Exception("Error: El numero de telefono no debe estar vacio.");
            }
            else if (pMaquila.getTelefono() < 0) {
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
            if (pMaquila.getCorreo().isEmpty()) {
                throw new Exception("Error: El correo no debe estar vacio.");
            }
            if (pMaquila.getCorreo().length() < 6) {
                throw new Exception("Error: Correo incorrecto.");
            }
            if (cantidad == null) {
                throw new Exception("Error: La cantidad de empleados no debe estar vacia.");
            }
            if (pMaquila.getCantidadEmpleados() < 0) {
                throw new Exception("Error: La cantidad de empleados no puede ser < 0.");
            }

            respuesta = MaquilaDatos.InsertarMaquila(pMaquila);
            if (respuesta.equals(null)) {
                respuesta = "Guardado Exitosamente";
            }
        } catch (Exception e) {
            respuesta = e.getMessage();
        }
        finally {
            return respuesta;
        }
    }

    public void actualizar(Maquila pMaquila) throws Exception {
        int digitos=0;
        Long codigo = pMaquila.getCodigo();
        Long telefono = pMaquila.getTelefono();
        Integer cantidad = new Integer(pMaquila.getCantidadEmpleados());
        try {
            //validaciones:
            if (codigo == null) {
                throw new Exception("Error: El codigo no debe estar vacio.");
            }
            if (pMaquila.getCodigo() <= 0) {
                throw new Exception("Error: Indique el codigo correctamente.");
            }

            if (pMaquila.getNombre().isEmpty()) {
                throw new Exception("Error: El nombre no debe estar vacio.");
            }
            if (pMaquila.getNombre().length() < 3) {
                throw new Exception("Error: Nombre Incorrecto.");
            }
            if (pMaquila.getDireccion().isEmpty()) {
                throw new Exception("Error: La direccion no debe estar vacia.");
            }
            if (pMaquila.getDireccion().length() < 3) {
                throw new Exception("Error: Direccion invalida.");
            }
            if (pMaquila.getFechaInicio().toString().isEmpty()) {
                throw new Exception("Error: La fecha no debe estar vacia.");
            }
            if (pMaquila.getFechaInicio().getYear() > 2021) {
                throw new Exception("Error: Fecha invalida.");
            }
            if (telefono == null) {
                throw new Exception("Error: El numero de telefono no debe estar vacio.");
            }
            else if (pMaquila.getTelefono() < 0) {
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
            if (pMaquila.getCorreo().isEmpty()) {
                throw new Exception("Error: El correo no debe estar vacio.");
            }
            if (pMaquila.getCorreo().length() < 11) {
                throw new Exception("Error: Correo incorrecto.");
            }
            if (cantidad == null) {
                throw new Exception("Error: La cantidad de empleados no debe estar vacia.");
            }
            if (pMaquila.getCantidadEmpleados() < 0) {
                throw new Exception("Error: La cantidad de empleados no puede ser < 0.");
            }

            MaquilaDatos.ActualizarMaquila(pMaquila);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void eliminar(Maquila pMaquila) throws Exception {
        Long codigo = pMaquila.getCodigo();
        try {
            if (codigo == null) {
                throw new Exception("Error: El codigo no debe estar vacio.");
            }
             else if (pMaquila.getCodigo() <= 0) {
                throw new Exception("Error: Codigo Invalido.");
            }

            MaquilaDatos.EliminarMaquila(pMaquila);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Maquila> buscar(Maquila pMaquila) throws Exception {
        List<Maquila> listaMaquilas = new ArrayList<>();
        try {
            if (pMaquila.getNombre().isEmpty()) {
                throw new Exception("Error: El nombre no debe estar vacio.");
            }
            if (pMaquila.getNombre().length() < 3) {
                throw new Exception("Error: Nombre Incorrecto.");
            }

            listaMaquilas = MaquilaDatos.BuscarMaquila(pMaquila);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaMaquilas;
    }
}
