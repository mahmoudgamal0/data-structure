package eg.edu.alexu.csd.datastructure.linkedList.cs61_61;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;


public class SLinkedList implements ILinkedList{

	
	private int size;
	private SNode head;
	private SNode tail;

	public SLinkedList() 
	{
		this.size = 0;
		this.tail = null;
		this.head = null;
	}

	@Override
	public void add(int index, Object element) {
	
		if(index > this.size)
			throw null;
		if (index == this.size) 
		{
			this.add(element);
		} 
		else if(index == 0)
		{
			SNode newNode = new SNode(this.head, element);
			this.head = newNode;
			this.size++;
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
	public void add(Object element)
	{
		SNode addedNode = new SNode(null, element);
		if(isEmpty())
			this.head = addedNode;
		else
			this.tail.setNext(addedNode);
		this.tail = addedNode;
		this.size++;
	}

	@Override
	public Object get(int index) {
		
		if(index >=this.size || index < 0)
			throw null;
		if(isEmpty())
			return null;
		else
		{
			SNode temp = this.head;
			for(int i = 0 ; i < index ; i++)
			{
				temp = temp.getNext();
			}
			return temp.getValue();
		}
		
	}

	@Override
	public void set(int index, Object element) {
		
		if(isEmpty() || index >= this.size || index < 0)
			throw null;
		else
		{
			SNode temp = this.head;
			for(int i = 0 ; i < index ; i++)
			{
				temp = temp.getNext();
			}
			temp.setValue(element);
		}
	}

	@Override
	public void clear() {
		if(isEmpty())
			throw null;
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
		
		if(isEmpty() || index >= this.size || index < 0)
			throw null;
		else if(index == 0)
		{
			this.head = this.head.getNext();
			this.size--;
			if(isEmpty())
			{
				this.tail = null;
			}
		}
		else
		{
			SNode temp = this.head;
			for(int i = 0 ; i < index - 1 ; i++)
			{
				temp = temp.getNext();
			}
			
			if(temp.getNext() == this.tail)
			{
				this.tail = temp;
				temp.setNext(null);
			}
			else
			{
				temp.setNext(temp.getNext().getNext());
			}
			this.size--;
		}
		
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		if (fromIndex < 0 || fromIndex >= this.size || isEmpty() || toIndex >= this.size)
		{
			throw null;
		}
		else 
		{
			if(fromIndex > toIndex)
			{
				return null;
			}
			SLinkedList newList = new SLinkedList();
			SNode tmp = this.head;
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

	@Override
	public boolean contains(Object o) {
		if (this.isEmpty()) {
			throw null;
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
	
	public void print()
	{
		if(isEmpty())
		{
			System.out.println("The List: ");
			return;
		}
		SNode temp = this.head;
		System.out.print("The list: ");
		while(temp!=null)
		{
			System.out.print(temp.getValue() + " ");
			temp=temp.getNext();
		}
		System.out.println();
	}
}
