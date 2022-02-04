/*
UnicornHead: Ariella Katz, Melody Lew, Lior Polischouk, Tom, Ollie, Toothless
APCS
HW25 -- Do I repeat myself?
2021-10-26
time spent: 1.0 hours
*/

/*
DISCO:
0. If you want to build off of the value of a variable in a loop of some sort (like with f
   and oldF in fenceW()), you have to initialize it first; you can't just declare it.
1. Returning the invocation of a method results in Java running the entire method, so if
   the method prints anything in its body, this will also be among the outputs (not just
   the value it returns). (See the else statement in fenceR().)
QCC:
0. You can't initialize variables in recursive loops (see DISCO 0) because the value will
   reset every time. In fenceR, we sidestepped this by using System.out.print to concatenate
   sections of the fence, but how else can we resolve this issue? Our way only works for
   Strings - what if we want to alter the value of an integer with each recursive call? How
   else can we create something to build off of?
*/

public class Repeater{

	public static String fenceW ( int numPosts ) {
		int i = 1;
		String f = "|";
		String oldF = ""; //You must initialize it to be able to use it in the while loop below.

		if (numPosts == 0) {
			return ("No posts");
		}
		while (i <= numPosts) {
			oldF = f;
			f = f + "--|";
			i += 1;
		}
		return oldF;
	}

	public static String fenceR ( int numPosts ) {
		int n = numPosts;

		if (n == 0) {
			return ("No posts");
		}
		if (n == 1) {
			return ("|");
		}
		else {
			System.out.print("|--"); //not println so it concatenates fence sections
			n = n - 1;
			return fenceR(n);
		}
	}
	public static void main ( String[] args ) {
		System.out.println(fenceW(4));
		System.out.println(fenceR(4));
	}

}
