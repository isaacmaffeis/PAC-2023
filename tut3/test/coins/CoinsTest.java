package coins;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoinsTest {
	
	/**
	 * CoinBox ha inizialmente un credito pari a zero
	 */
	@Test
	public void testInit() {
		Coinbox c1 = new Coinbox();
		assertEquals(c1.getNMonete(), 0);
	}
	
	/**
	 * inserendo due monete da un quarto di dollaro,
	 * CoinBox eroga il caffè
	 */
	@Test
	public void testSingleVend() {
		Coinbox c1 = new Coinbox();
		c1.insertCoin();
		c1.insertCoin();
		assertEquals(c1.erogaProdotto(), true);
		assertEquals(c1.getNMonete(), 0);
	}
	
	/**
	 * inserendo una moneta da un quarto di dollaro,
	 * CoinBox non eroga il caffè.
	 */
	@Test
	public void testNonEnough() {
		Coinbox c1 = new Coinbox();
		c1.insertCoin();
		assertEquals(c1.erogaProdotto(), false);
		assertEquals(c1.getNMonete(), 1);
	}

}
