// Team Dysentery: Ameer Alnasser, Ethan Lam, Ariella Katz, Tom, Carl, TurtleBoi
// APCS
// HW69: Making Sense
// 2022-03-03
// time spent: 0.5 hrs

/***
 * SKEELTON for
 * class MazeSolver
 * Implements a blind depth-first exit-finding algorithm.
 * Displays probing in terminal.
 *
 * USAGE:
 * $ java Maze [path/to/mazefile]
 * (mazefile is ASCII representation of a maze, using symbols below)
 *
 * ALGORITHM for finding exit from starting position:
 * 1) Is the current space the exit?
 *   Yes: You're done!
 *   No:
 *   A) Is it on the path?
 *     Yes:
 *       i) Have you tried moving in all possible directions?
 *         Yes: This location failed. Go back
 *         No:
 *           a) Move up, to the left, down, or to the right (depending on what
 *           you've already tried)
 *           b) Repeat from Step 1)
 *     No:
 *       ii) Go back
 *
 * DISCO
 * We don't need to place @s in our mazes since that is the entire premise of our maze solver: place a start position and find a solutionf rom there
 *
 * QCC
 * We still do not undertsand what makes a maze difficult.
 * Is there anything that would render our maze solver to be in an infinite loop?
 * How would we optimize this solution to find a solution quicker?
 * breadth or depth?
 ***/

//enable file I/O
import java.io.*;
import java.util.*;


class MazeSolver
{
  final private int FRAME_DELAY = 50;

  private char[][] _maze;
  public int h, w; // height, width of maze *made public for rando drop
  private boolean _solved;

  //~~~~~~~~~~~~~  L E G E N D  ~~~~~~~~~~~~~
  final private char HERO =           '@';
  final private char PATH =           '#';
  final private char WALL =           ' ';
  final private char EXIT =           '$';
  final private char VISITED_PATH =   '.';
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  public MazeSolver( String inputFile )
  {
    // init 2D array to represent maze
    // (80x25 is default terminal window size)
    _maze = new char[80][25];
    h = 0;
    w = 0;

    //transcribe maze from file into memory
    try {
      Scanner sc = new Scanner( new File(inputFile) );

      System.out.println( "reading in file..." );

      int row = 0;

      while( sc.hasNext() ) {

        String line = sc.nextLine();

        if ( w < line.length() )
          w = line.length();

        for( int i=0; i<line.length(); i++ )
          _maze[i][row] = line.charAt( i );

        h++;
        row++;
      }

      for( int i=0; i<w; i++ )
        _maze[i][row] = WALL;
      h++;
      row++;

    } catch( Exception e ) { System.out.println( "Error reading file" ); }

    //at init time, maze has not been solved:
    _solved = false;
  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, ESC
    //ms.solve( startX, startY );
    //emacs shortcut: M-x quoted-insert, ESC

    int i, j;
    for( i=0; i<h; i++ ) {
      for( j=0; j<w; j++ )
        retStr = retStr + _maze[j][i];
      retStr = retStr + "\n";
    }
    return retStr;
  }


  /**
   * helper method to keep try/catch clutter out of main flow
   * @param n      delay in ms
   **/
  private void delay( int n )
  {
    try {
      Thread.sleep(n);
    } catch( InterruptedException e ) {
      System.exit(0);
    }
  }


  /**
   * void solve(int x,int y) -- recursively finds maze exit (depth-first)
   * @param x starting x-coord, measured from left
   * @param y starting y-coord, measured from top
   **/
  public void solve( int x, int y )
  {
    delay( FRAME_DELAY ); //slow it down enough to be followable

    if ( _solved == true ) { System.exit(0); }
    //primary base case
    if ( _maze[y][x] == EXIT ) {
      _solved = true;
      System.out.println(_maze);
      System.exit(0);
    }
    //other base cases
    else if ( _maze[y][x] != PATH ) {
	    return;
    }
    //otherwise, recursively solve maze from next pos over,
    //after marking current location
    else {
	    _maze[y][x] = HERO;
      System.out.println( this ); //refresh screen
      solve(x+1,y); //move up
      solve(x,y+1); //move right
      solve(x-1,y); //move down
      solve(x,y-1); //move left
      System.out.println( this ); //refresh screen
      _maze[y][x] = VISITED_PATH;
      return;
    }
  }

  //accessor method to help with randomized drop-in location
  public boolean onPath( int x, int y) {
    return (_maze[y][x] == PATH);
  }

}//end class MazeSolver


public class Maze
{
  public static void main( String[] args )
  {
    String mazeInputFile = null;

    try {
      mazeInputFile = args[0];
    } catch( Exception e ) {
      System.out.println( "Error reading input file." );
      System.out.println( "USAGE:\n $ java Maze path/to/filename" );
    }

    if (mazeInputFile==null) { System.exit(0); }

    MazeSolver ms = new MazeSolver( mazeInputFile );

    //clear screen
    System.out.println( "[2J" );

    //display maze
    System.out.println( ms );

    //drop hero into the maze (coords must be on path)

    // ThinkerTODO: comment next line out when ready to randomize startpos
    //ms.solve( 4, 3 );

    int startX = 0;
    int startY = 0;
    //drop our hero into maze at random location on path
    while(!ms.onPath(startX, startY)) {
      startX = (int) (Math.random() * ms.h);
      startY = (int) (Math.random() * ms.w);
    }
    ms.solve( startX, startY );
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class Maze
