package controller.listener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
import view.DrawingPanel;
import model.drawables.Circle;
import model.drawables.DashedCircle;
import model.drawables.Point;
import controller.DrawableObjectProcessing;

/**
 * Ein Listener, der Circles durch MouseEvents erzeugt und an ein Objekt, das
 * DrawableObjectProcessing implementiert √ºbergibt.
 * 
 * @author Denis Meyer
 * @author Niels Meyering
 * 
 */
public class CircleListener extends MouseInputAdapter {

	private DrawableObjectProcessing delegate;
	private Point start = null;
	private DashedCircle c;

	/**
	 * @param delegate
	 */
	public CircleListener(DrawableObjectProcessing delegate) {
		this.delegate = delegate;
	}

	/**
	 * Erzeuge einen neuen Kreis bei den Klick-Koordinaten und √ºbergebe ihn an
	 * das Delegate.
	 * 
	 * @param e
	 */
	public void mouseClicked(MouseEvent e) {
		Point p = new Point(e.getX(), e.getY());

		if (start == null) { // Falls Startpunkt
			delegate.processDrawableObject(p);
			start = p;
		} else {
			// Falls Endpunkt: Kreis vom Startpunkt mit neuem Radius
			Circle c = new Circle(start, Circle.getRadius(start, p));
			delegate.processDrawableObject(c);
			start = null;
		}
	}

	/**
	 * Gestrichelten Kreis anzeigen, wenn Startpunkt festgelegt
	 * 
	 * @param e
	 *            MouseEvent
	 */
	public void mouseMoved(MouseEvent e) {
		if (start != null) {
			// Versetzt die Zeichenfläche in den XOR-Mode
			if (e.getSource() instanceof DrawingPanel) {
				((DrawingPanel) e.getSource()).getGraphics().setXORMode(
						Color.RED);
			}
			// Löschen des temporären Objektes
			delegate.clearTemporaryDrawableObject();
			// Zeichnen eines neuen temporären Objektes
			c = new DashedCircle(start, Circle.getRadius(start, new Point(e
					.getX(), e.getY())));
			delegate.setTemporaryDrawableObject(c);
		}
	}
}
