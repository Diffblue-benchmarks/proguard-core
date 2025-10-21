package proguard.evaluation.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.LibraryClass;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.TypedReferenceValue;
import proguard.evaluation.value.UnknownDoubleValue;
import proguard.evaluation.value.Value;

public class ArrayStoreTypeExceptionDiffblueTest {
  /**
   * Test {@link ArrayStoreTypeException#ArrayStoreTypeException(TypedReferenceValue, Value)}.
   *
   * <p>Method under test: {@link
   * ArrayStoreTypeException#ArrayStoreTypeException(TypedReferenceValue, Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArrayStoreTypeException.<init>(TypedReferenceValue, Value)"})
  public void testNewArrayStoreTypeException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "TypedReferenceValue ArrayStoreTypeException.getArray()",
    "Value ArrayStoreTypeException.getValue()"
  })
  public void testGettersAndSetters() {
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
