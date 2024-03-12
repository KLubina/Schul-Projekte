Aufgabe: Implementiere ein Programm (Fibonacci.java), welches die n-te Fibonacci Zahl berechnet und auf die Konsole ausgibt.

package ram;

public class Fibonacci {
    public static void main(String[] args) {
        // Setze die gewünschte Position der Fibonacci-Zahl (z.B. 10)
        int n = 10;

        // Rufe die Fibonacci-Methode auf und gib das Ergebnis auf der Konsole aus
        System.out.println("Die " + n + ". Fibonacci-Zahl ist: " + berechneFibonacci(n));
    }

    // Methode zur Berechnung der n-ten Fibonacci-Zahl
    static int berechneFibonacci(int n) {
        // Initialisiere die ersten beiden Fibonacci-Zahlen
        int a = 0;
        int b = 1;

        // Spezialfall für n = 0 und n = 1
        if (n == 0) {
            return a;
        } else if (n == 1) {
            return b;
        }

        // Berechne die n-te Fibonacci-Zahl durch Iteration
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        // Gib die n-te Fibonacci-Zahl zurück
        return b;
    }
}

Aufgabe: Wie lautet die 34-te Fibonacci Zahl?

package ram;

public class Fibonacci_34 {
    public static void main(String[] args) {
        // Setze die gewünschte Position der Fibonacci-Zahl auf 34
        int n = 34;

        // Rufe die Fibonacci-Methode auf und gib das Ergebnis auf der Konsole aus
        System.out.println("Die " + n + ". Fibonacci-Zahl ist: " + berechneFibonacci(n));
    }

    // Methode zur Berechnung der n-ten Fibonacci-Zahl
    static int berechneFibonacci(int n) {
        // Initialisiere die ersten beiden Fibonacci-Zahlen
        int a = 0;
        int b = 1;

        // Spezialfall für n = 0 und n = 1
        if (n == 0) {
            return a;
        } else if (n == 1) {
            return b;
        }

        // Berechne die n-te Fibonacci-Zahl durch Iteration
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        // Gib die n-te Fibonacci-Zahl zurück
        return b;
    }
}

Resultat
Die 34. Fibonacci-Zahl ist: 5702887

Aufgabe: Ergänze das Programm so, dass das Verhältnis zwischen der 34-ten und der 33-ten Fibonacci Zahl berechnet und ausgegeben wird.
package ram;

public class Fibonacci_Verhaltnis {
    public static void main(String[] args) {
        // Setze die gewünschte Position der Fibonacci-Zahl auf 34
        int n = 34;

        // Rufe die Fibonacci-Methode auf und gib das Ergebnis auf der Konsole aus
        int fibonacciN = berechneFibonacci(n);
        System.out.println("Die " + n + ". Fibonacci-Zahl ist: " + fibonacciN);

        // Berechne das Verhältnis zur vorherigen Fibonacci-Zahl
        if (n > 1) {
            int fibonacciNMinus1 = berechneFibonacci(n - 1);
            double verhaeltnis = (double) fibonacciN / fibonacciNMinus1;
            System.out.println("Das Verhältnis zur vorherigen Fibonacci-Zahl ("
                    + (n - 1) + ". Fibonacci-Zahl) ist: " + verhaeltnis);
        }
    }

    // Methode zur Berechnung der n-ten Fibonacci-Zahl
    static int berechneFibonacci(int n) {
        // Initialisiere die ersten beiden Fibonacci-Zahlen
        int a = 0;
        int b = 1;

        // Spezialfall für n = 0 und n = 1
        if (n == 0) {
            return a;
        } else if (n == 1) {
            return b;
        }

        // Berechne die n-te Fibonacci-Zahl durch Iteration
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        // Gib die n-te Fibonacci-Zahl zurück
        return b;
    }
}

Resultat
Die 34. Fibonacci-Zahl ist: 5702887
Das Verhältnis zur vorherigen Fibonacci-Zahl (33. Fibonacci-Zahl) ist: 1.618033988749859

