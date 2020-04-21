package ic.doc.co575;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;


public class AdditionProductCombinedTest {
  @Test
  public void evaluate_product_addition_1() {
    Addition a = new Addition(new NaturalNumber(4), new NaturalNumber(4));
    Addition b = new Addition(new NaturalNumber(3), new NaturalNumber(2));
    Product c = new Product(a, b);

    int expectedOutput = 40;
    String expectedStringOutput = "(4+4)*(3+2)";
    int output = c.evaluate();
    String outputString = c.toString();

    final String errorMsg = String.format("Problem adding nested additions: %s", c);
    assertThat(errorMsg, output, equalTo(expectedOutput));
    assertThat(errorMsg, outputString, equalTo(expectedStringOutput));
  }

  @Test
  public void evaluate_product_addition_2() {
    Addition a = new Addition(new NaturalNumber(2), new NaturalNumber(3));
    Product b = new Product(new NaturalNumber(3), a);
    Addition c = new Addition(new NaturalNumber(4), b);

    int expectedOutput = 19;
    String expectedStringOutput = "4+(3*(2+3))";

    int output = c.evaluate();
    String outputString = c.toString();

    final String errorMsg = String.format("Problem adding nested additions: %s", c);
    assertThat(errorMsg, output, equalTo(expectedOutput));
    assertThat(errorMsg, outputString, equalTo(expectedStringOutput));
  }
}
