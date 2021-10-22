/***
 *  class Coin
 *  by Clyde "Thluffy" Sinclair
 *  SKELETON
 ***/

public class Coin {

  //attributes aka instance vars
  double value;
  String upFace;
  String name;
  int flipCtr;
  int headsCtr;
  int tailsCtr;
  double bias;


  /***
   *  Coin() -- default constuctor
   *  precond:
   *  postcond:
   ***/
  public Coin() {

  }


  /***
      Coin(String) -- overloaded constructor
      precond: input is one of
      "penny",
      "nickel",
      "dime",
      "quarter",
      "half dollar",
      "dollar"
      postcond:
  ***/
  public Coin( String s ) {
    name = s;
  }


  /***
      Coin(String,String) --
      precond:
      postcond:
  ***/
  public Coin( String s, String nowFace ) {
    name = s;
    upFace = nowFace;
  }


  // Accessors...
  // ----------------------------
  public String getUpFace() {

  }

  public int getFlipCtr() {

  }

  public double getValue() {

  }

  public int getHeadsCtr() {

  }

  public int getTailsCtr() {

  }
  // ----------------------------


  /***
   * assignValue() -- set a Coin's monetary value based on its name
   * precond:  input String is a valid coin name ("penny", "nickel", etc.)
   * postcond: instvar value gets appropriate value
   * Returns value assigned.
   ***/
  private double assignValue( String s ) {
    if (name == "penny"){
	value = 0.01;
	}
    if (name == "nickel"){
	value = 0.05;
	}
    if (name == "dime"){
    	value = 0.10;
    	}
    if (name == "quarter"){
    	value = 0.25;
    	}
    if (name == "half dollar"){
	value = 0.50;
	}
    if (name == "dollar"){
	value = 1.00;
	}
  }


  /***
      reset() -- initialize a Coin
      precond:  s is "heads" or "tails", 0.0 <= d <= 1.0
      postcond: Coin's attribs reset to starting vals
  ***/
  public void reset( String s, double d ) {
	
  }


  /***
   * String flip() -- simulates a Coin flip
   * precond:  bias is a double on interval [0.0,1.0]
   * (1.0 indicates always heads, 0.0 always tails)
   * postcond: upFace updated to reflect result of flip.
   * flipCtr incremented by 1.
   * Either headsCtr or tailsCtr incremented by 1, as approp.
   * Returns "heads" or "tails"
   ***/
  public String flip() {
    ht = Math.random()
    if (ht < bias) {
      return "heads";
    }
    else {
      return "tails";
    }
  }


  /***
   * boolean equals(Coin) -- checks to see if 2 coins have same face up
   * precond: other is not null
   * postcond: Returns true if both coins showing heads
   * or both showing tails. False otherwise.
   ***/
  public boolean equals( Coin other ) {
    if (other.name == name){
	return true;
	}
    else {
	return false;
	}
  }


  /***
   * String toString() -- overrides toString() provided by Java
   * precond: n/a
   * postcond: Return String comprised of name and current face
   ***/
  public String toString() {
    upFace = flip();
    return name + upFace; 
  }

}//end class
