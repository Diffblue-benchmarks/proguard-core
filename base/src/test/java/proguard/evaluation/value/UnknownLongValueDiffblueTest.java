package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownLongValue.negate()"})
  void testNegate() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualNegateResult = unknownLongValue.negate();

    // Assert
    assertSame(unknownLongValue, actualNegateResult);
  }

  /**
   * Test {@link UnknownLongValue#convertToInteger()}.
   *
   * <p>Method under test: {@link UnknownLongValue#convertToInteger()}
   */
  @Test
  @DisplayName("Test convertToInteger()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownLongValue.convertToInteger()"})
  void testConvertToInteger() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult = new UnknownLongValue().convertToInteger();

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue UnknownLongValue.convertToFloat()"})
  void testConvertToFloat() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = new UnknownLongValue().convertToFloat();

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue UnknownLongValue.convertToDouble()"})
  void testConvertToDouble() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = new UnknownLongValue().convertToDouble();

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownLongValue.generalize(LongValue)"})
  void testGeneralizeWithLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualGeneralizeResult = unknownLongValue.generalize(BasicValueFactory.LONG_VALUE);

    // Assert
    assertSame(unknownLongValue, actualGeneralizeResult);
  }

  /**
   * Test {@link UnknownLongValue#add(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#add(LongValue)}
   */
  @Test
  @DisplayName("Test add(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownLongValue.add(LongValue)"})
  void testAddWithLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualAddResult = unknownLongValue.add(BasicValueFactory.LONG_VALUE);

    // Assert
    assertSame(unknownLongValue, actualAddResult);
  }

  /**
   * Test {@link UnknownLongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#subtract(LongValue)}
   */
  @Test
  @DisplayName("Test subtract(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownLongValue.subtract(LongValue)"})
  void testSubtractWithLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualSubtractResult = unknownLongValue.subtract(BasicValueFactory.LONG_VALUE);

    // Assert
    assertSame(unknownLongValue, actualSubtractResult);
  }

  /**
   * Test {@link UnknownLongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#subtractFrom(LongValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownLongValue.subtractFrom(LongValue)"})
  void testSubtractFromWithLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualSubtractFromResult =
        unknownLongValue.subtractFrom(BasicValueFactory.LONG_VALUE);

    // Assert
    assertSame(unknownLongValue, actualSubtractFromResult);
  }

  /**
   * Test {@link UnknownLongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#multiply(LongValue)}
   */
  @Test
  @DisplayName("Test multiply(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownLongValue.multiply(LongValue)"})
  void testMultiplyWithLongValue() throws ArithmeticException {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualMultiplyResult = unknownLongValue.multiply(BasicValueFactory.LONG_VALUE);

    // Assert
    assertSame(unknownLongValue, actualMultiplyResult);
  }

  /**
   * Test {@link UnknownLongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#divide(LongValue)}
   */
  @Test
  @DisplayName("Test divide(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownLongValue.divide(LongValue)"})
  void testDivideWithLongValue() throws ArithmeticException {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualDivideResult = unknownLongValue.divide(BasicValueFactory.LONG_VALUE);

    // Assert
    assertSame(unknownLongValue, actualDivideResult);
  }

  /**
   * Test {@link UnknownLongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#divideOf(LongValue)}
   */
  @Test
  @DisplayName("Test divideOf(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownLongValue.divideOf(LongValue)"})
  void testDivideOfWithLongValue() throws ArithmeticException {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualDivideOfResult = unknownLongValue.divideOf(BasicValueFactory.LONG_VALUE);

    // Assert
    assertSame(unknownLongValue, actualDivideOfResult);
  }

  /**
   * Test {@link UnknownLongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#remainder(LongValue)}
   */
  @Test
  @DisplayName("Test remainder(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownLongValue.remainder(LongValue)"})
  void testRemainderWithLongValue() throws ArithmeticException {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualRemainderResult = unknownLongValue.remainder(BasicValueFactory.LONG_VALUE);

    // Assert
    assertSame(unknownLongValue, actualRemainderResult);
  }

  /**
   * Test {@link UnknownLongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#remainderOf(LongValue)}
   */
  @Test
  @DisplayName("Test remainderOf(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownLongValue.remainderOf(LongValue)"})
  void testRemainderOfWithLongValue() throws ArithmeticException {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualRemainderOfResult = unknownLongValue.remainderOf(BasicValueFactory.LONG_VALUE);

    // Assert
    assertSame(unknownLongValue, actualRemainderOfResult);
  }

  /**
   * Test {@link UnknownLongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownLongValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualShiftLeftResult =
        unknownLongValue.shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownLongValue, actualShiftLeftResult);
  }

  /**
   * Test {@link UnknownLongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownLongValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualShiftRightResult =
        unknownLongValue.shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownLongValue, actualShiftRightResult);
  }

  /**
   * Test {@link UnknownLongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownLongValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualUnsignedShiftRightResult =
        unknownLongValue.unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownLongValue, actualUnsignedShiftRightResult);
  }

  /**
   * Test {@link UnknownLongValue#and(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#and(LongValue)}
   */
  @Test
  @DisplayName("Test and(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownLongValue.and(LongValue)"})
  void testAndWithLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualAndResult = unknownLongValue.and(BasicValueFactory.LONG_VALUE);

    // Assert
    assertSame(unknownLongValue, actualAndResult);
  }

  /**
   * Test {@link UnknownLongValue#or(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#or(LongValue)}
   */
  @Test
  @DisplayName("Test or(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownLongValue.or(LongValue)"})
  void testOrWithLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualOrResult = unknownLongValue.or(BasicValueFactory.LONG_VALUE);

    // Assert
    assertSame(unknownLongValue, actualOrResult);
  }

  /**
   * Test {@link UnknownLongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#xor(LongValue)}
   */
  @Test
  @DisplayName("Test xor(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownLongValue.xor(LongValue)"})
  void testXorWithLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualXorResult = unknownLongValue.xor(BasicValueFactory.LONG_VALUE);

    // Assert
    assertSame(unknownLongValue, actualXorResult);
  }

  /**
   * Test {@link UnknownLongValue#compare(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownLongValue#compare(LongValue)}
   */
  @Test
  @DisplayName("Test compare(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownLongValue.compare(LongValue)"})
  void testCompareWithLongValue() {
    // Arrange and Act
    IntegerValue actualCompareResult = new UnknownLongValue().compare(BasicValueFactory.LONG_VALUE);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UnknownLongValue.equals(Object)", "int UnknownLongValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();
    UnknownLongValue unknownLongValue2 = new UnknownLongValue();

    // Act and Assert
    assertEquals(unknownLongValue, unknownLongValue2);
    assertEquals(unknownLongValue.hashCode(), unknownLongValue2.hashCode());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UnknownLongValue.equals(Object)", "int UnknownLongValue.hashCode()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UnknownLongValue.equals(Object)", "int UnknownLongValue.hashCode()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UnknownLongValue.equals(Object)", "int UnknownLongValue.hashCode()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UnknownLongValue.equals(Object)", "int UnknownLongValue.hashCode()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnknownLongValue.<init>()",
    "java.lang.String UnknownLongValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("l", new UnknownLongValue().toString());
  }
}
