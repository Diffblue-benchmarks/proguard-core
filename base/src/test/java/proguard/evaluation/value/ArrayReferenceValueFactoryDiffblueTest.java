package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class ArrayReferenceValueFactoryDiffblueTest {
  /**
   * Test {@link ArrayReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   * with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link ArrayReferenceValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ArrayReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        arrayReferenceValueFactory.createArrayReferenceValue(
            "Type", referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    Clazz referencedClass2 = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof ArrayReferenceValue);
    assertTrue(
        ((ArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength
            instanceof UnknownIntegerValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(((ArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, referencedClass2);
    IntegerValue expectedCreateIntegerValueResult =
        ((ArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertSame(expectedCreateIntegerValueResult, arrayReferenceValueFactory.createIntegerValue());
  }

  /**
   * Test {@link ArrayReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   * with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link ArrayReferenceValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ArrayReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength2() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    IntegerValue arrayLength = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        arrayReferenceValueFactory.REFERENCE_VALUE_NULL,
        arrayReferenceValueFactory.createArrayReferenceValue(
            null, new LibraryClass(), arrayLength));
    assertSame(arrayLength, arrayReferenceValueFactory.createIntegerValue());
  }

  /**
   * Test {@link ArrayReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue,
   * Object)} with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code
   * elementValues}.
   *
   * <p>Method under test: {@link ArrayReferenceValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ArrayReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue, Object)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        arrayReferenceValueFactory.createArrayReferenceValue(
            "Type", referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    Clazz referencedClass2 = actualCreateArrayReferenceValueResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualCreateArrayReferenceValueResult instanceof ArrayReferenceValue);
    assertTrue(
        ((ArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength
            instanceof UnknownIntegerValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(((ArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, referencedClass2);
    IntegerValue expectedCreateIntegerValueResult =
        ((ArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertSame(expectedCreateIntegerValueResult, arrayReferenceValueFactory.createIntegerValue());
  }

  /**
   * Test {@link ArrayReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue,
   * Object)} with {@code type}, {@code referencedClass}, {@code arrayLength}, {@code
   * elementValues}.
   *
   * <p>Method under test: {@link ArrayReferenceValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ArrayReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue, Object)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues2() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    IntegerValue arrayLength = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        arrayReferenceValueFactory.REFERENCE_VALUE_NULL,
        arrayReferenceValueFactory.createArrayReferenceValue(
            null, new LibraryClass(), arrayLength, "Element Values"));
    assertSame(arrayLength, arrayReferenceValueFactory.createIntegerValue());
  }
}
