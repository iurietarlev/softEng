package monitoring;

class SmsSender implements Alerter {
  public void send(String msisdn, String msg) {
    System.out.println("SMS: " + msisdn + " :" + msg);
  }
}
