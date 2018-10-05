/**
 * 
 */
package ast;

/**
 * This class provides the text representation of the variable created
 * by string
 * 
 * @author Manpreet Kaur
 * 
 */
public class Variable {
	/**
	 * Value of the variable
	 */
	private String var;

	/**
	 * This constructor sets the value for string for a variable
	 * 
	 * @param var :  String for the variable
	 * 
	 */
	public Variable(String var) {
		this.var = var;
	}
	
	/**
	 * @return The string representation of the Variable object
	 */
	@Override
	public String toString() {
		return var;
	}
}
