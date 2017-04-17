package eg.edu.alexu.csd.datastructure.stack.cs61;

public class Main {
	
	
	public static void main(String args[])
	{
		Stack x = new Stack();
		
		x.push(4);
		x.print();
		x.push(5);
		x.print();
		x.push(7);
		x.print();
		System.out.println(x.peek());
		System.out.println(x.pop());
		x.print();
	}
	
}
