/*
ABA: Ariella Katz, Alif Rahman, Brianna Tieu, Tom, Grippy, Pepe
APCS
HW34 -- A Pirate's Life for Me
2021-11-12
time spent: 0.5hrs
*/

/*
DISCO:
0. With both iterative loops and recursion, the idea is to keep repeating a procedure but with
   a different value of a certain variable each time. In iterative loops, you can create a new
   variable to increment with each iteration, but with recursion, you're limited to only being
   able to change the arguments of the method (which you do when you make the recursive call).
   Iteration is probably more favorable than recursion in cases like this one, where ideally the
   variable that you're changing isn't one of the parameters of the method (here, it's easiest
   to change the index, i, of the array, but since you can't do that recursively, you're forced
   to make a new array and check the same index for that one).
QCC:
0. We've seen a situation where an iterative approach is far simpler than a recursive approach,
   given the limitations of recursion described in DISCO 0, but what limitations are there of
   iterative approaches that would sometimes make recursion the only option?
*/

public class Loopier {

	public static void addInts (int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] =(int)(Math.random() * 100);
		}
	}

	public static String stringArray(int[] array) {
		String ans = "";
		for (int i = 0; i < array.length; i++) {
			ans += array[i] + ", ";
		}
		return ans.substring(0,ans.length()-2);
	}

	public static int linSearch(int[] a, int target) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == target) { return i; }
		}
		return -1;
	}

	public static int linSearchR(int[] a, int target) {
		if (a.length == 0) { return -1;}
		else {
			if (a[0] == target) { return 0;}
			else {
				int[] aNew = new int[a.length-1];
        		        for (int i = 1; i < a.length; i++) {
                	        	aNew[i-1] = a[i];
               			}
				if ((a[1 + linSearchR(aNew, target)]) == target) {
					return 1 + linSearchR(aNew, target); }
				else { return -1; }
			}
		}
	}

	public static int freq(int[] a, int target) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == target) { count++; }
		}
		return count;
	}

	public static int freqRec(int[] a, int target) {
                int[] aNew = new int[a.length-1];
                for (int i = 1; i < a.length; i++) {
                        aNew[i-1] = a[i];
                }
		if (a.length == 0) { return 0; }
		else {
			if (a[0] == target) {
				if (aNew.length == 0) { return 1; }
				else { return 1 + freqRec(aNew, target); }
			}
			else {
				if (aNew.length == 0) { return 0; }
				else { return freqRec(aNew, target); }
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[25];
		addInts(array);
		System.out.println(stringArray(array));
		System.out.println(linSearch(array,0));
		System.out.println(linSearchR(array,0));
		System.out.println(freq(array,0));
		System.out.println(freqRec(array,0));
	}

}
