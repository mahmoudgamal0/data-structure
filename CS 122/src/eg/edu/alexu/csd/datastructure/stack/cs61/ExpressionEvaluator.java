package eg.edu.alexu.csd.datastructure.stack.cs61;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

public class ExpressionEvaluator implements IExpressionEvaluator{
	
	public String infixToPostfix(String expression) {
			
		isCorrect(expression);
		
		Stack s = new Stack();
		String postExpression = "";
		
		
		for(int i = 0 ; i < expression.length() ; i++)
		{
		
			char c = expression.charAt(i);
			
			if(!isSymbol(c))
			{
				postExpression += c;
				
				while(addToString(expression, i+1))
				{
					i++;
					postExpression += expression.charAt(i);
				}
				postExpression += ' ';
				
			}
			else if(isOperation(c))
			{
				if(s.isEmpty() || isParen((char)s.peek()) || isHigher((char)s.peek(), c))
						s.push(c);
				else
				{
					if((char)s.peek() == c)
					{
						postExpression += c ;
						postExpression += ' ';
					}
					else
					{
						while(!s.isEmpty() && !isHigher((char)s.peek(),c) && !isParen((char)s.peek()))
						{
							postExpression += (char)s.pop();
							postExpression += ' ';
						}
						s.push(c);
					}
				}
			}
			else if(isParen(c))
			{
				if(c == '(')
				{
					s.push(c);
					continue;
				}
				while((char)s.peek() != '(')
				{
					postExpression += (char)s.pop();
					postExpression += ' ';
				}
				s.pop();
			}
		}
		while(!s.isEmpty())
		{
			postExpression += (char)s.pop();
			if(!s.isEmpty())
				postExpression += ' ';
		}
		return postExpression;
	}

	public int evaluate(String expression) {
		
		if(expression == null || expression.length() == 0)
			return 0;
		
		isNumeric(expression);
		
		float result = 0;
		
		Stack s = new Stack();
		
		for(int i = 0 ; i < expression.length() ; i++)
		{
			char c = expression.charAt(i);
			
			if(!isSymbol(c))
			{
				String temp = "";
				temp += c;
				while(addToString(expression, i+1))
				{
					i++;
					temp += expression.charAt(i);
				}
				s.push(getValue(temp));
			}
			else if(isOperation(c))
			{
				if(s.isEmpty() || s.size() < 2)
					throw null;
				else
				{
					result = operation(c, (float)s.pop(), (float)s.pop());
					s.push(result);
				}
			}
			else if( c == ' ')
				continue;
			else
				throw null;
		}
		
		return (int)result;
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

	private float operation(char op , float a, float b)
	{
		if(op == '+')
			return (a + b);
		else if(op == '-')
			return (b - a);
		else if(op == '*')
			return (a * b);
		else if(op == '/')
		{
			if(a == 0)
				throw null;
			return (b / a);
		}
		throw null;
	}

	private void isCorrect(String expression)
	{
		if(expression == null)
			throw null;
		else if(expression.length() == 0)
			throw null;
		else if(!testRightParen(expression))
			throw null;
		else if(!testOperators(expression))
			throw null;	
	}

	private void isNumeric(String expression)
	{
		for (int i = 0 ; i < expression.length()-1 ; i++)
		{
			char c = expression.charAt(i);
			
			if(isOperation(c))
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

	private float getValue(String expression)
	{
		float value = 0;
		
		for (int i = expression.length() - 1 ; i >=0 ; i--)
		{
			value += Character.getNumericValue(expression.charAt(i)) * Math.pow(10, expression.length() - i - 1);
		}
		
		return value;
	}

	private boolean testRightParen(String expression)
	{
		int parenFlag = 0;
		for (int i =0 ; i< expression.length() ; i++)
		{
			char c = expression.charAt(i);
			
			if(c == '(')
				parenFlag++;
			else if(c == ')')
				parenFlag--;
		}
		
		if(parenFlag == 0)
			return true;
		return false;
	}

	private boolean testOperators(String expression)
	{
		int ops = 0;
		int literals = 0;
		for(int i = 0; i<expression.length() ; i++)
		{
			char c = expression.charAt(i);
			if(!isSymbol(c))
			{
				String temp = "";
				temp += c;
				while(addToString(expression, i+1))
				{
					i++;
					temp += expression.charAt(i);
				}
				literals++;
			}
			else if(isOperation(c))
				ops++;
			else if(isParen(c) || c == ' ')
				continue;
			else
				throw null;
		}
		
		if(ops==literals - 1)
			return true;
		return false;
	}
}
