// Team Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz)
// APCS pd6
// HW72: All About the About Face
// 2022-03-09
// time spent: 0.75 hours

/***
 * class Parition (née Mysterion)
 *
 * <h1>MYSTERION is PARTITION</h1>
 * The Mysterion method ... <YOUR TRIO'S DESCRIPTION HERE>
 * <p>
 * <b>Note:</b> BLAH blah blah, yakkety schmakketty...
 * @author  Trey Parker, Matt Stone
 * @version 3.1415926535897932384626433
 * @since   2022-03-08t
 *
 * algo as pseudocode:
 * ------------------------------
 *     v = arr[c]
 *     swap arr[c], arr[b]
 *     s = a
 *     for i in [a..b-1]
 *         if arr[i] < v
 *             swap arr[s], arr[i]
 *             s+=1
 *     swap arr[b], arr[s]
 **/


public class Partition
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o )
  {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a )
  {
    for ( int o : a )
      System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d )
  {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
      tmp = d[i];
      swapPos = i + (int)( (d.length - i) * Math.random() );
      swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal )
  {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
      retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------


  /**
   * int partition(int[],int,int,int)
   * The pvtPos is the same as the hiPos.
   * Because on either side of any previous pvtVal(s) the array is unsorted,
   * there is no way to know whether a chosen pvtVal will end up being in the
   * middle after the array is partitioned without actually trying it out.
   * Similarly, there is no way to choose a pvtPos that corresponds to the
   * pvtVal that ends up in the middle after partitioning without using trial
   * and error to find it.
   * So, it is simpler and more time-efficient to just choose a convention for
   * deciding an arbitrary pvtPos and keeping consistent. We (arbitrarily)
   * chose to have the pvtPos be the last value in the array section of interest.
   *
   * @param arr input array of ints
   * @param loPos
   * @param hiPos
   * @param pvtPos //removed after refactoring
   * @return int position of
   *
   */
  public static int partition( int arr[], int loPos, int hiPos)
  {
    int v = arr[hiPos]; //hiPos = pvtPos (arbitrary)

    // swap( pvtPos, hiPos, arr); //no longer necessary (swaps w/ itself)
    int s = loPos;

    for( int i = loPos; i < hiPos; i++ ) {
      if ( arr[i] <= v) {
        swap( i, s, arr );
        s++;}
    }
    swap(s,hiPos,arr);

    return s;
  }//end partition


  //main method for testing
  public static void main( String[] args )
  {

    //init test arrays of magic numbers
    int[] arr1 = {8,21,17,69,343};
    int[] arr3 = {1,28,33,4982,37};
    int[] arr4 = {5,4,17,9000,6};
    int[] arr5 = {3,0,16,599,1024};


    // run partition on each array,
    // holding loPos & hiPos fixed, varying pvtPos...
    //for( int testPIVOT = 0; testPIVOT < 5; testPIVOT++ ) {
      System.out.println("arr1: ");
      printArr(arr1);
      //partition(arr1,0,4,testPIVOT);
      partition(arr1,0,4); //refactored
      System.out.println("after partition w/ loPos=0, hiPos=4, pvtPos="
                         + "hiPos" +"...");
      printArr(arr1);
      System.out.println("-----------------------");

      System.out.println("arr3:");
      printArr(arr3);
      //partition(arr3,0,4,testPIVOT);
      partition(arr3,0,4); //refactored
      System.out.println("after partition w/ loPos=0, hiPos=4, pvtPos="
                         + "hiPos" +"...");
      printArr(arr3);
      System.out.println("-----------------------");

      System.out.println("arr4:");
      printArr(arr4);
      //partition(arr4,0,4,testPIVOT);
      partition(arr4,0,4); //refactored
      System.out.println("after partition w/ loPos=0, hiPos=4, pvtPos="
                         + "hiPos" +"...");
      printArr(arr4);
      System.out.println("-----------------------");

      System.out.println("arr5:");
      printArr(arr5);
      //partition(arr5,0,4,testPIVOT);
      partition(arr5,0,4); //refactored
      System.out.println("after partition w/ loPos=0, hiPos=4, pvtPos="
                         + "hiPos" +"...");
      printArr(arr5);
      System.out.println("-----------------------");
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    //}
  }//end main

}//end class Partition
