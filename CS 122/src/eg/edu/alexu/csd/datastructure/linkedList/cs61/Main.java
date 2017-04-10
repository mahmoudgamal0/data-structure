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
		
		
		list.add(2);
		list.add(3);
		list.add(4);
		list.print();
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		list.add(0,1);
		list.print();
		list.add(5,5);
		list.print();
		list.add(4,6);
		list.print();
		list.add(6,7);
		list.print();
	}
}
