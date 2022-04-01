/*
Team Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz, Tom, Preguac, Applesauce)
APCS pd6
HW86: What a Racket
2022-03-31
time spent: 1.0 hours
*/

/*
DISCO:
0. For the return value of evaluate(), we had to pop off the single value left
in stack1 and return that, since stack1 itself cannot be String-ified.
1. *= is a thing!
QCC:
0. None of our Stacks have a toString().
1. How might we do this recursively instead of with a for loop? What would the
base case be?
*/

/***
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Steal underpants.
 *   2. Push elements onto stack 1 until you get to a ).
 *   3. Pop off elements from stack 1 and push them onto stack 2 until you get to a (.
 *   4. Unload stack 2 and push the value onto stack 1.
 *   5. Continue pushing elements onto stack 1 until you finish the String
 *   6. Profit!
 *
 * STACK OF CHOICE: ____ by ____
 * b/c ...
 **/

public class Scheme
{
  /***
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   **/
  public static String evaluate( String expr )
  {
    String[] elements = expr.split("\\s+");
    Stack<String> stack1 = new LLStack<String>();
    Stack<String> stack2 = new LLStack<String>();
    for (int m = 0; m < elements.length; m++) {
      stack1.push(elements[m]);
      if (elements[m].equals(")")) {
        while (!(stack1.peekTop().equals("("))) {
          stack2.push(stack1.pop());
        }

        String val;
        if (stack2.peekTop().equals("+")) {
          stack2.pop();
          val = unload(1, stack2);
        }
        else if (stack2.peekTop().equals("-")) {
          stack2.pop();
          val = unload(2, stack2);
        }
        else {
          stack2.pop();
          val = unload(3, stack2);
        }

        stack1.pop();
        stack1.push(val);
      }
    }
    String retstr = stack1.pop();
    return retstr;
  }//end evaluate()


  /***
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   **/
  public static String unload( int op, Stack<String> numbers )
  {
    Integer retVal;
    if (op == 1) {
      retVal = Integer.parseInt(numbers.pop());
      while (!(numbers.peekTop().equals(")"))) {
        retVal += Integer.parseInt(numbers.pop());
      }
    }
    else if (op == 2) {
      retVal = Integer.parseInt(numbers.pop());
      while (!(numbers.peekTop().equals(")"))) {
        retVal -= Integer.parseInt(numbers.pop());
      }
    }
    else {
      retVal = Integer.parseInt(numbers.pop());
      while (!(numbers.peekTop().equals(")"))) {
        retVal *= Integer.parseInt(numbers.pop());
      }
    }
    String retStr = "" + retVal;
    return retStr;
  }//end unload()


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
  }
  catch( NumberFormatException e ) {
  return false;
  }
  }
  */


  //main method for testing
  public static void main( String[] args )
  {

      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
          /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main()

}//end class Scheme
