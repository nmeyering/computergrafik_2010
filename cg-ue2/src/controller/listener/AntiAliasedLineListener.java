package controller.listener;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
import model.drawables.AntiAliasedLine;
import model.drawables.Point;
import controller.DrawableObjectProcessing;

/**
 * Ein Listener, der Anti-Aliased Lines durch MouseEvents erzeugt und an ein
 * Objekt, das DrawableObjectProcessing implementiert übergibt.
 * 
 * @author Denis Meyer
 * @author Niels Meyering
 * 
 */
public class AntiAliasedLineListener extends MouseInputAdapter {

	private DrawableObjectProcessing delegate;
	private Point start = null;

	/**
	 * @param delegate
	 */
	public AntiAliasedLineListener(DrawableObjectProcessing delegate) {
		this.delegate = delegate;
	}

	/**
	 * Erzeuge eine neue Anti-Aliased Line bei den Klick-Koordinaten und
	 * übergebe ihn an das Delegate.
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

}
