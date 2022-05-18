/*
AKH+D :: Ariella Katz, Kaitlin Ho, Hugo Jenkins
APCS pd6
HW 103 - Erica's Friends, Hugo, and The One in the Middle
2022-05-18
time spent: 1.0 hrs
*/

public class RunMed {

  ALHeapMax lilVals;
  ALHeapMin bigVals;

  public RunMed() {
    lilVals = new ALHeapMax();
    bigVals = new ALHeapMin();
  }

  public Integer getMedian() {
    if (lilVals.size() == bigVals.size()) {
      return (lilVals.getMax() + bigVals.getMin())/2;
    }
    else {
      if (lilVals.size() > bigVals.size()) {
        return lilVals.getMax();
      }
      else {
        return bigVals.getMin();
      }
    }
  }

  public void add(Integer newVal) {
    if (newVal < lilVals.getMax()) {
      lilVals.add(newVal);
    }
    else {
      bigVals.add(newVal);
    }
    if (lilVals.size() > bigVals.size()+1) {
      while(lilVals.size() > bigVals.size()+1) {
        bigVals.add(lilVals.removeMin());
      }
    }
    else if (bigVals.size() > lilVals.size()+1) {
      while(bigVals.size() > lilVals.size()+1) {
        lilVals.add(bigVals.removeMin());
      }
    }
  }

}
