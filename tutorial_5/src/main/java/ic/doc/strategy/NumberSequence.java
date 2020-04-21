package ic.doc.strategy;

import java.util.Iterator;

import org.jetbrains.annotations.NotNull;

public class NumberSequence implements Iterable<Integer> {

  private final TermGenerator termGenerator;

  public NumberSequence(TermGenerator termGenerator) {
    this.termGenerator = termGenerator;
  }

  public int term(int i) {
    if (i < 0) {
      throw new IllegalArgumentException("Not defined for indices < 0");
    }
    return termGenerator.positiveTerm(i);
  }

  @NotNull
  public Iterator<Integer> iterator() {
    return new SequenceIterator();
  }

  private class SequenceIterator implements Iterator<Integer> {

    private int index = 0;

    @Override
    public boolean hasNext() {
      return true;
    }

    @Override
    public Integer next() {
      return term(index++);
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("remove is not implemented");
    }
  }
}
