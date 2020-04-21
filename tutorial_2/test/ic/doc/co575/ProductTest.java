package ic.doc.co575;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;


public class ProductTest {

  @Test
  public void evaluate_TwoNumbers() {
    Product a = new Product(new NaturalNumber(3), new NaturalNumber(4));
    int expectedOutput = 12;
    int output = a.evaluate();
    final String errorMsg = String.format("Problem multiplying two natural numbers: %s.", a);
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }

  @Test
  public void evaluate_NestedProducts() {
    Product a = new Product(new NaturalNumber(3), new NaturalNumber(4));
    Product b = new Product(new NaturalNumber(1), new NaturalNumber(5));
    Product c = new Product(a, b);

    int expectedOutput = 60;
    int output = c.evaluate();
    final String errorMsg =
        String.format("Problem multiplying nested products of natural numbers: %s.", c);
    assertThat(errorMsg, output, equalTo(expectedOutput));
  }

}
