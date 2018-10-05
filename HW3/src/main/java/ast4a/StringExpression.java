/**
 * 
 */
package ast4a;

/**
 * This class provides the text representation of the string expression created
 * by the string
 * 
 * @author Manpreet Kaur
 *
 */
public class StringExpression extends Expression {
	/**
	 * String value of the StringExpression
	 */
	private String strText;

	/**
	 * This constructor sets the value for StringExpression string for a string
	 * 
	 * @param strExp
	 *            : String for the string expression
	 * 
	 */
	public StringExpression(String strExp) {
		strText = strExp;
	}

	/**
	 * @return The StringExpression as a String
	 */
	@Override
	public String textRepresentation() {
		return strText;
	}

	/**
	 * @return The string representation of the StringExpression object
	 */
	@Override
	public String toString() {
		return strText;
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
