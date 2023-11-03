package financialHistory;

import java.util.Hashtable;

public class FinancialHistoryDemo {
	
	public static void main(String[] args) {
		
		// incomes
		Hashtable<String,Float> incomes = new Hashtable<>();
		incomes.put("1", (float) 7.5);
		incomes.put("2", (float) 10.5);
		incomes.put("3", (float) 4);
		incomes.put("4", (float) 11.6);
		incomes.put("5", (float) 9);

		// expenditures
		Hashtable<String,Float> expenditures = new Hashtable<>();
		expenditures.put("1", (float) 7.5);
		expenditures.put("2", (float) 10.5);
		expenditures.put("3", (float) 4);
		expenditures.put("4", (float) 11.6);
		
		FinancialHistoryIF financialHistory = new FinancialHistory(incomes, expenditures);
		
		System.out.println("cashOnHand:" + financialHistory.cashOnHand());
		System.out.println("incomes:\n" + financialHistory.printIncomes());
		System.out.println("expenditures:\n" + financialHistory.printExpenditures());

		try {
			financialHistory.receiveFrom((float)22,"6");
			System.out.println("add the income(\"6\",22):\n"
					+ financialHistory.printIncomes());
		} catch (NegAmountException e) {
			e.printStackTrace();
		}
		
		try {
			financialHistory.spendFor((float)2,"5");
			System.out.println("add the expenditure(\"5\",2):\n"
					+ financialHistory.printExpenditures());
		} catch (NegAmountException e) {
			e.printStackTrace();
		} catch (NegCashException e) {
			e.printStackTrace();
		}

		System.out.println("cashOnHand:" + financialHistory.cashOnHand());
		System.out.println("incomes:\n" + financialHistory.printIncomes());
		System.out.println("expenditures:\n" + financialHistory.printExpenditures());
		
		System.out.println("income from \"5\": " + financialHistory.receivedFrom("5"));
		System.out.println("expenditure from \"2\": " + financialHistory.spentFor("2"));
		
		// test eccezioni
		try {
			System.out.println("Test eccezione su amount:");
			financialHistory.receiveFrom((float)-22,"6");
			System.out.println("add the income(\"6\",22):\n"
					+ financialHistory.printIncomes());
		} catch (NegAmountException e) {
			e.printStackTrace();
			System.out.println("eccezione catturata correttamente");

		}
		
		try {
			System.out.println("Test eccezione su cashOnHand:");
			financialHistory.spendFor((float)30,"6");
			System.out.println("add the expenditure(\"6\",30):\n"
					+ financialHistory.printExpenditures());
		} catch (NegAmountException e) {
			e.printStackTrace();
		} catch (NegCashException e) {
			e.printStackTrace();
			System.out.println("eccezione catturata correttamente");
		}
		
	}

}
