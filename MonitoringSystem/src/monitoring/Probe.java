package monitoring;

public interface Probe {
  boolean passes();

  String getFailureDescription();
}
