package proguard.analysis.cpa.defaults;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DepthFirstWaitlistDiffblueTest {
  /**
   * Test new {@link DepthFirstWaitlist} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DepthFirstWaitlist}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DepthFirstWaitlist.<init>()"})
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
