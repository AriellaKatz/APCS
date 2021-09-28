//Think Java - Ch 6
public class Methods{
//Ex 2:
public static boolean isDivisible(int n, int m){
  if (n % m == 0) {
    return true;
  } else {
    return false;
  }
}

//Ex 3:
public static boolean isTriangle(int side1, int side2, int side3){
  if (!(side1 + side2 < side3) && !(side2 + side3 < side1) && !(side1 + side3 < side2)) {
    return true;
  } else {
    return false;
  }
}

//Ex 8:
public static int ack(int m, int n){
  if (m == 0) {
    return n + 1;
  } else {
    if (m > 0 && n == 0) {
      return ack(m - 1, 1);
    } else {
      if (m > 0 && n > 0) {
        return ack(m - 1, ack(m, n - 1));
      } else {
        return 0;
      }
    }
  }
}
//For displaying the results of Ex 8 later;
//It will only display them if the result is valid
//(the inputted numbers must be >= 0, and if they aren't,
//the result will not be >0, so it won't display)
public static void printAck(int m, int n){
  if (ack(m, n) > 0) {
    System.out.println(ack(m, n));
  } else {
    return;
  }
}

//To check Ex 8:
public static void main(String[] args){
  printAck(1,2);
}
}
