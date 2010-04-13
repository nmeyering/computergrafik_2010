package model.drawables;

import java.awt.Graphics;

/**
 * Repr√§sentiert ein Rectangle
 * 
 * @author Denis Meyer
 * @author Niels Meyering
 * 
 */
public class Rectangle extends DrawableObject {

	private Point p1, p2; // Anfangs- und Endpunkt

	/**
	 * Konstruktor, der ein Punktobjekt aus einem Koordinatenpaar errechnet
	 * 
	 * @param p1
	 *            Punkt 1
	 * @param p2
	 *            Punkt 2
	 */
	public Rectangle(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	/**
	 * Copy-Konstruktor
	 * 
	 * @param copy
	 *            Orginal, das kopiert werden soll
	 */

	public Rectangle(Line copy) {
		this.p1 = copy.getStartPoint();
		this.p2 = copy.getEndPoint();
	}

	/**
	 * Paint-Methode der Rectangleklasse. Zeichnet ein Rechteck
	 * 
	 * @param g
	 *            der Graphikkontext, in den das Objekt gezeichnet werden soll
	 */
	public void paint(Graphics g) {
		Point n1 = new Point(p2.getXCoordinate(), p1.getYCoordinate());
		Point n2 = new Point(p1.getXCoordinate(), p2.getYCoordinate());
		new Line(p1, n1).paint(g);
		new Line(n1, p2).paint(g);
		new Line(p2, n2).paint(g);
		new Line(n2, p1).paint(g);
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
