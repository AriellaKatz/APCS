/*
Team Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz, Tom, Preguac, Applesauce)
APCS pd6
HW80: Generically Speaking
2022-03-23
time spent: 1.5 hours
KtS consumed: many
*/
/***
 * class DLLNode v1
 * Implements a node, for use in lists and other container classes.
 * Stores a Object as cargo.
 **/

public class DLLNode
{
  private Object _cargo;    //cargo may only be of type T
  private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes


  // constructor -- initializes instance vars
  public DLLNode(Object value, DLLNode prev, DLLNode next )
  {
    _cargo = value;
    _nextNode = next;
    _prevNode = prev;
  }


  //--------------v  ACCESSORS  v--------------
  public Object getCargo() { return _cargo; }

  public DLLNode getNext() { return _nextNode; }

  public DLLNode getPrev() { return _prevNode; }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public Object setCargo( Object newCargo )
  {
    Object foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public DLLNode setNext( DLLNode newNext )
  {
    DLLNode foo = getNext();
    _nextNode = newNext;
    return foo;
  }

  public DLLNode setPrev( DLLNode newPrev )
  {
    DLLNode foo = getPrev();
    _prevNode = newPrev;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString() { return _cargo.toString(); }


  //main method for testing
  public static void main( String[] args )
  {
    //Below is an exercise in creating a linked list...

    /*********************

    //Create a node
    DLLNode first = new DLLNode( "cat", null, null );

    //Create a new node after the first
    first.setNext( new DLLNode( "dog", first, null ) );

    //Create a third node after the second
    first.getNext().setNext( new DLLNode( "cow", first.getNext(), null ) );

    //Create a node
    DLLNode second = new DLLNode( 1, null, null );

    //Create a new node after the first
    second.setNext( new DLLNode( 2, second, null ) );

    //Create a third node after the second
    second.getNext().setNext( new DLLNode( "cow", second.getNext(), null ) );

    DLLNode temp = first;
    while( temp != null ) {
      System.out.println( temp );
      temp = temp.getNext();
    }

      DLLNode temp2 = second;
      while( temp2 != null ) {
        System.out.println( temp2 );
        temp2 = temp2.getNext();
      }

   ***********************/
  }//end main

}//end class DLLNode
