/*
UnicornHead: Melody Lew, Ariella Katz, Lior Polischouk, Tom, Ollie, Toothless
APCS pd6
HW26 - GCD Three Ways
2021-10-27
time spent: 1.0 hours
*/

/*
DISCO:
0.
QCC:
0.
*/

import java.lang.Math;

public class Stats {

  public static int mean(int a, int b) {
//    int avg = (int) (a+b)/2;
    int avg = (a+b)/2; //don't need to worry about typecasting b/c int division
    return avg;
  }

  public static double mean(double a, double b) {
    double avg = (a+b)/2;
    return avg;
  }

  public static int max(int a, int b) {
    if (a >= b){
      return a;
    }
    else {
      return b;
    }
  }

  public static double max(double a, double b) {
    if (a >= b){
      return a;
    }
    else {
      return b;
    }
  }

  public static int geoMean(int a, int b) {
  //  int mean = (int) Math.sqrt(a*b);
   int mean = Math.round(Math.round(Math.sqrt(a*b))); //Math.round returns a long , second converts to int
   return mean;
  }

  public static double geoMean(double a, double b) {
    double mean = Math.sqrt(a*b);
    return mean;
  }

  public static int max(int a, int b, int c) {
    if ((a >= b) && (a >= c)){
      return a;
    }
    else {
      if (b >= c){
        return b;
      }
      else {
        return c;
      }
    }
  }

  public static double max(double a, double b, double c) {
    if ((a >= b) && (a >= c)){
      return a;
    }
    else {
      if (b >= c){
        return b;
      }
      else {
        return c;
      }
    }
  }

  public static int geoMean(int a, int b, int c) {
    int mean = Math.round(Math.round(Math.pow(a*b*c, 1.0/3.0)));
    return mean;
  }

  public static double geoMean(double a, double b, double c) {
    double mean = Math.pow(a*b*c, 1.0/3.0);
    return mean;
  }

  public static int gcd(int a, int b) {
    if (a <= 0 || b <= 0) {
      System.out.print("Error: Non-positive input(s) -> ");
      return 0;
    }

    int n = 1;
    int output = 0;
    while (n <= a && n <= b) {
      if (a % n == 0 && b % n == 0) { output = n; }
      n += 1;
    }
    return output;
  }

  public static int gcdER(int a, int b) {
    if (a <= 0 || b <= 0) {
      System.out.print("Error: Non-positive input(s) -> ");
      return 0;
    }

    if (a == b) { return a; }
    else {
      if (a < b) {
        b = b - a;
        return gcdER(a, b);
      }
      else {
        a = a - b;
        return gcdER(a, b);
      }
    }
  }

  public static int gcdEW(int a, int b) {
    if (a <= 0 || b <= 0) {
      System.out.print("Error: Non-positive input(s) -> ");
      return 0;
    }

    int n = 0;
    if (a < b) { n = a; }
    else { n = b; }
    while (a % n != 0 || b % n != 0) { n -= 1; }
    return n;
  }


  //main method for testing functionality
  public static void main( String[] args ) {
    System.out.println(gcd(15,18));
    System.out.println(gcd(3,3));
    System.out.println(gcd(0,5));
    System.out.println(gcdER(15,18));
    System.out.println(gcdER(3,3));
    System.out.println(gcdER(0,5));
    System.out.println(gcdEW(15,18));
    System.out.println(gcdEW(3,3));
    System.out.println(gcdEW(0,5));
  }

}//end class
