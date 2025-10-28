package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.analysis.datastructure.CodeLocation;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;

public class BasicValueFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link BasicValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Method under test:
   * {@link BasicValueFactory#createValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateValue2() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Value actualCreateValueResult = arrayReferenceValueFactory.createValue("Type", referencedClass, true, true);

    // Assert
    assertTrue(actualCreateValueResult instanceof TypedReferenceValue);
    assertEquals("Type", ((TypedReferenceValue) actualCreateValueResult).getType());
    AnalyzedObject value = ((TypedReferenceValue) actualCreateValueResult).getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, ((TypedReferenceValue) actualCreateValueResult).isNotNull());
    assertEquals(0, ((TypedReferenceValue) actualCreateValueResult).isNull());
    assertFalse(actualCreateValueResult.isCategory2());
    assertFalse(actualCreateValueResult.isParticular());
    assertFalse(actualCreateValueResult.isSpecific());
    assertTrue(((TypedReferenceValue) actualCreateValueResult).mayBeExtension());
    assertTrue(((TypedReferenceValue) actualCreateValueResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualCreateValueResult).mayBeNull);
    assertSame(referencedClass, ((TypedReferenceValue) actualCreateValueResult).getReferencedClass());
  }

  /**
   * Method under test: {@link BasicValueFactory#createIntegerValue()}
   */
  @Test
  public void testCreateIntegerValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.INTEGER_VALUE, basicValueFactory.createIntegerValue());
  }

  /**
   * Method under test: {@link BasicValueFactory#createIntegerValue(int)}
   */
  @Test
  public void testCreateIntegerValue2() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.INTEGER_VALUE, basicValueFactory.createIntegerValue(42));
  }

  /**
   * Method under test: {@link BasicValueFactory#createIntegerValue(int, int)}
   */
  @Test
  public void testCreateIntegerValue3() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.INTEGER_VALUE, basicValueFactory.createIntegerValue(1, 3));
  }

  /**
   * Method under test: {@link BasicValueFactory#createIntegerValue(int, int)}
   */
  @Test
  public void testCreateIntegerValue4() {
    // Arrange and Act
    IntegerValue actualCreateIntegerValueResult = (new DetailedArrayValueFactory()).createIntegerValue(1, 3);

    // Assert
    assertTrue(actualCreateIntegerValueResult instanceof IdentifiedIntegerValue);
    assertFalse(actualCreateIntegerValueResult.isCategory2());
    assertFalse(actualCreateIntegerValueResult.isParticular());
    assertTrue(actualCreateIntegerValueResult.isSpecific());
  }

  /**
   * Method under test: {@link BasicValueFactory#createLongValue()}
   */
  @Test
  public void testCreateLongValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.LONG_VALUE, basicValueFactory.createLongValue());
  }

  /**
   * Method under test: {@link BasicValueFactory#createLongValue(long)}
   */
  @Test
  public void testCreateLongValue2() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.LONG_VALUE, basicValueFactory.createLongValue(42L));
  }

  /**
   * Method under test: {@link BasicValueFactory#createFloatValue()}
   */
  @Test
  public void testCreateFloatValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.FLOAT_VALUE, basicValueFactory.createFloatValue());
  }

  /**
   * Method under test: {@link BasicValueFactory#createFloatValue(float)}
   */
  @Test
  public void testCreateFloatValue2() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.FLOAT_VALUE, basicValueFactory.createFloatValue(10.0f));
  }

  /**
   * Method under test: {@link BasicValueFactory#createDoubleValue()}
   */
  @Test
  public void testCreateDoubleValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.DOUBLE_VALUE, basicValueFactory.createDoubleValue());
  }

  /**
   * Method under test: {@link BasicValueFactory#createDoubleValue(double)}
   */
  @Test
  public void testCreateDoubleValue2() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.DOUBLE_VALUE, basicValueFactory.createDoubleValue(10.0d));
  }

  /**
   * Method under test: {@link BasicValueFactory#createReferenceValue()}
   */
  @Test
  public void testCreateReferenceValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.REFERENCE_VALUE, basicValueFactory.createReferenceValue());
  }

  /**
   * Method under test:
   * {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean)}
   */
  @Test
  public void testCreateReferenceValue2() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createReferenceValue("Type", new LibraryClass(), true, true));
  }

  /**
   * Method under test:
   * {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValue3() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createReferenceValue("Type", new LibraryClass(), true, true, "Value"));
  }

  /**
   * Method under test:
   * {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValue4() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = arrayReferenceValueFactory.createReferenceValue("Type",
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
   * {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  public void testCreateReferenceValue5() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act and Assert
    assertSame(basicValueFactory.REFERENCE_VALUE, basicValueFactory.createReferenceValue("Type", referencedClass, true,
        true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1));
  }

  /**
   * Method under test:
   * {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int)}
   */
  @Test
  public void testCreateReferenceValue6() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = arrayReferenceValueFactory.createReferenceValue("Type",
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
   * {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  public void testCreateReferenceValue7() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act and Assert
    assertSame(basicValueFactory.REFERENCE_VALUE, basicValueFactory.createReferenceValue("Type", referencedClass, true,
        true, creationClass, new LibraryMethod(1, "Name", "Descriptor"), 1, "Value"));
  }

  /**
   * Method under test:
   * {@link BasicValueFactory#createReferenceValue(String, Clazz, boolean, boolean, Clazz, Method, int, Object)}
   */
  @Test
  public void testCreateReferenceValue8() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();
    LibraryClass creationClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueResult = arrayReferenceValueFactory.createReferenceValue("Type",
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
   * Method under test: {@link BasicValueFactory#createReferenceValueNull()}
   */
  @Test
  public void testCreateReferenceValueNull() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.REFERENCE_VALUE, basicValueFactory.createReferenceValueNull());
  }

  /**
   * Method under test:
   * {@link BasicValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValueForId() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createReferenceValueForId("Type", new LibraryClass(), true, true, "Id"));
  }

  /**
   * Method under test:
   * {@link BasicValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object)}
   */
  @Test
  public void testCreateReferenceValueForId2() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = arrayReferenceValueFactory.createReferenceValueForId("Type",
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
   * {@link BasicValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)}
   */
  @Test
  public void testCreateReferenceValueForId3() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createReferenceValueForId("Type", new LibraryClass(), true, true, "Id", "Value"));
  }

  /**
   * Method under test:
   * {@link BasicValueFactory#createReferenceValueForId(String, Clazz, boolean, boolean, Object, Object)}
   */
  @Test
  public void testCreateReferenceValueForId4() {
    // Arrange
    ArrayReferenceValueFactory arrayReferenceValueFactory = new ArrayReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateReferenceValueForIdResult = arrayReferenceValueFactory.createReferenceValueForId("Type",
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
   * {@link BasicValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.REFERENCE_VALUE,
        basicValueFactory.createArrayReferenceValue("Type", new LibraryClass(), BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Method under test:
   * {@link BasicValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue)}
   */
  @Test
  public void testCreateArrayReferenceValue2() {
    // Arrange
    ParticularReferenceValueFactory arrayReferenceValueFactory = new ParticularReferenceValueFactory();
    BasicRangeValueFactory basicRangeValueFactory = new BasicRangeValueFactory(arrayReferenceValueFactory,
        new ParticularReferenceValueFactory());
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = basicRangeValueFactory.createArrayReferenceValue("Type",
        referencedClass, BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualCreateArrayReferenceValueResult instanceof IdentifiedReferenceValue);
    assertEquals("[Type", actualCreateArrayReferenceValueResult.getType());
    AnalyzedObject value = actualCreateArrayReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualCreateArrayReferenceValueResult.isNotNull());
    assertFalse(actualCreateArrayReferenceValueResult.isCategory2());
    assertFalse(actualCreateArrayReferenceValueResult.mayBeExtension());
    assertFalse(actualCreateArrayReferenceValueResult.isParticular());
    assertFalse(((IdentifiedReferenceValue) actualCreateArrayReferenceValueResult).mayBeExtension);
    assertFalse(((IdentifiedReferenceValue) actualCreateArrayReferenceValueResult).mayBeNull);
    assertTrue(actualCreateArrayReferenceValueResult.isSpecific());
    assertEquals(Value.NEVER, actualCreateArrayReferenceValueResult.isNull());
    assertSame(referencedClass, actualCreateArrayReferenceValueResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link BasicValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue3() {
    // Arrange
    BasicValueFactory basicValueFactory = new BasicValueFactory();

    // Act and Assert
    assertSame(basicValueFactory.REFERENCE_VALUE, basicValueFactory.createArrayReferenceValue("Type",
        new LibraryClass(), BasicValueFactory.INTEGER_VALUE, "Element Values"));
  }

  /**
   * Method under test:
   * {@link BasicValueFactory#createArrayReferenceValue(String, Clazz, IntegerValue, Object)}
   */
  @Test
  public void testCreateArrayReferenceValue4() {
    // Arrange
    PrimitiveTypedReferenceValueFactory primitiveTypedReferenceValueFactory = new PrimitiveTypedReferenceValueFactory();
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCreateArrayReferenceValueResult = primitiveTypedReferenceValueFactory
        .createArrayReferenceValue("Type", referencedClass, BasicValueFactory.INTEGER_VALUE, "Element Values");

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
   * {@link BasicValueFactory#checkCreationLocation(CodeLocation)}
   */
  @Test
  public void testCheckCreationLocation() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> BasicValueFactory
        .checkCreationLocation(new CodeLocation(clazz, new LibraryField(1, "Name", "Descriptor"), 2)));
  }
}
