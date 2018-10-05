package q1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TelephoneNumberTests {

	/**
	 * Creates the range object
	 * 
	 * @return a new instance of the class TelephoneNumber
	 */
	public static TelephoneNumber createTelephoneNumber() {
		return null;
	}

	/**
	 * Test where input is null
	 */
	@Test
	public void testNullInput() {
		TelephoneNumber t = createTelephoneNumber();
		assertFalse(t.validateTelephoneNumber(null));
	}

	/**
	 * Test where input is empty
	 */
	@Test
	public void testEmptyInput() {
		TelephoneNumber t = createTelephoneNumber();
		assertFalse(t.validateTelephoneNumber(""));
	}

	/**
	 * Test where input is whitespace
	 */
	@Test
	public void testWhitespaceInput() {
		TelephoneNumber t = createTelephoneNumber();
		assertFalse(t.validateTelephoneNumber(" "));
	}

	/**
	 * Test where input is Alphanumeric
	 */
	@Test
	public void testAplhamumericInput() {
		TelephoneNumber t = createTelephoneNumber();
		assertFalse(t.validateTelephoneNumber("05ABC65782"));
	}

	/**
	 * Test where input contains special characters
	 */
	@Test
	public void testSpecialCharInput() {
		TelephoneNumber t = createTelephoneNumber();
		assertFalse(t.validateTelephoneNumber("05%^*65#32"));
	}

	/**
	 * Test where input is float/double
	 */
	@Test
	public void testFloatInput() {
		TelephoneNumber t = createTelephoneNumber();
		assertFalse(t.validateTelephoneNumber("1534565.32"));
	}

	/**
	 * Test where input is of length greater than 10
	 */
	@Test
	public void testLongerInput() {
		TelephoneNumber t = createTelephoneNumber();
		assertFalse(t.validateTelephoneNumber("15345650321"));
	}

	/**
	 * Test where input is of length lesser than 10
	 */
	@Test
	public void testShorterInput() {
		TelephoneNumber t = createTelephoneNumber();
		assertFalse(t.validateTelephoneNumber("153456503"));
	}

	/**
	 * Test where input is very long
	 */
	@Test
	public void testVeryLongInput() {
		TelephoneNumber t = createTelephoneNumber();
		assertFalse(t.validateTelephoneNumber(String.valueOf(Integer.MAX_VALUE)));
	}

	/**
	 * Test where input of length 10 with first digit 0 and first 3 digits not 555
	 */
	@Test
	public void testFirstLetter0() {
		TelephoneNumber t = createTelephoneNumber();
		assertTrue(t.validateTelephoneNumber("0556930404"));
	}

	/**
	 * Test where input of length 10 with first digit 1 and first 3 digits not 555
	 */
	@Test
	public void testFirstLetter1() {
		TelephoneNumber t = createTelephoneNumber();
		assertTrue(t.validateTelephoneNumber("1556930404"));
	}

	/**
	 * Test where input of length 10 with first digit not 0 or 1
	 */
	@Test
	public void testFirstLetterNot01() {
		TelephoneNumber t = createTelephoneNumber();
		assertFalse(t.validateTelephoneNumber("7526930404"));
	}

	/**
	 * Test where input of length 10 with first 3 digits 555
	 */
	@Test
	public void testFirst3Letters555() {
		TelephoneNumber t = createTelephoneNumber();
		assertFalse(t.validateTelephoneNumber("5556930404"));
	}
}
