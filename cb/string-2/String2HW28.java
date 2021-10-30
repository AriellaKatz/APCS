/*
Ariella Katz
APCS
HW28 -- PPMP
2021-10-19
time spent: 1.2 hours
*/

/*
DISCO:
0. String.toLowerCase() converts all characters to lowercase.
QCC:
0. Why does .equals() but not == work for comparing Strings?
	.equals() compares the values of two objects while == compares their memory
	addresses.
		1. In the expression 1 == 1, do the two 1s have the same memory
		   addresses? How does that work?
*/

public class String2HW28{

/*
Given a string, return a string where for every char in the original, there are two chars.

doubleChar("The") → "TThhee"
doubleChar("AAbb") → "AAAAbbbb"
doubleChar("Hi-There") → "HHii--TThheerree"
*/
	public String doubleChar(String str) {
		String output = "";
		for (int i = 0; i < str.length(); i += 1) {
			output = output + str.substring(i,i+1) + str.substring(i,i+1);
		}
		return output;
	}

/*
Return the number of times that the string "hi" appears anywhere in the given string.

countHi("abc hi ho") → 1
countHi("ABChi hi") → 2
countHi("hihi") → 2
*/
	public int countHi(String str) {
		int count = 0;
		for (int i = 0; i < (str.length() - 1); i += 1){
			if (str.substring(i,(i+2)).equals("hi")) { count += 1; }
		}
		return count;
	}
	//Why is there an issue with using if (str.substring(i,(i+2)) == "hi") instead?
	//How does == differ from .equals()?
	//See DISCO/QCC

/*
Return true if the string "cat" and "dog" appear the same number of times in the given
string.

catDog("catdog") → true
catDog("catcat") → false
catDog("1cat1cadodog") → true
*/
	public boolean catDog(String str) {
		int countCat = 0;
		int countDog = 0;
		for (int i = 0; i < str.length()-2; i += 1) {
			if (str.substring(i,i+3).equals("cat")) { countCat += 1; }
			if (str.substring(i,i+3).equals("dog")) { countDog += 1; }
		}
		return (countCat == countDog);
	}

/*
Return the number of times that the string "code" appears anywhere in the given string,
except we'll accept any letter for the 'd', so "cope" and "cooe" count.

countCode("aaacodebbb") → 1
countCode("codexxcode") → 2
countCode("cozexxcope") → 2
*/
	public int countCode(String str){
		int count = 0;
		for (int i = 0; i < str.length()-3; i += 1) {
			if (str.substring(i,i+2).equals("co") &&
			str.substring(i+3,i+4).equals("e")) { count += 1; }
		}
		return count;
	}

/*
Given two strings, return true if either of the strings appears at the very end of the
other string, ignoring upper/lower case differences (in other words, the computation
should not be "case sensitive").
Note: str.toLowerCase() returns the lowercase version of a string.

endOther("Hiabc", "abc") → true
endOther("AbC", "HiaBc") → true
endOther("abc", "abXabc") → true
*/

	public boolean endOther(String a, String b) {
		String x = a.toLowerCase();
		String y = b.toLowerCase();
		if (x.length() > y.length()) {
			return (x.substring(x.length()-y.length()).equals(y));
		}
		else {
			return (y.substring(y.length()-x.length()).equals(x));
		}
	}

/*
Return true if the given string contains an appearance of "xyz" where the xyz is not
directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.

xyzThere("abcxyz") → true
xyzThere("abc.xyz") → false
xyzThere("xyz.abc") → true
*/
	public boolean xyzThere(String str){
		boolean tf = false;
		for (int i = 0; i < str.length()-2; i += 1) {
			if (str.substring(i,i+3).equals("xyz") &&
			((i == 0) || !(str.substring(i-1,i).equals(".")))) { tf = true; }
		}
		return tf;
	}

	public static void main(String[] args) {
		String2HW28 test = new String2HW28();
		//Testing doubleChar
		System.out.println("doubleChar:");
		System.out.println(test.doubleChar("The"));
		System.out.println(test.doubleChar("AAbb"));
		System.out.println(test.doubleChar("Hi-There"));
		System.out.println(test.doubleChar("Word!"));
		System.out.println(test.doubleChar("!!"));
		System.out.println(test.doubleChar(""));
		System.out.println(test.doubleChar("a"));
		System.out.println(test.doubleChar("."));
		System.out.println(test.doubleChar("aa"));
		System.out.println("\n");
		//Testing countHi
		System.out.println("countHi:");
		System.out.println(test.countHi("abc hi ho"));
		System.out.println(test.countHi("ABChi hi"));
		System.out.println(test.countHi("hihi"));
		System.out.println(test.countHi("hiHIhi"));
		System.out.println(test.countHi(""));
		System.out.println(test.countHi("h"));
		System.out.println(test.countHi("hi"));
		System.out.println(test.countHi("Hi is no HI on ahI"));
		System.out.println(test.countHi("hiho not HOHIhi"));
		System.out.println("\n");
		//Testing catDog
		System.out.println("catDog:");
		System.out.println(test.catDog("catdog"));
		System.out.println(test.catDog("catcat"));
		System.out.println(test.catDog("1cat1cadodog"));
		System.out.println(test.catDog("catxxdogxxxdog"));
		System.out.println(test.catDog("catxdogxdogxcat"));
		System.out.println(test.catDog("catxdogxdogxca"));
		System.out.println(test.catDog("dogdogcat"));
		System.out.println(test.catDog("dogogcat"));
		System.out.println(test.catDog("dog"));
		System.out.println(test.catDog("cat"));
		System.out.println(test.catDog("ca"));
		System.out.println(test.catDog("c"));
		System.out.println(test.catDog(""));
		System.out.println("\n");
		//Testing countCode
		System.out.println("countCode:");
		System.out.println(test.countCode("aaacodebbb"));
		System.out.println(test.countCode("codexxcode"));
		System.out.println(test.countCode("cozexxcope"));
		System.out.println(test.countCode("cozfxxcope"));
		System.out.println(test.countCode("xxcozeyycop"));
		System.out.println(test.countCode("cozcop"));
		System.out.println(test.countCode("abcxyz"));
		System.out.println(test.countCode("code"));
		System.out.println(test.countCode("ode"));
		System.out.println(test.countCode("c"));
		System.out.println(test.countCode(""));
		System.out.println(test.countCode("AAcodeBBcoleCCccoreDD"));
		System.out.println(test.countCode("AAcodeBBcoleCCccorfDD"));
		System.out.println(test.countCode("coAcodBcoleccoreDD"));
		System.out.println("\n");
		//Testing endOther
		System.out.println("endOther:");
		System.out.println(test.endOther("Hiabc","abc"));
		System.out.println(test.endOther("AbC","HiaBc"));
		System.out.println(test.endOther("abc","abXabc"));
		System.out.println(test.endOther("Hiabc","abcd"));
		System.out.println(test.endOther("Hiabc","bc"));
		System.out.println(test.endOther("Hiabcx","bc"));
		System.out.println(test.endOther("abc","abc"));
		System.out.println(test.endOther("xyz","12xyz"));
		System.out.println(test.endOther("yz","12xz"));
		System.out.println(test.endOther("Z","12xz"));
		System.out.println(test.endOther("12","12"));
		System.out.println(test.endOther("abcXYZ","abcDEF"));
		System.out.println(test.endOther("ab","ab12"));
		System.out.println(test.endOther("ab","12ab"));
		System.out.println("\n");
		//Testing xyzThere
		System.out.println("xyzThere:");
		System.out.println(test.xyzThere("abcxyz"));
		System.out.println(test.xyzThere("abcxyz"));
		System.out.println(test.xyzThere("xyz.abc"));
		System.out.println(test.xyzThere("abcxy"));
		System.out.println(test.xyzThere("xyz"));
		System.out.println(test.xyzThere("xy"));
		System.out.println(test.xyzThere("x"));
		System.out.println(test.xyzThere(""));
		System.out.println(test.xyzThere("abc.xyzxyz"));
		System.out.println(test.xyzThere("abc.xxyz"));
		System.out.println(test.xyzThere(".xyz"));
		System.out.println(test.xyzThere("12.xy"));
		System.out.println(test.xyzThere("12xyz"));
		System.out.println(test.xyzThere("1.xyz.xyz2.xyz"));
		System.out.println("\n");
	}

}
