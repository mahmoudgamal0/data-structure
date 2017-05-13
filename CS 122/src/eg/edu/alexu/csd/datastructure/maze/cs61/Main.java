package eg.edu.alexu.csd.datastructure.maze.cs61;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		File maze = new File("jimmy.txt");
		
		MazeSolver ms = new MazeSolver();
		int[][]	temp = ms.solveBFS(maze);
		int[][] temp2 = ms.solveDFS(maze);
		
		for(int i = 0 ; i < temp.length ; i++)
		{
			System.out.println(temp[i][0] + ", " + temp[i][1]);
		}
		System.out.println("==========================");
		for(int i = 0 ; i < temp2.length ; i++)
		{
			System.out.println(temp2[i][0] + ", " + temp2[i][1]);
		}
	}

}
