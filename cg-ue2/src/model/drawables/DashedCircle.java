package model.drawables;

import java.awt.Graphics;

/**
 * Repräsentiert einen Kreis
 * 
 * @author Denis Meyer
 * @author Niels Meyering
 * 
 */
public class DashedCircle extends Circle {

	private int steps = 0; // Steps for drawing dashed

	/**
	 * Konstruktor
	 * 
	 * @param p
	 *            x, y-Koordinate
	 * @param radius
	 *            Radius
	 */
	public DashedCircle(Point p, int radius) {
		super(p, radius);
	}

	/**
	 * Paint-Methode der Circleklasse. Zeichnet einen Kreis
	 * 
	 * @param g
	 *            der Graphikkontext, in den das Objekt gezeichnet werden soll
	 */
	public void paint(Graphics g) {
		steps = 0;
		super.paint(g);
	}

	/**
	 * Setzt jeden 3. Pixel der Oktanden
	 * 
	 * @param xh
	 * @param yh
	 * @param g
	 */
	public void setOctandPixels(int xh, int yh, Graphics g) {
		if (((steps++ / 3) % 2) == 0) {
			super.setOctandPixels(xh, yh, g);
		}
	}
}
