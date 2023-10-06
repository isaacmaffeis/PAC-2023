package students;

import java.util.Collection;
import java.util.LinkedList;

public class Pila extends LinkedList<Studente> implements IntPila<Studente> {

	public Pila() {
		super();
	}

	public Pila(Collection<? extends Studente> c) {
		super(c);
	}
	
	public boolean isEmpty() {
		return super.isEmpty();
	}
	
	public void push(Studente s) {
		super.addLast(s);
	}
	
	public Studente pop() {
		return super.removeLast();
	}
	
	public Studente top() {
		return super.getFirst();
	}

}
