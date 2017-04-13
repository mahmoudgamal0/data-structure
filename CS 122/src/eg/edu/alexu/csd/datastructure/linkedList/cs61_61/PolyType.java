package eg.edu.alexu.csd.datastructure.linkedList.cs61_61;

public class PolyType {

	private int coeff;
	private int expo;

	public PolyType() {
		this(0, 0);
	}

	public PolyType(int coeff, int expo) {
		this.coeff = coeff;
		this.expo = expo;
	}

	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}

	public void setExpo(int expo) {
		this.expo = expo;
	}

	public int getCoeff() {
		return this.coeff;
	}

	public int getExpo() {
		return this.expo;
	}
}
