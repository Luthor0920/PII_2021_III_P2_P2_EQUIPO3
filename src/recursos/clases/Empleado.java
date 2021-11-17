package recursos.clases;

import java.util.Date;

public class Empleado extends Persona {
    //private Area Area;
    private long Codigo;
    private String Puesto;
    private double Sueldo;
    private Date FechaIngreso;
    private String NivelAcademico;

    public Empleado (){
        super();
    }
    public Empleado (long pDNI, String pNombre, Date pFechaNacimiento, String pDireccion, long pTelefono,
                     String pCorreo, int pEdad, long pCodigo, String pPuesto, double pSueldo, Date pFechaIngreso,
                     String pNivelAcademico){
        super(pDNI, pNombre, pFechaNacimiento, pDireccion, pTelefono, pCorreo, pEdad);
        this.Codigo         = pCodigo;
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
