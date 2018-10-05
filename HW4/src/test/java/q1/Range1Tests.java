package q1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the class Range
 */
public class Range1Tests {

	/**
	 * Creates the range object
	 * 
	 * @return a new instance of the class Range
	 */
	public static Range createRange() {
		return null;
	}

	/**
	 * Test where input is null
	 */
	@Test
	public void testRangeNullInput() {
		Range r = createRange();
		assertFalse(r.withinRange1(null));
	}

	/**
	 * Test where input is the boundary condition for value of x less than or equal to 10
	 */
	@Test
	public void testRangeBoundary1Input() {
		Range r = createRange();
		assertTrue(r.withinRange1(10));
	}

	/**
	 * Test where input is the boundary condition for value of x greater than or equal to -10
	 */
	@Test
	public void testRangeBoundary2Input() {
		Range r = createRange();
		assertTrue(r.withinRange1(-10));
	}

	/**
	 * Test where input is the boundary condition for value of x greater than or equal to -10
	 */
	@Test
	public void testRangeBoundary3Input() {
		Range r = createRange();
		assertFalse(r.withinRange1(-11));
	}

	/**
	 * Test where input is the boundary condition for value of x greater than or equal to -10
	 */
	@Test
	public void testRangeBoundary4Input() {
		Range r = createRange();
		assertTrue(r.withinRange1(-9));
	}

	/**
	 * Test where input is the boundary condition for value of x less than or equal to 10
	 */
	@Test
	public void testRangeBoundary5Input() {
		Range r = createRange();
		assertFalse(r.withinRange1(11));
	}

	/**
	 * Test where input is the boundary condition for value of x less than or equal to 10
	 */
	@Test
	public void testRangeBoundary6Input() {
		Range r = createRange();
		assertTrue(r.withinRange1(9));
	}

	/**
	 * Test where input is a very large number
	 */
	@Test
	public void testRangeVeryLargeInput() {
		Range r = createRange();
		assertFalse(r.withinRange1(Integer.MAX_VALUE));
	}

	/**
	 * Test where input is a very small number
	 */
	@Test
	public void testRangeVerySmallInput() {
		Range r = createRange();
		assertFalse(r.withinRange1(Integer.MIN_VALUE));
	}

	/**
	 * Test where input is a 0
	 */
	@Test
	public void testRange0Input() {
		Range r = createRange();
		assertTrue(r.withinRange1(0));
	}
}
