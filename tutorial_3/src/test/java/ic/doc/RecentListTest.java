package ic.doc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RecentListTest {

  final RecentList<String> list = new RecentList<>();

  @Test
  public void initialisesAnEmptyList() {
    assertTrue(list.isEmpty());
    assertThat(list.getSize(), is(0));
  }

  @Test
  public void allowsItemsToBeAdded() {
    list.addItem("hello");
    assertFalse(list.isEmpty());
    assertThat(list.getSize(), is(1));
    list.addItem("good bye");
    assertThat(list.getSize(), is(2));
  }

  @Test
  public void keepsTheMostRecentItemAtTheTopOfList() {
    list.addItem("cat");
    list.addItem("dog");
    assertThat(list.getItem(), is("dog"));
    assertThat(list.getItem(), is("cat"));
  }

  @Test
  public void preventsDuplicates() {
    
    list.addItem("cat");
    list.addItem("cat");
    assertThat(list.getSize(), is(1));
  }

  @Test
  public void movesAddedDuplicateItemToTopOfQueue() {
    list.addItem("one");
    list.addItem("two");
    list.addItem("one");

    assertThat(list.getSize(), is(2));
    assertThat(list.getItem(), is("one"));
  }
}
