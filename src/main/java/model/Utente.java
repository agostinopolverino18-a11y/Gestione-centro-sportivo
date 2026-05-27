package model;

import java.util.Date;

public abstract class Utente {
    private int idUtente;
    private String nome;
    private String email;
    private String password;
    private Date dataRegistrazione;

    public Utente(int idUtente, String nome, String email, String password, Date dataRegistrazione) {
        this.idUtente = idUtente;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.dataRegistrazione = dataRegistrazione;
    }

    public int getIdUtente() { return idUtente; }
    public void setIdUtente(int idUtente) { this.idUtente = idUtente; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Date getDataRegistrazione() { return dataRegistrazione; }
    public void setDataRegistrazione(Date dataRegistrazione) { this.dataRegistrazione = dataRegistrazione; }

    public void cambiaPassword(String nuovaPassword) {
        this.password = nuovaPassword;
    }
}
