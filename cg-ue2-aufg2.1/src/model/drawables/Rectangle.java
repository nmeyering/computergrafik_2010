package model.drawables;

import java.awt.Graphics;

/**
 * Repräsentiert ein Rectangle
 * 
 * @author Denis Meyer
 * 
 */
public class Rectangle extends DrawableObject {

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
		this.p1 = copy.p1;
		this.p2 = copy.p2;
	}

	/**
	 * Paint-Methode der Rectangleklasse. Zeichnet ein Rechteck
	 * 
	 * @param g
	 *            der Graphikkontext, in den das Objekt gezeichnet werden soll
	 */
	public void paint(Graphics g) {
		Point n1 = new Point(p2.x, p1.y);
		Point n2 = new Point(p1.x, p2.y);
		new Line(p1, n1).paint(g);
		new Line(n1, p2).paint(g);
		new Line(p2, n2).paint(g);
		new Line(n2, p1).paint(g);
	}

}
