//        Team JEA: Jacob Kirmayer, Ethan Lam, Ariella Katz, Jacob Jr., Carl, Tom
//        APCS
//        HW68: ...and T-, Tr-, Tri-, Tries Again Until It's Done
//        2022-03-01
//        Time spent: 1.3 hrs


/***
 * SKELETON
 * class KnightTour (and supporting class TourFinder)
 * Animates generation of a Knight's Tour on a square chess board.
 *
 * USAGE: (default N value: 8)
 * $ javac KnightTour.java
 * $ java KnightTour
 * $ java KnightTour [N]
 *
 *
 * DISCO
 * System.exit stops the program
 * QCC
 * Why was this written with a system.exit function
 * Mean execution times for boards of size n*n:
 * n=5   0.007s    across 10 executions
 * n=6   0.08s    across 10 executions
 * n=7   0.1s    across 10 executions
 * n=8   very many s    across 1 executions
 *
 * POSIX PROTIP: to measure execution time from BASH, use time program:
 * $ time java KnightTour 5
 *
 *ALGO
 *
 * Precond: The board is filled with “zeroes” (no knights have been placed yet)
 * Postcond: The board is either filled with “ones” (a knight has been placed everywhere) or all possible states have been assessed and rejected.
 * On an nxn grid:
 * Choose a starting position
 * Move the knight until
 * No viable moves are left and spaces have still not been traveled to
 * Return to the previous position
 * Repeat step 2
 * If the knight returns to its starting position, choose a new starting position
 * All the spaces have been traveled to
 * The knight can make a tour of the board.
 ***/


import java.io.*;
import java.util.*;


public class KnightTour
{
  public static void main( String[] args )
  {
    int n = 5;

    try {
      n = Integer.parseInt( args[0] );
    } catch( Exception e ) {
      System.out.println( "Invalid input. Using board size "
                          + n + "..." );
    }



    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for fixed starting location, use line below:

      TourFinder tf = new TourFinder( n,System.currentTimeMillis() );

      //clear screen using ANSI control code
//      System.out.println( "[2J" );

      //display board
//      System.out.println( tf );
      tf.findTour( 2, 2, 0 );
      System.out.println( tf );
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //for random starting location, use lines below:
//    int startX = (int) (Math.random()*n)+2;
//    int startY = (int) (Math.random()*n)+2;
//    tf.findTour( startX, startY, 0 );   // 1 or 0 ?
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // PUSHING FARTHER...
    // Systematically attempt to solve from every position on the board?
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  }//end main()

}//end class KnightTour


class TourFinder
{
  //instance vars
  private int[][] _board;
  private int _sideLength; //board has dimensions n x n
  private boolean _solved = false;
  private double start;

  //constructor -- build board of size n x n
  public TourFinder( int n,double _start )
  {
    _sideLength = n;
    start = _start;
    //init 2D array to represent square board with moat
    _board = new int[n+4][n+4];

    //SETUP BOARD --  0 for unvisited cell
    //               -1 for cell in moat
    //---------------------------------------------------------
    for (int i = 0;i<_board.length;i++){
      for (int j = 0; j < _board.length ; j++){
        if (i<2 || j<2 || i>_board.length-3|| j>_board.length-3){
          _board[i][j] = -1;
        }
      }
    }
    //---------------------------------------------------------

  }//end constructor


  /**
   * "stringify" the board
   **/
  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";
    //emacs shortcut: C-q, then press ESC
    //emacs shortcut: M-x quoted-insert, then press ESC
    int i, j;
    for( i=0; i < _sideLength+4; i++ ) {
      for( j=0; j < _sideLength+4; j++ )
        retStr = retStr + String.format( "%3d", _board[j][i] );
      //"%3d" allots 3 spaces for each number
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
   * void findTour(int x,int y,int moves) -- use depth-first w/ backtracking algo
   * to find valid knight's tour
   * @param x      starting x-coord
   * @param y      starting y-coord
   * @param moves  number of moves made so far
   **/
  public void findTour( int x, int y, int moves )
  {
//    delay(50);

    //if a tour has been completed, stop animation
    if ( moves== Math.pow(_board.length-4,2) ) {
      System.out.println( this ); //refresh screen
      System.out.println("reached end");
//      System.out.println(System.currentTimeMillis()-start);
      System.exit(0);
      return;
    }

    //primary base case: tour completed
    //other base case: stepped off board or onto visited cell
    if ( _board[x][y]!=0 ) {
      return;
    }
    //otherwise, mark current location

    //and recursively generate tour possibilities from current pos

    else {
      //mark current cell with current move number
      _board[x][y] = moves+1;
//      System.out.println( this );
      findTour(x+1,y+2,moves+1);
      findTour(x+1,y-2,moves+1);
      findTour(x-1,y+2,moves+1);
      findTour(x-1,y-2,moves+1);
      findTour(x+2,y+1,moves+1);
      findTour(x+2,y-1,moves+1);
      findTour(x-2,y+1,moves+1);
      findTour(x-2,y-1,moves+1);
      //If made it this far, path did not lead to tour, so back up...
      // (Overwrite number at this cell with a 0.)
      _board[x][y] = 0;
//      System.out.println( this );
      if (moves==0){
        System.out.println(System.currentTimeMillis()-start);
        System.exit(0);
      }

      /******************************************
       * Recursively try to "solve" (find a tour) from
       * each of knight's available moves.
       *     . e . d .
       *     f . . . c
       *     . . @ . .
       *     g . . . b
       *     . h . a .
      ******************************************/


    }
  }//end findTour()

}//end class TourFinder
