package proguard.evaluation.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.UnknownDoubleValue;
import proguard.evaluation.value.Value;

class ValueTypeExceptionDiffblueTest {
  /**
   * Test {@link ValueTypeException#ValueTypeException(String, Value)}.
   *
   * <p>Method under test: {@link ValueTypeException#ValueTypeException(String, Value)}
   */
  @Test
  @DisplayName("Test new ValueTypeException(String, Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.exception.ValueTypeException.<init>(java.lang.String, proguard.evaluation.value.Value)"
  })
  void testNewValueTypeException() {
    // Arrange
    DoubleValue actualType = BasicValueFactory.DOUBLE_VALUE;

    // Act
    ValueTypeException actualValueTypeException =
        new ValueTypeException("Excepted Type", actualType);

    // Assert
    assertEquals("Excepted Type", actualValueTypeException.getExceptedType());
    Object[] errorParameters = actualValueTypeException.getErrorParameters();
    assertEquals("Excepted Type", errorParameters[0]);
    assertEquals(
        "Invalid reference provided to instruction. Expected Excepted Type but found: d.",
        actualValueTypeException.getLocalizedMessage());
    assertEquals(
        "Invalid reference provided to instruction. Expected Excepted Type but found: d.",
        actualValueTypeException.getMessage());
    assertEquals("d", errorParameters[1]);
    assertNull(actualValueTypeException.getCause());
    assertEquals(0, actualValueTypeException.getSuppressed().length);
    assertEquals(1009, actualValueTypeException.getComponentErrorId());
    assertEquals(2, errorParameters.length);
    assertSame(actualType, actualValueTypeException.getActualType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ValueTypeException#getActualType()}
   *   <li>{@link ValueTypeException#getExceptedType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.exception.ValueTypeException.getActualType()",
    "java.lang.String proguard.evaluation.exception.ValueTypeException.getExceptedType()"
  })
  void testGettersAndSetters() {
    // Arrange
    ValueTypeException valueTypeException =
        new ValueTypeException("Excepted Type", BasicValueFactory.DOUBLE_VALUE);

    // Act
    Value actualActualType = valueTypeException.getActualType();

    // Assert
    assertTrue(actualActualType instanceof UnknownDoubleValue);
    assertEquals("Excepted Type", valueTypeException.getExceptedType());
  }
}
