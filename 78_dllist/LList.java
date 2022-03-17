/*
Team Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz, Tom, Preguac, Applesauce)
APCS pd6
HW78: Double Up
2022-03-16
time spent: 1.5 hours
KtS consumed: many
*/

/*
DISCO
Add at index algo is not necessarily the same as remove.
Find and replace exists
There's a special case where we have to remove the only element in a size 1 list
QCC
What's the use in _tail? (It'll probably be useful in traversing backwards but we weren't assigned to do that yet)
ALGO ADD
check where we are adding.
if 0 index just use add. (Add creates a new node with previousnode being null, nextnode being head. Then we reset head to be the new node.)
if adding to the end of the list, traverse until last node and set next node to new added node. The new node should have a prevNode pointer to the last node before add happened. Move tail to new node.
If in the middle, we need the information about the node currently at the index and the node at the index -1
set the index -1 node's next node to the new added node. set the new added node's next node to the old node that was at the index.
set the old node's prev node to the new node.
ALGO REM
Check where we are adding
if index 0, then traverse the list one node but don't use a temp. Basically Set the head to the next node. Change the new 0 index node's prevNode to null.
if last index, go to second to last node and set next node to NULL. Move tail
If in the middle we need the node before and after the node at the index.
set node at index - 1 next node to node at index + 1. Set node at index +1 prev node to node at index -1
*/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private DLLNode _head;
  private int _size;
  private DLLNode _tail;

  // constructor -- initializes instance vars
  public LList( )
  {
    _tail = null;
    _head = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    DLLNode tmp = new DLLNode(null, newVal, _head );
    _head = tmp;
    _size++;
    DLLNode tmp2 = _head;

    for(int i = 0; i < _size - 1; i++){
        tmp2 = tmp2.getNext();                //After adding new node, traverse to end of list to set the last node as the tail
    }
    _tail = tmp2;

    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    String retVal;
    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
      tmp = tmp.getNext();

    //store target node's cargo
    String oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }

  public String remove( int index ){
      DLLNode  tmp1 = _head;
      DLLNode tmp2 = _head;
      String oldval = get(index);

      if(size() == 1){
          _head = null;                                            //Special case when removing 1 element from size 1 list
          _tail = null;
          _size--;
          return oldval;
      }else if(index < _size - 1 && index > 0){                          //When index is in the middle
          for( int i=0; i < index - 1; i++ ){
            tmp1 = tmp1.getNext();
          }

          for( int i=0; i < index + 1; i++ ){
            tmp2 = tmp2.getNext();
          }
          tmp1.setNext(tmp2);
          tmp2.setPrev(tmp1);
          _size--;
          return oldval;
      }else if (index == _size - 1 ) {             //when index is the end
          for( int i=0; i < index -1; i++ ){
            tmp1 = tmp1.getNext();
          }
          tmp1.setNext(null);
          _tail = tmp1;
          _size--;
          return oldval;
      }else{                                    // When index is first
          _head = _head.getNext();
          _head.setPrev(null);
          _size--;
          return oldval;
      }
  }

  public void add( int index, String newVal ) {
    DLLNode tmp1 = _head;
    DLLNode tmp2 = _head;

      if(index == 0){                               //add at beginning
          add(newVal);

      }
      else if(index == _size ){               // add at end

        for( int i=0; i < index - 1; i++ ){
          tmp1 = tmp1.getNext();
        }
          tmp2 = new DLLNode(tmp1, newVal, null);
          tmp1.setNext(tmp2);
          _tail = tmp2;
          _size++;

      }else{                                            // add at middle

        for( int i=0; i < index - 1; i++ ){
          tmp1 = tmp1.getNext();
        }

        for( int i=0; i < index ; i++ ){
          tmp2 = tmp2.getNext();
        }
        DLLNode tmp3 = new DLLNode(tmp1, newVal, tmp2);
        tmp1.setNext(tmp3);
        tmp2.setPrev(tmp3);
        _size++;

      }

  }



  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    DLLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    retStr += "<- TAIL";

    return retStr;
  }


  //main method for testing
  /*
  public static void main( String[] args )
  {
    LList james = new LList();
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    System.out.println( "2nd item is: " + james.get(1) );
    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
    System.out.println( james );
    System.out.println( "size: " + james.size() );
// -------------------------new tests-----------------------------------------------
    System.out.println();
    james.add( 1, "index 1" );
    System.out.println( "Added at index 1?: "  );
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    System.out.println();
    james.add( 0, "index 0" );
    System.out.println( "Added at index 0?: "  );
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    System.out.println();
    james.add (6, "at end" );
    System.out.println( "Added at index size?: "  );
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    System.out.println();
    james.add (6, "at second to last" );
    System.out.println( "Added at index size - 1?: "  );
    System.out.println( james );
    System.out.println( "size: " + james.size() );
//--------------------------------test remove
    System.out.println();
    james.remove( 0 );
    System.out.println( "remove at 0?: "  );
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    System.out.println();
    james.remove( 1 );
    System.out.println( "remove at 1: "  );
    System.out.println( james );
    System.out.println( "size: " + james.size() );
    System.out.println();
    james.remove (5 );
    System.out.println( "remove last: "  );
    System.out.println( james );
    System.out.println( "size: " + james.size() );
  }
*/

}//end class LList
