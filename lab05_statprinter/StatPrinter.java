// Team JEA (Jacob Kirmayer, Ethan Lam, Ariella Katz, Jacob Jr, Carl, Tom)
// APCS pd6
// L05 -- Stats on Stats
// 2022-02-03r
// time spent:   0.5 hrs



/**
   An AP-style question, for practice...
   GOAL: Write the StatPrinter class below.
   WHAT YOU NEED TO KNOW:
   The StatPrinter Object receives an
   ArrayList of nonnegative integers, then builds a frequency ArrayList in which
   the index values are the data and the entry at the index is the frequency.
   For example, if the received data is    2,3,2,5,1,3    then the frequency
   list would be [0,1,2,2,0,1]. This is read as 0 zeroes, 1 one, 2 twos,
   2 threes, 0 fours, 1 five. The size of the frequency list is the equal to
   the maximum value of the data.
   A capability of the class is to calculate local modes from the frequency
   list. A local mode is a value that is greater than the value at index-1
   and greater than the value at index+1. A local mode is never at the end
   points of the list. For example, if the frequency list is [1,2,1,4,2,3,5]
   then the local modes are 2 and 4.
   This class is also capable of printing a histogram of the frequencies, using
   '*'s to indicate a frequency amount. To print a histogram, the user specifies
   the longest sequence of '*'s used and then all other values are printed in
   proportion to this value. For example, if longest bar is 10 and the frequency
   list is [1,2,1,4,2,3,5] then the histogram printed looks like this:
   0 : **
   1 : ****
   2 : **
   3 : ********
   4 : ****
   5 : ******
   6 : **********
   For each method, state run time efficiency using Big O notation.
   TIPS FOR AWESOME:
   * Keys to Success were so named (by Thinkeren) for a reason.
   * Look over all fxns, think a bit, decide which to tackle first.
   ( Simplest?  Prerequisites? . . . )
   * Develop 1 fxn at a time, test it, then move to next.
   * Initially, what extra code do you need to get past compiler?
   **/

import java.util.ArrayList;


public class StatPrinter
{
  // instance variable for frequencies of each integer in input ArrayList
  private ArrayList <Integer> _frequency;


  //*************** QUESTION 02 **************************
  //precond:  data.size() > 0, each entry b/t 0,100 inclusive
  //postcond: _frequency.size() set to max(data) + 1
  //          _frequency.get(i) returns frequency of i in data
  //eg, for data [2,3,2,5,2,3]
  //  _frequency would be [0,0,3,2,0,1]
  public StatPrinter( ArrayList <Integer> data )
  {
    //O(n)
    _frequency = new ArrayList<Integer>(max(data)+1);
    //start with frequencies of 0 for all numbers
    for (int n = 0; n < max(data)+1; n++) {
      _frequency.add(0);
    }
    // for each number in data, increment the frequency at the
    //corresponding index of _frequency
    for (int i = 0; i < data.size(); i ++){
      int element = data.get(i);
      int freq = _frequency.get(element);
      _frequency.set(element, freq+1);
    }
  }



  //*************** QUESTION 01 **************************
  //precond:  data.size() > 0
  //postcond: returns largest integer in data
  public Integer max( ArrayList <Integer> data )
  {
    //O(n)
    Integer max = 0;
    // traverse data, updating the max whenever a greater element
    //is found
    for (int i = 0; i < data.size(); i++) {
      Integer element = data.get(i);
      if (element.compareTo(max) > 0) {
        max = element;
      }
    }
    return max;
  }


  //*************** QUESTION 03 **************************
  //postcond: returns true if i > 0 and i < _frequency.size() - 1
  //          and _frequency.get( i - 1 ) < _frequency.get( i )
  //          and _frequency.get( i + 1 ) < _frequency.get( i )
  //          Otherwise, returns false
  //eg, for _frequency [1,2,1,5,5,8,2,4]
  //    2 and 8 are local modes, so
  //    isLocalMode(0) -> false
  //    isLocalMode(1) -> true
  //    isLocalMode(5) -> true
  public boolean isLocalMode( int i )
  {
    //O(1)
    // literally just return the truth value of all the criteria in
    //the postcond
    return ((i > 0) &&
    (i < _frequency.size()-1) &&
    (_frequency.get(i-1) < _frequency.get(i)) &&
    (_frequency.get(i+1) < _frequency.get(i)));
  }


  //*************** QUESTION 04 **************************
  //postcond: returns list of modes in _frequency
  public ArrayList<Integer> getLocalModes()
  {
    //O(n)
    ArrayList<Integer> list = new ArrayList<Integer>(_frequency.size()/2); //bc less than half of the numbers are local modes
    // traverse _frequency, checking each frequency to see if it's a
    //local mode, and add it to the list of modes if it is
    int i = 1; //bc element 0 can't be a local mode
    while (i < _frequency.size()-1) { //bc the last element can't be a local mode
      if (isLocalMode(i)) {
        list.add(i);
        i = i+2; //if it is a local mode, the next one definitely won't be, so skip it
      }
      else {
        i++;
      }
    }
    return list;
  }


  //*************** QUESTION 05 **************************
  //precond:  longestBar > 0
  public void printHistogram( int longestBar )
  {
    //O(n^2)
    String s = "";
    // for each number btwn 0 and max (for every index in _frequency),
    //create a new line starting with index : , followed by the
    //proportional number of stars
    for (int i = 0; i < _frequency.size(); i++) {
      s += i + " : ";
      // calculate the number of stars for each frequency
      int numStars = (longestBar * _frequency.get(i) / max(_frequency));
      // add the stars to the string one at a time
      for (int x = 0; x < numStars; x++) {
        s += "*";
      }
      s += "\n"; //remember to make a new line!
    }
    System.out.println(s);
  }

 }//end class StatPrinte
