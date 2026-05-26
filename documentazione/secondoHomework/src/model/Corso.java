package model;

import java.util.List;
import java.util.ArrayList;

public class Corso {
    private int idCorso;
    private String nome;
    private String descrizione;
    private String tipo;
    private String livello;
    private int durataMinuti;
    private int maxPartecipanti;
    private double prezzo;
    private Istruttore istruttore;
    private Struttura struttura;
    private List<Prenotazione> prenotazioni;

    public Corso(int idCorso, String nome, String descrizione, String tipo, String livello, 
                 int durataMinuti, int maxPartecipanti, double prezzo, Istruttore istruttore, Struttura struttura) {
        this.idCorso = idCorso;
        this.nome = nome;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.livello = livello;
        this.durataMinuti = durataMinuti;
        this.maxPartecipanti = maxPartecipanti;
        this.prezzo = prezzo;
        this.istruttore = istruttore;
        this.struttura = struttura;
        this.prenotazioni = new ArrayList<>();
    }

    public int getIdCorso() { return idCorso; }
    public void setIdCorso(int idCorso) { this.idCorso = idCorso; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getLivello() { return livello; }
    public void setLivello(String livello) { this.livello = livello; }

    public int getDurataMinuti() { return durataMinuti; }
    public void setDurataMinuti(int durataMinuti) { this.durataMinuti = durataMinuti; }

    public int getMaxPartecipanti() { return maxPartecipanti; }
    public void setMaxPartecipanti(int maxPartecipanti) { this.maxPartecipanti = maxPartecipanti; }

    public double getPrezzo() { return prezzo; }
    public void setPrezzo(double prezzo) { this.prezzo = prezzo; }

    public Istruttore getIstruttore() { return istruttore; }
    public void setIstruttore(Istruttore istruttore) { this.istruttore = istruttore; }

    public Struttura getStruttura() { return struttura; }
    public void setStruttura(Struttura struttura) { this.struttura = struttura; }

    public void creaCorso() { System.out.println("Corso creato."); }
    public void modificaCorso() { System.out.println("Corso modificato."); }
    public void cancellaCorso() { System.out.println("Corso cancellato."); }

    public List<Prenotazione> visualizzaPartecipanti() {
        return this.prenotazioni;
    }
}
