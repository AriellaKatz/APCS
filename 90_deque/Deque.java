// Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz)
// APCS Pd 6
// HW90: Swabbing the Deque
// 2022-04-12
// Time Spent: 0.5 hrs

public interface Deque<Card>{
  public void addFirst(Card e);
  public void addLast(Card e);
  public Card removeFirst();
  public Card removeLast();
  public Card getFirst();
  public Card getLast();

  public Card peekFirst();
  public Card peekLast();
  public Card pollFirst();
  public Card pollLast();

  // Unnecessary
  // public boolean offerFirst(Card e);
  // public boolean offerLast(Card e);
}
