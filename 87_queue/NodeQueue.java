/*
Team Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz, Tom, Preguac, Applesauce)
APCS pd6
HW87: The English Do Not Wait In Line for Soup
2022-04-01
time spent: too many hours
*/

/*
DISCO:
QCC:
0. We had to add <QUASAR> after every LLNode call? instantiation? Why is that?
1. our first method for traversing to the end didn't work for some reason so we changed it but then our toString was also broken so we don't know which
was the problem
2. This took too long.
3. Writing test cases is quite annoying
4.Our code is expected to produce an error at the end because we run peek front on an empty queue
*/

public class NodeQueue<QUASAR> implements Queue<QUASAR> {

  private LLNode<QUASAR> _queue;
  private int _qsize;

  public NodeQueue() {
    _queue = null;
    _qsize = 0;
  }

  public QUASAR dequeue() {                                       //traverse to end, get value , delete it
    LLNode<QUASAR> temp = _queue;
    QUASAR retVal = _queue.getCargo();;
    // while (!(temp.getNext().getNext().equals(null))) {
    //   temp = temp.getNext();
    // }
    // QUASAR ret = temp.getNext().getCargo();                //idk why this keeps hitting null pointer exception
    // temp.setNext(null);
    // return ret;

    if(_qsize > 0){
        if(_qsize == 1){
          retVal = _queue.getCargo();
          _queue = null;
          _qsize --;
          return retVal;
        }else{
          for( int i=0; i < _qsize -1; i++ ){
              temp = temp.getNext();
              retVal = temp.getCargo();
          }
          temp.setNext(null);
          _qsize --;
          return retVal;
        }
    }else{
      return _queue.getCargo();
    }

  }


  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( QUASAR x ) {
    LLNode<QUASAR> temp = new LLNode(x, _queue);          //_queue always points to the head
    _queue = temp;
    _qsize ++;
  }

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty() {
    //return (_queue.getCargo().equals(null));
    return _qsize == 0;
  }

  //Returns the first element of the queue without dequeuing it.
  public QUASAR peekFront() {
    LLNode<QUASAR> temp = _queue;
    QUASAR retVal = _queue.getCargo();;
    // while (!(temp.getNext().equals(null))) {
    //   temp = temp.getNext();
    // }
    // return temp.getCargo();
    if(_qsize == 1){
      retVal = _queue.getCargo();
      //_queue = null;
      //_qsize --;
      return retVal;
    }else{
      for( int i=0; i < _qsize -1; i++ ){
          temp = temp.getNext();
          retVal = temp.getCargo();
      }
      //_temp.setNext(null);
      //_qsize --;
      return retVal;
    }

  }


  public String toString()
  {
    {
    String retStr = "";
    LLNode<QUASAR> tmp = _queue; //init tr

    for (int i = _qsize; i > 0; i--) {
	    retStr += tmp.getCargo() + ", ";
      tmp = tmp.getNext();
    }
    return retStr;
  }
  }

  private class LLNode<QUASAR>
  {
    //instance vars
    private QUASAR _cargo;
    private LLNode<QUASAR> _nextNode;

    // constructor
    public LLNode( QUASAR value, LLNode<QUASAR> next )
    {
      _cargo = value;
      _nextNode = next;
    }


    //--------------v  ACCESSORS  v--------------
    public QUASAR getCargo()
    {
      return _cargo;
    }

    public LLNode<QUASAR> getNext()
    {
      return _nextNode;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public QUASAR setCargo( QUASAR newCargo )
    {
      QUASAR foo = getCargo();
      _cargo = newCargo;
      return foo;
    }

    public LLNode<QUASAR> setNext( LLNode<QUASAR> newNext )
    {
      LLNode<QUASAR> foo = getNext();
      _nextNode = newNext;
      return foo;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
      return "" + _cargo;
    }

  }//end class LLNode
  public static void main(String[] args){
      NodeQueue<Object> bob = new NodeQueue<Object>();

      for(int i = 0; i < 10; i++){
          bob.enqueue(i);
          System.out.println(bob);
          System.out.println(bob.peekFront());
      }
      //System.out.println(bob.peekFront());
      System.out.println();

      while(!bob.isEmpty()){
          System.out.println(bob);
          System.out.println("size before pop : " + bob._qsize);
          bob.dequeue();
          System.out.println(bob);
          System.out.println("size after pop : " + bob._qsize);
          System.out.println();
          System.out.println(bob.peekFront());
          System.out.println();


      }
  }
}
