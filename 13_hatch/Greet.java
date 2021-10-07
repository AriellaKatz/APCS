/*
Ariella Katz
APCS
HW13 -- Constructor methods
2021-10-06
This is a copy of GreetImproved.java from directory 12_bigsib 
  to be used in collaboration with BigSib.java in directory 13_hatch.
*/

public class Greet{
 public static void main(String[] args) {
  String greeting;
  String greeting1;
  String greeting2;
  String greeting3;

  BigSib richard = new BigSib();
//richard.setHelloMsg("Word up"); we don't need this because of constructor method added to BigSib.java

  greeting = richard.greet("freshman");
  System.out.println(greeting);

  BigSib robert = new BigSib();
  robert.setHelloMsg("Salutations");

  greeting1 = robert.greet("Dr. Spaceman");
  System.out.println(greeting1);

  BigSib raymond = new BigSib();
  raymond.setHelloMsg("Hey ya");

  greeting2 = raymond.greet("Kong Fooey");
  System.out.println(greeting2);

  BigSib russel = new BigSib();
  russel.setHelloMsg("Sup");

  greeting3 = russel.greet("mom");
  System.out.println(greeting3);

 }
}
