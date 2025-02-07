package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.value.object.AnalyzedObject;

class TracingValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TracingValue#TracingValue(Value, Value)}
   *   <li>{@link TracingValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.TracingValue.<init>(proguard.evaluation.value.Value, proguard.evaluation.value.Value)",
    "java.lang.String proguard.evaluation.value.TracingValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "Pbb",
        (new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .toString());
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.TracingValue proguard.evaluation.value.TracingValue.generalize(proguard.evaluation.value.TracingValue)"
  })
  void testGeneralizeWithTracingValue() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(
        tracingValue,
        tracingValue.generalize(
            new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.TracingValue proguard.evaluation.value.TracingValue.generalize(proguard.evaluation.value.TracingValue)"
  })
  void testGeneralizeWithTracingValue2() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_CHAR, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    TracingValue actualGeneralizeResult =
        tracingValue.generalize(
            new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.TracingValue proguard.evaluation.value.TracingValue.generalize(proguard.evaluation.value.TracingValue)"
  })
  void testGeneralizeWithTracingValue3() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_SHORT, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        tracingValue,
        tracingValue.generalize(
            new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.TracingValue proguard.evaluation.value.TracingValue.generalize(proguard.evaluation.value.TracingValue)"
  })
  void testGeneralizeWithTracingValue4() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act
    TracingValue actualGeneralizeResult =
        tracingValue.generalize(
            new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link TracingValue#generalize(Value)} with {@code Value}.
   *
   * <p>Method under test: {@link TracingValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value) with 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.value.TracingValue.generalize(proguard.evaluation.value.Value)"
  })
  void testGeneralizeWithValue() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(tracingValue, tracingValue.generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link TracingValue#generalize(Value)} with {@code Value}.
   *
   * <p>Method under test: {@link TracingValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value) with 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.value.TracingValue.generalize(proguard.evaluation.value.Value)"
  })
  void testGeneralizeWithValue2() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_SHORT);

    // Act
    Value actualGeneralizeResult =
        tracingValue.generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracingValue);
    assertEquals(tracingValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracingValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>Then return not Category2.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value) with 'Value'; then return not Category2")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.value.TracingValue.generalize(proguard.evaluation.value.Value)"
  })
  void testGeneralizeWithValue_thenReturnNotCategory2() {
    // Arrange and Act
    Value actualGeneralizeResult =
        (new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_CHAR))
            .generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracingValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link TracingValue#isCategory2()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#isCategory2()}
   */
  @Test
  @DisplayName("Test isCategory2(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.TracingValue.isCategory2()"})
  void testIsCategory2_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .isCategory2());
  }

  /**
   * Test {@link TracingValue#isCategory2()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#isCategory2()}
   */
  @Test
  @DisplayName("Test isCategory2(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.TracingValue.isCategory2()"})
  void testIsCategory2_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.DOUBLE_VALUE))
            .isCategory2());
  }

  /**
   * Test {@link TracingValue#category1Value()}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#category1Value()}
   */
  @Test
  @DisplayName("Test category1Value(); then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Category1Value proguard.evaluation.value.TracingValue.category1Value()"
  })
  void testCategory1Value_thenReturnRangeIntegerValue() {
    // Arrange and Act
    Category1Value actualCategory1ValueResult =
        (new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .category1Value();

    // Assert
    assertTrue(actualCategory1ValueResult instanceof RangeIntegerValue);
    assertFalse(actualCategory1ValueResult.isCategory2());
    assertFalse(actualCategory1ValueResult.isParticular());
    assertFalse(actualCategory1ValueResult.isSpecific());
  }

  /**
   * Test {@link TracingValue#category2Value()}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#category2Value()}
   */
  @Test
  @DisplayName("Test category2Value(); then return UnknownDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Category2Value proguard.evaluation.value.TracingValue.category2Value()"
  })
  void testCategory2Value_thenReturnUnknownDoubleValue() {
    // Arrange and Act
    Category2Value actualCategory2ValueResult =
        (new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.DOUBLE_VALUE))
            .category2Value();

    // Assert
    assertTrue(actualCategory2ValueResult instanceof UnknownDoubleValue);
    assertFalse(actualCategory2ValueResult.isParticular());
    assertFalse(actualCategory2ValueResult.isSpecific());
    assertTrue(actualCategory2ValueResult.isCategory2());
  }

  /**
   * Test {@link TracingValue#integerValue()}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#integerValue()}
   */
  @Test
  @DisplayName("Test integerValue(); then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.TracingValue.integerValue()"
  })
  void testIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualIntegerValueResult =
        (new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .integerValue();

    // Assert
    assertTrue(actualIntegerValueResult instanceof RangeIntegerValue);
    assertFalse(actualIntegerValueResult.isCategory2());
    assertFalse(actualIntegerValueResult.isParticular());
    assertFalse(actualIntegerValueResult.isSpecific());
  }

  /**
   * Test {@link TracingValue#longValue()}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#longValue()}
   */
  @Test
  @DisplayName("Test longValue(); then return UnknownLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.TracingValue.longValue()"
  })
  void testLongValue_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualLongValueResult =
        (new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.LONG_VALUE))
            .longValue();

    // Assert
    assertTrue(actualLongValueResult instanceof UnknownLongValue);
    assertFalse(actualLongValueResult.isParticular());
    assertFalse(actualLongValueResult.isSpecific());
    assertTrue(actualLongValueResult.isCategory2());
  }

  /**
   * Test {@link TracingValue#floatValue()}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#floatValue()}
   */
  @Test
  @DisplayName("Test floatValue(); then return UnknownFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.TracingValue.floatValue()"
  })
  void testFloatValue_thenReturnUnknownFloatValue() {
    // Arrange and Act
    FloatValue actualFloatValueResult =
        (new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.FLOAT_VALUE))
            .floatValue();

    // Assert
    assertTrue(actualFloatValueResult instanceof UnknownFloatValue);
    assertFalse(actualFloatValueResult.isCategory2());
    assertFalse(actualFloatValueResult.isParticular());
    assertFalse(actualFloatValueResult.isSpecific());
  }

  /**
   * Test {@link TracingValue#doubleValue()}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#doubleValue()}
   */
  @Test
  @DisplayName("Test doubleValue(); then return UnknownDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.TracingValue.doubleValue()"
  })
  void testDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange and Act
    DoubleValue actualDoubleValueResult =
        (new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.DOUBLE_VALUE))
            .doubleValue();

    // Assert
    assertTrue(actualDoubleValueResult instanceof UnknownDoubleValue);
    assertFalse(actualDoubleValueResult.isParticular());
    assertFalse(actualDoubleValueResult.isSpecific());
    assertTrue(actualDoubleValueResult.isCategory2());
  }

  /**
   * Test {@link TracingValue#referenceValue()}.
   *
   * <ul>
   *   <li>Then return {@link UnknownReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#referenceValue()}
   */
  @Test
  @DisplayName("Test referenceValue(); then return UnknownReferenceValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.TracingValue.referenceValue()"
  })
  void testReferenceValue_thenReturnUnknownReferenceValue() {
    // Arrange and Act
    ReferenceValue actualReferenceValueResult =
        (new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.REFERENCE_VALUE))
            .referenceValue();

    // Assert
    assertTrue(actualReferenceValueResult instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", actualReferenceValueResult.getType());
    AnalyzedObject value = actualReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualReferenceValueResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualReferenceValueResult.isNotNull());
    assertEquals(0, actualReferenceValueResult.isNull());
    assertFalse(actualReferenceValueResult.isCategory2());
    assertFalse(actualReferenceValueResult.isParticular());
    assertFalse(actualReferenceValueResult.isSpecific());
  }

  /**
   * Test {@link TracingValue#instructionOffsetValue()}.
   *
   * <ul>
   *   <li>Then return {@link InstructionOffsetValue#EMPTY_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#instructionOffsetValue()}
   */
  @Test
  @DisplayName("Test instructionOffsetValue(); then return EMPTY_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.InstructionOffsetValue proguard.evaluation.value.TracingValue.instructionOffsetValue()"
  })
  void testInstructionOffsetValue_thenReturnEmpty_value() {
    // Arrange and Act
    InstructionOffsetValue actualInstructionOffsetValueResult =
        (new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE, InstructionOffsetValue.EMPTY_VALUE))
            .instructionOffsetValue();

    // Assert
    assertSame(actualInstructionOffsetValueResult.EMPTY_VALUE, actualInstructionOffsetValueResult);
  }

  /**
   * Test {@link TracingValue#isSpecific()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#isSpecific()}
   */
  @Test
  @DisplayName("Test isSpecific(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.TracingValue.isSpecific()"})
  void testIsSpecific_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .isSpecific());
  }

  /**
   * Test {@link TracingValue#isSpecific()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#isSpecific()}
   */
  @Test
  @DisplayName("Test isSpecific(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.TracingValue.isSpecific()"})
  void testIsSpecific_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE, InstructionOffsetValue.EMPTY_VALUE))
            .isSpecific());
  }

  /**
   * Test {@link TracingValue#isParticular()}.
   *
   * <p>Method under test: {@link TracingValue#isParticular()}
   */
  @Test
  @DisplayName("Test isParticular()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.TracingValue.isParticular()"})
  void testIsParticular() {
    // Arrange, Act and Assert
    assertFalse(
        (new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .isParticular());
  }

  /**
   * Test {@link TracingValue#isParticular()}.
   *
   * <p>Method under test: {@link TracingValue#isParticular()}
   */
  @Test
  @DisplayName("Test isParticular()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.TracingValue.isParticular()"})
  void testIsParticular2() {
    // Arrange, Act and Assert
    assertFalse(
        (new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.DOUBLE_VALUE))
            .isParticular());
  }

  /**
   * Test {@link TracingValue#isParticular()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#isParticular()}
   */
  @Test
  @DisplayName("Test isParticular(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.TracingValue.isParticular()"})
  void testIsParticular_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE, InstructionOffsetValue.EMPTY_VALUE))
            .isParticular());
  }

  /**
   * Test {@link TracingValue#computationalType()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#computationalType()}
   */
  @Test
  @DisplayName("Test computationalType(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.evaluation.value.TracingValue.computationalType()"})
  void testComputationalType_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        (new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .computationalType());
  }

  /**
   * Test {@link TracingValue#internalType()}.
   *
   * <ul>
   *   <li>Then return {@code I}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#internalType()}
   */
  @Test
  @DisplayName("Test internalType(); then return 'I'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.evaluation.value.TracingValue.internalType()"})
  void testInternalType_thenReturnI() {
    // Arrange, Act and Assert
    assertEquals(
        "I",
        (new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .internalType());
  }

  /**
   * Test {@link TracingValue#equals(Object)}, and {@link TracingValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TracingValue#equals(Object)}
   *   <li>{@link TracingValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TracingValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TracingValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracingValue tracingValue2 =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(tracingValue, tracingValue2);
    int expectedHashCodeResult = tracingValue.hashCode();
    assertEquals(expectedHashCodeResult, tracingValue2.hashCode());
  }

  /**
   * Test {@link TracingValue#equals(Object)}, and {@link TracingValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TracingValue#equals(Object)}
   *   <li>{@link TracingValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TracingValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TracingValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(tracingValue, tracingValue);
    int expectedHashCodeResult = tracingValue.hashCode();
    assertEquals(expectedHashCodeResult, tracingValue.hashCode());
  }

  /**
   * Test {@link TracingValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TracingValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TracingValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_CHAR, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(
        tracingValue,
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link TracingValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TracingValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TracingValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(
        tracingValue,
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link TracingValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TracingValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TracingValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        null);
  }

  /**
   * Test {@link TracingValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.TracingValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.TracingValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to TracingValue");
  }
}
