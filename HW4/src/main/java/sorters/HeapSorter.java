/**
 * 
 */
package sorters;

/**
 * This class implements the sort method using the Heap Sort algorithm
 *
 */
public class HeapSorter<T extends Comparable<T>> implements Sorter<T> {
	/**
	 * Implementation of the sort method of the interface
	 * 
	 * @param arr
	 *            array of elements to be sorted
	 *
	 */
	public void sort(T[] arr) {
		int n = arr.length;

		for (int i = n / 2 - 1; i >= 0; i--)
			createHeap(arr, n, i);

		for (int i = n - 1; i >= 0; i--) {
			T temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			createHeap(arr, i, 0);
		}
	}

	/**
	 * To heapify a subtree rooted
	 * 
	 * @param arr
	 *            array of elements to be sorted
	 * @param n
	 *            size of the heap
	 * @param i
	 *            index of the array
	 */
	private void createHeap(T[] arr, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n) {
			int comp = 0;
			if (arr[l] == null) {
				comp = -1;
			} else if (arr[largest] == null) {
				comp = 1;
			} else {
				comp = arr[l].compareTo(arr[largest]);
			}

			if (comp > 0)
				largest = l;
		}

		if (r < n) {
			int comp = 0;
			if (arr[r] == null) {
				comp = -1;
			} else if (arr[largest] == null) {
				comp = 1;
			} else {
				comp = arr[r].compareTo(arr[largest]);
			}

			if (comp > 0)
				largest = r;
		}

		if (largest != i) {
			T temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			createHeap(arr, n, largest);
		}
	}
}
