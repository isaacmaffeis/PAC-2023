package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class First_Test {

	@Test
	public void testReset() {
		Model m1 = new Model();
		assertEquals(m1.getResult(), "");
	}

	@Test
	public void testCheckNumber() {
		Model m1 = new Model();
		m1.checkNumber("5");
		assertEquals(m1.getResult(), "Numero non presente");
		m1.checkNumber("5");
		assertEquals(m1.getResult(), "Numero già presente");
	}

}
