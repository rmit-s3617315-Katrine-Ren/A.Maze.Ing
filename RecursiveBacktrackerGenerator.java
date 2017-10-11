package mazeGenerator;

import java.util.*;
import maze.Cell;
import maze.Maze;
import maze.TunnelMaze;

public class RecursiveBacktrackerGenerator implements MazeGenerator {

	@Override
	public void generateMaze(Maze maze) {
		// TODO Auto-generated method stub

		if(maze.type==Maze.NORMAL){
			
			Random ran = new Random();
			Cell current = maze.entrance;
			ArrayList<Cell> visitedCells= new ArrayList<Cell>();
			
			visitedCells.add(current);
			int[] fourDirect = {maze.EAST, maze.NORTH, maze.SOUTH, maze.WEST};
			
			while(visitedCells.size() != (maze.sizeR*maze.sizeC)){
				
				
				boolean deadEnd=true;
				
				//// shuffle direction
				 for (int i = 0; i < fourDirect.length; i++) {
					 int ranVal = i + ran.nextInt(fourDirect.length-i);
					 int ranEle = fourDirect[ranVal];
					 fourDirect[ranVal] = fourDirect[i];
					 fourDirect[i]= ranEle;
					 
				 }
				
				
				/////Chk if it is deadend
				for(int i =0; i<fourDirect.length; i++){
					if(current.neigh[fourDirect[i]] != null){
						if(!visitedCells.contains(current.neigh[fourDirect[i]])){
								deadEnd=false;
								break;
							
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
										deadEnd=false;
										break;
								}
							}
						}
						if(!deadEnd)
							break;
						
					}
					
				}
				
				
				Cell d = null;
				
				for(int i =0; i<fourDirect.length; i++){
					if(current.neigh[fourDirect[i]] != null){
						if(!visitedCells.contains(current.neigh[fourDirect[i]])){
								current.wall[fourDirect[i]].present = false;
								current = current.neigh[fourDirect[i]];
								visitedCells.add(current);
								break;
						}
						
					}
				}
			}

			
		}
		
		
		if(maze.type==Maze.TUNNEL){
			Random ran = new Random();
			Cell current = maze.entrance;
			ArrayList<Cell> visitedCells= new ArrayList<Cell>();
			
			visitedCells.add(current);
			int[] fourDirect = {maze.EAST, maze.NORTH, maze.SOUTH, maze.WEST};
			
			while(visitedCells.size() != (maze.sizeR*maze.sizeC)){
				
				
				boolean deadEnd=true;
				
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
						
					}
				
				/////Chk if it is deadend
				for(int i =0; i<fourDirect.length; i++){
					if(current.neigh[fourDirect[i]] != null){
						if(!visitedCells.contains(current.neigh[fourDirect[i]])){
								deadEnd=false;
								break;
							
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
										deadEnd=false;
										break;
									
								}
							}
						}
						if(!deadEnd)
							break;
						
					}
					
				}
				
				
				Cell d = null;
				
				for(int i =0; i<fourDirect.length; i++){
					if(current.neigh[fourDirect[i]] != null){
						if(!visitedCells.contains(current.neigh[fourDirect[i]])){
								current.wall[fourDirect[i]].present = false;
								current = current.neigh[fourDirect[i]];
								visitedCells.add(current);
								break;
						}
						
					}
				}
			}
			
			
		}
		
		if(maze.type==Maze.HEX){
			Random ran = new Random();
			Cell current = maze.entrance;
			ArrayList<Cell> visitedCells= new ArrayList<Cell>();
			
			visitedCells.add(current);
			
			while(visitedCells.size() != (maze.sizeR*maze.sizeC)){
				int[] sixDirect = {maze.NORTH, maze.NORTHEAST,maze.NORTHWEST, maze.SOUTH, maze.SOUTHEAST, maze.SOUTHWEST};
				boolean move=true,deadEnd=true;
				
				///shuffle direction
				for (int i = 0; i < sixDirect.length; i++) {
					 int ranVal = i + ran.nextInt(sixDirect.length-i);
					 int ranEle = sixDirect[ranVal];
					 sixDirect[ranVal] = sixDirect[i];
					 sixDirect[i]= ranEle;
					 
				 }
				
				/////Chk if it is deadend
				for(int i =0; i<sixDirect.length; i++){
					if(current.neigh[sixDirect[i]] != null){
						if(!visitedCells.contains(current.neigh[sixDirect[i]])){
							deadEnd=false;
							break;
						}
					}
				}
				
				///if so go back one by one
				if(deadEnd){
					for(int i=visitedCells.size()-1;i>=0;i--){
						current=visitedCells.get(i);
						
						for(int j =0; j<sixDirect.length; j++){
							if(current.neigh[sixDirect[j]] != null){
								if(!visitedCells.contains(current.neigh[sixDirect[j]])){
									deadEnd=false;
									break;
								}
							}
						}if(!deadEnd)
							break;
						
					}
					
				}
				
				Cell d = null;
				
				for(int i =0; i<sixDirect.length; i++){
					if(current.neigh[sixDirect[i]] != null){
						if(!visitedCells.contains(current.neigh[sixDirect[i]])){
							current.wall[sixDirect[i]].present = false;
							current = current.neigh[sixDirect[i]];
							visitedCells.add(current);
							break;
						}
						
					}
				}

				
				
			}
			
		}
		
		///////////////////////////////////////////////////
		
		
		
	} // end of generateMaze()

} // end of class RecursiveBacktrackerGenerator
