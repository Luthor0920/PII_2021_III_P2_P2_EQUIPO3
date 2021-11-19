package recursos.clases;


import java.util.Date;

public class Factura {
    private long   NumeroFactura;
    private String Cliente;
    private String Empleado;
    private Date   Fecha;
    private String Producto; //Produccion
    private int    Cantidad;
    private double SubTotal;
    private double ISV;
    private double TotalPagar;

    public Factura(){}

    public Factura(long pNumeroFactura, String pCliente, String pEmpleado, Date pFecha, String pProducto, int pCantidad,
                   double pSubTotal, double pISV, double pTotalPagar){
        this.NumeroFactura = pNumeroFactura;
        this.Cliente       = pCliente;
        this.Empleado      = pEmpleado;
        this.Fecha         = pFecha;
        this.Producto      = pProducto;
        this.Cantidad      = pCantidad;
        this.SubTotal      = pSubTotal;
        this.ISV           = pISV;
        this.TotalPagar    = pTotalPagar;
    }
    public long getNumeroFactura() {
        return NumeroFactura;
    }
    public void setNumeroFactura(long numeroFactura) {
        this.NumeroFactura = numeroFactura;
    }
    public String getCliente() {
        return Cliente;
    }
    public void setCliente(String cliente) {
        this.Cliente = cliente;
    }
    public String getEmpleado() {
        return Empleado;
    }
    public void setEmpleado(String empleado) {
        this.Empleado = empleado;
    }
    public Date getFecha() {
        return Fecha;
    }
    public void setFecha(Date fecha) {
        this.Fecha = fecha;
    }
    public String getProducto() {
        return Producto;
    }
    public void setProducto(String producto) {
        this.Producto = producto;
    }
    public int getCantidad() {
        return Cantidad;
    }
    public void setCantidad(int cantidad) {
        this.Cantidad = cantidad;
    }
    public double getSubTotal() {
        return SubTotal;
    }
    public void setSubTotal(double subTotal) {
        this.SubTotal = subTotal;
    }
    public double getISV() {
        return ISV;
    }
    public void setISV(double ISV) {
        this.ISV = ISV;
    }
    public double getTotalPagar() {
        return TotalPagar;
    }
    public void setTotalPagar(double totalPagar) {
        this.TotalPagar = totalPagar;
    }
}
