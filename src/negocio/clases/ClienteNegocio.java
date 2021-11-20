package negocio.clases;

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

            ClienteDatos.ActualizarCliente(pCliente);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void eliminar(Cliente pCliente) throws Exception {
        try {

            ClienteDatos.EliminarCliente(pCliente);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Cliente> buscar(Cliente pCliente) throws Exception {
        List<Cliente> listaClientes = new ArrayList<>();
        try {

            listaClientes = ClienteDatos.BuscarCliente(pCliente);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return listaClientes;
    }
}
