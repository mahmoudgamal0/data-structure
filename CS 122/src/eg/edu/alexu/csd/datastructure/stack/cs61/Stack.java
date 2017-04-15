package eg.edu.alexu.csd.datastructure.stack.cs61;

import eg.edu.alexu.csd.datastructure.stack.IStack;
import java.lang.Exception;

public class Stack implements IStack {

	private class StackNode {

		private Object element;
		private StackNode next;

		public StackNode(StackNode next, Object element) {
			this.element = element;
			this.next = next;
		}

		public void setElement(Object element) {
			this.element = element;
		}

		public void setNext(StackNode next) {
			this.next = next;
		}

		public StackNode getNext() {
			return this.next;
		}

		public Object getElement() {
			return this.element;
		}
	}

	private StackNode head;
	private StackNode tail;
	private int size;

	public Stack() {
		this.head = null;
		this.size = 0;
	}

	public void add(int index, Object element) {
		if (index > this.size || index < 0)
			throw null;
		if (index == 0) {
			StackNode entry = new StackNode(this.head, element);
			this.head = entry;
			if(isEmpty())
				this.tail = this.head;
			this.size++;
		} else {
			StackNode temp = this.head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.getNext();
			}
			StackNode entry = new StackNode(temp.getNext(), element);
			temp.setNext(entry);
			this.size++;
		}
	}

	public Object pop() {
		Object temp = this.peek();
		StackNode traverser = this.head;
		while(traverser.getNext() != this.tail)
			traverser = traverser.getNext();
		this.tail = traverser;
		this.tail.setNext(null);
		this.size--;
		return temp;
	}

	public Object peek() {
		if (this.isEmpty())
			throw null;
		Object temp = this.tail.getElement();
		return temp;
	}

	public void push(Object element) {
		this.add(this.size, element);
	}

	public boolean isEmpty() {
		if (this.size == 0)
			return true;
		return false;
	}

	public int size() {
		return this.size;
	}

	public void print() {
		StackNode temp = this.head;
		System.out.print("stack: ");
		while (temp != null) {
			System.out.print(temp.getElement() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}
}
