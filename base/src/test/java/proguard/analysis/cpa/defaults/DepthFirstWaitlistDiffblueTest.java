package proguard.analysis.cpa.defaults;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DepthFirstWaitlistDiffblueTest {
  /**
   * Test new {@link DepthFirstWaitlist} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DepthFirstWaitlist}
   */
  @Test
  @DisplayName("Test new DepthFirstWaitlist (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DepthFirstWaitlist.<init>()"})
  void testNewDepthFirstWaitlist() {
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
