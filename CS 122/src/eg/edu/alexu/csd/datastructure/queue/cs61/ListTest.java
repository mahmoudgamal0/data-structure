package eg.edu.alexu.csd.datastructure.queue.cs61;

import org.junit.Assert;
import org.junit.Test;
import java.lang.NullPointerException;

public class ListTest {

	@Test
	public void testEnqueue() {
		QueueList ql = new QueueList();
		ql.enqueue(1);
		ql.enqueue(2);
		ql.enqueue(3);
		Assert.assertEquals(ql.dequeue(), 1);
	}

	@Test
	public void testDequeue() {
		QueueList ql = new QueueList();
		ql.enqueue(1);
		ql.enqueue(2);
		ql.enqueue(3);
		ql.dequeue();
		ql.dequeue();
		Assert.assertEquals(ql.dequeue(), 3);

	}

	@Test
	public void testSize() {
		QueueList ql = new QueueList();
		ql.enqueue(1);
		ql.enqueue(2);
		ql.enqueue(3);
		ql.dequeue();
		Assert.assertEquals(ql.size(), 2);

	}

	@Test
	public void testEmpty() {
		QueueList ql = new QueueList();
		Assert.assertEquals(ql.isEmpty(), true);
		ql.enqueue(1);
		ql.enqueue(2);
		ql.enqueue(3);
		ql.dequeue();
		ql.dequeue();
		Assert.assertEquals(ql.isEmpty(), false);
		ql.dequeue();
		Assert.assertEquals(ql.isEmpty(), true);

	}

	@Test(expected = NullPointerException.class)
	public void testDequeueEmpty() {
		QueueList ql = new QueueList();
		ql.enqueue(1);
		ql.dequeue();
		ql.dequeue();
	}

}
