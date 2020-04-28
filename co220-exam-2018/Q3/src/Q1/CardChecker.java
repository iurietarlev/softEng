package Q1;

import java.util.ArrayList;

public class CardChecker {
  private ArrayList<Observer> observers = new ArrayList<>();

  public void validate(String s) {
    int count = s.length();
    if (count != 12) {
      for (Observer i : observers) {
        i.alert(s);
      }
    }
  }

  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }
}
