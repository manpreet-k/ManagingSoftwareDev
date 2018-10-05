package ast4a;

import ast4c.Expression;
import ast4c.InfixExpression;
import ast4c.NumberExpression;
import ast4c.Operator;
import ast4c.PrefixExpression;
import ast4c.StringExpression;
import ast4c.Variable;
import ast4c.VariableExpression;

/**
 * ExpressionFactory class allows the creation of specialized versions of the
 * expression by creating subclasses of Expression
 * 
 * @author Manpreet Kaur
 *
 */
public class ExpressionFactory {
	/**
	 * Counter for number of PrefixExpression nodes created
	 */
	private int prefixCtr = 0;

	/**
	 * Counter for number of InfixExpression nodes created
	 */
	private int infixCtr = 0;

	/**
	 * Counter for number of NumberExpression nodes created
	 */
	private int numCtr = 0;

	/**
	 * Counter for number of StringExpression nodes created
	 */
	private int stringCtr = 0;

	/**
	 * Counter for number of VariableExpression nodes created
	 */
	private int varCtr = 0;

	/**
	 * ExpressionFactory instance object for singleton design
	 */
	private static ExpressionFactory factory = null;

	/**
	 * Constructor of ExpressionFactory made private for singleTon design
	 */
	private ExpressionFactory() {
	}

	/**
	 * This method returns the factory instance, if it exists. Otherwise creates a
	 * new one and returns that
	 * 
	 * @return ExpressionFactory : Instance of ExpressionFactory class
	 */
	public static ExpressionFactory instance() {
		if (factory == null) {
			factory = new ExpressionFactory();
		}

		return factory;
	}

	/**
	 * This method creates a new object of InfixExpression for an operator and
	 * expressions
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
	public Expression makeInfixExp(Operator operation, Expression firstOperand, Expression secondOperand) {
		infixCtr++;
		return new InfixExpression(operation, firstOperand, secondOperand);
	}

	/**
	 * This method creates a new object of PrefixExpression for an operator and
	 * expressions
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
	public Expression makeprefixExp(Operator operation, Expression firstOperand, Expression secondOperand) {
		prefixCtr++;
		return new PrefixExpression(operation, firstOperand, secondOperand);
	}

	/**
	 * This method creates a new object of NumberExpression for the int
	 * 
	 * @param value
	 *            : Number of type int for the number expression
	 * 
	 */
	public Expression makeNumberExp(int value) {
		numCtr++;
		return new NumberExpression(value);
	}

	/**
	 * This method creates a new object of NumberExpression for the double
	 * 
	 * @param value
	 *            : Number of type double for the number expression
	 * 
	 */
	public Expression makeNumberExp(double value) {
		numCtr++;
		return new NumberExpression(value);
	}

	/**
	 * This method creates a new object of StringExpression for a string
	 * 
	 * @param strExp
	 *            : String for the string expression
	 * 
	 */
	public Expression makeStringExp(String value) {
		stringCtr++;
		return new StringExpression(value);
	}

	/**
	 * This method creates a new object of string for a variable expression
	 * 
	 * @param var
	 *            : String for the variable expression
	 * 
	 */
	public Expression makeVariableExp(String value) {
		varCtr++;
		return new VariableExpression(value);
	}

	/**
	 * This method creates a new object of variable for a variable expression
	 * 
	 * @param var
	 *            : Variable for the variable expression
	 * 
	 */
	public Expression makeVariableExp(Variable value) {
		varCtr++;
		return new VariableExpression(value);
	}

	/**
	 * This method prints the number of each of the specialized nodes created to
	 * standard output
	 * 
	 */
	public void report() {
		StringBuilder report = new StringBuilder();

		if (prefixCtr > 0)
			report.append("Number of PrefixExpression nodes = " + prefixCtr + "\n");
		if (infixCtr > 0)
			report.append("Number of InfixExpression nodes = " + infixCtr + "\n");
		if (numCtr > 0)
			report.append("Number of NumberExpression nodes = " + numCtr + "\n");
		if (stringCtr > 0)
			report.append("Number of StringExpression nodes = " + stringCtr + "\n");
		if (varCtr > 0)
			report.append("Number of VariableExpression nodes = " + varCtr + "\n");

		System.out.print(report);
	}

	/**
	 * This method resets the counters.
	 * 
	 */
	public void resetCounters() {
		prefixCtr = 0;
		infixCtr = 0;
		numCtr = 0;
		stringCtr = 0;
		varCtr = 0;
	}
}
