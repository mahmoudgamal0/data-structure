package eg.edu.alexu.csd.datastructure.linkedList.cs61_61;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class DLinkedList implements ILinkedList {

	private int size;
	private DNode header;
	private DNode trailer;

	public DLinkedList() 
	{
		this.size = 0;
		this.header = new DNode(null, null, null);
		this.trailer = new DNode(header, null, null);
		this.header.setNext(this.trailer);
	}

	public void add(int index, Object element) 
	{
		if(index > this.size)
			throw null;
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
				DNode tmp = this.header.getNext();
				DNode addedNode = new DNode(this.header, tmp, element);
				this.header.setNext(addedNode);
				tmp.setPrevious(addedNode);
				this.size++;
			}
		} 
		else 
		{
			DNode tmp = this.header.getNext();
			for (int i = 0; i <index; i++) 
			{
				tmp = tmp.getNext();
			}
			DNode addedNode = new DNode(tmp.getPrevious(), tmp, element);
			tmp.getPrevious().setNext(addedNode);
			tmp.setPrevious(addedNode);
			this.size++;
		}
	}

	public void add(Object element) {
		if (this.size == 0) 
		{
			DNode addedNode = new DNode(this.header, this.trailer, element);
			this.header.setNext(addedNode);
			this.trailer.setPrevious(addedNode);
			this.size++;
		} 
		else 
		{
			DNode tmp = this.trailer.getPrevious();
			DNode addedNode = new DNode(tmp, this.trailer, element);
			tmp.setNext(addedNode);
			this.trailer.setPrevious(addedNode);
			this.size++;
		}
		
	}


	public Object get(int index) {
		if (index > this.size - 1 || index < 0 || isEmpty()) 
		{
			throw null;
		} 
		else if (index == 0) 
		{
			return this.header.getNext().getValue();
		}
		else if (index == this.size - 1) 
		{
			return this.trailer.getPrevious().getValue();
		} 
		else 
		{
			DNode tmp = this.header.getNext();
			for (int i = 0; i < index; i++) 
			{
				tmp = tmp.getNext();
			}
			return tmp.getValue();
		}
		
	}

	
	public void set(int index, Object element) {
		if (index > this.size - 1 || this.size == 0 || index < 0) 
			throw null;
		else 
		{
			DNode tmp = this.header.getNext();
			for (int i = 0; i < index; i++) {
				tmp = tmp.getNext();
			}
			tmp.setValue(element);
		}
	}

	
	public void clear() {
		if(isEmpty())
			throw null;
		this.header.getNext().setPrevious(null);
		this.trailer.getPrevious().setNext(null);
		this.header.setNext(this.trailer);
		this.trailer.setPrevious(this.header);
		this.size = 0;
	}


	public boolean isEmpty() 
	{
		if (this.size == 0) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}

	
	public void remove(int index) {
		if (index > this.size - 1 || this.size == 0 || index < 0)
			throw null;
		else 
		{
			DNode tmp = this.header.getNext();
			for (int i = 0; i < index; i++) {
				tmp = tmp.getNext();
			}
			tmp.getNext().setPrevious(tmp.getPrevious());
			tmp.getPrevious().setNext(tmp.getNext());
			this.size--;
		}
	}

	
	public int size() 
	{
		return this.size;
	}


	public ILinkedList sublist(int fromIndex, int toIndex) {
		if (fromIndex < 0 || fromIndex > this.size - 1  || isEmpty() || toIndex >= this.size) 
		{
			throw null;
		} 
		else 
		{
			if(toIndex < fromIndex)
				throw null;
			DLinkedList newList = new DLinkedList();
			DNode tmp = this.header.getNext();
			for (int i = 0; i < fromIndex; i++) 
			{
				tmp = tmp.getNext();
			}
			for (int i = fromIndex; i <= toIndex; i++) 
			{
				if(i > this.size - 1)
					break;
				newList.add(tmp.getValue());
				tmp = tmp.getNext();
			}
			return newList;
		}

	}

	
	public boolean contains(Object o) {
		if (this.size == 0) {
			throw null;
		} else {
			DNode tmp = this.header.getNext();
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