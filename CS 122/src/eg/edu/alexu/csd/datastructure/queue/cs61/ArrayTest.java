package eg.edu.alexu.csd.datastructure.queue.cs61;

import org.junit.Assert;
import org.junit.Test;

public class ArrayTest {

	@Test
	public void testEnqueue()
	{
		QueueArray qa = new QueueArray(5);
		qa.enqueue(1);
		qa.enqueue(2);
		qa.enqueue(3);
		Assert.assertEquals(qa.dequeue(), 1);
	}
	
	@Test
	public void testDequeue()
	{
		QueueArray qa = new QueueArray(5);
		qa.enqueue(1);
		qa.enqueue(2);
		qa.enqueue(3);
		qa.dequeue();
		qa.dequeue();
		Assert.assertEquals(qa.dequeue(),3);
		
	}
	
	@Test
	public void testSize()
	{
		QueueArray qa = new QueueArray(5);
		qa.enqueue(1);
		qa.enqueue(2);
		qa.enqueue(3);
		qa.dequeue();
		Assert.assertEquals(qa.size(), 2);
		
	}
	
	@Test
	public void testEmpty()
	{
		QueueArray qa = new QueueArray(5);
		Assert.assertEquals(qa.isEmpty(), true);
		qa.enqueue(1);
		qa.enqueue(2);
		qa.enqueue(3);
		qa.dequeue();
		qa.dequeue();
		Assert.assertEquals(qa.isEmpty(), false);
		qa.dequeue();
		Assert.assertEquals(qa.isEmpty(), true);
		
	}
	
	@Test(expected=NullPointerException.class)
	public void testDequeueEmpty()
	{
		QueueArray qa = new QueueArray(5);
		qa.enqueue(1);
		qa.dequeue();
		qa.dequeue();
	}
	
	@Test(expected = NullPointerException.class)
	public void testFull()
	{
		QueueArray qa = new QueueArray(5);
		qa.enqueue(1);
		qa.enqueue(2);
		qa.enqueue(3);
		qa.enqueue(4);
		qa.enqueue(5);
		qa.enqueue(6);
	}

}
