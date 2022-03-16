/*
Team Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz, Tom, Preguac, Applesauce)
APCS pd6
HW77: Insert|Remove
2022-03-15
time spent: 1.5 hours
KtS consumed: many
*/

/*
DISCO
Add at index algo is not necessarily the same as remove.
QCC
Why is it that when tmps are altered (their _nextNodes are manipulated to link tmps together), the same changes are made to _head?
ALGO ADD
check where we are adding.
if 0 index just use add
if adding to the end of the list, traverse until last node and set next node to new added node
If in the middle, we need the information about the node currently at the index and the node at the index -1
set the index -1 node's next node to the new added node. set the new added node's next node to the old node that was at the index.
ALGO REM
Check where we are removing
if index 0, then traverse the list one node but don't use a temp. Basically Set the head to the next node
if last index, go to second to last node and set next node to NULL
If in the middle we need the node before and after the node at the index.
set node at index - 1 next node to node at index + 1 (in other words, change the _nextNode of index-1 to _cargo of index+1)
*/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    LLNode tmp = new LLNode( newVal, _head );
    _head = tmp;
    _size++;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    String retVal;
    LLNode tmp = _head; //create alias to head

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

    LLNode tmp = _head; //create alias to head

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
      LLNode  tmp1 = _head;
      LLNode tmp2 = _head;
      String oldval = get(index);

      if(index < _size && index > 0){                          //When index is in the middle
          for( int i=0; i < index - 1; i++ ){
            tmp1 = tmp1.getNext();
          }

          for( int i=0; i < index + 1; i++ ){
            tmp2 = tmp2.getNext();
          }
          tmp1.setNext(tmp2);
          _size--;
          return oldval;
      }else if (index == _size - 1 ) {             //when index is the end
          for( int i=0; i < index -1; i++ ){
            tmp1 = tmp1.getNext();
          }
          tmp1.setNext(null);
          _size--;
          return oldval;
      }else{                                    // When index is first
          _head = _head.getNext();
          _size--;
          return oldval;
      }
  }

  public void add( int index, String newVal ) {
    LLNode tmp1 = _head;
    LLNode tmp2 = _head;

      if(index == 0){                               //add at beginning
          add(newVal);

      }
      else if(index == _size ){               // add at end

        for( int i=0; i < index - 1; i++ ){
          tmp1 = tmp1.getNext();
        }
          tmp2 = new LLNode(newVal, null);
          tmp1.setNext(tmp2);
          _size++;

      }else{                                            // add at middle

        for( int i=0; i < index - 1; i++ ){
          tmp1 = tmp1.getNext();
        }

        for( int i=0; i < index ; i++ ){
          tmp2 = tmp2.getNext();
        }
        tmp1.setNext(new LLNode(newVal, tmp2));
        _size++;

      }

  }



  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    LLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
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



}//end class LList
