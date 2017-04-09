package eg.edu.alexu.csd.datastructure.linkedList.cs61;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class SLinkedList implements ILinkedList{

	
	private int size;
	private SNode head;
	private SNode tail;

	public SLinkedList() {
		this.size = 0;
		this.tail = null;
		this.head = null;
	}

	@Override
	public void add(int index, Object element) {
	
		if(index > this.size)
			return;
		else if (index > this.size - 1) 
		{
			this.add(element);
		} 
		else if (index == 0) 
		{
			if (this.size == 0) 
			{
				this.add(element);
			} 
			else 
			{
				SNode tmp = this.head;
				SNode addedNode = new SNode(tmp, element);
				this.head = addedNode;
				this.size++;
			}
		} 
		else if (index == this.size - 1) 
		{
			this.add(element);
		} 
		else 
		{
			SNode tmp = this.head;
			for (int i = 0; i < index - 1; i++) {
				tmp = tmp.getNext();
			}
			SNode addedNode = new SNode(tmp.getNext(), element);
			tmp.setNext(addedNode);
			this.size++;
		}

	}

	@Override
	public void add(Object element) {
		if (this.size == 0) 
		{
			SNode addedNode = new SNode(null, element);
			this.head = addedNode;
			this.tail = addedNode;
			this.size++;
		} 
		else if (this.size == 1) 
		{
			SNode addedNode = new SNode(null, element);
			this.head.setNext(addedNode);
			this.tail = addedNode;
			this.size++;
		} 
		else 
		{
			SNode tmp = this.tail;
			SNode addedNode = new SNode(null, element);
			tmp.setNext(addedNode);
			this.tail = addedNode;
			this.size++;
		}
	}

	@Override
	public Object get(int index) {
		if (index > this.size - 1) {
			return null;
		} else if (index == 0) {
			return this.head.getValue();
		} else if (index == this.size - 1) {
			return this.tail.getValue();
		} else {
			SNode tmp = this.head;
			for (int i = 0; i < index ; i++) {
				tmp = tmp.getNext();
			}
			return tmp.getValue();
		}
	}

	@Override
	public void set(int index, Object element) {
		if (index > this.size - 1 || this.size == 0) 
		{

		} else {
			SNode tmp = this.head;
			for (int i = 0; i < index; i++) 
			{
				tmp = tmp.getNext();
			}
			tmp.setValue(element);
		}
	}

	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void remove(int index) {
		if (index > this.size - 1 || this.size == 0) 
		{

		}
		else if (index == 0) 
		{
			if (this.size == 1) 
			{
				this.clear();
			} 
			else 
			{
				SNode tmp = this.head;
				this.head = tmp.getNext();
				tmp.setNext(null);
				this.size--;
			}
		} 
		else 
		{
			SNode tmp = this.head;
			for (int i = 0; i < index - 1; i++) 
			{
				tmp = tmp.getNext();
			}
			SNode removedNode = tmp.getNext();
			if (this.tail == removedNode) 
			{
				this.tail = tmp;
			}
			tmp.setNext(removedNode.getNext());
			removedNode.setNext(null);
			this.size--;

		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		if (fromIndex < 0 || fromIndex > this.size - 1) {
			SLinkedList newList = new SLinkedList();
			return null;
		} else {
			SLinkedList newList = new SLinkedList();
			SNode tmp = this.head;
			for (int i = 0; i < fromIndex; i++) {
				tmp = tmp.getNext();
			}
			for (int i = fromIndex; i <= toIndex; i++) {
				if(i > this.size - 1)
					break;
				newList.add(tmp.getValue());
				tmp = tmp.getNext();
			}
			return newList;
		}

	}

	@Override
	public boolean contains(Object o) {
		if (this.size == 0) {
			return false;
		} else {
			SNode tmp = this.head;
			for (int i = 0; i < this.size; i++) {
				if (o.equals(tmp.getValue())) {
					return true;
				}
				tmp = tmp.getNext();
			}
		}
		return false;
	}
	
}
