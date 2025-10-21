package proguard.analysis.cpa.defaults;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BreadthFirstWaitlistDiffblueTest {
  /**
   * Test new {@link BreadthFirstWaitlist} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BreadthFirstWaitlist}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BreadthFirstWaitlist.<init>()"})
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
