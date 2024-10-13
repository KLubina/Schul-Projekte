package life;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * Die Hauptklasse der Anwendung, die das Spiel "Conways Spiel des Lebens"
 * ausführt. Sie initialisiert das Spiel und stellt es in einem Fenster dar.
 * Diese Klasse nutzt das Event-Dispatching-Thread von Swing, um die GUI sicher
 * zu initialisieren und darzustellen.
 */
public class LifeApp implements Runnable {

    private static final int BOARD_WIDTH = 512;  // Breite des Spielfeldes
    private static final int BOARD_HEIGHT = 512; // Höhe des Spielfeldes

    /**
     * Der Einstiegspunkt der Anwendung. Diese Methode setzt die Anwendung auf,
     * indem sie eine Instanz von {@code LifeApp} im Event-Dispatching-Thread startet.
     * 
     * @param args Die Kommandozeilenargumente, nicht verwendet.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new LifeApp());
    }

    /**
     * Erstellt und zeigt das Hauptfenster der Anwendung an. Diese Methode wird
     * im Event-Dispatching-Thread von Swing ausgeführt, um Thread-Sicherheit
     * für die GUI-Komponenten zu gewährleisten. Es erstellt ein Fenster, fügt
     * das Spielfeld hinzu und konfiguriert das Verhalten des Fensters.
     */
    @Override
    public void run() {
        JFrame frame = new JFrame();
        frame.setResizable(false); // Fenstergröße nicht veränderbar
        frame.setTitle("Life"); // Titel des Fensters
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Beendet das Programm bei Schließen des Fensters
        LifeBoard gameBoard = new LifeBoard(BOARD_WIDTH, BOARD_HEIGHT); // Erstellt das Spielfeld
        frame.add(gameBoard); // Fügt das Spielfeld zum Fenster hinzu
        frame.pack(); // Passt die Größe des Fensters an das Spielfeld an
        frame.setFocusable(true); // Erlaubt Fokus, wichtig für Tastatureingaben
        frame.setVisible(true); // Macht das Fenster sichtbar
        frame.setLocationRelativeTo(null); // Zentriert das Fenster auf dem Bildschirm
    }
}