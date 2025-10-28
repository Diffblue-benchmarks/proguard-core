package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;

public class IdentifiedValueFactoryDiffblueTest {
  /**
   * Method under test: {@link IdentifiedValueFactory#createIntegerValue()}
   */
  @Test
  public void testCreateIntegerValue() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult = (new IdentifiedValueFactory()).createIntegerValue();

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof IdentifiedIntegerValue);
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertFalse(actualCreateIntegerValueResult.isParticular());
    assertTrue(actualCreateIntegerValueResult.isSpecific());
  }

  /**
   * Method under test: {@link IdentifiedValueFactory#createLongValue()}
   */
  @Test
  public void testCreateLongValue() {
    // Arrange and Act
    LongValue actualCreateLongValueResult = (new IdentifiedValueFactory()).createLongValue();

    // Assert
    assertTrue(actualCreateLongValueResult instanceof IdentifiedLongValue);
    assertFalse(actualCreateLongValueResult.isParticular());
    assertTrue(actualCreateLongValueResult.isCategory2());
    assertTrue(actualCreateLongValueResult.isSpecific());
  }

  /**
   * Method under test: {@link IdentifiedValueFactory#createFloatValue()}
   */
  @Test
  public void testCreateFloatValue() {
    // Arrange and Act
    FloatValue actualCreateFloatValueResult = (new IdentifiedValueFactory()).createFloatValue();

    // Assert
    assertTrue(actualCreateFloatValueResult instanceof IdentifiedFloatValue);
    assertFalse(actualCreateFloatValueResult.isCategory2());
    assertFalse(actualCreateFloatValueResult.isParticular());
    assertTrue(actualCreateFloatValueResult.isSpecific());
  }

  /**
   * Method under test: {@link IdentifiedValueFactory#createDoubleValue()}
   */
  @Test
  public void testCreateDoubleValue() {
    // Arrange and Act
    DoubleValue actualCreateDoubleValueResult = (new IdentifiedValueFactory()).createDoubleValue();

    // Assert
    assertTrue(actualCreateDoubleValueResult instanceof IdentifiedDoubleValue);
    assertFalse(actualCreateDoubleValueResult.isParticular());
    assertTrue(actualCreateDoubleValueResult.isCategory2());
    assertTrue(actualCreateDoubleValueResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link IdentifiedValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = identifiedValueFactory.createReferenceValue("Type",
        referencedClass, true, true);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link IdentifiedValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue2() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueResult = identifiedValueFactory.createReferenceValue(null,
        new LibraryClass(), true, true);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueResult.getType());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateReferenceValueResult.isNotNull());
  }

  /**
   * Method under test:
   * {@link IdentifiedValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValue3() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = identifiedValueFactory.createReferenceValue("Type",
        referencedClass, true, true, "Value");

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link IdentifiedValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValue4() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueResult = identifiedValueFactory.createReferenceValue(null,
        new LibraryClass(), true, true, "Value");

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueResult.getType());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateReferenceValueResult.isNotNull());
  }

  /**
   * Method under test:
   * {@link IdentifiedValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  public void testCreateReferenceValue5() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = identifiedValueFactory.createReferenceValue("Type",
        referencedClass, true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link IdentifiedValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  public void testCreateReferenceValue6() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = identifiedValueFactory.createReferenceValue(null, referencedClass,
        true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueResult.getType());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateReferenceValueResult.isNotNull());
  }

  /**
   * Method under test:
   * {@link IdentifiedValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  public void testCreateReferenceValue7() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = identifiedValueFactory.createReferenceValue("Type",
        referencedClass, true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1, "Value");

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueResult.isSpecific());
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link IdentifiedValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  public void testCreateReferenceValue8() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = identifiedValueFactory.createReferenceValue(null, referencedClass,
        true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1, "Value");

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueResult.getType());
    assertNull(actualCreateReferenceValueResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueResult.isParticular());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateReferenceValueResult.isNotNull());
  }

  /**
   * Method under test:
   * {@link IdentifiedValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValueForId() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = identifiedValueFactory.createReferenceValueForId("Type",
        referencedClass, true, true, "Id");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof IdentifiedReferenceValue);
    assertEquals("Id", ((IdentifiedReferenceValue) actualCreateReferenceValueForIdResult).id);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    AnalyzedObject value = actualCreateReferenceValueForIdResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueForIdResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueForIdResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link IdentifiedValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValueForId2() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = identifiedValueFactory.createReferenceValueForId(null,
        new LibraryClass(), true, true, "Id");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueForIdResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueForIdResult.getType());
    assertNull(actualCreateReferenceValueForIdResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateReferenceValueForIdResult.isNotNull());
  }

  /**
   * Method under test:
   * {@link IdentifiedValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)}
   */
  @Test
  public void testCreateReferenceValueForId3() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = identifiedValueFactory.createReferenceValueForId("Type",
        referencedClass, true, true, "Id", "Value");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof IdentifiedReferenceValue);
    assertEquals("Id", ((IdentifiedReferenceValue) actualCreateReferenceValueForIdResult).id);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    AnalyzedObject value = actualCreateReferenceValueForIdResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(((IdentifiedReferenceValue) actualCreateReferenceValueForIdResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueForIdResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link IdentifiedValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)}
   */
  @Test
  public void testCreateReferenceValueForId4() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = identifiedValueFactory.createReferenceValueForId(null,
        new LibraryClass(), true, true, "Id", "Value");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueForIdResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueForIdResult.getType());
    assertNull(actualCreateReferenceValueForIdResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueForIdResult.isParticular());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateReferenceValueForIdResult.isNotNull());
  }

  /**
   * Method under test:
   * {@link IdentifiedValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = identifiedValueFactory.createArrayReferenceValue("Type",
        referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedArrayReferenceValue);
    ValueFactory valueFactory = ((IdentifiedArrayReferenceValue) actualCreateArrayReferenceValueResult).valuefactory;
    assertTrue(valueFactory instanceof IdentifiedValueFactory);
    ValueFactory valueFactory2 = ((IdentifiedValueFactory) valueFactory).referenceValueFactory;
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
    assertSame(identifiedValueFactory.referenceValueFactory, valueFactory2);
  }

  /**
   * Method under test:
   * {@link IdentifiedValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue2() {
    // Arrange
    IdentifiedValueFactory identifiedValueFactory = new IdentifiedValueFactory();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = identifiedValueFactory.createArrayReferenceValue(null,
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
   * {@link IdentifiedValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue3() {
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
   * Method under test: {@link IdentifiedValueFactory#IdentifiedValueFactory()}
   */
  @Test
  public void testNewIdentifiedValueFactory() {
    // Arrange, Act and Assert
    assertTrue((new IdentifiedValueFactory()).referenceValueFactory instanceof TypedReferenceValueFactory);
  }

  /**
   * Method under test:
   * {@link IdentifiedValueFactory#IdentifiedValueFactory(ValueFactory)}
   */
  @Test
  public void testNewIdentifiedValueFactory2() {
    // Arrange
    ParticularReferenceValueFactory referenceValueFactory = new ParticularReferenceValueFactory();

    // Act
    IdentifiedValueFactory actualIdentifiedValueFactory = new IdentifiedValueFactory(referenceValueFactory);

    // Assert
    assertTrue(actualIdentifiedValueFactory.referenceValueFactory instanceof ParticularReferenceValueFactory);
    DoubleValue createDoubleValueResult = referenceValueFactory.createDoubleValue();
    assertTrue(createDoubleValueResult instanceof UnknownDoubleValue);
    FloatValue createFloatValueResult = referenceValueFactory.createFloatValue();
    assertTrue(createFloatValueResult instanceof UnknownFloatValue);
    IntegerValue createIntegerValueResult = referenceValueFactory.createIntegerValue();
    assertTrue(createIntegerValueResult instanceof UnknownIntegerValue);
    LongValue createLongValueResult = referenceValueFactory.createLongValue();
    assertTrue(createLongValueResult instanceof UnknownLongValue);
    assertSame(actualIdentifiedValueFactory.DOUBLE_VALUE, createDoubleValueResult);
    assertSame(actualIdentifiedValueFactory.FLOAT_VALUE, createFloatValueResult);
    assertSame(actualIdentifiedValueFactory.INTEGER_VALUE, createIntegerValueResult);
    assertSame(actualIdentifiedValueFactory.LONG_VALUE, createLongValueResult);
  }

  /**
   * Method under test:
   * {@link IdentifiedValueFactory#IdentifiedValueFactory(ValueFactory, ValueFactory)}
   */
  @Test
  public void testNewIdentifiedValueFactory3() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory = new ParticularReferenceValueFactory();

    // Act
    IdentifiedValueFactory actualIdentifiedValueFactory = new IdentifiedValueFactory(arrayReferenceValueFactory,
        new ParticularReferenceValueFactory());

    // Assert
    assertTrue(actualIdentifiedValueFactory.referenceValueFactory instanceof ParticularReferenceValueFactory);
    DoubleValue createDoubleValueResult = arrayReferenceValueFactory.createDoubleValue();
    assertTrue(createDoubleValueResult instanceof UnknownDoubleValue);
    FloatValue createFloatValueResult = arrayReferenceValueFactory.createFloatValue();
    assertTrue(createFloatValueResult instanceof UnknownFloatValue);
    IntegerValue createIntegerValueResult = arrayReferenceValueFactory.createIntegerValue();
    assertTrue(createIntegerValueResult instanceof UnknownIntegerValue);
    LongValue createLongValueResult = arrayReferenceValueFactory.createLongValue();
    assertTrue(createLongValueResult instanceof UnknownLongValue);
    assertSame(actualIdentifiedValueFactory.DOUBLE_VALUE, createDoubleValueResult);
    assertSame(actualIdentifiedValueFactory.FLOAT_VALUE, createFloatValueResult);
    assertSame(actualIdentifiedValueFactory.INTEGER_VALUE, createIntegerValueResult);
    assertSame(actualIdentifiedValueFactory.LONG_VALUE, createLongValueResult);
  }
}
