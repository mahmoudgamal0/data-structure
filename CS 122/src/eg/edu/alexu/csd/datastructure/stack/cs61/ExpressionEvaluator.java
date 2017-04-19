package eg.edu.alexu.csd.datastructure.stack.cs61;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

public class ExpressionEvaluator implements IExpressionEvaluator{
	
	private int flag;
	
	public ExpressionEvaluator()
	{
		this.flag = 0;
	}
	
	public String infixToPostfix(String expression) {
		
		
		isCorrect(expression);
		
		if(this.flag == 1)
			return null;
		
		Stack s = new Stack();
		String postExpression = "";
		
		int parenFlag = 0;
		
		
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
						if((char)s.peek() == c)
						{
							postExpression += c;
							postExpression += ' ';
						}
						else
						{
							while(!s.isEmpty() && !isHigher((char)s.peek(), c) && !isParen((char)s.peek()))
							{
								postExpression += s.pop();
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
						parenFlag--;
					}
				}
			}
			
		}
		
		while(!s.isEmpty())
		{
			postExpression += s.pop();
			if(!s.isEmpty())
				postExpression += ' ';
		}
			
		
		return postExpression;
	}

	public int evaluate(String expression) {
		
		if(expression == null || expression.length() == 0)
			return 0;
		
		isNumeric(expression);
		
		int result = 0;
		
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
					result = operation(c, (int)s.pop(), (int)s.pop());
					s.push(result);
				}
			}
			else if( c == ' ')
				continue;
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
		
//		if(expression == null)
//			this.flag = 1;
//		else if(expression.length() == 0)
//			throw null;
//		
//		int ops = 0;
//		int opCount = 0;
//		int literalsCount = 0;
//		int parenFlag = 0;
//		for (int i = 0 ; i < expression.length()-1 ; i++)
//		{
//			char current = expression.charAt(i);
//			char next = expression.charAt(i+1);
//			
//			if(isOperation(current))
//			{
//				opCount++;
//				if(i == 0)
//					throw null;
//				else if(isOperation(next))
//					throw null;
//			}
//			else if(isOperation(next) && i+1 == expression.length()-1)
//				throw null;
//			else if(current == '(')
//			{
//				parenFlag++;
//				ops = 0;
//				if(isOperation(next))
//					throw null;
//			}
//			else if(next == ')')
//			{
//				parenFlag--;
//				if(isOperation(current))
//					throw null;
//				else if(ops == 0)
//					throw null;
//			}
//			else if(current == '!')
//				throw null;
//			else if(current == ' ')
//				continue;
//			else if(isBraces(current))
//				throw null;
//			else
//				literalsCount++;
//			
//			if(parenFlag != 0 && isOperation(current))
//			{
//				ops++;
//			}
//		}
//		
//		if (expression.charAt(expression.length()-1) == '!' || isBraces(expression.charAt(expression.length()-1))|| isParen(expression.charAt(expression.length()-1)) || isOperation(expression.charAt(expression.length()-1)))
//			throw null;
//		else if(!isSymbol(expression.charAt(expression.length()-1)))
//			literalsCount++;
//		
//		if (opCount == 0)
//			throw null;
//		else if(literalsCount == 0)
//			throw null;
//		else if(opCount != literalsCount-1)
//		{
//			if(opCount >= literalsCount)
//				throw null;
//			else
//				this.flag = 1;
//		}
//		else if(parenFlag != 0)
//			throw null;
		
		
		if(expression == null)
		{
			this.flag = 1;
			return;
		}
		else if(expression.length() == 0)
			throw null;
		else if(!testRightParen(expression))
			throw null;
		else if(!testOperators(expression))
			throw null;
		else
		{
		
		}
		
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

	private int getValue(String expression)
	{
		int value = 0;
		
		for (int i = expression.length() - 1 ; i >=0 ; i--)
		{
			value += Character.getNumericValue(expression.charAt(i)) * Math.pow(10, expression.length() - i - 1);
		}
		
		return value;
	}

	private boolean isBraces(char c)		
	{
		if(c == '[' || c == ']' || c == '{' || c == '}')
			return true;
		return false;
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
		
		if(ops==literals-1)
			return true;
		return false;
	}
}
