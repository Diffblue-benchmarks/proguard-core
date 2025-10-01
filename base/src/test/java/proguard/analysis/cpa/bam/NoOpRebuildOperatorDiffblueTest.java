package proguard.analysis.cpa.bam;

import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.interfaces.AbstractState;
import proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState;

class NoOpRebuildOperatorDiffblueTest {
  /**
   * Test {@link NoOpRebuildOperator#rebuild(AbstractState, AbstractState)}.
   *
   * <ul>
   *   <li>Then return {@link JvmMemoryLocationAbstractState#top}.
   * </ul>
   *
   * <p>Method under test: {@link NoOpRebuildOperator#rebuild(AbstractState, AbstractState)}
   */
  @Test
  @DisplayName("Test rebuild(AbstractState, AbstractState); then return top")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AbstractState NoOpRebuildOperator.rebuild(AbstractState, AbstractState)"})
  void testRebuild_thenReturnTop() {
    // Arrange and Act
    AbstractState actualRebuildResult =
        new NoOpRebuildOperator()
            .rebuild(JvmMemoryLocationAbstractState.top, JvmMemoryLocationAbstractState.top);

    // Assert
    assertSame(((JvmMemoryLocationAbstractState) actualRebuildResult).top, actualRebuildResult);
  }
}
