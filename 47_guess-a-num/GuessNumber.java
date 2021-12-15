// ABA - Ariella Katz, Alif Rahman, Brianna Tieu, Tom, Grippy, Pepe
// APCS
// HW47 -- Guess Again
// 2021-12-14
// time spent: 0.5 hrs

/***
 * class GuessNumber -- fun fun fun!
 *
 * eg, sample interaction with end user:
 *
 * Guess a # fr 1-100: 50
 * Too high
 * Guess a # fr 1-49: 25
 * Too low
 * Guess a # fr 26-49: 38
 * Correct! It took 3 guesses
 ***/

/*
DISCO:
0. Using true as the condition for a while loop causes it to run until it
   sees the command break.
1. break is used for exiting a loop while return is used for exiting the
   invocation of a method. If the entire method is a loop, either could be
   used.
QCC:
0. Are there problems where there might be both a recursive and an iterative
   solution but one is more efficient than the other for any/all cases?
*/

import java.util.Scanner;

public class GuessNumber
{

  //instance vars
  private int _lo, _hi, _guessCtr, _target;
  Scanner sc = new Scanner( System.in );


  /*==================================================
    constructor -- initializes a guess-a-number game
    pre:
    post: _lo is lower bound, _hi is upper bound,
    _guessCtr is 1, _target is random int on range [_lo,_hi]
    ==================================================*/
  public GuessNumber( int a, int b )
  {
    _lo = Math.min(a,b);
    _hi = Math.max(a,b);
    _guessCtr = 1;

    //pick random number in range [a,b]

    _target = (int)(Math.random() * (_hi - _lo)) + _lo;
  }


  /*==================================================
    void playRec() -- Prompts a user to guess until guess is correct.
    Uses recursion.
    ==================================================*/
  public void playRec()
  {
    System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
    int guess = sc.nextInt();

    //3 cases: we either found it, too hi, too lo

    if (guess == _target) {
      System.out.println("Correct! It took " + _guessCtr + " guesses");
    }
    else if (guess > _target) {
      _guessCtr++;
      _hi = guess - 1;
      System.out.println("Too high");
      if (_hi == _lo) {
        System.out.println("You've failed! The correct number was " + _target);
        return;
      }
      playRec();
    }
    else {
      _guessCtr++;
      _lo = guess + 1;
      System.out.println("Too low");
      if (_hi == _lo) {
        System.out.println("You've failed! The correct number was " + _target);
        return;
      }
      playRec();
    }
  }


  /*==================================================
    void playIter() -- Prompts a user to guess until guess is correct.
    Uses iteration.
    ==================================================*/
  public void playIter()
  {

    int guess;

    while( true ) {
      System.out.print("Guess a num bt " + _lo + " & " + _hi + ": ");
      guess = sc.nextInt();

      //3 cases: we either found it, too hi, too lo

      if (guess == _target) {
        System.out.println("Correct! It took " + _guessCtr + " guesses");
        break;
      }
      else if (guess > _target) {
        System.out.println("Too high");
        _hi = guess - 1;
        if (_hi == _lo) {
          System.out.println("You've failed! The correct number was " + _target);
          _guessCtr++;
          break;
        }
      }
      else {
        System.out.println("Too low");
        _lo = guess + 1;
        if (_hi == _lo) {
          System.out.println("You've failed! The correct number was " + _target);
          _guessCtr++;
          break;
        }
      }

      _guessCtr++;
    }
  }


  //wrapper for playRec/playIter to simplify calling
  public void play()
  {
    //use one or the other below:
    //playRec();
    playIter();
  }


  //main method to run it all
  public static void main( String[] args )
  {

    //instantiate a new game
    GuessNumber g = new GuessNumber(1,100);
    //start the game
    g.play();
    /*-----------------------------
    -----------------------------*/
  }

}//end class GuessNumber
