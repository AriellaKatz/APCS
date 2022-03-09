// Team Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz)
// APCS pd6
// HW72: So So Fast
// 2022-03-08
// Time spent: 2 hours

//Our current code does not work. We spent several hours on this code, and it is
//now time to prioritize sleep/other assignments.

/*
DISCO
We have to realize that the yth element is the y -1 index.
When you run partition it changes the original array because of swap
Everytime you call partition, even in an if statement, the array will change so you have to call it right at the beginning.
The position of a pivot value can not change in subsequent partitions.
QCC
This is similar to binary search but we can use an unsorted list.
If java is pass by value, how come after fastSelect is run, the original array is coming out sorted. *answer: swap is changing the array*
It doesn't matter what we use as the pivot because the S value(place of the partition) is what we care about.
To stay consistent we'll use the last index as the pivot whenever we use partition.
ALGO
Run partition on the array with the last index being the pivot. If S (place of the partition) = y then return the pivot value. Else:
    - If S is less than y, we know that the values on the left of s are also smaller than y so we need to look at the values to the right of s.
        -Run partition again but change the range from s to the end and subtract s from y.
    - If S is more than y, we know that the values on the right of s are also greater than y so we need to look at the values to the left of s.
        - Run partition again but change the range from beginning to s-1
BEST CASE SCENARIO: After first partition the yth value is found. In our case the yth value is last item.
WORST CASE SCENARIO: After n partitions the yth value is found. In our case,after every partition, the yth value always goes at least 2 infront of the last item?
Include test cases in main() method illustrating each best- and worst-case scenario.
*/

public class FastSelect{

     private static int[] foo = {7,1,5,12,3};
     private static int[] temper = {1,3,5,12,7};
     private static int[] foo1 = {7,1,5,12,3};
     private static int[] foo2 = {7,1,5,12,3};
     private static int[] foo3 = {7,1,5,12,3};
     private static int[] foo4 = {7,1,5,12,3};

     public static void swap( int x, int y, int[] o ){
        int tmp = o[x];
        o[x] = o[y];
        o[y] = tmp;
     }

    //print input array
    public static void printArr( int[] a ){
        for ( int o : a )
            System.out.print( o + " " );
            System.out.println();
    }

  //shuffle elements of input array
    public static void shuffle( int[] d ){
        int tmp;
        int swapPos;
        for( int i = 0; i < d.length; i++ ) {
            tmp = d[i];
            swapPos = i + (int)( (d.length - i) * Math.random() );
            swap( i, swapPos, d );
        }
    }

  //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ){
        int[] retArr = new int[s];
        for( int i = 0; i < retArr.length; i++ )
            retArr[i] = (int)( maxVal * Math.random() );
        return retArr;
    }

    public static int partition( int arr[], int first, int end, int pivot){
	    printArr(arr);
	    int v = arr[pivot];
		  swap(pivot, end, arr);
		  int s = first;  //where the pivot will end up at the end of function aka where the array is split

		for(int i = first; i < end-1; i++){               //i HAS TO EQUAL FIRST NOT 0
			if(arr[i] < v){
				swap(i, s, arr);
				s++;
			}
		}
		swap(end, s, arr);
		printArr(arr);
		return s;
    }

    public static int fastSelect(int y, int array[], int first, int end, int pivot){
        int s = 0;
        //int length = array.length - 1;
        printArr(array);
        //System.out.println();
        int piv_Value = array[pivot];
        s = partition(array, first, end, pivot); // s is index of pivot value after partition

        // if(partition(array, first, end, pivot) < (y - 1)){            // y-1 because the yth element is the y - 1 index.
        //     s = partition(array, first, end, pivot);
        //     return fastSelect(y-s,array, s+1, length, length);
        //
        // }else if(partition(array, first, end, pivot) > (y - 1) ){
        //     s = partition(array, first, end, pivot);
        //     return fastSelect(y, array, first, s-1, s-1);

        if(s == (y-1)){
            return piv_Value;
        }else if(s < (y -1)){ //index of pivot less than where you want it
            return fastSelect(y-s, array, s, end, end);
        }else{// index of pivot greater than where you want it                                                          //if(s > (y - 1) )
            return fastSelect(y, array, first, s-1, s-1);
        }



        // // assuming pivot value starts at the end
        // for(int i = array.length-1; i >= 0; i --){
        //   s = partition(array, first, end, i);
        //   if (s == (y-1)){
        //     return piv_Value;
        //   }
        // } return -1;
    }

    public static void main(String[] args){
	//	System.out.println(partition(foo, 0, 4, 4));
  //  System.out.println(partition(temper, 2, 4, 4));

    //System.out.println();
		//System.out.println(fastSelect(3, foo, 0, 4, 2));

    System.out.println(fastSelect(1, foo, 0, 4, 4));
    //printArr(foo);
    System.out.println();
    System.out.println(fastSelect(2, foo1, 0, 4, 4));
    System.out.println();
    System.out.println(fastSelect(3, foo2, 0, 4, 4));
    System.out.println();
    System.out.println(fastSelect(4, foo3, 0, 4, 4));         // doesn't work
    System.out.println();
    System.out.println(fastSelect(5, foo4, 0, 4, 4));         // doesn't work



	}
}
