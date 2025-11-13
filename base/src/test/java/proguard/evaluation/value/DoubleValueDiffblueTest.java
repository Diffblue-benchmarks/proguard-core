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

class DoubleValueDiffblueTest {
  /**
   * Test {@link DoubleValue#value()}.
   *
   * <p>Method under test: {@link DoubleValue#value()}
   */
  @Test
  @DisplayName("Test value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double DoubleValue.value()"})
  void testValue() {
    // Arrange, Act and Assert
    assertEquals(0.0d, new UnknownDoubleValue().value());
  }

  /**
   * Test {@link DoubleValue#generalize(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#generalize(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularDoubleValue) with 'ParticularDoubleValue'; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.generalize(ParticularDoubleValue)"})
  void testGeneralizeWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualGeneralizeResult =
        unknownDoubleValue.generalize(new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualGeneralizeResult);
  }

  /**
   * Test {@link DoubleValue#generalize(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#generalize(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularDoubleValue) with 'ParticularDoubleValue'; then return UnknownDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.generalize(ParticularDoubleValue)"})
  void testGeneralizeWithParticularDoubleValue_thenReturnUnknownDoubleValue2() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualGeneralizeResult =
        compositeDoubleValue.generalize(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link DoubleValue#generalize(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <p>Method under test: {@link DoubleValue#generalize(SpecificDoubleValue)}
   */
  @Test
  @DisplayName("Test generalize(SpecificDoubleValue) with 'SpecificDoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.generalize(SpecificDoubleValue)"})
  void testGeneralizeWithSpecificDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualGeneralizeResult =
        unknownDoubleValue.generalize((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualGeneralizeResult);
  }

  /**
   * Test {@link DoubleValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#UNKNOWN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value) with 'Value'; given DOUBLE_VALUE; then return UNKNOWN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value DoubleValue.generalize(Value)"})
  void testGeneralizeWithValue_givenDouble_value_thenReturnUnknown_value() {
    // Arrange
    UnknownValue other = BasicValueFactory.UNKNOWN_VALUE;

    // Act
    Value actualGeneralizeResult = BasicValueFactory.DOUBLE_VALUE.generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link DoubleValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#generalize(Value)}
   */
  @Test
  @DisplayName(
      "Test generalize(Value) with 'Value'; when DOUBLE_VALUE; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value DoubleValue.generalize(Value)"})
  void testGeneralizeWithValue_whenDouble_value_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    Value actualGeneralizeResult =
        unknownDoubleValue.generalize((Value) BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertSame(unknownDoubleValue, actualGeneralizeResult);
  }

  /**
   * Test {@link DoubleValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#generalize(Value)}
   */
  @Test
  @DisplayName(
      "Test generalize(Value) with 'Value'; when INTEGER_VALUE_BYTE; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value DoubleValue.generalize(Value)"})
  void testGeneralizeWithValue_whenInteger_value_byte_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new UnknownDoubleValue().generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link DoubleValue#add(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#add(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularDoubleValue) with 'ParticularDoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.add(ParticularDoubleValue)"})
  void testAddWithParticularDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualAddResult = compositeDoubleValue.add(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualAddResult instanceof CompositeDoubleValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#add(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#add(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularDoubleValue) with 'ParticularDoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.add(ParticularDoubleValue)"})
  void testAddWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    ParticularDoubleValue other = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualAddResult = ParticularValueFactory.DOUBLE_VALUE_0.add(other);

    // Assert
    assertTrue(actualAddResult instanceof ParticularDoubleValue);
    assertEquals(other, actualAddResult);
  }

  /**
   * Test {@link DoubleValue#add(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#add(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularDoubleValue) with 'ParticularDoubleValue'; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.add(ParticularDoubleValue)"})
  void testAddWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualAddResult = unknownDoubleValue.add(new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualAddResult);
  }

  /**
   * Test {@link DoubleValue#add(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#add(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test add(SpecificDoubleValue) with 'SpecificDoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.add(SpecificDoubleValue)"})
  void testAddWithSpecificDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualAddResult =
        ParticularValueFactory.DOUBLE_VALUE_0.add(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualAddResult instanceof CompositeDoubleValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#add(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#add(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test add(SpecificDoubleValue) with 'SpecificDoubleValue'; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.add(SpecificDoubleValue)"})
  void testAddWithSpecificDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualAddResult =
        unknownDoubleValue.add((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualAddResult);
  }

  /**
   * Test {@link DoubleValue#subtract(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtract(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(ParticularDoubleValue) with 'ParticularDoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.subtract(ParticularDoubleValue)"})
  void testSubtractWithParticularDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualSubtractResult =
        compositeDoubleValue.subtract(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#subtract(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtract(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(ParticularDoubleValue) with 'ParticularDoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.subtract(ParticularDoubleValue)"})
  void testSubtractWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange and Act
    DoubleValue actualSubtractResult =
        ParticularValueFactory.DOUBLE_VALUE_0.subtract(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularDoubleValue);
    assertEquals(-10.0d, actualSubtractResult.value());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#subtract(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtract(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(ParticularDoubleValue) with 'ParticularDoubleValue'; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.subtract(ParticularDoubleValue)"})
  void testSubtractWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualSubtractResult =
        unknownDoubleValue.subtract(new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualSubtractResult);
  }

  /**
   * Test {@link DoubleValue#subtract(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtract(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(SpecificDoubleValue) with 'SpecificDoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.subtract(SpecificDoubleValue)"})
  void testSubtractWithSpecificDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualSubtractResult =
        ParticularValueFactory.DOUBLE_VALUE_0.subtract(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#subtract(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtract(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(SpecificDoubleValue) with 'SpecificDoubleValue'; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.subtract(SpecificDoubleValue)"})
  void testSubtractWithSpecificDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualSubtractResult =
        unknownDoubleValue.subtract((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualSubtractResult);
  }

  /**
   * Test {@link DoubleValue#subtractFrom(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtractFrom(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(ParticularDoubleValue) with 'ParticularDoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.subtractFrom(ParticularDoubleValue)"})
  void testSubtractFromWithParticularDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualSubtractFromResult =
        compositeDoubleValue.subtractFrom(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#subtractFrom(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtractFrom(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(ParticularDoubleValue) with 'ParticularDoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.subtractFrom(ParticularDoubleValue)"})
  void testSubtractFromWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    ParticularDoubleValue other = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualSubtractFromResult =
        ParticularValueFactory.DOUBLE_VALUE_0.subtractFrom(other);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularDoubleValue);
    assertEquals(other, actualSubtractFromResult);
  }

  /**
   * Test {@link DoubleValue#subtractFrom(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtractFrom(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(ParticularDoubleValue) with 'ParticularDoubleValue'; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.subtractFrom(ParticularDoubleValue)"})
  void testSubtractFromWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualSubtractFromResult =
        unknownDoubleValue.subtractFrom(new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualSubtractFromResult);
  }

  /**
   * Test {@link DoubleValue#subtractFrom(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtractFrom(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(SpecificDoubleValue) with 'SpecificDoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.subtractFrom(SpecificDoubleValue)"})
  void testSubtractFromWithSpecificDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualSubtractFromResult =
        ParticularValueFactory.DOUBLE_VALUE_0.subtractFrom(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#subtractFrom(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#subtractFrom(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(SpecificDoubleValue) with 'SpecificDoubleValue'; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.subtractFrom(SpecificDoubleValue)"})
  void testSubtractFromWithSpecificDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualSubtractFromResult =
        unknownDoubleValue.subtractFrom((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualSubtractFromResult);
  }

  /**
   * Test {@link DoubleValue#multiply(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#multiply(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(ParticularDoubleValue) with 'ParticularDoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.multiply(ParticularDoubleValue)"})
  void testMultiplyWithParticularDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualMultiplyResult =
        compositeDoubleValue.multiply(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeDoubleValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#multiply(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#multiply(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(ParticularDoubleValue) with 'ParticularDoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.multiply(ParticularDoubleValue)"})
  void testMultiplyWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    DoubleValue doubleValue = ParticularValueFactory.DOUBLE_VALUE_0;

    // Act
    DoubleValue actualMultiplyResult = doubleValue.multiply(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularDoubleValue);
    assertEquals(doubleValue, actualMultiplyResult);
  }

  /**
   * Test {@link DoubleValue#multiply(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#multiply(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(ParticularDoubleValue) with 'ParticularDoubleValue'; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.multiply(ParticularDoubleValue)"})
  void testMultiplyWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualMultiplyResult =
        unknownDoubleValue.multiply(new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualMultiplyResult);
  }

  /**
   * Test {@link DoubleValue#multiply(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#multiply(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(SpecificDoubleValue) with 'SpecificDoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.multiply(SpecificDoubleValue)"})
  void testMultiplyWithSpecificDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualMultiplyResult =
        ParticularValueFactory.DOUBLE_VALUE_0.multiply(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeDoubleValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#multiply(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#multiply(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(SpecificDoubleValue) with 'SpecificDoubleValue'; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.multiply(SpecificDoubleValue)"})
  void testMultiplyWithSpecificDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualMultiplyResult =
        unknownDoubleValue.multiply((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualMultiplyResult);
  }

  /**
   * Test {@link DoubleValue#divide(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divide(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularDoubleValue) with 'ParticularDoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.divide(ParticularDoubleValue)"})
  void testDivideWithParticularDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualDivideResult = compositeDoubleValue.divide(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#divide(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divide(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularDoubleValue) with 'ParticularDoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.divide(ParticularDoubleValue)"})
  void testDivideWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    DoubleValue doubleValue = ParticularValueFactory.DOUBLE_VALUE_0;

    // Act
    DoubleValue actualDivideResult = doubleValue.divide(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideResult instanceof ParticularDoubleValue);
    assertEquals(doubleValue, actualDivideResult);
  }

  /**
   * Test {@link DoubleValue#divide(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divide(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularDoubleValue) with 'ParticularDoubleValue'; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.divide(ParticularDoubleValue)"})
  void testDivideWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualDivideResult = unknownDoubleValue.divide(new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualDivideResult);
  }

  /**
   * Test {@link DoubleValue#divide(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divide(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divide(SpecificDoubleValue) with 'SpecificDoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.divide(SpecificDoubleValue)"})
  void testDivideWithSpecificDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualDivideResult =
        ParticularValueFactory.DOUBLE_VALUE_0.divide(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#divide(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divide(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divide(SpecificDoubleValue) with 'SpecificDoubleValue'; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.divide(SpecificDoubleValue)"})
  void testDivideWithSpecificDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualDivideResult =
        unknownDoubleValue.divide((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualDivideResult);
  }

  /**
   * Test {@link DoubleValue#divideOf(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divideOf(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(ParticularDoubleValue) with 'ParticularDoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.divideOf(ParticularDoubleValue)"})
  void testDivideOfWithParticularDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualDivideOfResult =
        compositeDoubleValue.divideOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#divideOf(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divideOf(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(ParticularDoubleValue) with 'ParticularDoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.divideOf(ParticularDoubleValue)"})
  void testDivideOfWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange and Act
    DoubleValue actualDivideOfResult =
        ParticularValueFactory.DOUBLE_VALUE_0.divideOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularDoubleValue);
    assertTrue(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
    assertEquals(Double.POSITIVE_INFINITY, actualDivideOfResult.value());
  }

  /**
   * Test {@link DoubleValue#divideOf(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divideOf(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(ParticularDoubleValue) with 'ParticularDoubleValue'; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.divideOf(ParticularDoubleValue)"})
  void testDivideOfWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualDivideOfResult =
        unknownDoubleValue.divideOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualDivideOfResult);
  }

  /**
   * Test {@link DoubleValue#divideOf(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divideOf(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(SpecificDoubleValue) with 'SpecificDoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.divideOf(SpecificDoubleValue)"})
  void testDivideOfWithSpecificDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualDivideOfResult =
        ParticularValueFactory.DOUBLE_VALUE_0.divideOf(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#divideOf(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#divideOf(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(SpecificDoubleValue) with 'SpecificDoubleValue'; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.divideOf(SpecificDoubleValue)"})
  void testDivideOfWithSpecificDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualDivideOfResult =
        unknownDoubleValue.divideOf((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualDivideOfResult);
  }

  /**
   * Test {@link DoubleValue#remainder(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainder(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(ParticularDoubleValue) with 'ParticularDoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.remainder(ParticularDoubleValue)"})
  void testRemainderWithParticularDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualRemainderResult =
        compositeDoubleValue.remainder(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#remainder(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainder(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(ParticularDoubleValue) with 'ParticularDoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.remainder(ParticularDoubleValue)"})
  void testRemainderWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    DoubleValue doubleValue = ParticularValueFactory.DOUBLE_VALUE_0;

    // Act
    DoubleValue actualRemainderResult = doubleValue.remainder(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularDoubleValue);
    assertEquals(doubleValue, actualRemainderResult);
  }

  /**
   * Test {@link DoubleValue#remainder(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainder(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(ParticularDoubleValue) with 'ParticularDoubleValue'; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.remainder(ParticularDoubleValue)"})
  void testRemainderWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualRemainderResult =
        unknownDoubleValue.remainder(new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualRemainderResult);
  }

  /**
   * Test {@link DoubleValue#remainder(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainder(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(SpecificDoubleValue) with 'SpecificDoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.remainder(SpecificDoubleValue)"})
  void testRemainderWithSpecificDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualRemainderResult =
        ParticularValueFactory.DOUBLE_VALUE_0.remainder(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#remainder(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainder(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(SpecificDoubleValue) with 'SpecificDoubleValue'; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.remainder(SpecificDoubleValue)"})
  void testRemainderWithSpecificDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualRemainderResult =
        unknownDoubleValue.remainder((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualRemainderResult);
  }

  /**
   * Test {@link DoubleValue#remainderOf(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainderOf(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(ParticularDoubleValue) with 'ParticularDoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.remainderOf(ParticularDoubleValue)"})
  void testRemainderOfWithParticularDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    DoubleValue actualRemainderOfResult =
        compositeDoubleValue.remainderOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#remainderOf(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainderOf(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(ParticularDoubleValue) with 'ParticularDoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.remainderOf(ParticularDoubleValue)"})
  void testRemainderOfWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange and Act
    DoubleValue actualRemainderOfResult =
        ParticularValueFactory.DOUBLE_VALUE_0.remainderOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularDoubleValue);
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
    assertEquals(Double.NaN, actualRemainderOfResult.value());
  }

  /**
   * Test {@link DoubleValue#remainderOf(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainderOf(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(ParticularDoubleValue) with 'ParticularDoubleValue'; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.remainderOf(ParticularDoubleValue)"})
  void testRemainderOfWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualRemainderOfResult =
        unknownDoubleValue.remainderOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualRemainderOfResult);
  }

  /**
   * Test {@link DoubleValue#remainderOf(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainderOf(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(SpecificDoubleValue) with 'SpecificDoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.remainderOf(SpecificDoubleValue)"})
  void testRemainderOfWithSpecificDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange and Act
    DoubleValue actualRemainderOfResult =
        ParticularValueFactory.DOUBLE_VALUE_0.remainderOf(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#remainderOf(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#remainderOf(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(SpecificDoubleValue) with 'SpecificDoubleValue'; then return UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.remainderOf(SpecificDoubleValue)"})
  void testRemainderOfWithSpecificDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualRemainderOfResult =
        unknownDoubleValue.remainderOf((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(unknownDoubleValue, actualRemainderOfResult);
  }

  /**
   * Test {@link DoubleValue#compare(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <p>Method under test: {@link DoubleValue#compare(ParticularDoubleValue)}
   */
  @Test
  @DisplayName("Test compare(ParticularDoubleValue) with 'ParticularDoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue DoubleValue.compare(ParticularDoubleValue)"})
  void testCompareWithParticularDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    IntegerValue actualCompareResult =
        compositeDoubleValue.compare(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compare(ParticularDoubleValue)} with {@code ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#compare(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test compare(ParticularDoubleValue) with 'ParticularDoubleValue'; given UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue DoubleValue.compare(ParticularDoubleValue)"})
  void testCompareWithParticularDoubleValue_givenUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    IntegerValue actualCompareResult = unknownDoubleValue.compare(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compare(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <p>Method under test: {@link DoubleValue#compare(SpecificDoubleValue)}
   */
  @Test
  @DisplayName("Test compare(SpecificDoubleValue) with 'SpecificDoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue DoubleValue.compare(SpecificDoubleValue)"})
  void testCompareWithSpecificDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    IntegerValue actualCompareResult =
        unknownDoubleValue.compare((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compareReverse(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link DoubleValue#compareReverse(DoubleValue)}
   */
  @Test
  @DisplayName("Test compareReverse(DoubleValue) with 'DoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue DoubleValue.compareReverse(DoubleValue)"})
  void testCompareReverseWithDoubleValue() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        new CompositeDoubleValue(
                BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE)
            .compareReverse(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compareReverse(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#compareReverse(DoubleValue)}
   */
  @Test
  @DisplayName("Test compareReverse(DoubleValue) with 'DoubleValue'; given DOUBLE_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue DoubleValue.compareReverse(DoubleValue)"})
  void testCompareReverseWithDoubleValue_givenDouble_value_0() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        ParticularValueFactory.DOUBLE_VALUE_0.compareReverse(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compareReverse(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#compareReverse(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test compareReverse(DoubleValue) with 'DoubleValue'; given UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue DoubleValue.compareReverse(DoubleValue)"})
  void testCompareReverseWithDoubleValue_givenUnknownDoubleValue() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        new UnknownDoubleValue().compareReverse(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compareReverse(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <p>Method under test: {@link DoubleValue#compareReverse(ParticularDoubleValue)}
   */
  @Test
  @DisplayName("Test compareReverse(ParticularDoubleValue) with 'ParticularDoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue DoubleValue.compareReverse(ParticularDoubleValue)"})
  void testCompareReverseWithParticularDoubleValue() {
    // Arrange
    CompositeDoubleValue compositeDoubleValue =
        new CompositeDoubleValue(
            BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE);

    // Act
    IntegerValue actualCompareReverseResult =
        compositeDoubleValue.compareReverse(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compareReverse(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#compareReverse(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test compareReverse(ParticularDoubleValue) with 'ParticularDoubleValue'; given UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue DoubleValue.compareReverse(ParticularDoubleValue)"})
  void testCompareReverseWithParticularDoubleValue_givenUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    IntegerValue actualCompareReverseResult =
        unknownDoubleValue.compareReverse(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compareReverse(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#compareReverse(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test compareReverse(ParticularDoubleValue) with 'ParticularDoubleValue'; then return ParticularIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue DoubleValue.compareReverse(ParticularDoubleValue)"})
  void testCompareReverseWithParticularDoubleValue_thenReturnParticularIntegerValue() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        ParticularValueFactory.DOUBLE_VALUE_0.compareReverse(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareReverseResult instanceof ParticularIntegerValue);
    assertEquals(1, actualCompareReverseResult.value());
    assertTrue(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compareReverse(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#compareReverse(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test compareReverse(SpecificDoubleValue) with 'SpecificDoubleValue'; given DOUBLE_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue DoubleValue.compareReverse(SpecificDoubleValue)"})
  void testCompareReverseWithSpecificDoubleValue_givenDouble_value_0() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        ParticularValueFactory.DOUBLE_VALUE_0.compareReverse(
            (SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#compareReverse(SpecificDoubleValue)} with {@code SpecificDoubleValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownDoubleValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DoubleValue#compareReverse(SpecificDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test compareReverse(SpecificDoubleValue) with 'SpecificDoubleValue'; given UnknownDoubleValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue DoubleValue.compareReverse(SpecificDoubleValue)"})
  void testCompareReverseWithSpecificDoubleValue_givenUnknownDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    IntegerValue actualCompareReverseResult =
        unknownDoubleValue.compareReverse((SpecificDoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link DoubleValue#doubleValue()}.
   *
   * <p>Method under test: {@link DoubleValue#doubleValue()}
   */
  @Test
  @DisplayName("Test doubleValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue DoubleValue.doubleValue()"})
  void testDoubleValue() {
    // Arrange
    UnknownDoubleValue unknownDoubleValue = new UnknownDoubleValue();

    // Act
    DoubleValue actualDoubleValueResult = unknownDoubleValue.doubleValue();

    // Assert
    assertSame(unknownDoubleValue, actualDoubleValueResult);
  }

  /**
   * Test {@link DoubleValue#computationalType()}.
   *
   * <p>Method under test: {@link DoubleValue#computationalType()}
   */
  @Test
  @DisplayName("Test computationalType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DoubleValue.computationalType()"})
  void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(4, new UnknownDoubleValue().computationalType());
  }

  /**
   * Test {@link DoubleValue#internalType()}.
   *
   * <p>Method under test: {@link DoubleValue#internalType()}
   */
  @Test
  @DisplayName("Test internalType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String DoubleValue.internalType()"})
  void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("D", new UnknownDoubleValue().internalType());
  }
}
