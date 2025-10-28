package proguard.evaluation.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.LibraryClass;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.UnknownDoubleValue;
import proguard.evaluation.value.Value;

public class ArrayStoreTypeExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ArrayStoreTypeException#getArray()}
   *   <li>{@link ArrayStoreTypeException#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    TypedReferenceValue array = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    ArrayStoreTypeException arrayStoreTypeException = new ArrayStoreTypeException(array,
        BasicValueFactory.DOUBLE_VALUE);

    // Act
    TypedReferenceValue actualArray = arrayStoreTypeException.getArray();

    // Assert
    assertTrue(arrayStoreTypeException.getValue() instanceof UnknownDoubleValue);
    assertSame(array, actualArray);
  }

  /**
   * Method under test:
   * {@link ArrayStoreTypeException#ArrayStoreTypeException(TypedReferenceValue, Value)}
   */
  @Test
  public void testNewArrayStoreTypeException() {
    // Arrange
    TypedReferenceValue array = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    DoubleValue value = BasicValueFactory.DOUBLE_VALUE;

    // Act
    ArrayStoreTypeException actualArrayStoreTypeException = new ArrayStoreTypeException(array, value);

    // Assert
    assertEquals("Array of type [Type] can not store value [d]", actualArrayStoreTypeException.getLocalizedMessage());
    assertEquals("Array of type [Type] can not store value [d]", actualArrayStoreTypeException.getMessage());
    Object[] errorParameters = actualArrayStoreTypeException.getErrorParameters();
    assertEquals("Type", errorParameters[0]);
    assertEquals("d", errorParameters[1]);
    assertNull(actualArrayStoreTypeException.getCause());
    assertEquals(0, actualArrayStoreTypeException.getSuppressed().length);
    assertEquals(1012, actualArrayStoreTypeException.getComponentErrorId());
    assertEquals(2, errorParameters.length);
    assertSame(array, actualArrayStoreTypeException.getArray());
    assertSame(value, actualArrayStoreTypeException.getValue());
  }
}
