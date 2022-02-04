// ABA: Ariella Katz, Alif Rahman, Brianna Tieu, Tom, Grippy, Pepe
// APCS
// HW43 -- encapsulation (basic SuperArray functionality)
// 2021-12-06
// time spent: 0.5 hrs

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

/*
DISCO:
0. Although you can't alter the length of an array, arr, you can set arr = to
   an array of a different length and arr will assume that length (there are
   no compatibility issues with this).
QCC:
0. When running SuperArray in the terminal, is there a way to input via std
   input (the command line) the desired array length to be inputted in the
   constructor? 
*/

public class SuperArray
{

  private int[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new int[10];
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String str = "[";
    for (int element : _data) {
      str += element + ", ";
    }
    str = str.substring(0,str.length()-2) + "]";
    return str;
  }


  //double capacity of SuperArray
  private void expand()
  {
    int[] _newData = new int[2 * _data.length];
    for (int i = 0; i < _data.length; i++) {
      _newData[i] = _data[i];
    }
    _data = _newData;
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
    int oldVal = _data[index];
    _data[index] = newVal;
    return oldVal;
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
      }
      /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class
