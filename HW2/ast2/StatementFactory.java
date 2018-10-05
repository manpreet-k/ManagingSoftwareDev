/**
 * 
 */
package ast2;

import ast2.Assignment;
import ast2.Declaration;
import ast2.Expression;
import ast2.Sequence;
import ast2.Statement;
import ast2.Variable;

/**
 * StatementFactory class allows the creation of specialized versions of the
 * expression by creating subclasses of Statement
 * 
 * @author Manpreet Kaur
 *
 */
public class StatementFactory {
	
	/**
	 * This method creates a new object of declaration for a Variable
	 * 
	 * @param var : Variable which is to be declared.
	 */
	public Declaration makeDeclaration(Variable var) {
		return new Declaration(var);
	}
	
	/**
	 * This method creates a new object of declaration for an Expression
	 * 
	 * @param var : Expression which is to be declared.
	 */
	public Declaration makeDeclaration(Expression var) {
		return new Declaration(var);
	}
	
	/**
	 * This method creates a new object of Assignment string for a variable and an
	 * expression
	 * 
	 * @param var
	 *            Variable to which the value is to be assigned
	 * @param exp
	 *            Value which will be assignment to the variable
	 */
	public Assignment makeAssignment(Variable var, Expression exp) {
		return new Assignment(var, exp);
	}
	
	/**
	 * This method creates a new object of Assignment string for a variable and an
	 * expression
	 * 
	 * @param var
	 *            Expression to which the value is to be assigned
	 * @param exp
	 *            Value which will be assignment to the Expression
	 */
	public Assignment makeAssignment(Expression var, Expression exp) {
		return new Assignment(var, exp);
	}
	
	/**
	 * This method creates a new object of PrefixExpression string for an operator
	 * and expressions
	 * 
	 * @param firstStatement
	 *            : First statement in the sequence
	 * 
	 * @param secondStatement
	 *            : Second statement in the sequence
	 * 
	 */
	public Sequence makeSequence(Statement stmt1, Statement stmt2) {
		return new Sequence(stmt1, stmt2);
	}
}
