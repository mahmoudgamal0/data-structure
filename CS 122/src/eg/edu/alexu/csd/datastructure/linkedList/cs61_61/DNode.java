package eg.edu.alexu.csd.datastructure.linkedList.cs61_61;

public class DNode {
	
	private DNode nextNode;
	private DNode previousNode;
	private Object element;

	public DNode() {
		this(null, null, null);
	}

	public DNode(DNode previousNode, DNode nextNode, Object value) {
		this.nextNode = nextNode;
		this.previousNode = previousNode;
		this.element = value;
	}

	public void setNext(DNode nextNode) {
		this.nextNode = nextNode;
	}

	public void setPrevious(DNode previousNode) {
		this.previousNode = previousNode;
	}

	public DNode getNext() {
		return this.nextNode;
	}

	public DNode getPrevious() {
		return this.previousNode;
	}

	public void setValue(Object value) {
		this.element = value;
	}

	public Object getValue() {
		return this.element;
	}

}
