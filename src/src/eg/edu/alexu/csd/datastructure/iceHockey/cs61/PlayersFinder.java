package eg.edu.alexu.csd.datastructure.iceHockey.cs61;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class PlayersFinder implements IPlayersFinder{

	public static class Depth
	{
		public int max_x_depth=1;
		public int min_x_depth=1;
		public int max_y_depth=1;
		public int min_y_depth=1;
		
	}
	
	Depth depth = new Depth();
	
	private char[][] map = new char[2500][2500];
	private char[][] visitedMap;
	private Point[] pointMap = new Point[50];
	private int pointI;
	private int num;
	private Point[] empty = {};
	
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		if( photo.length == 0 ||  photo == null)
			return empty;
		this.map = toArray(photo, team); 
		this.visitedMap = new char[this.map.length][this.map[0].length];
		setVisitedMap();
		this.pointI = 0;
		this.num = 0;
		this.pointMap = new Point[50];
		searchIntializer(team, threshold);
		setPointsMap();
		sortMap();
		return this.pointMap;
	}
	
	private int DFS(int team, int i, int j)
	{
		int counter = 0;
		if(DFSIntializer(team,i,j))
		{
			this.visitedMap[i][j] = '1';
			compareMaxMin(i,j);
			counter += DFS(team,i,j+1);
			counter += DFS(team,i,j-1);
			counter += DFS(team,i+1,j);
			counter += DFS(team,i-1,j);
			return ++counter;
		}
		else
		{
			this.visitedMap[i][j] = '1';
			return 0;
		}
	}
	
	private char[][] toArray(String[] photo ,int team)
	{
		char[][] map = new char[photo.length+2][photo[0].length()+2];
		
		for(int i=0; i<photo.length+2; i++)
		{
			for(int j=0; j<photo[0].length()+2;j++)
			{
				if(i==0 || i==photo.length+1)
				{
					map[i][j] = '!';
				}
				else if(j==0 || j==photo[0].length()+1)
				{
					map[i][j] = '!';
				}
				else
				{
					if(Character.getNumericValue(photo[i-1].charAt(j-1)) == team)
						map[i][j] = photo[i-1].charAt(j-1);
					else
						map[i][j] = '!';
				}
				
			}
		}
		
		return map;
	}
		
	private void setVisitedMap()
	{
		for(int i=0;i<this.visitedMap.length;i++)
		{
			for(int j=0;j<this.visitedMap[0].length;j++)
			{
				if(i==0 || i==this.visitedMap.length-1)
					this.visitedMap[i][j] = '!';
				else if(j==0 || j==this.visitedMap[0].length-1)
					this.visitedMap[i][j] = '!';
				else
					this.visitedMap[i][j] = '0';
			}
		}
	}
	
	private boolean DFSIntializer(int team, int i, int j)
	{
		if(Character.getNumericValue(this.map[i][j]) == team && this.visitedMap[i][j] != '1' && i!=0 && j!=0 && i!=this.map.length-1 && j!=this.map[0].length-1)
			return true;
		return false;
	}

	private void searchIntializer(int team, int threshold)
	{
		for(int i=1; i<this.map.length-1;i++)
		{
			for(int j=1;j<this.map[0].length-1;j++)
			{
				if(this.visitedMap[i][j] != '1')
				{
					setMaxMin(i,j);
					int counter = DFS(team,i,j);
					if(counter*4 >= threshold)
					{
						this.num++;
						pointCalculator();
					}
				}	
				
			}
		}
	}
	
	private void pointCalculator()
	{
		Point p = new Point();
		p.x = (depth.max_x_depth*2 +(depth.min_x_depth*2 -2))/2;
		p.y = (depth.max_y_depth*2 +(depth.min_y_depth*2 -2))/2;
		this.pointMap[this.pointI] = p;
		this.pointI++;
	}
	
	private void setMaxMin(int i, int j)
	{
		depth.max_x_depth = j;
		depth.max_y_depth = i;
		depth.min_x_depth = j;
		depth.min_y_depth = i;
	}
	
	private void compareMaxMin(int i, int j)
	{
		if(depth.max_x_depth <= j)
			depth.max_x_depth = j;
		if(depth.max_y_depth <=i)
			depth.max_y_depth = i;
		if(depth.min_x_depth >= j)
			depth.min_x_depth = j;
		if(depth.min_y_depth >=i)
			depth.min_y_depth = i;
	}
	
	private void setPointsMap()
	{
		Point[] p = new Point[this.num];
		for(int i=0; i<this.num; i++)
			p[i] = this.pointMap[i];
		this.pointMap = p;
	}
	
	private void sortMap()
	{
		boolean swapped = true;
		for(int i=0;i<this.num && swapped;i++)
		{
			swapped = false;
			for(int j=0;j<this.num-1-i;j++)
			{
				if(this.pointMap[j].x>this.pointMap[j+1].x)
				{
					Point temp = this.pointMap[j];
					this.pointMap[j] = this.pointMap[j+1];
					this.pointMap[j+1] = temp;
					swapped = true;
				}
				else if(this.pointMap[j].x==this.pointMap[j+1].x)
				{
					if(this.pointMap[j].y>this.pointMap[j+1].y)
					{
						Point temp = this.pointMap[i];
						this.pointMap[j] = this.pointMap[j+1];
						this.pointMap[j+1] = temp;
						swapped = true;
					}
				}
				
			}
		}
	}
	
}
