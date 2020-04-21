package ic.doc;

import com.weather.Forecast;

public class WeatherComForecast implements WeatherForecast {
  private final Forecast forecast;

  public WeatherComForecast(Forecast forecast) {
    this.forecast = forecast;
  }

  @Override
  public String summary() {
    return forecast.summary();
  }

  @Override
  public int temperature() {
    return forecast.temperature();
  }
}
