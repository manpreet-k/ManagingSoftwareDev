package BitVectorTestsB;

import static org.junit.Assert.*;

import org.junit.Test;

import BitVectorsB.BitVector;
import BitVectorsB.IBitVector;
import BitVectorsB.Iterator;

/**
 * This class tests the operations of the BitVector class
 * 
 * @author Manpreet Kaur
 * 
 * */
public class BitVectorTests {

	/**
	 * Test the size of the BitVector with numbers between 0-31 only
	 * */
	@Test
	public void sizeWith1Vector() {
		IBitVector vector = new BitVector();
		int[] input = new int[] {0, 1, 4, 7, 10};
		
		setBitVector(vector, input);			
		assertEquals(5, vector.size());
	}
	
	/**
	 * Test the size of the BitVector with numbers between 0-63 only
	 * */
	@Test
	public void sizeWith2Vectors() {
		IBitVector vector = new BitVector();
		int[] input = new int[] {7, 4, 12, 30, 31, 32, 63};
		
		setBitVector(vector, input);			
		assertEquals(7, vector.size());
	}
	
	/**
	 * Test the size of the BitVector with numbers between 0-95 only
	 * */
	@Test
	public void sizeWith3Vectors_2gap() {
		IBitVector vector = new BitVector();
		int[] input = new int[] {7, 4, 12, 30, 31, 94, 95};
		
		setBitVector(vector, input);			
		assertEquals(7, vector.size());
	}
	
	/**
	 * Test the size of the BitVector with numbers between 0-74 only
	 * */
	@Test
	public void sizeWith2Vectors_1gap_1ele() {
		IBitVector vector = new BitVector();
		int[] input = new int[] {74};
		
		setBitVector(vector, input);			
		assertEquals(1, vector.size());
	}
	
	/**
	 * Test the get method of the BitVector with numbers between 0-31 only
	 * */
	@Test
	public void get1Ele1Vector() {
		IBitVector vector = new BitVector();
		int[] input = new int[] {0, 1, 4, 7, 10};
		
		setBitVector(vector, input);			
		assertEquals(true, vector.get(7));
	}
	
	/**
	 * Test the get method of the BitVector with numbers between 0-31 only
	 * */
	@Test
	public void get1Ele1Vector_NotExists() {
		IBitVector vector = new BitVector();
		int[] input = new int[] {0, 1, 4, 7, 10};
		
		setBitVector(vector, input);			
		assertEquals(false, vector.get(11));
	}
	
	/**
	 * Test the get method of the BitVector with numbers between 0-63 only
	 * */
	@Test
	public void get1Ele2Vector() {
		IBitVector vector = new BitVector();
		int[] input = new int[] {7, 4, 12, 30, 31, 32, 63};
		
		setBitVector(vector, input);			
		assertEquals(true, vector.get(63));
	}
	
	/**
	 * Test the get method of the BitVector with numbers between 0-63 only
	 * */
	@Test
	public void get1Ele2Vector_NotExists() {
		IBitVector vector = new BitVector();
		int[] input = new int[] {7, 4, 12, 30, 31, 32, 63};
		
		setBitVector(vector, input);			
		assertEquals(false, vector.get(64));
	}
	
	/**
	 * Test the clear method of the BitVector with numbers between 0-63 only
	 * */
	@Test
	public void testClear() {
		IBitVector vector = new BitVector();
		int[] input = new int[] {7, 4, 12, 30, 31, 32, 63};
		
		setBitVector(vector, input);			
		assertEquals(true, vector.get(63));
		
		vector.clear(63);
		assertEquals(false, vector.get(63));
	}
	
	/**
	 * Test the set method of the BitVector with numbers between 0-63 only
	 * */
	@Test
	public void testSet() {
		IBitVector vector = new BitVector();
		int[] input = new int[] {7, 4, 12, 30, 31, 32};
		
		setBitVector(vector, input);			
		assertEquals(false, vector.get(63));
		
		vector.set(63);
		assertEquals(true, vector.get(63));
	}
	
	/**
	 * Test the copy method of the BitVector with numbers between 0-63 only
	 * */
	@Test
	public void copyToEmptyVector() {
		IBitVector vector = new BitVector();
		IBitVector vectorNew = new BitVector();
		int[] input = new int[] {7, 4, 12, 30, 31, 32, 63};
	
		setBitVector(vector, input);
				
		assertEquals(false, vectorNew.get(63));
		
		vectorNew.copy(vector);
		assertEquals(true, vectorNew.get(63));
	}
	
	/**
	 * Test the copy method of the BitVector with numbers between 0-63 only
	 * */
	@Test
	public void copyToNonEmptyVector() {
		IBitVector vector = new BitVector();
		IBitVector vectorNew = new BitVector();
		int[] input = new int[] {7, 4, 12, 30, 31, 32};
		int[] inputNew = new int[] {7, 31, 32, 63};
	
		setBitVector(vector, input);
		setBitVector(vectorNew, inputNew);
		
		assertEquals(false, vectorNew.get(4));
		
		vectorNew.copy(vector);
		assertEquals(true, vectorNew.get(4));
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
	 * Tests the iterator method of BitVector some elements set
	 * */
	@Test
	public void IteratorHasElementNonEmptyVector() {
		Iterator<Integer> iterator;
		IBitVector vector = new BitVector();
		int[] input = new int[] {32, 63, 80, 95};
		
		setBitVector(vector, input);
		iterator = vector.iterator();
		
		assertEquals(true, iterator.hasAnotherElement());
		
	}
	
	/**
	 * Tests the iterator method of BitVector with no element set
	 * */
	@Test
	public void hasElementEmptySet() {
		Iterator<Integer> iterator;
		IBitVector vector = new BitVector();
				
		iterator = vector.iterator();
		
		assertEquals(false, iterator.hasAnotherElement());
	}
	
	/**
	 * Tests the iterator method of BitVector with 4 elements set
	 * */
	@Test
	public void iteratorNonEmptyVector() {
		IBitVector vector = new BitVector();
		Iterator<Integer> iterator;
		
		int i = 0;
		int[] input = new int[] {32, 63, 80, 95};
		int[] output = new int[input.length];
				
		setBitVector(vector, input);
		iterator = vector.iterator();
		
		while (iterator.hasAnotherElement()) {
			output[i++] = iterator.nextElement();
		}
		
		assertArrayEquals(input, output);
	}
	
	/**
	 * Tests the iterator method of BitVector with no element set
	 * */
	@Test
	public void iteratorEmptyVector() {
		Iterator<Integer> iterator;
		IBitVector vector = new BitVector();
				
		iterator = vector.iterator();
		
		assertSame(-1, iterator.nextElement());
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
