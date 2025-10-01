package proguard.evaluation.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.Value;

class StackCategoryOneExceptionDiffblueTest {
  /**
   * Test {@link StackCategoryOneException#StackCategoryOneException(Value, Throwable)}.
   *
   * <p>Method under test: {@link StackCategoryOneException#StackCategoryOneException(Value,
   * Throwable)}
   */
  @Test
  @DisplayName("Test new StackCategoryOneException(Value, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StackCategoryOneException.<init>(Value, Throwable)"})
  void testNewStackCategoryOneException() {
    // Arrange
    DoubleValue foundValue = BasicValueFactory.DOUBLE_VALUE;
    Throwable cause = new Throwable();

    // Act
    StackCategoryOneException actualStackCategoryOneException =
        new StackCategoryOneException(foundValue, cause);

    // Assert
    assertEquals(
        "Stack value of type Category 1 expected, but found: d.",
        actualStackCategoryOneException.getLocalizedMessage());
    assertEquals(
        "Stack value of type Category 1 expected, but found: d.",
        actualStackCategoryOneException.getMessage());
    Object[] errorParameters = actualStackCategoryOneException.getErrorParameters();
    assertEquals("d", errorParameters[0]);
    assertEquals(0, actualStackCategoryOneException.getSuppressed().length);
    assertEquals(1, errorParameters.length);
    assertEquals(1007, actualStackCategoryOneException.getComponentErrorId());
    assertSame(cause, actualStackCategoryOneException.getCause());
    assertSame(foundValue, actualStackCategoryOneException.getFoundValue());
  }
}
