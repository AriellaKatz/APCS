/*
Ariella Katz
APCS
HW28
2021-10-29
time spent: 1.2 hours
*/

public class String1HW28{

/*
Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".

helloName("Bob") → "Hello Bob!"
helloName("Alice") → "Hello Alice!"
helloName("X") → "Hello X!"
*/
	public String helloName(String name) {
		return ("Hello " + name + "!");
	}

/*
Given two strings, a and b, return the result of putting them together in the order abba,
e.g. "Hi" and "Bye" returns "HiByeByeHi".

makeAbba("Hi", "Bye") → "HiByeByeHi"
makeAbba("Yo", "Alice") → "YoAliceAliceYo"
makeAbba("What", "Up") → "WhatUpUpWhat"
*/
	public String makeAbba(String a, String b) {
  		return ("" + a + b + b + a);
	}

	public String makeTags(String tag, String word) {
  		return ("<"+tag+">"+word+"</"+tag+">");
	}

	public String makeOutWord(String out, String word) {
		return (""+out.substring(0,2)+word+out.substring(2));
	}

	public String extraEnd(String str) {
		return(""+str.substring(str.length()-2)+str.substring(str.length()-2)+str.substring(str.length()-2));
	}

	public String firstTwo(String str) {
		if (str.length() < 2) { return str; }
		else {return (str.substring(0,2)); }
	}

	public String firstHalf(String str) {
		return(str.substring(0,(str.length()/2)));
	}

	public String withoutEnd(String str) {
		return (str.substring(1,(str.length()-1)));
	}

	public String comboString(String a, String b) {
		if (a.length()<b.length()) { return (""+a+b+a); }
		else { return (""+b+a+b);}
	}

	public String nonStart(String a, String b) {
		return(a.substring(1)+b.substring(1));
	}

	public String left2(String str) {
		return (str.substring(2)+str.substring(0,2));
	}

	public static void main(String[] args) {
		String1HW28 test = new String1HW28();
		//Testing helloName:
		System.out.println("helloName:");
		System.out.println(test.helloName("Bob"));
		System.out.println(test.helloName("Alice"));
		System.out.println(test.helloName("X"));
		System.out.println(test.helloName("Dolly"));
		System.out.println(test.helloName("Alpha"));
		System.out.println(test.helloName("Omega"));
		System.out.println(test.helloName("Goodbye"));
		System.out.println(test.helloName("ho ho ho"));
		System.out.println(test.helloName("xyz"));
		System.out.println(test.helloName("Hello"));
		System.out.println("\n");
		//Testing makeAbba
		System.out.println("makeAbba:");
		System.out.println(test.makeAbba("Hi", "Bye"));
		System.out.println(test.makeAbba("Yo", "Alice"));
		System.out.println(test.makeAbba("What", "Up"));
		System.out.println(test.makeAbba("aaa", "bbb"));
		System.out.println(test.makeAbba("x", "y"));
		System.out.println(test.makeAbba("x", ""));
		System.out.println(test.makeAbba("", "y"));
		System.out.println(test.makeAbba("Bo", "Ya"));
		System.out.println(test.makeAbba("Ya", "Ya"));
		System.out.println("\n");
	}

}

