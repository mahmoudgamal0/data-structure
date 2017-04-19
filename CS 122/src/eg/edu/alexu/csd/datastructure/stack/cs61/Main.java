package eg.edu.alexu.csd.datastructure.stack.cs61;

public class Main {
	
	
	public static void main(String args[])
	{
		Evaluator x = new Evaluator();
		
		
		
		String f = "";
		
		System.out.println(x.infixToPostfix(null));
		
		String i = "1 2 + 3 -";
		
		System.out.println(x.evaluate(null));
	
	}
	
}
