package ic.doc.co575;

public class Addition extends BinaryExpression {

  public Addition(Expression a, Expression b) {
    super(a, b);
  }

  @Override
  public String toString() {
    String temp;
    if (getLeft() instanceof Product) {
      temp = '(' + getLeft().toString() + ") +";
    } else {
      temp = getLeft().toString() + "+";
    }

    if (getRight() instanceof Product) {
      temp += '(' + getRight().toString() + ')';
    } else {
      temp += getRight().toString();
    }
    return temp;
  }


  @Override
  public int evaluate() {
    return (getLeft().evaluate() + getRight().evaluate());
  }


}
