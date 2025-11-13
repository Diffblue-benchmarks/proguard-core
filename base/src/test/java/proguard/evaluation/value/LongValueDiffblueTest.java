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

class LongValueDiffblueTest {
  /**
   * Test {@link LongValue#value()}.
   *
   * <p>Method under test: {@link LongValue#value()}
   */
  @Test
  @DisplayName("Test value()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long LongValue.value()"})
  void testValue() {
    // Arrange, Act and Assert
    assertEquals(0L, new UnknownLongValue().value());
  }

  /**
   * Test {@link LongValue#generalize(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#generalize(LongValue)}
   */
  @Test
  @DisplayName("Test generalize(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.generalize(LongValue)"})
  void testGeneralizeWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualGeneralizeResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link LongValue#generalize(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#generalize(LongValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(LongValue) with 'LongValue'; given LONG_VALUE_0; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.generalize(LongValue)"})
  void testGeneralizeWithLongValue_givenLong_value_0_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualGeneralizeResult = ParticularValueFactory.LONG_VALUE_0.generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link LongValue#generalize(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#generalize(LongValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(LongValue) with 'LongValue'; given LONG_VALUE; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.generalize(LongValue)"})
  void testGeneralizeWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualGeneralizeResult = BasicValueFactory.LONG_VALUE.generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link LongValue#generalize(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#generalize(LongValue)}
   */
  @Test
  @DisplayName("Test generalize(LongValue) with 'LongValue'; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.generalize(LongValue)"})
  void testGeneralizeWithLongValue_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualGeneralizeResult =
        ParticularValueFactory.LONG_VALUE_0.generalize(
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
   * Test {@link LongValue#generalize(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#generalize(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularLongValue) with 'ParticularLongValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.generalize(ParticularLongValue)"})
  void testGeneralizeWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualGeneralizeResult = unknownLongValue.generalize(new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualGeneralizeResult);
  }

  /**
   * Test {@link LongValue#generalize(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#generalize(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(ParticularLongValue) with 'ParticularLongValue'; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.generalize(ParticularLongValue)"})
  void testGeneralizeWithParticularLongValue_thenReturnUnknownLongValue2() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualGeneralizeResult = compositeLongValue.generalize(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualGeneralizeResult instanceof UnknownLongValue);
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.isCategory2());
  }

  /**
   * Test {@link LongValue#generalize(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <p>Method under test: {@link LongValue#generalize(SpecificLongValue)}
   */
  @Test
  @DisplayName("Test generalize(SpecificLongValue) with 'SpecificLongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.generalize(SpecificLongValue)"})
  void testGeneralizeWithSpecificLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualGeneralizeResult =
        unknownLongValue.generalize((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualGeneralizeResult);
  }

  /**
   * Test {@link LongValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#UNKNOWN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value) with 'Value'; given LONG_VALUE; then return UNKNOWN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value LongValue.generalize(Value)"})
  void testGeneralizeWithValue_givenLong_value_thenReturnUnknown_value() {
    // Arrange
    UnknownValue other = BasicValueFactory.UNKNOWN_VALUE;

    // Act
    Value actualGeneralizeResult = BasicValueFactory.LONG_VALUE.generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link LongValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#generalize(Value)}
   */
  @Test
  @DisplayName(
      "Test generalize(Value) with 'Value'; when INTEGER_VALUE_BYTE; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value LongValue.generalize(Value)"})
  void testGeneralizeWithValue_whenInteger_value_byte_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new UnknownLongValue().generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link LongValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#generalize(Value)}
   */
  @Test
  @DisplayName(
      "Test generalize(Value) with 'Value'; when LONG_VALUE; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value LongValue.generalize(Value)"})
  void testGeneralizeWithValue_whenLong_value_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    Value actualGeneralizeResult =
        unknownLongValue.generalize((Value) BasicValueFactory.LONG_VALUE);

    // Assert
    assertSame(unknownLongValue, actualGeneralizeResult);
  }

  /**
   * Test {@link LongValue#computationalType()}.
   *
   * <p>Method under test: {@link LongValue#computationalType()}
   */
  @Test
  @DisplayName("Test computationalType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LongValue.computationalType()"})
  void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(2, new UnknownLongValue().computationalType());
  }

  /**
   * Test {@link LongValue#internalType()}.
   *
   * <p>Method under test: {@link LongValue#internalType()}
   */
  @Test
  @DisplayName("Test internalType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LongValue.internalType()"})
  void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("J", new UnknownLongValue().internalType());
  }

  /**
   * Test {@link LongValue#add(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#add(LongValue)}
   */
  @Test
  @DisplayName("Test add(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.add(LongValue)"})
  void testAddWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualAddResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .add(other);

    // Assert
    assertSame(other, actualAddResult);
  }

  /**
   * Test {@link LongValue#add(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#add(LongValue)}
   */
  @Test
  @DisplayName(
      "Test add(LongValue) with 'LongValue'; given LONG_VALUE_0; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.add(LongValue)"})
  void testAddWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualAddResult = ParticularValueFactory.LONG_VALUE_0.add(other);

    // Assert
    assertSame(other, actualAddResult);
  }

  /**
   * Test {@link LongValue#add(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#add(LongValue)}
   */
  @Test
  @DisplayName(
      "Test add(LongValue) with 'LongValue'; given LONG_VALUE; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.add(LongValue)"})
  void testAddWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualAddResult = BasicValueFactory.LONG_VALUE.add(other);

    // Assert
    assertSame(other, actualAddResult);
  }

  /**
   * Test {@link LongValue#add(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#add(LongValue)}
   */
  @Test
  @DisplayName("Test add(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.add(LongValue)"})
  void testAddWithLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualAddResult =
        ParticularValueFactory.LONG_VALUE_0.add(
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
   * Test {@link LongValue#add(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#add(LongValue)}
   */
  @Test
  @DisplayName(
      "Test add(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.add(LongValue)"})
  void testAddWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualAddResult = ParticularValueFactory.LONG_VALUE_0.add(other);

    // Assert
    assertTrue(actualAddResult instanceof ParticularLongValue);
    assertEquals(other, actualAddResult);
  }

  /**
   * Test {@link LongValue#add(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#add(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularLongValue) with 'ParticularLongValue'; given LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.add(ParticularLongValue)"})
  void testAddWithParticularLongValue_givenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualAddResult = ParticularValueFactory.LONG_VALUE_0.add(other);

    // Assert
    assertTrue(actualAddResult instanceof ParticularLongValue);
    assertEquals(other, actualAddResult);
  }

  /**
   * Test {@link LongValue#add(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#add(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularLongValue) with 'ParticularLongValue'; given UnknownLongValue (default constructor); then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.add(ParticularLongValue)"})
  void testAddWithParticularLongValue_givenUnknownLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualAddResult = unknownLongValue.add(new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualAddResult);
  }

  /**
   * Test {@link LongValue#add(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#add(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test add(ParticularLongValue) with 'ParticularLongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.add(ParticularLongValue)"})
  void testAddWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualAddResult = compositeLongValue.add(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAddResult instanceof CompositeLongValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link LongValue#add(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#add(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test add(SpecificLongValue) with 'SpecificLongValue'; given LONG_VALUE_0; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.add(SpecificLongValue)"})
  void testAddWithSpecificLongValue_givenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualAddResult =
        ParticularValueFactory.LONG_VALUE_0.add((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAddResult instanceof CompositeLongValue);
    assertFalse(actualAddResult.isParticular());
    assertTrue(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link LongValue#add(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#add(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test add(SpecificLongValue) with 'SpecificLongValue'; given UnknownLongValue (default constructor); then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.add(SpecificLongValue)"})
  void testAddWithSpecificLongValue_givenUnknownLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualAddResult =
        unknownLongValue.add((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualAddResult);
  }

  /**
   * Test {@link LongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#subtract(LongValue)}
   */
  @Test
  @DisplayName("Test subtract(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtract(LongValue)"})
  void testSubtractWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualSubtractResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .subtract(other);

    // Assert
    assertSame(other, actualSubtractResult);
  }

  /**
   * Test {@link LongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtract(LongValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(LongValue) with 'LongValue'; given LONG_VALUE_0; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtract(LongValue)"})
  void testSubtractWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualSubtractResult = ParticularValueFactory.LONG_VALUE_0.subtract(other);

    // Assert
    assertSame(other, actualSubtractResult);
  }

  /**
   * Test {@link LongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtract(LongValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(LongValue) with 'LongValue'; given LONG_VALUE; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtract(LongValue)"})
  void testSubtractWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualSubtractResult = BasicValueFactory.LONG_VALUE.subtract(other);

    // Assert
    assertSame(other, actualSubtractResult);
  }

  /**
   * Test {@link LongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtract(LongValue)}
   */
  @Test
  @DisplayName("Test subtract(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtract(LongValue)"})
  void testSubtractWithLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualSubtractResult =
        ParticularValueFactory.LONG_VALUE_0.subtract(
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
   * Test {@link LongValue#subtract(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtract(LongValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtract(LongValue)"})
  void testSubtractWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualSubtractResult = ParticularValueFactory.LONG_VALUE_0.subtract(other);

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularLongValue);
    assertEquals(other, actualSubtractResult);
  }

  /**
   * Test {@link LongValue#subtract(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtract(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(ParticularLongValue) with 'ParticularLongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtract(ParticularLongValue)"})
  void testSubtractWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualSubtractResult = compositeLongValue.subtract(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeLongValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link LongValue#subtract(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtract(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtract(ParticularLongValue)"})
  void testSubtractWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange and Act
    LongValue actualSubtractResult =
        ParticularValueFactory.LONG_VALUE_0.subtract(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractResult instanceof ParticularLongValue);
    assertEquals(-42L, actualSubtractResult.value());
    assertTrue(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link LongValue#subtract(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtract(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(ParticularLongValue) with 'ParticularLongValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtract(ParticularLongValue)"})
  void testSubtractWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualSubtractResult = unknownLongValue.subtract(new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualSubtractResult);
  }

  /**
   * Test {@link LongValue#subtract(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtract(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(SpecificLongValue) with 'SpecificLongValue'; given LONG_VALUE_0; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtract(SpecificLongValue)"})
  void testSubtractWithSpecificLongValue_givenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualSubtractResult =
        ParticularValueFactory.LONG_VALUE_0.subtract(
            (SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractResult instanceof CompositeLongValue);
    assertFalse(actualSubtractResult.isParticular());
    assertTrue(actualSubtractResult.isCategory2());
    assertTrue(actualSubtractResult.isSpecific());
  }

  /**
   * Test {@link LongValue#subtract(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtract(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test subtract(SpecificLongValue) with 'SpecificLongValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtract(SpecificLongValue)"})
  void testSubtractWithSpecificLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualSubtractResult =
        unknownLongValue.subtract((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualSubtractResult);
  }

  /**
   * Test {@link LongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#subtractFrom(LongValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(LongValue)"})
  void testSubtractFromWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualSubtractFromResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .subtractFrom(other);

    // Assert
    assertSame(other, actualSubtractFromResult);
  }

  /**
   * Test {@link LongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtractFrom(LongValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(LongValue) with 'LongValue'; given LONG_VALUE_0; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(LongValue)"})
  void testSubtractFromWithLongValue_givenLong_value_0_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualSubtractFromResult = ParticularValueFactory.LONG_VALUE_0.subtractFrom(other);

    // Assert
    assertSame(other, actualSubtractFromResult);
  }

  /**
   * Test {@link LongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtractFrom(LongValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(LongValue) with 'LongValue'; given LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(LongValue)"})
  void testSubtractFromWithLongValue_givenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualSubtractFromResult = BasicValueFactory.LONG_VALUE.subtractFrom(other);

    // Assert
    assertSame(other, actualSubtractFromResult);
  }

  /**
   * Test {@link LongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtractFrom(LongValue)}
   */
  @Test
  @DisplayName("Test subtractFrom(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(LongValue)"})
  void testSubtractFromWithLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualSubtractFromResult =
        ParticularValueFactory.LONG_VALUE_0.subtractFrom(
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
   * Test {@link LongValue#subtractFrom(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtractFrom(LongValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(LongValue)"})
  void testSubtractFromWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualSubtractFromResult = ParticularValueFactory.LONG_VALUE_0.subtractFrom(other);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularLongValue);
    assertEquals(other, actualSubtractFromResult);
  }

  /**
   * Test {@link LongValue#subtractFrom(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtractFrom(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(ParticularLongValue) with 'ParticularLongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(ParticularLongValue)"})
  void testSubtractFromWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualSubtractFromResult =
        compositeLongValue.subtractFrom(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeLongValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link LongValue#subtractFrom(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtractFrom(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(ParticularLongValue)"})
  void testSubtractFromWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualSubtractFromResult = ParticularValueFactory.LONG_VALUE_0.subtractFrom(other);

    // Assert
    assertTrue(actualSubtractFromResult instanceof ParticularLongValue);
    assertEquals(other, actualSubtractFromResult);
  }

  /**
   * Test {@link LongValue#subtractFrom(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtractFrom(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(ParticularLongValue) with 'ParticularLongValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(ParticularLongValue)"})
  void testSubtractFromWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualSubtractFromResult =
        unknownLongValue.subtractFrom(new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualSubtractFromResult);
  }

  /**
   * Test {@link LongValue#subtractFrom(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtractFrom(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(SpecificLongValue) with 'SpecificLongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(SpecificLongValue)"})
  void testSubtractFromWithSpecificLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualSubtractFromResult =
        ParticularValueFactory.LONG_VALUE_0.subtractFrom(
            (SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualSubtractFromResult instanceof CompositeLongValue);
    assertFalse(actualSubtractFromResult.isParticular());
    assertTrue(actualSubtractFromResult.isCategory2());
    assertTrue(actualSubtractFromResult.isSpecific());
  }

  /**
   * Test {@link LongValue#subtractFrom(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#subtractFrom(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test subtractFrom(SpecificLongValue) with 'SpecificLongValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.subtractFrom(SpecificLongValue)"})
  void testSubtractFromWithSpecificLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualSubtractFromResult =
        unknownLongValue.subtractFrom((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualSubtractFromResult);
  }

  /**
   * Test {@link LongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#multiply(LongValue)}
   */
  @Test
  @DisplayName("Test multiply(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.multiply(LongValue)"})
  void testMultiplyWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualMultiplyResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .multiply(other);

    // Assert
    assertSame(other, actualMultiplyResult);
  }

  /**
   * Test {@link LongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#multiply(LongValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(LongValue) with 'LongValue'; given LONG_VALUE_0; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.multiply(LongValue)"})
  void testMultiplyWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualMultiplyResult = ParticularValueFactory.LONG_VALUE_0.multiply(other);

    // Assert
    assertSame(other, actualMultiplyResult);
  }

  /**
   * Test {@link LongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#multiply(LongValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(LongValue) with 'LongValue'; given LONG_VALUE; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.multiply(LongValue)"})
  void testMultiplyWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualMultiplyResult = BasicValueFactory.LONG_VALUE.multiply(other);

    // Assert
    assertSame(other, actualMultiplyResult);
  }

  /**
   * Test {@link LongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#multiply(LongValue)}
   */
  @Test
  @DisplayName("Test multiply(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.multiply(LongValue)"})
  void testMultiplyWithLongValue_thenReturnCompositeLongValue() throws ArithmeticException {
    // Arrange and Act
    LongValue actualMultiplyResult =
        ParticularValueFactory.LONG_VALUE_0.multiply(
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
   * Test {@link LongValue#multiply(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#multiply(LongValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.multiply(LongValue)"})
  void testMultiplyWithLongValue_whenLong_value_0_thenReturnParticularLongValue()
      throws ArithmeticException {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualMultiplyResult = ParticularValueFactory.LONG_VALUE_0.multiply(other);

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularLongValue);
    assertEquals(other, actualMultiplyResult);
  }

  /**
   * Test {@link LongValue#multiply(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#multiply(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(ParticularLongValue) with 'ParticularLongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.multiply(ParticularLongValue)"})
  void testMultiplyWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualMultiplyResult = compositeLongValue.multiply(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeLongValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link LongValue#multiply(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#multiply(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.multiply(ParticularLongValue)"})
  void testMultiplyWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualMultiplyResult = longValue.multiply(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualMultiplyResult instanceof ParticularLongValue);
    assertEquals(longValue, actualMultiplyResult);
  }

  /**
   * Test {@link LongValue#multiply(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#multiply(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(ParticularLongValue) with 'ParticularLongValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.multiply(ParticularLongValue)"})
  void testMultiplyWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualMultiplyResult = unknownLongValue.multiply(new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualMultiplyResult);
  }

  /**
   * Test {@link LongValue#multiply(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#multiply(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(SpecificLongValue) with 'SpecificLongValue'; given LONG_VALUE_0; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.multiply(SpecificLongValue)"})
  void testMultiplyWithSpecificLongValue_givenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualMultiplyResult =
        ParticularValueFactory.LONG_VALUE_0.multiply(
            (SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualMultiplyResult instanceof CompositeLongValue);
    assertFalse(actualMultiplyResult.isParticular());
    assertTrue(actualMultiplyResult.isCategory2());
    assertTrue(actualMultiplyResult.isSpecific());
  }

  /**
   * Test {@link LongValue#multiply(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#multiply(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test multiply(SpecificLongValue) with 'SpecificLongValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.multiply(SpecificLongValue)"})
  void testMultiplyWithSpecificLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualMultiplyResult =
        unknownLongValue.multiply((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualMultiplyResult);
  }

  /**
   * Test {@link LongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#divide(LongValue)}
   */
  @Test
  @DisplayName("Test divide(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divide(LongValue)"})
  void testDivideWithLongValue() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualDivideResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .divide(other);

    // Assert
    assertSame(other, actualDivideResult);
  }

  /**
   * Test {@link LongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divide(LongValue)}
   */
  @Test
  @DisplayName(
      "Test divide(LongValue) with 'LongValue'; given LONG_VALUE_0; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divide(LongValue)"})
  void testDivideWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualDivideResult = ParticularValueFactory.LONG_VALUE_0.divide(other);

    // Assert
    assertSame(other, actualDivideResult);
  }

  /**
   * Test {@link LongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divide(LongValue)}
   */
  @Test
  @DisplayName(
      "Test divide(LongValue) with 'LongValue'; given LONG_VALUE; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divide(LongValue)"})
  void testDivideWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualDivideResult = BasicValueFactory.LONG_VALUE.divide(other);

    // Assert
    assertSame(other, actualDivideResult);
  }

  /**
   * Test {@link LongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divide(LongValue)}
   */
  @Test
  @DisplayName("Test divide(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divide(LongValue)"})
  void testDivideWithLongValue_thenReturnCompositeLongValue() throws ArithmeticException {
    // Arrange and Act
    LongValue actualDivideResult =
        ParticularValueFactory.LONG_VALUE_0.divide(
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
   * Test {@link LongValue#divide(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_1}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divide(LongValue)}
   */
  @Test
  @DisplayName(
      "Test divide(LongValue) with 'LongValue'; when LONG_VALUE_1; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divide(LongValue)"})
  void testDivideWithLongValue_whenLong_value_1_thenReturnParticularLongValue()
      throws ArithmeticException {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualDivideResult = longValue.divide(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualDivideResult instanceof ParticularLongValue);
    assertEquals(longValue, actualDivideResult);
  }

  /**
   * Test {@link LongValue#divide(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divide(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularLongValue) with 'ParticularLongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divide(ParticularLongValue)"})
  void testDivideWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualDivideResult = compositeLongValue.divide(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeLongValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link LongValue#divide(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divide(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divide(ParticularLongValue)"})
  void testDivideWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualDivideResult = longValue.divide(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideResult instanceof ParticularLongValue);
    assertEquals(longValue, actualDivideResult);
  }

  /**
   * Test {@link LongValue#divide(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divide(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test divide(ParticularLongValue) with 'ParticularLongValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divide(ParticularLongValue)"})
  void testDivideWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualDivideResult = unknownLongValue.divide(new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualDivideResult);
  }

  /**
   * Test {@link LongValue#divide(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divide(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test divide(SpecificLongValue) with 'SpecificLongValue'; given LONG_VALUE_0; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divide(SpecificLongValue)"})
  void testDivideWithSpecificLongValue_givenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualDivideResult =
        ParticularValueFactory.LONG_VALUE_0.divide(
            (SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideResult instanceof CompositeLongValue);
    assertFalse(actualDivideResult.isParticular());
    assertTrue(actualDivideResult.isCategory2());
    assertTrue(actualDivideResult.isSpecific());
  }

  /**
   * Test {@link LongValue#divide(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divide(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test divide(SpecificLongValue) with 'SpecificLongValue'; given UnknownLongValue (default constructor); then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divide(SpecificLongValue)"})
  void testDivideWithSpecificLongValue_givenUnknownLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualDivideResult =
        unknownLongValue.divide((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualDivideResult);
  }

  /**
   * Test {@link LongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#divideOf(LongValue)}
   */
  @Test
  @DisplayName("Test divideOf(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divideOf(LongValue)"})
  void testDivideOfWithLongValue() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualDivideOfResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .divideOf(other);

    // Assert
    assertSame(other, actualDivideOfResult);
  }

  /**
   * Test {@link LongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#divideOf(LongValue)}
   */
  @Test
  @DisplayName("Test divideOf(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divideOf(LongValue)"})
  void testDivideOfWithLongValue2() throws ArithmeticException {
    // Arrange and Act
    LongValue actualDivideOfResult =
        ParticularValueFactory.LONG_VALUE_0.divideOf(
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
   * Test {@link LongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divideOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(LongValue) with 'LongValue'; given LONG_VALUE_0; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divideOf(LongValue)"})
  void testDivideOfWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualDivideOfResult = ParticularValueFactory.LONG_VALUE_0.divideOf(other);

    // Assert
    assertSame(other, actualDivideOfResult);
  }

  /**
   * Test {@link LongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divideOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(LongValue) with 'LongValue'; given LONG_VALUE; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divideOf(LongValue)"})
  void testDivideOfWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualDivideOfResult = BasicValueFactory.LONG_VALUE.divideOf(other);

    // Assert
    assertSame(other, actualDivideOfResult);
  }

  /**
   * Test {@link LongValue#divideOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divideOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(LongValue) with 'LongValue'; when LONG_VALUE_0; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divideOf(LongValue)"})
  void testDivideOfWithLongValue_whenLong_value_0_thenReturnCompositeLongValue()
      throws ArithmeticException {
    // Arrange and Act
    LongValue actualDivideOfResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .divideOf(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeLongValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link LongValue#divideOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divideOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(ParticularLongValue) with 'ParticularLongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divideOf(ParticularLongValue)"})
  void testDivideOfWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualDivideOfResult = compositeLongValue.divideOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeLongValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link LongValue#divideOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divideOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divideOf(ParticularLongValue)"})
  void testDivideOfWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualDivideOfResult = ParticularValueFactory.LONG_VALUE_1.divideOf(other);

    // Assert
    assertTrue(actualDivideOfResult instanceof ParticularLongValue);
    assertEquals(other, actualDivideOfResult);
  }

  /**
   * Test {@link LongValue#divideOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divideOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(ParticularLongValue) with 'ParticularLongValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divideOf(ParticularLongValue)"})
  void testDivideOfWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualDivideOfResult = unknownLongValue.divideOf(new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualDivideOfResult);
  }

  /**
   * Test {@link LongValue#divideOf(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divideOf(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(SpecificLongValue) with 'SpecificLongValue'; given LONG_VALUE_0; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divideOf(SpecificLongValue)"})
  void testDivideOfWithSpecificLongValue_givenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualDivideOfResult =
        ParticularValueFactory.LONG_VALUE_0.divideOf(
            (SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualDivideOfResult instanceof CompositeLongValue);
    assertFalse(actualDivideOfResult.isParticular());
    assertTrue(actualDivideOfResult.isCategory2());
    assertTrue(actualDivideOfResult.isSpecific());
  }

  /**
   * Test {@link LongValue#divideOf(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#divideOf(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test divideOf(SpecificLongValue) with 'SpecificLongValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.divideOf(SpecificLongValue)"})
  void testDivideOfWithSpecificLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualDivideOfResult =
        unknownLongValue.divideOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualDivideOfResult);
  }

  /**
   * Test {@link LongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#remainder(LongValue)}
   */
  @Test
  @DisplayName("Test remainder(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainder(LongValue)"})
  void testRemainderWithLongValue() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualRemainderResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .remainder(other);

    // Assert
    assertSame(other, actualRemainderResult);
  }

  /**
   * Test {@link LongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainder(LongValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(LongValue) with 'LongValue'; given LONG_VALUE_0; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainder(LongValue)"})
  void testRemainderWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualRemainderResult = ParticularValueFactory.LONG_VALUE_0.remainder(other);

    // Assert
    assertSame(other, actualRemainderResult);
  }

  /**
   * Test {@link LongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainder(LongValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(LongValue) with 'LongValue'; given LONG_VALUE; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainder(LongValue)"})
  void testRemainderWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualRemainderResult = BasicValueFactory.LONG_VALUE.remainder(other);

    // Assert
    assertSame(other, actualRemainderResult);
  }

  /**
   * Test {@link LongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainder(LongValue)}
   */
  @Test
  @DisplayName("Test remainder(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainder(LongValue)"})
  void testRemainderWithLongValue_thenReturnCompositeLongValue() throws ArithmeticException {
    // Arrange and Act
    LongValue actualRemainderResult =
        ParticularValueFactory.LONG_VALUE_0.remainder(
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
   * Test {@link LongValue#remainder(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_1}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainder(LongValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(LongValue) with 'LongValue'; when LONG_VALUE_1; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainder(LongValue)"})
  void testRemainderWithLongValue_whenLong_value_1_thenReturnParticularLongValue()
      throws ArithmeticException {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualRemainderResult = longValue.remainder(ParticularValueFactory.LONG_VALUE_1);

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularLongValue);
    assertEquals(longValue, actualRemainderResult);
  }

  /**
   * Test {@link LongValue#remainder(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainder(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(ParticularLongValue) with 'ParticularLongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainder(ParticularLongValue)"})
  void testRemainderWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualRemainderResult = compositeLongValue.remainder(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeLongValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link LongValue#remainder(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainder(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainder(ParticularLongValue)"})
  void testRemainderWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualRemainderResult = longValue.remainder(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderResult instanceof ParticularLongValue);
    assertEquals(longValue, actualRemainderResult);
  }

  /**
   * Test {@link LongValue#remainder(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainder(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(ParticularLongValue) with 'ParticularLongValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainder(ParticularLongValue)"})
  void testRemainderWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualRemainderResult = unknownLongValue.remainder(new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualRemainderResult);
  }

  /**
   * Test {@link LongValue#remainder(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainder(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(SpecificLongValue) with 'SpecificLongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainder(SpecificLongValue)"})
  void testRemainderWithSpecificLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualRemainderResult =
        ParticularValueFactory.LONG_VALUE_0.remainder(
            (SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderResult instanceof CompositeLongValue);
    assertFalse(actualRemainderResult.isParticular());
    assertTrue(actualRemainderResult.isCategory2());
    assertTrue(actualRemainderResult.isSpecific());
  }

  /**
   * Test {@link LongValue#remainder(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainder(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test remainder(SpecificLongValue) with 'SpecificLongValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainder(SpecificLongValue)"})
  void testRemainderWithSpecificLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualRemainderResult =
        unknownLongValue.remainder((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualRemainderResult);
  }

  /**
   * Test {@link LongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#remainderOf(LongValue)}
   */
  @Test
  @DisplayName("Test remainderOf(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainderOf(LongValue)"})
  void testRemainderOfWithLongValue() throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualRemainderOfResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .remainderOf(other);

    // Assert
    assertSame(other, actualRemainderOfResult);
  }

  /**
   * Test {@link LongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#remainderOf(LongValue)}
   */
  @Test
  @DisplayName("Test remainderOf(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainderOf(LongValue)"})
  void testRemainderOfWithLongValue2() throws ArithmeticException {
    // Arrange and Act
    LongValue actualRemainderOfResult =
        ParticularValueFactory.LONG_VALUE_0.remainderOf(
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
   * Test {@link LongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainderOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(LongValue) with 'LongValue'; given LONG_VALUE_0; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainderOf(LongValue)"})
  void testRemainderOfWithLongValue_givenLong_value_0_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualRemainderOfResult = ParticularValueFactory.LONG_VALUE_0.remainderOf(other);

    // Assert
    assertSame(other, actualRemainderOfResult);
  }

  /**
   * Test {@link LongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainderOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(LongValue) with 'LongValue'; given LONG_VALUE; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainderOf(LongValue)"})
  void testRemainderOfWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value()
      throws ArithmeticException {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualRemainderOfResult = BasicValueFactory.LONG_VALUE.remainderOf(other);

    // Assert
    assertSame(other, actualRemainderOfResult);
  }

  /**
   * Test {@link LongValue#remainderOf(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainderOf(LongValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(LongValue) with 'LongValue'; when LONG_VALUE_0; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainderOf(LongValue)"})
  void testRemainderOfWithLongValue_whenLong_value_0_thenReturnCompositeLongValue()
      throws ArithmeticException {
    // Arrange and Act
    LongValue actualRemainderOfResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .remainderOf(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeLongValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link LongValue#remainderOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainderOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(ParticularLongValue) with 'ParticularLongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainderOf(ParticularLongValue)"})
  void testRemainderOfWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualRemainderOfResult =
        compositeLongValue.remainderOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeLongValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link LongValue#remainderOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainderOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(ParticularLongValue) with 'ParticularLongValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainderOf(ParticularLongValue)"})
  void testRemainderOfWithParticularLongValue_thenReturnParticularLongValue() {
    // Arrange and Act
    LongValue actualRemainderOfResult =
        ParticularValueFactory.LONG_VALUE_1.remainderOf(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderOfResult instanceof ParticularLongValue);
    assertEquals(0L, actualRemainderOfResult.value());
    assertTrue(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link LongValue#remainderOf(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainderOf(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(ParticularLongValue) with 'ParticularLongValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainderOf(ParticularLongValue)"})
  void testRemainderOfWithParticularLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualRemainderOfResult = unknownLongValue.remainderOf(new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualRemainderOfResult);
  }

  /**
   * Test {@link LongValue#remainderOf(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainderOf(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(SpecificLongValue) with 'SpecificLongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainderOf(SpecificLongValue)"})
  void testRemainderOfWithSpecificLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualRemainderOfResult =
        ParticularValueFactory.LONG_VALUE_0.remainderOf(
            (SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualRemainderOfResult instanceof CompositeLongValue);
    assertFalse(actualRemainderOfResult.isParticular());
    assertTrue(actualRemainderOfResult.isCategory2());
    assertTrue(actualRemainderOfResult.isSpecific());
  }

  /**
   * Test {@link LongValue#remainderOf(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#remainderOf(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test remainderOf(SpecificLongValue) with 'SpecificLongValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.remainderOf(SpecificLongValue)"})
  void testRemainderOfWithSpecificLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualRemainderOfResult =
        unknownLongValue.remainderOf((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualRemainderOfResult);
  }

  /**
   * Test {@link LongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link LongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftLeft(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue() {
    // Arrange and Act
    LongValue actualShiftLeftResult =
        ParticularValueFactory.LONG_VALUE_0.shiftLeft(
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
   * Test {@link LongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; given LONG_VALUE_0; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue_givenLong_value_0_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftLeftResult =
        ParticularValueFactory.LONG_VALUE_0.shiftLeft(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
    assertTrue(actualShiftLeftResult.isCategory2());
  }

  /**
   * Test {@link LongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; given LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue_givenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue longValue = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualShiftLeftResult =
        longValue.shiftLeft(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(longValue, actualShiftLeftResult);
  }

  /**
   * Test {@link LongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue_whenInteger_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualShiftLeftResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .shiftLeft(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link LongValue#shiftLeft(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftLeft(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(IntegerValue)"})
  void testShiftLeftWithIntegerValue_whenInteger_value_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftLeftResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .shiftLeft(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftLeftResult instanceof UnknownLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertFalse(actualShiftLeftResult.isSpecific());
    assertTrue(actualShiftLeftResult.isCategory2());
  }

  /**
   * Test {@link LongValue#shiftLeft(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(ParticularIntegerValue)"})
  void testShiftLeftWithParticularIntegerValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualShiftLeftResult = compositeLongValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link LongValue#shiftLeft(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(ParticularIntegerValue)"})
  void testShiftLeftWithParticularIntegerValue_thenReturnParticularLongValue() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualShiftLeftResult = longValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftLeftResult instanceof ParticularLongValue);
    assertEquals(longValue, actualShiftLeftResult);
  }

  /**
   * Test {@link LongValue#shiftLeft(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftLeft(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(ParticularIntegerValue)"})
  void testShiftLeftWithParticularIntegerValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualShiftLeftResult = unknownLongValue.shiftLeft(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownLongValue, actualShiftLeftResult);
  }

  /**
   * Test {@link LongValue#shiftLeft(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftLeft(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(SpecificLongValue) with 'SpecificLongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(SpecificLongValue)"})
  void testShiftLeftWithSpecificLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualShiftLeftResult =
        ParticularValueFactory.LONG_VALUE_0.shiftLeft(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftLeftResult instanceof CompositeLongValue);
    assertFalse(actualShiftLeftResult.isParticular());
    assertTrue(actualShiftLeftResult.isCategory2());
    assertTrue(actualShiftLeftResult.isSpecific());
  }

  /**
   * Test {@link LongValue#shiftLeft(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftLeft(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftLeft(SpecificLongValue) with 'SpecificLongValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftLeft(SpecificLongValue)"})
  void testShiftLeftWithSpecificLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualShiftLeftResult = unknownLongValue.shiftLeft(new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualShiftLeftResult);
  }

  /**
   * Test {@link LongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link LongValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test shiftRight(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue() {
    // Arrange and Act
    LongValue actualShiftRightResult =
        ParticularValueFactory.LONG_VALUE_0.shiftRight(
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
   * Test {@link LongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(IntegerValue) with 'IntegerValue'; given LONG_VALUE_0; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue_givenLong_value_0_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftRightResult =
        ParticularValueFactory.LONG_VALUE_0.shiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isCategory2());
  }

  /**
   * Test {@link LongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(IntegerValue) with 'IntegerValue'; given LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue_givenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue longValue = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualShiftRightResult =
        longValue.shiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(longValue, actualShiftRightResult);
  }

  /**
   * Test {@link LongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue_whenInteger_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualShiftRightResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .shiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link LongValue#shiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#INTEGER_VALUE}.
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftRight(IntegerValue)"})
  void testShiftRightWithIntegerValue_whenInteger_value_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualShiftRightResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .shiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertFalse(actualShiftRightResult.isSpecific());
    assertTrue(actualShiftRightResult.isCategory2());
  }

  /**
   * Test {@link LongValue#shiftRight(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftRight(ParticularIntegerValue)"})
  void testShiftRightWithParticularIntegerValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualShiftRightResult =
        compositeLongValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link LongValue#shiftRight(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftRight(ParticularIntegerValue)"})
  void testShiftRightWithParticularIntegerValue_thenReturnParticularLongValue() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualShiftRightResult = longValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualShiftRightResult instanceof ParticularLongValue);
    assertEquals(longValue, actualShiftRightResult);
  }

  /**
   * Test {@link LongValue#shiftRight(ParticularIntegerValue)} with {@code ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftRight(ParticularIntegerValue)"})
  void testShiftRightWithParticularIntegerValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualShiftRightResult = unknownLongValue.shiftRight(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownLongValue, actualShiftRightResult);
  }

  /**
   * Test {@link LongValue#shiftRight(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftRight(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(SpecificLongValue) with 'SpecificLongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftRight(SpecificLongValue)"})
  void testShiftRightWithSpecificLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualShiftRightResult =
        ParticularValueFactory.LONG_VALUE_0.shiftRight(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualShiftRightResult.isParticular());
    assertTrue(actualShiftRightResult.isCategory2());
    assertTrue(actualShiftRightResult.isSpecific());
  }

  /**
   * Test {@link LongValue#shiftRight(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#shiftRight(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test shiftRight(SpecificLongValue) with 'SpecificLongValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.shiftRight(SpecificLongValue)"})
  void testShiftRightWithSpecificLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualShiftRightResult = unknownLongValue.shiftRight(new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualShiftRightResult);
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(IntegerValue) with 'IntegerValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult =
        ParticularValueFactory.LONG_VALUE_0.unsignedShiftRight(
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
   * Test {@link LongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; given LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue_givenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue longValue = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualUnsignedShiftRightResult =
        longValue.unsignedShiftRight(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(longValue, actualUnsignedShiftRightResult);
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .unsignedShiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue_thenReturnUnknownLongValue2() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult =
        ParticularValueFactory.LONG_VALUE_0.unsignedShiftRight(BasicValueFactory.INTEGER_VALUE);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof UnknownLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertFalse(actualUnsignedShiftRightResult.isSpecific());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(IntegerValue)} with {@code IntegerValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#INTEGER_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(IntegerValue)}
   */
  @Test
  @DisplayName("Test unsignedShiftRight(IntegerValue) with 'IntegerValue'; when INTEGER_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(IntegerValue)"})
  void testUnsignedShiftRightWithIntegerValue_whenInteger_value_0() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .unsignedShiftRight(ParticularValueFactory.INTEGER_VALUE_0);

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(ParticularIntegerValue)"})
  void testUnsignedShiftRightWithParticularIntegerValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualUnsignedShiftRightResult =
        compositeLongValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(ParticularIntegerValue)"})
  void testUnsignedShiftRightWithParticularIntegerValue_thenReturnParticularLongValue() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualUnsignedShiftRightResult =
        longValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof ParticularLongValue);
    assertEquals(longValue, actualUnsignedShiftRightResult);
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(ParticularIntegerValue)} with {@code
   * ParticularIntegerValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(ParticularIntegerValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(ParticularIntegerValue) with 'ParticularIntegerValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(ParticularIntegerValue)"})
  void testUnsignedShiftRightWithParticularIntegerValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualUnsignedShiftRightResult =
        unknownLongValue.unsignedShiftRight(new ParticularIntegerValue(42));

    // Assert
    assertSame(unknownLongValue, actualUnsignedShiftRightResult);
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(SpecificLongValue) with 'SpecificLongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(SpecificLongValue)"})
  void testUnsignedShiftRightWithSpecificLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualUnsignedShiftRightResult =
        ParticularValueFactory.LONG_VALUE_0.unsignedShiftRight(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualUnsignedShiftRightResult instanceof CompositeLongValue);
    assertFalse(actualUnsignedShiftRightResult.isParticular());
    assertTrue(actualUnsignedShiftRightResult.isCategory2());
    assertTrue(actualUnsignedShiftRightResult.isSpecific());
  }

  /**
   * Test {@link LongValue#unsignedShiftRight(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#unsignedShiftRight(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test unsignedShiftRight(SpecificLongValue) with 'SpecificLongValue'; then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.unsignedShiftRight(SpecificLongValue)"})
  void testUnsignedShiftRightWithSpecificLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualUnsignedShiftRightResult =
        unknownLongValue.unsignedShiftRight(new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualUnsignedShiftRightResult);
  }

  /**
   * Test {@link LongValue#and(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#and(LongValue)}
   */
  @Test
  @DisplayName("Test and(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.and(LongValue)"})
  void testAndWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualAndResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .and(other);

    // Assert
    assertSame(other, actualAndResult);
  }

  /**
   * Test {@link LongValue#and(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#and(LongValue)}
   */
  @Test
  @DisplayName(
      "Test and(LongValue) with 'LongValue'; given LONG_VALUE_0; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.and(LongValue)"})
  void testAndWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualAndResult = ParticularValueFactory.LONG_VALUE_0.and(other);

    // Assert
    assertSame(other, actualAndResult);
  }

  /**
   * Test {@link LongValue#and(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#and(LongValue)}
   */
  @Test
  @DisplayName(
      "Test and(LongValue) with 'LongValue'; given LONG_VALUE; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.and(LongValue)"})
  void testAndWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualAndResult = BasicValueFactory.LONG_VALUE.and(other);

    // Assert
    assertSame(other, actualAndResult);
  }

  /**
   * Test {@link LongValue#and(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#and(LongValue)}
   */
  @Test
  @DisplayName("Test and(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.and(LongValue)"})
  void testAndWithLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualAndResult =
        ParticularValueFactory.LONG_VALUE_0.and(
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
   * Test {@link LongValue#and(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#and(LongValue)}
   */
  @Test
  @DisplayName(
      "Test and(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.and(LongValue)"})
  void testAndWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualAndResult = ParticularValueFactory.LONG_VALUE_0.and(other);

    // Assert
    assertTrue(actualAndResult instanceof ParticularLongValue);
    assertEquals(other, actualAndResult);
  }

  /**
   * Test {@link LongValue#and(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#and(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test and(ParticularLongValue) with 'ParticularLongValue'; given LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.and(ParticularLongValue)"})
  void testAndWithParticularLongValue_givenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue longValue = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualAndResult = longValue.and(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAndResult instanceof ParticularLongValue);
    assertEquals(longValue, actualAndResult);
  }

  /**
   * Test {@link LongValue#and(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#and(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test and(ParticularLongValue) with 'ParticularLongValue'; given UnknownLongValue (default constructor); then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.and(ParticularLongValue)"})
  void testAndWithParticularLongValue_givenUnknownLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualAndResult = unknownLongValue.and(new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualAndResult);
  }

  /**
   * Test {@link LongValue#and(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#and(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test and(ParticularLongValue) with 'ParticularLongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.and(ParticularLongValue)"})
  void testAndWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualAndResult = compositeLongValue.and(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAndResult instanceof CompositeLongValue);
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isCategory2());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link LongValue#and(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#and(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test and(SpecificLongValue) with 'SpecificLongValue'; given LONG_VALUE_0; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.and(SpecificLongValue)"})
  void testAndWithSpecificLongValue_givenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualAndResult =
        ParticularValueFactory.LONG_VALUE_0.and((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualAndResult instanceof CompositeLongValue);
    assertFalse(actualAndResult.isParticular());
    assertTrue(actualAndResult.isCategory2());
    assertTrue(actualAndResult.isSpecific());
  }

  /**
   * Test {@link LongValue#and(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#and(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test and(SpecificLongValue) with 'SpecificLongValue'; given UnknownLongValue (default constructor); then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.and(SpecificLongValue)"})
  void testAndWithSpecificLongValue_givenUnknownLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualAndResult =
        unknownLongValue.and((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualAndResult);
  }

  /**
   * Test {@link LongValue#or(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#or(LongValue)}
   */
  @Test
  @DisplayName("Test or(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.or(LongValue)"})
  void testOrWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualOrResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .or(other);

    // Assert
    assertSame(other, actualOrResult);
  }

  /**
   * Test {@link LongValue#or(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#or(LongValue)}
   */
  @Test
  @DisplayName(
      "Test or(LongValue) with 'LongValue'; given LONG_VALUE_0; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.or(LongValue)"})
  void testOrWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualOrResult = ParticularValueFactory.LONG_VALUE_0.or(other);

    // Assert
    assertSame(other, actualOrResult);
  }

  /**
   * Test {@link LongValue#or(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#or(LongValue)}
   */
  @Test
  @DisplayName(
      "Test or(LongValue) with 'LongValue'; given LONG_VALUE; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.or(LongValue)"})
  void testOrWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualOrResult = BasicValueFactory.LONG_VALUE.or(other);

    // Assert
    assertSame(other, actualOrResult);
  }

  /**
   * Test {@link LongValue#or(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#or(LongValue)}
   */
  @Test
  @DisplayName("Test or(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.or(LongValue)"})
  void testOrWithLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualOrResult =
        ParticularValueFactory.LONG_VALUE_0.or(
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
   * Test {@link LongValue#or(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#or(LongValue)}
   */
  @Test
  @DisplayName(
      "Test or(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.or(LongValue)"})
  void testOrWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualOrResult = ParticularValueFactory.LONG_VALUE_0.or(other);

    // Assert
    assertTrue(actualOrResult instanceof ParticularLongValue);
    assertEquals(other, actualOrResult);
  }

  /**
   * Test {@link LongValue#or(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#or(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test or(ParticularLongValue) with 'ParticularLongValue'; given LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.or(ParticularLongValue)"})
  void testOrWithParticularLongValue_givenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualOrResult = ParticularValueFactory.LONG_VALUE_0.or(other);

    // Assert
    assertTrue(actualOrResult instanceof ParticularLongValue);
    assertEquals(other, actualOrResult);
  }

  /**
   * Test {@link LongValue#or(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#or(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test or(ParticularLongValue) with 'ParticularLongValue'; given UnknownLongValue (default constructor); then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.or(ParticularLongValue)"})
  void testOrWithParticularLongValue_givenUnknownLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualOrResult = unknownLongValue.or(new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualOrResult);
  }

  /**
   * Test {@link LongValue#or(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#or(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test or(ParticularLongValue) with 'ParticularLongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.or(ParticularLongValue)"})
  void testOrWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualOrResult = compositeLongValue.or(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualOrResult instanceof CompositeLongValue);
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isCategory2());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link LongValue#or(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#or(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test or(SpecificLongValue) with 'SpecificLongValue'; given LONG_VALUE_0; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.or(SpecificLongValue)"})
  void testOrWithSpecificLongValue_givenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualOrResult =
        ParticularValueFactory.LONG_VALUE_0.or((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualOrResult instanceof CompositeLongValue);
    assertFalse(actualOrResult.isParticular());
    assertTrue(actualOrResult.isCategory2());
    assertTrue(actualOrResult.isSpecific());
  }

  /**
   * Test {@link LongValue#or(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#or(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test or(SpecificLongValue) with 'SpecificLongValue'; given UnknownLongValue (default constructor); then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.or(SpecificLongValue)"})
  void testOrWithSpecificLongValue_givenUnknownLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualOrResult =
        unknownLongValue.or((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualOrResult);
  }

  /**
   * Test {@link LongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#xor(LongValue)}
   */
  @Test
  @DisplayName("Test xor(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.xor(LongValue)"})
  void testXorWithLongValue() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualXorResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .xor(other);

    // Assert
    assertSame(other, actualXorResult);
  }

  /**
   * Test {@link LongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#xor(LongValue)}
   */
  @Test
  @DisplayName(
      "Test xor(LongValue) with 'LongValue'; given LONG_VALUE_0; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.xor(LongValue)"})
  void testXorWithLongValue_givenLong_value_0_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualXorResult = ParticularValueFactory.LONG_VALUE_0.xor(other);

    // Assert
    assertSame(other, actualXorResult);
  }

  /**
   * Test {@link LongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#xor(LongValue)}
   */
  @Test
  @DisplayName(
      "Test xor(LongValue) with 'LongValue'; given LONG_VALUE; when LONG_VALUE; then return LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.xor(LongValue)"})
  void testXorWithLongValue_givenLong_value_whenLong_value_thenReturnLong_value() {
    // Arrange
    LongValue other = BasicValueFactory.LONG_VALUE;

    // Act
    LongValue actualXorResult = BasicValueFactory.LONG_VALUE.xor(other);

    // Assert
    assertSame(other, actualXorResult);
  }

  /**
   * Test {@link LongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#xor(LongValue)}
   */
  @Test
  @DisplayName("Test xor(LongValue) with 'LongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.xor(LongValue)"})
  void testXorWithLongValue_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualXorResult =
        ParticularValueFactory.LONG_VALUE_0.xor(
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
   * Test {@link LongValue#xor(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#xor(LongValue)}
   */
  @Test
  @DisplayName(
      "Test xor(LongValue) with 'LongValue'; when LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.xor(LongValue)"})
  void testXorWithLongValue_whenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    LongValue other = ParticularValueFactory.LONG_VALUE_0;

    // Act
    LongValue actualXorResult = ParticularValueFactory.LONG_VALUE_0.xor(other);

    // Assert
    assertTrue(actualXorResult instanceof ParticularLongValue);
    assertEquals(other, actualXorResult);
  }

  /**
   * Test {@link LongValue#xor(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ParticularLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#xor(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test xor(ParticularLongValue) with 'ParticularLongValue'; given LONG_VALUE_0; then return ParticularLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.xor(ParticularLongValue)"})
  void testXorWithParticularLongValue_givenLong_value_0_thenReturnParticularLongValue() {
    // Arrange
    ParticularLongValue other = new ParticularLongValue(42L);

    // Act
    LongValue actualXorResult = ParticularValueFactory.LONG_VALUE_0.xor(other);

    // Assert
    assertTrue(actualXorResult instanceof ParticularLongValue);
    assertEquals(other, actualXorResult);
  }

  /**
   * Test {@link LongValue#xor(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#xor(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test xor(ParticularLongValue) with 'ParticularLongValue'; given UnknownLongValue (default constructor); then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.xor(ParticularLongValue)"})
  void testXorWithParticularLongValue_givenUnknownLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualXorResult = unknownLongValue.xor(new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualXorResult);
  }

  /**
   * Test {@link LongValue#xor(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#xor(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test xor(ParticularLongValue) with 'ParticularLongValue'; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.xor(ParticularLongValue)"})
  void testXorWithParticularLongValue_thenReturnCompositeLongValue() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    LongValue actualXorResult = compositeLongValue.xor(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualXorResult instanceof CompositeLongValue);
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link LongValue#xor(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link CompositeLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#xor(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test xor(SpecificLongValue) with 'SpecificLongValue'; given LONG_VALUE_0; then return CompositeLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.xor(SpecificLongValue)"})
  void testXorWithSpecificLongValue_givenLong_value_0_thenReturnCompositeLongValue() {
    // Arrange and Act
    LongValue actualXorResult =
        ParticularValueFactory.LONG_VALUE_0.xor((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualXorResult instanceof CompositeLongValue);
    assertFalse(actualXorResult.isParticular());
    assertTrue(actualXorResult.isCategory2());
    assertTrue(actualXorResult.isSpecific());
  }

  /**
   * Test {@link LongValue#xor(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   *   <li>Then return {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#xor(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test xor(SpecificLongValue) with 'SpecificLongValue'; given UnknownLongValue (default constructor); then return UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.xor(SpecificLongValue)"})
  void testXorWithSpecificLongValue_givenUnknownLongValue_thenReturnUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualXorResult =
        unknownLongValue.xor((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertSame(unknownLongValue, actualXorResult);
  }

  /**
   * Test {@link LongValue#compare(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#compare(LongValue)}
   */
  @Test
  @DisplayName("Test compare(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue LongValue.compare(LongValue)"})
  void testCompareWithLongValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .compare(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compare(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#compare(LongValue)}
   */
  @Test
  @DisplayName("Test compare(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue LongValue.compare(LongValue)"})
  void testCompareWithLongValue2() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .compare(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compare(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link BasicValueFactory#LONG_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compare(LongValue)}
   */
  @Test
  @DisplayName("Test compare(LongValue) with 'LongValue'; given LONG_VALUE_0; when LONG_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue LongValue.compare(LongValue)"})
  void testCompareWithLongValue_givenLong_value_0_whenLong_value() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        ParticularValueFactory.LONG_VALUE_0.compare(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compare(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>When {@link ParticularValueFactory#LONG_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compare(LongValue)}
   */
  @Test
  @DisplayName("Test compare(LongValue) with 'LongValue'; given LONG_VALUE_0; when LONG_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue LongValue.compare(LongValue)"})
  void testCompareWithLongValue_givenLong_value_0_whenLong_value_0() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        ParticularValueFactory.LONG_VALUE_0.compare(ParticularValueFactory.LONG_VALUE_0);

    // Assert
    assertTrue(actualCompareResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compare(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link BasicValueFactory#LONG_VALUE}.
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compare(LongValue)}
   */
  @Test
  @DisplayName(
      "Test compare(LongValue) with 'LongValue'; given LONG_VALUE; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue LongValue.compare(LongValue)"})
  void testCompareWithLongValue_givenLong_value_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        BasicValueFactory.LONG_VALUE.compare(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertFalse(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compare(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compare(ParticularLongValue)}
   */
  @Test
  @DisplayName("Test compare(ParticularLongValue) with 'ParticularLongValue'; given LONG_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue LongValue.compare(ParticularLongValue)"})
  void testCompareWithParticularLongValue_givenLong_value_0() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        ParticularValueFactory.LONG_VALUE_0.compare(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareResult instanceof ComparisonValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compare(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compare(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test compare(ParticularLongValue) with 'ParticularLongValue'; given UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue LongValue.compare(ParticularLongValue)"})
  void testCompareWithParticularLongValue_givenUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    IntegerValue actualCompareResult = unknownLongValue.compare(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareResult instanceof ComparisonValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compare(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compare(SpecificLongValue)}
   */
  @Test
  @DisplayName("Test compare(SpecificLongValue) with 'SpecificLongValue'; given LONG_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue LongValue.compare(SpecificLongValue)"})
  void testCompareWithSpecificLongValue_givenLong_value_0() {
    // Arrange and Act
    IntegerValue actualCompareResult =
        ParticularValueFactory.LONG_VALUE_0.compare(
            (SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareResult instanceof ComparisonValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compare(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compare(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test compare(SpecificLongValue) with 'SpecificLongValue'; given UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue LongValue.compare(SpecificLongValue)"})
  void testCompareWithSpecificLongValue_givenUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    IntegerValue actualCompareResult =
        unknownLongValue.compare((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareResult instanceof ComparisonValue);
    assertFalse(actualCompareResult.isCategory2());
    assertFalse(actualCompareResult.isParticular());
    assertTrue(actualCompareResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compareReverse(LongValue)} with {@code LongValue}.
   *
   * <p>Method under test: {@link LongValue#compareReverse(LongValue)}
   */
  @Test
  @DisplayName("Test compareReverse(LongValue) with 'LongValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue LongValue.compareReverse(LongValue)"})
  void testCompareReverseWithLongValue() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .compareReverse(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof ComparisonValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compareReverse(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   *   <li>Then return {@link ComparisonValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compareReverse(LongValue)}
   */
  @Test
  @DisplayName(
      "Test compareReverse(LongValue) with 'LongValue'; given LONG_VALUE_0; then return ComparisonValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue LongValue.compareReverse(LongValue)"})
  void testCompareReverseWithLongValue_givenLong_value_0_thenReturnComparisonValue() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        ParticularValueFactory.LONG_VALUE_0.compareReverse(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof ComparisonValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compareReverse(LongValue)} with {@code LongValue}.
   *
   * <ul>
   *   <li>Then return {@link UnknownIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compareReverse(LongValue)}
   */
  @Test
  @DisplayName("Test compareReverse(LongValue) with 'LongValue'; then return UnknownIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue LongValue.compareReverse(LongValue)"})
  void testCompareReverseWithLongValue_thenReturnUnknownIntegerValue() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        new UnknownLongValue().compareReverse(BasicValueFactory.LONG_VALUE);

    // Assert
    assertTrue(actualCompareReverseResult instanceof UnknownIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertFalse(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compareReverse(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compareReverse(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test compareReverse(ParticularLongValue) with 'ParticularLongValue'; given LONG_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue LongValue.compareReverse(ParticularLongValue)"})
  void testCompareReverseWithParticularLongValue_givenLong_value_0() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        ParticularValueFactory.LONG_VALUE_0.compareReverse(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareReverseResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compareReverse(ParticularLongValue)} with {@code ParticularLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compareReverse(ParticularLongValue)}
   */
  @Test
  @DisplayName(
      "Test compareReverse(ParticularLongValue) with 'ParticularLongValue'; given UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue LongValue.compareReverse(ParticularLongValue)"})
  void testCompareReverseWithParticularLongValue_givenUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    IntegerValue actualCompareReverseResult =
        unknownLongValue.compareReverse(new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareReverseResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compareReverse(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#LONG_VALUE_0}.
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compareReverse(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test compareReverse(SpecificLongValue) with 'SpecificLongValue'; given LONG_VALUE_0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue LongValue.compareReverse(SpecificLongValue)"})
  void testCompareReverseWithSpecificLongValue_givenLong_value_0() {
    // Arrange and Act
    IntegerValue actualCompareReverseResult =
        ParticularValueFactory.LONG_VALUE_0.compareReverse(
            (SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareReverseResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link LongValue#compareReverse(SpecificLongValue)} with {@code SpecificLongValue}.
   *
   * <ul>
   *   <li>Given {@link UnknownLongValue} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LongValue#compareReverse(SpecificLongValue)}
   */
  @Test
  @DisplayName(
      "Test compareReverse(SpecificLongValue) with 'SpecificLongValue'; given UnknownLongValue (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue LongValue.compareReverse(SpecificLongValue)"})
  void testCompareReverseWithSpecificLongValue_givenUnknownLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    IntegerValue actualCompareReverseResult =
        unknownLongValue.compareReverse((SpecificLongValue) new ParticularLongValue(42L));

    // Assert
    assertTrue(actualCompareReverseResult instanceof NegatedIntegerValue);
    assertFalse(actualCompareReverseResult.isCategory2());
    assertFalse(actualCompareReverseResult.isParticular());
    assertTrue(actualCompareReverseResult.isSpecific());
  }

  /**
   * Test {@link LongValue#longValue()}.
   *
   * <p>Method under test: {@link LongValue#longValue()}
   */
  @Test
  @DisplayName("Test longValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue LongValue.longValue()"})
  void testLongValue() {
    // Arrange
    UnknownLongValue unknownLongValue = new UnknownLongValue();

    // Act
    LongValue actualLongValueResult = unknownLongValue.longValue();

    // Assert
    assertSame(unknownLongValue, actualLongValueResult);
  }
}
