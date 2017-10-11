package mazeGenerator;

import java.util.*;

import maze.Maze;
import maze.Cell;

public class GrowingTreeGenerator implements MazeGenerator {
	// Growing tree maze generator. As it is very general, here we implement as "usually pick the most recent cell, but occasionally pick a random cell"
	
	double threshold = 0.1;
	
	@Override
	public void generateMaze(Maze maze) {
		
		Set<Cell> Z = new HashSet<Cell>();
		
		Random ran = new Random();
		Cell start = maze.entrance;
		ArrayList<Cell> visitedCells= new ArrayList<Cell>();
		
		Z.add(start);
		visitedCells.add(start);
		
		if(maze.type==Maze.NORMAL){
			
			while(!Z.isEmpty()){
				int[] fourDirect = {maze.EAST, maze.NORTH, maze.SOUTH, maze.WEST};
				
				Cell b = null;
				float chance = ran.nextFloat();
				
				////shuffle   OK
				for (int i = fourDirect.length-1; i>0;i--) {
					 int ranVal = ran.nextInt(i+1);
					 int ranEle = fourDirect[ranVal];
					 fourDirect[ranVal] = fourDirect[i];
					 fourDirect[i]= ranEle;
					 
				 }
				
				if(chance > threshold){
					
					for(int i=visitedCells.size()-1;i>=0;i--){
						if(Z.contains(visitedCells.get(i))){
							b=visitedCells.get(i);
							break;
						}
						
					}
					/////////////////////
					
					
					
				}else{///////////emulate prism
					int x=0;
					boolean notLast=true;
					
					
					////random cell in Z
					
						int  ranZ = ran.nextInt(Z.size());
						for(Cell obj : Z){
							if(x==ranZ){
								b=obj;
								break;
							}
							x++;
						}
				}
				
				boolean deadEnd=true;
				
				/////////chk if b has unvisit neig
				for(int i =0; i<fourDirect.length; i++){
					if(b.neigh[fourDirect[i]] != null){
						if(!visitedCells.contains(b.neigh[fourDirect[i]])){
							deadEnd=false;
							break;
						}
					}
				}
				
				
				if(deadEnd){
					Z.remove(b);
				}else{
					for(int i =0; i<fourDirect.length; i++){
						if(b.neigh[fourDirect[i]] != null){
							if(!visitedCells.contains(b.neigh[fourDirect[i]])){
								b.wall[fourDirect[i]].present = false;
								Z.add(b.neigh[fourDirect[i]]);
								visitedCells.add(b.neigh[fourDirect[i]]);
								break;
							
							}
						}
					}
				
				}
				
				
			}
		
		}
		
		if(maze.type==Maze.HEX){
			while(!Z.isEmpty()){
				int[] sixDirect = {maze.NORTH, maze.NORTHEAST,maze.NORTHWEST, maze.SOUTH, maze.SOUTHEAST, maze.SOUTHWEST};
				
				Cell b = null;
				float chance = ran.nextFloat();
				
				////shuffle   OK
				for (int i = sixDirect.length-1; i>0;i--) {
					 int ranVal = ran.nextInt(i+1);
					 int ranEle = sixDirect[ranVal];
					 sixDirect[ranVal] = sixDirect[i];
					 sixDirect[i]= ranEle;
					 
				 }
				
				if(chance > threshold){
					for(int i=visitedCells.size()-1;i>=0;i--){
						if(Z.contains(visitedCells.get(i))){
							b=visitedCells.get(i);
							break;
						}
						
					}
					
				}else{
					int x=0;
					boolean notLast=true;
					
					
					////random cell in Z
					
						int  ranZ = ran.nextInt(Z.size());
						for(Cell obj : Z){
							if(x==ranZ){
								b=obj;
								break;
							}
							x++;
						}
				}
				
				boolean deadEnd=true;
				
				/////////chk if b has unvisit neig
				for(int i =0; i<sixDirect.length; i++){
					if(b.neigh[sixDirect[i]] != null){
						if(!visitedCells.contains(b.neigh[sixDirect[i]])){
							deadEnd=false;
							break;
						}
					}
				}
				
				
				if(deadEnd){
					Z.remove(b);
				}else{
					for(int i =0; i<sixDirect.length; i++){
						if(b.neigh[sixDirect[i]] != null){
							if(!visitedCells.contains(b.neigh[sixDirect[i]])){
								b.wall[sixDirect[i]].present = false;
								Z.add(b.neigh[sixDirect[i]]);
								visitedCells.add(b.neigh[sixDirect[i]]);
								break;
							
							}
						}
					}
				
				}
				
			}
		}
	}

}
