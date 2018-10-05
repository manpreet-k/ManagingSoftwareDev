package asttests3b;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ast3b.Expression;
import ast3b.ExpressionFactory;
import ast3b.Node;
import ast3b.Operator;
import ast3b.Statement;
import ast3b.StatementFactory;
import ast3b.Variable;

/**
 * ast4Tests class test the Abstract syntax tree implementation for the package
 * ast4.
 * 
 * @author Manpreet Kaur
 *
 */
public class AST3BTests {
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
	public void test1DeclReport() {
		StatementFactory stmtFactory = StatementFactory.instance();
		Variable x = new Variable("x");
		
		stmtFactory.resetCounters();
		Node.resetIds();

		Statement decl = stmtFactory.makeDeclaration(x);
		decl.textRepresentation();

		String testOutput = "Number of Declaration nodes = 1\n";

		stmtFactory.report();

		assertEquals(testOutput, outContent.toString());
	}

	/**
	 * This method tests the Sequence of Declaration of a Variable and Assignment of
	 * an InfixExpression consisting of two NumberExpressions and an operator
	 * 
	 */
	@Test
	public void testSeq_DeclAssignInfix_2Num() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		expFactory.resetCounters();
		stmtFactory.resetCounters();
		Node.resetIds();

		Variable x = new Variable("x");
		Operator plus = new Operator("+");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression exp = expFactory.makeInfixExp(plus, one, two);

		Statement decl = stmtFactory.makeDeclaration(x);
		Statement assign = stmtFactory.makeAssignment(x, exp);
		Statement seq = stmtFactory.makeSequence(decl, assign);

		assertEquals("var x; x = 1 + 2;", seq.textRepresentation());
	}

	/**
	 * This method tests the Sequence of Declaration of a Variable and Assignment of
	 * an PrefixExpression consisting of four NumberExpressions and three operators
	 * 
	 */
	@Test
	public void testSeq_DeclPrefix() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		Variable x = new Variable("x");
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

		Statement decl = stmtFactory.makeDeclaration(x);
		Statement assign = stmtFactory.makeAssignment(x, exp3);
		Statement seq = stmtFactory.makeSequence(decl, assign);

		assertEquals("var x; x = / * 1 + 2 3 4;", seq.textRepresentation());
	}

	/**
	 * This method tests the Sequence of Declaration of three Variables and
	 * Assignment of NumberExpressions to these three variables
	 * 
	 */
	@Test
	public void testsSeq_DeclAssign() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();

		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Variable z = new Variable("z");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression three = expFactory.makeNumberExp(3.3);

		Statement decl1 = stmtFactory.makeDeclaration(x);
		Statement decl2 = stmtFactory.makeDeclaration(y);
		Statement decl3 = stmtFactory.makeDeclaration(z);
		Statement assign1 = stmtFactory.makeAssignment(x, one);
		Statement assign2 = stmtFactory.makeAssignment(y, two);
		Statement assign3 = stmtFactory.makeAssignment(z, three);
		Statement seq1 = stmtFactory.makeSequence(decl1, decl2);
		Statement seq2 = stmtFactory.makeSequence(seq1, decl3);
		Statement seq3 = stmtFactory.makeSequence(seq2, assign1);
		Statement seq4 = stmtFactory.makeSequence(seq3, assign2);
		Statement seq5 = stmtFactory.makeSequence(seq4, assign3);

		assertEquals("var x; var y; var z; x = 1; y = 2; z = 3.3;", seq5.textRepresentation());
	}

	/**
	 * This method tests the Sequence of Declaration of three Variables and
	 * Assignment of NumberExpressions and StringExpression to these three variables
	 * and InfixExpression of these variables with two operator
	 * 
	 */
	@Test
	public void testSeq_DeclAssignInfix_3Exp() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();

		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Variable z = new Variable("z");
		Operator plus = new Operator("+");
		Operator mul = new Operator("*");

		Expression a = expFactory.makeStringExp("A");
		Expression b = expFactory.makeStringExp("B");
		Expression three = expFactory.makeNumberExp(3);

		Statement decl1 = stmtFactory.makeDeclaration(x);
		Statement decl2 = stmtFactory.makeDeclaration(y);
		Statement decl3 = stmtFactory.makeDeclaration(z);
		Statement assign1 = stmtFactory.makeAssignment(x, a);
		Statement assign2 = stmtFactory.makeAssignment(y, b);

		Expression exp1 = expFactory.makeInfixExp(plus, b, three);
		Expression exp2 = expFactory.makeInfixExp(mul, a, exp1);

		Statement assign3 = stmtFactory.makeAssignment(z, exp2);
		Statement seq1 = stmtFactory.makeSequence(decl1, decl2);
		Statement seq2 = stmtFactory.makeSequence(seq1, decl3);
		Statement seq3 = stmtFactory.makeSequence(seq2, assign1);
		Statement seq4 = stmtFactory.makeSequence(seq3, assign2);
		Statement seq5 = stmtFactory.makeSequence(seq4, assign3);

		assertEquals("var x; var y; var z; x = A; y = B; z = A * B + 3;", seq5.textRepresentation());
	}

	/**
	 * This method tests the Sequence of Declaration of one Variables and one
	 * VariiableExpression and Assignment of NumberExpressions to them and
	 * InfixExpression of these variables with two operator
	 * 
	 */
	@Test
	public void testSeq_DeclAssignInfix_2Exp() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();

		Variable y = new Variable("y");
		Operator plus = new Operator("+");

		Expression x = expFactory.makeVariableExp("x");
		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Statement decl1 = stmtFactory.makeDeclaration(x);
		Statement decl2 = stmtFactory.makeDeclaration(y);
		Statement assign1 = stmtFactory.makeAssignment(x, one);

		Expression exp = expFactory.makeInfixExp(plus, x, two);
		Statement assign2 = stmtFactory.makeAssignment(y, exp);
		Statement seq1 = stmtFactory.makeSequence(decl1, decl2);
		Statement seq2 = stmtFactory.makeSequence(seq1, assign1);
		Statement seq3 = stmtFactory.makeSequence(seq2, assign2);

		assertEquals("var x; var y; x = 1; y = x + 2;", seq3.textRepresentation());
	}

	/**
	 * This method tests the toString method of VariableExpression
	 * 
	 */
	@Test
	public void testVarExpToString() {
		ExpressionFactory expFactory = ExpressionFactory.instance();

		Expression x = expFactory.makeVariableExp("x");

		assertEquals("x", x.toString());
	}

	/**
	 * This method tests the toString method of Variable
	 * 
	 */
	@Test
	public void testVariableToString() {
		Variable x = new Variable("x");
		assertEquals("x", x.toString());
	}

	/**
	 * This method tests the toString method of NumberExpression
	 * 
	 */
	@Test
	public void testNumberExpToString() {
		ExpressionFactory expFactory = ExpressionFactory.instance();

		Expression one = expFactory.makeNumberExp(1);

		assertEquals("1", one.toString());
	}

	/**
	 * This method tests the toString method of StringExpression
	 * 
	 */
	@Test
	public void testStrExpToString() {
		ExpressionFactory expFactory = ExpressionFactory.instance();

		Expression a = expFactory.makeStringExp("A");

		assertEquals("A", a.toString());
	}

	/**
	 * This method tests the toString method of Declaration
	 * 
	 */
	@Test
	public void testDeclToString() {
		StatementFactory stmtFactory = StatementFactory.instance();
		Variable x = new Variable("x");

		Statement decl = stmtFactory.makeDeclaration(x);

		assertEquals("var x", decl.toString());
	}

	/**
	 * This method tests the toString method of Assignment
	 * 
	 */
	@Test
	public void testAssignToString() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();
		Variable x = new Variable("x");

		Expression one = expFactory.makeNumberExp(1);
		Statement assign = stmtFactory.makeAssignment(x, one);

		assertEquals("x = 1", assign.toString());
	}

	/**
	 * This method tests the toString method of Sequence
	 * 
	 */
	@Test
	public void testSeqToString() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();

		Expression x = expFactory.makeVariableExp("x");
		Expression one = expFactory.makeNumberExp(1);
		Statement assign = stmtFactory.makeAssignment(x, one);

		Expression a = expFactory.makeStringExp("A");
		Statement assign1 = stmtFactory.makeAssignment(a, x);
		Statement seq = stmtFactory.makeSequence(assign, assign1);

		assertEquals("x = 1; A = x; ", seq.toString());
	}

	/**
	 * This method tests the toString method of PrefixExpression
	 * 
	 */
	@Test
	public void testPrefixToString() {
		ExpressionFactory expFactory = ExpressionFactory.instance();
		Operator div = new Operator("/");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression prefix = expFactory.makeprefixExp(div, one, two);

		assertEquals("/ 1 2", prefix.toString());
	}

	/**
	 * This method tests the toString method of InfixExpression
	 * 
	 */
	@Test
	public void testInfixToString() {
		ExpressionFactory expFactory = ExpressionFactory.instance();
		Operator div = new Operator("-");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression infix = expFactory.makeInfixExp(div, one, two);

		assertEquals("1 - 2", infix.toString());
	}

	/**
	 * This method tests the Sequence of Declaration of two Variables and one
	 * VariableExpression and Assignment of NumberExpressions to them and
	 * InfixExpression of these variables with two operator
	 * 
	 */
	@Test
	public void testSeq_DeclAssignInfix_1Num() {
		Variable x1 = new Variable("x");
		Variable y = new Variable("y");
		Operator plus = new Operator("+");

		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();

		Expression x = expFactory.makeVariableExp(x1);
		Expression one = expFactory.makeNumberExp(1);

		Statement decl1 = stmtFactory.makeDeclaration(x);
		Statement decl2 = stmtFactory.makeDeclaration(y);
		Statement assign1 = stmtFactory.makeAssignment(x, one);

		Expression exp = expFactory.makeInfixExp(plus, x, x);
		Statement assign2 = stmtFactory.makeAssignment(y, exp);
		Statement seq1 = stmtFactory.makeSequence(decl1, decl2);
		Statement seq2 = stmtFactory.makeSequence(seq1, assign1);
		Statement seq3 = stmtFactory.makeSequence(seq2, assign2);

		assertEquals("var x; var y; x = 1; y = x + x;", seq3.textRepresentation());
	}

	/**
	 * This method tests the report method of Expression containing NumberExpression
	 * and InfixExpression
	 * 
	 */
	@Test
	public void testReport_2NumInfix() {
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		expFactory.resetCounters();
		Node.resetIds();

		Operator plus = new Operator("+");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression exp = expFactory.makeInfixExp(plus, one, two);
		exp.textRepresentation();
		expFactory.report();

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
	public void testReport_DeclAssign2NumInfix() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		expFactory.resetCounters();
		stmtFactory.resetCounters();
		Node.resetIds();

		Variable x = new Variable("x");
		Operator plus = new Operator("+");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression exp = expFactory.makeInfixExp(plus, one, two);

		Statement decl = stmtFactory.makeDeclaration(x);
		Statement assign = stmtFactory.makeAssignment(x, exp);
		Statement seq = stmtFactory.makeSequence(decl, assign);
		seq.textRepresentation();
		stmtFactory.report();

		String testOutput = "Number of Sequence nodes = 1\n"
				+ "Number of Declaration nodes = 1\n"
				+ "Number of Assignment nodes = 1\n";

		assertEquals(testOutput, outContent.toString());
	}

	/**
	 * This method tests the report method of Expression containing PrefixExpression
	 * and NumberExpression
	 * 
	 */
	@Test
	public void testReport_4Num2Prefix() {
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		expFactory.resetCounters();
		Node.resetIds();

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

		exp3.textRepresentation();

		String testOutput = "Number of PrefixExpression nodes = 3\n"
				+ "Number of NumberExpression nodes = 4\n";

		expFactory.report();

		assertEquals(outContent.toString(), testOutput);
	}

	/**
	 * This method tests the report method for Statement containing Sequence and
	 * Assignment
	 * 
	 */
	@Test
	public void testReport_SeqAssign1VarNumStr() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		expFactory.resetCounters();
		stmtFactory.resetCounters();
		Node.resetIds();

		Expression x = expFactory.makeVariableExp("x");
		Expression one = expFactory.makeNumberExp(1);
		Statement assign = stmtFactory.makeAssignment(x, one);

		Expression a = expFactory.makeStringExp("A");
		Statement assign1 = stmtFactory.makeAssignment(a, x);
		Statement seq = stmtFactory.makeSequence(assign, assign1);
		seq.textRepresentation();

		String testOutput = "Number of Sequence nodes = 1\n"
				+ "Number of Assignment nodes = 2\n";

		stmtFactory.report();

		assertEquals(outContent.toString(), testOutput);
	}

	/**
	 * This method tests the report method for StringExpression
	 * 
	 */
	@Test
	public void testReport_StrExp() {
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		expFactory.resetCounters();
		Node.resetIds();

		Expression a = expFactory.makeStringExp("A");
		a.textRepresentation();

		String testOutput = "Number of StringExpression nodes = 1\n";

		expFactory.report();

		assertEquals(outContent.toString(), testOutput);
	}

	/**
	 * This method tests the toString method of VariableExpression
	 * 
	 */
	@Test
	public void testReport_VarExp() {
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		expFactory.resetCounters();
		Node.resetIds();

		Expression x = expFactory.makeVariableExp("x");
		x.textRepresentation();

		String testOutput = "Number of VariableExpression nodes = 1\n";

		expFactory.report();

		assertEquals(outContent.toString(), testOutput);
	}

	/**
	 * This method tests the getId method of VariableExpression
	 */
	@Test
	public void testGetId_VarExp() {
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		expFactory.resetCounters();
		Node.resetIds();

		Expression x = expFactory.makeVariableExp("x");
		x.textRepresentation();

		assertEquals(0, x.getId());
	}

	/**
	 * This method tests the getNode method for VariableExpression
	 */
	@Test
	public void testGetNode_VarExp() {
		ExpressionFactory expFactory = ExpressionFactory.instance();

		Expression x = expFactory.makeVariableExp("x");
		int id = x.getId();
		x.textRepresentation();
		assertEquals(x, Node.getNode(id));
	}

	/**
	 * This method tests the getId method of StringExpression
	 */
	@Test
	public void testGetId_StrExp() {
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		expFactory.resetCounters();
		Node.resetIds();

		Expression x = expFactory.makeStringExp("A");
		x.textRepresentation();

		assertEquals(0, x.getId());
	}

	/**
	 * This method tests the getNode method for StringExpression
	 */
	@Test
	public void testGetNode_StrExp() {
		ExpressionFactory expFactory = ExpressionFactory.instance();

		Expression x = expFactory.makeStringExp("A");
		int id = x.getId();
		x.textRepresentation();
		assertEquals(x, Node.getNode(id));
	}

	/**
	 * This method tests the getId method of NumberExpression
	 */
	@Test
	public void testGetId_NumExp() {
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		expFactory.resetCounters();
		Node.resetIds();
		
		Expression x = expFactory.makeNumberExp(23);
		assertEquals(0, x.getId());
	}

	/**
	 * This method tests the getNode method for NumberExpression
	 */
	@Test
	public void testGetNode_NumExp() {
		ExpressionFactory expFactory = ExpressionFactory.instance();
		Expression x = expFactory.makeNumberExp(23);
		int id = x.getId();
		assertEquals(x, Node.getNode(id));
	}

	/**
	 * This method tests the getId method of PrefixExpression
	 */
	@Test
	public void testGetId_2NumExpPrefix() {
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		expFactory.resetCounters();
		Node.resetIds();

		Operator plus = new Operator("+");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression exp = expFactory.makeprefixExp(plus, one, two);

		assertEquals(2, exp.getId());
	}

	/**
	 * This method tests the getNode method for PrefixExpression
	 */
	@Test
	public void testGetNode_2NumExpPrefix() {
		ExpressionFactory expFactory = ExpressionFactory.instance();

		Operator plus = new Operator("+");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression exp = expFactory.makeprefixExp(plus, one, two);

		int id = exp.getId();
		assertEquals(exp, Node.getNode(id));
	}

	/**
	 * This method tests the getId method of InfixExpression
	 */
	@Test
	public void testGetId_2NumExpInfix() {
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		expFactory.resetCounters();
		Node.resetIds();

		Operator plus = new Operator("+");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression exp = expFactory.makeInfixExp(plus, one, two);

		assertEquals(2, exp.getId());
	}

	/**
	 * This method tests the getNode method for InfixExpression
	 */
	@Test
	public void testGetNode_2NumExpInfix() {
		ExpressionFactory expFactory = ExpressionFactory.instance();

		Operator plus = new Operator("+");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression exp = expFactory.makeInfixExp(plus, one, two);

		int id = exp.getId();
		assertEquals(exp, Node.getNode(id));
	}

	/**
	 * This method tests the getId method of Declaration
	 */
	@Test
	public void testGetId_Decl() {
		StatementFactory stmtFactory = StatementFactory.instance();
		
		stmtFactory.resetCounters();
		Node.resetIds();

		Variable x = new Variable("x");
		Statement decl = stmtFactory.makeDeclaration(x);

		assertEquals(0, decl.getId());
	}

	/**
	 * This method tests the getNode method for Declaration
	 */
	@Test
	public void testGetNode_Decl() {
		StatementFactory stmtFactory = StatementFactory.instance();
		
		stmtFactory.resetCounters();
		Node.resetIds();

		Variable x = new Variable("x");
		Statement decl = stmtFactory.makeDeclaration(x);

		int id = decl.getId();
		assertEquals(decl, Node.getNode(id));
	}

	/**
	 * This method tests the getId method of Sequence
	 */
	@Test
	public void testGetId_2NumInfixDeclAssignSeq() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		stmtFactory.resetCounters();
		Node.resetIds();

		Variable x = new Variable("x");
		Operator plus = new Operator("+");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression exp = expFactory.makeInfixExp(plus, one, two);

		Statement decl = stmtFactory.makeDeclaration(x);
		Statement assign = stmtFactory.makeAssignment(x, exp);
		Statement seq = stmtFactory.makeSequence(decl, assign);

		assertEquals(5, seq.getId());
	}

	/**
	 * This method tests the getNode method for Sequence
	 */
	@Test
	public void testGetNode_2NumInfixDeclAssignSeq() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		stmtFactory.resetCounters();
		Node.resetIds();

		Variable x = new Variable("x");
		Operator plus = new Operator("+");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression exp = expFactory.makeInfixExp(plus, one, two);

		Statement decl = stmtFactory.makeDeclaration(x);
		Statement assign = stmtFactory.makeAssignment(x, exp);
		Statement seq = stmtFactory.makeSequence(decl, assign);

		int id = seq.getId();
		assertEquals(seq, Node.getNode(id));
	}

	/**
	 * This method tests the getId method of Assignment
	 */
	@Test
	public void testGetId_2NumInfixAssign() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		expFactory.resetCounters();
		stmtFactory.resetCounters();
		Node.resetIds();

		Variable x = new Variable("x");
		Operator plus = new Operator("+");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression exp = expFactory.makeInfixExp(plus, one, two);

		Statement assign = stmtFactory.makeAssignment(x, exp);

		assertEquals(3, assign.getId());
	}

	/**
	 * This method tests the getNode method for Assignment
	 */
	@Test
	public void testGetNode_2NumInfixAssign() {
		StatementFactory stmtFactory = StatementFactory.instance();
		ExpressionFactory expFactory = ExpressionFactory.instance();
		
		expFactory.resetCounters();
		stmtFactory.resetCounters();
		Node.resetIds();

		Variable x = new Variable("x");
		Operator plus = new Operator("+");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression exp = expFactory.makeInfixExp(plus, one, two);

		Statement assign = stmtFactory.makeAssignment(x, exp);

		int id = assign.getId();
		assertEquals(assign, Node.getNode(id));
	}
}
