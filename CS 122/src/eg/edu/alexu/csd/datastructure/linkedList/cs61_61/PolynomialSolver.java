package eg.edu.alexu.csd.datastructure.linkedList.cs61_61;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;
import java.lang.Math;
import java.util.Arrays;
import java.lang.RuntimeException;
public class PolynomialSolver implements IPolynomialSolver {

	public SLinkedList A = new SLinkedList();
	public SLinkedList B = new SLinkedList();
	public SLinkedList C = new SLinkedList();
	public SLinkedList R = new SLinkedList();
	private int numberOfSet = 0;
	
	public void setPolynomial(char poly, int[][] terms) 
	{
		if(!this.sorted(terms))
			throw new RuntimeException();
		if(!(poly == 'A' || poly == 'B' || poly == 'C'))
			throw new RuntimeException();
//		if(poly == 'A' && this.isSet(this.A))
//			throw new RuntimeException();
//		else if(poly == 'B' && this.isSet(this.B))
//			throw new RuntimeException();
//		else if(poly == 'C' && this.isSet(this.C))
//			throw new RuntimeException();
//		
	
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
		this.numberOfSet++;
	}

	public String print(char poly) 
	{
		
		String temp;
		
		if(poly == 'A')
			temp = toString(this.A);
		
		else if(poly == 'B')
			temp = toString(this.B);
		
		else if(poly == 'C')
			temp = toString(this.C);
		
		else if(poly == 'R')
			temp = toString(this.R);
		
		else
			throw new RuntimeException();
		
		return temp;
	}
	
	public void clearPolynomial(char poly)
	{
		if(poly == 'A')
		{
			this.A = new SLinkedList();
			this.numberOfSet--;
		}
		else if(poly == 'B' )
		{
			this.B = new SLinkedList();
			this.numberOfSet--;
		}
		else if(poly == 'C' )
		{
			this.C = new SLinkedList();
			this.numberOfSet--;
		}
		
			
	}

	public float evaluatePolynomial(char poly, float value) 
	{
		SLinkedList temp = getList(poly);
		if(!(isSet(temp)))
			throw new RuntimeException();
		
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
		
		if(!(isSet(listA) || isSet(listB)))
			throw new RuntimeException();
		this.R = new SLinkedList();
		
		int i = 0, j = 0;
		
		while( i < listA.size() && j < listB.size())
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
		
		if(i < listA.size())
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
		
		if(!(isSet(listA) || isSet(listB)))
			throw new RuntimeException();
		
		if(listA.equals(listB))
		{
			int[][] terms = new int[0][0];
			return terms;
		}
		
		
		this.R = new SLinkedList();
		int i = 0, j = 0;
		while(i < listA.size() && j < listB.size())
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
		
		if(i < listA.size())
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
		SLinkedList listA = getList(poly1);
		SLinkedList listB = getList(poly2);
		
		if(!(isSet(listA) || isSet(listB)))
			throw new RuntimeException();
		
		this.R = new SLinkedList();
		
		for(int i = 0 ; i < listA.size() ; i++)
		{
			SLinkedList temp = new SLinkedList();
			for(int j = 0; j < listB.size()  ; j++)
			{
				PolyType product = new PolyType();
				product.setCoeff( ((PolyType)listA.get(i)).getCoeff() * ((PolyType)listB.get(j)).getCoeff() );
				product.setExpo( ((PolyType)listA.get(i)).getExpo() + ((PolyType)listB.get(j)).getExpo() );
				temp.add(product);
			}
			int[][] result = this.add(this.R, temp);
			this.R = toList(result);
		}
		
		return this.toArray(this.R);
	}

	private String toString(SLinkedList poly)
	{
		
		if(poly.isEmpty())
			return null;
		
		String polynomial = new String();
		for(int i = 0; i < poly.size(); i++)
		{	
			if(((PolyType)poly.get(i)).getCoeff() > 0 && i!=0)
				polynomial += " + ";
			if(((PolyType)poly.get(i)).getCoeff() == 1 && ((PolyType)poly.get(i)).getExpo() == 0)
			{
				polynomial += " 1";
			}
			else if(((PolyType)poly.get(i)).getCoeff() == 1 )
			{
				
			}
			else if(((PolyType)poly.get(i)).getCoeff() == -1 && i+1 != poly.size())
			{
				polynomial += " - ";
			}
			else
				polynomial += ((PolyType)poly.get(i)).getCoeff();
			if(((PolyType)poly.get(i)).getExpo() == 1)
				polynomial += "x";
			else if(((PolyType)poly.get(i)).getExpo() == 0)
			{
				
			}
			else
				polynomial += "x^" + ((PolyType)poly.get(i)).getExpo();
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
	
	public SLinkedList getList(char poly)
	{
		if(poly == 'A')
			return this.A;
		
		else if(poly == 'B')
			return this.B;
		
		else if(poly == 'C')
			return this.C;
		else if(poly == 'R')
			return this.R;
		else
			throw new RuntimeException();
	}

	public boolean isSet(SLinkedList poly)
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
		else if(poly == this.R)
		{
			if(this.R.isEmpty())
				return false;
			return true;
		}
		return false;
	}

	private SLinkedList toList(int[][] terms)
	{
		SLinkedList temp = new SLinkedList();
		for(int i = 0 ; i < terms.length ; i++)
		{
			PolyType entry = new PolyType(terms[i][0], terms[i][1]);
			temp.add(entry);
		}
		return temp;
	}

	public int[][] add(SLinkedList poly1, SLinkedList poly2) 
	{
		SLinkedList listA = poly1;
		SLinkedList listB = poly2;
		
		SLinkedList temp = new SLinkedList();
		
		int i = 0, j = 0;
		
		while(i < listA.size() && j < listB.size())
		{	
			PolyType entry = new PolyType();
			if(((PolyType)listA.get(i)).getExpo()  == ((PolyType)listB.get(j)).getExpo())
			{
				entry.setCoeff(((PolyType)listA.get(i)).getCoeff() + ((PolyType)listB.get(j)).getCoeff());
				entry.setExpo(((PolyType)listA.get(i)).getExpo());
				temp.add(entry);
				i++;
				j++;
			}
			else if(((PolyType)listA.get(i)).getExpo()  > ((PolyType)listB.get(j)).getExpo())
			{
				entry.setCoeff(((PolyType)listA.get(i)).getCoeff());
				entry.setExpo(((PolyType)listA.get(i)).getExpo());
				temp.add(entry);
				i++;
			}
			else
			{
				entry.setCoeff(((PolyType)listB.get(j)).getCoeff());
				entry.setExpo(((PolyType)listB.get(j)).getExpo());
				temp.add(entry);
				j++;

			}
		}
		
		if(i < listA.size())
		{
			for(int k = i ; k<listA.size(); k++)
			{
				PolyType entry = new PolyType(((PolyType)listA.get(k)).getCoeff(),((PolyType)listA.get(k)).getExpo());
				temp.add(entry);
			}
		}
		else
		{
			for(int k = j ; k<listB.size(); k++)
			{
				PolyType entry = new PolyType(((PolyType)listB.get(k)).getCoeff(),((PolyType)listB.get(k)).getExpo());
				temp.add(entry);
			}
		}
		
		return toArray(temp);
	}

	public boolean sorted(int[][] terms)
	{
		for(int i = 0 ; i < terms.length; i++)
		{
			if(i+1 != terms.length && terms[i][1] <= terms[i+1][1])
			{
				return false;
			}
			if(terms[i][1] < 0)
			{
				return false;
			}
		}
		
		return true;
	}

}
