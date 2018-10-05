package asttests4b;

import static org.junit.Assert.*;

import org.junit.Test;

import ast4b.Iterator;
import ast4b.Node;
import ast4b.BitVector;
import ast4b.IBitVector;
import ast4b.Assignment;
import ast4b.Declaration;
import ast4b.Expression;
import ast4b.NodeSet;
import ast4b.NumberExpression;
import ast4b.Sequence;
import ast4b.Statement;
import ast4b.StringExpression;
import ast4b.VariableExpression;

/**
 * This class tests the operations of the NodeSet class
 * 
 * @author Manpreet Kaur
 * 
 * */
public class NodeSetTests {
	/**
	 * Tests the nextElement method of Iterator that has element
	 * */
	@Test
	public void testNextElementExists() {
		NodeSet set = new NodeSet();
		Expression var = new VariableExpression("x");
		set.add(var);
		
		Iterator<Node> iterator = set.iterator();
		
		assertEquals(var, iterator.nextElement());
	}
	
	/**
	 * Tests the nextElement method of Iterator that has no element
	 * */
	@Test
	public void testNextElementNoExists() {
		NodeSet set = new NodeSet();
				
		Iterator<Node> iterator = set.iterator();
		
		assertEquals(null, iterator.nextElement());
	}
	
	/**
	 * Tests the size method of Nodeset, add 1 element
	 * */
	@Test
	public void testSizeContainsVarExp() {
		NodeSet set = new NodeSet();
		Expression var = new VariableExpression("x");
		set.add(var);
		
		assertEquals(1, set.size());
	}
	
	/**
	 * Tests the toString method of Nodeset, add 1 element
	 * */
	@Test
	public void testToStringVarExp() {
		NodeSet set = new NodeSet();
		Expression var = new VariableExpression("x");
		set.add(var);
		
		assertEquals("1", set.toString());
	}
	
	/**
	 * Tests the add method of Nodeset, add 1 element
	 * */
	@Test
	public void testSetContainsVarExp() {
		NodeSet set = new NodeSet();
		Expression var = new VariableExpression("x");
		set.add(var);
		
		assertEquals(true, set.contains(var));
	}

	/**
	 * Tests the add method of Nodeset, add null
	 * */
	@Test (expected = NullPointerException.class)
	public void testAddNull() {
		NodeSet set = new NodeSet();
		Expression var = null;
		set.add(var);
		
		assertEquals(true, set.contains(var));
	}
	
	/**
	 * Tests the add method of Nodeset, add 3 element
	 * */
	@Test
	public void testAddVarStrNum() {
		NodeSet set = new NodeSet();
		Expression var = new VariableExpression("x");
		Expression str = new StringExpression("abc");
		Expression num = new NumberExpression(1.2);
		set.add(var);
		set.add(str);
		set.add(num);
		
		assertEquals(true, set.contains(str));
	}
	
	/**
	 * Tests the addAll method of empty Nodeset
	 * */
	@Test
	public void testAddllEmptySetToEmptySet() {
		NodeSet set1 = new NodeSet();
		NodeSet set2 = new NodeSet();
		
		Expression var = new VariableExpression("x");
				
		set2.addAll(set1);
		
		assertEquals(false, set2.contains(var));
	}
	
	/**
	 * Tests the addAll method of Nodeset, add 3 element
	 * */
	@Test
	public void testAddllVarStrNum() {
		NodeSet set1 = new NodeSet();
		NodeSet set2 = new NodeSet();
		Expression var = new VariableExpression("x");
		Expression str = new StringExpression("abc");
		Expression num = new NumberExpression(1.2);
		set1.add(var);
		set1.add(str);
		set1.add(num);
		
		set2.addAll(set1);
		
		assertEquals(true, set2.contains(str));
	}
	
	/**
	 * Tests the addAll method of Nodeset, add 3 elements in each set
	 * */
	@Test
	public void testAddlltoEmptySet() {
		NodeSet set1 = new NodeSet();
		NodeSet set2 = new NodeSet();
		Expression var = new VariableExpression("x");
		Expression str = new StringExpression("abc");
		Expression num = new NumberExpression(1.2);
		
		Statement decl = new Declaration(var);
		Statement assign = new Assignment(var, num);
		Statement seq = new Sequence(decl, assign);
		
		set1.add(var);
		set1.add(str);
		set1.add(num);
		
		set2.add(decl);
		set2.add(assign);
		set2.add(seq);
		
		set2.addAll(set1);
		
		assertEquals(true, set2.contains(str));
	}
	
	/**
	 * Tests the addAll method of Nodeset, add 3 elements in each set
	 * */
	@Test
	public void testAddlltoNonEmptySet() {
		NodeSet set1 = new NodeSet();
		NodeSet set2 = new NodeSet();
		Expression var = new VariableExpression("x");
		Expression str = new StringExpression("abc");
		Expression num = new NumberExpression(1.2);
		
		Statement decl = new Declaration(var);
		Statement assign = new Assignment(var, num);
		Statement seq = new Sequence(decl, assign);
		
		set1.add(var);
		set1.add(str);
		set1.add(num);
		
		set2.add(decl);
		set2.add(assign);
		set2.add(seq);
		
		set2.addAll(set1);
		
		assertEquals(true, set2.contains(decl));
	}
	
	/**
	 * Tests the addAll method of Nodeset, add 3 elements 
	 * */
	@Test
	public void testContains_EleNotExists() {
		NodeSet set1 = new NodeSet();
		
		Expression var = new VariableExpression("x");
		Expression str = new StringExpression("abc");
		Expression num = new NumberExpression(1.2);
		Expression num1 = new NumberExpression(300);
		
		set1.add(var);
		set1.add(str);
		set1.add(num);
		
		assertEquals(false, set1.contains(num1));
	}

	/**
	 * Tests the remove method of Nodeset, add 3 elements, remove the one not added
	 * */
	@Test
	public void testRemove_NotExists() {
		NodeSet set1 = new NodeSet(); 
		
		Expression var = new VariableExpression("x");
		Expression str = new StringExpression("abc");
		Expression num = new NumberExpression(1.2);
		 
		Statement assign = new Assignment(var, num);
		
		set1.add(var);
		set1.add(str);
		set1.add(num);
		
		assertEquals(false, set1.contains(assign));
		
		set1.remove(assign);
		
		assertEquals(false, set1.contains(assign));
	}
	
	/**
	 * Tests the remove method of Nodeset, add 3 elements, remove 1
	 * */
	@Test
	public void testRemove_EleExists() {
		NodeSet set1 = new NodeSet();
		
		Expression var = new VariableExpression("x");
		Expression str = new StringExpression("abc");
		Expression num = new NumberExpression(1.2);
						
		set1.add(var);
		set1.add(str);
		set1.add(num);
			
		assertEquals(true, set1.contains(var));
		
		set1.remove(var);
		
		assertEquals(false, set1.contains(var));
	}
	
	/**
	 * Tests the remove method of Nodeset, add 3 elements, remove 1
	 * */
	@Test
	public void testAllRemove_EleExists() {
		NodeSet set1 = new NodeSet();
		NodeSet set2 = new NodeSet();
		Expression var = new VariableExpression("x");
		Expression str = new StringExpression("abc");
		Expression num = new NumberExpression(1.2);
		
		Statement decl = new Declaration(var);
		Statement assign = new Assignment(var, num);
		Statement seq = new Sequence(decl, assign);
		
		set1.add(var);
		set1.add(str);
		set1.add(num);
		
		set2.add(decl);
		set2.add(assign);
		set2.add(seq);
		
		set2.addAll(set1);
		
		assertEquals(true, set2.contains(var));
		
		set2.remove(var);
		
		assertEquals(false, set2.contains(var));
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
	 * Tests the set method for 312 vector length
	 * 
	 */
	@Test
	public void sizeWith312Vector() {
		IBitVector vector = new BitVector();
		int[] input = new int[] {0, 32, 100, 500, 1000, 9999, 453627};
		
		setBitVector(vector, input);			
		assertEquals(7, vector.size());
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
