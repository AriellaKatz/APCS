// Team ABA - Ariella Katz, Alif Rahman, Brianna Tieu, Tom, Grippy, Pepe
// APCS
// HW51 -- implementing bubblesort
// 2022-01-03
// time spent: 0.5 hrs

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 *
 * ALGO:
 * Traverse the array from right to left, swapping as necessary.
 * Repeat until a traversal causes no swaps.
 * DISCO
 * Rather than creating local variable swaps, we could have created 
 * another for loop that repeats for the maximum number of passes 
 * (specified in the QCC section).
 * QCC
 * q0: If a pass requires no swaps, what do you know?
 * a0: It is fully sorted 
 * q1: After pass p, what do you know?
 * a1: The element at index p-1 is correct
 * q2: How many passes are necessary to completely sort?
 * a2: No more than length-1
 * 
 ******************************/

import java.util.ArrayList;

public class BubbleSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond:  lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
      //     offset + rand int on interval [lo,hi]
      retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
      size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    int swaps = 0;
    for (int i = data.size()-1; i > 0; i--) {
      if ((data.get(i)).compareTo(data.get(i-1)) < 0) {
        Comparable temp = data.get(i);
        data.set(i, data.get(i-1));
        data.set(i-1, temp);
        swaps ++;
      }
    }
    if (swaps > 0) { bubbleSortV(data); }
  }


  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
    ArrayList sorted = new ArrayList<Comparable>(input);
    bubbleSortV(sorted);
    return sorted;
  }


  public static void main( String [] args )
  {

    /*===============for VOID methods=============
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      ============================================*/

      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = bubbleSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );
      System.out.println( coco );
    /*==========for AL-returning methods==========
      ============================================*/

  }//end main

}//end class BubbleSort
