package monitoring;

public interface Alerter {
  void send(String to, String msg);
}
