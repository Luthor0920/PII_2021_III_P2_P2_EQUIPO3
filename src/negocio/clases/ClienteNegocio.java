package negocio.clases;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import datos.clasesDatos.ClienteDatos;
import recursos.clases.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteNegocio {

    public List<Cliente> leer() throws Exception {
        List<Cliente> listaClientes = new ArrayList<>();
        try {

            listaClientes = ClienteDatos.leerCliente();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaClientes;
    }

    public String insertar(Cliente pCliente) throws Exception {
        String respuesta = "Error";
        try {
            //validaciones
            if (String.valueOf(pCliente.getCodigo()).isEmpty()) {
                throw new Exception("Error: El codigo no debe estar vacio.");
            }
            if (pCliente.getCodigo() <= 0) {
                throw new Exception("Error: Indique el codigo correctamente.");
            }
            if (pCliente.getNombre().isEmpty()) {
                throw new Exception("Error: El nombre no debe estar vacio.");
            }
            if (pCliente.getNombre().length() < 3) {
                throw new Exception("Error: Nombre Incorrecto.");
            }
            if (String.valueOf(pCliente.getDNI()).isEmpty()) {
                throw new Exception("Error: El DNI no debe estar vacio.");
            }
            if (pCliente.getDNI() <= 0) {
                throw new Exception("Error: El DNI no puede ser menor a 0.");
            }
            if (String.valueOf(pCliente.getDNI()).length() < 12) {
                throw new Exception("Error: El DNI es demasiado corto.");
            }
            if (String.valueOf(pCliente.getDNI()).length() > 13) {
                throw new Exception("Error: El DNI es muy largo.");
            }
            if (pCliente.getTipoCliente().isEmpty()) {
                throw new Exception("Error: El tipo de cliente no debe estar vacio.");
            }
            if (pCliente.getTipoCliente().length() < 3) {
                throw new Exception("Error: Tipo de cliente invalido.");
            }
            if (pCliente.getOcupacion().isEmpty()) {
                throw new Exception("Error: La ocupacion no debe estar vacia.");
            }
            if (pCliente.getOcupacion().length() < 3) {
                throw new Exception("Error: Ocupacion incorrecta.");
            }
            if (pCliente.getRecurrencia().isEmpty()) {
                throw new Exception("Error: La recurrencia no debe estar vacia.");
            }
            if (pCliente.getRecurrencia().length() < 3) {
                throw new Exception("Error: Recurrencia incorrecta.");
            }
            if (pCliente.getTallaCamisa().isEmpty()) {
                throw new Exception("Error: La talla de camisa no debe estar vacia.");
            }
            //if ((!pCliente.getTallaCamisa().contains("XS")) || (!pCliente.getTallaCamisa().contains("S")) || (!pCliente.getTallaCamisa().contains("M")) ||
            //        (!pCliente.getTallaCamisa().contains("L")) || (!pCliente.getTallaCamisa().contains("XL")) || (!pCliente.getTallaCamisa().contains("XXL"))) {
            //    throw new Exception("Error: Talla de camisa invalida.");
            //}
            if (pCliente.getTallaCamisa().length() > 3) {
                throw new Exception("Error: Talla de camisa incorrecta.");
            }
            if (String.valueOf(pCliente.getTallaPantalon()).isEmpty()) {
                throw new Exception("Error: La talla de pantalon no debe estar vacia.");
            }
            if (pCliente.getTallaPantalon() < 0) {
                throw new Exception("Error: Talla de pantalon incorrecta.");
            }
            if (pCliente.getTallaPantalon() > 46) {
                throw new Exception("Error: Talla de pantalon invalida.");
            }
            if (pCliente.getReferencia().isEmpty()) {
                throw new Exception("Error: La referencia no debe estar vacia.");
            }
            if (pCliente.getReferencia().length() < 3) {
                throw new Exception("Error: Referencia incorrecta.");
            }

            respuesta = ClienteDatos.InsertarCliente(pCliente);
            if (respuesta == null) {
                respuesta = "Guardado Exitosamente";
            }
        } catch (Exception e) {
            respuesta = e.getMessage();
        }
        return respuesta;
    }

    public void actualizar(Cliente pCliente) throws Exception {
        try {
            if (String.valueOf(pCliente.getCodigo()).isEmpty()) {
                throw new Exception("Error: El codigo no debe estar vacio.");
            }
            if (pCliente.getCodigo() <= 0) {
                throw new Exception("Error: Indique el codigo correctamente.");
            }
            if (pCliente.getNombre().isEmpty()) {
                throw new Exception("Error: El nombre no debe estar vacio.");
            }
            if (pCliente.getNombre().length() < 3) {
                throw new Exception("Error: Nombre Incorrecto.");
            }
            if (String.valueOf(pCliente.getDNI()).isEmpty()) {
                throw new Exception("Error: El DNI no debe estar vacio.");
            }
            if (pCliente.getDNI() <= 0) {
                throw new Exception("Error: El DNI no puede ser menor a 0.");
            }
            if (String.valueOf(pCliente.getDNI()).length() < 12) {
                throw new Exception("Error: El DNI es demasiado corto.");
            }
            if (String.valueOf(pCliente.getDNI()).length() > 13) {
                throw new Exception("Error: El DNI es muy largo.");
            }
            if (pCliente.getTipoCliente().isEmpty()) {
                throw new Exception("Error: El tipo de cliente no debe estar vacio.");
            }
            if (pCliente.getTipoCliente().length() < 3) {
                throw new Exception("Error: Tipo de cliente invalido.");
            }
            if (pCliente.getOcupacion().isEmpty()) {
                throw new Exception("Error: La ocupacion no debe estar vacia.");
            }
            if (pCliente.getOcupacion().length() < 3) {
                throw new Exception("Error: Ocupacion incorrecta.");
            }
            if (pCliente.getRecurrencia().isEmpty()) {
                throw new Exception("Error: La recurrencia no debe estar vacia.");
            }
            if (pCliente.getRecurrencia().length() < 3) {
                throw new Exception("Error: Recurrencia incorrecta.");
            }
            if (pCliente.getTallaCamisa().isEmpty()) {
                throw new Exception("Error: La talla de camisa no debe estar vacia.");
            }
            //if ((!pCliente.getTallaCamisa().contains("XS")) || (!pCliente.getTallaCamisa().contains("S")) || (!pCliente.getTallaCamisa().contains("M")) ||
            //        (!pCliente.getTallaCamisa().contains("L")) || (!pCliente.getTallaCamisa().contains("XL")) || (!pCliente.getTallaCamisa().contains("XXL"))) {
            //    throw new Exception("Error: Talla de camisa invalida.");
            //}
            if (pCliente.getTallaCamisa().length() > 4) {
                throw new Exception("Error: Talla de camisa incorrecta.");
            }
            if (String.valueOf(pCliente.getTallaPantalon()).isEmpty()) {
                throw new Exception("Error: La talla de pantalon no debe estar vacia.");
            }
            if (pCliente.getTallaPantalon() < 0) {
                throw new Exception("Error: Talla de pantalon incorrecta.");
            }
            if (pCliente.getTallaPantalon() > 46) {
                throw new Exception("Error: Talla de pantalon invalida.");
            }
            if (pCliente.getReferencia().isEmpty()) {
                throw new Exception("Error: La referencia no debe estar vacia.");
            }
            if (pCliente.getReferencia().length() < 3) {
                throw new Exception("Error: Referencia incorrecta.");
            }

            ClienteDatos.ActualizarCliente(pCliente);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void eliminar(Cliente pCliente) throws Exception {
        try {
            if (String.valueOf(pCliente.getCodigo()).isEmpty()) {
                throw new Exception("Error: El codigo no debe estar vacio.");
            }
            if (pCliente.getCodigo() <= 0) {
                throw new Exception("Error: Indique el codigo correctamente.");
            }

            ClienteDatos.EliminarCliente(pCliente);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Cliente> buscar(Cliente pCliente) throws Exception {
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            if (pCliente.getNombre().isEmpty()) {
                throw new Exception("Error: El nombre no debe estar vacio.");
            }
            if (pCliente.getNombre().length() < 3) {
                throw new Exception("Error: Nombre Incorrecto.");
            }

            listaClientes = ClienteDatos.BuscarCliente(pCliente);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaClientes;
    }
}
