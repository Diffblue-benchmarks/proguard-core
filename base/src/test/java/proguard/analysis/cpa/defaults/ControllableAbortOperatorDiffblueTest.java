package proguard.analysis.cpa.defaults;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.cpa.interfaces.AbstractState;
import proguard.analysis.cpa.jvm.domain.memory.JvmMemoryLocationAbstractState;

class ControllableAbortOperatorDiffblueTest {
  /**
   * Test {@link ControllableAbortOperator#abort(AbstractState)}.
   *
   * <ul>
   *   <li>Given {@link ControllableAbortOperator} (default constructor) {@link
   *       ControllableAbortOperator#abort} is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ControllableAbortOperator#abort(AbstractState)}
   */
  @Test
  @DisplayName(
      "Test abort(AbstractState); given ControllableAbortOperator (default constructor) abort is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ControllableAbortOperator.abort(AbstractState)"})
  void testAbort_givenControllableAbortOperatorAbortIsTrue_thenReturnTrue() {
    // Arrange
    ControllableAbortOperator controllableAbortOperator = new ControllableAbortOperator();
    controllableAbortOperator.abort = true;

    // Act and Assert
    assertTrue(controllableAbortOperator.abort(JvmMemoryLocationAbstractState.top));
  }

  /**
   * Test {@link ControllableAbortOperator#abort(AbstractState)}.
   *
   * <ul>
   *   <li>Given {@link ControllableAbortOperator} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ControllableAbortOperator#abort(AbstractState)}
   */
  @Test
  @DisplayName(
      "Test abort(AbstractState); given ControllableAbortOperator (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ControllableAbortOperator.abort(AbstractState)"})
  void testAbort_givenControllableAbortOperator_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new ControllableAbortOperator().abort(JvmMemoryLocationAbstractState.top));
  }

  /**
   * Test new {@link ControllableAbortOperator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ControllableAbortOperator}
   */
  @Test
  @DisplayName("Test new ControllableAbortOperator (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ControllableAbortOperator.<init>()"})
  void testNewControllableAbortOperator() {
    // Arrange, Act and Assert
    assertFalse(new ControllableAbortOperator().abort);
  }
}
