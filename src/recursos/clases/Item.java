package recursos.clases;

public class Item {
    private long Codigo;
    private String Nombre;
    private double Precio;

    public Item(long pCodigo, String pNombre) {
        this.Codigo = pCodigo;
        this.Nombre = pNombre;
    }

    public Item(double pPrecio, String pNombre) {
        this.Precio = pPrecio;
        this.Nombre = pNombre;
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
    public double getPrecio() {
        return Precio;
    }
    public void setPrecio(double precio) {
        this.Precio = precio;
    }

    @Override
    public String toString() {
        return Nombre;
    }
}
