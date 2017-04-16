package eg.edu.alexu.csd.datastructure.stack.cs61;

public class Main {
	
	
	public static void main(String args[])
	{
		Stack x = new Stack();
		
		x.add(0, 1);
		x.print();
		x.push(5);
		x.print();
		x.add(1, 2);
		x.print();
		x.add(0,3);
		x.print();
		System.out.println(x.peek());
		x.push(4);
		x.push(5);
		System.out.println(x.peek());
		x.print();
		System.out.println(x.size());
		System.out.println(x.pop());
		System.out.println(x.size());
		x.print();
		System.out.println(x.peek());
		x.add(x.size(), 6);
		System.out.println(x.size());
		x.print();
		
	}
	
}
