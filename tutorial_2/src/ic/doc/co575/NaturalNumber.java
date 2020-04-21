package ic.doc.co575;

/**
 * This class represents a natural number
 */
public class NaturalNumber implements Expression {

  private final int value;

  public NaturalNumber(int val) {
    if (val <= 0) {
      throw new IllegalArgumentException(val + " is not a natural number.");
    }
    value = val;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @Override
  public int evaluate() {
    return value;
  }

  @Override
  public int depth() {
    return 0;
  }

  @Override
  public int compareTo(Expression other) {
    if (other.evaluate() < this.evaluate()) {
      return 1;
    } else if (other.evaluate() == this.evaluate()) {
      return 0;
    } else {
      return -1;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof NaturalNumber) {
      return ((NaturalNumber) o).evaluate() == this.evaluate();
    }
    return false;
  }
}
