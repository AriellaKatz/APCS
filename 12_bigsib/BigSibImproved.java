/*
Phase 0: Ariella Katz, Tom, Jacob Kirmayer, Jacob Jr, Nafiz Labib, Martha
APCS
HW12 -- Instance variables
worked with Kaitlin Ho, Ziying Jain
*/

/*
DISCO:
Instance variables are used to create a new instance of a class with specific arguments for its methods.
QCC:
I'm really confused. 
I'm not sure where the instance variable helloMsg is supposed to come into play. Isn't richard an instance
 variable? (see Greet.java)
What does static mean?
*/

public class BigSibImproved {
 String helloMsg;

 public void setHelloMsg(String msg) {
  helloMsg = msg; 
 }

 public String greet(String name) {
  return(helloMsg + " " + name + "\n");
 }
}
