package eg.edu.alexu.csd.datastructure.linkedList.cs61_35;

import org.junit.Assert;

public class TestDList {

	@org.junit.Test
	public void testAdd() {
		DLinkedList list = new DLinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		Assert.assertEquals(list.size(), 3);
	}

	@org.junit.Test
	public void correctInsertion() {
		DLinkedList list = new DLinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		Assert.assertEquals(10, list.get(0));
		Assert.assertEquals(30, list.get(list.size() - 1));
	}

	@org.junit.Test
	public void correctMiddleInsertion() {
		DLinkedList list = new DLinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(list.size(), 25);
		list.add(2, 5);
		list.add(3, 15);
		list.add(1, 35);
		Assert.assertEquals(5, list.get(3));
		Assert.assertEquals(15, list.get(4));
		Assert.assertEquals(25, list.get(list.size() - 1));
		Assert.assertEquals(35, list.get(1));
	}

	@org.junit.Test
	public void changeElement() {
		DLinkedList list = new DLinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(list.size(), 25);
		list.add(2, 5);
		list.add(3, 15);
		list.add(1, 35);
		list.set(4, 70);
		Assert.assertEquals(70, list.get(4));

	}

	@org.junit.Test
	public void testSublist() {
		DLinkedList list = new DLinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(list.size(), 25);
		list.add(2, 5);
		list.add(3, 15);
		list.add(1, 35);
		DLinkedList x = (DLinkedList) list.sublist(3, 5);
		Assert.assertEquals(x.size(), 3);
		Assert.assertEquals(5, list.get(3));
		Assert.assertEquals(15, list.get(4));
		Assert.assertEquals(30, list.get(5));
	}

	@org.junit.Test
	public void testDelete() {
		DLinkedList list = new DLinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(list.size(), 25);
		list.add(2, 5);
		list.add(3, 15);
		list.add(1, 35);
		list.remove(4);
		Assert.assertEquals(list.size(), 6);
		Assert.assertEquals(5, list.get(3));
		Assert.assertEquals(30, list.get(4));
	}

	@org.junit.Test
	public void testContain() {
		DLinkedList list = new DLinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(list.size(), 25);
		list.add(2, 5);
		list.add(3, 15);
		list.add(1, 35);
		Assert.assertTrue(list.contains(15));
		list.remove(4);
		Assert.assertFalse(list.contains(15));
	}

	@org.junit.Test
	public void testEmpty() {
		DLinkedList list = new DLinkedList();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(list.size(), 25);
		list.add(2, 5);
		list.add(3, 15);
		list.add(1, 35);
		list.clear();
		Assert.assertTrue(list.isEmpty());
		Assert.assertEquals(0, list.size());
	}

}
