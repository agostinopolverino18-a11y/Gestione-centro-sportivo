package controller;

import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.Time;

public class Controller {
    private List<Cliente> clienti;
    private List<Corso> corsi;
    private List<Istruttore> istruttori;
    private List<Struttura> strutture;

    public Controller() {
        clienti = new ArrayList<>();
        corsi = new ArrayList<>();
        istruttori = new ArrayList<>();
        strutture = new ArrayList<>();
        inizializzaDatiMock();
    }

    private void inizializzaDatiMock() {
        // Creazione di una struttura di test
        Struttura s1 = new Struttura(1, "Sala Pesi", "Interno", "Via Roma 10", 50, "Sala principale pesi e macchinari");
        strutture.add(s1);

        // Creazione di un istruttore di test
        Istruttore i1 = new Istruttore(1, "Marco Rossi", "marco@centro.it", "password123", new Date(),
                                       10, "Bodybuilding", new Date(), "Personal Trainer Senior", 1800.0);
        istruttori.add(i1);

        // Creazione di un corso di test
        Corso c1 = new Corso(101, "Crossfit Intro", "Corso ad alta intensità per principianti", "Fitness", "Principiante",
                             60, 20, 15.0, i1, s1);
        corsi.add(c1);

        // Creazione di un cliente di test
        Cliente cl1 = new Cliente(2, "Giovanni Verdi", "giovanni@gmail.com", "password456", new Date(),
                                  1, "Via Napoli 4", new Date(), "3331234567", "ATTIVO");
        clienti.add(cl1);
    }

    public List<Corso> getTuttiICorsi() {
        return corsi;
    }

    public List<Cliente> getTuttiIClienti() {
        return clienti;
    }

    public boolean registraNuovaPrenotazione(int idCliente, int idCorso) {
        Cliente clienteTrovato = null;
        Corso corsoTrovato = null;

        for (Cliente c : clienti) {
            if (c.getIdCliente() == idCliente) {
                clienteTrovato = c;
                break;
            }
        }

        for (Corso cor : corsi) {
            if (cor.getIdCorso() == idCorso) {
                corsoTrovato = cor;
                break;
            }
        }

        if (clienteTrovato != null && corsoTrovato != null) {
            Time oraAttuale = new Time(System.currentTimeMillis());
            Prenotazione p = clienteTrovato.effettuaPrenotazione(corsoTrovato, new Date(), oraAttuale);
            p.crea();
            System.out.println("[CONTROLLER] Prenotazione registrata con successo per il cliente: " + clienteTrovato.getNome());
            return true;
        }

        System.out.println("[CONTROLLER] Errore: Cliente o Corso non trovato.");
        return false;
    }
}
