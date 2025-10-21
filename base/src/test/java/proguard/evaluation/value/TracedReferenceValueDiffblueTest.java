package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.ReferenceTracingValueFactory;

public class TracedReferenceValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TracedReferenceValue#TracedReferenceValue(ReferenceValue, Value)}
   *   <li>{@link TracedReferenceValue#toString()}
   *   <li>{@link TracedReferenceValue#getReferenceValue()}
   *   <li>{@link TracedReferenceValue#getTraceValue()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TracedReferenceValue.<init>(ReferenceValue, Value)",
    "ReferenceValue TracedReferenceValue.getReferenceValue()",
    "Value TracedReferenceValue.getTraceValue()",
    "String TracedReferenceValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    ReferenceValue referenceValue = BasicValueFactory.REFERENCE_VALUE;
    IntegerValue traceValue = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act
    TracedReferenceValue actualTracedReferenceValue =
        new TracedReferenceValue(referenceValue, traceValue);
    String actualToStringResult = actualTracedReferenceValue.toString();
    ReferenceValue actualReferenceValue = actualTracedReferenceValue.getReferenceValue();

    // Assert
    assertEquals("ba", actualToStringResult);
    assertSame(traceValue, actualTracedReferenceValue.getTraceValue());
    assertSame(referenceValue, actualReferenceValue);
  }

  /**
   * Test {@link TracedReferenceValue#getType()}.
   *
   * <p>Method under test: {@link TracedReferenceValue#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TracedReferenceValue.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertEquals(
        "Ljava/lang/Object;",
        (new TracedReferenceValue(
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .getType());
  }

  /**
   * Test {@link TracedReferenceValue#getType()}.
   *
   * <ul>
   *   <li>Then return {@code Ljava/lang/Object;}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TracedReferenceValue.getType()"})
  public void testGetType_thenReturnLjavaLangObject() {
    // Arrange, Act and Assert
    assertEquals(
        "Ljava/lang/Object;",
        (new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .getType());
  }

  /**
   * Test {@link TracedReferenceValue#getReferencedClass()}.
   *
   * <p>Method under test: {@link TracedReferenceValue#getReferencedClass()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Clazz TracedReferenceValue.getReferencedClass()"})
  public void testGetReferencedClass() {
    // Arrange, Act and Assert
    assertNull(
        (new TracedReferenceValue(
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#getReferencedClass()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#getReferencedClass()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Clazz TracedReferenceValue.getReferencedClass()"})
  public void testGetReferencedClass_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#mayBeExtension()}.
   *
   * <p>Method under test: {@link TracedReferenceValue#mayBeExtension()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedReferenceValue.mayBeExtension()"})
  public void testMayBeExtension() {
    // Arrange, Act and Assert
    assertTrue(
        (new TracedReferenceValue(
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .mayBeExtension());
  }

  /**
   * Test {@link TracedReferenceValue#mayBeExtension()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#mayBeExtension()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedReferenceValue.mayBeExtension()"})
  public void testMayBeExtension_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new TracedReferenceValue(
                PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .mayBeExtension());
  }

  /**
   * Test {@link TracedReferenceValue#mayBeExtension()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#mayBeExtension()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedReferenceValue.mayBeExtension()"})
  public void testMayBeExtension_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .mayBeExtension());
  }

  /**
   * Test {@link TracedReferenceValue#isNull()}.
   *
   * <p>Method under test: {@link TracedReferenceValue#isNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.isNull()"})
  public void testIsNull() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new TracedReferenceValue(
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .isNull());
  }

  /**
   * Test {@link TracedReferenceValue#isNull()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#isNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.isNull()"})
  public void testIsNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .isNull());
  }

  /**
   * Test {@link TracedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <p>Method under test: {@link TracedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link TracedReferenceValue#instanceOf(String, Clazz)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.instanceOf(String, Clazz)"})
  public void testInstanceOf_thenReturnZero() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Test {@link TracedReferenceValue#arrayLength(ValueFactory)}.
   *
   * <p>Method under test: {@link TracedReferenceValue#arrayLength(ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue TracedReferenceValue.arrayLength(ValueFactory)"})
  public void testArrayLength() {
    // Arrange
    ArrayReferenceValue referenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(referenceValue, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(
        referenceValue.arrayLength,
        tracedReferenceValue.arrayLength(new ParticularReferenceValueFactory()));
  }

  /**
   * Test {@link TracedReferenceValue#arrayLength(ValueFactory)}.
   *
   * <p>Method under test: {@link TracedReferenceValue#arrayLength(ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue TracedReferenceValue.arrayLength(ValueFactory)"})
  public void testArrayLength2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.INTEGER_VALUE, tracedReferenceValue.arrayLength(valueFactory));
  }

  /**
   * Test {@link TracedReferenceValue#arrayLength(ValueFactory)}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#arrayLength(ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue TracedReferenceValue.arrayLength(ValueFactory)"})
  public void testArrayLength_thenReturnParticularReferenceValueFactoryInteger_value() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.INTEGER_VALUE, tracedReferenceValue.arrayLength(valueFactory));
  }

  /**
   * Test {@link TracedReferenceValue#arrayLength(ValueFactory)}.
   *
   * <ul>
   *   <li>When {@link DetailedArrayValueFactory#DetailedArrayValueFactory()}.
   *   <li>Then return {@link IdentifiedIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#arrayLength(ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue TracedReferenceValue.arrayLength(ValueFactory)"})
  public void testArrayLength_whenDetailedArrayValueFactory_thenReturnIdentifiedIntegerValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualArrayLengthResult =
        tracedReferenceValue.arrayLength(new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualArrayLengthResult instanceof IdentifiedIntegerValue);
    assertFalse(actualArrayLengthResult.isCategory2());
    assertFalse(actualArrayLengthResult.isParticular());
    assertTrue(actualArrayLengthResult.isSpecific());
  }

  /**
   * Test {@link TracedReferenceValue#integerArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <p>Method under test: {@link TracedReferenceValue#integerArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "IntegerValue TracedReferenceValue.integerArrayLoad(IntegerValue, ValueFactory)"
  })
  public void testIntegerArrayLoad() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.INTEGER_VALUE,
        tracedReferenceValue.integerArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Test {@link TracedReferenceValue#integerArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>Then return {@link IdentifiedIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#integerArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "IntegerValue TracedReferenceValue.integerArrayLoad(IntegerValue, ValueFactory)"
  })
  public void testIntegerArrayLoad_thenReturnIdentifiedIntegerValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualIntegerArrayLoadResult =
        tracedReferenceValue.integerArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualIntegerArrayLoadResult instanceof IdentifiedIntegerValue);
    assertFalse(actualIntegerArrayLoadResult.isCategory2());
    assertFalse(actualIntegerArrayLoadResult.isParticular());
    assertTrue(actualIntegerArrayLoadResult.isSpecific());
  }

  /**
   * Test {@link TracedReferenceValue#integerArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#integerArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "IntegerValue TracedReferenceValue.integerArrayLoad(IntegerValue, ValueFactory)"
  })
  public void testIntegerArrayLoad_thenReturnParticularReferenceValueFactoryInteger_value() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.INTEGER_VALUE,
        tracedReferenceValue.integerArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Test {@link TracedReferenceValue#longArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <p>Method under test: {@link TracedReferenceValue#longArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue TracedReferenceValue.longArrayLoad(IntegerValue, ValueFactory)"})
  public void testLongArrayLoad() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.LONG_VALUE,
        tracedReferenceValue.longArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Test {@link TracedReferenceValue#longArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#longArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue TracedReferenceValue.longArrayLoad(IntegerValue, ValueFactory)"})
  public void testLongArrayLoad_thenReturnParticularReferenceValueFactoryLong_value() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.LONG_VALUE,
        tracedReferenceValue.longArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Test {@link TracedReferenceValue#longArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>When {@link DetailedArrayValueFactory#DetailedArrayValueFactory()}.
   *   <li>Then return {@link IdentifiedLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#longArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue TracedReferenceValue.longArrayLoad(IntegerValue, ValueFactory)"})
  public void testLongArrayLoad_whenDetailedArrayValueFactory_thenReturnIdentifiedLongValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualLongArrayLoadResult =
        tracedReferenceValue.longArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualLongArrayLoadResult instanceof IdentifiedLongValue);
    assertFalse(actualLongArrayLoadResult.isParticular());
    assertTrue(actualLongArrayLoadResult.isCategory2());
    assertTrue(actualLongArrayLoadResult.isSpecific());
  }

  /**
   * Test {@link TracedReferenceValue#floatArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <p>Method under test: {@link TracedReferenceValue#floatArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue TracedReferenceValue.floatArrayLoad(IntegerValue, ValueFactory)"})
  public void testFloatArrayLoad() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.FLOAT_VALUE,
        tracedReferenceValue.floatArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Test {@link TracedReferenceValue#floatArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#floatArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue TracedReferenceValue.floatArrayLoad(IntegerValue, ValueFactory)"})
  public void testFloatArrayLoad_thenReturnParticularReferenceValueFactoryFloat_value() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.FLOAT_VALUE,
        tracedReferenceValue.floatArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Test {@link TracedReferenceValue#floatArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>When {@link DetailedArrayValueFactory#DetailedArrayValueFactory()}.
   *   <li>Then return {@link IdentifiedFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#floatArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue TracedReferenceValue.floatArrayLoad(IntegerValue, ValueFactory)"})
  public void testFloatArrayLoad_whenDetailedArrayValueFactory_thenReturnIdentifiedFloatValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    FloatValue actualFloatArrayLoadResult =
        tracedReferenceValue.floatArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualFloatArrayLoadResult instanceof IdentifiedFloatValue);
    assertFalse(actualFloatArrayLoadResult.isCategory2());
    assertFalse(actualFloatArrayLoadResult.isParticular());
    assertTrue(actualFloatArrayLoadResult.isSpecific());
  }

  /**
   * Test {@link TracedReferenceValue#doubleArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <p>Method under test: {@link TracedReferenceValue#doubleArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "DoubleValue TracedReferenceValue.doubleArrayLoad(IntegerValue, ValueFactory)"
  })
  public void testDoubleArrayLoad() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.DOUBLE_VALUE,
        tracedReferenceValue.doubleArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Test {@link TracedReferenceValue#doubleArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>Then return {@link IdentifiedDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#doubleArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "DoubleValue TracedReferenceValue.doubleArrayLoad(IntegerValue, ValueFactory)"
  })
  public void testDoubleArrayLoad_thenReturnIdentifiedDoubleValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    DoubleValue actualDoubleArrayLoadResult =
        tracedReferenceValue.doubleArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new DetailedArrayValueFactory());

    // Assert
    assertTrue(actualDoubleArrayLoadResult instanceof IdentifiedDoubleValue);
    assertFalse(actualDoubleArrayLoadResult.isParticular());
    assertTrue(actualDoubleArrayLoadResult.isCategory2());
    assertTrue(actualDoubleArrayLoadResult.isSpecific());
  }

  /**
   * Test {@link TracedReferenceValue#doubleArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#doubleArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "DoubleValue TracedReferenceValue.doubleArrayLoad(IntegerValue, ValueFactory)"
  })
  public void testDoubleArrayLoad_thenReturnParticularReferenceValueFactoryDouble_value() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.DOUBLE_VALUE,
        tracedReferenceValue.doubleArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Test {@link TracedReferenceValue#referenceArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <p>Method under test: {@link TracedReferenceValue#referenceArrayLoad(IntegerValue,
   * ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TracedReferenceValue.referenceArrayLoad(IntegerValue, ValueFactory)"
  })
  public void testReferenceArrayLoad() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new MultiTypedReferenceValue(
                new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory valueFactory2 =
        new ReferenceTracingValueFactory(valueFactory, true);
    valueFactory2.setTraceValue(null);

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        tracedReferenceValue.referenceArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory2));
  }

  /**
   * Test {@link TracedReferenceValue#referenceArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link TracedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#referenceArrayLoad(IntegerValue,
   * ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TracedReferenceValue.referenceArrayLoad(IntegerValue, ValueFactory)"
  })
  public void testReferenceArrayLoad_givenInteger_value_byte_thenReturnTracedReferenceValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    ReferenceTracingValueFactory valueFactory =
        new ReferenceTracingValueFactory(new ParticularReferenceValueFactory(), true);
    valueFactory.setTraceValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualReferenceArrayLoadResult =
        tracedReferenceValue.referenceArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory);

    // Assert
    assertTrue(actualReferenceArrayLoadResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualReferenceArrayLoadResult);
  }

  /**
   * Test {@link TracedReferenceValue#referenceArrayLoad(IntegerValue, ValueFactory)}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#referenceArrayLoad(IntegerValue,
   * ValueFactory)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TracedReferenceValue.referenceArrayLoad(IntegerValue, ValueFactory)"
  })
  public void testReferenceArrayLoad_thenReturnParticularReferenceValueFactoryReference_value() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    ReferenceTracingValueFactory valueFactory2 =
        new ReferenceTracingValueFactory(valueFactory, true);
    valueFactory2.setTraceValue(null);

    // Act and Assert
    assertSame(
        valueFactory.REFERENCE_VALUE,
        tracedReferenceValue.referenceArrayLoad(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory2));
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ArrayReferenceValue)} with {@code
   * ArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ArrayReferenceValue)"})
  public void testGeneralizeWithArrayReferenceValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ArrayReferenceValue)} with {@code
   * ArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ArrayReferenceValue)"})
  public void testGeneralizeWithArrayReferenceValue2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ArrayReferenceValue)} with {@code
   * ArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ArrayReferenceValue)"})
  public void testGeneralizeWithArrayReferenceValue3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue referenceValue =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);

    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(referenceValue, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    Clazz referencedClass2 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue2 =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue2 instanceof TypedReferenceValue);
    IntegerValue expectedTraceValue = referenceValue.arrayLength;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualGeneralizeResult).getTraceValue());
    assertSame(referencedClass2, referenceValue2.getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ArrayReferenceValue)} with {@code
   * ArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ArrayReferenceValue)"})
  public void testGeneralizeWithArrayReferenceValue4() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new MultiTypedReferenceValue(
                new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ArrayReferenceValue)} with {@code
   * ArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ArrayReferenceValue)"})
  public void testGeneralizeWithArrayReferenceValue5() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ArrayReferenceValue)} with {@code
   * ArrayReferenceValue}.
   *
   * <ul>
   *   <li>Then return ReferenceValue Null is zero.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ArrayReferenceValue)"})
  public void testGeneralizeWithArrayReferenceValue_thenReturnReferenceValueNullIsZero() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    Clazz referencedClass = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals(0, referenceValue.isNull());
    assertTrue(((TypedReferenceValue) referenceValue).mayBeNull);
    assertSame(referencedClass, referenceValue.getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TracedReferenceValue.generalize(IdentifiedArrayReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedArrayReferenceValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TracedReferenceValue.generalize(IdentifiedArrayReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedArrayReferenceValue2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1));

    // Assert
    Clazz referencedClass2 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals(0, referenceValue.isNull());
    assertTrue(((TypedReferenceValue) referenceValue).mayBeNull);
    assertSame(referencedClass2, referenceValue.getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TracedReferenceValue.generalize(IdentifiedArrayReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedArrayReferenceValue3() {
    // Arrange
    ArrayReferenceValue referenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(referenceValue, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1));

    // Assert
    Clazz referencedClass2 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue2 =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue2 instanceof TypedReferenceValue);
    IntegerValue expectedTraceValue = referenceValue.arrayLength;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualGeneralizeResult).getTraceValue());
    assertSame(referencedClass2, referenceValue2.getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TracedReferenceValue.generalize(IdentifiedArrayReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedArrayReferenceValue4() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new MultiTypedReferenceValue(
                new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TracedReferenceValue.generalize(IdentifiedArrayReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedArrayReferenceValue5() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <ul>
   *   <li>Then return NotNull is one.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ReferenceValue TracedReferenceValue.generalize(IdentifiedArrayReferenceValue)"
  })
  public void testGeneralizeWithIdentifiedArrayReferenceValue_thenReturnNotNullIsOne() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass2,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1));

    // Assert
    Clazz referencedClass3 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass3 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertEquals(1, referenceValue.isNotNull());
    assertFalse(((TypedReferenceValue) referenceValue).mayBeNull);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertEquals(Value.NEVER, referenceValue.isNull());
    assertSame(referencedClass3, referenceValue.getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(IdentifiedReferenceValue)"})
  public void testGeneralizeWithIdentifiedReferenceValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(IdentifiedReferenceValue)"})
  public void testGeneralizeWithIdentifiedReferenceValue2() {
    // Arrange
    ArrayReferenceValue referenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(referenceValue, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    Clazz referencedClass2 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue2 =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue2 instanceof TypedReferenceValue);
    IntegerValue expectedTraceValue = referenceValue.arrayLength;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualGeneralizeResult).getTraceValue());
    assertSame(referencedClass2, referenceValue2.getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(IdentifiedReferenceValue)"})
  public void testGeneralizeWithIdentifiedReferenceValue3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new IdentifiedReferenceValue(
                "Type", referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    Clazz referencedClass3 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass3 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertSame(referencedClass3, referenceValue.getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(IdentifiedReferenceValue)"})
  public void testGeneralizeWithIdentifiedReferenceValue4() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new MultiTypedReferenceValue(
                new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(IdentifiedReferenceValue)"})
  public void testGeneralizeWithIdentifiedReferenceValue5() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <ul>
   *   <li>Then return Specific.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(IdentifiedReferenceValue)"})
  public void testGeneralizeWithIdentifiedReferenceValue_thenReturnSpecific() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue other =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertTrue(actualGeneralizeResult.isSpecific());
    assertSame(other, ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue() {
    // Arrange
    TypedReferenceValue type = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        (new TracedReferenceValue(
                new MultiTypedReferenceValue(type, true),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    Clazz referencedClass = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertSame(type, ((MultiTypedReferenceValue) referenceValue).getGeneralizedType());
    assertSame(referencedClass, referenceValue.getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue2() {
    // Arrange
    ReferenceValue other = BasicValueFactory.REFERENCE_VALUE;

    // Act
    ReferenceValue actualGeneralizeResult =
        (new TracedReferenceValue(
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TracedReferenceValue);
    ReferenceValue referenceValue2 = ((TracedReferenceValue) referenceValue).getReferenceValue();
    assertTrue(referenceValue2 instanceof UnknownReferenceValue);
    assertSame(other, referenceValue2);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue4() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue5() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue6() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(other, tracedReferenceValue.generalize((ReferenceValue) other));
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue7() {
    // Arrange and Act
    ReferenceValue actualGeneralizeResult =
        (new TracedReferenceValue(
                new MultiTypedReferenceValue(
                    new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    Clazz referencedClass = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(
        referencedClass,
        ((MultiTypedReferenceValue) referenceValue).getGeneralizedType().getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue8() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new MultiTypedReferenceValue(
                new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    Clazz referencedClass = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(
        referencedClass,
        ((MultiTypedReferenceValue) referenceValue).getGeneralizedType().getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue9() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new MultiTypedReferenceValue(
                new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id"));

    // Assert
    Clazz referencedClass2 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertSame(referencedClass2, referenceValue.getReferencedClass());
    assertSame(
        referencedClass2,
        ((MultiTypedReferenceValue) referenceValue).getGeneralizedType().getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue10() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue11() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ArrayReferenceValue other =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TracedReferenceValue);
    assertTrue(
        ((TracedReferenceValue) referenceValue).getReferenceValue()
            instanceof UnknownReferenceValue);
    IntegerValue expectedTraceValue = other.arrayLength;
    assertSame(expectedTraceValue, ((TracedReferenceValue) referenceValue).getTraceValue());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue12() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedArrayReferenceValue other =
        new IdentifiedArrayReferenceValue(
            "Type",
            referencedClass,
            true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ParticularReferenceValueFactory(),
            1);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TracedReferenceValue);
    assertTrue(
        ((TracedReferenceValue) referenceValue).getReferenceValue()
            instanceof UnknownReferenceValue);
    IntegerValue expectedTraceValue = other.arrayLength;
    assertSame(expectedTraceValue, ((TracedReferenceValue) referenceValue).getTraceValue());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue13() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type", referencedClass, true, true, valuefactory, "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TracedReferenceValue);
    ReferenceValue referenceValue2 = ((TracedReferenceValue) referenceValue).getReferenceValue();
    assertTrue(referenceValue2 instanceof UnknownReferenceValue);
    assertSame(valuefactory.REFERENCE_VALUE, referenceValue2);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue14() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue15() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue16() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue17() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue18() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1));

    // Assert
    Clazz referencedClass3 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass3 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertEquals(1, referenceValue.isNotNull());
    assertFalse(((TypedReferenceValue) referenceValue).mayBeNull);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertEquals(Value.NEVER, referenceValue.isNull());
    assertSame(referencedClass3, referenceValue.getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue19() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id"));

    // Assert
    Clazz referencedClass3 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass3 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals(0, referenceValue.isNull());
    assertSame(referencedClass3, referenceValue.getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return NotNull is one.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnNotNullIsOne() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1));

    // Assert
    Clazz referencedClass2 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertEquals(1, referenceValue.isNotNull());
    assertFalse(((TypedReferenceValue) referenceValue).mayBeNull);
    assertEquals(Value.NEVER, actualGeneralizeResult.isNull());
    assertEquals(Value.NEVER, referenceValue.isNull());
    assertSame(referencedClass2, referenceValue.getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return ReferenceValue Null is zero.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnReferenceValueNullIsZero() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    Clazz referencedClass = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals(0, referenceValue.isNull());
    assertSame(referencedClass, referenceValue.getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return Specific.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_thenReturnSpecific() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();
    IdentifiedReferenceValue other =
        new IdentifiedReferenceValue(
            "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id");

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertTrue(actualGeneralizeResult.isSpecific());
    assertSame(other, ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_whenReference_value() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(ReferenceValue)"})
  public void testGeneralizeWithReferenceValue_whenReference_value_null() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(
        tracedReferenceValue,
        tracedReferenceValue.generalize(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue4() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new MultiTypedReferenceValue(
                new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    Clazz referencedClass = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(
        referencedClass,
        ((MultiTypedReferenceValue) referenceValue).getGeneralizedType().getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue5() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(0, referenceValue.isNull());
    assertFalse(referenceValue.isParticular());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue6() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue7() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new TracedReferenceValue(
                new MultiTypedReferenceValue(
                    new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    Clazz referencedClass = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(
        referencedClass,
        ((MultiTypedReferenceValue) referenceValue).getGeneralizedType().getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue8() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other =
        new TracedReferenceValue(
            TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue9() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new TracedReferenceValue(
                TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/Object;", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(0, referenceValue.isNull());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(((TypedReferenceValue) referenceValue).mayBeExtension);
    assertTrue(((TypedReferenceValue) referenceValue).mayBeNull);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue10() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue11() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new TracedReferenceValue(
                new MultiTypedReferenceValue(
                    new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    Clazz referencedClass = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(
        referencedClass,
        ((MultiTypedReferenceValue) referenceValue).getGeneralizedType().getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue12() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue13() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                new MultiTypedReferenceValue(
                    new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue14() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new TracedReferenceValue(
                PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue15() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue16() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue17() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue18() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new MultiTypedReferenceValue(
                new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new TracedReferenceValue(
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    Clazz referencedClass = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertSame(referencedClass, referenceValue.getReferencedClass());
    assertSame(
        referencedClass,
        ((MultiTypedReferenceValue) referenceValue).getGeneralizedType().getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue19() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new MultiTypedReferenceValue(
                new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new TracedReferenceValue(
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    Clazz referencedClass2 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertSame(referencedClass2, referenceValue.getReferencedClass());
    assertSame(
        referencedClass2,
        ((MultiTypedReferenceValue) referenceValue).getGeneralizedType().getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue20() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new MultiTypedReferenceValue(
                new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new TracedReferenceValue(
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id"),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    Clazz referencedClass2 = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass2 instanceof LibraryClass);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertSame(referencedClass2, referenceValue.getReferencedClass());
    assertSame(
        referencedClass2,
        ((MultiTypedReferenceValue) referenceValue).getGeneralizedType().getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue21() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.REFERENCE_VALUE);
    TracedReferenceValue other =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.UNKNOWN_VALUE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue22() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, InstructionOffsetValue.EMPTY_VALUE);
    TracedReferenceValue other =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.UNKNOWN_VALUE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TracedReferenceValue)"})
  public void testGeneralizeWithTracedReferenceValue23() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, InstructionOffsetValue.EMPTY_VALUE);

    // Act and Assert
    assertSame(
        tracedReferenceValue,
        tracedReferenceValue.generalize(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, InstructionOffsetValue.EMPTY_VALUE)));
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue2() {
    // Arrange
    ArrayReferenceValue referenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(referenceValue, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue2 =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue2 instanceof TypedReferenceValue);
    assertEquals(other, referenceValue2);
    IntegerValue expectedTraceValue = referenceValue.arrayLength;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualGeneralizeResult).getTraceValue());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new MultiTypedReferenceValue(
                new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue4() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <ul>
   *   <li>Then ReferencedClass return {@link LibraryClass}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(TypedReferenceValue)"})
  public void testGeneralizeWithTypedReferenceValue_thenReferencedClassReturnLibraryClass() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TypedReferenceValue other = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult.getReferencedClass() instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertSame(other, ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue() {
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
   * Test {@link TracedReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new MultiTypedReferenceValue(
                new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracedReferenceValue.generalize(UnknownReferenceValue)"})
  public void testGeneralizeWithUnknownReferenceValue3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#equal(ArrayReferenceValue)} with {@code ArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ArrayReferenceValue)"})
  public void testEqualWithArrayReferenceValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ArrayReferenceValue)} with {@code ArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ArrayReferenceValue)"})
  public void testEqualWithArrayReferenceValue2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ArrayReferenceValue)} with {@code ArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ArrayReferenceValue)"})
  public void testEqualWithArrayReferenceValue3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ArrayReferenceValue)} with {@code ArrayReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ArrayReferenceValue)"})
  public void testEqualWithArrayReferenceValue_thenReturnNever() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        Value.NEVER,
        tracedReferenceValue.equal(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(IdentifiedArrayReferenceValue)"})
  public void testEqualWithIdentifiedArrayReferenceValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(IdentifiedArrayReferenceValue)"})
  public void testEqualWithIdentifiedArrayReferenceValue2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(IdentifiedArrayReferenceValue)"})
  public void testEqualWithIdentifiedArrayReferenceValue3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass2,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(IdentifiedArrayReferenceValue)"})
  public void testEqualWithIdentifiedArrayReferenceValue4() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(IdentifiedArrayReferenceValue)"})
  public void testEqualWithIdentifiedArrayReferenceValue_thenReturnNever() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        Value.NEVER,
        tracedReferenceValue.equal(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(IdentifiedReferenceValue)"})
  public void testEqualWithIdentifiedReferenceValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Test {@link TracedReferenceValue#equal(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(IdentifiedReferenceValue)"})
  public void testEqualWithIdentifiedReferenceValue2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Test {@link TracedReferenceValue#equal(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(IdentifiedReferenceValue)"})
  public void testEqualWithIdentifiedReferenceValue3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new IdentifiedReferenceValue(
                "Type",
                referencedClass2,
                true,
                true,
                new ParticularReferenceValueFactory(),
                "Id")));
  }

  /**
   * Test {@link TracedReferenceValue#equal(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(IdentifiedReferenceValue)"})
  public void testEqualWithIdentifiedReferenceValue4() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id")));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            (ReferenceValue)
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id")));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue4() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            (ReferenceValue)
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue5() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue6() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            (ReferenceValue)
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue7() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id")));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue8() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            (ReferenceValue)
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue9() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue10() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            (ReferenceValue)
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue11() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            (ReferenceValue)
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue12() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id")));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue13() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id")));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_thenReturnNever() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        Value.NEVER,
        tracedReferenceValue.equal(
            (ReferenceValue)
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        (new TracedReferenceValue(
                PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value2() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new TracedReferenceValue(
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value_null() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(ReferenceValue)"})
  public void testEqualWithReferenceValue_whenReference_value_null2() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new TracedReferenceValue(
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue4() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue5() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue6() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new MultiTypedReferenceValue(
                new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue7() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue8() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TracedReferenceValue(
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue9() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TracedReferenceValue(
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue10() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TracedReferenceValue(
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue11() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TracedReferenceValue(
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue12() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TracedReferenceValue(
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue13() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new IdentifiedArrayReferenceValue(
                "Type",
                referencedClass,
                true,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                new ParticularReferenceValueFactory(),
                1),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TracedReferenceValue(
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue14() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TracedReferenceValue(
                PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue15() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new IdentifiedReferenceValue(
                "Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TracedReferenceValue(
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue_thenReturnNever() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new ArrayReferenceValue(
                "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        Value.NEVER,
        tracedReferenceValue.equal(
            new TracedReferenceValue(
                PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TracedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TracedReferenceValue)"})
  public void testEqualWithTracedReferenceValue_thenReturnOne() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        1,
        tracedReferenceValue.equal(
            new TracedReferenceValue(
                PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TypedReferenceValue)} with {@code TypedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TypedReferenceValue)"})
  public void testEqualWithTypedReferenceValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TypedReferenceValue)} with {@code TypedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TypedReferenceValue)"})
  public void testEqualWithTypedReferenceValue2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(TypedReferenceValue)} with {@code TypedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(TypedReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(TypedReferenceValue)"})
  public void testEqualWithTypedReferenceValue3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        tracedReferenceValue.equal(
            new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(UnknownReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(UnknownReferenceValue)"})
  public void testEqualWithUnknownReferenceValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal(new UnknownReferenceValue()));
  }

  /**
   * Test {@link TracedReferenceValue#equal(UnknownReferenceValue)} with {@code
   * UnknownReferenceValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(UnknownReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracedReferenceValue.equal(UnknownReferenceValue)"})
  public void testEqualWithUnknownReferenceValue_thenReturnZero() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, tracedReferenceValue.equal(new UnknownReferenceValue()));
  }

  /**
   * Test {@link TracedReferenceValue#isSpecific()}.
   *
   * <p>Method under test: {@link TracedReferenceValue#isSpecific()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedReferenceValue.isSpecific()"})
  public void testIsSpecific() {
    // Arrange, Act and Assert
    assertFalse(
        (new TracedReferenceValue(
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .isSpecific());
  }

  /**
   * Test {@link TracedReferenceValue#isSpecific()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#isSpecific()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedReferenceValue.isSpecific()"})
  public void testIsSpecific_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .isSpecific());
  }

  /**
   * Test {@link TracedReferenceValue#isSpecific()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#isSpecific()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedReferenceValue.isSpecific()"})
  public void testIsSpecific_thenReturnTrue() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertTrue(
        (new TracedReferenceValue(
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .isSpecific());
  }

  /**
   * Test {@link TracedReferenceValue#isParticular()}.
   *
   * <p>Method under test: {@link TracedReferenceValue#isParticular()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedReferenceValue.isParticular()"})
  public void testIsParticular() {
    // Arrange, Act and Assert
    assertFalse(
        (new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .isParticular());
  }

  /**
   * Test {@link TracedReferenceValue#isParticular()}.
   *
   * <p>Method under test: {@link TracedReferenceValue#isParticular()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedReferenceValue.isParticular()"})
  public void testIsParticular2() {
    // Arrange, Act and Assert
    assertFalse(
        (new TracedReferenceValue(
                new MultiTypedReferenceValue(
                    new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .isParticular());
  }

  /**
   * Test {@link TracedReferenceValue#isParticular()}.
   *
   * <p>Method under test: {@link TracedReferenceValue#isParticular()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedReferenceValue.isParticular()"})
  public void testIsParticular3() {
    // Arrange, Act and Assert
    assertFalse(
        (new TracedReferenceValue(
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .isParticular());
  }

  /**
   * Test {@link TracedReferenceValue#isParticular()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#isParticular()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracedReferenceValue.isParticular()"})
  public void testIsParticular_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new TracedReferenceValue(
                PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .isParticular());
  }

  /**
   * Test {@link TracedReferenceValue#internalType()}.
   *
   * <p>Method under test: {@link TracedReferenceValue#internalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TracedReferenceValue.internalType()"})
  public void testInternalType() {
    // Arrange, Act and Assert
    assertEquals(
        "Ljava/lang/Object;",
        (new TracedReferenceValue(
                new TracedReferenceValue(
                    BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .internalType());
  }

  /**
   * Test {@link TracedReferenceValue#internalType()}.
   *
   * <ul>
   *   <li>Then return {@code Ljava/lang/Object;}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#internalType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TracedReferenceValue.internalType()"})
  public void testInternalType_thenReturnLjavaLangObject() {
    // Arrange, Act and Assert
    assertEquals(
        "Ljava/lang/Object;",
        (new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .internalType());
  }

  /**
   * Test {@link TracedReferenceValue#equals(Object)}, and {@link TracedReferenceValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TracedReferenceValue#equals(Object)}
   *   <li>{@link TracedReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TracedReferenceValue.equals(Object)",
    "int TracedReferenceValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue tracedReferenceValue2 =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(tracedReferenceValue, tracedReferenceValue2);
    int expectedHashCodeResult = tracedReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, tracedReferenceValue2.hashCode());
  }

  /**
   * Test {@link TracedReferenceValue#equals(Object)}, and {@link TracedReferenceValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TracedReferenceValue#equals(Object)}
   *   <li>{@link TracedReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TracedReferenceValue.equals(Object)",
    "int TracedReferenceValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(tracedReferenceValue, tracedReferenceValue);
    int expectedHashCodeResult = tracedReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, tracedReferenceValue.hashCode());
  }

  /**
   * Test {@link TracedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TracedReferenceValue.equals(Object)",
    "int TracedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(
        tracedReferenceValue,
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link TracedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TracedReferenceValue.equals(Object)",
    "int TracedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(
        tracedReferenceValue,
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link TracedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TracedReferenceValue.equals(Object)",
    "int TracedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(
        tracedReferenceValue,
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link TracedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TracedReferenceValue.equals(Object)",
    "int TracedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        null);
  }

  /**
   * Test {@link TracedReferenceValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean TracedReferenceValue.equals(Object)",
    "int TracedReferenceValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to TracedReferenceValue");
  }
}
