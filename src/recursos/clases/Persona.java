package recursos.clases;

import java.util.Date;

public class Persona {
    private long DNI;
    private String Nombre;
    private Date FechaNacimiento;
    private String Direccion;
    private long Telefono;
    private String Correo;
    private int Edad;

    public Persona(){}

    public Persona(long pDNI, String pNombre, Date pFechaNacimiento, String pDireccion, long pTelefono,
                   String pCorreo, int pEdad){
        this.DNI             = pDNI;
        this.Nombre          = pNombre;
        this.FechaNacimiento = pFechaNacimiento;
        this.Direccion       = pDireccion;
        this.Telefono        = pTelefono;
        this.Correo          = pCorreo;
        this.Edad            = pEdad;
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
    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.FechaNacimiento = fechaNacimiento;
    }
    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String direccion) {
        this.Direccion = direccion;
    }
    public long getTelefono() {
        return Telefono;
    }
    public void setTelefono(long telefono) {
        this.Telefono = telefono;
    }
    public String getCorreo() {
        return Correo;
    }
    public void setCorreo(String correo) {
        this.Correo = correo;
    }
    public int getEdad() {
        return Edad;
    }
    public void setEdad(int edad) {
        this.Edad = edad;
    }
}
