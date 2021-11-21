package negocio.clases;

import datos.clasesDatos.PuestoDatos;
import recursos.clases.Puesto;

import java.util.ArrayList;
import java.util.List;

public class PuestoNegocio {
    public List<Puesto> leer() throws Exception{
        List<Puesto> listaPuesto = new ArrayList<>();
        try{
            listaPuesto = PuestoDatos.leerPuesto();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaPuesto;
    }
    public String InsertarPuesto(Puesto pPuesto) throws Exception{
        String respuesta = "Error";
        try{
            if (pPuesto.getCodigo() <= 0) {
                throw new Exception("Error: El codigo no debe ser menor o igual a 0");
            }
            if (String.valueOf(pPuesto.getCodigo()).isEmpty()){
                throw new Exception("Error: El valor del codigo no debe estar vacío");
            }
            if(pPuesto.getNombre().isEmpty()){
                throw new Exception("Error: El valor Nombre no debe estar vacío");
            }
            if (pPuesto.getNombre().length() < 3){
                throw new Exception("Error: Nombre demasiado corto");
            }
            if (String.valueOf(pPuesto.getNumeroEstaciones()).isEmpty()){
                throw new Exception("Error: El valor número de estaciones no debe estar vacío");
            }
            if (pPuesto.getNumeroEstaciones() <= 0){
                throw new Exception("Error: El número de estaciones no puede ser menor o igual a 0");
            }
            if (pPuesto.getEstudioMinimo().isEmpty()){
                throw new Exception("Error: Estudio minimo no puede estar vacío");
            }
            if (pPuesto.getEstudioMinimo().length() <= 3){
                throw new Exception("Error: Valor de Estudio minimo demasiado corto");
            }
            if (pPuesto.getCantidadEmpleados() <= 0){
                throw new Exception("Error: La cantidad de empleados no puede ser menor o igual a 0");
            }
            if (pPuesto.getFechaInicio().toString().isEmpty()){
                throw new Exception("Error: La Fecha de inicio no puede estar vacía");
            }
            if (pPuesto.getFechaInicio().getYear() > 2021){
                throw new Exception("Error: Fecha ingresada invalida");
            }
            if (pPuesto.getUniforme().isEmpty()){
                throw new Exception("Error: El valor uniforme no puede estar vacío");
            }
            if (pPuesto.getUniforme().length() > 2){
                throw new Exception("Error: Valor de uniforme ingresado invalido");
            }
            respuesta = PuestoDatos.InsertarPuesto(pPuesto);
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
    public void Actualizar(Puesto pPuesto) throws Exception{
        try {
            if (pPuesto.getCodigo() <= 0) {
                throw new Exception("Error: El codigo no debe ser menor o igual a 0");
            }
            if (String.valueOf(pPuesto.getCodigo()).isEmpty()){
                throw new Exception("Error: El valor del codigo no debe estar vacío");
            }
            if(pPuesto.getNombre().isEmpty()){
                throw new Exception("Error: El valor Nombre no debe estar vacío");
            }
            if (pPuesto.getNombre().length() < 3){
                throw new Exception("Error: Nombre demasiado corto");
            }
            if (String.valueOf(pPuesto.getNumeroEstaciones()).isEmpty()){
                throw new Exception("Error: El valor número de estaciones no debe estar vacío");
            }
            if (pPuesto.getNumeroEstaciones() <= 0){
                throw new Exception("Error: El número de estaciones no puede ser menor o igual a 0");
            }
            if (pPuesto.getEstudioMinimo().isEmpty()){
                throw new Exception("Error: Estudio minimo no puede estar vacío");
            }
            if (pPuesto.getEstudioMinimo().length() <= 3){
                throw new Exception("Error: Valor de Estudio minimo demasiado corto");
            }
            if (pPuesto.getCantidadEmpleados() <= 0){
                throw new Exception("Error: La cantidad de empleados no puede ser menor o igual a 0");
            }
            if (pPuesto.getFechaInicio().toString().isEmpty()){
                throw new Exception("Error: La Fecha de inicio no puede estar vacía");
            }
            if (pPuesto.getFechaInicio().getYear() > 2021){
                throw new Exception("Error: Fecha ingresada invalida");
            }
            if (pPuesto.getUniforme().isEmpty()){
                throw new Exception("Error: El valor uniforme no puede estar vacío");
            }
            if (pPuesto.getUniforme().length() > 2){
                throw new Exception("Error: Valor de uniforme ingresado invalido");
            }
            PuestoDatos.ActualizarPuesto(pPuesto);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void Eliminar(Puesto pPuesto) throws Exception{
        try {
            if (pPuesto.getCodigo() <= 0) {
                throw new Exception("El codigo no debe ser menor o igual a 0");
            }
            if (String.valueOf(pPuesto.getCodigo()).isEmpty()) {
                throw new Exception("El valor del codigo no debe estar vacío");
            }
            PuestoDatos.EliminarPuesto(pPuesto);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public List<Puesto> Buscar(Puesto pPuesto) throws Exception{
        List<Puesto> listaPuesto = new ArrayList<>();
        try{
            if(pPuesto.getNombre().isEmpty()){
                throw new Exception("Error: El valor Nombre no debe estar vacío");
            }
            if (pPuesto.getNombre().length() < 3){
                throw new Exception("Error: Nombre demasiado corto");
            }
            listaPuesto = PuestoDatos.BuscarPuesto(pPuesto);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaPuesto;
    }
}
