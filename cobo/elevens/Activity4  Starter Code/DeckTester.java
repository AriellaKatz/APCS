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
		String[] ranks = {"jack", "queen", "king"};
		String[] suits = {"blue", "red"};
		int[] pointValues = {11, 12, 13};
		Deck d = new Deck(ranks, suits, pointValues);

		System.out.println("**** Original Deck Methods ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After 1 Card Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal Remaining 5 Cards ****");
		for (int i = 0; i < 5; i++) {
			System.out.println("  deal: " + d.deal());
		}
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After All Cards Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card From Empty Deck ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		String[] ranks1 = {"two", "two", "two", "two",
		        					"three", "three", "three", "three",
		        					"four", "four", "four", "four",
		        					"five", "five", "five", "five",
		        					"six", "six", "six", "six",
		        					"seven", "seven", "seven", "seven",
		        					"eight", "eight", "eight", "eight",
		        					"nine", "nine", "nine", "nine",
		        					"ten", "ten", "ten", "ten",
		        					"jack", "jack", "jack", "jack",
		        					"queen", "queen", "queen", "queen",
		        					"king", "king", "king", "king",
		        					"ace", "ace", "ace", "ace"};
		String[] suits1 = {"spades", "hearts", "clubs", "diamonds",
		        					"spades", "hearts", "clubs", "diamonds",
		        					"spades", "hearts", "clubs", "diamonds",
		        					"spades", "hearts", "clubs", "diamonds",
		        					"spades", "hearts", "clubs", "diamonds",
		        					"spades", "hearts", "clubs", "diamonds",
		        					"spades", "hearts", "clubs", "diamonds",
		        					"spades", "hearts", "clubs", "diamonds",
		        					"spades", "hearts", "clubs", "diamonds",
		        					"spades", "hearts", "clubs", "diamonds",
		        					"spades", "hearts", "clubs", "diamonds",
		        					"spades", "hearts", "clubs", "diamonds",
		        					"spades", "hearts", "clubs", "diamonds"};
		int[] pointValues1 = {2, 2, 2, 2,
		              			 3, 3, 3, 3,
		              			 4, 4, 4, 4,
		              			 5, 5, 5, 5,
		              			 6, 6, 6, 6,
		              			 7, 7, 7, 7,
		              			 8, 8, 8, 8,
		              			 9, 9, 9, 9,
		              			 10, 10, 10, 10,
		              			 10, 10, 10, 10,
		              			 10, 10, 10, 10,
		              			 10, 10, 10, 10,
		              			 10, 10, 10, 10,
		              			 11, 11, 11, 11};
		Deck fiftyTwo = new Deck(ranks1, suits1, pointValues1);
		for (int i = 0; i < 4; i++) {
			System.out.println(i + ": ");
			fiftyTwo.shuffle();
			System.out.println(fiftyTwo);
			System.out.println("");
		}
	}
}
