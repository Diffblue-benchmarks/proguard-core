package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.evaluation.value.object.AnalyzedObject;

public class TracingValueDiffblueTest {
  /**
   * Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    TracingValue tracingValue = new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(tracingValue, tracingValue.generalize(
        new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    TracingValue tracingValue = new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    TracingValue actualGeneralizeResult = tracingValue.generalize(
        new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    TracingValue tracingValue = new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_SHORT,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(tracingValue, tracingValue.generalize(
        new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    TracingValue tracingValue = new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act
    TracingValue actualGeneralizeResult = tracingValue.generalize(
        new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link TracingValue#generalize(Value)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    TracingValue tracingValue = new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertSame(tracingValue, tracingValue.generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link TracingValue#generalize(Value)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange and Act
    Value actualGeneralizeResult = (new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_CHAR)).generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracingValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Method under test: {@link TracingValue#generalize(Value)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange
    TracingValue tracingValue = new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_SHORT);

    // Act
    Value actualGeneralizeResult = tracingValue.generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracingValue);
    assertEquals(tracingValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link TracingValue#isCategory2()}
   */
  @Test
  public void testIsCategory2() {
    // Arrange, Act and Assert
    assertFalse((new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .isCategory2());
    assertTrue(
        (new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.DOUBLE_VALUE)).isCategory2());
  }

  /**
   * Method under test: {@link TracingValue#category1Value()}
   */
  @Test
  public void testCategory1Value() {
    // Arrange and Act
    Category1Value actualCategory1ValueResult = (new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).category1Value();

    // Assert
    assertTrue(actualCategory1ValueResult instanceof RangeIntegerValue);
    assertFalse(actualCategory1ValueResult.isCategory2());
    assertFalse(actualCategory1ValueResult.isParticular());
    assertFalse(actualCategory1ValueResult.isSpecific());
  }

  /**
   * Method under test: {@link TracingValue#category2Value()}
   */
  @Test
  public void testCategory2Value() {
    // Arrange and Act
    Category2Value actualCategory2ValueResult = (new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicValueFactory.DOUBLE_VALUE)).category2Value();

    // Assert
    assertTrue(actualCategory2ValueResult instanceof UnknownDoubleValue);
    assertFalse(actualCategory2ValueResult.isParticular());
    assertFalse(actualCategory2ValueResult.isSpecific());
    assertTrue(actualCategory2ValueResult.isCategory2());
  }

  /**
   * Method under test: {@link TracingValue#integerValue()}
   */
  @Test
  public void testIntegerValue() {
    // Arrange and Act
    IntegerValue actualIntegerValueResult = (new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE)).integerValue();

    // Assert
    assertTrue(actualIntegerValueResult instanceof RangeIntegerValue);
    assertFalse(actualIntegerValueResult.isCategory2());
    assertFalse(actualIntegerValueResult.isParticular());
    assertFalse(actualIntegerValueResult.isSpecific());
  }

  /**
   * Method under test: {@link TracingValue#longValue()}
   */
  @Test
  public void testLongValue() {
    // Arrange and Act
    LongValue actualLongValueResult = (new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicValueFactory.LONG_VALUE)).longValue();

    // Assert
    assertTrue(actualLongValueResult instanceof UnknownLongValue);
    assertFalse(actualLongValueResult.isParticular());
    assertFalse(actualLongValueResult.isSpecific());
    assertTrue(actualLongValueResult.isCategory2());
  }

  /**
   * Method under test: {@link TracingValue#floatValue()}
   */
  @Test
  public void testFloatValue() {
    // Arrange and Act
    FloatValue actualFloatValueResult = (new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicValueFactory.FLOAT_VALUE)).floatValue();

    // Assert
    assertTrue(actualFloatValueResult instanceof UnknownFloatValue);
    assertFalse(actualFloatValueResult.isCategory2());
    assertFalse(actualFloatValueResult.isParticular());
    assertFalse(actualFloatValueResult.isSpecific());
  }

  /**
   * Method under test: {@link TracingValue#doubleValue()}
   */
  @Test
  public void testDoubleValue() {
    // Arrange and Act
    DoubleValue actualDoubleValueResult = (new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicValueFactory.DOUBLE_VALUE)).doubleValue();

    // Assert
    assertTrue(actualDoubleValueResult instanceof UnknownDoubleValue);
    assertFalse(actualDoubleValueResult.isParticular());
    assertFalse(actualDoubleValueResult.isSpecific());
    assertTrue(actualDoubleValueResult.isCategory2());
  }

  /**
   * Method under test: {@link TracingValue#referenceValue()}
   */
  @Test
  public void testReferenceValue() {
    // Arrange and Act
    ReferenceValue actualReferenceValueResult = (new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicValueFactory.REFERENCE_VALUE)).referenceValue();

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
   * Method under test: {@link TracingValue#instructionOffsetValue()}
   */
  @Test
  public void testInstructionOffsetValue() {
    // Arrange and Act
    InstructionOffsetValue actualInstructionOffsetValueResult = (new TracingValue(
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, InstructionOffsetValue.EMPTY_VALUE)).instructionOffsetValue();

    // Assert
    assertSame(actualInstructionOffsetValueResult.EMPTY_VALUE, actualInstructionOffsetValueResult);
  }

  /**
   * Method under test: {@link TracingValue#isSpecific()}
   */
  @Test
  public void testIsSpecific() {
    // Arrange, Act and Assert
    assertFalse((new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .isSpecific());
    assertTrue(
        (new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, InstructionOffsetValue.EMPTY_VALUE)).isSpecific());
  }

  /**
   * Method under test: {@link TracingValue#isParticular()}
   */
  @Test
  public void testIsParticular() {
    // Arrange, Act and Assert
    assertFalse((new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
        .isParticular());
    assertFalse(
        (new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.DOUBLE_VALUE)).isParticular());
    assertTrue((new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, InstructionOffsetValue.EMPTY_VALUE))
        .isParticular());
  }

  /**
   * Method under test: {@link TracingValue#computationalType()}
   */
  @Test
  public void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(1,
        (new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .computationalType());
  }

  /**
   * Method under test: {@link TracingValue#internalType()}
   */
  @Test
  public void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("I",
        (new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .internalType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TracingValue#equals(Object)}
   *   <li>{@link TracingValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TracingValue tracingValue = new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracingValue tracingValue2 = new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(tracingValue, tracingValue2);
    int expectedHashCodeResult = tracingValue.hashCode();
    assertEquals(expectedHashCodeResult, tracingValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TracingValue#equals(Object)}
   *   <li>{@link TracingValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TracingValue tracingValue = new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(tracingValue, tracingValue);
    int expectedHashCodeResult = tracingValue.hashCode();
    assertEquals(expectedHashCodeResult, tracingValue.hashCode());
  }

  /**
   * Method under test: {@link TracingValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TracingValue tracingValue = new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(tracingValue,
        new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link TracingValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TracingValue tracingValue = new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE,
        BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(tracingValue,
        new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link TracingValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Method under test: {@link TracingValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to TracingValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TracingValue#TracingValue(Value, Value)}
   *   <li>{@link TracingValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Pbb",
        (new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .toString());
  }
}
