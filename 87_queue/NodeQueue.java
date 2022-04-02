public class NodeQueue<QUASAR> implements Queue<QUASAR> {

  private LLNode _queue;
  private int _qsize;

  public NodeQueue() {
    _queue = null;
    _qsize = 0;
  }

  public QUASAR dequeue() {
    LLNode temp = _queue;
    while (!(temp.getNext().getNext().equals(null))) {
      temp = temp.getNext();
    }
    QUASAR ret = temp.getNext().getCargo();
    temp.setNext(null);
    return ret;
  }

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( QUASAR x ) {
    LLNode temp = new LLNode(x, _queue);
    _queue = temp;
  }

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty() {
    return (_queue.getCargo().equals(null));
  }

  //Returns the first element of the queue without dequeuing it.
  public QUASAR peekFront() {
    LLNode temp = _queue;
    while (!(temp.getNext().equals(null))) {
      temp = temp.getNext();
    }
    return temp.getCargo();
  }

  private class LLNode<QUASAR>
  {
    //instance vars
    private QUASAR _cargo;
    private LLNode _nextNode;

    // constructor
    public LLNode( QUASAR value, LLNode next )
    {
      _cargo = value;
      _nextNode = next;
    }


    //--------------v  ACCESSORS  v--------------
    public QUASAR getCargo()
    {
      return _cargo;
    }

    public LLNode getNext()
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
