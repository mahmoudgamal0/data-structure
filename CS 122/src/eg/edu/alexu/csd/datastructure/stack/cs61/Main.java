package eg.edu.alexu.csd.datastructure.stack.cs61;

public class Main {
	
	
	public static void main(String args[])
	{
		Evaluator x = new Evaluator();
		
		
		
		String f = "a+b";
		
		System.out.println(x.infixToPostfix(f));
		
		String i = "1 1 2 + 7   * * 2 - ";
		
		System.out.println(x.evaluate(i));
	
	}
	
}
