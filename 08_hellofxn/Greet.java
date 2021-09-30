/*
Ariella Katz
APCS
HW08 -- Building off of No hablo queso and Hello, world!
*/

/*
DISCOVERIES:
 You can't use 1 print command to print multiple things 
  (ie System.out.println(string, ", ", name)). You have to use a separate
  command for each. (I forgot this from the summer homework.)
UNRESOLVED QUESTIONS:
 What does it mean to pull a file?
 Why is it that if I create a file through the terminal and add it to my
  GitHub repository, and then access the file through github.com and make 
  some changes there, if I then access the file again through the terminal
  the changes won't be there?
 Why can I access my work repository through my personal computer but none
  of the directories in it are there? I think this has something to do with
  pulling.
*/

public class Greet{
 public static void greet(String string, String name) {
  System.out.print(string);
  System.out.print(", ");
  System.out.println(name);
 }

 public static void main(String[] args) {
  String name1 = "Ho"; //As in Kaitlin Ho (no profanities here!)
  String name2 = "Aleenis";
  String name3 = "Tom";
  greet("What's  up", name1);
 }
}
