package recursos.clases;

public class Produccion {
    private long CodigoPrenda;
    private long CodigoLote;
    private String TipoPrenda;
    private String DiseñoPrenda;
    private int CantidadPrenda;
    private String TallaPrenda;
    private double CostoPrenda;

    public Produccion(){}
    public Produccion (long pCodigoPrenda, long pCodigoLote, String pTipoPrenda, String pDiseñoPrenda,
                       int pCantidadPrenda, String pTallaPrenda, double pCostoPrenda){
        this.CodigoPrenda = pCodigoPrenda;
        this.CodigoLote   = pCodigoLote;
        this.TipoPrenda   = pTipoPrenda;
        this.DiseñoPrenda = pDiseñoPrenda;
        this.CantidadPrenda  = pCantidadPrenda;
        this.TallaPrenda  = pTallaPrenda;
        this.CostoPrenda  = pCostoPrenda;
    }
    public long getCodigoPrenda() {
        return CodigoPrenda;
    }
    public void setCodigoPrenda(long codigoPrenda) {
        this.CodigoPrenda = codigoPrenda;
    }
    public long getCodigoLote() {
        return CodigoLote;
    }
    public void setCodigoLote(long codigoLote) {
        this.CodigoLote = codigoLote;
    }
    public String getTipoPrenda() {
        return TipoPrenda;
    }
    public void setTipoPrenda(String tipoPrenda) {
        this.TipoPrenda = tipoPrenda;
    }
    public String getDiseñoPrenda() {
        return DiseñoPrenda;
    }
    public void setDiseñoPrenda(String diseñoPrenda) {
        this.DiseñoPrenda = diseñoPrenda;
    }
    public int getCantidadPrenda() {
        return CantidadPrenda;
    }
    public void setCantidadPrenda(int cantidadPrenda) {
        this.CantidadPrenda = cantidadPrenda;
    }
    public String getTallaPrenda() {
        return TallaPrenda;
    }
    public void setTallaPrenda(String tallaPrenda) {
        this.TallaPrenda = tallaPrenda;
    }
    public double getCostoPrenda() {
        return CostoPrenda;
    }
    public void setCostoPrenda(double costoPrenda) {
        this.CostoPrenda = costoPrenda;
    }
}
