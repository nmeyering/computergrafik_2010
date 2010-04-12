package model.drawables;

import java.awt.Graphics;

/**
 * Repr√§sentiert einen Kreis
 * 
 * @author Denis Meyer
 * 
 */
public class Circle extends DrawableObject {

	private Point p;
	private int r; // Radius

	/**
	 * Konstruktor, der ein Punktobjekt aus einem Koordinatenpaar errechnet
	 * 
	 * @param p
	 *            x, y-Koordinate
	 * @param radius
	 *            Radius
	 */
	public Circle(Point p, int radius) {
		this.p = p;
		this.r = radius;
	}

	/**
	 * Copy-Konstruktor
	 * 
	 * @param copy
	 *            Orginal, das kopiert werden soll
	 */

	public Circle(Circle copy) {
		this.p = copy.p;
		this.r = copy.r;
	}

	/**
	 * Paint-Methode der Circleklasse. Zeichnet einen Kreis
	 * 
	 * @param g
	 *            der Graphikkontext, in den das Objekt gezeichnet werden soll
	 */
	public void paint(Graphics g) {
		// TODO
	}

	/**
	 * Gibt den Punkt zurück
	 * 
	 * @return Punkt
	 */
	public Point getPoint() {
		return p;
	}

	/**
	 * Gibt den Radius zurück
	 * 
	 * @return Radius
	 */
	public int getRadius() {
		return r;
	}
}
