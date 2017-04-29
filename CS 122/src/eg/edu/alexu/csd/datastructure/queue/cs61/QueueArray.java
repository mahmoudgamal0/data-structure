package eg.edu.alexu.csd.datastructure.queue.cs61;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class QueueArray implements IQueue, IArrayBased {

	private Object[] queue;
	private int front;
	private int rear;
	private int size;
	
	public QueueArray(int size)
	{
		this.queue = new Object[size];
		this.front = 0;
		this.rear = 0;
		this.size = 0;
	}
	
	
	@Override
	public void enqueue(Object item) {
		
		if(isFull())
			throw null;
		
		this.queue[this.rear] = item;
		if(this.rear == this.queue.length - 1)
			this.rear = 0;
		else
			this.rear++;
		this.size++;
		
	}

	@Override
	public Object dequeue() {
		
		if(isEmpty())
			throw null;
		Object temp = this.queue[this.front];
		this.queue[this.front] = null;
		if(this.front == this.queue.length - 1)
			this.front = 0;
		else
			this.front++;
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
	
	public boolean isFull()
	{
		if(this.size == this.queue.length)
			return true;
		return false;
	}
	
}
