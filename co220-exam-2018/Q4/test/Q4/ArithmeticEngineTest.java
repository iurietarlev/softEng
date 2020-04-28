package Q4;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class ArithmeticEngineTest {

  @Rule public JUnitRuleMockery context = new JUnitRuleMockery();
  final Updatable updatable = context.mock(Updatable.class);
  final ArithmeticEngine arithmeticEngine = new ArithmeticEngine();

  @Test
  public void ObserverIsNotifiedWithTheFirstEnteredValue() {
    context.checking(
        new Expectations() {
          {
            oneOf(updatable).updateWith(3, 3.0);
          }
        });

    arithmeticEngine.addObserver(updatable);
    arithmeticEngine.apply(3);
  }
}
