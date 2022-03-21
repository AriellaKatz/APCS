/*
Team Pink Lemonade: Ariella Katz, Emily Ortiz, Jacob Ng
APCS pd6
L07: But These Go Up To Eleven
2022-03-18
time spent: 0.5 hrs
*/

/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card card0 = new Card("two", "spades", 2);
		Card card1 = new Card("two", "spades", 2);
		Card card2 = new Card("two", "hearts", 2);

		System.out.println("Card0: " + card0);
		System.out.println("Card1: " + card1);
		System.out.println("Card2: " + card2);

		System.out.println("Card0 = Card1?");
		System.out.println(card0.matches(card1));
		System.out.println("Card0 = Card2?");
		System.out.println(card0.matches(card2));
		System.out.println("Card1 = Card2?");
		System.out.println(card1.matches(card2));
	}
}
