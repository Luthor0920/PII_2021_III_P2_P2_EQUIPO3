package negocio.clases;

import datos.clasesDatos.FacturaDatos;
import recursos.clases.Factura;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FacturaNegocio {
    public List<Factura> leer() throws Exception{
        List<Factura> listaFactura = new ArrayList<>();
        try {
            listaFactura = FacturaDatos.leerFactura();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaFactura;
    }
    public String IngresarFactura(Factura pFactura) throws Exception{
        String respuesta = "Error";
        try {
            if (pFactura.getNumeroFactura() <= 0){
                throw new Exception("El numero de factura no puede ser meno o igual a 0");
            }
            if (String.valueOf(pFactura.getNumeroFactura()).isEmpty()){
                throw new Exception("El numero de factura no puede estar vacío");
            }
            if (pFactura.getCliente().isEmpty()){
                throw new Exception("El cliente no puede estar vacío");
            }
            if (pFactura.getCliente().length() < 3){
                throw new Exception("Nombre cliente demasiado corto");
            }
            if (pFactura.getEmpleado().isEmpty()){
                throw new Exception("El empleado no puede estar vacío");
            }
            if (pFactura.getEmpleado().length() < 3){
                throw new Exception("Nombre empleado demasiado corto");
            }
            if (String.valueOf(pFactura.getFecha()).isEmpty()){
                throw new Exception("Fecha no puede estar vacía");
            }
            if (pFactura.getFecha().getYear() > 2021){
                throw new Exception("Fecha ingresada invalida");
            }
            if (pFactura.getProducto().isEmpty()){
                throw new Exception("El producto no puede estar vacío");
            }
            if (pFactura.getProducto().length() < 4){
                throw new Exception("Nombre de producto demasiado corto");
            }
            if (String.valueOf(pFactura.getCantidad()).isEmpty()){
                throw new Exception("Cantidad de producto no puede estar vacío");
            }
            if (pFactura.getCantidad() <= 0){
                throw new Exception("Cantidad de producto no puede ser menor o igual a 0");
            }
            if (String.valueOf(pFactura.getSubTotal()).isEmpty()){
                throw new Exception("SubTotal no puede estar vacío");
            }
            if (pFactura.getSubTotal() < 0){
                throw new Exception("SubTotal no puede ser menor que 0");
            }
            if (pFactura.getISV() < 0){
                throw new Exception("El ISV no puede ser menor a 0");
            }
            if (String.valueOf(pFactura.getISV()).isEmpty()){
                throw new Exception("El valor del ISV no puede estar vacío");
            }
            if (String.valueOf(pFactura.getTotalPagar()).isEmpty()){
                throw new Exception("Total a pagar no puede estar vacio");
            }
            if (pFactura.getTotalPagar() < 0){
                throw new Exception("El total a pagar no puede ser menor a 0");
            }
            respuesta = FacturaDatos.IngresarFactura(pFactura);
            if (respuesta == null){
                respuesta = "Guardado Exitosamente";
            }
        } catch (Exception e) {
            respuesta = e.getMessage();
        } finally {
            return respuesta;
        }
    }
    public void Actualizar(Factura pFactura) throws Exception{
        try {
            if (pFactura.getNumeroFactura() <= 0){
                throw new Exception("El numero de factura no puede ser meno o igual a 0");
            }
            if (String.valueOf(pFactura.getNumeroFactura()).isEmpty()){
                throw new Exception("El numero de factura no puede estar vacío");
            }
            if (pFactura.getCliente().isEmpty()){
                throw new Exception("El cliente no puede estar vacío");
            }
            if (pFactura.getCliente().length() < 3){
                throw new Exception("Nombre cliente demasiado corto");
            }
            if (pFactura.getEmpleado().isEmpty()){
                throw new Exception("El empleado no puede estar vacío");
            }
            if (pFactura.getEmpleado().length() < 3){
                throw new Exception("Nombre empleado demasiado corto");
            }
            if (String.valueOf(pFactura.getFecha()).isEmpty()){
                throw new Exception("Fecha no puede estar vacía");
            }
            if (pFactura.getFecha().getYear() > 2021){
                throw new Exception("Fecha ingresada invalida");
            }
            if (pFactura.getProducto().isEmpty()){
                throw new Exception("El producto no puede estar vacío");
            }
            if (pFactura.getProducto().length() < 4){
                throw new Exception("Nombre de producto demasiado corto");
            }
            if (String.valueOf(pFactura.getCantidad()).isEmpty()){
                throw new Exception("Cantidad de producto no puede estar vacío");
            }
            if (pFactura.getCantidad() <= 0){
                throw new Exception("Cantidad de producto no puede ser menor o igual a 0");
            }
            if (String.valueOf(pFactura.getSubTotal()).isEmpty()){
                throw new Exception("SubTotal no puede estar vacío");
            }
            if (pFactura.getSubTotal() < 0){
                throw new Exception("SubTotal no puede ser menor que 0");
            }
            if (pFactura.getISV() < 0){
                throw new Exception("El ISV no puede ser menor a 0");
            }
            if (String.valueOf(pFactura.getISV()).isEmpty()){
                throw new Exception("El valor del ISV no puede estar vacío");
            }
            if (String.valueOf(pFactura.getTotalPagar()).isEmpty()){
                throw new Exception("Total a pagar no puede estar vacio");
            }
            if (pFactura.getTotalPagar() < 0){
                throw new Exception("El total a pagar no puede ser menor a 0");
            }
            FacturaDatos.ActualizarFactura(pFactura);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public void Eliminar(Factura pFactura)throws Exception{
        try {
            if (pFactura.getNumeroFactura() <= 0){
                throw new Exception("El numero de factura no puede ser meno o igual a 0");
            }
            if (String.valueOf(pFactura.getNumeroFactura()).isEmpty()){
                throw new Exception("El numero de factura no puede estar vacío");
            }
            FacturaDatos.EliminarFactura(pFactura);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public List<Factura> Buscar(Factura pFactura) throws Exception{
        List<Factura> listaFactura = new ArrayList<>();
        try {
            if (pFactura.getNumeroFactura() <= 0){
                throw new Exception("El numero de factura no puede ser meno o igual a 0");
            }
            if (String.valueOf(pFactura.getNumeroFactura()).isEmpty()){
                throw new Exception("El numero de factura no puede estar vacío");
            }
            listaFactura = FacturaDatos.BuscarFactura(pFactura);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaFactura;
    }
}
