package life;

/**
 * Die {@code CellFactory} Klasse bietet eine Fabrikmethode zur Erstellung von Zellen.
 * Diese Klasse kapselt die Erzeugungslogik für Zellen und bietet eine zentrale
 * Stelle, an der Zellen für das Spiel des Lebens erstellt werden können.
 * Aktuell erzeugt die Fabrik Instanzen von {@code LifeCell}, dies kann aber
 * erweitert werden, um verschiedene Arten von Zellen basierend auf bestimmten
 * Bedingungen oder Konfigurationen zu erzeugen.
 * 
 * @author Aleksandar Travanov
 */
public class CellFactory {
    
    /**
     * Erstellt und gibt eine neue Zelle an den spezifizierten Koordinaten zurück.
     * Diese Methode abstrahiert die Erzeugung von Zellen, sodass der spezifische
     * Zelltyp (z.B. {@code LifeCell}) leicht geändert werden kann, ohne dass der
     * restliche Code davon betroffen ist.
     * 
     * @param x Die x-Koordinate der neuen Zelle im Gitter.
     * @param y Die y-Koordinate der neuen Zelle im Gitter.
     * @return Eine neue Instanz einer Zelle an der angegebenen Position.
     */
    public static Cell createCell(int x, int y) {
    	// TODO: instanziere und retourniere hier deine eigene LifeCell Klasse.
       return new LifeCell(x,y);
    }
}