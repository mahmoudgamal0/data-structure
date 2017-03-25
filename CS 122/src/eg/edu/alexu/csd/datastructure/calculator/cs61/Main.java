package eg.edu.alexu.csd.datastructure.calculator.cs61;

import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

public class Main {
	
	public static void main(String args[])
	{
		Scanner scn = new Scanner(System.in);
		ICalculator calc = new Operations();
		
		System.out.println("Please select an operation: A - D");
		String c = scn.next();
		if(c.charAt(0) == 'A')
		{
			System.out.println("Please enter the two numbers");
			System.out.println(calc.add(scn.nextInt(), scn.nextInt()));
		}
		else if(c.charAt(0) == 'D')
		{
			System.out.println("Please enter the two numbers");
			System.out.println(calc.divide(scn.nextInt(), scn.nextInt()));
		}
		else
			System.out.println("Wrong operation");
		scn.close();
	}
}
