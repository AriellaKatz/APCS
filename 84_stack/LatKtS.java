/*
Team Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz, Tom, Preguac, Applesauce)
APCS pd6
HW84: Stack: What is it good for?
2022-03-29
time spent: too many hours
QCC
Is it possible that a linked list would be better for this ?
String work sucks.
had to add the last character to retStr outside for loop since for loop only goes to s.length() - 1
*/


/***
 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
 **/

public class LatKtS
{

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **/
  public static String flip( String s )
  {
    String retStr = "";
    Latkes stack = new Latkes(s.length());

    for (int i = 0; i < s.length(); i ++){
      String letter = s.substring(i, i+1);
      stack.push(letter);
    }

    for (int i = s.length(); i > 0; i--){
      retStr += stack.pop();
    }

    return retStr;
  }


  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **/
  public static boolean allMatched( String s )        //is this recursion ?
  {
    /*
    algo- find first pair. For allMatched to be true, their needs to be at least one pair "()", "[]","{}" somewhere.
    push the string into a stack until you find a pair. pop out the pair then push rest of string. repeat until no pairs found or all pairs found.
    */
    boolean finalMatch = false;
    String parenthesis = "()";
    String bracket = "[]";
    String brace = "{}";
    String retStr = "";
    //Latkes stack = new Latkes(s.length());
    Latkes pair = new Latkes(s.length());

    if(s.length() % 2 == 1){
        finalMatch = false;
        return finalMatch;
    }

    for (int i = 0; i < s.length() - 1; i ++){
        String duo = s.substring(i, i+2);
        String letter = s.substring(i, i+1);
        if(duo.equals(parenthesis) || duo.equals(bracket) || duo.equals(brace)){
            pair.push(duo);
            i+=1;
          //  System.out.println(i);
        }else{
            retStr += letter;
          //  System.out.println(i);
        }
    }
    if(retStr.length() == 0){
        finalMatch = true;
        return finalMatch;
    }
    retStr += s.substring(s.length()-1);
    //System.out.println(retStr);

    if(pair.isEmpty() == true){
      return false;
    }else{
      return allMatched(retStr);
    }

  }
  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class
