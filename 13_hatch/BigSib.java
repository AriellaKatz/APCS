/*
Excellent Apples: Ariella Katz, Tom, Alif 
APCS
HW13 -- Constructor methods
*/

/*
DISCO:

QCC:

*/

public class BigSib {
 String helloMsg; //declares instance variable helloMsg (of type String)

 public BigSib() {
  helloMsg = "Word up"; //sets "Word up" as the default helloMsg whenever there is a new instance of BigSib
 }

 public void setHelloMsg(String msg) { //note that neither this method nor the one below is static
  helloMsg = msg; //sets helloMsg to whatever msg is inputted as the argument to method setHelloMsg
 }

 public String greet(String name) { //not static because it uses an instance variable
  return(helloMsg + " " + name); //this output will be printed by Greet.java
 }
}
