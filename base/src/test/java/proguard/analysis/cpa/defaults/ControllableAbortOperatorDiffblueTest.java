package proguard.analysis.cpa.defaults;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class ControllableAbortOperatorDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ControllableAbortOperator}
   */
  @Test
  public void testNewControllableAbortOperator() {
    // Arrange, Act and Assert
    assertFalse((new ControllableAbortOperator()).abort);
  }
}
