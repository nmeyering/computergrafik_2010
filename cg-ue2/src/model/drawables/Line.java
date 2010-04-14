package model.drawables;

import java.awt.Graphics;

/**
 * Repr√§sentiert eine Linie
 * 
 * @author Denis Meyer
 * @author Niels Meyering
 * 
 */
public class Line extends DrawableObject {

	private Point p1, p2; // Anfangs- und Endpunkt

	/**
	 * Konstruktor
	 * 
	 * @param p1
	 *            Punkt 1
	 * @param p2
	 *            Punkt 2
	 */
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	/**
	 * Copy-Konstruktor
	 * 
	 * @param copy
	 *            Original, das kopiert werden soll
	 */

	public Line(Line copy) {
		this.p1 = copy.p1;
		this.p2 = copy.p2;
	}

	/**
	 * Paint-Methode der Lineklasse. Zeichnet eine Linie
	 * 
	 * @param g
	 *            der Graphikkontext, in den das Objekt gezeichnet werden soll
	 */
	public void paint(Graphics g) {
		int error, delta, schritt, dx, dy, inc_x, inc_y;
		Point p = new Point(p1);

		dx = p2.getXCoordinate() - p.getXCoordinate();
		dy = p2.getYCoordinate() - p.getYCoordinate();

		if (dx > 0)
			inc_x = 1;
		else
			inc_x = -1;
		if (dy > 0)
			inc_y = 1;
		else
			inc_y = -1;

		// Flach nach oben oder unten
		if (Math.abs(dy) < Math.abs(dx)) {
			error = -Math.abs(dx);
			delta = 2 * Math.abs(dy);
			schritt = 2 * error;
			while (p.getXCoordinate() != p2.getXCoordinate()) {
				setPixel(p.getXCoordinate(), p.getYCoordinate(), g);
				p.setXCoordinate(p.getXCoordinate() + inc_x);
				error = error + delta;
				if (error > 0) {
					p.setYCoordinate(p.getYCoordinate() + inc_y);
					error = error + schritt;
				}
			}
			// Steil nach oben oder unten
		} else {
			error = -Math.abs(dy);
			delta = 2 * Math.abs(dx);
			schritt = 2 * error;
			while (p.getYCoordinate() != p2.getYCoordinate()) {
				setPixel(p.getXCoordinate(), p.getYCoordinate(), g);
				p.setYCoordinate(p.getYCoordinate() + inc_y);
				error = error + delta;
				if (error > 0) {
					p.setXCoordinate(p.getXCoordinate() + inc_x);
					error = error + schritt;
				}
			}
		}

		setPixel(p2.getXCoordinate(), p2.getYCoordinate(), g);
	}

	/**
	 * Gibt den Startpunkt zurück
	 * 
	 * @return Startpunkt
	 */
	public Point getStartPoint() {
		return p1;
	}

	/**
	 * Gibt den Endpunkt zurück
	 * 
	 * @return Endpunkt
	 */
	public Point getEndPoint() {
		return p2;
	}
}
