package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class UnknownIntegerValueDiffblueTest {
  /**
   * Method under test: {@link UnknownIntegerValue#negate()}
   */
  @Test
  public void testNegate() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.negate());
  }

  /**
   * Method under test: {@link UnknownIntegerValue#convertToByte()}
   */
  @Test
  public void testConvertToByte() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.convertToByte());
  }

  /**
   * Method under test: {@link UnknownIntegerValue#convertToCharacter()}
   */
  @Test
  public void testConvertToCharacter() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.convertToCharacter());
  }

  /**
   * Method under test: {@link UnknownIntegerValue#convertToShort()}
   */
  @Test
  public void testConvertToShort() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.convertToShort());
  }

  /**
   * Method under test: {@link UnknownIntegerValue#convertToLong()}
   */
  @Test
  public void testConvertToLong() {
    // Arrange and Act
    LongValue actualConvertToLongResult = (new UnknownIntegerValue()).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof UnknownLongValue);
    assertFalse(actualConvertToLongResult.isParticular());
    assertFalse(actualConvertToLongResult.isSpecific());
    assertTrue(actualConvertToLongResult.isCategory2());
  }

  /**
   * Method under test: {@link UnknownIntegerValue#convertToFloat()}
   */
  @Test
  public void testConvertToFloat() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = (new UnknownIntegerValue()).convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof UnknownFloatValue);
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertFalse(actualConvertToFloatResult.isParticular());
    assertFalse(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Method under test: {@link UnknownIntegerValue#convertToDouble()}
   */
  @Test
  public void testConvertToDouble() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = (new UnknownIntegerValue()).convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof UnknownDoubleValue);
    assertFalse(actualConvertToDoubleResult.isParticular());
    assertFalse(actualConvertToDoubleResult.isSpecific());
    assertTrue(actualConvertToDoubleResult.isCategory2());
  }

  /**
   * Method under test: {@link UnknownIntegerValue#generalize(IntegerValue)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#add(IntegerValue)}
   */
  @Test
  public void testAdd() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.add(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#subtract(IntegerValue)}
   */
  @Test
  public void testSubtract() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtract(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  public void testSubtractFrom() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtractFrom(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#multiply(IntegerValue)}
   */
  @Test
  public void testMultiply() throws ArithmeticException {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.multiply(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#divide(IntegerValue)}
   */
  @Test
  public void testDivide() throws ArithmeticException {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divide(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  public void testDivideOf() throws ArithmeticException {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divideOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#remainder(IntegerValue)}
   */
  @Test
  public void testRemainder() throws ArithmeticException {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainder(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  public void testRemainderOf() throws ArithmeticException {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainderOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  public void testShiftLeft() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  public void testShiftLeftOf() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeftOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  public void testShiftLeftOf2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new UnknownIntegerValue()).shiftLeftOf(other));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  public void testShiftRight() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  public void testShiftRightOf() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  public void testShiftRightOf2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new UnknownIntegerValue()).shiftRightOf(other));
  }

  /**
   * Method under test:
   * {@link UnknownIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRight() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test:
   * {@link UnknownIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  public void testUnsignedShiftRightOf() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue,
        unknownIntegerValue.unsignedShiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test:
   * {@link UnknownIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  public void testUnsignedShiftRightOf2() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new UnknownIntegerValue()).unsignedShiftRightOf(other));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#and(IntegerValue)}
   */
  @Test
  public void testAnd() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.and(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#or(IntegerValue)}
   */
  @Test
  public void testOr() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.or(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#xor(IntegerValue)}
   */
  @Test
  public void testXor() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.xor(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#equal(IntegerValue)}
   */
  @Test
  public void testEqual() {
    // Arrange, Act and Assert
    assertEquals(0, (new UnknownIntegerValue()).equal(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  public void testLessThan() {
    // Arrange, Act and Assert
    assertEquals(0, (new UnknownIntegerValue()).lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Method under test: {@link UnknownIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  public void testLessThanOrEqual() {
    // Arrange, Act and Assert
    assertEquals(0, (new UnknownIntegerValue()).lessThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UnknownIntegerValue#equals(Object)}
   *   <li>{@link UnknownIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();
    UnknownIntegerValue unknownIntegerValue2 = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(unknownIntegerValue, unknownIntegerValue2);
    int expectedHashCodeResult = unknownIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownIntegerValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UnknownIntegerValue#equals(Object)}
   *   <li>{@link UnknownIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(unknownIntegerValue, unknownIntegerValue);
    int expectedHashCodeResult = unknownIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownIntegerValue.hashCode());
  }

  /**
   * Method under test: {@link UnknownIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownIntegerValue(), 1);
  }

  /**
   * Method under test: {@link UnknownIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownIntegerValue(), null);
  }

  /**
   * Method under test: {@link UnknownIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownIntegerValue(), "Different type to UnknownIntegerValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UnknownIntegerValue}
   *   <li>{@link UnknownIntegerValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("i", (new UnknownIntegerValue()).toString());
  }
}
