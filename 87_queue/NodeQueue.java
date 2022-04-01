public class NodeQueue {

  private LLNode _queue;
  private int _qsize;

  public NodeQueue {
    _queue = null;
    _qsize = 0;
  }

  public QUASAR dequeue() {

  }

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( QUASAR x ) {

  }

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty() {

  }

  //Returns the first element of the queue without dequeuing it.
  public QUASAR peekFront() {

  }

  private class LLNode
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
      String foo = getCargo();
      _cargo = newCargo;
      return foo;
    }

    public LLNode setNext( LLNode newNext )
    {
      LLNode foo = getNext();
      _nextNode = newNext;
      return foo;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
      return _cargo;
    }

  }//end class LLNode

}
