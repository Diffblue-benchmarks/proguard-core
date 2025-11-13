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

class ParticularLongValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParticularLongValue#ParticularLongValue(long)}
   *   <li>{@link ParticularLongValue#toString()}
   *   <li>{@link ParticularLongValue#isParticular()}
   *   <li>{@link ParticularLongValue#value()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ParticularLongValue.<init>(long)",
    "boolean ParticularLongValue.isParticular()",
    "String ParticularLongValue.toString()",
    "long ParticularLongValue.value()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ParticularLongValue actualParticularLongValue = new ParticularLongValue(42L);
    String actualToStringResult = actualParticularLongValue.toString();
    boolean actualIsParticularResult = actualParticularLongValue.isParticular();

    // Assert
    assertEquals("42L", actualToStringResult);
    assertEquals(42L, actualParticularLongValue.value());
    assertTrue(actualIsParticularResult);
  }

  /**
   * Test {@link ParticularLongValue#negate()}.
   *
   * <p>Method under test: {@link ParticularLongValue#negate()}
   */
  @Test
  @DisplayName("Test negate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.negate()"})
  void testNegate() {
    // Arrange and Act
    LongValue actualNegateResult = new ParticularLongValue(42L).negate();

    // Assert
    assertTrue(actualNegateResult instanceof ParticularLongValue);
    assertEquals(-42L, actualNegateResult.value());
    assertTrue(actualNegateResult.isCategory2());
    assertTrue(actualNegateResult.isParticular());
    assertTrue(actualNegateResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#convertToInteger()}.
   *
   * <p>Method under test: {@link ParticularLongValue#convertToInteger()}
   */
  @Test
  @DisplayName("Test convertToInteger()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularLongValue.convertToInteger()"})
  void testConvertToInteger() {
    // Arrange and Act
    IntegerValue actualConvertToIntegerResult = new ParticularLongValue(42L).convertToInteger();

    // Assert
    assertTrue(actualConvertToIntegerResult instanceof ParticularIntegerValue);
    assertEquals(42, actualConvertToIntegerResult.value());
    assertFalse(actualConvertToIntegerResult.isCategory2());
    assertTrue(actualConvertToIntegerResult.isParticular());
    assertTrue(actualConvertToIntegerResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#convertToFloat()}.
   *
   * <p>Method under test: {@link ParticularLongValue#convertToFloat()}
   */
  @Test
  @DisplayName("Test convertToFloat()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue ParticularLongValue.convertToFloat()"})
  void testConvertToFloat() {
    // Arrange and Act
    FloatValue actualConvertToFloatResult = new ParticularLongValue(42L).convertToFloat();

    // Assert
    assertTrue(actualConvertToFloatResult instanceof ParticularFloatValue);
    assertEquals(42.0f, actualConvertToFloatResult.value());
    assertFalse(actualConvertToFloatResult.isCategory2());
    assertTrue(actualConvertToFloatResult.isParticular());
    assertTrue(actualConvertToFloatResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#convertToDouble()}.
   *
   * <p>Method under test: {@link ParticularLongValue#convertToDouble()}
   */
  @Test
  @DisplayName("Test convertToDouble()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue ParticularLongValue.convertToDouble()"})
  void testConvertToDouble() {
    // Arrange and Act
    DoubleValue actualConvertToDoubleResult = new ParticularLongValue(42L).convertToDouble();

    // Assert
    assertTrue(actualConvertToDoubleResult instanceof ParticularDoubleValue);
    assertEquals(42.0d, actualConvertToDoubleResult.value());
    assertTrue(actualConvertToDoubleResult.isCategory2());
    assertTrue(actualConvertToDoubleResult.isParticular());
    assertTrue(actualConvertToDoubleResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#generalize(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link ParticularLongValue#generalize(LongValue)}
   */
  @Test
  @DisplayName("Test generalize(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.generalize(LongValue)"})
  void testGeneralizeWithLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualGeneralizeResult =
        particularLongValue.generalize(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link ParticularLongValue#generalize(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#generalize(LongValue)}
   */
  @Test
  @DisplayName("Test generalize(LongValue) with 'LongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.generalize(LongValue)"})
  void testGeneralizeWithLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualGeneralizeResult = particularLongValue.generalize((LongValue) other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualGeneralizeResult);
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link ParticularLongValue#generalize(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#generalize(LongValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(LongValue) with 'LongValue'; when LONG_VALUE_0; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.generalize(LongValue)"})
  void testGeneralizeWithLongValue_whenLong_value_0_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualGeneralizeResult =
        new ParticularLongValue(42L).generalize(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link ParticularLongValue#generalize(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#generalize(LongValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.generalize(LongValue)"})
  void testGeneralizeWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualGeneralizeResult = new ParticularLongValue(42L).generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link ParticularLongValue#generalize(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <p>Method under test: {@link ParticularLongValue#generalize(ParticularLongValue)}
   */
  @Test
  @DisplayName("Test generalize(ParticularLongValue) with 'ParticularLongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.generalize(ParticularLongValue)"})
  void testGeneralizeWithParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualGeneralizeResult = particularLongValue.generalize(new ParticularLongValue(42L));

    // Assert
    assertSame(particularLongValue, actualGeneralizeResult);
  }

  /**
   * Test {@link ParticularLongValue#generalize(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularLongValue#ParticularLongValue(long)} with value is one.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#generalize(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularLongValue) with 'ParticularLongValue'; given ParticularLongValue(long) with value is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.generalize(ParticularLongValue)"})
  void testGeneralizeWithParticularLongValue_givenParticularLongValueWithValueIsOne() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act
    LongValue actualGeneralizeResult = particularLongValue.generalize(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link ParticularLongValue#generalize(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#generalize(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularLongValue) with 'ParticularLongValue'; when 'null'; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.generalize(ParticularLongValue)"})
  void testGeneralizeWithParticularLongValue_whenNull_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualGeneralizeResult =
        new ParticularLongValue(42L).generalize((ParticularLongValue) null);

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link ParticularLongValue#add(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#add(LongValue)}
   */
  @Test
  @DisplayName("Test add(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.add(LongValue)"})
  void testAddWithLongValue_thenReturnCompositeLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualAddResult =
        particularLongValue.add(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAddResult instanceof CompositeLongValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#add(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#add(LongValue)}
   */
  @Test
  @DisplayName(
      "Test add(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.add(LongValue)"})
  void testAddWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualAddResult = particularLongValue.add(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualAddResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualAddResult);
  }

  /**
   * Test {@link ParticularLongValue#add(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#add(LongValue)}
   */
  @Test
  @DisplayName("Test add(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.add(LongValue)"})
  void testAddWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualAddResult = new ParticularLongValue(42L).add(other);

    // Assert
    assertSame(other, actualAddResult);
  }

  /**
   * Test {@link ParticularLongValue#add(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#add(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.add(ParticularLongValue)"})
  void testAddWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualAddResult = particularLongValue.add(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAddResult instanceof ParticularLongValue);
    assertEquals(84L, actualAddResult.value());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#subtract(LongValue)}
   */
  @Test
  @DisplayName("Test subtract(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.subtract(LongValue)"})
  void testSubtractWithLongValue_thenReturnCompositeLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractResult =
        particularLongValue.subtract(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeLongValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#subtract(LongValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.subtract(LongValue)"})
  void testSubtractWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractResult =
        particularLongValue.subtract(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualSubtractResult);
  }

  /**
   * Test {@link ParticularLongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#subtract(LongValue)}
   */
  @Test
  @DisplayName("Test subtract(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.subtract(LongValue)"})
  void testSubtractWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualSubtractResult = new ParticularLongValue(42L).subtract(other);

    // Assert
    assertSame(other, actualSubtractResult);
  }

  /**
   * Test {@link ParticularLongValue#subtract(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#subtract(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.subtract(ParticularLongValue)"})
  void testSubtractWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractResult = particularLongValue.subtract(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularLongValue);
    assertEquals(0L, actualSubtractResult.value());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#subtractFrom(LongValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.subtractFrom(LongValue)"})
  void testSubtractFromWithLongValue_thenReturnCompositeLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractFromResult =
        particularLongValue.subtractFrom(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeLongValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#subtractFrom(LongValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.subtractFrom(LongValue)"})
  void testSubtractFromWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange and Act
    LongValue actualSubtractFromResult =
        new ParticularLongValue(42L).subtractFrom(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularLongValue);
    assertEquals(-42L, actualSubtractFromResult.value());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#subtractFrom(LongValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.subtractFrom(LongValue)"})
  void testSubtractFromWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualSubtractFromResult = new ParticularLongValue(42L).subtractFrom(other);

    // Assert
    assertSame(other, actualSubtractFromResult);
  }

  /**
   * Test {@link ParticularLongValue#subtractFrom(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#subtractFrom(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.subtractFrom(ParticularLongValue)"})
  void testSubtractFromWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractFromResult =
        particularLongValue.subtractFrom(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularLongValue);
    assertEquals(0L, actualSubtractFromResult.value());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#multiply(LongValue)}
   */
  @Test
  @DisplayName("Test multiply(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.multiply(LongValue)"})
  void testMultiplyWithLongValue_thenReturnCompositeLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualMultiplyResult =
        particularLongValue.multiply(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeLongValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#multiply(LongValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.multiply(LongValue)"})
  void testMultiplyWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualMultiplyResult = new ParticularLongValue(42L).multiply(other);

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularLongValue);
    assertEquals(other, actualMultiplyResult);
  }

  /**
   * Test {@link ParticularLongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#multiply(LongValue)}
   */
  @Test
  @DisplayName("Test multiply(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.multiply(LongValue)"})
  void testMultiplyWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualMultiplyResult = new ParticularLongValue(42L).multiply(other);

    // Assert
    assertSame(other, actualMultiplyResult);
  }

  /**
   * Test {@link ParticularLongValue#multiply(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#multiply(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.multiply(ParticularLongValue)"})
  void testMultiplyWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualMultiplyResult = particularLongValue.multiply(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularLongValue);
    assertEquals(1764L, actualMultiplyResult.value());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#divide(LongValue)}
   */
  @Test
  @DisplayName("Test divide(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.divide(LongValue)"})
  void testDivideWithLongValue_thenReturnCompositeLongValue() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualDivideResult =
        particularLongValue.divide(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeLongValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_1}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#divide(LongValue)}
   */
  @Test
  @DisplayName(
      "Test divide(LongValue) with 'LongValue'; when LONG_VALUE_1; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.divide(LongValue)"})
  void testDivideWithLongValue_whenLong_value_1_thenReturnParticularLongValue()
      throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualDivideResult = particularLongValue.divide(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualDivideResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualDivideResult);
  }

  /**
   * Test {@link ParticularLongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#divide(LongValue)}
   */
  @Test
  @DisplayName("Test divide(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.divide(LongValue)"})
  void testDivideWithLongValue_whenLong_value_thenReturnLong_value() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualDivideResult = new ParticularLongValue(42L).divide(other);

    // Assert
    assertSame(other, actualDivideResult);
  }

  /**
   * Test {@link ParticularLongValue#divide(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#divide(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.divide(ParticularLongValue)"})
  void testDivideWithParticularLongValue_thenReturnParticularLongValue()
      throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualDivideResult = particularLongValue.divide(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideResult instanceof ParticularLongValue);
    assertEquals(1L, actualDivideResult.value());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#divideOf(LongValue)}
   */
  @Test
  @DisplayName("Test divideOf(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.divideOf(LongValue)"})
  void testDivideOfWithLongValue_thenReturnCompositeLongValue() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualDivideOfResult =
        particularLongValue.divideOf(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeLongValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#divideOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.divideOf(LongValue)"})
  void testDivideOfWithLongValue_whenLong_value_0_thenReturnParticularLongValue()
      throws ArithmeticException {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualDivideOfResult = new ParticularLongValue(42L).divideOf(other);

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularLongValue);
    assertEquals(other, actualDivideOfResult);
  }

  /**
   * Test {@link ParticularLongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#divideOf(LongValue)}
   */
  @Test
  @DisplayName("Test divideOf(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.divideOf(LongValue)"})
  void testDivideOfWithLongValue_whenLong_value_thenReturnLong_value() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualDivideOfResult = new ParticularLongValue(42L).divideOf(other);

    // Assert
    assertSame(other, actualDivideOfResult);
  }

  /**
   * Test {@link ParticularLongValue#divideOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#divideOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.divideOf(ParticularLongValue)"})
  void testDivideOfWithParticularLongValue_thenReturnParticularLongValue()
      throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualDivideOfResult = particularLongValue.divideOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularLongValue);
    assertEquals(1L, actualDivideOfResult.value());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#remainder(LongValue)}
   */
  @Test
  @DisplayName("Test remainder(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.remainder(LongValue)"})
  void testRemainderWithLongValue_thenReturnCompositeLongValue() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualRemainderResult =
        particularLongValue.remainder(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeLongValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_1}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#remainder(LongValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(LongValue) with 'LongValue'; when LONG_VALUE_1; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.remainder(LongValue)"})
  void testRemainderWithLongValue_whenLong_value_1_thenReturnParticularLongValue()
      throws ArithmeticException {
    // Arrange and Act
    LongValue actualRemainderResult =
        new ParticularLongValue(42L).remainder(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularLongValue);
    assertEquals(0L, actualRemainderResult.value());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#remainder(LongValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.remainder(LongValue)"})
  void testRemainderWithLongValue_whenLong_value_thenReturnLong_value() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualRemainderResult = new ParticularLongValue(42L).remainder(other);

    // Assert
    assertSame(other, actualRemainderResult);
  }

  /**
   * Test {@link ParticularLongValue#remainder(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#remainder(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.remainder(ParticularLongValue)"})
  void testRemainderWithParticularLongValue_thenReturnParticularLongValue()
      throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualRemainderResult = particularLongValue.remainder(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularLongValue);
    assertEquals(0L, actualRemainderResult.value());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#remainderOf(LongValue)}
   */
  @Test
  @DisplayName("Test remainderOf(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.remainderOf(LongValue)"})
  void testRemainderOfWithLongValue_thenReturnCompositeLongValue() throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualRemainderOfResult =
        particularLongValue.remainderOf(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeLongValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#remainderOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.remainderOf(LongValue)"})
  void testRemainderOfWithLongValue_whenLong_value_0_thenReturnParticularLongValue()
      throws ArithmeticException {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualRemainderOfResult = new ParticularLongValue(42L).remainderOf(other);

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularLongValue);
    assertEquals(other, actualRemainderOfResult);
  }

  /**
   * Test {@link ParticularLongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#remainderOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.remainderOf(LongValue)"})
  void testRemainderOfWithLongValue_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualRemainderOfResult = new ParticularLongValue(42L).remainderOf(other);

    // Assert
    assertSame(other, actualRemainderOfResult);
  }

  /**
   * Test {@link ParticularLongValue#remainderOf(ParticularLongValue)} with {@code
   * ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#remainderOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.remainderOf(ParticularLongValue)"})
  void testRemainderOfWithParticularLongValue_thenReturnParticularLongValue()
      throws ArithmeticException {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualRemainderOfResult =
        particularLongValue.remainderOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularLongValue);
    assertEquals(0L, actualRemainderOfResult.value());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(IntegerValue) with 'IntegerValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue_thenReturnCompositeLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftLeftResult =
        particularLongValue.shiftLeft(
            new ComparisonValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue_whenInteger_value_0_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftLeftResult =
        particularLongValue.shiftLeft(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftLeftResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualShiftLeftResult);
  }

  /**
   * Test {@link ParticularLongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue_whenInteger_value_byte_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftLeftResult =
        new ParticularLongValue(42L).shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
    assertTrue(actualShiftLeftResult.isCategory2());
  }

  /**
   * Test {@link ParticularLongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue_whenInteger_value_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftLeftResult =
        new ParticularLongValue(42L).shiftLeft(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
    assertTrue(actualShiftLeftResult.isCategory2());
  }

  /**
   * Test {@link ParticularLongValue#shiftLeft(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.shiftLeft(ParticularIntegerValue)"})
  void testShiftLeftWithParticularIntegerValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftLeftResult = particularLongValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof ParticularLongValue);
    assertEquals(184717953466368L, actualShiftLeftResult.value());
    assertTrue(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(IntegerValue) with 'IntegerValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue_thenReturnCompositeLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftRightResult =
        particularLongValue.shiftRight(
            new ComparisonValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue_whenInteger_value_0_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftRightResult =
        particularLongValue.shiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftRightResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualShiftRightResult);
  }

  /**
   * Test {@link ParticularLongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue_whenInteger_value_byte_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftRightResult =
        new ParticularLongValue(42L).shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isCategory2());
  }

  /**
   * Test {@link ParticularLongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue_whenInteger_value_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftRightResult =
        new ParticularLongValue(42L).shiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isCategory2());
  }

  /**
   * Test {@link ParticularLongValue#shiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.shiftRight(ParticularIntegerValue)"})
  void testShiftRightWithParticularIntegerValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualShiftRightResult =
        particularLongValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof ParticularLongValue);
    assertEquals(0L, actualShiftRightResult.value());
    assertTrue(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue_thenReturnCompositeLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualUnsignedShiftRightResult =
        particularLongValue.unsignedShiftRight(
            new ComparisonValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualUnsignedShiftRightResult =
        particularLongValue.unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualUnsignedShiftRightResult);
  }

  /**
   * Test {@link ParticularLongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue_whenInteger_value() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult =
        new ParticularLongValue(42L).unsignedShiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
  }

  /**
   * Test {@link ParticularLongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_BYTE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue_whenInteger_value_byte() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult =
        new ParticularLongValue(42L).unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
  }

  /**
   * Test {@link ParticularLongValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.unsignedShiftRight(ParticularIntegerValue)"})
  void testUnsignedShiftRightWithParticularIntegerValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualUnsignedShiftRightResult =
        particularLongValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof ParticularLongValue);
    assertEquals(0L, actualUnsignedShiftRightResult.value());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#and(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#and(LongValue)}
   */
  @Test
  @DisplayName("Test and(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.and(LongValue)"})
  void testAndWithLongValue_thenReturnCompositeLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualAndResult =
        particularLongValue.and(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualAndResult instanceof CompositeLongValue);
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isCategory2());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#and(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#and(LongValue)}
   */
  @Test
  @DisplayName(
      "Test and(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.and(LongValue)"})
  void testAndWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualAndResult = new ParticularLongValue(42L).and(other);

    // Assert
    assertTrue(actualAndResult instanceof ParticularLongValue);
    assertEquals(other, actualAndResult);
  }

  /**
   * Test {@link ParticularLongValue#and(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#and(LongValue)}
   */
  @Test
  @DisplayName("Test and(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.and(LongValue)"})
  void testAndWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualAndResult = new ParticularLongValue(42L).and(other);

    // Assert
    assertSame(other, actualAndResult);
  }

  /**
   * Test {@link ParticularLongValue#and(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#and(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test and(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.and(ParticularLongValue)"})
  void testAndWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualAndResult = particularLongValue.and(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAndResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualAndResult);
  }

  /**
   * Test {@link ParticularLongValue#or(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#or(LongValue)}
   */
  @Test
  @DisplayName("Test or(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.or(LongValue)"})
  void testOrWithLongValue_thenReturnCompositeLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualOrResult =
        particularLongValue.or(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualOrResult instanceof CompositeLongValue);
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isCategory2());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#or(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#or(LongValue)}
   */
  @Test
  @DisplayName(
      "Test or(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.or(LongValue)"})
  void testOrWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualOrResult = particularLongValue.or(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualOrResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualOrResult);
  }

  /**
   * Test {@link ParticularLongValue#or(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#or(LongValue)}
   */
  @Test
  @DisplayName("Test or(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.or(LongValue)"})
  void testOrWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualOrResult = new ParticularLongValue(42L).or(other);

    // Assert
    assertSame(other, actualOrResult);
  }

  /**
   * Test {@link ParticularLongValue#or(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#or(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test or(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.or(ParticularLongValue)"})
  void testOrWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualOrResult = particularLongValue.or(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualOrResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualOrResult);
  }

  /**
   * Test {@link ParticularLongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#xor(LongValue)}
   */
  @Test
  @DisplayName("Test xor(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.xor(LongValue)"})
  void testXorWithLongValue_thenReturnCompositeLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualXorResult =
        particularLongValue.xor(
            (LongValue)
                new CompositeLongValue(
                    BasicValueFactory.LONG_VALUE,
                    (byte) 'A',
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualXorResult instanceof CompositeLongValue);
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#xor(LongValue)}
   */
  @Test
  @DisplayName(
      "Test xor(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.xor(LongValue)"})
  void testXorWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualXorResult = particularLongValue.xor(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualXorResult instanceof ParticularLongValue);
    assertEquals(particularLongValue, actualXorResult);
  }

  /**
   * Test {@link ParticularLongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#xor(LongValue)}
   */
  @Test
  @DisplayName("Test xor(LongValue) with 'LongValue'; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.xor(LongValue)"})
  void testXorWithLongValue_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualXorResult = new ParticularLongValue(42L).xor(other);

    // Assert
    assertSame(other, actualXorResult);
  }

  /**
   * Test {@link ParticularLongValue#xor(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#xor(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test xor(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue ParticularLongValue.xor(ParticularLongValue)"})
  void testXorWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act
    LongValue actualXorResult = particularLongValue.xor(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualXorResult instanceof ParticularLongValue);
    assertEquals(0L, actualXorResult.value());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isParticular());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#compare(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link NegatedIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#compare(LongValue)}
   */
  @Test
  @DisplayName(
      "Test compare(LongValue) with 'LongValue'; when LONG_VALUE_0; then return NegatedIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularLongValue.compare(LongValue)"})
  void testCompareWithLongValue_whenLong_value_0_thenReturnNegatedIntegerValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        new ParticularLongValue(42L).compare(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#compare(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link NegatedIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#compare(LongValue)}
   */
  @Test
  @DisplayName(
      "Test compare(LongValue) with 'LongValue'; when LONG_VALUE; then return NegatedIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue ParticularLongValue.compare(LongValue)"})
  void testCompareWithLongValue_whenLong_value_thenReturnNegatedIntegerValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        new ParticularLongValue(42L).compare(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link ParticularLongValue#equals(Object)}, and {@link ParticularLongValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParticularLongValue#equals(Object)}
   *   <li>{@link ParticularLongValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParticularLongValue.equals(Object)",
    "int ParticularLongValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);
    ParticularLongValue particularLongValue2 = new ParticularLongValue(42L);

    // Act and Assert
    assertEquals(particularLongValue, particularLongValue2);
    assertEquals(particularLongValue.hashCode(), particularLongValue2.hashCode());
  }

  /**
   * Test {@link ParticularLongValue#equals(Object)}, and {@link ParticularLongValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParticularLongValue#equals(Object)}
   *   <li>{@link ParticularLongValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParticularLongValue.equals(Object)",
    "int ParticularLongValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(42L);

    // Act and Assert
    assertEquals(particularLongValue, particularLongValue);
    int expectedHashCodeResult = particularLongValue.hashCode();
    assertEquals(expectedHashCodeResult, particularLongValue.hashCode());
  }

  /**
   * Test {@link ParticularLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParticularLongValue.equals(Object)",
    "int ParticularLongValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParticularLongValue particularLongValue = new ParticularLongValue(1L);

    // Act and Assert
    assertNotEquals(particularLongValue, new ParticularLongValue(42L));
  }

  /**
   * Test {@link ParticularLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParticularLongValue.equals(Object)",
    "int ParticularLongValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularLongValue(42L), null);
  }

  /**
   * Test {@link ParticularLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ParticularLongValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParticularLongValue.equals(Object)",
    "int ParticularLongValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParticularLongValue(42L), "Different type to ParticularLongValue");
  }
}
