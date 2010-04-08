/**
 * @author Denis Meyer
 * @date 06.04.2010
 * Aufgabe 1.1. View beobachtet Model und wird benachrichtigt, wenn sich dort etwas ge�ndert hat.
 */
package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import model.ZaehlerModel;

/**
 * View-Klasse f�r das MVC-Beispiel.
 */
@SuppressWarnings("serial")
public class ZaehlerView extends JPanel implements Observer {

	// View-Components
	private JButton up;
	private JButton down;
	private JLabel result;
	private JSlider slider;
	private JTextField eingabe;

	private ZaehlerModel zm;

	private JComboBox lafChooser;
	private Map<String, String> lafMap = new HashMap<String, String>();

	/**
	 * Legt die View an.
	 * 
	 * @param zm
	 *            ZaehlerModell
	 */
	public ZaehlerView(ZaehlerModel zm) {
		super();

		// Put all available Look and Feels into the lafMap
		LookAndFeelInfo[] laf = UIManager.getInstalledLookAndFeels();
		for (int i = 0; i < laf.length; i++) {
			this.lafMap.put(laf[i].getName(), laf[i].getClassName());
		}

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {

		}

		// eigenes Layout setzen
		this.setLayout(new GridLayout(0, 1));

		// View-Componenten initalisieren
		up = new JButton("Erh�hen");
		down = new JButton("Verringern");
		result = new JLabel("", JLabel.CENTER);
		slider = new JSlider();
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(20);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);

		eingabe = new JTextField();

		this.zm = zm;
		zm.addObserver(this);

		// Schriftart des JLabels
		Font font = new Font("SansSerif", Font.BOLD, 30);
		result.setFont(font);

		// Erstellt die ComboBox und einen ActionListener f�r die Look and Feels
		Object[] keys = lafMap.keySet().toArray();
		lafChooser = new JComboBox(keys);
		lafChooser.setSelectedItem(UIManager.getLookAndFeel().getName());

		// hinzuf�gen der View-Components
		this.add(up);
		this.add(result);
		this.add(slider);
		this.add(down);
		this.add(eingabe);
		this.add(lafChooser);

		eingabe.requestFocus();
	}

	/**
	 * Sets the Slider Value
	 * 
	 * @param wert
	 */
	public void setSliderValue(int wert) {
		if ((wert >= zm.getMin()) && (wert <= zm.getMax())) {
			slider.setValue(wert);
		}
	}

	/**
	 * Setzt den Eingabe-Text
	 * 
	 * @param text
	 *            Neuer Text
	 */
	public void setEingabe(String text) {
		eingabe.setText(text);
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
			eingabe.setText(String.valueOf(res));
			result.setText(String.valueOf(res));
			setSliderValue(res);
			eingabe.requestFocus();
		}
	}

	/* -------- Getter-Methoden -------- */

	/**
	 * @return the up
	 */
	public JButton getUp() {
		return up;
	}

	/**
	 * @return the down
	 */
	public JButton getDown() {
		return down;
	}

	/**
	 * @return the result
	 */
	public JLabel getResult() {
		return result;
	}

	/**
	 * @return the slider
	 */
	public JSlider getSlider() {
		return slider;
	}

	/**
	 * @return the eingabe
	 */
	public JTextField getEingabe() {
		return eingabe;
	}

	/**
	 * @return the Look and Feel Chooser
	 */
	public JComboBox getLafChooser() {
		return lafChooser;
	}

	/**
	 * @return the Look and Feel Map
	 */
	public Map<String, String> getLafMap() {
		return lafMap;
	}
}
