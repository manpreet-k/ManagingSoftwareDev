package tests;

import static org.junit.Assert.*;
import ast.Assignment;
import ast.Declaration;
import ast.Expression;
import ast.InfixExpression;
import ast.NumberExpression;
import ast.Operator;
import ast.PrefixExpression;
import ast.Sequence;
import ast.Statement;
import ast.StringExpression;
import ast.Variable;
import ast.VariableExpression;

/**
 * @author Manpreet Kaur
 * 
 */
import org.junit.Test;

/**
 * ASTTests class test the Abstract syntax tree implementation for the package
 * ast.
 * 
 * @author Manpreet Kaur
 *
 */
public class ASTTests {

	/**
	 * This method tests the Sequence of Declaration of a Variable and Assignment of
	 * an InfixExpression consisting of two NumberExpressions and an operator
	 * 
	 */
	@Test
	public void test1() {
		Variable x = new Variable("x");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Operator plus = new Operator("+");
		Expression exp = new InfixExpression(plus, one, two);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp);
		Statement seq = new Sequence(decl, assign);

		assertEquals(seq.textRepresentation(), "var x; x = 1 + 2;");
	}

	/**
	 * This method tests the Sequence of Declaration of a Variable and Assignment of
	 * an PrefixExpression consisting of four NumberExpressions and three operators
	 * 
	 */
	@Test
	public void test2() {
		Variable x = new Variable("x");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Expression three = new NumberExpression(3);
		Expression four = new NumberExpression(4);
		Operator plus = new Operator("+");
		Operator mul = new Operator("*");
		Operator div = new Operator("/");
		Expression exp1 = new PrefixExpression(plus, two, three);
		Expression exp2 = new PrefixExpression(mul, one, exp1);
		Expression exp3 = new PrefixExpression(div, exp2, four);
		Statement decl = new Declaration(x);
		Statement assign = new Assignment(x, exp3);
		Statement seq = new Sequence(decl, assign);

		assertEquals(seq.textRepresentation(), "var x; x = / * 1 + 2 3 4;");
	}

	/**
	 * This method tests the Sequence of Declaration of three Variables and
	 * Assignment of NumberExpressions to these three variables
	 * 
	 */
	@Test
	public void test3() {
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Variable z = new Variable("z");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Expression three = new NumberExpression(3.3);
		Statement decl1 = new Declaration(x);
		Statement decl2 = new Declaration(y);
		Statement decl3 = new Declaration(z);
		Statement assign1 = new Assignment(x, one);
		Statement assign2 = new Assignment(y, two);
		Statement assign3 = new Assignment(z, three);
		Statement seq1 = new Sequence(decl1, decl2);
		Statement seq2 = new Sequence(seq1, decl3);
		Statement seq3 = new Sequence(seq2, assign1);
		Statement seq4 = new Sequence(seq3, assign2);
		Statement seq5 = new Sequence(seq4, assign3);
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
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Variable z = new Variable("z");
		Expression a = new StringExpression("A");
		Expression b = new StringExpression("B");
		Expression three = new NumberExpression(3);
		Statement decl1 = new Declaration(x);
		Statement decl2 = new Declaration(y);
		Statement decl3 = new Declaration(z);
		Statement assign1 = new Assignment(x, a);
		Statement assign2 = new Assignment(y, b);
		Operator plus = new Operator("+");
		Operator mul = new Operator("*");
		Expression exp1 = new InfixExpression(plus, b, three);
		Expression exp2 = new InfixExpression(mul, a, exp1);
		Statement assign3 = new Assignment(z, exp2);
		Statement seq1 = new Sequence(decl1, decl2);
		Statement seq2 = new Sequence(seq1, decl3);
		Statement seq3 = new Sequence(seq2, assign1);
		Statement seq4 = new Sequence(seq3, assign2);
		Statement seq5 = new Sequence(seq4, assign3);

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
		Expression x = new VariableExpression("x");
		Variable y = new Variable("y");
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Statement decl1 = new Declaration(x);
		Statement decl2 = new Declaration(y);
		Statement assign1 = new Assignment(x, one);
		Operator plus = new Operator("+");
		Expression exp = new InfixExpression(plus, x, two);
		Statement assign2 = new Assignment(y, exp);
		Statement seq1 = new Sequence(decl1, decl2);
		Statement seq2 = new Sequence(seq1, assign1);
		Statement seq3 = new Sequence(seq2, assign2);

		assertEquals(seq3.textRepresentation(), "var x; var y; x = 1; y = x + 2;");
	}

	/**
	 * This method tests the toString method of VariableExpression
	 * 
	 */
	@Test
	public void test6() {
		Expression x = new VariableExpression("x");
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
		Expression one = new NumberExpression(1);
		assertEquals(one.toString(), "1");
	}

	/**
	 * This method tests the toString method of StringExpression
	 * 
	 */
	@Test
	public void test9() {
		Expression a = new StringExpression("A");
		assertEquals(a.toString(), "A");
	}

	/**
	 * This method tests the toString method of Declaration
	 * 
	 */
	@Test
	public void test10() {
		Variable x = new Variable("x");
		Statement decl = new Declaration(x);
		assertEquals(decl.toString(), "var x");
	}

	/**
	 * This method tests the toString method of Assignment
	 * 
	 */
	@Test
	public void test11() {
		Variable x = new Variable("x");
		Expression one = new NumberExpression(1);
		Statement assign = new Assignment(x, one);
		assertEquals(assign.toString(), "x = 1");
	}

	/**
	 * This method tests the toString method of Sequence
	 * 
	 */
	@Test
	public void test12() {
		Expression x = new VariableExpression("x");
		Expression one = new NumberExpression(1);
		Statement assign = new Assignment(x, one);

		Expression a = new StringExpression("A");
		Statement assign1 = new Assignment(a, x);
		Statement seq = new Sequence(assign, assign1);
		assertEquals(seq.toString(), "x = 1; A = x;");
	}

	/**
	 * This method tests the toString method of PrefixExpression
	 * 
	 */
	@Test
	public void test13() {
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Operator div = new Operator("/");
		Expression prefix = new PrefixExpression(div, one, two);

		assertEquals(prefix.toString(), "/ 1 2");
	}

	/**
	 * This method tests the toString method of InfixExpression
	 * 
	 */
	@Test
	public void test14() {
		Expression one = new NumberExpression(1);
		Expression two = new NumberExpression(2);
		Operator div = new Operator("-");
		Expression infix = new InfixExpression(div, one, two);

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
		Expression x = new VariableExpression(x1);
		
		Variable y = new Variable("y");
		
		Expression one = new NumberExpression(1);
		
		Statement decl1 = new Declaration(x);
		Statement decl2 = new Declaration(y);
		Statement assign1 = new Assignment(x, one);
		Operator plus = new Operator("+");
		Expression exp = new InfixExpression(plus, x, x);
		Statement assign2 = new Assignment(y, exp);
		Statement seq1 = new Sequence(decl1, decl2);
		Statement seq2 = new Sequence(seq1, assign1);
		Statement seq3 = new Sequence(seq2, assign2);

		assertEquals(seq3.textRepresentation(), "var x; var y; x = 1; y = x + x;");
	}

}
