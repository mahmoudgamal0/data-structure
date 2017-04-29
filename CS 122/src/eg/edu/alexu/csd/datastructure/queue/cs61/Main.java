package eg.edu.alexu.csd.datastructure.queue.cs61;

public class Main {

	public static void main(String[] args) {
		
		QueueList x = new QueueList();
		QueueArray y = new QueueArray(4);
		
		
		System.out.println(y.isEmpty());
		y.enqueue(1);
		System.out.println(y.size());
		y.enqueue(2);
		System.out.println(y.size());
		y.enqueue(3);
		System.out.println(y.size());
		y.print();
		y.dequeue();
		System.out.println(y.isEmpty());
		y.dequeue();
		y.print();
		y.enqueue(4);
		y.print();
		y.dequeue();
		y.print();
		y.dequeue();
		y.print();
		System.out.println(y.isEmpty());
		y.enqueue(1);
		y.print();
		y.dequeue();
		y.print();
		
	}

}
