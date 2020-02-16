package ic.doc;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;

public class RecentlyUsedTest {
  RecentlyUsedList list = new RecentlyUsedList();

  @Test
  public void isInitializedEmpty() {
    assertTrue(list.isEmpty());
    assertThat(list.size(), is(0));
  }

  @Test
  public void allowsItemsToBeAdded() {
    list.add("hello");
    assertFalse(list.isEmpty());
    assertThat(list.size(), is(1));
    list.add("goodBye");
    assertThat(list.size(), is(2));
  }

  @Test
  public void keepsTheMostRecentItemAtTheTopOfTheList() {
    list.add("cat");
    list.add("dog");
    assertThat(list.get(0), is("dog"));
    assertThat(list.get(1), is("cat"));
  }

  @Test
  public void preventDuplicates() {
    list.add("cat");
    list.add("cat");
    assertThat(list.size(), is(1));
  }

  @Test
  public void movesTheMostRecentEntryToTheTopOfListIfDuplicatesAdded() {
    list.add("cat");
    list.add("dog");
    list.add("cat");
    assertThat(list.size(), is(2));
    assertThat(list.get(0), is("cat"));
  }
}