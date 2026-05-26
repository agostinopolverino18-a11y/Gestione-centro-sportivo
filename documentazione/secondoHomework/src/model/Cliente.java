package model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.sql.Time;

public class Cliente extends Utente {
    private int idCliente;
    private String indirizzo;
    private Date dataNascita;
    private String telefono;
    private String statoAbbonamento;
    private List<Prenotazione> prenotazioni;

    public Cliente(int idUtente, String nome, String email, String password, Date dataRegistrazione,
                   int idCliente, String indirizzo, Date dataNascita, String telefono, String statoAbbonamento) {
        super(idUtente, nome, email, password, dataRegistrazione);
        this.idCliente = idCliente;
        this.indirizzo = indirizzo;
        this.dataNascita = dataNascita;
        this.telefono = telefono;
        this.statoAbbonamento = statoAbbonamento;
        this.prenotazioni = new ArrayList<>();
    }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getIndirizzo() { return indirizzo; }
    public void setIndirizzo(String indirizzo) { this.indirizzo = indirizzo; }

    public Date getDataNascita() { return dataNascita; }
    public void setDataNascita(Date dataNascita) { this.dataNascita = dataNascita; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getStatoAbbonamento() { return statoAbbonamento; }
    public void setStatoAbbonamento(String statoAbbonamento) { this.statoAbbonamento = statoAbbonamento; }

    public List<Corso> visualizzaCorsi() {
        return new ArrayList<>(); 
    }

    public Prenotazione effettuaPrenotazione(Corso corso, Date data, Time ora) {
        Prenotazione nuova = new Prenotazione(this.prenotazioni.size() + 1, data, ora, ora, "CONFERMATA", this, corso, null);
        this.prenotazioni.add(nuova);
        return nuova;
    }

    public List<Prenotazione> visualizzaPrenotazioni() {
        return this.prenotazioni;
    }

    public void aggiornaProfilo() {
        System.out.println("Profilo del cliente " + getNome() + " aggiornato con successo.");
    }
}
