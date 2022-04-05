/*
The Greyducks :: Kaitlin Ho, Hugo Jenkins, Ariella Katz, Apple, Boary, Tom
APCS
LAB08 -- America's Next Top Data Scientist
2022-04-05
time spent: 1.0 hrs
*/

public class Cereal {

  private String _name;
  private char _type;
  private int _cals;
  private byte _protein;
  private byte _fat;
  private int _sodium;
  private float _fiber;
  private float _carbs;
  private byte _sugar;
  private int _potass;
  private int _vitamins;
  private byte _shelf;
  private float _weight;
  private float _cups;
  private double _rating;

  public Cereal(String name, char type, int cals, byte protein, byte fat,
  int sodium, float fiber, float carbs, byte sugar, int potass, int vitamins,
  byte shelf, float weight, float cups, double rating) {
    _name = name;
    _type = type;
    _cals = cals;
    _protein = protein;
    _fat = fat;
    _sodium = sodium;
    _fiber = fiber;
    _carbs = carbs;
    _sugar = sugar;
    _potass = potass;
    _vitamins = vitamins;
    _shelf = shelf;
    _weight = weight;
    _cups = cups;
    _rating = rating;
  }

  //ACCESSORS BELOW
  public String name() {
    return _name;
  }
  public char type() {
    return _type;
  }
  public int calories() {
    return _cals;
  }
  public byte protein() {
    return _protein;
  }
  public byte fat() {
    return _fat;
  }
  public int sodium() {
    return _sodium;
  }
  public float fiber() {
    return _fiber;
  }
  public float carbohydrates() {
    return _carbs;
  }
  public byte sugar() {
    return _sugar;
  }
  public int potassium() {
    return _potass;
  }
  public int vitamins() {
    return _vitamins;
  }
  public byte shelf() {
    return _shelf;
  }
  public float weight() {
    return _weight;
  }
  public float cups() {
    return _cups;
  }
  public double rating() {
    return _rating;
  }
  //ACCESSORS ABOVE

  public String toString() {
    String retStr = "";
    retStr += "Name: " + _name + "\n";
    retStr += "Type: " + _type + "\n";
    retStr += "Calories: " + _cals + "\n";
    retStr += "Protein: " + _protein + "\n";
    retStr += "Fat: " + _fat + "\n";
    retStr += "Sodium: " + _sodium + "\n";
    retStr += "Fiber: " + _fiber + "\n";
    retStr += "Carbohydrates: " + _carbs + "\n";
    retStr += "Sugar: " + _sugar + "\n";
    retStr += "Potassium: " + _potass + "\n";
    retStr += "Vitamins: " + _vitamins + "\n";
    retStr += "Shelf: " + _shelf + "\n";
    retStr += "Weight: " + _weight + "\n";
    retStr += "Cups: " + _cups + "\n";
    retStr += "Rating: " + _rating + "\n";
    return retStr;
  }

  public void main(String[] args) {
    
  }

}
