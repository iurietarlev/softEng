package ic.doc;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;

public class WeatherComForecaster implements WeatherForecaster {

  private final Forecaster forecaster = new Forecaster();

  @Override
  public WeatherForecast forecastFor(String region, String day) {
    Forecast forecast = forecaster.forecastFor(
        Region.valueOf(region.toUpperCase()),
        Day.valueOf(day.toUpperCase())
    );
    return new WeatherComForecast(forecast);
  }
}
