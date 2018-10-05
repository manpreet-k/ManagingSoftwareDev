/**
 * 
 */
package ast4c;

/**
 * This class provides the text representation of the Infix expression created
 * by the operator and expressions
 * 
 * @author Manpreet Kaur
 *
 */
public class InfixExpression extends Expression {
	/**
	 * String constant for whitespace
	 */
	private static final String SPACE = " ";

	/**
	 * Text representation of the infixExpression
	 */
	private String infixText;

	/**
	 * This constructor sets the value for InfixExpression string for an operator
	 * and expressions
	 * 
	 * @param operation
	 *            : Operator for the infix expression
	 * 
	 * @param operand1
	 *            : First operand for the infix expression
	 * 
	 * @param operand2
	 *            : Second operand for the infix expression
	 * 
	 */
	public InfixExpression(Operator operation, Expression operand1, Expression operand2) {
		infixText = operand1.textRepresentation() + SPACE + operation + SPACE + operand2.textRepresentation();
	}

	/**
	 * @return The InfixExpression as a String
	 */
	@Override
	public String textRepresentation() {
		return infixText;
	}

	/**
	 * @return The string representation of the InfixExpression object
	 */
	@Override
	public String toString() {
		return infixText;
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
