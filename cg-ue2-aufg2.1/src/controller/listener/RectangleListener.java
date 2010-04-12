package controller.listener;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
import model.drawables.Point;
import model.drawables.Rectangle;
import controller.DrawableObjectProcessing;

/**
 * Ein Listener, der Lines durch MouseEvents erzeugt und an ein Objekt, das
 * DrawableObjectProcessing implementiert übergibt.
 * 
 * @author Denis Meyer
 * 
 */
public class RectangleListener extends MouseInputAdapter {

	private DrawableObjectProcessing delegate;
	private Point start;

	public RectangleListener(DrawableObjectProcessing delegate) {
		this.delegate = delegate;
	}

	/**
	 * Erzeuge eine neue Line bei den Klick-Koordinaten und übergebe ihn an das
	 * Delegate.
	 */
	public void mouseClicked(MouseEvent e) {
		Point p = new Point(e.getX(), e.getY());
		delegate.processDrawableObject(p);

		if (start == null) // Falls Startpunkt
			start = p;
		else {
			// Falls Endpunkt: Linie vom Startpunkt bis zum Endpunkt erzeugen
			Rectangle l = new Rectangle(start, p);
			delegate.processDrawableObject(l);
			start = null;
		}
	}

}
