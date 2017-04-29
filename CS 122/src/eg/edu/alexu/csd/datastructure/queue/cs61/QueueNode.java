package eg.edu.alexu.csd.datastructure.queue.cs61;

public class QueueNode {

	private Object element;
	private QueueNode next;
	
	public QueueNode()
	{
		this(null,null);
	}
	
	public QueueNode(Object element, QueueNode next)
	{
		this.element = element;
		this.next = next;
	}
	
	public void setElement(Object element)
	{
		this.element = element;
	}
	
	public void setNext(QueueNode next)
	{
		this.next = next;
	}
	
	public Object getElement()
	{
		return this.element;
	}
	
	public QueueNode getNext()
	{
		return this.next;
	}
}
