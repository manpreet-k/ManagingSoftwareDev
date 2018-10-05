package ast2;

import ast2.Expression;
import ast2.InfixExpression;
import ast2.NumberExpression;
import ast2.Operator;
import ast2.PrefixExpression;
import ast2.StringExpression;
import ast2.VariableExpression;

/**
 * ExpressionFactory class allows the creation of specialized versions of the
 * expression by creating subclasses of Expression
 * 
 * @author Manpreet Kaur
 *
 */
public class ExpressionFactory {

	/**
	 * This method creates a new object of InfixExpression for an operator and
	 * expressions
	 * 
	 * @param operation :  Operator for the infix expression
	 * 
	 * @param operand1 : First operand for the infix expression
	 * 
	 * @param operand2 : Second operand for the infix expression
	 * 
	 */
	public Expression makeInfixExp(Operator operation, Expression firstOperand, Expression secondOperand) {
		return new InfixExpression(operation, firstOperand, secondOperand);
	}

	/**
	 * This method creates a new object of PrefixExpression for an operator and
	 * expressions
	 * 
	 * @param operation :  Operator for the prefix expression
	 * 
	 * @param operand1 : First operand for the prefix expression
	 * 
	 * @param operand2 : Second operand for the prefix expression
	 * 
	 */
	public Expression makeprefixExp(Operator operation, Expression firstOperand, Expression secondOperand) {
		return new PrefixExpression(operation, firstOperand, secondOperand);
	}

	/**
	 * This method creates a new object of NumberExpression for the int
	 * 
	 * @param value :  Number of type int for the number expression
	 * 
	 */
	public Expression makeNumberExp(int value) {
		return new NumberExpression(value);
	}

	/**
	 * This method creates a new object of NumberExpression for the double
	 * 
	 * @param value :  Number of type double for the number expression
	 * 
	 */
	public Expression makeNumberExp(double value) {
		return new NumberExpression(value);
	}

	/**
	 * This method creates a new object of StringExpression for a string
	 * 
	 * @param strExp :  String for the string expression
	 *  
	 */
	public Expression makeStringExp(String value) {
		return new StringExpression(value);
	}

	/**
	 * This method creates a new object of string for a variable expression
	 * 
	 * @param var :  String for the variable expression
	 * 
	 */
	public Expression makeVariableExp(String value) {
		return new VariableExpression(value);
	}

	/**
	 * This method creates a new object of variable for a variable expression
	 * 
	 * @param var :  Variable for the variable expression
	 * 
	 */
	public Expression makeVariableExp(Variable value) {
		return new VariableExpression(value);
	}
}
