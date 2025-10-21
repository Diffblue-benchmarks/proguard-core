package proguard.analysis.cpa.defaults;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractWaitlistDiffblueTest {
  /**
   * Test {@link AbstractWaitlist#isEmpty()}.
   *
   * <p>Method under test: {@link AbstractWaitlist#isEmpty()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractWaitlist.isEmpty()"})
  public void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new BreadthFirstWaitlist()).isEmpty());
  }

  /**
   * Test {@link AbstractWaitlist#size()}.
   *
   * <p>Method under test: {@link AbstractWaitlist#size()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int AbstractWaitlist.size()"})
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new BreadthFirstWaitlist()).size());
  }

  /**
   * Test {@link AbstractWaitlist#iterator()}.
   *
   * <p>Method under test: {@link AbstractWaitlist#iterator()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Iterator AbstractWaitlist.iterator()"})
  public void testIterator() {
    // Arrange, Act and Assert
    assertFalse((new BreadthFirstWaitlist()).iterator().hasNext());
  }

  /**
   * Test {@link AbstractWaitlist#spliterator()}.
   *
   * <p>Method under test: {@link AbstractWaitlist#spliterator()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Spliterator AbstractWaitlist.spliterator()"})
  public void testSpliterator() {
    // Arrange, Act and Assert
    assertEquals(0L, (new BreadthFirstWaitlist()).spliterator().getExactSizeIfKnown());
  }
}
