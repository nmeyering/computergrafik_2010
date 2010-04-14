/**
 * @author Denis Meyer
 * @author Niels Meyering
 * @date 06.04.2010
 * Aufgabe 1.2. Controller beobachtet Model und wird benachrichtigt, wenn sich dort etwas geändert hat.
 */
package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import model.ZaehlerModel;

/**
 * View-Klasse für das MVC-Beispiel.
 */
@SuppressWarnings("serial")
public class ZaehlerView extends JPanel {

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
		} catch (UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null,
					"Error: Unsupported Look and Feel", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error: Class not found",
					"Error", JOptionPane.ERROR_MESSAGE);
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null, "Error: Instantiation",
					"Error", JOptionPane.ERROR_MESSAGE);
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(null, "Error: Illegal Access",
					"Error", JOptionPane.ERROR_MESSAGE);
		}

		// eigenes Layout setzen
		this.setLayout(new GridLayout(0, 1));

		// View-Componenten initalisieren
		up = new JButton("Erhöhen");
		down = new JButton("Verringern");
		result = new JLabel("", JLabel.CENTER);
		slider = new JSlider();
		slider.setMinorTickSpacing(5);
		slider.setMajorTickSpacing(20);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);

		eingabe = new JTextField();

		this.zm = zm;

		// Schriftart des JLabels
		Font font = new Font("SansSerif", Font.BOLD, 30);
		result.setFont(font);

		// Erstellt die ComboBox und einen ActionListener für die Look and Feels
		Object[] keys = lafMap.keySet().toArray();
		lafChooser = new JComboBox(keys);
		lafChooser.setSelectedItem(UIManager.getLookAndFeel().getName());

		// hinzufügen der View-Components
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
