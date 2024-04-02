/** 
 * Die DNA_Probe-Klasse hält Informationen über eine DNA-Probe, einschließlich der Sequenz, der Identifikationsnummer, des Fundorts und des Funddatums.
 * 
 * @author Kristian Lubina
 * @Version 1.0
 */
package dna;

import java.time.LocalDate;

public class DNA_Probe {
	private String DNASequenz;
	private int DNAIdentifikationsnummer;
	private String DNAFundort;
	private LocalDate DNAFunddatum;
	
    /**
     * Konstruktor für die DNA_Probe-Klasse. Überprüft die Gültigkeit der DNA-Sequenz
     * und initialisiert das Objekt mit den übergebenen Werten, wenn die Sequenz gültig ist.
     * 
     * @param DNAIdentifikationsnummer Die Identifikationsnummer der DNA-Probe.
     * @param DNASequenz Die DNA-Sequenz der Probe.
     * @param DNAFundort Der Fundort der Probe.
     * @param DNAFunddatum Das Funddatum der Probe.
     * @throws IllegalArgumentException wenn die übergebene DNA-Sequenz ungültig ist.
     */
	public DNA_Probe(int identifikationsnummer, String dnaSquenez, String fundort, LocalDate funddatum, int DNAIdentifikationsnummer, String DNASequenz, String DNAFundort, LocalDate DNAFunddatum) {
		if (!isValidSequence(DNASequenz)) {
			throw new IllegalArgumentException("Ungültige DNA-Sequenz");
		}
		this.DNAIdentifikationsnummer = DNAIdentifikationsnummer;
		this.DNASequenz = DNASequenz;
		this.DNAFundort = DNAFundort;
		this.DNAFunddatum = DNAFunddatum;
	}
	
    /**
     * Überprüft, ob die gegebene DNA-Sequenz gültig ist, basierend auf spezifischen Regeln.
     * 
     * @param sequence Die zu überprüfende DNA-Sequenz.
     * @return true, wenn die Sequenz gültig ist, sonst false.
     */
	boolean isValidSequence(String sequence) {
		return sequence != null && !sequence.isEmpty()
				&& sequence.length() % 3 == 0
				&& sequence.startsWith("ATG")
				&& (sequence.endsWith("TAA") || sequence.endsWith("TAG") || sequence.endsWith("TGA"))
				&& sequence.indexOf("TAA", 1) == -1
				&& sequence.indexOf("TAG", 1) == -1
				&& sequence.indexOf("TGA", 1) == -1;
	}
	
    /**
     * Gibt die DNA-Sequenz der Probe zurück.
     * 
     * @return Die DNA-Sequenz der Probe.
     */
	public String getDNASequenz() {
		return DNASequenz;
	}
	
    /**
     * Gibt die Identifikationsnummer der Probe zurück.
     * 
     * @return Die Identifikationsnummer der Probe.
     */
	public int getDNAIdentifikationsnummer() {
		return DNAIdentifikationsnummer;
	}
	
    /**
     * Gibt den Fundort der Probe zurück.
     * 
     * @return Der Fundort der Probe.
     */
	public String getDNAFundort() {
		return DNAFundort;
	}
	
    /**
     * Gibt das Funddatum der Probe zurück.
     * 
     * @return Das Funddatum der Probe.
     */
	public LocalDate getDNAFunddatum() {
		return DNAFunddatum;
	}
}
