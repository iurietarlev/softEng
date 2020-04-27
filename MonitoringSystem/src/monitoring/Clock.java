package monitoring;

import java.time.LocalTime;

public interface Clock {
  LocalTime now();
}
