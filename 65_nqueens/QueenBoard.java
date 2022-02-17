/*
Team JEA: Jacob Kirmayer, Ethan Lam, Ariella Katz, Jacob Jr., Carl, Tom
APCS
HW65: How Many Queens Can a Thinker Place, If a Thinker Can Place Queens...
2022-02-16
time spent: 0.5hrs
*/

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Transcribe your KtS verbiage into block comments preceding each method where necessary.
 * 2. Implement solver method.
 */

public class QueenBoard
{

  private int[][] _board;

  public QueenBoard( int size )
  {
    _board = new int[size][size];
  }


  /***
   * precondition: board is filled with 0's only.
   * postcondition:
   * If a solution is found, board shows position of N queens,
   * returns true.
   * If no solution, board is filled with 0's,
   * returns false.
   */
  public boolean solve()
  {
    return solveH(0);
  }


  /**
   *Helper method for solve.
   */
  private boolean solveH( int col )
  {
    // if you've found a square for a queen in every column and
    //have thus gotten to the end of the board, return true
    if ( col == _board[0].length) { return true; }
    else {
      for (int i = 0; i < _board.length; i++) {
        // if there is a square in column col where a queen can
        //be added, add it and try the next column. If it can be
        //solved by adding a queen to any space in the next column
        //(and all the columns afterwards, recursively), return true.
        //If it can't, return false.
        if (addQueen(i, col)) {
          if (solveH(col+1)) { return true; }
          else { removeQueen(i, col); }
        }
      }
      return false;
    }
  }


  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
    solve();
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        if (_board[r][c] == 1) { ans += "0\t"; }
        else { ans += "-\t"; }
        }
      ans += "\n";
    }
    System.out.println(ans);
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * Adds a queen at the given square and adds all resulting danger areas
   * precondition: There are no queens already added to the right or in the same column
   * postcondition: The value at the queen's square is 1 and the values of all squares
   * diagonally right or horizontally right are decremented by 1
   */
  private boolean addQueen(int row, int col)
  {
    if(_board[row][col] != 0){
      return false;
    }
    _board[row][col] = 1;
    int offset = 1;
    while(col+offset < _board[row].length){
      _board[row][col+offset]--;
      if(row - offset >= 0){
        _board[row-offset][col+offset]--;
      }
      if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
      }
      offset++;
    }
    return true;
  }


  /***
   * Removes a queen from the given square and gets rid of any previously resulting danger
   * precondition:
   * postcondition: The value at that square is 0 and the values of all squares
   * diagonally right or horizontally right are incremented by 1
   */
  private boolean removeQueen(int row, int col){
    if ( _board[row][col] != 1 ) {
      return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
      _board[row][col+offset]++;
      if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
      }
      if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
      }
      offset++;
    }
    return true;
  }


  /***
   * Returns a chessboard as a String
   * precondition:
   * postcondition:
   */
  public String  toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
      for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
      }
      ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    System.out.println(b);
    /** should be...
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
       0	0	0	0	0
    */

    b.addQueen(3,0);
    b.addQueen(0,1);
    System.out.println(b);
    /** should be...
       0	1	-1	-2	-1
       0	0	-2	0	0
       0	-1	0	-1	0
       1	-1	-1	-1	-2
       0	-1	0	0	0
    */

    b.removeQueen(3,0);
    System.out.println(b);
    /** should be...
       0	1	-1	-1	-1
       0	0	-1	0	0
       0	0	0	-1	0
       0	0	0	0	-1
       0	0	0	0	0
    */

    QueenBoard two = new QueenBoard(2);
    //System.out.println(two.solve());
    two.printSolution();

    QueenBoard eight = new QueenBoard(8);
    //System.out.println(eight.solve());
    eight.printSolution();

    QueenBoard nine = new QueenBoard(9);
    nine.printSolution();

    QueenBoard ten = new QueenBoard(10);
    ten.printSolution();

    QueenBoard eleven = new QueenBoard(11);
    eleven.printSolution();

    QueenBoard twelve = new QueenBoard(12);
    twelve.printSolution();

    QueenBoard thirteen = new QueenBoard(13);
    thirteen.printSolution();

  }

}//end class
