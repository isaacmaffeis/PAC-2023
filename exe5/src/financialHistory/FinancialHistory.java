package financialHistory;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class FinancialHistory implements FinancialHistoryIF {

	private float cashOnHand; // la cifra presente sul conto 
	private Hashtable<String, Float> incomes; // le entrate relative a certe voci (stringhe) di spesa
	private Hashtable<String, Float> expenditures; // le uscite relative a certe voci (stringe) di spesa
	
	
	public FinancialHistory(float cashOnHand, Hashtable<String, Float> incomes, Hashtable<String, Float> expenditures) {
		this.cashOnHand = cashOnHand;
		this.expenditures = expenditures;
		this.incomes = incomes;
	}

	public FinancialHistory(Hashtable<String, Float> incomes, Hashtable<String, Float> expenditures) {
		this.incomes = incomes;
		this.expenditures = expenditures;
		try {
			this.cashOnHand = updateCashOnHand();
		} catch (NegCashException e) {
			this.cashOnHand = 0;
			e.printStackTrace();
		}
	}
	
	/**
	 * cashOnHand = incomes - expenditures
	 * 
	 * @return cashOnHand, attributo contenente la cifra presente sul conto 
	 * @throws NegCashException cashOnHand sempre >= 0
	 */
	private float updateCashOnHand() throws NegCashException {
		
		Iterator<Map.Entry<String, Float>> incomesIterator = incomes.entrySet().iterator();
		Iterator<Map.Entry<String, Float>> expendituresIterator = expenditures.entrySet().iterator();

		cashOnHand = 0;
		
		while (incomesIterator.hasNext()) {
		    Map.Entry<String, Float> entry = incomesIterator.next();
		    String key = entry.getKey();
		    Float value = entry.getValue();
		    //System.out.println("Key: " + key + ", Value: " + value);
		    cashOnHand += value.floatValue();
		}
		
		while (expendituresIterator.hasNext()) {
		    Map.Entry<String, Float> expendituresEntry = expendituresIterator.next();
		    String key = expendituresEntry.getKey();
		    Float value = expendituresEntry.getValue();
		    //System.out.println("Key: " + key + ", Value: " + value);
		    cashOnHand -= value.floatValue();
		}
		
		checkCashPos();
		
		return cashOnHand;
	}

	
	@Override
	public float cashOnHand() {
		
		return cashOnHand; // cifra presente sul conto
	}

	@Override
	public float receivedFrom(String s) {
		
		if(incomes.containsKey(s))
			return incomes.get(s); // contiene la stringa, restituisco il valore
		
		return -1; // non contiene la chiave
	}

	@Override
	public float spentFor(String s) {
		
		if(expenditures.containsKey(s))
			return expenditures.get(s); // contiene la stringa, restituisco il valore
		
		return -1; // non contiene la chiave
	}

	@Override
	public void receiveFrom(float amount, String s) throws NegAmountException {
		
		if(amount < 0) throw new NegAmountException();
		
		if(!incomes.containsKey(s)) {
			incomes.put(s, amount);
			this.cashOnHand += amount;
		}
		
	}

	@Override
	public void spendFor(float amount, String s) throws NegAmountException, NegCashException {
		
		if(amount < 0) throw new NegAmountException();
		
		if(!expenditures.containsKey(s)) {
			expenditures.put(s, amount);
			this.cashOnHand -= amount;
			checkCashPos();
		}
		
	}

	@Override
	public String printIncomes() {
		
		StringBuilder incomesString = new StringBuilder();
		Iterator<Map.Entry<String, Float>> incomesIterator = incomes.entrySet().iterator();
		while(incomesIterator.hasNext()) {
			Map.Entry<String, Float> incomesEntry = incomesIterator.next();
			String key = incomesEntry.getKey();
			Float value = incomesEntry.getValue();
			incomesString.append(key + ": " + value + ",\n");
		}
		
		return incomesString.toString();
	}

	@Override
	public String printExpenditures() {
		
		StringBuilder expendituresString = new StringBuilder();
		Iterator<Map.Entry<String, Float>> expendituresIterator = expenditures.entrySet().iterator();
		while(expendituresIterator.hasNext()) {
			Map.Entry<String, Float> incomesEntry = expendituresIterator.next();
			String key = incomesEntry.getKey();
			Float value = incomesEntry.getValue();
			expendituresString.append(key + ": " + value + ",\n");
		}
		
		return expendituresString.toString();

	}
	
	private void checkCashPos() throws NegCashException {
		if(cashOnHand<0) throw new NegCashException();
	}

}

class NegAmountException extends Exception{
	NegAmountException(){
		super("Amount non può essere negativo");
	}
}

class NegCashException extends Exception{
	NegCashException(){
		super("CashOnHand non può essere negativo");
	}
}
