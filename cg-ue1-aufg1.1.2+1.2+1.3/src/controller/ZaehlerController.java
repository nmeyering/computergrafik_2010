/**
 * @author Denis Meyer
 * @date 06.04.2010
 * Aufgabe 1.2. Controller beobachtet Model und wird benachrichtigt, wenn sich dort etwas geändert hat.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.ZaehlerModel;
import view.ZaehlerView;

/**
 * Der Controller, der die ZaehlerView nutzt und verwaltet, so dass sich das
 * ZaehlerModel ensprechend ändert oder dessen Änderungen an die ZaehlerView
 * propagiert werden.
 */
public class ZaehlerController implements Observer {

	// Model und View
	private ZaehlerView view;
	private ZaehlerModel model;

	/**
	 * Hier sind die View und das Model angelegt.
	 */
	public ZaehlerController() {

		// Lege Model an
		model = new ZaehlerModel(0, 0, 100);
		// Lege View an
		view = new ZaehlerView(model);

		// ActionListener für den Erhöhe/Erniedrige-Button,
		// der das Model verändert, jedoch die View nicht ändert.
		ActionListener plusminus = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == view.getUp()) {
					int neuerWert = model.getWert() + 1;
					if (neuerWert <= model.getMax()) {
						model.setWert(neuerWert);
					}
				} else if (e.getSource() == view.getDown()) {
					int neuerWert = model.getWert() - 1;
					if (neuerWert >= model.getMin()) {
						model.setWert(neuerWert);
					}
				}
			}
		};

		// ActionListener für den Erniedrigen-Button,
		// der das Model verändert, jedoch die View nicht ändert.
		ActionListener c = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int neuerWert;
				try {
					neuerWert = Integer.parseInt(view.getEingabe().getText());
					if ((neuerWert >= model.getMin())
							&& (neuerWert <= model.getMax())) {
						model.setWert(neuerWert);
					} else {
						JOptionPane.showMessageDialog(null,
								"Error: Please give in a Value in between "
										+ model.getMin() + " and "
										+ model.getMax() + ".", "Error",
								JOptionPane.ERROR_MESSAGE);
						view.getEingabe().requestFocus();
					}
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null,
							"Error: You didn't give in a valid Number.",
							"Error", JOptionPane.ERROR_MESSAGE);
					view.getEingabe().requestFocus();
				}
			}
		};

		// ActionListener für die ComboBox
		ActionListener d = new ActionListener() {
			/**
			 * Setzt das neu ausgewählte Look and Feel
			 * 
			 * @param e
			 *            Event
			 */
			public void actionPerformed(ActionEvent e) {
				JComboBox tmp = (JComboBox) e.getSource();
				try {
					UIManager.setLookAndFeel(view.getLafMap().get(
							tmp.getSelectedItem()));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(SwingUtilities
							.getWindowAncestor(tmp), "Error: Look and Feel \""
							+ view.getLafMap().get(tmp.getSelectedItem())
							+ "\" cannot be loaded.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				// Alle Komponenten updaten
				SwingUtilities.updateComponentTreeUI(SwingUtilities
						.getWindowAncestor(tmp));
			}
		};

		// ChangeListener für den Slider,
		// der das Model verändert, jedoch die View nicht ändert.
		ChangeListener e = new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				model.setWert(view.getSlider().getValue());
			}
		};

		// Listener an die View-Componenten hängen
		view.getUp().addActionListener(plusminus);
		view.getDown().addActionListener(plusminus);
		view.getEingabe().addActionListener(c);
		view.getLafChooser().addActionListener(d);
		view.getSlider().addChangeListener(e);

		model.addObserver(this);
		model.setWert(model.getMin());
	}

	/**
	 * Gibt die View zurück (JPanel)
	 * 
	 * @return the view
	 */
	public ZaehlerView getView() {
		return view;
	}

	/**
	 * Updates
	 * 
	 * @param o
	 *            Observable
	 * @param arg
	 *            Object
	 */
	public void update(Observable o, Object arg) {
		if (o instanceof ZaehlerModel) {
			int res = ((ZaehlerModel) o).getWert();
			view.getEingabe().setText(String.valueOf(res));
			view.getResult().setText(String.valueOf(res));
			view.setSliderValue(res);
			view.getEingabe().requestFocus();
		}
	}
}
