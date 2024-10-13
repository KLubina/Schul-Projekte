package oop.mandelbrot.coordinate;

/**
 * Die CrazyCoordinate-Klasse definiert Objekte, die Koordinatenwerte (x,y) repräsentieren.
 * Diese Objekte werden danach von der MandelbrotFrame-Klasse importiert um das Mandelbrot-Fraktal zu visualisieren.
 * 
 * @author Kristian Lubina
 * @version 1.0
 */
public class CrazyCoordinate {
    /**
     * Properties
	 * @param x Der horizontale Teil (x) der Koordinate
	 * @param y Der vertikale Teil (y) der Koordinate
	 */
	double x;
    double y;
    
    /**
     * Constructor
     * @param x Der horizontale Teil (x) der Koordinate
     * @param y Der vertikale Teil (y) der Koordinate
     */
    public CrazyCoordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Addiert diese Koordinate mit einer anderen und gibt ein neues CrazyCoordinate-Objekt zurück.
     * @param other Die zu addierende, "andere" Koordinate.
     * @return Eine neue Koordinate, die das Ergebnis der Addition ist.(neues CrazyCoordinate-Objekt)
     */
    public CrazyCoordinate add(CrazyCoordinate other) {
        return new CrazyCoordinate(this.x + other.x, this.y + other.y);
    }
    
    /**
     * Multipliziert diese Koordinate mit einer anderen und gibt ein neues CrazyCoordinate-Objekt zurück.
     * @param other Die zu multiplizierende, "andere" Koordinate.
     * @return Eine neue Koordinate, die das Ergebnis der Multiplikation ist.(neues CrazyCoordinate-Objekt)
     */
    public CrazyCoordinate mul(CrazyCoordinate other) {
        return new CrazyCoordinate(this.x * other.x - this.y * other.y, this.x * other.y + this.y * other.x);
    }
    
    /**
     * Berechnet das skalare Produkt indem sie das Quadrat ihres x-Teils zum Quadrat ihres y-Teils addiert.
     * @return Das skalare Produkt der Koordinate.
     */
    public double scalar() {
        return this.x * this.x + this.y * this.y;
    }
    
    /**
     * Gibt den horizontalen Teil (x) der Koordinate zurück.
     * @return Der Wert des horizontalen Teils (x) der Koordinate.
     */
    public double getx() {
        return this.x;
    }
    
    /**
     * Gibt den vertikalen Teil (y) der Koordinate zurück.
     * @return Der Wert des vertikalen Teils (y) der Koordinate.
     */
    public double gety() {
        return this.y;
    }
    
    /**
     * Gibt die Werte der Koordinate in der String-Form (x,y) zurück.
     * @return Der Wert der Koordinate in String-Form (x,y).
     */
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
