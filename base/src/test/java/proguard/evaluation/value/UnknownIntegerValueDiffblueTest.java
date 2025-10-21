package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UnknownIntegerValueDiffblueTest {
  /**
   * Test {@link UnknownIntegerValue#negate()}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.negate()"})
  public void testNegate() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.negate());
  }

  /**
   * Test {@link UnknownIntegerValue#convertToByte()}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#convertToByte()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.convertToByte()"})
  public void testConvertToByte() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.convertToByte());
  }

  /**
   * Test {@link UnknownIntegerValue#convertToCharacter()}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#convertToCharacter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.convertToCharacter()"})
  public void testConvertToCharacter() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.convertToCharacter());
  }

  /**
   * Test {@link UnknownIntegerValue#convertToShort()}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#convertToShort()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.convertToShort()"})
  public void testConvertToShort() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.convertToShort());
  }

  /**
   * Test {@link UnknownIntegerValue#convertToLong()}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#convertToLong()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownIntegerValue.convertToLong()"})
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
   * Test {@link UnknownIntegerValue#convertToFloat()}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#convertToFloat()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue UnknownIntegerValue.convertToFloat()"})
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
   * Test {@link UnknownIntegerValue#convertToDouble()}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#convertToDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue UnknownIntegerValue.convertToDouble()"})
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
   * Test {@link UnknownIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.generalize(IntegerValue)"})
  public void testGeneralizeWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#add(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.add(IntegerValue)"})
  public void testAddWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.add(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.subtract(IntegerValue)"})
  public void testSubtractWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.subtract(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.subtractFrom(IntegerValue)"})
  public void testSubtractFromWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.subtractFrom(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.multiply(IntegerValue)"})
  public void testMultiplyWithIntegerValue() throws ArithmeticException {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.multiply(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#divide(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.divide(IntegerValue)"})
  public void testDivideWithIntegerValue() throws ArithmeticException {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.divide(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.divideOf(IntegerValue)"})
  public void testDivideOfWithIntegerValue() throws ArithmeticException {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.divideOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.remainder(IntegerValue)"})
  public void testRemainderWithIntegerValue() throws ArithmeticException {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.remainder(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.remainderOf(IntegerValue)"})
  public void testRemainderOfWithIntegerValue() throws ArithmeticException {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.remainderOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.shiftLeft(IntegerValue)"})
  public void testShiftLeftWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.shiftLeftOf(IntegerValue)"})
  public void testShiftLeftOfWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.shiftLeftOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#shiftLeftOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownIntegerValue.shiftLeftOf(LongValue)"})
  public void testShiftLeftOfWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new UnknownIntegerValue()).shiftLeftOf(other));
  }

  /**
   * Test {@link UnknownIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.shiftRight(IntegerValue)"})
  public void testShiftRightWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.shiftRightOf(IntegerValue)"})
  public void testShiftRightOfWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.shiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#shiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownIntegerValue.shiftRightOf(LongValue)"})
  public void testShiftRightOfWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new UnknownIntegerValue()).shiftRightOf(other));
  }

  /**
   * Test {@link UnknownIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.unsignedShiftRight(IntegerValue)"})
  public void testUnsignedShiftRightWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  public void testUnsignedShiftRightOfWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.unsignedShiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#unsignedShiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownIntegerValue.unsignedShiftRightOf(LongValue)"})
  public void testUnsignedShiftRightOfWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new UnknownIntegerValue()).unsignedShiftRightOf(other));
  }

  /**
   * Test {@link UnknownIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#and(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.and(IntegerValue)"})
  public void testAndWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.and(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#or(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.or(IntegerValue)"})
  public void testOrWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.or(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#xor(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.xor(IntegerValue)"})
  public void testXorWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.xor(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#equal(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int UnknownIntegerValue.equal(IntegerValue)"})
  public void testEqualWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(0, (new UnknownIntegerValue()).equal(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int UnknownIntegerValue.lessThan(IntegerValue)"})
  public void testLessThanWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0, (new UnknownIntegerValue()).lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int UnknownIntegerValue.lessThanOrEqual(IntegerValue)"})
  public void testLessThanOrEqualWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0, (new UnknownIntegerValue()).lessThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#equals(Object)}, and {@link UnknownIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UnknownIntegerValue#equals(Object)}
   *   <li>{@link UnknownIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UnknownIntegerValue.equals(Object)",
    "int UnknownIntegerValue.hashCode()"
  })
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
   * Test {@link UnknownIntegerValue#equals(Object)}, and {@link UnknownIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UnknownIntegerValue#equals(Object)}
   *   <li>{@link UnknownIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UnknownIntegerValue.equals(Object)",
    "int UnknownIntegerValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(unknownIntegerValue, unknownIntegerValue);
    int expectedHashCodeResult = unknownIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownIntegerValue.hashCode());
  }

  /**
   * Test {@link UnknownIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UnknownIntegerValue.equals(Object)",
    "int UnknownIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownIntegerValue(), 1);
  }

  /**
   * Test {@link UnknownIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UnknownIntegerValue.equals(Object)",
    "int UnknownIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownIntegerValue(), null);
  }

  /**
   * Test {@link UnknownIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownIntegerValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UnknownIntegerValue.equals(Object)",
    "int UnknownIntegerValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownIntegerValue(), "Different type to UnknownIntegerValue");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UnknownIntegerValue}
   *   <li>{@link UnknownIntegerValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UnknownIntegerValue.<init>()",
    "java.lang.String UnknownIntegerValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("i", (new UnknownIntegerValue()).toString());
  }
}
