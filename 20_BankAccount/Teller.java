/*
UnicornHead: Ariella Katz, Melody Lew, Lior Piloschouk, Tom, Ollie, Toothless
APCS
hw20 - 
2021-10-19
*/

/*
DISCO:

QCC:

*/

public class Teller{

 public static void main(String[] args){
  BankAccount ba = new BankAccount();
  System.out.println("Testing w/ valid cases:");
  ba.setName("Lady Bartholomew");
  ba.setPasswd("BicornHead");
  ba.setPin((short) 2023);
  ba.setAcctNum(202120231);
  ba.setBalance(1000.00);
  System.out.println(ba.toString());
  System.out.println("\n");
  ba.deposit(100.00);
  System.out.println(ba.toString());
  System.out.println("\n");
  ba.withdraw(1000.00);
  System.out.println(ba.toString());
  System.out.println("\n");
  System.out.println(ba.authenticate(202120231, "BicornHead"));
  System.out.println("----------------");
  System.out.println("Testing w/ invalid cases:");
  ba.setPin((short) 0000);
  System.out.println(ba.toString());
  System.out.println("\n");
  ba.setPin((short) 2023);
  ba.setAcctNum(000000000);
  System.out.println(ba.toString());
  System.out.println("\n");
  ba.setAcctNum(202120231);
  ba.withdraw(100000.00);
  System.out.println(ba.toString());
  System.out.println("\n");
  System.out.println(ba.authenticate(123456789, "UnicornHead"));

 } 

}
