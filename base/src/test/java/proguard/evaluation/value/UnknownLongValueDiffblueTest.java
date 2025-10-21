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

public class UnknownLongValueDiffblueTest {
  /**
   * Test {@link UnknownLongValue#negate()}.
   *
   * <p>Method under test: {@link UnknownLongValue#negate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownLongValue.negate()"})
  public void testNegate() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.negate());
  }

  /**
   * Test {@link UnknownLongValue#convertToInteger()}.
   *
   * <p>Method under test: {@link UnknownLongValue#convertToInteger()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownLongValue.convertToInteger()"})
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
   * Test {@link UnknownLongValue#convertToFloat()}.
   *
   * <p>Method under test: {@link UnknownLongValue#convertToFloat()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FloatValue UnknownLongValue.convertToFloat()"})
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
   * Test {@link UnknownLongValue#convertToDouble()}.
   *
   * <p>Method under test: {@link UnknownLongValue#convertToDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DoubleValue UnknownLongValue.convertToDouble()"})
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
   * Test {@link UnknownLongValue#generalize(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#generalize(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownLongValue.generalize(LongValue)"})
  public void testGeneralizeWithLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.generalize(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Test {@link UnknownLongValue#add(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#add(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownLongValue.add(LongValue)"})
  public void testAddWithLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.add(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Test {@link UnknownLongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#subtract(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownLongValue.subtract(LongValue)"})
  public void testSubtractWithLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.subtract(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Test {@link UnknownLongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#subtractFrom(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownLongValue.subtractFrom(LongValue)"})
  public void testSubtractFromWithLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.subtractFrom(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Test {@link UnknownLongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#multiply(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownLongValue.multiply(LongValue)"})
  public void testMultiplyWithLongValue() throws ArithmeticException {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.multiply(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Test {@link UnknownLongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#divide(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownLongValue.divide(LongValue)"})
  public void testDivideWithLongValue() throws ArithmeticException {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.divide(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Test {@link UnknownLongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#divideOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownLongValue.divideOf(LongValue)"})
  public void testDivideOfWithLongValue() throws ArithmeticException {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.divideOf(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Test {@link UnknownLongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#remainder(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownLongValue.remainder(LongValue)"})
  public void testRemainderWithLongValue() throws ArithmeticException {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.remainder(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Test {@link UnknownLongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#remainderOf(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownLongValue.remainderOf(LongValue)"})
  public void testRemainderOfWithLongValue() throws ArithmeticException {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.remainderOf(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Test {@link UnknownLongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownLongValue.shiftLeft(IntegerValue)"})
  public void testShiftLeftWithIntegerValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(
        unknownLongValue, unknownLongValue.shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownLongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#shiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownLongValue.shiftRight(IntegerValue)"})
  public void testShiftRightWithIntegerValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(
        unknownLongValue, unknownLongValue.shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownLongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownLongValue.unsignedShiftRight(IntegerValue)"})
  public void testUnsignedShiftRightWithIntegerValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(
        unknownLongValue,
        unknownLongValue.unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownLongValue#and(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#and(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownLongValue.and(LongValue)"})
  public void testAndWithLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.and(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Test {@link UnknownLongValue#or(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#or(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownLongValue.or(LongValue)"})
  public void testOrWithLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.or(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Test {@link UnknownLongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#xor(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LongValue UnknownLongValue.xor(LongValue)"})
  public void testXorWithLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertSame(unknownLongValue, unknownLongValue.xor(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Test {@link UnknownLongValue#compare(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#compare(LongValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"IntegerValue UnknownLongValue.compare(LongValue)"})
  public void testCompareWithLongValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        (new UnknownLongValue()).compare(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link UnknownLongValue#equals(Object)}, and {@link UnknownLongValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UnknownLongValue#equals(Object)}
   *   <li>{@link UnknownLongValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnknownLongValue.equals(Object)", "int UnknownLongValue.hashCode()"})
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
   * Test {@link UnknownLongValue#equals(Object)}, and {@link UnknownLongValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UnknownLongValue#equals(Object)}
   *   <li>{@link UnknownLongValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnknownLongValue.equals(Object)", "int UnknownLongValue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act and Assert
    assertEquals(unknownLongValue, unknownLongValue);
    int expectedHashCodeResult = unknownLongValue.hashCode();
    assertEquals(expectedHashCodeResult, unknownLongValue.hashCode());
  }

  /**
   * Test {@link UnknownLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownLongValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnknownLongValue.equals(Object)", "int UnknownLongValue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownLongValue(), 1);
  }

  /**
   * Test {@link UnknownLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownLongValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnknownLongValue.equals(Object)", "int UnknownLongValue.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownLongValue(), null);
  }

  /**
   * Test {@link UnknownLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UnknownLongValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean UnknownLongValue.equals(Object)", "int UnknownLongValue.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UnknownLongValue(), "Different type to UnknownLongValue");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UnknownLongValue}
   *   <li>{@link UnknownLongValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UnknownLongValue.<init>()",
    "java.lang.String UnknownLongValue.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("l", (new UnknownLongValue()).toString());
  }
}
