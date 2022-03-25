/*
Team Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz, Tom, Preguac, Applesauce)
APCS pd6
HW80: Generically Speaking
2022-03-24
time spent: 0.5 hours
KtS consumed: many
*/

/***
 * class ItrWork
 *  SKELETON
 * Facilitates familiarization with iterators
 **/

 /***
     DISCO
     We have to type cast it.next()
     When we first use .next() it points to the first object in the list
     QCC
     Does iterator have private variables? How does it know what element to remove/ point to ?
     Is there any correlation between scanner and iterator? (next and hasnext methods)
     SUMMARY THE FIRST:
     Similar to nodes, iterator has a next() method that returns the next element (returns an object) in the collection. This is like get next node.
     Iterator also has remove but it's different than the one used in our linked lists (no index). It removes the element that the next() method
     landed on? pointing to? gotten? Finally, theres hasNext() which is new and returns a boolean. It returns true if theres a next element in the collection.
     SUMMARY THE SECOND:
     ItrWork has method foundA which returns a boolean and takes in an Integer parameter and List of Integer as the other parameter. foundA uses a for each loop
     to check the elements in the list to see if the integer parameter is in the list. If the integer parameter is in the list , return true. FoundB has the
     same parameters and aalso returns a boolean. However, foundB uses Iterator methods to find the Integer key. foundB uses a temporary iterator pointer? and while
     loop to iterate through the list. The while loop uses hasNext to know whether or not to keep iterating/ if there are any elements left. oddsA returns a list of integers
     and takes in a list of integers as the only parameter. oddsA uses a for each loop to find all the odd integers. we use the conditional of % 2 == 1 then it must
     be odd so at it to our output array list which is return at the end of the function. oddsB is the same as oddsA but uses iterator methods. Again, we need
     a temporary iterator pointer. Then we used a while loop and has next to iterate through all the elements and for every element we use the conditional
     %2 == 1 to see if the element is odd and if it should be added to the ouput list. Finally, we have removes even which returns void and takes in an integer list.
     We need a temporary iterator pointer to iterate through the list. We iterate through the list with a while loop again and check for each element if it's even
     by using % 2 == 0. If it is even, we use remove from the iterator interface. Unlike oddsA and B, this method actually edits the input parameter list.
 **/




import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{

  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key,
                                List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    boolean found = false;
    for(Integer i : L){
        if(i.equals(key)){
            found = true;
        }
    }
    return found;
  }

  //explicitly using an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key,
                                List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
      boolean found = false;
      Iterator it = L.iterator();
      while(it.hasNext()){
          Integer i = (Integer)it.next();
          if(i.equals(key)){
            found = true;
          }
      }
      return found;
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsA( List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    List <Integer> a = new ArrayList<Integer>();
    for(Integer i : L){
        if(i % 2 == 1){
            a.add(i);
        }
    }
    return a;
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsB( List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    List <Integer> a = new ArrayList<Integer>();
    Iterator it = L.iterator();
    while(it.hasNext()){
        Integer i = (Integer)it.next();
        if(i % 2 == 1){
          a.add(i);
        }
    }
    return a;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    Iterator it = L.iterator();
    while(it.hasNext()){
        Integer i = (Integer)it.next();
        if(i % 2 == 0){
          it.remove();
        }
    }
  }


  public static void main( String [] args )
  {


    //var type: List   obj type: ?
    List<Integer> L = new ArrayList <Integer>();

    for( int i = 0; i < 10; i++ )
      L.add(i);


    // TASK: write code to print the contents of L...

    // a) using a FOREACH loop
      String output = "";
      for(Integer i : L){
        output += i;
        output += ", ";
      }
      System.out.println(output);

    // b) explicitly using an iterator
      String output1 = "";
      Iterator it = L.iterator();
      while(it.hasNext()){
        output1 += it.next();
        output1 += ", ";
      }
      System.out.println(output1);

    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) );
    System.out.println("13 in L? -> " + foundA(13,L) );

    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) );
    System.out.println("13 in L? -> " + foundB(13,L) );

    System.out.println("\nTesting oddsA...");
    List<Integer> A = oddsA(L);
    for( int n : A ) System.out.println(n);

    System.out.println("\nTesting oddsB...");
    List<Integer> B = oddsB(L);
    for( int n : B ) System.out.println(n);

    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for( int n : L ) System.out.println(n);

    /*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class ItrWork
