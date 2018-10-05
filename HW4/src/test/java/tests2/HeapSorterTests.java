package tests2;

import static org.junit.Assert.*;

import sorters.Person;
import sorters.HeapSorter;
import sorters.Sorter;

import org.junit.Test;

public class HeapSorterTests {

	/**
	 * Method for creating a sorter.
	 * 
	 * @return Sorter
	 */
	private static <T extends Comparable<T>> Sorter<T> createSorter() {
		return new HeapSorter<T>();
	}

	/**
	 * This method tests the sort method for an empty list of the type Integer
	 */
	@Test
	public void testSorterForEmptyListIntegers() {
		Sorter<Integer> sorter = createSorter();

		Integer[] input = new Integer[5];
		Integer[] expectedOutput = new Integer[5];
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list of the type Integer
	 */
	@Test
	public void testSorterForNonEmptyListIntegers() {
		Sorter<Integer> sorter = createSorter();

		Integer[] input = { 200, 6, 0, 120, 340 };
		Integer[] expectedOutput = { 0, 6, 120, 200, 340 };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list with only 1 element
	 * of the type Integer
	 */
	@Test
	public void testSorterForSingleEleListIntegers() {
		Sorter<Integer> sorter = createSorter();

		Integer[] input = { 200 };
		Integer[] expectedOutput = { 200 };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that is already
	 * sorted of the type Integer
	 */
	@Test
	public void testSorterForSortedListIntegers() {
		Sorter<Integer> sorter = createSorter();

		Integer[] input = { 200, 300, 400 };
		Integer[] expectedOutput = { 200, 300, 400 };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that is already
	 * sorted in the reverse order of the type Integer
	 */
	@Test
	public void testSorterForSortedRevListIntegers() {
		Sorter<Integer> sorter = createSorter();

		Integer[] input = { 400, 300, 200 };
		Integer[] expectedOutput = { 200, 300, 400 };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that contains
	 * duplicates of the type Integer
	 */
	@Test
	public void testSorterForDuplicateEleListIntegers() {
		Sorter<Integer> sorter = createSorter();

		Integer[] input = { 400, 300, 400, 100, 500, 200 };
		Integer[] expectedOutput = { 100, 200, 300, 400, 400, 500 };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that contains both
	 * positive and negative numbers of the type Integer
	 */
	@Test
	public void testSorterForPosNegEleListIntegers() {
		Sorter<Integer> sorter = createSorter();

		Integer[] input = { 400, -300, 600, 100, -500, 200 };
		Integer[] expectedOutput = { -500, -300, 100, 200, 400, 600 };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that contains same
	 * number only of the type Integer
	 */
	@Test
	public void testSorterForSameEleListIntegers() {
		Sorter<Integer> sorter = createSorter();

		Integer[] input = { 400, 400, 400, 400 };
		Integer[] expectedOutput = { 400, 400, 400, 400 };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an very large list that contains
	 * elements of the type Integer
	 */
	@Test
	public void testVeryLargeListIntegers() {
		Sorter<Integer> sorter = createSorter();
		int VERY_LARGE = 10000000;
		Integer[] input = new Integer[VERY_LARGE];
		Integer[] expectedOutput = new Integer[VERY_LARGE];
		for (int i = 0; i < VERY_LARGE; i++) {
			expectedOutput[i] = i;
			input[VERY_LARGE - i - 1] = i;
		}
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an list that contains some elements of
	 * the type Integer
	 */
	@Test
	public void testNullInteger() {
		Sorter<Integer> sorter = createSorter();
		Integer[] input = { 6, 2, null, 8 };
		Integer[] expectedOutput = { null, 2, 6, 8 };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for a list with null elements of the type
	 * String
	 */
	@Test
	public void testSorterForNullEleListStrings() {
		Sorter<String> sorter = createSorter();

		String[] input = new String[5];
		String[] expectedOutput = new String[5];
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an empty list of the type String
	 */
	@Test
	public void testSorterForEmptyListStrings() {
		Sorter<String> sorter = createSorter();

		String[] input = { "", "", "" };
		String[] expectedOutput = { "", "", "" };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list of the type String
	 */
	@Test
	public void testSorterForNonEmptyListStrings() {
		Sorter<String> sorter = createSorter();

		String[] input = { "A", "X", "Z", "D", "E" };
		String[] expectedOutput = { "A", "D", "E", "X", "Z" };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list with only 1 element
	 * of the type String
	 */
	@Test
	public void testSorterForSingleEleListStrings() {
		Sorter<String> sorter = createSorter();

		String[] input = { "H" };
		String[] expectedOutput = { "H" };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that is already
	 * sorted of the type String
	 */
	@Test
	public void testSorterForSortedListStrings() {
		Sorter<String> sorter = createSorter();

		String[] input = { "G", "K", "P" };
		String[] expectedOutput = { "G", "K", "P" };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that is already
	 * sorted in the reverse order of the type String
	 */
	@Test
	public void testSorterForSortedRevListStrings() {
		Sorter<String> sorter = createSorter();

		String[] input = { "P", "K", "G" };
		String[] expectedOutput = { "G", "K", "P" };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that contains
	 * duplicates of the type String
	 */
	@Test
	public void testSorterForDuplicateEleListStrings() {
		Sorter<String> sorter = createSorter();

		String[] input = { "F", "L", "M", "B", "F", "L" };
		String[] expectedOutput = { "B", "F", "F", "L", "L", "M" };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that contains both
	 * characters and numbers of the type String
	 */
	@Test
	public void testSorterForCharNumEleListStrings() {
		Sorter<String> sorter = createSorter();

		String[] input = { "400", "-300", "B", "Z", "-500", "C" };
		String[] expectedOutput = { "-300", "-500", "400", "B", "C", "Z" };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that contains same
	 * element only of the type String
	 */
	@Test
	public void testSorterForSameEleListStrings() {
		Sorter<String> sorter = createSorter();

		String[] input = { "D", "D", "D", "D" };
		String[] expectedOutput = { "D", "D", "D", "D" };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an list that contains some elements of
	 * the type Integer
	 */
	@Test
	public void testNullString() {
		Sorter<String> sorter = createSorter();
		String[] input = { "6", "2", null, "8" };
		String[] expectedOutput = { null, "2", "6", "8" };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an empty list of the type Double
	 */
	@Test
	public void testSorterForEmptyListDoubles() {
		Sorter<Double> sorter = createSorter();

		Double[] input = new Double[5];
		Double[] expectedOutput = new Double[5];
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list of the type Double
	 */
	@Test
	public void testSorterForNonEmptyListDoubles() {
		Sorter<Double> sorter = createSorter();

		Double[] input = { 200.89, 6.43, 0.76, 120.43, 340.23 };
		Double[] expectedOutput = { 0.76, 6.43, 120.43, 200.89, 340.23 };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list with only 1 element
	 * of the type Double
	 */
	@Test
	public void testSorterForSingleEleListDoubles() {
		Sorter<Double> sorter = createSorter();

		Double[] input = { 200.34 };
		Double[] expectedOutput = { 200.34 };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that is already
	 * sorted of the type Double
	 */
	@Test
	public void testSorterForSortedListDoubles() {
		Sorter<Double> sorter = createSorter();

		Double[] input = { 200.45, 300.98, 400.77 };
		Double[] expectedOutput = { 200.45, 300.98, 400.77 };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that is already
	 * sorted in the reverse order of the type Double
	 */
	@Test
	public void testSorterForSortedRevListDoubles() {
		Sorter<Double> sorter = createSorter();

		Double[] input = { 400.56, 300.88, 200.32 };
		Double[] expectedOutput = { 200.32, 300.88, 400.56 };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that contains
	 * duplicates of the type Double
	 */
	@Test
	public void testSorterForDuplicateEleListDoubles() {
		Sorter<Double> sorter = createSorter();

		Double[] input = { 400.67, 300.98, 400.67, 100.27, 500.43, 200.58 };
		Double[] expectedOutput = { 100.27, 200.58, 300.98, 400.67, 400.67, 500.43 };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that contains both
	 * positive and negative numbers of the type Double
	 */
	@Test
	public void testSorterForPosNegEleListDoubles() {
		Sorter<Double> sorter = createSorter();

		Double[] input = { 400.76, -300.21, 600.83, 100.38, -500.46, 200.66 };
		Double[] expectedOutput = { -500.46, -300.21, 100.38, 200.66, 400.76, 600.83 };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that contains same
	 * number only of the type Double
	 */
	@Test
	public void testSorterForSameEleListDoubles() {
		Sorter<Double> sorter = createSorter();

		Double[] input = { 400.47, 400.47, 400.47, 400.47 };
		Double[] expectedOutput = { 400.47, 400.47, 400.47, 400.47 };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an very large list that contains
	 * elements of the type Double
	 */
	@Test
	public void testVeryLargeListDouble() {
		Sorter<Double> sorter = createSorter();
		int VERY_LARGE = 10000000;
		Double[] input = new Double[VERY_LARGE];
		Double[] expectedOutput = new Double[VERY_LARGE];
		for (int i = 0; i < VERY_LARGE; i++) {
			expectedOutput[i] = i * 1.2;
			input[VERY_LARGE - i - 1] = i * 1.2;
		}
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an list that contains some elements of
	 * the type Double
	 */
	@Test
	public void testNullDouble() {
		Sorter<Double> sorter = createSorter();
		Double[] input = { 6.2, 2.5, null, 8.7 };
		Double[] expectedOutput = { null, 2.5, 6.2, 8.7 };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an empty list of the type Person
	 */
	@Test
	public void testSorterForEmptyListPersons() {
		Sorter<Person> sorter = createSorter();
		Person[] people = {};
		sorter.sort(people);
		Person[] expectedOutput = {};
		assertArrayEquals(people, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list of the type Person
	 */
	@Test
	public void testSorterForNonEmptyListPersons() {
		Sorter<Person> sorter = createSorter();

		Person[] input = { new Person("Joe"), new Person("Jane"), new Person("Doe"),
				new Person("John"), new Person("Snow") };
		Person[] expectedOutput = { new Person("Doe"), new Person("Jane"),
				new Person("Joe"), new Person("John"), new Person("Snow") };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list with only 1 element
	 * of the type Person
	 */
	@Test
	public void testSorterForSingleEleListPersons() {
		Sorter<Person> sorter = createSorter();

		Person[] input = { new Person("John") };
		Person[] expectedOutput = { new Person("John") };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that is already
	 * sorted of the type Person
	 */
	@Test
	public void testSorterForSortedListPersons() {
		Sorter<Person> sorter = createSorter();

		Person[] input = { new Person("Doe"), new Person("Jane"), new Person("Joe"),
				new Person("John"), new Person("Snow") };
		Person[] expectedOutput = { new Person("Doe"), new Person("Jane"),
				new Person("Joe"), new Person("John"), new Person("Snow") };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that is already
	 * sorted in the reverse order of the type Person
	 */
	@Test
	public void testSorterForSortedRevListPersons() {
		Sorter<Person> sorter = createSorter();

		Person[] input = { new Person("Snow"), new Person("Jon"), new Person("Joe"),
				new Person("Jane"), new Person("Doe") };
		Person[] expectedOutput = { new Person("Doe"), new Person("Jane"),
				new Person("Joe"), new Person("Jon"), new Person("Snow") };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that contains
	 * duplicates of the type Person
	 */
	@Test
	public void testSorterForDuplicateEleListPersons() {
		Sorter<Person> sorter = createSorter();

		Person[] input = { new Person("Joe"), new Person("Jane"), new Person("Doe"),
				new Person("Snow"), new Person("Joe"), new Person("Joe") };
		Person[] expectedOutput = { new Person("Doe"), new Person("Jane"),
				new Person("Joe"), new Person("Joe"), new Person("Joe"),
				new Person("Snow") };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an non-empty list that contains same
	 * number only of the type Person
	 */
	@Test
	public void testSorterForSameEleListPersons() {
		Sorter<Person> sorter = createSorter();

		Person[] input = { new Person("Joe"), new Person("Joe"), new Person("Joe") };
		Person[] expectedOutput = { new Person("Joe"), new Person("Joe"),
				new Person("Joe") };

		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}

	/**
	 * This method tests the sort method for an list that contains some elements of
	 * the type Person
	 */
	@Test
	public void testNullPerson() {
		Sorter<Person> sorter = createSorter();

		Person[] input = { new Person("Joe"), new Person("Joe"), new Person("Joe"),
				new Person("Joe"), null };
		Person[] expectedOutput = { null, new Person("Joe"), new Person("Joe"),
				new Person("Joe"), new Person("Joe") };
		sorter.sort(input);
		assertArrayEquals(input, expectedOutput);
	}
}
