package eg.edu.alexu.csd.datastructure.maze.cs61;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;

public class MazeSolver implements IMazeSolver{

	
	private BufferedReader br;
	private char[][] map;
	private int[][] visitedMap;
	private int[] start;
	private int[] end;
	
	@Override
	public int[][] solveBFS(File maze) {
		
		try
		{
			readFile(maze);
		}
		catch(Exception e)
		{
			System.out.println("wrong file");
			throw null;
		}
		return startBFS();
		
	}

	@Override
	public int[][] solveDFS(File maze) {
		
		try
		{
			readFile(maze);
		}
		catch(Exception e)
		{
			System.out.println("wrong file");
		}
		
		
		
		return null;
	}

	private void readFile(File maze) throws IOException
	{
		br = new BufferedReader(new FileReader(maze));
		String tempSize = br.readLine();
		this.map = new char[Character.getNumericValue(tempSize.charAt(0))+2][Character.getNumericValue(tempSize.charAt(2))+2];
		this.visitedMap = new int[Character.getNumericValue(tempSize.charAt(0))+2][Character.getNumericValue(tempSize.charAt(2))+2];
		this.start = new int[2];
		this.end = new int[2];
		
		for(int i = 0 ; i <this.map.length ; i++)
		{
			for(int j = 0 ; j <this.map[0].length; j++)
			{
				this.map[i][j] = '0';
				this.visitedMap[i][j] = 0;
				if(i == 0 || i == this.map.length-1 || j == 0 || j == this.map[0].length-1) 
					this.visitedMap[i][j] = 1;
			}
		}
		
		String tempRow = "";
		int i = 1;
		while((tempRow = br.readLine())!=null)
		{
			int j = 1;
			while(j<this.map[i].length-1)
			{	
				if(tempRow.charAt(j-1) == 'S')
				{
					this.start[0] = i;
					this.start[1] = j;
				}
				else if(tempRow.charAt(j-1) == 'E')
				{
					this.end[0] = i;
					this.end[1] = j;
				}
				
				this.map[i][j] = tempRow.charAt(j-1);
				j++;
			}
			i++;
		}	
		
		int[] temp = {0,0};
		if(Arrays.equals(this.start, temp))
			throw null;
		if(Arrays.equals(this.end, temp))
			throw null;
	}
	
	private int[][] startBFS ()
	{
		Queue<int[]> Q = new Queue<>();
		Stack<int[]> S = new Stack<>();
		Q.enqueue(this.start);
		while(Q.size() > 0)
		{	
			int[] coordTemp = Q.dequeue();
			this.visitedMap[coordTemp[0]][coordTemp[1]] = 1;
			
			if (Arrays.equals(coordTemp, this.end))
			{
				S.push(coordTemp);
				break;
			}
			else
			{
				int op = checkCoord(coordTemp,Q);
				if(Q.size() == 0 && op == 0)
					return null;
				if(S.size() == 0)
					S.push(coordTemp);
				else if(((Math.abs(S.top()[0]-coordTemp[0]) == 1 && Math.abs(S.top()[1]-coordTemp[1]) == 0) || (Math.abs(S.top()[0]-coordTemp[0]) == 0 && Math.abs(S.top()[1]-coordTemp[1]) == 1)) && op > 0  )
				{
					S.push(coordTemp);
				}
					
			}
			
		}
		
		return toArray(S);
		
	}

	private int checkCoord(int[] coord, Queue<int[]> Q)
	{
		int op = 0;
		if(this.map[coord[0] + 0][coord[1] + -1] != '#' && this.visitedMap[coord[0] + 0][coord[1] + -1] == 0)
		{
			int[] temp = {coord[0] + 0, coord[1] + -1};
			Q.enqueue(temp);
			op++;
		}
		
		if(this.map[coord[0] + 0][coord[1] + 1] != '#' && this.visitedMap[coord[0] + 0][coord[1] + 1] == 0)
		{
			int[] temp = {coord[0] + 0, coord[1] + 1};
			Q.enqueue(temp);
			op++;
		}
		
		if(this.map[coord[0] + -1][coord[1] + 0] != '#' && this.visitedMap[coord[0] + -1][coord[1] + 0] == 0)
		{
			int[] temp = {coord[0] + -1, coord[1] + 0};
			Q.enqueue(temp);
			op++;
		}
		
		if(this.map[coord[0] + 1][coord[1] + 0] != '#' && this.visitedMap[coord[0] + 1][coord[1] + 0] == 0)
		{
			int[] temp = {coord[0] + 1, coord[1] + 0};
			Q.enqueue(temp);
			op++;
		}
		
		return op;
	}

	private int[][] toArray(Stack<int[]> S)
	{
		int[][] temp = new int[S.size()][2];
		
		for(int i = temp.length-1 ; i >=0 ; i--)
		{
			temp[i][0] = S.top()[0] - 1;
			temp[i][1] = S.pop()[1] - 1;
		}
		
		return temp;
	}
}
