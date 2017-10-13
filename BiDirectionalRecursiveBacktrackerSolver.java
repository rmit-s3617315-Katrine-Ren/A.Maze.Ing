package mazeSolver;

import java.util.ArrayList;
import java.util.Random;

import maze.Cell;
import maze.Maze;

/**
 * Implements the BiDirectional recursive backtracking maze solving algorithm.
 */
public class BiDirectionalRecursiveBacktrackerSolver implements MazeSolver {

	int steps=0;
	boolean solved;
	Cell current;
	
	@Override
	public void solveMaze(Maze maze) {
		// TODO Auto-generated method stub
		solved = false;
		Random ran = new Random();
		current = maze.entrance;
		ArrayList<Cell> visitedCells= new ArrayList<Cell>();
		visitedCells.add(current);
		maze.drawFtPrt(current);
		
		if(maze.type==Maze.NORMAL){
			int[] fourDirect = {maze.EAST, maze.NORTH, maze.SOUTH, maze.WEST};
			
			while(current != maze.exit){
				
				//// shuffle direction
				 for (int i = 0; i < fourDirect.length; i++) {
					 int ranVal = i + ran.nextInt(fourDirect.length-i);
					 int ranEle = fourDirect[ranVal];
					 fourDirect[ranVal] = fourDirect[i];
					 fourDirect[i]= ranEle;
					 
				 }
				 
				 int path=0;
				 
				 for(int i =0; i<fourDirect.length; i++){
					 if(current.wall[fourDirect[i]].present == false){
						 path++;
						 
					 } 
				 }
				 
				 boolean deadEnd=true;
				 
				 
				/////Chk if it is deadend
				for(int i =0; i<fourDirect.length; i++){
					if(current.neigh[fourDirect[i]] != null){
						if(current.wall[fourDirect[i]].present == false){
							if(!visitedCells.contains(current.neigh[fourDirect[i]])){
								deadEnd=false;
								break;
								
							}
						}
					}
				}
				
				/////if so go back one by one
				if(deadEnd){
					for(int i=visitedCells.size()-2;i>=0;i--){
						current=visitedCells.get(i);
						for(int j =0; j<fourDirect.length; j++){
							if(current.neigh[fourDirect[j]] != null){
								if(!visitedCells.contains(current.neigh[fourDirect[j]])){
									if(current.wall[fourDirect[j]].present == false){
										deadEnd=false;
										break;
									}
								}
							}
						}
						if(!deadEnd)
							break;
						
					}
					
				}
				 
				 
					 for(int i =0; i<fourDirect.length; i++){
						if(current.neigh[fourDirect[i]] != null){
							if(!visitedCells.contains(current.neigh[fourDirect[i]])){
								if(current.wall[fourDirect[i]].present == false){
									current = current.neigh[fourDirect[i]];
									maze.drawFtPrt(current);
									visitedCells.add(current);
									steps++;
									break;
								}
								
							}
						}
					 }
				 
			}///////// end of while
			
			solved = true;
		}///// end of if maze type normal
		
		if(maze.type==Maze.TUNNEL){
			int[] fourDirect = {maze.EAST, maze.NORTH, maze.SOUTH, maze.WEST};
			
			while(current != maze.exit){

				//// shuffle direction
				 for (int i = 0; i < fourDirect.length; i++) {
					 int ranVal = i + ran.nextInt(fourDirect.length-i);
					 int ranEle = fourDirect[ranVal];
					 fourDirect[ranVal] = fourDirect[i];
					 fourDirect[i]= ranEle;
					 
				 }
				 
				 /////if current is a tunnel move to its destination
				 if(current.tunnelTo != null){
						current = current.tunnelTo;
						visitedCells.add(current);
						maze.drawFtPrt(current);
						
					}
				 
				 
				 boolean deadEnd=true;
				 

					/////Chk if it is deadend
					for(int i =0; i<fourDirect.length; i++){
						if(current.neigh[fourDirect[i]] != null){
							if(current.wall[fourDirect[i]].present == false){
								if(!visitedCells.contains(current.neigh[fourDirect[i]])){
									deadEnd=false;
									break;
									
								}
							}
						}
					}
					
					/////if so go back one by one
					if(deadEnd){
						for(int i=visitedCells.size()-2;i>=0;i--){
							current=visitedCells.get(i);
							for(int j =0; j<fourDirect.length; j++){
								if(current.neigh[fourDirect[j]] != null){
									if(!visitedCells.contains(current.neigh[fourDirect[j]])){
										if(current.wall[fourDirect[j]].present == false){
											deadEnd=false;
											break;
										}
									}
								}
							}
							if(!deadEnd)
								break;
							
						}
						
					}
					 
					 
						 for(int i =0; i<fourDirect.length; i++){
							if(current.neigh[fourDirect[i]] != null){
								if(!visitedCells.contains(current.neigh[fourDirect[i]])){
									if(current.wall[fourDirect[i]].present == false){
										current = current.neigh[fourDirect[i]];
										maze.drawFtPrt(current);
										visitedCells.add(current);
										steps++;
										break;
									}
									
								}
							}
						 }
				
			}///end while
			solved=true;
			
		}///end of if maze
		
		if(maze.type==Maze.HEX){
			int[] sixDirect = {maze.NORTH, maze.NORTHEAST,maze.NORTHWEST, maze.SOUTH, maze.SOUTHEAST, maze.SOUTHWEST};
			
			while(current != maze.exit){

				//// shuffle direction
				 for (int i = 0; i < sixDirect.length; i++) {
					 int ranVal = i + ran.nextInt(sixDirect.length-i);
					 int ranEle = sixDirect[ranVal];
					 sixDirect[ranVal] = sixDirect[i];
					 sixDirect[i]= ranEle;
					 
				 }
				 
				 int path=0;
				 
				 for(int i =0; i<sixDirect.length; i++){
					 if(current.wall[sixDirect[i]].present == false){
						 path++;
						 
					 } 
				 }
				 
				 boolean deadEnd=true;
				 

				/////Chk if it is deadend
				for(int i =0; i<sixDirect.length; i++){
					if(current.neigh[sixDirect[i]] != null){
						if(current.wall[sixDirect[i]].present == false){
							if(!visitedCells.contains(current.neigh[sixDirect[i]])){
								deadEnd=false;
								break;
								
							}
						}
					}
				}
				
				/////if so go back one by one
				if(deadEnd){
					for(int i=visitedCells.size()-2;i>=0;i--){
						current=visitedCells.get(i);
						for(int j =0; j<sixDirect.length; j++){
							if(current.neigh[sixDirect[j]] != null){
								if(!visitedCells.contains(current.neigh[sixDirect[j]])){
									if(current.wall[sixDirect[j]].present == false){
										deadEnd=false;
										break;
									}
								}
							}
						}
						if(!deadEnd)
							break;
						
					}
					
				}
				 
				 
					 for(int i =0; i<sixDirect.length; i++){
						if(current.neigh[sixDirect[i]] != null){
							if(!visitedCells.contains(current.neigh[sixDirect[i]])){
								if(current.wall[sixDirect[i]].present == false){
									current = current.neigh[sixDirect[i]];
									maze.drawFtPrt(current);
									visitedCells.add(current);
									steps++;
									break;
								}
								
							}
						}
					 }
				
			}///end of while
			solved=true;
			
		}///end of if

	} // end of solveMaze()


	@Override
	public boolean isSolved() {
		// TODO Auto-generated method stub

		return solved;
	} // end if isSolved()


	@Override
	public int cellsExplored() {
		// TODO Auto-generated method stub
		
		
		return steps;
	} // end of cellsExplored()

} // end of class BiDirectionalRecursiveBackTrackerSolver
