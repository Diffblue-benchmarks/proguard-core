package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float proguard.evaluation.value.FloatValue.value()"})
  void testValue() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new UnknownFloatValue()).value());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.generalize(proguard.evaluation.value.ParticularFloatValue)"
  })
  void testGeneralizeWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.generalize(new ParticularFloatValue(10.0f)));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.generalize(proguard.evaluation.value.ParticularFloatValue)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.generalize(proguard.evaluation.value.SpecificFloatValue)"
  })
  void testGeneralizeWithSpecificFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(
        unknownFloatValue,
        unknownFloatValue.generalize((SpecificFloatValue) new ParticularFloatValue(10.0f)));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.value.FloatValue.generalize(proguard.evaluation.value.Value)"
  })
  void testGeneralizeWithValue_givenFloat_value_thenReturnUnknown_value() {
    // Arrange
    UnknownValue other = BasicValueFactory.UNKNOWN_VALUE;

    // Act and Assert
    assertSame(other, BasicValueFactory.FLOAT_VALUE.generalize(other));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.value.FloatValue.generalize(proguard.evaluation.value.Value)"
  })
  void testGeneralizeWithValue_whenFloat_value_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(
        unknownFloatValue, unknownFloatValue.generalize((Value) BasicValueFactory.FLOAT_VALUE));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.add(proguard.evaluation.value.ParticularFloatValue)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.add(proguard.evaluation.value.ParticularFloatValue)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.add(proguard.evaluation.value.ParticularFloatValue)"
  })
  void testAddWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.add(new ParticularFloatValue(10.0f)));
  }

  /**
   * Test {@link FloatValue#add(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#add(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test add(SpecificFloatValue) with 'SpecificFloatValue'; given FLOAT_VALUE_0; then return CompositeFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.add(proguard.evaluation.value.SpecificFloatValue)"
  })
  void testAddWithSpecificFloatValue_givenFloat_value_0_thenReturnCompositeFloatValue() {
    // Arrange and Act
    FloatValue actualAddResult =
        ParticularValueFactory.FLOAT_VALUE_0.add(
            (SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualAddResult instanceof CompositeFloatValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.add(proguard.evaluation.value.SpecificFloatValue)"
  })
  void testAddWithSpecificFloatValue_givenUnknownFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(
        unknownFloatValue,
        unknownFloatValue.add((SpecificFloatValue) new ParticularFloatValue(10.0f)));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.subtract(proguard.evaluation.value.ParticularFloatValue)"
  })
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
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#subtract(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(ParticularFloatValue) with 'ParticularFloatValue'; then return ParticularFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.subtract(proguard.evaluation.value.ParticularFloatValue)"
  })
  void testSubtractWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange and Act
    FloatValue actualSubtractResult =
        ParticularValueFactory.FLOAT_VALUE_0.subtract(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularFloatValue);
    assertEquals(-10.0f, actualSubtractResult.value());
    assertTrue(actualSubtractResult.isParticular());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.subtract(proguard.evaluation.value.ParticularFloatValue)"
  })
  void testSubtractWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.subtract(new ParticularFloatValue(10.0f)));
  }

  /**
   * Test {@link FloatValue#subtract(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#subtract(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(SpecificFloatValue) with 'SpecificFloatValue'; then return CompositeFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.subtract(proguard.evaluation.value.SpecificFloatValue)"
  })
  void testSubtractWithSpecificFloatValue_thenReturnCompositeFloatValue() {
    // Arrange and Act
    FloatValue actualSubtractResult =
        ParticularValueFactory.FLOAT_VALUE_0.subtract(
            (SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.subtract(proguard.evaluation.value.SpecificFloatValue)"
  })
  void testSubtractWithSpecificFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(
        unknownFloatValue,
        unknownFloatValue.subtract((SpecificFloatValue) new ParticularFloatValue(10.0f)));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.subtractFrom(proguard.evaluation.value.ParticularFloatValue)"
  })
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
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#subtractFrom(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(ParticularFloatValue) with 'ParticularFloatValue'; then return ParticularFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.subtractFrom(proguard.evaluation.value.ParticularFloatValue)"
  })
  void testSubtractFromWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue other = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractFromResult = ParticularValueFactory.FLOAT_VALUE_0.subtractFrom(other);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularFloatValue);
    assertEquals(other, actualSubtractFromResult);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.subtractFrom(proguard.evaluation.value.ParticularFloatValue)"
  })
  void testSubtractFromWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.subtractFrom(new ParticularFloatValue(10.0f)));
  }

  /**
   * Test {@link FloatValue#subtractFrom(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#subtractFrom(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(SpecificFloatValue) with 'SpecificFloatValue'; then return CompositeFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.subtractFrom(proguard.evaluation.value.SpecificFloatValue)"
  })
  void testSubtractFromWithSpecificFloatValue_thenReturnCompositeFloatValue() {
    // Arrange and Act
    FloatValue actualSubtractFromResult =
        ParticularValueFactory.FLOAT_VALUE_0.subtractFrom(
            (SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.subtractFrom(proguard.evaluation.value.SpecificFloatValue)"
  })
  void testSubtractFromWithSpecificFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(
        unknownFloatValue,
        unknownFloatValue.subtractFrom((SpecificFloatValue) new ParticularFloatValue(10.0f)));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.multiply(proguard.evaluation.value.ParticularFloatValue)"
  })
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
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#multiply(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(ParticularFloatValue) with 'ParticularFloatValue'; then return ParticularFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.multiply(proguard.evaluation.value.ParticularFloatValue)"
  })
  void testMultiplyWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    FloatValue floatValue = ParticularValueFactory.FLOAT_VALUE_0;

    // Act
    FloatValue actualMultiplyResult = floatValue.multiply(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularFloatValue);
    assertEquals(floatValue, actualMultiplyResult);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.multiply(proguard.evaluation.value.ParticularFloatValue)"
  })
  void testMultiplyWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.multiply(new ParticularFloatValue(10.0f)));
  }

  /**
   * Test {@link FloatValue#multiply(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#multiply(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(SpecificFloatValue) with 'SpecificFloatValue'; then return CompositeFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.multiply(proguard.evaluation.value.SpecificFloatValue)"
  })
  void testMultiplyWithSpecificFloatValue_thenReturnCompositeFloatValue() {
    // Arrange and Act
    FloatValue actualMultiplyResult =
        ParticularValueFactory.FLOAT_VALUE_0.multiply(
            (SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeFloatValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.multiply(proguard.evaluation.value.SpecificFloatValue)"
  })
  void testMultiplyWithSpecificFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(
        unknownFloatValue,
        unknownFloatValue.multiply((SpecificFloatValue) new ParticularFloatValue(10.0f)));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.divide(proguard.evaluation.value.ParticularFloatValue)"
  })
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
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#divide(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularFloatValue) with 'ParticularFloatValue'; then return ParticularFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.divide(proguard.evaluation.value.ParticularFloatValue)"
  })
  void testDivideWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    FloatValue floatValue = ParticularValueFactory.FLOAT_VALUE_0;

    // Act
    FloatValue actualDivideResult = floatValue.divide(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideResult instanceof ParticularFloatValue);
    assertEquals(floatValue, actualDivideResult);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.divide(proguard.evaluation.value.ParticularFloatValue)"
  })
  void testDivideWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.divide(new ParticularFloatValue(10.0f)));
  }

  /**
   * Test {@link FloatValue#divide(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#divide(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test divide(SpecificFloatValue) with 'SpecificFloatValue'; then return CompositeFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.divide(proguard.evaluation.value.SpecificFloatValue)"
  })
  void testDivideWithSpecificFloatValue_thenReturnCompositeFloatValue() {
    // Arrange and Act
    FloatValue actualDivideResult =
        ParticularValueFactory.FLOAT_VALUE_0.divide(
            (SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeFloatValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.divide(proguard.evaluation.value.SpecificFloatValue)"
  })
  void testDivideWithSpecificFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(
        unknownFloatValue,
        unknownFloatValue.divide((SpecificFloatValue) new ParticularFloatValue(10.0f)));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.divideOf(proguard.evaluation.value.ParticularFloatValue)"
  })
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
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#divideOf(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(ParticularFloatValue) with 'ParticularFloatValue'; then return ParticularFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.divideOf(proguard.evaluation.value.ParticularFloatValue)"
  })
  void testDivideOfWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange and Act
    FloatValue actualDivideOfResult =
        ParticularValueFactory.FLOAT_VALUE_0.divideOf(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularFloatValue);
    assertTrue(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
    assertEquals(Float.POSITIVE_INFINITY, actualDivideOfResult.value());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.divideOf(proguard.evaluation.value.ParticularFloatValue)"
  })
  void testDivideOfWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.divideOf(new ParticularFloatValue(10.0f)));
  }

  /**
   * Test {@link FloatValue#divideOf(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#divideOf(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(SpecificFloatValue) with 'SpecificFloatValue'; then return CompositeFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.divideOf(proguard.evaluation.value.SpecificFloatValue)"
  })
  void testDivideOfWithSpecificFloatValue_thenReturnCompositeFloatValue() {
    // Arrange and Act
    FloatValue actualDivideOfResult =
        ParticularValueFactory.FLOAT_VALUE_0.divideOf(
            (SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeFloatValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.divideOf(proguard.evaluation.value.SpecificFloatValue)"
  })
  void testDivideOfWithSpecificFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(
        unknownFloatValue,
        unknownFloatValue.divideOf((SpecificFloatValue) new ParticularFloatValue(10.0f)));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.remainder(proguard.evaluation.value.ParticularFloatValue)"
  })
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
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#remainder(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(ParticularFloatValue) with 'ParticularFloatValue'; then return ParticularFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.remainder(proguard.evaluation.value.ParticularFloatValue)"
  })
  void testRemainderWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    FloatValue floatValue = ParticularValueFactory.FLOAT_VALUE_0;

    // Act
    FloatValue actualRemainderResult = floatValue.remainder(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularFloatValue);
    assertEquals(floatValue, actualRemainderResult);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.remainder(proguard.evaluation.value.ParticularFloatValue)"
  })
  void testRemainderWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.remainder(new ParticularFloatValue(10.0f)));
  }

  /**
   * Test {@link FloatValue#remainder(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#remainder(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(SpecificFloatValue) with 'SpecificFloatValue'; then return CompositeFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.remainder(proguard.evaluation.value.SpecificFloatValue)"
  })
  void testRemainderWithSpecificFloatValue_thenReturnCompositeFloatValue() {
    // Arrange and Act
    FloatValue actualRemainderResult =
        ParticularValueFactory.FLOAT_VALUE_0.remainder(
            (SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.remainder(proguard.evaluation.value.SpecificFloatValue)"
  })
  void testRemainderWithSpecificFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(
        unknownFloatValue,
        unknownFloatValue.remainder((SpecificFloatValue) new ParticularFloatValue(10.0f)));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.remainderOf(proguard.evaluation.value.ParticularFloatValue)"
  })
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
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#remainderOf(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(ParticularFloatValue) with 'ParticularFloatValue'; then return ParticularFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.remainderOf(proguard.evaluation.value.ParticularFloatValue)"
  })
  void testRemainderOfWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange and Act
    FloatValue actualRemainderOfResult =
        ParticularValueFactory.FLOAT_VALUE_0.remainderOf(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularFloatValue);
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
    assertEquals(Float.NaN, actualRemainderOfResult.value());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.remainderOf(proguard.evaluation.value.ParticularFloatValue)"
  })
  void testRemainderOfWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.remainderOf(new ParticularFloatValue(10.0f)));
  }

  /**
   * Test {@link FloatValue#remainderOf(SpecificFloatValue)} with {@code SpecificFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link FloatValue#remainderOf(SpecificFloatValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(SpecificFloatValue) with 'SpecificFloatValue'; then return CompositeFloatValue")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.remainderOf(proguard.evaluation.value.SpecificFloatValue)"
  })
  void testRemainderOfWithSpecificFloatValue_thenReturnCompositeFloatValue() {
    // Arrange and Act
    FloatValue actualRemainderOfResult =
        ParticularValueFactory.FLOAT_VALUE_0.remainderOf(
            (SpecificFloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.remainderOf(proguard.evaluation.value.SpecificFloatValue)"
  })
  void testRemainderOfWithSpecificFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(
        unknownFloatValue,
        unknownFloatValue.remainderOf((SpecificFloatValue) new ParticularFloatValue(10.0f)));
  }

  /**
   * Test {@link FloatValue#compare(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <p>Method under test: {@link FloatValue#compare(ParticularFloatValue)}
   */
  @Test
  @DisplayName("Test compare(ParticularFloatValue) with 'ParticularFloatValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.FloatValue.compare(proguard.evaluation.value.ParticularFloatValue)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.FloatValue.compare(proguard.evaluation.value.ParticularFloatValue)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.FloatValue.compare(proguard.evaluation.value.SpecificFloatValue)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.FloatValue.compareReverse(proguard.evaluation.value.FloatValue)"
  })
  void testCompareReverseWithFloatValue() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        (new CompositeFloatValue(
                BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE))
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.FloatValue.compareReverse(proguard.evaluation.value.FloatValue)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.FloatValue.compareReverse(proguard.evaluation.value.FloatValue)"
  })
  void testCompareReverseWithFloatValue_givenUnknownFloatValue() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        (new UnknownFloatValue()).compareReverse(BasicValueFactory.FLOAT_VALUE);

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.FloatValue.compareReverse(proguard.evaluation.value.ParticularFloatValue)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.FloatValue.compareReverse(proguard.evaluation.value.ParticularFloatValue)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.FloatValue.compareReverse(proguard.evaluation.value.ParticularFloatValue)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.FloatValue.compareReverse(proguard.evaluation.value.SpecificFloatValue)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.FloatValue.compareReverse(proguard.evaluation.value.SpecificFloatValue)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.FloatValue.floatValue()"
  })
  void testFloatValue() {
    // Arrange
    UnknownFloatValue unknownFloatValue = new UnknownFloatValue();

    // Act and Assert
    assertSame(unknownFloatValue, unknownFloatValue.floatValue());
  }

  /**
   * Test {@link FloatValue#computationalType()}.
   *
   * <p>Method under test: {@link FloatValue#computationalType()}
   */
  @Test
  @DisplayName("Test computationalType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.evaluation.value.FloatValue.computationalType()"})
  void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(3, (new UnknownFloatValue()).computationalType());
  }

  /**
   * Test {@link FloatValue#internalType()}.
   *
   * <p>Method under test: {@link FloatValue#internalType()}
   */
  @Test
  @DisplayName("Test internalType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.evaluation.value.FloatValue.internalType()"})
  void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("F", (new UnknownFloatValue()).internalType());
  }
}
