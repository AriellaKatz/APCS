// ABA - Ariella Katz, Alif Rahman, Brianna Tiue, Tom, Grippy, Pepe
// APCS
// HW45 -- Array of Titanium
// 2021-12-08
// time spent: 0.5hrs

/***************************
 * class SuperArray version 2.0
 * (SKELETON)
 * Wrapper class for array. Facilitates
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 ***************************/

/*
DISCO:
0. Interfaces have different formatting conventions than classes.
   Methods are not followed by {}, but are rather followed by ;.
1. If the implemented methods do not have the same returntype as
   the abstract methods in the interface, it will throw an error.
2. Implemented methods cannot override abstract methods; you need
   to implement the interface's abstract methods with the same
   parameters, and then you can override that implemented method.
QCC:
0. Since the methods in interfaces have basically no information,
   are interfaces essentially just checklists to ensure that when
   you write the class(es) that implements them, the classes
   contain certain methods with the desired parameters?
1. How is  add(int index, int newVal) treated since it's still
   technically an overriden add() method but add(int newVal) is
   explicitly required by the interface while
   add(int index, int newVal) has different parameters and is not
   in compliance with the interface?
*/

public class SuperArray implements ListInt
{

  private int[] _data;  //underlying ("encapsulated") container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new int[10];
    _size = 0;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String foo = "[";
    for( int i = 0; i < _size; i++ ) {
      foo += _data[i] + ",";
    }
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length()-1 );
    foo += "]";
    return foo;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] temp = new int[ _data.length * 2 ];
    for( int i = 0; i < _data.length; i++ )
      temp[i] = _data[i];
    _data = temp;
  }


  //accessor -- return value at specified index
  public int get( int index )
  {
    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public int set( int index, int newVal )
  {
    int temp = _data[index];
    _data[index] = newVal;
    if (index >= _size) { _size ++; }
    return temp;
  }


  //adds an item after the last item
  public boolean add( int newVal )
  {
    if (_size ==  _data.length) { expand(); }
    _data[_size] = newVal;
    _size++;
    return true; //required by Java
  }


  //inserts an item at index
  public boolean add( int index, int newVal )
  {
    if (!(_size < _data.length - 1)) { expand(); }
    for (int i = _size; i > index; i--) {
      _data[i] = _data[i-1];
    }
    _data[index] = newVal;
    _size++;
    return true; //required by Java
  }


  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  public void remove( int index )
  {
    for (int i = index; i < _size - 1; i++) {
      _data[i] = _data[i+1];
    }
    _data[_size-1] = 0;
    _size--;
  }


  //return number of meaningful items in _data
  public int size()
  {
    return _size;
  }



  //main method for testing
  public static void main( String[] args )
  {
      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );
      for( int i = 0; i < curtis._data.length; i++ ) {
      curtis.set( i, i * 2 );
      }
      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);
      for( int i = 0; i < 3; i++ ) {
      curtis.expand();
      System.out.println("Printing expanded SuperArray curtis...");
      System.out.println(curtis);
      System.out.println("new length of underlying array: "
      + curtis._data.length );
      }
      SuperArray mayfield = new SuperArray();
      System.out.println("Printing empty SuperArray mayfield...");
      System.out.println(mayfield);
      mayfield.add(5);
      mayfield.add(4);
      mayfield.add(3);
      mayfield.add(2);
      mayfield.add(1);
      System.out.println("Printing populated SuperArray mayfield...");
      System.out.println(mayfield);
      mayfield.remove(3);
      System.out.println("Printing SuperArray mayfield post-remove...");
      System.out.println(mayfield);
      mayfield.remove(3);
      System.out.println("Printing SuperArray mayfield post-remove...");
      System.out.println(mayfield);
      mayfield.add(3,99);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      mayfield.add(2,88);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
      mayfield.add(1,77);
      System.out.println("Printing SuperArray mayfield post-insert...");
      System.out.println(mayfield);
    /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class
