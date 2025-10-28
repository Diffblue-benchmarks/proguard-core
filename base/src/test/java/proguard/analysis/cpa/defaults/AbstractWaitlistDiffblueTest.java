package proguard.analysis.cpa.defaults;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AbstractWaitlistDiffblueTest {
  /**
   * Method under test: {@link AbstractWaitlist#isEmpty()}
   */
  @Test
  public void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new BreadthFirstWaitlist()).isEmpty());
  }

  /**
   * Method under test: {@link AbstractWaitlist#size()}
   */
  @Test
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new BreadthFirstWaitlist()).size());
  }

  /**
   * Method under test: {@link AbstractWaitlist#iterator()}
   */
  @Test
  public void testIterator() {
    // Arrange, Act and Assert
    assertFalse((new BreadthFirstWaitlist()).iterator().hasNext());
  }

  /**
   * Method under test: {@link AbstractWaitlist#spliterator()}
   */
  @Test
  public void testSpliterator() {
    // Arrange, Act and Assert
    assertEquals(0L, (new BreadthFirstWaitlist()).spliterator().getExactSizeIfKnown());
  }
}
