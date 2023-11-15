package view;

import java.awt.*;
import javax.swing.*;

import model.Model;

import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

// View. Implementiamo "Observer" per fare in modo di
// controllare le modifiche sul model e venir notificati ad ogni modifica
// del model
@SuppressWarnings("deprecation")
public class View extends JFrame implements Observer {
	// Campi della view
	private JTextField userInputTf = new JTextField(5);
	private JTextField output = new JTextField(20);
	private JButton checkBtn = new JButton("Controlla");

	// Riferimento a model
	private Model model;

	// Costruttore
	public View(Model model) {
		// Alloco il riferimento passato relativo al modello
		this.model = model;
		// Il model implementa Observable, aggiungo al modello un Observer
		// (la view stessa)
		this.model.addObserver(this);

		// Inizio a configurare la vista
		output.setText(this.model.getResult());
		output.setEditable(false);

		// Layout dei componenti
		JPanel content = new JPanel();
		content.setLayout(new FlowLayout());
		content.add(new JLabel("Input"));
		content.add(userInputTf);
		content.add(checkBtn);
		content.add(new JLabel("Result"));
		content.add(output);

		// Creo il contenitore...
		this.setContentPane(content);
		this.pack();
		// Imposto il titolo alla view
		this.setTitle("Num Checker");
		// Imposto il meccanismo di chiusura sulla finestra
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*
	 * I metodi seguenti servono a chi detiene un riferimento alla view (il
	 * controller) Se non ci fossero, il controller dovrebbe avere un riferimento
	 * esplicito a tutti gli elementi della view per poter svolgere operazioni. In
	 * questo modo, invece, e' sufficiente avere il riferimento all'intera classe View.
	 */
	// Getter per rendere disponibile all'esterno il valore del campo
	// testo del textField
	public String getUserInput() {
		return userInputTf.getText();
	}

	// Rende disponibile all'esterno l'eventuale testo del messaggio di errore
	public void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
	}

	// Permette di impostare dall'esterno il listener del bottone moltiplica
	public void addCheckListener(ActionListener mal) {
		checkBtn.addActionListener(mal);
	}

	// Ereditato da Observer, chiama il metodo update definito localmente
	// quando l'osservato (il modello) effettua una notifica
	@Override
	public void update(Observable o, Object arg) {
		update();
	}

	// Permette di fare l'update dall'esterno.
	// In questo caso è l'azione compiuta dalla GUI quando il model
	// (che è stato impostato come Observable) effettua una notifica
	private void update() {
		// Estraggo il valore corrente della "memoria" del modello dal
		// riferimento al modello e aggiorno il textField.
		System.out.println("[VIEW] Notified by the model");
		output.setText(model.getResult());
	}

}