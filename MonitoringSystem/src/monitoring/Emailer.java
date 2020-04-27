package monitoring;

class Emailer implements Alerter {
  private Emailer() {}

  public static Emailer getInstance() {
    return new Emailer();
  }

  @Override
  public void send(String to, String msg) {
    System.out.println("Email: " + to + " :" + msg);
  }
}
