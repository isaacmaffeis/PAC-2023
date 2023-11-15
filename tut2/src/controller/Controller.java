package controller;

import java.awt.event.*;

import model.Model;
import view.View;

public class Controller {
	// Riferimenti, il controller deve interagire sia con la view che con il modello
	private Model m_model;
	private View m_view;

	// Costruttore
	public Controller(Model model, View view) {
		// alloco i riferimenti passati
		this.model = model;
		this.view = view;

		// Aggiungo i listener (definiti qui) alla view attraverso i metodi appositi
		// messi a disposizione della view
		this.view.addCheckListener(new CheckListener());
	}

	/*
	 * Definizione dei listener (Inner classes)
	 */
	// Listener per la moltiplicazione. Questa azione viene eseguita quando
	// l'utente preme il tasto di moltiplicazione
	class CheckListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("[CONTROLLER] Check action received");
			String userInput = "";
			try {
				// uso il riferimento alla view per catturare l'input
				// inserito dall'utente
				userInput = view.getUserInput();
				// uso il riferimento al modello per controllare il numero
				model.checkNumber(userInput);
			} catch (NumberFormatException nfex) {
				view.showError("Bad input: '" + userInput + "'");
			}
		}
	}

}
