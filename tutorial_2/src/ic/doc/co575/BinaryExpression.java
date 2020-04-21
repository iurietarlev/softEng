package ic.doc.co575;

public abstract class BinaryExpression implements Expression {
  private Expression left;
  private Expression right;

  //constructor
  public BinaryExpression(Expression left, Expression right) {
    this.left = left;
    this.right = right;
  }

  public Expression getLeft() {
    return left;
  }

  public Expression getRight() {
    return right;
  }

  @Override
  public int depth() {
    int leftDepth = getLeft().depth() + 1;
    int rightDepth = getRight().depth() + 1;
    return Math.max(leftDepth, rightDepth);
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
    if (o instanceof Expression) {
      return ((Expression) o).evaluate() == this.evaluate();
    }

    return false;

  }
}
