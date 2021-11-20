package negocio.clases;

import datos.clasesDatos.ProduccionDatos;
import recursos.clases.Produccion;

import java.util.ArrayList;
import java.util.List;

public class ProduccionNegocio {
    public List<Produccion> leer() throws Exception {
        List<Produccion> listaProduccion = new ArrayList<>();
        try{
            listaProduccion = ProduccionDatos.leerProduccion();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaProduccion;
    }
    public String InsertarProduccion(Produccion pProduccion) throws Exception{
        String respuesta = "Error";
        try{
            if (pProduccion.getCodigoPrenda() <= 0){
                throw new Exception("El valor del codigo de prenda no puede ser menor o igual a 0");
            }
            if (String.valueOf(pProduccion.getCodigoPrenda()).isEmpty()){
                throw new Exception("El valor del codigo prenda no puede estar vacio");
            }
            if (pProduccion.getCodigoLote() <= 0){
                throw new Exception("El valor del codigo de lote no puede ser menor o igual a 0");
            }
            if (String.valueOf(pProduccion.getCodigoLote()).isEmpty()){
                throw new Exception("El valor codigo lote no puede estar vacío");
            }
            if (pProduccion.getTipoPrenda().isEmpty()){
                throw new Exception("El valor tipo de prenda no puede estar vacío");
            }
            if (pProduccion.getDiseñoPrenda().isEmpty()){
                throw new Exception("El valor doseño de prenda no puede estar vacío");
            }
            if (pProduccion.getCantidadPrenda() <= 0){
                throw new Exception("La cantidad no puede ser menor o igual a 0");
            }
            if (String.valueOf(pProduccion.getCantidadPrenda()).isEmpty()){
                throw new Exception("La cantidad de prendas no puede estar vacío");
            }
            if (pProduccion.getTallaPrenda().isEmpty()){
                throw new Exception("El valor de la talla no puede estar vacío");
            }
            if (!(pProduccion.getTallaPrenda().equalsIgnoreCase("XXS, XS, S, M, L, XL, XXL, XXXL"))){
                throw new Exception("El valor de la talla debe ser XXS, XS, S, M, L, XL, XXL o XXXL");
            }
            if (String.valueOf(pProduccion.getCostoPrenda()).isEmpty()){
                throw new Exception("El costo de la prenda no puede estar vacío");
            }
            if (pProduccion.getCostoPrenda() <= 0){
                throw new Exception("El costo de la prenda no puede ser menor o igual a 0");
            }
            respuesta = ProduccionDatos.InsertarProduccion(pProduccion);
            if (respuesta == null){
                respuesta = "Guardado Exitosamente";
            }
        }catch (Exception e){
            respuesta = e.getMessage();
        }
        finally {
            return respuesta;
        }
    }
    public void Actualizar(Produccion pProduccion) throws Exception{
        String respuesta = "Error";
        try{
            if (pProduccion.getCodigoPrenda() <= 0){
                throw new Exception("El valor del codigo de prenda no puede ser menor o igual a 0");
            }
            if (String.valueOf(pProduccion.getCodigoPrenda()).isEmpty()){
                throw new Exception("El valor del codigo prenda no puede estar vacio");
            }
            if (pProduccion.getCodigoLote() <= 0){
                throw new Exception("El valor del codigo de lote no puede ser menor o igual a 0");
            }
            if (String.valueOf(pProduccion.getCodigoLote()).isEmpty()){
                throw new Exception("El valor codigo lote no puede estar vacío");
            }
            if (pProduccion.getTipoPrenda().isEmpty()){
                throw new Exception("El valor tipo de prenda no puede estar vacío");
            }
            if (pProduccion.getDiseñoPrenda().isEmpty()){
                throw new Exception("El valor doseño de prenda no puede estar vacío");
            }
            if (pProduccion.getCantidadPrenda() <= 0){
                throw new Exception("La cantidad no puede ser menor o igual a 0");
            }
            if (String.valueOf(pProduccion.getCantidadPrenda()).isEmpty()){
                throw new Exception("La cantidad de prendas no puede estar vacío");
            }
            if (pProduccion.getTallaPrenda().isEmpty()){
                throw new Exception("El valor de la talla no puede estar vacío");
            }
            if (!(pProduccion.getTallaPrenda().equalsIgnoreCase("XXS, XS, S, M, L, XL, XXL, XXXL"))){
                throw new Exception("El valor de la talla debe ser XXS, XS, S, M, L, XL, XXL o XXXL");
            }
            if (String.valueOf(pProduccion.getCostoPrenda()).isEmpty()){
                throw new Exception("El costo de la prenda no puede estar vacío");
            }
            if (pProduccion.getCostoPrenda() <= 0){
                throw new Exception("El costo de la prenda no puede ser menor o igual a 0");
            }
            respuesta = ProduccionDatos.ActualizarProduccion(pProduccion);
            if (respuesta == null){
                respuesta = "Guardado Exitosamente";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void Eliminar(Produccion pProduccion) throws Exception{
        try{
            if (String.valueOf(pProduccion.getCodigoPrenda()).isEmpty()) {
                throw new Exception("Error: El codigo de prenda no debe estar vacio.");
            }
            if (pProduccion.getCodigoPrenda() <= 0) {
                throw new Exception("Error: Indique el codigo correctamente.");
            }
            ProduccionDatos.EliminarProduccion(pProduccion);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public List<Produccion> Buscar(Produccion pProduccion) throws Exception{
        List<Produccion> listaProduccion = new ArrayList<>();
        try{
            if (String.valueOf(pProduccion.getCodigoPrenda()).isEmpty()) {
                throw new Exception("Error: El codigo de prenda no debe estar vacio.");
            }
            if (pProduccion.getCodigoPrenda() <= 0) {
                throw new Exception("Error: Indique el codigo correctamente.");
            }
            ProduccionDatos.BuscarProduccion(pProduccion);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaProduccion;
    }
}
