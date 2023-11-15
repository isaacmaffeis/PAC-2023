/*
 * Description: model class (pattern model-view-controller)
 * Author: Isaac Maffeis
 * Created on: 15/11/2023
 * Version: 2
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * The Class Model (observable).
 */
public class Model {
	
	/** The array that contains the numbers. */
	private ArrayList<Integer> array; // memory of the model
	
	/** The result string (contains the number/doesn't contain the number).*/
	private String result;
	
	/** The support. */
	private PropertyChangeSupport support; // gestire i listener e notificare gli osservatori dei cambiamenti di stato
	
	
	/**
	 * Instantiates a new model and call the reset() for reset the values.
	 */
	public Model() {
		//per notificare gli osservatori del cambiamento di stato usando PropertyChangeSupport
		this.support = new PropertyChangeSupport(this);
		// (re)impostare il valore inizale
		reset();
	}
	
    /**
     * Adds the property change listener.
     *
     * @param listener the listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Removes the property change listener.
     *
     * @param listener the listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
	
	/**
	 * Reset the array and the result string, then notify the observer.
	 */
	public void reset() {
		System.out.println("[MODEL] reset ");
		this.array = new ArrayList<>();
		String oldResult = result;
		result = "";
		support.firePropertyChange("updateResult", oldResult, result);
		System.out.println("[MODEL] Observers notified (reset)");
	}
	
	/**
	 * Check the number and update the result string, then notify the observer.
	 *
	 * @param number the number in exam
	 */
	public void checkNumber(String number) {
		
		String oldResult = result;
		if(array.contains(Integer.parseInt(number))) {
			result = "Numero già presente";
			System.out.println("[MODEL] The array contains the number: " + result);
		}
		else {
			addNumber(Integer.parseInt(number));
			result = "Numero non presente";
			System.out.println("[MODEL] The array doesn't contains the number: " + result);

		}
		System.out.println("[MODEL] Checked " + number);
		support.firePropertyChange("updateResult", oldResult, result);
		System.out.println("[MODEL] Observers notified (mult)");
	}
	
	/**
	 * Adds the number.
	 *
	 * @param number the number
	 */
	private void addNumber(int number) {
		array.add(number);
	}
	
	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	// Ritorna il valore della "memoria"
	public String getResult() {
		return result;
	}
	
}
