// Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz)
// APCS Pd 6
// HW91: Deque the Halls
// 2022-04-13
// Time Spent: 1.0 hrs

import java.util.Iterator;

public class DeDriver {

  public static void main(String[] args){
      Dequey<String> Bob = new Dequey<String>();
      System.out.println("Bob : " + Bob);
      Bob.addLast("you");
      System.out.println("Bob : " + Bob);
      Bob.addLast("are");
      System.out.println("Bob : " + Bob);
      Bob.addLast("smart.");
      System.out.println("Bob : " + Bob);
      Bob.addFirst("no,");
      System.out.println("Bob : " + Bob);
      System.out.println("Should print : no, you are smart.");

      Bob.removeFirst();
      System.out.println("Bob : " + Bob);
      System.out.println("Should print : you are smart.");
      Bob.removeLast();
      System.out.println("Bob : " + Bob);
      System.out.println("Should print : you are");
      System.out.println("First : " + Bob.getFirst());
      System.out.println("Last : " + Bob.getLast());

      Bob.add("you");
      Bob.add("are");
      System.out.println("Bob : " + Bob);
      System.out.println("Should print : you are you are");
      Bob.removeFirstOccurrence("you");
      Bob.removeLastOccurrence("are");
      System.out.println("Bob : " + Bob);
      System.out.println("Should print : are you");

      System.out.println("First : " + Bob.peekFirst());
      System.out.println("Last : " + Bob.peekLast());

      Bob.remove();
      Bob.remove();
      System.out.println("Bob : " + Bob);
      System.out.println("Should print : ");
      System.out.println("pollFirst : " + Bob.pollFirst());
      System.out.println("Bob : " + Bob);
      System.out.println("Should print : ");
      System.out.println("pollLast : " + Bob.pollLast());
      System.out.println("Bob : " + Bob);
      System.out.println("Should print : ");

      Bob.add("to");
      Bob.add("be");
      Bob.add("or");
      Bob.add("not");
      Bob.add("to");
      Bob.add("be");
      System.out.println("Bob : " + Bob);
      System.out.println("Should print : to be or not to be");
      System.out.println("Size : " + Bob.size());
      System.out.println("element : " + Bob.element());
      System.out.println("Bob : " + Bob);
      System.out.println("Should print : to be or not to be");
      System.out.println("Contains 'question' : " + Bob.contains("question"));
      System.out.println("Contains 'be' : " + Bob.contains("be"));

      Bob.push("?");
      System.out.println("Bob : " + Bob);
      System.out.println("Should print : ? to be or not to be");
      System.out.println("pop : " + Bob.pop());
      System.out.println("Bob : " + Bob);
      System.out.println("Should print : to be or not to be");

      System.out.println("ascending iterator : ");
      Iterator<String> it1 = Bob.iterator();
      while(it1.hasNext()) {
        String s = it1.next();
        System.out.println(s);
      }

      System.out.println("descending iterator : ");
      Iterator<String> it2 = Bob.descendingIterator();
      while(it2.hasNext()) {
        String s = it2.next();
        System.out.println(s);
      }

  } // end main

}
