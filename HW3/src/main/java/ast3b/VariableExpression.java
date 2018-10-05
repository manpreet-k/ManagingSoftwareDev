/**
 * 
 */
package ast3b;

import ast3b.Variable;

/**
 * This class provides the text representation of the variable expression
 * created by string
 * 
 * @author Manpreet Kaur
 *
 */
public class VariableExpression extends Expression {
	/**
	 * Value of the variable expression
	 */
	private String var;

	/**
	 * This constructor sets the value for string for a variable expression
	 * 
	 * @param var
	 *            : String for the variable expression
	 * 
	 */
	public VariableExpression(String var) {
		this.var = var;
	}

	/**
	 * This constructor sets the value for Variable for a variable expression
	 * 
	 * @param var
	 *            : String for the variable expression
	 * 
	 */
	public VariableExpression(Variable var) {
		this.var = var.toString();
	}

	/**
	 * @return The string value of the VariableExpression
	 */
	@Override
	public String textRepresentation() {
		return var;
	}

	/**
	 * @return The string representation of the VariableExpression object
	 */
	@Override
	public String toString() {
		return var;
	}
}
