package asttests4b;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ast4b.ASTNodeCountVisitor;
import ast4b.BitVector;
import ast4b.Expression;
import ast4b.ExpressionFactory;
import ast4b.IBitVector;
import ast4b.Operator;
import ast4b.Statement;
import ast4b.StatementFactory;
import ast4b.Variable;

/**
 * This class tests the ASTNodeCountVisitor class
 * 
 * @author Manpreet Kaur
 * 
 * */
public class ASTNodeCountVisitorTests {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(System.out);
		System.setErr(System.err);
	}

	/**
	 * This method tests the report method for Declaration
	 * 
	 */
	@Test
	public void testVisitDecl() {
		ASTNodeCountVisitor visitor = new ASTNodeCountVisitor();
		StatementFactory stmtFactory = StatementFactory.instance();
		Variable x = new Variable("x");

		Statement decl = stmtFactory.makeDeclaration(x);
		decl.accept(visitor);

		String testOutput = "Number of Declaration nodes = 1\n";

		visitor.report();

		assertEquals(testOutput, outContent.toString());
	}

	/**
	 * This method tests the report method of Expression containing NumberExpression
	 * and InfixExpression
	 * 
	 */
	@Test
	public void testVisitInfixNum() {
		ExpressionFactory expFactory = ExpressionFactory.instance();
		ASTNodeCountVisitor visitor = new ASTNodeCountVisitor();

		Operator plus = new Operator("+");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression exp = expFactory.makeInfixExp(plus, one, two);

		one.accept(visitor);
		two.accept(visitor);
		exp.accept(visitor);

		visitor.report();

		String testOutput = "Number of InfixExpression nodes = 1\n"
				+ "Number of NumberExpression nodes = 2\n";

		assertEquals(testOutput, outContent.toString());
	}

	/**
	 * This method tests the report method of Statement containing Assignment,
	 * Declaration and Sequence
	 * 
	 */
	@Test
	public void testVisitInfixNumAssign() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();
		ASTNodeCountVisitor visitor = new ASTNodeCountVisitor();

		Variable x = new Variable("x");
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

		visitor.report();

		String testOutput = "Number of InfixExpression nodes = 1\n"
				+ "Number of NumberExpression nodes = 2\n"
				+ "Number of Assignment nodes = 1\n"
				+ "Number of Declaration nodes = 1\n"
				+ "Number of Sequence nodes = 1\n";

		assertEquals(testOutput, outContent.toString());
	}

	/**
	 * This method tests the report method of Expression containing PrefixExpression
	 * and NumberExpression
	 * 
	 */
	@Test
	public void testVisitPrefixNum() {
		ExpressionFactory expFactory = ExpressionFactory.instance();
		ASTNodeCountVisitor visitor = new ASTNodeCountVisitor();

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

		String testOutput = "Number of PrefixExpression nodes = 3\n"
				+ "Number of NumberExpression nodes = 4\n";

		visitor.report();

		assertEquals(testOutput, outContent.toString());
	}

	/**
	 * This method tests the report method for Statement containing Sequence and
	 * Assignment
	 * 
	 */
	@Test
	public void testVisitNumStrVarAssignSeq() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();
		ASTNodeCountVisitor visitor = new ASTNodeCountVisitor();

		Expression x = expFactory.makeVariableExp("x");
		Expression one = expFactory.makeNumberExp(1);
		Statement assign = stmtFactory.makeAssignment(x, one);

		Expression a = expFactory.makeStringExp("A");
		Statement assign1 = stmtFactory.makeAssignment(a, x);
		Statement seq = stmtFactory.makeSequence(assign, assign1);

		x.accept(visitor);
		one.accept(visitor);
		assign.accept(visitor);
		a.accept(visitor);
		assign1.accept(visitor);
		seq.accept(visitor);

		String testOutput = "Number of NumberExpression nodes = 1\n"
				+ "Number of StringExpression nodes = 1\n"
				+ "Number of VariableExpression nodes = 1\n"
				+ "Number of Assignment nodes = 2\n"
				+ "Number of Sequence nodes = 1\n";

		visitor.report();

		assertEquals(testOutput, outContent.toString());
	}

	/**
	 * This method tests the report method for StringExpression
	 * 
	 */
	@Test
	public void testVisitStr() {
		ExpressionFactory expFactory = ExpressionFactory.instance();
		ASTNodeCountVisitor visitor = new ASTNodeCountVisitor();

		Expression a = expFactory.makeStringExp("A");
		a.accept(visitor);

		String testOutput = "Number of StringExpression nodes = 1\n";

		visitor.report();

		assertEquals(testOutput, outContent.toString());
	}

	/**
	 * This method tests the toString method of VariableExpression
	 * 
	 */
	@Test
	public void testVisitVar() {
		ExpressionFactory expFactory = ExpressionFactory.instance();
		ASTNodeCountVisitor visitor = new ASTNodeCountVisitor();

		Expression x = expFactory.makeVariableExp("x");
		x.accept(visitor);

		String testOutput = "Number of VariableExpression nodes = 1\n";

		visitor.report();

		assertEquals(testOutput, outContent.toString());
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
