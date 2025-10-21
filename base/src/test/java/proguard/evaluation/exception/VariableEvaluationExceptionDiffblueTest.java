package proguard.evaluation.exception;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class VariableEvaluationExceptionDiffblueTest {
  /**
   * Test {@link VariableEvaluationException#getIndex()}.
   *
   * <p>Method under test: {@link VariableEvaluationException#getIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int VariableEvaluationException.getIndex()"})
  public void testGetIndex() {
    // Arrange, Act and Assert
    assertEquals(1, (new VariableEmptySlotException(1)).getIndex());
  }
}
