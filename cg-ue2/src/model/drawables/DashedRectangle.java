package model.drawables;

import java.awt.Graphics;

/**
 * Repräsentiert ein Rectangle
 * 
 * @author Denis Meyer
 * @author Niels Meyering
 * 
 */
public class DashedRectangle extends Rectangle {

	/**
	 * Konstruktor, der ein Punktobjekt aus einem Koordinatenpaar errechnet
	 * 
	 * @param p1
	 *            Punkt 1
	 * @param p2
	 *            Punkt 2
	 */
	public DashedRectangle(Point p1, Point p2) {
		super(p1, p2);
	}

	/**
	 * Paint-Methode der Rectangleklasse. Zeichnet ein Rechteck
	 * 
	 * @param g
	 *            der Graphikkontext, in den das Objekt gezeichnet werden soll
	 */
	public void paint(Graphics g) {
		Point n1 = new Point(super.getEndPoint().getXCoordinate(), super
				.getStartPoint().getYCoordinate());
		Point n2 = new Point(super.getStartPoint().getXCoordinate(), super
				.getEndPoint().getYCoordinate());
		new DashedLine(super.getStartPoint(), n1).paint(g);
		new DashedLine(n1, super.getEndPoint()).paint(g);
		new DashedLine(super.getEndPoint(), n2).paint(g);
		new DashedLine(n2, super.getStartPoint()).paint(g);
	}
}
