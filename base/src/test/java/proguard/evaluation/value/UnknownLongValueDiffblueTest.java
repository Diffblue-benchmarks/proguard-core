package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UnknownLongValueDiffblueTest {
  /**
   * Test {@link UnknownLongValue#negate()}.
   *
   * <p>Method under test: {@link UnknownLongValue#negate()}
   */
  @Test
  @DisplayName("Test negate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.UnknownLongValue.negate()"
  })
  void testNegate() {
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
  @DisplayName("Test convertToInteger()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.UnknownLongValue.convertToInteger()"
  })
  void testConvertToInteger() {
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
  @DisplayName("Test convertToFloat()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.UnknownLongValue.convertToFloat()"
  })
  void testConvertToFloat() {
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
  @DisplayName("Test convertToDouble()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.UnknownLongValue.convertToDouble()"
  })
  void testConvertToDouble() {
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
  @DisplayName("Test generalize(LongValue) with 'LongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.UnknownLongValue.generalize(proguard.evaluation.value.LongValue)"
  })
  void testGeneralizeWithLongValue() {
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
  @DisplayName("Test add(LongValue) with 'LongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.UnknownLongValue.add(proguard.evaluation.value.LongValue)"
  })
  void testAddWithLongValue() {
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
  @DisplayName("Test subtract(LongValue) with 'LongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.UnknownLongValue.subtract(proguard.evaluation.value.LongValue)"
  })
  void testSubtractWithLongValue() {
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
  @DisplayName("Test subtractFrom(LongValue) with 'LongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.UnknownLongValue.subtractFrom(proguard.evaluation.value.LongValue)"
  })
  void testSubtractFromWithLongValue() {
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
  @DisplayName("Test multiply(LongValue) with 'LongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.UnknownLongValue.multiply(proguard.evaluation.value.LongValue)"
  })
  void testMultiplyWithLongValue() throws ArithmeticException {
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
  @DisplayName("Test divide(LongValue) with 'LongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.UnknownLongValue.divide(proguard.evaluation.value.LongValue)"
  })
  void testDivideWithLongValue() throws ArithmeticException {
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
  @DisplayName("Test divideOf(LongValue) with 'LongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.UnknownLongValue.divideOf(proguard.evaluation.value.LongValue)"
  })
  void testDivideOfWithLongValue() throws ArithmeticException {
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
  @DisplayName("Test remainder(LongValue) with 'LongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.UnknownLongValue.remainder(proguard.evaluation.value.LongValue)"
  })
  void testRemainderWithLongValue() throws ArithmeticException {
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
  @DisplayName("Test remainderOf(LongValue) with 'LongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.UnknownLongValue.remainderOf(proguard.evaluation.value.LongValue)"
  })
  void testRemainderOfWithLongValue() throws ArithmeticException {
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
  @DisplayName("Test shiftLeft(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.UnknownLongValue.shiftLeft(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftWithIntegerValue() {
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
  @DisplayName("Test shiftRight(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.UnknownLongValue.shiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightWithIntegerValue() {
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
  @DisplayName("Test unsignedShiftRight(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.UnknownLongValue.unsignedShiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightWithIntegerValue() {
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
  @DisplayName("Test and(LongValue) with 'LongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.UnknownLongValue.and(proguard.evaluation.value.LongValue)"
  })
  void testAndWithLongValue() {
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
  @DisplayName("Test or(LongValue) with 'LongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.UnknownLongValue.or(proguard.evaluation.value.LongValue)"
  })
  void testOrWithLongValue() {
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
  @DisplayName("Test xor(LongValue) with 'LongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.UnknownLongValue.xor(proguard.evaluation.value.LongValue)"
  })
  void testXorWithLongValue() {
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
  @DisplayName("Test compare(LongValue) with 'LongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.UnknownLongValue.compare(proguard.evaluation.value.LongValue)"
  })
  void testCompareWithLongValue() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.UnknownLongValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.UnknownLongValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.UnknownLongValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.UnknownLongValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.UnknownLongValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.UnknownLongValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.UnknownLongValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.UnknownLongValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.UnknownLongValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.UnknownLongValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.UnknownLongValue.<init>()",
    "java.lang.String proguard.evaluation.value.UnknownLongValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("l", (new UnknownLongValue()).toString());
  }
}
