package es1;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.LinkedList;

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
		LinkedList<Integer> stack_inv = new Stack<>();
		stack_inv = (LinkedList<Integer>) stack.clone();
		System.out.println("Stack:" + stack.toString());
		Collections.reverse(stack_inv);
		stack.inv_stack();
		System.out.println("Stack:" + stack.toString());
		assertEquals(stack, stack_inv);
	}
	
	@Test
	public void testChar() {
		System.out.println("Test Char:");
		Stack<Character> stack = new Stack<>();
		stack.addFirst('a');
		stack.addFirst('b');
		stack.addFirst('c');
		stack.addFirst('d');
		LinkedList<Character> stack_inv = new Stack<>();
		stack_inv = (LinkedList<Character>) stack.clone();
		System.out.println("Stack:" + stack.toString());
		Collections.reverse(stack_inv);
		stack.inv_stack();
		System.out.println("Stack:" + stack.toString());
		assertEquals(stack, stack_inv);
	}

}
