// Pink Lemonade (Ariella Katz, Jacob Ng, Emily Ortiz)
// APCS Pd 6
// HW91: Deque the Halls
// 2022-04-13
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
    public boolean offerFirst(Card e);
    public boolean offerLast(Card e);
    public boolean add(Card e);
    public boolean offer(Card e);
    public Card remove();
    public Card poll();
    public Card element();
    public Card peek();
    public boolean contains(Card e);
    public int size();
    public Iterator<Card> iterator();

    public boolean removeFirstOccurrence(Card e);
    public boolean removeLastOccurrence(Card o);
    public void push(Card e);
    public Card pop();
    public Iterator<Card> descendingIterator();


}
