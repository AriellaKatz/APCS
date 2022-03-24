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
    SUMMARY THE FIRST:
    SUMMARY THE SECOND:
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
