package eg.edu.alexu.csd.datastructure.queue.cs61;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class QueueArray implements IQueue, IArrayBased {

	private Object[] queue;
	private int front;
	private int rear;
	
	
	public QueueArray(int size)
	{
		this.queue = new Object[size];
		this.front = 0;
		this.rear = 0;
	}
	
	
	@Override
	public void enqueue(Object item) {
		if(size() == this.queue.length)
			throw null;
		this.queue[this.rear] = item;
		this.rear = (this.rear + 1) % this.queue.length;
	}

	@Override
	public Object dequeue() {
		if(isEmpty())
			throw null;
		Object temp = this.queue[this.front];
		this.queue[this.front] = null;
		this.front = (this.front + 1) % this.queue.length;
		return temp;
	}

	@Override
	public boolean isEmpty() {
		if(this.front == this.rear)
			return true;
		return false;
	}

	@Override
	public int size() {
		return (this.queue.length - this.front + this.rear) % this.queue.length;
	}
	
	public void print()
	{
		System.out.print("Queue: ");
		for(int i = 0 ; i < this.queue.length ; i++)
		{
			System.out.print(this.queue[i] + " ");
		}
		System.out.println();
	}
}
