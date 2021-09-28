public class Loops{
  //Ex 3:
  public static void power(double X, int N) {
    int n = N;
    double x = X;
    while (Math.pow(x, n) < 1000000) {
      System.out.println(Math.pow(x, n));
      x = Math.pow(x, n);
    }
  }

  //Ex 4:
  public static int factorial(int n) {
    int f = 1;
    for (int subt = 1; subt <= n; subt = subt + 1) {
      f = f * subt;
    }
    return f;
  }

  //Ex 5:
//  public static void myexp(int x, int n) {
//    double ex = 0;
//    for (int i = 0; i <= n - 1; i = i + 1) {
//      ex = ex + Math.pow(x, i)/factorial(i);
//    }
//    System.out.println(ex);
//  }
// Above is a less efficient version of what is below.
  public static double myexp(double x, int n) {
    double ex = 0.0;
    double num = 1.0;
    double denom = 1.0;
    for (int i = 1; i <= n; i = i + 1) {
      ex = ex + num/denom;
      num = num * x;
      denom = denom * (double) i;
    }
    return ex;
  //  System.out.println(ex);
  }
  public static void check(double x) {
    System.out.println("e^" + x + ": \t" + x + "\t" + myexp(x, 18) + "\t" + Math.exp(x));
  }

//The larger \x\ gets, the less accurate the estimation (myexp) is.
  public static void main(String[] args) {
    for (double x = 0.1; x <= 100; x = x * 10) {
      check(x);
    }
    for (double x = -0.1; x >= -100; x = x * 10) {
      check(x);
    }
  }
}
