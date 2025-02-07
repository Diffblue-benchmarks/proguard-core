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

class SpecificDoubleValueDiffblueTest {
  /**
   * Test {@link SpecificDoubleValue#negate()}.
   *
   * <ul>
   *   <li>Then return {@link NegatedDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#negate()}
   */
  @Test
  @DisplayName("Test negate(); then return NegatedDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.negate()"
  })
  void testNegate_thenReturnNegatedDoubleValue() {
    // Arrange and Act
    DoubleValue actualNegateResult =
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof NegatedDoubleValue);
    assertFalse(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isCategory2());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#negate()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#negate()}
   */
  @Test
  @DisplayName("Test negate(); then return ParticularDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.negate()"
  })
  void testNegate_thenReturnParticularDoubleValue() {
    // Arrange and Act
    DoubleValue actualNegateResult = (new ParticularDoubleValue(10.0d)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof ParticularDoubleValue);
    assertEquals(-10.0d, actualNegateResult.value());
    assertTrue(actualNegateResult.isCategory2());
    assertTrue(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#convertToInteger()}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#convertToInteger()}
   */
  @Test
  @DisplayName("Test convertToInteger(); then return ConvertedIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificDoubleValue.convertToInteger()"
  })
  void testConvertToInteger_thenReturnConvertedIntegerValue() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult =
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof ConvertedIntegerValue);
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertFalse(actualConvertToIntegerResult.isParticular());
    assertTrue(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#convertToInteger()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#convertToInteger()}
   */
  @Test
  @DisplayName("Test convertToInteger(); then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificDoubleValue.convertToInteger()"
  })
  void testConvertToInteger_thenReturnParticularIntegerValue() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult =
        (new ParticularDoubleValue(10.0d)).convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof ParticularIntegerValue);
    assertEquals(10, actualConvertToIntegerResult.value());
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertTrue(actualConvertToIntegerResult.isParticular());
    assertTrue(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#convertToLong()}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#convertToLong()}
   */
  @Test
  @DisplayName("Test convertToLong(); then return ConvertedLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificDoubleValue.convertToLong()"
  })
  void testConvertToLong_thenReturnConvertedLongValue() {
    // Arrange and Act
    LongValue actualConvertToLongResult =
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof ConvertedLongValue);
    assertFalse(actualConvertToLongResult.isParticular());
    assertTrue(actualConvertToLongResult.isCategory2());
    assertTrue(actualConvertToLongResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#convertToLong()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#convertToLong()}
   */
  @Test
  @DisplayName("Test convertToLong(); then return ParticularLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.SpecificDoubleValue.convertToLong()"
  })
  void testConvertToLong_thenReturnParticularLongValue() {
    // Arrange and Act
    LongValue actualConvertToLongResult = (new ParticularDoubleValue(10.0d)).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof ParticularLongValue);
    assertEquals(10L, actualConvertToLongResult.value());
    assertTrue(actualConvertToLongResult.isCategory2());
    assertTrue(actualConvertToLongResult.isParticular());
    assertTrue(actualConvertToLongResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#convertToFloat()}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#convertToFloat()}
   */
  @Test
  @DisplayName("Test convertToFloat(); then return ConvertedFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.SpecificDoubleValue.convertToFloat()"
  })
  void testConvertToFloat_thenReturnConvertedFloatValue() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult =
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof ConvertedFloatValue);
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertFalse(actualConvertToFloatResult.isParticular());
    assertTrue(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#convertToFloat()}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#convertToFloat()}
   */
  @Test
  @DisplayName("Test convertToFloat(); then return ParticularFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.SpecificDoubleValue.convertToFloat()"
  })
  void testConvertToFloat_thenReturnParticularFloatValue() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = (new ParticularDoubleValue(10.0d)).convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof ParticularFloatValue);
    assertEquals(10.0f, actualConvertToFloatResult.value());
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertTrue(actualConvertToFloatResult.isParticular());
    assertTrue(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#generalize(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link SpecificDoubleValue#generalize(DoubleValue)}
   */
  @Test
  @DisplayName("Test generalize(DoubleValue) with 'DoubleValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.generalize(proguard.evaluation.value.DoubleValue)"
  })
  void testGeneralizeWithDoubleValue() {
    // Arrange
    ConvertedDoubleValue convertedDoubleValue =
        new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    DoubleValue actualGeneralizeResult =
        convertedDoubleValue.generalize(
            (DoubleValue)
                new ConvertedDoubleValue(
                    new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link SpecificDoubleValue#generalize(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Given {@link ConvertedDoubleValue#ConvertedDoubleValue(Value)} with value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#generalize(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(DoubleValue) with 'DoubleValue'; given ConvertedDoubleValue(Value) with value is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.generalize(proguard.evaluation.value.DoubleValue)"
  })
  void testGeneralizeWithDoubleValue_givenConvertedDoubleValueWithValueIsNull() {
    // Arrange
    ConvertedDoubleValue convertedDoubleValue = new ConvertedDoubleValue(null);

    // Act
    DoubleValue actualGeneralizeResult =
        convertedDoubleValue.generalize(
            (DoubleValue)
                new ConvertedDoubleValue(
                    new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link SpecificDoubleValue#generalize(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularDoubleValue#ParticularDoubleValue(double)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#generalize(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(DoubleValue) with 'DoubleValue'; given ParticularDoubleValue(double) with value is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.generalize(proguard.evaluation.value.DoubleValue)"
  })
  void testGeneralizeWithDoubleValue_givenParticularDoubleValueWithValueIsTen() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).generalize(other));
  }

  /**
   * Test {@link SpecificDoubleValue#generalize(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ConvertedDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#generalize(DoubleValue)}
   */
  @Test
  @DisplayName("Test generalize(DoubleValue) with 'DoubleValue'; then return ConvertedDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.generalize(proguard.evaluation.value.DoubleValue)"
  })
  void testGeneralizeWithDoubleValue_thenReturnConvertedDoubleValue() {
    // Arrange
    ConvertedDoubleValue convertedDoubleValue =
        new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedDoubleValue other =
        new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    DoubleValue actualGeneralizeResult = convertedDoubleValue.generalize((DoubleValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof ConvertedDoubleValue);
    assertEquals(convertedDoubleValue, actualGeneralizeResult);
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link SpecificDoubleValue#generalize(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return {@link UnknownDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#generalize(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE_0; then return UnknownDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.generalize(proguard.evaluation.value.DoubleValue)"
  })
  void testGeneralizeWithDoubleValue_whenDouble_value_0_thenReturnUnknownDoubleValue() {
    // Arrange and Act
    DoubleValue actualGeneralizeResult =
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .generalize(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link SpecificDoubleValue#generalize(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#generalize(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.generalize(proguard.evaluation.value.DoubleValue)"
  })
  void testGeneralizeWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).generalize(other));
  }

  /**
   * Test {@link SpecificDoubleValue#generalize(SpecificDoubleValue)} with {@code
   * SpecificDoubleValue}.
   *
   * <p>Method under test: {@link SpecificDoubleValue#generalize(SpecificDoubleValue)}
   */
  @Test
  @DisplayName("Test generalize(SpecificDoubleValue) with 'SpecificDoubleValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.generalize(proguard.evaluation.value.SpecificDoubleValue)"
  })
  void testGeneralizeWithSpecificDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act and Assert
    assertSame(
        particularDoubleValue,
        particularDoubleValue.generalize((SpecificDoubleValue) new ParticularDoubleValue(10.0d)));
  }

  /**
   * Test {@link SpecificDoubleValue#generalize(SpecificDoubleValue)} with {@code
   * SpecificDoubleValue}.
   *
   * <p>Method under test: {@link SpecificDoubleValue#generalize(SpecificDoubleValue)}
   */
  @Test
  @DisplayName("Test generalize(SpecificDoubleValue) with 'SpecificDoubleValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.generalize(proguard.evaluation.value.SpecificDoubleValue)"
  })
  void testGeneralizeWithSpecificDoubleValue2() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualGeneralizeResult =
        particularDoubleValue.generalize(
            new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link SpecificDoubleValue#generalize(SpecificDoubleValue)} with {@code
   * SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularDoubleValue#ParticularDoubleValue(double)} with value is {@code
   *       0.5}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#generalize(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(SpecificDoubleValue) with 'SpecificDoubleValue'; given ParticularDoubleValue(double) with value is '0.5'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.generalize(proguard.evaluation.value.SpecificDoubleValue)"
  })
  void testGeneralizeWithSpecificDoubleValue_givenParticularDoubleValueWithValueIs05() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(0.5d);

    // Act
    DoubleValue actualGeneralizeResult =
        particularDoubleValue.generalize((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link SpecificDoubleValue#generalize(SpecificDoubleValue)} with {@code
   * SpecificDoubleValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link UnknownDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#generalize(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(SpecificDoubleValue) with 'SpecificDoubleValue'; when 'null'; then return UnknownDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.generalize(proguard.evaluation.value.SpecificDoubleValue)"
  })
  void testGeneralizeWithSpecificDoubleValue_whenNull_thenReturnUnknownDoubleValue() {
    // Arrange and Act
    DoubleValue actualGeneralizeResult =
        (new ParticularDoubleValue(10.0d)).generalize((SpecificDoubleValue) null);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link SpecificDoubleValue#add(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularDoubleValue#ParticularDoubleValue(double)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#add(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test add(DoubleValue) with 'DoubleValue'; given ParticularDoubleValue(double) with value is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.add(proguard.evaluation.value.DoubleValue)"
  })
  void testAddWithDoubleValue_givenParticularDoubleValueWithValueIsTen() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).add(other));
  }

  /**
   * Test {@link SpecificDoubleValue#add(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#add(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test add(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE_0; then return CompositeDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.add(proguard.evaluation.value.DoubleValue)"
  })
  void testAddWithDoubleValue_whenDouble_value_0_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualAddResult =
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .add(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualAddResult instanceof CompositeDoubleValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#add(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#add(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test add(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.add(proguard.evaluation.value.DoubleValue)"
  })
  void testAddWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).add(other));
  }

  /**
   * Test {@link SpecificDoubleValue#add(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <p>Method under test: {@link SpecificDoubleValue#add(SpecificDoubleValue)}
   */
  @Test
  @DisplayName("Test add(SpecificDoubleValue) with 'SpecificDoubleValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.add(proguard.evaluation.value.SpecificDoubleValue)"
  })
  void testAddWithSpecificDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualAddResult =
        particularDoubleValue.add((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualAddResult instanceof CompositeDoubleValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#subtract(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularDoubleValue#ParticularDoubleValue(double)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#subtract(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(DoubleValue) with 'DoubleValue'; given ParticularDoubleValue(double) with value is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.subtract(proguard.evaluation.value.DoubleValue)"
  })
  void testSubtractWithDoubleValue_givenParticularDoubleValueWithValueIsTen() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).subtract(other));
  }

  /**
   * Test {@link SpecificDoubleValue#subtract(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#subtract(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE_0; then return CompositeDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.subtract(proguard.evaluation.value.DoubleValue)"
  })
  void testSubtractWithDoubleValue_whenDouble_value_0_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualSubtractResult =
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .subtract(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#subtract(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#subtract(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.subtract(proguard.evaluation.value.DoubleValue)"
  })
  void testSubtractWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).subtract(other));
  }

  /**
   * Test {@link SpecificDoubleValue#subtract(SpecificDoubleValue)} with {@code
   * SpecificDoubleValue}.
   *
   * <p>Method under test: {@link SpecificDoubleValue#subtract(SpecificDoubleValue)}
   */
  @Test
  @DisplayName("Test subtract(SpecificDoubleValue) with 'SpecificDoubleValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.subtract(proguard.evaluation.value.SpecificDoubleValue)"
  })
  void testSubtractWithSpecificDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualSubtractResult =
        particularDoubleValue.subtract((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#subtractFrom(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularDoubleValue#ParticularDoubleValue(double)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#subtractFrom(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(DoubleValue) with 'DoubleValue'; given ParticularDoubleValue(double) with value is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.subtractFrom(proguard.evaluation.value.DoubleValue)"
  })
  void testSubtractFromWithDoubleValue_givenParticularDoubleValueWithValueIsTen() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).subtractFrom(other));
  }

  /**
   * Test {@link SpecificDoubleValue#subtractFrom(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#subtractFrom(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(DoubleValue) with 'DoubleValue'; then return CompositeDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.subtractFrom(proguard.evaluation.value.DoubleValue)"
  })
  void testSubtractFromWithDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualSubtractFromResult =
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .subtractFrom(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#subtractFrom(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#subtractFrom(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.subtractFrom(proguard.evaluation.value.DoubleValue)"
  })
  void testSubtractFromWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).subtractFrom(other));
  }

  /**
   * Test {@link SpecificDoubleValue#subtractFrom(SpecificDoubleValue)} with {@code
   * SpecificDoubleValue}.
   *
   * <p>Method under test: {@link SpecificDoubleValue#subtractFrom(SpecificDoubleValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(SpecificDoubleValue) with 'SpecificDoubleValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.subtractFrom(proguard.evaluation.value.SpecificDoubleValue)"
  })
  void testSubtractFromWithSpecificDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualSubtractFromResult =
        particularDoubleValue.subtractFrom((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#multiply(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularDoubleValue#ParticularDoubleValue(double)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#multiply(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(DoubleValue) with 'DoubleValue'; given ParticularDoubleValue(double) with value is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.multiply(proguard.evaluation.value.DoubleValue)"
  })
  void testMultiplyWithDoubleValue_givenParticularDoubleValueWithValueIsTen() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).multiply(other));
  }

  /**
   * Test {@link SpecificDoubleValue#multiply(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#multiply(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE_0; then return CompositeDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.multiply(proguard.evaluation.value.DoubleValue)"
  })
  void testMultiplyWithDoubleValue_whenDouble_value_0_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualMultiplyResult =
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .multiply(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeDoubleValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#multiply(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#multiply(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.multiply(proguard.evaluation.value.DoubleValue)"
  })
  void testMultiplyWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).multiply(other));
  }

  /**
   * Test {@link SpecificDoubleValue#multiply(SpecificDoubleValue)} with {@code
   * SpecificDoubleValue}.
   *
   * <p>Method under test: {@link SpecificDoubleValue#multiply(SpecificDoubleValue)}
   */
  @Test
  @DisplayName("Test multiply(SpecificDoubleValue) with 'SpecificDoubleValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.multiply(proguard.evaluation.value.SpecificDoubleValue)"
  })
  void testMultiplyWithSpecificDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualMultiplyResult =
        particularDoubleValue.multiply((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeDoubleValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#divide(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularDoubleValue#ParticularDoubleValue(double)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#divide(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divide(DoubleValue) with 'DoubleValue'; given ParticularDoubleValue(double) with value is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.divide(proguard.evaluation.value.DoubleValue)"
  })
  void testDivideWithDoubleValue_givenParticularDoubleValueWithValueIsTen() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).divide(other));
  }

  /**
   * Test {@link SpecificDoubleValue#divide(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#divide(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divide(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE_0; then return CompositeDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.divide(proguard.evaluation.value.DoubleValue)"
  })
  void testDivideWithDoubleValue_whenDouble_value_0_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualDivideResult =
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .divide(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualDivideResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#divide(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#divide(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divide(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.divide(proguard.evaluation.value.DoubleValue)"
  })
  void testDivideWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(
        other, (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).divide(other));
  }

  /**
   * Test {@link SpecificDoubleValue#divide(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <p>Method under test: {@link SpecificDoubleValue#divide(SpecificDoubleValue)}
   */
  @Test
  @DisplayName("Test divide(SpecificDoubleValue) with 'SpecificDoubleValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.divide(proguard.evaluation.value.SpecificDoubleValue)"
  })
  void testDivideWithSpecificDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualDivideResult =
        particularDoubleValue.divide((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#divideOf(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularDoubleValue#ParticularDoubleValue(double)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#divideOf(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(DoubleValue) with 'DoubleValue'; given ParticularDoubleValue(double) with value is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.divideOf(proguard.evaluation.value.DoubleValue)"
  })
  void testDivideOfWithDoubleValue_givenParticularDoubleValueWithValueIsTen() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).divideOf(other));
  }

  /**
   * Test {@link SpecificDoubleValue#divideOf(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#divideOf(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE_0; then return CompositeDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.divideOf(proguard.evaluation.value.DoubleValue)"
  })
  void testDivideOfWithDoubleValue_whenDouble_value_0_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualDivideOfResult =
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .divideOf(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#divideOf(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#divideOf(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.divideOf(proguard.evaluation.value.DoubleValue)"
  })
  void testDivideOfWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).divideOf(other));
  }

  /**
   * Test {@link SpecificDoubleValue#divideOf(SpecificDoubleValue)} with {@code
   * SpecificDoubleValue}.
   *
   * <p>Method under test: {@link SpecificDoubleValue#divideOf(SpecificDoubleValue)}
   */
  @Test
  @DisplayName("Test divideOf(SpecificDoubleValue) with 'SpecificDoubleValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.divideOf(proguard.evaluation.value.SpecificDoubleValue)"
  })
  void testDivideOfWithSpecificDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualDivideOfResult =
        particularDoubleValue.divideOf((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#remainder(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularDoubleValue#ParticularDoubleValue(double)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#remainder(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(DoubleValue) with 'DoubleValue'; given ParticularDoubleValue(double) with value is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.remainder(proguard.evaluation.value.DoubleValue)"
  })
  void testRemainderWithDoubleValue_givenParticularDoubleValueWithValueIsTen() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).remainder(other));
  }

  /**
   * Test {@link SpecificDoubleValue#remainder(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#remainder(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE_0; then return CompositeDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.remainder(proguard.evaluation.value.DoubleValue)"
  })
  void testRemainderWithDoubleValue_whenDouble_value_0_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualRemainderResult =
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .remainder(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#remainder(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#remainder(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.remainder(proguard.evaluation.value.DoubleValue)"
  })
  void testRemainderWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).remainder(other));
  }

  /**
   * Test {@link SpecificDoubleValue#remainder(SpecificDoubleValue)} with {@code
   * SpecificDoubleValue}.
   *
   * <p>Method under test: {@link SpecificDoubleValue#remainder(SpecificDoubleValue)}
   */
  @Test
  @DisplayName("Test remainder(SpecificDoubleValue) with 'SpecificDoubleValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.remainder(proguard.evaluation.value.SpecificDoubleValue)"
  })
  void testRemainderWithSpecificDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualRemainderResult =
        particularDoubleValue.remainder((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#remainderOf(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularDoubleValue#ParticularDoubleValue(double)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#remainderOf(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(DoubleValue) with 'DoubleValue'; given ParticularDoubleValue(double) with value is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.remainderOf(proguard.evaluation.value.DoubleValue)"
  })
  void testRemainderOfWithDoubleValue_givenParticularDoubleValueWithValueIsTen() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(other, (new ParticularDoubleValue(10.0d)).remainderOf(other));
  }

  /**
   * Test {@link SpecificDoubleValue#remainderOf(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#remainderOf(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE_0; then return CompositeDoubleValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.remainderOf(proguard.evaluation.value.DoubleValue)"
  })
  void testRemainderOfWithDoubleValue_whenDouble_value_0_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualRemainderOfResult =
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .remainderOf(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#remainderOf(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#remainderOf(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.remainderOf(proguard.evaluation.value.DoubleValue)"
  })
  void testRemainderOfWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act and Assert
    assertSame(
        other,
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).remainderOf(other));
  }

  /**
   * Test {@link SpecificDoubleValue#remainderOf(SpecificDoubleValue)} with {@code
   * SpecificDoubleValue}.
   *
   * <p>Method under test: {@link SpecificDoubleValue#remainderOf(SpecificDoubleValue)}
   */
  @Test
  @DisplayName("Test remainderOf(SpecificDoubleValue) with 'SpecificDoubleValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.SpecificDoubleValue.remainderOf(proguard.evaluation.value.SpecificDoubleValue)"
  })
  void testRemainderOfWithSpecificDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualRemainderOfResult =
        particularDoubleValue.remainderOf((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#compare(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularDoubleValue#ParticularDoubleValue(double)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#compare(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test compare(DoubleValue) with 'DoubleValue'; given ParticularDoubleValue(double) with value is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificDoubleValue.compare(proguard.evaluation.value.DoubleValue)"
  })
  void testCompareWithDoubleValue_givenParticularDoubleValueWithValueIsTen() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        (new ParticularDoubleValue(10.0d)).compare(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#compare(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#compare(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test compare(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE_0; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificDoubleValue.compare(proguard.evaluation.value.DoubleValue)"
  })
  void testCompareWithDoubleValue_whenDouble_value_0_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .compare(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#compare(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#compare(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test compare(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificDoubleValue.compare(proguard.evaluation.value.DoubleValue)"
  })
  void testCompareWithDoubleValue_whenDouble_value_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        (new ConvertedDoubleValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .compare(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#compare(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <p>Method under test: {@link SpecificDoubleValue#compare(SpecificDoubleValue)}
   */
  @Test
  @DisplayName("Test compare(SpecificDoubleValue) with 'SpecificDoubleValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.SpecificDoubleValue.compare(proguard.evaluation.value.SpecificDoubleValue)"
  })
  void testCompareWithSpecificDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    IntegerValue actualCompareResult =
        particularDoubleValue.compare((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#isSpecific()}.
   *
   * <p>Method under test: {@link SpecificDoubleValue#isSpecific()}
   */
  @Test
  @DisplayName("Test isSpecific()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.SpecificDoubleValue.isSpecific()"})
  void testIsSpecific() {
    // Arrange, Act and Assert
    assertTrue((new ParticularDoubleValue(10.0d)).isSpecific());
  }

  /**
   * Test {@link SpecificDoubleValue#equals(Object)}, and {@link SpecificDoubleValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.SpecificDoubleValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.SpecificDoubleValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);
    ParticularDoubleValue particularDoubleValue2 = new ParticularDoubleValue(10.0d);

    // Act and Assert
    assertEquals(particularDoubleValue, particularDoubleValue2);
    int expectedHashCodeResult = particularDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, particularDoubleValue2.hashCode());
  }

  /**
   * Test {@link SpecificDoubleValue#equals(Object)}, and {@link SpecificDoubleValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.SpecificDoubleValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.SpecificDoubleValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act and Assert
    assertEquals(particularDoubleValue, particularDoubleValue);
    int expectedHashCodeResult = particularDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, particularDoubleValue.hashCode());
  }

  /**
   * Test {@link SpecificDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.SpecificDoubleValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.SpecificDoubleValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(0.5d);

    // Act and Assert
    assertNotEquals(particularDoubleValue, new ParticularDoubleValue(10.0d));
  }

  /**
   * Test {@link SpecificDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.SpecificDoubleValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.SpecificDoubleValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularDoubleValue(10.0d), null);
  }

  /**
   * Test {@link SpecificDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SpecificDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.SpecificDoubleValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.SpecificDoubleValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularDoubleValue(10.0d), "Different type to SpecificDoubleValue");
  }
}
