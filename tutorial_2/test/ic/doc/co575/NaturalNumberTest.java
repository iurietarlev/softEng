package ic.doc.co575;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class NaturalNumberTest {

  @Test
  public void containsValue() {
    NaturalNumber w = new NaturalNumber(2);
    assertThat(w.evaluate(), is(2));
  }
}
