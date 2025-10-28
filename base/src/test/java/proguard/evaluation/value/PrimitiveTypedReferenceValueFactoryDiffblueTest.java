package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.value.object.AnalyzedObject;

public class PrimitiveTypedReferenceValueFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link PrimitiveTypedReferenceValueFactory#createReferenceValueNull()}
   */
  @Test
  public void testCreateReferenceValueNull() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory = new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(primitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
        primitiveTypedReferenceValueFactory.createReferenceValueNull());
  }

  /**
   * Method under test:
   * {@link PrimitiveTypedReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory = new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(primitiveTypedReferenceValueFactory.REFERENCE_VALUE,
        primitiveTypedReferenceValueFactory.createReferenceValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Method under test:
   * {@link PrimitiveTypedReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue2() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory = new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(primitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
        primitiveTypedReferenceValueFactory.createReferenceValue(null, new LibraryClass(), true, true));
  }

  /**
   * Method under test:
   * {@link PrimitiveTypedReferenceValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue3() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory = new PrimitiveTypedReferenceValueFactory();

    // Act and Assert
    assertSame(primitiveTypedReferenceValueFactory.REFERENCE_VALUE,
        primitiveTypedReferenceValueFactory.createReferenceValue("", new LibraryClass(), true, true));
  }

  /**
   * Method under test:
   * {@link PrimitiveTypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory = new PrimitiveTypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = primitiveTypedReferenceValueFactory
        .createArrayReferenceValue("Type", referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof ArrayReferenceValue);
    IntegerValue integerValue = ((ArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertTrue(integerValue instanceof UnknownIntegerValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(integerValue.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(integerValue.isParticular());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(integerValue.isSpecific());
    assertFalse(((ArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((ArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    IntegerValue expectedCreateIntegerValueResult = ((ArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertSame(expectedCreateIntegerValueResult, primitiveTypedReferenceValueFactory.createIntegerValue());
  }

  /**
   * Method under test:
   * {@link PrimitiveTypedReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue2() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory = new PrimitiveTypedReferenceValueFactory();
    IntegerValue arrayLength = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(primitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
        primitiveTypedReferenceValueFactory.createArrayReferenceValue(null, new LibraryClass(), arrayLength));
    assertSame(arrayLength, primitiveTypedReferenceValueFactory.createIntegerValue());
  }
}
