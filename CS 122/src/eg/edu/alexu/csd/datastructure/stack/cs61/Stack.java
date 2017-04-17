package eg.edu.alexu.csd.datastructure.stack.cs61;

import eg.edu.alexu.csd.datastructure.stack.IStack;

public class Stack implements IStack {


	private StackNode head;
	private StackNode tail;
	private int size;

	public Stack() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public void add(int index, Object element) {
		if (index > this.size || index < 0)
			throw null;
		if (index == 0) {
			StackNode entry = new StackNode(this.head, element);
			this.head = entry;
			if(this.isEmpty())
				this.tail = this.head;
		} else if (index == this.size) {
			StackNode entry = new StackNode(null, element);
			this.tail.setNext(entry);
			this.tail = entry;
		} else {
			StackNode temp = this.head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.getNext();
			}
			StackNode entry = new StackNode(temp.getNext(), element);
			temp.setNext(entry);
		}
		this.size++;
	}

	public Object pop() {
		Object temp = this.peek();
		StackNode traverser = this.head;
		while(traverser.getNext()!= this.tail && traverser!=this.tail)
			traverser = traverser.getNext();
		this.tail = traverser;
		this.tail.setNext(null);
		this.size--;
		return temp;
	}

	public Object peek() {
		if (this.isEmpty())
			throw new RuntimeException();
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
