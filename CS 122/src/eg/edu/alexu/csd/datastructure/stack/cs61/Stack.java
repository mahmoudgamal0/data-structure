/**
 *	The stack's ADT logic 
 */

package eg.edu.alexu.csd.datastructure.stack.cs61;

import eg.edu.alexu.csd.datastructure.stack.IStack;

public class Stack implements IStack {

	/**
	 * the head for adding at zero index
	 */
	private StackNode head;

	/**
	 * the tail which acts as the top of the stack
	 */
	private StackNode tail;

	/**
	 * the size of the stack
	 */
	private int size;

	/**
	 * a setter constructor
	 */
	public Stack() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * adds an element in a specific location
	 * 
	 * @param index
	 *            to place the element into
	 * @param element
	 *            the element to be placed
	 * @throws null
	 *             if the index is out of bounds
	 */
	public void add(int index, Object element) {
		if (index > this.size || index < 0)
			throw null;
		if (index == 0) {
			StackNode entry = new StackNode(this.head, null, element);
			this.head = entry;
			if (this.isEmpty())
				this.tail = this.head;
			else {
				entry.getNext().setPrev(entry);
			}
		} else if (index == this.size) {
			StackNode entry = new StackNode(null, this.tail, element);
			this.tail.setNext(entry);
			this.tail = entry;
		} else {
			StackNode temp = this.head;
			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}
			StackNode entry = new StackNode(temp, temp.getPrev(), element);
			entry.getNext().setPrev(entry);
			entry.getPrev().setNext(entry);
		}
		this.size++;
	}

	/**
	 * retrieves the top element in the stack and deletes it
	 * 
	 * @return the top element
	 * @throws null
	 *             if the stack is empty
	 */
	public Object pop() {
		Object temp = this.peek();
		if (this.size != 1) {
			this.tail = this.tail.getPrev();
			this.tail.setNext(null);
			this.size--;
		} else
			this.clear();
		return temp;
	}

	/**
	 * retrieves the top element in the stack and does not delete it
	 * 
	 * @return the top element
	 * @throws null
	 *             if the stack is empty
	 */
	public Object peek() {
		if (this.isEmpty())
			throw new RuntimeException();
		Object temp = this.tail.getElement();
		return temp;
	}

	/**
	 * adds a new element at the top of the stack
	 * 
	 * @param element
	 *            to be pushed
	 */
	public void push(Object element) {
		this.add(this.size, element);
	}

	/**
	 * checks whether the stack is empty or not
	 * 
	 * @return true if the stack is empty
	 * @return false if the stack is not empty
	 */
	public boolean isEmpty() {
		if (this.size == 0)
			return true;
		return false;
	}

	/**
	 * @return the number of elements in the stack
	 */
	public int size() {
		return this.size;
	}

	/**
	 * prints all the values in the stack
	 */
	public void print() {
		StackNode temp = this.head;
		System.out.println("========================================");
		System.out.print("Stack: ");
		while (temp != null) {
			System.out.print(temp.getElement() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}

	/**
	 * sets the stack empty
	 */
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
}
