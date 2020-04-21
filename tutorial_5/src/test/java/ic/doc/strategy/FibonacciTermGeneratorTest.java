package ic.doc.strategy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class FibonacciTermGeneratorTest {

  final TermGenerator termGen = new FibonacciTermGenerator();

  @Test
  public void definesFirstTwoTermsToBeOne() {
    assertThat(termGen.positiveTerm(0), is(1));
    assertThat(termGen.positiveTerm(1), is(1));
  }

  @Test
  public void definesSubsequentTermsToBeTheSumOfThePreviousTwo() {
    assertThat(termGen.positiveTerm(2), is(2));
    assertThat(termGen.positiveTerm(3), is(3));
    assertThat(termGen.positiveTerm(4), is(5));
  }
}