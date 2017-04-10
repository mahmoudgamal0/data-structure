package eg.edu.alexu.csd.datastructure.linkedList.cs61;


public class Main {
	
	public static void main(String args[])
	{
//		int[][] terms = {{4,3},{3,2},{-1,1},{-1,0}};
//		PolynomialSolver x = new PolynomialSolver();
//		x.setPolynomial('A', terms);
//		x.setPolynomial('B', terms);
//		terms = x.subtract('A', 'B');
//		System.out.println(x.evaluatePolynomial('A', 2));
//		for(int i =0; i<terms.length;i++)
//		{
//			System.out.println("{" + terms[i][0] + ", " + terms[i][1] + "}");
//		}
//		System.out.println(x.print('A'));
//		System.out.println(x.print('B'));
		
		
		SLinkedList list = new SLinkedList();
		
		
		list.clear();
		list.print();
		list.remove(0);
		list.print();
		System.out.println(list.get(0));
		list.set(0, 5);
		list.print();
		list.add(10);
		list.add(20);
		list.add(40);
		list.print();
		list.add(0, 5);
		list.print();
		list.add(4,50);
		list.print();
		System.out.println(list.get(1));
		list.set(1,30);
		list.print();
		list.add(3,10);
		list.print();
		
	}
}
