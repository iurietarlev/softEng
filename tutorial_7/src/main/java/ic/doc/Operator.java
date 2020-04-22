package ic.doc;

enum Operator {
  PLUS("+") {
    @Override
    public Integer apply(Integer x, Integer y) {
      return x + y;
    }
  },
  MINUS("-") {
    @Override
    public Integer apply(Integer x, Integer y) {
      return y - x;
    }
  },
  TIMES("*") {
    @Override
    public Integer apply(Integer x, Integer y) {
      return y*x;
    }
  },
  DIVIDE("/") {
    @Override
    public Integer apply(Integer x, Integer y) {
      return y/x;
    }
  };


  private String label;

  Operator(String label) {
    this.label = label;
  }

  public String label() {
    return label;
  }

  public abstract Integer apply(Integer x, Integer y);
}
