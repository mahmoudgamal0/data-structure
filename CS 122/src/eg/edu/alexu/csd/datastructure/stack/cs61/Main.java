package eg.edu.alexu.csd.datastructure.stack.cs61;

public class Main {
	
	
	public static void main(String args[])
	{
		ExpressionEvaluator x = new ExpressionEvaluator();
		
		
		
		String f = "( + 1  ) +1*1";
		
		System.out.println(x.infixToPostfix(null));
		
		
		System.out.println(x.evaluate(x.infixToPostfix(f)));
	
	}
	
}
