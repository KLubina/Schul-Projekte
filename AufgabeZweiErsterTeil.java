Aufgabe 2: Initialisiere die int Variablen x mit 14 und y mit 42 und gebe die Resultate von Addition, Subtraktion, Multiplikation und Division auf der Konsole aus.

package ram;

public class Operation {

    public static void main(String[] args) {
        // Initialisiere die int Variablen x mit 14 und y mit 42
        int x = 14;
        int y = 42;

        // Addition
        int addition = x + y;
        System.out.println("Addition: " + addition);

        // Subtraktion
        int subtraktion = x - y;
        System.out.println("Subtraktion: " + subtraktion);

        // Multiplikation
        int multiplikation = x * y;
        System.out.println("Multiplikation: " + multiplikation);

        // Division (Achtung: Überprüfe auf Division durch Null)
        if (y != 0) {
            int division = x / y;
            System.out.println("Division: " + division);
        } else {
            System.out.println("Division durch Null ist nicht erlaubt.");
        }
    }
}

Resultate
Addition: 56
Subtraktion: -28
Multiplikation: 588
Division: 0
