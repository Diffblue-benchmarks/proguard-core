package proguard.evaluation.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VariableEvaluationExceptionDiffblueTest {
  /**
   * Test {@link VariableEvaluationException#getIndex()}.
   *
   * <p>Method under test: {@link VariableEvaluationException#getIndex()}
   */
  @Test
  @DisplayName("Test getIndex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int VariableEvaluationException.getIndex()"})
  void testGetIndex() {
    // Arrange, Act and Assert
    assertEquals(1, new VariableEmptySlotException(1).getIndex());
  }
}
