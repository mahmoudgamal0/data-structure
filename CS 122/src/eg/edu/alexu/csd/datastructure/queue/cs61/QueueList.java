package eg.edu.alexu.csd.datastructure.queue.cs61;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class QueueList implements IQueue, ILinkedBased{

	private QueueNode head;
	private QueueNode tail;
	private int size;
	
	public QueueList()
	{
		this.head = null;
		this.tail = null;
		this.size =  0;
	}
	
	@Override
	public void enqueue(Object item) {
		QueueNode temp = new QueueNode(item,null);
		if(isEmpty())
		{
			this.tail = temp;
			this.head = this.tail;
		}
		else
		{
			this.tail.setNext(temp);
			this.tail = temp;
		}
		this.size++;
	}

	@Override
	public Object dequeue() {
		if(isEmpty())
			throw null;
		Object temp = this.head.getElement();
		this.head = this.head.getNext();
		this.size--;
		return temp;
	}

	@Override
	public boolean isEmpty() {
		if(this.size == 0)
			return true;
		return false;
	}

	@Override
	public int size() {
		return this.size;
	}

	public void print()
	{
		System.out.print("Queue :");
		QueueNode temp = this.head;
		while(temp != null)
		{
			System.out.print(temp.getElement() + " ");
			temp = temp.getNext();
		}
		
		System.out.println();
	}
}
