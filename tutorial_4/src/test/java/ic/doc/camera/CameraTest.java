package ic.doc.camera;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class CameraTest {

  private static final byte[] IMAGE = new byte[4];
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  Sensor sensor = context.mock(Sensor.class);
  MemoryCard memoryCard = context.mock(MemoryCard.class);
  Camera camera = new Camera(sensor, memoryCard);

  private void switchOnTheCamera() {
    context.checking(new Expectations() {{
      ignoring(sensor).powerUp();
    }});
    camera.powerOn();
  }

  @Test
  public void switchingTheCameraOnPowersUpTheSensor() {
    context.checking(new Expectations() {{
      oneOf(sensor).powerUp();
    }});
    camera.powerOn();
  }

  @Test
  public void switchingTheCameraOffPowersDownTheSensor() {
    switchOnTheCamera();

    context.checking(new Expectations() {{
      oneOf(sensor).powerDown();
    }});
    camera.powerOff();
  }

  @Test
  public void pressingTheShutterWhenCameraIsOnCopiesDataToMemoryCard() {
    switchOnTheCamera();
    context.checking(new Expectations() {{
      oneOf(sensor).readData(); will(returnValue(IMAGE));
      oneOf(memoryCard).write(IMAGE);
    }});
    camera.pressShutter();
  }

  @Test
  public void pressingTheCameraShutterWhenPowerIsOffDoesNothing() {
    context.checking(new Expectations() {{
      never(sensor);
      never(memoryCard);
    }});
    camera.pressShutter();
  }

  @Test
  public void doesNotPowerDownTheSensorUntilWritingIsComplete() {
    switchOnTheCamera();
    context.checking(new Expectations() {{
      oneOf(sensor).readData(); will(returnValue(IMAGE));
      oneOf(memoryCard).write(IMAGE);
    }});

    camera.pressShutter();
    camera.powerOff();

    context.checking(new Expectations(){{
      oneOf(sensor).powerDown();
    }} );

    camera.writeComplete();
  }

  @Test
  public void nothingHappensIfShutterPressedWhilstDataIsBeingWritten() {
    switchOnTheCamera();
    context.checking(new Expectations() {{
      oneOf(sensor).readData(); will(returnValue(IMAGE));
      oneOf(memoryCard).write(IMAGE);
    }});
    camera.pressShutter();

    context.checking(new Expectations() {{
      never(sensor);
      never(memoryCard);
    }});

    camera.pressShutter();
  }
}
