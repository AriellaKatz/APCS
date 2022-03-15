/*
Team Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz, Tom, Preguac, Applesauce)
APCS pd6
HW75: Nodal Recall
2022-03-11
time spent: 0.75 hours
KtS consumed: 3
*/

/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode
{
  //instance vars
  private String _cargo;
  private LLNode _nextNode;

  // constructor
  public LLNode( String value, LLNode next )
  {
    _cargo = value;
    _nextNode = next;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return _cargo;
  }

  public LLNode getNext()
  {
    return _nextNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    String oldCargo = getCargo();
    _cargo = newCargo;
    return oldCargo;
  }

  public LLNode setNext( LLNode newNext )
  {
    LLNode oldNext = getNext();
    _nextNode = newNext;
    return oldNext;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    return this.getCargo();
  }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    LLNode first = new LLNode( "cat", null );
    System.out.println(first);

    //Create a new node after the first
    first.setNext( new LLNode( "dog", null ) );
    System.out.println(first);

    //Create a third node after the second
    first.getNext().setNext( new LLNode( "cow", null ) );
    System.out.println(first);

    // A naive list traversal, has side effects.... ??
    /*
       while( first != null ) {
       System.out.println( first );
       first = first.getNext();
       }
       System.out.println(first);
    */

    //Q: when head ptr moves to next node in list, what happens to the node it
    //   just left?
    //A: first is no longer assigned to the original node, so it's effectively
    //   deleted because there is no longer anything pointing to it
    //...so better: ?

        LLNode temp = first;
        //this way, first isn't actually changed during the traversal (only temp
        //is changed)
        while (temp != null) {
          System.out.println(temp);
          temp = temp.getNext();
        }
        System.out.println(first);
        //System.out.println(temp);

  }//end main

}//end class LLNode
