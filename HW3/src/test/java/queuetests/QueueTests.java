package queuetests;

import static org.junit.Assert.*;

import org.junit.Test;

import queue.Queue;

/**
 * This class tests the operations of the Queue class
 * 
 * @author Manpreet Kaur
 * 
 * */
public class QueueTests {

	/**
	 * Test to add 1 element of type int in an empty queue
	 * 
	 */
	@Test
	public void testIntAdd() {
		Queue<Integer> q = new Queue<Integer>();
		assertEquals(true, q.add(3));
	}
	
	/**
	 * Test to add 3 elements of type int and remove 1
	 * 
	 */
	@Test
	public void testIntRemove() {
		Queue<Integer> q = new Queue<Integer>();
		q.add(14);
		q.add(20);
		q.add(3);
		int remove = q.remove();
		assertEquals(14, remove);
	}
	
	/**
	 * Test to add 3 elements of type int and peek 1
	 * 
	 */
	@Test
	public void testIntPeek() {
		Queue<Integer> q = new Queue<Integer>();
		q.add(14);
		q.add(20);
		q.add(3);
		int peek = q.peek();
		assertEquals(3, peek);
	}
	
	/**
	 * Test to add 3 elements of type int and remove 1 and peek 1
	 * 
	 */
	@Test
	public void testInt1Remove1Peek() {
		Queue<Integer> q = new Queue<Integer>();
		q.add(14);
		q.add(20);
		q.add(3);
		q.remove();
		int peek = q.peek();
		assertEquals(3, peek);
	}
	
	/**
	 * Test to add null to the queue
	 * 
	 */
	@Test (expected=NullPointerException.class)
	public void testIntNullPointerException() {
		Queue<Integer> q = new Queue<Integer>();
		assertEquals(null, q.add(null));
	}
	
	/**
	 * Test to add 3 elements and remove 4 elements of type int
	 * 
	 */
	@Test
	public void testIntRemoveNoEle() {
		Queue<Integer> q = new Queue<Integer>();
		q.add(14);
		q.add(20);
		q.add(3);
		q.remove();
		q.remove();
		q.remove();
		assertEquals(null, q.remove());
	}
	
	/**
	 * Test to add 3 elements and remove 3 elements and peek of type int
	 * 
	 */
	@Test
	public void testIntPeekNoEle() {
		Queue<Integer> q = new Queue<Integer>();
		q.add(14);
		q.add(20);
		q.add(3);
		q.remove();
		q.remove();
		q.remove();
		assertEquals(null, q.peek());
	}
	
	/**
	 * Test to add 1 element of type String in an empty queue
	 * 
	 */
	@Test
	public void testStrAdd() {
		Queue<String> q = new Queue<String>();
		assertEquals(true, q.add("ABC"));
	}
	
	/**
	 * Test to add 3 elements of type String and remove 1
	 * 
	 */
	@Test
	public void testStrRemove() {
		Queue<String> q = new Queue<String>();
		q.add("ABC");
		q.add("DEF");
		q.add("XYZ");
		String remove = q.remove();
		assertEquals("ABC", remove);
	}
	
	/**
	 * Test to add 3 elements of type String and peek 1
	 * 
	 */
	@Test
	public void testStrPeek() {
		Queue<String> q = new Queue<String>();
		q.add("ABC");
		q.add("DEF");
		q.add("XYZ");
		String peek = q.peek();
		assertEquals("XYZ", peek);
	}
	
	/**
	 * Test to add 3 elements of type String and remove 1 and peek 1
	 * 
	 */
	@Test
	public void testStr1Remove1Peek() {
		Queue<String> q = new Queue<String>();
		q.add("ABC");
		q.add("DEF");
		q.add("XYZ");
		q.remove();
		String peek = q.peek();
		assertEquals("XYZ", peek);
	}
	
	/**
	 * Test to add null to the queue
	 * 
	 */
	@Test (expected=NullPointerException.class)
	public void testStrNullPointerException() {
		Queue<String> q = new Queue<String>();
		assertEquals(null, q.add(null));
	}
	
	/**
	 * Test to add 3 elements and remove 4 elements of type String
	 * 
	 */
	@Test
	public void testRemoveNoStrEle() {
		Queue<String> q = new Queue<String>();
		q.add("ABC");
		q.add("DEF");
		q.add("XYZ");
		q.remove();
		q.remove();
		q.remove();
		assertEquals(null, q.remove());
	}
	
	/**
	 * Test to add 3 elements and remove 3 elements and peek of type String
	 * 
	 */
	@Test
	public void testPeekNoStrEle() {
		Queue<String> q = new Queue<String>();
		q.add("ABC");
		q.add("DEF");
		q.add("XYZ");
		q.remove();
		q.remove();
		q.remove();
		assertEquals(null, q.peek());
	}
}
