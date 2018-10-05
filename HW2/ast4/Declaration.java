/**
 * 
 */
package ast4;

/**
 * Declaration class declares a variable.
 * 
 * @author Manpreet Kaur
 *
 */
public class Declaration implements Statement {
	/**
	 * String constant for text "var"
	 */
	private static final String TEXT_VAR = "var ";

	/**
	 * The string value for the Declaration statement
	 */
	private String declText;

	/**
	 * This constructor sets the string value of the declaration statement for a Variable
	 * 
	 * @param var : Variable which is to be declared.
	 */
	public Declaration(Variable var) {
		declText = TEXT_VAR + var.toString();
	}
	
	/**
	 * This constructor sets the string value of the declaration statement for an Expression
	 * 
	 * @param var : Variable which is to be declared.
	 */
	public Declaration(Expression var) {
		declText = TEXT_VAR + var.textRepresentation();
	}

	/**
	 * This method takes the variable and returns the string representation of this
	 * declaration statement
	 * 
	 * @return The Declaration statement as a String
	 */
	@Override
	public String textRepresentation() {
		return declText;
	}

	/**
	 * This method returns the String value of the object Assignment
	 * 
	 * @return The string representation of the Declaration object
	 */
	@Override
	public String toString() {
		return declText;
	}
}
