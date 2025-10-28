package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.ReferenceTracingValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;

public class TracedReferenceValueDiffblueTest {
  /**
   * Method under test: {@link TracedReferenceValue#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals("Ljava/lang/Object;",
        (new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .getType());
    assertEquals("Ljava/lang/Object;",
        (new TracedReferenceValue(
            new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)).getType());
  }

  /**
   * Method under test: {@link TracedReferenceValue#getReferencedClass()}
   */
  @Test
  public void testGetReferencedClass() {
    // Arrange, Act and Assert
    assertNull((new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .getReferencedClass());
    assertNull((new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).getReferencedClass());
  }

  /**
   * Method under test: {@link TracedReferenceValue#mayBeExtension()}
   */
  @Test
  public void testMayBeExtension() {
    // Arrange, Act and Assert
    assertTrue((new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .mayBeExtension());
    assertFalse((new TracedReferenceValue(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).mayBeExtension());
    assertTrue((new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).mayBeExtension());
  }

  /**
   * Method under test: {@link TracedReferenceValue#isNull()}
   */
  @Test
  public void testIsNull() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .isNull());
    assertEquals(0,
        (new TracedReferenceValue(
            new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)).isNull());
  }

  /**
   * Method under test: {@link TracedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Method under test: {@link TracedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Method under test: {@link TracedReferenceValue#arrayLength(ValueFactory)}
   */
  @Test
  public void testArrayLength() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.INTEGER_VALUE, tracedReferenceValue.arrayLength(valueFactory));
  }

  /**
   * Method under test: {@link TracedReferenceValue#arrayLength(ValueFactory)}
   */
  @Test
  public void testArrayLength2() {
    // Arrange
    ArrayReferenceValue referenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(referenceValue,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(referenceValue.arrayLength, tracedReferenceValue.arrayLength(new ParticularReferenceValueFactory()));
  }

  /**
   * Method under test: {@link TracedReferenceValue#arrayLength(ValueFactory)}
   */
  @Test
  public void testArrayLength3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.INTEGER_VALUE, tracedReferenceValue.arrayLength(valueFactory));
  }

  /**
   * Method under test: {@link TracedReferenceValue#arrayLength(ValueFactory)}
   */
  @Test
  public void testArrayLength4() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualArrayLengthResult = tracedReferenceValue.arrayLength(new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualArrayLengthResult instanceof IdentifiedIntegerValue);
    assertFalse(actualArrayLengthResult.isCategory2());
    assertFalse(actualArrayLengthResult.isParticular());
    assertTrue(actualArrayLengthResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#integerArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testIntegerArrayLoad() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.INTEGER_VALUE,
        tracedReferenceValue.integerArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#integerArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testIntegerArrayLoad2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.INTEGER_VALUE,
        tracedReferenceValue.integerArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#integerArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testIntegerArrayLoad3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualIntegerArrayLoadResult = tracedReferenceValue
        .integerArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualIntegerArrayLoadResult instanceof IdentifiedIntegerValue);
    assertFalse(actualIntegerArrayLoadResult.isCategory2());
    assertFalse(actualIntegerArrayLoadResult.isParticular());
    assertTrue(actualIntegerArrayLoadResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#longArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testLongArrayLoad() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.LONG_VALUE,
        tracedReferenceValue.longArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#longArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testLongArrayLoad2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.LONG_VALUE,
        tracedReferenceValue.longArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#longArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testLongArrayLoad3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualLongArrayLoadResult = tracedReferenceValue.longArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualLongArrayLoadResult instanceof IdentifiedLongValue);
    assertFalse(actualLongArrayLoadResult.isParticular());
    assertTrue(actualLongArrayLoadResult.isCategory2());
    assertTrue(actualLongArrayLoadResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#floatArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testFloatArrayLoad() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.FLOAT_VALUE,
        tracedReferenceValue.floatArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#floatArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testFloatArrayLoad2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.FLOAT_VALUE,
        tracedReferenceValue.floatArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#floatArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testFloatArrayLoad3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    FloatValue actualFloatArrayLoadResult = tracedReferenceValue
        .floatArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualFloatArrayLoadResult instanceof IdentifiedFloatValue);
    assertFalse(actualFloatArrayLoadResult.isCategory2());
    assertFalse(actualFloatArrayLoadResult.isParticular());
    assertTrue(actualFloatArrayLoadResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#doubleArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testDoubleArrayLoad() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.DOUBLE_VALUE,
        tracedReferenceValue.doubleArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#doubleArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testDoubleArrayLoad2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.DOUBLE_VALUE,
        tracedReferenceValue.doubleArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#doubleArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testDoubleArrayLoad3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    DoubleValue actualDoubleArrayLoadResult = tracedReferenceValue
        .doubleArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualDoubleArrayLoadResult instanceof IdentifiedDoubleValue);
    assertFalse(actualDoubleArrayLoadResult.isParticular());
    assertTrue(actualDoubleArrayLoadResult.isCategory2());
    assertTrue(actualDoubleArrayLoadResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#referenceArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testReferenceArrayLoad() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory valueFactory2 = new ReferenceTracingValueFactory(valueFactory, true);
    valueFactory2.setTraceValue(null);

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        tracedReferenceValue.referenceArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory2));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#referenceArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testReferenceArrayLoad2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    ReferenceTracingValueFactory valueFactory = new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(),
        true);
    valueFactory.setTraceValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualReferenceArrayLoadResult = tracedReferenceValue
        .referenceArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory);

    // Assert
    assertTrue(actualReferenceArrayLoadResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualReferenceArrayLoadResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#referenceArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testReferenceArrayLoad3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory valueFactory2 = new ReferenceTracingValueFactory(valueFactory, true);
    valueFactory2.setTraceValue(null);

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        tracedReferenceValue.referenceArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory2));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();
    ArrayReferenceValue other = new ArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals("Type", referenceValue.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertEquals(0, referenceValue.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(referenceValue.isSpecific());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(((TypedReferenceValue) referenceValue).mayBeExtension);
    assertTrue(((TypedReferenceValue) referenceValue).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(value, referenceValue.getValue());
    IntegerValue expectedTraceValue = other.arrayLength;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualGeneralizeResult).getTraceValue());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ArrayReferenceValue other = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals("Type", referenceValue.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertEquals(1, referenceValue.isNotNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(referenceValue.isSpecific());
    assertFalse(((TypedReferenceValue) referenceValue).mayBeNull);
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(((TypedReferenceValue) referenceValue).mayBeExtension);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertEquals(Value.NEVER, referenceValue.isNull());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(value, referenceValue.getValue());
    IntegerValue expectedTraceValue = other.arrayLength;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualGeneralizeResult).getTraceValue());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testGeneralize8() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue other = new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals("Type", referenceValue.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertEquals(0, referenceValue.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(referenceValue.isSpecific());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(((TypedReferenceValue) referenceValue).mayBeExtension);
    assertTrue(((TypedReferenceValue) referenceValue).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(value, referenceValue.getValue());
    IntegerValue expectedTraceValue = other.arrayLength;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualGeneralizeResult).getTraceValue());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testGeneralize9() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new ArrayReferenceValue("Type", referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();
    IdentifiedArrayReferenceValue other = new IdentifiedArrayReferenceValue("Type", referencedClass2, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals("Type", referenceValue.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertEquals(1, referenceValue.isNotNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(referenceValue.isSpecific());
    assertFalse(((TypedReferenceValue) referenceValue).mayBeNull);
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(((TypedReferenceValue) referenceValue).mayBeExtension);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertEquals(Value.NEVER, referenceValue.isNull());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(value, referenceValue.getValue());
    IntegerValue expectedTraceValue = other.arrayLength;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualGeneralizeResult).getTraceValue());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testGeneralize10() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();
    IdentifiedArrayReferenceValue other = new IdentifiedArrayReferenceValue("Type", referencedClass2, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals("Type", referenceValue.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertEquals(1, referenceValue.isNotNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(referenceValue.isSpecific());
    assertFalse(((TypedReferenceValue) referenceValue).mayBeNull);
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(((TypedReferenceValue) referenceValue).mayBeExtension);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertEquals(Value.NEVER, referenceValue.isNull());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(value, referenceValue.getValue());
    IntegerValue expectedTraceValue = other.arrayLength;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualGeneralizeResult).getTraceValue());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testGeneralize11() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testGeneralize12() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize13() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize14() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue other = new IdentifiedReferenceValue("Type", referencedClass, true, true,
        new ParticularReferenceValueFactory(), "Id");

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    Value traceValue = ((TracedReferenceValue) actualGeneralizeResult).getTraceValue();
    assertTrue(traceValue instanceof RangeIntegerValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(traceValue.isParticular());
    assertFalse(traceValue.isSpecific());
    assertTrue(actualGeneralizeResult.isSpecific());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
    assertSame(other, ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize15() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ArrayReferenceValue referenceValue = new ArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(referenceValue,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(new IdentifiedReferenceValue("Type",
        referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue2 = ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue2 instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals("Type", referenceValue2.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, referenceValue2.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertEquals(0, referenceValue2.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(referenceValue2.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(referenceValue2.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(referenceValue2.isSpecific());
    assertTrue(referenceValue2.mayBeExtension());
    assertTrue(((TypedReferenceValue) referenceValue2).mayBeExtension);
    assertTrue(((TypedReferenceValue) referenceValue2).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
    assertSame(referencedClass, referenceValue2.getReferencedClass());
    assertSame(value, referenceValue2.getValue());
    IntegerValue expectedTraceValue = referenceValue.arrayLength;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualGeneralizeResult).getTraceValue());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize16() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(new IdentifiedReferenceValue("Type",
        referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    Value traceValue = ((TracedReferenceValue) actualGeneralizeResult).getTraceValue();
    assertTrue(traceValue instanceof RangeIntegerValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals("Type", referenceValue.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertEquals(0, referenceValue.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertFalse(traceValue.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(referenceValue.isSpecific());
    assertFalse(traceValue.isSpecific());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(((TypedReferenceValue) referenceValue).mayBeExtension);
    assertTrue(((TypedReferenceValue) referenceValue).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize17() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize18() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize19() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize20() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize21() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize22() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize23() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize((ReferenceValue) new ArrayReferenceValue("Type", new LibraryClass(), true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize24() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize((ReferenceValue) new IdentifiedArrayReferenceValue("Type", referencedClass, true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize25() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize((ReferenceValue) new IdentifiedReferenceValue("Type", referencedClass, true, true,
            new ParticularReferenceValueFactory(), "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize26() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(other, tracedReferenceValue.generalize((ReferenceValue) other));
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize27() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize28() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize((ReferenceValue) new ArrayReferenceValue("Type", new LibraryClass(), true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize29() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize((ReferenceValue) new IdentifiedReferenceValue("Type", referencedClass, true, true,
            new ParticularReferenceValueFactory(), "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize30() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize31() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize((ReferenceValue) new ArrayReferenceValue("Type", new LibraryClass(), true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize32() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize((ReferenceValue) new IdentifiedArrayReferenceValue("Type", referencedClass, true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize33() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize((ReferenceValue) new IdentifiedReferenceValue("Type", referencedClass, true, true,
            new ParticularReferenceValueFactory(), "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize34() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize((ReferenceValue) new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize35() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize36() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize37() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();
    ArrayReferenceValue other = new ArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals("Type", referenceValue.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertEquals(0, referenceValue.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(referenceValue.isSpecific());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(((TypedReferenceValue) referenceValue).mayBeExtension);
    assertTrue(((TypedReferenceValue) referenceValue).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(value, referenceValue.getValue());
    IntegerValue expectedTraceValue = other.arrayLength;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualGeneralizeResult).getTraceValue());
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize38() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize((ReferenceValue) new ArrayReferenceValue("Type", new LibraryClass(), true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize39() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new ArrayReferenceValue("Type", referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();
    IdentifiedArrayReferenceValue other = new IdentifiedArrayReferenceValue("Type", referencedClass2, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals("Type", referenceValue.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertEquals(1, referenceValue.isNotNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(referenceValue.isSpecific());
    assertFalse(((TypedReferenceValue) referenceValue).mayBeNull);
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(((TypedReferenceValue) referenceValue).mayBeExtension);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertEquals(Value.NEVER, referenceValue.isNull());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(value, referenceValue.getValue());
    IntegerValue expectedTraceValue = other.arrayLength;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualGeneralizeResult).getTraceValue());
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize40() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();
    IdentifiedArrayReferenceValue other = new IdentifiedArrayReferenceValue("Type", referencedClass2, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals("Type", referenceValue.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertEquals(1, referenceValue.isNotNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(referenceValue.isSpecific());
    assertFalse(((TypedReferenceValue) referenceValue).mayBeNull);
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(((TypedReferenceValue) referenceValue).mayBeExtension);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertEquals(Value.NEVER, referenceValue.isNull());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(value, referenceValue.getValue());
    IntegerValue expectedTraceValue = other.arrayLength;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualGeneralizeResult).getTraceValue());
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize41() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue other = new IdentifiedReferenceValue("Type", referencedClass, true, true,
        new ParticularReferenceValueFactory(), "Id");

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    Value traceValue = ((TracedReferenceValue) actualGeneralizeResult).getTraceValue();
    assertTrue(traceValue instanceof RangeIntegerValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(traceValue.isParticular());
    assertFalse(traceValue.isSpecific());
    assertTrue(actualGeneralizeResult.isSpecific());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
    assertSame(other, ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue());
  }

  /**
   * Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize42() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize((ReferenceValue) new IdentifiedReferenceValue("Type", referencedClass2, true, true,
            new ParticularReferenceValueFactory(), "Id"));

    // Assert
    Value traceValue = ((TracedReferenceValue) actualGeneralizeResult).getTraceValue();
    assertTrue(traceValue instanceof RangeIntegerValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertEquals("Type", referenceValue.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertEquals(0, referenceValue.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertFalse(traceValue.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(referenceValue.isSpecific());
    assertFalse(traceValue.isSpecific());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(((TypedReferenceValue) referenceValue).mayBeExtension);
    assertTrue(((TypedReferenceValue) referenceValue).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize43() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(tracedReferenceValue, tracedReferenceValue.generalize(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize44() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize45() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize46() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize47() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    Value traceValue = ((TracedReferenceValue) actualGeneralizeResult).getTraceValue();
    assertTrue(traceValue instanceof RangeIntegerValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    assertEquals("Ljava/lang/Object;", referenceValue.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(referenceValue.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertEquals(0, referenceValue.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertFalse(traceValue.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(referenceValue.isSpecific());
    assertFalse(traceValue.isSpecific());
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize48() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize49() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize50() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other = new TracedReferenceValue(
        TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize51() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize(new TracedReferenceValue(TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    Value traceValue = ((TracedReferenceValue) actualGeneralizeResult).getTraceValue();
    assertTrue(traceValue instanceof RangeIntegerValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue = ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    assertEquals("Ljava/lang/Object;", referenceValue.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(referenceValue.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, referenceValue.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertEquals(0, referenceValue.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(referenceValue.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(referenceValue.isParticular());
    assertFalse(traceValue.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(referenceValue.isSpecific());
    assertFalse(traceValue.isSpecific());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(((TypedReferenceValue) referenceValue).mayBeExtension);
    assertTrue(((TypedReferenceValue) referenceValue).mayBeNull);
    assertSame(value, referenceValue.getValue());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize52() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize53() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize54() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE), BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize55() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE), BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize56() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize57() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize58() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize59() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize60() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(new TracedReferenceValue(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize61() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize(
            new TracedReferenceValue(
                new IdentifiedArrayReferenceValue("Type", referencedClass, true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize62() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(new TracedReferenceValue(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize63() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicValueFactory.REFERENCE_VALUE);
    TracedReferenceValue other = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicValueFactory.UNKNOWN_VALUE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize64() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        InstructionOffsetValue.EMPTY_VALUE);
    TracedReferenceValue other = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicValueFactory.UNKNOWN_VALUE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize65() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        InstructionOffsetValue.EMPTY_VALUE);

    // Act and Assert
    assertSame(tracedReferenceValue, tracedReferenceValue
        .generalize(new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, InstructionOffsetValue.EMPTY_VALUE)));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize66() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize67() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue other = new TypedReferenceValue("Type", referencedClass, true, true);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    Value traceValue = ((TracedReferenceValue) actualGeneralizeResult).getTraceValue();
    assertTrue(traceValue instanceof RangeIntegerValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(traceValue.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(traceValue.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(traceValue.isSpecific());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
    assertSame(other, ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize68() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    ArrayReferenceValue referenceValue = new ArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(referenceValue,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue2 = ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue2 instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertEquals(other, referenceValue2);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
    IntegerValue expectedTraceValue = referenceValue.arrayLength;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualGeneralizeResult).getTraceValue());
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize69() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize70() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue
        .generalize(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize71() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize72() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize73() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  public void testEqual() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue
        .equal(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  public void testEqual2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(Value.NEVER, tracedReferenceValue
        .equal(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  public void testEqual3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue
        .equal(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  public void testEqual4() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue
        .equal(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testEqual5() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal(new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testEqual6() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(Value.NEVER, tracedReferenceValue.equal(new IdentifiedArrayReferenceValue("Type", referencedClass,
        true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testEqual7() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal(new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testEqual8() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal(new IdentifiedArrayReferenceValue("Type", referencedClass2, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testEqual9() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal(new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  public void testEqual10() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal(new IdentifiedReferenceValue("Type", referencedClass, true, true,
        new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  public void testEqual11() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal(new IdentifiedReferenceValue("Type", referencedClass, true, true,
        new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  public void testEqual12() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal(new IdentifiedReferenceValue("Type", referencedClass2, true, true,
        new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test:
   * {@link TracedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  public void testEqual13() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal(new IdentifiedReferenceValue("Type", referencedClass, true, true,
        new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual14() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual15() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new TracedReferenceValue(
            new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)).equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual16() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual17() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal((ReferenceValue) new ArrayReferenceValue("Type", new LibraryClass(),
        true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual18() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal((ReferenceValue) new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual19() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal((ReferenceValue) new IdentifiedReferenceValue("Type", referencedClass,
        true, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual20() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0,
        tracedReferenceValue.equal((ReferenceValue) new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual21() {
    // Arrange, Act and Assert
    assertEquals(0,
        (new TracedReferenceValue(
            new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE))
                .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual22() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal((ReferenceValue) new ArrayReferenceValue("Type", new LibraryClass(),
        true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual23() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal((ReferenceValue) new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual24() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal((ReferenceValue) new IdentifiedReferenceValue("Type", referencedClass,
        true, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual25() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0,
        tracedReferenceValue.equal((ReferenceValue) new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual26() {
    // Arrange, Act and Assert
    assertEquals(1,
        (new TracedReferenceValue(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE))
                .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual27() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(Value.NEVER, tracedReferenceValue.equal((ReferenceValue) new ArrayReferenceValue("Type",
        new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual28() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal((ReferenceValue) new ArrayReferenceValue("Type", new LibraryClass(),
        true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual29() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal((ReferenceValue) new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual30() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal((ReferenceValue) new IdentifiedArrayReferenceValue("Type",
        referencedClass2, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual31() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal((ReferenceValue) new IdentifiedReferenceValue("Type", referencedClass,
        true, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual32() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal((ReferenceValue) new IdentifiedReferenceValue("Type", referencedClass2,
        true, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual33() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue
        .equal(new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual34() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue
        .equal(new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual35() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue
        .equal(new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual36() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue
        .equal(new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual37() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue
        .equal(new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual38() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue
        .equal(new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual39() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue
        .equal(new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual40() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0,
        tracedReferenceValue.equal(new TracedReferenceValue(
            new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual41() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(1,
        tracedReferenceValue.equal(new TracedReferenceValue(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual42() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0,
        tracedReferenceValue.equal(new TracedReferenceValue(
            new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual43() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(Value.NEVER,
        tracedReferenceValue.equal(new TracedReferenceValue(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual44() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0,
        tracedReferenceValue.equal(new TracedReferenceValue(
            new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual45() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0,
        tracedReferenceValue.equal(new TracedReferenceValue(
            new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual46() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0,
        tracedReferenceValue
            .equal(new TracedReferenceValue(
                new IdentifiedArrayReferenceValue("Type", referencedClass2, true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual47() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0,
        tracedReferenceValue.equal(new TracedReferenceValue(
            new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual48() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0,
        tracedReferenceValue.equal(new TracedReferenceValue(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual49() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0,
        tracedReferenceValue.equal(new TracedReferenceValue(
            new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  public void testEqual50() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal(new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  public void testEqual51() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal(new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  public void testEqual52() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal(new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(UnknownReferenceValue)}
   */
  @Test
  public void testEqual53() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal(new UnknownReferenceValue()));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equal(UnknownReferenceValue)}
   */
  @Test
  public void testEqual54() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal(new UnknownReferenceValue()));
  }

  /**
   * Method under test: {@link TracedReferenceValue#isSpecific()}
   */
  @Test
  public void testIsSpecific() {
    // Arrange, Act and Assert
    assertFalse((new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .isSpecific());
    assertFalse((new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).isSpecific());
  }

  /**
   * Method under test: {@link TracedReferenceValue#isSpecific()}
   */
  @Test
  public void testIsSpecific2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertTrue((new TracedReferenceValue(new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).isSpecific());
  }

  /**
   * Method under test: {@link TracedReferenceValue#isParticular()}
   */
  @Test
  public void testIsParticular() {
    // Arrange, Act and Assert
    assertFalse((new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .isParticular());
    assertTrue((new TracedReferenceValue(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).isParticular());
    assertFalse((new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).isParticular());
    assertFalse((new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).isParticular());
  }

  /**
   * Method under test: {@link TracedReferenceValue#internalType()}
   */
  @Test
  public void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("Ljava/lang/Object;",
        (new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .internalType());
    assertEquals("Ljava/lang/Object;",
        (new TracedReferenceValue(
            new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE)).internalType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TracedReferenceValue#equals(Object)}
   *   <li>{@link TracedReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue tracedReferenceValue2 = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(tracedReferenceValue, tracedReferenceValue2);
    int expectedHashCodeResult = tracedReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, tracedReferenceValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TracedReferenceValue#equals(Object)}
   *   <li>{@link TracedReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(tracedReferenceValue, tracedReferenceValue);
    int expectedHashCodeResult = tracedReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, tracedReferenceValue.hashCode());
  }

  /**
   * Method under test: {@link TracedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(tracedReferenceValue,
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(tracedReferenceValue,
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(tracedReferenceValue,
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link TracedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Method under test: {@link TracedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to TracedReferenceValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TracedReferenceValue#TracedReferenceValue(ReferenceValue, Value)}
   *   <li>{@link TracedReferenceValue#toString()}
   *   <li>{@link TracedReferenceValue#getReferenceValue()}
   *   <li>{@link TracedReferenceValue#getTraceValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ReferenceValue referenceValue = BasicValueFactory.REFERENCE_VALUE;
    IntegerValue traceValue = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act
    TracedReferenceValue actualTracedReferenceValue = new TracedReferenceValue(referenceValue, traceValue);
    String actualToStringResult = actualTracedReferenceValue.toString();
    ReferenceValue actualReferenceValue = actualTracedReferenceValue.getReferenceValue();

    // Assert
    assertEquals("ba", actualToStringResult);
    assertSame(traceValue, actualTracedReferenceValue.getTraceValue());
    assertSame(referenceValue, actualReferenceValue);
  }
}
