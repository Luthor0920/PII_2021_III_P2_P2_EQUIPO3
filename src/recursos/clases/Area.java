package recursos.clases;

public class Area {
    private long Codigo;
    private String Descripcion;

    public Area(){
    }
    public Area(long pCodigo, String pDescripcion){
        this.Codigo      = pCodigo;
        this.Descripcion = pDescripcion;
    }
    public long getCodigo() {
        return Codigo;
    }
    public void setCodigo(long codigo) {
        this.Codigo = codigo;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }
}
