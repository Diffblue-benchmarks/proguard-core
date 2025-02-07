package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IntegerValueDiffblueTest {
  /**
   * Test {@link IntegerValue#value()}.
   *
   * <p>Method under test: {@link IntegerValue#value()}
   */
  @Test
  @DisplayName("Test value()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.evaluation.value.IntegerValue.value()"})
  void testValue() {
    // Arrange, Act and Assert
    assertEquals(0, (new UnknownIntegerValue()).value());
  }

  /**
   * Test {@link IntegerValue#generalize(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.generalize(proguard.evaluation.value.ParticularIntegerValue)"
  })
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
   * Test {@link IntegerValue#generalize(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.generalize(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testGeneralizeWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.generalize(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#generalize(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.generalize(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testGeneralizeWithParticularIntegerValue_thenReturnUnknownIntegerValue2() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualGeneralizeResult =
        comparisonValue.generalize(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#generalize(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.generalize(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testGeneralizeWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.generalize(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#generalize(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#generalize(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.generalize(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testGeneralizeWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.generalize((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#generalize(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#generalize(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.generalize(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testGeneralizeWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.generalize(other));
  }

  /**
   * Test {@link IntegerValue#generalize(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.generalize(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testGeneralizeWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.generalize(other));
  }

  /**
   * Test {@link IntegerValue#generalize(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.generalize(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testGeneralizeWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.generalize(other));
  }

  /**
   * Test {@link IntegerValue#generalize(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.generalize(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testGeneralizeWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.generalize(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link BasicValueFactory#UNKNOWN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(Value)}
   */
  @Test
  @DisplayName(
      "Test generalize(Value) with 'Value'; given INTEGER_VALUE_BYTE; then return UNKNOWN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.value.IntegerValue.generalize(proguard.evaluation.value.Value)"
  })
  void testGeneralizeWithValue_givenInteger_value_byte_thenReturnUnknown_value() {
    // Arrange
    UnknownValue other = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.generalize(other));
  }

  /**
   * Test {@link IntegerValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(Value)}
   */
  @Test
  @DisplayName(
      "Test generalize(Value) with 'Value'; when INTEGER_VALUE_BYTE; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.value.IntegerValue.generalize(proguard.evaluation.value.Value)"
  })
  void testGeneralizeWithValue_whenInteger_value_byte_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.generalize((Value) BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#add(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.add(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testAddWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualAddResult = comparisonValue.add(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#add(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.add(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testAddWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.add(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#add(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.add(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testAddWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.add(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#add(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(RangeIntegerValue) with 'RangeIntegerValue'; given INTEGER_VALUE_BYTE; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.add(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testAddWithRangeIntegerValue_givenInteger_value_byte_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.add(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#add(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(RangeIntegerValue) with 'RangeIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.add(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testAddWithRangeIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.add(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#add(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(SpecificIntegerValue) with 'SpecificIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.add(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testAddWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        ParticularValueFactory.INTEGER_VALUE_0.add(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof CompositeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#add(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(SpecificIntegerValue) with 'SpecificIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.add(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testAddWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAddResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.add(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAddResult instanceof RangeIntegerValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertFalse(actualAddResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#add(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(SpecificIntegerValue) with 'SpecificIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.add(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testAddWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.add((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#add(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#add(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test add(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.add(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testAddWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.add(other));
  }

  /**
   * Test {@link IntegerValue#add(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test add(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.add(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testAddWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.add(other));
  }

  /**
   * Test {@link IntegerValue#add(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test add(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.add(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testAddWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.add(other));
  }

  /**
   * Test {@link IntegerValue#add(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#add(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test add(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.add(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testAddWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.add(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#subtract(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtract(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testSubtractWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractResult = comparisonValue.subtract(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtract(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtract(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testSubtractWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtract(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtract(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtract(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testSubtractWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtract(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#subtract(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtract(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testSubtractWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtract(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtract(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(RangeIntegerValue) with 'RangeIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtract(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testSubtractWithRangeIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtract(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#subtract(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(SpecificIntegerValue) with 'SpecificIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtract(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testSubtractWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        ParticularValueFactory.INTEGER_VALUE_0.subtract(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtract(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(SpecificIntegerValue) with 'SpecificIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtract(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testSubtractWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtract(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertFalse(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtract(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(SpecificIntegerValue) with 'SpecificIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtract(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testSubtractWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.subtract((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#subtract(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#subtract(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtract(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testSubtractWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.subtract(other));
  }

  /**
   * Test {@link IntegerValue#subtract(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtract(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testSubtractWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.subtract(other));
  }

  /**
   * Test {@link IntegerValue#subtract(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtract(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testSubtractWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtract(other));
  }

  /**
   * Test {@link IntegerValue#subtract(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtract(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtract(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testSubtractWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtract(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#subtractFrom(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtractFrom(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testSubtractFromWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualSubtractFromResult =
        comparisonValue.subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtractFrom(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtractFrom(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testSubtractFromWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtractFrom(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtractFrom(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testSubtractFromWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.subtractFrom(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#subtractFrom(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtractFrom(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testSubtractFromWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtractFrom(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(RangeIntegerValue) with 'RangeIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtractFrom(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testSubtractFromWithRangeIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtractFrom(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#subtractFrom(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(SpecificIntegerValue) with 'SpecificIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtractFrom(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testSubtractFromWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        ParticularValueFactory.INTEGER_VALUE_0.subtractFrom(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtractFrom(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(SpecificIntegerValue) with 'SpecificIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtractFrom(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testSubtractFromWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualSubtractFromResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtractFrom(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualSubtractFromResult instanceof RangeIntegerValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertFalse(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#subtractFrom(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(SpecificIntegerValue) with 'SpecificIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtractFrom(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testSubtractFromWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.subtractFrom((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#subtractFrom(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtractFrom(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testSubtractFromWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.subtractFrom(other));
  }

  /**
   * Test {@link IntegerValue#subtractFrom(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtractFrom(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testSubtractFromWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.subtractFrom(other));
  }

  /**
   * Test {@link IntegerValue#subtractFrom(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtractFrom(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testSubtractFromWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtractFrom(other));
  }

  /**
   * Test {@link IntegerValue#subtractFrom(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.subtractFrom(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testSubtractFromWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.subtractFrom(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#multiply(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.multiply(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testMultiplyWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualMultiplyResult = comparisonValue.multiply(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#multiply(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.multiply(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testMultiplyWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.multiply(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#multiply(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.multiply(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testMultiplyWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.multiply(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#multiply(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.multiply(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testMultiplyWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.multiply(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#multiply(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(SpecificIntegerValue) with 'SpecificIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.multiply(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testMultiplyWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        ParticularValueFactory.INTEGER_VALUE_0.multiply(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#multiply(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(SpecificIntegerValue) with 'SpecificIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.multiply(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testMultiplyWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualMultiplyResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.multiply(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualMultiplyResult instanceof RangeIntegerValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertFalse(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#multiply(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(SpecificIntegerValue) with 'SpecificIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.multiply(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testMultiplyWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.multiply((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#multiply(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#multiply(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.multiply(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testMultiplyWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.multiply(other));
  }

  /**
   * Test {@link IntegerValue#multiply(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.multiply(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testMultiplyWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.multiply(other));
  }

  /**
   * Test {@link IntegerValue#multiply(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.multiply(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testMultiplyWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.multiply(other));
  }

  /**
   * Test {@link IntegerValue#multiply(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#multiply(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.multiply(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testMultiplyWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.multiply(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#divide(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divide(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testDivideWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualDivideResult = comparisonValue.divide(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#divide(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divide(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testDivideWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualDivideResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.divide(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#divide(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divide(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testDivideWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divide(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#divide(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test divide(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divide(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testDivideWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divide(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#divide(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(SpecificIntegerValue) with 'SpecificIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divide(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testDivideWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualDivideResult =
        ParticularValueFactory.INTEGER_VALUE_0.divide(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#divide(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(SpecificIntegerValue) with 'SpecificIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divide(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testDivideWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualDivideResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.divide(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideResult instanceof RangeIntegerValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertFalse(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#divide(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(SpecificIntegerValue) with 'SpecificIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divide(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testDivideWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.divide((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#divide(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#divide(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test divide(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divide(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testDivideWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.divide(other));
  }

  /**
   * Test {@link IntegerValue#divide(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test divide(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divide(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testDivideWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.divide(other));
  }

  /**
   * Test {@link IntegerValue#divide(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divide(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testDivideWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.divide(other));
  }

  /**
   * Test {@link IntegerValue#divide(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divide(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divide(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divide(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testDivideWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divide(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#divideOf(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divideOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testDivideOfWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualDivideOfResult = comparisonValue.divideOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#divideOf(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divideOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testDivideOfWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualDivideOfResult = ParticularValueFactory.INTEGER_VALUE_1.divideOf(other);

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualDivideOfResult);
  }

  /**
   * Test {@link IntegerValue#divideOf(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divideOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divideOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testDivideOfWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divideOf(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#divideOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divideOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testDivideOfWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divideOf(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#divideOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#divideOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divideOf(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testDivideOfWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.divideOf((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#divideOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#divideOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divideOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testDivideOfWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.divideOf(other));
  }

  /**
   * Test {@link IntegerValue#divideOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divideOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divideOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testDivideOfWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.divideOf(other));
  }

  /**
   * Test {@link IntegerValue#divideOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divideOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divideOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testDivideOfWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.divideOf(other));
  }

  /**
   * Test {@link IntegerValue#divideOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divideOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.divideOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testDivideOfWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.divideOf(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#remainder(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainder(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testRemainderWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualRemainderResult = comparisonValue.remainder(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#remainder(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainder(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testRemainderWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        BasicRangeValueFactory.INTEGER_VALUE_CHAR.remainder(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#remainder(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainder(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainder(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testRemainderWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainder(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#remainder(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainder(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testRemainderWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainder(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#remainder(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#remainder(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainder(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testRemainderWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.remainder((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#remainder(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#remainder(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainder(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testRemainderWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.remainder(other));
  }

  /**
   * Test {@link IntegerValue#remainder(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainder(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainder(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testRemainderWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.remainder(other));
  }

  /**
   * Test {@link IntegerValue#remainder(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainder(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainder(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testRemainderWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.remainder(other));
  }

  /**
   * Test {@link IntegerValue#remainder(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainder(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainder(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testRemainderWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainder(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#remainderOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainderOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testRemainderOfWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualRemainderOfResult =
        comparisonValue.remainderOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#remainderOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainderOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testRemainderOfWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        ParticularValueFactory.INTEGER_VALUE_1.remainderOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularIntegerValue);
    assertEquals(0, actualRemainderOfResult.value());
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#remainderOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainderOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testRemainderOfWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.remainderOf(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#remainderOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainderOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testRemainderOfWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainderOf(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#remainderOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainderOf(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testRemainderOfWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.remainderOf((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#remainderOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainderOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testRemainderOfWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.remainderOf(other));
  }

  /**
   * Test {@link IntegerValue#remainderOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainderOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testRemainderOfWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.remainderOf(other));
  }

  /**
   * Test {@link IntegerValue#remainderOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainderOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testRemainderOfWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.remainderOf(other));
  }

  /**
   * Test {@link IntegerValue#remainderOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.remainderOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testRemainderOfWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.remainderOf(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#shiftLeft(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeft(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testShiftLeftWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftLeftResult = comparisonValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftLeft(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeft(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testShiftLeftWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    IntegerValue integerValue = ParticularValueFactory.INTEGER_VALUE_0;

    // Act
    IntegerValue actualShiftLeftResult = integerValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof ParticularIntegerValue);
    assertEquals(integerValue, actualShiftLeftResult);
  }

  /**
   * Test {@link IntegerValue#shiftLeft(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeft(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testShiftLeftWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeft(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#shiftLeft(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeft(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftLeftWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeft(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#shiftLeft(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeft(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testShiftLeftWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.shiftLeft((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#shiftLeft(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeft(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testShiftLeftWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.shiftLeft(other));
  }

  /**
   * Test {@link IntegerValue#shiftLeft(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeft(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testShiftLeftWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.shiftLeft(other));
  }

  /**
   * Test {@link IntegerValue#shiftLeft(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeft(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testShiftLeftWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftLeft(other));
  }

  /**
   * Test {@link IntegerValue#shiftLeft(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeft(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testShiftLeftWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeft(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#shiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRight(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testShiftRightWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftRightResult =
        comparisonValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRight(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testShiftRightWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRight(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testShiftRightWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRight(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#shiftRight(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRight(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftRightWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRight(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#shiftRight(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(SpecificIntegerValue) with 'SpecificIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRight(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testShiftRightWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightResult =
        ParticularValueFactory.INTEGER_VALUE_0.shiftRight(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftRight(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(SpecificIntegerValue) with 'SpecificIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRight(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testShiftRightWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftRight(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightResult.isCategory2());
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftRight(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(SpecificIntegerValue) with 'SpecificIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRight(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testShiftRightWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.shiftRight((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#shiftRight(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRight(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testShiftRightWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.shiftRight(other));
  }

  /**
   * Test {@link IntegerValue#shiftRight(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRight(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testShiftRightWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.shiftRight(other));
  }

  /**
   * Test {@link IntegerValue#shiftRight(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRight(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testShiftRightWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftRight(other));
  }

  /**
   * Test {@link IntegerValue#shiftRight(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRight(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testShiftRightWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRight(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRight(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testUnsignedShiftRightWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        comparisonValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRight(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testUnsignedShiftRightWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.unsignedShiftRight(
            new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRight(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testUnsignedShiftRightWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.unsignedShiftRight(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRight(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testUnsignedShiftRightWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.unsignedShiftRight(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(SpecificIntegerValue) with 'SpecificIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRight(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testUnsignedShiftRightWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        ParticularValueFactory.INTEGER_VALUE_0.unsignedShiftRight(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(SpecificIntegerValue) with 'SpecificIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRight(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testUnsignedShiftRightWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.unsignedShiftRight(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightResult.isCategory2());
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(SpecificIntegerValue) with 'SpecificIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRight(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testUnsignedShiftRightWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.unsignedShiftRight(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRight(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testUnsignedShiftRightWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.unsignedShiftRight(other));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRight(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testUnsignedShiftRightWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.unsignedShiftRight(other));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRight(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testUnsignedShiftRightWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.unsignedShiftRight(other));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRight(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testUnsignedShiftRightWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.unsignedShiftRight(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeftOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testShiftLeftOfWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftLeftOfResult =
        comparisonValue.shiftLeftOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeftOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testShiftLeftOfWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftLeftOfResult =
        ParticularValueFactory.INTEGER_VALUE_0.shiftLeftOf(other);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualShiftLeftOfResult);
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeftOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testShiftLeftOfWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.shiftLeftOf(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(ParticularLongValue) with 'ParticularLongValue'; then return CompositeLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.IntegerValue.shiftLeftOf(proguard.evaluation.value.ParticularLongValue)"
  })
  void testShiftLeftOfWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualShiftLeftOfResult = comparisonValue.shiftLeftOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isCategory2());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.IntegerValue.shiftLeftOf(proguard.evaluation.value.ParticularLongValue)"
  })
  void testShiftLeftOfWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftLeftOfResult = ParticularValueFactory.INTEGER_VALUE_0.shiftLeftOf(other);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof ParticularLongValue);
    assertEquals(other, actualShiftLeftOfResult);
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(ParticularLongValue) with 'ParticularLongValue'; then return UnknownLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.IntegerValue.shiftLeftOf(proguard.evaluation.value.ParticularLongValue)"
  })
  void testShiftLeftOfWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualShiftLeftOfResult =
        unknownIntegerValue.shiftLeftOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
    assertTrue(actualShiftLeftOfResult.isCategory2());
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeftOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftLeftOfWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeftOf(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeftOf(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testShiftLeftOfWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.shiftLeftOf((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(SpecificLongValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(SpecificLongValue) with 'SpecificLongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.IntegerValue.shiftLeftOf(proguard.evaluation.value.SpecificLongValue)"
  })
  void testShiftLeftOfWithSpecificLongValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualShiftLeftOfResult =
        unknownIntegerValue.shiftLeftOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
    assertTrue(actualShiftLeftOfResult.isCategory2());
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeftOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testShiftLeftOfWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.shiftLeftOf(other));
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeftOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testShiftLeftOfWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.shiftLeftOf(other));
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeftOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testShiftLeftOfWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftLeftOf(other));
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftLeftOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testShiftLeftOfWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftLeftOf(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(UnknownLongValue)} with {@code UnknownLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(UnknownLongValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(UnknownLongValue) with 'UnknownLongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.IntegerValue.shiftLeftOf(proguard.evaluation.value.UnknownLongValue)"
  })
  void testShiftLeftOfWithUnknownLongValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();
    UnknownLongValue other = new UnknownLongValue();

    // Act
    LongValue actualShiftLeftOfResult = unknownIntegerValue.shiftLeftOf(other);

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof UnknownLongValue);
    assertEquals(other, actualShiftLeftOfResult);
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRightOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testShiftRightOfWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualShiftRightOfResult =
        comparisonValue.shiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRightOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testShiftRightOfWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualShiftRightOfResult =
        ParticularValueFactory.INTEGER_VALUE_0.shiftRightOf(other);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualShiftRightOfResult);
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRightOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testShiftRightOfWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.shiftRightOf(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(ParticularLongValue) with 'ParticularLongValue'; then return CompositeLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.IntegerValue.shiftRightOf(proguard.evaluation.value.ParticularLongValue)"
  })
  void testShiftRightOfWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualShiftRightOfResult = comparisonValue.shiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isCategory2());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.IntegerValue.shiftRightOf(proguard.evaluation.value.ParticularLongValue)"
  })
  void testShiftRightOfWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftRightOfResult = ParticularValueFactory.INTEGER_VALUE_0.shiftRightOf(other);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof ParticularLongValue);
    assertEquals(other, actualShiftRightOfResult);
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(ParticularLongValue) with 'ParticularLongValue'; then return UnknownLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.IntegerValue.shiftRightOf(proguard.evaluation.value.ParticularLongValue)"
  })
  void testShiftRightOfWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualShiftRightOfResult =
        unknownIntegerValue.shiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isCategory2());
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRightOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testShiftRightOfWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRightOf(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRightOf(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testShiftRightOfWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.shiftRightOf((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(SpecificLongValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(SpecificLongValue) with 'SpecificLongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.IntegerValue.shiftRightOf(proguard.evaluation.value.SpecificLongValue)"
  })
  void testShiftRightOfWithSpecificLongValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualShiftRightOfResult =
        unknownIntegerValue.shiftRightOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
    assertTrue(actualShiftRightOfResult.isCategory2());
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRightOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testShiftRightOfWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.shiftRightOf(other));
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRightOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testShiftRightOfWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.shiftRightOf(other));
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRightOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testShiftRightOfWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftRightOf(other));
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.shiftRightOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testShiftRightOfWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.shiftRightOf(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(UnknownLongValue)} with {@code UnknownLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(UnknownLongValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(UnknownLongValue) with 'UnknownLongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.IntegerValue.shiftRightOf(proguard.evaluation.value.UnknownLongValue)"
  })
  void testShiftRightOfWithUnknownLongValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();
    UnknownLongValue other = new UnknownLongValue();

    // Act
    LongValue actualShiftRightOfResult = unknownIntegerValue.shiftRightOf(other);

    // Assert
    assertTrue(actualShiftRightOfResult instanceof UnknownLongValue);
    assertEquals(other, actualShiftRightOfResult);
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRightOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testUnsignedShiftRightOfWithParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        ParticularValueFactory.INTEGER_VALUE_0.unsignedShiftRightOf(other);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof ParticularIntegerValue);
    assertEquals(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRightOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testUnsignedShiftRightOfWithParticularIntegerValue2() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        comparisonValue.unsignedShiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRightOf(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testUnsignedShiftRightOfWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.unsignedShiftRightOf(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(ParticularLongValue) with 'ParticularLongValue'; then return CompositeLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.IntegerValue.unsignedShiftRightOf(proguard.evaluation.value.ParticularLongValue)"
  })
  void testUnsignedShiftRightOfWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        comparisonValue.unsignedShiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.IntegerValue.unsignedShiftRightOf(proguard.evaluation.value.ParticularLongValue)"
  })
  void testUnsignedShiftRightOfWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        ParticularValueFactory.INTEGER_VALUE_0.unsignedShiftRightOf(other);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof ParticularLongValue);
    assertEquals(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(ParticularLongValue) with 'ParticularLongValue'; then return UnknownLongValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.IntegerValue.unsignedShiftRightOf(proguard.evaluation.value.ParticularLongValue)"
  })
  void testUnsignedShiftRightOfWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        unknownIntegerValue.unsignedShiftRightOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(RangeIntegerValue)} with {@code
   * RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRightOf(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testUnsignedShiftRightOfWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.unsignedShiftRightOf(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRightOf(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testUnsignedShiftRightOfWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.unsignedShiftRightOf(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(SpecificLongValue)} with {@code
   * SpecificLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(SpecificLongValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(SpecificLongValue) with 'SpecificLongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.IntegerValue.unsignedShiftRightOf(proguard.evaluation.value.SpecificLongValue)"
  })
  void testUnsignedShiftRightOfWithSpecificLongValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    LongValue actualUnsignedShiftRightOfResult =
        unknownIntegerValue.unsignedShiftRightOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
    assertTrue(actualUnsignedShiftRightOfResult.isCategory2());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRightOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testUnsignedShiftRightOfWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.unsignedShiftRightOf(other));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRightOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testUnsignedShiftRightOfWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.unsignedShiftRightOf(other));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRightOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testUnsignedShiftRightOfWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.unsignedShiftRightOf(other));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.unsignedShiftRightOf(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testUnsignedShiftRightOfWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue, unknownIntegerValue.unsignedShiftRightOf(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(UnknownLongValue)} with {@code UnknownLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(UnknownLongValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(UnknownLongValue) with 'UnknownLongValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.IntegerValue.unsignedShiftRightOf(proguard.evaluation.value.UnknownLongValue)"
  })
  void testUnsignedShiftRightOfWithUnknownLongValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();
    UnknownLongValue other = new UnknownLongValue();

    // Act
    LongValue actualUnsignedShiftRightOfResult = unknownIntegerValue.unsignedShiftRightOf(other);

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof UnknownLongValue);
    assertEquals(other, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link IntegerValue#and(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.and(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testAndWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualAndResult = comparisonValue.and(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#and(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.and(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testAndWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.and(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof RangeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#and(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.and(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testAndWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.and(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#and(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#and(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test and(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.and(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testAndWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.and(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#and(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(SpecificIntegerValue) with 'SpecificIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.and(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testAndWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult =
        ParticularValueFactory.INTEGER_VALUE_0.and(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof CompositeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#and(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(SpecificIntegerValue) with 'SpecificIntegerValue'; then return RangeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.and(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testAndWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualAndResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.and(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualAndResult instanceof RangeIntegerValue);
    assertFalse(actualAndResult.isCategory2());
    assertFalse(actualAndResult.isParticular());
    assertFalse(actualAndResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#and(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(SpecificIntegerValue) with 'SpecificIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.and(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testAndWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.and((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#and(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#and(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test and(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.and(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testAndWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.and(other));
  }

  /**
   * Test {@link IntegerValue#and(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test and(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.and(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testAndWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.and(other));
  }

  /**
   * Test {@link IntegerValue#and(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test and(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.and(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testAndWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.and(other));
  }

  /**
   * Test {@link IntegerValue#and(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#and(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test and(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.and(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testAndWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.and(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#or(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.or(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testOrWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualOrResult = comparisonValue.or(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#or(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.or(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testOrWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualOrResult = ParticularValueFactory.INTEGER_VALUE_0.or(other);

    // Assert
    assertTrue(actualOrResult instanceof ParticularIntegerValue);
    assertEquals(other, actualOrResult);
  }

  /**
   * Test {@link IntegerValue#or(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.or(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testOrWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.or(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#or(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#or(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test or(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.or(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testOrWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.or(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#or(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#or(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test or(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.or(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testOrWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.or((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#or(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#or(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test or(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.or(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testOrWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.or(other));
  }

  /**
   * Test {@link IntegerValue#or(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#or(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test or(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.or(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testOrWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.or(other));
  }

  /**
   * Test {@link IntegerValue#or(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#or(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test or(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.or(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testOrWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.or(other));
  }

  /**
   * Test {@link IntegerValue#or(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#or(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.or(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testOrWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.or(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#xor(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#xor(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.xor(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testXorWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualXorResult = comparisonValue.xor(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualXorResult instanceof CompositeIntegerValue);
    assertFalse(actualXorResult.isCategory2());
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#xor(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#xor(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularIntegerValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.xor(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testXorWithParticularIntegerValue_thenReturnParticularIntegerValue() {
    // Arrange
    ParticularIntegerValue other = new ParticularIntegerValue(42);

    // Act
    IntegerValue actualXorResult = ParticularValueFactory.INTEGER_VALUE_0.xor(other);

    // Assert
    assertTrue(actualXorResult instanceof ParticularIntegerValue);
    assertEquals(other, actualXorResult);
  }

  /**
   * Test {@link IntegerValue#xor(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#xor(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.xor(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testXorWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.xor(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#xor(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#xor(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test xor(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.xor(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testXorWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.xor(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#xor(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#xor(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test xor(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.xor(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testXorWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(
        unknownIntegerValue,
        unknownIntegerValue.xor((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#xor(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#xor(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test xor(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.xor(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testXorWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, comparisonValue.xor(other));
  }

  /**
   * Test {@link IntegerValue#xor(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#xor(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test xor(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.xor(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testXorWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, ParticularValueFactory.INTEGER_VALUE_0.xor(other));
  }

  /**
   * Test {@link IntegerValue#xor(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#xor(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test xor(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.xor(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testXorWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act and Assert
    assertSame(other, BasicRangeValueFactory.INTEGER_VALUE_BYTE.xor(other));
  }

  /**
   * Test {@link IntegerValue#xor(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#xor(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test xor(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.xor(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testXorWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.xor(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#equal(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.equal(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testEqualWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#equal(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(ParticularIntegerValue) with 'ParticularIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.equal(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testEqualWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.equal(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.equal(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testEqualWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.equal(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#equal(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#equal(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.equal(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testEqualWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(
        0, unknownIntegerValue.equal((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#equal(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#equal(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.equal(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testEqualWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.equal(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#equal(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#equal(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.equal(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testEqualWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(0, ParticularValueFactory.INTEGER_VALUE_0.equal(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#equal(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#equal(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.equal(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testEqualWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.equal(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#equal(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#equal(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test equal(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.equal(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testEqualWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.equal(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#lessThan(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThan(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testLessThanWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.lessThan(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#lessThan(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThan(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(ParticularIntegerValue) with 'ParticularIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThan(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testLessThanWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThan(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#lessThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThan(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testLessThanWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#lessThan(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThan(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(SpecificIntegerValue) with 'SpecificIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThan(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testLessThanWithSpecificIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.lessThan(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#lessThan(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThan(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(SpecificIntegerValue) with 'SpecificIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThan(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testLessThanWithSpecificIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(
        0, unknownIntegerValue.lessThan((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#lessThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#lessThan(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThan(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testLessThanWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.lessThan(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#lessThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThan(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThan(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testLessThanWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(0, ParticularValueFactory.INTEGER_VALUE_0.lessThan(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#lessThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThan(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThan(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testLessThanWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.lessThan(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#lessThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThan(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThan(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testLessThanWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThan(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThanOrEqual(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testLessThanOrEqualWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.lessThanOrEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(ParticularIntegerValue) with 'ParticularIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThanOrEqual(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testLessThanOrEqualWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThanOrEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThanOrEqual(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testLessThanOrEqualWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(SpecificIntegerValue) with 'SpecificIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThanOrEqual(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testLessThanOrEqualWithSpecificIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.lessThanOrEqual(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(SpecificIntegerValue) with 'SpecificIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThanOrEqual(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testLessThanOrEqualWithSpecificIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(
        0,
        unknownIntegerValue.lessThanOrEqual((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThanOrEqual(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testLessThanOrEqualWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.lessThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThanOrEqual(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testLessThanOrEqualWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(
        0, ParticularValueFactory.INTEGER_VALUE_0.lessThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThanOrEqual(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testLessThanOrEqualWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.lessThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.lessThanOrEqual(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testLessThanOrEqualWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.lessThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#notEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#notEqual(IntegerValue)}
   */
  @Test
  @DisplayName("Test notEqual(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.notEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testNotEqualWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0, (new UnknownIntegerValue()).notEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#notEqual(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#notEqual(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test notEqual(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.notEqual(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testNotEqualWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.notEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#notEqual(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#notEqual(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test notEqual(ParticularIntegerValue) with 'ParticularIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.notEqual(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testNotEqualWithParticularIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.notEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#notEqual(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#notEqual(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test notEqual(ParticularIntegerValue) with 'ParticularIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.notEqual(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testNotEqualWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.notEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#notEqual(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#notEqual(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test notEqual(RangeIntegerValue) with 'RangeIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.notEqual(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testNotEqualWithRangeIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.notEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#notEqual(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#notEqual(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test notEqual(RangeIntegerValue) with 'RangeIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.notEqual(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testNotEqualWithRangeIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.notEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#notEqual(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#notEqual(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test notEqual(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.notEqual(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testNotEqualWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(
        0, unknownIntegerValue.notEqual((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#notEqual(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#notEqual(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test notEqual(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.notEqual(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testNotEqualWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.notEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#notEqual(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#notEqual(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test notEqual(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.notEqual(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testNotEqualWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(0, ParticularValueFactory.INTEGER_VALUE_0.notEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#notEqual(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#notEqual(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test notEqual(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.notEqual(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testNotEqualWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.notEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#notEqual(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#notEqual(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test notEqual(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.notEqual(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testNotEqualWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.notEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#greaterThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(IntegerValue)}
   */
  @Test
  @DisplayName("Test greaterThan(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThan(proguard.evaluation.value.IntegerValue)"
  })
  void testGreaterThanWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ComparisonValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .greaterThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(IntegerValue)}
   */
  @Test
  @DisplayName("Test greaterThan(IntegerValue) with 'IntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThan(proguard.evaluation.value.IntegerValue)"
  })
  void testGreaterThanWithIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ParticularValueFactory.INTEGER_VALUE_0.greaterThan(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(IntegerValue)}
   */
  @Test
  @DisplayName("Test greaterThan(IntegerValue) with 'IntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThan(proguard.evaluation.value.IntegerValue)"
  })
  void testGreaterThanWithIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThan(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThan(IntegerValue) with 'IntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThan(proguard.evaluation.value.IntegerValue)"
  })
  void testGreaterThanWithIntegerValue_givenUnknownIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0, (new UnknownIntegerValue()).greaterThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThan(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test greaterThan(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThan(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testGreaterThanWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.greaterThan(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThan(ParticularIntegerValue) with 'ParticularIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThan(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testGreaterThanWithParticularIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThan(ParticularIntegerValue) with 'ParticularIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThan(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testGreaterThanWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThan(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThan(RangeIntegerValue) with 'RangeIntegerValue'; given INTEGER_VALUE_0; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThan(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testGreaterThanWithRangeIntegerValue_givenInteger_value_0_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        ParticularValueFactory.INTEGER_VALUE_0.greaterThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThan(RangeIntegerValue) with 'RangeIntegerValue'; given INTEGER_VALUE_BYTE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThan(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testGreaterThanWithRangeIntegerValue_givenInteger_value_byte_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThan(RangeIntegerValue) with 'RangeIntegerValue'; given UnknownIntegerValue (default constructor); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThan(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testGreaterThanWithRangeIntegerValue_givenUnknownIntegerValue_thenReturnZero() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThan(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThan(SpecificIntegerValue) with 'SpecificIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThan(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testGreaterThanWithSpecificIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ParticularValueFactory.INTEGER_VALUE_0.greaterThan(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThan(SpecificIntegerValue) with 'SpecificIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThan(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testGreaterThanWithSpecificIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThan(SpecificIntegerValue) with 'SpecificIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThan(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testGreaterThanWithSpecificIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(
        0, unknownIntegerValue.greaterThan((SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test greaterThan(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThan(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testGreaterThanWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.greaterThan(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#greaterThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThan(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThan(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testGreaterThanWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(0, ParticularValueFactory.INTEGER_VALUE_0.greaterThan(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#greaterThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThan(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThan(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testGreaterThanWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#greaterThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThan(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThan(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testGreaterThanWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThan(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName("Test greaterThanOrEqual(IntegerValue) with 'IntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testGreaterThanOrEqualWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new ComparisonValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .greaterThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName("Test greaterThanOrEqual(IntegerValue) with 'IntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testGreaterThanOrEqualWithIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ParticularValueFactory.INTEGER_VALUE_0.greaterThanOrEqual(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThanOrEqual(IntegerValue) with 'IntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testGreaterThanOrEqualWithIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThanOrEqual(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThanOrEqual(IntegerValue) with 'IntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThanOrEqual(proguard.evaluation.value.IntegerValue)"
  })
  void testGreaterThanOrEqualWithIntegerValue_givenUnknownIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        (new UnknownIntegerValue()).greaterThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test greaterThanOrEqual(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThanOrEqual(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testGreaterThanOrEqualWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.greaterThanOrEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThanOrEqual(ParticularIntegerValue) with 'ParticularIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThanOrEqual(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testGreaterThanOrEqualWithParticularIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThanOrEqual(
            new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThanOrEqual(ParticularIntegerValue) with 'ParticularIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThanOrEqual(proguard.evaluation.value.ParticularIntegerValue)"
  })
  void testGreaterThanOrEqualWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThanOrEqual(new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThanOrEqual(RangeIntegerValue) with 'RangeIntegerValue'; given INTEGER_VALUE_0; then return NEVER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThanOrEqual(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testGreaterThanOrEqualWithRangeIntegerValue_givenInteger_value_0_thenReturnNever() {
    // Arrange, Act and Assert
    assertEquals(
        Value.NEVER,
        ParticularValueFactory.INTEGER_VALUE_0.greaterThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThanOrEqual(RangeIntegerValue) with 'RangeIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThanOrEqual(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testGreaterThanOrEqualWithRangeIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThanOrEqual(RangeIntegerValue) with 'RangeIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThanOrEqual(proguard.evaluation.value.RangeIntegerValue)"
  })
  void testGreaterThanOrEqualWithRangeIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThanOrEqual(new RangeIntegerValue(1, 3)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThanOrEqual(SpecificIntegerValue) with 'SpecificIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThanOrEqual(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testGreaterThanOrEqualWithSpecificIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ParticularValueFactory.INTEGER_VALUE_0.greaterThanOrEqual(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThanOrEqual(SpecificIntegerValue) with 'SpecificIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThanOrEqual(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testGreaterThanOrEqualWithSpecificIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThanOrEqual(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThanOrEqual(SpecificIntegerValue) with 'SpecificIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThanOrEqual(proguard.evaluation.value.SpecificIntegerValue)"
  })
  void testGreaterThanOrEqualWithSpecificIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(
        0,
        unknownIntegerValue.greaterThanOrEqual(
            (SpecificIntegerValue) new ParticularIntegerValue(42)));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test greaterThanOrEqual(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThanOrEqual(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testGreaterThanOrEqualWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(0, comparisonValue.greaterThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThanOrEqual(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThanOrEqual(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testGreaterThanOrEqualWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange, Act and Assert
    assertEquals(
        0, ParticularValueFactory.INTEGER_VALUE_0.greaterThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThanOrEqual(UnknownIntegerValue) with 'UnknownIntegerValue'; given INTEGER_VALUE_BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThanOrEqual(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testGreaterThanOrEqualWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange, Act and Assert
    assertEquals(
        0, BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test greaterThanOrEqual(UnknownIntegerValue) with 'UnknownIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.evaluation.value.IntegerValue.greaterThanOrEqual(proguard.evaluation.value.UnknownIntegerValue)"
  })
  void testGreaterThanOrEqualWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertEquals(0, unknownIntegerValue.greaterThanOrEqual(new UnknownIntegerValue()));
  }

  /**
   * Test {@link IntegerValue#integerValue()}.
   *
   * <p>Method under test: {@link IntegerValue#integerValue()}
   */
  @Test
  @DisplayName("Test integerValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.IntegerValue.integerValue()"
  })
  void testIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act and Assert
    assertSame(unknownIntegerValue, unknownIntegerValue.integerValue());
  }

  /**
   * Test {@link IntegerValue#computationalType()}.
   *
   * <p>Method under test: {@link IntegerValue#computationalType()}
   */
  @Test
  @DisplayName("Test computationalType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.evaluation.value.IntegerValue.computationalType()"})
  void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(1, (new UnknownIntegerValue()).computationalType());
  }

  /**
   * Test {@link IntegerValue#internalType()}.
   *
   * <p>Method under test: {@link IntegerValue#internalType()}
   */
  @Test
  @DisplayName("Test internalType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.evaluation.value.IntegerValue.internalType()"})
  void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("I", (new UnknownIntegerValue()).internalType());
  }
}
