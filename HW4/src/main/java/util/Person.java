package util;

import java.util.Objects;

/**
 * This class creates a person with the specified name
 */
public class Person implements Comparable<Person> {
	private String name;

	/**
	 * Creates the person object with the specified name
	 * 
	 * @param name
	 *            Name of the person
	 */
	public Person(String name) {
		this.name = name;
	}

	/**
	 * Compares the name of the person object with the current object's name
	 * 
	 * @param person
	 *            the object to which the current object must be compared
	 * 
	 * @return 0, if both the names are the same. Negative number if the current
	 *         object's name is lexically smaller than the parameter object's name.
	 *         Positive number otherwise
	 */
	public int compareTo(Person person) {
		return name.compareTo(person.name);
	}

	/**
	 * Compares the name of the person object with the current object's name
	 * 
	 * @param obj
	 *            the object to which the current object must be compared
	 * 
	 * @return true, if both the names are the same. False otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			return name.equals(((Person) obj).name);
		}
		return false;
	}

	/**
	 * Creates a hashcode for the current object based on the name
	 * 
	 * @return Hashcode of the current object
	 */
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
