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

            EmpleadoDatos.ActualizarEmpleado(pEmpleado);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void eliminar(Empleado pEmpleado) throws Exception {
        try {

            EmpleadoDatos.EliminarEmpleado(pEmpleado);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Empleado> buscar(Empleado pEmpleado) throws Exception {
        List<Empleado> listaEmpleados = new ArrayList<>();
        try {

            listaEmpleados = EmpleadoDatos.BuscarEmpleado(pEmpleado);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaEmpleados;
    }
}
