/*
UnicornHead: Ariella Katz, Melody Lew, Lior Piloschouk, Tom, Ollie, Toothless
APCS
hw20 - External Audit
2021-10-19
*/

/*
DISCO:
0. Our conditional statements can be rewritten to contain only if statements, excluding
   the else statements.
QCC:
0. Why do their methods return the previous value of the attribute instead of the updated
   one? Yes, the value of the attribute is updated, which is the most important thing,
   but why wouldn't it be more useful to return the new value instead of the old one?
    This being said, their account info can still be updated with ease without returning
    the newest info for each attribute, so what is the purpose of returning anything at
    all?
1. Their authenticate() method is very elegant. The expression being returned will either
   be true or false based on the inputted accountNumber and pass, and this truth value
   will be returned; it's redundant to make an entire if statement (as we did) to tell
   Java to return true if the expression is true and return false if the expression is
   false when we could just have Java return the boolean expression.
2. All of the code in Geese's main() seems to be executable from ours. However, one thing
   that they could potentially do from their main() that we could not might be to print
   any of the attributes (using System.out.println, not toString()), since they're
   private.
*/

public class Teller{

 public static void main(String[] args){
  BankAccount ba = new BankAccount();

  System.out.println("Testing w/ valid cases:");

  System.out.println("Setting account info:");
  ba.setName("Lady Bartholomew");
  ba.setPasswd("BicornHead");
  ba.setPin((short) 2023);
  ba.setAcctNum(202120231);
  ba.setBalance(1000.00);
  System.out.println(ba.toString());

  System.out.println("Depositing $100.00:");
  ba.deposit(100.00);
  System.out.println(ba.toString());

  System.out.println("Withdrawing $1000.00:");
  ba.withdraw(1000.00);
  System.out.println(ba.toString());

  System.out.println("Authenticate:");
  System.out.println(ba.authenticate(202120231, "BicornHead"));

  System.out.println("----------------");
  System.out.println("Testing w/ invalid cases:");

  System.out.println("Setting invalid pin:");
  ba.setPin((short) 0000);
  System.out.println(ba.toString());

  System.out.println("Resetting pin, setting invalid account number:");
  ba.setPin((short) 2023);
  ba.setAcctNum(000000000);
  System.out.println(ba.toString());

  System.out.println("Resetting account number, withdrawing too much:");
  ba.setAcctNum(202120231);
  ba.withdraw(100000.00);
  System.out.println(ba.toString());

  System.out.println("Authenticate:");
  System.out.println(ba.authenticate(123456789, "UnicornHead"));

//  System.out.println(ba.name); //Throws an error - see QCC2
 } 

}
