package mazeSolver;

import java.util.ArrayList;
import java.util.Random;

import maze.Cell;
import maze.Maze;

/**
 * Implements WallFollowerSolver
 * The wallFollower apply the left-hand rule to solve the maze
 * The algorithms will check whether there is path on the left, if so turns left
 * When there is a dead end, turn right/90 degree Clockwise 
 * Continue the two steps above unitl meet the exit of maze
 */

public class WallFollowerSolver implements MazeSolver {
    
    int steps=0;
    boolean solved;
    Cell current;
    Random ran = new Random();
    int currentDir;
    ArrayList<Cell> visitedCells= new ArrayList<Cell>();

    int[] fourDirect = {Maze.EAST, Maze.NORTH, Maze.WEST, Maze.SOUTH};
    int[] sixDirect = { Maze.NORTHEAST,Maze.NORTH,Maze.NORTHWEST,Maze.SOUTHWEST,Maze.SOUTH, Maze.SOUTHEAST};

    @Override
    public void solveMaze(Maze maze) {
        solved = false;
        current = maze.entrance;
        visitedCells.add(current);
        maze.drawFtPrt(current);

        
        /* Wall Follower algorithm solver for perfect normal maze */
        if(maze.type==Maze.NORMAL){

            
            //start first step toward a random direction
            currentDir = Shuffle(maze);

        //Have we reahced the end?
        while(current != maze.exit){

            //Is there no left wall?

            //if ture, turn left and step to left-side cell
            if(noLeftWall(currentDir)==true){
                rotateLeft(currentDir);
                stepForward(maze,currentDir);
            }

            else{
                // left wall exist. Is there no front wall? 

                //if true, step forward to current direction
                if(noFrontWall(currentDir) == true){
                    stepForward(maze,currentDir);
                }
                //if false, turn right/90 degree CW
                else{
                    rotateRight(currentDir);
                }
               
            }

        }
        ///since able to reach exit, maze is solved
            solved = true;
        }//end of NORMAL Maze Solver


       /* Wall Follower algorithm solver for perfect tunnel maze */
        if(maze.type==Maze.TUNNEL){

            //int[] fourDirect = {maze.EAST, maze.NORTH, maze.WEST, maze.SOUTH};

            //start first step toward a random direction
            currentDir = Shuffle(maze);

        //Have we reached the end?
        while(current != maze.exit){

            ////if current is a tunnel move to its destination
            if(current.tunnelTo != null){
                current = current.tunnelTo;
                visitedCells.add(current);
                maze.drawFtPrt(current);    
            }

            //Is there no left wall?

            //if ture, turn left and step to the left-side cell
            if(noLeftWall(currentDir)==true){
                rotateLeft(currentDir);
                stepForward(maze,currentDir);
            }

            else{
                //left wall exist. Is there no front wall? 

                //if true, step forward to current direction
                if(noFrontWall(currentDir) == true){
                    stepForward(maze,currentDir);
                }
                //if false, turn right/90 degree CW
                else{
                    rotateRight(currentDir);
                }
               
            }

        }
        ///since able to reach exit, maze is solved
            solved = true;
        
     }//end of TUNNEL Maze Solver


     /* Wall Follower algorithm solver for perfect Hexgon maze */
     if(maze.type == Maze.HEX){

        

        //start first step toward a random direction
        currentDir = Shuffle(maze);

        while(current != maze.exit){

            //Is there no bottom-left wall?
            if(noBottomLeftWall(currentDir) == true){

                //rotate to bottom-left and step to next cell
                rotateBottomLeft(currentDir);
                stepForward(maze,currentDir);

            }
            //Is there no top-left wall?
            else if(noTopLeftWall(currentDir) == true){

                //rotate to top-left and step to next cell
                rotateTopLeft(currentDir);
                stepForward(maze,currentDir);

            }
            else{
                //Is there no front wall?
                if(noFrontHexWall(currentDir) == true){
                    //step forward to current direction
                    stepForward(maze,currentDir);

                }
                else{

                    //rotate to top-right direction and loop again
                    rotateTopRight(currentDir);


                }


            }

        }


     }//end of HEX maze Solver


    } // end of solveMaze()
    
    
    

    /*Check if the wall exist */

    //functions for Square maze
    public boolean noLeftWall(int cDirection){
        boolean noLWall = false;

         if(cDirection == fourDirect[0]) {
            if(current.wall[fourDirect[1]].present == false){
                noLWall = true;
            }
         }
         else if(cDirection == (fourDirect[1])){
            if(current.wall[fourDirect[2]].present == false){
                noLWall = true;
         }
        }
         else if(cDirection == (fourDirect[2])){
            if(current.wall[fourDirect[3]].present == false){
                noLWall = true;
         }
        }
         else if(cDirection == (fourDirect[3])){
            if(current.wall[fourDirect[0]].present == false){
                noLWall = true;
         }
        }

        return noLWall;
                
      }//end of noLeftWall()

    

    public boolean noFrontWall(int cDirection){

        boolean noFWall = false;

         if(cDirection == (fourDirect[0])) {
            if(current.wall[fourDirect[0]].present == false){
                noFWall = true;
            }
         }
         else if(cDirection == (fourDirect[1])){
            if(current.wall[fourDirect[1]].present == false){
                noFWall = true;
         }
        }
         else if(cDirection == (fourDirect[2])){
            if(current.wall[fourDirect[2]].present == false){
                noFWall = true;
         }
        }
         else if(cDirection == (fourDirect[3])){
            if(current.wall[fourDirect[3]].present == false){
                noFWall = true;
         }
        }

        return noFWall;

    }//end of noFrontWall()


    //functions for Hex maze
    public boolean noBottomLeftWall(int cDirection){
        
        boolean noBLWall = false;

        if(cDirection == (sixDirect[0])) {
            if(current.wall[sixDirect[2]].present == false){
                noBLWall = true;
            }
         }
         else if(cDirection == (sixDirect[1])){
            if(current.wall[sixDirect[3]].present == false){
                noBLWall = true;
         }
        }
        else if(cDirection == (sixDirect[2])){
            if(current.wall[sixDirect[4]].present == false){
                noBLWall = true;
         }
        }else if(cDirection == (sixDirect[3])){
            if(current.wall[sixDirect[5]].present == false){
                noBLWall = true;
         }
        }else if(cDirection == (sixDirect[4])){
            if(current.wall[sixDirect[0]].present == false){
                noBLWall = true;
         }
        }else if(cDirection == (sixDirect[5])){
            if(current.wall[sixDirect[1]].present == false){
                noBLWall = true;
         }
        }

        return noBLWall;


    }

    public boolean noTopLeftWall(int cDirection){
        boolean noTLWall = false;

        if(cDirection == (sixDirect[0])) {
            if(current.wall[sixDirect[1]].present == false){
                noTLWall = true;
            }
         }
         else if(cDirection == (sixDirect[1])){
            if(current.wall[sixDirect[2]].present == false){
                noTLWall = true;
         }
        }
        else if(cDirection == (sixDirect[2])){
            if(current.wall[sixDirect[3]].present == false){
                noTLWall = true;
         }
        }else if(cDirection == (sixDirect[3])){
            if(current.wall[sixDirect[4]].present == false){
                noTLWall = true;
         }
        }else if(cDirection == (sixDirect[4])){
            if(current.wall[sixDirect[5]].present == false){
                noTLWall = true;
         }
        }else if(cDirection == (sixDirect[5])){
            if(current.wall[sixDirect[0]].present == false){
                noTLWall = true;
         }
        }

        return noTLWall;

    }

    public boolean noFrontHexWall(int cDirection){

        boolean noFLWall = false;

        if(cDirection == (sixDirect[0])) {
            if(current.wall[sixDirect[0]].present == false){
                noFLWall = true;
            }
         }
         else if(cDirection == (sixDirect[1])){
            if(current.wall[sixDirect[1]].present == false){
                noFLWall = true;
         }
        }
        else if(cDirection == (sixDirect[2])){
            if(current.wall[sixDirect[2]].present == false){
                noFLWall = true;
         }
        }else if(cDirection == (sixDirect[3])){
            if(current.wall[sixDirect[3]].present == false){
                noFLWall = true;
         }
        }else if(cDirection == (sixDirect[4])){
            if(current.wall[sixDirect[4]].present == false){
                noFLWall = true;
         }
        }else if(cDirection == (sixDirect[5])){
            if(current.wall[sixDirect[5]].present == false){
                noFLWall = true;
         }
        }

        return noFLWall;

    }


    /* Change Direction */

    //function for Square maze
    public void rotateLeft(int cDirection) {

        if(cDirection == (fourDirect[0])){
            cDirection = fourDirect[1]; 
        }
        else if(cDirection == (fourDirect[1])){
            cDirection = fourDirect[2];
        }
        else if(cDirection == (fourDirect[2])){
            cDirection = fourDirect[3];
        }
        else if(cDirection == (fourDirect[3])){
            cDirection = fourDirect[0];
        }

    }

    public void rotateRight(int cDirection){

        if(cDirection == (fourDirect[0])){
            cDirection = fourDirect[3]; 
        }
        else if(cDirection == (fourDirect[1])){
            cDirection = fourDirect[0];
        }
        else if(cDirection == (fourDirect[2])){
            cDirection = fourDirect[1];
        }
        else if(cDirection == (fourDirect[3])){
            cDirection = fourDirect[2];
        }

    }

    //functions for Hex Maze

    public void rotateBottomLeft(int cDirection){

        if(cDirection == (sixDirect[0])) {
            cDirection = sixDirect[2];
         }
         else if(cDirection == (sixDirect[1])){
            cDirection = sixDirect[3];
        }
        else if(cDirection == (sixDirect[2])){
            cDirection = sixDirect[4];

        }else if(cDirection == (sixDirect[3])){
            cDirection = sixDirect[5];

        }else if(cDirection == (sixDirect[4])){
            cDirection = sixDirect[0];

        }else if(cDirection == (sixDirect[5])){
            cDirection = sixDirect[1];
        }

    }


    public void rotateTopLeft(int cDirection){

        if(cDirection == (sixDirect[0])) {
            cDirection = sixDirect[1];
         }
         else if(cDirection == (sixDirect[1])){
            cDirection = sixDirect[2];
        }
        else if(cDirection == (sixDirect[2])){
            cDirection = sixDirect[3];

        }else if(cDirection == (sixDirect[3])){
            cDirection = sixDirect[4];

        }else if(cDirection == (sixDirect[4])){
            cDirection = sixDirect[5];

        }else if(cDirection == (sixDirect[5])){
            cDirection = sixDirect[0];
        }

    }

    public void rotateTopRight(int cDirection){

        if(cDirection == (sixDirect[0])) {
            cDirection = sixDirect[5];
         }
         else if(cDirection == (sixDirect[1])){
            cDirection = sixDirect[0];
        }
        else if(cDirection == (sixDirect[2])){
            cDirection = sixDirect[1];

        }else if(cDirection == (sixDirect[3])){
            cDirection = sixDirect[2];

        }else if(cDirection == (sixDirect[4])){
            cDirection = sixDirect[3];

        }else if(cDirection == (sixDirect[5])){
            cDirection = sixDirect[4];
        }

    }



    /* General Command */

    public void stepForward(Maze maze, int cDirection){

            current = current.neigh[cDirection]; 
            maze.drawFtPrt(current);
        visitedCells.add(current);
        steps++;

    }


    public int Shuffle(Maze maze){

        int ranVal;

        if(maze.type == Maze.NORMAL || maze.type == Maze.TUNNEL){

            ranVal = ran.nextInt(fourDirect.length);
              return fourDirect[ranVal];
        }

        else{

            ranVal = ran.nextInt(sixDirect.length);
              return sixDirect[ranVal];
        }
    
    }


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





} // end of class WallFollowerSolver
