package model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Istruttore extends Utente {
    private int idIstruttore;
    private String specializzazione;
    private Date dataAssunzione;
    private String qualifica;
    private double salario;
    private List<Corso> corsiAssegnati;

    public Istruttore(int idUtente, String nome, String email, String password, Date dataRegistrazione,
                      int idIstruttore, String specializzazione, Date dataAssunzione, String qualifica, double salario) {
        super(idUtente, nome, email, password, dataRegistrazione);
        this.idIstruttore = idIstruttore;
        this.specializzazione = specializzazione;
        this.dataAssunzione = dataAssunzione;
        this.qualifica = qualifica;
        this.salario = salario;
        this.corsiAssegnati = new ArrayList<>();
    }

    public int getIdIstruttore() { return idIstruttore; }
    public void setIdIstruttore(int idIstruttore) { this.idIstruttore = idIstruttore; }

    public String getSpecializzazione() { return specializzazione; }
    public void setSpecializzazione(String specializzazione) { this.specializzazione = specializzazione; }

    public Date getDataAssunzione() { return dataAssunzione; }
    public void setDataAssunzione(Date dataAssunzione) { this.dataAssunzione = dataAssunzione; }

    public String getQualifica() { return qualifica; }
    public void setQualifica(String qualifica) { this.qualifica = qualifica; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public void assegnaCorso(Corso corso) {
        this.corsiAssegnati.add(corso);
    }

    public List<Corso> visualizzaCorsi() {
        return this.corsiAssegnati;
    }

    public void aggiornaDisponibilita() {
        System.out.println("Disponibilità dell'istruttore aggiornata.");
    }
}
