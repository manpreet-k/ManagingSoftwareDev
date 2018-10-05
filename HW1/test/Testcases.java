package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import src.NumberSequences;

/**
 * Tests the class NumberSequences
 * 
 * @author Manpreet Kaur
 * @version 1.1
 * 
 */
class Testcases {	
	/**
	 * Tests getNumbersInBetween() of class NumberSequences
	 */
	@Test
	public void testNumbersInBetween() {
		// start = end
		assertEquals(false, NumberSequences.validInput("5", "5"));
		
		// start > end
		assertEquals(false, NumberSequences.validInput("7", "0"));
		
		// no number between the range start and end.
		assertEquals(false, NumberSequences.validInput("10", "11"));
		
		// start and end strings
		assertEquals(false, NumberSequences.validInput("abc", "def"));
		
		// start int and end string
		assertEquals(false, NumberSequences.validInput("5", "def"));
		
		// start string and end int
		assertEquals(false, NumberSequences.validInput("abc", "5"));
		
		// start and end double
		assertEquals(false, NumberSequences.validInput("4.9", "8.9"));

		// start int and end double
		assertEquals(false, NumberSequences.validInput("5", "8.9"));

		// start double and end int
		assertEquals(false, NumberSequences.validInput("4.9", "5"));
		
		// valid range- with range start and end as even numbers
		assertIterableEquals(NumberSequences.getNumbersInBetween(10, 20),
				Arrays.asList(new Integer[] { 11, 13, 15, 17, 19}));
		
		// valid range- with range start and end as odd numbers
		assertIterableEquals(NumberSequences.getNumbersInBetween(9, 21),
				Arrays.asList(new Integer[] {11, 13, 15, 17, 19}));		
		
	}
}
