/*
Excellent Apples: Ariella Katz, Tom, Alif Rahman, Grippy, Nafiz Labib, Martha
APCS
HW14 -- Overloading constructors
2021-10-07
*/

/*
DISCO:

QCC:
Is there any way to customize helloMsg instead of having all of them be "Word up"?
*/

public class BigSib {
 String helloMsg;

 public BigSib() {
  helloMsg = "Word up"; //Since "Word up" is the default and Greet.java 
// (which we're basing this off of) doesn't provide any alternatives, 
// all of the greetings will be "Word up".
 }

 public String  greet(String name) {
  return(helloMsg + " " + name);
 }
}
