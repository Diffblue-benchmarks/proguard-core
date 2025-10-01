package proguard.analysis.cpa.defaults;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.interfaces.AbstractState;
import proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState;

class NeverAbortOperatorDiffblueTest {
  /**
   * Test {@link NeverAbortOperator#abort(AbstractState)}.
   *
   * <p>Method under test: {@link NeverAbortOperator#abort(AbstractState)}
   */
  @Test
  @DisplayName("Test abort(AbstractState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NeverAbortOperator.abort(AbstractState)"})
  void testAbort() {
    // Arrange, Act and Assert
    assertFalse(NeverAbortOperator.INSTANCE.abort(JvmMemoryLocationAbstractState.top));
  }
}
