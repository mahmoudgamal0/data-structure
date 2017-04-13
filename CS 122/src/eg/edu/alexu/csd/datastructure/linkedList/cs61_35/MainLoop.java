package eg.edu.alexu.csd.datastructure.linkedList.cs61_35;

import java.util.Scanner;

public class MainLoop {

	static Scanner scanUserChoice = new Scanner(System.in);

	public static void main(String[] args) {
		PolynomialSolver PS = new PolynomialSolver();
		while (true) {
			menu();
			int userChoice = scanChoice();
			if (userChoice == 1) {
				if (PS.getNumberOfSet() == 3) {
					System.out.println("all of the variables are set");
					continue;
				}
				System.out.println("Insert the variable name: A , B or C");
				char polynomial = scanPolynomial();
				if (PS.isSet(PS.getList(Character.toUpperCase(polynomial)))) {
					System.out.println("This variable is already set");
				} else {
					System.out.println(
							"Insert the polynomial terms in the form :(coeff1 , exponent1 ), (coeff2 , exponent2 ), ..");
					String userEntry = scanUserChoice.nextLine();
					userEntry = scanUserChoice.nextLine();
					int[][] terms = setArray(userEntry);
					try {
						PS.setPolynomial(Character.toUpperCase(polynomial), terms);
					} catch (Exception e) {
						System.out.println("Invaild entry please try  again");
					}
				}
				System.out.println("===============================================================");
			} else if (userChoice == 2) {
				if (PS.getNumberOfSet() < 1) {
					System.out.println("not enough number of variables set");
					continue;
				}
				System.out.println("Insert the variable name: A , B , C or R");
				char polynomial = scanPolynomialWithR();
				String printedPoly = PS.print(Character.toUpperCase(polynomial));
				if (printedPoly == null) {
					System.out.println("This variable is not set");
				} else {
					System.out.println(Character.toUpperCase(polynomial) + " Value in "
							+ Character.toUpperCase(polynomial) + ": " + printedPoly);
				}
				System.out.println("===============================================================");
			} else if (userChoice == 3) {
				if (PS.getNumberOfSet() < 2) {
					System.out.println("not enough number of variables set");
					continue;
				}
				char firstOperand = 0;
				while (firstOperand == 0) {
					System.out.println("Insert the first operand: A , B or C");
					firstOperand = scanOperands(PS);
				}
				char secondOperand = 0;
				while (secondOperand == 0) {
					System.out.println("Insert the second operand: A , B or C");
					secondOperand = scanOperands(PS);
				}
				int[][] result = PS.add(Character.toUpperCase(firstOperand), Character.toUpperCase(secondOperand));

				System.out.print("Result set in R: ");
				for (int i = 0; i < result.length; i++) {
					System.out.print("(" + result[i][0] + ", " + result[i][1] + "), ");
				}
				System.out.println();

				System.out.println("===============================================================");
			} else if (userChoice == 4) {
				if (PS.getNumberOfSet() < 2) {
					System.out.println("not enough number of variables set");
					continue;
				}
				char firstOperand = 0;
				while (firstOperand == 0) {
					System.out.println("Insert the first operand: A , B or C");
					firstOperand = scanOperands(PS);
				}
				char secondOperand = 0;
				while (secondOperand == 0) {
					System.out.println("Insert the second operand: A , B or C");
					secondOperand = scanOperands(PS);
				}
				int[][] result = PS.subtract(Character.toUpperCase(firstOperand), Character.toUpperCase(secondOperand));

				System.out.print("Result set in R: ");
				for (int i = 0; i < result.length; i++) {
					System.out.print("(" + result[i][0] + ", " + result[i][1] + "), ");
				}
				System.out.println();
				System.out.println("===============================================================");
			} else if (userChoice == 5) {
				if (PS.getNumberOfSet() < 2) {
					System.out.println("not enough number of variables set");
					continue;
				}
				char firstOperand = 0;
				while (firstOperand == 0) {
					System.out.println("Insert the first operand: A , B or C");
					firstOperand = scanOperands(PS);
				}
				char secondOperand = 0;
				while (secondOperand == 0) {
					System.out.println("Insert the second operand: A , B or C");
					secondOperand = scanOperands(PS);
				}
				int[][] result = PS.multiply(Character.toUpperCase(firstOperand), Character.toUpperCase(secondOperand));

				System.out.print("Result set in R: ");
				for (int i = 0; i < result.length; i++) {
					System.out.print("(" + result[i][0] + ", " + result[i][1] + "), ");
				}
				System.out.println();
				System.out.println("===============================================================");
			} else if (userChoice == 6) {
				if (PS.getNumberOfSet() < 1) {
					System.out.println("not enough number of variables set");
					continue;
				}
				System.out.println("Insert the variable name: A , B , C or R");
				char polynomial = scanPolynomialWithR();

				if (PS.isSet(PS.getList(polynomial))) {
					float value = scanUserChoice.nextFloat();
					float result = PS.evaluatePolynomial(polynomial, value);
					System.out.println("the value is " + result);
				} else {
					System.out.println("this polynomial is not set");
				}
				System.out.println("===============================================================");
			} else if (userChoice == 7) {
				if (PS.getNumberOfSet() < 1) {
					System.out.println("not enough number of variables set");
					continue;
				}
				System.out.println("Insert the variable name: A , B , C or R");
				char polynomial = scanPolynomialWithR();
				PS.clearPolynomial(polynomial);
				System.out.println("===============================================================");
			}

		}
	}

	private static void menu() {
		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1- Set a polynomial variable");
		System.out.println("2- Print the value of a polynomial variable");
		System.out.println("3- Add two polynomials");
		System.out.println("4- Subtract two polynomials");
		System.out.println("5- Multiply two polynomials");
		System.out.println("6- Evaluate a polynomial at some point");
		System.out.println("7- Clear a polynomial");
		System.out.println("===============================================================");
	}

	private static int scanChoice() {
		int userChoice = 0;
		String tmpChoice;
		boolean scanned = false;
		while (!scanned) {
			try {
				tmpChoice = scanUserChoice.next();
				if (!(tmpChoice.length() > 1) && (tmpChoice.charAt(0) >= '1' && tmpChoice.charAt(0) <= '7')) {
					userChoice = tmpChoice.charAt(0) - '0';
					scanned = true;
				} else {
					System.out.println("Please Enter a vaild input");
				}
			} catch (Exception e) {
				System.out.println("Please Enter a vaild input");
			}
		}
		return userChoice;
	}

	private static char scanPolynomial() {
		String tmpPolynomial;
		char finalPolynomial = 0;
		boolean scanned = false;
		while (!scanned) {
			try {
				tmpPolynomial = scanUserChoice.next();
				if (!(tmpPolynomial.length() > 1) && ((tmpPolynomial.equalsIgnoreCase("A"))
						|| (tmpPolynomial.equalsIgnoreCase("C")) || (tmpPolynomial.equalsIgnoreCase("B")))) {
					scanned = true;
					finalPolynomial = tmpPolynomial.charAt(0);
				} else {
					System.out.println("Please Enter a vaild input");
				}
			} catch (Exception e) {
				System.out.println("Please Enter a vaild input");
			}
		}
		return Character.toUpperCase(finalPolynomial);
	}

	private static char scanPolynomialWithR() {
		String tmpPolynomial;
		char finalPolynomial = 0;
		boolean scanned = false;
		while (!scanned) {
			try {
				tmpPolynomial = scanUserChoice.next();
				if (!(tmpPolynomial.length() > 1)
						&& ((tmpPolynomial.equalsIgnoreCase("A")) || (tmpPolynomial.equalsIgnoreCase("C"))
								|| (tmpPolynomial.equalsIgnoreCase("B")) || (tmpPolynomial.equalsIgnoreCase("R")))) {
					scanned = true;
					finalPolynomial = tmpPolynomial.charAt(0);
				} else {
					System.out.println("Please Enter a vaild input");
				}
			} catch (Exception e) {
				System.out.println("Please Enter a vaild input");
			}
		}
		return Character.toUpperCase(finalPolynomial);
	}

	private static char scanOperands(PolynomialSolver PS) {
		char operand = 0;
		boolean entered = false;
		while (!entered) {
			operand = scanPolynomial();
			if (PS.isSet(PS.getList(Character.toUpperCase(operand)))) {
				entered = true;
			} else {
				System.out.println("Variable not set");
				return 0;
			}
		}
		return Character.toUpperCase(operand);
	}

	private static int[][] setArray(String userEntry) {
		int numberOfTerms = 0;
		for (int j = 0; j < userEntry.length(); j++) {
			if (userEntry.charAt(j) == '(') {
				numberOfTerms++;
			}
		}
		int[][] terms = new int[numberOfTerms][2];
		int counter = 0;
		for (int i = 0; i < userEntry.length(); i++) {
			if (userEntry.charAt(i) == '(') {
				String tmp = "";
				i++;
				while (Character.isDigit(userEntry.charAt(i)) || userEntry.charAt(i) == '-') {
					tmp += userEntry.charAt(i);
					i++;
				}
				terms[counter][0] = Integer.parseInt(tmp);
				i += 2;
				tmp = "";
				while (Character.isDigit(userEntry.charAt(i)) || userEntry.charAt(i) == '-') {
					tmp += userEntry.charAt(i);
					i++;
				}
				terms[counter++][1] = Integer.parseInt(tmp);
			}
		}
		return terms;
	}

}
