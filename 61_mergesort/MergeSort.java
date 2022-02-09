/*
Team BAKK - Ariella Katz, Brian Kang, Tom, Vivian
APCS
HW61 - Instructions so Simple...
2021-02-08
time spent: 0.5 hrs
*/

/*
DISCO:
0. It would appear that when an array is passed through a method,
   it is altered. But... see QCC0
QCC:
0. Why is it that in merge(), we had to do a0 = sort(a0) and
   b0 = sort(b0) in order to proceed with sorted versions of a0
   and b0? Just doing sort(a0) and sort(b0) was insufficient,
   which would seem to contradict the hypothesis that passing a0
   and b0 through sort() would actually reorder a0 and b0 instead of
   returning sorted versions of them.
1. How does the arrangement of the code or placement affect the
   output when you run the code?
*/

/***
  class MergeSort
  Implements mergesort on array of ints.
  Summary of Algorithm:
  0. Check if the array is already sorted (if its length is 1).
  1. If it is, you're done.
  2. If it isn't, divide it into two halves, sort those two halves
     using the MergeSort algo (recursion!) and merge the now-sorted
     halves.
***/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
    int[] a0 = a;
    a0 = sort(a0);
    int[] b0 = b;
    b0 = sort(b0);
    int[] output = new int[a0.length + b0.length];
    int i = 0;
    while (a0.length > 0 && b0.length > 0) {
      if (a0[0] < b0[0]) {
        output[i] = a0[0];
        //remove the first element from a0
        int[] temp = new int[a0.length-1];
        for (int m = 0; m < temp.length; m++) {
          temp[m] = a0[m+1];
        }
        a0 = temp;
      }
      else {
        output[i] = b0[0];
        //remove the first element from b0
        int[] temp = new int[b0.length-1];
        for (int n = 0; n < temp.length; n++) {
          temp[n] = b0[n+1];
        }
        b0 = temp;
      }
      i++;
    }
    //if a0 still has elements left over
    if (a0.length > 0) {
      //add the remaining elements in a0
      for (int p = 0; p < a0.length; p++) {
        //index of next element in output:
        int index = output.length - a0.length + p;
        output[index] = a0[p];
      }
    }
    //otherwise, b0 will have elements left over
    else {
      //add the remaining elements in b0
      for (int q = 0; q < b0.length; q++) {
        //index of next element in output:
        int index = output.length - b0.length + q;
        output[index] = b0[q];
      }
    }
    return output;
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
    int[] output = new int[arr.length];
    if (arr.length == 1) {
      return arr;
    }
    else {
      int x = arr.length/2;
      int[] arrA = new int[x];
      int y = (arr.length - arr.length/2);
      int[] arrB = new int[y];

      for (int c = 0; c < arrA.length; c++) {
        arrA[c] = arr[c];
      }

      for (int d = 0; d < arrB.length; d++) {
        arrB[d] = arr[d + x];
      }
      output = merge(sort(arrA), sort(arrB));
      return output;
    }
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  // it appears that whatever happens to a in this method alters
  // the array that is passed through it
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args )
  {

      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};
      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );
      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );
      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr4,arr6) );
      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
     /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class MergeSort
