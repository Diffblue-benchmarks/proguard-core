package proguard.analysis.cpa.defaults;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ControllableAbortOperatorDiffblueTest {
  /**
   * Test new {@link ControllableAbortOperator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ControllableAbortOperator}
   */
  @Test
  @DisplayName("Test new ControllableAbortOperator (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.analysis.cpa.defaults.ControllableAbortOperator.<init>()"})
  void testNewControllableAbortOperator() {
    // Arrange, Act and Assert
    assertFalse((new ControllableAbortOperator()).abort);
  }
}
