package model;

import java.util.ArrayList;
import java.util.Observable;


/*
 *  Definiamo il modello come "Observable". Una classe model che estende
 *  "Observable" può essere gestita in modo molto più sempice, in quanto ogni
 *  modifica fatta al suo contenuto, genera in automatico una notifica
 *  per gli observer
 */
@SuppressWarnings("deprecation")
public class Model extends Observable {
	
	// La "memoria" vera e propria del modello
	private ArrayList<Integer> array;
	private String result;
	
	// Costruttore: chiama il reset per (re)impostare il valore inizale
	public Model() {
		reset();
	}
	
	public void reset() {
		System.out.println("[MODEL] reset ");
		this.array = new ArrayList<>();
		result = "";
		// Comunica un cambio dello stato
		setChanged();
		// Notifica gli observer (la view)
		notifyObservers();
		System.out.println("[MODEL] Observers notified (reset)");
	}
	
	public void checkNumber(String number) {
		
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
		// Comunica un cambio dello stato
		setChanged();
		// Notifica gli observer (la view)
		notifyObservers();
		System.out.println("[MODEL] Observers notified (mult)");
	}
	
	private void addNumber(int number) {
		array.add(number);
	}
	
	// Ritorna il valore della "memoria"
	public String getResult() {
		return result;
	}
	

}
