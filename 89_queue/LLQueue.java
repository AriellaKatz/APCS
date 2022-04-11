/*
Team Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz, Tom, Preguac, Applesauce)
APCS pd6
HW89:
2022-04-11
time spent:  hours
*/

/*
DISCO
-In linked lists, remove() removes the head of the linked list so we don't even need a _front
-They also have addLast() so we don't need an _end pointer either
- We also don't need _size since LList has it too
-The dummy variable does not need to match the one in the interface
QCC
-We tried using <int> in our test case but we got the error
LLQueue.java:77: error: unexpected type
      LLQueue<int> bob = new LLQueue<int>();
              ^
  required: reference
  found:    int
*/
import java.util.LinkedList;

public class LLQueue<T> implements Queue<T>{

  LinkedList<T> _queue;

  public LLQueue(){
    _queue = new LinkedList<T>();
  }

  public void enqueue(T val){           //O(1) because LList addLast is O(1)
     _queue.addLast(val);
  }

  public T dequeue(){             //O(1) because LList remove is O(1)
    //remove( index 0)
    T ret = _queue.remove();
    return ret;
  }

  public T peekFront(){       //O(1) because LList peekFirst is O(1)
    //getFirst()
    T ret = _queue.peekFirst();
    return ret;
  }

  public boolean isEmpty(){   //O(1) because just a comparison
    // size == 0
    return _queue.size() == 0;
  }

  public String toString()
  {
    String retStr = "FRONT :: ";
    for(int i = 0; i < _queue.size(); i ++){
        retStr += _queue.get(i);
        retStr += ", ";
    }
    retStr += " :: END";
    return retStr;
  }//end toString()

  public static void main(String[] args){
      LLQueue<String> bob = new LLQueue<String>();

      for(int i = 0; i < 5; i++){
          bob.enqueue(""+ i);
          System.out.println(bob);
      }

      while(bob.isEmpty() == false){
          System.out.println(bob.peekFront());
          bob.dequeue();
          System.out.println("Collection after dequeue: " + bob);
      }
  }
}
