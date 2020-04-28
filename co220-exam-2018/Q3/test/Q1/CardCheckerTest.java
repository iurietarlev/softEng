package Q1;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class CardCheckerTest {

  @Rule
  public JUnitRuleMockery context  = new JUnitRuleMockery();

  Observer obs1 = context.mock(Observer.class, "observer1");
  Observer obs2 = context.mock(Observer.class, "observer2");
  CardChecker cardChecker = new CardChecker();

  @Test
  public void observersAreNotAlertedIfCardNumberContains12Digits(){
    context.checking(new Expectations(){{
      never(obs1);
      never(obs2);
    }});

    cardChecker.addObserver(obs1);
    cardChecker.addObserver(obs2);
    cardChecker.validate("123123123123");
  }

  @Test
  public void observersIsAreAlertedIfCardDoesNotContain12Digits(){
    context.checking(new Expectations(){{
      oneOf(obs1).alert("12");
      oneOf(obs2).alert("12");
    }});

    cardChecker.addObserver(obs1);
    cardChecker.addObserver(obs2);
    cardChecker.validate("12");
  }


  @Test
  public void removedObserversDoNotGetAlerted(){
    context.checking(new Expectations(){{
      oneOf(obs1).alert("12");
    }});

    cardChecker.addObserver(obs1);
    cardChecker.addObserver(obs2);
    cardChecker.removeObserver(obs2);
    cardChecker.validate("12");
  }
}