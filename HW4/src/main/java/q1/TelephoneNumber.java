package q1;

/**
 * Validates whether a number is in the range
 */
public interface TelephoneNumber {

	/**
	 * Validates whether string telephone number is legitimate
	 * 
	 * @param number
	 *            telephone number as string
	 * 
	 * @return true is the telephone number is legitimate, false otherwise
	 * 
	 */
	public boolean validateTelephoneNumber(String number);
}
