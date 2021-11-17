package recursos.clases;

import java.util.Date;

public class Proveedor {
    private long Codigo;
    private String Nombre;
    private String Direccion;
    private long Telefono;
    private Date FechaInicio;
    private String Correo;
    private String TipoProveedor;

    public Proveedor(){}

    public Proveedor(long pCodigo, String pNombre, String pDireccion, long pTelefono, Date pFechaInicio,
                     String pCorreo, String pTipoProveedor){
        this.Codigo        = pCodigo;
        this.Nombre        = pNombre;
        this.Direccion     = pDireccion;
        this.Telefono      = pTelefono;
        this.FechaInicio   = pFechaInicio;
        this.Correo        = pCorreo;
        this.TipoProveedor = pTipoProveedor;
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
    public long getTelefono() {
        return Telefono;
    }
    public void setTelefono(long telefono) {
        this.Telefono = telefono;
    }
    public Date getFechaInicio() {
        return FechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.FechaInicio = fechaInicio;
    }
    public String getCorreo() {
        return Correo;
    }
    public void setCorreo(String correo) {
        this.Correo = correo;
    }
    public String getTipoProveedor() {
        return TipoProveedor;
    }
    public void setTipoProveedor(String tipoProveedor) {
        this.TipoProveedor = tipoProveedor;
    }
}
