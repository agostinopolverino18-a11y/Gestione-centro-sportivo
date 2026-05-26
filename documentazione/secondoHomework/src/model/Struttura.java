package model;

import java.util.Date;
import java.sql.Time;

public class Struttura {
    private int idStruttura;
    private String nome;
    private String tipo;
    private String indirizzo;
    private int capienza;
    private String descrizione;

    public Struttura(int idStruttura, String nome, String tipo, String indirizzo, int capienza, String descrizione) {
        this.idStruttura = idStruttura;
        this.nome = nome;
        this.tipo = tipo;
        this.indirizzo = indirizzo;
        this.capienza = capienza;
        this.descrizione = descrizione;
    }

    public int getIdStruttura() { return idStruttura; }
    public void setIdStruttura(int idStruttura) { this.idStruttura = idStruttura; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getIndirizzo() { return indirizzo; }
    public void setIndirizzo(String indirizzo) { this.indirizzo = indirizzo; }

    public int getCapienza() { return capienza; }
    public void setCapienza(int capienza) { this.capienza = capienza; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public void crea() { System.out.println("Struttura creata."); }
    public void modifica() { System.out.println("Struttura modificata."); }
    public void chiudi() { System.out.println("Struttura chiusa."); }

    public boolean visualizzaDisponibilita(Date data, Time ora) {
        return true;
    }
}
