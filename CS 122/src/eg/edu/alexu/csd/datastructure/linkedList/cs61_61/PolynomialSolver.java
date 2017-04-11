package eg.edu.alexu.csd.datastructure.linkedList.cs61_61;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;
import java.lang.Math;

public class PolynomialSolver implements IPolynomialSolver {

	private SLinkedList A = new SLinkedList();
	private SLinkedList B = new SLinkedList();
	private SLinkedList C = new SLinkedList();
	private SLinkedList R = new SLinkedList();
	
	public void setPolynomial(char poly, int[][] terms) 
	{
		for(int i = 0 ; i < terms.length ; i++)
		{
			PolyType entry = new PolyType(terms[i][0] ,terms[i][1]);
			if(poly == 'A')
				this.A.add(entry);
			else if(poly == 'B')
				this.B.add(entry);
			else if(poly == 'C')
				this.C.add(entry);
			else
				break;
		}
	}

	public String print(char poly) 
	{
		if(poly == 'A')
			return toString(this.A);
		
		else if(poly == 'B')
			return toString(this.B);
		
		else if(poly == 'C')
			return toString(this.C);
		else
			return "";
	}
	
	public void clearPolynomial(char poly)
	{
		if(poly == 'A')
			this.A = new SLinkedList();
		
		else if(poly == 'B')
			this.B = new SLinkedList();
		
		else if(poly == 'C')
			this.C = new SLinkedList();
	}

	public float evaluatePolynomial(char poly, float value) 
	{
		SLinkedList temp = getList(poly);
		if(temp == null)
			return 0;
		float result = 0;
		for(int i = 0; i < temp.size() ; i++)
		{
			result += ((PolyType)temp.get(i)).getCoeff() * Math.pow(value,((PolyType)temp.get(i)).getExpo());
		}
		return result;
	}

	public int[][] add(char poly1, char poly2) 
	{
		SLinkedList listA = getList(poly1);
		SLinkedList listB = getList(poly2);
		
		if(listA == null || listB == null)
			return null;
		this.R = new SLinkedList();
		
		int i = 0, j = 0;
		
		while(listA.get(i) != null && listB.get(j) != null)
		{	
			PolyType entry = new PolyType();
			if(((PolyType)listA.get(i)).getExpo()  == ((PolyType)listB.get(j)).getExpo())
			{
				entry.setCoeff(((PolyType)listA.get(i)).getCoeff() + ((PolyType)listB.get(j)).getCoeff());
				entry.setExpo(((PolyType)listA.get(i)).getExpo());
				this.R.add(entry);
				i++;
				j++;
			}
			else if(((PolyType)listA.get(i)).getExpo()  > ((PolyType)listB.get(j)).getExpo())
			{
				entry.setCoeff(((PolyType)listA.get(i)).getCoeff());
				entry.setExpo(((PolyType)listA.get(i)).getExpo());
				this.R.add(entry);
				i++;
			}
			else
			{
				entry.setCoeff(((PolyType)listB.get(j)).getCoeff());
				entry.setExpo(((PolyType)listB.get(j)).getExpo());
				this.R.add(entry);
				j++;

			}
		}
		
		if(listA.get(i) != null)
		{
			for(int k = i ; k<listA.size(); k++)
			{
				PolyType entry = new PolyType(((PolyType)listA.get(k)).getCoeff(),((PolyType)listA.get(k)).getExpo());
				this.R.add(entry);
			}
		}
		else
		{
			for(int k = j ; k<listB.size(); k++)
			{
				PolyType entry = new PolyType(((PolyType)listB.get(k)).getCoeff(),((PolyType)listB.get(k)).getExpo());
				this.R.add(entry);
			}
		}
		
		return toArray(this.R);
	}
	
	public int[][] subtract(char poly1, char poly2) 
	{
		
		SLinkedList listA = getList(poly1);
		SLinkedList listB = getList(poly2);
		
		if(listA == null || listB == null)
			return null;
		this.R = new SLinkedList();
		
		int i = 0, j = 0;
		
		while(listA.get(i) != null && listB.get(j) != null)
		{	
			PolyType entry = new PolyType();
			if(((PolyType)listA.get(i)).getExpo()  == ((PolyType)listB.get(j)).getExpo())
			{
				entry.setCoeff(((PolyType)listA.get(i)).getCoeff() - ((PolyType)listB.get(j)).getCoeff());
				entry.setExpo(((PolyType)listA.get(i)).getExpo());
				this.R.add(entry);
				i++;
				j++;
			}
			else if(((PolyType)listA.get(i)).getExpo()  > ((PolyType)listB.get(j)).getExpo())
			{
				entry.setCoeff(((PolyType)listA.get(i)).getCoeff());
				entry.setExpo(((PolyType)listA.get(i)).getExpo());
				this.R.add(entry);
				i++;
			}
			else
			{
				entry.setCoeff(-1*((PolyType)listB.get(j)).getCoeff());
				entry.setExpo(((PolyType)listB.get(j)).getExpo());
				this.R.add(entry);
				j++;

			}
		}
		
		if(listA.get(i) != null)
		{
			for(int k = i ; k<listA.size(); k++)
			{
				PolyType entry = new PolyType(((PolyType)listA.get(k)).getCoeff(),((PolyType)listA.get(k)).getExpo());
				this.R.add(entry);
			}
		}
		else
		{
			for(int k = j ; k<listB.size(); k++)
			{
				PolyType entry = new PolyType(-1*((PolyType)listB.get(k)).getCoeff(),((PolyType)listB.get(k)).getExpo());
				this.R.add(entry);
			}
		}
		
		return toArray(this.R);
	}
	
	public int[][] multiply(char poly1, char poly2) 
	{
		
		return null;
	}

	private String toString(SLinkedList poly)
	{
		if(poly == null)
			return null;
		String polynomial = new String();
		for(int i = 0; i < poly.size(); i++)
		{	
			if(((PolyType)poly.get(i)).getCoeff() > 0 && i!=0)
				polynomial += "+";
			polynomial += ((PolyType)poly.get(i)).getCoeff();
			polynomial += "x^";
			polynomial += ((PolyType)poly.get(i)).getExpo();
		}
		return polynomial;
	}
	
	public int[][] toArray(SLinkedList poly)
	{
		int[][] result = new int[poly.size()][2];
		for(int i = 0; i < result.length ; i++)
		{
			PolyType entry = (PolyType)poly.get(i);
			result[i][0] =	entry.getCoeff();
			result[i][1] = entry.getExpo();
		}
		return result;
	}
	
	private SLinkedList getList(char poly)
	{
		if(poly == 'A')
			return this.A;
		
		else if(poly == 'B')
			return this.B;
		
		else if(poly == 'C')
			return this.C;
		else
			return null;
	}

	private boolean isSet(SLinkedList poly)
	{
		if(poly == this.A)
		{
			if(this.A.isEmpty())
				return false;
			return true;
		}
		else if(poly == this.B)
		{
			if(this.B.isEmpty())
				return false;
			return true;
		}
		else if(poly == this.C)
		{
			if(this.C.isEmpty())
				return false;
			return true;
		}
		return false;
	}
}
