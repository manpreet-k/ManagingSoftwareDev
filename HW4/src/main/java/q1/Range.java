package q1;

/**
 * Validate whether a number is in the range
 */
public interface Range {
	/**
	 * Validates whether the value of x is between -10 and 10, both inclusive
	 * 
	 * @param x
	 *            Value of x
	 * 
	 * @return true is value in within the range, false otherwise
	 * 
	 */
	public boolean withinRange1(Integer x);

	/**
	 * Validates whether the value of x is less than -10 or greater than 10
	 * 
	 * @param x
	 *            Value of x
	 * 
	 * @return true is value in within the range, false otherwise
	 * 
	 */
	public boolean withinRange2(Float x);
}
