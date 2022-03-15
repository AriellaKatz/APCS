/*
Team Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz, Tom, Preguac, Applesauce)
APCS pd6
HW76: We Got a Little Ol' Convoy
2022-03-14
time spent: 1 hours
KtS consumed: 3
*/

/*
QCC
* Is the tail end supposed to be 0 index?
* What do we do with head node?
*?
/***
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 **/

public class LList implements List //interface def must be in this dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    // YOUR CODE HERE
    _head = new LLNode ("", null);           //what do we do for head? Is an empty node possible?
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    // YOUR CODE HERE
    if (_size == 0) { _head.setCargo(newVal); }
    LLNode temp = _head;
    while( temp.getNext() != null ) {       //use .getnext so that temp equals the last node not null
    temp = temp.getNext();
    }
    temp.setNext(new LLNode(newVal, null));
    _size ++;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    // YOUR CODE HERE
    LLNode temp = _head;
    for(int i = 0; i < _size - index; i++){
      temp = temp.getNext();
      //System.out.println(temp);
    }
      return temp.getCargo();
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
      throw new IndexOutOfBoundsException();

    // YOUR CODE HERE
    LLNode temp = _head;
    for(int i = 0; i < _size - index; i++){
      temp = temp.getNext();
    }
      return temp.setCargo(newVal);
  }


  //return number of nodes in list
  public int size()
  {
    // YOUR CODE HERE
    return _size;
  }

  //--------------^  List interface methods  ^--------------



  // override inherited toString
  public String toString()
  {
    // YOUR CODE HERE
    String retStr = "";
    //LLNode temp = _head;
    for(int i = 0; i < _size; i++){
      retStr += get(i) + ", ";
      //temp = temp.getNext();
    }
    if (_size > 0) {
      retStr = retStr.substring(0,retStr.length()-2);
    }
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
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class LList
