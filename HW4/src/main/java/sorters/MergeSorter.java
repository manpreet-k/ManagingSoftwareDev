/**
 * 
 */
package sorters;

import java.util.Arrays;

/**
 * This class implements the sort method using the Merge Sort algorithm
 *
 */
public class MergeSorter<T extends Comparable<T>> implements Sorter<T> {

	/**
	 * Implementation of the sort method of the interface
	 * 
	 * @param arr
	 *            array of elements to be sorted
	 *
	 */
	public void sort(T[] arr) {
		this.sort(arr, 0, arr.length - 1);
	}

	/**
	 * Initiates the sorting process
	 * 
	 * @param arr
	 *            array of elements to be sorted
	 * @param left
	 *            index of the first element of the array
	 * @param right
	 *            index of the last element of the array
	 *
	 */
	private void sort(T[] arr, int left, int right) {
		if (left < right) {
			int m = (left + right) / 2;

			sort(arr, left, m);
			sort(arr, m + 1, right);

			merge(arr, left, m, right);
		}
	}

	/**
	 * Merges two sorted arrays
	 * 
	 * @param elements
	 *            array of elements to be sorted
	 * @param left
	 *            index of the first element of the array
	 * @param median
	 *            index of the middle element of the array
	 * @param right
	 *            index of the last element of the array
	 *
	 */
	private void merge(T[] elements, int left, int median, int right) {
		int n1 = median - left + 1;
		int n2 = right - median;

		T[] leftHalf = Arrays.copyOf(elements, n1);
		T[] rightHalf = Arrays.copyOf(elements, n1);

		for (int i = 0; i < n1; ++i) {
			leftHalf[i] = elements[left + i];
		}

		for (int j = 0; j < n2; ++j) {
			rightHalf[j] = elements[median + 1 + j];
		}

		int i = 0;
		int j = 0;

		int k = left;
		while (i < n1 && j < n2) {
			int comp = 0;
			if (leftHalf[i] == null) {
				comp = -1;
			} else if (rightHalf[j] == null) {
				comp = 1;
			} else {
				comp = leftHalf[i].compareTo(rightHalf[j]);
			}

			if (comp <= 0) {
				elements[k] = leftHalf[i];
				i++;
			} else {
				elements[k] = rightHalf[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			elements[k] = leftHalf[i];
			i++;
			k++;
		}

		while (j < n2) {
			elements[k] = rightHalf[j];
			j++;
			k++;
		}
	}
}
