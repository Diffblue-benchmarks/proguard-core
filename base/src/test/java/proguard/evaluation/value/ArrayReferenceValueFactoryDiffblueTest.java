package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

class ArrayReferenceValueFactoryDiffblueTest {
  /**
   * Test {@link ArrayReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   * with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link ArrayReferenceValueFactory#createArrayReferenceValue(String,
   * Clazz, IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue ArrayReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength() {
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
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue ArrayReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength2() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    IntegerValue arrayLength = BasicValueFactory.INTEGER_VALUE;

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        arrayReferenceValueFactory.createArrayReferenceValue(null, new LibraryClass(), arrayLength);

    // Assert
    assertSame(arrayLength, arrayReferenceValueFactory.createIntegerValue());
    assertSame(
        TypedReferenceValueFactory.REFERENCE_VALUE_NULL, actualCreateArrayReferenceValueResult);
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
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue, Object) with 'type', 'referencedClass', 'arrayLength', 'elementValues'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue ArrayReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue, Object)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues() {
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
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue, Object) with 'type', 'referencedClass', 'arrayLength', 'elementValues'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue ArrayReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue, Object)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLengthElementValues2() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    IntegerValue arrayLength = BasicValueFactory.INTEGER_VALUE;

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        arrayReferenceValueFactory.createArrayReferenceValue(
            null, new LibraryClass(), arrayLength, "Element Values");

    // Assert
    assertSame(arrayLength, arrayReferenceValueFactory.createIntegerValue());
    assertSame(
        TypedReferenceValueFactory.REFERENCE_VALUE_NULL, actualCreateArrayReferenceValueResult);
  }
}
