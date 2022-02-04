/*
Ariella Katz
APCS
HW12 -- Instance variables
This is a revised version of Greet.java from directory 10_bigsib 
  to be used in collaboration with BigSib.java in directory 12_bigsib.
*/

public class GreetImproved{
 public static void main(String[] args) {
  String greeting;
  String greeting1;
  String greeting2;
  String greeting3;

  BigSibImproved richard = new BigSibImproved();
  richard.setHelloMsg("Word up");

  greeting = richard.greet("freshman");
  System.out.println(greeting);

  BigSibImproved robert = new BigSibImproved();
  robert.setHelloMsg("Salutations");

  greeting1 = robert.greet("Dr. Spaceman");
  System.out.println(greeting1);

  BigSibImproved raymond = new BigSibImproved();
  raymond.setHelloMsg("Hey ya");

  greeting2 = raymond.greet("Kong Fooey");
  System.out.println(greeting1);

  BigSibImproved russel = new BigSibImproved();
  russel.setHelloMsg("Sup");

  greeting3 = russel.greet("mom");
  System.out.println(greeting3);

 }
}
