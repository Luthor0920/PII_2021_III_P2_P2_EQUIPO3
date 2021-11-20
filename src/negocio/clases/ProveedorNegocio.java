package negocio.clases;

import datos.clasesDatos.ProveedorDatos;
import recursos.clases.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class ProveedorNegocio {

    public List<Proveedor> Leer() throws Exception {
        List<Proveedor> listaProveedores = new ArrayList<>();
        try {
            listaProveedores = ProveedorDatos.leerProveedor();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaProveedores;
    }

    public String insertar(Proveedor pProveedor) throws Exception {
        String respuesta = "Error: ";
        Long telefono = pProveedor.getTelefono();
        int digitos=0;
        try {
            //validaciones
            if (String.valueOf(pProveedor.getCodigo()).isEmpty()) {
                throw new Exception("Error: El codigo no debe estar vacio.");
            }
            if (pProveedor.getCodigo() <= 0) {
                throw new Exception("Error: El codigo no debe ser menor a 0.");
            }
            if (pProveedor.getNombre().isEmpty()) {
                throw new Exception("Error: El nombre no debe estar vacio.");
            }
            if (pProveedor.getNombre().length() < 3) {
                throw new Exception("Error: Nombre invalido.");
            }
            if (pProveedor.getDireccion().isEmpty()) {
                throw new Exception("Error: La direccion no debe estar vacia.");
            }
            if (pProveedor.getDireccion().length() < 3) {
                throw new Exception("Error: Direccion invalida.");
            }
            if (telefono == null) {
                throw new Exception("Error: El numero de telefono no debe estar vacio.");
            }
            else if (pProveedor.getTelefono() < 0) {
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
            if (pProveedor.getFechaInicio().toString().isEmpty()) {
                throw new Exception("Error: La fecha no debe estar vacia.");
            }
            if (pProveedor.getFechaInicio().getYear() > 2021) {
                throw new Exception("Error: Fecha invalida.");
            }
            if (pProveedor.getCorreo().isEmpty()) {
                throw new Exception("Error: El correo no debe estar vacio.");
            }
            if (pProveedor.getCorreo().length() < 6) {
                throw new Exception("Error: Correo incorrecto.");
            }
            if (pProveedor.getTipoProveedor().isEmpty()){
                throw new Exception("Error: El tipo de proveedor no debe estar vacio.");
            }
            if (pProveedor.getTipoProveedor().length() < 3) {
                throw new Exception("Error: Tipo de Proveedor invalido.");
            }

            respuesta = ProveedorDatos.IngresarProveedor(pProveedor);
            if (respuesta == null) {
                respuesta = "Guardado Exitosamente";
            }
        } catch (Exception e) {
            respuesta = e.getMessage();
        }
        finally {
            return respuesta;
        }
    }

    public void actualizar(Proveedor pProveedor) throws Exception {
        Long codigo = pProveedor.getCodigo();
        Long telefono = pProveedor.getTelefono();
        int digitos=0;
        try {
            //validaciones
            if (codigo == null) {
                throw new Exception("Error: El codigo no debe estar vacio.");
            }
            if (codigo <= 0) {
                throw new Exception("Error: El codigo no debe ser menor a 0.");
            }
            if (pProveedor.getNombre().isEmpty()) {
                throw new Exception("Error: El nombre no debe estar vacio.");
            }
            if (pProveedor.getNombre().length() < 3) {
                throw new Exception("Error: Nombre invalido.");
            }
            if (pProveedor.getDireccion().isEmpty()) {
                throw new Exception("Error: La direccion no debe estar vacia.");
            }
            if (pProveedor.getDireccion().length() < 3) {
                throw new Exception("Error: Direccion invalida.");
            }
            if (telefono == null) {
                throw new Exception("Error: El numero de telefono no debe estar vacio.");
            }
            else if (pProveedor.getTelefono() < 0) {
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
            if (pProveedor.getFechaInicio().toString().isEmpty()) {
                throw new Exception("Error: La fecha no debe estar vacia.");
            }
            if (pProveedor.getFechaInicio().getYear() > 2021) {
                throw new Exception("Error: Fecha invalida.");
            }
            if (pProveedor.getCorreo().isEmpty()) {
                throw new Exception("Error: El correo no debe estar vacio.");
            }
            if (pProveedor.getCorreo().length() < 6) {
                throw new Exception("Error: Correo incorrecto.");
            }
            if (pProveedor.getTipoProveedor().isEmpty()){
                throw new Exception("Error: El tipo de proveedor no debe estar vacio.");
            }
            if (pProveedor.getTipoProveedor().length() < 3) {
                throw new Exception("Error: Tipo de Proveedor invalido.");
            }

            ProveedorDatos.ActualizarProveedor(pProveedor);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void eliminar(Proveedor pProveedor) throws Exception {
        Long codigo = pProveedor.getCodigo();
        try {
            //validaciones
            if (codigo == null) {
                throw new Exception("Error: El codigo no debe estar vacio.");
            }
            else if (pProveedor.getCodigo() <= 0) {
                throw new Exception("Error: Codigo Invalido.");
            }

            ProveedorDatos.EliminarProveedor(pProveedor);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Proveedor> buscar(Proveedor pProveedor) throws Exception {
        List<Proveedor> listaProveedores = new ArrayList<>();
        try {
            if (pProveedor.getNombre().isEmpty()) {
                throw new Exception("Error: El nombre no debe estar vacio.");
            }
            if (pProveedor.getNombre().length() < 3) {
                throw new Exception("Error: Nombre Incorrecto.");
            }

            listaProveedores = ProveedorDatos.BuscarProveedor(pProveedor);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaProveedores;
    }
}
