package eg.edu.alexu.csd.datastructure.calculator.cs61;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

public class Operations implements ICalculator {

	public int add(int x, int y) {
		return x + y;
	}

	public float divide(int x, int y) {
		return (float) x / (float) y;
	}

}
