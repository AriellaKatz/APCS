/*
Ariella Katz, Tom
APCS
HW54 -- One File to Bring Them All...
2022-01-11
*/

import java.util.ArrayList;

public class MySorts {

/*
Exit-Early BubbleSort Algo:
Starting with the two leftmost elements, compare the two.
If the right element is less than or equal to the left element,
 swap them.
Repeat the previous two steps for all pairs of consecutive elements
 from left to right.
Repeat the previous steps until either:
 no swaps are made in the previous pass (exit early)
 there have been n passes
*/
  public static void exitBubble(ArrayList<Comparable> data) {
    for(int passes = 0; passes < data.size(); passes++) {
          boolean sorted = true;
          for(int index = data.size()-1; index > passes; index--) {
            if(data.get(index).compareTo(data.get(index-1)) <= 0) {
              Comparable temp = data.get(index);
              data.set(index, data.get(index-1));
              data.set(index-1, temp);
              sorted = false; // flags whether a swap happens
            }
          }
          if(sorted) {
            break;
          }
        }
      }

/*
InsertionSort Algo:
Begin with the partition "at" the first element.
 (All elements "at" the partition and to the left are sorted.)
Move the partition one to the right.
"Walk" the element now to the immediate left of the partition to
 its proper place in the sorted region.
Repeat this process, moving the partition to the right until it
 is "at" the last element.
*/
  public static void insertion(ArrayList<Comparable> data) {
    for(int partition = 1; partition < data.size(); partition++) {
      //partition marks first item in unsorted region
      //a pass in insertion is considered one walk through a
      // partitioned region

      //traverse sorted region from right to left
      for(int i = partition; i > 0; i--) {
        // "walk" the current item to where it belongs
        // by swapping adjacent items
        if ((data.get(i).compareTo(data.get(i-1)))<0) {
          Comparable x = data.get(i-1);
          data.set(i-1, data.get(i));
          data.set(i, x);
        }
        else
          break;
        }
      }
    }

/*
SelectionSort Algo:
Conduct a linear search for maximum value in the ArrayList
 and record its index.
Swap the maximum value with the value farthest to the right.
Repeat this process, excluding any previous maximums from
 the Arraylist.
*/
  public static void selection(ArrayList<Comparable> data) {
    int maxPos = 0;
    for(int pass = 0; pass < data.size(); pass++) {
        maxPos=0;
      for(int i = 0; i < data.size()-pass; i++ ) {
        if (data.get(i).compareTo(data.get(maxPos))>0) {
          maxPos = i;
        }
      }
      Comparable x= data.get(data.size()-1-pass);
      data.set(data.size()-1-pass, data.get(maxPos));
      data.set(maxPos, x);
    }
  }

}
