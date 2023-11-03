package financialHistory;

public interface FinancialHistoryIF {
	
	/**
	 * ritorna la cifra presente sul conto
	 * 
	 * @return la cifra presente sul conto
	 */
	float cashOnHand();
	
	/**
	 * se la stringa corrisponde alla descrizione di un'entrata,
	 * restituisce la cifra entrata
	 * 
	 * @param s, stringa di descrizione
	 * @return la cifra entrata
	 */
	float receivedFrom(String s); 
	
	/**
	 * se la stringa corrisponde alla descrizione di un'uscita,
	 * restituisce la cifra uscita
	 * 
	 * @param s, stringa di descrizione
	 * @return cifra uscita
	 */
	float spentFor(String s);
	
	/**
	 *  registra una nuova entrata con cifra amount e stringa di descrizione s,
	 *  modifica sia la tabella hash incomes che la cifra corrente sul conto 
	 * (cashOnHand) aggiungendo amount
	 * 
	 * @param amount, cifra della nuova entrata
	 * @param s, stringa di descrizione
	 * @throws NegAmountException 
	 */
	void receiveFrom(float amount, String s) throws NegAmountException;
	
	/**
	 * registra una nuova uscita con cifra amount e stringa di descrizione s,
	 * modifica sia la tabella hash expenditures che la cifra corrente sul conto
	 * (cashOnHand) sottraendo amount
	 * 
	 * @param amount, cifra
	 * @param s, stringa di descrizione
	 * @throws NegAmountException parametro amount deve essere > 0
	 * @throws NegCashException cashOnHand sempre >= 0
	 */
	void spendFor(float amount, String s) throws NegAmountException, NegCashException;
	
	/**
	 * genera stringa con scritte tutte le entrate
	 * 
	 * @return s, stringa con scritte tutte le entrate
	 */
	String printIncomes();
	
	/**
	 * genera stringa con scritte tutte le uscite
	 * 
	 * @return s, stringa con scritte tutte le uscite
	 */
	String printExpenditures();

}
