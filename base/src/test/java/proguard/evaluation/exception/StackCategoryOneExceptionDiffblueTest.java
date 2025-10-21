package proguard.evaluation.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.UnknownDoubleValue;
import proguard.evaluation.value.Value;

public class StackCategoryOneExceptionDiffblueTest {
  /**
   * Test {@link StackCategoryOneException#StackCategoryOneException(Value, Throwable)}.
   *
   * <p>Method under test: {@link StackCategoryOneException#StackCategoryOneException(Value,
   * Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StackCategoryOneException.<init>(Value, Throwable)"})
  public void testNewStackCategoryOneException() {
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

  /**
   * Test {@link StackCategoryOneException#getFoundValue()}.
   *
   * <p>Method under test: {@link StackCategoryOneException#getFoundValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value StackCategoryOneException.getFoundValue()"})
  public void testGetFoundValue() {
    // Arrange, Act and Assert
    assertTrue(
        (new StackCategoryOneException(BasicValueFactory.DOUBLE_VALUE, new Throwable()))
                .getFoundValue()
            instanceof UnknownDoubleValue);
  }
}
