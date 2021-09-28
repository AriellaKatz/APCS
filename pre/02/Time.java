public class Time{
  public static void main(String[] args){
    //It's 1:51-ish right now
    int hours = 13;
    int minutes = 51;
    int seconds = 30;
    //Number of seconds since midnight:
    int sAfter12 = hours * 60 * 60 + minutes * 60 + seconds;
    System.out.println("Seconds since midnight: " + sAfter12);
    //Number of seconds left in the day:
    int sLeft =  24 * 60 * 60 - sAfter12;
    System.out.println("Seconds left in the day: " + sLeft);
    //Percentage of the day that has passed:
    double percentDay = (double) sAfter12 / (24 * 60 * 60);
    System.out.println("Percentage of the day that's passed: " + percentDay * 100 + "%");
  }
}
