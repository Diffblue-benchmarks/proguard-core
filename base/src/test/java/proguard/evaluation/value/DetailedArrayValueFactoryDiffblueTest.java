package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;
import proguard.evaluation.value.object.model.ArrayModel;
import proguard.evaluation.value.object.model.Model;

public class DetailedArrayValueFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = detailedArrayValueFactory.createArrayReferenceValue("Type",
        referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    ValueFactory valueFactory = ((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).valuefactory;
    assertTrue(valueFactory instanceof DetailedArrayValueFactory);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedArrayReferenceValue);
    ValueFactory valueFactory2 = ((DetailedArrayValueFactory) valueFactory).referenceValueFactory;
    assertTrue(valueFactory2 instanceof TypedReferenceValueFactory);
    IntegerValue integerValue = ((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
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
    assertFalse(integerValue.isSpecific());
    assertFalse(((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    assertSame(detailedArrayValueFactory.referenceValueFactory, valueFactory2);
  }

  /**
   * Method under test:
   * {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue2() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = detailedArrayValueFactory.createArrayReferenceValue(null,
        new LibraryClass(), BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof TypedReferenceValue);
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateArrayReferenceValueResult.getType());
    assertNull(actualCreateArrayReferenceValueResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertTrue(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(((TypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNotNull());
  }

  /**
   * Method under test:
   * {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue3() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = detailedArrayValueFactory.createArrayReferenceValue("Type",
        referencedClass, ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof DetailedArrayReferenceValue);
    ValueFactory valueFactory = ((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).valuefactory;
    assertTrue(valueFactory instanceof DetailedArrayValueFactory);
    IntegerValue integerValue = ((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertTrue(integerValue instanceof ParticularIntegerValue);
    ValueFactory valueFactory2 = ((DetailedArrayValueFactory) valueFactory).referenceValueFactory;
    assertTrue(valueFactory2 instanceof TypedReferenceValueFactory);
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    assertEquals("[Type", modeledOrNullValue.getType());
    assertEquals(0, integerValue.value());
    assertEquals(0, ((ArrayModel) modeledOrNullValue).getValues().length);
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(integerValue.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(integerValue.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertTrue(integerValue.isSpecific());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    assertSame(detailedArrayValueFactory.referenceValueFactory, valueFactory2);
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Method under test:
   * {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue4() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = detailedArrayValueFactory.createArrayReferenceValue("Type",
        referencedClass, ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    ValueFactory valueFactory = ((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).valuefactory;
    assertTrue(valueFactory instanceof DetailedArrayValueFactory);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedArrayReferenceValue);
    IntegerValue integerValue = ((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertTrue(integerValue instanceof ParticularIntegerValue);
    ValueFactory valueFactory2 = ((DetailedArrayValueFactory) valueFactory).referenceValueFactory;
    assertTrue(valueFactory2 instanceof TypedReferenceValueFactory);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(integerValue.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(integerValue.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertTrue(integerValue.isSpecific());
    assertEquals(Value.NEVER, integerValue.value());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    assertSame(detailedArrayValueFactory.referenceValueFactory, valueFactory2);
  }

  /**
   * Method under test:
   * {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue5() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = detailedArrayValueFactory.createArrayReferenceValue("",
        referencedClass, ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof DetailedArrayReferenceValue);
    ValueFactory valueFactory = ((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).valuefactory;
    assertTrue(valueFactory instanceof DetailedArrayValueFactory);
    IntegerValue integerValue = ((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertTrue(integerValue instanceof ParticularIntegerValue);
    ValueFactory valueFactory2 = ((DetailedArrayValueFactory) valueFactory).referenceValueFactory;
    assertTrue(valueFactory2 instanceof TypedReferenceValueFactory);
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("[", actualCreateArrayReferenceValueResult.getType());
    assertEquals("[", modeledOrNullValue.getType());
    assertEquals(0, integerValue.value());
    assertEquals(0, ((ArrayModel) modeledOrNullValue).getValues().length);
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(integerValue.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(integerValue.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertTrue(integerValue.isSpecific());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    assertSame(detailedArrayValueFactory.referenceValueFactory, valueFactory2);
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Method under test:
   * {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue6() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = detailedArrayValueFactory
        .createArrayReferenceValue("Invalid type [", referencedClass, ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof DetailedArrayReferenceValue);
    ValueFactory valueFactory = ((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).valuefactory;
    assertTrue(valueFactory instanceof DetailedArrayValueFactory);
    IntegerValue integerValue = ((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertTrue(integerValue instanceof ParticularIntegerValue);
    ValueFactory valueFactory2 = ((DetailedArrayValueFactory) valueFactory).referenceValueFactory;
    assertTrue(valueFactory2 instanceof TypedReferenceValueFactory);
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("[Invalid type [", actualCreateArrayReferenceValueResult.getType());
    assertEquals("[Invalid type [", modeledOrNullValue.getType());
    assertEquals(1, integerValue.value());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    Value[] values = ((ArrayModel) modeledOrNullValue).getValues();
    assertEquals(1, values.length);
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(integerValue.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(integerValue.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertTrue(integerValue.isSpecific());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    assertSame(detailedArrayValueFactory.INTEGER_VALUE_0, values[0]);
    assertSame(detailedArrayValueFactory.referenceValueFactory, valueFactory2);
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Method under test:
   * {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue7() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = detailedArrayValueFactory.createArrayReferenceValue("",
        referencedClass, ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof DetailedArrayReferenceValue);
    ValueFactory valueFactory = ((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).valuefactory;
    assertTrue(valueFactory instanceof DetailedArrayValueFactory);
    IntegerValue integerValue = ((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertTrue(integerValue instanceof ParticularIntegerValue);
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    Value[] values = ((ArrayModel) modeledOrNullValue).getValues();
    Value value2 = values[0];
    assertTrue(value2 instanceof TypedReferenceValue);
    ValueFactory valueFactory2 = ((DetailedArrayValueFactory) valueFactory).referenceValueFactory;
    assertTrue(valueFactory2 instanceof TypedReferenceValueFactory);
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("[", actualCreateArrayReferenceValueResult.getType());
    assertEquals("[", modeledOrNullValue.getType());
    AnalyzedObject value3 = ((TypedReferenceValue) value2).getValue();
    assertNull(value3.getPreciseValue());
    assertNull(((TypedReferenceValue) value2).getType());
    assertNull(((TypedReferenceValue) value2).getReferencedClass());
    assertNull(value3.getModeledOrNullValue());
    assertEquals(1, integerValue.value());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertEquals(1, ((TypedReferenceValue) value2).isNull());
    assertEquals(1, values.length);
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(integerValue.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(((TypedReferenceValue) value2).mayBeExtension());
    assertFalse(value2.isCategory2());
    assertFalse(value2.isSpecific());
    assertFalse(((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((TypedReferenceValue) value2).mayBeExtension);
    assertFalse(((DetailedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(value2.isParticular());
    assertTrue(integerValue.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertTrue(integerValue.isSpecific());
    assertTrue(((TypedReferenceValue) value2).mayBeNull);
    assertEquals(Value.NEVER, ((TypedReferenceValue) value2).isNotNull());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    assertSame(detailedArrayValueFactory.referenceValueFactory, valueFactory2);
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Method under test:
   * {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue8() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = detailedArrayValueFactory.createArrayReferenceValue("Type",
        referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    ValueFactory valueFactory = ((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).valuefactory;
    assertTrue(valueFactory instanceof DetailedArrayValueFactory);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedArrayReferenceValue);
    ValueFactory valueFactory2 = ((DetailedArrayValueFactory) valueFactory).referenceValueFactory;
    assertTrue(valueFactory2 instanceof TypedReferenceValueFactory);
    IntegerValue integerValue = ((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
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
    assertFalse(integerValue.isSpecific());
    assertFalse(((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    assertSame(detailedArrayValueFactory.referenceValueFactory, valueFactory2);
  }

  /**
   * Method under test:
   * {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue9() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = detailedArrayValueFactory.createArrayReferenceValue(null,
        new LibraryClass(), BasicValueFactory.INTEGER_VALUE, "Element Values");

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof TypedReferenceValue);
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateArrayReferenceValueResult.getType());
    assertNull(actualCreateArrayReferenceValueResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertTrue(actualCreateArrayReferenceValueResult.isParticular());
    assertTrue(((TypedReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNotNull());
  }

  /**
   * Method under test:
   * {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue10() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> detailedArrayValueFactory.createArrayReferenceValue("Type",
        new LibraryClass(), ParticularValueFactory.INTEGER_VALUE_0, "Element Values"));
  }

  /**
   * Method under test:
   * {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue11() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = detailedArrayValueFactory.createArrayReferenceValue("Type",
        referencedClass, ParticularValueFactory.INTEGER_VALUE_M1, "Element Values");

    // Assert
    ValueFactory valueFactory = ((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).valuefactory;
    assertTrue(valueFactory instanceof DetailedArrayValueFactory);
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedArrayReferenceValue);
    IntegerValue integerValue = ((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertTrue(integerValue instanceof ParticularIntegerValue);
    ValueFactory valueFactory2 = ((DetailedArrayValueFactory) valueFactory).referenceValueFactory;
    assertTrue(valueFactory2 instanceof TypedReferenceValueFactory);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(integerValue.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(integerValue.isParticular());
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertTrue(integerValue.isSpecific());
    assertEquals(Value.NEVER, integerValue.value());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
    assertSame(detailedArrayValueFactory.referenceValueFactory, valueFactory2);
  }

  /**
   * Method under test:
   * {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue12() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> detailedArrayValueFactory.createArrayReferenceValue("",
        new LibraryClass(), ParticularValueFactory.INTEGER_VALUE_0, "Element Values"));
  }

  /**
   * Method under test:
   * {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue13() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> detailedArrayValueFactory.createArrayReferenceValue("Invalid type [", new LibraryClass(),
            ParticularValueFactory.INTEGER_VALUE_1, "Element Values"));
  }

  /**
   * Method under test:
   * {@link DetailedArrayValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue14() {
    // Arrange
    DetailedArrayValueFactory detailedArrayValueFactory = new DetailedArrayValueFactory();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> detailedArrayValueFactory.createArrayReferenceValue("",
        new LibraryClass(), ParticularValueFactory.INTEGER_VALUE_1, "Element Values"));
  }

  /**
   * Method under test:
   * {@link DetailedArrayValueFactory#DetailedArrayValueFactory()}
   */
  @Test
  public void testNewDetailedArrayValueFactory() {
    // Arrange, Act and Assert
    assertTrue((new DetailedArrayValueFactory()).referenceValueFactory instanceof TypedReferenceValueFactory);
  }

  /**
   * Method under test:
   * {@link DetailedArrayValueFactory#DetailedArrayValueFactory(ValueFactory)}
   */
  @Test
  public void testNewDetailedArrayValueFactory2() {
    // Arrange
    ParticularReferenceValueFactory referenceValueFactory = new ParticularReferenceValueFactory();

    // Act
    DetailedArrayValueFactory actualDetailedArrayValueFactory = new DetailedArrayValueFactory(referenceValueFactory);

    // Assert
    assertTrue(actualDetailedArrayValueFactory.referenceValueFactory instanceof ParticularReferenceValueFactory);
    DoubleValue createDoubleValueResult = referenceValueFactory.createDoubleValue();
    assertTrue(createDoubleValueResult instanceof UnknownDoubleValue);
    FloatValue createFloatValueResult = referenceValueFactory.createFloatValue();
    assertTrue(createFloatValueResult instanceof UnknownFloatValue);
    IntegerValue createIntegerValueResult = referenceValueFactory.createIntegerValue();
    assertTrue(createIntegerValueResult instanceof UnknownIntegerValue);
    LongValue createLongValueResult = referenceValueFactory.createLongValue();
    assertTrue(createLongValueResult instanceof UnknownLongValue);
    assertSame(actualDetailedArrayValueFactory.DOUBLE_VALUE, createDoubleValueResult);
    assertSame(actualDetailedArrayValueFactory.FLOAT_VALUE, createFloatValueResult);
    assertSame(actualDetailedArrayValueFactory.INTEGER_VALUE, createIntegerValueResult);
    assertSame(actualDetailedArrayValueFactory.LONG_VALUE, createLongValueResult);
  }
}
