public class Driver {

	public static void main(String[] args) {
		Rational a = new Rational(1, 2);
		Rational b = new Rational(3, 4);
		Rational c = new Rational(3, 6);
		String d = new String("5, 6");

		System.out.println("1/2 = 3/4? " + a.equals(b));
		System.out.println("1/2 vs 3/4: " + a.compareTo(b));
		a = new Rational(1, 2); //reset a
		System.out.println("------------------------");
		System.out.println("1/2 = 3/6? " + a.equals(c));
		System.out.println("1/2 vs 3/6: " + a.compareTo(c));
                a = new Rational(1, 2); //reset a
                System.out.println("------------------------");
		System.out.println("1/2 = '5, 6'? " + a.equals(d));
		System.out.println("1/2 vs '5, 6': " + a.compareTo(d));
                a = new Rational(1, 2); //reset a
                System.out.println("------------------------");
	}

}
