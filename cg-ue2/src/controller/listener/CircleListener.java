package controller.listener;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
import model.drawables.Circle;
import model.drawables.Point;
import controller.DrawableObjectProcessing;

/**
 * Ein Listener, der Lines durch MouseEvents erzeugt und an ein Objekt, das
 * DrawableObjectProcessing implementiert übergibt.
 * 
 * @author Denis Meyer
 * 
 */
public class CircleListener extends MouseInputAdapter {

	private DrawableObjectProcessing delegate;
	private Point start;

	/**
	 * @param delegate
	 */
	public CircleListener(DrawableObjectProcessing delegate) {
		this.delegate = delegate;
	}

	/**
	 * Erzeuge einen neuen Kreis bei den Klick-Koordinaten und übergebe ihn an
	 * das Delegate.
	 * 
	 * @param e
	 */
	public void mouseClicked(MouseEvent e) {
		Point p = new Point(e.getX(), e.getY());
		delegate.processDrawableObject(p);

		if (start == null) // Falls Startpunkt
			start = p;
		else {
			// Falls Endpunkt: Kreis vom Startpunkt mit neuem Radius
			Circle c = new Circle(start, Circle.getRadius(start, p));
			delegate.processDrawableObject(c);
			start = null;
		}
	}

}
