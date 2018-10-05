/**
 * 
 */
package ast4b;

/**
 * This class provides the text representation of the Prefix expression created
 * by the operator and expressions
 * 
 * @author Manpreet Kaur
 *
 */
public class PrefixExpression extends Expression {
	/**
	 * String constant for whitespace
	 */
	private static final String SPACE = " ";

	/**
	 * Text representation of the prefixExpression
	 */
	private String prefixText;

	/**
	 * This constructor sets the value for PrefixExpression string for an operator
	 * and expressions
	 * 
	 * @param operation
	 *            : Operator for the prefix expression
	 * 
	 * @param operand1
	 *            : First operand for the prefix expression
	 * 
	 * @param operand2
	 *            : Second operand for the prefix expression
	 * 
	 */
	public PrefixExpression(Operator operation, Expression operand1, Expression operand2) {
		prefixText = operation.toString() + SPACE + operand1.textRepresentation() + SPACE
				+ operand2.textRepresentation();
	}

	/**
	 * @return The PrefixExpression as a String
	 */
	@Override
	public String textRepresentation() {
		return prefixText;
	}

	/**
	 * @return The string representation of the PrefixExpression object
	 */
	@Override
	public String toString() {
		return prefixText;
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
