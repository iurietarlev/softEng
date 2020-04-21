package ic.doc.co575;

public class Product extends BinaryExpression {

  public Product(Expression a, Expression b) {
    super(a, b);
  }

  @Override
  public String toString() {
    String temp;
    if (getLeft() instanceof Addition) {
      temp = '(' + getLeft().toString() + ")*";
    } else {
      temp = getLeft().toString() + "*";
    }

    if (getRight() instanceof Addition) {
      temp += '(' + getRight().toString() + ')';
    } else {
      temp += getRight().toString();
    }
    return temp;
  }

  @Override
  public int evaluate() {
    return getLeft().evaluate() * getRight().evaluate();
  }

}
