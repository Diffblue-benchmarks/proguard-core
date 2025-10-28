package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import org.junit.Test;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;

public class ReferenceValueDiffblueTest {
  /**
   * Method under test: {@link ReferenceValue#value()}
   */
  @Test
  public void testValue() {
    // Arrange, Act and Assert
    assertNull((new UnknownReferenceValue()).value());
  }

  /**
   * Method under test: {@link ReferenceValue#getValue()}
   */
  @Test
  public void testGetValue() {
    // Arrange and Act
    AnalyzedObject actualValue = (new UnknownReferenceValue()).getValue();

    // Assert
    assertNull(actualValue.getPreciseValue());
    assertNull(actualValue.getModeledOrNullValue());
  }

  /**
   * Method under test: {@link ReferenceValue#arrayLength(ValueFactory)}
   */
  @Test
  public void testArrayLength() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.INTEGER_VALUE, unknownReferenceValue.arrayLength(valueFactory));
  }

  /**
   * Method under test: {@link ReferenceValue#arrayLength(ValueFactory)}
   */
  @Test
  public void testArrayLength2() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act
    IntegerValue actualArrayLengthResult = unknownReferenceValue.arrayLength(new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualArrayLengthResult instanceof IdentifiedIntegerValue);
    assertFalse(actualArrayLengthResult.isCategory2());
    assertFalse(actualArrayLengthResult.isParticular());
    assertTrue(actualArrayLengthResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ReferenceValue#integerArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testIntegerArrayLoad() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.INTEGER_VALUE,
        unknownReferenceValue.integerArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link ReferenceValue#integerArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testIntegerArrayLoad2() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act
    IntegerValue actualIntegerArrayLoadResult = unknownReferenceValue
        .integerArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualIntegerArrayLoadResult instanceof IdentifiedIntegerValue);
    assertFalse(actualIntegerArrayLoadResult.isCategory2());
    assertFalse(actualIntegerArrayLoadResult.isParticular());
    assertTrue(actualIntegerArrayLoadResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ReferenceValue#longArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testLongArrayLoad() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.LONG_VALUE,
        unknownReferenceValue.longArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link ReferenceValue#longArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testLongArrayLoad2() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act
    LongValue actualLongArrayLoadResult = unknownReferenceValue.longArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualLongArrayLoadResult instanceof IdentifiedLongValue);
    assertFalse(actualLongArrayLoadResult.isParticular());
    assertTrue(actualLongArrayLoadResult.isCategory2());
    assertTrue(actualLongArrayLoadResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ReferenceValue#floatArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testFloatArrayLoad() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.FLOAT_VALUE,
        unknownReferenceValue.floatArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link ReferenceValue#floatArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testFloatArrayLoad2() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act
    FloatValue actualFloatArrayLoadResult = unknownReferenceValue
        .floatArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualFloatArrayLoadResult instanceof IdentifiedFloatValue);
    assertFalse(actualFloatArrayLoadResult.isCategory2());
    assertFalse(actualFloatArrayLoadResult.isParticular());
    assertTrue(actualFloatArrayLoadResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ReferenceValue#doubleArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testDoubleArrayLoad() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.DOUBLE_VALUE,
        unknownReferenceValue.doubleArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link ReferenceValue#doubleArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testDoubleArrayLoad2() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act
    DoubleValue actualDoubleArrayLoadResult = unknownReferenceValue
        .doubleArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualDoubleArrayLoadResult instanceof IdentifiedDoubleValue);
    assertFalse(actualDoubleArrayLoadResult.isParticular());
    assertTrue(actualDoubleArrayLoadResult.isCategory2());
    assertTrue(actualDoubleArrayLoadResult.isSpecific());
  }

  /**
   * Method under test:
   * {@link ReferenceValue#referenceArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testReferenceArrayLoad() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        unknownReferenceValue.referenceArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test: {@link ReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertSame(unknownReferenceValue, unknownReferenceValue.generalize(
        new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test:
   * {@link ReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(unknownReferenceValue, unknownReferenceValue.generalize(new IdentifiedArrayReferenceValue("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test:
   * {@link ReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL
        .generalize(new IdentifiedArrayReferenceValue("Type", referencedClass, true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(unknownReferenceValue, unknownReferenceValue.generalize(new IdentifiedReferenceValue("Type",
        referencedClass, true, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test:
   * {@link ReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue other = new IdentifiedReferenceValue("Type", referencedClass, true, true,
        new ParticularReferenceValueFactory(), "Id");

    // Act and Assert
    assertSame(other, PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL.generalize(other));
  }

  /**
   * Method under test:
   * {@link ReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL
        .generalize(new IdentifiedReferenceValue("Type", referencedClass, true, false,
            new ParticularReferenceValueFactory(), "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = identifiedReferenceValue.generalize(new IdentifiedReferenceValue("Type",
        referencedClass2, true, false, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeExtension);
    assertTrue(((TypedReferenceValue) actualGeneralizeResult).mayBeNull);
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link ReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  public void testGeneralize8() {
    // Arrange
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(
        new TypedReferenceValue("Type", new LibraryClass(), true, true), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new IdentifiedReferenceValue("Type",
        referencedClass, true, false, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link ReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  public void testGeneralize9() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = unknownReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link ReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  public void testGeneralize10() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = unknownReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link ReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  public void testGeneralize11() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes
        .add(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = unknownReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link ReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  public void testGeneralize12() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(null);
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = unknownReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link ReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  public void testGeneralize13() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    LibraryClass referencedClass = new LibraryClass();
    potentialTypes.add(new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = unknownReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link ReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize14() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    TracedReferenceValue other = new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = unknownReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link ReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  public void testGeneralize15() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    TracedReferenceValue other = new TracedReferenceValue(
        new MultiTypedReferenceValue(new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = unknownReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link ReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize16() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertSame(unknownReferenceValue,
        unknownReferenceValue.generalize(new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Method under test: {@link ReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize17() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    UnknownReferenceValue other = new UnknownReferenceValue();

    // Act and Assert
    assertSame(other, unknownReferenceValue.generalize(other));
  }

  /**
   * Method under test: {@link ReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize18() {
    // Arrange
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(
        new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link ReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize19() {
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
   * Method under test: {@link ReferenceValue#generalize(Value)}
   */
  @Test
  public void testGeneralize20() {
    // Arrange
    UnknownValue other = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.REFERENCE_VALUE.generalize(other));
  }

  /**
   * Method under test: {@link ReferenceValue#generalize(Value)}
   */
  @Test
  public void testGeneralize21() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertSame(unknownReferenceValue, unknownReferenceValue.generalize((Value) BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Method under test: {@link ReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  public void testEqual() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertEquals(0, unknownReferenceValue
        .equal(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test:
   * {@link ReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testEqual2() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0, unknownReferenceValue.equal(new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test:
   * {@link ReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testEqual3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(Value.NEVER,
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL
            .equal(new IdentifiedArrayReferenceValue("Type", referencedClass, true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test:
   * {@link ReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  public void testEqual4() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", new LibraryClass(), true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0, arrayReferenceValue.equal(new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1)));
  }

  /**
   * Method under test: {@link ReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  public void testEqual5() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0, unknownReferenceValue.equal(new IdentifiedReferenceValue("Type", referencedClass, true, true,
        new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test: {@link ReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  public void testEqual6() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(0, PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL.equal(new IdentifiedReferenceValue("Type",
        referencedClass, true, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test: {@link ReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  public void testEqual7() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue = new IdentifiedReferenceValue("Type", referencedClass, true,
        true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(0, identifiedReferenceValue.equal(new IdentifiedReferenceValue("Type", referencedClass2, true, true,
        new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Method under test: {@link ReferenceValue#equal(MultiTypedReferenceValue)}
   */
  @Test
  public void testEqual8() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals(0, unknownReferenceValue.equal(new MultiTypedReferenceValue(potentialTypes, true)));
  }

  /**
   * Method under test: {@link ReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  public void testEqual9() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertEquals(0, unknownReferenceValue
        .equal(new TracedReferenceValue(BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link ReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  public void testEqual10() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertEquals(0, unknownReferenceValue.equal(new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Method under test: {@link ReferenceValue#equal(UnknownReferenceValue)}
   */
  @Test
  public void testEqual11() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertEquals(0, unknownReferenceValue.equal(new UnknownReferenceValue()));
  }

  /**
   * Method under test: {@link ReferenceValue#referenceValue()}
   */
  @Test
  public void testReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertSame(unknownReferenceValue, unknownReferenceValue.referenceValue());
  }

  /**
   * Method under test: {@link ReferenceValue#isNotNull()}
   */
  @Test
  public void testIsNotNull() {
    // Arrange, Act and Assert
    assertEquals(0, (new UnknownReferenceValue()).isNotNull());
  }

  /**
   * Method under test: {@link ReferenceValue#notEqual(ReferenceValue)}
   */
  @Test
  public void testNotEqual() {
    // Arrange, Act and Assert
    assertEquals(0, (new UnknownReferenceValue()).notEqual(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Method under test: {@link ReferenceValue#computationalType()}
   */
  @Test
  public void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(5, (new UnknownReferenceValue()).computationalType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReferenceValue#equals(Object)}
   *   <li>{@link ReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReferenceValue referenceValue = BasicValueFactory.REFERENCE_VALUE;
    ReferenceValue referenceValue2 = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertEquals(referenceValue, referenceValue2);
    int expectedHashCodeResult = referenceValue.hashCode();
    assertEquals(expectedHashCodeResult, referenceValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReferenceValue#equals(Object)}
   *   <li>{@link ReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReferenceValue referenceValue = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertEquals(referenceValue, referenceValue);
    int expectedHashCodeResult = referenceValue.hashCode();
    assertEquals(expectedHashCodeResult, referenceValue.hashCode());
  }

  /**
   * Method under test: {@link ReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL, BasicValueFactory.REFERENCE_VALUE);
  }

  /**
   * Method under test: {@link ReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BasicValueFactory.REFERENCE_VALUE, null);
  }

  /**
   * Method under test: {@link ReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BasicValueFactory.REFERENCE_VALUE, "Different type to ReferenceValue");
  }

  /**
   * Method under test: {@link ReferenceValue#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("a", BasicValueFactory.REFERENCE_VALUE.toString());
  }
}
