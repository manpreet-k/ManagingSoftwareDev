/**
 * 
 */
package ast4b;

/**
 * This class provides the text representation of the Number expression
 * 
 * @author Manpreet Kaur
 *
 */
public class NumberExpression extends Expression {
	/**
	 * Number value of the NumberExpression
	 */
	private String numExpText;

	/**
	 * This constructor sets the value for NumberExpression text from the int
	 * 
	 * @param value
	 *            : Number of type int for the number expression
	 * 
	 */
	public NumberExpression(int value) {
		this.numExpText = String.valueOf(value);
	}

	/**
	 * This constructor sets the value for NumberExpression text from the double
	 * 
	 * @param value
	 *            : Number of type double for the number expression
	 * 
	 */
	public NumberExpression(double value) {
		this.numExpText = String.valueOf(value);
	}

	/**
	 * @return The NumberExpression as a String
	 */
	@Override
	public String textRepresentation() {
		return numExpText;
	}

	/**
	 * @return The string representation of the NumberExpression object
	 */
	@Override
	public String toString() {
		return numExpText;
	}

	/**
	 * This method calls the visit method the visitor class
	 * 
	 */
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
