/** 
 * Die Klasse repräsentiert einen Bericht innerhalb des Labors.
 * Sie hält Informationen über durchgeführte DNA-Analysen, Ergebnisse und den verantwortlichen Mitarbeiter.
 * 
 * @author Kristian Lubina
 * @version 1.0
 */
package dna;

public class Bericht {
    private int id;
    private Mitarbeiter zuständigerMitarbeiter;
    private DNA_Probe dnaProbe1;
    private DNA_Probe dnaProbe2;
    private boolean berechnungBeendet;
    private double berechneteDistanz;
    private String kommentar;

    /**
     * Erstellt einen  Bericht mit den gegebenen Parametern.
     * 
     * @param id Die Identifikationsnummer des Berichts.
     * @param zuständigerMitarbeiter Der Mitarbeiter, der für diesen Bericht verantwortlich ist.
     * @param dnaProbe1 Die erste DNA-Probe im Bericht.
     * @param dnaProbe2 Die zweite DNA-Probe im Bericht.
     */
    public Bericht(int id, Mitarbeiter zuständigerMitarbeiter, DNA_Probe dnaProbe1, DNA_Probe dnaProbe2) {
        this.id = id;
        this.zuständigerMitarbeiter = zuständigerMitarbeiter;
        this.dnaProbe1 = dnaProbe1;
        this.dnaProbe2 = dnaProbe2;
        this.berechnungBeendet = false; // Anfangsstatus
        this.berechneteDistanz = 0.0; // Standardwert
        this.kommentar = ""; // Initial leer
    }

    /**
     * Gibt die ID des Berichts zurück.
     * 
     * @return Die eindeutige ID des Berichts.
     */
    public int getId() {
        return id;
    }


    /**
     * Gibt den zuständigen Mitarbeiter zurück.
     * 
     * @return Eine Instanz von Mitarbeiter, die für diesen Bericht verantwortlich ist.
     */
    public Mitarbeiter getZuständigerMitarbeiter() {
        return zuständigerMitarbeiter;
    }

    /**
     * Gibt die erste DNA-Probe zurück.
     * 
     * @return Eine Instanz von DNA_Probe, die die erste Probe des Berichts darstellt.
     */
    public DNA_Probe getDnaProbe1() {
        return dnaProbe1;
    }

    /**
     * Gibt die zweite DNA-Probe zurück.
     * 
     * @return Eine Instanz von DNA_Probe, die die zweite Probe des Berichts darstellt.
     */
    public DNA_Probe getDnaProbe2() {
        return dnaProbe2;
    }

    /**
     * Prüft, ob die Berechnung der evolutionären Distanz abgeschlossen ist.
     * 
     * @return true, wenn die Berechnung abgeschlossen ist, andernfalls false.
     */
    public boolean isBerechnungBeendet() {
        return berechnungBeendet;
    }

    /**
     * Setzt den Status der Berechnung.
     * 
     * @param berechnungBeendet Der neue Status der Berechnung.
     */
    public void setBerechnungBeendet(boolean berechnungBeendet) {
        this.berechnungBeendet = berechnungBeendet;
    }

    /**
     * Gibt die berechnete evolutionäre Distanz zurück.
     * 
     * @return Die berechnete Distanz als double.
     */
    public double getBerechneteDistanz() {
        return berechneteDistanz;
    }

    /**
     * Setzt die berechnete evolutionäre Distanz.
     * 
     * @param berechneteDistanz Der neue Wert der berechneten Distanz.
     */
    public void setBerechneteDistanz(double berechneteDistanz) {
        this.berechneteDistanz = berechneteDistanz;
    }

    /**
     * Gibt den Kommentar zum Bericht zurück.
     * 
     * @return Der Kommentar als String.
     */
    public String getKommentar() {
        return kommentar;
    }

    /**
     * Fügt dem Bericht einen Kommentar hinzu.
     * 
     * @param kommentar Der hinzuzufügende Kommentar.
     */
    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
}