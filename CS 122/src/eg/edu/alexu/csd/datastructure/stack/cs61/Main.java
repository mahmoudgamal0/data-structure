/**
 * The User Interface controller for menu-driven program
 */
package eg.edu.alexu.csd.datastructure.stack.cs61;

import java.util.Scanner;

public class Main {

	/**
	 * The name of the scanner
	 */
	public static Scanner scanOrder = new Scanner(System.in);

	/**
	 * The stack of the program
	 */
	public static Stack stack = new Stack();

	/**
	 * The main loop of the program
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		while (true) {
			draw();

			int userChoice = scanOrder.nextInt();

			if (userChoice == 1) {
				Object element = scanOrder.next();
				push(element);
				stack.print();
			} else if (userChoice == 2) {
				try {
					System.out.println(pop());
					stack.print();
				} catch (Exception e) {
					System.out.println("Invalid Input !!");
					System.out.println("Try again !!");
				}
			} else if (userChoice == 3) {
				try {
					System.out.println(peek());
				} catch (Exception e) {
					System.out.println("Invalid Input !!");
					System.out.println("Try again !!");
				}
			} else if (userChoice == 4) {
				System.out.println("The size is :" + getSize());
			} else if (userChoice == 5) {
				if (checkEmpty())
					System.out.println("The stack is empty");
				else
					System.out.println("The stack is not empty");
			} else if (userChoice == 6) {
				stack.clear();
			}

		}

	}

	/**
	 * Pushing a new element to the stack
	 * 
	 * @param element
	 *            which is the element to push to the stack
	 */
	public static void push(Object element) {
		stack.push(element);
	}

	/**
	 * Gets the most top element in the stack and delete it
	 * 
	 * @return the top of the stack
	 * @throws NullPointerException
	 *             if the user access an empty stack
	 */
	public static Object pop() throws NullPointerException {
		return stack.pop();
	}

	/**
	 * Gets the most top element in the stack without deleting it
	 * 
	 * @return the top of the stack
	 * @throws NullPointerException
	 *             if the user access an empty stack
	 */
	public static Object peek() throws NullPointerException {
		return stack.peek();
	}

	/**
	 * The size of the stack
	 * 
	 * @return the stack's size
	 */
	public static int getSize() {
		return stack.size();
	}

	/**
	 * Checks whether the stack is empty or not
	 * 
	 * @return true when the stack is empty
	 * @return false when the stack is not empty
	 */
	public static boolean checkEmpty() {
		return stack.isEmpty();
	}

	/**
	 * draws the UI for the user
	 */
	public static void draw() {
		System.out.println("========================================");
		System.out.println("Make your choice: ");
		System.out.println("1- push an element");
		System.out.println("2- pop an element");
		System.out.println("3- peek the stack");
		System.out.println("4- get the size");
		System.out.println("5- check if empty");
		System.out.println("6- clear the stack");
		System.out.println("========================================");
	}

}
