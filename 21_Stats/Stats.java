/*
UnicornHead: Melody Lew, Ariella Katz, Lior Polischouk, Tom, Ollie, Toothless
APCS pd6
HW21 -- STAtisTically Speaking...
2021-10-20
*/

/*
DISCO:
0. For the geoMean methods that use Math.pow, the power has to be written as 1.0/3.0 
   instead of 1/3, or it returns 1, because the / operator sees two int operands and 
   returns an int, 0, and anything to the 0 power is 1.
   Integer division rounds down towards 0, while double division gives a more precise
   approximation.
QCC:
0. How can we make this compilable without using typecasting, specifically for the methods
   involving means (arithmetic or geometric)?
1. What is the purpose of the main() method in this class if we're using the driver class,
   StatsDriver.java, to test the functionality of the code?
*/

import java.lang.Math;

public class Stats {

  public static int mean(int a, int b) {
    int avg = (int) (a+b)/2;
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
    int mean = (int) Math.sqrt(a*b);
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
    int mean = (int) Math.pow(a*b*c, 1.0/3.0);
    return mean;
  }

  public static double geoMean(double a, double b, double c) {
    double mean = Math.pow(a*b*c, 1.0/3.0);
    return mean;
  }


  //main method for testing functionality
//  public static void main( String[] args ) {

//  }

}//end class
