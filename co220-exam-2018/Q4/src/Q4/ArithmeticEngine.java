package Q4;

import java.util.ArrayList;
import java.util.List;

//model
public class ArithmeticEngine {
  private ArrayList<Updatable> observers = new ArrayList<Updatable>();
  private int max;
  private double mean;
  private final List<Integer> numbers = new ArrayList<>();

  public void addObserver(Updatable observer) {
    observers.add(observer);
  }

  public void apply(int n) {
    numbers.add(n);
    max = Math.max(max, n);
    mean = numbers.stream().mapToInt(val -> val).average().orElse(0.0);
    notifyObservers();
  }

  private void notifyObservers() {
    for (Updatable observer : observers) {
      observer.updateWith(max, mean);
    }
  }
}
