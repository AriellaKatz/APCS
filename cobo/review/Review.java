/*
Team JEA: Jacob Kirmayer, Ethan Lam, Ariella Katz, Jacob Jr., Carl, Tom
APCS
HW63: Read/Review/Expand
2022-02-10
time spent: 0.5 hrs
*/

import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {

  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();
  private static ArrayList<String> allWords = new ArrayList<String>(); //added by us

  private static final String SPACE = " ";

  static{
    try {
      Scanner input = new Scanner(new File("cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
        allWords.add(temp[0]); //added by us
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }


  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        System.out.println(temp);
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }

  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }
  }

  /**
   * returns a string containing all of the text in fileName (including punctuation),
   * with words separated by a single space
   */
  public static String textToString( String fileName )
  {
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));

      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();

    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }

  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment)
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }

  /**
   * Returns the ending punctuation of a string, or the empty string if there is none
   */
  public static String getPunctuation( String word )
  {
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }

    /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }

    return word;
  }

  /**
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }

  /**
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);

  }

  /**
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }

  public static double totalSentiment (String fileName) {
    double sent = 0;
    String txt = textToString(fileName);
    String[] words = txt.split(" ");
    for (String w: words){
      sent+=sentimentVal(removePunctuation(w));
    }
    return sent;
  }

  public static int starRating (String fileName) {
    int stars;
    double sent = totalSentiment(fileName);
    //suppose reviews can range from -50 to 50:
    if (sent < -30) { stars = 1; }
    else if (sent <= -10) { stars = 2; }
    else if (sent <= 10) { stars = 3; }
    else if (sent <= 30) { stars = 4; }
    else { stars = 5; }
    return stars;
  }

  public static String fakeReview(String fileName) {
    String review = textToString("SimpleReview.txt");
    String[] words = review.split(" ");
    String newRev = "";
    for (String w: words) {
      if (w.substring(0,1).equals("*")) {
        String word = removePunctuation(w);
        //to make all of the adjectives positive
        if (sentimentVal(word) <= 0) {
          w = randomPositiveAdj();
        }
      }
      newRev += w + " ";
    }
    return newRev;
  }

  public static void main(String[] args) {
    System.out.println("Expecting 2.32...");
    System.out.println(sentimentVal("happily"));
    System.out.println("Expecting -3.38...");
    System.out.println(sentimentVal("terrible"));
    System.out.println("Expecting -0.04...");
    System.out.println(sentimentVal("cold"));
    System.out.println("Expecting -0.02...");
    System.out.println(sentimentVal("administration"));
    System.out.println("Expecting -0.94...");
    System.out.println(sentimentVal("americans"));
    System.out.println("Expecting 0.15...");
    System.out.println(sentimentVal("computer"));

    System.out.println("Expecting -0.18...");
    System.out.println(totalSentiment("SimpleReview.txt"));
    System.out.println("Expecting 3...");
    System.out.println(starRating("SimpleReview.txt"));

    System.out.println(fakeReview("SimpleReview.txt"));
  }
}
