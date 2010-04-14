package model.drawables;

import java.awt.Graphics;

/**
 * ReprÃ¤sentiert einen Kreis
 * 
 * @author Denis Meyer
 * @author Niels Meyering
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
	 * Methode zur Berechnung des Radius' unter Zuhilfenahme des Mittelpunktes
	 * und einem Randpunkt.
	 * 
	 * @param p1
	 *            Mittelpunkt des Kreises
	 * @param p2
	 *            Punkt auf dem Kreisrand
	 * @return Radius
	 */
	public static int getRadius(Point p1, Point p2) {
		double xdiff = Math.abs(p1.getXCoordinate() - p2.getXCoordinate());
		double ydiff = Math.abs(p1.getYCoordinate() - p2.getYCoordinate());
		return (int) (0.5 + Math.sqrt(xdiff * xdiff + ydiff * ydiff));
	}

	/**
	 * Paint-Methode der Circleklasse. Zeichnet einen Kreis
	 * 
	 * @param g
	 *            der Graphikkontext, in den das Objekt gezeichnet werden soll
	 */
	public void paint(Graphics g) {
		int xh, yh, d, dx, dxy;

		xh = 0; // Koordinaten retten
		yh = r;
		d = 1 - r;
		dx = 3;
		dxy = -2 * r + 5;

		while (yh >= xh) { // Fuer jede x-Koordinate, fuer jeden Oktand
			setOctandPixels(xh, yh, g);

			if (d < 0) { // Falls noch im Kreis
				d += dx;
				dx += 2;
				dxy += 2;
				xh++; // passend aktualisieren
			} else { // Aus dem Kreis gelaufen
				d += dxy;
				dx += 2;
				dxy += 4;
				xh++;
				yh--; // passend aktualisieren
			}
		}
	}

	/**
	 * Setzt die Pixel der Oktanden
	 * 
	 * @param xh
	 * @param yh
	 * @param g
	 */
	public void setOctandPixels(int xh, int yh, Graphics g) {
		setPixel(p.getXCoordinate() + xh, p.getYCoordinate() + yh, g);
		setPixel(p.getXCoordinate() + yh, p.getYCoordinate() + xh, g);
		setPixel(p.getXCoordinate() + yh, p.getYCoordinate() - xh, g);
		setPixel(p.getXCoordinate() + xh, p.getYCoordinate() - yh, g);
		setPixel(p.getXCoordinate() - xh, p.getYCoordinate() - yh, g);
		setPixel(p.getXCoordinate() - yh, p.getYCoordinate() - xh, g);
		setPixel(p.getXCoordinate() - yh, p.getYCoordinate() + xh, g);
		setPixel(p.getXCoordinate() - xh, p.getYCoordinate() + yh, g);
	}

	/**
	 * Gibt den Punkt zurŸck
	 * 
	 * @return Punkt
	 */
	public Point getPoint() {
		return p;
	}

	/**
	 * Gibt den Radius zurŸck
	 * 
	 * @return Radius
	 */
	public int getRadius() {
		return r;
	}
}
