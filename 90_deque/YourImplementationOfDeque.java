// Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz)
// APCS Pd 6
// HW90: Swabbing the Deque
// 2022-04-12
// Time Spent: 0.5 hrs

import java.util.LinkedList;

public class YourImplementationOfDeque<D> implements Deque<D>{
  LinkedList<D> _Deque;

  public YourImplementationOfDeque(){
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

  // public boolean offerFirst(D val){
  //     return _Deque.offerFirst(val);
  // }
  //
  // public boolean offerLast(D val){
  //     return _Deque.offerLast(val);
  // }

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

  public static void main(String[] args){
      YourImplementationOfDeque<String> Bob = new YourImplementationOfDeque<String>();
      System.out.println(Bob);
      Bob.addLast("you");
      System.out.println(Bob);
      Bob.addLast("are");
      System.out.println(Bob);
      Bob.addLast("smart.");
      System.out.println(Bob);
      Bob.addFirst("no,");
      System.out.println(Bob);
      System.out.println("Should print : no, you are smart.");

      Bob.removeFirst();
      System.out.println(Bob);
      System.out.println("Should print : you are smart.");
  } // end main
} // end class
