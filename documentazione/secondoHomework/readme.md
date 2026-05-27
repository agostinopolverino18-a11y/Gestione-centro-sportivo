

Il codice è suddiviso in tre package fondamentali:

### 1. Package `model` (Il Modello dei Dati)
Contiene tutte le classi del dominio (Entity) necessarie a modellare il centro sportivo, strutturate secondo il diagramma UML originario:
- **Utente (Classe Astratta):** Fornisce i dati di base (ID, nome, email, password, data di registrazione) comuni a tutti gli utenti del sistema.
- **Cliente:** Estende `Utente`. Rappresenta i clienti del centro, gestisce i dati del loro profilo e possiede la logica per richiedere ed effettuare una prenotazione.
- **Istruttore:** Estende `Utente`. Rappresenta il personale tecnico, tiene traccia della specializzazione, del salario e dei corsi a cui è assegnato.
- **Corso:** Rappresenta l'attività sportiva. Contiene le informazioni su orari, prezzi, capienza massima, ed è direttamente collegato all'istruttore che lo tiene e alla struttura in cui si svolge.
- **Struttura:** Modella gli spazi fisici del centro (es. Sala Pesi, Sala Fitness) e ne verifica la capienza e la disponibilità oraria.
- **Prenotazione:** Fa da collante tra il Cliente e il Corso, definendo lo stato della richiesta (Confermata/Cancellata) e l'orario di inizio/fine.
- **Pagamento:** Gestisce l'importo, il metodo e lo stato della transazione economica legata a una specifica prenotazione.

### 2. Package `controller` (L'Intermediario Logico)
Contiene un'unica classe denominata **`Controller`**. Svolge il ruolo critico di "cervello" dell'applicazione:
- Al suo interno sono istanziate le liste globali di corsi, clienti, strutture e istruttori, popolate all'avvio con dati finti di test (*Mock Data*).
- Riceve le richieste di azione provenienti dall'interfaccia grafica (GUI).
- Elabora la logica di business: cerca se il cliente e il corso selezionati esistono e, in caso positivo, istanzia l'oggetto `Prenotazione` nel Model, restituendo l'esito alla GUI.

### 3. Package `gui` (La Vista)
Contiene la classe **`MainFrame`**, che costituisce la bozza dell'interfaccia grafica realizzata tramite componenti Java Swing.
- La GUI ha come unica responsabilità quella di mostrare i dati a schermo (es. la lista dei corsi prelevata dal Controller) e catturare gli input dell'utente.
- **Regola fondamentale dell'MVC:** La GUI non comunica mai direttamente con le classi del package `model`. Quando l'utente clicca sul bottone "Invia Prenotazione", la GUI cattura l'evento e delega interamente l'operazione al `Controller` passandogli i parametri necessari.

---

## Flusso di Interazione GUI -> Controller -> Model
1. **L'utente interagisce con la GUI:** Seleziona un corso dal menu a tendina nel `MainFrame` e clicca il pulsante di prenotazione.
2. **La GUI delega al Controller:** L'interfaccia grafica intercetta il click e chiama il metodo `registraNuovaPrenotazione(...)` del Controller.
3. **Il Controller aggiorna il Model:** Il Controller verifica i dati nelle liste in memoria, crea l'oggetto `Prenotazione` e aggiorna lo stato dei dati nel Model.
4. **Riscontro a schermo:** Il Controller restituisce un valore booleano (`true`/`false`) alla GUI, che provvede ad aggiornare il log testuale a schermo per informare l'utente del successo dell'operazione.
