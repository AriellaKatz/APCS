// Clyde "Thluffy" Sinclair
// APCS p0
// HW49 -- implementing an interface from standard library
// 2021-12-23r

/**
 * class Rational (v3)
 * stores a rational number (p/q s.t. p,q ints && q!=0)
 * facilitates
 * multiplication
 * division
 * reduction
 * comparison
 **/

public class RationalLib implements Comparable
{
  // Instance variables for numerator and denominator
  private int _numerator;
  private int _denominator;


  /***
   * Default constructor (no parameters)
   * @return a new Rational with value 0/1
   ***/
  public RationalLib()
  {
    _numerator = 0;
    _denominator = 1;
  }


  /***
   * Overloaded constructor
   * @param numerator
   * @param denominator
   * if an invalid denominator is attempted, should print a message and set the number to 0/1
   ***/
  public RationalLib( int n, int d )
  {
    this();
    if ( d != 0 ) {
      _numerator = n;
      _denominator = d;
    }
    else {
      System.out.println( "Invalid number. " +
                          "Denominator set to 1." );
    }
  }


  // toString
  // returns a string representation of the rational number (formatting of your choice)
  public String toString()
  {
    return _numerator + " / " + _denominator;
  }


  // floatValue
  // returns floating point approximation of the number
  // uses the most precise floating point primitive
  public double floatValue()
  {
    return (double)_numerator / _denominator;
  }


  // multiply
  // takes a Rational parameter and multiplies it by this Rational
  // does not return a value
  // modifies this object, leaves parameter alone
  // need not reduce
  public void multiply( RationalLib r )
  {
    _numerator   = this._numerator   * r._numerator;
    _denominator = this._denominator * r._denominator;
  }


  // divide
  // works the same as multiply, except the operation is division
  public void divide( RationalLib r )
  {
    if ( r._numerator != 0 ) {
      _numerator   = _numerator   * r._denominator;
      _denominator = _denominator * r._numerator;
    }
    else {
      System.out.println( "Div by 0 error. Values unchanged." );
    }
  }


  //increases this Rational by value of input Rational
  public void add( RationalLib r )
  {
    _numerator = _numerator * r._denominator + r._numerator * _denominator;
    _denominator = _denominator * r._denominator;
  }


  //decreases this Rational by value of input Rational
  public void subtract( RationalLib r )
  {
    _numerator = _numerator * r._denominator - r._numerator * _denominator;
    _denominator = _denominator * r._denominator;
  }


  //reduces this Rational to simplest fraction
  public void reduce()
  {
    int g = gcd();
    _numerator = _numerator / g;
    _denominator = _denominator / g;
  }


  //calculates GCD/GCF of numerator and denominator
  public int gcd()
  {
    return gcd( _numerator, _denominator );
  }


  //calculates GCD/GCF of two int inputs
  public static int gcd( int n, int d )
  {
    int a, b, x;

    a = n;
    b = d;

    while( a % b != 0 ) {
      x = a;
      a = b;
      b = x % b;
    }

    return b;
  }


  /***
   * boolean equals(Object) -- tells whether 2 Objs are equivalent
   * pre:  other is an instance of class Rational
   * post:
   * @return true if this and other are aliases (pointers to same
   *   Object), or if this and other have matching attribute values.
   *   (which in this case indicates equivalent fractions)
   ***/
  public boolean equals( Object other )
  {
    if ( !(other instanceof RationalLib) ) {
      System.out.println("not a rational");
      return false;
    }

    //First, reduce both fractions.
    //...thus allowing for direct comparison of attributes
    this.reduce();
    ((RationalLib)other).reduce();

    return this == other //check for aliases
      ||
      ( this._numerator == ((RationalLib)other)._numerator
       && this._denominator == ((RationalLib)other)._denominator);
  }//end equals()


  /***
   * int compareTo(Object) -- tell which of two Rationals is greater
   *  pre:
   *  post:
   * @throws exception if input not an instance of class Rational.
   * @return 0 if this Rational equiv to Rational argument,
   *         negative integer if this < other,
   *         positive integer if this > other.
   ***/
  public int compareTo( Object other )
  {
    // If other is not a Rational, throw an exception
    // This will exit the function, generating a runtime error
    if ( ! (other instanceof RationalLib) ) {
      // ClassCastException specified by Java API.
      // Input String is optional; gives diagnostics info.
      throw new ClassCastException("\nMy first error message! "
                                   + " compareTo() input not a Rational");
    }

    int thisNumerator, otherNumerator; //just for clarity below...

    thisNumerator = _numerator * ((RationalLib)other)._denominator;
    otherNumerator = _denominator * ((RationalLib)other)._numerator;

    return thisNumerator - otherNumerator;
  }


  //main method for testing
  public static void main( String[] args )
  {
      RationalLib r = new RationalLib( 3, 7 );
      RationalLib s = new RationalLib();
      RationalLib t = new RationalLib( 8, 5 );

      RationalLib u = new RationalLib( -1, 2 );
      RationalLib v = new RationalLib( -2, 3 );
      RationalLib w = new RationalLib( -8, 12 );

      RationalLib x = new RationalLib( -8, 12 );
      String y = "yoo";

      System.out.println("r: " + r );
      System.out.println("s: " +  s );
      System.out.println("t: " +  t );

      System.out.println( r + " as a floating pt approximation: "
      + r.floatValue() );
      System.out.println( s + " as a floating pt approximation: "
      + s.floatValue() );
      System.out.println( t + " as a floating pt approximation: "
      + t.floatValue() );

      System.out.print( r + " * " + t + " = ");
      r.multiply(t);
      System.out.println(r);

      System.out.print( r + " / " + t + " = ");
      r.divide(t);
      System.out.println(r);

      System.out.print( u + " + " + v + " = ");
      u.add(v);
      System.out.println(u);

      System.out.print( u + " - " + v + " = ");
      u.subtract(v);
      System.out.println(u);

      System.out.println( "\nNow testing static gcd...");

      System.out.println("expect 1");
      System.out.print("actual:\t");
      System.out.println( Rational.gcd(100,9) );

      System.out.println("expect 5");
      System.out.print("actual:\t");
      System.out.println( Rational.gcd(245,25) );


      System.out.println( "\nNow testing non-static gcd...");

      System.out.println("Rational r...");
      System.out.println( r );
      System.out.println("expect 40");
      System.out.print("actual:\t");
      System.out.println( r.gcd() );

      System.out.println("Rational t...");
      System.out.println( t );
      System.out.println("expect 1");
      System.out.print("actual:\t");
      System.out.println( t.gcd() );

      System.out.println("Rational w...");
      System.out.println( w );
      System.out.println("expect 4");
      System.out.print("actual:\t");
      System.out.println( w.gcd() );


      System.out.println( "\nNow testing reduce...");
      System.out.println("Rational r...");
      System.out.println( r );
      System.out.print( r + " in reduced form = ");
      r.reduce();
      System.out.println(r);


      System.out.println( "r > t: " +  r.compareTo(t) );
      System.out.println( "r > s: " +  r.compareTo(s) );
      System.out.println( "s > t: " +  s.compareTo(t) );
      //uncommenting the line below should trigger a runtime error
      //  System.out.println( "s > y: " +  s.compareTo(y) );

      System.out.println( "v.equals(v): " + v.equals(v) );
      System.out.println( "v.equals(w): " + v.equals(w) );
      System.out.println( "w.equals(x): " + w.equals(x) );
    /*~~~v~~~~~~~~~~down~goer~3~~~~~~~~~~~~~v~~~~~
      ~~~~~|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~*/
  }

}//end class
