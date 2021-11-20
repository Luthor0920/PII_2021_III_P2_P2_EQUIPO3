package recursos.clases;

public class Item {
    private long Codigo;
    private String Nombre;

    public Item(long pCodigo, String pNombre) {
        this.Codigo = pCodigo;
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

    @Override
    public String toString() {
        return Nombre;
    }
}
