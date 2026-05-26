package model;

import java.util.Date;

public class Pagamento {
    private int idPagamento;
    private Date dataPagamento;
    private double importo;
    private String metodo;
    private String stato;
    private String transazioneId;

    public Pagamento(int idPagamento, Date dataPagamento, double importo, String metodo, String stato, String transazioneId) {
        this.idPagamento = idPagamento;
        this.dataPagamento = dataPagamento;
        this.importo = importo;
        this.metodo = metodo;
        this.stato = stato;
        this.transazioneId = transazioneId;
    }

    public int getIdPagamento() { return idPagamento; }
    public void setIdPagamento(int idPagamento) { this.idPagamento = idPagamento; }

    public Date getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(Date dataPagamento) { this.dataPagamento = dataPagamento; }

    public double getImporto() { return importo; }
    public void setImporto(double importo) { this.importo = importo; }

    public String getMetodo() { return metodo; }
    public void setMetodo(String metodo) { this.metodo = metodo; }

    public String getStato() { return stato; }
    public void setStato(String stato) { this.stato = stato; }

    public String getTransazioneId() { return transazioneId; }
    public void setTransazioneId(String transazioneId) { this.transazioneId = transazioneId; }

    public boolean effettuaPagamento() {
        this.stato = "COMPLETATO";
        return true;
    }

    public void annullaPagamento() {
        this.stato = "ANNULLATO";
    }

    public String visualizzaRicevuta() {
        return "Ricevuta ID: " + transazioneId + " - Importo: €" + importo;
    }
}
