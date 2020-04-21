package ic.doc;

import java.util.LinkedHashMap;
import java.util.Map;

public class WeatherForecasterProxy implements WeatherForecaster {
  private final int maxSize; // max size of cache
  private final WeatherForecaster forecaster;

  private final LinkedHashMap<String, WeatherForecast> cache =
      new LinkedHashMap<>() {

        // overridden function removeEldestEntry is checked against every time
        // an element gets put into the LinkedHasMap
        @Override
        protected boolean removeEldestEntry(final Map.Entry eldest) {
          return size() > maxSize;
        }
      };

  public WeatherForecasterProxy(WeatherForecaster forecaster, int maxSize) {
    this.forecaster = forecaster;
    this.maxSize = maxSize;
  }

  @Override
  public WeatherForecast forecastFor(String region, String day) {
    // store key as concatenation of uppercase region and day
    final String key = region.toUpperCase() + day.toUpperCase();
    if (cache.containsKey(key)) {
      return cache.get(key);
    } else {
      final WeatherForecast forecast = forecaster.forecastFor(region, day);
      cache.put(key, forecast);
      return forecast;
    }
  }
}
