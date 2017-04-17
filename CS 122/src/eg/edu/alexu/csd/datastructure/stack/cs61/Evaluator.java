package eg.edu.alexu.csd.datastructure.stack.cs61;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

public class Evaluator implements IExpressionEvaluator{
	
	public String infixToPostfix(String expression) {
		
		isCorrect(expression);
		
		Stack s = new Stack();
		String postExpression = "";
		
		int parenFlag = 0;
		
		
		for(int i = 0 ; i < expression.length() ; i++)
		{
			// digits are strings
			// ops and symbols are chars
			
			char c = expression.charAt(i);
			
			if(!isSymbol(c))
			{
				String temp = "";
				while(addToString(expression, i))
				{
					temp += expression.charAt(i);
					i++;
				}
				
				postExpression += temp + " ";
			}
			else
			{
				if(isOperation(c))
				{
					if(s.isEmpty() || isParen((char)s.peek()))
						s.push(c);
					else if(isHigher((char)s.peek(), c))
						s.push(c);
					else if(!isHigher((char)s.peek() , c))
					{
						while(!s.isEmpty() && !isHigher((char)s.peek(), c) && !isParen((char)s.peek()))
						{
							postExpression += s.pop();
							postExpression += ' ';
						}
						s.push(c);
					}
				}
				else if(isParen(c))
				{
					if(c == '(')
					{
						parenFlag++;
						s.push(c);
					}
					else if(c == ')')
					{
						if(parenFlag == 0)
							throw null;
						while((char)s.peek() != '(')
						{
							postExpression += s.pop();
							postExpression += ' ';
						}
						s.pop();
						postExpression += ' ';
						parenFlag--;
					}
				}
			}
			
		}
		
		while(!s.isEmpty())
			postExpression += s.pop();
		
		return postExpression;
	}

	public int evaluate(String expression) {
		
		if(expression.length() == 0)
			throw null;
		isNumeric(expression);
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

	private boolean isOperation(char c)
	{
		if(c == '+' || c == '-' || c== '/' || c == '*' )
			return true;
		return false;
	}
	
	private boolean isParen(char c)
	{
		if(c == '(' || c == ')')
			return true;
		return false;
	}
	
	private boolean isHigher(char inStack, char scanned)
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

	private void isCorrect(String expression)
	{
		if(expression.length() == 0)
			throw null;
		for (int i = 0 ; i < expression.length()-1 ; i++)
		{
			char current = expression.charAt(i);
			char next = expression.charAt(i+1);
			
			if(isOperation(current))
			{
				if(i == 0)
					throw null;
				else if(isOperation(next))
					throw null;
			}
			if(isOperation(next) && i+1 == expression.length()-1)
				throw null;
			else if(current == '(')
			{
				if(isOperation(next))
					throw null;
			}
			else if(next == ')')
			{
				if(isOperation(current))
					throw null;
			}
		}
		
	}

	private void isNumeric(String expression)
	{
		for (int i = 0 ; i < expression.length() ; i++)
		{
			char c = expression.charAt(i);
			if(isSymbol(c))
				continue;
			else if(c == ' ')
				continue;
			else
			{
				if(!Character.isDigit(c))
					throw null;
			}
		}
	}

	private boolean isSymbol(char c)
	{
		if(c == ' ' || isOperation(c) || isParen(c))
			return true;
		return false;
	}
	
	private boolean addToString(String expression, int location)
	{
		if(location == expression.length())
			return false;
		char c = expression.charAt(location);
		if(isSymbol(c))
			return false;
		return true;
	}
}
