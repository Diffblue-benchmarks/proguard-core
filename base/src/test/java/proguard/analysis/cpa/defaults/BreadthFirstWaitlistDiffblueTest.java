package proguard.analysis.cpa.defaults;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BreadthFirstWaitlistDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link BreadthFirstWaitlist}
   */
  @Test
  public void testNewBreadthFirstWaitlist() {
    // Arrange and Act
    BreadthFirstWaitlist actualBreadthFirstWaitlist = new BreadthFirstWaitlist();

    // Assert
    assertEquals(0, actualBreadthFirstWaitlist.size());
    assertEquals(0L, actualBreadthFirstWaitlist.spliterator().getExactSizeIfKnown());
    assertFalse(actualBreadthFirstWaitlist.iterator().hasNext());
    assertTrue(actualBreadthFirstWaitlist.waitlist.isEmpty());
    assertTrue(actualBreadthFirstWaitlist.isEmpty());
  }
}
