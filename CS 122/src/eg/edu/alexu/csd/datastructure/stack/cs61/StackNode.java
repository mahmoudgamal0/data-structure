package eg.edu.alexu.csd.datastructure.stack.cs61;

public class StackNode {
	
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
