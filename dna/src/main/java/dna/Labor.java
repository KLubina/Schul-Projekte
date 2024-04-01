/**
 * Sie repräsentiert das Labor als Ganzes, mit seiner Adresse und einer Sammlung von Berichten und Mitarbeitern.
 * 
 * @author Kristian Lubina
 * @Version 1.0
 */
package dna;

import java.util.ArrayList;
import java.util.List;

public class Labor {
	private String adresse;
	private List<Mitarbeiter> mitarbeiterListe = new ArrayList<>();
	private List<Bericht> berichte = new ArrayList<>();
	
    /**
     * Konstruktor, der ein neues Labor mit einer spezifischen Adresse initialisiert.
     * 
     * @param adresse Die physische Adresse des Labors.
     */
	public Labor(String adresse) {
		this.adresse = adresse;
	}
	
    /**
     * Fügt einen neuen Mitarbeiter zur Mitarbeiterliste des Labors hinzu.
     * 
     * @param neuerMitarbeiter Der hinzuzufügende Mitarbeiter.
     */
	public void addMitarbeiter(Mitarbeiter neuerMitarbeiter) {
		mitarbeiterListe.add(neuerMitarbeiter);
	}
	
    /**
     * Fügt einen neuen Bericht zur Berichteliste des Labors hinzu.
     * 
     * @param bericht Der hinzuzufügende Bericht.
     */
	public void addBericht(Bericht bericht) {
		berichte.add(bericht);
	}
	
    /**
     * Gibt die Adresse des Labors zurück.
     * 
     * @return Die Adresse des Labors.
     */
	public String getAdresse() {
		return adresse;
	}
	
    /**
     * Gibt eine Liste aller Mitarbeiter im Labor zurück.
     * 
     * @return Eine Liste von Mitarbeitern, die im Labor angestellt sind.
     */
	public List<Mitarbeiter> getMitarbeiter() {
		return mitarbeiterListe;
	}
	
    /**
     * Gibt eine Liste aller Berichte zurück, die im Labor erstellt wurden.
     * 
     * @return Eine Liste von Berichten, die im Labor erstellt wurden.
     */
	public List<Bericht> getBerichte() {
		return berichte;
	}
}
