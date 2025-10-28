package proguard.evaluation.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.UnknownDoubleValue;
import proguard.evaluation.value.Value;

public class ValueTypeExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ValueTypeException#getActualType()}
   *   <li>{@link ValueTypeException#getExceptedType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ValueTypeException valueTypeException = new ValueTypeException("Excepted Type", BasicValueFactory.DOUBLE_VALUE);

    // Act
    Value actualActualType = valueTypeException.getActualType();

    // Assert
    assertTrue(actualActualType instanceof UnknownDoubleValue);
    assertEquals("Excepted Type", valueTypeException.getExceptedType());
  }

  /**
   * Method under test:
   * {@link ValueTypeException#ValueTypeException(String, Value)}
   */
  @Test
  public void testNewValueTypeException() {
    // Arrange
    DoubleValue actualType = BasicValueFactory.DOUBLE_VALUE;

    // Act
    ValueTypeException actualValueTypeException = new ValueTypeException("Excepted Type", actualType);

    // Assert
    assertEquals("Excepted Type", actualValueTypeException.getExceptedType());
    Object[] errorParameters = actualValueTypeException.getErrorParameters();
    assertEquals("Excepted Type", errorParameters[0]);
    assertEquals("Invalid reference provided to instruction. Expected Excepted Type but found: d.",
        actualValueTypeException.getLocalizedMessage());
    assertEquals("Invalid reference provided to instruction. Expected Excepted Type but found: d.",
        actualValueTypeException.getMessage());
    assertEquals("d", errorParameters[1]);
    assertNull(actualValueTypeException.getCause());
    assertEquals(0, actualValueTypeException.getSuppressed().length);
    assertEquals(1009, actualValueTypeException.getComponentErrorId());
    assertEquals(2, errorParameters.length);
    assertSame(actualType, actualValueTypeException.getActualType());
  }
}
