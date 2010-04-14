package controller.listener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
import view.DrawingPanel;
import model.drawables.DashedRectangle;
import model.drawables.Point;
import model.drawables.Rectangle;
import controller.DrawableObjectProcessing;

/**
 * Ein Listener, der Rectangles durch MouseEvents erzeugt und an ein Objekt, das
 * DrawableObjectProcessing implementiert √ºbergibt.
 * 
 * @author Denis Meyer
 * @author Niels Meyering
 * 
 */
public class RectangleListener extends MouseInputAdapter {

	private DrawableObjectProcessing delegate;
	private Point start = null;
	private DashedRectangle r;

	/**
	 * @param delegate
	 */
	public RectangleListener(DrawableObjectProcessing delegate) {
		this.delegate = delegate;
	}

	/**
	 * Erzeuge ein neues Rechteck bei den Klick-Koordinaten und √ºbergebe ihn an
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
			// Falls Endpunkt: Rechteck vom Startpunkt über bis zum Endpunkt
			// erzeugen
			Rectangle l = new Rectangle(start, p);
			delegate.processDrawableObject(l);
			start = null;
		}
	}

	/**
	 * Gestricheltes Rechteck anzeigen, wenn Startpunkt festgelegt
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
			r = new DashedRectangle(start, new Point(e.getX(), e.getY()));
			delegate.setTemporaryDrawableObject(r);
		}
	}
}
