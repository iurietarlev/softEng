package monitoring;

import java.time.LocalTime;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.Expectations;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class MonitorTest {

  private final ControllableClock clock = new ControllableClock();
  Mockery context = new JUnit4Mockery();
  Alerter emailer = context.mock(Alerter.class,"emailSender");
  Alerter smsSender = context.mock(Alerter.class, "smsSender");

  @Test
  public void sendsAnEmailOnlyWhenAProbeFailsOutOfBusinessHours() {
    clock.currentTimeIs(18, 00);
    context.checking(
        new Expectations() {
          {
            oneOf(emailer).send("support@example.com", "always fails");
          }
        });

    new Monitor(emailer, new SmsSender(), clock, new FailingProbe()).check();
  }

  @Test
  public void sendsBothAnEmailAndAnSmsIfProbeFailsDuringBusinessHours() {

    clock.currentTimeIs(17,59 );
    context.checking(
        new Expectations() {
          {
            oneOf(emailer).send("support@example.com", "always fails");
            oneOf(smsSender).send("+447777123456", "always fails");
          }
        });

    new Monitor(emailer, smsSender, clock, new FailingProbe()).check();
  }

  private static class FailingProbe implements Probe {
    @Override
    public boolean passes() {
      return false;
    }

    @Override
    public String getFailureDescription() {
      return "always fails";
    }
  }

  private class ControllableClock implements Clock {

    private LocalTime time;

    @Override
    public LocalTime now() {
      return time;
    }

    public void currentTimeIs(int hour, int min) {
      time = LocalTime.of(hour, min);
    }
  }
}
