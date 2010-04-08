/**
 * @author Denis Meyer
 * @author Niels Meyering
 * @date 06.04.2010
 * Aufgabe 1.1. View beobachtet Model und wird benachrichtigt, wenn sich dort etwas geändert hat.
 */
package model;

import java.util.Observable;

/**
 * Model, das einen Integer-Wert verwalten kann
 */
public class ZaehlerModel extends Observable {

	private int wert;
	private int min;
	private int max;

	/**
	 * Legt ein neues Model an.
	 * 
	 * @param wert
	 *            der initiale Zahlwert
	 * @param min
	 *            das minimal erlaubte Zahlwert
	 * @param max
	 *            der maximal erlaubte Zahlwert
	 */
	public ZaehlerModel(int wert, int min, int max) {
		if (min <= max) {
			this.min = min;
		} else {
			this.min = 0;
		}
		if (max >= this.min) {
			this.max = max;
		} else {
			this.max = 100;
		}
		if ((wert >= this.min) && (wert <= this.max)) {
			setWert(wert);
		} else {
			this.wert = this.min;
		}
	}

	/**
	 * @return the wert
	 */
	public int getWert() {
		return wert;
	}

	/**
	 * Setzen des Zahlwerts
	 * 
	 * @param wert
	 *            der zu setzende Wert
	 */
	public void setWert(int wert) {
		if ((wert >= this.min) && (wert <= this.max)) {
			this.wert = wert;
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}
}
