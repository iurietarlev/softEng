package ic.doc;

import java.util.LinkedList;

public class RecentList<T> {
  private final LinkedList<T> queue = new LinkedList<>();

  public T getItem() {
    return queue.pollFirst();
  }

  public void addItem(T item) {

    //removes the first occurrence of item from list if exists
    queue.remove(item);

    //adds element to the top of list
    queue.addFirst(item);
  }

  public int getSize() {
    return queue.size();
  }

  public boolean isEmpty() {
    return queue.isEmpty();
  }
}
