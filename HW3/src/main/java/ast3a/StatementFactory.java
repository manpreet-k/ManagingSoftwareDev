package ast3a;

import ast3a.Assignment;
import ast3a.Declaration;
import ast3a.Expression;
import ast3a.Sequence;
import ast3a.Statement;
import ast3a.Variable;

/**
 * StatementFactory class allows the creation of specialized versions of the
 * expression by creating subclasses of Statement
 * 
 * @author Manpreet Kaur
 *
 */
public class StatementFactory {
	/**
	 * Counter for number of Sequence nodes created
	 */
	private int seqCtr = 0;

	/**
	 * Counter for number of Declaration nodes created
	 */
	private int declCtr = 0;

	/**
	 * Counter for number of Assignment nodes created
	 */
	private int assignCtr = 0;

	/**
	 * StatementFactory instance object for singleton design
	 */
	private static StatementFactory factory = null;

	/**
	 * Constructor of StatementFactory made private for singleTon design
	 */
	private StatementFactory() {
	}

	/**
	 * This method returns the factory instance, if it exists. Otherwise creates a
	 * new one and returns that
	 * 
	 * @return StatementFactory : Instance of StatementFactory class
	 */
	public static StatementFactory instance() {
		if (factory == null) {
			factory = new StatementFactory();
		}

		return factory;
	}

	/**
	 * This method creates a new object of declaration for a Variable
	 * 
	 * @param var
	 *            : Variable which is to be declared.
	 */
	public Declaration makeDeclaration(Variable var) {
		declCtr++;
		return new Declaration(var);
	}

	/**
	 * This method creates a new object of declaration for an Expression
	 * 
	 * @param var
	 *            : Expression which is to be declared.
	 */
	public Declaration makeDeclaration(Expression var) {
		declCtr++;
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
		assignCtr++;
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
		assignCtr++;
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
		seqCtr++;
		return new Sequence(stmt1, stmt2);
	}

	/**
	 * This method prints the number of each of the specialized nodes created to
	 * standard output
	 * 
	 */
	public void report() {
		StringBuilder report = new StringBuilder();

		if (seqCtr > 0)
			report.append("Number of Sequence nodes = " + seqCtr + "\n");
		if (declCtr > 0)
			report.append("Number of Declaration nodes = " + declCtr + "\n");
		if (assignCtr > 0)
			report.append("Number of Assignment nodes = " + assignCtr + "\n");

		System.out.print(report);
	}

	/**
	 * This method resets the counters
	 * 
	 */
	public void resetCounters() {
		seqCtr = 0;
		declCtr = 0;
		assignCtr = 0;
	}
}
