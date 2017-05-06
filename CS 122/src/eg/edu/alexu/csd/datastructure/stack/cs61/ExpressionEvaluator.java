/**
 * A stack based expression evaluator
 * It takes an infix expression and returns it as a postfix expression
 * It evaluates postfix expressions and gets the value of it
 */

package eg.edu.alexu.csd.datastructure.stack.cs61;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

public class ExpressionEvaluator implements IExpressionEvaluator {

	/**
	 * takes an infix notation and change it to postfix notation
	 * 
	 * @param expression
	 *            the infix notation to be changed
	 * @throws null
	 *             if the expression is null if the expression is not correct
	 */
	public String infixToPostfix(String expression) {

		isCorrect(expression);

		Stack s = new Stack();
		StringBuilder postExpression = new StringBuilder(expression.length());

		for (int i = 0; i < expression.length(); i++) {

			char c = expression.charAt(i);

			if (!isSymbol(c)) {
				postExpression.append(c);

				while (addToString(expression, i + 1)) {
					i++;
					postExpression.append(expression.charAt(i));
				}
				postExpression.append(' ');

			} else if (isOperation(c)) {
				if (!(!s.isEmpty() && !isHigher((char) s.peek(), c) && !isParen((char) s.peek())))
					s.push(c);
				else {
					if ((char) s.peek() == c) {
						postExpression.append(c);
						postExpression.append(' ');
					} else {
						while (!s.isEmpty() && !isHigher((char) s.peek(), c) && !isParen((char) s.peek())) {
							postExpression.append((char) s.pop());
							postExpression.append(' ');
						}
						s.push(c);
					}
				}
			} else if (isParen(c)) {
				if (c == '(') {
					s.push(c);
					continue;
				}
				while ((char) s.peek() != '(') {
					postExpression.append((char) s.pop());
					postExpression.append(' ');
				}
				s.pop();
			}
		}
		while (!s.isEmpty()) {
			postExpression.append((char) s.pop());
			if (!s.isEmpty())
				postExpression.append(' ');
		}
		return postExpression.toString();
	}

	/**
	 * evaluates a postfix notation
	 * 
	 * @param expression
	 *            the notation to be evaluated
	 * @return the value of evaluation
	 * @throws null
	 *             if the expression is not correct if the expression is
	 *             symbolic
	 */
	public int evaluate(String expression) {

		if (expression == null || expression.length() == 0)
			return 0;

		isNumeric(expression);

		float result = 0;

		Stack s = new Stack();

		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);

			if (!isSymbol(c)) {
				String temp = "";
				temp += c;
				while (addToString(expression, i + 1)) {
					i++;
					temp += expression.charAt(i);
				}
				s.push(getValue(temp));
			} else if (isOperation(c)) {
				if (s.isEmpty() || s.size() < 2)
					throw null;
				else {
					result = operation(c, (float) s.pop(), (float) s.pop());
					s.push(result);
				}
			} else if (c == ' ')
				continue;
			else
				throw null;
		}

		return (int) result;
	}

	/**
	 * checks whether the provided character is an arithmetic operation or not
	 * 
	 * @param c
	 *            character in the expression
	 * @return true if it is an operation
	 * @return false if it is not an operation
	 */
	private boolean isOperation(char c) {
		if (c == '+' || c == '-' || c == '/' || c == '*')
			return true;
		return false;
	}

	/**
	 * checks whether the provided character is a parenthesis or not
	 * 
	 * @param c
	 *            character in the expression
	 * @return true if it is a parenthesis
	 * @return false if it is not a parenthesis
	 */
	private boolean isParen(char c) {
		if (c == '(' || c == ')')
			return true;
		return false;
	}

	/**
	 * checks if the inStack has a higher precedence than scanned
	 * 
	 * @param inStack
	 *            the operation in the stack
	 * @param scanned
	 *            the operation compared to the top of the stack
	 * @return true if inStack has higher precedence
	 * @return false if not
	 */
	private boolean isHigher(char inStack, char scanned) {
		if (scanned == '*' || scanned == '/')
			if (inStack == '+' || inStack == '-')
				return true;
		return false;
	}

	/**
	 * performs the arithmetic operation
	 * 
	 * @param op
	 *            the operation
	 * @param a
	 *            the first operand
	 * @param b
	 *            the second operand
	 * @return the result of the arithmetic operation between a and b
	 */
	private float operation(char op, float a, float b) {
		if (op == '+')
			return (a + b);
		else if (op == '-')
			return (b - a);
		else if (op == '*')
			return (a * b);
		else if (op == '/') {
			if (a == 0)
				throw null;
			return (b / a);
		}
		throw null;
	}

	/**
	 * checks whether the provided expression is correct for the infixToPostfix
	 * process
	 * 
	 * @param expression
	 *            the expression to be checked
	 * @throws null
	 *             if the expression is null if it has wrong parenthesis if
	 *             there is unary operators in the expression
	 */
	private void isCorrect(String expression) {
		if (expression == null)
			throw null;
		else if (expression.length() == 0)
			throw null;
		else if (!testRightParen(expression))
			throw null;
		else if (!testOperators(expression))
			throw null;
	}

	/**
	 * checks whether the postfix expression can be evaluated or not
	 * 
	 * @param expression
	 *            the postfix expression to be evaluated
	 * @throws null
	 *             if it is a symbolic expression if it has unary operators if
	 *             it has different symbols than digits and arithmetic
	 *             operations
	 */
	private void isNumeric(String expression) {
		for (int i = 0; i < expression.length() - 1; i++) {
			char c = expression.charAt(i);

			if (isOperation(c))
				continue;
			else if (c == ' ')
				continue;
			else {
				if (!Character.isDigit(c))
					throw null;
			}
		}
	}

	/**
	 * checks whether the character belongs to the category of arithmetic
	 * operations and parenthesis or not
	 * 
	 * @param c
	 *            the character to be checked
	 * @return true if it is either an operation, parenthesis, or a space
	 * @return false if it is a letter or a digit
	 */
	private boolean isSymbol(char c) {
		if (c == ' ' || isOperation(c) || isParen(c))
			return true;
		return false;
	}

	/**
	 * checks if the character in this location belongs to the previous
	 * character to form a single multi-digit number
	 * 
	 * @param expression
	 *            the expression to be checked
	 * @param location
	 *            the location of the character
	 * @return true if it belongs to the previous character
	 * @return false if it does not belong to the previous character
	 */
	private boolean addToString(String expression, int location) {
		if (location == expression.length() || isSymbol(expression.charAt(location)))
			return false;
		// char c = expression.charAt(location);
		// if(isSymbol(c))
		// return false;
		return true;
	}

	/**
	 * gets the integer value for evaluation
	 * 
	 * @param expression
	 *            the expression to get the numerical value of
	 * @return the numerical value of the expression
	 */
	private float getValue(String expression) {
		float value = 0;

		for (int i = expression.length() - 1; i >= 0; i--) {
			value += Character.getNumericValue(expression.charAt(i)) * Math.pow(10, expression.length() - i - 1);
		}

		return value;
	}

	/**
	 * checks whether the number of parenthesis is balanced or not
	 * 
	 * @param expression
	 *            the expression to be checked
	 * @return true if the expression has balanced parenthesis
	 * @return false if the expression does not have balanced parenthesis
	 */
	private boolean testRightParen(String expression) {
		int parenFlag = 0;
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);

			if (c == '(')
				parenFlag++;
			else if (c == ')')
				parenFlag--;
		}

		if (parenFlag == 0)
			return true;
		return false;
	}

	/**
	 * checks if the expression has extra operators, unary operators, or lacks
	 * operators
	 * 
	 * @param expression
	 * @return true if it is correct
	 * @returns false if it has an error between the literals and operations
	 *          numbers
	 */
	private boolean testOperators(String expression) {
		int ops = 0;
		int literals = 0;
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (!isSymbol(c)) {
				String temp = "";
				temp += c;
				while (addToString(expression, i + 1)) {
					i++;
					temp += expression.charAt(i);
				}
				literals++;
			} else if (isOperation(c))
				ops++;
			else if (isParen(c) || c == ' ')
				continue;
			else
				throw null;
		}

		if (ops == literals - 1)
			return true;
		return false;
	}
}
