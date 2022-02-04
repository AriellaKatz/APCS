public class Arrays{
  //Ex 1:
  //Takes a double array, a, and returns a new array
  // that contains the elements of a raised to the power pow.
  public static double[] powArray(double[] a, double pow) {
    double[] b = new double[a.length];
    for (int i = 0; i < a.length; i++) {
      b[i] = Math.pow(a[i], pow);
    }
    return b;
  }
  //
  public static void histogram(int[] scores) {
    int[] counts = new int[100];
    for (int score : scores) {
      counts[score]++;
      System.out.println(score + "\t -> \t" + counts[score]);
    }

  }

  //Ex 4:
  public static int indexOfMax(int[] integersArray) {
    //Find the element with the greatest value
    int greatestYet = 0;
    for (int i = 0; i < integersArray.length; i++) {
      if (integersArray[i] > greatestYet) {
        greatestYet = integersArray[i];
      } else {
        continue;
      }
    }
    //Return the index of that element
    for (int i = 0; i < integersArray.length; i++) {
      int target = integersArray[i];
      if (target == greatestYet) {
        return i;
      }
    }
    return -1;
  }

  //Ex 5:
  public static boolean[] sieve(int n) {
    boolean[] isItPrime = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (i < 2) {
        isItPrime[i] = false;
      } else {
        if (i == 2) {
          isItPrime[i] = true;
        } else {
          for (int j = 2; j < i; j++) {
            if (i % j == 0) {
              isItPrime[i] = false;
              break;
            } 
            isItPrime[i] = true;
          }
        }
      }
    }
    return isItPrime;
  }
  public static void printArray(boolean[] a) {
    System.out.print("{" + a[0]);
    for (int i = 1; i < a.length; i++) {
      System.out.print(", " + a[i]);
    }
    System.out.println("}");
  }

  public static void main(String[] args) {
    printArray(sieve(12));
  }
  }
