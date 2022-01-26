package pkg;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Maze {
	
	Square[][] maze;
	Square start;
	Square exit;
	String fileName;
	
	public Maze() {
		
	}
	
	public boolean loadMaze(String fileName) {
		this.fileName = fileName;
		try {	
			Scanner scr = new Scanner(new File(fileName));
			maze = new Square[scr.nextInt()][scr.nextInt()];
			int r = 0, c = 0;
			
			
			while(scr.hasNext()) {
				maze[r][c] = new Square(r, c, scr.nextInt());
				
				if (maze[r][c].getType() == 2)
					start = maze[r][c];
				if (maze[r][c].getType() == 3)
					exit = maze[r][c];
				
				c++;
				if (c >= maze[r].length) {
					r++;
					c=0;
				}
			}
			
		/*for(int r = 0; r < maze.length; r++)
		{
			for(int c = 0; c < maze[r].length; c++)
			{
				maze[r][c] = new Square(r, c, lines.get(r).charAt(c));
				if (maze[r][c].getType() == 2)
					start = maze[r][c];
				if (maze[r][c].getType() == 3)
					exit = maze[r][c];
			}
		}
		*/
		} catch (IOException e) {
				return false;
		}
		return true;
	}
	
	public List<Square> getNeighbors(Square s) {
		ArrayList<Square> neighbors = new ArrayList<Square>();
		
		if(s.getCol() - 1 >= 0) {
			neighbors.add(maze[s.getCol() - 1][s.getRow()]);
		}
		if(s.getCol() + 1 < maze[0].length) {
			neighbors.add(maze[s.getCol()][s.getRow() + 1]);
		}
		if(s.getRow() - 1 >= 0) {
			neighbors.add(maze[s.getCol()][s.getRow() - 1]);
		}
		if(s.getRow() + 1 < maze.length) {
			neighbors.add(maze[s.getRow()][s.getRow() + 1]);
		}		
		
		return neighbors;
	}
	
	public Square getStart() {
		return start;
	}
	
	public Square getExit() {
		return exit;
	}
	
	public void reset() 
	{
		for(int x = 0; x < maze.length; x++)
		{
			for(int y = 0; y < maze[x].length; y++)
			{
				switch(maze[x][y].getType())
				{
				case 0:
					maze[x][y] = new Square(x,y,0);
					break;
				case 1:
					maze[x][y] = new Square(x,y,1);
					break;
				case 2:
					maze[x][y] = new Square(x,y,2);
					break;
				case 3:
					maze[x][y] = new Square(x,y,3);
					break;
				}
			}
		}
		
	}
	
	public String toString() {		
		String s = "";
		for(int r = 0; r < maze.length; r++)
		{
			for(int c = 0; c < maze[r].length; c++)
			{
				s += maze[r][c];
			}
			s += "\n";
		}
		return s;
	}

}
