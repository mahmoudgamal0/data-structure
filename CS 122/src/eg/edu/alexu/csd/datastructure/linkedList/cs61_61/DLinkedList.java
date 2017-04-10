package eg.edu.alexu.csd.datastructure.linkedList.cs61_61;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class DLinkedList implements ILinkedList {

	private int size;
	private DNode header;
	private DNode trailer;

	public DLinkedList() 
	{
//		this.size = 0;
//		this.header = new DNode(null, null, null);
//		this.trailer = new DNode(header, null, null);
//		this.header.setNext(this.trailer);
		
		this.size = 0;
		this.header = null;
		this.trailer = null;
	}

	public void add(int index, Object element) 
	{
//		if(index > this.size)
//			return;
//		else if (index > this.size - 1) 
//		{
//			this.add(element);
//		} 
//		else if (index == 0) 
//		{
//			if (this.size == 0) 
//			{
//				this.add(element);
//			} 
//			else 
//			{
//				DNode tmp = this.header.getNext();
//				DNode addedNode = new DNode(this.header, tmp, element);
//				this.header.setNext(addedNode);
//				tmp.setPrevious(addedNode);
//				this.size++;
//			}
//		} 
//		else 
//		{
//			DNode tmp = this.header.getNext();
//			for (int i = 0; i <index; i++) 
//			{
//				tmp = tmp.getNext();
//			}
//			DNode addedNode = new DNode(tmp.getPrevious(), tmp, element);
//			tmp.getPrevious().setNext(addedNode);
//			tmp.setPrevious(addedNode);
//			this.size++;
//		}

		if(index > this.size)
			return;
		else if(isEmpty() || index == this.size)
			this.add(element);
		else
		{
			DNode temp = this.header;
			int n = 0;
			while(n < index)
			{
				temp = temp.getNext();
				n++;
			}
			DNode entry = new DNode(temp.getPrevious(),temp,element);
			if(temp == this.header)
			{
				this.header = entry;
			}
			else
			{
				temp.getPrevious().setNext(entry);
				temp.setPrevious(entry);
			}
			this.size++;
		}
	}

	public void add(Object element) {
//		if (this.size == 0) 
//		{
//			DNode addedNode = new DNode(this.header, this.trailer, element);
//			this.header.setNext(addedNode);
//			this.trailer.setPrevious(addedNode);
//			this.size++;
//		} 
//		else 
//		{
//			DNode tmp = this.trailer.getPrevious();
//			DNode addedNode = new DNode(tmp, this.trailer, element);
//			tmp.setNext(addedNode);
//			this.trailer.setPrevious(addedNode);
//			this.size++;
//		}
		
		DNode entry = new DNode(null,null,element);
		if(isEmpty())
			this.header = entry;
		else
		{
			this.trailer.setNext(entry);
			entry.setPrevious(this.trailer);
		}
			
		this.trailer = entry;
		this.size++;
	}


	public Object get(int index) {
//		if (index > this.size - 1) 
//		{
//			return null;
//		} 
//		else if (index == 0) 
//		{
//			return this.header.getNext().getValue();
//		}
//		else if (index == this.size - 1) 
//		{
//			return this.trailer.getPrevious().getValue();
//		} 
//		else 
//		{
//			DNode tmp = this.header.getNext();
//			for (int i = 0; i < index; i++) 
//			{
//				tmp = tmp.getNext();
//			}
//			return tmp.getValue();
//		}
		if(isEmpty() || index >= this.size)
			return null;
		else
		{
			DNode temp = this.header;
			int n = 0;
			while(n < index)
			{
				temp = temp.getNext();
				n++;
			}
			return temp.getValue();
		}
	}

	
	public void set(int index, Object element) {
//		if (index > this.size - 1 || this.size == 0) 
//			return;
//		else 
//		{
//			DNode tmp = this.header.getNext();
//			for (int i = 0; i < index; i++) {
//				tmp = tmp.getNext();
//			}
//			tmp.setValue(element);
//		}
		if(isEmpty() || index >= this.size)
			return;
		else
		{
			DNode temp = this.header;
			int n = 0;
			while(n < index)
			{
				temp = temp.getNext();
				n++;
			}
			temp.setValue(element);
		}
	}

	
	public void clear() {
//		this.header.getNext().setPrevious(null);
//		this.trailer.getPrevious().setNext(null);
//		this.header.setNext(this.trailer);
//		this.trailer.setPrevious(this.header);
//		this.size = 0;
		
		this.header = null;
		this.trailer = null;
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
//		if (index > this.size - 1 || this.size == 0)
//			return;
//		else 
//		{
//			DNode tmp = this.header.getNext();
//			for (int i = 0; i < index; i++) {
//				tmp = tmp.getNext();
//			}
//			tmp.getNext().setPrevious(tmp.getPrevious());
//			tmp.getPrevious().setNext(tmp.getNext());
//			this.size--;
//		}
		
		if(isEmpty() || index >= this.size)
			return;
		else
		{
			DNode temp = this.header;
			int n = 0;
			while(n < index)
			{
				temp = temp.getNext();
				n++;
			}
			if(temp == this.header)
			{
				this.header = this.header.getNext();
				this.header.setPrevious(null);
			}
			else if(temp == this.trailer)
			{
				this.trailer = this.trailer.getPrevious();
				this.trailer.setNext(null);
			}
			else
			{
				temp.getPrevious().setNext(temp.getNext());
				temp.getNext().setPrevious(temp.getPrevious());
				temp.setNext(null);
				temp.setPrevious(null);
			}
			this.size--;
		}
	}

	
	public int size() 
	{
		return this.size;
	}


	public ILinkedList sublist(int fromIndex, int toIndex) {
//		if (fromIndex < 0 || fromIndex > this.size - 1) 
//		{
//			DLinkedList newList = new DLinkedList();
//			return newList;
//		} 
//		else 
//		{
//			DLinkedList newList = new DLinkedList();
//			DNode tmp = this.header.getNext();
//			for (int i = 0; i < fromIndex; i++) 
//			{
//				tmp = tmp.getNext();
//			}
//			for (int i = fromIndex; i <= toIndex; i++) 
//			{
//				if(i > this.size - 1)
//					break;
//				newList.add(tmp.getValue());
//				tmp = tmp.getNext();
//			}
//			return newList;
//		}
		if(isEmpty() || fromIndex < 0 || fromIndex >= this.size || toIndex < 0)
			return null;
		else
		{
			
			if(toIndex < fromIndex)
				return null;
			else
			{
				DLinkedList dlist = new DLinkedList();
				int n = 0;
				DNode temp = this.header;
				while(n<fromIndex)
				{
					temp = temp.getNext();
					n++;
				}
				while(n<=toIndex && n<this.size)
				{
					dlist.add(temp);
					temp = temp.getNext();
					n++;
				}
				return dlist;
			}
		}
	}

	
	public boolean contains(Object o) {
//		if (this.size == 0) {
//			return false;
//		} else {
//			DNode tmp = this.header.getNext();
//			for (int i = 0; i < this.size; i++) {
//				if (o.equals(tmp.getValue())) {
//					return true;
//				}
//				tmp = tmp.getNext();
//			}
//		}
//		return false;
		
		if(isEmpty())
			return false;
		else
		{
			DNode temp = this.header;
			while(temp.getNext() != null)
			{
				if(o.equals(temp.getValue()))
					return true;
				temp = temp.getNext();
			}
			return false;
		}
	}
	
	
}