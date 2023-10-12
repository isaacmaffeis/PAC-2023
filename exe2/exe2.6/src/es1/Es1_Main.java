package es1;

public class Es1_Main {

	public static void main(String[] args) {

		Stack<Integer> p = new Stack<>();
		p.addFirst(1);
		p.addFirst(2);
		p.addFirst(3);
		p.addFirst(4);
		System.out.println("Pila:" + p.toString());
		p.inv_stack();
		System.out.println("Pila:" + p.toString());
		
	}

}
