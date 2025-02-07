package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.ReferenceTracingValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;

class TracedReferenceValueDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.TracedReferenceValue.<init>(proguard.evaluation.value.ReferenceValue, proguard.evaluation.value.Value)",
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.getReferenceValue()",
    "proguard.evaluation.value.Value proguard.evaluation.value.TracedReferenceValue.getTraceValue()",
    "java.lang.String proguard.evaluation.value.TracedReferenceValue.toString()"
  })
  void testGettersAndSetters() {
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
  @DisplayName("Test getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.evaluation.value.TracedReferenceValue.getType()"})
  void testGetType() {
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
  @DisplayName("Test getType(); then return 'Ljava/lang/Object;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.evaluation.value.TracedReferenceValue.getType()"})
  void testGetType_thenReturnLjavaLangObject() {
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
  @DisplayName("Test getReferencedClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Clazz proguard.evaluation.value.TracedReferenceValue.getReferencedClass()"
  })
  void testGetReferencedClass() {
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
  @DisplayName("Test getReferencedClass(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.Clazz proguard.evaluation.value.TracedReferenceValue.getReferencedClass()"
  })
  void testGetReferencedClass_thenReturnNull() {
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
  @DisplayName("Test mayBeExtension()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.TracedReferenceValue.mayBeExtension()"})
  void testMayBeExtension() {
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
  @DisplayName("Test mayBeExtension(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.TracedReferenceValue.mayBeExtension()"})
  void testMayBeExtension_thenReturnFalse() {
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
  @DisplayName("Test mayBeExtension(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.TracedReferenceValue.mayBeExtension()"})
  void testMayBeExtension_thenReturnTrue() {
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
  @DisplayName("Test isNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.evaluation.value.TracedReferenceValue.isNull()"})
  void testIsNull() {
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
  @DisplayName("Test isNull(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.evaluation.value.TracedReferenceValue.isNull()"})
  void testIsNull_thenReturnZero() {
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
  @DisplayName("Test instanceOf(String, Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.instanceOf(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceOf() {
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
  @DisplayName("Test instanceOf(String, Clazz); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.instanceOf(java.lang.String, proguard.classfile.Clazz)"
  })
  void testInstanceOf_thenReturnZero() {
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
  @DisplayName("Test arrayLength(ValueFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.TracedReferenceValue.arrayLength(proguard.evaluation.value.ValueFactory)"
  })
  void testArrayLength() {
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
  @DisplayName("Test arrayLength(ValueFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.TracedReferenceValue.arrayLength(proguard.evaluation.value.ValueFactory)"
  })
  void testArrayLength2() {
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
  @DisplayName(
      "Test arrayLength(ValueFactory); then return ParticularReferenceValueFactory (default constructor) INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.TracedReferenceValue.arrayLength(proguard.evaluation.value.ValueFactory)"
  })
  void testArrayLength_thenReturnParticularReferenceValueFactoryInteger_value() {
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
  @DisplayName(
      "Test arrayLength(ValueFactory); when DetailedArrayValueFactory(); then return IdentifiedIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.TracedReferenceValue.arrayLength(proguard.evaluation.value.ValueFactory)"
  })
  void testArrayLength_whenDetailedArrayValueFactory_thenReturnIdentifiedIntegerValue() {
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
  @DisplayName("Test integerArrayLoad(IntegerValue, ValueFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.TracedReferenceValue.integerArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testIntegerArrayLoad() {
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
  @DisplayName(
      "Test integerArrayLoad(IntegerValue, ValueFactory); then return IdentifiedIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.TracedReferenceValue.integerArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testIntegerArrayLoad_thenReturnIdentifiedIntegerValue() {
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
  @DisplayName(
      "Test integerArrayLoad(IntegerValue, ValueFactory); then return ParticularReferenceValueFactory (default constructor) INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.TracedReferenceValue.integerArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testIntegerArrayLoad_thenReturnParticularReferenceValueFactoryInteger_value() {
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
  @DisplayName("Test longArrayLoad(IntegerValue, ValueFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.TracedReferenceValue.longArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testLongArrayLoad() {
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
  @DisplayName(
      "Test longArrayLoad(IntegerValue, ValueFactory); then return ParticularReferenceValueFactory (default constructor) LONG_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.TracedReferenceValue.longArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testLongArrayLoad_thenReturnParticularReferenceValueFactoryLong_value() {
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
  @DisplayName(
      "Test longArrayLoad(IntegerValue, ValueFactory); when DetailedArrayValueFactory(); then return IdentifiedLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.TracedReferenceValue.longArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testLongArrayLoad_whenDetailedArrayValueFactory_thenReturnIdentifiedLongValue() {
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
  @DisplayName("Test floatArrayLoad(IntegerValue, ValueFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.TracedReferenceValue.floatArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testFloatArrayLoad() {
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
  @DisplayName(
      "Test floatArrayLoad(IntegerValue, ValueFactory); then return ParticularReferenceValueFactory (default constructor) FLOAT_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.TracedReferenceValue.floatArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testFloatArrayLoad_thenReturnParticularReferenceValueFactoryFloat_value() {
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
  @DisplayName(
      "Test floatArrayLoad(IntegerValue, ValueFactory); when DetailedArrayValueFactory(); then return IdentifiedFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.TracedReferenceValue.floatArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testFloatArrayLoad_whenDetailedArrayValueFactory_thenReturnIdentifiedFloatValue() {
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
  @DisplayName("Test doubleArrayLoad(IntegerValue, ValueFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.TracedReferenceValue.doubleArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testDoubleArrayLoad() {
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
  @DisplayName(
      "Test doubleArrayLoad(IntegerValue, ValueFactory); then return IdentifiedDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.TracedReferenceValue.doubleArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testDoubleArrayLoad_thenReturnIdentifiedDoubleValue() {
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
  @DisplayName(
      "Test doubleArrayLoad(IntegerValue, ValueFactory); then return ParticularReferenceValueFactory (default constructor) DOUBLE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.TracedReferenceValue.doubleArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testDoubleArrayLoad_thenReturnParticularReferenceValueFactoryDouble_value() {
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
  @DisplayName("Test referenceArrayLoad(IntegerValue, ValueFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.referenceArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testReferenceArrayLoad() {
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
  @DisplayName(
      "Test referenceArrayLoad(IntegerValue, ValueFactory); given INTEGER_VALUE_BYTE; then return TracedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.referenceArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testReferenceArrayLoad_givenInteger_value_byte_thenReturnTracedReferenceValue() {
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
  @DisplayName(
      "Test referenceArrayLoad(IntegerValue, ValueFactory); then return ParticularReferenceValueFactory (default constructor) REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.referenceArrayLoad(proguard.evaluation.value.IntegerValue, proguard.evaluation.value.ValueFactory)"
  })
  void testReferenceArrayLoad_thenReturnParticularReferenceValueFactoryReference_value() {
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
  @DisplayName("Test generalize(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testGeneralizeWithArrayReferenceValue() {
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
  @DisplayName("Test generalize(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testGeneralizeWithArrayReferenceValue2() {
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
  @DisplayName("Test generalize(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testGeneralizeWithArrayReferenceValue3() {
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
  @DisplayName("Test generalize(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testGeneralizeWithArrayReferenceValue4() {
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
  @DisplayName("Test generalize(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testGeneralizeWithArrayReferenceValue5() {
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
  @DisplayName(
      "Test generalize(ArrayReferenceValue) with 'ArrayReferenceValue'; then return ReferenceValue Null is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testGeneralizeWithArrayReferenceValue_thenReturnReferenceValueNullIsZero() {
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
   * Test {@link TracedReferenceValue#generalize(DetailedArrayReferenceValue)} with {@code
   * DetailedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(DetailedArrayReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(DetailedArrayReferenceValue) with 'DetailedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.DetailedArrayReferenceValue)"
  })
  void testGeneralizeWithDetailedArrayReferenceValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    DetailedArrayReferenceValue other = mock(DetailedArrayReferenceValue.class);
    when(other.generalize(Mockito.<UnknownReferenceValue>any()))
        .thenReturn(BasicValueFactory.REFERENCE_VALUE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    verify(other).generalize(isA(UnknownReferenceValue.class));
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(DetailedArrayReferenceValue)} with {@code
   * DetailedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(DetailedArrayReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(DetailedArrayReferenceValue) with 'DetailedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.DetailedArrayReferenceValue)"
  })
  void testGeneralizeWithDetailedArrayReferenceValue2() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(mock(DetailedArrayReferenceValue.class));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(DetailedArrayReferenceValue)} with {@code
   * DetailedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(DetailedArrayReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(DetailedArrayReferenceValue) with 'DetailedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.DetailedArrayReferenceValue)"
  })
  void testGeneralizeWithDetailedArrayReferenceValue3() {
    // Arrange
    ArrayReferenceValue referenceValue =
        new ArrayReferenceValue(
            "Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        (new TracedReferenceValue(referenceValue, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(mock(DetailedArrayReferenceValue.class));

    // Assert
    Clazz referencedClass = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue2 =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue2 instanceof TypedReferenceValue);
    IntegerValue expectedTraceValue = referenceValue.arrayLength;
    assertSame(expectedTraceValue, ((TracedReferenceValue) actualGeneralizeResult).getTraceValue());
    assertSame(referencedClass, referenceValue2.getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(DetailedArrayReferenceValue)} with {@code
   * DetailedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(DetailedArrayReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(DetailedArrayReferenceValue) with 'DetailedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.DetailedArrayReferenceValue)"
  })
  void testGeneralizeWithDetailedArrayReferenceValue4() {
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

    // Act
    ReferenceValue actualGeneralizeResult =
        (new TracedReferenceValue(referenceValue, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(mock(DetailedArrayReferenceValue.class));

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
   * Test {@link TracedReferenceValue#generalize(DetailedArrayReferenceValue)} with {@code
   * DetailedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(DetailedArrayReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(DetailedArrayReferenceValue) with 'DetailedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.DetailedArrayReferenceValue)"
  })
  void testGeneralizeWithDetailedArrayReferenceValue5() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(mock(DetailedArrayReferenceValue.class));

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(DetailedArrayReferenceValue)} with {@code
   * DetailedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(DetailedArrayReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(DetailedArrayReferenceValue) with 'DetailedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.DetailedArrayReferenceValue)"
  })
  void testGeneralizeWithDetailedArrayReferenceValue6() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    DetailedArrayReferenceValue other = mock(DetailedArrayReferenceValue.class);
    when(other.generalize(Mockito.<UnknownReferenceValue>any()))
        .thenReturn(BasicValueFactory.REFERENCE_VALUE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    verify(other).generalize(isA(UnknownReferenceValue.class));
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(DetailedArrayReferenceValue)} with {@code
   * DetailedArrayReferenceValue}.
   *
   * <ul>
   *   <li>Then return Type is {@code Ljava/lang/Object;}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(DetailedArrayReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(DetailedArrayReferenceValue) with 'DetailedArrayReferenceValue'; then return Type is 'Ljava/lang/Object;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.DetailedArrayReferenceValue)"
  })
  void testGeneralizeWithDetailedArrayReferenceValue_thenReturnTypeIsLjavaLangObject() {
    // Arrange and Act
    ReferenceValue actualGeneralizeResult =
        (new TracedReferenceValue(
                TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(mock(DetailedArrayReferenceValue.class));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    assertEquals("Ljava/lang/Object;", referenceValue.getType());
    assertNull(referenceValue.getReferencedClass());
    assertEquals(0, referenceValue.isNull());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(((TypedReferenceValue) referenceValue).mayBeExtension);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(IdentifiedArrayReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testGeneralizeWithIdentifiedArrayReferenceValue() {
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
  @DisplayName(
      "Test generalize(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testGeneralizeWithIdentifiedArrayReferenceValue2() {
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
  @DisplayName(
      "Test generalize(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testGeneralizeWithIdentifiedArrayReferenceValue3() {
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
  @DisplayName(
      "Test generalize(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testGeneralizeWithIdentifiedArrayReferenceValue4() {
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
  @DisplayName(
      "Test generalize(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testGeneralizeWithIdentifiedArrayReferenceValue5() {
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
  @DisplayName(
      "Test generalize(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'; then return NotNull is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testGeneralizeWithIdentifiedArrayReferenceValue_thenReturnNotNullIsOne() {
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
  @DisplayName("Test generalize(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testGeneralizeWithIdentifiedReferenceValue() {
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
  @DisplayName("Test generalize(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testGeneralizeWithIdentifiedReferenceValue2() {
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
  @DisplayName("Test generalize(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testGeneralizeWithIdentifiedReferenceValue3() {
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
  @DisplayName("Test generalize(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testGeneralizeWithIdentifiedReferenceValue4() {
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
  @DisplayName("Test generalize(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testGeneralizeWithIdentifiedReferenceValue5() {
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
   *   <li>Then calls {@link AnalyzedObject#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'; then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testGeneralizeWithIdentifiedReferenceValue_thenCallsGetType() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new IdentifiedReferenceValue(
                "Type", referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    verify(value, atLeast(1)).getType();
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
   * <ul>
   *   <li>Then return Specific.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'; then return Specific")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testGeneralizeWithIdentifiedReferenceValue_thenReturnSpecific() {
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
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue() {
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
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue2() {
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
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue3() {
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
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue4() {
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
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue5() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue6() {
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
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue7() {
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
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue8() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
                new TracedReferenceValue(
                    PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

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
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue9() {
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
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue10() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
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
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue11() {
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
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue12() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
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
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue13() {
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
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue14() {
    // Arrange
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act
    ReferenceValue actualGeneralizeResult =
        (new TracedReferenceValue(
                PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertSame(other, ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue15() {
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
                    PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

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
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue16() {
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
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue17() {
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
                new TracedReferenceValue(
                    new ArrayReferenceValue(
                        "Type",
                        new LibraryClass(),
                        true,
                        BasicRangeValueFactory.INTEGER_VALUE_BYTE),
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
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue18() {
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
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue19() {
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
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue20() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue other =
        new TracedReferenceValue(
            new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize((ReferenceValue) other);

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then calls {@link AnalyzedObject#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'; then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenCallsGetType() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
                new TracedReferenceValue(
                    new ParticularReferenceValue(
                        referencedClass,
                        new ParticularReferenceValueFactory(),
                        "Reference ID",
                        value),
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then ReferenceValue return {@link TracedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then ReferenceValue return TracedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReferenceValueReturnTracedReferenceValue() {
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
   * <ul>
   *   <li>Then ReferenceValue return {@link TypedReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then ReferenceValue return TypedReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReferenceValueReturnTypedReferenceValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
                new TracedReferenceValue(
                    TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof TypedReferenceValue);
    assertEquals("Ljava/lang/Object;", referenceValue.getType());
    assertEquals(0, referenceValue.isNull());
    assertFalse(referenceValue.isParticular());
    assertTrue(referenceValue.mayBeExtension());
    assertTrue(((TypedReferenceValue) referenceValue).mayBeExtension);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>Then ReferenceValue return {@link UnknownReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ReferenceValue) with 'ReferenceValue'; then ReferenceValue return UnknownReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_thenReferenceValueReturnUnknownReferenceValue() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            (ReferenceValue)
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
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_whenReference_value() {
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
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_whenReference_value2() {
    // Arrange and Act
    ReferenceValue actualGeneralizeResult =
        (new TracedReferenceValue(
                new MultiTypedReferenceValue(
                    new TypedReferenceValue("Type", new LibraryClass(), true, true), true),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(BasicValueFactory.REFERENCE_VALUE);

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
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE_NULL")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_whenReference_value_null() {
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
   * Test {@link TracedReferenceValue#generalize(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <ul>
   *   <li>When {@link PrimitiveTypedReferenceValueFactory#REFERENCE_VALUE_NULL}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE_NULL")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.ReferenceValue)"
  })
  void testGeneralizeWithReferenceValue_whenReference_value_null2() {
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
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue() {
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
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue2() {
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
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue3() {
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
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue4() {
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
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue5() {
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
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue6() {
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
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue7() {
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
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue8() {
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
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue9() {
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
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue10() {
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
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue11() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TypedReferenceValue type = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new TracedReferenceValue(
                new MultiTypedReferenceValue(type, true),
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    Clazz referencedClass = actualGeneralizeResult.getReferencedClass();
    assertTrue(referencedClass instanceof LibraryClass);
    ReferenceValue referenceValue =
        ((TracedReferenceValue) actualGeneralizeResult).getReferenceValue();
    assertTrue(referenceValue instanceof MultiTypedReferenceValue);
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(type, ((MultiTypedReferenceValue) referenceValue).getGeneralizedType());
    assertSame(referencedClass, referenceValue.getReferencedClass());
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue12() {
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
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue13() {
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
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue14() {
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
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue15() {
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
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue16() {
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
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue17() {
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
  @DisplayName("Test generalize(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue18() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult =
        tracedReferenceValue.generalize(
            new TracedReferenceValue(
                PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(tracedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TracedReferenceValue)} with {@code
   * TracedReferenceValue}.
   *
   * <ul>
   *   <li>Then calls {@link AnalyzedObject#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TracedReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(TracedReferenceValue) with 'TracedReferenceValue'; then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testGeneralizeWithTracedReferenceValue_thenCallsGetType() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracedReferenceValue other =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    ReferenceValue actualGeneralizeResult = tracedReferenceValue.generalize(other);

    // Assert
    verify(value, atLeast(1)).getType();
    assertTrue(actualGeneralizeResult instanceof TracedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Test {@link TracedReferenceValue#generalize(TypedReferenceValue)} with {@code
   * TypedReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  @DisplayName("Test generalize(TypedReferenceValue) with 'TypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue() {
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
  @DisplayName("Test generalize(TypedReferenceValue) with 'TypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue2() {
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
  @DisplayName("Test generalize(TypedReferenceValue) with 'TypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue3() {
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
  @DisplayName("Test generalize(TypedReferenceValue) with 'TypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue4() {
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
  @DisplayName(
      "Test generalize(TypedReferenceValue) with 'TypedReferenceValue'; then ReferencedClass return LibraryClass")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testGeneralizeWithTypedReferenceValue_thenReferencedClassReturnLibraryClass() {
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
  @DisplayName("Test generalize(UnknownReferenceValue) with 'UnknownReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.UnknownReferenceValue)"
  })
  void testGeneralizeWithUnknownReferenceValue() {
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
  @DisplayName("Test generalize(UnknownReferenceValue) with 'UnknownReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.UnknownReferenceValue)"
  })
  void testGeneralizeWithUnknownReferenceValue2() {
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
  @DisplayName("Test generalize(UnknownReferenceValue) with 'UnknownReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracedReferenceValue.generalize(proguard.evaluation.value.UnknownReferenceValue)"
  })
  void testGeneralizeWithUnknownReferenceValue3() {
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
  @DisplayName("Test equal(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testEqualWithArrayReferenceValue() {
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
  @DisplayName("Test equal(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testEqualWithArrayReferenceValue2() {
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
  @DisplayName("Test equal(ArrayReferenceValue) with 'ArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testEqualWithArrayReferenceValue3() {
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
  @DisplayName("Test equal(ArrayReferenceValue) with 'ArrayReferenceValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ArrayReferenceValue)"
  })
  void testEqualWithArrayReferenceValue_thenReturnNever() {
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
   * Test {@link TracedReferenceValue#equal(DetailedArrayReferenceValue)} with {@code
   * DetailedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(DetailedArrayReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(DetailedArrayReferenceValue) with 'DetailedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.DetailedArrayReferenceValue)"
  })
  void testEqualWithDetailedArrayReferenceValue() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        (new TracedReferenceValue(
                PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(mock(DetailedArrayReferenceValue.class)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(DetailedArrayReferenceValue)} with {@code
   * DetailedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(DetailedArrayReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(DetailedArrayReferenceValue) with 'DetailedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.DetailedArrayReferenceValue)"
  })
  void testEqualWithDetailedArrayReferenceValue2() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        (new TracedReferenceValue(
                new ArrayReferenceValue(
                    "Type", new LibraryClass(), true, BasicValueFactory.INTEGER_VALUE),
                BasicRangeValueFactory.INTEGER_VALUE_CHAR))
            .equal(mock(DetailedArrayReferenceValue.class)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(DetailedArrayReferenceValue)} with {@code
   * DetailedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(DetailedArrayReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(DetailedArrayReferenceValue) with 'DetailedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.DetailedArrayReferenceValue)"
  })
  void testEqualWithDetailedArrayReferenceValue3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertEquals(
        Value.NEVER,
        (new TracedReferenceValue(
                new IdentifiedArrayReferenceValue(
                    "Type",
                    referencedClass,
                    true,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    new ParticularReferenceValueFactory(),
                    1),
                BasicRangeValueFactory.INTEGER_VALUE_CHAR))
            .equal(mock(DetailedArrayReferenceValue.class)));
  }

  /**
   * Test {@link TracedReferenceValue#equal(DetailedArrayReferenceValue)} with {@code
   * DetailedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(DetailedArrayReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(DetailedArrayReferenceValue) with 'DetailedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.DetailedArrayReferenceValue)"
  })
  void testEqualWithDetailedArrayReferenceValue4() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new TracedReferenceValue(
                BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_CHAR);
    DetailedArrayReferenceValue other = mock(DetailedArrayReferenceValue.class);
    when(other.equal(Mockito.<UnknownReferenceValue>any())).thenReturn(1);

    // Act
    int actualEqualResult = tracedReferenceValue.equal(other);

    // Assert
    verify(other).equal(isA(UnknownReferenceValue.class));
    assertEquals(1, actualEqualResult);
  }

  /**
   * Test {@link TracedReferenceValue#equal(DetailedArrayReferenceValue)} with {@code
   * DetailedArrayReferenceValue}.
   *
   * <ul>
   *   <li>Then calls {@link ReferenceValue#equal(UnknownReferenceValue)}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(DetailedArrayReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(DetailedArrayReferenceValue) with 'DetailedArrayReferenceValue'; then calls equal(UnknownReferenceValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.DetailedArrayReferenceValue)"
  })
  void testEqualWithDetailedArrayReferenceValue_thenCallsEqual() {
    // Arrange
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    DetailedArrayReferenceValue other = mock(DetailedArrayReferenceValue.class);
    when(other.equal(Mockito.<UnknownReferenceValue>any())).thenReturn(1);

    // Act
    int actualEqualResult = tracedReferenceValue.equal(other);

    // Assert
    verify(other).equal(isA(UnknownReferenceValue.class));
    assertEquals(1, actualEqualResult);
  }

  /**
   * Test {@link TracedReferenceValue#equal(IdentifiedArrayReferenceValue)} with {@code
   * IdentifiedArrayReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(IdentifiedArrayReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testEqualWithIdentifiedArrayReferenceValue() {
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
  @DisplayName("Test equal(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testEqualWithIdentifiedArrayReferenceValue2() {
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
  @DisplayName("Test equal(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testEqualWithIdentifiedArrayReferenceValue3() {
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
  @DisplayName("Test equal(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testEqualWithIdentifiedArrayReferenceValue4() {
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
  @DisplayName(
      "Test equal(IdentifiedArrayReferenceValue) with 'IdentifiedArrayReferenceValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.IdentifiedArrayReferenceValue)"
  })
  void testEqualWithIdentifiedArrayReferenceValue_thenReturnNever() {
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
  @DisplayName("Test equal(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testEqualWithIdentifiedReferenceValue() {
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
  @DisplayName("Test equal(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testEqualWithIdentifiedReferenceValue2() {
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
  @DisplayName("Test equal(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testEqualWithIdentifiedReferenceValue3() {
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
  @DisplayName("Test equal(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testEqualWithIdentifiedReferenceValue4() {
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
   * Test {@link TracedReferenceValue#equal(IdentifiedReferenceValue)} with {@code
   * IdentifiedReferenceValue}.
   *
   * <ul>
   *   <li>Then calls {@link AnalyzedObject#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(IdentifiedReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test equal(IdentifiedReferenceValue) with 'IdentifiedReferenceValue'; then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.IdentifiedReferenceValue)"
  })
  void testEqualWithIdentifiedReferenceValue_thenCallsGetType() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    int actualEqualResult =
        tracedReferenceValue.equal(
            new IdentifiedReferenceValue(
                "Type", referencedClass2, true, true, new ParticularReferenceValueFactory(), "Id"));

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link TracedReferenceValue#equal(ReferenceValue)} with {@code ReferenceValue}.
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue2() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue3() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue4() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue5() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue6() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue7() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue8() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue9() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue10() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue11() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue12() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue13() {
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
   *   <li>Then calls {@link AnalyzedObject#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link TracedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'; then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_thenCallsGetType() {
    // Arrange
    AnalyzedObject value = mock(AnalyzedObject.class);
    when(value.getType()).thenReturn("Type");
    LibraryClass referencedClass = new LibraryClass();
    TracedReferenceValue tracedReferenceValue =
        new TracedReferenceValue(
            new ParticularReferenceValue(
                referencedClass, new ParticularReferenceValueFactory(), "Reference ID", value),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    LibraryClass referencedClass2 = new LibraryClass();

    // Act
    int actualEqualResult =
        tracedReferenceValue.equal(
            (ReferenceValue)
                new IdentifiedReferenceValue(
                    "Type",
                    referencedClass2,
                    true,
                    true,
                    new ParticularReferenceValueFactory(),
                    "Id"));

    // Assert
    verify(value, atLeast(1)).getType();
    assertEquals(0, actualEqualResult);
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_thenReturnNever() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_thenReturnOne() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value2() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE_NULL")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value_null() {
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
  @DisplayName("Test equal(ReferenceValue) with 'ReferenceValue'; when REFERENCE_VALUE_NULL")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.ReferenceValue)"
  })
  void testEqualWithReferenceValue_whenReference_value_null2() {
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
  @DisplayName("Test equal(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testEqualWithTracedReferenceValue() {
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
  @DisplayName("Test equal(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testEqualWithTracedReferenceValue2() {
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
  @DisplayName("Test equal(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testEqualWithTracedReferenceValue3() {
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
  @DisplayName("Test equal(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testEqualWithTracedReferenceValue4() {
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
  @DisplayName("Test equal(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testEqualWithTracedReferenceValue5() {
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
  @DisplayName("Test equal(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testEqualWithTracedReferenceValue6() {
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
  @DisplayName("Test equal(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testEqualWithTracedReferenceValue7() {
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
  @DisplayName("Test equal(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testEqualWithTracedReferenceValue8() {
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
  @DisplayName("Test equal(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testEqualWithTracedReferenceValue9() {
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
  @DisplayName("Test equal(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testEqualWithTracedReferenceValue10() {
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
  @DisplayName("Test equal(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testEqualWithTracedReferenceValue11() {
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
  @DisplayName("Test equal(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testEqualWithTracedReferenceValue12() {
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
  @DisplayName("Test equal(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testEqualWithTracedReferenceValue13() {
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
  @DisplayName("Test equal(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testEqualWithTracedReferenceValue14() {
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
  @DisplayName("Test equal(TracedReferenceValue) with 'TracedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testEqualWithTracedReferenceValue15() {
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
  @DisplayName("Test equal(TracedReferenceValue) with 'TracedReferenceValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testEqualWithTracedReferenceValue_thenReturnNever() {
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
  @DisplayName("Test equal(TracedReferenceValue) with 'TracedReferenceValue'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TracedReferenceValue)"
  })
  void testEqualWithTracedReferenceValue_thenReturnOne() {
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
  @DisplayName("Test equal(TypedReferenceValue) with 'TypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testEqualWithTypedReferenceValue() {
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
  @DisplayName("Test equal(TypedReferenceValue) with 'TypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testEqualWithTypedReferenceValue2() {
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
  @DisplayName("Test equal(TypedReferenceValue) with 'TypedReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.TypedReferenceValue)"
  })
  void testEqualWithTypedReferenceValue3() {
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
  @DisplayName("Test equal(UnknownReferenceValue) with 'UnknownReferenceValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.UnknownReferenceValue)"
  })
  void testEqualWithUnknownReferenceValue() {
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
  @DisplayName("Test equal(UnknownReferenceValue) with 'UnknownReferenceValue'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.TracedReferenceValue.equal(proguard.evaluation.value.UnknownReferenceValue)"
  })
  void testEqualWithUnknownReferenceValue_thenReturnZero() {
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
  @DisplayName("Test isSpecific()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.TracedReferenceValue.isSpecific()"})
  void testIsSpecific() {
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
  @DisplayName("Test isSpecific(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.TracedReferenceValue.isSpecific()"})
  void testIsSpecific_thenReturnFalse() {
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
  @DisplayName("Test isSpecific(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.TracedReferenceValue.isSpecific()"})
  void testIsSpecific_thenReturnTrue() {
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
  @DisplayName("Test isParticular()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.TracedReferenceValue.isParticular()"})
  void testIsParticular() {
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
  @DisplayName("Test isParticular()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.TracedReferenceValue.isParticular()"})
  void testIsParticular2() {
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
  @DisplayName("Test isParticular()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.TracedReferenceValue.isParticular()"})
  void testIsParticular3() {
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
  @DisplayName("Test isParticular(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.TracedReferenceValue.isParticular()"})
  void testIsParticular_thenReturnTrue() {
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
  @DisplayName("Test internalType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.evaluation.value.TracedReferenceValue.internalType()"
  })
  void testInternalType() {
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
  @DisplayName("Test internalType(); then return 'Ljava/lang/Object;'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.evaluation.value.TracedReferenceValue.internalType()"
  })
  void testInternalType_thenReturnLjavaLangObject() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TracedReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TracedReferenceValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TracedReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TracedReferenceValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TracedReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TracedReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TracedReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TracedReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TracedReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TracedReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TracedReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TracedReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TracedReferenceValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TracedReferenceValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TracedReferenceValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to TracedReferenceValue");
  }
}
