/*
Ariella Katz
APCS
HW09 -- Working with classes
2021-10-01
worked with Tom, Jacob Kirmayer, Jacob Jr, Nafiz Labib, Martha
*/

/*
DISCOVERIES:
 Contrary to my "discovery" in HW08, you can in fact print multiple "things"
  in the same print command; you just have to separate them with a +, rather 
  than a ,.
 Class names don't have to match the file name if the class is private.
 Before compiling and running GreetNew.java (which reference this class), I
  first have to compile (but NOT run) this code.
UNRESOLVED QUESTIONS:
 What does it mean for a class to be public or private?
 What does static mean (when creating a method)?
 I've seen code with that references other classes with more than 2 levels
  (ex name1.name2.name3.name4()). How can there be more than just class and a
  method it contains? How do you build something of a higher level than
  class?
*/

public class BigSib {
 public static void greet(String name) {
  System.out.println("What's up, " + name);
 }
}
