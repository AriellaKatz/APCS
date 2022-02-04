//String concatenation to display values with different types
public class Date{
  public static void main(String[] args){
    String day = "Thursday";
    int date = 2;
    String month = "September";
    int year = 2021;
    System.out.println("American format:");
    System.out.println(day + ", " + month + " "+ date + ", " + year);
    System.out.println("European format:");
    System.out.println(day + " " + date + " " + month + " " + year);
  }
}
