package ast4c;

/**
 * This class defines the visit operations for each type of node in the AST
 * 
 */
public class ASTSearchVisitor implements ASTVisitor {

	/**
	 * NodeSet to store the Nodes that match the search criterion
	 */
	private NodeSet nodes;

	/**
	 * Variable that needs to be searched
	 */
	private Variable var;

	/**
	 * VariableExpression that needs to be searched
	 */
	private VariableExpression varExp;

	/**
	 * This constructor sets the Variable and initializes the NodeSet.
	 * 
	 * @param var
	 *            : Variable to be checked
	 * 
	 */
	public ASTSearchVisitor(Variable var) {
		nodes = new NodeSet();
		this.var = var;
	}

	/**
	 * This constructor sets the VariableExpression and initializes the NodeSet.
	 * 
	 * @param varExp
	 *            : VariableExpression to be checked
	 * 
	 */
	public ASTSearchVisitor(VariableExpression varExp) {
		nodes = new NodeSet();
		this.varExp = varExp;
	}

	/**
	 * This method defines the visit function for StringExpression
	 */
	@Override
	public void visit(StringExpression strExp) {
		// No implementation necessary
	}

	/**
	 * This method defines the visit function for InfixExpression
	 */
	@Override
	public void visit(InfixExpression infixExp) {
		// No implementation necessary
	}

	/**
	 * This method defines the visit function for NumberExpression
	 */
	@Override
	public void visit(NumberExpression numExp) {
		// No implementation necessary
	}

	/**
	 * This method defines the visit function for PrefixExpression
	 */
	@Override
	public void visit(PrefixExpression prefixExp) {
		// No implementation necessary
	}

	/**
	 * This method defines the visit function for VariableExpression
	 */
	@Override
	public void visit(VariableExpression varExp) {
		// No implementation necessary
	}

	/**
	 * This method checks if the variable name exists in the Assignment
	 */
	@Override
	public void visit(Assignment assignExp) {
		String assign = assignExp.textRepresentation();
		int equalIndex = assign.indexOf(" =");

		String varName = null;

		if (var != null) {
			varName = var.toString();
		} else {
			varName = varExp.textRepresentation();
		}

		if (assign.substring(0, equalIndex).equals(varName)) {
			nodes.add(assignExp);
		}
	}

	/**
	 * This method checks if the variable name exists in the Declaration
	 */
	@Override
	public void visit(Declaration declExp) {
		String decl = declExp.textRepresentation();

		String checkVariable = getVariableName();

		if (decl.substring(4).equals(checkVariable)) {
			nodes.add(declExp);
		}
	}

	/**
	 * This method returns the name of the variable or Variable expression
	 * 
	 * @return Variable or VariableExpression name
	 */
	private String getVariableName() {
		if (var != null) {
			return var.toString();
		} else {
			return varExp.textRepresentation();
		}
	}

	/**
	 * This method defines the visit function for Sequence
	 */
	@Override
	public void visit(Sequence seqExp) {
		// No implementation necessary
	}

	/**
	 * @return the nodes
	 */
	public NodeSet getNodes() {
		return nodes;
	}

}
