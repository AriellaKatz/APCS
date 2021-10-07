/* 
Ariella Katz
APCS
HW14 -- Overloading constructors
2021-10-07
This class is used in conjunction with BigSib.java in the same directory.
*/

public class Greet {
 public static void main( String[] args ) {
  String greeting;
  BigSib richard = new BigSib("Word up");
  BigSib grizz = new BigSib("Salutations");
  BigSib dotCom = new BigSib("Hey ya");
  BigSib tracy = new BigSib("Sup");
  greeting = richard.greet("freshman");
  System.out.println(greeting);
  greeting = grizz.greet("Dr. Spaceman");
  System.out.println(greeting);
  greeting = dotCom.greet("Kong Fooey");
  System.out.println(greeting);
  greeting = tracy.greet("mom");
  System.out.println(greeting);
 }
}
