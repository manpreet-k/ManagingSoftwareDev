package tests3;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ast3.Expression;
import ast3.ExpressionFactory;
import ast3.Operator;
import ast3.Statement;
import ast3.StatementFactory;
import ast3.Variable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * AST3Tests class test the Abstract syntax tree implementation for the package
 * ast3.
 * 
 * @author Manpreet Kaur
 *
 */
public class AST3Tests {
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
	 * This method tests the Sequence of Declaration of a Variable and Assignment of
	 * an InfixExpression consisting of two NumberExpressions and an operator
	 * 
	 */
	@Test
	public void test1() {
		StatementFactory stmtFactory = new StatementFactory();
		ExpressionFactory expFactory = new ExpressionFactory();

		Variable x = new Variable("x");
		Operator plus = new Operator("+");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression exp = expFactory.makeInfixExp(plus, one, two);

		Statement decl = stmtFactory.makeDeclaration(x);
		Statement assign = stmtFactory.makeAssignment(x, exp);
		Statement seq = stmtFactory.makeSequence(decl, assign);

		assertEquals(seq.textRepresentation(), "var x; x = 1 + 2;");
	}

	/**
	 * This method tests the Sequence of Declaration of a Variable and Assignment of
	 * an PrefixExpression consisting of four NumberExpressions and three operators
	 * 
	 */
	@Test
	public void test2() {
		StatementFactory stmtFactory = new StatementFactory();
		ExpressionFactory expFactory = new ExpressionFactory();

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

		assertEquals(seq.textRepresentation(), "var x; x = / * 1 + 2 3 4;");
	}

	/**
	 * This method tests the Sequence of Declaration of three Variables and
	 * Assignment of NumberExpressions to these three variables
	 * 
	 */
	@Test
	public void test3() {
		StatementFactory stmtFactory = new StatementFactory();
		ExpressionFactory expFactory = new ExpressionFactory();

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

		assertEquals(seq5.textRepresentation(), "var x; var y; var z; x = 1; y = 2; z = 3.3;");
	}

	/**
	 * This method tests the Sequence of Declaration of three Variables and
	 * Assignment of NumberExpressions and StringExpression to these three variables
	 * and InfixExpression of these variables with two operator
	 * 
	 */
	@Test
	public void test4() {
		StatementFactory stmtFactory = new StatementFactory();
		ExpressionFactory expFactory = new ExpressionFactory();
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

		assertEquals(seq5.textRepresentation(), "var x; var y; var z; x = A; y = B; z = A * B + 3;");
	}

	/**
	 * This method tests the Sequence of Declaration of one Variables and one
	 * VariiableExpression and Assignment of NumberExpressions to them and
	 * InfixExpression of these variables with two operator
	 * 
	 */
	@Test
	public void test5() {
		StatementFactory stmtFactory = new StatementFactory();
		ExpressionFactory expFactory = new ExpressionFactory();
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

		assertEquals(seq3.textRepresentation(), "var x; var y; x = 1; y = x + 2;");
	}

	/**
	 * This method tests the toString method of VariableExpression
	 * 
	 */
	@Test
	public void test6() {
		ExpressionFactory expFactory = new ExpressionFactory();

		Expression x = expFactory.makeVariableExp("x");

		assertEquals(x.toString(), "x");
	}

	/**
	 * This method tests the toString method of Variable
	 * 
	 */
	@Test
	public void test7() {
		Variable x = new Variable("x");
		assertEquals(x.toString(), "x");
	}

	/**
	 * This method tests the toString method of NumberExpression
	 * 
	 */
	@Test
	public void test8() {
		ExpressionFactory expFactory = new ExpressionFactory();

		Expression one = expFactory.makeNumberExp(1);

		assertEquals(one.toString(), "1");
	}

	/**
	 * This method tests the toString method of StringExpression
	 * 
	 */
	@Test
	public void test9() {
		ExpressionFactory expFactory = new ExpressionFactory();

		Expression a = expFactory.makeStringExp("A");

		assertEquals(a.toString(), "A");
	}

	/**
	 * This method tests the toString method of Declaration
	 * 
	 */
	@Test
	public void test10() {
		StatementFactory stmtFactory = new StatementFactory();
		Variable x = new Variable("x");

		Statement decl = stmtFactory.makeDeclaration(x);

		assertEquals(decl.toString(), "var x");
	}

	/**
	 * This method tests the toString method of Assignment
	 * 
	 */
	@Test
	public void test11() {
		StatementFactory stmtFactory = new StatementFactory();
		ExpressionFactory expFactory = new ExpressionFactory();
		Variable x = new Variable("x");

		Expression one = expFactory.makeNumberExp(1);
		Statement assign = stmtFactory.makeAssignment(x, one);

		assertEquals(assign.toString(), "x = 1");
	}

	/**
	 * This method tests the toString method of Sequence
	 * 
	 */
	@Test
	public void test12() {
		StatementFactory stmtFactory = new StatementFactory();
		ExpressionFactory expFactory = new ExpressionFactory();

		Expression x = expFactory.makeVariableExp("x");
		Expression one = expFactory.makeNumberExp(1);
		Statement assign = stmtFactory.makeAssignment(x, one);

		Expression a = expFactory.makeStringExp("A");
		Statement assign1 = stmtFactory.makeAssignment(a, x);
		Statement seq = stmtFactory.makeSequence(assign, assign1);

		assertEquals(seq.toString(), "x = 1; A = x;");
	}

	/**
	 * This method tests the toString method of PrefixExpression
	 * 
	 */
	@Test
	public void test13() {
		ExpressionFactory expFactory = new ExpressionFactory();
		Operator div = new Operator("/");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression prefix = expFactory.makeprefixExp(div, one, two);

		assertEquals(prefix.toString(), "/ 1 2");
	}

	/**
	 * This method tests the toString method of InfixExpression
	 * 
	 */
	@Test
	public void test14() {
		ExpressionFactory expFactory = new ExpressionFactory();
		Operator div = new Operator("-");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression infix = expFactory.makeInfixExp(div, one, two);

		assertEquals(infix.toString(), "1 - 2");
	}
	
	/**
	 * This method tests the Sequence of Declaration of two Variables and one
	 * VariableExpression and Assignment of NumberExpressions to them and
	 * InfixExpression of these variables with two operator
	 * 
	 */
	@Test
	public void test15() {
		Variable x1 = new Variable("x");
		Variable y = new Variable("y");
		Operator plus = new Operator("+");
		
		ExpressionFactory expFactory = new ExpressionFactory();
		StatementFactory stmtFactory = new StatementFactory();
		
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

		assertEquals(seq3.textRepresentation(), "var x; var y; x = 1; y = x + x;");
	}


	/**
	 * This method tests the report method of Expression containing NumberExpression
	 * and InfixExpression
	 * 
	 */
	@Test
	public void test16() {
		ExpressionFactory expFactory = new ExpressionFactory();

		Operator plus = new Operator("+");

		Expression one = expFactory.makeNumberExp(1);
		Expression two = expFactory.makeNumberExp(2);
		Expression exp = expFactory.makeInfixExp(plus, one, two);
		exp.textRepresentation();
		expFactory.report();

		String testOutput = "Number of InfixExpression nodes = 1\nNumber of NumberExpression nodes = 2\n";

		assertEquals(testOutput, outContent.toString());
	}

	/**
	 * This method tests the report method of Statement containing Assignment,
	 * Declaration and Sequence
	 * 
	 */
	@Test
	public void test17() {
		StatementFactory stmtFactory = new StatementFactory();
		ExpressionFactory expFactory = new ExpressionFactory();

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

		String testOutput = "Number of Sequence nodes = 1\nNumber of Declaration nodes = 1\nNumber of Assignment nodes = 1\n";

		assertEquals(testOutput, outContent.toString());
	}

	/**
	 * This method tests the report method of Expression containing PrefixExpression
	 * and NumberExpression
	 * 
	 */
	@Test
	public void test18() {
		ExpressionFactory expFactory = new ExpressionFactory();

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

		String testOutput = "Number of PrefixExpression nodes = 3\nNumber of NumberExpression nodes = 4\n";

		expFactory.report();

		assertEquals(outContent.toString(), testOutput);
	}

	/**
	 * This method tests the report method for Statement containing Sequence and
	 * Assignment
	 * 
	 */
	@Test
	public void test19() {
		StatementFactory stmtFactory = new StatementFactory();
		ExpressionFactory expFactory = new ExpressionFactory();

		Expression x = expFactory.makeVariableExp("x");
		Expression one = expFactory.makeNumberExp(1);
		Statement assign = stmtFactory.makeAssignment(x, one);

		Expression a = expFactory.makeStringExp("A");
		Statement assign1 = stmtFactory.makeAssignment(a, x);
		Statement seq = stmtFactory.makeSequence(assign, assign1);
		seq.textRepresentation();

		String testOutput = "Number of Sequence nodes = 1\nNumber of Assignment nodes = 2\n";

		stmtFactory.report();

		assertEquals(outContent.toString(), testOutput);
	}
	
	/**
	 * This method tests the report method for Declaration
	 * 
	 */
	@Test
	public void test20() {
		StatementFactory stmtFactory = new StatementFactory();		
		Variable x = new Variable("x");
		
		Statement decl = stmtFactory.makeDeclaration(x);	
		decl.textRepresentation();
		
		String testOutput = "Number of Declaration nodes = 1\n";

		stmtFactory.report();

		assertEquals(outContent.toString(), testOutput);
	}
	
	/**
	 * This method tests the report method for StringExpression
	 * 
	 */
	@Test
	public void test21() {
		ExpressionFactory expFactory = new ExpressionFactory();
		
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
	public void test22() {
		ExpressionFactory expFactory = new ExpressionFactory();
		
		Expression x = expFactory.makeVariableExp("x");
		x.textRepresentation();
		
		String testOutput = "Number of VariableExpression nodes = 1\n";

		expFactory.report();

		assertEquals(outContent.toString(), testOutput);
	}
}
