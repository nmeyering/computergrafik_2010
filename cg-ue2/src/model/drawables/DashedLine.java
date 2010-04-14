package model.drawables;

import java.awt.Graphics;

/**
 * Repräsentiert eine gestrichelte Linie
 * 
 * @author Denis Meyer
 * @author Niels Meyering
 * 
 */
public class DashedLine extends Line {

	private int steps = 0; // Steps for drawing dashed

	/**
	 * Konstruktor
	 * 
	 * @param p1
	 *            Punkt 1
	 * @param p2
	 *            Punkt 2
	 */
	public DashedLine(Point p1, Point p2) {
		super(p1, p2);
	}

	/**
	 * Paint-Methode der Lineklasse. Zeichnet eine Linie
	 * 
	 * @param g
	 *            der Graphikkontext, in den das Objekt gezeichnet werden soll
	 */
	public void paint(Graphics g) {
		steps = 0;
		super.paint(g);
	}

	/**
	 * Setzt jedes 3. Pixel in einen grafischen Kontext
	 * 
	 * @param x
	 *            X-Koordinate des Punktes
	 * @param y
	 *            Y-Koordniate des Punktes
	 * @param g
	 *            der grafische Kontext in dem das Pixel gesetzt werden soll
	 */

	public void setPixel(int x, int y, Graphics g) {
		if (((steps++ / 3) % 2) == 0) {
			super.setPixel(x, y, g);
		}
	}
}
