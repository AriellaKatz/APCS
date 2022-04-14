// Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz)
// APCS Pd 6
// HW91: Deque the Halls
// 2022-04-13
// Time Spent: 1.0 hrs

import java.util.LinkedList;
import java.util.Iterator;

public class Dequey<D> implements Deque<D>{
  LinkedList<D> _Deque;

  public Dequey(){
      _Deque = new LinkedList<D>();
  }

  public void addFirst(D val){
      _Deque.addFirst(val);
  }

  public void addLast(D val){
      _Deque.addLast(val);
  }

  public D removeFirst(){
      return  _Deque.remove();
  }

  public D removeLast(){
      return _Deque.removeLast();
  }

  public D getFirst(){
      return _Deque.getFirst();
  }

  public D getLast(){
      return _Deque.getLast();
  }

  public D peekFirst(){
      return _Deque.peekFirst();
  }

  public D peekLast(){
      return _Deque.peekLast();
  }

  public D pollFirst(){
      return _Deque.pollFirst();
  }

  public D pollLast(){
      return _Deque.pollLast();
  }

  public boolean offerFirst(D val){
      return _Deque.offerFirst(val);
  }

  public boolean offerLast(D val){
      return _Deque.offerLast(val);
  }

  public boolean add(D val){
    return _Deque.add(val);
  }

  public boolean offer(D val){
    return _Deque.offer(val);
  }

  public D remove(){
    return _Deque.remove();
  }

  public D poll(){
    return _Deque.poll();
  }

  public D element(){
    return _Deque.element();
  }

  public D peek(){
    return _Deque.peek();
  }

  public boolean contains(D val){
    return _Deque.contains(val);
  }

  public int size(){
    return _Deque.size();
  }

  public Iterator<D> iterator(){
    return _Deque.iterator();
  }

  public boolean removeFirstOccurrence(D val){
    return _Deque.removeFirstOccurrence(val);
  }

  public boolean removeLastOccurrence(D val){
    return _Deque.removeLastOccurrence(val);
  }

  public void push(D val){
    _Deque.push(val);
  }

  public D pop(){
    return _Deque.pop();
  }

  public Iterator<D> descendingIterator(){
    return _Deque.descendingIterator();
  }

  public String toString()
  {
    String retStr = "FRONT :: ";
    for(int i = 0; i < _Deque.size(); i ++){
        retStr += _Deque.get(i);
        retStr += ", ";
    }
    retStr += " :: END";
    return retStr;
  }//end toString()

} // end class
