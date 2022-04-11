/*
Team Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz, Tom, Preguac, Applesauce)
APCS pd6
HW89:
2022-04-11
time spent:  hours
*/

/*
DISCO
- Now we need counters for the front index and end index since add already adds at end and the array list auto shifts stuff after remove so the front index is always 0
- We don't need _size since ArrayList has it too
-Array list automatically shifts stuff after remove so we will have at least one O(n) method in either enqueue or dequeue
QCC
- In this implementation, we have the front at index 0
*/

import java.util.ArrayList;

public class ALQueue<T> implements Queue<T>{

  ArrayList<T> _queue;
//  int _size;
//  int _front;
//  int _end;

  public ALQueue(){
    _queue = new ArrayList<T>();
    //_size = 0;
    //_front = 0;
    //_end = -1;
  }

  public void enqueue(T val){   //O(1) because arrayList add is O(1)?
     _queue.add(val);
     //_size++;
     //_front = 0;
     //_end++;

  }

  public T dequeue(){         //0(n) because arraylist remove is O(n)
    //remove( index 0)
    T ret = _queue.remove(0);
    //_front++;
  //  _size--;
    return ret;


  }

  public T peekFront(){
    //getFirst()
    T ret = _queue.get(0);  //O(1) because arraylist get is O(1)
    return ret;

  }

  public boolean isEmpty(){
    // size == 0
    return _queue.size() == 0;    //O(1) because it's just a comparison
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
      ALQueue<String> bob = new ALQueue<String>();

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
