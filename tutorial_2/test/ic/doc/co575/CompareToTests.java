package ic.doc.co575;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;




public class CompareToTests {
  @Test
  public void compareToTest() {
    Product a = new Product(new NaturalNumber(3), new NaturalNumber(4));
    Addition b = new Addition(new NaturalNumber(1), new NaturalNumber(1));
    Product c = new Product(b, new NaturalNumber(1));

    int expectedOutput = 1;

    final String errorMsg = String.format("Incorrect comparison result, given two expressions: "
        + "%s and %s", a, c);
    assertThat(errorMsg, a.compareTo(c), equalTo(expectedOutput));
  }

  @Test
  public void equalsTest() {
    Product a = new Product(new NaturalNumber(3), new NaturalNumber(4));
    Addition b = new Addition(new NaturalNumber(1), new NaturalNumber(1));

    boolean expectedOutput = false;
    boolean equalsBool = a.equals(b);


    final String errorMsg = String.format("equalTest fails when comparing %s to %s ", a, b);
    assertThat(errorMsg, equalsBool, equalTo(expectedOutput));
  }

  @Test
  public void equalsTest1() {
    Product a = new Product(new NaturalNumber(3), new NaturalNumber(4));
    Addition b = new Addition(new NaturalNumber(1), new NaturalNumber(1));

    boolean expectedOutput = false;
    String obj = "Hello";
    boolean equalsBool = a.equals(obj);

    final String errorMsg = String.format("equalTest fails when comparing %s to %s ", a, obj);
    assertThat(errorMsg, equalsBool, equalTo(expectedOutput));
  }

  @Test
  public void equalsTest2() {
    Product a = new Product(new NaturalNumber(3), new NaturalNumber(3));
    Addition b = new Addition(new NaturalNumber(3), new NaturalNumber(3));

    boolean expectedOutput = false;
    boolean equalsBool = a.equals(b);


    final String errorMsg = String.format("equalTest fails when comparing %s to %s ", a, b);
    assertThat(errorMsg, equalsBool, equalTo(expectedOutput));
  }

  @Test
  public void equalsTest3() {
    Product a = new Product(new NaturalNumber(3), new NaturalNumber(3));
    Product b = new Product(new NaturalNumber(3), new NaturalNumber(3));

    boolean expectedOutput = true;
    boolean equalsBool = a.equals(b);


    final String errorMsg = String.format("equalTest fails when comparing %s to %s ", a, b);
    assertThat(errorMsg, equalsBool, equalTo(expectedOutput));
  }
}
