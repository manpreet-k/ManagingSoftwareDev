/**
 * 
 */
package ast4b;

/**
 * This class provides the text representation of the Sequence statement created
 * by two statements
 * 
 * @author Manpreet Kaur
 *
 */
public class Sequence extends Statement {
	/**
	 * String constant for whitespace
	 */
	private static final String SPACE = " ";

	/**
	 * String constant for semicolon symbol
	 */
	private static final String SEMICOLON = ";";

	/**
	 * Text for statement of the sequence
	 */
	private StringBuilder statementText;

	private Statement[] statements;

	/**
	 * This constructor sets the value for PrefixExpression string for an operator
	 * and expressions
	 * 
	 * @param firstStatement
	 *            : First statement in the sequence
	 * 
	 * @param secondStatement
	 *            : Second statement in the sequence
	 * 
	 */
	public Sequence(Statement... statements) {
		if (statements.length > 0) {
			statementText = new StringBuilder();
			this.statements = statements;

			for (Statement stmt : this.statements) {
				statementText.append(stmt.textRepresentation());
				if (!stmt.textRepresentation().endsWith(";"))
					statementText.append(SEMICOLON);
				statementText.append(SPACE);
			}
		}
	}

	/**
	 * @return The Sequence as a String
	 * 
	 */
	@Override
	public String textRepresentation() {
		String stmtText = new String(statementText);
		return stmtText.trim();
	}

	/**
	 * @return The string representation of the Sequence object
	 * 
	 */
	@Override
	public String toString() {
		return String.valueOf(statementText);
	}

	/**
	 * This method calls the visit method the visitor class
	 * 
	 */
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
	}
}
