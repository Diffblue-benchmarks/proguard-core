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

class ParticularFloatValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParticularFloatValue#ParticularFloatValue(float)}
   *   <li>{@link ParticularFloatValue#toString()}
   *   <li>{@link ParticularFloatValue#isParticular()}
   *   <li>{@link ParticularFloatValue#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ParticularFloatValue.<init>(float)",
    "boolean ParticularFloatValue.isParticular()",
    "String ParticularFloatValue.toString()",
    "float ParticularFloatValue.value()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ParticularFloatValue actualParticularFloatValue = new ParticularFloatValue(10.0f);
    String actualToStringResult = actualParticularFloatValue.toString();
    boolean actualIsParticularResult = actualParticularFloatValue.isParticular();

    // Assert
    assertEquals("10.0f", actualToStringResult);
    assertEquals(10.0f, actualParticularFloatValue.value());
    assertTrue(actualIsParticularResult);
  }

  /**
   * Test {@link ParticularFloatValue#negate()}.
   *
   * <p>Method under test: {@link ParticularFloatValue#negate()}
   */
  @Test
  @DisplayName("Test negate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.negate()"})
  void testNegate() {
    // Arrange and Act
    FloatValue actualNegateResult = new ParticularFloatValue(10.0f).negate();

    // Assert
    assertTrue(actualNegateResult instanceof ParticularFloatValue);
    assertEquals(-10.0f, actualNegateResult.value());
    assertFalse(actualNegateResult.isCategory2());
    assertTrue(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#convertToInteger()}.
   *
   * <p>Method under test: {@link ParticularFloatValue#convertToInteger()}
   */
  @Test
  @DisplayName("Test convertToInteger()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.convertToInteger()"})
  void testConvertToInteger() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult = new ParticularFloatValue(10.0f).convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof ParticularIntegerValue);
    assertEquals(10, actualConvertToIntegerResult.value());
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertTrue(actualConvertToIntegerResult.isParticular());
    assertTrue(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#convertToLong()}.
   *
   * <p>Method under test: {@link ParticularFloatValue#convertToLong()}
   */
  @Test
  @DisplayName("Test convertToLong()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularFloatValue.convertToLong()"})
  void testConvertToLong() {
    // Arrange and Act
    LongValue actualConvertToLongResult = new ParticularFloatValue(10.0f).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof ParticularLongValue);
    assertEquals(10L, actualConvertToLongResult.value());
    assertTrue(actualConvertToLongResult.isCategory2());
    assertTrue(actualConvertToLongResult.isParticular());
    assertTrue(actualConvertToLongResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#convertToDouble()}.
   *
   * <p>Method under test: {@link ParticularFloatValue#convertToDouble()}
   */
  @Test
  @DisplayName("Test convertToDouble()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularFloatValue.convertToDouble()"})
  void testConvertToDouble() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = new ParticularFloatValue(10.0f).convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof ParticularDoubleValue);
    assertEquals(10.0d, actualConvertToDoubleResult.value());
    assertTrue(actualConvertToDoubleResult.isCategory2());
    assertTrue(actualConvertToDoubleResult.isParticular());
    assertTrue(actualConvertToDoubleResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#generalize(FloatValue)} with {@code FloatValue}.
   *
   * <p>Method under test: {@link ParticularFloatValue#generalize(FloatValue)}
   */
  @Test
  @DisplayName("Test generalize(FloatValue) with 'FloatValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.generalize(FloatValue)"})
  void testGeneralizeWithFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualGeneralizeResult =
        particularFloatValue.generalize(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#generalize(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#generalize(FloatValue)}
   */
  @Test
  @DisplayName("Test generalize(FloatValue) with 'FloatValue'; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.generalize(FloatValue)"})
  void testGeneralizeWithFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);
    ParticularFloatValue other = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualGeneralizeResult = particularFloatValue.generalize((FloatValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof ParticularFloatValue);
    assertEquals(particularFloatValue, actualGeneralizeResult);
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link ParticularFloatValue#generalize(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link UnknownFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#generalize(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(FloatValue) with 'FloatValue'; when FLOAT_VALUE_0; then return UnknownFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.generalize(FloatValue)"})
  void testGeneralizeWithFloatValue_whenFloat_value_0_thenReturnUnknownFloatValue() {
    // Arrange and Act
    FloatValue actualGeneralizeResult =
        new ParticularFloatValue(10.0f).generalize(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#generalize(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#generalize(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(FloatValue) with 'FloatValue'; when FLOAT_VALUE; then return FLOAT_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.generalize(FloatValue)"})
  void testGeneralizeWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act
    FloatValue actualGeneralizeResult = new ParticularFloatValue(10.0f).generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link ParticularFloatValue#generalize(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <p>Method under test: {@link ParticularFloatValue#generalize(ParticularFloatValue)}
   */
  @Test
  @DisplayName("Test generalize(ParticularFloatValue) with 'ParticularFloatValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.generalize(ParticularFloatValue)"})
  void testGeneralizeWithParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualGeneralizeResult =
        particularFloatValue.generalize(new ParticularFloatValue(10.0f));

    // Assert
    assertSame(particularFloatValue, actualGeneralizeResult);
  }

  /**
   * Test {@link ParticularFloatValue#generalize(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#generalize(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularFloatValue) with 'ParticularFloatValue'; then return UnknownFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.generalize(ParticularFloatValue)"})
  void testGeneralizeWithParticularFloatValue_thenReturnUnknownFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(0.5f);

    // Act
    FloatValue actualGeneralizeResult =
        particularFloatValue.generalize(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownFloatValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#add(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#add(FloatValue)}
   */
  @Test
  @DisplayName("Test add(FloatValue) with 'FloatValue'; then return CompositeFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.add(FloatValue)"})
  void testAddWithFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualAddResult =
        particularFloatValue.add(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualAddResult instanceof CompositeFloatValue);
    assertFalse(actualAddResult.isCategory2());
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#add(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#add(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test add(FloatValue) with 'FloatValue'; when FLOAT_VALUE_0; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.add(FloatValue)"})
  void testAddWithFloatValue_whenFloat_value_0_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualAddResult = particularFloatValue.add(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualAddResult instanceof ParticularFloatValue);
    assertEquals(particularFloatValue, actualAddResult);
  }

  /**
   * Test {@link ParticularFloatValue#add(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#add(FloatValue)}
   */
  @Test
  @DisplayName("Test add(FloatValue) with 'FloatValue'; when FLOAT_VALUE; then return FLOAT_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.add(FloatValue)"})
  void testAddWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act
    FloatValue actualAddResult = new ParticularFloatValue(10.0f).add(other);

    // Assert
    assertSame(other, actualAddResult);
  }

  /**
   * Test {@link ParticularFloatValue#add(ParticularFloatValue)} with {@code ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#add(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularFloatValue) with 'ParticularFloatValue'; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.add(ParticularFloatValue)"})
  void testAddWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualAddResult = particularFloatValue.add(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualAddResult instanceof ParticularFloatValue);
    assertEquals(20.0f, actualAddResult.value());
    assertFalse(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#subtract(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#subtract(FloatValue)}
   */
  @Test
  @DisplayName("Test subtract(FloatValue) with 'FloatValue'; then return CompositeFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.subtract(FloatValue)"})
  void testSubtractWithFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractResult =
        particularFloatValue.subtract(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractResult.isCategory2());
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#subtract(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#subtract(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(FloatValue) with 'FloatValue'; when FLOAT_VALUE_0; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.subtract(FloatValue)"})
  void testSubtractWithFloatValue_whenFloat_value_0_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractResult =
        particularFloatValue.subtract(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularFloatValue);
    assertEquals(particularFloatValue, actualSubtractResult);
  }

  /**
   * Test {@link ParticularFloatValue#subtract(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#subtract(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(FloatValue) with 'FloatValue'; when FLOAT_VALUE; then return FLOAT_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.subtract(FloatValue)"})
  void testSubtractWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act
    FloatValue actualSubtractResult = new ParticularFloatValue(10.0f).subtract(other);

    // Assert
    assertSame(other, actualSubtractResult);
  }

  /**
   * Test {@link ParticularFloatValue#subtract(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#subtract(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(ParticularFloatValue) with 'ParticularFloatValue'; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.subtract(ParticularFloatValue)"})
  void testSubtractWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractResult =
        particularFloatValue.subtract(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularFloatValue);
    assertEquals(0.0f, actualSubtractResult.value());
    assertFalse(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#subtractFrom(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#subtractFrom(FloatValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(FloatValue) with 'FloatValue'; then return CompositeFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.subtractFrom(FloatValue)"})
  void testSubtractFromWithFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractFromResult =
        particularFloatValue.subtractFrom(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeFloatValue);
    assertFalse(actualSubtractFromResult.isCategory2());
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#subtractFrom(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#subtractFrom(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(FloatValue) with 'FloatValue'; when FLOAT_VALUE_0; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.subtractFrom(FloatValue)"})
  void testSubtractFromWithFloatValue_whenFloat_value_0_thenReturnParticularFloatValue() {
    // Arrange and Act
    FloatValue actualSubtractFromResult =
        new ParticularFloatValue(10.0f).subtractFrom(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularFloatValue);
    assertEquals(-10.0f, actualSubtractFromResult.value());
    assertFalse(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#subtractFrom(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#subtractFrom(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(FloatValue) with 'FloatValue'; when FLOAT_VALUE; then return FLOAT_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.subtractFrom(FloatValue)"})
  void testSubtractFromWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act
    FloatValue actualSubtractFromResult = new ParticularFloatValue(10.0f).subtractFrom(other);

    // Assert
    assertSame(other, actualSubtractFromResult);
  }

  /**
   * Test {@link ParticularFloatValue#subtractFrom(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#subtractFrom(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(ParticularFloatValue) with 'ParticularFloatValue'; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.subtractFrom(ParticularFloatValue)"})
  void testSubtractFromWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualSubtractFromResult =
        particularFloatValue.subtractFrom(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularFloatValue);
    assertEquals(0.0f, actualSubtractFromResult.value());
    assertFalse(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#multiply(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#multiply(FloatValue)}
   */
  @Test
  @DisplayName("Test multiply(FloatValue) with 'FloatValue'; then return CompositeFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.multiply(FloatValue)"})
  void testMultiplyWithFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualMultiplyResult =
        particularFloatValue.multiply(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeFloatValue);
    assertFalse(actualMultiplyResult.isCategory2());
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#multiply(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#multiply(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(FloatValue) with 'FloatValue'; when FLOAT_VALUE_0; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.multiply(FloatValue)"})
  void testMultiplyWithFloatValue_whenFloat_value_0_thenReturnParticularFloatValue() {
    // Arrange
    FloatValue other = ParticularValueFactory.FLOAT_VALUE_0;

    // Act
    FloatValue actualMultiplyResult = new ParticularFloatValue(10.0f).multiply(other);

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularFloatValue);
    assertEquals(other, actualMultiplyResult);
  }

  /**
   * Test {@link ParticularFloatValue#multiply(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#multiply(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(FloatValue) with 'FloatValue'; when FLOAT_VALUE; then return FLOAT_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.multiply(FloatValue)"})
  void testMultiplyWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act
    FloatValue actualMultiplyResult = new ParticularFloatValue(10.0f).multiply(other);

    // Assert
    assertSame(other, actualMultiplyResult);
  }

  /**
   * Test {@link ParticularFloatValue#multiply(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#multiply(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(ParticularFloatValue) with 'ParticularFloatValue'; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.multiply(ParticularFloatValue)"})
  void testMultiplyWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualMultiplyResult =
        particularFloatValue.multiply(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularFloatValue);
    assertEquals(100.0f, actualMultiplyResult.value());
    assertFalse(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#divide(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#divide(FloatValue)}
   */
  @Test
  @DisplayName("Test divide(FloatValue) with 'FloatValue'; then return CompositeFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.divide(FloatValue)"})
  void testDivideWithFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualDivideResult =
        particularFloatValue.divide(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeFloatValue);
    assertFalse(actualDivideResult.isCategory2());
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#divide(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#divide(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test divide(FloatValue) with 'FloatValue'; when FLOAT_VALUE_0; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.divide(FloatValue)"})
  void testDivideWithFloatValue_whenFloat_value_0_thenReturnParticularFloatValue() {
    // Arrange and Act
    FloatValue actualDivideResult =
        new ParticularFloatValue(10.0f).divide(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualDivideResult instanceof ParticularFloatValue);
    assertFalse(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
    assertEquals(Float.POSITIVE_INFINITY, actualDivideResult.value());
  }

  /**
   * Test {@link ParticularFloatValue#divide(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#divide(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test divide(FloatValue) with 'FloatValue'; when FLOAT_VALUE; then return FLOAT_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.divide(FloatValue)"})
  void testDivideWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act
    FloatValue actualDivideResult = new ParticularFloatValue(10.0f).divide(other);

    // Assert
    assertSame(other, actualDivideResult);
  }

  /**
   * Test {@link ParticularFloatValue#divide(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#divide(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularFloatValue) with 'ParticularFloatValue'; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.divide(ParticularFloatValue)"})
  void testDivideWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualDivideResult = particularFloatValue.divide(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideResult instanceof ParticularFloatValue);
    assertEquals(1.0f, actualDivideResult.value());
    assertFalse(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#divideOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#divideOf(FloatValue)}
   */
  @Test
  @DisplayName("Test divideOf(FloatValue) with 'FloatValue'; then return CompositeFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.divideOf(FloatValue)"})
  void testDivideOfWithFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualDivideOfResult =
        particularFloatValue.divideOf(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeFloatValue);
    assertFalse(actualDivideOfResult.isCategory2());
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#divideOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#divideOf(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(FloatValue) with 'FloatValue'; when FLOAT_VALUE_0; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.divideOf(FloatValue)"})
  void testDivideOfWithFloatValue_whenFloat_value_0_thenReturnParticularFloatValue() {
    // Arrange
    FloatValue other = ParticularValueFactory.FLOAT_VALUE_0;

    // Act
    FloatValue actualDivideOfResult = new ParticularFloatValue(10.0f).divideOf(other);

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularFloatValue);
    assertEquals(other, actualDivideOfResult);
  }

  /**
   * Test {@link ParticularFloatValue#divideOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#divideOf(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(FloatValue) with 'FloatValue'; when FLOAT_VALUE; then return FLOAT_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.divideOf(FloatValue)"})
  void testDivideOfWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act
    FloatValue actualDivideOfResult = new ParticularFloatValue(10.0f).divideOf(other);

    // Assert
    assertSame(other, actualDivideOfResult);
  }

  /**
   * Test {@link ParticularFloatValue#divideOf(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#divideOf(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(ParticularFloatValue) with 'ParticularFloatValue'; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.divideOf(ParticularFloatValue)"})
  void testDivideOfWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualDivideOfResult =
        particularFloatValue.divideOf(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularFloatValue);
    assertEquals(1.0f, actualDivideOfResult.value());
    assertFalse(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#remainder(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#remainder(FloatValue)}
   */
  @Test
  @DisplayName("Test remainder(FloatValue) with 'FloatValue'; then return CompositeFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.remainder(FloatValue)"})
  void testRemainderWithFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualRemainderResult =
        particularFloatValue.remainder(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#remainder(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#remainder(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(FloatValue) with 'FloatValue'; when FLOAT_VALUE_0; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.remainder(FloatValue)"})
  void testRemainderWithFloatValue_whenFloat_value_0_thenReturnParticularFloatValue() {
    // Arrange and Act
    FloatValue actualRemainderResult =
        new ParticularFloatValue(10.0f).remainder(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularFloatValue);
    assertFalse(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
    assertEquals(Float.NaN, actualRemainderResult.value());
  }

  /**
   * Test {@link ParticularFloatValue#remainder(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#remainder(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(FloatValue) with 'FloatValue'; when FLOAT_VALUE; then return FLOAT_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.remainder(FloatValue)"})
  void testRemainderWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act
    FloatValue actualRemainderResult = new ParticularFloatValue(10.0f).remainder(other);

    // Assert
    assertSame(other, actualRemainderResult);
  }

  /**
   * Test {@link ParticularFloatValue#remainder(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#remainder(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(ParticularFloatValue) with 'ParticularFloatValue'; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.remainder(ParticularFloatValue)"})
  void testRemainderWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualRemainderResult =
        particularFloatValue.remainder(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularFloatValue);
    assertEquals(0.0f, actualRemainderResult.value());
    assertFalse(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#remainderOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#remainderOf(FloatValue)}
   */
  @Test
  @DisplayName("Test remainderOf(FloatValue) with 'FloatValue'; then return CompositeFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.remainderOf(FloatValue)"})
  void testRemainderOfWithFloatValue_thenReturnCompositeFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualRemainderOfResult =
        particularFloatValue.remainderOf(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeFloatValue);
    assertFalse(actualRemainderOfResult.isCategory2());
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#remainderOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#remainderOf(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(FloatValue) with 'FloatValue'; when FLOAT_VALUE_0; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.remainderOf(FloatValue)"})
  void testRemainderOfWithFloatValue_whenFloat_value_0_thenReturnParticularFloatValue() {
    // Arrange
    FloatValue other = ParticularValueFactory.FLOAT_VALUE_0;

    // Act
    FloatValue actualRemainderOfResult = new ParticularFloatValue(10.0f).remainderOf(other);

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularFloatValue);
    assertEquals(other, actualRemainderOfResult);
  }

  /**
   * Test {@link ParticularFloatValue#remainderOf(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link BasicValueFactory#FLOAT_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#remainderOf(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(FloatValue) with 'FloatValue'; when FLOAT_VALUE; then return FLOAT_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.remainderOf(FloatValue)"})
  void testRemainderOfWithFloatValue_whenFloat_value_thenReturnFloat_value() {
    // Arrange
    FloatValue other = BasicValueFactory.FLOAT_VALUE;

    // Act
    FloatValue actualRemainderOfResult = new ParticularFloatValue(10.0f).remainderOf(other);

    // Assert
    assertSame(other, actualRemainderOfResult);
  }

  /**
   * Test {@link ParticularFloatValue#remainderOf(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#remainderOf(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(ParticularFloatValue) with 'ParticularFloatValue'; then return ParticularFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularFloatValue.remainderOf(ParticularFloatValue)"})
  void testRemainderOfWithParticularFloatValue_thenReturnParticularFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    FloatValue actualRemainderOfResult =
        particularFloatValue.remainderOf(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularFloatValue);
    assertEquals(0.0f, actualRemainderOfResult.value());
    assertFalse(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#compare(FloatValue)} with {@code FloatValue}.
   *
   * <p>Method under test: {@link ParticularFloatValue#compare(FloatValue)}
   */
  @Test
  @DisplayName("Test compare(FloatValue) with 'FloatValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.compare(FloatValue)"})
  void testCompareWithFloatValue() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    IntegerValue actualCompareResult =
        particularFloatValue.compare(
            (FloatValue)
                new CompositeFloatValue(
                    BasicValueFactory.FLOAT_VALUE, (byte) 'A', BasicValueFactory.FLOAT_VALUE));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#compare(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return value is {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#compare(FloatValue)}
   */
  @Test
  @DisplayName("Test compare(FloatValue) with 'FloatValue'; then return value is NEVER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.compare(FloatValue)"})
  void testCompareWithFloatValue_thenReturnValueIsNever() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        new ParticularFloatValue(-0.5f).compare(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
    assertEquals(Value.NEVER, actualCompareResult.value());
  }

  /**
   * Test {@link ParticularFloatValue#compare(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>Then return value is zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#compare(FloatValue)}
   */
  @Test
  @DisplayName("Test compare(FloatValue) with 'FloatValue'; then return value is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.compare(FloatValue)"})
  void testCompareWithFloatValue_thenReturnValueIsZero() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    IntegerValue actualCompareResult =
        particularFloatValue.compare((FloatValue) new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(0, actualCompareResult.value());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#compare(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#FLOAT_VALUE_0}.
   *   <li>Then return value is one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#compare(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test compare(FloatValue) with 'FloatValue'; when FLOAT_VALUE_0; then return value is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.compare(FloatValue)"})
  void testCompareWithFloatValue_whenFloat_value_0_thenReturnValueIsOne() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        new ParticularFloatValue(10.0f).compare(ParticularValueFactory.FLOAT_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(1, actualCompareResult.value());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#compare(FloatValue)} with {@code FloatValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#FLOAT_VALUE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#compare(FloatValue)}
   */
  @Test
  @DisplayName(
      "Test compare(FloatValue) with 'FloatValue'; when FLOAT_VALUE; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.compare(FloatValue)"})
  void testCompareWithFloatValue_whenFloat_value_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        new ParticularFloatValue(10.0f).compare(BasicValueFactory.FLOAT_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#compare(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return value is {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#compare(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test compare(ParticularFloatValue) with 'ParticularFloatValue'; then return value is NEVER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.compare(ParticularFloatValue)"})
  void testCompareWithParticularFloatValue_thenReturnValueIsNever() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(0.5f);

    // Act
    IntegerValue actualCompareResult =
        particularFloatValue.compare(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
    assertEquals(Value.NEVER, actualCompareResult.value());
  }

  /**
   * Test {@link ParticularFloatValue#compare(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return value is one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#compare(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test compare(ParticularFloatValue) with 'ParticularFloatValue'; then return value is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.compare(ParticularFloatValue)"})
  void testCompareWithParticularFloatValue_thenReturnValueIsOne() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(Float.NaN);

    // Act
    IntegerValue actualCompareResult =
        particularFloatValue.compare(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(1, actualCompareResult.value());
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#compare(ParticularFloatValue)} with {@code
   * ParticularFloatValue}.
   *
   * <ul>
   *   <li>Then return value is zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#compare(ParticularFloatValue)}
   */
  @Test
  @DisplayName(
      "Test compare(ParticularFloatValue) with 'ParticularFloatValue'; then return value is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularFloatValue.compare(ParticularFloatValue)"})
  void testCompareWithParticularFloatValue_thenReturnValueIsZero() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act
    IntegerValue actualCompareResult =
        particularFloatValue.compare(new ParticularFloatValue(10.0f));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(0, actualCompareResult.value());
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularFloatValue#equals(Object)}, and {@link ParticularFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParticularFloatValue#equals(Object)}
   *   <li>{@link ParticularFloatValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParticularFloatValue.equals(Object)",
    "int ParticularFloatValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);
    ParticularFloatValue particularFloatValue2 = new ParticularFloatValue(10.0f);

    // Act and Assert
    assertEquals(particularFloatValue, particularFloatValue2);
    assertEquals(particularFloatValue.hashCode(), particularFloatValue2.hashCode());
  }

  /**
   * Test {@link ParticularFloatValue#equals(Object)}, and {@link ParticularFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParticularFloatValue#equals(Object)}
   *   <li>{@link ParticularFloatValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParticularFloatValue.equals(Object)",
    "int ParticularFloatValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(10.0f);

    // Act and Assert
    assertEquals(particularFloatValue, particularFloatValue);
    int expectedHashCodeResult = particularFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, particularFloatValue.hashCode());
  }

  /**
   * Test {@link ParticularFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParticularFloatValue.equals(Object)",
    "int ParticularFloatValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularFloatValue particularFloatValue = new ParticularFloatValue(0.5f);

    // Act and Assert
    assertNotEquals(particularFloatValue, new ParticularFloatValue(10.0f));
  }

  /**
   * Test {@link ParticularFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParticularFloatValue.equals(Object)",
    "int ParticularFloatValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularFloatValue(10.0f), null);
  }

  /**
   * Test {@link ParticularFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularFloatValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParticularFloatValue.equals(Object)",
    "int ParticularFloatValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularFloatValue(10.0f), "Different type to ParticularFloatValue");
  }
}
