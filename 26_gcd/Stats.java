/*
UnicornHead: Melody Lew, Ariella Katz, Lior Polischouk, Tom, Ollie, Toothless
APCS pd6
HW26 -- GCD Three Ways
2021-10-27
time spent: 1,0 hrs
*/

/*
DISCO:
0. Working backwards (i.e. starting from larger numbers and working your way down to smaller numbers) is faster and makes more sense
in this context of gcd because you're finding the GREATEST common denominator.
1. If one part of the or statement is true, then java can implement boolean short circuiting. For example, if either a or b are not 
divisible by x, then x isn't the gcd.
QCC:
0. Why does the idea that the gcd remains the same if the larger number is replaced by the difference work? How/where did this discovery
arise?
ALGO:
gcdEW
 0. If either integers are 0 or negative, then there will be no positive gcd and will result in 0 being returned.
 1. Start off with the greatest common denominator as the smaller integer of the two.
 2. If the smaller integer is not the gcd, then decrease it by 1 and keep dividing until you find the gcd of both integers.
*/
import java.lang.Math;

public class Stats {

  public static int mean(int a, int b) {
    int avg = (a+b)/2;
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
    int mean = (int)Math.sqrt(a*b);
    return mean;
  }

  public static double geoMean(double a, double b) {
    double mean = Math.sqrt(a*b);
    return mean;
  }

public static int max(int a, int b, int c) {
     if ((a >= b) && (a >= c)) {
        return a;
     } else if ((b >= a) && (b >= c)) {
        return b;
     } else {
        return c;
     }
  }

  public static double max(double a, double b, double c) {
     if ((a >= b) && (a >= c)) {
        return a;
     } else if ((b >= a) && (b >= c)) {
        return b;
     } else {
        return c;
     }
  }

  public static int geoMean(int a, int b, int c) {
     int mean = (int)Math.pow(a*b*c, 1.0/3.0);
     return mean;
  }

  public static double geoMean(double a, double b, double c) {
     double mean = Math.pow(a*b*c,1.0/3.0);
     return mean;
  }
  
//GCD
  
public static int gcd(int a, int b) {
    if (a == 0) { return b; }
    if (b == 0) { return a; }
    if ((a < 0 || b < 0) || (b == 0 && a == 0)) {
      System.out.print("Error: Invalid input(s) -> ");
      return 0;
    }

    int n = 1;
    int output = 0;
    while (n <= a && n <= b) {
      if (a % n == 0 && b % n == 0) { 
        output = n;
      }
      n += 1;
    }
    return output;
  }

  public static int gcdER(int a, int b) {
    if (a == 0) { return b; }
    if (b == 0) { return a; }
    if ((a < 0 || b < 0) || (b == 0 && a == 0)) {
      System.out.print("Error: Invalid input(s) -> ");
      return 0;
    }

    if (a == b) { 
      return a;
    }
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
    if (a == 0) { return b; }
    if (b == 0) { return a; }
    if ((a < 0 || b < 0) || (b == 0 && a == 0)) {
      System.out.print("Error: Invalid input(s) -> ");
      return 0;
    }

    int n = 0;
    if (a < b) { 
      n = a;
    }
    else { 
      n = b;
    }
    while (a % n != 0 || b % n != 0) { 
      n -= 1;
    }
    return n;
  }

  public static void main( String[] args ) { 
     System.out.println(gcd(6, 8));
     System.out.println(gcdEW(6, 8));
     System.out.println(gcdER(6, 8));
     System.out.println(gcd(1072, 584));
     System.out.println(gcdEW(256, 86));
     System.out.println(gcdER(1072,584));
  }

}//end class
