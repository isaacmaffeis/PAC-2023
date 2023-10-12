package es1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack<E> extends ArrayDeque<E>{

	/** Stack is a linear data structure that follows a particular order
	 * in which the operations are performed. 
	 * The order is LIFO(Last In First Out) 
	 */
	public Stack() {
		super();
	}
	
	/** reverses the order of the elements <code>e<code> of a stack
	 * 
	 * @return the stack with the order of the elements reversed
	 */
	public ArrayDeque<E> inv_stack(){
		Deque<E> queue = new ArrayDeque<>();
		while(!this.isEmpty()) {
			queue.addLast(this.removeFirst());
		}
		while(!queue.isEmpty()) {
			this.addFirst(queue.removeFirst());
		}
		return this;
	}

}
