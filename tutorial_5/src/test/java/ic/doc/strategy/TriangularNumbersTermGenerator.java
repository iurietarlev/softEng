package ic.doc.strategy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class TriangularNumbersTermGenerator {

  final TermGenerator sequence = new TriangleNumbersTermGenerator();

  @Test
  public void definesFirstTwoTermsToBeOne() {
    assertThat(sequence.positiveTerm(0), is(1));
    assertThat(sequence.positiveTerm(1), is(3));
  }

  @Test
  public void definesSubsequentTermsToBeTheSumOfThePreviousTwo() {

    assertThat(sequence.positiveTerm(2), is(6));
    assertThat(sequence.positiveTerm(3), is(10));
    assertThat(sequence.positiveTerm(4), is(15));
  }
}