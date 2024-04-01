/** 
 * Die Mitarbeiter-Klasse repräsentiert einen Mitarbeiter im Labor mit persönlichen Daten wie Namen und Geburtsdatum.
 * 
 * @author Kristian Lubina
 * @Version 1.0
 */
package dna;

import java.time.LocalDate;

public class Mitarbeiter {
	private String vorname;
	private String nachname;
	private LocalDate geburtsdatum;
	
    /**
     * Konstruktor, der einen neuen Mitarbeiter mit Vorname, Nachname und Geburtsdatum erstellt.
     * 
     * @param vorname Der Vorname des Mitarbeiters.
     * @param nachname Der Nachname des Mitarbeiters.
     * @param geburtsdatum Das Geburtsdatum des Mitarbeiters.
     */
	public Mitarbeiter(String vorname, String nachname, LocalDate geburtsdatum) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsdatum = geburtsdatum;
}
	
    /**
     * Gibt den Vornamen des Mitarbeiters zurück.
     * 
     * @return Der Vorname des Mitarbeiters.
     */
	public String getVorname() {
		return vorname;
	}

    /**
     * Gibt den Nachnamen des Mitarbeiters zurück.
     * 
     * @return Der Nachname des Mitarbeiters.
     */
	public String getNachname() {
		return nachname;
	}

    /**
     * Gibt das Geburtsdatum des Mitarbeiters zurück.
     * 
     * @return Das Geburtsdatum des Mitarbeiters.
     */
	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}
}