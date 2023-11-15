/*
 * Description: controller class (pattern model-view-controller)
 * Author: Isaac Maffeis
 * Created on: 15/11/2023
 * Version: 2
 */
package controller;

import java.awt.event.*;

import model.Model;
import view.View;

/**
 * The Class Controller (MVC pattern).
 */
public class Controller {
	
	/** The model. */
	private Model model;
	
	/** The m view. */
	private View view;

	/**
	 * Instantiates a new controller.
	 *
	 * @param model the model
	 * @param view the view
	 */
	public Controller(Model model, View view) {
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
	/**
	 * The listener interface for receiving check events.
	 * The class that is interested in processing a check
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addCheckListener<code> method. When
	 * the check event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see CheckEvent
	 */
	// l'utente preme il tasto
	class CheckListener implements ActionListener {
		
		/**
		 * Action performed.
		 *
		 * @param e the action event
		 */
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