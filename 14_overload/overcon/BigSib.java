/*
Excellent Apples: Ariella Katz, Tom, Alif Rahman, Grippy, Nafiz Labib, Martha
APCS
HW14 -- Overloading constructors to take arguments
2021-10-07
*/

/*
DISCO:
You're allowed to have a constructor that takes arguments without having a default constructor
 (one that doesn't take arguments). Here, we have no use for the default, because its only purpose
 is to set a value for helloMsg, which we immediately alter (or keep the same, in the case of
 "Word up") in the following constructor.
QCC:
Before, we used a regular method to set helloMsg. By now, we've switched to using a constructor for
 the same purpose. Couldn't we do the same for name (if we made name an instance variable) and just
 add another parameter for the constructor? If so, why don't we?
*/

public class BigSib {
 private String helloMsg;

// public BigSib() {       We don't need this constructor! See DISCO
 // helloMsg  = "Word up";
// }

 public BigSib(String msg) {
  helloMsg = msg;
 }

 public String greet(String name) {
  return(helloMsg + " " + name);
 }
}
