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

class FloatValueDiffblueTest {
  /**
   * Test {@link FloatValue#value()}.
   *
   * <p>Method under test: {@link FloatValue#value()}
   */
  @Test
  @DisplayName("Test value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float FloatValue.value()"})
  void testValue() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new UnknownFloatValue().value());
  }

  /**
   * Test {@link FloatValue#generalize(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#generalize(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularFloatValue) with 'ParticularFloatValue'; then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.generalize(ParticularFloatValue)"})
  void testGeneralizeWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualGeneralizeResult =
        unknownFloatValue.generalize(new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualGeneralizeResult);
  }

  /**
   * Test {@link FloatValue#generalize(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#generalize(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularFloatValue) with 'ParticularFloatValue'; then return UnknownFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.generalize(ParticularFloatValue)"})
  void testGeneralizeWithParticularFloatValue_thenReturnUnknownFloatValue2() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualGeneralizeResult =
        compositeFloatValue.generalize(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#generalize(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <p>Method under test: {@link FloatValue#generalize(SpecificFloatValue)}
   */
  @Test
  @DisplayName("Test generalize(SpecificFloatValue) with 'SpecificFloatValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.generalize(SpecificFloatValue)"})
  void testGeneralizeWithSpecificFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualGeneralizeResult =
        unknownFloatValue.generalize((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualGeneralizeResult);
  }

  /**
   * Test {@link FloatValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#UNKNOWN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value) with 'Value'; given FLOAT_VALUE; then return UNKNOWN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value FloatValue.generalize(Value)"})
  void testGeneralizeWithValue_givenFloat_value_thenReturnUnknown_value() {
    // Arrange
    UnknownValue other = BasicValueFactory.UNKNOWN_VALUE;

    // Act
    Value actualGeneralizeResult = BasicValueFactory.FLOAT_VALUE.generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link FloatValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#generalize(Value)}
   */
  @Test
  @DisplayName(
      "Test generalize(Value) with 'Value'; when FLOAT_VALUE; then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value FloatValue.generalize(Value)"})
  void testGeneralizeWithValue_whenFloat_value_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    Value actualGeneralizeResult =
        unknownFloatValue.generalize((Value) BasicValueFactory.FLOAT_VALUE);

    // Assert
    assertSame(unknownFloatValue, actualGeneralizeResult);
  }

  /**
   * Test {@link FloatValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#generalize(Value)}
   */
  @Test
  @DisplayName(
      "Test generalize(Value) with 'Value'; when INTEGER_VALUE_BYTE; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value FloatValue.generalize(Value)"})
  void testGeneralizeWithValue_whenInteger_value_byte_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new UnknownFloatValue().generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link FloatValue#add(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#add(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularFloatValue) with 'ParticularFloatValue'; then return CompositeFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.add(ParticularFloatValue)"})
  void testAddWithParticularFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualAddResult = compositeFloatValue.add(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualAddResult instanceof CompositeFloatValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#add(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#add(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularFloatValue) with 'ParticularFloatValue'; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.add(ParticularFloatValue)"})
  void testAddWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue other = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualAddResult = ParticularValueFactory.FLOAT_VALUE_0.add(other);

    // Assert
    assertTrue(actualAddResult instanceof ParticularFloatValue);
    assertEquals(other, actualAddResult);
  }

  /**
   * Test {@link FloatValue#add(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#add(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularFloatValue) with 'ParticularFloatValue'; then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.add(ParticularFloatValue)"})
  void testAddWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualAddResult = unknownFloatValue.add(new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualAddResult);
  }

  /**
   * Test {@link FloatValue#add(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownFloatValue} (default constructor).
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#add(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test add(SpecificFloatValue) with 'SpecificFloatValue'; given UnknownFloatValue (default constructor); then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.add(SpecificFloatValue)"})
  void testAddWithSpecificFloatValue_givenUnknownFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualAddResult =
        unknownFloatValue.add((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualAddResult);
  }

  /**
   * Test {@link FloatValue#subtract(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#subtract(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(ParticularFloatValue) with 'ParticularFloatValue'; then return CompositeFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.subtract(ParticularFloatValue)"})
  void testSubtractWithParticularFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualSubtractResult = compositeFloatValue.subtract(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#subtract(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#subtract(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(ParticularFloatValue) with 'ParticularFloatValue'; then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.subtract(ParticularFloatValue)"})
  void testSubtractWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualSubtractResult = unknownFloatValue.subtract(new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualSubtractResult);
  }

  /**
   * Test {@link FloatValue#subtract(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#subtract(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(SpecificFloatValue) with 'SpecificFloatValue'; then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.subtract(SpecificFloatValue)"})
  void testSubtractWithSpecificFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualSubtractResult =
        unknownFloatValue.subtract((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualSubtractResult);
  }

  /**
   * Test {@link FloatValue#subtractFrom(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#subtractFrom(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(ParticularFloatValue) with 'ParticularFloatValue'; then return CompositeFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.subtractFrom(ParticularFloatValue)"})
  void testSubtractFromWithParticularFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualSubtractFromResult =
        compositeFloatValue.subtractFrom(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#subtractFrom(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#subtractFrom(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(ParticularFloatValue) with 'ParticularFloatValue'; then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.subtractFrom(ParticularFloatValue)"})
  void testSubtractFromWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualSubtractFromResult =
        unknownFloatValue.subtractFrom(new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualSubtractFromResult);
  }

  /**
   * Test {@link FloatValue#subtractFrom(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#subtractFrom(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(SpecificFloatValue) with 'SpecificFloatValue'; then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.subtractFrom(SpecificFloatValue)"})
  void testSubtractFromWithSpecificFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualSubtractFromResult =
        unknownFloatValue.subtractFrom((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualSubtractFromResult);
  }

  /**
   * Test {@link FloatValue#multiply(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#multiply(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(ParticularFloatValue) with 'ParticularFloatValue'; then return CompositeFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.multiply(ParticularFloatValue)"})
  void testMultiplyWithParticularFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualMultiplyResult = compositeFloatValue.multiply(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeFloatValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#multiply(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#multiply(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(ParticularFloatValue) with 'ParticularFloatValue'; then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.multiply(ParticularFloatValue)"})
  void testMultiplyWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualMultiplyResult = unknownFloatValue.multiply(new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualMultiplyResult);
  }

  /**
   * Test {@link FloatValue#multiply(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#multiply(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(SpecificFloatValue) with 'SpecificFloatValue'; then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.multiply(SpecificFloatValue)"})
  void testMultiplyWithSpecificFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualMultiplyResult =
        unknownFloatValue.multiply((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualMultiplyResult);
  }

  /**
   * Test {@link FloatValue#divide(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#divide(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularFloatValue) with 'ParticularFloatValue'; then return CompositeFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.divide(ParticularFloatValue)"})
  void testDivideWithParticularFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualDivideResult = compositeFloatValue.divide(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeFloatValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#divide(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#divide(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularFloatValue) with 'ParticularFloatValue'; then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.divide(ParticularFloatValue)"})
  void testDivideWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualDivideResult = unknownFloatValue.divide(new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualDivideResult);
  }

  /**
   * Test {@link FloatValue#divide(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#divide(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test divide(SpecificFloatValue) with 'SpecificFloatValue'; then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.divide(SpecificFloatValue)"})
  void testDivideWithSpecificFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualDivideResult =
        unknownFloatValue.divide((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualDivideResult);
  }

  /**
   * Test {@link FloatValue#divideOf(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#divideOf(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(ParticularFloatValue) with 'ParticularFloatValue'; then return CompositeFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.divideOf(ParticularFloatValue)"})
  void testDivideOfWithParticularFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualDivideOfResult = compositeFloatValue.divideOf(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeFloatValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#divideOf(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#divideOf(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(ParticularFloatValue) with 'ParticularFloatValue'; then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.divideOf(ParticularFloatValue)"})
  void testDivideOfWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualDivideOfResult = unknownFloatValue.divideOf(new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualDivideOfResult);
  }

  /**
   * Test {@link FloatValue#divideOf(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#divideOf(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(SpecificFloatValue) with 'SpecificFloatValue'; then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.divideOf(SpecificFloatValue)"})
  void testDivideOfWithSpecificFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualDivideOfResult =
        unknownFloatValue.divideOf((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualDivideOfResult);
  }

  /**
   * Test {@link FloatValue#remainder(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#remainder(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(ParticularFloatValue) with 'ParticularFloatValue'; then return CompositeFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.remainder(ParticularFloatValue)"})
  void testRemainderWithParticularFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualRemainderResult =
        compositeFloatValue.remainder(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#remainder(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#remainder(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(ParticularFloatValue) with 'ParticularFloatValue'; then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.remainder(ParticularFloatValue)"})
  void testRemainderWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualRemainderResult = unknownFloatValue.remainder(new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualRemainderResult);
  }

  /**
   * Test {@link FloatValue#remainder(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#remainder(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(SpecificFloatValue) with 'SpecificFloatValue'; then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.remainder(SpecificFloatValue)"})
  void testRemainderWithSpecificFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualRemainderResult =
        unknownFloatValue.remainder((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualRemainderResult);
  }

  /**
   * Test {@link FloatValue#remainderOf(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#remainderOf(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(ParticularFloatValue) with 'ParticularFloatValue'; then return CompositeFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.remainderOf(ParticularFloatValue)"})
  void testRemainderOfWithParticularFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE);

    // Act
    FloatValue actualRemainderOfResult =
        compositeFloatValue.remainderOf(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#remainderOf(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#remainderOf(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(ParticularFloatValue) with 'ParticularFloatValue'; then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.remainderOf(ParticularFloatValue)"})
  void testRemainderOfWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualRemainderOfResult =
        unknownFloatValue.remainderOf(new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualRemainderOfResult);
  }

  /**
   * Test {@link FloatValue#remainderOf(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#remainderOf(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(SpecificFloatValue) with 'SpecificFloatValue'; then return UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.remainderOf(SpecificFloatValue)"})
  void testRemainderOfWithSpecificFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualRemainderOfResult =
        unknownFloatValue.remainderOf((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertSame(unknownFloatValue, actualRemainderOfResult);
  }

  /**
   * Test {@link FloatValue#compare(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <p>Method under test: {@link FloatValue#compare(ParticularFloatValue)}
   */
  @Test
  @DisplayName("Test compare(ParticularFloatValue) with 'ParticularFloatValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue FloatValue.compare(ParticularFloatValue)"})
  void testCompareWithParticularFloatValue() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE);

    // Act
    IntegerValue actualCompareResult = compositeFloatValue.compare(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#compare(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#compare(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test compare(ParticularFloatValue) with 'ParticularFloatValue'; given UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue FloatValue.compare(ParticularFloatValue)"})
  void testCompareWithParticularFloatValue_givenUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    IntegerValue actualCompareResult = unknownFloatValue.compare(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#compare(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <p>Method under test: {@link FloatValue#compare(SpecificFloatValue)}
   */
  @Test
  @DisplayName("Test compare(SpecificFloatValue) with 'SpecificFloatValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue FloatValue.compare(SpecificFloatValue)"})
  void testCompareWithSpecificFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    IntegerValue actualCompareResult =
        unknownFloatValue.compare((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#compareReverse(FloatValue)} with {@code FloatValue}.
   *
   * <p>Method under test: {@link FloatValue#compareReverse(FloatValue)}
   */
  @Test
  @DisplayName("Test compareReverse(FloatValue) with 'FloatValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue FloatValue.compareReverse(FloatValue)"})
  void testCompareReverseWithFloatValue() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        new CompositeFloatValue(
                BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE)
            .compareReverse(BasicValueFactory.FLOAT_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#compareReverse(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#FLOAT_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#compareReverse(FloatValue)}
   */
  @Test
  @DisplayName("Test compareReverse(FloatValue) with 'FloatValue'; given FLOAT_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue FloatValue.compareReverse(FloatValue)"})
  void testCompareReverseWithFloatValue_givenFloat_value_0() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        ParticularValueFactory.FLOAT_VALUE_0.compareReverse(BasicValueFactory.FLOAT_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#compareReverse(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#compareReverse(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test compareReverse(FloatValue) with 'FloatValue'; given UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue FloatValue.compareReverse(FloatValue)"})
  void testCompareReverseWithFloatValue_givenUnknownFloatValue() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        new UnknownFloatValue().compareReverse(BasicValueFactory.FLOAT_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#compareReverse(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <p>Method under test: {@link FloatValue#compareReverse(ParticularFloatValue)}
   */
  @Test
  @DisplayName("Test compareReverse(ParticularFloatValue) with 'ParticularFloatValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue FloatValue.compareReverse(ParticularFloatValue)"})
  void testCompareReverseWithParticularFloatValue() {
    // Arrange
    CompositeFloatValue compositeFloatValue =
        new CompositeFloatValue(
            BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE);

    // Act
    IntegerValue actualCompareReverseResult =
        compositeFloatValue.compareReverse(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#compareReverse(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#compareReverse(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test compareReverse(ParticularFloatValue) with 'ParticularFloatValue'; given UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue FloatValue.compareReverse(ParticularFloatValue)"})
  void testCompareReverseWithParticularFloatValue_givenUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    IntegerValue actualCompareReverseResult =
        unknownFloatValue.compareReverse(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#compareReverse(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#compareReverse(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test compareReverse(ParticularFloatValue) with 'ParticularFloatValue'; then return ParticularIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue FloatValue.compareReverse(ParticularFloatValue)"})
  void testCompareReverseWithParticularFloatValue_thenReturnParticularIntegerValue() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        ParticularValueFactory.FLOAT_VALUE_0.compareReverse(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareReverseResult instanceof ParticularIntegerValue);
    assertEquals(1, actualCompareReverseResult.value());
    assertTrue(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#compareReverse(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#FLOAT_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#compareReverse(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test compareReverse(SpecificFloatValue) with 'SpecificFloatValue'; given FLOAT_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue FloatValue.compareReverse(SpecificFloatValue)"})
  void testCompareReverseWithSpecificFloatValue_givenFloat_value_0() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        ParticularValueFactory.FLOAT_VALUE_0.compareReverse(
            (SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#compareReverse(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownFloatValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#compareReverse(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test compareReverse(SpecificFloatValue) with 'SpecificFloatValue'; given UnknownFloatValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue FloatValue.compareReverse(SpecificFloatValue)"})
  void testCompareReverseWithSpecificFloatValue_givenUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    IntegerValue actualCompareReverseResult =
        unknownFloatValue.compareReverse((SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link FloatValue#floatValue()}.
   *
   * <p>Method under test: {@link FloatValue#floatValue()}
   */
  @Test
  @DisplayName("Test floatValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue FloatValue.floatValue()"})
  void testFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act
    FloatValue actualFloatValueResult = unknownFloatValue.floatValue();

    // Assert
    assertSame(unknownFloatValue, actualFloatValueResult);
  }

  /**
   * Test {@link FloatValue#computationalType()}.
   *
   * <p>Method under test: {@link FloatValue#computationalType()}
   */
  @Test
  @DisplayName("Test computationalType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FloatValue.computationalType()"})
  void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(3, new UnknownFloatValue().computationalType());
  }

  /**
   * Test {@link FloatValue#internalType()}.
   *
   * <p>Method under test: {@link FloatValue#internalType()}
   */
  @Test
  @DisplayName("Test internalType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String FloatValue.internalType()"})
  void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("F", new UnknownFloatValue().internalType());
  }
}
