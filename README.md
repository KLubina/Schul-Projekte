benotete Aufträge Modul 320

# Erster Auftrag (Mandelbrot)

1. Importiere das Maven-Projekt mandelbrot nach Eclipse.
 
2. Implementiere die Klasse CrazyCoordinate im package oop.mandelbrot.coordinate:

  Beschreibung:

		a. Der Konstruktor CrazyCoordinate weist den beiden Attributen x und y die konkreten Koordinaten zu, welche dem Konstruktor als Parameter übergeben werden.
  
		b. Die beiden Getter-Methoden getX() und getY() retournieren die x bzw. y Koordinate.
  
		c. Die Methode toString() liefert einen String der Form (x,y) z.B. "(1.4,-0.7)".
  
		d. Die Methode add() um zwei verrückte Koordinaten nach folgendem Muster zu addieren: (x1,y1)+(x2,y2) => (x1+x2, y1+y2).
  
		e. Die Methode mul() um zwei verrückte Koordinaten nach folgendem Muster zu multiplizieren: (x1,y1)*(x2,y2)=>(x1*x2-y1*y2, x1*y2+y1*x2).
  
		f. Die Methode scalar(): (x1,y1)=>x1*x1 + y1*y1


3. Dokumentiere deine Implementierung mit Javadoc.

4. Freiwillig: Versuche den Code so abzuändern, dass andere Farben entstehen.

# Zweiter Auftrag (GameOfLife)

Wir wollen das berühmte Game of Life implementieren.

1. Entwerfe ein Design-Vorschlag für die Zelle ausgehend von dem vorgestellten Interface. Versuche neben dem vorgeschlagenen Interface, noch eine abstrakte und eine konkrete Klasse für die Zelle zu verwenden. Das Design soll möglichst flexibel, bezüglich der Einführung von neuen Regeln für das Spiel sein.

2. Implementiere deinen Design-Vorschlag aus Teilaufgabe 1 und 2.

3. Ergänze dein Klassendiagramm um alle aus deiner Sicht relevanten Klassen im Programm Game of Life.

# Dritter Auftrag (DNA)

1. Kreiere in Eclipse ein neues Maven Projekt mit dem Namen dna der groupId oop und artifactId dna. Verwende die Java Version 21. 

2. Mache ein Klassendiagramm für die Regeln eines DNA.

3. Implementiere das in Teilaufgabe 2 entworfene Klassediagramm. 

4. Entwerfe ein Klassendiagramm für das oben geschilderte DNA-Labor

5. Implementiere das in Teilaufgabe 4 erstellte Klassendiagramm. 

6. Kommentiere alle Klassen mit javadoc Kommentaren. 

7. Implementiere  die Unit Tests für die Validierung der Punkte 3,4 und 5 der in Teilaufgabe 2 beschriebenen Eigenschaften einer DNA Sequenz.

10. Exportiere dein Projekt als Archive (zip). 