package recursos.clases;

import java.util.Date;

public class Maquila {
    private long Codigo;
    private String Nombre;
    private String Direccion;
    private Date FechaInicio;
    private long Telefono;
    private String Correo;
    private int CantidadEmpleados;

    public Maquila(){}

    public Maquila(long pCodigo, String pNombre, String pDireccion, Date pFechaInicio, long pTelefono,
                   String pCorreo, int pCantidadEmpleados){
        this.Codigo            = pCodigo;
        this.Nombre            = pNombre;
        this.Direccion         = pDireccion;
        this.FechaInicio       = pFechaInicio;
        this.Telefono          = pTelefono;
        this.Correo            = pCorreo;
        this.CantidadEmpleados = pCantidadEmpleados;
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
    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String direccion) {
        this.Direccion = direccion;
    }
    public Date getFechaInicio() {
        return FechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.FechaInicio = fechaInicio;
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
    public int getCantidadEmpleados() {
        return CantidadEmpleados;
    }
    public void setCantidadEmpleados(int cantidadEmpleados) {
        this.CantidadEmpleados = cantidadEmpleados;
    }
}
