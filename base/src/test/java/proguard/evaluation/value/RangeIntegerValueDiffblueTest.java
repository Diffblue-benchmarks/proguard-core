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

class RangeIntegerValueDiffblueTest {
  /**
   * Test {@link RangeIntegerValue#RangeIntegerValue(int, int)}.
   *
   * <p>Method under test: {@link RangeIntegerValue#RangeIntegerValue(int, int)}
   */
  @Test
  @DisplayName("Test new RangeIntegerValue(int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RangeIntegerValue.<init>(int, int)"})
  void testNewRangeIntegerValue() {
    // Arrange and Act
    RangeIntegerValue actualRangeIntegerValue = new RangeIntegerValue(1, 3);

    // Assert
    assertFalse(actualRangeIntegerValue.isCategory2());
    assertFalse(actualRangeIntegerValue.isParticular());
    assertFalse(actualRangeIntegerValue.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#value()}.
   *
   * <p>Method under test: {@link RangeIntegerValue#value()}
   */
  @Test
  @DisplayName("Test value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.value()"})
  void testValue() {
    // Arrange, Act and Assert
    assertEquals(1, new RangeIntegerValue(1, 3).value());
  }

  /**
   * Test {@link RangeIntegerValue#negate()}.
   *
   * <ul>
   *   <li>Then return not Particular.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#negate()}
   */
  @Test
  @DisplayName("Test negate(); then return not Particular")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.negate()"})
  void testNegate_thenReturnNotParticular() {
    // Arrange and Act
    IntegerValue actualNegateResult = new RangeIntegerValue(1, 3).negate();

    // Assert
    assertTrue(actualNegateResult instanceof RangeIntegerValue);
    assertFalse(actualNegateResult.isCategory2());
    assertFalse(actualNegateResult.isParticular());
    assertFalse(actualNegateResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#negate()}.
   *
   * <ul>
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#negate()}
   */
  @Test
  @DisplayName("Test negate(); then return Particular")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.negate()"})
  void testNegate_thenReturnParticular() {
    // Arrange and Act
    IntegerValue actualNegateResult = new RangeIntegerValue(Integer.MIN_VALUE, 3).negate();

    // Assert
    assertTrue(actualNegateResult instanceof RangeIntegerValue);
    assertFalse(actualNegateResult.isCategory2());
    assertFalse(actualNegateResult.isSpecific());
    assertTrue(actualNegateResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#convertToByte()}.
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToByte()}
   */
  @Test
  @DisplayName("Test convertToByte()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToByte()"})
  void testConvertToByte() {
    // Arrange and Act
    IntegerValue actualConvertToByteResult = new RangeIntegerValue(-128, 128).convertToByte();

    // Assert
    assertTrue(actualConvertToByteResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToByteResult.isCategory2());
    assertFalse(actualConvertToByteResult.isParticular());
    assertFalse(actualConvertToByteResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#convertToByte()}.
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToByte()}
   */
  @Test
  @DisplayName("Test convertToByte()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToByte()"})
  void testConvertToByte2() {
    // Arrange and Act
    IntegerValue actualConvertToByteResult =
        new RangeIntegerValue(-129, Float.MAX_EXPONENT).convertToByte();

    // Assert
    assertTrue(actualConvertToByteResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToByteResult.isCategory2());
    assertFalse(actualConvertToByteResult.isParticular());
    assertFalse(actualConvertToByteResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#convertToByte()}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max
   *       is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToByte()}
   */
  @Test
  @DisplayName(
      "Test convertToByte(); then return RangeIntegerValue(int, int) with min is one and max is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToByte()"})
  void testConvertToByte_thenReturnRangeIntegerValueWithMinIsOneAndMaxIsThree() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualConvertToByteResult = rangeIntegerValue.convertToByte();

    // Assert
    assertSame(rangeIntegerValue, actualConvertToByteResult);
  }

  /**
   * Test {@link RangeIntegerValue#convertToCharacter()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is {@link
   *       Value#NEVER} and max is {@code 65535}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToCharacter()}
   */
  @Test
  @DisplayName(
      "Test convertToCharacter(); given RangeIntegerValue(int, int) with min is NEVER and max is '65535'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToCharacter()"})
  void testConvertToCharacter_givenRangeIntegerValueWithMinIsNeverAndMaxIs65535() {
    // Arrange and Act
    IntegerValue actualConvertToCharacterResult =
        new RangeIntegerValue(Value.NEVER, 65535).convertToCharacter();

    // Assert
    assertTrue(actualConvertToCharacterResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToCharacterResult.isCategory2());
    assertFalse(actualConvertToCharacterResult.isParticular());
    assertFalse(actualConvertToCharacterResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#convertToCharacter()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is zero and max is
   *       {@code 65536}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToCharacter()}
   */
  @Test
  @DisplayName(
      "Test convertToCharacter(); given RangeIntegerValue(int, int) with min is zero and max is '65536'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToCharacter()"})
  void testConvertToCharacter_givenRangeIntegerValueWithMinIsZeroAndMaxIs65536() {
    // Arrange and Act
    IntegerValue actualConvertToCharacterResult =
        new RangeIntegerValue(0, 65536).convertToCharacter();

    // Assert
    assertTrue(actualConvertToCharacterResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToCharacterResult.isCategory2());
    assertFalse(actualConvertToCharacterResult.isParticular());
    assertFalse(actualConvertToCharacterResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#convertToCharacter()}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max
   *       is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToCharacter()}
   */
  @Test
  @DisplayName(
      "Test convertToCharacter(); then return RangeIntegerValue(int, int) with min is one and max is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToCharacter()"})
  void testConvertToCharacter_thenReturnRangeIntegerValueWithMinIsOneAndMaxIsThree() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualConvertToCharacterResult = rangeIntegerValue.convertToCharacter();

    // Assert
    assertSame(rangeIntegerValue, actualConvertToCharacterResult);
  }

  /**
   * Test {@link RangeIntegerValue#convertToShort()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is {@code -32768}
   *       and max is {@code 32768}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToShort()}
   */
  @Test
  @DisplayName(
      "Test convertToShort(); given RangeIntegerValue(int, int) with min is '-32768' and max is '32768'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToShort()"})
  void testConvertToShort_givenRangeIntegerValueWithMinIs32768AndMaxIs32768() {
    // Arrange and Act
    IntegerValue actualConvertToShortResult = new RangeIntegerValue(-32768, 32768).convertToShort();

    // Assert
    assertTrue(actualConvertToShortResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToShortResult.isCategory2());
    assertFalse(actualConvertToShortResult.isParticular());
    assertFalse(actualConvertToShortResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#convertToShort()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is {@code -32769}
   *       and max is {@code 32767}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToShort()}
   */
  @Test
  @DisplayName(
      "Test convertToShort(); given RangeIntegerValue(int, int) with min is '-32769' and max is '32767'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToShort()"})
  void testConvertToShort_givenRangeIntegerValueWithMinIs32769AndMaxIs32767() {
    // Arrange and Act
    IntegerValue actualConvertToShortResult = new RangeIntegerValue(-32769, 32767).convertToShort();

    // Assert
    assertTrue(actualConvertToShortResult instanceof RangeIntegerValue);
    assertFalse(actualConvertToShortResult.isCategory2());
    assertFalse(actualConvertToShortResult.isParticular());
    assertFalse(actualConvertToShortResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#convertToShort()}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max
   *       is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToShort()}
   */
  @Test
  @DisplayName(
      "Test convertToShort(); then return RangeIntegerValue(int, int) with min is one and max is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.convertToShort()"})
  void testConvertToShort_thenReturnRangeIntegerValueWithMinIsOneAndMaxIsThree() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualConvertToShortResult = rangeIntegerValue.convertToShort();

    // Assert
    assertSame(rangeIntegerValue, actualConvertToShortResult);
  }

  /**
   * Test {@link RangeIntegerValue#convertToLong()}.
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToLong()}
   */
  @Test
  @DisplayName("Test convertToLong()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue RangeIntegerValue.convertToLong()"})
  void testConvertToLong() {
    // Arrange and Act
    LongValue actualConvertToLongResult = new RangeIntegerValue(1, 3).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof UnknownLongValue);
    assertFalse(actualConvertToLongResult.isParticular());
    assertFalse(actualConvertToLongResult.isSpecific());
    assertTrue(actualConvertToLongResult.isCategory2());
  }

  /**
   * Test {@link RangeIntegerValue#convertToFloat()}.
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToFloat()}
   */
  @Test
  @DisplayName("Test convertToFloat()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue RangeIntegerValue.convertToFloat()"})
  void testConvertToFloat() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = new RangeIntegerValue(1, 3).convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof UnknownFloatValue);
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertFalse(actualConvertToFloatResult.isParticular());
    assertFalse(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#convertToDouble()}.
   *
   * <p>Method under test: {@link RangeIntegerValue#convertToDouble()}
   */
  @Test
  @DisplayName("Test convertToDouble()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue RangeIntegerValue.convertToDouble()"})
  void testConvertToDouble() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = new RangeIntegerValue(1, 3).convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof UnknownDoubleValue);
    assertFalse(actualConvertToDoubleResult.isParticular());
    assertFalse(actualConvertToDoubleResult.isSpecific());
    assertTrue(actualConvertToDoubleResult.isCategory2());
  }

  /**
   * Test {@link RangeIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(IntegerValue)"})
  void testGeneralizeWithIntegerValue() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult =
        new RangeIntegerValue(Integer.MIN_VALUE, 3)
            .generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(IntegerValue)"})
  void testGeneralizeWithIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualGeneralizeResult =
        rangeIntegerValue.generalize(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertSame(rangeIntegerValue, actualGeneralizeResult);
  }

  /**
   * Test {@link RangeIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(IntegerValue)"})
  void testGeneralizeWithIntegerValue3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue =
        new RangeIntegerValue(Integer.MIN_VALUE, Float.MAX_EXPONENT);

    // Act
    IntegerValue actualGeneralizeResult =
        rangeIntegerValue.generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(rangeIntegerValue, actualGeneralizeResult);
  }

  /**
   * Test {@link RangeIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(IntegerValue) with 'IntegerValue'; then return INTEGER_VALUE_BYTE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(IntegerValue)"})
  void testGeneralizeWithIntegerValue_thenReturnInteger_value_byte() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act
    IntegerValue actualGeneralizeResult = new RangeIntegerValue(1, 3).generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link RangeIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(IntegerValue) with 'IntegerValue'; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(IntegerValue)"})
  void testGeneralizeWithIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualGeneralizeResult =
        rangeIntegerValue.generalize(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(IntegerValue)"})
  void testGeneralizeWithIntegerValue_whenInteger_value_0_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult =
        new RangeIntegerValue(1, 3).generalize(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_4}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_4; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(IntegerValue)"})
  void testGeneralizeWithIntegerValue_whenInteger_value_4_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult =
        new RangeIntegerValue(1, 3).generalize(ParticularValueFactory.INTEGER_VALUE_4);

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(IntegerValue)"})
  void testGeneralizeWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualGeneralizeResult = new RangeIntegerValue(1, 3).generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link RangeIntegerValue#generalize(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(ParticularIntegerValue)"})
  void testGeneralizeWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act
    IntegerValue actualGeneralizeResult =
        rangeIntegerValue.generalize(new ParticularIntegerValue(42));

    // Assert
    assertSame(rangeIntegerValue, actualGeneralizeResult);
  }

  /**
   * Test {@link RangeIntegerValue#generalize(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(ParticularIntegerValue)"})
  void testGeneralizeWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualGeneralizeResult =
        rangeIntegerValue.generalize(new ParticularIntegerValue(0));

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#generalize(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(ParticularIntegerValue)"})
  void testGeneralizeWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualGeneralizeResult =
        rangeIntegerValue.generalize(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#generalize(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(RangeIntegerValue)"})
  void testGeneralizeWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualGeneralizeResult = rangeIntegerValue.generalize(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(rangeIntegerValue, actualGeneralizeResult);
  }

  /**
   * Test {@link RangeIntegerValue#generalize(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(RangeIntegerValue)"})
  void testGeneralizeWithRangeIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(3, 3);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualGeneralizeResult = rangeIntegerValue.generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link RangeIntegerValue#generalize(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(RangeIntegerValue)"})
  void testGeneralizeWithRangeIntegerValue3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 1);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualGeneralizeResult = rangeIntegerValue.generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link RangeIntegerValue#generalize(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(RangeIntegerValue)"})
  void testGeneralizeWithRangeIntegerValue4() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, 1);

    // Act
    IntegerValue actualGeneralizeResult = rangeIntegerValue.generalize(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#generalize(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>When {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(RangeIntegerValue) with 'RangeIntegerValue'; when RangeIntegerValue(int, int) with min is one and max is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.generalize(RangeIntegerValue)"})
  void testGeneralizeWithRangeIntegerValue_whenRangeIntegerValueWithMinIsOneAndMaxIsOne() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(3, 3);

    // Act
    IntegerValue actualGeneralizeResult = rangeIntegerValue.generalize(new RangeIntegerValue(1, 1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is {@link
   *       Integer#MIN_VALUE} and max is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; given RangeIntegerValue(int, int) with min is MIN_VALUE and max is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  void testAddWithIntegerValue_givenRangeIntegerValueWithMinIsMin_valueAndMaxIsThree() {
    // Arrange and Act
    IntegerValue actualAddResult =
        new RangeIntegerValue(Integer.MIN_VALUE, 3).add(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is {@link
   *       Integer#MIN_VALUE} and max is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; given RangeIntegerValue(int, int) with min is MIN_VALUE and max is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  void testAddWithIntegerValue_givenRangeIntegerValueWithMinIsMin_valueAndMaxIsThree2() {
    // Arrange and Act
    IntegerValue actualAddResult =
        new RangeIntegerValue(Integer.MIN_VALUE, 3).add(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName("Test add(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  void testAddWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAddResult =
        rangeIntegerValue.add(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max
   *       is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue(int, int) with min is one and max is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  void testAddWithIntegerValue_thenReturnRangeIntegerValueWithMinIsOneAndMaxIsThree() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAddResult = rangeIntegerValue.add(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertSame(rangeIntegerValue, actualAddResult);
  }

  /**
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_1; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  void testAddWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        new RangeIntegerValue(1, 3).add(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  void testAddWithIntegerValue_whenInteger_value_byte_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        new RangeIntegerValue(1, 3).add(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link RangeValueFactory#INTEGER_VALUE_INT}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_INT; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  void testAddWithIntegerValue_whenInteger_value_int_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        new RangeIntegerValue(1, 3).add(RangeValueFactory.INTEGER_VALUE_INT);

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_M1; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  void testAddWithIntegerValue_whenInteger_value_m1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        new RangeIntegerValue(1, 3).add(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(IntegerValue)"})
  void testAddWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualAddResult = new RangeIntegerValue(1, 3).add(other);

    // Assert
    assertSame(other, actualAddResult);
  }

  /**
   * Test {@link RangeIntegerValue#add(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test add(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(ParticularIntegerValue)"})
  void testAddWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAddResult = rangeIntegerValue.add(new ParticularIntegerValue(0));

    // Assert
    assertSame(rangeIntegerValue, actualAddResult);
  }

  /**
   * Test {@link RangeIntegerValue#add(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(ParticularIntegerValue)"})
  void testAddWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAddResult = rangeIntegerValue.add(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(ParticularIntegerValue)"})
  void testAddWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualAddResult = rangeIntegerValue.add(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularIntegerValue) with 'ParticularIntegerValue'; when ParticularIntegerValue(int) with value is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(ParticularIntegerValue)"})
  void testAddWithParticularIntegerValue_whenParticularIntegerValueWithValueIsFortyTwo() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAddResult = rangeIntegerValue.add(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Integer#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularIntegerValue) with 'ParticularIntegerValue'; when ParticularIntegerValue(int) with value is MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(ParticularIntegerValue)"})
  void testAddWithParticularIntegerValue_whenParticularIntegerValueWithValueIsMax_value() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualAddResult =
        rangeIntegerValue.add(new ParticularIntegerValue(Integer.MAX_VALUE));

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test add(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(RangeIntegerValue)"})
  void testAddWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MAX_VALUE, 3);

    // Act
    IntegerValue actualAddResult = rangeIntegerValue.add(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@link Integer#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(RangeIntegerValue) with 'RangeIntegerValue'; given RangeIntegerValue(int, int) with min is one and max is MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(RangeIntegerValue)"})
  void testAddWithRangeIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsMax_value() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, Integer.MAX_VALUE);

    // Act
    IntegerValue actualAddResult = rangeIntegerValue.add(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#add(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.add(RangeIntegerValue)"})
  void testAddWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAddResult = rangeIntegerValue.add(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  void testSubtractWithIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        new RangeIntegerValue(Integer.MIN_VALUE, 3)
            .subtract(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  void testSubtractWithIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractResult =
        rangeIntegerValue.subtract(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertSame(rangeIntegerValue, actualSubtractResult);
  }

  /**
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  void testSubtractWithIntegerValue3() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        new RangeIntegerValue(Integer.MIN_VALUE, 3)
            .subtract(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  void testSubtractWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractResult =
        rangeIntegerValue.subtract(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_1; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  void testSubtractWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        new RangeIntegerValue(1, 3).subtract(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  void testSubtractWithIntegerValue_whenInteger_value_byte_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        new RangeIntegerValue(1, 3).subtract(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link RangeValueFactory#INTEGER_VALUE_INT}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_INT; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  void testSubtractWithIntegerValue_whenInteger_value_int_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        new RangeIntegerValue(1, 3).subtract(RangeValueFactory.INTEGER_VALUE_INT);

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_M1; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  void testSubtractWithIntegerValue_whenInteger_value_m1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        new RangeIntegerValue(1, 3).subtract(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(IntegerValue)"})
  void testSubtractWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualSubtractResult = new RangeIntegerValue(1, 3).subtract(other);

    // Assert
    assertSame(other, actualSubtractResult);
  }

  /**
   * Test {@link RangeIntegerValue#subtract(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(ParticularIntegerValue)"})
  void testSubtractWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractResult = rangeIntegerValue.subtract(new ParticularIntegerValue(0));

    // Assert
    assertSame(rangeIntegerValue, actualSubtractResult);
  }

  /**
   * Test {@link RangeIntegerValue#subtract(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(ParticularIntegerValue)"})
  void testSubtractWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractResult =
        rangeIntegerValue.subtract(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(ParticularIntegerValue)"})
  void testSubtractWithParticularIntegerValue3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualSubtractResult = rangeIntegerValue.subtract(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(ParticularIntegerValue)"})
  void testSubtractWithParticularIntegerValue4() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractResult =
        rangeIntegerValue.subtract(new ParticularIntegerValue(Integer.MIN_VALUE));

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(ParticularIntegerValue)"})
  void testSubtractWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractResult = rangeIntegerValue.subtract(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(RangeIntegerValue)"})
  void testSubtractWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualSubtractResult = rangeIntegerValue.subtract(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(RangeIntegerValue)"})
  void testSubtractWithRangeIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, Integer.MIN_VALUE);

    // Act
    IntegerValue actualSubtractResult = rangeIntegerValue.subtract(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtract(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtract(RangeIntegerValue)"})
  void testSubtractWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractResult = rangeIntegerValue.subtract(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(IntegerValue)"})
  void testSubtractFromWithIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        new RangeIntegerValue(Integer.MIN_VALUE, 3)
            .subtractFrom(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(IntegerValue)"})
  void testSubtractFromWithIntegerValue2() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        new RangeIntegerValue(Integer.MIN_VALUE, 3)
            .subtractFrom(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(IntegerValue)"})
  void testSubtractFromWithIntegerValue3() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        new RangeIntegerValue(1, Integer.MIN_VALUE)
            .subtractFrom(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(IntegerValue)"})
  void testSubtractFromWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractFromResult =
        rangeIntegerValue.subtractFrom(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(IntegerValue)"})
  void testSubtractFromWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        new RangeIntegerValue(1, 3).subtractFrom(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(IntegerValue)"})
  void testSubtractFromWithIntegerValue_whenInteger_value_0_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        new RangeIntegerValue(1, 3).subtractFrom(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link RangeValueFactory#INTEGER_VALUE_INT}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_INT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(IntegerValue)"})
  void testSubtractFromWithIntegerValue_whenInteger_value_int() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        new RangeIntegerValue(1, 3).subtractFrom(RangeValueFactory.INTEGER_VALUE_INT);

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(IntegerValue)"})
  void testSubtractFromWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualSubtractFromResult = new RangeIntegerValue(1, 3).subtractFrom(other);

    // Assert
    assertSame(other, actualSubtractFromResult);
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(ParticularIntegerValue)"})
  void testSubtractFromWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualSubtractFromResult =
        rangeIntegerValue.subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(ParticularIntegerValue)"})
  void testSubtractFromWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, Integer.MIN_VALUE);

    // Act
    IntegerValue actualSubtractFromResult =
        rangeIntegerValue.subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(ParticularIntegerValue)"})
  void testSubtractFromWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractFromResult =
        rangeIntegerValue.subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(RangeIntegerValue)"})
  void testSubtractFromWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualSubtractFromResult =
        rangeIntegerValue.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(RangeIntegerValue)"})
  void testSubtractFromWithRangeIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, Integer.MIN_VALUE);

    // Act
    IntegerValue actualSubtractFromResult =
        rangeIntegerValue.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#subtractFrom(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.subtractFrom(RangeIntegerValue)"})
  void testSubtractFromWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualSubtractFromResult =
        rangeIntegerValue.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  void testMultiplyWithIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualMultiplyResult =
        rangeIntegerValue.multiply(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertSame(rangeIntegerValue, actualMultiplyResult);
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  void testMultiplyWithIntegerValue2() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        new RangeIntegerValue(Integer.MIN_VALUE, 3)
            .multiply(ParticularValueFactory.INTEGER_VALUE_2);

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(IntegerValue) with 'IntegerValue'; given RangeIntegerValue(int, int) with min is one and max is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  void testMultiplyWithIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsMin_value() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        new RangeIntegerValue(1, Integer.MIN_VALUE)
            .multiply(ParticularValueFactory.INTEGER_VALUE_2);

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  void testMultiplyWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualMultiplyResult =
        rangeIntegerValue.multiply(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return INTEGER_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  void testMultiplyWithIntegerValue_whenInteger_value_0_thenReturnInteger_value_0() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualMultiplyResult = new RangeIntegerValue(1, 3).multiply(other);

    // Assert
    assertSame(other, actualMultiplyResult);
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_2}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_2; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  void testMultiplyWithIntegerValue_whenInteger_value_2_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        new RangeIntegerValue(1, 3).multiply(ParticularValueFactory.INTEGER_VALUE_2);

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  void testMultiplyWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        new RangeIntegerValue(1, 3).multiply(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_M1; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  void testMultiplyWithIntegerValue_whenInteger_value_m1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        new RangeIntegerValue(1, 3).multiply(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(IntegerValue)"})
  void testMultiplyWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualMultiplyResult = new RangeIntegerValue(1, 3).multiply(other);

    // Assert
    assertSame(other, actualMultiplyResult);
  }

  /**
   * Test {@link RangeIntegerValue#multiply(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(ParticularIntegerValue)"})
  void testMultiplyWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act
    IntegerValue actualMultiplyResult = rangeIntegerValue.multiply(other);

    // Assert
    assertSame(other, actualMultiplyResult);
  }

  /**
   * Test {@link RangeIntegerValue#multiply(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(ParticularIntegerValue)"})
  void testMultiplyWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualMultiplyResult = rangeIntegerValue.multiply(new ParticularIntegerValue(1));

    // Assert
    assertSame(rangeIntegerValue, actualMultiplyResult);
  }

  /**
   * Test {@link RangeIntegerValue#multiply(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(ParticularIntegerValue)"})
  void testMultiplyWithParticularIntegerValue3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualMultiplyResult =
        rangeIntegerValue.multiply(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(ParticularIntegerValue)"})
  void testMultiplyWithParticularIntegerValue4() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualMultiplyResult = rangeIntegerValue.multiply(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(ParticularIntegerValue)"})
  void testMultiplyWithParticularIntegerValue5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, Integer.MIN_VALUE);

    // Act
    IntegerValue actualMultiplyResult = rangeIntegerValue.multiply(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(ParticularIntegerValue)"})
  void testMultiplyWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualMultiplyResult = rangeIntegerValue.multiply(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#multiply(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.multiply(RangeIntegerValue)"})
  void testMultiplyWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualMultiplyResult = rangeIntegerValue.multiply(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is {@link
   *       Integer#MIN_VALUE} and max is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(IntegerValue) with 'IntegerValue'; given RangeIntegerValue(int, int) with min is MIN_VALUE and max is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  void testDivideWithIntegerValue_givenRangeIntegerValueWithMinIsMin_valueAndMaxIsThree()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult =
        new RangeIntegerValue(Integer.MIN_VALUE, 3).divide(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(IntegerValue) with 'IntegerValue'; given RangeIntegerValue(int, int) with min is one and max is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  void testDivideWithIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsMin_value()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult =
        new RangeIntegerValue(1, Integer.MIN_VALUE).divide(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName("Test divide(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  void testDivideWithIntegerValue_thenReturnCompositeIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideResult =
        rangeIntegerValue.divide(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max
   *       is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue(int, int) with min is one and max is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  void testDivideWithIntegerValue_thenReturnRangeIntegerValueWithMinIsOneAndMaxIsThree()
      throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideResult =
        rangeIntegerValue.divide(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertSame(rangeIntegerValue, actualDivideResult);
  }

  /**
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  void testDivideWithIntegerValue_whenInteger_value_0_thenReturnUnknownIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult =
        new RangeIntegerValue(1, 3).divide(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_2}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_2; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  void testDivideWithIntegerValue_whenInteger_value_2_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult =
        new RangeIntegerValue(1, 3).divide(ParticularValueFactory.INTEGER_VALUE_2);

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  void testDivideWithIntegerValue_whenInteger_value_byte_thenReturnUnknownIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult =
        new RangeIntegerValue(1, 3).divide(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_M1; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  void testDivideWithIntegerValue_whenInteger_value_m1_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult =
        new RangeIntegerValue(1, 3).divide(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(IntegerValue)"})
  void testDivideWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualDivideResult = new RangeIntegerValue(1, 3).divide(other);

    // Assert
    assertSame(other, actualDivideResult);
  }

  /**
   * Test {@link RangeIntegerValue#divide(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test divide(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(ParticularIntegerValue)"})
  void testDivideWithParticularIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideResult = rangeIntegerValue.divide(new ParticularIntegerValue(1));

    // Assert
    assertSame(rangeIntegerValue, actualDivideResult);
  }

  /**
   * Test {@link RangeIntegerValue#divide(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test divide(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(ParticularIntegerValue)"})
  void testDivideWithParticularIntegerValue2() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualDivideResult =
        rangeIntegerValue.divide(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test divide(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(ParticularIntegerValue)"})
  void testDivideWithParticularIntegerValue3() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, Integer.MIN_VALUE);

    // Act
    IntegerValue actualDivideResult =
        rangeIntegerValue.divide(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularIntegerValue) with 'ParticularIntegerValue'; then return Particular")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(ParticularIntegerValue)"})
  void testDivideWithParticularIntegerValue_thenReturnParticular() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideResult = rangeIntegerValue.divide(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isSpecific());
    assertTrue(actualDivideResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#divide(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(ParticularIntegerValue)"})
  void testDivideWithParticularIntegerValue_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideResult =
        rangeIntegerValue.divide(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularIntegerValue) with 'ParticularIntegerValue'; when ParticularIntegerValue(int) with value is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(ParticularIntegerValue)"})
  void testDivideWithParticularIntegerValue_whenParticularIntegerValueWithValueIsZero()
      throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideResult = rangeIntegerValue.divide(new ParticularIntegerValue(0));

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divide(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test divide(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divide(RangeIntegerValue)"})
  void testDivideWithRangeIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideResult = rangeIntegerValue.divide(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(IntegerValue)"})
  void testDivideOfWithIntegerValue() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        new RangeIntegerValue(Integer.MIN_VALUE, Integer.MIN_VALUE)
            .divideOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isSpecific());
    assertTrue(actualDivideOfResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is zero and max is
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(IntegerValue) with 'IntegerValue'; given RangeIntegerValue(int, int) with min is zero and max is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(IntegerValue)"})
  void testDivideOfWithIntegerValue_givenRangeIntegerValueWithMinIsZeroAndMaxIsThree()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        new RangeIntegerValue(0, 3).divideOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(IntegerValue)"})
  void testDivideOfWithIntegerValue_thenReturnCompositeIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideOfResult =
        rangeIntegerValue.divideOf(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return Particular")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(IntegerValue)"})
  void testDivideOfWithIntegerValue_whenInteger_value_0_thenReturnParticular()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        new RangeIntegerValue(1, 3).divideOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isSpecific());
    assertTrue(actualDivideOfResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(IntegerValue)"})
  void testDivideOfWithIntegerValue_whenInteger_value_byte() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        new RangeIntegerValue(1, 3).divideOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_M1; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(IntegerValue)"})
  void testDivideOfWithIntegerValue_whenInteger_value_m1_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        new RangeIntegerValue(1, 3).divideOf(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(IntegerValue)"})
  void testDivideOfWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualDivideOfResult = new RangeIntegerValue(1, 3).divideOf(other);

    // Assert
    assertSame(other, actualDivideOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(ParticularIntegerValue)"})
  void testDivideOfWithParticularIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideOfResult = rangeIntegerValue.divideOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(ParticularIntegerValue)"})
  void testDivideOfWithParticularIntegerValue2() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, 0);

    // Act
    IntegerValue actualDivideOfResult = rangeIntegerValue.divideOf(new ParticularIntegerValue(0));

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(ParticularIntegerValue)"})
  void testDivideOfWithParticularIntegerValue3() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, Value.NEVER);

    // Act
    IntegerValue actualDivideOfResult =
        rangeIntegerValue.divideOf(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(ParticularIntegerValue)"})
  void testDivideOfWithParticularIntegerValue4() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, Value.NEVER);

    // Act
    IntegerValue actualDivideOfResult =
        rangeIntegerValue.divideOf(new ParticularIntegerValue(Integer.MIN_VALUE));

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(ParticularIntegerValue)"})
  void testDivideOfWithParticularIntegerValue5() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Value.NEVER, Value.NEVER);

    // Act
    IntegerValue actualDivideOfResult =
        rangeIntegerValue.divideOf(new ParticularIntegerValue(Integer.MIN_VALUE));

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return Particular")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(ParticularIntegerValue)"})
  void testDivideOfWithParticularIntegerValue_thenReturnParticular() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Value.NEVER, Value.NEVER);

    // Act
    IntegerValue actualDivideOfResult = rangeIntegerValue.divideOf(new ParticularIntegerValue(0));

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isSpecific());
    assertTrue(actualDivideOfResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#divideOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.divideOf(RangeIntegerValue)"})
  void testDivideOfWithRangeIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideOfResult = rangeIntegerValue.divideOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(IntegerValue)"})
  void testRemainderWithIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderResult =
        rangeIntegerValue.remainder(ParticularValueFactory.INTEGER_VALUE_4);

    // Assert
    assertSame(rangeIntegerValue, actualRemainderResult);
  }

  /**
   * Test {@link RangeIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(IntegerValue)"})
  void testRemainderWithIntegerValue2() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        new RangeIntegerValue(Integer.MIN_VALUE, 3)
            .remainder(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(IntegerValue)"})
  void testRemainderWithIntegerValue_thenReturnCompositeIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderResult =
        rangeIntegerValue.remainder(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(IntegerValue)"})
  void testRemainderWithIntegerValue_whenInteger_value_0_thenReturnUnknownIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        new RangeIntegerValue(1, 3).remainder(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_1; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(IntegerValue)"})
  void testRemainderWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        new RangeIntegerValue(1, 3).remainder(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualRemainderResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isSpecific());
    assertTrue(actualRemainderResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(IntegerValue)"})
  void testRemainderWithIntegerValue_whenInteger_value_byte() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        new RangeIntegerValue(1, 3).remainder(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(IntegerValue)"})
  void testRemainderWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualRemainderResult = new RangeIntegerValue(1, 3).remainder(other);

    // Assert
    assertSame(other, actualRemainderResult);
  }

  /**
   * Test {@link RangeIntegerValue#remainder(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(ParticularIntegerValue)"})
  void testRemainderWithParticularIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderResult =
        rangeIntegerValue.remainder(new ParticularIntegerValue(42));

    // Assert
    assertSame(rangeIntegerValue, actualRemainderResult);
  }

  /**
   * Test {@link RangeIntegerValue#remainder(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(ParticularIntegerValue)"})
  void testRemainderWithParticularIntegerValue2() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, 3);

    // Act
    IntegerValue actualRemainderResult = rangeIntegerValue.remainder(new ParticularIntegerValue(0));

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainder(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(ParticularIntegerValue)"})
  void testRemainderWithParticularIntegerValue3() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Value.NEVER, 3);

    // Act
    IntegerValue actualRemainderResult = rangeIntegerValue.remainder(new ParticularIntegerValue(1));

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainder(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(ParticularIntegerValue)"})
  void testRemainderWithParticularIntegerValue_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, 3);

    // Act
    IntegerValue actualRemainderResult = rangeIntegerValue.remainder(new ParticularIntegerValue(1));

    // Assert
    assertTrue(actualRemainderResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isSpecific());
    assertTrue(actualRemainderResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#remainder(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainder(RangeIntegerValue)"})
  void testRemainderWithRangeIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderResult = rangeIntegerValue.remainder(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is zero and max is
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(IntegerValue) with 'IntegerValue'; given RangeIntegerValue(int, int) with min is zero and max is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(IntegerValue)"})
  void testRemainderOfWithIntegerValue_givenRangeIntegerValueWithMinIsZeroAndMaxIsThree()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        new RangeIntegerValue(0, 3).remainderOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(IntegerValue)"})
  void testRemainderOfWithIntegerValue_thenReturnCompositeIntegerValue()
      throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderOfResult =
        rangeIntegerValue.remainderOf(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return INTEGER_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(IntegerValue)"})
  void testRemainderOfWithIntegerValue_whenInteger_value_0_thenReturnInteger_value_0()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualRemainderOfResult = new RangeIntegerValue(1, 3).remainderOf(other);

    // Assert
    assertSame(other, actualRemainderOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_1; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(IntegerValue)"})
  void testRemainderOfWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        new RangeIntegerValue(1, 3).remainderOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualRemainderOfResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_3}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_3; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(IntegerValue)"})
  void testRemainderOfWithIntegerValue_whenInteger_value_3_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        new RangeIntegerValue(1, 3).remainderOf(ParticularValueFactory.INTEGER_VALUE_3);

    // Assert
    assertTrue(actualRemainderOfResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(IntegerValue)"})
  void testRemainderOfWithIntegerValue_whenInteger_value_byte() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        new RangeIntegerValue(1, 3).remainderOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_M1")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(IntegerValue)"})
  void testRemainderOfWithIntegerValue_whenInteger_value_m1() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        new RangeIntegerValue(1, 3).remainderOf(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(IntegerValue)"})
  void testRemainderOfWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualRemainderOfResult = new RangeIntegerValue(1, 3).remainderOf(other);

    // Assert
    assertSame(other, actualRemainderOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(ParticularIntegerValue)"})
  void testRemainderOfWithParticularIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderOfResult =
        rangeIntegerValue.remainderOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderOfResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(ParticularIntegerValue)"})
  void testRemainderOfWithParticularIntegerValue2() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, 3);

    // Act
    IntegerValue actualRemainderOfResult =
        rangeIntegerValue.remainderOf(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(ParticularIntegerValue)"})
  void testRemainderOfWithParticularIntegerValue3() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act
    IntegerValue actualRemainderOfResult = rangeIntegerValue.remainderOf(other);

    // Assert
    assertSame(other, actualRemainderOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(ParticularIntegerValue)"})
  void testRemainderOfWithParticularIntegerValue4() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderOfResult =
        rangeIntegerValue.remainderOf(new ParticularIntegerValue(1));

    // Assert
    assertTrue(actualRemainderOfResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(ParticularIntegerValue)"})
  void testRemainderOfWithParticularIntegerValue_thenReturnUnknownIntegerValue()
      throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, 3);

    // Act
    IntegerValue actualRemainderOfResult =
        rangeIntegerValue.remainderOf(new ParticularIntegerValue(0));

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#remainderOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.remainderOf(RangeIntegerValue)"})
  void testRemainderOfWithRangeIntegerValue() throws ArithmeticException {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderOfResult =
        rangeIntegerValue.remainderOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftResult =
        rangeIntegerValue.shiftLeft(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertSame(rangeIntegerValue, actualShiftLeftResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue2() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult =
        new RangeIntegerValue(1, Integer.MIN_VALUE)
            .shiftLeft(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftResult =
        rangeIntegerValue.shiftLeft(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_1; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult =
        new RangeIntegerValue(1, 3).shiftLeft(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult =
        new RangeIntegerValue(1, 3).shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_M1; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue_whenInteger_value_m1_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult =
        new RangeIntegerValue(1, 3).shiftLeft(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualShiftLeftResult = new RangeIntegerValue(1, 3).shiftLeft(other);

    // Assert
    assertSame(other, actualShiftLeftResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(ParticularIntegerValue)"})
  void testShiftLeftWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, 3);

    // Act
    IntegerValue actualShiftLeftResult =
        rangeIntegerValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(ParticularIntegerValue)"})
  void testShiftLeftWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftResult =
        rangeIntegerValue.shiftLeft(new ParticularIntegerValue(1024));

    // Assert
    assertSame(rangeIntegerValue, actualShiftLeftResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(ParticularIntegerValue)"})
  void testShiftLeftWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftResult =
        rangeIntegerValue.shiftLeft(new ParticularIntegerValue(10));

    // Assert
    assertTrue(actualShiftLeftResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(ParticularIntegerValue)"})
  void testShiftLeftWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftResult =
        rangeIntegerValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeft(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeft(RangeIntegerValue)"})
  void testShiftLeftWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftResult = rangeIntegerValue.shiftLeft(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  void testShiftLeftOfWithIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        new RangeIntegerValue(Integer.MIN_VALUE, 3)
            .shiftLeftOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(IntegerValue) with 'IntegerValue'; given RangeIntegerValue(int, int) with min is one and max is NEVER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  void testShiftLeftOfWithIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsNever() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        new RangeIntegerValue(1, Value.NEVER).shiftLeftOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@link Integer#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(IntegerValue) with 'IntegerValue'; given RangeIntegerValue(int, int) with min is one and max is SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  void testShiftLeftOfWithIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsSize() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        new RangeIntegerValue(1, Integer.SIZE).shiftLeftOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  void testShiftLeftOfWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftOfResult =
        rangeIntegerValue.shiftLeftOf(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return INTEGER_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  void testShiftLeftOfWithIntegerValue_whenInteger_value_0_thenReturnInteger_value_0() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualShiftLeftOfResult = new RangeIntegerValue(1, 3).shiftLeftOf(other);

    // Assert
    assertSame(other, actualShiftLeftOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_1; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  void testShiftLeftOfWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        new RangeIntegerValue(1, 3).shiftLeftOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  void testShiftLeftOfWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        new RangeIntegerValue(1, 3).shiftLeftOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_M1; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  void testShiftLeftOfWithIntegerValue_whenInteger_value_m1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        new RangeIntegerValue(1, 3).shiftLeftOf(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(IntegerValue)"})
  void testShiftLeftOfWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualShiftLeftOfResult = new RangeIntegerValue(1, 3).shiftLeftOf(other);

    // Assert
    assertSame(other, actualShiftLeftOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularValueFactory#LONG_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(LongValue) with 'LongValue'; when LONG_VALUE_0; then return LONG_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftLeftOf(LongValue)"})
  void testShiftLeftOfWithLongValue_whenLong_value_0_thenReturnLong_value_0() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualShiftLeftOfResult = new RangeIntegerValue(1, 3).shiftLeftOf(other);

    // Assert
    assertSame(other, actualShiftLeftOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_1}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(LongValue) with 'LongValue'; when LONG_VALUE_1; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftLeftOf(LongValue)"})
  void testShiftLeftOfWithLongValue_whenLong_value_1_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftLeftOfResult =
        new RangeIntegerValue(1, 3).shiftLeftOf(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
    assertTrue(actualShiftLeftOfResult.isCategory2());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftLeftOf(LongValue)"})
  void testShiftLeftOfWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualShiftLeftOfResult = new RangeIntegerValue(1, 3).shiftLeftOf(other);

    // Assert
    assertSame(other, actualShiftLeftOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(ParticularIntegerValue)"})
  void testShiftLeftOfWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftOfResult =
        rangeIntegerValue.shiftLeftOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(ParticularIntegerValue)"})
  void testShiftLeftOfWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, Integer.SIZE);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act
    IntegerValue actualShiftLeftOfResult = rangeIntegerValue.shiftLeftOf(other);

    // Assert
    assertSame(other, actualShiftLeftOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(ParticularIntegerValue)"})
  void testShiftLeftOfWithParticularIntegerValue3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, Integer.SIZE);

    // Act
    IntegerValue actualShiftLeftOfResult =
        rangeIntegerValue.shiftLeftOf(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(ParticularIntegerValue)"})
  void testShiftLeftOfWithParticularIntegerValue4() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, 31);

    // Act
    IntegerValue actualShiftLeftOfResult =
        rangeIntegerValue.shiftLeftOf(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(ParticularIntegerValue)"})
  void testShiftLeftOfWithParticularIntegerValue5() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Value.NEVER, Integer.SIZE);

    // Act
    IntegerValue actualShiftLeftOfResult =
        rangeIntegerValue.shiftLeftOf(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(ParticularIntegerValue)"})
  void testShiftLeftOfWithParticularIntegerValue6() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftOfResult =
        rangeIntegerValue.shiftLeftOf(new ParticularIntegerValue(Integer.MIN_VALUE));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularLongValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(ParticularLongValue) with 'ParticularLongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftLeftOf(ParticularLongValue)"})
  void testShiftLeftOfWithParticularLongValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularLongValue other = new ParticularLongValue(0L);

    // Act
    LongValue actualShiftLeftOfResult = rangeIntegerValue.shiftLeftOf(other);

    // Assert
    assertSame(other, actualShiftLeftOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(ParticularLongValue) with 'ParticularLongValue'; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftLeftOf(ParticularLongValue)"})
  void testShiftLeftOfWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    LongValue actualShiftLeftOfResult = rangeIntegerValue.shiftLeftOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
    assertTrue(actualShiftLeftOfResult.isCategory2());
  }

  /**
   * Test {@link RangeIntegerValue#shiftLeftOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftLeftOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftLeftOf(RangeIntegerValue)"})
  void testShiftLeftOfWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftOfResult =
        rangeIntegerValue.shiftLeftOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightResult =
        rangeIntegerValue.shiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertSame(rangeIntegerValue, actualShiftRightResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightResult =
        rangeIntegerValue.shiftRight(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(IntegerValue) with 'IntegerValue'; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightResult =
        new RangeIntegerValue(1, 3).shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_1; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightResult =
        new RangeIntegerValue(1, 3).shiftRight(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualShiftRightResult = new RangeIntegerValue(1, 3).shiftRight(other);

    // Assert
    assertSame(other, actualShiftRightResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRight(ParticularIntegerValue)"})
  void testShiftRightWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightResult =
        rangeIntegerValue.shiftRight(new ParticularIntegerValue(0));

    // Assert
    assertSame(rangeIntegerValue, actualShiftRightResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRight(ParticularIntegerValue)"})
  void testShiftRightWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightResult =
        rangeIntegerValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRight(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRight(RangeIntegerValue)"})
  void testShiftRightWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightResult = rangeIntegerValue.shiftRight(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(IntegerValue)"})
  void testShiftRightOfWithIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult =
        new RangeIntegerValue(Integer.MIN_VALUE, 3)
            .shiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@link Integer#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(IntegerValue) with 'IntegerValue'; given RangeIntegerValue(int, int) with min is one and max is SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(IntegerValue)"})
  void testShiftRightOfWithIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsSize() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult =
        new RangeIntegerValue(1, Integer.SIZE).shiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(IntegerValue)"})
  void testShiftRightOfWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightOfResult =
        rangeIntegerValue.shiftRightOf(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return INTEGER_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(IntegerValue)"})
  void testShiftRightOfWithIntegerValue_whenInteger_value_0_thenReturnInteger_value_0() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualShiftRightOfResult = new RangeIntegerValue(1, 3).shiftRightOf(other);

    // Assert
    assertSame(other, actualShiftRightOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_1; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(IntegerValue)"})
  void testShiftRightOfWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult =
        new RangeIntegerValue(1, 3).shiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(IntegerValue)"})
  void testShiftRightOfWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult =
        new RangeIntegerValue(1, 3).shiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_M1")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(IntegerValue)"})
  void testShiftRightOfWithIntegerValue_whenInteger_value_m1() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult =
        new RangeIntegerValue(1, 3).shiftRightOf(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(IntegerValue)"})
  void testShiftRightOfWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualShiftRightOfResult = new RangeIntegerValue(1, 3).shiftRightOf(other);

    // Assert
    assertSame(other, actualShiftRightOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularValueFactory#LONG_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(LongValue) with 'LongValue'; when LONG_VALUE_0; then return LONG_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftRightOf(LongValue)"})
  void testShiftRightOfWithLongValue_whenLong_value_0_thenReturnLong_value_0() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualShiftRightOfResult = new RangeIntegerValue(1, 3).shiftRightOf(other);

    // Assert
    assertSame(other, actualShiftRightOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_1}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(LongValue) with 'LongValue'; when LONG_VALUE_1; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftRightOf(LongValue)"})
  void testShiftRightOfWithLongValue_whenLong_value_1_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftRightOfResult =
        new RangeIntegerValue(1, 3).shiftRightOf(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isCategory2());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftRightOf(LongValue)"})
  void testShiftRightOfWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualShiftRightOfResult = new RangeIntegerValue(1, 3).shiftRightOf(other);

    // Assert
    assertSame(other, actualShiftRightOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(ParticularIntegerValue)"})
  void testShiftRightOfWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightOfResult =
        rangeIntegerValue.shiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(ParticularIntegerValue)"})
  void testShiftRightOfWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, Integer.SIZE);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act
    IntegerValue actualShiftRightOfResult = rangeIntegerValue.shiftRightOf(other);

    // Assert
    assertSame(other, actualShiftRightOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(ParticularIntegerValue)"})
  void testShiftRightOfWithParticularIntegerValue3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Value.NEVER, Integer.SIZE);

    // Act
    IntegerValue actualShiftRightOfResult =
        rangeIntegerValue.shiftRightOf(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return Particular")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(ParticularIntegerValue)"})
  void testShiftRightOfWithParticularIntegerValue_thenReturnParticular() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, 31);

    // Act
    IntegerValue actualShiftRightOfResult =
        rangeIntegerValue.shiftRightOf(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(ParticularIntegerValue)"})
  void testShiftRightOfWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, Integer.SIZE);

    // Act
    IntegerValue actualShiftRightOfResult =
        rangeIntegerValue.shiftRightOf(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(ParticularLongValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(ParticularLongValue) with 'ParticularLongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftRightOf(ParticularLongValue)"})
  void testShiftRightOfWithParticularLongValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularLongValue other = new ParticularLongValue(0L);

    // Act
    LongValue actualShiftRightOfResult = rangeIntegerValue.shiftRightOf(other);

    // Assert
    assertSame(other, actualShiftRightOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(ParticularLongValue) with 'ParticularLongValue'; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue RangeIntegerValue.shiftRightOf(ParticularLongValue)"})
  void testShiftRightOfWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    LongValue actualShiftRightOfResult =
        rangeIntegerValue.shiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isCategory2());
  }

  /**
   * Test {@link RangeIntegerValue#shiftRightOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#shiftRightOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.shiftRightOf(RangeIntegerValue)"})
  void testShiftRightOfWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightOfResult =
        rangeIntegerValue.shiftRightOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        rangeIntegerValue.unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertSame(rangeIntegerValue, actualUnsignedShiftRightResult);
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue2() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        new RangeIntegerValue(Integer.MIN_VALUE, 3)
            .unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        rangeIntegerValue.unsignedShiftRight(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; then return Particular")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue_thenReturnParticular() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        new RangeIntegerValue(Integer.MIN_VALUE, Integer.MIN_VALUE)
            .unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        new RangeIntegerValue(1, 3).unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        new RangeIntegerValue(1, 3).unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        new RangeIntegerValue(1, 3).unsignedShiftRight(other);

    // Assert
    assertSame(other, actualUnsignedShiftRightResult);
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(ParticularIntegerValue)"})
  void testUnsignedShiftRightWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Value.NEVER, 0);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        rangeIntegerValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(ParticularIntegerValue)"})
  void testUnsignedShiftRightWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Value.NEVER, 1);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        rangeIntegerValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(ParticularIntegerValue)"})
  void testUnsignedShiftRightWithParticularIntegerValue3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        rangeIntegerValue.unsignedShiftRight(new ParticularIntegerValue(0));

    // Assert
    assertSame(rangeIntegerValue, actualUnsignedShiftRightResult);
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'; then return Particular")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(ParticularIntegerValue)"})
  void testUnsignedShiftRightWithParticularIntegerValue_thenReturnParticular() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        rangeIntegerValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRight(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRight(RangeIntegerValue)"})
  void testUnsignedShiftRightWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        rangeIntegerValue.unsignedShiftRight(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  void testUnsignedShiftRightOfWithIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult =
        new RangeIntegerValue(Integer.MIN_VALUE, 3)
            .unsignedShiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  void testUnsignedShiftRightOfWithIntegerValue2() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult =
        new RangeIntegerValue(1, Integer.SIZE)
            .unsignedShiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  void testUnsignedShiftRightOfWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        rangeIntegerValue.unsignedShiftRightOf(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  void testUnsignedShiftRightOfWithIntegerValue_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        new RangeIntegerValue(1, 3).unsignedShiftRightOf(other);

    // Assert
    assertSame(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'; then return INTEGER_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  void testUnsignedShiftRightOfWithIntegerValue_thenReturnInteger_value_0() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        new RangeIntegerValue(1, 3).unsignedShiftRightOf(other);

    // Assert
    assertSame(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  void testUnsignedShiftRightOfWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult =
        new RangeIntegerValue(1, 3).unsignedShiftRightOf(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  void testUnsignedShiftRightOfWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult =
        new RangeIntegerValue(1, 3).unsignedShiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(LongValue) with 'LongValue'; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue RangeIntegerValue.unsignedShiftRightOf(LongValue)"})
  void testUnsignedShiftRightOfWithLongValue_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightOfResult =
        new RangeIntegerValue(1, 3).unsignedShiftRightOf(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularValueFactory#LONG_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(LongValue) with 'LongValue'; when LONG_VALUE_0; then return LONG_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue RangeIntegerValue.unsignedShiftRightOf(LongValue)"})
  void testUnsignedShiftRightOfWithLongValue_whenLong_value_0_thenReturnLong_value_0() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        new RangeIntegerValue(1, 3).unsignedShiftRightOf(other);

    // Assert
    assertSame(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue RangeIntegerValue.unsignedShiftRightOf(LongValue)"})
  void testUnsignedShiftRightOfWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        new RangeIntegerValue(1, 3).unsignedShiftRightOf(other);

    // Assert
    assertSame(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(ParticularIntegerValue)"})
  void testUnsignedShiftRightOfWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(0, Integer.SIZE);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult = rangeIntegerValue.unsignedShiftRightOf(other);

    // Assert
    assertSame(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(ParticularIntegerValue)"})
  void testUnsignedShiftRightOfWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(Integer.MIN_VALUE, 3);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        rangeIntegerValue.unsignedShiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(ParticularIntegerValue)"})
  void testUnsignedShiftRightOfWithParticularIntegerValue3() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        rangeIntegerValue.unsignedShiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(ParticularIntegerValue)"})
  void testUnsignedShiftRightOfWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        rangeIntegerValue.unsignedShiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(ParticularLongValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(ParticularLongValue) with 'ParticularLongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue RangeIntegerValue.unsignedShiftRightOf(ParticularLongValue)"})
  void testUnsignedShiftRightOfWithParticularLongValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularLongValue other = new ParticularLongValue(0L);

    // Act
    LongValue actualUnsignedShiftRightOfResult = rangeIntegerValue.unsignedShiftRightOf(other);

    // Assert
    assertSame(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(ParticularLongValue) with 'ParticularLongValue'; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue RangeIntegerValue.unsignedShiftRightOf(ParticularLongValue)"})
  void testUnsignedShiftRightOfWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        rangeIntegerValue.unsignedShiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
  }

  /**
   * Test {@link RangeIntegerValue#unsignedShiftRightOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.unsignedShiftRightOf(RangeIntegerValue)"})
  void testUnsignedShiftRightOfWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        rangeIntegerValue.unsignedShiftRightOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName("Test and(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(IntegerValue)"})
  void testAndWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAndResult =
        rangeIntegerValue.and(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max
   *       is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue(int, int) with min is one and max is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(IntegerValue)"})
  void testAndWithIntegerValue_thenReturnRangeIntegerValueWithMinIsOneAndMaxIsThree() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAndResult = rangeIntegerValue.and(ParticularValueFactory.INTEGER_VALUE_M1);

    // Assert
    assertSame(rangeIntegerValue, actualAndResult);
  }

  /**
   * Test {@link RangeIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return INTEGER_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(IntegerValue)"})
  void testAndWithIntegerValue_whenInteger_value_0_thenReturnInteger_value_0() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualAndResult = new RangeIntegerValue(1, 3).and(other);

    // Assert
    assertSame(other, actualAndResult);
  }

  /**
   * Test {@link RangeIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_1; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(IntegerValue)"})
  void testAndWithIntegerValue_whenInteger_value_1_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult =
        new RangeIntegerValue(1, 3).and(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualAndResult instanceof RangeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(IntegerValue)"})
  void testAndWithIntegerValue_whenInteger_value_byte_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult =
        new RangeIntegerValue(1, 3).and(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAndResult instanceof UnknownIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(IntegerValue)"})
  void testAndWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualAndResult = new RangeIntegerValue(1, 3).and(other);

    // Assert
    assertSame(other, actualAndResult);
  }

  /**
   * Test {@link RangeIntegerValue#and(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test and(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(ParticularIntegerValue)"})
  void testAndWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(0);

    // Act
    IntegerValue actualAndResult = rangeIntegerValue.and(other);

    // Assert
    assertSame(other, actualAndResult);
  }

  /**
   * Test {@link RangeIntegerValue#and(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test and(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(ParticularIntegerValue)"})
  void testAndWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAndResult = rangeIntegerValue.and(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertSame(rangeIntegerValue, actualAndResult);
  }

  /**
   * Test {@link RangeIntegerValue#and(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(ParticularIntegerValue)"})
  void testAndWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAndResult = rangeIntegerValue.and(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof RangeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#and(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(ParticularIntegerValue)"})
  void testAndWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAndResult =
        rangeIntegerValue.and(new ParticularIntegerValue(Integer.MIN_VALUE));

    // Assert
    assertTrue(actualAndResult instanceof UnknownIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#and(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#and(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test and(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.and(RangeIntegerValue)"})
  void testAndWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualAndResult = rangeIntegerValue.and(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAndResult instanceof UnknownIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName("Test or(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(IntegerValue)"})
  void testOrWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualOrResult =
        rangeIntegerValue.or(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max
   *       is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue(int, int) with min is one and max is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(IntegerValue)"})
  void testOrWithIntegerValue_thenReturnRangeIntegerValueWithMinIsOneAndMaxIsThree() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualOrResult = rangeIntegerValue.or(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertSame(rangeIntegerValue, actualOrResult);
  }

  /**
   * Test {@link RangeIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_1; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(IntegerValue)"})
  void testOrWithIntegerValue_whenInteger_value_1_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualOrResult =
        new RangeIntegerValue(1, 3).or(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualOrResult instanceof UnknownIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(IntegerValue)"})
  void testOrWithIntegerValue_whenInteger_value_byte_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualOrResult =
        new RangeIntegerValue(1, 3).or(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualOrResult instanceof UnknownIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   *   <li>Then return {@link ParticularValueFactory#INTEGER_VALUE_M1}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_M1; then return INTEGER_VALUE_M1")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(IntegerValue)"})
  void testOrWithIntegerValue_whenInteger_value_m1_thenReturnInteger_value_m1() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_M1;

    // Act
    IntegerValue actualOrResult = new RangeIntegerValue(1, 3).or(other);

    // Assert
    assertSame(other, actualOrResult);
  }

  /**
   * Test {@link RangeIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(IntegerValue)"})
  void testOrWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualOrResult = new RangeIntegerValue(1, 3).or(other);

    // Assert
    assertSame(other, actualOrResult);
  }

  /**
   * Test {@link RangeIntegerValue#or(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test or(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(ParticularIntegerValue)"})
  void testOrWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualOrResult = rangeIntegerValue.or(new ParticularIntegerValue(0));

    // Assert
    assertSame(rangeIntegerValue, actualOrResult);
  }

  /**
   * Test {@link RangeIntegerValue#or(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test or(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(ParticularIntegerValue)"})
  void testOrWithParticularIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);
    ParticularIntegerValue other = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualOrResult = rangeIntegerValue.or(other);

    // Assert
    assertSame(other, actualOrResult);
  }

  /**
   * Test {@link RangeIntegerValue#or(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(ParticularIntegerValue)"})
  void testOrWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualOrResult =
        rangeIntegerValue.or(new ParticularIntegerValue(Integer.MIN_VALUE));

    // Assert
    assertTrue(actualOrResult instanceof RangeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#or(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(ParticularIntegerValue)"})
  void testOrWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualOrResult = rangeIntegerValue.or(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualOrResult instanceof UnknownIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#or(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#or(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test or(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.or(RangeIntegerValue)"})
  void testOrWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualOrResult = rangeIntegerValue.or(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualOrResult instanceof UnknownIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#xor(IntegerValue)}
   */
  @Test
  @DisplayName("Test xor(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.xor(IntegerValue)"})
  void testXorWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualXorResult =
        rangeIntegerValue.xor(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max
   *       is three.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#xor(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue(int, int) with min is one and max is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.xor(IntegerValue)"})
  void testXorWithIntegerValue_thenReturnRangeIntegerValueWithMinIsOneAndMaxIsThree() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualXorResult = rangeIntegerValue.xor(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertSame(rangeIntegerValue, actualXorResult);
  }

  /**
   * Test {@link RangeIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#xor(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_1; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.xor(IntegerValue)"})
  void testXorWithIntegerValue_whenInteger_value_1_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualXorResult =
        new RangeIntegerValue(1, 3).xor(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualXorResult instanceof UnknownIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertFalse(actualXorResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#xor(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.xor(IntegerValue)"})
  void testXorWithIntegerValue_whenInteger_value_byte_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualXorResult =
        new RangeIntegerValue(1, 3).xor(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualXorResult instanceof UnknownIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertFalse(actualXorResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#xor(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.xor(IntegerValue)"})
  void testXorWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualXorResult = new RangeIntegerValue(1, 3).xor(other);

    // Assert
    assertSame(other, actualXorResult);
  }

  /**
   * Test {@link RangeIntegerValue#xor(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#xor(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test xor(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.xor(ParticularIntegerValue)"})
  void testXorWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualXorResult = rangeIntegerValue.xor(new ParticularIntegerValue(0));

    // Assert
    assertSame(rangeIntegerValue, actualXorResult);
  }

  /**
   * Test {@link RangeIntegerValue#xor(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#xor(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.xor(ParticularIntegerValue)"})
  void testXorWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualXorResult = rangeIntegerValue.xor(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualXorResult instanceof UnknownIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertFalse(actualXorResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#xor(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#xor(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test xor(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue RangeIntegerValue.xor(RangeIntegerValue)"})
  void testXorWithRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualXorResult = rangeIntegerValue.xor(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualXorResult instanceof UnknownIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertFalse(actualXorResult.isSpecific());
  }

  /**
   * Test {@link RangeIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName("Test equal(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(IntegerValue)"})
  void testEqualWithIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    int actualEqualResult =
        rangeIntegerValue.equal(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(IntegerValue) with 'IntegerValue'; given RangeIntegerValue(int, int) with min is one and max is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(IntegerValue)"})
  void testEqualWithIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsMin_value() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        new RangeIntegerValue(1, Integer.MIN_VALUE)
            .equal(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link RangeIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName("Test equal(IntegerValue) with 'IntegerValue'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(IntegerValue)"})
  void testEqualWithIntegerValue_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, new RangeIntegerValue(1, 1).equal(ParticularValueFactory.INTEGER_VALUE_1));
  }

  /**
   * Test {@link RangeIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return NEVER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(IntegerValue)"})
  void testEqualWithIntegerValue_whenInteger_value_0_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER, new RangeIntegerValue(1, 3).equal(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link RangeIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_1; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(IntegerValue)"})
  void testEqualWithIntegerValue_whenInteger_value_1_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new RangeIntegerValue(1, 3).equal(ParticularValueFactory.INTEGER_VALUE_1));
  }

  /**
   * Test {@link RangeIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_4}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_4; then return NEVER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(IntegerValue)"})
  void testEqualWithIntegerValue_whenInteger_value_4_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER, new RangeIntegerValue(1, 3).equal(ParticularValueFactory.INTEGER_VALUE_4));
  }

  /**
   * Test {@link RangeIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(IntegerValue)"})
  void testEqualWithIntegerValue_whenInteger_value_byte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new RangeIntegerValue(1, 3).equal(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link RangeIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName("Test equal(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(IntegerValue)"})
  void testEqualWithIntegerValue_whenInteger_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new RangeIntegerValue(1, 3).equal(BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Test {@link RangeIntegerValue#equal(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(ParticularIntegerValue)"})
  void testEqualWithParticularIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(42, 3);

    // Act
    int actualEqualResult = rangeIntegerValue.equal(new ParticularIntegerValue(42));

    // Assert
    assertEquals(Value.NEVER, actualEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#equal(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ParticularIntegerValue) with 'ParticularIntegerValue'; then return NEVER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(ParticularIntegerValue)"})
  void testEqualWithParticularIntegerValue_thenReturnNever() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    int actualEqualResult = rangeIntegerValue.equal(new ParticularIntegerValue(42));

    // Assert
    assertEquals(Value.NEVER, actualEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#equal(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(ParticularIntegerValue) with 'ParticularIntegerValue'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(ParticularIntegerValue)"})
  void testEqualWithParticularIntegerValue_thenReturnOne() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(42, 42);

    // Act
    int actualEqualResult = rangeIntegerValue.equal(new ParticularIntegerValue(42));

    // Assert
    assertEquals(1, actualEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#equal(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(ParticularIntegerValue) with 'ParticularIntegerValue'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(ParticularIntegerValue)"})
  void testEqualWithParticularIntegerValue_thenReturnZero() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act
    int actualEqualResult = rangeIntegerValue.equal(new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#equal(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ParticularIntegerValue) with 'ParticularIntegerValue'; when ParticularIntegerValue(int) with value is NEVER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(ParticularIntegerValue)"})
  void testEqualWithParticularIntegerValue_whenParticularIntegerValueWithValueIsNever() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    int actualEqualResult = rangeIntegerValue.equal(new ParticularIntegerValue(Value.NEVER));

    // Assert
    assertEquals(Value.NEVER, actualEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(RangeIntegerValue) with 'RangeIntegerValue'; given RangeIntegerValue(int, int) with min is one and max is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(RangeIntegerValue)"})
  void testEqualWithRangeIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsOne() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 1);

    // Act
    int actualEqualResult = rangeIntegerValue.equal(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(RangeIntegerValue) with 'RangeIntegerValue'; given RangeIntegerValue(int, int) with min is one and max is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(RangeIntegerValue)"})
  void testEqualWithRangeIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsZero() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 0);

    // Act
    int actualEqualResult = rangeIntegerValue.equal(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(Value.NEVER, actualEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(RangeIntegerValue) with 'RangeIntegerValue'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(RangeIntegerValue)"})
  void testEqualWithRangeIntegerValue_thenReturnOne() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(3, 3);

    // Act
    int actualEqualResult = rangeIntegerValue.equal(new RangeIntegerValue(3, 3));

    // Assert
    assertEquals(1, actualEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(RangeIntegerValue) with 'RangeIntegerValue'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(RangeIntegerValue)"})
  void testEqualWithRangeIntegerValue_thenReturnZero() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    int actualEqualResult = rangeIntegerValue.equal(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(RangeIntegerValue) with 'RangeIntegerValue'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(RangeIntegerValue)"})
  void testEqualWithRangeIntegerValue_thenReturnZero2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(3, 3);

    // Act
    int actualEqualResult = rangeIntegerValue.equal(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>When {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(RangeIntegerValue) with 'RangeIntegerValue'; when RangeIntegerValue(int, int) with min is one and max is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.equal(RangeIntegerValue)"})
  void testEqualWithRangeIntegerValue_whenRangeIntegerValueWithMinIsOneAndMaxIsZero() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    int actualEqualResult = rangeIntegerValue.equal(new RangeIntegerValue(1, 0));

    // Assert
    assertEquals(Value.NEVER, actualEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(IntegerValue)"})
  void testLessThanWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        new RangeIntegerValue(Float.MAX_EXPONENT, 3)
            .lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(IntegerValue)"})
  void testLessThanWithIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    int actualLessThanResult =
        rangeIntegerValue.lessThan(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertEquals(0, actualLessThanResult);
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(IntegerValue) with 'IntegerValue'; given RangeIntegerValue(int, int) with min is one and max is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(IntegerValue)"})
  void testLessThanWithIntegerValue_givenRangeIntegerValueWithMinIsOneAndMaxIsMin_value() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        new RangeIntegerValue(1, Integer.MIN_VALUE)
            .lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return NEVER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(IntegerValue)"})
  void testLessThanWithIntegerValue_whenInteger_value_0_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER, new RangeIntegerValue(1, 3).lessThan(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_2}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_2; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(IntegerValue)"})
  void testLessThanWithIntegerValue_whenInteger_value_2_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new RangeIntegerValue(1, 3).lessThan(ParticularValueFactory.INTEGER_VALUE_2));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_4}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_4; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(IntegerValue)"})
  void testLessThanWithIntegerValue_whenInteger_value_4_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, new RangeIntegerValue(1, 3).lessThan(ParticularValueFactory.INTEGER_VALUE_4));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(IntegerValue)"})
  void testLessThanWithIntegerValue_whenInteger_value_byte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, new RangeIntegerValue(1, 3).lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(IntegerValue)"})
  void testLessThanWithIntegerValue_whenInteger_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new RangeIntegerValue(1, 3).lessThan(BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(ParticularIntegerValue) with 'ParticularIntegerValue'; then return NEVER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(ParticularIntegerValue)"})
  void testLessThanWithParticularIntegerValue_thenReturnNever() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    int actualLessThanResult = rangeIntegerValue.lessThan(new ParticularIntegerValue(1));

    // Assert
    assertEquals(Value.NEVER, actualLessThanResult);
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(ParticularIntegerValue) with 'ParticularIntegerValue'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(ParticularIntegerValue)"})
  void testLessThanWithParticularIntegerValue_thenReturnOne() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    int actualLessThanResult = rangeIntegerValue.lessThan(new ParticularIntegerValue(42));

    // Assert
    assertEquals(1, actualLessThanResult);
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(ParticularIntegerValue) with 'ParticularIntegerValue'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(ParticularIntegerValue)"})
  void testLessThanWithParticularIntegerValue_thenReturnZero() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 42);

    // Act
    int actualLessThanResult = rangeIntegerValue.lessThan(new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualLessThanResult);
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(RangeIntegerValue) with 'RangeIntegerValue'; then return NEVER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(RangeIntegerValue)"})
  void testLessThanWithRangeIntegerValue_thenReturnNever() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(3, 3);

    // Act
    int actualLessThanResult = rangeIntegerValue.lessThan(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(Value.NEVER, actualLessThanResult);
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(RangeIntegerValue) with 'RangeIntegerValue'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(RangeIntegerValue)"})
  void testLessThanWithRangeIntegerValue_thenReturnOne() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 0);

    // Act
    int actualLessThanResult = rangeIntegerValue.lessThan(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(1, actualLessThanResult);
  }

  /**
   * Test {@link RangeIntegerValue#lessThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(RangeIntegerValue) with 'RangeIntegerValue'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThan(RangeIntegerValue)"})
  void testLessThanWithRangeIntegerValue_thenReturnZero() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    int actualLessThanResult = rangeIntegerValue.lessThan(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(0, actualLessThanResult);
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(IntegerValue)"})
  void testLessThanOrEqualWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        new RangeIntegerValue(1, -128).lessThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(IntegerValue)"})
  void testLessThanOrEqualWithIntegerValue2() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    int actualLessThanOrEqualResult =
        rangeIntegerValue.lessThanOrEqual(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertEquals(0, actualLessThanOrEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return NEVER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(IntegerValue)"})
  void testLessThanOrEqualWithIntegerValue_whenInteger_value_0_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        new RangeIntegerValue(1, 3).lessThanOrEqual(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_1; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(IntegerValue)"})
  void testLessThanOrEqualWithIntegerValue_whenInteger_value_1_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, new RangeIntegerValue(1, 3).lessThanOrEqual(ParticularValueFactory.INTEGER_VALUE_1));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_3}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_3; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(IntegerValue)"})
  void testLessThanOrEqualWithIntegerValue_whenInteger_value_3_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(
        1, new RangeIntegerValue(1, 3).lessThanOrEqual(ParticularValueFactory.INTEGER_VALUE_3));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(IntegerValue)"})
  void testLessThanOrEqualWithIntegerValue_whenInteger_value_byte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, new RangeIntegerValue(1, 3).lessThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(IntegerValue)"})
  void testLessThanOrEqualWithIntegerValue_whenInteger_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new RangeIntegerValue(1, 3).lessThanOrEqual(BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(ParticularIntegerValue) with 'ParticularIntegerValue'; then return NEVER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(ParticularIntegerValue)"})
  void testLessThanOrEqualWithParticularIntegerValue_thenReturnNever() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    int actualLessThanOrEqualResult =
        rangeIntegerValue.lessThanOrEqual(new ParticularIntegerValue(0));

    // Assert
    assertEquals(Value.NEVER, actualLessThanOrEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(ParticularIntegerValue) with 'ParticularIntegerValue'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(ParticularIntegerValue)"})
  void testLessThanOrEqualWithParticularIntegerValue_thenReturnOne() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    int actualLessThanOrEqualResult =
        rangeIntegerValue.lessThanOrEqual(new ParticularIntegerValue(42));

    // Assert
    assertEquals(1, actualLessThanOrEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(ParticularIntegerValue) with 'ParticularIntegerValue'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(ParticularIntegerValue)"})
  void testLessThanOrEqualWithParticularIntegerValue_thenReturnZero() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    int actualLessThanOrEqualResult =
        rangeIntegerValue.lessThanOrEqual(new ParticularIntegerValue(1));

    // Assert
    assertEquals(0, actualLessThanOrEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(RangeIntegerValue) with 'RangeIntegerValue'; then return NEVER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(RangeIntegerValue)"})
  void testLessThanOrEqualWithRangeIntegerValue_thenReturnNever() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    int actualLessThanOrEqualResult =
        rangeIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 0));

    // Assert
    assertEquals(Value.NEVER, actualLessThanOrEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(RangeIntegerValue) with 'RangeIntegerValue'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(RangeIntegerValue)"})
  void testLessThanOrEqualWithRangeIntegerValue_thenReturnOne() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 1);

    // Act
    int actualLessThanOrEqualResult =
        rangeIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(1, actualLessThanOrEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#lessThanOrEqual(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(RangeIntegerValue) with 'RangeIntegerValue'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int RangeIntegerValue.lessThanOrEqual(RangeIntegerValue)"})
  void testLessThanOrEqualWithRangeIntegerValue_thenReturnZero() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    int actualLessThanOrEqualResult =
        rangeIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(0, actualLessThanOrEqualResult);
  }

  /**
   * Test {@link RangeIntegerValue#isParticular()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       three.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#isParticular()}
   */
  @Test
  @DisplayName(
      "Test isParticular(); given RangeIntegerValue(int, int) with min is one and max is three; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeIntegerValue.isParticular()"})
  void testIsParticular_givenRangeIntegerValueWithMinIsOneAndMaxIsThree_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new RangeIntegerValue(1, 3).isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#isParticular()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#isParticular()}
   */
  @Test
  @DisplayName("Test isParticular(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RangeIntegerValue.isParticular()"})
  void testIsParticular_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new RangeIntegerValue(3, 3).isParticular());
  }

  /**
   * Test {@link RangeIntegerValue#equals(Object)}, and {@link RangeIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RangeIntegerValue#equals(Object)}
   *   <li>{@link RangeIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RangeIntegerValue.equals(Object)",
    "int RangeIntegerValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertEquals(rangeIntegerValue, rangeIntegerValue);
    int expectedHashCodeResult = rangeIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, rangeIntegerValue.hashCode());
  }

  /**
   * Test {@link RangeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RangeIntegerValue.equals(Object)",
    "int RangeIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertNotEquals(rangeIntegerValue, new RangeIntegerValue(1, 3));
  }

  /**
   * Test {@link RangeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RangeIntegerValue.equals(Object)",
    "int RangeIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RangeIntegerValue(1, 3), null);
  }

  /**
   * Test {@link RangeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RangeIntegerValue.equals(Object)",
    "int RangeIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RangeIntegerValue(1, 3), "Different type to RangeIntegerValue");
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is {@code -32768}
   *       and max is {@code 32767}.
   *   <li>Then return {@code s}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given RangeIntegerValue(int, int) with min is '-32768' and max is '32767'; then return 's'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  void testToString_givenRangeIntegerValueWithMinIs32768AndMaxIs32767_thenReturnS() {
    // Arrange, Act and Assert
    assertEquals("s", new RangeIntegerValue(-32768, 32767).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is {@code -32768}
   *       and max is one.
   *   <li>Then return {@code -32768..1}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given RangeIntegerValue(int, int) with min is '-32768' and max is one; then return '-32768..1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  void testToString_givenRangeIntegerValueWithMinIs32768AndMaxIsOne_thenReturn327681() {
    // Arrange, Act and Assert
    assertEquals("-32768..1", new RangeIntegerValue(-32768, 1).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       three.
   *   <li>Then return {@code 1..3}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given RangeIntegerValue(int, int) with min is one and max is three; then return '1..3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  void testToString_givenRangeIntegerValueWithMinIsOneAndMaxIsThree_thenReturn13() {
    // Arrange, Act and Assert
    assertEquals("1..3", new RangeIntegerValue(1, 3).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is three and max is
   *       three.
   *   <li>Then return {@code 3}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given RangeIntegerValue(int, int) with min is three and max is three; then return '3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  void testToString_givenRangeIntegerValueWithMinIsThreeAndMaxIsThree_thenReturn3() {
    // Arrange, Act and Assert
    assertEquals("3", new RangeIntegerValue(3, 3).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is zero and max is
   *       one.
   *   <li>Then return {@code z}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given RangeIntegerValue(int, int) with min is zero and max is one; then return 'z'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  void testToString_givenRangeIntegerValueWithMinIsZeroAndMaxIsOne_thenReturnZ() {
    // Arrange, Act and Assert
    assertEquals("z", new RangeIntegerValue(0, 1).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Then return {@code 0..127}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '0..127'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  void testToString_thenReturn0127() {
    // Arrange, Act and Assert
    assertEquals("0..127", new RangeIntegerValue(0, Float.MAX_EXPONENT).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Then return {@code -128..1}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '-128..1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  void testToString_thenReturn1281() {
    // Arrange, Act and Assert
    assertEquals("-128..1", new RangeIntegerValue(-128, 1).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Then return {@code -2147483648..1}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '-2147483648..1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  void testToString_thenReturn21474836481() {
    // Arrange, Act and Assert
    assertEquals("-2147483648..1", new RangeIntegerValue(Integer.MIN_VALUE, 1).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Then return {@code b}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  void testToString_thenReturnB() {
    // Arrange, Act and Assert
    assertEquals("b", new RangeIntegerValue(-128, Float.MAX_EXPONENT).toString());
  }

  /**
   * Test {@link RangeIntegerValue#toString()}.
   *
   * <ul>
   *   <li>Then return {@code i}.
   * </ul>
   *
   * <p>Method under test: {@link RangeIntegerValue#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'i'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RangeIntegerValue.toString()"})
  void testToString_thenReturnI() {
    // Arrange, Act and Assert
    assertEquals("i", new RangeIntegerValue(Integer.MIN_VALUE, Integer.MAX_VALUE).toString());
  }
}
