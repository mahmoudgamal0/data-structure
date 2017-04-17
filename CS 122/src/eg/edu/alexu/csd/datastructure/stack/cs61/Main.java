package eg.edu.alexu.csd.datastructure.stack.cs61;

public class Main {
	
	
	public static void main(String args[])
	{
		ExpressionEvaluator x = new ExpressionEvaluator();
		
		
		
		String f = "1*(12*(1+2))-2";
		
		System.out.println(x.infixToPostfix(f));
		
		String i = "1 12 1 2 + * * 2 -";
		
		System.out.println(x.evaluate(i));
		
	}
	
}
