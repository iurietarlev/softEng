package ic.doc;

import com.weather.Day;
import com.weather.Forecaster;
import com.weather.Region;
import java.time.DayOfWeek;

public class WeatherDotComTemperatureService implements TemperatureService {
  @Override
  public int temperatureFor(String place, DayOfWeek dayOfWeek) {
    Day day = Day.valueOf(dayOfWeek.toString());
    Region region = Region.valueOf(place.toUpperCase());
    return new Forecaster().forecastFor(region, day).temperature();
  }
}
