package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w; 
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
		int mazeX = randGen.nextInt(maze.getHeight());
		int mazeY = randGen.nextInt(maze.getWidth());
		
		//5. call selectNextPath method with the randomly selected cell
		selectNextPath(maze.getCell(mazeX, mazeY));
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		//A. mark cell as visited
		currentCell.hasBeenVisited();
		//B. Get an ArrayList of unvisited neighbors using the current cell and the method below
	    ArrayList<Cell> neighbors = getUnvisitedNeighbors(currentCell);
		//C. if has unvisited neighbors,
		if (neighbors.size()>0){
			Random rand = new Random();
			int n = rand.nextInt(neighbors.size());
			uncheckedCells.push(neighbors.get(n));
			neighbors.get(n).setWestWall(false);
			neighbors.get(n).setEastWall(false);
			neighbors.get(n).hasBeenVisited();
			selectNextPath(maze.getCell(n, 0));
		}
			//C1. select one at random.
		
			//C2. push it to the stack
		
			//C3. remove the wall between the two cells

			//C4. make the new cell the current cell and mark it as visited
		
			//C5. call the selectNextPath method with the current cell
			
			
		//D. if all neighbors are visited
		if (neighbors.size()<100) {
			if (uncheckedCells.empty()==false) {
				uncheckedCells.pop();
				selectNextPath(maze.getCell(width, height));
				
			}
		}
			//D1. if the stack is not empty
			
				// D1a. pop a cell from the stack
		
				// D1b. make that the current cell
		
				// D1c. call the selectNextPath method with the current cell
				
			
		
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if (c1 == c2) {
			c1.setEastWall(false);
			c1.setNorthWall(false);
			c1.setWestWall(false);
			c1.setSouthWall(false);
			c2.setWestWall(false);
			c2.setSouthWall(false);
			c2.setEastWall(false);
			c2.setNorthWall(false);
		}
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		
		return null;
		
	}
}
