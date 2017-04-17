package eg.edu.alexu.csd.datastructure.stack.cs61;

public class StackNode {
	
	private Object element;
	private StackNode next;
	private StackNode prev;

	public StackNode(StackNode next, StackNode prev ,Object element) {
		this.element = element;
		this.next = next;
		this.prev = prev;
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
	
	public void setPrev(StackNode prev){
		this.prev = prev;
	}
	
	public StackNode getPrev(){
		return this.prev;
	}

	public Object getElement() {
		return this.element;
	}
}
