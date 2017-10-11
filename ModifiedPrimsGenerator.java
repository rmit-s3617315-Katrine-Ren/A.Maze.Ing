package mazeGenerator;

import java.util.*;

import maze.Cell;
import maze.Maze;

public class ModifiedPrimsGenerator implements MazeGenerator {

	@Override
	public void generateMaze(Maze maze) {
		// TODO Auto-generated method stub
		
		if(maze.type==Maze.NORMAL){
			
			Set<Cell> F = new HashSet<Cell>();
			Set<Cell> Z = new HashSet<Cell>();
			
			Random ran = new Random();
			Cell start = maze.entrance;
			
			Z.add(start);
			
			if(start.neigh[maze.NORTH] != null)
				F.add(start.neigh[maze.NORTH]);
			
			if(start.neigh[maze.SOUTH] != null)
				F.add(start.neigh[maze.SOUTH]);
			
			if(start.neigh[maze.EAST] != null)
				F.add(start.neigh[maze.EAST]);
			
			if(start.neigh[maze.WEST] != null)
				F.add(start.neigh[maze.WEST]);
			
			while(Z.size() != (maze.sizeR*maze.sizeC)){
				
				Cell c = null;
				int  ranC = ran.nextInt(F.size());
				int x=0;
				for(Cell obj : F){
					if(x==ranC){
						c=obj;
						break;
					}
					x++;
				}
				
				F.remove(c);
				
				Cell d = null;
				
				int[] fourDirect = {maze.EAST, maze.NORTH, maze.SOUTH, maze.WEST};
				
				for(int i =0; i<fourDirect.length; i++){
					if(c.neigh[fourDirect[i]] != null){
						for (Cell obj : Z){
							if(c.neigh[fourDirect[i]].equals(obj)){
								d = c.neigh[fourDirect[i]];
								c.wall[fourDirect[i]].present = false;
								break;
								
							}
							
						}
						
					}if (d != null){
						break;
					}
					
				}
				
				Z.add(c);
				
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
		
		if(maze.type==Maze.HEX){
			Set<Cell> F = new HashSet<Cell>();
			Set<Cell> Z = new HashSet<Cell>();
			
			Random ran = new Random();
			Cell start = maze.entrance;
			
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
			
			while(Z.size() != (maze.sizeR*maze.sizeC)){
				Cell c = null;
				int  ranC = ran.nextInt(F.size());
				int x=0;
				for(Cell obj : F){
					if(x==ranC){
						c=obj;
						break;
					}
					x++;
				}
				
				F.remove(c);
				
				Cell d = null;
				
				int[] sixDirect = {maze.NORTH, maze.NORTHEAST,maze.NORTHWEST, maze.SOUTH, maze.SOUTHEAST, maze.SOUTHWEST};
				
				for(int i =0; i<sixDirect.length; i++){
					if(c.neigh[sixDirect[i]] != null){
						for (Cell obj : Z){
							if(c.neigh[sixDirect[i]].equals(obj)){
								d = c.neigh[sixDirect[i]];
								c.wall[sixDirect[i]].present = false;
								break;
								
							}
							
						}
						
					}if (d != null){
						break;
					}
					
				}
				
				Z.add(c);
				
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
