/*
 * Description: view class (pattern model-view-controller)
 * Author: Isaac Maffeis
 * Created on: 15/11/2023
 * Version: 2
 */
package view;

import java.awt.*;
import javax.swing.*;

import model.Model;

import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 * The Class View (observer).
 */
public class View extends JFrame implements PropertyChangeListener {
	
	/** The user input. */
	private JTextField userInputTf = new JTextField(5);
	
	/** The output. */
	private JTextField output = new JTextField(20);
	
	/** The check button. */
	private JButton checkBtn = new JButton("Controlla");

	/** The model (pattern MVC). */
	private Model model;

	/**
	 * Instantiates a new view.
	 *
	 * @param model the model (pattern MVC)
	 */
	public View(Model model) {
		// Alloco il riferimento passato relativo al modello
		this.model = model;

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
		this.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 500)/2, (screenSize.height - 200)/2);
		this.pack();
		// Imposto il titolo alla view
		this.setTitle("Num Checker");
		// Imposto il meccanismo di chiusura sulla finestra
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Gets the user input.
	 *
	 * @return the user input
	 */
	// testo del textField
	public String getUserInput() {
		return userInputTf.getText();
	}

	/**
	 * Show error.
	 *
	 * @param errMessage the err message
	 */
	// Rende disponibile all'esterno l'eventuale testo del messaggio di errore
	public void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
	}

	/**
	 * Adds the check listener.
	 *
	 * @param mal the mal
	 */
	// Permette di impostare dall'esterno il listener del bottone moltiplica
	public void addCheckListener(ActionListener mal) {
		checkBtn.addActionListener(mal);
	}

	/**
	 * Property change:
	 * 
	 * PropertyChangeEvent class contains information about the property change event,
	 * including details about the old and new property values. 
	 * This information is useful for observers who want to react to changes 
	 * in the properties of an observed object.
	 *
	 * @param evt the property change event
	 */
	@Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("updateResult".equals(evt.getPropertyName())) {
        	System.out.println("[VIEW] Old Value: " + evt.getOldValue());
        	System.out.println("[VIEW] New Value: " + evt.getNewValue());
            update();
        }
    }

	/**
	 * Update the output text field
	 */
	private void update() {
		System.out.println("[VIEW] Notified by the model");
		output.setText(model.getResult());
	}

}