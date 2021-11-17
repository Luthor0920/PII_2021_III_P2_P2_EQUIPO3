package recursos.clases;

import java.util.Date;

public class Cliente extends Persona{
    private long Codigo;
    private String TipoCliente;
    private String Ocupacion;
    private String Recurrencia;
    private String TallaCamisa;
    private int TallaPantalon;
    private String Referencia;

    public Cliente(){
        super();
    }

    public Cliente(long pDNI, String pNombre, Date pFechaNacimiento, String pDireccion, long pTelefono,
                   String pCorreo, int pEdad, long pCodigo, String pTipoCliente, String pOcupacion,
                   String pRecurrencia, String pTallaCamisa, int pTallaPantalon, String pReferencia){
        super(pDNI, pNombre, pFechaNacimiento, pDireccion, pTelefono, pCorreo, pEdad);
        this.Codigo        = pCodigo;
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
