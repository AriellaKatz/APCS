//Using Scanner and formatting outputs
import java.util.Scanner;
public class TempConversion{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    double C;
    double F;

    System.out.print("What is the temperature in Celsius?");
    C = (double) in.nextInt(); //You have to input an integer for C.
    F = C * (9.0 / 5.0) + 32;
    System.out.printf("%.1f C = %.1f F\n", C, F);
    System.out.printf("That's %.1f in Fahrenheit.", F);
  }
}
