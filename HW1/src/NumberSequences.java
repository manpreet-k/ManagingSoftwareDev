package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Takes two numbers (integers) as in input and prints all the odd numbers between
 * the two.
 * 
 * @author Manpreet Kaur
 * @version 1.1
 * 
 */
public class NumberSequences {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in); // initialize the scanner for console input

			System.out.println("Enter the range start:");
			String start = scanner.nextLine(); // get the start of the range from the user

			System.out.println("Enter the range end:");
			String end = scanner.nextLine(); // get the end of the range from the user

			scanner.close(); // close the scanner

			if (validInput(start, end)) {
				System.out.println("Numbers between " + start + " and end " + end + " are ");
				getNumbersInBetween(Integer.parseInt(start), Integer.parseInt(end));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Validates the user input.
	 * 
	 * @param start
	 *            : start of the range
	 * @param end
	 *            : end of the range
	 * @return : true, if the input is valid, false otherwise
	 * 
	 */
	public static boolean validInput(String start, String end) {
		try {
			int first = Integer.parseInt(start); // convert the start of the range to Int

			int second = Integer.parseInt(end); // convert the end of the range to Int

			// validate the input: first number should be less than the second number
			if (first >= second) {
				System.out.println("Invalid range. First number should be lesser than the second number");
				return false;
			} else if (second - first == 1) {
				System.out.println("There is no number between " + start + " and " + end);
				return false;
			} else {
				return true;
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter integer values only");
			return false;
		}
	}

	/**
	 * Generates and returns a list containing all odd the numbers that lie between the
	 * start and the end parameters
	 * 
	 * @param start
	 *            : start of the range
	 * @param end
	 *            : end of the range
	 * @return : List of all the odd numbers between start and end, empty list if none
	 *         exist
	 */
	public static List<Integer> getNumbersInBetween(int start, int end) {
		/**
		 * List containing all the odd numbers that lie between the start and the end
		 * parameters
		 */
		List<Integer> numbersBetween = new ArrayList<Integer>();

		for (int i = start + 1; i < end; i++) {
			if(i % 2 != 0) { // print and return only odd numbers
				numbersBetween.add(i);
				System.out.println(i);
			}
		}

		return numbersBetween;
	}
}
