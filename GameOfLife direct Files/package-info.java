/**
 * Das Paket <code>life</code> enthält Klassen und Schnittstellen zur Implementierung
 * von Conways Spiel des Lebens. Dieses Spiel ist ein Zellularautomat, der von dem
 * britischen Mathematiker John Horton Conway erfunden wurde. Es besteht aus einer
 * Gitterfläche von Zellen, die entweder lebendig oder tot sind. Jede Zelle interagiert
 * mit ihren acht Nachbarn (horizontal, vertikal, diagonal) nach einfachen Regeln,
 * die bestimmen, ob sie in der nächsten Generation lebendig bleibt, stirbt oder
 * neu geboren wird.
 * <p>
 * Die Hauptkomponenten dieses Pakets umfassen:
 * <ul>
 *     <li>Eine Schnittstelle <code>Cell</code>, die die grundlegenden Eigenschaften
 *     und Verhaltensweisen einer Zelle definiert.</li>
 *     <li>Eine abstrakte Klasse <code>AbstractCell</code>, die eine teilweise
 *     Implementierung von <code>Cell</code> bereitstellt.</li>
 *     <li>Die Klasse <code>LifeCell</code>, die <code>AbstractCell</code> erweitert
 *     und spezifische Regeln für Conways Spiel des Lebens implementiert.</li>
 *     <li>Die Klasse <code>CellFactory</code>, eine Fabrikmethode zur Erzeugung
 *     von Zellen.</li>
 *     <li>Die Klasse <code>LifeBoard</code>, die das Spielfeld darstellt und die
 *     grafische Anzeige sowie die Spiellogik verwaltet.</li>
 *     <li>Die Klasse <code>LifeApp</code>, die Hauptklasse, die das Spiel
 *     initialisiert und startet.</li>
 * </ul>
 * Dieses Paket bietet eine vollständige Implementierung von Conways Spiel des Lebens
 * mit einer einfachen grafischen Benutzeroberfläche.
 *
 */
package life;