/**
 * The basis of the stack implementation
 * This is a stack based on a doubly linked list implementation
 */

package eg.edu.alexu.csd.datastructure.stack.cs61;

public class StackNode {

	/**
	 * The data to be held
	 */
	private Object element;

	/**
	 * The next node
	 */
	private StackNode next;

	/**
	 * The previous node
	 */
	private StackNode prev;

	/**
	 * Constructor for the stack
	 * 
	 * @param next
	 *            the id of the next node
	 * @param prev
	 *            the id of the previous node
	 * @param element
	 *            the data to be held
	 */
	public StackNode(StackNode next, StackNode prev, Object element) {
		this.element = element;
		this.next = next;
		this.prev = prev;
	}

	/**
	 * sets the data field of a node
	 * 
	 * @param element
	 *            to hold the data
	 */
	public void setElement(Object element) {
		this.element = element;
	}

	/**
	 * sets the next node
	 * 
	 * @param next
	 *            the id of the next node
	 */
	public void setNext(StackNode next) {
		this.next = next;
	}

	/**
	 * 
	 * @return the instance of the next node
	 */
	public StackNode getNext() {
		return this.next;
	}

	/**
	 * sets the previous node
	 * 
	 * @param prev
	 *            the id to the previous node
	 */
	public void setPrev(StackNode prev) {
		this.prev = prev;
	}

	/**
	 * 
	 * @return the instance of the previous node
	 */
	public StackNode getPrev() {
		return this.prev;
	}

	/**
	 * 
	 * @return the data held in the node
	 */
	public Object getElement() {
		return this.element;
	}
}
