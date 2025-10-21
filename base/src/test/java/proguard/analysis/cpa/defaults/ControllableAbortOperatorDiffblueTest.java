package proguard.analysis.cpa.defaults;

import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ControllableAbortOperatorDiffblueTest {
  /**
   * Test new {@link ControllableAbortOperator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ControllableAbortOperator}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ControllableAbortOperator.<init>()"})
  public void testNewControllableAbortOperator() {
    // Arrange, Act and Assert
    assertFalse((new ControllableAbortOperator()).abort);
  }
}
