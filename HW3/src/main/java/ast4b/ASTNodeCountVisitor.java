package ast4b;

/**
 * This class defines the visit operations for each type of node in the AST
 * 
 */
public class ASTNodeCountVisitor implements ASTVisitor {

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
	 * This method defines the visit function for StringExpression
	 */
	@Override
	public void visit(StringExpression strExp) {
		stringCtr++;
	}

	/**
	 * This method defines the visit function for InfixExpression
	 */
	@Override
	public void visit(InfixExpression infixExp) {
		infixCtr++;
	}

	/**
	 * This method defines the visit function for NumberExpression
	 */
	@Override
	public void visit(NumberExpression numExp) {
		numCtr++;
	}

	/**
	 * This method defines the visit function for PrefixExpression
	 */
	@Override
	public void visit(PrefixExpression prefixExp) {
		prefixCtr++;
	}

	/**
	 * This method defines the visit function for VariableExpression
	 */
	@Override
	public void visit(VariableExpression varExp) {
		varCtr++;
	}

	/**
	 * This method defines the visit function for Assignment
	 */
	@Override
	public void visit(Assignment assignExp) {
		assignCtr++;
	}

	/**
	 * This method defines the visit function for Declaration
	 */
	@Override
	public void visit(Declaration declExp) {
		declCtr++;
	}

	/**
	 * This method defines the visit function for Sequence
	 */
	@Override
	public void visit(Sequence seqExp) {
		seqCtr++;
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
		if (assignCtr > 0)
			report.append("Number of Assignment nodes = " + assignCtr + "\n");
		if (declCtr > 0)
			report.append("Number of Declaration nodes = " + declCtr + "\n");
		if (seqCtr > 0)
			report.append("Number of Sequence nodes = " + seqCtr + "\n");

		System.out.print(report);
	}

}
