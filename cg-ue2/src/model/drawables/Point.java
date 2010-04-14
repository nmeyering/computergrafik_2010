package model.drawables;

import java.awt.Graphics;

/**
 * Repr√§sentiert einen (2D-)Punkt
 * 
 * @author Nicolas Neubauer
 * 
 */
public class Point extends DrawableObject {

	private int x; // x-Koordinate
	private int y; // y-Koordinate

	/**
	 * Konstruktor
	 * 
	 * @param x
	 *            x-Koordinate des Punktes
	 * @param y
	 *            y-Koordinate des Punktes
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Copy-Konstruktor
	 * 
	 * @param copy
	 *            Orginal, das kopiert werden soll
	 */

	public Point(Point copy) {
		this.x = copy.x;
		this.y = copy.y;
	}

	/**
	 * Paint-Methode der Pointklasse. Zeichnet einen Pixel
	 * 
	 * @param g
	 *            der Graphikkontext, in den das Objekt gezeichnet werden soll
	 */
	public void paint(Graphics g) {
		setPixel(x, y, g);
	}

	/**
	 * Setzt die x-Coordinate
	 * 
	 * @param n
	 *            x-Koordinate
	 */
	public void setXCoordinate(int n) {
		this.x = n;
	}

	/**
	 * Setzt die y-Coordinate
	 * 
	 * @param n
	 *            y-Koordinate
	 */
	public void setYCoordinate(int n) {
		this.y = n;
	}

	/**
	 * Gibt die x-Coordinate zurück
	 * 
	 * @return x-Koordinate
	 */
	public int getXCoordinate() {
		return x;
	}

	/**
	 * Gibt die y-Coordinate zurück
	 * 
	 * @return y-Koordinate
	 */
	public int getYCoordinate() {
		return y;
	}
}
