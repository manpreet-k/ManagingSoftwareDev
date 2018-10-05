package ast4a;

/**
 * This class defines the visit operations for each type of node in the AST
 * 
 */
public interface ASTVisitor {
	/**
	 * This method defines the visit function for StringExpression
	 */
	public void visit(StringExpression strExp);

	/**
	 * This method defines the visit function for InfixExpression
	 */
	public void visit(InfixExpression infixExp);

	/**
	 * This method defines the visit function for NumberExpression
	 */
	public void visit(NumberExpression numExp);

	/**
	 * This method defines the visit function for PrefixExpression
	 */
	public void visit(PrefixExpression prefixExp);

	/**
	 * This method defines the visit function for VariableExpression
	 */
	public void visit(VariableExpression varExp);

	/**
	 * This method defines the visit function for Assignment
	 */
	public void visit(Assignment assignExp);

	/**
	 * This method defines the visit function for Declaration
	 */
	public void visit(Declaration declExp);

	/**
	 * This method defines the visit function for Sequence
	 */
	public void visit(Sequence seqExp);
}
