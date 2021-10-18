/*
UnicornHead: Melody, Ariella, Lior, Tom, Toothless, Ollie
APCS
HW18 - CPA-One
2021-10-14
*/

/* 
DISCO
 0. We can call non-static methods from main by creating a new instance of the class (call this object 
    "account") and calling account.methods. 
 1. We can convert a value to a different datatype by preceding the value with the new datatype in ().
 2. /n can be used to make a new line.
 3. You can have non-String values in a String as long as they are concatenated somewhere with a
    String.

QCC
 0. Why doesn't toString run if the returntype is void instead of String?
 1. Does java assume that all integer numbers are of type int, rather than short, for example?
    Could the same be said for doubles and longs?

Team UnicornHead’s Latest and Greatest Q2 Response:
The code 
  Class name = new Class()
will produce a new instance of the class. Since constructors are required to create new objects,
and you haven't made a constructor yet, Java must have provided one for you. If you then run
  name.method(args)
it will return the expected value (for visual confirmation).

Team UnicornHead’s Latest and Greatest Q3 Response:
If the following code is compilable and produces a sequence of letters and numbers after being
executed, then Java provides a means for outputting a String representation of an object.
  System.out.println(object.toString());
(This means is the toString method provided by Java.)
*/

public class BankAccount{
  private String name;
  private String passwd;
  private short pin;
  private int acctNum;
  private double balance;

  public String setName(String newName){
    name = newName;
    return name;
  }
  public String setPasswd(String newPasswd){
    passwd = newPasswd;
    return passwd;
  }
  public short setPin(short newPin){
    pin = newPin;
    return pin;
  }
  public int setAcctNum(int newAcctNum){
    acctNum = newAcctNum;
    return acctNum;
  }
  public double setBalance(double newBalance){
    balance = newBalance;
    return balance;
  }

  public void deposit(double depositAmount){
    balance = balance + depositAmount;
  }

  public void withdraw(double withdrawAmount){
    balance = balance - withdrawAmount;
  }

  public String toString(){
    return ("" + name + "\n" + passwd + "\n" + pin + "\n" + acctNum + "\n" + balance); 
  }

  public static void main(String[] args){
    BankAccount account = new BankAccount();
    account.setName("Bob Smith");
    account.setPasswd("1234Unicorn");
    account.setPin((short) 5678);
    account.setAcctNum(123456789);
    account.setBalance(100.51);
    account.deposit(0.01);
    account.withdraw(99.99);
    System.out.println(account.toString());
  }
}
