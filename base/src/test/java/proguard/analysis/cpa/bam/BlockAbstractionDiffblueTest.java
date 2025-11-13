package proguard.analysis.cpa.bam;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.defaults.BreadthFirstWaitlist;
import proguard.analysis.cpa.defaults.DefaultReachedSet;
import proguard.analysis.cpa.interfaces.ReachedSet;
import proguard.analysis.cpa.interfaces.Waitlist;

class BlockAbstractionDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BlockAbstraction.<init>(ReachedSet, Waitlist)",
    "ReachedSet BlockAbstraction.getReachedSet()",
    "Waitlist BlockAbstraction.getWaitlist()"
  })
  void testGettersAndSetters() {
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
