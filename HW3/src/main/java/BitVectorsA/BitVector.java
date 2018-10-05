/**
 * 
 */
package BitVectorsA;

/**
 * This class contains the representation of integer arrays as 32-bit values.
 * The ith bit to indicate whether the number i is in the set.
 * 
 * @author Manpreet Kaur
 *
 */
public class BitVector implements IBitVector {
	/**
	 * Size of the integer array
	 */
	private static final int SIZE = 32;

	/**
	 * Size of the integer array
	 */
	private int arraySize = 100;

	/**
	 * To store the 32-bit representations of the integer array
	 */
	int[] vectors;

	/**
	 * This constructor initializes the array containing ints
	 * 
	 */
	public BitVector() {
		vectors = new int[arraySize];
	}

	/**
	 * Determines if the bit at position i is set.
	 * 
	 * @param i
	 *            : position of the bit
	 * 
	 */
	public boolean get(int i) {
		int index = i / SIZE;
		int pos = i % SIZE;

		validateArraySize(index);

		int n = vectors[index];

		return ((n & (1 << pos)) != 0);
	}

	/**
	 * Set the bit at position i.
	 * 
	 * @param i
	 *            : position of the bit
	 * 
	 */
	public void set(int i) {
		int index = i / SIZE;
		int pos = i % SIZE;

		validateArraySize(index);

		int n = vectors[index];

		n = ((1 << pos) | n);

		vectors[index] = n;
	}

	/**
	 * Clear the bit at position i.
	 * 
	 * @param i
	 *            : position of the bit
	 * 
	 */
	public void clear(int i) {
		int index = i / SIZE;
		int pos = i % SIZE;

		validateArraySize(index);

		int n = vectors[index];
		n = (n & ~(1 << pos));
		vectors[index] = n;
	}

	/**
	 * Set the bits in the argument BitVector b.
	 * 
	 * @param b
	 *            : BitVector to be copied to the current BitVector
	 */
	public void copy(IBitVector b) {
		int size = b.size();
		int counter = 0;
		int loop = 0;

		while (counter < size) {
			if (b.get(loop)) {
				set(loop);
				counter++;
			}
			loop++;
		}
	}

	/**
	 * Determine the number of non-zero bits in the BitVector.
	 * 
	 * @return : size of the BitVector
	 */
	public int size() {
		int count = 0;
		for (int i = 0; i < vectors.length; i++) {
			if (vectors[i] != 0)
				count += setBitCount(vectors[i]);
		}
		return count;
	}

	/**
	 * Determine the number of non-zero bits in the Int.
	 * 
	 * @param :
	 *            Int number
	 * 
	 * @return : number of non-zero bits in the Int
	 */
	private int setBitCount(int number) {
		int count = 0;
		while (number != 0) {
			++count;
			number &= number - 1;
		}
		return count;
	}

	/**
	 * Checks whether the index to be verified is present in the array or not. if
	 * not, extends the size of the array
	 * 
	 * @param index
	 *            : Index of the current bit vector
	 */
	private void validateArraySize(int index) {
		if (index >= arraySize) {
			arraySize += index + 1;
			int[] newVectors = new int[arraySize];
			System.arraycopy(vectors, 0, newVectors, 0, vectors.length);
			vectors = newVectors;
		}
	}

	/**
	 * Iterator over the Integer values represented by this BitVector.
	 */
	public Iterator<Integer> iterator() {
		throw new UnsupportedOperationException();
	}
}
