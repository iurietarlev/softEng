package ic.doc.templatemethod;

import static ic.doc.matchers.IterableBeginsWith.beginsWith;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

import org.junit.Test;

public class NumberSequenceTest {

  final NumberSequence sequence = new NumberSequence() {
    @Override
    protected int positiveTerm(int i) {
      return i;
    }
  };

  @Test
  public void isUndefinedForNegativeIndices() {
    try {
      sequence.term(-1);
      fail("should have thrown exception");
    } catch (IllegalArgumentException e) {
      assertThat(e.getMessage(), containsString("Not defined for indices < 0"));
    }
  }

  @Test
  public void canBeIteratedThrough() {
    assertThat(sequence, beginsWith(0, 1, 2, 3, 4, 5));
  }

}