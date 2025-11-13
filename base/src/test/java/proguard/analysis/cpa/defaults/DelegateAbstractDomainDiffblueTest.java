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
import proguard.analysis.cpa.jvm.domain.value.ValueAbstractState;
import proguard.evaluation.value.BasicValueFactory;

class DelegateAbstractDomainDiffblueTest {
  /**
   * Test {@link DelegateAbstractDomain#isLessOrEqual(AbstractState, AbstractState)}.
   *
   * <ul>
   *   <li>When {@link JvmMemoryLocationAbstractState#top}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DelegateAbstractDomain#isLessOrEqual(AbstractState,
   * AbstractState)}
   */
  @Test
  @DisplayName("Test isLessOrEqual(AbstractState, AbstractState); when top; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DelegateAbstractDomain.isLessOrEqual(AbstractState, AbstractState)"})
  void testIsLessOrEqual_whenTop_thenReturnTrue() {
    // Arrange
    DelegateAbstractDomain<LatticeAbstractState> delegateAbstractDomain =
        new DelegateAbstractDomain<>();

    // Act and Assert
    assertTrue(
        delegateAbstractDomain.isLessOrEqual(
            JvmMemoryLocationAbstractState.top, JvmMemoryLocationAbstractState.top));
  }

  /**
   * Test {@link DelegateAbstractDomain#isLessOrEqual(AbstractState, AbstractState)}.
   *
   * <ul>
   *   <li>When {@link ValueAbstractState#UNKNOWN}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DelegateAbstractDomain#isLessOrEqual(AbstractState,
   * AbstractState)}
   */
  @Test
  @DisplayName(
      "Test isLessOrEqual(AbstractState, AbstractState); when UNKNOWN; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DelegateAbstractDomain.isLessOrEqual(AbstractState, AbstractState)"})
  void testIsLessOrEqual_whenUnknown_thenReturnFalse() {
    // Arrange
    DelegateAbstractDomain<LatticeAbstractState> delegateAbstractDomain =
        new DelegateAbstractDomain<>();

    // Act and Assert
    assertFalse(
        delegateAbstractDomain.isLessOrEqual(
            ValueAbstractState.UNKNOWN, new ValueAbstractState(BasicValueFactory.DOUBLE_VALUE)));
  }
}
