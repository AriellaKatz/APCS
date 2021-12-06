//Team ABA -- Ariella Katz, Alif Rahman, Brianna Tieu, Tom, Grippy, Pepe
//APCS
//HW42 -- Be More Rational
//2021-12-02
//time Spent: 0.5 hr

/*
DISCO:
0. If you only have if statements and no return statement outside of them, Java
   will say you're missing a return statement even if the if statements cover
   all possible cases but if you also have an else statement that returns
   something, then it's fine.
QCC:
0. In the method compareTo(), since it's supposed to return an int whose sign
   indicates which Rational is bigger (the int represents the sign of their
   difference) and we're already using subtract() anyways, why don't we just
   return the difference and check if it's positive or negative, since we're
   basically already there? 
*/

public class Rational {
  protected int p;
  protected int q;

  public Rational() {
    p = 0;
    q = 1;
  }

  public Rational(int x, int y) {
    p = x;
    q = y;
    if ( y == 0 ) {
      p = 0;
      q = 1;
      System.out.println("Invalid denominator input -> Rational set to 0/1");
    }
  }

  public double floatValue() {
    double floatNum = ( (double) p / q);
    return floatNum;
  }

  public String toString() {
    String str = p + "/" + q;
    return str;
  }

  public void multiply(Rational Q) {
    this.p = this.p * Q.p;
    this.q = this.q * Q.q;
  }

  public void divide(Rational Q) {
    this.p = this.p * Q.q;
    this.q = this.q * Q.p;
  }

  public void add(Rational Q) {
    int newp;
    int newq;
    newp = this.p * Q.q;
    newq = this.q * Q.q;
    Q.p = Q.p * this.q;
    Q.q = Q.q * this.q;
    this.p = newp;
    this.q = newq;
    this.p = this.p + Q.p;
  }

  public void subtract(Rational Q) {
    int newp;
    int newq;
    newp = this.p * Q.q;
    newq = this.q * Q.q;
    Q.p = Q.p * this.q;
    Q.q = Q.q * this.q;
    this.p = newp;
    this.q = newq;
    this.p = this.p - Q.p;
  }

  public void reduce() {
    int gcd = gcd();
    this.p = this.p/gcd;
    this.q = this.q/gcd;
  }

  public int compareTo(Rational Q) {
    //Key: Returns 0 if ==, 1 if Q is smaller, -1 if Q is bigger
    subtract(Q);
    if (this.p > 0) { return 1; }
    if (this.p == 0) { return 0; }
    else { return -1; }
  }

  public static int gcd( int a, int b ) {
    if ((a == 0) && (b == 0)) { 
      System.out.println("Error: Invalid inputs");
      return 0;
    }

    if (a == 0) { return b; }
    if (b == 0) { return a; }
    if (a <= b) { return gcd(a, b-a); }
    else { return gcd(a-b, b); }
  }

  public int gcd() {
    int gcd = gcd(this.p, this.q);
    return gcd;
  }

  public static void main(String[] args) {
    Rational test = new Rational(2, 3);
    Rational pog = new Rational(3, 4);

    System.out.println("test: " + test + "\tpog: " + pog);

    System.out.print("test as floating-point number: ");
    System.out.println(test.floatValue());

    System.out.print("multiplying test: ");
    test.multiply(pog);
    System.out.print(test + " -> ");
    test.reduce();
    System.out.println(test);

    System.out.print("dividing test back: ");
    test.divide(pog);
    System.out.print(test + " -> ");
    test.reduce();
    System.out.println(test);

    System.out.print("adding test: ");
    test.add(pog);
    System.out.print(test + " -> ");
    test.reduce();
    System.out.println(test);

    System.out.print("subtracting test back: ");
    test.subtract(pog);
    System.out.print(test + " -> ");
    test.reduce();
    System.out.println(test);

    System.out.print("test vs pog: ");
    System.out.println(test.compareTo(pog));

    System.out.println("---------------------------");

    System.out.println("Trying 4/0...");
    Rational zeroDenom = new Rational(4, 0);
    System.out.println("zeroDenom: " + zeroDenom);
  }
}
