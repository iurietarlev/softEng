package ic.doc.camera;

public class Camera implements WriteListener {

  private final Sensor sensor;
  private final MemoryCard memoryCard;
  private boolean writing = false; //false by default
  private boolean powerIsOn = false;

  public Camera(Sensor sensor, MemoryCard memoryCard) {
    this.sensor = sensor;
    this.memoryCard = memoryCard;
  }

  public void powerOn() {
    sensor.powerUp();
    powerIsOn = true;
  }

  public void powerOff() {
    if (!writing) {
      sensor.powerDown();
      powerIsOn = false;
    }
  }

  public void pressShutter() {
    if (powerIsOn && !writing) {
      memoryCard.write(sensor.readData());
      writing=true;
    }
  }

  @Override
  public void writeComplete() {
    writing = false;
    if (powerIsOn) {
      sensor.powerDown();
    }
  }
}

