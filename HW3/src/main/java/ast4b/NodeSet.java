package ast4b;

import ast4b.Node;
import ast4b.BitVector;
import ast4b.IBitVector;
import ast4b.Iterator;

/**
 * Class NodeSet represents a set of AST Nodes.
 * 
 * @author Manpreet Kaur
 *
 */
public class NodeSet implements Set<Node> {
	/**
	 * The component that needs to adapt
	 */
	private IBitVector adaptee;

	/**
	 * This constructor initialized the adaptee
	 */
	public NodeSet() {
		adaptee = new BitVector();
	}

	/**
	 * Add a Node object to the NodeSet
	 * 
	 * @param Node
	 *            object to be added
	 * 
	 */
	@Override
	public void add(Node n) {
		adaptee.set(n.getId());
	}

	/**
	 * Add all Node in the NodeSet
	 * 
	 * @param Set
	 *            of all the nodes to be added
	 * 
	 */
	@Override
	public void addAll(Set<Node> n) {
		Iterator<Node> iterator = n.iterator();

		while (iterator.hasAnotherElement()) {
			Node nextElement = iterator.nextElement();
			adaptee.set(nextElement.getId());
		}
	}

	/**
	 * Remove the Node element
	 * 
	 * @param Node
	 *            object to be removed
	 * 
	 */
	@Override
	public void remove(Node n) {
		int id = n.getId();
		adaptee.clear(id);
	}

	/**
	 * Check if the Node object occurs in the set
	 * 
	 * @param Node
	 *            object to be checked
	 * 
	 */
	@Override
	public boolean contains(Node n) {
		int id = n.getId();
		return adaptee.get(id);
	}

	/**
	 * Return the number of arguments in the set
	 */
	@Override
	public int size() {
		return adaptee.size();
	}

	/**
	 * Return an iterator over the set
	 */
	@Override
	public Iterator<Node> iterator() {
		Iterator<Integer> iterator = adaptee.iterator();
		return new Iterator<Node>() {

			@Override
			public Node nextElement() {
				int nextElement = iterator.nextElement();
				if(nextElement != -1)
					return Node.getNode(nextElement);
				return null;
			}

			@Override
			public boolean hasAnotherElement() {
				return iterator.hasAnotherElement();
			}
		};
	}

	/**
	 * Returns the size of the NodeSet as a String
	 */
	@Override
	public String toString() {
		return String.valueOf(adaptee.size());
	}
}
