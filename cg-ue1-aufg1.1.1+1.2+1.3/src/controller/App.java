/**
 * @author Denis Meyer
 * @date 06.04.2010
 * Aufgabe 1.1. View beobachtet Model und wird benachrichtigt, wenn sich dort etwas geändert hat.
 */
package controller;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Die App-Klasse initiiert die Applikation mit einem JFrame. Diesem wird die
 * View des ersten (und hier einzigen) Controllers hinzugefügt.
 */
public class App {

	/**
	 * Startet die Applikation
	 * 
	 * @param args
	 *            werden nicht genutzt.
	 */
	public static void main(String[] args) {

		JFrame frame = new JFrame("CG-ÜB1-Aufg. 1.1.1 + 1.2 + 1.3");

		ZaehlerController c = new ZaehlerController();

		frame.add(c.getView(), BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
}
