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
import proguard.evaluation.value.object.model.ArrayModel;
import proguard.evaluation.value.object.model.Model;

public class ParticularValueFactoryDiffblueTest {
  /**
   * Method under test: {@link ParticularValueFactory#createIntegerValue(int)}
   */
  @Test
  public void testCreateIntegerValue() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult = (new ParticularValueFactory()).createIntegerValue(42);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof ParticularIntegerValue);
    assertEquals(42, actualCreateIntegerValueResult.value());
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertTrue(actualCreateIntegerValueResult.isParticular());
    assertTrue(actualCreateIntegerValueResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularValueFactory#createIntegerValue(int)}
   */
  @Test
  public void testCreateIntegerValue2() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.INTEGER_VALUE_M1, particularValueFactory.createIntegerValue(Value.NEVER));
  }

  /**
   * Method under test: {@link ParticularValueFactory#createIntegerValue(int)}
   */
  @Test
  public void testCreateIntegerValue3() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.INTEGER_VALUE_0, particularValueFactory.createIntegerValue(0));
  }

  /**
   * Method under test: {@link ParticularValueFactory#createIntegerValue(int)}
   */
  @Test
  public void testCreateIntegerValue4() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.INTEGER_VALUE_1, particularValueFactory.createIntegerValue(1));
  }

  /**
   * Method under test: {@link ParticularValueFactory#createIntegerValue(int)}
   */
  @Test
  public void testCreateIntegerValue5() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.INTEGER_VALUE_2, particularValueFactory.createIntegerValue(2));
  }

  /**
   * Method under test: {@link ParticularValueFactory#createIntegerValue(int)}
   */
  @Test
  public void testCreateIntegerValue6() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.INTEGER_VALUE_3, particularValueFactory.createIntegerValue(3));
  }

  /**
   * Method under test: {@link ParticularValueFactory#createIntegerValue(int)}
   */
  @Test
  public void testCreateIntegerValue7() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.INTEGER_VALUE_4, particularValueFactory.createIntegerValue(4));
  }

  /**
   * Method under test: {@link ParticularValueFactory#createIntegerValue(int)}
   */
  @Test
  public void testCreateIntegerValue8() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.INTEGER_VALUE_5, particularValueFactory.createIntegerValue(5));
  }

  /**
   * Method under test: {@link ParticularValueFactory#createLongValue(long)}
   */
  @Test
  public void testCreateLongValue() {
    // Arrange and Act
    LongValue actualCreateLongValueResult = (new ParticularValueFactory()).createLongValue(42L);

    // Assert
    assertTrue(actualCreateLongValueResult instanceof ParticularLongValue);
    assertEquals(42L, actualCreateLongValueResult.value());
    assertTrue(actualCreateLongValueResult.isCategory2());
    assertTrue(actualCreateLongValueResult.isParticular());
    assertTrue(actualCreateLongValueResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularValueFactory#createLongValue(long)}
   */
  @Test
  public void testCreateLongValue2() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.LONG_VALUE_0, particularValueFactory.createLongValue(0L));
  }

  /**
   * Method under test: {@link ParticularValueFactory#createLongValue(long)}
   */
  @Test
  public void testCreateLongValue3() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.LONG_VALUE_1, particularValueFactory.createLongValue(1L));
  }

  /**
   * Method under test: {@link ParticularValueFactory#createFloatValue(float)}
   */
  @Test
  public void testCreateFloatValue() {
    // Arrange and Act
    FloatValue actualCreateFloatValueResult = (new ParticularValueFactory()).createFloatValue(10.0f);

    // Assert
    assertTrue(actualCreateFloatValueResult instanceof ParticularFloatValue);
    assertEquals(10.0f, actualCreateFloatValueResult.value(), 0.0f);
    assertFalse(actualCreateFloatValueResult.isCategory2());
    assertTrue(actualCreateFloatValueResult.isParticular());
    assertTrue(actualCreateFloatValueResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularValueFactory#createFloatValue(float)}
   */
  @Test
  public void testCreateFloatValue2() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.FLOAT_VALUE_0, particularValueFactory.createFloatValue(0.0f));
  }

  /**
   * Method under test: {@link ParticularValueFactory#createFloatValue(float)}
   */
  @Test
  public void testCreateFloatValue3() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.FLOAT_VALUE_1, particularValueFactory.createFloatValue(1.0f));
  }

  /**
   * Method under test: {@link ParticularValueFactory#createFloatValue(float)}
   */
  @Test
  public void testCreateFloatValue4() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.FLOAT_VALUE_2, particularValueFactory.createFloatValue(2.0f));
  }

  /**
   * Method under test: {@link ParticularValueFactory#createDoubleValue(double)}
   */
  @Test
  public void testCreateDoubleValue() {
    // Arrange and Act
    DoubleValue actualCreateDoubleValueResult = (new ParticularValueFactory()).createDoubleValue(10.0d);

    // Assert
    assertTrue(actualCreateDoubleValueResult instanceof ParticularDoubleValue);
    assertEquals(10.0d, actualCreateDoubleValueResult.value(), 0.0);
    assertTrue(actualCreateDoubleValueResult.isCategory2());
    assertTrue(actualCreateDoubleValueResult.isParticular());
    assertTrue(actualCreateDoubleValueResult.isSpecific());
  }

  /**
   * Method under test: {@link ParticularValueFactory#createDoubleValue(double)}
   */
  @Test
  public void testCreateDoubleValue2() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.DOUBLE_VALUE_0, particularValueFactory.createDoubleValue(0.0d));
  }

  /**
   * Method under test: {@link ParticularValueFactory#createDoubleValue(double)}
   */
  @Test
  public void testCreateDoubleValue3() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.DOUBLE_VALUE_1, particularValueFactory.createDoubleValue(1.0d));
  }

  /**
   * Method under test: {@link ParticularValueFactory#createReferenceValue()}
   */
  @Test
  public void testCreateReferenceValue() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();

    // Act and Assert
    assertSame(particularValueFactory.REFERENCE_VALUE, particularValueFactory.createReferenceValue());
  }

  /**
   * Method under test: {@link ParticularValueFactory#createReferenceValue()}
   */
  @Test
  public void testCreateReferenceValue2() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory = new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory(arrayReferenceValueFactory,
        new BasicRangeValueFactory());

    // Act and Assert
    assertSame(basicRangeValueFactory.REFERENCE_VALUE, basicRangeValueFactory.createReferenceValue());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue3() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = particularValueFactory.createReferenceValue("Type",
        referencedClass, true, true);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue4() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory = new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory(arrayReferenceValueFactory,
        new BasicRangeValueFactory());
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = basicRangeValueFactory.createReferenceValue("Type",
        referencedClass, true, true);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValue5() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = particularValueFactory.createReferenceValue("Type",
        referencedClass, true, true, "Value");

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValue6() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory = new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory(arrayReferenceValueFactory,
        new BasicRangeValueFactory());
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = basicRangeValueFactory.createReferenceValue("Type",
        referencedClass, true, true, "Value");

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValue7() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory = new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory(arrayReferenceValueFactory,
        new PrimitiveTypedReferenceValueFactory());

    // Act and Assert
    assertSame(basicRangeValueFactory.REFERENCE_VALUE,
        basicRangeValueFactory.createReferenceValue("Type", new LibraryClass(), true, true, "Value"));
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  public void testCreateReferenceValue8() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = particularValueFactory.createReferenceValue("Type",
        referencedClass, true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  public void testCreateReferenceValue9() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory = new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory(arrayReferenceValueFactory,
        new BasicRangeValueFactory());
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = basicRangeValueFactory.createReferenceValue("Type",
        referencedClass, true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1);

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  public void testCreateReferenceValue10() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = particularValueFactory.createReferenceValue("Type",
        referencedClass, true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1, "Value");

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  public void testCreateReferenceValue11() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory = new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory(arrayReferenceValueFactory,
        new BasicRangeValueFactory());
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = basicRangeValueFactory.createReferenceValue("Type",
        referencedClass, true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1, "Value");

    // Assert
    assertTrue(actualCreateReferenceValueResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueResult.getType());
    AnalyzedObject value = actualCreateReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueResult.isNull());
    assertFalse(actualCreateReferenceValueResult.isCategory2());
    assertFalse(actualCreateReferenceValueResult.isParticular());
    assertFalse(actualCreateReferenceValueResult.isSpecific());
    assertTrue(actualCreateReferenceValueResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  public void testCreateReferenceValue12() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory = new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory(arrayReferenceValueFactory,
        new PrimitiveTypedReferenceValueFactory());
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act and Assert
    assertSame(basicRangeValueFactory.REFERENCE_VALUE, basicRangeValueFactory.createReferenceValue("Type",
        referencedClass, true, true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1, "Value"));
  }

  /**
   * Method under test: {@link ParticularValueFactory#createReferenceValueNull()}
   */
  @Test
  public void testCreateReferenceValueNull() {
    // Arrange and Act
    ReferenceValue actualCreateReferenceValueNullResult = (new ParticularValueFactory()).createReferenceValueNull();

    // Assert
    assertTrue(actualCreateReferenceValueNullResult instanceof TypedReferenceValue);
    AnalyzedObject value = actualCreateReferenceValueNullResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCreateReferenceValueNullResult.getType());
    assertNull(actualCreateReferenceValueNullResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateReferenceValueNullResult.isNull());
    assertFalse(actualCreateReferenceValueNullResult.isCategory2());
    assertFalse(actualCreateReferenceValueNullResult.mayBeExtension());
    assertFalse(actualCreateReferenceValueNullResult.isSpecific());
    assertFalse(((TypedReferenceValue) actualCreateReferenceValueNullResult).mayBeExtension);
    assertTrue(actualCreateReferenceValueNullResult.isParticular());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueNullResult).mayBeNull);
    assertEquals(Value.NEVER, actualCreateReferenceValueNullResult.isNotNull());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValueForId() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = particularValueFactory.createReferenceValueForId("Type",
        referencedClass, true, true, "Id");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    AnalyzedObject value = actualCreateReferenceValueForIdResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueForIdResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValueForId2() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory = new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory(arrayReferenceValueFactory,
        new BasicRangeValueFactory());
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = basicRangeValueFactory.createReferenceValueForId("Type",
        referencedClass, true, true, "Id");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    AnalyzedObject value = actualCreateReferenceValueForIdResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueForIdResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)}
   */
  @Test
  public void testCreateReferenceValueForId3() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = particularValueFactory.createReferenceValueForId("Type",
        referencedClass, true, true, "Id", "Value");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    AnalyzedObject value = actualCreateReferenceValueForIdResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueForIdResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)}
   */
  @Test
  public void testCreateReferenceValueForId4() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory = new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory(arrayReferenceValueFactory,
        new BasicRangeValueFactory());
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = basicRangeValueFactory.createReferenceValueForId("Type",
        referencedClass, true, true, "Id", "Value");

    // Assert
    assertTrue(actualCreateReferenceValueForIdResult instanceof TypedReferenceValue);
    assertEquals("Type", actualCreateReferenceValueForIdResult.getType());
    AnalyzedObject value = actualCreateReferenceValueForIdResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNotNull());
    assertEquals(0, actualCreateReferenceValueForIdResult.isNull());
    assertFalse(actualCreateReferenceValueForIdResult.isCategory2());
    assertFalse(actualCreateReferenceValueForIdResult.isParticular());
    assertFalse(actualCreateReferenceValueForIdResult.isSpecific());
    assertTrue(actualCreateReferenceValueForIdResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateReferenceValueForIdResult).mayBeNull);
    assertSame(referencedClass, actualCreateReferenceValueForIdResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)}
   */
  @Test
  public void testCreateReferenceValueForId5() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory = new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory(arrayReferenceValueFactory,
        new PrimitiveTypedReferenceValueFactory());

    // Act and Assert
    assertSame(basicRangeValueFactory.REFERENCE_VALUE,
        basicRangeValueFactory.createReferenceValueForId("Type", new LibraryClass(), true, true, "Id", "Value"));
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = particularValueFactory.createArrayReferenceValue("Type",
        referencedClass, ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof ArrayReferenceValue);
    IntegerValue integerValue = ((ArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertTrue(integerValue instanceof ParticularIntegerValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, integerValue.value());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(integerValue.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(((ArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((ArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(integerValue.isParticular());
    assertTrue(integerValue.isSpecific());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue2() {
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
   * {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue3() {
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
   * {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue4() {
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
   * {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue5() {
    // Arrange
    BasicRangeValueFactory arrayReferenceValueFactory = new BasicRangeValueFactory();
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory(arrayReferenceValueFactory,
        new ParticularReferenceValueFactory());
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = basicRangeValueFactory.createArrayReferenceValue("Type",
        referencedClass, ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof ArrayReferenceValue);
    IntegerValue integerValue = ((ArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertTrue(integerValue instanceof ParticularIntegerValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, integerValue.value());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(integerValue.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(((ArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((ArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(integerValue.isParticular());
    assertTrue(integerValue.isSpecific());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue6() {
    // Arrange
    DetailedArrayValueFactory arrayReferenceValueFactory = new DetailedArrayValueFactory();
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory(arrayReferenceValueFactory,
        new ParticularReferenceValueFactory());
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = basicRangeValueFactory.createArrayReferenceValue("Type",
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
    assertSame(arrayReferenceValueFactory.referenceValueFactory, valueFactory2);
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue7() {
    // Arrange
    ParticularValueFactory particularValueFactory = new ParticularValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = particularValueFactory.createArrayReferenceValue("Type",
        referencedClass, ParticularValueFactory.INTEGER_VALUE_0, "Element Values");

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof ArrayReferenceValue);
    IntegerValue integerValue = ((ArrayReferenceValue) actualCreateArrayReferenceValueResult).arrayLength;
    assertTrue(integerValue instanceof ParticularIntegerValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, integerValue.value());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(integerValue.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(actualCreateArrayReferenceValueResult.isSpecific());
    assertFalse(((ArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((ArrayReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(integerValue.isParticular());
    assertTrue(integerValue.isSpecific());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#ParticularValueFactory(ValueFactory)}
   */
  @Test
  public void testNewParticularValueFactory() {
    // Arrange, Act and Assert
    assertTrue((new ParticularValueFactory(
        new ParticularReferenceValueFactory())).referenceValueFactory instanceof ParticularReferenceValueFactory);
    assertTrue((new ParticularValueFactory()).referenceValueFactory instanceof TypedReferenceValueFactory);
  }

  /**
   * Method under test:
   * {@link ParticularValueFactory#ParticularValueFactory(ValueFactory, ValueFactory)}
   */
  @Test
  public void testNewParticularValueFactory2() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertTrue((new ParticularValueFactory(arrayReferenceValueFactory,
        new ParticularReferenceValueFactory())).referenceValueFactory instanceof ParticularReferenceValueFactory);
  }
}
