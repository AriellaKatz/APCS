/***
 * UnicornHead: Ariella Katz, Melody Lew, Lior Polischouk, Tom, Ollie, Toothless
 * APCS
 * HW31 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
 * 2021-11-03
 * time spent: 0.5hrs
 *
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

/*
DISCO:
0. indexOf() is used to return the index position of a char or substring in another string.
1. final means that this method cannot by overridden by subclasses.
2. indexOf() returns -1 if the char or substring is not in the string.
QCC:
0. Will y never be considered a vowel?
1. How will these methods combine to create Pig Latin?
2. indexOf() is used for arrays. Are Strings types of arrays?
3. How do we return the last occurrence of a char/string (since indexOf() returns the first)?
*/

public class Pig
{
  //Q: How does this initialization make your life easier?
  //A: We can use VOWELS in any method without creating a local variable whenever we need it.
  private static final String VOWELS = "aeiouy";
  private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String PUNCS = ".,:;!?";



  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter )
  {
    if (w.indexOf(letter) >= 0) { return true; }
    else { return false; }
  }


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter )
  {
    if (VOWELS.indexOf(letter) >= 0) { return true; }
    else { return false; }
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w )
  {
    int count = 0;
    for (int i = 0; i < w.length(); i = i + 1) {
      if (isAVowel(w.substring(i, i+1))) { count = count + 1; }
    }
    return count;
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w )
  {
    for (int i = 0; i < w.length(); i = i + 1) {
      if (isAVowel(w.substring(i, i+1))) { return true; }
    }
    return false;
  }


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w )
  {
    String vowStr = "";
    for (int i = 0; i < w.length(); i = i + 1) {
      if (isAVowel(w.substring(i, i+1))) { vowStr = vowStr + w.substring(i, i+1); }
    }
    return vowStr;
  }

  /*=====================================
      boolean isPunc(String) -- tells whether a character is punctuation
      pre:  symbol.length() == 1
      post: isPunc(".") -> true
            isPunc("b") -> false
      =====================================*/
    public static boolean isPunc( String symbol ) {
	    return PUNCS.indexOf( symbol ) != -1;
    }


    /*=====================================
      boolean isUpperCase(String) -- tells whether a letter is uppercase
      pre:  letter.length() == 1
      post: isUpperCase("a") -> false
            isUpperCase("A") -> true
      =====================================*/
    public static boolean isUpperCase( String letter ) {
      return CAPS.indexOf ( letter ) != -1;
    }


    /*=====================================
      boolean hasPunc(String) -- tells whether a String contains punctuation
      pre:  w != null
      post: hasPunc(“cat.”) -> true
            hasPunc(“cat”) -> false
      =====================================*/
    public static boolean hasPunc( String w ) {
      for (int i = 0; i < w.length(); i += 1) {
        if isPunc(w.substring(i,i+1)) { return true; }
      }
      return false;
    }


    /*=====================================
      boolean beginsWithUpper(String) -- tells whether 1st letter is uppercase
      pre:  w != null and w.length() > 0
      post: beginsWithUpper("Apple") -> true
            beginsWithUpper("apple") -> false
      =====================================*/
    public static boolean beginsWithUpper( String w ) {
	     return isUpperCase(w.substring(0,1) );
    }

  /**
      String engToPig(String) -- converts an English word to Pig Latin
      pre:  w.length() > 0
      post: engToPig("apple")  --> "appleway"
      engToPig("strong") --> "ongstray"
      engToPig("java")   --> "avajay"
      **/
  /*  public static String engToPig( String w ) {

      String ans = "";

      if ( beginsWithVowel(w) )
        ans = w + "way";

      else {
        int vPos = w.indexOf( firstVowel(w) );
        ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
      }

      return ans;
    }

  public static void main( String[] args ) {

     for( String word : args ) {
       System.out.println( "allVowels \t" + allVowels(word) );
       System.out.println( "firstVowels \t" + firstVowel(word) );
       System.out.println( "countVowels \t" + countVowels(word) );
       System.out.println( "engToPig \t" + engToPig(word) );
       System.out.println( "---------------------" );
     }

   }//end main()
*/
    public static void main( String[] args )
  {
    System.out.print("Expecting true... ");
    System.out.println(hasA("cat", "a"));
    System.out.print("Expecting false... ");
    System.out.println(hasA("cat", "p"));

    System.out.print("Expecting true... ");
    System.out.println(isAVowel("a"));
    System.out.print("Expecting false... ");
    System.out.println(isAVowel("p"));

    System.out.print("Expecting 3... ")private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String PUNCS = ".,:;!?";
;
    System.out.println(countVowels("meatball"));
    System.out.print("Expecting 0... ");
    System.out.println(countVowels("m34tb4ll"));

    System.out.print("Expecting true... ");
    System.out.println(hasAVowel("cat"));
    System.out.print("Expecting false... ");
    System.out.println(hasAVowel("zzz"));

    System.out.print("Expecting eaa... ");
    System.out.println(allVowels("meatball"));
    System.out.print("Expecting nothing... ");
    System.out.println(allVowels("m34tb4ll"));
  }

}//end class Pig
