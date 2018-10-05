/**
 * 
 */
package ast2;

/**
 * Assignment class assigns a value to a variable or an expression and provides
 * a text representation of this assignment.
 * 
 * @author Manpreet Kaur
 *
 */
public class Assignment implements Statement {
	/**
	 * String constant for equal to symbol
	 */
	private static final String EQUAL = " = ";

	/**
	 * String value of assignment statement
	 */
	private String assignText;

	/**
	 * This constructor sets the value for Assignment string for a variable and an
	 * expression
	 * 
	 * @param var
	 *            Variable to which the value is to be assigned
	 * @param exp
	 *            Value which will be assignment to the variable
	 */
	public Assignment(Variable var, Expression exp) {
		assignText = var.toString() + EQUAL + exp.textRepresentation();
	}

	/**
	 * This constructor sets the value for Assignment string for a variable and an
	 * expression
	 * 
	 * @param var
	 *            Expression to which the value is to be assigned
	 * @param exp
	 *            Value which will be assignment to the Expression
	 */
	public Assignment(Expression var, Expression exp) {
		assignText = var.textRepresentation() + EQUAL + exp.textRepresentation();
	}

	/**
	 * This method takes the values of variable and expression and returns the
	 * string representation of this assignment statement
	 * 
	 * @return The Assignment statement as a String
	 */
	@Override
	public String textRepresentation() {
		return assignText;
	}

	/**
	 * This method returns the String value of the object Assignment
	 * 
	 * @return The string representation of the Assignment object
	 */
	@Override
	public String toString() {
		return assignText;
	}
}
