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

public class ArrayReferenceValueFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link ArrayReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = arrayReferenceValueFactory.createArrayReferenceValue("Type",
        referencedClass, BasicValueFactory.INTEGER_VALUE);

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
    assertSame(expectedCreateIntegerValueResult, arrayReferenceValueFactory.createIntegerValue());
  }

  /**
   * Method under test:
   * {@link ArrayReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue2() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    IntegerValue arrayLength = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(arrayReferenceValueFactory.REFERENCE_VALUE_NULL,
        arrayReferenceValueFactory.createArrayReferenceValue(null, new LibraryClass(), arrayLength));
    assertSame(arrayLength, arrayReferenceValueFactory.createIntegerValue());
  }

  /**
   * Method under test:
   * {@link ArrayReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue3() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = arrayReferenceValueFactory.createArrayReferenceValue("Type",
        referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

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
    assertSame(expectedCreateIntegerValueResult, arrayReferenceValueFactory.createIntegerValue());
  }

  /**
   * Method under test:
   * {@link ArrayReferenceValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue4() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    IntegerValue arrayLength = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(arrayReferenceValueFactory.REFERENCE_VALUE_NULL,
        arrayReferenceValueFactory.createArrayReferenceValue(null, new LibraryClass(), arrayLength, "Element Values"));
    assertSame(arrayLength, arrayReferenceValueFactory.createIntegerValue());
  }
}
