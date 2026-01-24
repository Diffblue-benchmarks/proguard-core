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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.negate()"})
  void testNegate_thenReturnNegatedIntegerValue() {
    // Arrange and Act
    IntegerValue actualNegateResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).negate();

    // Assert
    assertTrue(actualNegateResult instanceof NegatedIntegerValue);
    assertFalse(actualNegateResult.isCategory2());
    assertFalse(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#convertToByte()}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedByteValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#convertToByte()}
   */
  @Test
  @DisplayName("Test convertToByte(); then return ConvertedByteValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.convertToByte()"})
  void testConvertToByte_thenReturnConvertedByteValue() {
    // Arrange and Act
    IntegerValue actualConvertToByteResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).convertToByte();

    // Assert
    assertTrue(actualConvertToByteResult instanceof ConvertedByteValue);
    assertFalse(actualConvertToByteResult.isCategory2());
    assertFalse(actualConvertToByteResult.isParticular());
    assertTrue(actualConvertToByteResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#convertToByte()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#convertToByte()}
   */
  @Test
  @DisplayName("Test convertToByte(); then return ParticularIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.convertToByte()"})
  void testConvertToByte_thenReturnParticularIntegerValue() {
    // Arrange and Act
    IntegerValue actualConvertToByteResult =
        new ParticularIntegerValue(Integer.MIN_VALUE).convertToByte();

    // Assert
    assertTrue(actualConvertToByteResult instanceof ParticularIntegerValue);
    assertEquals(0, actualConvertToByteResult.value());
    assertFalse(actualConvertToByteResult.isCategory2());
    assertTrue(actualConvertToByteResult.isParticular());
    assertTrue(actualConvertToByteResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#convertToCharacter()}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedCharacterValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#convertToCharacter()}
   */
  @Test
  @DisplayName("Test convertToCharacter(); then return ConvertedCharacterValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.convertToCharacter()"})
  void testConvertToCharacter_thenReturnConvertedCharacterValue() {
    // Arrange and Act
    IntegerValue actualConvertToCharacterResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).convertToCharacter();

    // Assert
    assertTrue(actualConvertToCharacterResult instanceof ConvertedCharacterValue);
    assertFalse(actualConvertToCharacterResult.isCategory2());
    assertFalse(actualConvertToCharacterResult.isParticular());
    assertTrue(actualConvertToCharacterResult.isSpecific());
  }

  /**
   * Test {@link SpecificIntegerValue#convertToShort()}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedShortValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#convertToShort()}
   */
  @Test
  @DisplayName("Test convertToShort(); then return ConvertedShortValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.convertToShort()"})
  void testConvertToShort_thenReturnConvertedShortValue() {
    // Arrange and Act
    IntegerValue actualConvertToShortResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).convertToShort();

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue SpecificIntegerValue.convertToLong()"})
  void testConvertToLong_thenReturnConvertedLongValue() {
    // Arrange and Act
    LongValue actualConvertToLongResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof ConvertedLongValue);
    assertFalse(actualConvertToLongResult.isParticular());
    assertTrue(actualConvertToLongResult.isCategory2());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue SpecificIntegerValue.convertToFloat()"})
  void testConvertToFloat_thenReturnConvertedFloatValue() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof ConvertedFloatValue);
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertFalse(actualConvertToFloatResult.isParticular());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue SpecificIntegerValue.convertToDouble()"})
  void testConvertToDouble_thenReturnConvertedDoubleValue() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof ConvertedDoubleValue);
    assertFalse(actualConvertToDoubleResult.isParticular());
    assertTrue(actualConvertToDoubleResult.isCategory2());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.generalize(IntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.generalize(IntegerValue)"})
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
   *   <li>When {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@link
   *       ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IntegerValue) with 'IntegerValue'; when ConvertedByteValue(IntegerValue) with value is INTEGER_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.generalize(IntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.generalize(IntegerValue)"})
  void testGeneralizeWithIntegerValue_whenInteger_value_0_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.generalize(IntegerValue)"})
  void testGeneralizeWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.generalize(IntegerValue)"})
  void testGeneralizeWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualGeneralizeResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.generalize(RangeIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.generalize(SpecificIntegerValue)"})
  void testGeneralizeWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualGeneralizeResult =
        particularIntegerValue.generalize((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(particularIntegerValue, actualGeneralizeResult);
  }

  /**
   * Test {@link SpecificIntegerValue#generalize(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#generalize(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.generalize(SpecificIntegerValue)"})
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
   *   <li>When {@code null}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#generalize(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(SpecificIntegerValue) with 'SpecificIntegerValue'; when 'null'; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.generalize(SpecificIntegerValue)"})
  void testGeneralizeWithSpecificIntegerValue_whenNull_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult =
        new ParticularIntegerValue(42).generalize((SpecificIntegerValue) null);

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
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.add(IntegerValue)"})
  void testAddWithIntegerValue_whenInteger_value_0_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.add(IntegerValue)"})
  void testAddWithIntegerValue_whenInteger_value_byte_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.add(IntegerValue)"})
  void testAddWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualAddResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).add(other);

    // Assert
    assertSame(other, actualAddResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.add(RangeIntegerValue)"})
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
   * Test {@link SpecificIntegerValue#add(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#add(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test add(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.add(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtract(IntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtract(IntegerValue)"})
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
   *   <li>When {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@link
   *       ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(IntegerValue) with 'IntegerValue'; when ConvertedByteValue(IntegerValue) with value is INTEGER_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtract(IntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtract(IntegerValue)"})
  void testSubtractWithIntegerValue_whenInteger_value_0_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtract(IntegerValue)"})
  void testSubtractWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtract(IntegerValue)"})
  void testSubtractWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualSubtractResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).subtract(other);

    // Assert
    assertSame(other, actualSubtractResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtract(RangeIntegerValue)"})
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
   * Test {@link SpecificIntegerValue#subtract(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtract(SpecificIntegerValue)"})
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
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(SpecificIntegerValue) with 'SpecificIntegerValue'; then return ParticularIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtract(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtract(SpecificIntegerValue)"})
  void testSubtractWithSpecificIntegerValue_whenNull_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        new ParticularIntegerValue(42).subtract((SpecificIntegerValue) null);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtractFrom(IntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtractFrom(IntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtractFrom(IntegerValue)"})
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
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtractFrom(IntegerValue)"})
  void testSubtractFromWithIntegerValue_whenInteger_value_0() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtractFrom(IntegerValue)"})
  void testSubtractFromWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtractFrom(IntegerValue)"})
  void testSubtractFromWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualSubtractFromResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).subtractFrom(other);

    // Assert
    assertSame(other, actualSubtractFromResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtractFrom(RangeIntegerValue)"})
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
   * Test {@link SpecificIntegerValue#subtractFrom(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtractFrom(SpecificIntegerValue)"})
  void testSubtractFromWithSpecificIntegerValue() {
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtractFrom(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.subtractFrom(SpecificIntegerValue)"})
  void testSubtractFromWithSpecificIntegerValue_whenNull() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        new ParticularIntegerValue(42).subtractFrom((SpecificIntegerValue) null);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.multiply(IntegerValue)"})
  void testMultiplyWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.multiply(IntegerValue)"})
  void testMultiplyWithIntegerValue_whenInteger_value_0_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.multiply(IntegerValue)"})
  void testMultiplyWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualMultiplyResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).multiply(other);

    // Assert
    assertSame(other, actualMultiplyResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.multiply(RangeIntegerValue)"})
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
   * Test {@link SpecificIntegerValue#multiply(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#multiply(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.multiply(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.divide(IntegerValue)"})
  void testDivideWithIntegerValue_whenInteger_value_0_thenReturnCompositeIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.divide(IntegerValue)"})
  void testDivideWithIntegerValue_whenInteger_value_byte() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.divide(IntegerValue)"})
  void testDivideWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualDivideResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).divide(other);

    // Assert
    assertSame(other, actualDivideResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.divide(RangeIntegerValue)"})
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
   * Test {@link SpecificIntegerValue#divide(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#divide(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test divide(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.divide(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.divideOf(IntegerValue)"})
  void testDivideOfWithIntegerValue_thenReturnCompositeIntegerValue() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.divideOf(IntegerValue)"})
  void testDivideOfWithIntegerValue_whenInteger_value_0_thenReturnCompositeIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.divideOf(IntegerValue)"})
  void testDivideOfWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualDivideOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).divideOf(other);

    // Assert
    assertSame(other, actualDivideOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.divideOf(RangeIntegerValue)"})
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
   * Test {@link SpecificIntegerValue#divideOf(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#divideOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.divideOf(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.remainder(IntegerValue)"})
  void testRemainderWithIntegerValue_whenInteger_value_0() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.remainder(IntegerValue)"})
  void testRemainderWithIntegerValue_whenInteger_value_byte() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.remainder(IntegerValue)"})
  void testRemainderWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualRemainderResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).remainder(other);

    // Assert
    assertSame(other, actualRemainderResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.remainder(RangeIntegerValue)"})
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
   * Test {@link SpecificIntegerValue#remainder(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#remainder(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.remainder(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.remainderOf(IntegerValue)"})
  void testRemainderOfWithIntegerValue_whenInteger_value_0() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.remainderOf(IntegerValue)"})
  void testRemainderOfWithIntegerValue_whenInteger_value_byte() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.remainderOf(IntegerValue)"})
  void testRemainderOfWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualRemainderOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).remainderOf(other);

    // Assert
    assertSame(other, actualRemainderOfResult);
  }

  /**
   * Test {@link SpecificIntegerValue#remainderOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(RangeIntegerValue) with 'RangeIntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.remainderOf(RangeIntegerValue)"})
  void testRemainderOfWithRangeIntegerValue_thenReturnCompositeIntegerValue()
      throws ArithmeticException {
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.remainderOf(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue_whenInteger_value_0() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualShiftLeftResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).shiftLeft(other);

    // Assert
    assertSame(other, actualShiftLeftResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftLeft(RangeIntegerValue)"})
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
   * Test {@link SpecificIntegerValue#shiftLeft(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeft(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftLeft(SpecificIntegerValue)"})
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
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftLeftOf(IntegerValue)"})
  void testShiftLeftOfWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftLeftOf(IntegerValue)"})
  void testShiftLeftOfWithIntegerValue_whenInteger_value_0() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftLeftOf(IntegerValue)"})
  void testShiftLeftOfWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualShiftLeftOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).shiftLeftOf(other);

    // Assert
    assertSame(other, actualShiftLeftOfResult);
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeftOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue SpecificIntegerValue.shiftLeftOf(LongValue)"})
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
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(LongValue) with 'LongValue'; when LONG_VALUE_0; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue SpecificIntegerValue.shiftLeftOf(LongValue)"})
  void testShiftLeftOfWithLongValue_whenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualShiftLeftOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue SpecificIntegerValue.shiftLeftOf(LongValue)"})
  void testShiftLeftOfWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualShiftLeftOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).shiftLeftOf(other);

    // Assert
    assertSame(other, actualShiftLeftOfResult);
  }

  /**
   * Test {@link SpecificIntegerValue#shiftLeftOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftLeftOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(RangeIntegerValue) with 'RangeIntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftLeftOf(RangeIntegerValue)"})
  void testShiftLeftOfWithRangeIntegerValue_thenReturnCompositeIntegerValue() {
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftLeftOf(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue SpecificIntegerValue.shiftLeftOf(SpecificLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue_whenInteger_value_0() {
    // Arrange and Act
    IntegerValue actualShiftRightResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualShiftRightResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualShiftRightResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).shiftRight(other);

    // Assert
    assertSame(other, actualShiftRightResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftRight(RangeIntegerValue)"})
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
   * Test {@link SpecificIntegerValue#shiftRight(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRight(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftRight(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftRightOf(IntegerValue)"})
  void testShiftRightOfWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftRightOf(IntegerValue)"})
  void testShiftRightOfWithIntegerValue_whenInteger_value_0() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftRightOf(IntegerValue)"})
  void testShiftRightOfWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualShiftRightOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).shiftRightOf(other);

    // Assert
    assertSame(other, actualShiftRightOfResult);
  }

  /**
   * Test {@link SpecificIntegerValue#shiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue SpecificIntegerValue.shiftRightOf(LongValue)"})
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
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(LongValue) with 'LongValue'; when LONG_VALUE_0; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue SpecificIntegerValue.shiftRightOf(LongValue)"})
  void testShiftRightOfWithLongValue_whenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualShiftRightOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue SpecificIntegerValue.shiftRightOf(LongValue)"})
  void testShiftRightOfWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualShiftRightOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).shiftRightOf(other);

    // Assert
    assertSame(other, actualShiftRightOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftRightOf(RangeIntegerValue)"})
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
   * Test {@link SpecificIntegerValue#shiftRightOf(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#shiftRightOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.shiftRightOf(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue SpecificIntegerValue.shiftRightOf(SpecificLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue_whenInteger_value_0() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).unsignedShiftRight(other);

    // Assert
    assertSame(other, actualUnsignedShiftRightResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.unsignedShiftRight(RangeIntegerValue)"})
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
   * Test {@link SpecificIntegerValue#unsignedShiftRight(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRight(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.unsignedShiftRight(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  void testUnsignedShiftRightOfWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  void testUnsignedShiftRightOfWithIntegerValue_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .unsignedShiftRightOf(other);

    // Assert
    assertSame(other, actualUnsignedShiftRightOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.unsignedShiftRightOf(IntegerValue)"})
  void testUnsignedShiftRightOfWithIntegerValue_whenInteger_value_0() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue SpecificIntegerValue.unsignedShiftRightOf(LongValue)"})
  void testUnsignedShiftRightOfWithLongValue() {
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue SpecificIntegerValue.unsignedShiftRightOf(LongValue)"})
  void testUnsignedShiftRightOfWithLongValue_whenLong_value_0() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue SpecificIntegerValue.unsignedShiftRightOf(LongValue)"})
  void testUnsignedShiftRightOfWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .unsignedShiftRightOf(other);

    // Assert
    assertSame(other, actualUnsignedShiftRightOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.unsignedShiftRightOf(RangeIntegerValue)"})
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
   * Test {@link SpecificIntegerValue#unsignedShiftRightOf(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#unsignedShiftRightOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IntegerValue SpecificIntegerValue.unsignedShiftRightOf(SpecificIntegerValue)"
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue SpecificIntegerValue.unsignedShiftRightOf(SpecificLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.and(IntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.and(IntegerValue)"})
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
   *   <li>When {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@link
   *       ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(IntegerValue) with 'IntegerValue'; when ConvertedByteValue(IntegerValue) with value is INTEGER_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.and(IntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.and(IntegerValue)"})
  void testAndWithIntegerValue_whenInteger_value_0_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.and(IntegerValue)"})
  void testAndWithIntegerValue_whenInteger_value_byte_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.and(IntegerValue)"})
  void testAndWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualAndResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).and(other);

    // Assert
    assertSame(other, actualAndResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.and(RangeIntegerValue)"})
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
   * Test {@link SpecificIntegerValue#and(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test and(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.and(SpecificIntegerValue)"})
  void testAndWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAndResult =
        particularIntegerValue.and((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(particularIntegerValue, actualAndResult);
  }

  /**
   * Test {@link SpecificIntegerValue#and(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test and(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.and(SpecificIntegerValue)"})
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
   *   <li>When {@code null}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(SpecificIntegerValue) with 'SpecificIntegerValue'; when 'null'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.and(SpecificIntegerValue)"})
  void testAndWithSpecificIntegerValue_whenNull_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult = new ParticularIntegerValue(42).and((SpecificIntegerValue) null);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.or(IntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.or(IntegerValue)"})
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
   *   <li>When {@link ConvertedByteValue#ConvertedByteValue(IntegerValue)} with value is {@link
   *       ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(IntegerValue) with 'IntegerValue'; when ConvertedByteValue(IntegerValue) with value is INTEGER_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.or(IntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.or(IntegerValue)"})
  void testOrWithIntegerValue_whenInteger_value_0_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualOrResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.or(IntegerValue)"})
  void testOrWithIntegerValue_whenInteger_value_byte_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualOrResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.or(IntegerValue)"})
  void testOrWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualOrResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).or(other);

    // Assert
    assertSame(other, actualOrResult);
  }

  /**
   * Test {@link SpecificIntegerValue#or(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#or(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(RangeIntegerValue) with 'RangeIntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.or(RangeIntegerValue)"})
  void testOrWithRangeIntegerValue_thenReturnCompositeIntegerValue() {
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.or(SpecificIntegerValue)"})
  void testOrWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualOrResult =
        particularIntegerValue.or((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(particularIntegerValue, actualOrResult);
  }

  /**
   * Test {@link SpecificIntegerValue#or(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#or(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test or(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.or(SpecificIntegerValue)"})
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
   *   <li>When {@code null}.
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#or(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(SpecificIntegerValue) with 'SpecificIntegerValue'; when 'null'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.or(SpecificIntegerValue)"})
  void testOrWithSpecificIntegerValue_whenNull_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualOrResult = new ParticularIntegerValue(42).or((SpecificIntegerValue) null);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.xor(IntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.xor(IntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.xor(IntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.xor(IntegerValue)"})
  void testXorWithIntegerValue_whenInteger_value_0_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualXorResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.xor(IntegerValue)"})
  void testXorWithIntegerValue_whenInteger_value_byte_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualXorResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.xor(IntegerValue)"})
  void testXorWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act
    IntegerValue actualXorResult =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).xor(other);

    // Assert
    assertSame(other, actualXorResult);
  }

  /**
   * Test {@link SpecificIntegerValue#xor(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#xor(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test xor(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.xor(RangeIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.xor(SpecificIntegerValue)"})
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
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificIntegerValue#xor(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(SpecificIntegerValue) with 'SpecificIntegerValue'; then return ParticularIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.xor(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue SpecificIntegerValue.xor(SpecificIntegerValue)"})
  void testXorWithSpecificIntegerValue_whenNull_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualXorResult = new ParticularIntegerValue(42).xor((SpecificIntegerValue) null);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.equal(IntegerValue)"})
  void testEqualWithIntegerValue_givenConvertedByteValueWithValueIsNull() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act
    int actualEqualResult =
        convertedByteValue.equal(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertEquals(0, actualEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.equal(IntegerValue)"})
  void testEqualWithIntegerValue_thenReturnOne() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    int actualEqualResult =
        convertedByteValue.equal(
            (IntegerValue) new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertEquals(1, actualEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.equal(IntegerValue)"})
  void testEqualWithIntegerValue_whenConvertedByteValueWithValueIsInteger_value_0() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    int actualEqualResult =
        convertedByteValue.equal(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertEquals(0, actualEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.equal(IntegerValue)"})
  void testEqualWithIntegerValue_whenInteger_value_0_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.equal(IntegerValue)"})
  void testEqualWithIntegerValue_whenInteger_value_byte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.equal(IntegerValue)"})
  void testEqualWithIntegerValue_whenInteger_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .equal(BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Test {@link SpecificIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.equal(RangeIntegerValue)"})
  void testEqualWithRangeIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    int actualEqualResult = convertedByteValue.equal(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link SpecificIntegerValue#equal(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#equal(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.equal(SpecificIntegerValue)"})
  void testEqualWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    int actualEqualResult =
        particularIntegerValue.equal(
            new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertEquals(0, actualEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.equal(SpecificIntegerValue)"})
  void testEqualWithSpecificIntegerValue_thenReturnOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    int actualEqualResult =
        particularIntegerValue.equal((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertEquals(1, actualEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.equal(SpecificIntegerValue)"})
  void testEqualWithSpecificIntegerValue_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new ParticularIntegerValue(42).equal((SpecificIntegerValue) null));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThan(IntegerValue)"})
  void testLessThanWithIntegerValue_givenConvertedByteValueWithValueIsNull() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act
    int actualLessThanResult =
        convertedByteValue.lessThan(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertEquals(0, actualLessThanResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThan(IntegerValue)"})
  void testLessThanWithIntegerValue_thenReturnNever() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    int actualLessThanResult =
        convertedByteValue.lessThan(
            (IntegerValue) new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertEquals(Value.NEVER, actualLessThanResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThan(IntegerValue)"})
  void testLessThanWithIntegerValue_whenConvertedByteValueWithValueIsInteger_value_0() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    int actualLessThanResult =
        convertedByteValue.lessThan(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertEquals(0, actualLessThanResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThan(IntegerValue)"})
  void testLessThanWithIntegerValue_whenInteger_value_0_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThan(IntegerValue)"})
  void testLessThanWithIntegerValue_whenInteger_value_byte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThan(IntegerValue)"})
  void testLessThanWithIntegerValue_whenInteger_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .lessThan(BasicValueFactory.INTEGER_VALUE));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThan(RangeIntegerValue)"})
  void testLessThanWithRangeIntegerValue_thenReturnZero() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    int actualLessThanResult = convertedByteValue.lessThan(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(0, actualLessThanResult);
  }

  /**
   * Test {@link SpecificIntegerValue#lessThan(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThan(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThan(SpecificIntegerValue)"})
  void testLessThanWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    int actualLessThanResult =
        particularIntegerValue.lessThan(
            new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertEquals(0, actualLessThanResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThan(SpecificIntegerValue)"})
  void testLessThanWithSpecificIntegerValue_thenReturnNever() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    int actualLessThanResult =
        particularIntegerValue.lessThan((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertEquals(Value.NEVER, actualLessThanResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThan(SpecificIntegerValue)"})
  void testLessThanWithSpecificIntegerValue_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new ParticularIntegerValue(42).lessThan((SpecificIntegerValue) null));
  }

  /**
   * Test {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThanOrEqual(IntegerValue)"})
  void testLessThanOrEqualWithIntegerValue() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    int actualLessThanOrEqualResult =
        convertedByteValue.lessThanOrEqual(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertEquals(0, actualLessThanOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThanOrEqual(IntegerValue)"})
  void testLessThanOrEqualWithIntegerValue_givenConvertedByteValueWithValueIsNull() {
    // Arrange
    ConvertedByteValue convertedByteValue = new ConvertedByteValue(null);

    // Act
    int actualLessThanOrEqualResult =
        convertedByteValue.lessThanOrEqual(
            (IntegerValue) new ConvertedByteValue(ParticularValueFactory.INTEGER_VALUE_0));

    // Assert
    assertEquals(0, actualLessThanOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThanOrEqual(IntegerValue)"})
  void testLessThanOrEqualWithIntegerValue_thenReturnOne() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    int actualLessThanOrEqualResult =
        convertedByteValue.lessThanOrEqual(
            (IntegerValue) new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertEquals(1, actualLessThanOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThanOrEqual(IntegerValue)"})
  void testLessThanOrEqualWithIntegerValue_whenInteger_value_0_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThanOrEqual(IntegerValue)"})
  void testLessThanOrEqualWithIntegerValue_whenInteger_value_byte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThanOrEqual(IntegerValue)"})
  void testLessThanOrEqualWithIntegerValue_whenInteger_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .lessThanOrEqual(BasicValueFactory.INTEGER_VALUE));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThanOrEqual(RangeIntegerValue)"})
  void testLessThanOrEqualWithRangeIntegerValue_thenReturnZero() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    int actualLessThanOrEqualResult =
        convertedByteValue.lessThanOrEqual(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(0, actualLessThanOrEqualResult);
  }

  /**
   * Test {@link SpecificIntegerValue#lessThanOrEqual(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#lessThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThanOrEqual(SpecificIntegerValue)"})
  void testLessThanOrEqualWithSpecificIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    int actualLessThanOrEqualResult =
        particularIntegerValue.lessThanOrEqual(
            new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertEquals(0, actualLessThanOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThanOrEqual(SpecificIntegerValue)"})
  void testLessThanOrEqualWithSpecificIntegerValue_thenReturnOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    int actualLessThanOrEqualResult =
        particularIntegerValue.lessThanOrEqual(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertEquals(1, actualLessThanOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SpecificIntegerValue.lessThanOrEqual(SpecificIntegerValue)"})
  void testLessThanOrEqualWithSpecificIntegerValue_whenNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new ParticularIntegerValue(42).lessThanOrEqual((SpecificIntegerValue) null));
  }

  /**
   * Test {@link SpecificIntegerValue#isSpecific()}.
   *
   * <p>Method under test: {@link SpecificIntegerValue#isSpecific()}
   */
  @Test
  @DisplayName("Test isSpecific()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SpecificIntegerValue.isSpecific()"})
  void testIsSpecific() {
    // Arrange, Act and Assert
    assertTrue(new ParticularIntegerValue(42).isSpecific());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SpecificIntegerValue.equals(Object)",
    "int SpecificIntegerValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);
    ParticularIntegerValue particularIntegerValue2 = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(particularIntegerValue, particularIntegerValue2);
    assertEquals(particularIntegerValue.hashCode(), particularIntegerValue2.hashCode());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SpecificIntegerValue.equals(Object)",
    "int SpecificIntegerValue.hashCode()"
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SpecificIntegerValue.equals(Object)",
    "int SpecificIntegerValue.hashCode()"
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SpecificIntegerValue.equals(Object)",
    "int SpecificIntegerValue.hashCode()"
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SpecificIntegerValue.equals(Object)",
    "int SpecificIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularIntegerValue(42), "Different type to SpecificIntegerValue");
  }
}
