package ic.doc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class PairTest {

  @Test
  public void testEqualPairsAreEqual() {
    Pair<String, String> pair = new Pair<>("a", "b");
    assertEquals(pair, pair);
    assertEquals(pair, new Pair<>("a", "b"));
    assertNotEquals(new Pair<>("a", "c"), new Pair<>("a", "b"));
    assertNotEquals(new Pair<>("c", "a"), new Pair<>("b", "a"));
    assertNotEquals(pair, new Pair<>(1, 3));
    assertNotEquals(null, pair);
  }

  @Test
  public void twoEqualPairsHaveTheSameHashcode() {
    assertEquals(new Pair<>("a", "b").hashCode(), new Pair<>("a", "b").hashCode());
  }
}
