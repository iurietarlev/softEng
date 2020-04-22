package ic.doc;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class ArithmeticEngineTest {

  @Rule public JUnitRuleMockery context = new JUnitRuleMockery();

  Updatable display = context.mock(Updatable.class);

  ArithmeticEngine calc = new ArithmeticEngine();

  @Test
  public void updatesDisplayWhenANewNumberIsInput() {
    calc.addObserver(display);
    context.checking(
        new Expectations() {
          {
            oneOf(display).updateWith(5);
          }
        });

    this.calc.input(5);
  }

  @Test
  public void supportsAddingTwoValues() {
    allowDisplayWithTwoNumbers();
    context.checking(
        new Expectations() {
          {
            oneOf(display).updateWith(8);
          }
        });

    calc.input(5);
    calc.input(3);
    calc.apply(Operator.PLUS);
  }

  @Test
  public void supportsSubtractingTwoValues() {
    allowDisplayWithTwoNumbers();
    context.checking(
        new Expectations() {
          {
            oneOf(display).updateWith(2);
          }
        });

    calc.input(5);
    calc.input(3);
    calc.apply(Operator.MINUS);
  }


  @Test
  public void supportsMultiplicationOfTwoNumbers() {
    allowDisplayWithTwoNumbers();
    context.checking(
        new Expectations() {
          {
            oneOf(display).updateWith(15);
          }
        });

    calc.input(5);
    calc.input(3);
    calc.apply(Operator.TIMES);
  }

  @Test
  public void supportsDivisionOfTwoNumbers() {
    allowDisplayWithTwoNumbers();
    context.checking(
        new Expectations() {
          {
            oneOf(display).updateWith(1);
          }
        });

    calc.input(5);
    calc.input(3);
    calc.apply(Operator.DIVIDE);
  }


  private void allowDisplayWithTwoNumbers() {
    calc.addObserver(display);
    context.checking(
        new Expectations() {
          {
            allowing(display).updateWith(5);
            allowing(display).updateWith(3);
          }
        });
  }
}
