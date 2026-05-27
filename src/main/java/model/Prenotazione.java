package model;

import java.util.Date;
import java.sql.Time;

public class Prenotazione {
    private int idPrenotazione;
    private Date data;
    private Time orarioInizio;
    private Time orarioFine;
    private String stato;
    private Cliente cliente;
    private Corso corso;
    private Pagamento pagamento;

    public Prenotazione(int idPrenotazione, Date data, Time orarioInizio, Time orarioFine, String stato,
                        Cliente cliente, Corso corso, Pagamento pagamento) {
        this.idPrenotazione = idPrenotazione;
        this.data = data;
        this.orarioInizio = orarioInizio;
        this.orarioFine = orarioFine;
        this.stato = stato;
        this.cliente = cliente;
        this.corso = corso;
        this.pagamento = pagamento;
    }

    public int getIdPrenotazione() { return idPrenotazione; }
    public void setIdPrenotazione(int idPrenotazione) { this.idPrenotazione = idPrenotazione; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }

    public Time getOrarioInizio() { return orarioInizio; }
    public void setOrarioInizio(Time orarioInizio) { this.orarioInizio = orarioInizio; }

    public Time getOrarioFine() { return orarioFine; }
    public void setOrarioFine(Time orarioFine) { this.orarioFine = orarioFine; }

    public String getStato() { return stato; }
    public void setStato(String stato) { this.stato = stato; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Corso getCorso() { return corso; }
    public void setCorso(Corso corso) { this.corso = corso; }

    public Pagamento getPagamento() { return pagamento; }
    public void setPagamento(Pagamento pagamento) { this.pagamento = pagamento; }

    public void crea() { System.out.println("Prenotazione salvata."); }
    
    public void modifica(Date nuovaData, Time nuovoInizio, Time nuovoFine) {
        this.data = nuovaData;
        this.orarioInizio = nuovoInizio;
        this.orarioFine = nuovoFine;
    }

    public void cancella() {
        this.stato = "CANCELLATA";
    }

    public boolean verificaDisponibilita() {
        return true;
    }
}
