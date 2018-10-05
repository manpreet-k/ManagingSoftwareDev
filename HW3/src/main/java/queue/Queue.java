package queue;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides the implementation of a generic queue
 */
public class Queue<T> implements IQueue<T> {
	/**
	 * The component that needs to adapt
	 */
	private List<T> adaptee;

	/**
	 * This constructor initialized the adaptee
	 */
	public Queue() {
		adaptee = new ArrayList<T>();
	}

	/**
	 * add an element to the head of the queue
	 * 
	 * @param t
	 *            : element to be added to the head of the queue
	 */
	public boolean add(T t) {
		if (t != null)
			return adaptee.add(t);
		else
			throw new NullPointerException();
	}

	/**
	 * remove an element from the end of the queue.
	 * 
	 * @return : Element at the end of the queue.
	 */
	public T remove() {
		if (!adaptee.isEmpty()) {
			return adaptee.remove(0);
		}
		return null;
	}

	/**
	 * returns the head of the queue.
	 * 
	 * @return : Element at the head of the queue. Returns null if queue is empty
	 */
	public T peek() {
		if (!adaptee.isEmpty()) {
			int head = adaptee.size() - 1;
			return adaptee.get(head);
		}
		return null;
	}

}
