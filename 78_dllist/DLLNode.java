/*
Team Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz, Tom, Preguac, Applesauce)
APCS pd6
HW78: Double Up
2022-03-16
time spent: 1.5 hours
KtS consumed: many
*/

/***
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class DLLNode
{
  //instance vars
  private DLLNode _prevNode;
  private String _cargo;
  private DLLNode _nextNode;


  // constructor
  public DLLNode(DLLNode prev, String value, DLLNode next )
  {
    _prevNode = prev;
    _cargo = value;
    _nextNode = next;
  }


  //--------------v  ACCESSORS  v--------------
  public DLLNode getPrev()
  {
    return _prevNode;
  }

  public String getCargo()
  {
    return _cargo;
  }

  public DLLNode getNext()
  {
    return _nextNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public DLLNode setPrev (DLLNode newPrev){
    DLLNode oldPrev = getPrev();
    _prevNode = newPrev;
    return oldPrev;
  }


  public String setCargo( String newCargo )
  {
    String oldCargo = getCargo();
    _cargo = newCargo;
    return oldCargo;
  }

  public DLLNode setNext( DLLNode newNext )
  {
    DLLNode oldNext = getNext();
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
    DLLNode first = new DLLNode( null, "cat", null );
    System.out.println(first);

    //Create a new node after the first
    first.setNext( new DLLNode( first, "dog", null ) );
    System.out.println(first);

    //Create a third node after the second
    first.getNext().setNext( new DLLNode( first.getNext(), "cow", null ) );
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

        DLLNode temp = first;
        //this way, first isn't actually changed during the traversal (only temp
        //is changed)
        while (temp != null) {
          System.out.println(temp);
          temp = temp.getNext();
        }
        System.out.println(first);
        //System.out.println(temp);

        System.out.println();
        DLLNode temp2 = first.getNext().getNext();
        System.out.print(temp2);
        temp2 = temp2.getPrev();
        System.out.print(temp2);
        temp2 = temp2.getPrev();
        System.out.print(temp2);
        temp2 = temp2.getPrev();


  }//end main

}//end class DLLNode
