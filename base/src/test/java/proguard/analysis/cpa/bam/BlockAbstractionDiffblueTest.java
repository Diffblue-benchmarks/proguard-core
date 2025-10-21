package proguard.analysis.cpa.bam;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.analysis.cpa.defaults.BreadthFirstWaitlist;
import proguard.analysis.cpa.defaults.DefaultReachedSet;
import proguard.analysis.cpa.interfaces.ReachedSet;
import proguard.analysis.cpa.interfaces.Waitlist;

public class BlockAbstractionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BlockAbstraction#BlockAbstraction(ReachedSet, Waitlist)}
   *   <li>{@link BlockAbstraction#getReachedSet()}
   *   <li>{@link BlockAbstraction#getWaitlist()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BlockAbstraction.<init>(ReachedSet, Waitlist)",
    "ReachedSet BlockAbstraction.getReachedSet()",
    "Waitlist BlockAbstraction.getWaitlist()"
  })
  public void testGettersAndSetters() {
    // Arrange
    DefaultReachedSet reachedSet = new DefaultReachedSet();
    BreadthFirstWaitlist waitlist = new BreadthFirstWaitlist();

    // Act
    BlockAbstraction actualBlockAbstraction = new BlockAbstraction(reachedSet, waitlist);
    ReachedSet actualReachedSet = actualBlockAbstraction.getReachedSet();

    // Assert
    assertTrue(actualReachedSet instanceof Set);
    assertSame(waitlist, actualBlockAbstraction.getWaitlist());
    assertSame(reachedSet, actualReachedSet);
  }
}
