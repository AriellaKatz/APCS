/*
   Geese: Weichen Liu + Blueface, Anthony Sun + Corn, Brian Li + Robert
   APCS pd6
   HW19 -- adding more functionality
   2021-10-18
*/

/*
 * DISCO:
 * We learned how to typecast an int to a short primitive
 * You have to return a boolean in both parts of the if else statement if you plan to make the return type of the method a boolean.
 
 * Q/C/C:
 * Authenticate still isn't useful right now, because it cannot be used in deposit/withdraw (no params to take in accnt info)
*/

public class BankAccount {

  //instance variables
  private String name;
  private String passwd;
  private short pin;
  private int acctNum;
  private double balance;
  //---------------------------------------------


  //mutators
  public String setName( String newName ) {
    String oldName = name;
    name = newName;
    return oldName;
  }

  public String setPasswd( String newPasswd ) {
    String oldPasswd = passwd;
    passwd = newPasswd;
    return oldPasswd;
  }

  public short setPin( short newPin ) {
    short oldPin = pin;
    if (!(newPin < (short) 9999 && newPin >= (short) 1000)) {
	newPin = (short) 9999;
	System.out.println("Your pin number is invalid, please try again");
    }
    pin = newPin;
    return oldPin;
  }

  public int setAcctNum( int newAcctNum ) {
    int oldAcctNum = acctNum;
    if (!(newAcctNum < 999999999 && newAcctNum >= 100000000)) {
        newAcctNum = 999999999;
    	System.out.println("Your account number is invalid, please try again.");
    }
    acctNum = newAcctNum;
    return oldAcctNum;
  }

  public double setBalance( double newBalance ) {
    double oldBalance = balance;
    balance = newBalance;
    return oldBalance;
  }
  //---------------------------------------------


  public void deposit( double depositAmount ) {
    balance = balance + depositAmount;
  }

  public boolean withdraw( double withdrawAmount ) {
    if (balance < withdrawAmount) {
	System.out.println("Sorry, you cannot withdraw more than your current balance.");
	return false;
    }
    balance = balance - withdrawAmount;
    return true;
  }

  public boolean authenticate(int accountNumber, String pass) {
	return acctNum == accountNumber && passwd == pass;
  }

  //overwritten toString()
  public String toString() {
    String retStr = "\nAccount info:\n=======================";
    retStr = retStr + "\nName: " + name;
    retStr = retStr + "\nPassword: " + passwd;
    retStr = retStr + "\nPIN: " + pin;
    retStr = retStr + "\nAccount Number: " + acctNum;
    retStr = retStr + "\nBalance: " + balance;
    retStr = retStr + "\n=======================";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args ) {
    // INSERT YOUR METHOD CALLS FOR TESTING HERE
    BankAccount ba = new BankAccount();
    ba.setName("Geese");
    ba.setPasswd("qwertyuiop1234");
    
    System.out.println("\nInvalid pin #:");
    ba.setPin((short) 12345);
    
    ba.setPin((short) 1234);
    System.out.println("\nInvalid accnt number:");
    ba.setAcctNum(100);
    ba.setAcctNum(100000012);
    ba.setBalance(100);
    System.out.print("\nTesting valid account # and password: ");
    System.out.println(ba.authenticate(100000012,"qwertyuiop1234"));
    System.out.print("\nTesting invalid account # and password: ");
    System.out.println(ba.authenticate(123,"asdf"));

    System.out.println(ba.toString());
    System.out.println("\ndeposited 40 dollars:");
    ba.deposit(40);
    System.out.println(ba.toString());
    System.out.println("\nwithdrew 50 dollars:");
    ba.withdraw(50);
    System.out.println(ba.toString());

    System.out.println("Testing invalid withdrawal - withdraw amt > balance:");
    System.out.println(ba.withdraw(10000));
  }//end main()

}//end class BankAccount
