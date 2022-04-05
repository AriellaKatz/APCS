/*
Team Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz, Tom, Preguac, Applesauce)
APCS pd6
HW88: BPC Kiddies Do Not Wait in Line Either
2022-04-04
time spent: 2.5 hours
*/

/*
QCC
Would it have been possible to make a temporary Queue?
DISCO
*/

/***
 * class RQueue
 * SKELETON
 * A node-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 **/


public class RQueue<SWASHBUCKLE> implements Queue<SWASHBUCKLE>
{
  //instance variables
  private LLNode<SWASHBUCKLE> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue()
  {
    _front = _end = null;
    _size = 0;
  }


  public void enqueue( SWASHBUCKLE enQVal )
  {
    //special case: when enqueuing to an empty list,
    //make _front && _end point to same node
    if ( isEmpty() ) {
      _front = _end = new LLNode<SWASHBUCKLE>( enQVal, null );
    }
    else {
      _end.setNext( new LLNode<SWASHBUCKLE>( enQVal, null ) );
      _end = _end.getNext();
    }
    _size++;
    System.out.println("enqueued " + enQVal);

  }//O(1) no iteration needed


  // remove and return thing at front of queue
  // assume _queue ! empty
  public SWASHBUCKLE dequeue()
  {
    for(int i = ((int)(Math.random() * 10)); i >=0 ; i--){
          sample();
    }
      SWASHBUCKLE retVal = _front.getCargo();
      _front = _front.getNext();

      if ( _front == null ) //just moved past last node
        _end = null;      //update _end to reflect emptiness

        _size--;

      //_peek = retVal;
      return retVal;
  }//O(?)


  public SWASHBUCKLE peekFront()
  {
      return _front.getCargo();
  }//O(1)


  /***
   * void sample() -- a means of "shuffling" the queue
   * Algo1:
   *   < YOUR SUCCINCT SUMMARY HERE >
   Pick random node from list and start new list. Remove from old list. keep going until old list is empty.
   It'd be nice if we could create a temporary queue. CAN WE MAKE A TEMPORARY QUEUE?
   ORRRRRR
   Create 2 temp link list. send all even index nodes to one temp list. send all odd index nodes to the other temp list
   combine both temp lists. Have _front point to front of this combination. Have _end point to end of combination.
   Similar to perfect shuffle
   Create 2 temporary LLists.
   Alternate between lists, and send first element from the queue to one of the temp LL until the queue is isEmpty
   now randomly link the first to the second list or the second to first list for extra randomness.
   Set _front to this new combined list and _end to the end of this list
   * Algo2:
   for each node in the queue, swap it with a random node in the queue.
   **/
  public void sample ()
  {
    /*
      //RQueue<SWASHBUCKLE> temp = new RQueue<SWASHBUCKLE>();
      LLNode<SWASHBUCKLE> tmp, tmpE;
      LLNode<SWASHBUCKLE> tmp2, tmp2E;
    //  int half = _size / 2;
      if(_size == 1){
        return;       //can't shuffle 1 element
      }else if(_size == 2){
        tmp = new LLNode<SWASHBUCKLE>(  _end.getCargo(), null );
        tmp2 = new LLNode<SWASHBUCKLE>(  _front.getCargo(), null );
        tmp.setNext(tmp2);
        _front = tmp;
        _end = _front.getNext();
      }else{
      //  System.out.println(_front);
           tmp = new LLNode<SWASHBUCKLE>(  _front.getCargo(), null );
           _front=_front.getNext();
      //  System.out.println(_front);

           tmp2 = new LLNode<SWASHBUCKLE>(  _front.getCargo(), null );
           _front=_front.getNext();
      //  System.out.println(_front);

           tmpE = tmp;
           tmp2E = tmp2;
          for(int i = 3; i<=_size; i++){
              if(i % 2 == 1 ){
                  // tmpE.setNext(_front.getCargo());
                  // tmpE = tmpE.getNext();
                  // _front=_front.getNext();
                  tmpE.setNext(new LLNode<SWASHBUCKLE> (_front.getCargo(), null));
                  tmpE = tmpE.getNext();
                  _front=_front.getNext();
                //  System.out.println("tmpE: " + tmpE);
                //  System.out.println(_front);

              }else{
                  // tmp2E.setNext(_front.getCargo());
                  // tmp2E = tmp2E.getNext();
                  // _front=_front.getNext();
                  tmp2E.setNext(new LLNode<SWASHBUCKLE> (_front.getCargo(), null));
                  tmp2E = tmp2E.getNext();
                  _front=_front.getNext();
                  //System.out.println("tmp2E: " + tmp2E);
                  //System.out.println(_front);

              }
          }
          int i = ((int)(Math.random() * 2));
          if(i == 0){
              tmpE.setNext(tmp2);
              _front = tmp;
              _end = tmp2E;
          }else{
              tmp2E.setNext(tmp);
              _front = tmp2;
              _end = tmpE;
          }
      }
    */
//    /*
    for (int i = 0; i < _size; i++) {
      System.out.println(toString());
      System.out.println("i: " + i);
      int rand = (int)(Math.random() * (_size-1));
      System.out.println("rand: " + rand);

      //iterate through to the node at index i
      LLNode<SWASHBUCKLE> temp1 = _front;
      for (int n = 0; n < i-1; n++) {
        temp1 = temp1.getNext();
      }
      LLNode<SWASHBUCKLE> temp2;
      if (i == 0) {
        temp2 = _front;
      }
      else {
        temp2 = temp1.getNext();
      }
      //iterate through to the node at index rand
      LLNode<SWASHBUCKLE> temp3 = _front;
      for (int m = 0; m < rand-1; m++) {
        temp3 = temp3.getNext();
      }
      LLNode<SWASHBUCKLE> temp4;
      if (rand == 0) {
        temp4 = _front;
      }
      else {
        temp4 = temp3.getNext();
      }
      System.out.println(temp1);
      System.out.println(temp2);
      System.out.println(temp3);
      System.out.println(temp4);
      //swap temp2 and temp4
      LLNode<SWASHBUCKLE> temp5 = temp4.getNext();
      if (!(temp2.equals(temp4))) {
        temp4.setNext(temp2.getNext());
        if (temp2.equals(_front)) {
          _front = temp4;
        }
        else {
          temp1.setNext(temp4);
        }
        temp2.setNext(temp5);
        if (temp5 == (null)) {
          _end = temp2;
        }
        temp3.setNext(temp2);
        System.out.println("front: " + _front);
        System.out.println("end: " + _end);
      }
    }
//    */
  }//O(n) Only 1 iteration


  public boolean isEmpty()
  {
    return _front == null;
  } //O(?)


  // print each node, separated by spaces
  public String toString()
  {
    String retStr = "FRONT :: ";
    LLNode<SWASHBUCKLE> tmp = _front; //init tr
    while( tmp != null ) {
      retStr += tmp.getCargo() + " ";
      tmp = tmp.getNext();
    }
    retStr += " :: END";
    return retStr;
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {


    Queue<String> PirateQueue = new RQueue<String>();

    System.out.println("\nnow enqueuing...");
    PirateQueue.enqueue("Dread");
    PirateQueue.enqueue("Pirate");
    PirateQueue.enqueue("Roberts");
    PirateQueue.enqueue("Blackbeard");
    PirateQueue.enqueue("Peter");
    PirateQueue.enqueue("Stuyvesant");

    System.out.println("\nnow testing toString()...");
    System.out.println( PirateQueue ); //for testing toString()...

    System.out.println("\nnow dequeuing...");
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );
    System.out.println( PirateQueue.dequeue() );

    System.out.println("\nnow dequeuing fr empty queue...\n" +
                       "(expect NPE)\n");
    System.out.println( PirateQueue.dequeue() );
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
