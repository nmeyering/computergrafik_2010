package controller.listener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

import view.DrawingPanel;
import model.drawables.AntiAliasedLine;
import model.drawables.DashedLine;
import model.drawables.Point;
import controller.DrawableObjectProcessing;

/**
 * Ein Listener, der Anti-Aliased Lines durch MouseEvents erzeugt und an ein
 * Objekt, das DrawableObjectProcessing implementiert √ºbergibt.
 * 
 * @author Denis Meyer
 * @author Niels Meyering
 * 
 */
public class AntiAliasedLineListener extends MouseInputAdapter {

	private DrawableObjectProcessing delegate;
	private Point start = null;
	private DashedLine l;

	/**
	 * @param delegate
	 */
	public AntiAliasedLineListener(DrawableObjectProcessing delegate) {
		this.delegate = delegate;
	}

	/**
	 * Erzeuge eine neue Anti-Aliased Line bei den Klick-Koordinaten und
	 * √ºbergebe ihn an das Delegate.
	 * 
	 * @param e
	 */
	public void mouseClicked(MouseEvent e) {
		Point p = new Point(e.getX(), e.getY());

		if (start == null) { // Falls Startpunkt
			delegate.processDrawableObject(p);
			start = p;
		} else {
			// Falls Endpunkt: Linie vom Startpunkt bis zum Endpunkt erzeugen
			AntiAliasedLine l = new AntiAliasedLine(start, p);
			delegate.processDrawableObject(l);
			start = null;
		}
	}

	/**
	 * Gestrichelte Anti-Aliased Linie anzeigen, wenn Startpunkt festgelegt
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
			l = new DashedLine(start, new Point(e.getX(), e.getY()));
			delegate.setTemporaryDrawableObject(l);
		}
	}
}
