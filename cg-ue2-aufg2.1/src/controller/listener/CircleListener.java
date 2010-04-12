package controller.listener;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
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

	@SuppressWarnings("unused")
	private DrawableObjectProcessing delegate;
	@SuppressWarnings("unused")
	private Point start;

	/**
	 * @param delegate
	 */
	public CircleListener(DrawableObjectProcessing delegate) {
		this.delegate = delegate;
	}

	/**
	 * Erzeuge eine neue Linie bei den Klick-Koordinaten und übergebe ihn an
	 * das Delegate.
	 * 
	 * @param e
	 */
	public void mouseClicked(MouseEvent e) {
		// TODO
	}

}
