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

class ParticularIntegerValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParticularIntegerValue#ParticularIntegerValue(int)}
   *   <li>{@link ParticularIntegerValue#toString()}
   *   <li>{@link ParticularIntegerValue#isParticular()}
   *   <li>{@link ParticularIntegerValue#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.ParticularIntegerValue.<init>(int)",
    "boolean proguard.evaluation.value.ParticularIntegerValue.isParticular()",
    "java.lang.String proguard.evaluation.value.ParticularIntegerValue.toString()",
    "int proguard.evaluation.value.ParticularIntegerValue.value()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ParticularIntegerValue actualParticularIntegerValue = new ParticularIntegerValue(42);
    String actualToStringResult = actualParticularIntegerValue.toString();
    boolean actualIsParticularResult = actualParticularIntegerValue.isParticular();

    // Assert
    assertEquals("42", actualToStringResult);
    assertEquals(42, actualParticularIntegerValue.value());
    assertTrue(actualIsParticularResult);
  }

  /**
   * Test {@link ParticularIntegerValue#negate()}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#negate()}
   */
  @Test
  @DisplayName("Test negate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.negate()"
  })
  void testNegate() {
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
   * Test {@link ParticularIntegerValue#convertToByte()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#convertToByte()}
   */
  @Test
  @DisplayName("Test convertToByte(); then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.convertToByte()"
  })
  void testConvertToByte_thenReturnParticularIntegerValue() {
    // Arrange and Act
    IntegerValue actualConvertToByteResult =
        (new ParticularIntegerValue(Integer.MIN_VALUE)).convertToByte();

    // Assert
    assertTrue(actualConvertToByteResult instanceof ParticularIntegerValue);
    assertEquals(0, actualConvertToByteResult.value());
    assertFalse(actualConvertToByteResult.isCategory2());
    assertTrue(actualConvertToByteResult.isParticular());
    assertTrue(actualConvertToByteResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#convertToByte()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is
   *       forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#convertToByte()}
   */
  @Test
  @DisplayName(
      "Test convertToByte(); then return ParticularIntegerValue(int) with value is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.convertToByte()"
  })
  void testConvertToByte_thenReturnParticularIntegerValueWithValueIsFortyTwo() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.convertToByte());
  }

  /**
   * Test {@link ParticularIntegerValue#convertToCharacter()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#convertToCharacter()}
   */
  @Test
  @DisplayName("Test convertToCharacter(); then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.convertToCharacter()"
  })
  void testConvertToCharacter_thenReturnParticularIntegerValue() {
    // Arrange and Act
    IntegerValue actualConvertToCharacterResult =
        (new ParticularIntegerValue(Value.NEVER)).convertToCharacter();

    // Assert
    assertTrue(actualConvertToCharacterResult instanceof ParticularIntegerValue);
    assertEquals(65535, actualConvertToCharacterResult.value());
    assertFalse(actualConvertToCharacterResult.isCategory2());
    assertTrue(actualConvertToCharacterResult.isParticular());
    assertTrue(actualConvertToCharacterResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#convertToCharacter()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is
   *       forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#convertToCharacter()}
   */
  @Test
  @DisplayName(
      "Test convertToCharacter(); then return ParticularIntegerValue(int) with value is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.convertToCharacter()"
  })
  void testConvertToCharacter_thenReturnParticularIntegerValueWithValueIsFortyTwo() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.convertToCharacter());
  }

  /**
   * Test {@link ParticularIntegerValue#convertToShort()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#convertToShort()}
   */
  @Test
  @DisplayName("Test convertToShort(); then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.convertToShort()"
  })
  void testConvertToShort_thenReturnParticularIntegerValue() {
    // Arrange and Act
    IntegerValue actualConvertToShortResult =
        (new ParticularIntegerValue(Integer.MIN_VALUE)).convertToShort();

    // Assert
    assertTrue(actualConvertToShortResult instanceof ParticularIntegerValue);
    assertEquals(0, actualConvertToShortResult.value());
    assertFalse(actualConvertToShortResult.isCategory2());
    assertTrue(actualConvertToShortResult.isParticular());
    assertTrue(actualConvertToShortResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#convertToShort()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is
   *       forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#convertToShort()}
   */
  @Test
  @DisplayName(
      "Test convertToShort(); then return ParticularIntegerValue(int) with value is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.convertToShort()"
  })
  void testConvertToShort_thenReturnParticularIntegerValueWithValueIsFortyTwo() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.convertToShort());
  }

  /**
   * Test {@link ParticularIntegerValue#convertToLong()}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#convertToLong()}
   */
  @Test
  @DisplayName("Test convertToLong()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.ParticularIntegerValue.convertToLong()"
  })
  void testConvertToLong() {
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
   * Test {@link ParticularIntegerValue#convertToFloat()}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#convertToFloat()}
   */
  @Test
  @DisplayName("Test convertToFloat()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.ParticularIntegerValue.convertToFloat()"
  })
  void testConvertToFloat() {
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
   * Test {@link ParticularIntegerValue#convertToDouble()}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#convertToDouble()}
   */
  @Test
  @DisplayName("Test convertToDouble()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.ParticularIntegerValue.convertToDouble()"
  })
  void testConvertToDouble() {
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
   * Test {@link ParticularIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.generalize(proguard.evaluation.value.IntegerValue)"
  })
  void testGeneralizeWithIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualGeneralizeResult =
        particularIntegerValue.generalize(
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
   * Test {@link ParticularIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IntegerValue) with 'IntegerValue'; given ParticularIntegerValue(int) with value is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.generalize(proguard.evaluation.value.IntegerValue)"
  })
  void testGeneralizeWithIntegerValue_givenParticularIntegerValueWithValueIsMin_value() {
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
   * Test {@link ParticularIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(IntegerValue) with 'IntegerValue'; then return INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.generalize(proguard.evaluation.value.IntegerValue)"
  })
  void testGeneralizeWithIntegerValue_thenReturnInteger_value_byte() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).generalize(other));
  }

  /**
   * Test {@link ParticularIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.generalize(proguard.evaluation.value.IntegerValue)"
  })
  void testGeneralizeWithIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualGeneralizeResult = particularIntegerValue.generalize((IntegerValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualGeneralizeResult);
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link ParticularIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.generalize(proguard.evaluation.value.IntegerValue)"
  })
  void testGeneralizeWithIntegerValue_whenInteger_value_0_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult =
        (new ParticularIntegerValue(42)).generalize(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.generalize(proguard.evaluation.value.IntegerValue)"
  })
  void testGeneralizeWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).generalize(other));
  }

  /**
   * Test {@link ParticularIntegerValue#generalize(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#generalize(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(IntegerValue) with 'IntegerValue'; when RangeIntegerValue(int, int) with min is one and max is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.generalize(proguard.evaluation.value.IntegerValue)"
  })
  void testGeneralizeWithIntegerValue_whenRangeIntegerValueWithMinIsOneAndMaxIsThree() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualGeneralizeResult =
        particularIntegerValue.generalize((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#generalize(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.generalize(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testGeneralizeWithParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertSame(
        particularIntegerValue, particularIntegerValue.generalize(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link ParticularIntegerValue#generalize(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.generalize(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testGeneralizeWithParticularIntegerValue2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualGeneralizeResult =
        particularIntegerValue.generalize(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#generalize(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularIntegerValue) with 'ParticularIntegerValue'; when 'null'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.generalize(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testGeneralizeWithParticularIntegerValue_whenNull_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult =
        (new ParticularIntegerValue(42)).generalize((ParticularIntegerValue) null);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#generalize(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.generalize(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testGeneralizeWithRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.generalize(other));
  }

  /**
   * Test {@link ParticularIntegerValue#generalize(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(RangeIntegerValue) with 'RangeIntegerValue'; given ParticularIntegerValue(int) with value is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.generalize(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testGeneralizeWithRangeIntegerValue_givenParticularIntegerValueWithValueIsZero() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

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
   * Test {@link ParticularIntegerValue#generalize(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.generalize(proguard.evaluation.value.RangeIntegerValue)"
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
   * Test {@link ParticularIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; given ParticularIntegerValue(int) with value is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.add(proguard.evaluation.value.IntegerValue)"
  })
  void testAddWithIntegerValue_givenParticularIntegerValueWithValueIsMin_value() {
    // Arrange and Act
    IntegerValue actualAddResult =
        (new ParticularIntegerValue(Integer.MIN_VALUE))
            .add(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; given ParticularIntegerValue(int) with value is NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.add(proguard.evaluation.value.IntegerValue)"
  })
  void testAddWithIntegerValue_givenParticularIntegerValueWithValueIsNever() {
    // Arrange and Act
    IntegerValue actualAddResult =
        (new ParticularIntegerValue(Value.NEVER)).add(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName("Test add(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.add(proguard.evaluation.value.IntegerValue)"
  })
  void testAddWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAddResult =
        particularIntegerValue.add(
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
   * Test {@link ParticularIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName("Test add(IntegerValue) with 'IntegerValue'; then return INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.add(proguard.evaluation.value.IntegerValue)"
  })
  void testAddWithIntegerValue_thenReturnInteger_value_byte() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(0)).add(other));
  }

  /**
   * Test {@link ParticularIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.add(proguard.evaluation.value.IntegerValue)"
  })
  void testAddWithIntegerValue_whenInteger_value_0_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAddResult =
        particularIntegerValue.add(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualAddResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualAddResult);
  }

  /**
   * Test {@link ParticularIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.add(proguard.evaluation.value.IntegerValue)"
  })
  void testAddWithIntegerValue_whenInteger_value_byte_thenReturnRangeIntegerValue() {
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
   * Test {@link ParticularIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link RangeValueFactory#INTEGER_VALUE_INT}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_INT; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.add(proguard.evaluation.value.IntegerValue)"
  })
  void testAddWithIntegerValue_whenInteger_value_int_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        (new ParticularIntegerValue(42)).add(RangeValueFactory.INTEGER_VALUE_INT);

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#add(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#add(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.add(proguard.evaluation.value.IntegerValue)"
  })
  void testAddWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).add(other));
  }

  /**
   * Test {@link ParticularIntegerValue#add(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.add(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testAddWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAddResult = particularIntegerValue.add(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof ParticularIntegerValue);
    assertEquals(84, actualAddResult.value());
    assertFalse(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#add(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test add(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.add(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testAddWithRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.add(other));
  }

  /**
   * Test {@link ParticularIntegerValue#add(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Integer#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(RangeIntegerValue) with 'RangeIntegerValue'; given ParticularIntegerValue(int) with value is MAX_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.add(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testAddWithRangeIntegerValue_givenParticularIntegerValueWithValueIsMax_value() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Integer.MAX_VALUE);

    // Act
    IntegerValue actualAddResult =
        particularIntegerValue.add(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#add(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.add(proguard.evaluation.value.RangeIntegerValue)"
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
   * Test {@link ParticularIntegerValue#add(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.add(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testAddWithRangeIntegerValue_thenReturnRangeIntegerValue2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualAddResult = particularIntegerValue.add(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#add(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#add(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(RangeIntegerValue) with 'RangeIntegerValue'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.add(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testAddWithRangeIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualAddResult =
        particularIntegerValue.add(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualAddResult instanceof UnknownIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(IntegerValue) with 'IntegerValue'; given ParticularIntegerValue(int) with value is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtract(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractWithIntegerValue_givenParticularIntegerValueWithValueIsMin_value() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        (new ParticularIntegerValue(Integer.MIN_VALUE))
            .subtract(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtract(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractResult =
        particularIntegerValue.subtract(
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
   * Test {@link ParticularIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtract(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractWithIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractResult =
        particularIntegerValue.subtract(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualSubtractResult);
  }

  /**
   * Test {@link ParticularIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtract(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractWithIntegerValue_whenInteger_value_byte_thenReturnRangeIntegerValue() {
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
   * Test {@link ParticularIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link RangeValueFactory#INTEGER_VALUE_INT}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_INT; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtract(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractWithIntegerValue_whenInteger_value_int_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        (new ParticularIntegerValue(42)).subtract(RangeValueFactory.INTEGER_VALUE_INT);

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#subtract(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtract(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtract(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).subtract(other));
  }

  /**
   * Test {@link ParticularIntegerValue#subtract(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtract(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testSubtractWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractResult =
        particularIntegerValue.subtract(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularIntegerValue);
    assertEquals(0, actualSubtractResult.value());
    assertFalse(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#subtract(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtract(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testSubtractWithRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Integer.MIN_VALUE);

    // Act
    IntegerValue actualSubtractResult =
        particularIntegerValue.subtract(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#subtract(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtract(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testSubtractWithRangeIntegerValue2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractResult =
        particularIntegerValue.subtract(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualSubtractResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#subtract(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtract(proguard.evaluation.value.RangeIntegerValue)"
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
   * Test {@link ParticularIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtractFrom(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractFromWithIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        (new ParticularIntegerValue(-128)).subtractFrom(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(IntegerValue) with 'IntegerValue'; given ParticularIntegerValue(int) with value is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtractFrom(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractFromWithIntegerValue_givenParticularIntegerValueWithValueIsMin_value() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        (new ParticularIntegerValue(Integer.MIN_VALUE))
            .subtractFrom(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtractFrom(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractFromWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractFromResult =
        particularIntegerValue.subtractFrom(
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
   * Test {@link ParticularIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(IntegerValue) with 'IntegerValue'; then return INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtractFrom(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractFromWithIntegerValue_thenReturnInteger_value_byte() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(0)).subtractFrom(other));
  }

  /**
   * Test {@link ParticularIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtractFrom(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractFromWithIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        (new ParticularIntegerValue(42)).subtractFrom(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularIntegerValue);
    assertEquals(-42, actualSubtractFromResult.value());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtractFrom(proguard.evaluation.value.IntegerValue)"
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
   * Test {@link ParticularIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link RangeValueFactory#INTEGER_VALUE_INT}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_INT")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtractFrom(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractFromWithIntegerValue_whenInteger_value_int() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        (new ParticularIntegerValue(42)).subtractFrom(RangeValueFactory.INTEGER_VALUE_INT);

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#subtractFrom(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtractFrom(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtractFrom(proguard.evaluation.value.IntegerValue)"
  })
  void testSubtractFromWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).subtractFrom(other));
  }

  /**
   * Test {@link ParticularIntegerValue#subtractFrom(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtractFrom(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testSubtractFromWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractFromResult =
        particularIntegerValue.subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularIntegerValue);
    assertEquals(0, actualSubtractFromResult.value());
    assertFalse(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#subtractFrom(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtractFrom(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testSubtractFromWithRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(-41);

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
   * Test {@link ParticularIntegerValue#subtractFrom(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtractFrom(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testSubtractFromWithRangeIntegerValue2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.subtractFrom(other));
  }

  /**
   * Test {@link ParticularIntegerValue#subtractFrom(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtractFrom(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testSubtractFromWithRangeIntegerValue3() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Integer.MIN_VALUE);

    // Act
    IntegerValue actualSubtractFromResult =
        particularIntegerValue.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#subtractFrom(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtractFrom(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testSubtractFromWithRangeIntegerValue4() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualSubtractFromResult =
        particularIntegerValue.subtractFrom(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof UnknownIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#subtractFrom(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.subtractFrom(proguard.evaluation.value.RangeIntegerValue)"
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
   * Test {@link ParticularIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@code
   *       -5376}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(IntegerValue) with 'IntegerValue'; given ParticularIntegerValue(int) with value is '-5376'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.multiply(proguard.evaluation.value.IntegerValue)"
  })
  void testMultiplyWithIntegerValue_givenParticularIntegerValueWithValueIs5376() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        (new ParticularIntegerValue(-5376)).multiply(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.multiply(proguard.evaluation.value.IntegerValue)"
  })
  void testMultiplyWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualMultiplyResult =
        particularIntegerValue.multiply(
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
   * Test {@link ParticularIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(IntegerValue) with 'IntegerValue'; then return INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.multiply(proguard.evaluation.value.IntegerValue)"
  })
  void testMultiplyWithIntegerValue_thenReturnInteger_value_byte() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(1)).multiply(other));
  }

  /**
   * Test {@link ParticularIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.multiply(proguard.evaluation.value.IntegerValue)"
  })
  void testMultiplyWithIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualMultiplyResult = (new ParticularIntegerValue(42)).multiply(other);

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularIntegerValue);
    assertEquals(other, actualMultiplyResult);
  }

  /**
   * Test {@link ParticularIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue(int) with value is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.multiply(proguard.evaluation.value.IntegerValue)"
  })
  void testMultiplyWithIntegerValue_thenReturnParticularIntegerValueWithValueIsZero() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(
        particularIntegerValue,
        particularIntegerValue.multiply(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ParticularIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.multiply(proguard.evaluation.value.IntegerValue)"
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
   * Test {@link ParticularIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(IntegerValue) with 'IntegerValue'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.multiply(proguard.evaluation.value.IntegerValue)"
  })
  void testMultiplyWithIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        (new ParticularIntegerValue(Integer.MIN_VALUE))
            .multiply(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_CHAR}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_CHAR")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.multiply(proguard.evaluation.value.IntegerValue)"
  })
  void testMultiplyWithIntegerValue_whenInteger_value_char() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        (new ParticularIntegerValue(Integer.MIN_VALUE))
            .multiply(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#multiply(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#multiply(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.multiply(proguard.evaluation.value.IntegerValue)"
  })
  void testMultiplyWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).multiply(other));
  }

  /**
   * Test {@link ParticularIntegerValue#multiply(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.multiply(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testMultiplyWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualMultiplyResult =
        particularIntegerValue.multiply(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularIntegerValue);
    assertEquals(1764, actualMultiplyResult.value());
    assertFalse(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#multiply(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.multiply(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testMultiplyWithRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.multiply(other));
  }

  /**
   * Test {@link ParticularIntegerValue#multiply(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.multiply(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testMultiplyWithRangeIntegerValue2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(
        particularIntegerValue, particularIntegerValue.multiply(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#multiply(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.multiply(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testMultiplyWithRangeIntegerValue3() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Integer.MIN_VALUE);

    // Act
    IntegerValue actualMultiplyResult =
        particularIntegerValue.multiply(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#multiply(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.multiply(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testMultiplyWithRangeIntegerValue4() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualMultiplyResult =
        particularIntegerValue.multiply(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualMultiplyResult instanceof UnknownIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#multiply(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(RangeIntegerValue) with 'RangeIntegerValue'; given ParticularIntegerValue(int) with value is NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.multiply(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testMultiplyWithRangeIntegerValue_givenParticularIntegerValueWithValueIsNever() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

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
   * Test {@link ParticularIntegerValue#multiply(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.multiply(proguard.evaluation.value.RangeIntegerValue)"
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
   * Test {@link ParticularIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(IntegerValue) with 'IntegerValue'; given ParticularIntegerValue(int) with value is NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divide(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideWithIntegerValue_givenParticularIntegerValueWithValueIsNever()
      throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualDivideResult =
        particularIntegerValue.divide((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName("Test divide(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divide(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideWithIntegerValue_thenReturnCompositeIntegerValue() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideResult =
        particularIntegerValue.divide(
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
   * Test {@link ParticularIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName("Test divide(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divide(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideWithIntegerValue_thenReturnRangeIntegerValue() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideResult =
        particularIntegerValue.divide((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_1}.
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_1; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divide(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideWithIntegerValue_whenInteger_value_1_thenReturnParticularIntegerValue()
      throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideResult =
        particularIntegerValue.divide(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualDivideResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualDivideResult);
  }

  /**
   * Test {@link ParticularIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divide(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideWithIntegerValue_whenInteger_value_byte_thenReturnUnknownIntegerValue()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideResult =
        (new ParticularIntegerValue(42)).divide(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#divide(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divide(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divide(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).divide(other));
  }

  /**
   * Test {@link ParticularIntegerValue#divide(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divide(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testDivideWithParticularIntegerValue_thenReturnParticularIntegerValue()
      throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideResult = particularIntegerValue.divide(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof ParticularIntegerValue);
    assertEquals(1, actualDivideResult.value());
    assertFalse(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#divide(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(RangeIntegerValue) with 'RangeIntegerValue'; given ParticularIntegerValue(int) with value is NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divide(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testDivideWithRangeIntegerValue_givenParticularIntegerValueWithValueIsNever()
      throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualDivideResult = particularIntegerValue.divide(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#divide(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test divide(RangeIntegerValue) with 'RangeIntegerValue'; then return Particular")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divide(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testDivideWithRangeIntegerValue_thenReturnParticular() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideResult =
        particularIntegerValue.divide(new RangeIntegerValue(Integer.MIN_VALUE, Integer.MIN_VALUE));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isSpecific());
    assertTrue(actualDivideResult.isParticular());
  }

  /**
   * Test {@link ParticularIntegerValue#divide(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(RangeIntegerValue) with 'RangeIntegerValue'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divide(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testDivideWithRangeIntegerValue_thenReturnUnknownIntegerValue() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideResult = particularIntegerValue.divide(new RangeIntegerValue(0, 3));

    // Assert
    assertTrue(actualDivideResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#divide(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>When {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(RangeIntegerValue) with 'RangeIntegerValue'; when RangeIntegerValue(int, int) with min is one and max is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divide(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testDivideWithRangeIntegerValue_whenRangeIntegerValueWithMinIsOneAndMaxIsThree()
      throws ArithmeticException {
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
   * Test {@link ParticularIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is minus
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(IntegerValue) with 'IntegerValue'; given ParticularIntegerValue(int) with value is minus three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divideOf(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideOfWithIntegerValue_givenParticularIntegerValueWithValueIsMinusThree()
      throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        (new ParticularIntegerValue(-3)).divideOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divideOf(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideOfWithIntegerValue_thenReturnCompositeIntegerValue() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideOfResult =
        particularIntegerValue.divideOf(
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
   * Test {@link ParticularIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(IntegerValue) with 'IntegerValue'; then return INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divideOf(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideOfWithIntegerValue_thenReturnInteger_value_byte() throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(1)).divideOf(other));
  }

  /**
   * Test {@link ParticularIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divideOf(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideOfWithIntegerValue_thenReturnParticularIntegerValue() throws ArithmeticException {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualDivideOfResult = (new ParticularIntegerValue(42)).divideOf(other);

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualDivideOfResult);
  }

  /**
   * Test {@link ParticularIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(IntegerValue) with 'IntegerValue'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divideOf(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideOfWithIntegerValue_thenReturnUnknownIntegerValue() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        (new ParticularIntegerValue(0)).divideOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divideOf(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideOfWithIntegerValue_whenInteger_value_byte_thenReturnRangeIntegerValue()
      throws ArithmeticException {
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
   * Test {@link ParticularIntegerValue#divideOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divideOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divideOf(proguard.evaluation.value.IntegerValue)"
  })
  void testDivideOfWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).divideOf(other));
  }

  /**
   * Test {@link ParticularIntegerValue#divideOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divideOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testDivideOfWithParticularIntegerValue_thenReturnParticularIntegerValue()
      throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideOfResult =
        particularIntegerValue.divideOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularIntegerValue);
    assertEquals(1, actualDivideOfResult.value());
    assertFalse(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#divideOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divideOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testDivideOfWithRangeIntegerValue() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.divideOf(other));
  }

  /**
   * Test {@link ParticularIntegerValue#divideOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divideOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testDivideOfWithRangeIntegerValue2() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualDivideOfResult =
        particularIntegerValue.divideOf(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#divideOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divideOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testDivideOfWithRangeIntegerValue3() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualDivideOfResult =
        particularIntegerValue.divideOf(new RangeIntegerValue(1, Integer.MIN_VALUE));

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#divideOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(RangeIntegerValue) with 'RangeIntegerValue'; given ParticularIntegerValue(int) with value is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divideOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testDivideOfWithRangeIntegerValue_givenParticularIntegerValueWithValueIsZero()
      throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act
    IntegerValue actualDivideOfResult =
        particularIntegerValue.divideOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideOfResult instanceof UnknownIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#divideOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(RangeIntegerValue) with 'RangeIntegerValue'; then return Particular")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divideOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testDivideOfWithRangeIntegerValue_thenReturnParticular() throws ArithmeticException {
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
   * Test {@link ParticularIntegerValue#divideOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.divideOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testDivideOfWithRangeIntegerValue_thenReturnRangeIntegerValue() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualDivideOfResult =
        particularIntegerValue.divideOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainder(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderWithIntegerValue() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        (new ParticularIntegerValue(-128)).remainder(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(IntegerValue) with 'IntegerValue'; given ParticularIntegerValue(int) with value is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainder(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderWithIntegerValue_givenParticularIntegerValueWithValueIsOne()
      throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualRemainderResult =
        particularIntegerValue.remainder((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainder(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderWithIntegerValue_thenReturnCompositeIntegerValue() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderResult =
        particularIntegerValue.remainder(
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
   * Test {@link ParticularIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainder(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderWithIntegerValue_thenReturnParticularIntegerValue() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        (new ParticularIntegerValue(42)).remainder(ParticularValueFactory.INTEGER_VALUE_1);

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularIntegerValue);
    assertEquals(0, actualRemainderResult.value());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue(int) with value is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainder(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderWithIntegerValue_thenReturnParticularIntegerValueWithValueIsZero()
      throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(
        particularIntegerValue,
        particularIntegerValue.remainder((IntegerValue) new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainder(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderWithIntegerValue_thenReturnRangeIntegerValue() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderResult =
        particularIntegerValue.remainder((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(IntegerValue) with 'IntegerValue'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainder(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderWithIntegerValue_thenReturnUnknownIntegerValue() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        (new ParticularIntegerValue(42)).remainder(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#remainder(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainder(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainder(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).remainder(other));
  }

  /**
   * Test {@link ParticularIntegerValue#remainder(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainder(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testRemainderWithParticularIntegerValue_thenReturnParticularIntegerValue()
      throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderResult =
        particularIntegerValue.remainder(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularIntegerValue);
    assertEquals(0, actualRemainderResult.value());
    assertFalse(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#remainder(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainder(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testRemainderWithRangeIntegerValue() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(
        particularIntegerValue, particularIntegerValue.remainder(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#remainder(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainder(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testRemainderWithRangeIntegerValue2() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderResult =
        particularIntegerValue.remainder(new RangeIntegerValue(0, 3));

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#remainder(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(RangeIntegerValue) with 'RangeIntegerValue'; given ParticularIntegerValue(int) with value is NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainder(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testRemainderWithRangeIntegerValue_givenParticularIntegerValueWithValueIsNever()
      throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualRemainderResult =
        particularIntegerValue.remainder(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#remainder(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(RangeIntegerValue) with 'RangeIntegerValue'; given ParticularIntegerValue(int) with value is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainder(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testRemainderWithRangeIntegerValue_givenParticularIntegerValueWithValueIsOne()
      throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

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
   * Test {@link ParticularIntegerValue#remainder(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainder(proguard.evaluation.value.RangeIntegerValue)"
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
   * Test {@link ParticularIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainderOf(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderOfWithIntegerValue() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        (new ParticularIntegerValue(-128)).remainderOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainderOf(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderOfWithIntegerValue2() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.remainderOf((IntegerValue) other));
  }

  /**
   * Test {@link ParticularIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainderOf(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderOfWithIntegerValue_thenReturnCompositeIntegerValue()
      throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderOfResult =
        particularIntegerValue.remainderOf(
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
   * Test {@link ParticularIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainderOf(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderOfWithIntegerValue_thenReturnParticularIntegerValue()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualRemainderOfResult = (new ParticularIntegerValue(42)).remainderOf(other);

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualRemainderOfResult);
  }

  /**
   * Test {@link ParticularIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainderOf(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderOfWithIntegerValue_thenReturnRangeIntegerValue() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        (new ParticularIntegerValue(42)).remainderOf(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Assert
    assertTrue(actualRemainderOfResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(IntegerValue) with 'IntegerValue'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainderOf(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderOfWithIntegerValue_thenReturnUnknownIntegerValue() throws ArithmeticException {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        (new ParticularIntegerValue(42)).remainderOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#remainderOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainderOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainderOf(proguard.evaluation.value.IntegerValue)"
  })
  void testRemainderOfWithIntegerValue_whenInteger_value_thenReturnInteger_value()
      throws ArithmeticException {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).remainderOf(other));
  }

  /**
   * Test {@link ParticularIntegerValue#remainderOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainderOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testRemainderOfWithParticularIntegerValue_thenReturnParticularIntegerValue()
      throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderOfResult =
        particularIntegerValue.remainderOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularIntegerValue);
    assertEquals(0, actualRemainderOfResult.value());
    assertFalse(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#remainderOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainderOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testRemainderOfWithRangeIntegerValue() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.remainderOf(other));
  }

  /**
   * Test {@link ParticularIntegerValue#remainderOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainderOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testRemainderOfWithRangeIntegerValue2() throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualRemainderOfResult =
        particularIntegerValue.remainderOf(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#remainderOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(RangeIntegerValue) with 'RangeIntegerValue'; given ParticularIntegerValue(int) with value is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainderOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testRemainderOfWithRangeIntegerValue_givenParticularIntegerValueWithValueIsZero()
      throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act
    IntegerValue actualRemainderOfResult =
        particularIntegerValue.remainderOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderOfResult instanceof UnknownIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#remainderOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.remainderOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testRemainderOfWithRangeIntegerValue_thenReturnRangeIntegerValue()
      throws ArithmeticException {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act
    IntegerValue actualRemainderOfResult =
        particularIntegerValue.remainderOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualRemainderOfResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isSpecific());
    assertTrue(actualRemainderOfResult.isParticular());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; given ParticularIntegerValue(int) with value is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeft(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftWithIntegerValue_givenParticularIntegerValueWithValueIsMin_value() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Integer.MIN_VALUE);

    // Act
    IntegerValue actualShiftLeftResult =
        particularIntegerValue.shiftLeft((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; given ParticularIntegerValue(int) with value is NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeft(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftWithIntegerValue_givenParticularIntegerValueWithValueIsNever() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualShiftLeftResult =
        particularIntegerValue.shiftLeft((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeft(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftResult =
        particularIntegerValue.shiftLeft(
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
   * Test {@link ParticularIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeft(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftWithIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftResult =
        particularIntegerValue.shiftLeft(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftLeftResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualShiftLeftResult);
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue(int) with value is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeft(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftWithIntegerValue_thenReturnParticularIntegerValueWithValueIsZero() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(
        particularIntegerValue,
        particularIntegerValue.shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeft(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftResult =
        particularIntegerValue.shiftLeft((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeft(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult =
        (new ParticularIntegerValue(42)).shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_CHAR}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_CHAR")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeft(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftWithIntegerValue_whenInteger_value_char() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult =
        (new ParticularIntegerValue(42)).shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeft(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).shiftLeft(other));
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeft(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeft(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testShiftLeftWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftResult =
        particularIntegerValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof ParticularIntegerValue);
    assertEquals(43008, actualShiftLeftResult.value());
    assertFalse(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeft(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftLeftWithRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(
        particularIntegerValue, particularIntegerValue.shiftLeft(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeft(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftLeftWithRangeIntegerValue2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Integer.MIN_VALUE);

    // Act
    IntegerValue actualShiftLeftResult =
        particularIntegerValue.shiftLeft(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeft(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftLeftWithRangeIntegerValue3() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftResult =
        particularIntegerValue.shiftLeft(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeft(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftLeftWithRangeIntegerValue4() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftResult =
        particularIntegerValue.shiftLeft(new RangeIntegerValue(1, 42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(RangeIntegerValue) with 'RangeIntegerValue'; given ParticularIntegerValue(int) with value is NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeft(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftLeftWithRangeIntegerValue_givenParticularIntegerValueWithValueIsNever() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

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
   * Test {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeft(proguard.evaluation.value.RangeIntegerValue)"
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
   * Test {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(IntegerValue) with 'IntegerValue'; given ParticularIntegerValue(int) with value is NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeftOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftOfWithIntegerValue_givenParticularIntegerValueWithValueIsNever() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        (new ParticularIntegerValue(Value.NEVER))
            .shiftLeftOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeftOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftOfWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftOfResult =
        particularIntegerValue.shiftLeftOf(
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
   * Test {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(IntegerValue) with 'IntegerValue'; then return INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeftOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftOfWithIntegerValue_thenReturnInteger_value_byte() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(-131072)).shiftLeftOf(other));
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeftOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftOfWithIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualShiftLeftOfResult = (new ParticularIntegerValue(42)).shiftLeftOf(other);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualShiftLeftOfResult);
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeftOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftOfWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        (new ParticularIntegerValue(10)).shiftLeftOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(IntegerValue) with 'IntegerValue'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeftOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftOfWithIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        (new ParticularIntegerValue(42)).shiftLeftOf(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeftOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeftOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftLeftOfWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).shiftLeftOf(other));
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeftOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.ParticularIntegerValue.shiftLeftOf(proguard.evaluation.value.LongValue)"
  })
  void testShiftLeftOfWithLongValue_thenReturnCompositeLongValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualShiftLeftOfResult =
        particularIntegerValue.shiftLeftOf(
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
   * Test {@link ParticularIntegerValue#shiftLeftOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.ParticularIntegerValue.shiftLeftOf(proguard.evaluation.value.LongValue)"
  })
  void testShiftLeftOfWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualShiftLeftOfResult = (new ParticularIntegerValue(42)).shiftLeftOf(other);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof ParticularLongValue);
    assertEquals(other, actualShiftLeftOfResult);
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeftOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeftOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.ParticularIntegerValue.shiftLeftOf(proguard.evaluation.value.LongValue)"
  })
  void testShiftLeftOfWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).shiftLeftOf(other));
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeftOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testShiftLeftOfWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftOfResult =
        particularIntegerValue.shiftLeftOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof ParticularIntegerValue);
    assertEquals(43008, actualShiftLeftOfResult.value());
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertTrue(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeftOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeftOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.ParticularIntegerValue.shiftLeftOf(proguard.evaluation.value.ParticularLongValue)"
  })
  void testShiftLeftOfWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualShiftLeftOfResult =
        particularIntegerValue.shiftLeftOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof ParticularLongValue);
    assertEquals(184717953466368L, actualShiftLeftOfResult.value());
    assertTrue(actualShiftLeftOfResult.isCategory2());
    assertTrue(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeftOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeftOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeftOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftLeftOfWithRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1024);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.shiftLeftOf(other));
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeftOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeftOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeftOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftLeftOfWithRangeIntegerValue2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftOfResult =
        particularIntegerValue.shiftLeftOf(new RangeIntegerValue(0, 3));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeftOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeftOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeftOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftLeftOfWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(10);

    // Act
    IntegerValue actualShiftLeftOfResult =
        particularIntegerValue.shiftLeftOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftLeftOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftLeftOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(RangeIntegerValue) with 'RangeIntegerValue'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftLeftOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftLeftOfWithRangeIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftOfResult =
        particularIntegerValue.shiftLeftOf(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightResult =
        particularIntegerValue.shiftRight(
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
   * Test {@link ParticularIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(IntegerValue) with 'IntegerValue'; then return Particular")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightWithIntegerValue_thenReturnParticular() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualShiftRightResult =
        particularIntegerValue.shiftRight((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isParticular());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightWithIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightResult =
        particularIntegerValue.shiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftRightResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualShiftRightResult);
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue(int) with value is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightWithIntegerValue_thenReturnParticularIntegerValueWithValueIsZero() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(
        particularIntegerValue,
        particularIntegerValue.shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightResult =
        particularIntegerValue.shiftRight((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(IntegerValue) with 'IntegerValue'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightWithIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightResult =
        (new ParticularIntegerValue(42)).shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_CHAR}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_CHAR")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightWithIntegerValue_whenInteger_value_char() {
    // Arrange and Act
    IntegerValue actualShiftRightResult =
        (new ParticularIntegerValue(42)).shiftRight(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).shiftRight(other));
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRight(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testShiftRightWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightResult =
        particularIntegerValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof ParticularIntegerValue);
    assertEquals(0, actualShiftRightResult.value());
    assertFalse(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRight(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRight(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftRightWithRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(
        particularIntegerValue, particularIntegerValue.shiftRight(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRight(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRight(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftRightWithRangeIntegerValue2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightResult =
        particularIntegerValue.shiftRight(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRight(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRight(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftRightWithRangeIntegerValue3() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightResult =
        particularIntegerValue.shiftRight(new RangeIntegerValue(1, 42));

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRight(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(RangeIntegerValue) with 'RangeIntegerValue'; then return Particular")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRight(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftRightWithRangeIntegerValue_thenReturnParticular() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act
    IntegerValue actualShiftRightResult =
        particularIntegerValue.shiftRight(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isParticular());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRight(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRight(proguard.evaluation.value.RangeIntegerValue)"
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
   * Test {@link ParticularIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRightOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightOfWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightOfResult =
        particularIntegerValue.shiftRightOf(
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
   * Test {@link ParticularIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(IntegerValue) with 'IntegerValue'; then return INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRightOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightOfWithIntegerValue_thenReturnInteger_value_byte() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(0)).shiftRightOf(other));
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRightOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightOfWithIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualShiftRightOfResult = (new ParticularIntegerValue(42)).shiftRightOf(other);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualShiftRightOfResult);
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRightOf(proguard.evaluation.value.IntegerValue)"
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
   * Test {@link ParticularIntegerValue#shiftRightOf(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRightOf(proguard.evaluation.value.IntegerValue)"
  })
  void testShiftRightOfWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).shiftRightOf(other));
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.ParticularIntegerValue.shiftRightOf(proguard.evaluation.value.LongValue)"
  })
  void testShiftRightOfWithLongValue_thenReturnCompositeLongValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualShiftRightOfResult =
        particularIntegerValue.shiftRightOf(
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
   * Test {@link ParticularIntegerValue#shiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.ParticularIntegerValue.shiftRightOf(proguard.evaluation.value.LongValue)"
  })
  void testShiftRightOfWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualShiftRightOfResult = (new ParticularIntegerValue(42)).shiftRightOf(other);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof ParticularLongValue);
    assertEquals(other, actualShiftRightOfResult);
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRightOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.ParticularIntegerValue.shiftRightOf(proguard.evaluation.value.LongValue)"
  })
  void testShiftRightOfWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).shiftRightOf(other));
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRightOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testShiftRightOfWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightOfResult =
        particularIntegerValue.shiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof ParticularIntegerValue);
    assertEquals(0, actualShiftRightOfResult.value());
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertTrue(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRightOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRightOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.ParticularIntegerValue.shiftRightOf(proguard.evaluation.value.ParticularLongValue)"
  })
  void testShiftRightOfWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualShiftRightOfResult =
        particularIntegerValue.shiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof ParticularLongValue);
    assertEquals(0L, actualShiftRightOfResult.value());
    assertTrue(actualShiftRightOfResult.isCategory2());
    assertTrue(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRightOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRightOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRightOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftRightOfWithRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.shiftRightOf(other));
  }

  /**
   * Test {@link ParticularIntegerValue#shiftRightOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#shiftRightOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.shiftRightOf(proguard.evaluation.value.RangeIntegerValue)"
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
   * Test {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightWithIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(
        particularIntegerValue,
        particularIntegerValue.unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        particularIntegerValue.unsignedShiftRight(
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
   * Test {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightWithIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        particularIntegerValue.unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualUnsignedShiftRightResult);
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightWithIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        particularIntegerValue.unsignedShiftRight((IntegerValue) new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightWithIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        (new ParticularIntegerValue(42))
            .unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_CHAR}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_CHAR")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightWithIntegerValue_whenInteger_value_char() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        (new ParticularIntegerValue(42))
            .unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRight(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).unsignedShiftRight(other));
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRight(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testUnsignedShiftRightWithParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        particularIntegerValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof ParticularIntegerValue);
    assertEquals(0, actualUnsignedShiftRightResult.value());
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRight(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRight(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testUnsignedShiftRightWithRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(
        particularIntegerValue,
        particularIntegerValue.unsignedShiftRight(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRight(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRight(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testUnsignedShiftRightWithRangeIntegerValue2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        particularIntegerValue.unsignedShiftRight(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRight(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRight(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testUnsignedShiftRightWithRangeIntegerValue3() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        particularIntegerValue.unsignedShiftRight(new RangeIntegerValue(1, 42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRight(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRight(proguard.evaluation.value.RangeIntegerValue)"
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
   * Test {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code
   * IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightOfWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        particularIntegerValue.unsignedShiftRightOf(
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
   * Test {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code
   * IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightOfWithIntegerValue_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).unsignedShiftRightOf(other));
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code
   * IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'; then return INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightOfWithIntegerValue_thenReturnInteger_value_byte() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(-128)).unsignedShiftRightOf(other));
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code
   * IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightOfWithIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        (new ParticularIntegerValue(42)).unsignedShiftRightOf(other);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code
   * IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.IntegerValue)"
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
   * Test {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)} with {@code
   * IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_CHAR}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRightOf(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_CHAR")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.IntegerValue)"
  })
  void testUnsignedShiftRightOfWithIntegerValue_whenInteger_value_char() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult =
        (new ParticularIntegerValue(42))
            .unsignedShiftRightOf(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.LongValue)"
  })
  void testUnsignedShiftRightOfWithLongValue_thenReturnCompositeLongValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        particularIntegerValue.unsignedShiftRightOf(
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
   * Test {@link ParticularIntegerValue#unsignedShiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(LongValue) with 'LongValue'; then return ParticularLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.LongValue)"
  })
  void testUnsignedShiftRightOfWithLongValue_thenReturnParticularLongValue() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        (new ParticularIntegerValue(42)).unsignedShiftRightOf(other);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof ParticularLongValue);
    assertEquals(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRightOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRightOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.LongValue)"
  })
  void testUnsignedShiftRightOfWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).unsignedShiftRightOf(other));
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link
   * ParticularIntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testUnsignedShiftRightOfWithParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        particularIntegerValue.unsignedShiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof ParticularIntegerValue);
    assertEquals(0, actualUnsignedShiftRightOfResult.value());
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertTrue(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRightOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRightOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.ParticularLongValue)"
  })
  void testUnsignedShiftRightOfWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        particularIntegerValue.unsignedShiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof ParticularLongValue);
    assertEquals(0L, actualUnsignedShiftRightOfResult.value());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
    assertTrue(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRightOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testUnsignedShiftRightOfWithRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.unsignedShiftRightOf(other));
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRightOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testUnsignedShiftRightOfWithRangeIntegerValue2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        particularIntegerValue.unsignedShiftRightOf(
            new RangeIntegerValue(Integer.MIN_VALUE, Integer.MIN_VALUE));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isParticular());
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRightOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return not Particular.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(RangeIntegerValue) with 'RangeIntegerValue'; then return not Particular")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testUnsignedShiftRightOfWithRangeIntegerValue_thenReturnNotParticular() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        particularIntegerValue.unsignedShiftRightOf(new RangeIntegerValue(Integer.MIN_VALUE, 3));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#unsignedShiftRightOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return Particular.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(RangeIntegerValue) with 'RangeIntegerValue'; then return Particular")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.unsignedShiftRightOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testUnsignedShiftRightOfWithRangeIntegerValue_thenReturnParticular() {
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
   * Test {@link ParticularIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName("Test and(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.and(proguard.evaluation.value.IntegerValue)"
  })
  void testAndWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAndResult =
        particularIntegerValue.and(
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
   * Test {@link ParticularIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName("Test and(IntegerValue) with 'IntegerValue'; then return INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.and(proguard.evaluation.value.IntegerValue)"
  })
  void testAndWithIntegerValue_thenReturnInteger_value_byte() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(Value.NEVER)).and(other));
  }

  /**
   * Test {@link ParticularIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue(int) with value is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.and(proguard.evaluation.value.IntegerValue)"
  })
  void testAndWithIntegerValue_thenReturnParticularIntegerValueWithValueIsZero() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(
        particularIntegerValue,
        particularIntegerValue.and(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ParticularIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName("Test and(IntegerValue) with 'IntegerValue'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.and(proguard.evaluation.value.IntegerValue)"
  })
  void testAndWithIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult =
        (new ParticularIntegerValue(Integer.MIN_VALUE))
            .and(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualAndResult instanceof UnknownIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.and(proguard.evaluation.value.IntegerValue)"
  })
  void testAndWithIntegerValue_whenInteger_value_0_thenReturnParticularIntegerValue() {
    // Arrange
    IntegerValue other = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualAndResult = (new ParticularIntegerValue(42)).and(other);

    // Assert
    assertTrue(actualAndResult instanceof ParticularIntegerValue);
    assertEquals(other, actualAndResult);
  }

  /**
   * Test {@link ParticularIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.and(proguard.evaluation.value.IntegerValue)"
  })
  void testAndWithIntegerValue_whenInteger_value_byte_thenReturnRangeIntegerValue() {
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
   * Test {@link ParticularIntegerValue#and(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#and(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.and(proguard.evaluation.value.IntegerValue)"
  })
  void testAndWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).and(other));
  }

  /**
   * Test {@link ParticularIntegerValue#and(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.and(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testAndWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualAndResult = particularIntegerValue.and(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualAndResult);
  }

  /**
   * Test {@link ParticularIntegerValue#and(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#and(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test and(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.and(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testAndWithRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.and(other));
  }

  /**
   * Test {@link ParticularIntegerValue#and(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#and(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(RangeIntegerValue) with 'RangeIntegerValue'; then return ParticularIntegerValue(int) with value is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.and(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testAndWithRangeIntegerValue_thenReturnParticularIntegerValueWithValueIsZero() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.and(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#and(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#and(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.and(proguard.evaluation.value.RangeIntegerValue)"
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
   * Test {@link ParticularIntegerValue#and(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#and(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(RangeIntegerValue) with 'RangeIntegerValue'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.and(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testAndWithRangeIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Integer.MIN_VALUE);

    // Act
    IntegerValue actualAndResult = particularIntegerValue.and(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAndResult instanceof UnknownIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName("Test or(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.or(proguard.evaluation.value.IntegerValue)"
  })
  void testOrWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualOrResult =
        particularIntegerValue.or(
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
   * Test {@link ParticularIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName("Test or(IntegerValue) with 'IntegerValue'; then return INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.or(proguard.evaluation.value.IntegerValue)"
  })
  void testOrWithIntegerValue_thenReturnInteger_value_byte() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(0)).or(other));
  }

  /**
   * Test {@link ParticularIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is
   *       {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(IntegerValue) with 'IntegerValue'; then return ParticularIntegerValue(int) with value is NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.or(proguard.evaluation.value.IntegerValue)"
  })
  void testOrWithIntegerValue_thenReturnParticularIntegerValueWithValueIsNever() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act and Assert
    assertSame(
        particularIntegerValue,
        particularIntegerValue.or(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ParticularIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName("Test or(IntegerValue) with 'IntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.or(proguard.evaluation.value.IntegerValue)"
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
   * Test {@link ParticularIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.or(proguard.evaluation.value.IntegerValue)"
  })
  void testOrWithIntegerValue_whenInteger_value_0_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualOrResult = particularIntegerValue.or(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualOrResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualOrResult);
  }

  /**
   * Test {@link ParticularIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.or(proguard.evaluation.value.IntegerValue)"
  })
  void testOrWithIntegerValue_whenInteger_value_byte_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualOrResult =
        (new ParticularIntegerValue(42)).or(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualOrResult instanceof UnknownIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#or(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#or(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.or(proguard.evaluation.value.IntegerValue)"
  })
  void testOrWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).or(other));
  }

  /**
   * Test {@link ParticularIntegerValue#or(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.or(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testOrWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualOrResult = particularIntegerValue.or(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualOrResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualOrResult);
  }

  /**
   * Test {@link ParticularIntegerValue#or(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is
   *       {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#or(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(RangeIntegerValue) with 'RangeIntegerValue'; then return ParticularIntegerValue(int) with value is NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.or(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testOrWithRangeIntegerValue_thenReturnParticularIntegerValueWithValueIsNever() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act and Assert
    assertSame(particularIntegerValue, particularIntegerValue.or(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#or(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#or(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test or(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.or(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testOrWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Integer.MIN_VALUE);

    // Act
    IntegerValue actualOrResult = particularIntegerValue.or(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualOrResult instanceof RangeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#or(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max
   *       is three.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#or(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue(int, int) with min is one and max is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.or(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testOrWithRangeIntegerValue_thenReturnRangeIntegerValueWithMinIsOneAndMaxIsThree() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.or(other));
  }

  /**
   * Test {@link ParticularIntegerValue#or(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#or(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(RangeIntegerValue) with 'RangeIntegerValue'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.or(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testOrWithRangeIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualOrResult = particularIntegerValue.or(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualOrResult instanceof UnknownIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#xor(IntegerValue)}
   */
  @Test
  @DisplayName("Test xor(IntegerValue) with 'IntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.xor(proguard.evaluation.value.IntegerValue)"
  })
  void testXorWithIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualXorResult =
        particularIntegerValue.xor(
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
   * Test {@link ParticularIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#xor(IntegerValue)}
   */
  @Test
  @DisplayName("Test xor(IntegerValue) with 'IntegerValue'; then return INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.xor(proguard.evaluation.value.IntegerValue)"
  })
  void testXorWithIntegerValue_thenReturnInteger_value_byte() {
    // Arrange
    IntegerValue other = BasicRangeValueFactory.INTEGER_VALUE_BYTE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(0)).xor(other));
  }

  /**
   * Test {@link ParticularIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#xor(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.xor(proguard.evaluation.value.IntegerValue)"
  })
  void testXorWithIntegerValue_whenInteger_value_0_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualXorResult =
        particularIntegerValue.xor(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualXorResult instanceof ParticularIntegerValue);
    assertEquals(particularIntegerValue, actualXorResult);
  }

  /**
   * Test {@link ParticularIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#xor(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.xor(proguard.evaluation.value.IntegerValue)"
  })
  void testXorWithIntegerValue_whenInteger_value_byte_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualXorResult =
        (new ParticularIntegerValue(42)).xor(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualXorResult instanceof UnknownIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertFalse(actualXorResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#xor(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#xor(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.xor(proguard.evaluation.value.IntegerValue)"
  })
  void testXorWithIntegerValue_whenInteger_value_thenReturnInteger_value() {
    // Arrange
    IntegerValue other = BasicValueFactory.INTEGER_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularIntegerValue(42)).xor(other));
  }

  /**
   * Test {@link ParticularIntegerValue#xor(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#xor(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.xor(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testXorWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualXorResult = particularIntegerValue.xor(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualXorResult instanceof ParticularIntegerValue);
    assertEquals(0, actualXorResult.value());
    assertFalse(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#xor(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#xor(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test xor(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.xor(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testXorWithRangeIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);
    RangeIntegerValue other = new RangeIntegerValue(1, 3);

    // Act and Assert
    assertSame(other, particularIntegerValue.xor(other));
  }

  /**
   * Test {@link ParticularIntegerValue#xor(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#xor(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(RangeIntegerValue) with 'RangeIntegerValue'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.ParticularIntegerValue.xor(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testXorWithRangeIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualXorResult = particularIntegerValue.xor(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualXorResult instanceof UnknownIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertFalse(actualXorResult.isSpecific());
  }

  /**
   * Test {@link ParticularIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName("Test equal(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.equal(proguard.evaluation.value.IntegerValue)"
  })
  void testEqualWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0, (new ParticularIntegerValue(-128)).equal(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ParticularIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName("Test equal(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.equal(proguard.evaluation.value.IntegerValue)"
  })
  void testEqualWithIntegerValue2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(
        0,
        particularIntegerValue.equal(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link ParticularIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(IntegerValue) with 'IntegerValue'; given ParticularIntegerValue(int) with value is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.equal(proguard.evaluation.value.IntegerValue)"
  })
  void testEqualWithIntegerValue_givenParticularIntegerValueWithValueIsMin_value() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        (new ParticularIntegerValue(Integer.MIN_VALUE))
            .equal(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ParticularIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName("Test equal(IntegerValue) with 'IntegerValue'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.equal(proguard.evaluation.value.IntegerValue)"
  })
  void testEqualWithIntegerValue_thenReturnOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(1, particularIntegerValue.equal((IntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link ParticularIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.equal(proguard.evaluation.value.IntegerValue)"
  })
  void testEqualWithIntegerValue_whenInteger_value_0_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        (new ParticularIntegerValue(42)).equal(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link ParticularIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.equal(proguard.evaluation.value.IntegerValue)"
  })
  void testEqualWithIntegerValue_whenInteger_value_byte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, (new ParticularIntegerValue(42)).equal(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ParticularIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName("Test equal(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.equal(proguard.evaluation.value.IntegerValue)"
  })
  void testEqualWithIntegerValue_whenInteger_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new ParticularIntegerValue(42)).equal(BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Test {@link ParticularIntegerValue#equal(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link RangeIntegerValue#RangeIntegerValue(int, int)} with min is one and max is
   *       three.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#equal(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(IntegerValue) with 'IntegerValue'; when RangeIntegerValue(int, int) with min is one and max is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.equal(proguard.evaluation.value.IntegerValue)"
  })
  void testEqualWithIntegerValue_whenRangeIntegerValueWithMinIsOneAndMaxIsThree() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(
        Value.NEVER, particularIntegerValue.equal((IntegerValue) new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#equal(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ParticularIntegerValue) with 'ParticularIntegerValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.equal(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testEqualWithParticularIntegerValue_thenReturnNever() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link ParticularIntegerValue#equal(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(ParticularIntegerValue) with 'ParticularIntegerValue'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.equal(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testEqualWithParticularIntegerValue_thenReturnOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(1, particularIntegerValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link ParticularIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(RangeIntegerValue) with 'RangeIntegerValue'; given ParticularIntegerValue(int) with value is NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.equal(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testEqualWithRangeIntegerValue_givenParticularIntegerValueWithValueIsNever() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(RangeIntegerValue) with 'RangeIntegerValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.equal(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testEqualWithRangeIntegerValue_thenReturnNever() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(RangeIntegerValue) with 'RangeIntegerValue'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.equal(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testEqualWithRangeIntegerValue_thenReturnOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertEquals(1, particularIntegerValue.equal(new RangeIntegerValue(1, 1)));
  }

  /**
   * Test {@link ParticularIntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(RangeIntegerValue) with 'RangeIntegerValue'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.equal(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testEqualWithRangeIntegerValue_thenReturnZero() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertEquals(0, particularIntegerValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThan(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanWithIntegerValue() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(
        0,
        particularIntegerValue.lessThan(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularIntegerValue#ParticularIntegerValue(int)} with value is {@link
   *       Float#MAX_EXPONENT}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(IntegerValue) with 'IntegerValue'; given ParticularIntegerValue(int) with value is MAX_EXPONENT")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThan(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanWithIntegerValue_givenParticularIntegerValueWithValueIsMax_exponent() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        (new ParticularIntegerValue(Float.MAX_EXPONENT))
            .lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(IntegerValue) with 'IntegerValue'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThan(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanWithIntegerValue_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        (new ParticularIntegerValue(Integer.MIN_VALUE))
            .lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(IntegerValue) with 'IntegerValue'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThan(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanWithIntegerValue_thenReturnOne2() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        (new ParticularIntegerValue(Integer.MIN_VALUE))
            .lessThan(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThan(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanWithIntegerValue_whenInteger_value_0_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        (new ParticularIntegerValue(42)).lessThan(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThan(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanWithIntegerValue_whenInteger_value_byte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, (new ParticularIntegerValue(42)).lessThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThan(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThan(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanWithIntegerValue_whenInteger_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new ParticularIntegerValue(42)).lessThan(BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThan(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(ParticularIntegerValue) with 'ParticularIntegerValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThan(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testLessThanWithParticularIntegerValue_thenReturnNever() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.lessThan(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThan(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(ParticularIntegerValue) with 'ParticularIntegerValue'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThan(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testLessThanWithParticularIntegerValue_thenReturnOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(Value.NEVER);

    // Act and Assert
    assertEquals(1, particularIntegerValue.lessThan(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(RangeIntegerValue) with 'RangeIntegerValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThan(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testLessThanWithRangeIntegerValue_thenReturnNever() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(RangeIntegerValue) with 'RangeIntegerValue'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThan(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testLessThanWithRangeIntegerValue_thenReturnOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(0);

    // Act and Assert
    assertEquals(1, particularIntegerValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(RangeIntegerValue) with 'RangeIntegerValue'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThan(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testLessThanWithRangeIntegerValue_thenReturnZero() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertEquals(0, particularIntegerValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanOrEqualWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        (new ParticularIntegerValue(-128))
            .lessThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanOrEqualWithIntegerValue2() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(
        0,
        particularIntegerValue.lessThanOrEqual(
            (IntegerValue)
                new ComparisonValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanOrEqualWithIntegerValue3() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(
        1, particularIntegerValue.lessThanOrEqual((IntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanOrEqualWithIntegerValue4() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(
        Value.NEVER,
        particularIntegerValue.lessThanOrEqual((IntegerValue) new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanOrEqualWithIntegerValue_whenInteger_value_0_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        (new ParticularIntegerValue(42)).lessThanOrEqual(ParticularValueFactory.INTEGER_VALUE_0));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanOrEqualWithIntegerValue_whenInteger_value_byte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ParticularIntegerValue(42))
            .lessThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testLessThanOrEqualWithIntegerValue_whenInteger_value_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, (new ParticularIntegerValue(42)).lessThanOrEqual(BasicValueFactory.INTEGER_VALUE));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(ParticularIntegerValue) with 'ParticularIntegerValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThanOrEqual(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testLessThanOrEqualWithParticularIntegerValue_thenReturnNever() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(
        Value.NEVER, particularIntegerValue.lessThanOrEqual(new ParticularIntegerValue(1)));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(ParticularIntegerValue) with 'ParticularIntegerValue'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThanOrEqual(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testLessThanOrEqualWithParticularIntegerValue_thenReturnOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(1, particularIntegerValue.lessThanOrEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThanOrEqual(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(RangeIntegerValue) with 'RangeIntegerValue'; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThanOrEqual(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testLessThanOrEqualWithRangeIntegerValue_thenReturnNever() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(42);

    // Act and Assert
    assertEquals(Value.NEVER, particularIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThanOrEqual(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(RangeIntegerValue) with 'RangeIntegerValue'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThanOrEqual(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testLessThanOrEqualWithRangeIntegerValue_thenReturnOne() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertEquals(1, particularIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#lessThanOrEqual(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(RangeIntegerValue) with 'RangeIntegerValue'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.ParticularIntegerValue.lessThanOrEqual(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testLessThanOrEqualWithRangeIntegerValue_thenReturnZero() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(3);

    // Act and Assert
    assertEquals(0, particularIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link ParticularIntegerValue#equals(Object)}, and {@link
   * ParticularIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParticularIntegerValue#equals(Object)}
   *   <li>{@link ParticularIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ParticularIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ParticularIntegerValue.hashCode()"
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
   * Test {@link ParticularIntegerValue#equals(Object)}, and {@link
   * ParticularIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParticularIntegerValue#equals(Object)}
   *   <li>{@link ParticularIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ParticularIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ParticularIntegerValue.hashCode()"
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
   * Test {@link ParticularIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ParticularIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ParticularIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularIntegerValue particularIntegerValue = new ParticularIntegerValue(1);

    // Act and Assert
    assertNotEquals(particularIntegerValue, new ParticularIntegerValue(42));
  }

  /**
   * Test {@link ParticularIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ParticularIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ParticularIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularIntegerValue(42), null);
  }

  /**
   * Test {@link ParticularIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ParticularIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ParticularIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularIntegerValue(42), "Different type to ParticularIntegerValue");
  }
}
