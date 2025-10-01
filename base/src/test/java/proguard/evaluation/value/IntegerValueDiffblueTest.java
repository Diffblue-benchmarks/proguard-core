package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.value()"})
  void testValue() {
    // Arrange, Act and Assert
    assertEquals(0, new UnknownIntegerValue().value());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(ParticularIntegerValue)"})
  void testGeneralizeWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualGeneralizeResult =
        unknownIntegerValue.generalize(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualGeneralizeResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(ParticularIntegerValue)"})
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
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(RangeIntegerValue) with 'RangeIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(RangeIntegerValue)"})
  void testGeneralizeWithRangeIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualGeneralizeResult =
        ParticularValueFactory.INTEGER_VALUE_0.generalize(new RangeIntegerValue(1, 3));

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#generalize(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(RangeIntegerValue) with 'RangeIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(RangeIntegerValue)"})
  void testGeneralizeWithRangeIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualGeneralizeResult =
        unknownIntegerValue.generalize(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualGeneralizeResult);
  }

  /**
   * Test {@link IntegerValue#generalize(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(SpecificIntegerValue) with 'SpecificIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(SpecificIntegerValue)"})
  void testGeneralizeWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualGeneralizeResult =
        rangeIntegerValue.generalize((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualGeneralizeResult instanceof RangeIntegerValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#generalize(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(SpecificIntegerValue) with 'SpecificIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(SpecificIntegerValue)"})
  void testGeneralizeWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualGeneralizeResult =
        unknownIntegerValue.generalize((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualGeneralizeResult);
  }

  /**
   * Test {@link IntegerValue#generalize(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#generalize(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test generalize(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(UnknownIntegerValue)"})
  void testGeneralizeWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualGeneralizeResult = comparisonValue.generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(UnknownIntegerValue)"})
  void testGeneralizeWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualGeneralizeResult = ParticularValueFactory.INTEGER_VALUE_0.generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(UnknownIntegerValue)"})
  void testGeneralizeWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualGeneralizeResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.generalize(UnknownIntegerValue)"})
  void testGeneralizeWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualGeneralizeResult = unknownIntegerValue.generalize(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualGeneralizeResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value IntegerValue.generalize(Value)"})
  void testGeneralizeWithValue_givenInteger_value_byte_thenReturnUnknown_value() {
    // Arrange
    UnknownValue other = BasicValueFactory.UNKNOWN_VALUE;

    // Act
    Value actualGeneralizeResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE.generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link IntegerValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#generalize(Value)}
   */
  @Test
  @DisplayName(
      "Test generalize(Value) with 'Value'; when DOUBLE_VALUE; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value IntegerValue.generalize(Value)"})
  void testGeneralizeWithValue_whenDouble_value_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new UnknownIntegerValue().generalize(BasicValueFactory.DOUBLE_VALUE));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value IntegerValue.generalize(Value)"})
  void testGeneralizeWithValue_whenInteger_value_byte_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    Value actualGeneralizeResult =
        unknownIntegerValue.generalize((Value) BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(unknownIntegerValue, actualGeneralizeResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.add(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.add(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.add(ParticularIntegerValue)"})
  void testAddWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualAddResult = unknownIntegerValue.add(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualAddResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.add(RangeIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.add(RangeIntegerValue)"})
  void testAddWithRangeIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualAddResult = unknownIntegerValue.add(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualAddResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.add(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.add(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.add(SpecificIntegerValue)"})
  void testAddWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualAddResult =
        unknownIntegerValue.add((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualAddResult);
  }

  /**
   * Test {@link IntegerValue#add(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#add(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test add(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.add(UnknownIntegerValue)"})
  void testAddWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualAddResult = comparisonValue.add(other);

    // Assert
    assertSame(other, actualAddResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.add(UnknownIntegerValue)"})
  void testAddWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualAddResult = ParticularValueFactory.INTEGER_VALUE_0.add(other);

    // Assert
    assertSame(other, actualAddResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.add(UnknownIntegerValue)"})
  void testAddWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualAddResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE.add(other);

    // Assert
    assertSame(other, actualAddResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.add(UnknownIntegerValue)"})
  void testAddWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualAddResult = unknownIntegerValue.add(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualAddResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(ParticularIntegerValue)"})
  void testSubtractWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualSubtractResult =
        unknownIntegerValue.subtract(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualSubtractResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(RangeIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(RangeIntegerValue)"})
  void testSubtractWithRangeIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualSubtractResult = unknownIntegerValue.subtract(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualSubtractResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(SpecificIntegerValue)"})
  void testSubtractWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualSubtractResult =
        unknownIntegerValue.subtract((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualSubtractResult);
  }

  /**
   * Test {@link IntegerValue#subtract(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#subtract(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test subtract(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(UnknownIntegerValue)"})
  void testSubtractWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualSubtractResult = comparisonValue.subtract(other);

    // Assert
    assertSame(other, actualSubtractResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(UnknownIntegerValue)"})
  void testSubtractWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualSubtractResult = ParticularValueFactory.INTEGER_VALUE_0.subtract(other);

    // Assert
    assertSame(other, actualSubtractResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(UnknownIntegerValue)"})
  void testSubtractWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualSubtractResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtract(other);

    // Assert
    assertSame(other, actualSubtractResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtract(UnknownIntegerValue)"})
  void testSubtractWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualSubtractResult = unknownIntegerValue.subtract(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualSubtractResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(ParticularIntegerValue)"})
  void testSubtractFromWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualSubtractFromResult =
        unknownIntegerValue.subtractFrom(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualSubtractFromResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(RangeIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(RangeIntegerValue)"})
  void testSubtractFromWithRangeIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualSubtractFromResult =
        unknownIntegerValue.subtractFrom(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualSubtractFromResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(SpecificIntegerValue)"})
  void testSubtractFromWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualSubtractFromResult =
        unknownIntegerValue.subtractFrom((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualSubtractFromResult);
  }

  /**
   * Test {@link IntegerValue#subtractFrom(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#subtractFrom(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(UnknownIntegerValue)"})
  void testSubtractFromWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualSubtractFromResult = comparisonValue.subtractFrom(other);

    // Assert
    assertSame(other, actualSubtractFromResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(UnknownIntegerValue)"})
  void testSubtractFromWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualSubtractFromResult =
        ParticularValueFactory.INTEGER_VALUE_0.subtractFrom(other);

    // Assert
    assertSame(other, actualSubtractFromResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(UnknownIntegerValue)"})
  void testSubtractFromWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualSubtractFromResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.subtractFrom(other);

    // Assert
    assertSame(other, actualSubtractFromResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.subtractFrom(UnknownIntegerValue)"})
  void testSubtractFromWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualSubtractFromResult =
        unknownIntegerValue.subtractFrom(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualSubtractFromResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(ParticularIntegerValue)"})
  void testMultiplyWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualMultiplyResult =
        unknownIntegerValue.multiply(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualMultiplyResult);
  }

  /**
   * Test {@link IntegerValue#multiply(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#multiply(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(RangeIntegerValue)"})
  void testMultiplyWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualMultiplyResult = unknownIntegerValue.multiply(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualMultiplyResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(SpecificIntegerValue)"})
  void testMultiplyWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualMultiplyResult =
        unknownIntegerValue.multiply((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualMultiplyResult);
  }

  /**
   * Test {@link IntegerValue#multiply(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#multiply(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test multiply(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(UnknownIntegerValue)"})
  void testMultiplyWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualMultiplyResult = comparisonValue.multiply(other);

    // Assert
    assertSame(other, actualMultiplyResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(UnknownIntegerValue)"})
  void testMultiplyWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualMultiplyResult = ParticularValueFactory.INTEGER_VALUE_0.multiply(other);

    // Assert
    assertSame(other, actualMultiplyResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(UnknownIntegerValue)"})
  void testMultiplyWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualMultiplyResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE.multiply(other);

    // Assert
    assertSame(other, actualMultiplyResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.multiply(UnknownIntegerValue)"})
  void testMultiplyWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualMultiplyResult = unknownIntegerValue.multiply(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualMultiplyResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(ParticularIntegerValue)"})
  void testDivideWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualDivideResult = unknownIntegerValue.divide(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualDivideResult);
  }

  /**
   * Test {@link IntegerValue#divide(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#divide(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test divide(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(RangeIntegerValue)"})
  void testDivideWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualDivideResult = unknownIntegerValue.divide(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualDivideResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(SpecificIntegerValue)"})
  void testDivideWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualDivideResult =
        unknownIntegerValue.divide((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualDivideResult);
  }

  /**
   * Test {@link IntegerValue#divide(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#divide(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test divide(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(UnknownIntegerValue)"})
  void testDivideWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualDivideResult = comparisonValue.divide(other);

    // Assert
    assertSame(other, actualDivideResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(UnknownIntegerValue)"})
  void testDivideWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualDivideResult = ParticularValueFactory.INTEGER_VALUE_0.divide(other);

    // Assert
    assertSame(other, actualDivideResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(UnknownIntegerValue)"})
  void testDivideWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualDivideResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE.divide(other);

    // Assert
    assertSame(other, actualDivideResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divide(UnknownIntegerValue)"})
  void testDivideWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualDivideResult = unknownIntegerValue.divide(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualDivideResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(ParticularIntegerValue)"})
  void testDivideOfWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualDivideOfResult =
        unknownIntegerValue.divideOf(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualDivideOfResult);
  }

  /**
   * Test {@link IntegerValue#divideOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#divideOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(RangeIntegerValue)"})
  void testDivideOfWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualDivideOfResult = unknownIntegerValue.divideOf(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualDivideOfResult);
  }

  /**
   * Test {@link IntegerValue#divideOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divideOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(SpecificIntegerValue) with 'SpecificIntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(SpecificIntegerValue)"})
  void testDivideOfWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualDivideOfResult =
        ParticularValueFactory.INTEGER_VALUE_0.divideOf(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#divideOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divideOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(SpecificIntegerValue) with 'SpecificIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(SpecificIntegerValue)"})
  void testDivideOfWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualDivideOfResult =
        rangeIntegerValue.divideOf((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualDivideOfResult instanceof RangeIntegerValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertFalse(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#divideOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#divideOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(SpecificIntegerValue) with 'SpecificIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(SpecificIntegerValue)"})
  void testDivideOfWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualDivideOfResult =
        unknownIntegerValue.divideOf((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualDivideOfResult);
  }

  /**
   * Test {@link IntegerValue#divideOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#divideOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test divideOf(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(UnknownIntegerValue)"})
  void testDivideOfWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualDivideOfResult = comparisonValue.divideOf(other);

    // Assert
    assertSame(other, actualDivideOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(UnknownIntegerValue)"})
  void testDivideOfWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualDivideOfResult = ParticularValueFactory.INTEGER_VALUE_0.divideOf(other);

    // Assert
    assertSame(other, actualDivideOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(UnknownIntegerValue)"})
  void testDivideOfWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualDivideOfResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE.divideOf(other);

    // Assert
    assertSame(other, actualDivideOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.divideOf(UnknownIntegerValue)"})
  void testDivideOfWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualDivideOfResult = unknownIntegerValue.divideOf(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualDivideOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(ParticularIntegerValue)"})
  void testRemainderWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualRemainderResult =
        unknownIntegerValue.remainder(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualRemainderResult);
  }

  /**
   * Test {@link IntegerValue#remainder(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#remainder(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(RangeIntegerValue)"})
  void testRemainderWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualRemainderResult = unknownIntegerValue.remainder(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualRemainderResult);
  }

  /**
   * Test {@link IntegerValue#remainder(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainder(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(SpecificIntegerValue) with 'SpecificIntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(SpecificIntegerValue)"})
  void testRemainderWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        ParticularValueFactory.INTEGER_VALUE_0.remainder(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#remainder(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainder(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(SpecificIntegerValue) with 'SpecificIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(SpecificIntegerValue)"})
  void testRemainderWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualRemainderResult =
        BasicRangeValueFactory.INTEGER_VALUE_CHAR.remainder(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertFalse(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#remainder(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainder(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(SpecificIntegerValue) with 'SpecificIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(SpecificIntegerValue)"})
  void testRemainderWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualRemainderResult =
        unknownIntegerValue.remainder((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualRemainderResult);
  }

  /**
   * Test {@link IntegerValue#remainder(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#remainder(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test remainder(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(UnknownIntegerValue)"})
  void testRemainderWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualRemainderResult = comparisonValue.remainder(other);

    // Assert
    assertSame(other, actualRemainderResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(UnknownIntegerValue)"})
  void testRemainderWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualRemainderResult = ParticularValueFactory.INTEGER_VALUE_0.remainder(other);

    // Assert
    assertSame(other, actualRemainderResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(UnknownIntegerValue)"})
  void testRemainderWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualRemainderResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE.remainder(other);

    // Assert
    assertSame(other, actualRemainderResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainder(UnknownIntegerValue)"})
  void testRemainderWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualRemainderResult = unknownIntegerValue.remainder(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualRemainderResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(ParticularIntegerValue)"})
  void testRemainderOfWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualRemainderOfResult =
        unknownIntegerValue.remainderOf(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualRemainderOfResult);
  }

  /**
   * Test {@link IntegerValue#remainderOf(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(RangeIntegerValue)"})
  void testRemainderOfWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualRemainderOfResult =
        unknownIntegerValue.remainderOf(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualRemainderOfResult);
  }

  /**
   * Test {@link IntegerValue#remainderOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(SpecificIntegerValue) with 'SpecificIntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(SpecificIntegerValue)"})
  void testRemainderOfWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualRemainderOfResult =
        ParticularValueFactory.INTEGER_VALUE_0.remainderOf(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#remainderOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(SpecificIntegerValue) with 'SpecificIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(SpecificIntegerValue)"})
  void testRemainderOfWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualRemainderOfResult =
        rangeIntegerValue.remainderOf((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualRemainderOfResult instanceof RangeIntegerValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertFalse(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#remainderOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(SpecificIntegerValue) with 'SpecificIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(SpecificIntegerValue)"})
  void testRemainderOfWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualRemainderOfResult =
        unknownIntegerValue.remainderOf((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualRemainderOfResult);
  }

  /**
   * Test {@link IntegerValue#remainderOf(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#remainderOf(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test remainderOf(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(UnknownIntegerValue)"})
  void testRemainderOfWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualRemainderOfResult = comparisonValue.remainderOf(other);

    // Assert
    assertSame(other, actualRemainderOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(UnknownIntegerValue)"})
  void testRemainderOfWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualRemainderOfResult =
        ParticularValueFactory.INTEGER_VALUE_0.remainderOf(other);

    // Assert
    assertSame(other, actualRemainderOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(UnknownIntegerValue)"})
  void testRemainderOfWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualRemainderOfResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.remainderOf(other);

    // Assert
    assertSame(other, actualRemainderOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.remainderOf(UnknownIntegerValue)"})
  void testRemainderOfWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualRemainderOfResult =
        unknownIntegerValue.remainderOf(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualRemainderOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(ParticularIntegerValue)"})
  void testShiftLeftWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftLeftResult =
        unknownIntegerValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualShiftLeftResult);
  }

  /**
   * Test {@link IntegerValue#shiftLeft(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(RangeIntegerValue)"})
  void testShiftLeftWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftLeftResult = unknownIntegerValue.shiftLeft(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualShiftLeftResult);
  }

  /**
   * Test {@link IntegerValue#shiftLeft(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(SpecificIntegerValue) with 'SpecificIntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(SpecificIntegerValue)"})
  void testShiftLeftWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult =
        ParticularValueFactory.INTEGER_VALUE_0.shiftLeft(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftLeft(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(SpecificIntegerValue) with 'SpecificIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(SpecificIntegerValue)"})
  void testShiftLeftWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftLeftResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftLeft(
            (SpecificIntegerValue) new ParticularIntegerValue(1));

    // Assert
    assertTrue(actualShiftLeftResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftResult.isCategory2());
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftLeft(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(SpecificIntegerValue) with 'SpecificIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(SpecificIntegerValue)"})
  void testShiftLeftWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftLeftResult =
        unknownIntegerValue.shiftLeft((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualShiftLeftResult);
  }

  /**
   * Test {@link IntegerValue#shiftLeft(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeft(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(UnknownIntegerValue)"})
  void testShiftLeftWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftLeftResult = comparisonValue.shiftLeft(other);

    // Assert
    assertSame(other, actualShiftLeftResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(UnknownIntegerValue)"})
  void testShiftLeftWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftLeftResult = ParticularValueFactory.INTEGER_VALUE_0.shiftLeft(other);

    // Assert
    assertSame(other, actualShiftLeftResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(UnknownIntegerValue)"})
  void testShiftLeftWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftLeftResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftLeft(other);

    // Assert
    assertSame(other, actualShiftLeftResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeft(UnknownIntegerValue)"})
  void testShiftLeftWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftLeftResult = unknownIntegerValue.shiftLeft(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualShiftLeftResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(ParticularIntegerValue)"})
  void testShiftRightWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftRightResult =
        unknownIntegerValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualShiftRightResult);
  }

  /**
   * Test {@link IntegerValue#shiftRight(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(RangeIntegerValue)"})
  void testShiftRightWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftRightResult =
        unknownIntegerValue.shiftRight(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualShiftRightResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(SpecificIntegerValue)"})
  void testShiftRightWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftRightResult =
        unknownIntegerValue.shiftRight((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualShiftRightResult);
  }

  /**
   * Test {@link IntegerValue#shiftRight(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRight(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(UnknownIntegerValue)"})
  void testShiftRightWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftRightResult = comparisonValue.shiftRight(other);

    // Assert
    assertSame(other, actualShiftRightResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(UnknownIntegerValue)"})
  void testShiftRightWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftRightResult = ParticularValueFactory.INTEGER_VALUE_0.shiftRight(other);

    // Assert
    assertSame(other, actualShiftRightResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(UnknownIntegerValue)"})
  void testShiftRightWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftRightResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftRight(other);

    // Assert
    assertSame(other, actualShiftRightResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRight(UnknownIntegerValue)"})
  void testShiftRightWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftRightResult = unknownIntegerValue.shiftRight(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualShiftRightResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(ParticularIntegerValue)"})
  void testUnsignedShiftRightWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        unknownIntegerValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualUnsignedShiftRightResult);
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(RangeIntegerValue)"})
  void testUnsignedShiftRightWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        unknownIntegerValue.unsignedShiftRight(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualUnsignedShiftRightResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(SpecificIntegerValue)"})
  void testUnsignedShiftRightWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        unknownIntegerValue.unsignedShiftRight(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualUnsignedShiftRightResult);
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRight(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(UnknownIntegerValue)"})
  void testUnsignedShiftRightWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualUnsignedShiftRightResult = comparisonValue.unsignedShiftRight(other);

    // Assert
    assertSame(other, actualUnsignedShiftRightResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(UnknownIntegerValue)"})
  void testUnsignedShiftRightWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        ParticularValueFactory.INTEGER_VALUE_0.unsignedShiftRight(other);

    // Assert
    assertSame(other, actualUnsignedShiftRightResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(UnknownIntegerValue)"})
  void testUnsignedShiftRightWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.unsignedShiftRight(other);

    // Assert
    assertSame(other, actualUnsignedShiftRightResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRight(UnknownIntegerValue)"})
  void testUnsignedShiftRightWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualUnsignedShiftRightResult =
        unknownIntegerValue.unsignedShiftRight(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualUnsignedShiftRightResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(ParticularIntegerValue)"})
  void testShiftLeftOfWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftLeftOfResult =
        unknownIntegerValue.shiftLeftOf(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualShiftLeftOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue IntegerValue.shiftLeftOf(ParticularLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue IntegerValue.shiftLeftOf(ParticularLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue IntegerValue.shiftLeftOf(ParticularLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(RangeIntegerValue)"})
  void testShiftLeftOfWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftLeftOfResult =
        unknownIntegerValue.shiftLeftOf(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualShiftLeftOfResult);
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(SpecificIntegerValue) with 'SpecificIntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(SpecificIntegerValue)"})
  void testShiftLeftOfWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftLeftOfResult =
        ParticularValueFactory.INTEGER_VALUE_0.shiftLeftOf(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertTrue(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(SpecificIntegerValue) with 'SpecificIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(SpecificIntegerValue)"})
  void testShiftLeftOfWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftLeftOfResult =
        rangeIntegerValue.shiftLeftOf((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftLeftOfResult.isCategory2());
    assertFalse(actualShiftLeftOfResult.isParticular());
    assertFalse(actualShiftLeftOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeftOf(SpecificIntegerValue) with 'SpecificIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(SpecificIntegerValue)"})
  void testShiftLeftOfWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftLeftOfResult =
        unknownIntegerValue.shiftLeftOf((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualShiftLeftOfResult);
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(SpecificLongValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(SpecificLongValue) with 'SpecificLongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue IntegerValue.shiftLeftOf(SpecificLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(UnknownIntegerValue)"})
  void testShiftLeftOfWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftLeftOfResult = comparisonValue.shiftLeftOf(other);

    // Assert
    assertSame(other, actualShiftLeftOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(UnknownIntegerValue)"})
  void testShiftLeftOfWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftLeftOfResult =
        ParticularValueFactory.INTEGER_VALUE_0.shiftLeftOf(other);

    // Assert
    assertSame(other, actualShiftLeftOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(UnknownIntegerValue)"})
  void testShiftLeftOfWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftLeftOfResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftLeftOf(other);

    // Assert
    assertSame(other, actualShiftLeftOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftLeftOf(UnknownIntegerValue)"})
  void testShiftLeftOfWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftLeftOfResult =
        unknownIntegerValue.shiftLeftOf(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualShiftLeftOfResult);
  }

  /**
   * Test {@link IntegerValue#shiftLeftOf(UnknownLongValue)} with {@code UnknownLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftLeftOf(UnknownLongValue)}
   */
  @Test
  @DisplayName("Test shiftLeftOf(UnknownLongValue) with 'UnknownLongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue IntegerValue.shiftLeftOf(UnknownLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(ParticularIntegerValue)"})
  void testShiftRightOfWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftRightOfResult =
        unknownIntegerValue.shiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualShiftRightOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue IntegerValue.shiftRightOf(ParticularLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue IntegerValue.shiftRightOf(ParticularLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue IntegerValue.shiftRightOf(ParticularLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(RangeIntegerValue)"})
  void testShiftRightOfWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftRightOfResult =
        unknownIntegerValue.shiftRightOf(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualShiftRightOfResult);
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(SpecificIntegerValue) with 'SpecificIntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(SpecificIntegerValue)"})
  void testShiftRightOfWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualShiftRightOfResult =
        ParticularValueFactory.INTEGER_VALUE_0.shiftRightOf(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertTrue(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(SpecificIntegerValue) with 'SpecificIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(SpecificIntegerValue)"})
  void testShiftRightOfWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualShiftRightOfResult =
        rangeIntegerValue.shiftRightOf((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualShiftRightOfResult.isCategory2());
    assertFalse(actualShiftRightOfResult.isParticular());
    assertFalse(actualShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRightOf(SpecificIntegerValue) with 'SpecificIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(SpecificIntegerValue)"})
  void testShiftRightOfWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftRightOfResult =
        unknownIntegerValue.shiftRightOf((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualShiftRightOfResult);
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(SpecificLongValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(SpecificLongValue) with 'SpecificLongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue IntegerValue.shiftRightOf(SpecificLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(UnknownIntegerValue)"})
  void testShiftRightOfWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftRightOfResult = comparisonValue.shiftRightOf(other);

    // Assert
    assertSame(other, actualShiftRightOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(UnknownIntegerValue)"})
  void testShiftRightOfWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftRightOfResult =
        ParticularValueFactory.INTEGER_VALUE_0.shiftRightOf(other);

    // Assert
    assertSame(other, actualShiftRightOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(UnknownIntegerValue)"})
  void testShiftRightOfWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftRightOfResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.shiftRightOf(other);

    // Assert
    assertSame(other, actualShiftRightOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.shiftRightOf(UnknownIntegerValue)"})
  void testShiftRightOfWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualShiftRightOfResult =
        unknownIntegerValue.shiftRightOf(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualShiftRightOfResult);
  }

  /**
   * Test {@link IntegerValue#shiftRightOf(UnknownLongValue)} with {@code UnknownLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#shiftRightOf(UnknownLongValue)}
   */
  @Test
  @DisplayName("Test shiftRightOf(UnknownLongValue) with 'UnknownLongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue IntegerValue.shiftRightOf(UnknownLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(ParticularIntegerValue)"})
  void testUnsignedShiftRightOfWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        unknownIntegerValue.unsignedShiftRightOf(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualUnsignedShiftRightOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue IntegerValue.unsignedShiftRightOf(ParticularLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue IntegerValue.unsignedShiftRightOf(ParticularLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue IntegerValue.unsignedShiftRightOf(ParticularLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(RangeIntegerValue)"})
  void testUnsignedShiftRightOfWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        unknownIntegerValue.unsignedShiftRightOf(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(SpecificIntegerValue) with 'SpecificIntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(SpecificIntegerValue)"})
  void testUnsignedShiftRightOfWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualUnsignedShiftRightOfResult =
        ParticularValueFactory.INTEGER_VALUE_0.unsignedShiftRightOf(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof CompositeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertTrue(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(SpecificIntegerValue) with 'SpecificIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(SpecificIntegerValue)"})
  void testUnsignedShiftRightOfWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange
    RangeIntegerValue rangeIntegerValue = new RangeIntegerValue(1, 3);

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        rangeIntegerValue.unsignedShiftRightOf(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightOfResult instanceof RangeIntegerValue);
    assertFalse(actualUnsignedShiftRightOfResult.isCategory2());
    assertFalse(actualUnsignedShiftRightOfResult.isParticular());
    assertFalse(actualUnsignedShiftRightOfResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(SpecificIntegerValue)} with {@code
   * SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRightOf(SpecificIntegerValue) with 'SpecificIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(SpecificIntegerValue)"})
  void testUnsignedShiftRightOfWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        unknownIntegerValue.unsignedShiftRightOf(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(SpecificLongValue)} with {@code
   * SpecificLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(SpecificLongValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(SpecificLongValue) with 'SpecificLongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue IntegerValue.unsignedShiftRightOf(SpecificLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(UnknownIntegerValue)"})
  void testUnsignedShiftRightOfWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualUnsignedShiftRightOfResult = comparisonValue.unsignedShiftRightOf(other);

    // Assert
    assertSame(other, actualUnsignedShiftRightOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(UnknownIntegerValue)"})
  void testUnsignedShiftRightOfWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        ParticularValueFactory.INTEGER_VALUE_0.unsignedShiftRightOf(other);

    // Assert
    assertSame(other, actualUnsignedShiftRightOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(UnknownIntegerValue)"})
  void testUnsignedShiftRightOfWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.unsignedShiftRightOf(other);

    // Assert
    assertSame(other, actualUnsignedShiftRightOfResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.unsignedShiftRightOf(UnknownIntegerValue)"})
  void testUnsignedShiftRightOfWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualUnsignedShiftRightOfResult =
        unknownIntegerValue.unsignedShiftRightOf(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualUnsignedShiftRightOfResult);
  }

  /**
   * Test {@link IntegerValue#unsignedShiftRightOf(UnknownLongValue)} with {@code UnknownLongValue}.
   *
   * <p>Method under test: {@link IntegerValue#unsignedShiftRightOf(UnknownLongValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRightOf(UnknownLongValue) with 'UnknownLongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue IntegerValue.unsignedShiftRightOf(UnknownLongValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.and(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.and(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.and(ParticularIntegerValue)"})
  void testAndWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualAndResult = unknownIntegerValue.and(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualAndResult);
  }

  /**
   * Test {@link IntegerValue#and(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#and(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test and(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.and(RangeIntegerValue)"})
  void testAndWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualAndResult = unknownIntegerValue.and(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualAndResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.and(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.and(SpecificIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.and(SpecificIntegerValue)"})
  void testAndWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualAndResult =
        unknownIntegerValue.and((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualAndResult);
  }

  /**
   * Test {@link IntegerValue#and(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#and(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test and(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.and(UnknownIntegerValue)"})
  void testAndWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualAndResult = comparisonValue.and(other);

    // Assert
    assertSame(other, actualAndResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.and(UnknownIntegerValue)"})
  void testAndWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualAndResult = ParticularValueFactory.INTEGER_VALUE_0.and(other);

    // Assert
    assertSame(other, actualAndResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.and(UnknownIntegerValue)"})
  void testAndWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualAndResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE.and(other);

    // Assert
    assertSame(other, actualAndResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.and(UnknownIntegerValue)"})
  void testAndWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualAndResult = unknownIntegerValue.and(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualAndResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.or(ParticularIntegerValue)"})
  void testOrWithParticularIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    IntegerValue actualOrResult = comparisonValue.or(new ParticularIntegerValue(Integer.MIN_VALUE));

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
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#or(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(ParticularIntegerValue) with 'ParticularIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.or(ParticularIntegerValue)"})
  void testOrWithParticularIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualOrResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.or(new ParticularIntegerValue(Integer.MIN_VALUE));

    // Assert
    assertTrue(actualOrResult instanceof RangeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.or(ParticularIntegerValue)"})
  void testOrWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualOrResult = unknownIntegerValue.or(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualOrResult);
  }

  /**
   * Test {@link IntegerValue#or(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#or(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test or(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.or(RangeIntegerValue)"})
  void testOrWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualOrResult = unknownIntegerValue.or(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualOrResult);
  }

  /**
   * Test {@link IntegerValue#or(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#or(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(SpecificIntegerValue) with 'SpecificIntegerValue'; then return CompositeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.or(SpecificIntegerValue)"})
  void testOrWithSpecificIntegerValue_thenReturnCompositeIntegerValue() {
    // Arrange and Act
    IntegerValue actualOrResult =
        ParticularValueFactory.INTEGER_VALUE_0.or(
            (SpecificIntegerValue) new ParticularIntegerValue(Integer.MIN_VALUE));

    // Assert
    assertTrue(actualOrResult instanceof CompositeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#or(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#or(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(SpecificIntegerValue) with 'SpecificIntegerValue'; then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.or(SpecificIntegerValue)"})
  void testOrWithSpecificIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualOrResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.or(
            (SpecificIntegerValue) new ParticularIntegerValue(Integer.MIN_VALUE));

    // Assert
    assertTrue(actualOrResult instanceof RangeIntegerValue);
    assertFalse(actualOrResult.isCategory2());
    assertFalse(actualOrResult.isParticular());
    assertFalse(actualOrResult.isSpecific());
  }

  /**
   * Test {@link IntegerValue#or(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#or(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test or(SpecificIntegerValue) with 'SpecificIntegerValue'; then return UnknownIntegerValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.or(SpecificIntegerValue)"})
  void testOrWithSpecificIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualOrResult =
        unknownIntegerValue.or((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualOrResult);
  }

  /**
   * Test {@link IntegerValue#or(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#or(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test or(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.or(UnknownIntegerValue)"})
  void testOrWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualOrResult = comparisonValue.or(other);

    // Assert
    assertSame(other, actualOrResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.or(UnknownIntegerValue)"})
  void testOrWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualOrResult = ParticularValueFactory.INTEGER_VALUE_0.or(other);

    // Assert
    assertSame(other, actualOrResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.or(UnknownIntegerValue)"})
  void testOrWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualOrResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE.or(other);

    // Assert
    assertSame(other, actualOrResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.or(UnknownIntegerValue)"})
  void testOrWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualOrResult = unknownIntegerValue.or(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualOrResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(ParticularIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(ParticularIntegerValue)"})
  void testXorWithParticularIntegerValue_thenReturnUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualXorResult = unknownIntegerValue.xor(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualXorResult);
  }

  /**
   * Test {@link IntegerValue#xor(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#xor(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test xor(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(RangeIntegerValue)"})
  void testXorWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualXorResult = unknownIntegerValue.xor(new RangeIntegerValue(1, 3));

    // Assert
    assertSame(unknownIntegerValue, actualXorResult);
  }

  /**
   * Test {@link IntegerValue#xor(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#xor(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test xor(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(SpecificIntegerValue)"})
  void testXorWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualXorResult =
        unknownIntegerValue.xor((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownIntegerValue, actualXorResult);
  }

  /**
   * Test {@link IntegerValue#xor(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#xor(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test xor(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(UnknownIntegerValue)"})
  void testXorWithUnknownIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualXorResult = comparisonValue.xor(other);

    // Assert
    assertSame(other, actualXorResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(UnknownIntegerValue)"})
  void testXorWithUnknownIntegerValue_givenInteger_value_0() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualXorResult = ParticularValueFactory.INTEGER_VALUE_0.xor(other);

    // Assert
    assertSame(other, actualXorResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(UnknownIntegerValue)"})
  void testXorWithUnknownIntegerValue_givenInteger_value_byte() {
    // Arrange
    UnknownIntegerValue other = new UnknownIntegerValue();

    // Act
    IntegerValue actualXorResult = BasicRangeValueFactory.INTEGER_VALUE_BYTE.xor(other);

    // Assert
    assertSame(other, actualXorResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.xor(UnknownIntegerValue)"})
  void testXorWithUnknownIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualXorResult = unknownIntegerValue.xor(new UnknownIntegerValue());

    // Assert
    assertSame(unknownIntegerValue, actualXorResult);
  }

  /**
   * Test {@link IntegerValue#equal(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#equal(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.equal(ParticularIntegerValue)"})
  void testEqualWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    int actualEqualResult = comparisonValue.equal(new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.equal(ParticularIntegerValue)"})
  void testEqualWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualEqualResult = unknownIntegerValue.equal(new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link IntegerValue#equal(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#equal(RangeIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(RangeIntegerValue) with 'RangeIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.equal(RangeIntegerValue)"})
  void testEqualWithRangeIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualEqualResult = unknownIntegerValue.equal(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link IntegerValue#equal(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#equal(SpecificIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(SpecificIntegerValue) with 'SpecificIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.equal(SpecificIntegerValue)"})
  void testEqualWithSpecificIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualEqualResult =
        unknownIntegerValue.equal((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualEqualResult);
  }

  /**
   * Test {@link IntegerValue#equal(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#equal(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test equal(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.equal(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.equal(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.equal(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.equal(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThan(ParticularIntegerValue)"})
  void testLessThanWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    int actualLessThanResult = comparisonValue.lessThan(new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualLessThanResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThan(ParticularIntegerValue)"})
  void testLessThanWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualLessThanResult = unknownIntegerValue.lessThan(new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualLessThanResult);
  }

  /**
   * Test {@link IntegerValue#lessThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(RangeIntegerValue) with 'RangeIntegerValue'; given INTEGER_VALUE_0; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThan(RangeIntegerValue)"})
  void testLessThanWithRangeIntegerValue_givenInteger_value_0_thenReturnOne() {
    // Arrange and Act
    int actualLessThanResult =
        ParticularValueFactory.INTEGER_VALUE_0.lessThan(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(1, actualLessThanResult);
  }

  /**
   * Test {@link IntegerValue#lessThan(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThan(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThan(RangeIntegerValue) with 'RangeIntegerValue'; given UnknownIntegerValue (default constructor); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThan(RangeIntegerValue)"})
  void testLessThanWithRangeIntegerValue_givenUnknownIntegerValue_thenReturnZero() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualLessThanResult = unknownIntegerValue.lessThan(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(0, actualLessThanResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThan(SpecificIntegerValue)"})
  void testLessThanWithSpecificIntegerValue_givenInteger_value_byte() {
    // Arrange and Act
    int actualLessThanResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.lessThan(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualLessThanResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThan(SpecificIntegerValue)"})
  void testLessThanWithSpecificIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualLessThanResult =
        unknownIntegerValue.lessThan((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualLessThanResult);
  }

  /**
   * Test {@link IntegerValue#lessThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#lessThan(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThan(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThan(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThan(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThan(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThan(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(ParticularIntegerValue)"})
  void testLessThanOrEqualWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    int actualLessThanOrEqualResult =
        comparisonValue.lessThanOrEqual(new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualLessThanOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(ParticularIntegerValue)"})
  void testLessThanOrEqualWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualLessThanOrEqualResult =
        unknownIntegerValue.lessThanOrEqual(new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualLessThanOrEqualResult);
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(RangeIntegerValue) with 'RangeIntegerValue'; given INTEGER_VALUE_0; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(RangeIntegerValue)"})
  void testLessThanOrEqualWithRangeIntegerValue_givenInteger_value_0_thenReturnOne() {
    // Arrange and Act
    int actualLessThanOrEqualResult =
        ParticularValueFactory.INTEGER_VALUE_0.lessThanOrEqual(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(1, actualLessThanOrEqualResult);
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(RangeIntegerValue)} with {@code RangeIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(RangeIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test lessThanOrEqual(RangeIntegerValue) with 'RangeIntegerValue'; given UnknownIntegerValue (default constructor); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(RangeIntegerValue)"})
  void testLessThanOrEqualWithRangeIntegerValue_givenUnknownIntegerValue_thenReturnZero() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualLessThanOrEqualResult =
        unknownIntegerValue.lessThanOrEqual(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(0, actualLessThanOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(SpecificIntegerValue)"})
  void testLessThanOrEqualWithSpecificIntegerValue_givenInteger_value_byte() {
    // Arrange and Act
    int actualLessThanOrEqualResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.lessThanOrEqual(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualLessThanOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(SpecificIntegerValue)"})
  void testLessThanOrEqualWithSpecificIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualLessThanOrEqualResult =
        unknownIntegerValue.lessThanOrEqual((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualLessThanOrEqualResult);
  }

  /**
   * Test {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#lessThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test lessThanOrEqual(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.lessThanOrEqual(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.notEqual(IntegerValue)"})
  void testNotEqualWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new ComparisonValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .notEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#notEqual(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#notEqual(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test notEqual(IntegerValue) with 'IntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.notEqual(IntegerValue)"})
  void testNotEqualWithIntegerValue_givenUnknownIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(0, new UnknownIntegerValue().notEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#notEqual(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#notEqual(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test notEqual(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.notEqual(ParticularIntegerValue)"})
  void testNotEqualWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    int actualNotEqualResult = comparisonValue.notEqual(new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualNotEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.notEqual(ParticularIntegerValue)"})
  void testNotEqualWithParticularIntegerValue_givenInteger_value_byte() {
    // Arrange and Act
    int actualNotEqualResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.notEqual(new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualNotEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.notEqual(ParticularIntegerValue)"})
  void testNotEqualWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualNotEqualResult = unknownIntegerValue.notEqual(new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualNotEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.notEqual(RangeIntegerValue)"})
  void testNotEqualWithRangeIntegerValue_givenInteger_value_byte() {
    // Arrange and Act
    int actualNotEqualResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.notEqual(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(0, actualNotEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.notEqual(RangeIntegerValue)"})
  void testNotEqualWithRangeIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualNotEqualResult = unknownIntegerValue.notEqual(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(0, actualNotEqualResult);
  }

  /**
   * Test {@link IntegerValue#notEqual(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#notEqual(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test notEqual(SpecificIntegerValue) with 'SpecificIntegerValue'; given INTEGER_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.notEqual(SpecificIntegerValue)"})
  void testNotEqualWithSpecificIntegerValue_givenInteger_value_0() {
    // Arrange and Act
    int actualNotEqualResult =
        ParticularValueFactory.INTEGER_VALUE_0.notEqual(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualNotEqualResult);
  }

  /**
   * Test {@link IntegerValue#notEqual(SpecificIntegerValue)} with {@code SpecificIntegerValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownIntegerValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link IntegerValue#notEqual(SpecificIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test notEqual(SpecificIntegerValue) with 'SpecificIntegerValue'; given UnknownIntegerValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.notEqual(SpecificIntegerValue)"})
  void testNotEqualWithSpecificIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualNotEqualResult =
        unknownIntegerValue.notEqual((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualNotEqualResult);
  }

  /**
   * Test {@link IntegerValue#notEqual(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#notEqual(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test notEqual(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.notEqual(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.notEqual(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.notEqual(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.notEqual(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThan(IntegerValue)"})
  void testGreaterThanWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new ComparisonValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThan(IntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThan(IntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThan(IntegerValue)"})
  void testGreaterThanWithIntegerValue_givenUnknownIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0, new UnknownIntegerValue().greaterThan(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThan(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test greaterThan(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThan(ParticularIntegerValue)"})
  void testGreaterThanWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    int actualGreaterThanResult = comparisonValue.greaterThan(new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualGreaterThanResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThan(ParticularIntegerValue)"})
  void testGreaterThanWithParticularIntegerValue_givenInteger_value_byte() {
    // Arrange and Act
    int actualGreaterThanResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan(new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualGreaterThanResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThan(ParticularIntegerValue)"})
  void testGreaterThanWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualGreaterThanResult = unknownIntegerValue.greaterThan(new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualGreaterThanResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThan(RangeIntegerValue)"})
  void testGreaterThanWithRangeIntegerValue_givenInteger_value_0_thenReturnNever() {
    // Arrange and Act
    int actualGreaterThanResult =
        ParticularValueFactory.INTEGER_VALUE_0.greaterThan(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(Value.NEVER, actualGreaterThanResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThan(RangeIntegerValue)"})
  void testGreaterThanWithRangeIntegerValue_givenInteger_value_byte_thenReturnZero() {
    // Arrange and Act
    int actualGreaterThanResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(0, actualGreaterThanResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThan(RangeIntegerValue)"})
  void testGreaterThanWithRangeIntegerValue_givenUnknownIntegerValue_thenReturnZero() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualGreaterThanResult = unknownIntegerValue.greaterThan(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(0, actualGreaterThanResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThan(SpecificIntegerValue)"})
  void testGreaterThanWithSpecificIntegerValue_givenInteger_value_0() {
    // Arrange and Act
    int actualGreaterThanResult =
        ParticularValueFactory.INTEGER_VALUE_0.greaterThan(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualGreaterThanResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThan(SpecificIntegerValue)"})
  void testGreaterThanWithSpecificIntegerValue_givenInteger_value_byte() {
    // Arrange and Act
    int actualGreaterThanResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThan(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualGreaterThanResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThan(SpecificIntegerValue)"})
  void testGreaterThanWithSpecificIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualGreaterThanResult =
        unknownIntegerValue.greaterThan((SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualGreaterThanResult);
  }

  /**
   * Test {@link IntegerValue#greaterThan(UnknownIntegerValue)} with {@code UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#greaterThan(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test greaterThan(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThan(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThan(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThan(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThan(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(IntegerValue)"})
  void testGreaterThanOrEqualWithIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new ComparisonValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(IntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(IntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(IntegerValue)"})
  void testGreaterThanOrEqualWithIntegerValue_givenUnknownIntegerValue() {
    // Arrange, Act and Assert
    assertEquals(
        0, new UnknownIntegerValue().greaterThanOrEqual(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(ParticularIntegerValue)}
   */
  @Test
  @DisplayName("Test greaterThanOrEqual(ParticularIntegerValue) with 'ParticularIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(ParticularIntegerValue)"})
  void testGreaterThanOrEqualWithParticularIntegerValue() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    int actualGreaterThanOrEqualResult =
        comparisonValue.greaterThanOrEqual(new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualGreaterThanOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(ParticularIntegerValue)"})
  void testGreaterThanOrEqualWithParticularIntegerValue_givenInteger_value_byte() {
    // Arrange and Act
    int actualGreaterThanOrEqualResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThanOrEqual(
            new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualGreaterThanOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(ParticularIntegerValue)"})
  void testGreaterThanOrEqualWithParticularIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualGreaterThanOrEqualResult =
        unknownIntegerValue.greaterThanOrEqual(new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualGreaterThanOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(RangeIntegerValue)"})
  void testGreaterThanOrEqualWithRangeIntegerValue_givenInteger_value_0_thenReturnNever() {
    // Arrange and Act
    int actualGreaterThanOrEqualResult =
        ParticularValueFactory.INTEGER_VALUE_0.greaterThanOrEqual(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(Value.NEVER, actualGreaterThanOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(RangeIntegerValue)"})
  void testGreaterThanOrEqualWithRangeIntegerValue_givenInteger_value_byte() {
    // Arrange and Act
    int actualGreaterThanOrEqualResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThanOrEqual(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(0, actualGreaterThanOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(RangeIntegerValue)"})
  void testGreaterThanOrEqualWithRangeIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualGreaterThanOrEqualResult =
        unknownIntegerValue.greaterThanOrEqual(new RangeIntegerValue(1, 3));

    // Assert
    assertEquals(0, actualGreaterThanOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(SpecificIntegerValue)"})
  void testGreaterThanOrEqualWithSpecificIntegerValue_givenInteger_value_0() {
    // Arrange and Act
    int actualGreaterThanOrEqualResult =
        ParticularValueFactory.INTEGER_VALUE_0.greaterThanOrEqual(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualGreaterThanOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(SpecificIntegerValue)"})
  void testGreaterThanOrEqualWithSpecificIntegerValue_givenInteger_value_byte() {
    // Arrange and Act
    int actualGreaterThanOrEqualResult =
        BasicRangeValueFactory.INTEGER_VALUE_BYTE.greaterThanOrEqual(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualGreaterThanOrEqualResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(SpecificIntegerValue)"})
  void testGreaterThanOrEqualWithSpecificIntegerValue_givenUnknownIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    int actualGreaterThanOrEqualResult =
        unknownIntegerValue.greaterThanOrEqual(
            (SpecificIntegerValue) new ParticularIntegerValue(42));

    // Assert
    assertEquals(0, actualGreaterThanOrEqualResult);
  }

  /**
   * Test {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)} with {@code
   * UnknownIntegerValue}.
   *
   * <p>Method under test: {@link IntegerValue#greaterThanOrEqual(UnknownIntegerValue)}
   */
  @Test
  @DisplayName("Test greaterThanOrEqual(UnknownIntegerValue) with 'UnknownIntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.greaterThanOrEqual(UnknownIntegerValue)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue IntegerValue.integerValue()"})
  void testIntegerValue() {
    // Arrange
    UnknownIntegerValue unknownIntegerValue = new UnknownIntegerValue();

    // Act
    IntegerValue actualIntegerValueResult = unknownIntegerValue.integerValue();

    // Assert
    assertSame(unknownIntegerValue, actualIntegerValueResult);
  }

  /**
   * Test {@link IntegerValue#computationalType()}.
   *
   * <p>Method under test: {@link IntegerValue#computationalType()}
   */
  @Test
  @DisplayName("Test computationalType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int IntegerValue.computationalType()"})
  void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(1, new UnknownIntegerValue().computationalType());
  }

  /**
   * Test {@link IntegerValue#internalType()}.
   *
   * <p>Method under test: {@link IntegerValue#internalType()}
   */
  @Test
  @DisplayName("Test internalType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String IntegerValue.internalType()"})
  void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("I", new UnknownIntegerValue().internalType());
  }
}
