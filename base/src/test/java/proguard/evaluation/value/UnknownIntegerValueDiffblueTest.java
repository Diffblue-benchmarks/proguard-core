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

class UnknownIntegerValueDiffblueTest {
  /**
   * Test {@link UnknownIntegerValue#negate()}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#negate()}
   */
  @Test
  @DisplayName("Test negate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.negate()"})
  void testNegate() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualNegateResult = unknownIntegerValue.negate();

    // Assert
    assertSame(unknownIntegerValue, actualNegateResult);
  }

  /**
   * Test {@link UnknownIntegerValue#convertToByte()}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#convertToByte()}
   */
  @Test
  @DisplayName("Test convertToByte()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.convertToByte()"})
  void testConvertToByte() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualConvertToByteResult = unknownIntegerValue.convertToByte();

    // Assert
    assertSame(unknownIntegerValue, actualConvertToByteResult);
  }

  /**
   * Test {@link UnknownIntegerValue#convertToCharacter()}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#convertToCharacter()}
   */
  @Test
  @DisplayName("Test convertToCharacter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.convertToCharacter()"})
  void testConvertToCharacter() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualConvertToCharacterResult = unknownIntegerValue.convertToCharacter();

    // Assert
    assertSame(unknownIntegerValue, actualConvertToCharacterResult);
  }

  /**
   * Test {@link UnknownIntegerValue#convertToShort()}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#convertToShort()}
   */
  @Test
  @DisplayName("Test convertToShort()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.convertToShort()"})
  void testConvertToShort() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualConvertToShortResult = unknownIntegerValue.convertToShort();

    // Assert
    assertSame(unknownIntegerValue, actualConvertToShortResult);
  }

  /**
   * Test {@link UnknownIntegerValue#convertToLong()}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#convertToLong()}
   */
  @Test
  @DisplayName("Test convertToLong()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownIntegerValue.convertToLong()"})
  void testConvertToLong() {
    // Arrange and Act
    LongValue actualConvertToLongResult = new UnknownIntegerValue().convertToLong();

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
  @DisplayName("Test convertToFloat()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue UnknownIntegerValue.convertToFloat()"})
  void testConvertToFloat() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = new UnknownIntegerValue().convertToFloat();

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
  @DisplayName("Test convertToDouble()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue UnknownIntegerValue.convertToDouble()"})
  void testConvertToDouble() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = new UnknownIntegerValue().convertToDouble();

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
  @DisplayName("Test generalize(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.generalize(IntegerValue)"})
  void testGeneralizeWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualGeneralizeResult =
        unknownIntegerValue.generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualGeneralizeResult);
  }

  /**
   * Test {@link UnknownIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName("Test add(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.add(IntegerValue)"})
  void testAddWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualAddResult =
        unknownIntegerValue.add(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualAddResult);
  }

  /**
   * Test {@link UnknownIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.subtract(IntegerValue)"})
  void testSubtractWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualSubtractResult =
        unknownIntegerValue.subtract(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualSubtractResult);
  }

  /**
   * Test {@link UnknownIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.subtractFrom(IntegerValue)"})
  void testSubtractFromWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualSubtractFromResult =
        unknownIntegerValue.subtractFrom(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualSubtractFromResult);
  }

  /**
   * Test {@link UnknownIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.multiply(IntegerValue)"})
  void testMultiplyWithIntegerValue() throws ArithmeticException {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualMultiplyResult =
        unknownIntegerValue.multiply(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualMultiplyResult);
  }

  /**
   * Test {@link UnknownIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName("Test divide(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.divide(IntegerValue)"})
  void testDivideWithIntegerValue() throws ArithmeticException {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualDivideResult =
        unknownIntegerValue.divide(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualDivideResult);
  }

  /**
   * Test {@link UnknownIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.divideOf(IntegerValue)"})
  void testDivideOfWithIntegerValue() throws ArithmeticException {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualDivideOfResult =
        unknownIntegerValue.divideOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualDivideOfResult);
  }

  /**
   * Test {@link UnknownIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.remainder(IntegerValue)"})
  void testRemainderWithIntegerValue() throws ArithmeticException {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualRemainderResult =
        unknownIntegerValue.remainder(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualRemainderResult);
  }

  /**
   * Test {@link UnknownIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.remainderOf(IntegerValue)"})
  void testRemainderOfWithIntegerValue() throws ArithmeticException {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualRemainderOfResult =
        unknownIntegerValue.remainderOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualRemainderOfResult);
  }

  /**
   * Test {@link UnknownIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftLeftResult =
        unknownIntegerValue.shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualShiftLeftResult);
  }

  /**
   * Test {@link UnknownIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.shiftLeftOf(IntegerValue)"})
  void testShiftLeftOfWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftLeftOfResult =
        unknownIntegerValue.shiftLeftOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualShiftLeftOfResult);
  }

  /**
   * Test {@link UnknownIntegerValue#shiftLeftOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownIntegerValue.shiftLeftOf(LongValue)"})
  void testShiftLeftOfWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualShiftLeftOfResult = new UnknownIntegerValue().shiftLeftOf(other);

    // Assert
    assertSame(other, actualShiftLeftOfResult);
  }

  /**
   * Test {@link UnknownIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftRightResult =
        unknownIntegerValue.shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualShiftRightResult);
  }

  /**
   * Test {@link UnknownIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.shiftRightOf(IntegerValue)"})
  void testShiftRightOfWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftRightOfResult =
        unknownIntegerValue.shiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualShiftRightOfResult);
  }

  /**
   * Test {@link UnknownIntegerValue#shiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownIntegerValue.shiftRightOf(LongValue)"})
  void testShiftRightOfWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualShiftRightOfResult = new UnknownIntegerValue().shiftRightOf(other);

    // Assert
    assertSame(other, actualShiftRightOfResult);
  }

  /**
   * Test {@link UnknownIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        unknownIntegerValue.unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualUnsignedShiftRightResult);
  }

  /**
   * Test {@link UnknownIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  void testUnsignedShiftRightOfWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        unknownIntegerValue.unsignedShiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link UnknownIntegerValue#unsignedShiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue UnknownIntegerValue.unsignedShiftRightOf(LongValue)"})
  void testUnsignedShiftRightOfWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        new UnknownIntegerValue().unsignedShiftRightOf(other);

    // Assert
    assertSame(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link UnknownIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName("Test and(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.and(IntegerValue)"})
  void testAndWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualAndResult =
        unknownIntegerValue.and(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualAndResult);
  }

  /**
   * Test {@link UnknownIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName("Test or(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.or(IntegerValue)"})
  void testOrWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualOrResult = unknownIntegerValue.or(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualOrResult);
  }

  /**
   * Test {@link UnknownIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#xor(IntegerValue)}
   */
  @Test
  @DisplayName("Test xor(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue UnknownIntegerValue.xor(IntegerValue)"})
  void testXorWithIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualXorResult =
        unknownIntegerValue.xor(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualXorResult);
  }

  /**
   * Test {@link UnknownIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName("Test equal(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UnknownIntegerValue.equal(IntegerValue)"})
  void testEqualWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(0, new UnknownIntegerValue().equal(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UnknownIntegerValue.lessThan(IntegerValue)"})
  void testLessThanWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(0, new UnknownIntegerValue().lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link UnknownIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link UnknownIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int UnknownIntegerValue.lessThanOrEqual(IntegerValue)"})
  void testLessThanOrEqualWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0, new UnknownIntegerValue().lessThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UnknownIntegerValue.equals(Object)",
    "int UnknownIntegerValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();
    UnknownIntegerValue unknownIntegerValue2 = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(unknownIntegerValue, unknownIntegerValue2);
    assertEquals(unknownIntegerValue.hashCode(), unknownIntegerValue2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UnknownIntegerValue.equals(Object)",
    "int UnknownIntegerValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UnknownIntegerValue.equals(Object)",
    "int UnknownIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UnknownIntegerValue.equals(Object)",
    "int UnknownIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UnknownIntegerValue.equals(Object)",
    "int UnknownIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnknownIntegerValue.<init>()",
    "java.lang.String UnknownIntegerValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("i", new UnknownIntegerValue().toString());
  }
}
