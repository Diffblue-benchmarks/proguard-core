package proguard.evaluation.exception;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class VariableEvaluationExceptionDiffblueTest {
  /**
   * Method under test: {@link VariableEvaluationException#getIndex()}
   */
  @Test
  public void testGetIndex() {
    // Arrange, Act and Assert
    assertEquals(1, (new VariableEmptySlotException(1)).getIndex());
  }
}
