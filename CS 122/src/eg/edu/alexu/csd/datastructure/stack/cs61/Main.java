package eg.edu.alexu.csd.datastructure.stack.cs61;

public class Main {
	
	
	public static void main(String args[])
	{
		Evaluator x = new Evaluator();
		
		
		
		String f = "2+(3*4)";
		
		System.out.println(x.infixToPostfix(f));
		
		String i = "1 2 * 3 * 4 * 5 *";
		
		System.out.println(x.evaluate(i));
	
	}
	
}
