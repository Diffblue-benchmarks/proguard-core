package proguard.analysis.cpa.defaults;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DepthFirstWaitlistDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link DepthFirstWaitlist}
   */
  @Test
  public void testNewDepthFirstWaitlist() {
    // Arrange and Act
    DepthFirstWaitlist actualDepthFirstWaitlist = new DepthFirstWaitlist();

    // Assert
    assertEquals(0, actualDepthFirstWaitlist.size());
    assertEquals(0L, actualDepthFirstWaitlist.spliterator().getExactSizeIfKnown());
    assertFalse(actualDepthFirstWaitlist.iterator().hasNext());
    assertTrue(actualDepthFirstWaitlist.waitlist.isEmpty());
    assertTrue(actualDepthFirstWaitlist.isEmpty());
  }
}
