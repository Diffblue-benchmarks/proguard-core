package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;

public class ReferenceValueDiffblueTest {
  /**
   * Test {@link ReferenceValue#value()}.
   *
   * <p>Method under test: {@link ReferenceValue#value()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object ReferenceValue.value()"})
  public void testValue() {
    // Arrange, Act and Assert
    assertNull((new UnknownReferenceValue()).value());
  }

  /**
   * Test {@link ReferenceValue#getValue()}.
   *
   * <p>Method under test: {@link ReferenceValue#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AnalyzedObject ReferenceValue.getValue()"})
  public void testGetValue() {
    // Arrange and Act
    AnalyzedObject actualValue = (new UnknownReferenceValue()).getValue();

    // Assert
    assertNull(actualValue.getPreciseValue());
    assertNull(actualValue.getModeledOrNullValue());
  }

  /**
   * Test {@link ReferenceValue#arrayLength(ValueFactory)}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#arrayLength(ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ReferenceValue.arrayLength(ValueFactory)"})
  public void testArrayLength_thenReturnParticularReferenceValueFactoryInteger_value() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.INTEGER_VALUE, unknownReferenceValue.arrayLength(valueFactory));
  }

  /**
   * Test {@link ReferenceValue#arrayLength(ValueFactory)}.
   *
   * <ul>
   *   <li>When {@link DetailedArrayValueFactory#DetailedArrayValueFactory()}.
   *   <li>Then return {@link IdentifiedIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#arrayLength(ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ReferenceValue.arrayLength(ValueFactory)"})
  public void testArrayLength_whenDetailedArrayValueFactory_thenReturnIdentifiedIntegerValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act
    IntegerValue actualArrayLengthResult =
        unknownReferenceValue.arrayLength(new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualArrayLengthResult instanceof IdentifiedIntegerValue);
    assertFalse(actualArrayLengthResult.isCategory2());
    assertFalse(actualArrayLengthResult.isParticular());
    assertTrue(actualArrayLengthResult.isSpecific());
  }

  /**
   * Test {@link ReferenceValue#integerArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>Then return {@link IdentifiedIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#integerArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ReferenceValue.integerArrayLoad(IntegerValue, ValueFactory)"})
  public void testIntegerArrayLoad_thenReturnIdentifiedIntegerValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act
    IntegerValue actualIntegerArrayLoadResult =
        unknownReferenceValue.integerArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualIntegerArrayLoadResult instanceof IdentifiedIntegerValue);
    assertFalse(actualIntegerArrayLoadResult.isCategory2());
    assertFalse(actualIntegerArrayLoadResult.isParticular());
    assertTrue(actualIntegerArrayLoadResult.isSpecific());
  }

  /**
   * Test {@link ReferenceValue#integerArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#integerArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue ReferenceValue.integerArrayLoad(IntegerValue, ValueFactory)"})
  public void testIntegerArrayLoad_thenReturnParticularReferenceValueFactoryInteger_value() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.INTEGER_VALUE,
        unknownReferenceValue.integerArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Test {@link ReferenceValue#longArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#longArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue ReferenceValue.longArrayLoad(IntegerValue, ValueFactory)"})
  public void testLongArrayLoad_thenReturnParticularReferenceValueFactoryLong_value() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.LONG_VALUE,
        unknownReferenceValue.longArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Test {@link ReferenceValue#longArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>When {@link DetailedArrayValueFactory#DetailedArrayValueFactory()}.
   *   <li>Then return {@link IdentifiedLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#longArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue ReferenceValue.longArrayLoad(IntegerValue, ValueFactory)"})
  public void testLongArrayLoad_whenDetailedArrayValueFactory_thenReturnIdentifiedLongValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act
    LongValue actualLongArrayLoadResult =
        unknownReferenceValue.longArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualLongArrayLoadResult instanceof IdentifiedLongValue);
    assertFalse(actualLongArrayLoadResult.isParticular());
    assertTrue(actualLongArrayLoadResult.isCategory2());
    assertTrue(actualLongArrayLoadResult.isSpecific());
  }

  /**
   * Test {@link ReferenceValue#floatArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#floatArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ReferenceValue.floatArrayLoad(IntegerValue, ValueFactory)"})
  public void testFloatArrayLoad_thenReturnParticularReferenceValueFactoryFloat_value() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.FLOAT_VALUE,
        unknownReferenceValue.floatArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Test {@link ReferenceValue#floatArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>When {@link DetailedArrayValueFactory#DetailedArrayValueFactory()}.
   *   <li>Then return {@link IdentifiedFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#floatArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue ReferenceValue.floatArrayLoad(IntegerValue, ValueFactory)"})
  public void testFloatArrayLoad_whenDetailedArrayValueFactory_thenReturnIdentifiedFloatValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act
    FloatValue actualFloatArrayLoadResult =
        unknownReferenceValue.floatArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualFloatArrayLoadResult instanceof IdentifiedFloatValue);
    assertFalse(actualFloatArrayLoadResult.isCategory2());
    assertFalse(actualFloatArrayLoadResult.isParticular());
    assertTrue(actualFloatArrayLoadResult.isSpecific());
  }

  /**
   * Test {@link ReferenceValue#doubleArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>Then return {@link IdentifiedDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#doubleArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue ReferenceValue.doubleArrayLoad(IntegerValue, ValueFactory)"})
  public void testDoubleArrayLoad_thenReturnIdentifiedDoubleValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act
    DoubleValue actualDoubleArrayLoadResult =
        unknownReferenceValue.doubleArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualDoubleArrayLoadResult instanceof IdentifiedDoubleValue);
    assertFalse(actualDoubleArrayLoadResult.isParticular());
    assertTrue(actualDoubleArrayLoadResult.isCategory2());
    assertTrue(actualDoubleArrayLoadResult.isSpecific());
  }

  /**
   * Test {@link ReferenceValue#doubleArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#doubleArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue ReferenceValue.doubleArrayLoad(IntegerValue, ValueFactory)"})
  public void testDoubleArrayLoad_thenReturnParticularReferenceValueFactoryDouble_value() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.DOUBLE_VALUE,
        unknownReferenceValue.doubleArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Test {@link ReferenceValue#referenceArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#referenceArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue ReferenceValue.referenceArrayLoad(IntegerValue, ValueFactory)"
  })
  public void testReferenceArrayLoad_thenReturnParticularReferenceValueFactoryReference_value() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        unknownReferenceValue.referenceArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Test {@link ReferenceValue#generalize(ArrayReferenceValue)} with {@code ArrayReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownReferenceValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(ArrayReferenceValue)"})
  public void testGeneralizeWithArrayReferenceValue_thenReturnUnknownReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertSame(
        unknownReferenceValue,
        unknownReferenceValue.generalize(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link ReferenceValue#generalize(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link TypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(IdentifiedArrayReferenceValue)"})
  public void testGeneralizeWithIdentifiedArrayReferenceValue_thenReturnTypedReferenceValue() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL.generalize(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link ReferenceValue#generalize(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownReferenceValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(IdentifiedArrayReferenceValue)"})
  public void testGeneralizeWithIdentifiedArrayReferenceValue_thenReturnUnknownReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        unknownReferenceValue,
        unknownReferenceValue.generalize(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1)));
  }

  /**
   * Test {@link ReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link ReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(IdentifiedReferenceValue)"})
  public void testGeneralizeWithIdentifiedReferenceValue() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue other =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");

    // Act and Assert
    assertSame(other, PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL.generalize(other));
  }

  /**
   * Test {@link ReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link ReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(IdentifiedReferenceValue)"})
  public void testGeneralizeWithIdentifiedReferenceValue2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        identifiedReferenceValue.generalize(
            new IdentifiedReferenceValue(
                "Type",
                referencedClass2,
                true,
                false,
                new ParticularReferenceValueFactory(),
                "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link ReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(IdentifiedReferenceValue)"})
  public void testGeneralizeWithIdentifiedReferenceValue_thenReturnMultiTypedReferenceValue() {
    // Arrange
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, false, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link ReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link TypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(IdentifiedReferenceValue)"})
  public void testGeneralizeWithIdentifiedReferenceValue_thenReturnTypedReferenceValue() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL.generalize(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, false, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Test {@link ReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownReferenceValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(IdentifiedReferenceValue)"})
  public void testGeneralizeWithIdentifiedReferenceValue_thenReturnUnknownReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        unknownReferenceValue,
        unknownReferenceValue.generalize(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Test {@link ReferenceValue#generalize(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <p>Method under test: {@link ReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(MultiTypedReferenceValue)"})
  public void testGeneralizeWithMultiTypedReferenceValue() {
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
   * Test {@link ReferenceValue#generalize(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <p>Method under test: {@link ReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(MultiTypedReferenceValue)"})
  public void testGeneralizeWithMultiTypedReferenceValue2() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = unknownReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link ReferenceValue#generalize(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashSet#HashSet()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(MultiTypedReferenceValue)"})
  public void testGeneralizeWithMultiTypedReferenceValue_givenNull_whenHashSetAddNull() {
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
   * Test {@link ReferenceValue#generalize(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(MultiTypedReferenceValue)"})
  public void testGeneralizeWithMultiTypedReferenceValue_thenReturnMultiTypedReferenceValue() {
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
   * Test {@link ReferenceValue#generalize(TracedReferenceValue)} with {@code TracedReferenceValue}.
   *
   * <p>Method under test: {@link ReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    TracedReferenceValue other =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = unknownReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link ReferenceValue#generalize(TracedReferenceValue)} with {@code TracedReferenceValue}.
   *
   * <p>Method under test: {@link ReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue2() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    TracedReferenceValue other =
        new TracedReferenceValue(
            new MultiTypedReferenceValue(
                new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = unknownReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link ReferenceValue#generalize(TypedReferenceValue)} with {@code TypedReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownReferenceValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue_thenReturnUnknownReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertSame(
        unknownReferenceValue,
        unknownReferenceValue.generalize(
            new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Test {@link ReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link MultiTypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue_thenReturnMultiTypedReferenceValue() {
    // Arrange
    MultiTypedReferenceValue multiTypedReferenceValue =
        new MultiTypedReferenceValue(
            new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act
    ReferenceValue actualGeneralizeResult =
        multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link ReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link TracedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue_thenReturnTracedReferenceValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link ReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownReferenceValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue_thenReturnUnknownReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    UnknownReferenceValue other = new UnknownReferenceValue();

    // Act and Assert
    assertSame(other, unknownReferenceValue.generalize(other));
  }

  /**
   * Test {@link ReferenceValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#UNKNOWN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#generalize(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value ReferenceValue.generalize(Value)"})
  public void testGeneralizeWithValue_givenReference_value_thenReturnUnknown_value() {
    // Arrange
    UnknownValue other = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.REFERENCE_VALUE.generalize(other));
  }

  /**
   * Test {@link ReferenceValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return {@link UnknownReferenceValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#generalize(Value)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value ReferenceValue.generalize(Value)"})
  public void testGeneralizeWithValue_whenReference_value_thenReturnUnknownReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertSame(
        unknownReferenceValue,
        unknownReferenceValue.generalize((Value) BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link ReferenceValue#equal(ArrayReferenceValue)} with {@code ArrayReferenceValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.equal(ArrayReferenceValue)"})
  public void testEqualWithArrayReferenceValue_thenReturnZero() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertEquals(
        0,
        unknownReferenceValue.equal(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link ReferenceValue#equal(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link ReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.equal(IdentifiedArrayReferenceValue)"})
  public void testEqualWithIdentifiedArrayReferenceValue() {
    // Arrange
    ArrayReferenceValue arrayReferenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        arrayReferenceValue.equal(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1)));
  }

  /**
   * Test {@link ReferenceValue#equal(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.equal(IdentifiedArrayReferenceValue)"})
  public void testEqualWithIdentifiedArrayReferenceValue_thenReturnNever() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        Value.NEVER,
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL.equal(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1)));
  }

  /**
   * Test {@link ReferenceValue#equal(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.equal(IdentifiedArrayReferenceValue)"})
  public void testEqualWithIdentifiedArrayReferenceValue_thenReturnZero() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        unknownReferenceValue.equal(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1)));
  }

  /**
   * Test {@link ReferenceValue#equal(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link ReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.equal(IdentifiedReferenceValue)"})
  public void testEqualWithIdentifiedReferenceValue() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue identifiedReferenceValue =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        identifiedReferenceValue.equal(
            new IdentifiedReferenceValue(
                "Type",
                referencedClass2,
                true,
                true,
                new ParticularReferenceValueFactory(),
                "Id")));
  }

  /**
   * Test {@link ReferenceValue#equal(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <ul>
   *   <li>Given {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.equal(IdentifiedReferenceValue)"})
  public void testEqualWithIdentifiedReferenceValue_givenReference_value_null_thenReturnZero() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL.equal(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Test {@link ReferenceValue#equal(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownReferenceValue} (default constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.equal(IdentifiedReferenceValue)"})
  public void testEqualWithIdentifiedReferenceValue_givenUnknownReferenceValue_thenReturnZero() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        unknownReferenceValue.equal(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Test {@link ReferenceValue#equal(MultiTypedReferenceValue)} with {@code
   * MultiTypedReferenceValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#equal(MultiTypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.equal(MultiTypedReferenceValue)"})
  public void testEqualWithMultiTypedReferenceValue_thenReturnZero() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals(
        0, unknownReferenceValue.equal(new MultiTypedReferenceValue(potentialTypes, true)));
  }

  /**
   * Test {@link ReferenceValue#equal(TracedReferenceValue)} with {@code TracedReferenceValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue_thenReturnZero() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertEquals(
        0,
        unknownReferenceValue.equal(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link ReferenceValue#equal(TypedReferenceValue)} with {@code TypedReferenceValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.equal(TypedReferenceValue)"})
  public void testEqualWithTypedReferenceValue_thenReturnZero() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertEquals(
        0,
        unknownReferenceValue.equal(
            new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Test {@link ReferenceValue#equal(UnknownReferenceValue)} with {@code UnknownReferenceValue}.
   *
   * <p>Method under test: {@link ReferenceValue#equal(UnknownReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.equal(UnknownReferenceValue)"})
  public void testEqualWithUnknownReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertEquals(0, unknownReferenceValue.equal(new UnknownReferenceValue()));
  }

  /**
   * Test {@link ReferenceValue#referenceValue()}.
   *
   * <p>Method under test: {@link ReferenceValue#referenceValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue ReferenceValue.referenceValue()"})
  public void testReferenceValue() {
    // Arrange
    UnknownReferenceValue unknownReferenceValue = new UnknownReferenceValue();

    // Act and Assert
    assertSame(unknownReferenceValue, unknownReferenceValue.referenceValue());
  }

  /**
   * Test {@link ReferenceValue#isNotNull()}.
   *
   * <p>Method under test: {@link ReferenceValue#isNotNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.isNotNull()"})
  public void testIsNotNull() {
    // Arrange, Act and Assert
    assertEquals(0, (new UnknownReferenceValue()).isNotNull());
  }

  /**
   * Test {@link ReferenceValue#notEqual(ReferenceValue)}.
   *
   * <p>Method under test: {@link ReferenceValue#notEqual(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.notEqual(ReferenceValue)"})
  public void testNotEqual() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .notEqual(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link ReferenceValue#notEqual(ReferenceValue)}.
   *
   * <p>Method under test: {@link ReferenceValue#notEqual(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.notEqual(ReferenceValue)"})
  public void testNotEqual2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        (new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1))
            .notEqual(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link ReferenceValue#notEqual(ReferenceValue)}.
   *
   * <p>Method under test: {@link ReferenceValue#notEqual(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.notEqual(ReferenceValue)"})
  public void testNotEqual3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        (new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"))
            .notEqual(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link ReferenceValue#notEqual(ReferenceValue)}.
   *
   * <ul>
   *   <li>Given {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#notEqual(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.notEqual(ReferenceValue)"})
  public void testNotEqual_givenReference_value_null_whenReference_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL.notEqual(
            BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link ReferenceValue#notEqual(ReferenceValue)}.
   *
   * <ul>
   *   <li>Given {@link UnknownReferenceValue} (default constructor).
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#notEqual(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.notEqual(ReferenceValue)"})
  public void testNotEqual_givenUnknownReferenceValue_whenReference_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new UnknownReferenceValue()).notEqual(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link ReferenceValue#computationalType()}.
   *
   * <p>Method under test: {@link ReferenceValue#computationalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ReferenceValue.computationalType()"})
  public void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(5, (new UnknownReferenceValue()).computationalType());
  }

  /**
   * Test {@link ReferenceValue#equals(Object)}, and {@link ReferenceValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReferenceValue#equals(Object)}
   *   <li>{@link ReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReferenceValue.equals(Object)", "int ReferenceValue.hashCode()"})
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
   * Test {@link ReferenceValue#equals(Object)}, and {@link ReferenceValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ReferenceValue#equals(Object)}
   *   <li>{@link ReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReferenceValue.equals(Object)", "int ReferenceValue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReferenceValue referenceValue = BasicValueFactory.REFERENCE_VALUE;

    // Act and Assert
    assertEquals(referenceValue, referenceValue);
    int expectedHashCodeResult = referenceValue.hashCode();
    assertEquals(expectedHashCodeResult, referenceValue.hashCode());
  }

  /**
   * Test {@link ReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReferenceValue.equals(Object)", "int ReferenceValue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
        BasicValueFactory.REFERENCE_VALUE);
  }

  /**
   * Test {@link ReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReferenceValue.equals(Object)", "int ReferenceValue.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BasicValueFactory.REFERENCE_VALUE, null);
  }

  /**
   * Test {@link ReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ReferenceValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ReferenceValue.equals(Object)", "int ReferenceValue.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BasicValueFactory.REFERENCE_VALUE, "Different type to ReferenceValue");
  }

  /**
   * Test {@link ReferenceValue#toString()}.
   *
   * <p>Method under test: {@link ReferenceValue#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String ReferenceValue.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("a", BasicValueFactory.REFERENCE_VALUE.toString());
  }
}
