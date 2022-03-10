// Team Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz)
// APCS pd6
// HW72: All About the About Face
// 2022-03-09
// time spent: 0.75 hours

/***
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):
 * If the length of the section of interest is 1, it's sorted, so return it.
 * Otherwise, partition the section of interest and sort the two sections.
 *  If s ends up at 0, that means one of the sections has length 0, so only sort
 *  the right section.
 *  s will never end up at the last index unless the array is already sorted, so
 *  this is not a problem.
 * 2a. Worst pivot choice and associated run time:
 *  The minimum or maximum; O(n^2), since a partition would be done for every
 *  element in the array.
 * 2b. Best pivot choice and associated run time:
 *  The median; O(nlogn), since the array would be divided in halves
 *  repetitively until each half had length 1, and an partition would be done
 *  for each division.
 * As described in the javadoc for Partition.partition(), we have no way of
 * intentionally choosing the middle value (or any value) each time when
 * choosing the pvtPt. It's just luck.
 * 3. Approach to handling duplicate values in array:
 *  Duplicates are treated as distinct values. Throughout the recursive sorts,
 *  they will always end up to the left of the other whenever the other is
 *  chosen as a pivot. Eventually, they will end up adjacent to each other as
 *  the sections of interest being sorted grow smaller and smaller and are
 *  partitioned.
 **/

public class QuickSort
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
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   */
  public static void qsort( int[] d )
  {
    qsortHelp(d, 0, d.length-1);
  }

  public static void qsortHelp( int[] d, int loPos, int hiPos)
  {
    if (loPos == hiPos) { return; }
    else {
      int s = Partition.partition(d, loPos, hiPos);
      qsortHelp(d, s, hiPos);
      if (s != 0) {
        qsortHelp(d, loPos, s-1);
      }
    }
  }






  //main method for testing
  public static void main( String[] args )
  {

    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);
    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);
    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;
    System.out.println("\narrN init'd to: " );
    printArr(arrN);
    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);
    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);
        /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);
    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);
    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );
    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);
    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);
    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
      /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    //best case:
    //the last element (the pivot) is always the median of the half after
    // partition()
    int[] arr3 = {1, 2, 5, 4, 3};
    System.out.println("\narr3 init'd to: ");
    printArr(arr3);
    qsort( arr3 );
    System.out.println("arr3 after qsort: ");
    printArr(arr3);

    //worst case:
    //the last element (the pivot) is always the maximum of the half after
    // partition()
    //(minimum would be just as bad)
    int[] arr4 = {1, 2, 3, 4, 5};
    System.out.println("\narr4 init'd to: ");
    printArr(arr4);
    qsort( arr4 );
    System.out.println("arr4 after qsort: ");
    printArr(arr4);

  }//end main

}//end class QuickSort
