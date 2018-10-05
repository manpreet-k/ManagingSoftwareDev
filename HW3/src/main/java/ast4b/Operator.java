/**
 * 
 */
package ast4b;

/**
 * This class provides the text representation of the operator
 * 
 * @author Manpreet Kaur
 *
 */
public class Operator {
	/**
	 * Value of the operator
	 */
	private String oper;

	/**
	 * This constructor sets the value for an operator
	 * 
	 * @param oper
	 *            : Operator for the expression
	 * 
	 */
	public Operator(String oper) {
		this.oper = oper;
	}

	/**
	 * @return The string representation of the Operator object
	 */
	@Override
	public String toString() {
		return oper;
	}
}
