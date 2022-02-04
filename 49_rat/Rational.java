//Team ABA -- Ariella Katz, Alif Rahman, Brianna Tieu, Tom, Grippy, Pepe
//APCS
//HW49 -- Rational Standards Compliance
//2021-12-22
//time Spent: 0.5 hr

/*
DISCO:
0. Even if you tell Java to throw an error if the object is not a Rational,
   you still need to typecast the object as a Rational because otherwise
   whenever Java reads code that references the object, it won't know that
   you've confirmed that the Object is a Rational and it'll think it could be
   anything.
QCC:
0. What is the purpose of equals() when we can just use compareTo()?
1. Our algorithm for compareTo() only works if both Rationals are positive.
*/

public class Rational implements Comparable{
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

  public int compareTo(Object o) {
    if (!(o instanceof Rational)) {
      throw new ClassCastException("\ncompareTo() input not a Rational");
    }
    Rational r = (Rational)o;
    //Key: Returns 0 if ==, 1 if Q is smaller, -1 if Q is bigger
    subtract(r);
    if (this.p > 0) { return 1; }
    else if (this.p == 0) { return 0; }
    else { return -1; }
  }

  public static int gcd( int a, int b ) {
    if ((a == 0) && (b == 0)) {
      System.out.println("Error: Invalid inputs");
      return 0;
    }

    if (a == 0) { return b; }
    else if (b == 0) { return a; }
    else if (a <= b) { return gcd(a, b-a); }
    else { return gcd(a-b, b); }
  }

  public int gcd() {
    int gcd = gcd(this.p, this.q);
    return gcd;
  }

  public boolean equals(Object other) {
    if (!(other instanceof Rational)) { return false; }
    Rational r = (Rational)other;
    this.reduce();
    r.reduce();
    return ((this.p == r.p) && (this.q == r.q));
  }

}
