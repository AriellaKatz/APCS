/*
ABA - Ariella Katz, Alif Rahman, Brianna Tieu, Tom, Grippy, Pepe
APCS
HW 48 - Halving the Halves
2021-12-15
time spentL 0.5hrs
*/

/*
DISCO:
0. By replacing m with lo or hi, depending on what half the target is in,
   lo and hi gradually approach each other, and the idea is that eventually,
   we'll either guess the correct element at m, or eventually lo and hi will
   be equal and the target will be there, or worse case, lo and hi will
   surpass each other, which would mean that the target was never there.
QCC:
0. It's ok for lo to = high as long as neither surpasses the other.
1. Would the iterative or recursive version be more efficient?
2. Is Comparable just an umbrella term for things that have numerical
   values (Integers/ints, Doubles/doubles, Bytes/bytes, Shorts/shorts,
   Longs/longs, Floats/floates; everything except Booleans/booleans and
   Chars/chars)?
*/

/**
   class BinSearch
   Binary search on array of Comparables
**/

public class BinSearch
{

  /**
     int binSearch(Comparable[],Comparable) -- searches an array of
     Comparables for target Comparable
     pre:  input array is sorted in ascending order
     post: returns index of target, or returns -1 if target not found
  **/
  public static int binSearch ( Comparable[] a, Comparable target )
  {
    //uncomment exactly 1 of the 2 stmts below:

    return binSearchIter( a, target, 0, a.length-1 );
    //return binSearchRec( a, target, 0, a.length-1 );
  }


  public static int binSearchRec( Comparable[] a,
                                  Comparable target,
                                  int lo, int hi )
  {

    int tPos = -1; //init return var to flag value -1

    int m = (lo + hi) / 2; //init mid pos var

    if (lo > hi) { return tPos; }

    if (a[m].compareTo(target) == 0) { return m; }
    else if (a[m].compareTo(target) > 0) { return binSearchRec(a, target, lo, m-1); }
    else { return binSearchRec(a, target, m+1, hi); }

  }//end binSearchRec


  public static int binSearchIter( Comparable[] a,
                                   Comparable target,
                                   int lo, int hi )
  {

    int tPos = -1; //init return var to flag value -1
    int m = (lo + hi) / 2; //init mid pos var

    while( hi >= lo ) { // run until lo & hi cross
      // update mid pos var
      m = (lo + hi) / 2;
      // target found
      if (a[m].compareTo(target) == 0) { return m; }
      // value at mid index higher than target
      else if (a[m].compareTo(target) > 0) { hi = m - 1; }
      // value at mid index lower than target
      else { lo = m + 1; }

    }

    return tPos;

  }//end binSearchIter



  //tell whether an array is sorted in ascending order
  private static boolean isSorted( Comparable[] arr )
  {

    boolean retBoo = true; //init to true, assume array is sorted

    //Q: Why would a FOREACH loop not suffice here?
    //A: Because it would try to compare the last element to an element at
    //   the next index, which would throw an OutOfBounds error.
    for( int i=0; i < arr.length-1; i++ ) {
      if ( ( arr[i].compareTo(arr[i+1]) > 0 ) ) {
        return false;
      }
    }
    return retBoo; //if entire array was traversed, it must be sorted
  }


  // utility/helper fxn to display contents of an array of Objects
  private static void printArray( Comparable[] arr ) {
    String output = "[ ";

    for( Comparable c : arr )
	    output += c + ", ";

    output = output.substring( 0, output.length()-2 ) + " ]";

    System.out.println( output );
  }



  //main method for testing
  //minimal -- augment as necessary
  public static void main ( String[] args )
  {


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    System.out.println("\nNow testing binSearch on Comparable array...");

    //Declare and initialize array of Comparables
    Comparable[] iArr = { 2, 4, 6, 8, 6, 42 };
    printArray( iArr );
    System.out.println( "iArr1 sorted? -- " + isSorted(iArr) );

    Comparable[] iArr2 = { 2, 4, 6, 8, 13, 42 };
    printArray( iArr2 );
    System.out.println( "iArr2 sorted? -- " + isSorted(iArr2) );
    Comparable[] iArr3 = new Integer[10000];
    for( int i = 0; i < iArr3.length; i++ ) {
    iArr3[i] = i * 2;
    }
//    printArray( iArr3 );
    System.out.println( "iArr3 sorted? -- " + isSorted(iArr3) );
    //search for 6 in array 
    System.out.println( "Expecting 0... " + binSearch(iArr2,2) );
    System.out.println( "Expecting 1... " + binSearch(iArr2,4) );
    System.out.println( "Expecting 2... " + binSearch(iArr2,6) );
    System.out.println( "Expecting 3... " + binSearch(iArr2,8) );
    System.out.println( "Expecting 4... " + binSearch(iArr2,13) );
    System.out.println( "Expecting 5... " + binSearch(iArr2,42) );
    //search for 43 in array 
    System.out.println( "Expecting -1... " + binSearch(iArr2,43) );
    System.out.println( "now testing binSearch on iArr3..." );
    System.out.println( "Expecting 2... " + binSearch(iArr3,4) );
    System.out.println( "Expecting 4... " + binSearch(iArr3,8) );
    System.out.println( "Expecting -1... " + binSearch(iArr3,5) );
    //search for 43 in array 
    System.out.println( "Expecting -1... " + binSearch(iArr3,43) );
    /*----------------------------------------------------
    ====================================================*/


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  }//end main()

}//end class BinSearch2
