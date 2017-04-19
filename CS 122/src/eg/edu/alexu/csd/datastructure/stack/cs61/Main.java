package eg.edu.alexu.csd.datastructure.stack.cs61;

public class Main {
	
	
	public static void main(String args[])
	{
		ExpressionEvaluator x = new ExpressionEvaluator();
		
		
		
		String f = "13/12 -1";
		
		System.out.println(x.infixToPostfix(f));
		
		
		System.out.println(x.evaluate(x.infixToPostfix(f)));
	
	}
	
}
