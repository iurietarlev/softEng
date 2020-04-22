package ic.doc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;
import org.junit.Test;

public class weatherDotComTemperatureServicetest {

  @Test
  public void canRetrieveTemperatureData(){
    TemperatureService weatherDotCom = new WeatherDotComTemperatureService();

    int temp = weatherDotCom.temperatureFor("London", DayOfWeek.FRIDAY);

    assertThat(temp, is(greaterThan(-20)));
  }
}
