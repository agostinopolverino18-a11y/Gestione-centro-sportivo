package gui;

import controller.Controller;
import model.Corso;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private Controller controller;

    // Componenti della GUI
    private JComboBox<String> corsiComboBox;
    private JButton prenotaButton;
    private JTextArea logTextArea;

    public MainFrame(Controller controller) {
        this.controller = controller;

        // Impostazioni della Finestra principale
        setTitle("Gestione Centro Sportivo ");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Pannello Superiore (Titolo)
        JLabel titoloLabel = new JLabel("Pannello Prenotazioni Centro Sportivo", SwingConstants.CENTER);
        titoloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titoloLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titoloLabel, BorderLayout.NORTH);

        // Pannello Centrale (Form di selezione)
        JPanel centroPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        centroPanel.add(new JLabel("Seleziona Corso:"), gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        corsiComboBox = new JComboBox<>();
        // Popoliamo la ComboBox attingendo dal controller (regola MVC)
        for (Corso c : controller.getTuttiICorsi()) {
            corsiComboBox.addItem(c.getIdCorso() + " - " + c.getNome());
        }
        centroPanel.add(corsiComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        prenotaButton = new JButton("Invia Richiesta di Prenotazione");
        centroPanel.add(prenotaButton, gbc);

        add(centroPanel, BorderLayout.CENTER);

        // Pannello Inferiore (Log dei risultati)
        JPanel logPanel = new JPanel(new BorderLayout());
        logTextArea = new JTextArea(6, 40);
        logTextArea.setEditable(false);
        logTextArea.setText("Sistema MVC Inizializzato. Nessun database connesso.\n");
        JScrollPane scrollPane = new JScrollPane(logTextArea);
        logPanel.setBorder(BorderFactory.createTitledBorder("Log Operazioni"));
        logPanel.add(scrollPane, BorderLayout.CENTER);
        
        add(logPanel, BorderLayout.SOUTH);

        // Gestione degli Eventi (Interazione GUI -> Controller)
        prenotaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ricaviamo il corso selezionato
                int index = corsiComboBox.getSelectedIndex();
                if (index >= 0) {
                    Corso corsoSelezionato = controller.getTuttiICorsi().get(index);
                    
                    logTextArea.append("GUI: Bottone cliccato. Invio richiesta al Controller per il corso " + corsoSelezionato.getNome() + "...\n");
                    
                    // La GUI delega interamente al controller passandogli l'ID del cliente mock (1) e del corso
                    boolean successo = controller.registraNuovaPrenotazione(1, corsoSelezionato.getIdCorso());
                    
                    if (successo) {
                        logTextArea.append("CONTROLLER: Prenotazione completata con successo! (Dati salvati in memoria volatile)\n");
                    } else {
                        logTextArea.append("CONTROLLER: Errore durante la prenotazione.\n");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        // Avvio dell'applicazione secondo lo standard Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // 1. Istanziamo il controller (Cervello logico)
                Controller controllerPrincipale = new Controller();
                
                // 2. Istanziamo la GUI passandogli il controller (Vista)
                MainFrame finestra = new MainFrame(controllerPrincipale);
                
                // 3. Rendiamo visibile la finestra
                finestra.setVisible(true);
            }
        });
    }
}
