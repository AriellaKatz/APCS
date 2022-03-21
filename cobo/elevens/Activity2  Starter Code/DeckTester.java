/*
Team Pink Lemonade: Ariella Katz, Emily Ortiz, Jacob Ng
APCS pd6
L07: But These Go Up To Eleven
2022-03-18
time spent: 0.5 hrs
*/

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks0 = {"two", "two", "two"};
		String[] suits0 = {"spades", "spades", "spades"};
		int[] values0 = {2, 2, 2};
		Deck deck0 = new Deck(ranks0, suits0, values0);
		System.out.println(deck0);
		System.out.print("It's empty: ");
		System.out.println(deck0.isEmpty());
		System.out.println("Dealing everything...");
		System.out.println(deck0.deal());
		System.out.println(deck0.deal());
		System.out.println(deck0.deal());
		System.out.println("finished dealing.");
		System.out.println("It's empty: ");
		System.out.println(deck0.isEmpty());
		System.out.println("Try dealing again...");
		System.out.println(deck0.deal());
		System.out.println("finished dealing.");
		System.out.println("\n");

		String[] ranks1 = {"ace", "two", "three"};
		String[] suits1 = {"spades", "hearts", "clubs"};
		int[] values1 = {1, 2, 3};
		Deck deck1 = new Deck(ranks1, suits1, values1);
		System.out.println(deck1);
		System.out.print("It's empty: ");
		System.out.println(deck1.isEmpty());
		System.out.println("Dealing everything...");
		System.out.println(deck1.deal());
		System.out.println(deck1.deal());
		System.out.println(deck1.deal());
		System.out.println("finished dealing.");
		System.out.println("It's empty: ");
		System.out.println(deck1.isEmpty());
		System.out.println("Try dealing again...");
		System.out.println(deck1.deal());
		System.out.println("finished dealing.");
		System.out.println("\n");

		String[] ranks2 = {"three", "three", "three"};
		String[] suits2 = {"spades", "hearts", "clubs"};
		int[] values2 = {3, 3, 3};
		Deck deck2 = new Deck(ranks2, suits2, values2);
		System.out.println(deck2);
		System.out.print("It's empty: ");
		System.out.println(deck2.isEmpty());
		System.out.println("Dealing everything...");
		System.out.println(deck2.deal());
		System.out.println(deck2.deal());
		System.out.println(deck2.deal());
		System.out.println("finished dealing.");
		System.out.println("It's empty: ");
		System.out.println(deck2.isEmpty());
		System.out.println("Try dealing again...");
		System.out.println(deck2.deal());
		System.out.println("finished dealing.");
		System.out.println("\n");
	}
}
