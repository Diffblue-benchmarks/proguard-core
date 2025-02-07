package proguard.evaluation.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.LibraryClass;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.UnknownDoubleValue;
import proguard.evaluation.value.Value;

class ArrayStoreTypeExceptionDiffblueTest {
  /**
   * Test {@link ArrayStoreTypeException#ArrayStoreTypeException(TypedReferenceValue, Value)}.
   *
   * <p>Method under test: {@link
   * ArrayStoreTypeException#ArrayStoreTypeException(TypedReferenceValue, Value)}
   */
  @Test
  @DisplayName("Test new ArrayStoreTypeException(TypedReferenceValue, Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.exception.ArrayStoreTypeException.<init>(proguard.evaluation.value.TypedReferenceValue, proguard.evaluation.value.Value)"
  })
  void testNewArrayStoreTypeException() {
    // Arrange
    TypedReferenceValue array = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    DoubleValue value = BasicValueFactory.DOUBLE_VALUE;

    // Act
    ArrayStoreTypeException actualArrayStoreTypeException =
        new ArrayStoreTypeException(array, value);

    // Assert
    assertEquals(
        "Array of type [Type] can not store value [d]",
        actualArrayStoreTypeException.getLocalizedMessage());
    assertEquals(
        "Array of type [Type] can not store value [d]", actualArrayStoreTypeException.getMessage());
    assertNull(actualArrayStoreTypeException.getCause());
    assertEquals(0, actualArrayStoreTypeException.getSuppressed().length);
    assertEquals(1012, actualArrayStoreTypeException.getComponentErrorId());
    assertEquals(2, actualArrayStoreTypeException.getErrorParameters().length);
    assertSame(array, actualArrayStoreTypeException.getArray());
    assertSame(value, actualArrayStoreTypeException.getValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayStoreTypeException#getArray()}
   *   <li>{@link ArrayStoreTypeException#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.TypedReferenceValue proguard.evaluation.exception.ArrayStoreTypeException.getArray()",
    "proguard.evaluation.value.Value proguard.evaluation.exception.ArrayStoreTypeException.getValue()"
  })
  void testGettersAndSetters() {
    // Arrange
    TypedReferenceValue array = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    ArrayStoreTypeException arrayStoreTypeException =
        new ArrayStoreTypeException(array, BasicValueFactory.DOUBLE_VALUE);

    // Act
    TypedReferenceValue actualArray = arrayStoreTypeException.getArray();

    // Assert
    assertTrue(arrayStoreTypeException.getValue() instanceof UnknownDoubleValue);
    assertSame(array, actualArray);
  }
}
