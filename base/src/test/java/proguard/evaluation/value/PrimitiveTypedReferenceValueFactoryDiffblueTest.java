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

class PrimitiveTypedReferenceValueFactoryDiffblueTest {
  /**
   * Test {@link PrimitiveTypedReferenceValueFactory#createReferenceValueNull()}.
   *
   * <p>Method under test: {@link PrimitiveTypedReferenceValueFactory#createReferenceValueNull()}
   */
  @Test
  @DisplayName("Test createReferenceValueNull()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue PrimitiveTypedReferenceValueFactory.createReferenceValueNull()"
  })
  void testCreateReferenceValueNull() {
    // Arrange, Act and Assert
    assertSame(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
        new PrimitiveTypedReferenceValueFactory().createReferenceValueNull());
  }

  /**
   * Test {@link PrimitiveTypedReferenceValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link PrimitiveTypedReferenceValueFactory#createReferenceValue(String,
   * Clazz, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean) with 'String', 'Clazz', 'boolean', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue PrimitiveTypedReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBoolean() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory =
        new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
        primitiveTypedReferenceValueFactory.createReferenceValue(
            null, new LibraryClass(), true, true));
  }

  /**
   * Test {@link PrimitiveTypedReferenceValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PrimitiveTypedReferenceValueFactory#createReferenceValue(String,
   * Clazz, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean) with 'String', 'Clazz', 'boolean', 'boolean'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue PrimitiveTypedReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBoolean_whenEmptyString() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory =
        new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(
        BasicValueFactory.REFERENCE_VALUE,
        primitiveTypedReferenceValueFactory.createReferenceValue(
            "", new LibraryClass(), true, true));
  }

  /**
   * Test {@link PrimitiveTypedReferenceValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link PrimitiveTypedReferenceValueFactory#createReferenceValue(String,
   * Clazz, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test createReferenceValue(String, Clazz, boolean, boolean) with 'String', 'Clazz', 'boolean', 'boolean'; when 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue PrimitiveTypedReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  void testCreateReferenceValueWithStringClazzBooleanBoolean_whenType() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory =
        new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(
        BasicValueFactory.REFERENCE_VALUE,
        primitiveTypedReferenceValueFactory.createReferenceValue(
            "Type", new LibraryClass(), true, true));
  }

  /**
   * Test {@link PrimitiveTypedReferenceValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)} with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link
   * PrimitiveTypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue PrimitiveTypedReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory =
        new PrimitiveTypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        primitiveTypedReferenceValueFactory.createArrayReferenceValue(
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
    assertSame(
        expectedCreateIntegerValueResult, primitiveTypedReferenceValueFactory.createIntegerValue());
  }

  /**
   * Test {@link PrimitiveTypedReferenceValueFactory#createArrayReferenceValue(String, Clazz,
   * IntegerValue)} with {@code type}, {@code referencedClass}, {@code arrayLength}.
   *
   * <p>Method under test: {@link
   * PrimitiveTypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test createArrayReferenceValue(String, Clazz, IntegerValue) with 'type', 'referencedClass', 'arrayLength'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReferenceValue PrimitiveTypedReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength2() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory =
        new PrimitiveTypedReferenceValueFactory();
    IntegerValue arrayLength = BasicValueFactory.INTEGER_VALUE;

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult =
        primitiveTypedReferenceValueFactory.createArrayReferenceValue(
            null, new LibraryClass(), arrayLength);

    // Assert
    assertSame(arrayLength, primitiveTypedReferenceValueFactory.createIntegerValue());
    assertSame(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
        actualCreateArrayReferenceValueResult);
  }
}
