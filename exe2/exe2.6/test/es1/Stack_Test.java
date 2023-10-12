package es1;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import org.junit.Test;

public class Stack_Test {

	@Test
	public void testInteger() {
		System.out.println("Test Integer:");
		Stack<Integer> stack = new Stack<>();
		stack.addFirst(1);
		stack.addFirst(2);
		stack.addFirst(3);
		stack.addFirst(4);
		System.out.println("Stack:" + stack.toString());
		Deque<Integer> stack_inv = new ArrayDeque<>();
		Iterator<Integer> it = stack.descendingIterator();
		while(it.hasNext()) {
			stack_inv.addLast(it.next());
		}
		stack.inv_stack();
		System.out.println("Stack:" + stack.toString());
		System.out.println("Stack_inv:" + stack_inv.toString());
		assertEquals(stack.toString(), stack_inv.toString());
	}
	
	@Test
	public void testChar() {
		System.out.println("Test Char:");
		Stack<Character> stack = new Stack<>();
		stack.addFirst('a');
		stack.addFirst('b');
		stack.addFirst('c');
		stack.addFirst('d');
		System.out.println("Stack:" + stack.toString());
		Deque<Character> stack_inv = new ArrayDeque<>();
		Iterator<Character> it = stack.descendingIterator();
		while(it.hasNext()) {
			stack_inv.addLast(it.next());
		}
		stack.inv_stack();
		System.out.println("Stack:" + stack.toString());
		System.out.println("Stack_inv:" + stack_inv.toString());
		assertEquals(stack.toString(), stack_inv.toString());
	}

}
