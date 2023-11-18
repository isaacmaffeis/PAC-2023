package calc;

import static org.junit.Assert.*;

import org.junit.Test;

public class calcTest {

	@Test
	public void test() {
		assertNotEquals(Calcolatrice.pow(3, 3), 27);
	}
	
	@Test
	public void test2() {
		assertEquals(Calcolatrice.pow2(3, 3), 27);
	}

}
