package eg.edu.alexu.csd.datastructure.iceHockey.cs61;

import java.awt.Point;

public class Main {

	public static void main(String[] args) {
		
		
		String photo[] = {	"3456789120",
							"ABCDEFGHYB",
							"IJKLMNOPZC",
							"QRSTUVWX3D",
							"45678910AE",
};
		Point[] p = new Point[50];
		PlayersFinder finder = new PlayersFinder();
		p=finder.findPlayers(photo, 3, 1);
		
		for(int i=0;i<p.length;i++)
		{
			System.out.println(p[i]);
		}
		
	}

}
