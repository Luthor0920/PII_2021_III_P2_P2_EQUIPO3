package negocio.clases;

import datos.clasesDatos.EmpleadoDatos;
import recursos.clases.Empleado;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoNegocio {

    public List<Empleado> leer() throws Exception {
        List<Empleado> listaEmpleados = new ArrayList<>();
        try {

            listaEmpleados = EmpleadoDatos.leerEmpleado();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaEmpleados;
    }

    public String insertar(Empleado pEmpleado) throws Exception {
        String respuesta = "Error";
        try {
            if (String.valueOf(pEmpleado.getCodigo()).isEmpty()) {
                throw new Exception("Error: El codigo no debe estar vacio.");
            }
            if (pEmpleado.getCodigo() <= 0) {
                throw new Exception("Error: Indique el codigo correctamente.");
            }
            if (pEmpleado.getNombre().isEmpty()) {
                throw new Exception("Error: El nombre no debe estar vacio.");
            }
            if (pEmpleado.getNombre().length() < 3) {
                throw new Exception("Error: Nombre Incorrecto.");
            }
            if (String.valueOf(pEmpleado.getDNI()).isEmpty()) {
                throw new Exception("Error: El DNI no debe estar vacio.");
            }
            if (pEmpleado.getDNI() <= 0) {
                throw new Exception("Error: El DNI no puede ser menor a 0.");
            }
            if (String.valueOf(pEmpleado.getDNI()).length() < 13) {
                throw new Exception("Error: El DNI es demasiado corto.");
            }
            if (String.valueOf(pEmpleado.getDNI()).length() > 13) {
                throw new Exception("Error: El DNI es muy largo.");
            }
            if (pEmpleado.getPuesto().isEmpty()) {
                throw new Exception("Error: El puesto no debe estar vacio.");
            }
            if (pEmpleado.getPuesto().length() < 3) {
                throw new Exception("Error: Puesto invalido.");
            }
            if (String.valueOf(pEmpleado.getSueldo()).isEmpty()) {
                throw new Exception("Error: El sueldo no debe estar vacio.");
            }
            if (pEmpleado.getSueldo() <= 0) {
                throw new Exception("Error: Sueldo incorrecto.");
            }
            if (pEmpleado.getFechaIngreso().toString().isEmpty()) {
                throw new Exception("Error: La fecha de ingreso no debe estar vacia.");
            }
            if (pEmpleado.getNivelAcademico().isEmpty()) {
                throw new Exception("Error: El nivel academico no debe estar vacio.");
            }
            if (pEmpleado.getNivelAcademico().length() < 3) {
                throw new Exception("Error: Nivel academico invalido.");
            }

            respuesta = EmpleadoDatos.IngresarEmpleado(pEmpleado);
            if (respuesta == null) {
                respuesta = "Guardado Exitosamente";
            }
        } catch (Exception e) {
            respuesta = e.getMessage();
        }
        return respuesta;
    }

    public void actualizar(Empleado pEmpleado) throws Exception {
        try {
            if (String.valueOf(pEmpleado.getCodigo()).isEmpty()) {
                throw new Exception("Error: El codigo no debe estar vacio.");
            }
            if (pEmpleado.getCodigo() <= 0) {
                throw new Exception("Error: Indique el codigo correctamente.");
            }
            if (pEmpleado.getNombre().isEmpty()) {
                throw new Exception("Error: El nombre no debe estar vacio.");
            }
            if (pEmpleado.getNombre().length() < 3) {
                throw new Exception("Error: Nombre Incorrecto.");
            }
            if (String.valueOf(pEmpleado.getDNI()).isEmpty()) {
                throw new Exception("Error: El DNI no debe estar vacio.");
            }
            if (pEmpleado.getDNI() <= 0) {
                throw new Exception("Error: El DNI no puede ser menor a 0.");
            }
            if (String.valueOf(pEmpleado.getDNI()).length() < 13) {
                throw new Exception("Error: El DNI es demasiado corto.");
            }
            if (String.valueOf(pEmpleado.getDNI()).length() > 13) {
                throw new Exception("Error: El DNI es muy largo.");
            }
            if (pEmpleado.getPuesto().isEmpty()) {
                throw new Exception("Error: El puesto no debe estar vacio.");
            }
            if (pEmpleado.getPuesto().length() < 3) {
                throw new Exception("Error: Puesto invalido.");
            }
            if (String.valueOf(pEmpleado.getSueldo()).isEmpty()) {
                throw new Exception("Error: El sueldo no debe estar vacio.");
            }
            if (pEmpleado.getSueldo() <= 0) {
                throw new Exception("Error: Sueldo incorrecto.");
            }
            if (pEmpleado.getFechaIngreso().toString().isEmpty()) {
                throw new Exception("Error: La fecha de ingreso no debe estar vacia.");
            }
            if (pEmpleado.getNivelAcademico().isEmpty()) {
                throw new Exception("Error: El nivel academico no debe estar vacio.");
            }
            if (pEmpleado.getNivelAcademico().length() < 3) {
                throw new Exception("Error: Nivel academico invalido.");
            }

            EmpleadoDatos.ActualizarEmpleado(pEmpleado);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void eliminar(Empleado pEmpleado) throws Exception {
        try {
            if (String.valueOf(pEmpleado.getCodigo()).isEmpty()) {
                throw new Exception("Error: El codigo no debe estar vacio.");
            }
            if (pEmpleado.getCodigo() <= 0) {
                throw new Exception("Error: Indique el codigo correctamente.");
            }

            EmpleadoDatos.EliminarEmpleado(pEmpleado);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Empleado> buscar(Empleado pEmpleado) throws Exception {
        List<Empleado> listaEmpleados = new ArrayList<>();
        try {
            if (pEmpleado.getNombre().isEmpty()) {
                throw new Exception("Error: El nombre no debe estar vacio.");
            }
            if (pEmpleado.getNombre().length() < 3) {
                throw new Exception("Error: Nombre Incorrecto.");
            }

            listaEmpleados = EmpleadoDatos.BuscarEmpleado(pEmpleado);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaEmpleados;
    }
}
