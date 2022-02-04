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

