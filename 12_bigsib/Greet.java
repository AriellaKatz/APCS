/*
Ariella Katz
APCS
HW12 -- Instance variables
2021-10-05
This is a revised version of Greet.java from directory 10_bigsib 
  to be used in collaboration with BigSib.java in directory 12_bigsib.
*/

public class Greet{
 public static void main(String[] args) {
  String greeting;

  BigSib richard = new BigSib();
  richard.setHelloMsg("Word up");

  greeting = richard.greet("freshman");
  System.out.println(greeting);

 }
}
