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

class ParticularDoubleValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParticularDoubleValue#ParticularDoubleValue(double)}
   *   <li>{@link ParticularDoubleValue#toString()}
   *   <li>{@link ParticularDoubleValue#isParticular()}
   *   <li>{@link ParticularDoubleValue#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ParticularDoubleValue.<init>(double)",
    "boolean ParticularDoubleValue.isParticular()",
    "String ParticularDoubleValue.toString()",
    "double ParticularDoubleValue.value()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ParticularDoubleValue actualParticularDoubleValue = new ParticularDoubleValue(10.0d);
    String actualToStringResult = actualParticularDoubleValue.toString();
    boolean actualIsParticularResult = actualParticularDoubleValue.isParticular();

    // Assert
    assertEquals("10.0d", actualToStringResult);
    assertEquals(10.0d, actualParticularDoubleValue.value());
    assertTrue(actualIsParticularResult);
  }

  /**
   * Test {@link ParticularDoubleValue#negate()}.
   *
   * <p>Method under test: {@link ParticularDoubleValue#negate()}
   */
  @Test
  @DisplayName("Test negate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.negate()"})
  void testNegate() {
    // Arrange and Act
    DoubleValue actualNegateResult = new ParticularDoubleValue(10.0d).negate();

    // Assert
    assertTrue(actualNegateResult instanceof ParticularDoubleValue);
    assertEquals(-10.0d, actualNegateResult.value());
    assertTrue(actualNegateResult.isCategory2());
    assertTrue(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#convertToInteger()}.
   *
   * <p>Method under test: {@link ParticularDoubleValue#convertToInteger()}
   */
  @Test
  @DisplayName("Test convertToInteger()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularDoubleValue.convertToInteger()"})
  void testConvertToInteger() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult = new ParticularDoubleValue(10.0d).convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof ParticularIntegerValue);
    assertEquals(10, actualConvertToIntegerResult.value());
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertTrue(actualConvertToIntegerResult.isParticular());
    assertTrue(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#convertToLong()}.
   *
   * <p>Method under test: {@link ParticularDoubleValue#convertToLong()}
   */
  @Test
  @DisplayName("Test convertToLong()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularDoubleValue.convertToLong()"})
  void testConvertToLong() {
    // Arrange and Act
    LongValue actualConvertToLongResult = new ParticularDoubleValue(10.0d).convertToLong();

    // Assert
    assertTrue(actualConvertToLongResult instanceof ParticularLongValue);
    assertEquals(10L, actualConvertToLongResult.value());
    assertTrue(actualConvertToLongResult.isCategory2());
    assertTrue(actualConvertToLongResult.isParticular());
    assertTrue(actualConvertToLongResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#convertToFloat()}.
   *
   * <p>Method under test: {@link ParticularDoubleValue#convertToFloat()}
   */
  @Test
  @DisplayName("Test convertToFloat()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularDoubleValue.convertToFloat()"})
  void testConvertToFloat() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = new ParticularDoubleValue(10.0d).convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof ParticularFloatValue);
    assertEquals(10.0f, actualConvertToFloatResult.value());
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertTrue(actualConvertToFloatResult.isParticular());
    assertTrue(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#generalize(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link ParticularDoubleValue#generalize(DoubleValue)}
   */
  @Test
  @DisplayName("Test generalize(DoubleValue) with 'DoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.generalize(DoubleValue)"})
  void testGeneralizeWithDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualGeneralizeResult =
        particularDoubleValue.generalize(
            (DoubleValue)
                new CompositeDoubleValue(
                    BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link ParticularDoubleValue#generalize(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#generalize(DoubleValue)}
   */
  @Test
  @DisplayName("Test generalize(DoubleValue) with 'DoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.generalize(DoubleValue)"})
  void testGeneralizeWithDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);
    ParticularDoubleValue other = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualGeneralizeResult = particularDoubleValue.generalize((DoubleValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof ParticularDoubleValue);
    assertEquals(particularDoubleValue, actualGeneralizeResult);
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link ParticularDoubleValue#generalize(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return {@link UnknownDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#generalize(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE_0; then return UnknownDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.generalize(DoubleValue)"})
  void testGeneralizeWithDoubleValue_whenDouble_value_0_thenReturnUnknownDoubleValue() {
    // Arrange and Act
    DoubleValue actualGeneralizeResult =
        new ParticularDoubleValue(10.0d).generalize(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link ParticularDoubleValue#generalize(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#generalize(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.generalize(DoubleValue)"})
  void testGeneralizeWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act
    DoubleValue actualGeneralizeResult = new ParticularDoubleValue(10.0d).generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link ParticularDoubleValue#generalize(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <p>Method under test: {@link ParticularDoubleValue#generalize(ParticularDoubleValue)}
   */
  @Test
  @DisplayName("Test generalize(ParticularDoubleValue) with 'ParticularDoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.generalize(ParticularDoubleValue)"})
  void testGeneralizeWithParticularDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualGeneralizeResult =
        particularDoubleValue.generalize(new ParticularDoubleValue(10.0d));

    // Assert
    assertSame(particularDoubleValue, actualGeneralizeResult);
  }

  /**
   * Test {@link ParticularDoubleValue#generalize(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#generalize(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularDoubleValue) with 'ParticularDoubleValue'; then return UnknownDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.generalize(ParticularDoubleValue)"})
  void testGeneralizeWithParticularDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(0.5d);

    // Act
    DoubleValue actualGeneralizeResult =
        particularDoubleValue.generalize(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownDoubleValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link ParticularDoubleValue#add(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#add(DoubleValue)}
   */
  @Test
  @DisplayName("Test add(DoubleValue) with 'DoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.add(DoubleValue)"})
  void testAddWithDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualAddResult =
        particularDoubleValue.add(
            (DoubleValue)
                new CompositeDoubleValue(
                    BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualAddResult instanceof CompositeDoubleValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#add(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#add(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test add(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE_0; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.add(DoubleValue)"})
  void testAddWithDoubleValue_whenDouble_value_0_thenReturnParticularDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualAddResult = particularDoubleValue.add(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualAddResult instanceof ParticularDoubleValue);
    assertEquals(particularDoubleValue, actualAddResult);
  }

  /**
   * Test {@link ParticularDoubleValue#add(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#add(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test add(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.add(DoubleValue)"})
  void testAddWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act
    DoubleValue actualAddResult = new ParticularDoubleValue(10.0d).add(other);

    // Assert
    assertSame(other, actualAddResult);
  }

  /**
   * Test {@link ParticularDoubleValue#add(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#add(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularDoubleValue) with 'ParticularDoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.add(ParticularDoubleValue)"})
  void testAddWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualAddResult = particularDoubleValue.add(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualAddResult instanceof ParticularDoubleValue);
    assertEquals(20.0d, actualAddResult.value());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#subtract(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#subtract(DoubleValue)}
   */
  @Test
  @DisplayName("Test subtract(DoubleValue) with 'DoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.subtract(DoubleValue)"})
  void testSubtractWithDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualSubtractResult =
        particularDoubleValue.subtract(
            (DoubleValue)
                new CompositeDoubleValue(
                    BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#subtract(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#subtract(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE_0; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.subtract(DoubleValue)"})
  void testSubtractWithDoubleValue_whenDouble_value_0_thenReturnParticularDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualSubtractResult =
        particularDoubleValue.subtract(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularDoubleValue);
    assertEquals(particularDoubleValue, actualSubtractResult);
  }

  /**
   * Test {@link ParticularDoubleValue#subtract(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#subtract(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.subtract(DoubleValue)"})
  void testSubtractWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act
    DoubleValue actualSubtractResult = new ParticularDoubleValue(10.0d).subtract(other);

    // Assert
    assertSame(other, actualSubtractResult);
  }

  /**
   * Test {@link ParticularDoubleValue#subtract(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#subtract(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(ParticularDoubleValue) with 'ParticularDoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.subtract(ParticularDoubleValue)"})
  void testSubtractWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualSubtractResult =
        particularDoubleValue.subtract(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularDoubleValue);
    assertEquals(0.0d, actualSubtractResult.value());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#subtractFrom(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#subtractFrom(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(DoubleValue) with 'DoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.subtractFrom(DoubleValue)"})
  void testSubtractFromWithDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualSubtractFromResult =
        particularDoubleValue.subtractFrom(
            (DoubleValue)
                new CompositeDoubleValue(
                    BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeDoubleValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#subtractFrom(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#subtractFrom(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(DoubleValue) with 'DoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.subtractFrom(DoubleValue)"})
  void testSubtractFromWithDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange and Act
    DoubleValue actualSubtractFromResult =
        new ParticularDoubleValue(10.0d).subtractFrom(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularDoubleValue);
    assertEquals(-10.0d, actualSubtractFromResult.value());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#subtractFrom(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#subtractFrom(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.subtractFrom(DoubleValue)"})
  void testSubtractFromWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act
    DoubleValue actualSubtractFromResult = new ParticularDoubleValue(10.0d).subtractFrom(other);

    // Assert
    assertSame(other, actualSubtractFromResult);
  }

  /**
   * Test {@link ParticularDoubleValue#subtractFrom(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#subtractFrom(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(ParticularDoubleValue) with 'ParticularDoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.subtractFrom(ParticularDoubleValue)"})
  void testSubtractFromWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualSubtractFromResult =
        particularDoubleValue.subtractFrom(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularDoubleValue);
    assertEquals(0.0d, actualSubtractFromResult.value());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#multiply(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#multiply(DoubleValue)}
   */
  @Test
  @DisplayName("Test multiply(DoubleValue) with 'DoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.multiply(DoubleValue)"})
  void testMultiplyWithDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualMultiplyResult =
        particularDoubleValue.multiply(
            (DoubleValue)
                new CompositeDoubleValue(
                    BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeDoubleValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#multiply(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#multiply(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE_0; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.multiply(DoubleValue)"})
  void testMultiplyWithDoubleValue_whenDouble_value_0_thenReturnParticularDoubleValue() {
    // Arrange
    DoubleValue other = ParticularValueFactory.DOUBLE_VALUE_0;

    // Act
    DoubleValue actualMultiplyResult = new ParticularDoubleValue(10.0d).multiply(other);

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularDoubleValue);
    assertEquals(other, actualMultiplyResult);
  }

  /**
   * Test {@link ParticularDoubleValue#multiply(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#multiply(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.multiply(DoubleValue)"})
  void testMultiplyWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act
    DoubleValue actualMultiplyResult = new ParticularDoubleValue(10.0d).multiply(other);

    // Assert
    assertSame(other, actualMultiplyResult);
  }

  /**
   * Test {@link ParticularDoubleValue#multiply(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#multiply(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(ParticularDoubleValue) with 'ParticularDoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.multiply(ParticularDoubleValue)"})
  void testMultiplyWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualMultiplyResult =
        particularDoubleValue.multiply(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularDoubleValue);
    assertEquals(100.0d, actualMultiplyResult.value());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#divide(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#divide(DoubleValue)}
   */
  @Test
  @DisplayName("Test divide(DoubleValue) with 'DoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.divide(DoubleValue)"})
  void testDivideWithDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualDivideResult =
        particularDoubleValue.divide(
            (DoubleValue)
                new CompositeDoubleValue(
                    BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#divide(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#divide(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divide(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE_0; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.divide(DoubleValue)"})
  void testDivideWithDoubleValue_whenDouble_value_0_thenReturnParticularDoubleValue() {
    // Arrange and Act
    DoubleValue actualDivideResult =
        new ParticularDoubleValue(10.0d).divide(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualDivideResult instanceof ParticularDoubleValue);
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
    assertEquals(Double.POSITIVE_INFINITY, actualDivideResult.value());
  }

  /**
   * Test {@link ParticularDoubleValue#divide(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#divide(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divide(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.divide(DoubleValue)"})
  void testDivideWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act
    DoubleValue actualDivideResult = new ParticularDoubleValue(10.0d).divide(other);

    // Assert
    assertSame(other, actualDivideResult);
  }

  /**
   * Test {@link ParticularDoubleValue#divide(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#divide(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularDoubleValue) with 'ParticularDoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.divide(ParticularDoubleValue)"})
  void testDivideWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualDivideResult = particularDoubleValue.divide(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideResult instanceof ParticularDoubleValue);
    assertEquals(1.0d, actualDivideResult.value());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#divideOf(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#divideOf(DoubleValue)}
   */
  @Test
  @DisplayName("Test divideOf(DoubleValue) with 'DoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.divideOf(DoubleValue)"})
  void testDivideOfWithDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualDivideOfResult =
        particularDoubleValue.divideOf(
            (DoubleValue)
                new CompositeDoubleValue(
                    BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeDoubleValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#divideOf(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#divideOf(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE_0; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.divideOf(DoubleValue)"})
  void testDivideOfWithDoubleValue_whenDouble_value_0_thenReturnParticularDoubleValue() {
    // Arrange
    DoubleValue other = ParticularValueFactory.DOUBLE_VALUE_0;

    // Act
    DoubleValue actualDivideOfResult = new ParticularDoubleValue(10.0d).divideOf(other);

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularDoubleValue);
    assertEquals(other, actualDivideOfResult);
  }

  /**
   * Test {@link ParticularDoubleValue#divideOf(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#divideOf(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.divideOf(DoubleValue)"})
  void testDivideOfWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act
    DoubleValue actualDivideOfResult = new ParticularDoubleValue(10.0d).divideOf(other);

    // Assert
    assertSame(other, actualDivideOfResult);
  }

  /**
   * Test {@link ParticularDoubleValue#divideOf(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#divideOf(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(ParticularDoubleValue) with 'ParticularDoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.divideOf(ParticularDoubleValue)"})
  void testDivideOfWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualDivideOfResult =
        particularDoubleValue.divideOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularDoubleValue);
    assertEquals(1.0d, actualDivideOfResult.value());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#remainder(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#remainder(DoubleValue)}
   */
  @Test
  @DisplayName("Test remainder(DoubleValue) with 'DoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.remainder(DoubleValue)"})
  void testRemainderWithDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualRemainderResult =
        particularDoubleValue.remainder(
            (DoubleValue)
                new CompositeDoubleValue(
                    BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#remainder(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#remainder(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE_0; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.remainder(DoubleValue)"})
  void testRemainderWithDoubleValue_whenDouble_value_0_thenReturnParticularDoubleValue() {
    // Arrange and Act
    DoubleValue actualRemainderResult =
        new ParticularDoubleValue(10.0d).remainder(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularDoubleValue);
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
    assertEquals(Double.NaN, actualRemainderResult.value());
  }

  /**
   * Test {@link ParticularDoubleValue#remainder(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#remainder(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.remainder(DoubleValue)"})
  void testRemainderWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act
    DoubleValue actualRemainderResult = new ParticularDoubleValue(10.0d).remainder(other);

    // Assert
    assertSame(other, actualRemainderResult);
  }

  /**
   * Test {@link ParticularDoubleValue#remainder(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#remainder(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(ParticularDoubleValue) with 'ParticularDoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.remainder(ParticularDoubleValue)"})
  void testRemainderWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualRemainderResult =
        particularDoubleValue.remainder(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularDoubleValue);
    assertEquals(0.0d, actualRemainderResult.value());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#remainderOf(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#remainderOf(DoubleValue)}
   */
  @Test
  @DisplayName("Test remainderOf(DoubleValue) with 'DoubleValue'; then return CompositeDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.remainderOf(DoubleValue)"})
  void testRemainderOfWithDoubleValue_thenReturnCompositeDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualRemainderOfResult =
        particularDoubleValue.remainderOf(
            (DoubleValue)
                new CompositeDoubleValue(
                    BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeDoubleValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#remainderOf(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#remainderOf(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(DoubleValue) with 'DoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.remainderOf(DoubleValue)"})
  void testRemainderOfWithDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    DoubleValue other = ParticularValueFactory.DOUBLE_VALUE_0;

    // Act
    DoubleValue actualRemainderOfResult = new ParticularDoubleValue(10.0d).remainderOf(other);

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularDoubleValue);
    assertEquals(other, actualRemainderOfResult);
  }

  /**
   * Test {@link ParticularDoubleValue#remainderOf(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#remainderOf(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.remainderOf(DoubleValue)"})
  void testRemainderOfWithDoubleValue_whenDouble_value_thenReturnDouble_value() {
    // Arrange
    DoubleValue other = BasicValueFactory.DOUBLE_VALUE;

    // Act
    DoubleValue actualRemainderOfResult = new ParticularDoubleValue(10.0d).remainderOf(other);

    // Assert
    assertSame(other, actualRemainderOfResult);
  }

  /**
   * Test {@link ParticularDoubleValue#remainderOf(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#remainderOf(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(ParticularDoubleValue) with 'ParticularDoubleValue'; then return ParticularDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularDoubleValue.remainderOf(ParticularDoubleValue)"})
  void testRemainderOfWithParticularDoubleValue_thenReturnParticularDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    DoubleValue actualRemainderOfResult =
        particularDoubleValue.remainderOf(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularDoubleValue);
    assertEquals(0.0d, actualRemainderOfResult.value());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#compare(DoubleValue)} with {@code DoubleValue}.
   *
   * <p>Method under test: {@link ParticularDoubleValue#compare(DoubleValue)}
   */
  @Test
  @DisplayName("Test compare(DoubleValue) with 'DoubleValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularDoubleValue.compare(DoubleValue)"})
  void testCompareWithDoubleValue() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    IntegerValue actualCompareResult =
        particularDoubleValue.compare(
            (DoubleValue)
                new CompositeDoubleValue(
                    BasicValueFactory.DOUBLE_VALUE, (byte) 'A', BasicValueFactory.DOUBLE_VALUE));

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#compare(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Then return value is {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#compare(DoubleValue)}
   */
  @Test
  @DisplayName("Test compare(DoubleValue) with 'DoubleValue'; then return value is NEVER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularDoubleValue.compare(DoubleValue)"})
  void testCompareWithDoubleValue_thenReturnValueIsNever() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        new ParticularDoubleValue(-0.5d).compare(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
    assertEquals(Value.NEVER, actualCompareResult.value());
  }

  /**
   * Test {@link ParticularDoubleValue#compare(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>Then return value is zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#compare(DoubleValue)}
   */
  @Test
  @DisplayName("Test compare(DoubleValue) with 'DoubleValue'; then return value is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularDoubleValue.compare(DoubleValue)"})
  void testCompareWithDoubleValue_thenReturnValueIsZero() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    IntegerValue actualCompareResult =
        particularDoubleValue.compare((DoubleValue) new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(0, actualCompareResult.value());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#compare(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#DOUBLE_VALUE_0}.
   *   <li>Then return value is one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#compare(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test compare(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE_0; then return value is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularDoubleValue.compare(DoubleValue)"})
  void testCompareWithDoubleValue_whenDouble_value_0_thenReturnValueIsOne() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        new ParticularDoubleValue(10.0d).compare(ParticularValueFactory.DOUBLE_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(1, actualCompareResult.value());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#compare(DoubleValue)} with {@code DoubleValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#compare(DoubleValue)}
   */
  @Test
  @DisplayName(
      "Test compare(DoubleValue) with 'DoubleValue'; when DOUBLE_VALUE; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularDoubleValue.compare(DoubleValue)"})
  void testCompareWithDoubleValue_whenDouble_value_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        new ParticularDoubleValue(10.0d).compare(BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#compare(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return value is {@link Value#NEVER}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#compare(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test compare(ParticularDoubleValue) with 'ParticularDoubleValue'; then return value is NEVER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularDoubleValue.compare(ParticularDoubleValue)"})
  void testCompareWithParticularDoubleValue_thenReturnValueIsNever() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(0.5d);

    // Act
    IntegerValue actualCompareResult =
        particularDoubleValue.compare(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
    assertEquals(Value.NEVER, actualCompareResult.value());
  }

  /**
   * Test {@link ParticularDoubleValue#compare(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return value is one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#compare(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test compare(ParticularDoubleValue) with 'ParticularDoubleValue'; then return value is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularDoubleValue.compare(ParticularDoubleValue)"})
  void testCompareWithParticularDoubleValue_thenReturnValueIsOne() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(Double.NaN);

    // Act
    IntegerValue actualCompareResult =
        particularDoubleValue.compare(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(1, actualCompareResult.value());
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#compare(ParticularDoubleValue)} with {@code
   * ParticularDoubleValue}.
   *
   * <ul>
   *   <li>Then return value is zero.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#compare(ParticularDoubleValue)}
   */
  @Test
  @DisplayName(
      "Test compare(ParticularDoubleValue) with 'ParticularDoubleValue'; then return value is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularDoubleValue.compare(ParticularDoubleValue)"})
  void testCompareWithParticularDoubleValue_thenReturnValueIsZero() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);

    // Act
    IntegerValue actualCompareResult =
        particularDoubleValue.compare(new ParticularDoubleValue(10.0d));

    // Assert
    assertTrue(actualCompareResult instanceof ParticularIntegerValue);
    assertEquals(0, actualCompareResult.value());
    assertFalse(actualCompareResult.isCategory2());
    assertTrue(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularDoubleValue#equals(Object)}, and {@link
   * ParticularDoubleValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParticularDoubleValue#equals(Object)}
   *   <li>{@link ParticularDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParticularDoubleValue.equals(Object)",
    "int ParticularDoubleValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(10.0d);
    ParticularDoubleValue particularDoubleValue2 = new ParticularDoubleValue(10.0d);

    // Act and Assert
    assertEquals(particularDoubleValue, particularDoubleValue2);
    assertEquals(particularDoubleValue.hashCode(), particularDoubleValue2.hashCode());
  }

  /**
   * Test {@link ParticularDoubleValue#equals(Object)}, and {@link
   * ParticularDoubleValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParticularDoubleValue#equals(Object)}
   *   <li>{@link ParticularDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParticularDoubleValue.equals(Object)",
    "int ParticularDoubleValue.hashCode()"
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
   * Test {@link ParticularDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParticularDoubleValue.equals(Object)",
    "int ParticularDoubleValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularDoubleValue particularDoubleValue = new ParticularDoubleValue(0.5d);

    // Act and Assert
    assertNotEquals(particularDoubleValue, new ParticularDoubleValue(10.0d));
  }

  /**
   * Test {@link ParticularDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParticularDoubleValue.equals(Object)",
    "int ParticularDoubleValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularDoubleValue(10.0d), null);
  }

  /**
   * Test {@link ParticularDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParticularDoubleValue.equals(Object)",
    "int ParticularDoubleValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularDoubleValue(10.0d), "Different type to ParticularDoubleValue");
  }
}
