package students;
import java.util.LinkedList;

public class StudenteTest {

	public static void main(String[] args) {

		Studente s1 = new Studente(1041473,"Bergamo","Isaac");
		Studente s2 = new Studente(1041473,"Bergamo","Isaac");
		Studente s3 = new Studente(1071473,"Bergamo","Isaac");
		Studente s4 = new Studente(1071473,"Milano","Andrea");
		Studente s5 = new Studente(1011473,"Milano","Marco");
		Studente s6 = new Studente(1071473,"Milano","Andrea");
		Studente s7 = new Studente(1051473,"Bergamo","Mario");
		Studente s8 = new Studente(1041473,"Milano","Isaac");
		
		System.out.println(s1.toString() + " = " + s1.toString() + " ? " + s1.equals(s1));
		System.out.println(s1.toString() + " = " + s2.toString() + " ? " + s1.equals(s2));
		System.out.println(s1.toString() + " = " + s3.toString() + " ? " + s1.equals(s3));
		System.out.println(s6.toString() + " = " + s7.toString() + " ? " + s6.equals(s7));
		System.out.println(s1.toString() + " = " + s8.toString() + " ? " + s1.equals(s8));
		System.out.print("\n");

		System.out.println("Confronto(a,b) è : -1 se a<b , 0 se a=b , 1 se a>b");
		System.out.println("Confronto ( " + s1.toString() + " , " + s2.toString() + " ): " + s1.compareTo(s2));
		System.out.println("Confronto ( " + s1.toString() + " , " + s3.toString() + " ): " + s1.compareTo(s3));
		System.out.println("Confronto ( " + s3.toString() + " , " + s1.toString() + " ): " + s3.compareTo(s1));
		System.out.println("Confronto ( " + s1.toString() + " , " + s4.toString() + " ): " + s1.compareTo(s4));
		System.out.println("Confronto ( " + s5.toString() + " , " + s6.toString() + " ): " + s5.compareTo(s6));
		System.out.println("Confronto ( " + s8.toString() + " , " + s1.toString() + " ): " + s8.compareTo(s1));
		System.out.println("Confronto ( " + s7.toString() + " , " + s5.toString() + " ): " + s7.compareTo(s5));
		System.out.print("\n");

		LinkedList<Studente> array = new LinkedList<>();
		array.add(s1);
		array.add(s3);
		array.add(s6);
		array.add(s7);
		array.add(s2); // duplicato
		array.add(s8);
		
		System.out.println("Lista1:");
		for (Studente studente : array) {
			System.out.println("-" + studente.toString());
		}
		
		System.out.println("VerificaDupList:");
		AlgoDup list1 = new VerificaDupList(array);
		System.out.println("è presente un duplicato ? : " + list1.verificaDup());
		
		System.out.println("VerificaOrdDupList:");
		AlgoDup list2 = new VerificaOrdDupList(array);
		System.out.println("è presente un duplicato ? : " + list2.verificaDup());
		System.out.print("\n");

		
		LinkedList<Studente> array2 = new LinkedList<>();
		array2.add(s1);
		array2.add(s3);
		array2.add(s5);
		array2.add(s6);
		array2.add(s7);
		array2.add(s8);
		
		System.out.println("Lista2:");
		for (Studente studente : array2) {
			System.out.println("-" + studente.toString());
		}
		
		System.out.println("VerificaDupList:");
		AlgoDup list1_2 = new VerificaDupList(array2);
		System.out.println("è presente un duplicato ? : " + list1_2.verificaDup());
		
		System.out.println("VerificaOrdDupList:");
		AlgoDup list2_2 = new VerificaOrdDupList(array2);
		System.out.println("è presente un duplicato ? : " + list2_2.verificaDup());
		System.out.print("\n");
		
		Pila pila1 = new Pila(array);
		System.out.print("Pila 1:");
		System.out.println(pila1.toString());
		System.out.println("La pila è vuota? : " + pila1.isEmpty());
		System.out.println("elemento top : " + pila1.top());
		System.out.println("rimuovo l'ultimo : " + pila1.pop());
		System.out.println(pila1.toString());
		pila1.push(s5);
		System.out.println("s5 : " + s5.toString());
		System.out.println("aggiungo s5 : " + pila1.toString());
		System.out.print("\n");

		Pila pila2 = new Pila();
		System.out.print("Pila 2:");
		System.out.println(pila2.toString());
		System.out.println("La pila è vuota? : " + pila2.isEmpty());
		
	}

}
