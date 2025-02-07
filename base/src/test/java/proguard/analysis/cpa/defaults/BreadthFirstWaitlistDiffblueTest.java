package proguard.analysis.cpa.defaults;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BreadthFirstWaitlistDiffblueTest {
  /**
   * Test new {@link BreadthFirstWaitlist} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BreadthFirstWaitlist}
   */
  @Test
  @DisplayName("Test new BreadthFirstWaitlist (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.analysis.cpa.defaults.BreadthFirstWaitlist.<init>()"})
  void testNewBreadthFirstWaitlist() {
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
