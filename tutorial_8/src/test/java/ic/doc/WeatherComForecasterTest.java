package ic.doc;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class WeatherComForecasterTest {
  WeatherForecaster forecaster = new WeatherComForecaster();

  @Test
  public void callingForecastForReturnsObjectOfTypeWeatherComForecast() {
    WeatherForecast forecast = forecaster.forecastFor("London", "Monday");
    assertThat(forecast, notNullValue());
    assertThat(forecast.temperature(), is(lessThan(100)));
    assertThat(forecast.summary(), is(CoreMatchers.any(String.class)));
  }
}
