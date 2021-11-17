package recursos.clases;


public class Factura {
    private long NumeroFactura;
    private int Cantidad;
    private double TotalPagar;

    public Factura(){}

    public Factura(long pNumeroFactura, int pCantidad, double pTotalPagar){
        this.NumeroFactura = pNumeroFactura;
        this.Cantidad      = pCantidad;
        this.TotalPagar    = pTotalPagar;
    }
    public long getNumeroFactura() {
        return NumeroFactura;
    }
    public void setNumeroFactura(long numeroFactura) {
        this.NumeroFactura = numeroFactura;
    }
    public int getCantidad() {
        return Cantidad;
    }
    public void setCantidad(int cantidad) {
        this.Cantidad = cantidad;
    }
    public double getTotalPagar() {
        return TotalPagar;
    }
    public void setTotalPagar(double totalPagar) {
        this.TotalPagar = totalPagar;
    }
}
