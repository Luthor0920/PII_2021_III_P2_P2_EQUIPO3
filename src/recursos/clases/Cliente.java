package recursos.clases;

public class Cliente{
    private long   Codigo;
    private long   DNI;
    private String Nombre;
    private String TipoCliente;
    private String Ocupacion;
    private String Recurrencia;
    private String TallaCamisa;
    private int    TallaPantalon;
    private String Referencia;

    public Cliente(){}

    public Cliente(long pCodigo, long pDNI, String pNombre, String pTipoCliente, String pOcupacion,
                   String pRecurrencia, String pTallaCamisa, int pTallaPantalon, String pReferencia){
        this.Codigo        = pCodigo;
        this.DNI           = pDNI;
        this.Nombre        = pNombre;
        this.TipoCliente   = pTipoCliente;
        this.Ocupacion     = pOcupacion;
        this.Recurrencia   = pRecurrencia;
        this.TallaCamisa   = pTallaCamisa;
        this.TallaPantalon = pTallaPantalon;
        this.Referencia    = pReferencia;
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
    public String getTipoCliente() {
        return TipoCliente;
    }
    public void setTipoCliente(String tipoCliente) {
        this.TipoCliente = tipoCliente;
    }
    public String getOcupacion() {
        return Ocupacion;
    }
    public void setOcupacion(String ocupacion) {
        this.Ocupacion = ocupacion;
    }
    public String getRecurrencia() {
        return Recurrencia;
    }
    public void setRecurrencia(String recurrencia) {
        this.Recurrencia = recurrencia;
    }
    public String getTallaCamisa() {
        return TallaCamisa;
    }
    public void setTallaCamisa(String tallaCamisa) {
        this.TallaCamisa = tallaCamisa;
    }
    public int getTallaPantalon() {
        return TallaPantalon;
    }
    public void setTallaPantalon(int tallaPantalon) {
        this.TallaPantalon = tallaPantalon;
    }
    public String getReferencia() {
        return Referencia;
    }
    public void setReferencia(String referencia) {
        this.Referencia = referencia;
    }
}
