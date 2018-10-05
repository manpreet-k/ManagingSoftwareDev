package ast4b;

import java.util.NoSuchElementException;

import ast4b.Node;

/**
 * The interface for the root of the ASTs
 * 
 * @author Manpreet Kaur
 *
 */
public abstract class Node {
	/**
	 * Constant initial size of the list
	 */
	private static final int INIT_SIZE = 50;

	/**
	 * Constant initial index of the list
	 */
	private static final int INIT_INDEX = 0;

	/**
	 * Current size of the list containing node objects
	 */
	protected static int size;

	/**
	 * Last inserted index of the list containing node objects
	 */
	protected static int index;

	/**
	 * Id of the object
	 */
	protected int id;

	/**
	 * List of objects of type node that have been created so far
	 */
	protected static Node[] nodeIds;

	/**
	 * This method returns the string representation of the node object
	 * 
	 */
	public abstract String textRepresentation();

	/**
	 * This method implements the visitor class
	 * 
	 */
	public abstract void accept(ASTVisitor visitor);

	/**
	 * This returns the node object corresponding to the unique identifier
	 * 
	 */
	public static Node getNode(int id) throws NoSuchElementException {
		return nodeIds[id];
	}

	/**
	 * This returns the corresponding to the unique identifier of the node object
	 * 
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the unique identifier for the object
	 * 
	 */
	private void setId() {
		if (index >= size) {
			size += size;
			Node[] newNodeIds = new Node[size];
			System.arraycopy(nodeIds, 0, newNodeIds, 0, nodeIds.length);
			nodeIds = newNodeIds;
		}

		id = index;
		index++;
		nodeIds[id] = this;

	}

	/**
	 * This constructor initializes the list that stores the objects of type node
	 * that have been created so far
	 * 
	 */
	public Node() {
		if (nodeIds == null) {
			resetIds();
		}
		setId();
	}

	/**
	 * This method resets the variables for capturing unique ids
	 */
	public static void resetIds() {
		size = INIT_SIZE;
		index = INIT_INDEX;
		nodeIds = new Node[size];
	}
}
