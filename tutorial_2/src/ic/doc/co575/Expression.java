package ic.doc.co575;

public interface Expression extends Comparable<Expression> {

  int evaluate();

  int depth();
}
