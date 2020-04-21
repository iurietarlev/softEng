package ic.doc;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;


public class WeatherForecasterProxyTest {
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  private WeatherForecaster aForecaster = context.mock(WeatherForecaster.class);
  WeatherForecaster forecaster = new WeatherForecasterProxy(aForecaster, 1);

  @Test
  public void proxyCallsTheForecasterThatItWasPassedIn() {
    context.checking(new Expectations(){{
      oneOf(aForecaster).forecastFor("London", "Monday");
    }});
    forecaster.forecastFor("London", "Monday");
  }

  @Test
  public void searchRetrievedFromCacheUponTheSameForecastRequest() {
    context.checking(new Expectations(){{
      oneOf(aForecaster).forecastFor("London", "Monday");
    }});
    forecaster.forecastFor("London", "Monday");
    forecaster.forecastFor("London", "Monday");
  }

  @Test
  public void searchCallsApiBecauseCacheReachedMaxSizeAndWasOverwritten() {
    context.checking(new Expectations(){{
      exactly(2).of(aForecaster).forecastFor("London", "Monday");
      oneOf(aForecaster).forecastFor("Edinburgh", "Monday");
    }});
    forecaster.forecastFor("London", "Monday");
    forecaster.forecastFor("Edinburgh", "Monday");
    forecaster.forecastFor("London", "Monday");
  }
}