public class Repeater{

	public static String fenceW ( int numPosts ) {
		int i = 1;
		String f = "|";
		String oldF = ""; //You must initialize it to be able to use it in the while loop below.

		while (i <= numPosts) {
			oldF = f;
			f = f + "--|";
			i += 1;
		}
		return oldF;
	}

	public static String fenceR ( int numPosts ) {
		String f = ""; //How do I initialize f (so i can use it in the if else statement) in a way that won't reset it back to "" for each recursive call?
		int n = numPosts;

		if (n == 1) {
			String newF = f + "|";
		}
		else {
			f = f + "|--";
			n = n - 1;
			fenceR(n);
		}
		return f;
	}

	public static void main ( String[] args ) {
		System.out.println(fenceW(4));
		System.out.println(fenceR(4));
	}

}
