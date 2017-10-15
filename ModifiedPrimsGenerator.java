package mazeGenerator;

import java.util.*;

import maze.Cell;
import maze.Maze;

public class ModifiedPrimsGenerator implements MazeGenerator {

	@Override
	public void generateMaze(Maze maze) {
		// TODO Auto-generated method stub
		
		////Prism algorithm for perfect normal maze
		if(maze.type==Maze.NORMAL){
			
			Set<Cell> F = new HashSet<Cell>();
			Set<Cell> Z = new HashSet<Cell>();
			
			Random ran = new Random();
			Cell start = maze.entrance;
			
			Z.add(start);
			
			///add neigbouring cells to F 
			if(start.neigh[maze.NORTH] != null)
				F.add(start.neigh[maze.NORTH]);
			
			if(start.neigh[maze.SOUTH] != null)
				F.add(start.neigh[maze.SOUTH]);
			
			if(start.neigh[maze.EAST] != null)
				F.add(start.neigh[maze.EAST]);
			
			if(start.neigh[maze.WEST] != null)
				F.add(start.neigh[maze.WEST]);
			
			///continue making maze until Z is as bis as the maze size
			while(Z.size() != (maze.sizeR*maze.sizeC)){
				
				Cell c = null;
				int  ranC = ran.nextInt(F.size());
				int x=0;
				
				///choose random cells in F
				for(Cell obj : F){
					if(x==ranC){
						c=obj;
						break;
					}
					x++;
				}
				
				F.remove(c);
				
				Cell b = null;
				
				int[] fourDirect = {maze.EAST, maze.NORTH, maze.SOUTH, maze.WEST};
				
				////find cell which is neigbour of c and in Z, then make a path 
				for(int i =0; i<fourDirect.length; i++){
					if(c.neigh[fourDirect[i]] != null){
						for (Cell obj : Z){
							if(c.neigh[fourDirect[i]].equals(obj)){
								b = c.neigh[fourDirect[i]];
								c.wall[fourDirect[i]].present = false;
								break;
								
							}
							
						}
						
					}if (b != null){
						break;
					}
					
				}
				
				///add c into Z
				Z.add(c);
				
				////then add the noigbouring cells of c into F if they are not 
				///already in Z or F 
				if(c.neigh[maze.NORTH] != null){
					boolean inZ = false;
					for (Cell obj : Z){
						if(c.neigh[maze.NORTH].equals(obj))
							inZ = true;
					}for(Cell obj : F){
						if(c.neigh[maze.NORTH].equals(obj))
							inZ = true;
					}if(inZ==false){
						F.add(c.neigh[maze.NORTH]);
						
					}
				}
				
				if(c.neigh[maze.SOUTH] != null){
					boolean inZ = false;
					for (Cell obj : Z){
						if(c.neigh[maze.SOUTH].equals(obj))
							inZ = true;
					}for(Cell obj : F){
						if(c.neigh[maze.SOUTH].equals(obj))
							inZ = true;
					}if(inZ==false){
						F.add(c.neigh[maze.SOUTH]);
						
					}
				}
				
				if(c.neigh[maze.EAST] != null){
					boolean inZ = false;
					for (Cell obj : Z){
						if(c.neigh[maze.EAST].equals(obj))
							inZ = true;
					}for(Cell obj : F){
						if(c.neigh[maze.EAST].equals(obj))
							inZ = true;
					}if(inZ==false){
						F.add(c.neigh[maze.EAST]);
						
					}
				}
				
				if(c.neigh[maze.WEST] != null){
					boolean inZ = false;
					for (Cell obj : Z){
						if(c.neigh[maze.WEST].equals(obj))
							inZ = true;
					}for(Cell obj : F){
						if(c.neigh[maze.WEST].equals(obj))
							inZ = true;
					}if(inZ==false){
						F.add(c.neigh[maze.WEST]);
						
					}
				}
				
			}
			
			
		}
		
		////Prism algorithm for perfect hex maze
		if(maze.type==Maze.HEX){
			Set<Cell> F = new HashSet<Cell>();
			Set<Cell> Z = new HashSet<Cell>();
			
			Random ran = new Random();
			Cell start = maze.entrance;
			
			///add start to Z and all neigbouring cells to F
			Z.add(start);
			
			if(start.neigh[maze.NORTH] != null)
				F.add(start.neigh[maze.NORTH]);
			
			if(start.neigh[maze.SOUTH] != null)
				F.add(start.neigh[maze.SOUTH]);
			
			if(start.neigh[maze.NORTHEAST] != null)
				F.add(start.neigh[maze.NORTHEAST]);
			
			if(start.neigh[maze.NORTHWEST] != null)
				F.add(start.neigh[maze.NORTHWEST]);
			
			if(start.neigh[maze.SOUTHEAST] != null)
				F.add(start.neigh[maze.SOUTHEAST]);
			
			if(start.neigh[maze.SOUTHWEST] != null)
				F.add(start.neigh[maze.SOUTHWEST]);
			
			///keep making maze until maze size wanted 
			while(Z.size() != (maze.sizeR*maze.sizeC)){
				Cell c = null;
				int  ranC = ran.nextInt(F.size());
				int x=0;
				
				///choose random cell in F as c
				for(Cell obj : F){
					if(x==ranC){
						c=obj;
						break;
					}
					x++;
				}
				
				F.remove(c);
				
				Cell b = null;
				
				int[] sixDirect = {maze.NORTH, maze.NORTHEAST,maze.NORTHWEST, maze.SOUTH, maze.SOUTHEAST, maze.SOUTHWEST};
				
				///find cell which is neigbour of c and in Z, then make a path 
				for(int i =0; i<sixDirect.length; i++){
					if(c.neigh[sixDirect[i]] != null){
						for (Cell obj : Z){
							if(c.neigh[sixDirect[i]].equals(obj)){
								b = c.neigh[sixDirect[i]];
								c.wall[sixDirect[i]].present = false;
								break;
								
							}
							
						}
						
					}if (b != null){
						break;
					}
					
				}
				
				///add c into Z
				Z.add(c);
				
				///add neigbouring cell to c into F if they are not already in Z or F
				if(c.neigh[maze.NORTH] != null){
					boolean inZ = false;
					for (Cell obj : Z){
						if(c.neigh[maze.NORTH].equals(obj))
							inZ = true;
					}for(Cell obj : F){
						if(c.neigh[maze.NORTH].equals(obj))
							inZ = true;
					}if(inZ==false){
						F.add(c.neigh[maze.NORTH]);
						
					}
				}
				
				if(c.neigh[maze.SOUTH] != null){
					boolean inZ = false;
					for (Cell obj : Z){
						if(c.neigh[maze.SOUTH].equals(obj))
							inZ = true;
					}for(Cell obj : F){
						if(c.neigh[maze.SOUTH].equals(obj))
							inZ = true;
					}if(inZ==false){
						F.add(c.neigh[maze.SOUTH]);
						
					}
				}
				
				if(c.neigh[maze.NORTHEAST] != null){
					boolean inZ = false;
					for (Cell obj : Z){
						if(c.neigh[maze.NORTHEAST].equals(obj))
							inZ = true;
					}for(Cell obj : F){
						if(c.neigh[maze.NORTHEAST].equals(obj))
							inZ = true;
					}if(inZ==false){
						F.add(c.neigh[maze.NORTHEAST]);
						
					}
				}
				
				if(c.neigh[maze.SOUTHEAST] != null){
					boolean inZ = false;
					for (Cell obj : Z){
						if(c.neigh[maze.SOUTHEAST].equals(obj))
							inZ = true;
					}for(Cell obj : F){
						if(c.neigh[maze.SOUTHEAST].equals(obj))
							inZ = true;
					}if(inZ==false){
						F.add(c.neigh[maze.SOUTHEAST]);
						
					}
				}
				
				if(c.neigh[maze.NORTHWEST] != null){
					boolean inZ = false;
					for (Cell obj : Z){
						if(c.neigh[maze.NORTHWEST].equals(obj))
							inZ = true;
					}for(Cell obj : F){
						if(c.neigh[maze.NORTHWEST].equals(obj))
							inZ = true;
					}if(inZ==false){
						F.add(c.neigh[maze.NORTHWEST]);
						
					}
				}
				
				if(c.neigh[maze.SOUTHWEST] != null){
					boolean inZ = false;
					for (Cell obj : Z){
						if(c.neigh[maze.SOUTHWEST].equals(obj))
							inZ = true;
					}for(Cell obj : F){
						if(c.neigh[maze.SOUTHWEST].equals(obj))
							inZ = true;
					}if(inZ==false){
						F.add(c.neigh[maze.SOUTHWEST]);
						
					}
				}
				
				
			}
			
		}
		
		
		
		
	} // end of generateMaze()

} // end of class ModifiedPrimsGenerator
