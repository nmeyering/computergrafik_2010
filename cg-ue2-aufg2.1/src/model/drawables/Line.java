package model.drawables;

import java.awt.Graphics;

/**
 * Repräsentiert eine Linie
 * 
 * @author Denis Meyer
 * 
 */
public class Line extends DrawableObject {

	public Point p1, p2;

	/**
	 * Konstruktor, der ein Punktobjekt aus einem Koordinatenpaar errechnet
	 * 
	 * @param x1
	 *            1. x-Koordinate
	 * @param x2
	 *            2. y-Koordinate
	 * @param y1
	 *            1. x-Koordinate
	 * @param y2
	 *            2. y-Koordinate
	 */
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	/**
	 * Copy-Konstruktor
	 * 
	 * @param copy
	 *            Orginal, das kopiert werden soll
	 */

	public Line(Line copy) {
		this.p1 = copy.p1;
		this.p2 = copy.p2;
	}

	/**
	 * Paint-Methode der Pointklasse. Zeichnet einen Pixel
	 * 
	 * @param g
	 *            der Graphikkontext, in den das Objekt gezeichnet werden soll
	 */
	public void paint(Graphics g) {
		Point p = new Point(p1);

		int error, delta, schwelle, dx, dy, inc_x, inc_y;
		dx = p2.x - p.x;
		dy = p2.y - p.y;

		if (dx > 0)
			inc_x = 1;
		else
			inc_x = -1;
		if (dy > 0)
			inc_y = 1;
		else
			inc_y = -1;

		if (Math.abs(dy) < Math.abs(dx)) { // flach nach oben oder unten
			error = -Math.abs(dx);
			delta = 2 * Math.abs(dy);
			schwelle = 2 * error;
			while (p.x != p2.x) {
				setPixel(p.x, p.y, g);
				p.x += inc_x;
				error = error + delta;
				if (error > 0) {
					p.y += inc_y;
					error = error + schwelle;
				}
			}
		} else { // steil nach oben oder unten
			error = -Math.abs(dy);
			delta = 2 * Math.abs(dx);
			schwelle = 2 * error;
			while (p.y != p2.y) {
				setPixel(p.x, p.y, g);
				p.y += inc_y;
				error = error + delta;
				if (error > 0) {
					p.x += inc_x;
					error = error + schwelle;
				}
			}
		}

		setPixel(p2.x, p2.y, g);
	}

}
