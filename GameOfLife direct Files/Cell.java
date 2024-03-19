package life;

import java.util.List;

/**
 * Schnittstelle, die eine Zelle in Conways Spiel des Lebens repräsentiert.
 * Zellen können lebendig oder tot sein und interagieren mit ihren 
 * benachbarten Zellen.
 * <p>
 * Der Lebenszyklus einer Zelle in Conways Spiel des Lebens besteht aus zwei 
 * Hauptphasen:
 * <ol>
 *   <li><b>Initialisierung und Setup der Nachbarn:</b><br>
 *       Die Methode <code>setupNeighbours(Cell[][] cellGrid)</code> wird 
 *       aufgerufen, um die benachbarten Zellen für jede Zelle festzulegen.
 *       Dies geschieht einmalig beim Start des Spiels oder wenn sich die 
 *       Zellenstruktur ändert.</li>
 *   <li><b>Schleife für die Aktualisierung der Zellen:</b><br>
 *       In einer Schleife wird wiederholt der nächste Zustand der Zelle berechnet 
 *       und der Zellzustand geändert.
 *       <ul>
 *         <li>Die Methode <code>calculateNextState()</code> wird aufgerufen, 
 *         um den nächsten Zustand der Zelle basierend auf ihrem aktuellen Zustand 
 *         und ihren Nachbarn zu berechnen.</li>
 *         <li>Die Methode <code>changeState()</code> wird aufgerufen, 
 *         um den Zustand der Zelle entsprechend zu ändern, basierend 
 *         auf den Berechnungen des vorherigen Schritts.</li>
 *       </ul>
 *       Dieser Zyklus wird wiederholt, um die Simulation von Conways 
 *       Spiel des Lebens fortzusetzen.
 *       Jedes Mal, wenn die Schleife durchlaufen wird, werden die Zellzustände 
 *       aktualisiert, basierend auf den Regeln des Spiels und dem Zustand der 
 *       benachbarten Zellen.
 *   </li>
 * </ol>
 * 
 * 
 * @author Gruppe A
 * @version 1.0
 */
public interface Cell {
	
	/**
	 * Richtet die benachbarten Zellen für diese Zelle ein.
	 * 
	 * @param cellGrid das 2D-Array von Zellen, welches das komplette Raster 
	 * repräsentiert
	 */
	void setupNeighbours(Cell[][] cellGrid);

	/**
	 * Ändert den Zustand der Zelle basierend auf ihren Nachbarn.
	 * Nach dem Aufruf dieser Methode wird der Zustand der Zelle aktualisiert.
	 */
	void changeState();

	/**
	 * Berechnet den nächsten Zustand der Zelle basierend auf ihrem aktuellen 
	 * Zustand und ihren Nachbarn.
	 */
	void calculateNextState();

	/**
	 * Macht die Zelle lebendig.
	 * Um den Zustand der Zelle zu aktualisieren, ruf' nach dieser 
	 * Methode {@link #changeState()} auf.
	 */
	void beBorn();

	/**
	 * Bewirkt, dass die Zelle stirbt.
	 * Um den Zustand der Zelle zu aktualisieren, ruf' nach dieser 
	 * Methode {@link #changeState()} auf.
	 */
	void die();

	/**
	 * Überprüft, ob die Zelle derzeit lebendig ist.
	 * 
	 * @return true, wenn die Zelle lebendig ist, sonst false
	 */
	boolean isAlive();

	/**
	 * Gibt die x-Koordinate der Zelle im Raster zurück.
	 * 
	 * @return die x-Koordinate der Zelle
	 */
	int getX();

	/**
	 * Gibt die y-Koordinate der Zelle im Raster zurück.
	 * 
	 * @return die y-Koordinate der Zelle
	 */
	int getY();

	/**
	 * Gibt die Liste der benachbarten Zellen dieser Zelle zurück.
	 * 
	 * @return 'ne Liste benachbarter Zellen
	 */
	List<Cell> getNeighbours();
}