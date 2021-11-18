package recursos.clases;

import java.util.Date;

public class Puesto {
    private long Codigo;
    private String Nombre;
    private int NumeroEstaciones; //Cuantas fases tiene ese puesto
    private String EstudioMinimo;
    private int CantidadEmpleados;
    private Date FechaInicio;
    private String Uniforme; //Si o No

    public Puesto(){
    }
    public Puesto(long pCodigo, String pNombre, int pNumeroEstaciones, String pEstudioMinimo, int pCantidadEmpleados,
                  Date pFechaInicio, String pUniforme){
        this.Codigo            = pCodigo;
        this.Nombre            = pNombre;
        this.NumeroEstaciones  = pNumeroEstaciones;
        this.EstudioMinimo     = pEstudioMinimo;
        this.CantidadEmpleados = pCantidadEmpleados;
        this.FechaInicio       = pFechaInicio;
        this.Uniforme          = pUniforme;
    }
    public long getCodigo() {
        return Codigo;
    }
    public void setCodigo(long codigo) {
        this.Codigo = codigo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public int getNumeroEstaciones() {
        return NumeroEstaciones;
    }
    public void setNumeroEstaciones(int numeroEstaciones) {
        this.NumeroEstaciones = numeroEstaciones;
    }
    public String getEstudioMinimo() {
        return EstudioMinimo;
    }
    public void setEstudioMinimo(String estudioMinimo) {
        this.EstudioMinimo = estudioMinimo;
    }
    public int getCantidadEmpleados() {
        return CantidadEmpleados;
    }
    public void setCantidadEmpleados(int cantidadEmpleados) {
        this.CantidadEmpleados = cantidadEmpleados;
    }
    public Date getFechaInicio() {
        return FechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.FechaInicio = fechaInicio;
    }
    public String getUniforme() {
        return Uniforme;
    }
    public void setUniforme(String uniforme) {
        this.Uniforme = uniforme;
    }
}
