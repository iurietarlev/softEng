package ic.doc.templatemethod;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class TriangularSequenceTest {

  final TriangularSequence sequence = new TriangularSequence();

  @Test
  public void definesFirstTwoTermsToBeOne() {
    assertThat(sequence.term(0), is(1));
    assertThat(sequence.term(1), is(3));
  }

  @Test
  public void definesSubsequentTermsToBeTheSumOfThePreviousTwo() {
    assertThat(sequence.term(2), is(6));
    assertThat(sequence.term(3), is(10));
    assertThat(sequence.term(4), is(15));
  }
}