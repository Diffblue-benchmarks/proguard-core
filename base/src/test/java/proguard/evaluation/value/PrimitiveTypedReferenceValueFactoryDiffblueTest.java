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

public class PrimitiveTypedReferenceValueFactoryDiffblueTest {
  /**
   * Test {@link PrimitiveTypedReferenceValueFactory#createReferenceValueNull()}.
   *
   * <p>Method under test: {@link PrimitiveTypedReferenceValueFactory#createReferenceValueNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue PrimitiveTypedReferenceValueFactory.createReferenceValueNull()"
  })
  public void testCreateReferenceValueNull() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory =
        new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(
        primitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
        primitiveTypedReferenceValueFactory.createReferenceValueNull());
  }

  /**
   * Test {@link PrimitiveTypedReferenceValueFactory#createReferenceValue(String, Clazz, boolean,
   * boolean)} with {@code String}, {@code Clazz}, {@code boolean}, {@code boolean}.
   *
   * <p>Method under test: {@link PrimitiveTypedReferenceValueFactory#createReferenceValue(String,
   * Clazz, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue PrimitiveTypedReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBoolean() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory =
        new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(
        primitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue PrimitiveTypedReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBoolean_whenEmptyString() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory =
        new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(
        primitiveTypedReferenceValueFactory.REFERENCE_VALUE,
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue PrimitiveTypedReferenceValueFactory.createReferenceValue(String, Clazz, boolean, boolean)"
  })
  public void testCreateReferenceValueWithStringClazzBooleanBoolean_whenType() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory =
        new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(
        primitiveTypedReferenceValueFactory.REFERENCE_VALUE,
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue PrimitiveTypedReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue PrimitiveTypedReferenceValueFactory.createArrayReferenceValue(String, Clazz, IntegerValue)"
  })
  public void testCreateArrayReferenceValueWithTypeReferencedClassArrayLength2() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory =
        new PrimitiveTypedReferenceValueFactory();
    IntegerValue arrayLength = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        primitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
        primitiveTypedReferenceValueFactory.createArrayReferenceValue(
            null, new LibraryClass(), arrayLength));
    assertSame(arrayLength, primitiveTypedReferenceValueFactory.createIntegerValue());
  }
}
