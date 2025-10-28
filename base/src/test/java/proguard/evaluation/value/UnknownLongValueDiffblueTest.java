package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class UnknownLongValueDiffblueTest {
  /**
   * Method under test: {@link UnknownLongValue#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.negate());
  }

  /**
   * Method under test: {@link UnknownLongValue#convertToInteger()}
   */
  @Test
  public void testConvertToInteger() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult = (new UnknownLongValue()).convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof UnknownIntegerValue);
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertFalse(actualConvertToIntegerResult.isParticular());
    assertFalse(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Method under test: {@link UnknownLongValue#convertToFloat()}
   */
  @Test
  public void testConvertToFloat() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = (new UnknownLongValue()).convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof UnknownFloatValue);
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertFalse(actualConvertToFloatResult.isParticular());
    assertFalse(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Method under test: {@link UnknownLongValue#convertToDouble()}
   */
  @Test
  public void testConvertToDouble() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = (new UnknownLongValue()).convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof UnknownDoubleValue);
    assertFalse(actualConvertToDoubleResult.isParticular());
    assertFalse(actualConvertToDoubleResult.isSpecific());
    assertTrue(actualConvertToDoubleResult.isCategory2());
  }

  /**
   * Method under test: {@link UnknownLongValue#generalize(LongValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.generalize(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Method under test: {@link UnknownLongValue#add(LongValue)}
   */
  @Test
  public void testAdd() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.add(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Method under test: {@link UnknownLongValue#subtract(LongValue)}
   */
  @Test
  public void testSubtract() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.subtract(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Method under test: {@link UnknownLongValue#subtractFrom(LongValue)}
   */
  @Test
  public void testSubtractFrom() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.subtractFrom(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Method under test: {@link UnknownLongValue#multiply(LongValue)}
   */
  @Test
  public void testMultiply() throws ArithmeticException {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.multiply(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Method under test: {@link UnknownLongValue#divide(LongValue)}
   */
  @Test
  public void testDivide() throws ArithmeticException {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.divide(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Method under test: {@link UnknownLongValue#divideOf(LongValue)}
   */
  @Test
  public void testDivideOf() throws ArithmeticException {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.divideOf(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Method under test: {@link UnknownLongValue#remainder(LongValue)}
   */
  @Test
  public void testRemainder() throws ArithmeticException {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.remainder(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Method under test: {@link UnknownLongValue#remainderOf(LongValue)}
   */
  @Test
  public void testRemainderOf() throws ArithmeticException {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.remainderOf(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Method under test: {@link UnknownLongValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownLongValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownLongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownLongValue#and(LongValue)}
   */
  @Test
  public void testAnd() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.and(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Method under test: {@link UnknownLongValue#or(LongValue)}
   */
  @Test
  public void testOr() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.or(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Method under test: {@link UnknownLongValue#xor(LongValue)}
   */
  @Test
  public void testXor() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.xor(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Method under test: {@link UnknownLongValue#compare(LongValue)}
   */
  @Test
  public void testCompare() {
    // Arrange and Act
    IntegerValue actualCompareResult = (new UnknownLongValue()).compare(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UnknownLongValue#equals(Object)}
   *   <li>{@link UnknownLongValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();
    UnknownLongValue unknownLongValue2 = new UnknownLongValue();

    // Act and Assert
    assertEquals(unknownLongValue, unknownLongValue2);
    int expectedHashCodeResult = unknownLongValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownLongValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UnknownLongValue#equals(Object)}
   *   <li>{@link UnknownLongValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertEquals(unknownLongValue, unknownLongValue);
    int expectedHashCodeResult = unknownLongValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownLongValue.hashCode());
  }

  /**
   * Method under test: {@link UnknownLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownLongValue(), 1);
  }

  /**
   * Method under test: {@link UnknownLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownLongValue(), null);
  }

  /**
   * Method under test: {@link UnknownLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownLongValue(), "Different type to UnknownLongValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UnknownLongValue}
   *   <li>{@link UnknownLongValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("l", (new UnknownLongValue()).toString());
  }
}
