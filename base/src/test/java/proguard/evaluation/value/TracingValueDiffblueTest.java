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
import proguard.evaluation.value.object.AnalyzedObject;

public class TracingValueDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TracingValue.<init>(Value, Value)",
    "java.lang.String TracingValue.toString()"
  })
  public void testGettersAndSetters() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  public void testGeneralizeWithTracingValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  public void testGeneralizeWithTracingValue2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  public void testGeneralizeWithTracingValue3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  public void testGeneralizeWithTracingValue4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value TracingValue.generalize(Value)"})
  public void testGeneralizeWithValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value TracingValue.generalize(Value)"})
  public void testGeneralizeWithValue2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value TracingValue.generalize(Value)"})
  public void testGeneralizeWithValue_thenReturnNotCategory2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracingValue.isCategory2()"})
  public void testIsCategory2_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracingValue.isCategory2()"})
  public void testIsCategory2_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Category1Value TracingValue.category1Value()"})
  public void testCategory1Value_thenReturnRangeIntegerValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Category2Value TracingValue.category2Value()"})
  public void testCategory2Value_thenReturnUnknownDoubleValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue TracingValue.integerValue()"})
  public void testIntegerValue_thenReturnRangeIntegerValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue TracingValue.longValue()"})
  public void testLongValue_thenReturnUnknownLongValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue TracingValue.floatValue()"})
  public void testFloatValue_thenReturnUnknownFloatValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue TracingValue.doubleValue()"})
  public void testDoubleValue_thenReturnUnknownDoubleValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue TracingValue.referenceValue()"})
  public void testReferenceValue_thenReturnUnknownReferenceValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InstructionOffsetValue TracingValue.instructionOffsetValue()"})
  public void testInstructionOffsetValue_thenReturnEmpty_value() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracingValue.isSpecific()"})
  public void testIsSpecific_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracingValue.isSpecific()"})
  public void testIsSpecific_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracingValue.isParticular()"})
  public void testIsParticular() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracingValue.isParticular()"})
  public void testIsParticular2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracingValue.isParticular()"})
  public void testIsParticular_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TracingValue.computationalType()"})
  public void testComputationalType_thenReturnOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String TracingValue.internalType()"})
  public void testInternalType_thenReturnI() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracingValue.equals(Object)", "int TracingValue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracingValue.equals(Object)", "int TracingValue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracingValue.equals(Object)", "int TracingValue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracingValue.equals(Object)", "int TracingValue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracingValue.equals(Object)", "int TracingValue.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TracingValue.equals(Object)", "int TracingValue.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to TracingValue");
  }
}
