package asttests4c;

import static org.junit.Assert.*;

import org.junit.Test;

import ast4c.ASTSearchVisitor;
import ast4c.BitVector;
import ast4c.Expression;
import ast4c.ExpressionFactory;
import ast4c.IBitVector;
import ast4c.NodeSet;
import ast4c.Operator;
import ast4c.Statement;
import ast4c.StatementFactory;
import ast4c.Variable;
import ast4c.VariableExpression;

/**
 * This class tests the ASTSearchVisitor class
 * 
 * @author Manpreet Kaur
 * 
 * */
public class ASTSearchVisitorTests {
	/**
	 * This method tests the report method for Declaration
	 * 
	 */
	@Test
	public void testAcceptDecl_1Stmt() {
		Variable x = new Variable("x");
		ASTSearchVisitor visitor = new ASTSearchVisitor(x);
		StatementFactory stmtFactory = StatementFactory.instance();
		Statement decl = stmtFactory.makeDeclaration(x);
		
		decl.accept(visitor);
		NodeSet nodes = visitor.getNodes();

		assertEquals(true, nodes.contains(decl));
	}

	/**
	 * This method tests the report method of Expression containing NumberExpression
	 * and InfixExpression
	 * 
	 */
	@Test
	public void testAcceptVarNum_3Exp() {
		VariableExpression x = new VariableExpression("x");
		ExpressionFactory expFactory = ExpressionFactory.instance();
		ASTSearchVisitor visitor = new ASTSearchVisitor(x);

		Operator plus = new Operator("+");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression exp = expFactory.makeInfixExp(plus, one, two);

		one.accept(visitor);
		two.accept(visitor);
		exp.accept(visitor);

		NodeSet nodes = visitor.getNodes();

		assertEquals(false, nodes.contains(one));
	}

	/**
	 * This method tests the report method of Statement containing Assignment,
	 * Declaration and Sequence
	 * 
	 */
	@Test
	public void testAcceptAssign_3Exp3Stmt() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();
		Variable x = new Variable("x");
		ASTSearchVisitor visitor = new ASTSearchVisitor(x);
		
		Operator plus = new Operator("+");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression exp = expFactory.makeInfixExp(plus, one, two);

		Statement decl = stmtFactory.makeDeclaration(x);
		Statement assign = stmtFactory.makeAssignment(x, exp);
		Statement seq = stmtFactory.makeSequence(decl, assign);

		one.accept(visitor);
		two.accept(visitor);
		exp.accept(visitor);
		decl.accept(visitor);
		assign.accept(visitor);
		seq.accept(visitor);

		NodeSet nodes = visitor.getNodes();

		assertEquals(true, nodes.contains(assign));
	}

	/**
	 * This method tests the report method of Expression containing PrefixExpression
	 * and NumberExpression
	 * 
	 */
	@Test
	public void testAcceptPrefix_7Exp_NotExists() {
		VariableExpression x = new VariableExpression("x");
		ExpressionFactory expFactory = ExpressionFactory.instance();
		ASTSearchVisitor visitor = new ASTSearchVisitor(x);

		Operator plus = new Operator("+");
		Operator mul = new Operator("*");
		Operator div = new Operator("/");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression three = expFactory.makeNumberExp(3);
		Expression four = expFactory.makeNumberExp(4);
		Expression exp1 = expFactory.makeprefixExp(plus, two, three);
		Expression exp2 = expFactory.makeprefixExp(mul, one, exp1);
		Expression exp3 = expFactory.makeprefixExp(div, exp2, four);

		one.accept(visitor);
		two.accept(visitor);
		three.accept(visitor);
		four.accept(visitor);
		exp1.accept(visitor);
		exp2.accept(visitor);
		exp3.accept(visitor);

		NodeSet nodes = visitor.getNodes();

		assertEquals(false, nodes.contains(exp1));
	}

	/**
	 * This method tests the report method for Statement containing Sequence and
	 * Assignment
	 * 
	 */
	@Test
	public void testAcceptAssign_2Exp1Var_NotExists() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		VariableExpression x = new VariableExpression("x");
		ASTSearchVisitor visitor = new ASTSearchVisitor(x);		

		Expression a = expFactory.makeStringExp("A");
		Statement assign = stmtFactory.makeAssignment(a, x);
		
		x.accept(visitor);
		a.accept(visitor);
		assign.accept(visitor);

		NodeSet nodes = visitor.getNodes();

		assertEquals(false, nodes.contains(assign));
	}

	/**
	 * This method tests the report method for StringExpression
	 * 
	 */
	@Test
	public void testAcceptStr_1Exp() {
		ExpressionFactory expFactory = ExpressionFactory.instance();
		Variable v = new Variable("A");
		ASTSearchVisitor visitor = new ASTSearchVisitor(v);
		Expression a = expFactory.makeStringExp("A");
		
		a.accept(visitor);
		NodeSet nodes = visitor.getNodes();

		assertEquals(false, nodes.contains(a));
	}

	/**
	 * This method tests the toString method of VariableExpression
	 * 
	 */
	@Test
	public void testAcceptVar_1Exp() {
		VariableExpression x = new VariableExpression("x");
		ASTSearchVisitor visitor = new ASTSearchVisitor(x);		

		x.accept(visitor);
		NodeSet nodes = visitor.getNodes();
		assertEquals(false, nodes.contains(x));
	}
	
	/**
	 * This method tests the accept method for Statement containing Sequence and
	 * Assignment
	 * 
	 */
	@Test
	public void testAcceptAssign_2Exp_1Stmt() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();
		VariableExpression x = new VariableExpression("x");
		ASTSearchVisitor visitor = new ASTSearchVisitor(x);

		
		Expression one = expFactory.makeNumberExp(1);
		Statement assign = stmtFactory.makeAssignment(x, one);
		
		x.accept(visitor);
		one.accept(visitor);
		assign.accept(visitor);

		NodeSet nodes = visitor.getNodes();

		assertEquals(true, nodes.contains(assign));
	}
	
	/**
	 * Test the copy method of the BitVector with numbers between 0-63 only
	 * */
	@Test
	public void testCopy() {
		IBitVector vector = new BitVector();
		IBitVector vectorNew = new BitVector();
		int[] input = new int[] {7, 4, 12, 30, 31, 32, 63};
	
		setBitVector(vector, input);
				
		assertEquals(false, vectorNew.get(63));
		
		vectorNew.copy(vector);
		assertEquals(true, vectorNew.get(63));
	}
	
	/**
	 * Sets the values from the input array to the BitVecor object
	 * 
	 * @param vector : BitVector object where the bits must be set
	 * @param input : The list of integers for which bits must be set
	 */
	private void setBitVector(IBitVector vector, int[] input) {
		for(int i = 0; i < input.length; i++) {
			vector.set(input[i]);
		}
	}

}
