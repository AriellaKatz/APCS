/*
UnicornHead: Melody Lew, Ariella Katz, Lior Polischouk
APCS pd6
HW21 -- STAtisTically Speaking...
2021-10-20
*/

/*
DISCO:
0. If you input ints for geoMean, the output will be an int, but if you input doubles, the output is a double.
QCC:
0. What is the difference between the main() method of StatsDriver.java and that of
   Stats.java?
*/
public class StatsDriver {
	public static void main(String[] args) {
    //int mean
		System.out.print(Stats.mean(2,4));
		System.out.println("...should be 3");
    		System.out.print(Stats.mean(3,4));
		System.out.println("...should be 3"); //rounds down
    		System.out.print(Stats.mean(4,4));
		System.out.println("...should be 4");
    //double mean
		System.out.print(Stats.mean(2.0,4.0));
		System.out.println("...should be 3.0");
    		System.out.print(Stats.mean(3.0,4.0));
		System.out.println("...should be 3.5"); //approximates
    		System.out.print(Stats.mean(4.0,4.0));
		System.out.println("...should be 4.0");
    //int max
		System.out.print(Stats.max(2,4));
		System.out.println("....should be 4");
		System.out.print(Stats.max(4,2));
    		System.out.println("...should be 4");
    		System.out.print(Stats.max(4,4));
    		System.out.println("...should be 4");
    //double max
   		System.out.print(Stats.max(2.0,4.0));
		System.out.println("...should be 4.0");
		System.out.print(Stats.max(4.0,2.0));
  		System.out.println("...should be 4.0");
    		System.out.print(Stats.max(4.0,4.0));
    		System.out.println("...should be 4.0");
    //int geoMean
		System.out.print(Stats.geoMean(16,4));
		System.out.println("...should be 8");
    		System.out.print(Stats.geoMean(16,5));
		System.out.println("...should be 8"); //rounds down
    //double geoMean
		System.out.print(Stats.geoMean(16.0,4.0));
		System.out.println("...should be 8.0");
    		System.out.print(Stats.geoMean(16.0,5.0));
		System.out.println("...should be ~8.9"); //approximation
    //int max
		System.out.print(Stats.max(2,3,4));
                System.out.println("...should be 4");
                System.out.print(Stats.max(2,4,4));
                System.out.println("...should be 4");
    //double max
		System.out.print(Stats.max(2.0,3.0,4.0));
                System.out.println("...should be 4");
                System.out.print(Stats.max(2.0,4.0,4.0));
                System.out.println("...should be 4");
    //int geoMean
		System.out.print(Stats.geoMean(1,3,9));
		System.out.println("...should be 3");
		System.out.print(Stats.geoMean(3,6,9));
		System.out.println("...should be 5");
    //double geoMean
		System.out.print(Stats.geoMean(1.0,3.0,9.0));
                System.out.println("...should be 3");
                System.out.print(Stats.geoMean(3.0,6.0,9.0));
                System.out.println("...should be ~5.5"); //approximation
	}
}
