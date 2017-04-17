package eg.edu.alexu.csd.datastructure.stack.cs61;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

public class ExpressionEvaluator implements IExpressionEvaluator {

	
	public String infixToPostfix(String expression) {
		
		Stack s = new Stack();
		String newExpression = "";
		int pFlag = 0;
		if(isSymbol(expression.charAt(0)))
			throw null;
		for(int i = 0 ; i< expression.length() ; i++)
		{
			char c = expression.charAt(i);
			if(c == ' ')
				continue;
			if(isSymbol(c))
			{
				if(s.isEmpty())
					s.push(c);
				else if((char)s.peek() == '(')
					s.push(c);
				else if(hasHigher((char)s.peek(), c))
					s.push(c);
				else if(!hasHigher((char)s.peek() , c))
				{
					while(!s.isEmpty() && !hasHigher((char)s.peek() , c) && (char)s.peek()!='(')
					{
						newExpression += s.pop();
					}
					s.push(c);
				}
				
			}
			else if(c == '(' || c == ')')
			{
				if(c == '(')
				{
					pFlag++;
					s.push(c);
				}
				else if(c == ')')
				{
					if(pFlag == 0)
						throw null;
					else
					{
						while((char)s.peek() != '(')
							newExpression += s.pop();
						s.pop();
						pFlag--;
					}
				}
			}
			else
				newExpression += c;
		}
		
		while(!s.isEmpty())
			newExpression += s.pop();
		
		return newExpression;
	}

	
	public int evaluate(String expression) {
		
		int result = 0;
		Stack s = new Stack();
		for(int i = 0 ; i < expression.length() ; i++)
		{
			char c = expression.charAt(i);
			if(c == ' ')
				continue;
			if(!isSymbol(c))
				s.push(Character.getNumericValue(c));
			else if(isSymbol(c))
			{
				if(s.isEmpty() || s.size() < 2)
					throw null;
				else
				{
					result = operation(c, (int)s.pop(), (int)s.pop());
					s.push(result);
				}
			}
			else
				throw null;
		}
		return result;
	}

	private boolean isSymbol(char c)
	{
		if(c == '+' || c == '-' || c== '/' || c == '*' )
			return true;
		return false;
	}
	
	private boolean hasHigher(char inStack, char scanned)
	{
		if (scanned == '*' || scanned == '/')
			if(inStack == '+' || inStack == '-')
				return true;
		return false;
	}

	private int operation(char op , int a, int b)
	{
		if(op == '+')
			return a + b;
		else if(op == '-')
			return b - a;
		else if(op == '*')
			return a * b;
		else if(op == '/')
		{
			if(a == 0)
				throw null;
			return b / a;
		}
		throw null;
	}
}
