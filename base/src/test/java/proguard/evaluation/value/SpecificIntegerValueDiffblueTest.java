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

class SpecificIntegerValueDiffblueTest {
  /**
   * Test {@link SpecificIntegerValue#negate()}.
   *
   * <ul>
   *   <li>Then return {@link NegatedIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#negate()}
   */
  @Test
  @DisplayName("Test negate(); then return NegatedIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.negate()"
  })
  void testNegate_thenReturnNegatedIntegerValue() {
    // Arrange and Act
    IntegerValue actualNegateResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof NegatedIntegerValue);
    assertFalse(actualNegateResult.isCategory2());
    assertFalse(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#negate()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#negate()}
   */
  @Test
  @DisplayName("Test negate(); then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.negate()"
  })
  void testNegate_thenReturnParticularIntegerValue() {
    // Arrange and Act
    IntegerValue actualNegateResult = (new ParticularIntegerValue(42)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof ParticularIntegerValue);
    assertEquals(-42, actualNegateResult.value());
    assertFalse(actualNegateResult.isCategory2());
    assertTrue(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#convertToByte()}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#convertToByte()}
   */
  @Test
  @DisplayName("Test convertToByte()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.convertToByte()"
  })
  void testConvertToByte() {
    // Arrange and Act
    IntegerValue actualConvertToByteResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).convertToByte();

    // Assert
    assertTrue(actualConvertToByteResult instanceof ConvertedByteValue);
    assertFalse(actualConvertToByteResult.isCategory2());
    assertFalse(actualConvertToByteResult.isParticular());
    assertTrue(actualConvertToByteResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#convertToCharacter()}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#convertToCharacter()}
   */
  @Test
  @DisplayName("Test convertToCharacter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.convertToCharacter()"
  })
  void testConvertToCharacter() {
    // Arrange and Act
    IntegerValue actualConvertToCharacterResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).convertToCharacter();

    // Assert
    assertTrue(actualConvertToCharacterResult instanceof ConvertedCharacterValue);
    assertFalse(actualConvertToCharacterResult.isCategory2());
    assertFalse(actualConvertToCharacterResult.isParticular());
    assertTrue(actualConvertToCharacterResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#convertToShort()}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#convertToShort()}
   */
  @Test
  @DisplayName("Test convertToShort()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.convertToShort()"
  })
  void testConvertToShort() {
    // Arrange and Act
    IntegerValue actualConvertToShortResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).convertToShort();

    // Assert
    assertTrue(actualConvertToShortResult instanceof ConvertedShortValue);
    assertFalse(actualConvertToShortResult.isCategory2());
    assertFalse(actualConvertToShortResult.isParticular());
    assertTrue(actualConvertToShortResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#convertToLong()}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#convertToLong()}
   */
  @Test
  @DisplayName("Test convertToLong(); then return ConvertedLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificIntegerValue.convertToLong()"
  })
  void testConvertToLong_thenReturnConvertedLongValue() {
    // Arrange and Act
    LongValue actualConvertToLongResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof ConvertedLongValue);
    assertFalse(actualConvertToLongResult.isParticular());
    assertTrue(actualConvertToLongResult.isCategory2());
    assertTrue(actualConvertToLongResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#convertToLong()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#convertToLong()}
   */
  @Test
  @DisplayName("Test convertToLong(); then return ParticularLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificIntegerValue.convertToLong()"
  })
  void testConvertToLong_thenReturnParticularLongValue() {
    // Arrange and Act
    LongValue actualConvertToLongResult = (new ParticularIntegerValue(42)).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof ParticularLongValue);
    assertEquals(42L, actualConvertToLongResult.value());
    assertTrue(actualConvertToLongResult.isCategory2());
    assertTrue(actualConvertToLongResult.isParticular());
    assertTrue(actualConvertToLongResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#convertToFloat()}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#convertToFloat()}
   */
  @Test
  @DisplayName("Test convertToFloat(); then return ConvertedFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.SpecificIntegerValue.convertToFloat()"
  })
  void testConvertToFloat_thenReturnConvertedFloatValue() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof ConvertedFloatValue);
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertFalse(actualConvertToFloatResult.isParticular());
    assertTrue(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#convertToFloat()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#convertToFloat()}
   */
  @Test
  @DisplayName("Test convertToFloat(); then return ParticularFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.SpecificIntegerValue.convertToFloat()"
  })
  void testConvertToFloat_thenReturnParticularFloatValue() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = (new ParticularIntegerValue(42)).convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof ParticularFloatValue);
    assertEquals(42.0f, actualConvertToFloatResult.value());
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertTrue(actualConvertToFloatResult.isParticular());
    assertTrue(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#convertToDouble()}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#convertToDouble()}
   */
  @Test
  @DisplayName("Test convertToDouble(); then return ConvertedDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificIntegerValue.convertToDouble()"
  })
  void testConvertToDouble_thenReturnConvertedDoubleValue() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof ConvertedDoubleValue);
    assertFalse(actualConvertToDoubleResult.isParticular());
    assertTrue(actualConvertToDoubleResult.isCategory2());
    assertTrue(actualConvertToDoubleResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#convertToDouble()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#convertToDouble()}
   */
  @Test
  @DisplayName("Test convertToDouble(); then return ParticularDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificIntegerValue.convertToDouble()"
  })
  void testConvertToDouble_thenReturnParticularDoubleValue() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = (new ParticularIntegerValue(42)).convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof ParticularDoubleValue);
    assertEquals(42.0d, actualConvertToDoubleResult.value());
    assertTrue(actualConvertToDoubleResult.isCategory2());
    assertTrue(actualConvertToDoubleResult.isParticular());
    assertTrue(actualConvertToDoubleResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IntegerValue) with 'IntegerValue'; given ConvertedByteValue(IntegerValue) with value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.generalize(proguard.evaluation.value.IntegerValue)"
  })
  void testGeneralizeWithIntegerValue_givenConvertedByteValueWithValueIsNull() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act
    IntegerValue actualGeneralizeResult =
        convertedByteValue.generalize(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedByteValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(IntegerValue) with 'IntegerValue'; then return ConvertedByteValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.generalize(proguard.evaluation.value.IntegerValue)"
  })
  void testGeneralizeWithIntegerValue_thenReturnConvertedByteValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedByteValue other = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualGeneralizeResult = convertedByteValue.generalize((IntegerValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof ConvertedByteValue);
    assertEquals(convertedByteValue, actualGeneralizeResult);
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link SpecificIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.generalize(proguard.evaluation.value.IntegerValue)"
  })
  void testGeneralizeWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult =
        (new ParticularIntegerValue(Integer.MIN_VALUE))
            .generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@link
   *       ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IntegerValue) with 'IntegerValue'; when ConvertedByteValue(IntegerValue) with value is INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.generalize(proguard.evaluation.value.IntegerValue)"
  })
  void testGeneralizeWithIntegerValue_whenConvertedByteValueWithValueIsInteger_value_0() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualGeneralizeResult =
        convertedByteValue.generalize(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.generalize(proguard.evaluation.value.IntegerValue)"
  })
  void testGeneralizeWithIntegerValue_whenInteger_value_0_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.generalize(proguard.evaluation.value.IntegerValue)"
  })
  void testGeneralizeWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.generalize(proguard.evaluation.value.IntegerValue)"
  })
  void testGeneralizeWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).generalize(other));
  }

  /**
   * Test {@link SpecificIntegerValue#generalize(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.generalize(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testGeneralizeWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualGeneralizeResult =
        particularIntegerValue.generalize(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#generalize(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(RangeIntegerValue) with 'RangeIntegerValue'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.generalize(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testGeneralizeWithRangeIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualGeneralizeResult =
        convertedByteValue.generalize(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#generalize(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#generalize(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.generalize(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testGeneralizeWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertSame(
        particularIntegerValue,
        particularIntegerValue.generalize((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link SpecificIntegerValue#generalize(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#generalize(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.generalize(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testGeneralizeWithSpecificIntegerValue2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualGeneralizeResult =
        particularIntegerValue.generalize(
            new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#generalize(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is one.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#generalize(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(SpecificIntegerValue) with 'SpecificIntegerValue'; given ParticularIntegerValue(int) with value is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.generalize(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testGeneralizeWithSpecificIntegerValue_givenParticularIntegerValueWithValueIsOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualGeneralizeResult =
        particularIntegerValue.generalize((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#generalize(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#generalize(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(SpecificIntegerValue) with 'SpecificIntegerValue'; when 'null'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.generalize(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testGeneralizeWithSpecificIntegerValue_whenNull_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult =
        (new ParticularIntegerValue(42)).generalize((SpecificIntegerValue) null);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName("Test add(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.add(proguard.evaluation.value.IntegerValue)"
  })
  void testAddWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        (new ParticularIntegerValue(42)).add(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.add(proguard.evaluation.value.IntegerValue)"
  })
  void testAddWithIntegerValue_whenInteger_value_0_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .add(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.add(proguard.evaluation.value.IntegerValue)"
  })
  void testAddWithIntegerValue_whenInteger_value_byte_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .add(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.add(proguard.evaluation.value.IntegerValue)"
  })
  void testAddWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).add(other));
  }

  /**
   * Test {@link SpecificIntegerValue#add(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(RangeIntegerValue) with 'RangeIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.add(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testAddWithRangeIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualAddResult = convertedByteValue.add(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#add(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.add(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testAddWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAddResult = particularIntegerValue.add(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#add(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#add(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test add(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.add(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testAddWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAddResult =
        particularIntegerValue.add((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(IntegerValue) with 'IntegerValue'; given ConvertedByteValue(IntegerValue) with value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtract(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractWithIntegerValue_givenConvertedByteValueWithValueIsNull() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act
    IntegerValue actualSubtractResult =
        convertedByteValue.subtract(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtract(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractWithIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractResult =
        convertedByteValue.subtract(
            (IntegerValue) new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularIntegerValue);
    assertEquals(0, actualSubtractResult.value());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtract(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        (new ParticularIntegerValue(42)).subtract(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@link
   *       ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(IntegerValue) with 'IntegerValue'; when ConvertedByteValue(IntegerValue) with value is INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtract(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractWithIntegerValue_whenConvertedByteValueWithValueIsInteger_value_0() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractResult =
        convertedByteValue.subtract(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtract(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractWithIntegerValue_whenInteger_value_0_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .subtract(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtract(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .subtract(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtract(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).subtract(other));
  }

  /**
   * Test {@link SpecificIntegerValue#subtract(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(RangeIntegerValue) with 'RangeIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtract(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testSubtractWithRangeIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractResult = convertedByteValue.subtract(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtract(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtract(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testSubtractWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractResult =
        particularIntegerValue.subtract(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtract(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtract(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testSubtractWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractResult =
        particularIntegerValue.subtract(
            new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtract(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is one.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(SpecificIntegerValue) with 'SpecificIntegerValue'; given ParticularIntegerValue(int) with value is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtract(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testSubtractWithSpecificIntegerValue_givenParticularIntegerValueWithValueIsOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualSubtractResult =
        particularIntegerValue.subtract((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtract(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(SpecificIntegerValue) with 'SpecificIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtract(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testSubtractWithSpecificIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractResult =
        particularIntegerValue.subtract((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularIntegerValue);
    assertEquals(0, actualSubtractResult.value());
    assertFalse(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtract(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(SpecificIntegerValue) with 'SpecificIntegerValue'; when 'null'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtract(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testSubtractWithSpecificIntegerValue_whenNull_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        (new ParticularIntegerValue(42)).subtract((SpecificIntegerValue) null);

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtractFrom(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractFromWithIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractFromResult =
        convertedByteValue.subtractFrom(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(IntegerValue) with 'IntegerValue'; given ConvertedByteValue(IntegerValue) with value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtractFrom(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractFromWithIntegerValue_givenConvertedByteValueWithValueIsNull() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act
    IntegerValue actualSubtractFromResult =
        convertedByteValue.subtractFrom(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtractFrom(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractFromWithIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractFromResult =
        convertedByteValue.subtractFrom(
            (IntegerValue) new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularIntegerValue);
    assertEquals(0, actualSubtractFromResult.value());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtractFrom(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractFromWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        (new ParticularIntegerValue(42)).subtractFrom(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtractFrom(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractFromWithIntegerValue_whenInteger_value_0() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .subtractFrom(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtractFrom(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractFromWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .subtractFrom(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtractFrom(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractFromWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).subtractFrom(other));
  }

  /**
   * Test {@link SpecificIntegerValue#subtractFrom(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(RangeIntegerValue) with 'RangeIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtractFrom(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testSubtractFromWithRangeIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractFromResult =
        convertedByteValue.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtractFrom(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtractFrom(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testSubtractFromWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractFromResult =
        particularIntegerValue.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtractFrom(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtractFrom(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testSubtractFromWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualSubtractFromResult =
        particularIntegerValue.subtractFrom((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtractFrom(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtractFrom(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testSubtractFromWithSpecificIntegerValue2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractFromResult =
        particularIntegerValue.subtractFrom(
            new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtractFrom(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(SpecificIntegerValue) with 'SpecificIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtractFrom(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testSubtractFromWithSpecificIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractFromResult =
        particularIntegerValue.subtractFrom((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularIntegerValue);
    assertEquals(0, actualSubtractFromResult.value());
    assertFalse(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#subtractFrom(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(SpecificIntegerValue) with 'SpecificIntegerValue'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.subtractFrom(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testSubtractFromWithSpecificIntegerValue_whenNull() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        (new ParticularIntegerValue(42)).subtractFrom((SpecificIntegerValue) null);

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.multiply(proguard.evaluation.value.IntegerValue)"
  })
  void testMultiplyWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .multiply(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.multiply(proguard.evaluation.value.IntegerValue)"
  })
  void testMultiplyWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        (new ParticularIntegerValue(42)).multiply(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.multiply(proguard.evaluation.value.IntegerValue)"
  })
  void testMultiplyWithIntegerValue_whenInteger_value_0_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .multiply(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.multiply(proguard.evaluation.value.IntegerValue)"
  })
  void testMultiplyWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).multiply(other));
  }

  /**
   * Test {@link SpecificIntegerValue#multiply(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(RangeIntegerValue) with 'RangeIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.multiply(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testMultiplyWithRangeIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualMultiplyResult = convertedByteValue.multiply(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#multiply(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.multiply(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testMultiplyWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualMultiplyResult =
        particularIntegerValue.multiply(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#multiply(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#multiply(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.multiply(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testMultiplyWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualMultiplyResult =
        particularIntegerValue.multiply((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.divide(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideWithIntegerValue_whenInteger_value_0_thenReturnCompositeIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .divide(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName("Test divide(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.divide(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideWithIntegerValue_whenInteger_value_byte() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .divide(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.divide(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).divide(other));
  }

  /**
   * Test {@link SpecificIntegerValue#divide(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(RangeIntegerValue) with 'RangeIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.divide(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testDivideWithRangeIntegerValue_thenReturnCompositeIntegerValue()
      throws ArithmeticException {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualDivideResult = convertedByteValue.divide(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#divide(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.divide(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testDivideWithRangeIntegerValue_thenReturnRangeIntegerValue() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideResult = particularIntegerValue.divide(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#divide(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#divide(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test divide(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.divide(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testDivideWithSpecificIntegerValue() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideResult =
        particularIntegerValue.divide((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.divideOf(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideOfWithIntegerValue_thenReturnCompositeIntegerValue() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .divideOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.divideOf(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideOfWithIntegerValue_thenReturnRangeIntegerValue() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        (new ParticularIntegerValue(42)).divideOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.divideOf(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideOfWithIntegerValue_whenInteger_value_0_thenReturnCompositeIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .divideOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.divideOf(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideOfWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).divideOf(other));
  }

  /**
   * Test {@link SpecificIntegerValue#divideOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(RangeIntegerValue) with 'RangeIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.divideOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testDivideOfWithRangeIntegerValue_thenReturnCompositeIntegerValue()
      throws ArithmeticException {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualDivideOfResult = convertedByteValue.divideOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#divideOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.divideOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testDivideOfWithRangeIntegerValue_thenReturnRangeIntegerValue() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideOfResult =
        particularIntegerValue.divideOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isSpecific());
    assertTrue(actualDivideOfResult.isParticular());
  }

  /**
   * Test {@link SpecificIntegerValue#divideOf(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#divideOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.divideOf(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testDivideOfWithSpecificIntegerValue() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideOfResult =
        particularIntegerValue.divideOf((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.remainder(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderWithIntegerValue_whenInteger_value_0() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .remainder(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.remainder(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderWithIntegerValue_whenInteger_value_byte() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .remainder(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.remainder(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).remainder(other));
  }

  /**
   * Test {@link SpecificIntegerValue#remainder(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(RangeIntegerValue) with 'RangeIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.remainder(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testRemainderWithRangeIntegerValue_thenReturnCompositeIntegerValue()
      throws ArithmeticException {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualRemainderResult = convertedByteValue.remainder(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#remainder(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.remainder(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testRemainderWithRangeIntegerValue_thenReturnRangeIntegerValue() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderResult =
        particularIntegerValue.remainder(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#remainder(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#remainder(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.remainder(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testRemainderWithSpecificIntegerValue() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderResult =
        particularIntegerValue.remainder((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.remainderOf(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderOfWithIntegerValue_whenInteger_value_0() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .remainderOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.remainderOf(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderOfWithIntegerValue_whenInteger_value_byte() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .remainderOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.remainderOf(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderOfWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).remainderOf(other));
  }

  /**
   * Test {@link SpecificIntegerValue#remainderOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.remainderOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testRemainderOfWithRangeIntegerValue() throws ArithmeticException {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualRemainderOfResult =
        convertedByteValue.remainderOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#remainderOf(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#remainderOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.remainderOf(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testRemainderOfWithSpecificIntegerValue() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderOfResult =
        particularIntegerValue.remainderOf((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftLeft(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftWithIntegerValue_whenInteger_value_0() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftLeft(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftLeft(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftLeft(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).shiftLeft(other));
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeft(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(RangeIntegerValue) with 'RangeIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftLeft(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftLeftWithRangeIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftLeftResult = convertedByteValue.shiftLeft(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeft(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftLeft(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftLeftWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftResult =
        particularIntegerValue.shiftLeft(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeft(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeft(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftLeft(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testShiftLeftWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftResult =
        particularIntegerValue.shiftLeft((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftLeftOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftOfWithIntegerValue_whenInteger_value_0() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftLeftOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftLeftOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftOfWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftLeftOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftLeftOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftOfWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).shiftLeftOf(other));
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeftOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(LongValue) with 'LongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificIntegerValue.shiftLeftOf(proguard.evaluation.value.LongValue)"
  })
  void testShiftLeftOfWithLongValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualShiftLeftOfResult =
        convertedByteValue.shiftLeftOf(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isCategory2());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeftOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(LongValue) with 'LongValue'; given ParticularIntegerValue(int) with value is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificIntegerValue.shiftLeftOf(proguard.evaluation.value.LongValue)"
  })
  void testShiftLeftOfWithLongValue_givenParticularIntegerValueWithValueIsFortyTwo() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).shiftLeftOf(other));
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeftOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(LongValue) with 'LongValue'; when LONG_VALUE_0; then return CompositeLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificIntegerValue.shiftLeftOf(proguard.evaluation.value.LongValue)"
  })
  void testShiftLeftOfWithLongValue_whenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualShiftLeftOfResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftLeftOf(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isCategory2());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeftOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificIntegerValue.shiftLeftOf(proguard.evaluation.value.LongValue)"
  })
  void testShiftLeftOfWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).shiftLeftOf(other));
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeftOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeftOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftLeftOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftLeftOfWithRangeIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftLeftOfResult =
        convertedByteValue.shiftLeftOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeftOf(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeftOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftLeftOf(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testShiftLeftOfWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftOfResult =
        particularIntegerValue.shiftLeftOf((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeftOf(SpecificLongValue)} with {@code
   * SpecificLongValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeftOf(SpecificLongValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(SpecificLongValue) with 'SpecificLongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificIntegerValue.shiftLeftOf(proguard.evaluation.value.SpecificLongValue)"
  })
  void testShiftLeftOfWithSpecificLongValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualShiftLeftOfResult =
        particularIntegerValue.shiftLeftOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isCategory2());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightWithIntegerValue_whenInteger_value_0() {
    // Arrange and Act
    IntegerValue actualShiftRightResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualShiftRightResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).shiftRight(other));
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRight(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(RangeIntegerValue) with 'RangeIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftRight(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftRightWithRangeIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftRightResult =
        convertedByteValue.shiftRight(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRight(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftRight(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftRightWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightResult =
        particularIntegerValue.shiftRight(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRight(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRight(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftRight(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testShiftRightWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightResult =
        particularIntegerValue.shiftRight((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftRightOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightOfWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftRightOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightOfWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult =
        (new ParticularIntegerValue(42)).shiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftRightOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightOfWithIntegerValue_whenInteger_value_0() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftRightOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftRightOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightOfWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).shiftRightOf(other));
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(LongValue) with 'LongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificIntegerValue.shiftRightOf(proguard.evaluation.value.LongValue)"
  })
  void testShiftRightOfWithLongValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualShiftRightOfResult =
        convertedByteValue.shiftRightOf(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isCategory2());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(LongValue) with 'LongValue'; given ParticularIntegerValue(int) with value is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificIntegerValue.shiftRightOf(proguard.evaluation.value.LongValue)"
  })
  void testShiftRightOfWithLongValue_givenParticularIntegerValueWithValueIsFortyTwo() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).shiftRightOf(other));
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(LongValue) with 'LongValue'; when LONG_VALUE_0; then return CompositeLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificIntegerValue.shiftRightOf(proguard.evaluation.value.LongValue)"
  })
  void testShiftRightOfWithLongValue_whenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualShiftRightOfResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .shiftRightOf(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isCategory2());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificIntegerValue.shiftRightOf(proguard.evaluation.value.LongValue)"
  })
  void testShiftRightOfWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).shiftRightOf(other));
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRightOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRightOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(RangeIntegerValue) with 'RangeIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftRightOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftRightOfWithRangeIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftRightOfResult =
        convertedByteValue.shiftRightOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRightOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRightOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftRightOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftRightOfWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightOfResult =
        particularIntegerValue.shiftRightOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isParticular());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRightOf(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRightOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.shiftRightOf(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testShiftRightOfWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightOfResult =
        particularIntegerValue.shiftRightOf((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRightOf(SpecificLongValue)} with {@code
   * SpecificLongValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRightOf(SpecificLongValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(SpecificLongValue) with 'SpecificLongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificIntegerValue.shiftRightOf(proguard.evaluation.value.SpecificLongValue)"
  })
  void testShiftRightOfWithSpecificLongValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualShiftRightOfResult =
        particularIntegerValue.shiftRightOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isCategory2());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightWithIntegerValue_whenInteger_value_0() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .unsignedShiftRight(other));
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRight(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(RangeIntegerValue) with 'RangeIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRight(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testUnsignedShiftRightWithRangeIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        convertedByteValue.unsignedShiftRight(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRight(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRight(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testUnsignedShiftRightWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        particularIntegerValue.unsignedShiftRight(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRight(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRight(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRight(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testUnsignedShiftRightWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        particularIntegerValue.unsignedShiftRight(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightOfWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .unsignedShiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightOfWithIntegerValue_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .unsignedShiftRightOf(other));
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightOfWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult =
        (new ParticularIntegerValue(42))
            .unsignedShiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightOfWithIntegerValue_whenInteger_value_0() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .unsignedShiftRightOf(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(LongValue) with 'LongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.LongValue)"
  })
  void testUnsignedShiftRightOfWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).unsignedShiftRightOf(other));
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(LongValue) with 'LongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.LongValue)"
  })
  void testUnsignedShiftRightOfWithLongValue2() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        convertedByteValue.unsignedShiftRightOf(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(LongValue) with 'LongValue'; when LONG_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.LongValue)"
  })
  void testUnsignedShiftRightOfWithLongValue_whenLong_value_0() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightOfResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .unsignedShiftRightOf(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.LongValue)"
  })
  void testUnsignedShiftRightOfWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .unsignedShiftRightOf(other));
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRightOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(RangeIntegerValue) with 'RangeIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testUnsignedShiftRightOfWithRangeIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        convertedByteValue.unsignedShiftRightOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRightOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testUnsignedShiftRightOfWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        particularIntegerValue.unsignedShiftRightOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isParticular());
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRightOf(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRightOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testUnsignedShiftRightOfWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        particularIntegerValue.unsignedShiftRightOf(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#unsignedShiftRightOf(SpecificLongValue)} with {@code
   * SpecificLongValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRightOf(SpecificLongValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(SpecificLongValue) with 'SpecificLongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.SpecificLongValue)"
  })
  void testUnsignedShiftRightOfWithSpecificLongValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        particularIntegerValue.unsignedShiftRightOf(
            (SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(IntegerValue) with 'IntegerValue'; given ConvertedByteValue(IntegerValue) with value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.and(proguard.evaluation.value.IntegerValue)"
  })
  void testAndWithIntegerValue_givenConvertedByteValueWithValueIsNull() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act
    IntegerValue actualAndResult =
        convertedByteValue.and(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedByteValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName("Test and(IntegerValue) with 'IntegerValue'; then return ConvertedByteValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.and(proguard.evaluation.value.IntegerValue)"
  })
  void testAndWithIntegerValue_thenReturnConvertedByteValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedByteValue other = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualAndResult = convertedByteValue.and((IntegerValue) other);

    // Assert
    assertTrue(actualAndResult instanceof ConvertedByteValue);
    assertEquals(convertedByteValue, actualAndResult);
    assertSame(other, actualAndResult);
  }

  /**
   * Test {@link SpecificIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName("Test and(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.and(proguard.evaluation.value.IntegerValue)"
  })
  void testAndWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult =
        (new ParticularIntegerValue(42)).and(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAndResult instanceof RangeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@link
   *       ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(IntegerValue) with 'IntegerValue'; when ConvertedByteValue(IntegerValue) with value is INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.and(proguard.evaluation.value.IntegerValue)"
  })
  void testAndWithIntegerValue_whenConvertedByteValueWithValueIsInteger_value_0() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualAndResult =
        convertedByteValue.and(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.and(proguard.evaluation.value.IntegerValue)"
  })
  void testAndWithIntegerValue_whenInteger_value_0_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .and(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.and(proguard.evaluation.value.IntegerValue)"
  })
  void testAndWithIntegerValue_whenInteger_value_byte_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .and(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.and(proguard.evaluation.value.IntegerValue)"
  })
  void testAndWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).and(other));
  }

  /**
   * Test {@link SpecificIntegerValue#and(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#and(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(RangeIntegerValue) with 'RangeIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.and(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testAndWithRangeIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualAndResult = convertedByteValue.and(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#and(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#and(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.and(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testAndWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAndResult = particularIntegerValue.and(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAndResult instanceof RangeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#and(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test and(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.and(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testAndWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertSame(
        particularIntegerValue,
        particularIntegerValue.and((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link SpecificIntegerValue#and(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test and(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.and(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testAndWithSpecificIntegerValue2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAndResult =
        particularIntegerValue.and(
            new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#and(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is one.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(SpecificIntegerValue) with 'SpecificIntegerValue'; given ParticularIntegerValue(int) with value is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.and(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testAndWithSpecificIntegerValue_givenParticularIntegerValueWithValueIsOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualAndResult =
        particularIntegerValue.and((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#and(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(SpecificIntegerValue) with 'SpecificIntegerValue'; when 'null'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.and(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testAndWithSpecificIntegerValue_whenNull_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult =
        (new ParticularIntegerValue(42)).and((SpecificIntegerValue) null);

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(IntegerValue) with 'IntegerValue'; given ConvertedByteValue(IntegerValue) with value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.or(proguard.evaluation.value.IntegerValue)"
  })
  void testOrWithIntegerValue_givenConvertedByteValueWithValueIsNull() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act
    IntegerValue actualOrResult =
        convertedByteValue.or(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedByteValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName("Test or(IntegerValue) with 'IntegerValue'; then return ConvertedByteValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.or(proguard.evaluation.value.IntegerValue)"
  })
  void testOrWithIntegerValue_thenReturnConvertedByteValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedByteValue other = new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualOrResult = convertedByteValue.or((IntegerValue) other);

    // Assert
    assertTrue(actualOrResult instanceof ConvertedByteValue);
    assertEquals(convertedByteValue, actualOrResult);
    assertSame(other, actualOrResult);
  }

  /**
   * Test {@link SpecificIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName("Test or(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.or(proguard.evaluation.value.IntegerValue)"
  })
  void testOrWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualOrResult =
        (new ParticularIntegerValue(Integer.MIN_VALUE))
            .or(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualOrResult instanceof RangeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@link
   *       ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(IntegerValue) with 'IntegerValue'; when ConvertedByteValue(IntegerValue) with value is INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.or(proguard.evaluation.value.IntegerValue)"
  })
  void testOrWithIntegerValue_whenConvertedByteValueWithValueIsInteger_value_0() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualOrResult =
        convertedByteValue.or(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.or(proguard.evaluation.value.IntegerValue)"
  })
  void testOrWithIntegerValue_whenInteger_value_0_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualOrResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .or(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.or(proguard.evaluation.value.IntegerValue)"
  })
  void testOrWithIntegerValue_whenInteger_value_byte_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualOrResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .or(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.or(proguard.evaluation.value.IntegerValue)"
  })
  void testOrWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).or(other));
  }

  /**
   * Test {@link SpecificIntegerValue#or(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#or(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test or(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.or(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testOrWithRangeIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualOrResult = convertedByteValue.or(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#or(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#or(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test or(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.or(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testOrWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertSame(
        particularIntegerValue,
        particularIntegerValue.or((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link SpecificIntegerValue#or(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#or(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test or(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.or(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testOrWithSpecificIntegerValue2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualOrResult =
        particularIntegerValue.or(
            new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#or(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is one.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#or(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(SpecificIntegerValue) with 'SpecificIntegerValue'; given ParticularIntegerValue(int) with value is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.or(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testOrWithSpecificIntegerValue_givenParticularIntegerValueWithValueIsOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualOrResult =
        particularIntegerValue.or((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#or(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#or(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(SpecificIntegerValue) with 'SpecificIntegerValue'; when 'null'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.or(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testOrWithSpecificIntegerValue_whenNull_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualOrResult = (new ParticularIntegerValue(42)).or((SpecificIntegerValue) null);

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#xor(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(IntegerValue) with 'IntegerValue'; given ConvertedByteValue(IntegerValue) with value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.xor(proguard.evaluation.value.IntegerValue)"
  })
  void testXorWithIntegerValue_givenConvertedByteValueWithValueIsNull() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act
    IntegerValue actualXorResult =
        convertedByteValue.xor(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#xor(IntegerValue)}
   */
  @Test
  @DisplayName("Test xor(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.xor(proguard.evaluation.value.IntegerValue)"
  })
  void testXorWithIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualXorResult =
        convertedByteValue.xor(
            (IntegerValue) new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualXorResult instanceof ParticularIntegerValue);
    assertEquals(0, actualXorResult.value());
    assertFalse(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@link
   *       ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#xor(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(IntegerValue) with 'IntegerValue'; when ConvertedByteValue(IntegerValue) with value is INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.xor(proguard.evaluation.value.IntegerValue)"
  })
  void testXorWithIntegerValue_whenConvertedByteValueWithValueIsInteger_value_0() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualXorResult =
        convertedByteValue.xor(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#xor(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.xor(proguard.evaluation.value.IntegerValue)"
  })
  void testXorWithIntegerValue_whenInteger_value_0_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualXorResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .xor(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#xor(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.xor(proguard.evaluation.value.IntegerValue)"
  })
  void testXorWithIntegerValue_whenInteger_value_byte_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualXorResult =
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .xor(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#xor(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.xor(proguard.evaluation.value.IntegerValue)"
  })
  void testXorWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).xor(other));
  }

  /**
   * Test {@link SpecificIntegerValue#xor(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#xor(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test xor(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.xor(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testXorWithRangeIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualXorResult = convertedByteValue.xor(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#xor(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#xor(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test xor(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.xor(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testXorWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualXorResult =
        particularIntegerValue.xor(
            new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#xor(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is one.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#xor(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(SpecificIntegerValue) with 'SpecificIntegerValue'; given ParticularIntegerValue(int) with value is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.xor(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testXorWithSpecificIntegerValue_givenParticularIntegerValueWithValueIsOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualXorResult =
        particularIntegerValue.xor((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#xor(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#xor(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(SpecificIntegerValue) with 'SpecificIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.xor(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testXorWithSpecificIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualXorResult =
        particularIntegerValue.xor((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualXorResult instanceof ParticularIntegerValue);
    assertEquals(0, actualXorResult.value());
    assertFalse(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#xor(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#xor(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(SpecificIntegerValue) with 'SpecificIntegerValue'; when 'null'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificIntegerValue.xor(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testXorWithSpecificIntegerValue_whenNull_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualXorResult =
        (new ParticularIntegerValue(42)).xor((SpecificIntegerValue) null);

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(IntegerValue) with 'IntegerValue'; given ConvertedByteValue(IntegerValue) with value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.equal(proguard.evaluation.value.IntegerValue)"
  })
  void testEqualWithIntegerValue_givenConvertedByteValueWithValueIsNull() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act and Assert
    assertEquals(
        0,
        convertedByteValue.equal(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0)));
  }

  /**
   * Test {@link SpecificIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName("Test equal(IntegerValue) with 'IntegerValue'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.equal(proguard.evaluation.value.IntegerValue)"
  })
  void testEqualWithIntegerValue_thenReturnOne() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        1,
        convertedByteValue.equal(
            (IntegerValue) new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link SpecificIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@link
   *       ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(IntegerValue) with 'IntegerValue'; when ConvertedByteValue(IntegerValue) with value is INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.equal(proguard.evaluation.value.IntegerValue)"
  })
  void testEqualWithIntegerValue_whenConvertedByteValueWithValueIsInteger_value_0() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        convertedByteValue.equal(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0)));
  }

  /**
   * Test {@link SpecificIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.equal(proguard.evaluation.value.IntegerValue)"
  })
  void testEqualWithIntegerValue_whenInteger_value_0_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link SpecificIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.equal(proguard.evaluation.value.IntegerValue)"
  })
  void testEqualWithIntegerValue_whenInteger_value_byte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link SpecificIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName("Test equal(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.equal(proguard.evaluation.value.IntegerValue)"
  })
  void testEqualWithIntegerValue_whenInteger_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .equal(BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Test {@link SpecificIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.equal(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testEqualWithRangeIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, convertedByteValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link SpecificIntegerValue#equal(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#equal(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.equal(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testEqualWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(
        0,
        particularIntegerValue.equal(
            new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link SpecificIntegerValue#equal(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is one.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#equal(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(SpecificIntegerValue) with 'SpecificIntegerValue'; given ParticularIntegerValue(int) with value is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.equal(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testEqualWithSpecificIntegerValue_givenParticularIntegerValueWithValueIsOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertEquals(
        0, particularIntegerValue.equal((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link SpecificIntegerValue#equal(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#equal(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(SpecificIntegerValue) with 'SpecificIntegerValue'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.equal(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testEqualWithSpecificIntegerValue_thenReturnOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(
        1, particularIntegerValue.equal((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link SpecificIntegerValue#equal(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#equal(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(SpecificIntegerValue) with 'SpecificIntegerValue'; when 'null'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.equal(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testEqualWithSpecificIntegerValue_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new ParticularIntegerValue(42)).equal((SpecificIntegerValue) null));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(IntegerValue) with 'IntegerValue'; given ConvertedByteValue(IntegerValue) with value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThan(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanWithIntegerValue_givenConvertedByteValueWithValueIsNull() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act and Assert
    assertEquals(
        0,
        convertedByteValue.lessThan(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0)));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(IntegerValue) with 'IntegerValue'; given ParticularIntegerValue(int) with value is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThan(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanWithIntegerValue_givenParticularIntegerValueWithValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        0, (new ParticularIntegerValue(42)).lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(IntegerValue) with 'IntegerValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThan(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanWithIntegerValue_thenReturnNever() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        Value.NEVER,
        convertedByteValue.lessThan(
            (IntegerValue) new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@link
   *       ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(IntegerValue) with 'IntegerValue'; when ConvertedByteValue(IntegerValue) with value is INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThan(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanWithIntegerValue_whenConvertedByteValueWithValueIsInteger_value_0() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        convertedByteValue.lessThan(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0)));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThan(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanWithIntegerValue_whenInteger_value_0_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .lessThan(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThan(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanWithIntegerValue_whenInteger_value_byte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThan(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanWithIntegerValue_whenInteger_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .lessThan(BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(RangeIntegerValue) with 'RangeIntegerValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThan(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testLessThanWithRangeIntegerValue_thenReturnNever() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(RangeIntegerValue) with 'RangeIntegerValue'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThan(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testLessThanWithRangeIntegerValue_thenReturnZero() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, convertedByteValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThan(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThan(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThan(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testLessThanWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(
        0,
        particularIntegerValue.lessThan(
            new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThan(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is one.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThan(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(SpecificIntegerValue) with 'SpecificIntegerValue'; given ParticularIntegerValue(int) with value is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThan(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testLessThanWithSpecificIntegerValue_givenParticularIntegerValueWithValueIsOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertEquals(
        0, particularIntegerValue.lessThan((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThan(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThan(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(SpecificIntegerValue) with 'SpecificIntegerValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThan(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testLessThanWithSpecificIntegerValue_thenReturnNever() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(
        Value.NEVER,
        particularIntegerValue.lessThan((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThan(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThan(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(SpecificIntegerValue) with 'SpecificIntegerValue'; when 'null'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThan(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testLessThanWithSpecificIntegerValue_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new ParticularIntegerValue(42)).lessThan((SpecificIntegerValue) null));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanOrEqualWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ParticularIntegerValue(42))
            .lessThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanOrEqualWithIntegerValue2() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        0,
        convertedByteValue.lessThanOrEqual(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0)));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(IntegerValue) with 'IntegerValue'; given ConvertedByteValue(IntegerValue) with value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanOrEqualWithIntegerValue_givenConvertedByteValueWithValueIsNull() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act and Assert
    assertEquals(
        0,
        convertedByteValue.lessThanOrEqual(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0)));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(IntegerValue) with 'IntegerValue'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanOrEqualWithIntegerValue_thenReturnOne() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(
        1,
        convertedByteValue.lessThanOrEqual(
            (IntegerValue) new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanOrEqualWithIntegerValue_whenInteger_value_0_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .lessThanOrEqual(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanOrEqualWithIntegerValue_whenInteger_value_byte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .lessThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanOrEqualWithIntegerValue_whenInteger_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .lessThanOrEqual(BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThanOrEqual(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(RangeIntegerValue) with 'RangeIntegerValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThanOrEqual(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testLessThanOrEqualWithRangeIntegerValue_thenReturnNever() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThanOrEqual(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(RangeIntegerValue) with 'RangeIntegerValue'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThanOrEqual(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testLessThanOrEqualWithRangeIntegerValue_thenReturnZero() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, convertedByteValue.lessThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThanOrEqual(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThanOrEqual(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testLessThanOrEqualWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertEquals(
        0,
        particularIntegerValue.lessThanOrEqual(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThanOrEqual(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThanOrEqual(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testLessThanOrEqualWithSpecificIntegerValue2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(
        0,
        particularIntegerValue.lessThanOrEqual(
            new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThanOrEqual(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(SpecificIntegerValue) with 'SpecificIntegerValue'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThanOrEqual(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testLessThanOrEqualWithSpecificIntegerValue_thenReturnOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(
        1,
        particularIntegerValue.lessThanOrEqual(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThanOrEqual(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(SpecificIntegerValue) with 'SpecificIntegerValue'; when 'null'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.SpecificIntegerValue.lessThanOrEqual(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testLessThanOrEqualWithSpecificIntegerValue_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new ParticularIntegerValue(42)).lessThanOrEqual((SpecificIntegerValue) null));
  }

  /**
   * Test {@link SpecificIntegerValue#isSpecific()}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#isSpecific()}
   */
  @Test
  @DisplayName("Test isSpecific()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.SpecificIntegerValue.isSpecific()"})
  void testIsSpecific() {
    // Arrange, Act and Assert
    assertTrue((new ParticularIntegerValue(42)).isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#equals(Object)}, and {@link SpecificIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.SpecificIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.SpecificIntegerValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);
    ParticularIntegerValue particularIntegerValue2 = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(particularIntegerValue, particularIntegerValue2);
    int expectedHashCodeResult = particularIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, particularIntegerValue2.hashCode());
  }

  /**
   * Test {@link SpecificIntegerValue#equals(Object)}, and {@link SpecificIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.SpecificIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.SpecificIntegerValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(particularIntegerValue, particularIntegerValue);
    int expectedHashCodeResult = particularIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, particularIntegerValue.hashCode());
  }

  /**
   * Test {@link SpecificIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.SpecificIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.SpecificIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertNotEquals(particularIntegerValue, new ParticularIntegerValue(42));
  }

  /**
   * Test {@link SpecificIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.SpecificIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.SpecificIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularIntegerValue(42), null);
  }

  /**
   * Test {@link SpecificIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.SpecificIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.SpecificIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularIntegerValue(42), "Different type to SpecificIntegerValue");
  }
}
