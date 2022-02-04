/*
UnicornHead: Melody Lew, Ariella Katz, Lior Polischouk, Tom, Toothless, Ollie
APCS
HW19 - Mo Money Mo Problems ...MORE AWESOME
2021-10-18
*/

/* 
DISCO
 0. If an if statement contains more than one boolean expression, the expressions should
    all be surrounded with parentheses.
 1. You do not need a return statement inside both the if and else statement, as long as 
    there is a return statement at the end of the conditional.

QCC
 0. Why does Java accept 12345678 but throws the error "integer too large" with 012345678?
 1. Why is the balance 100.52000000000001 when the input was only 100.51?

*/

public class BankAccount{
  private String name;
  private String passwd;
  private short pin;
  private int acctNum;
  private double balance;

 //------------------------------------------------

  public String setName(String newName){
    name = newName;
    return name;
  }

  public String setPasswd(String newPasswd){
    passwd = newPasswd;
    return passwd;
  }

  public short setPin(short newPin){
   if (((short) 1000 <= newPin) && ((short) 9998 >= newPin)){
    pin = newPin;
    return pin;
    }
    else{
     pin = 9999;
     System.out.println("Error: Invalid pin");
     return pin;
    }
  }

  public int setAcctNum(int newAcctNum){
   if ((100000000 <= newAcctNum) && (999999998 >= newAcctNum)){
    acctNum = newAcctNum;
    return acctNum;
    }
    else{
     acctNum = 999999999;
     System.out.println("Error: Invalid account number");
     return acctNum;
    }
  }

  public double setBalance(double newBalance){
    balance = newBalance;
    return balance;
  }
 
 //------------------------------------------------

  public void deposit(double depositAmount){
    balance = balance + depositAmount;
  }

  public boolean  withdraw(double withdrawAmount){
   if (withdrawAmount <= balance){
    balance = balance - withdrawAmount;
    return true;
    }
    else{
     System.out.println("Error: Insufficient balance");
     balance = balance;
     return false;
    }
  }

  public String toString(){
    return ("" + name + "\n" + passwd + "\n" + pin + "\n" + acctNum + "\n" + balance); 
  }

  public boolean authenticate(int authAcctNum, String authPasswd){
   if ((acctNum == authAcctNum) && (passwd == authPasswd)){
    return true;
    }
    else{
     return false;
    }
  }

  public static void main(String[] args){
    BankAccount account = new BankAccount();
    account.setName("Bob Smith");
    account.setPasswd("1234Unicorn");
    account.setPin((short) 5678);
    account.setAcctNum(123456789);
    account.setBalance(100.51);
    System.out.println(account.toString()); 
    System.out.println("\n");
    account.deposit(0.01);
    System.out.println(account.toString()); //Geese
    System.out.println("\n");
    account.withdraw(99.99);
    System.out.println(account.toString()); //Geese
    System.out.println("\n");
    account.setPin((short) 0123); //testing error message
    account.setAcctNum(12345678); //testing error message
    System.out.println(account.toString());
    System.out.println("\n");
    account.setPin((short) 5678);
    account.setAcctNum(123456789);
    account.withdraw(1000.00); //testing error message
    System.out.println(account.toString());
    System.out.println("\n");
    String tf = "" + account.authenticate(123456789, "1234Unicorn"); //testing authenticate part 1
    System.out.println(tf);
    tf = "" + account.authenticate(987654321, "Unicorn1234"); //testing authenticate part 2
    System.out.println(tf);
  }
}
