package recursos.clases;

import java.util.Date;

public class Empleado{
    private long   Codigo;
    private long   DNI;
    private String Nombre;
    private String Puesto;
    private double Sueldo;
    private Date   FechaIngreso;
    private String NivelAcademico;

    public Empleado (){
    }
    public Empleado (long pCodigo, long pDNI, String pNombre, String pPuesto, double pSueldo, Date pFechaIngreso,
                     String pNivelAcademico){
        this.Codigo         = pCodigo;
        this.DNI            = pDNI;
        this.Nombre         = pNombre;
        this.Puesto         = pPuesto;
        this.Sueldo         = pSueldo;
        this.FechaIngreso   = pFechaIngreso;
        this.NivelAcademico = pNivelAcademico;
    }
    public long getCodigo() {
        return Codigo;
    }
    public void setCodigo(long codigo) {
        this.Codigo = codigo;
    }
    public long getDNI() {
        return DNI;
    }
    public void setDNI(long DNI) {
        this.DNI = DNI;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public String getPuesto() {
        return Puesto;
    }
    public void setPuesto(String puesto) {
        this.Puesto = puesto;
    }
    public double getSueldo() {
        return Sueldo;
    }
    public void setSueldo(double sueldo) {
        this.Sueldo = sueldo;
    }
    public Date getFechaIngreso() {
        return FechaIngreso;
    }
    public void setFechaIngreso(Date fechaIngreso) {
        this.FechaIngreso = fechaIngreso;
    }
    public String getNivelAcademico() {
        return NivelAcademico;
    }
    public void setNivelAcademico(String nivelAcademico) {
        this.NivelAcademico = nivelAcademico;
    }
}
