/*
AKH+D :: Ariella Katz, Kaitlin Ho, Hugo Jenkins
APCS pd6
HW 99 - Some Are More Equal Than Others, Codified
2022-05-13
time spent: 1.0 hrs
*/

import java.util.*;

public class ArrayPriorityQueue<Integer> {

  private ArrayList<Integer> _pq;

  public ArrayPriorityQueue() {
    _pq = new ArrayList<Integer>();
  }

  public void add(Integer x) {
    _pq.add(x);
  }

  public boolean isEmpty() {
    return (_pq.size() == 0);
  }

  public Integer peekMin() {
    if (!isEmpty()) {
      Integer min = Integer.MAX_VALUE;
      for (int i = 0; i < _pq.size(); i++) {
        if (_pq.get(i) < min) {
          min = _pq.get(i);
        }
      }
      return min;
    }
    else {
      return null; //returns null if the whole thing is empty
    }
  }

  public Integer removeMin() {
    if (!isEmpty()) {
      int minInd = 0;
      for (int i = 0; i < _pq.size(); i++) {
        if (_pq.get(i) < _pq.get(minInd)) {
          minInd = i;
        }
      }
      return _pq.remove(i);
    }
    else {
      return null; //returns null if it's already empty
    }
  }

  public static void main(String[] args) {
    ArrayPriorityQueue<Integer> dn = new ArrayPriorityQueue();
  }

}
