package eg.edu.alexu.csd.datastructure.maze.cs61;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		File maze = new File("jimmy.txt");
		
		MazeSolver ms = new MazeSolver();
		int[][]	temp = ms.solveDFS(maze);
		
		System.out.println(temp[0][0]);
	}

}
