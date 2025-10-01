package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.value.object.AnalyzedObject;

class TracingValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TracingValue#TracingValue(Value, Value)}
   *   <li>{@link TracingValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TracingValue.<init>(Value, Value)",
    "java.lang.String TracingValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "Pbb",
        new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .toString());
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  void testGeneralizeWithTracingValue() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    TracingValue actualGeneralizeResult =
        tracingValue.generalize(
            new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertSame(tracingValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  void testGeneralizeWithTracingValue2() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_CHAR, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    TracingValue actualGeneralizeResult =
        tracingValue.generalize(
            new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  void testGeneralizeWithTracingValue3() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_SHORT, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    TracingValue actualGeneralizeResult =
        tracingValue.generalize(
            new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertEquals(tracingValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  void testGeneralizeWithTracingValue4() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(BasicValueFactory.DOUBLE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tracingValue.generalize(
                new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  void testGeneralizeWithTracingValue5() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(BasicValueFactory.FLOAT_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tracingValue.generalize(
                new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  void testGeneralizeWithTracingValue6() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(BasicValueFactory.LONG_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tracingValue.generalize(
                new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  void testGeneralizeWithTracingValue7() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicValueFactory.REFERENCE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tracingValue.generalize(
                new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  void testGeneralizeWithTracingValue8() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            InstructionOffsetValue.EMPTY_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tracingValue.generalize(
                new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  void testGeneralizeWithTracingValue9() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act
    TracingValue actualGeneralizeResult =
        tracingValue.generalize(
            new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  void testGeneralizeWithTracingValue10() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tracingValue.generalize(
                new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  void testGeneralizeWithTracingValue11() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tracingValue.generalize(
                new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  void testGeneralizeWithTracingValue12() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.LONG_VALUE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tracingValue.generalize(
                new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  void testGeneralizeWithTracingValue13() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tracingValue.generalize(
                new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  void testGeneralizeWithTracingValue14() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, InstructionOffsetValue.EMPTY_VALUE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tracingValue.generalize(
                new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  void testGeneralizeWithTracingValue15() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tracingValue.generalize(
                new TracingValue(
                    BasicValueFactory.DOUBLE_VALUE, BasicRangeValueFactory.INTEGER_VALUE_BYTE)));
  }

  /**
   * Test {@link TracingValue#generalize(TracingValue)} with {@code TracingValue}.
   *
   * <p>Method under test: {@link TracingValue#generalize(TracingValue)}
   */
  @Test
  @DisplayName("Test generalize(TracingValue) with 'TracingValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TracingValue TracingValue.generalize(TracingValue)"})
  void testGeneralizeWithTracingValue16() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tracingValue.generalize(
                new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.DOUBLE_VALUE)));
  }

  /**
   * Test {@link TracingValue#generalize(Value)} with {@code Value}.
   *
   * <p>Method under test: {@link TracingValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value) with 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value TracingValue.generalize(Value)"})
  void testGeneralizeWithValue() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act
    Value actualGeneralizeResult =
        tracingValue.generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertSame(tracingValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracingValue#generalize(Value)} with {@code Value}.
   *
   * <p>Method under test: {@link TracingValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value) with 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value TracingValue.generalize(Value)"})
  void testGeneralizeWithValue2() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_SHORT);

    // Act
    Value actualGeneralizeResult =
        tracingValue.generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracingValue);
    assertEquals(tracingValue, actualGeneralizeResult);
  }

  /**
   * Test {@link TracingValue#generalize(Value)} with {@code Value}.
   *
   * <p>Method under test: {@link TracingValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value) with 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value TracingValue.generalize(Value)"})
  void testGeneralizeWithValue3() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.DOUBLE_VALUE)
                .generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link TracingValue#generalize(Value)} with {@code Value}.
   *
   * <p>Method under test: {@link TracingValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value) with 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value TracingValue.generalize(Value)"})
  void testGeneralizeWithValue4() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.FLOAT_VALUE)
                .generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link TracingValue#generalize(Value)} with {@code Value}.
   *
   * <p>Method under test: {@link TracingValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value) with 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value TracingValue.generalize(Value)"})
  void testGeneralizeWithValue5() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.LONG_VALUE)
                .generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link TracingValue#generalize(Value)} with {@code Value}.
   *
   * <p>Method under test: {@link TracingValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value) with 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value TracingValue.generalize(Value)"})
  void testGeneralizeWithValue6() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.REFERENCE_VALUE)
                .generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link TracingValue#generalize(Value)} with {@code Value}.
   *
   * <p>Method under test: {@link TracingValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value) with 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value TracingValue.generalize(Value)"})
  void testGeneralizeWithValue7() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE, InstructionOffsetValue.EMPTY_VALUE)
                .generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link TracingValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>Then return not Category2.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value) with 'Value'; then return not Category2")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value TracingValue.generalize(Value)"})
  void testGeneralizeWithValue_thenReturnNotCategory2() {
    // Arrange and Act
    Value actualGeneralizeResult =
        new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_CHAR)
            .generalize(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof TracingValue);
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link TracingValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#DOUBLE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value) with 'Value'; when DOUBLE_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value TracingValue.generalize(Value)"})
  void testGeneralizeWithValue_whenDouble_value() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)
                .generalize(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link TracingValue#isCategory2()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#isCategory2()}
   */
  @Test
  @DisplayName("Test isCategory2(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracingValue.isCategory2()"})
  void testIsCategory2_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .isCategory2());
  }

  /**
   * Test {@link TracingValue#isCategory2()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#isCategory2()}
   */
  @Test
  @DisplayName("Test isCategory2(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracingValue.isCategory2()"})
  void testIsCategory2_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.DOUBLE_VALUE)
            .isCategory2());
  }

  /**
   * Test {@link TracingValue#category1Value()}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#category1Value()}
   */
  @Test
  @DisplayName("Test category1Value(); then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Category1Value TracingValue.category1Value()"})
  void testCategory1Value_thenReturnRangeIntegerValue() {
    // Arrange and Act
    Category1Value actualCategory1ValueResult =
        new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .category1Value();

    // Assert
    assertTrue(actualCategory1ValueResult instanceof RangeIntegerValue);
    assertFalse(actualCategory1ValueResult.isCategory2());
    assertFalse(actualCategory1ValueResult.isParticular());
    assertFalse(actualCategory1ValueResult.isSpecific());
  }

  /**
   * Test {@link TracingValue#category1Value()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#category1Value()}
   */
  @Test
  @DisplayName("Test category1Value(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Category1Value TracingValue.category1Value()"})
  void testCategory1Value_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.DOUBLE_VALUE)
                .category1Value());
  }

  /**
   * Test {@link TracingValue#category2Value()}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#category2Value()}
   */
  @Test
  @DisplayName("Test category2Value(); then return UnknownDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Category2Value TracingValue.category2Value()"})
  void testCategory2Value_thenReturnUnknownDoubleValue() {
    // Arrange and Act
    Category2Value actualCategory2ValueResult =
        new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.DOUBLE_VALUE)
            .category2Value();

    // Assert
    assertTrue(actualCategory2ValueResult instanceof UnknownDoubleValue);
    assertFalse(actualCategory2ValueResult.isParticular());
    assertFalse(actualCategory2ValueResult.isSpecific());
    assertTrue(actualCategory2ValueResult.isCategory2());
  }

  /**
   * Test {@link TracingValue#category2Value()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#category2Value()}
   */
  @Test
  @DisplayName("Test category2Value(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Category2Value TracingValue.category2Value()"})
  void testCategory2Value_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)
                .category2Value());
  }

  /**
   * Test {@link TracingValue#integerValue()}.
   *
   * <ul>
   *   <li>Then return {@link RangeIntegerValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#integerValue()}
   */
  @Test
  @DisplayName("Test integerValue(); then return RangeIntegerValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue TracingValue.integerValue()"})
  void testIntegerValue_thenReturnRangeIntegerValue() {
    // Arrange and Act
    IntegerValue actualIntegerValueResult =
        new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .integerValue();

    // Assert
    assertTrue(actualIntegerValueResult instanceof RangeIntegerValue);
    assertFalse(actualIntegerValueResult.isCategory2());
    assertFalse(actualIntegerValueResult.isParticular());
    assertFalse(actualIntegerValueResult.isSpecific());
  }

  /**
   * Test {@link TracingValue#integerValue()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#integerValue()}
   */
  @Test
  @DisplayName("Test integerValue(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerValue TracingValue.integerValue()"})
  void testIntegerValue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.DOUBLE_VALUE)
                .integerValue());
  }

  /**
   * Test {@link TracingValue#longValue()}.
   *
   * <ul>
   *   <li>Then return {@link UnknownLongValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#longValue()}
   */
  @Test
  @DisplayName("Test longValue(); then return UnknownLongValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue TracingValue.longValue()"})
  void testLongValue_thenReturnUnknownLongValue() {
    // Arrange and Act
    LongValue actualLongValueResult =
        new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.LONG_VALUE)
            .longValue();

    // Assert
    assertTrue(actualLongValueResult instanceof UnknownLongValue);
    assertFalse(actualLongValueResult.isParticular());
    assertFalse(actualLongValueResult.isSpecific());
    assertTrue(actualLongValueResult.isCategory2());
  }

  /**
   * Test {@link TracingValue#longValue()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#longValue()}
   */
  @Test
  @DisplayName("Test longValue(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LongValue TracingValue.longValue()"})
  void testLongValue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)
                .longValue());
  }

  /**
   * Test {@link TracingValue#floatValue()}.
   *
   * <ul>
   *   <li>Then return {@link UnknownFloatValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#floatValue()}
   */
  @Test
  @DisplayName("Test floatValue(); then return UnknownFloatValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue TracingValue.floatValue()"})
  void testFloatValue_thenReturnUnknownFloatValue() {
    // Arrange and Act
    FloatValue actualFloatValueResult =
        new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.FLOAT_VALUE)
            .floatValue();

    // Assert
    assertTrue(actualFloatValueResult instanceof UnknownFloatValue);
    assertFalse(actualFloatValueResult.isCategory2());
    assertFalse(actualFloatValueResult.isParticular());
    assertFalse(actualFloatValueResult.isSpecific());
  }

  /**
   * Test {@link TracingValue#floatValue()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#floatValue()}
   */
  @Test
  @DisplayName("Test floatValue(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FloatValue TracingValue.floatValue()"})
  void testFloatValue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)
                .floatValue());
  }

  /**
   * Test {@link TracingValue#doubleValue()}.
   *
   * <ul>
   *   <li>Then return {@link UnknownDoubleValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#doubleValue()}
   */
  @Test
  @DisplayName("Test doubleValue(); then return UnknownDoubleValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue TracingValue.doubleValue()"})
  void testDoubleValue_thenReturnUnknownDoubleValue() {
    // Arrange and Act
    DoubleValue actualDoubleValueResult =
        new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.DOUBLE_VALUE)
            .doubleValue();

    // Assert
    assertTrue(actualDoubleValueResult instanceof UnknownDoubleValue);
    assertFalse(actualDoubleValueResult.isParticular());
    assertFalse(actualDoubleValueResult.isSpecific());
    assertTrue(actualDoubleValueResult.isCategory2());
  }

  /**
   * Test {@link TracingValue#doubleValue()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#doubleValue()}
   */
  @Test
  @DisplayName("Test doubleValue(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DoubleValue TracingValue.doubleValue()"})
  void testDoubleValue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)
                .doubleValue());
  }

  /**
   * Test {@link TracingValue#referenceValue()}.
   *
   * <ul>
   *   <li>Then return {@link UnknownReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#referenceValue()}
   */
  @Test
  @DisplayName("Test referenceValue(); then return UnknownReferenceValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReferenceValue TracingValue.referenceValue()"})
  void testReferenceValue_thenReturnUnknownReferenceValue() {
    // Arrange and Act
    ReferenceValue actualReferenceValueResult =
        new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.REFERENCE_VALUE)
            .referenceValue();

    // Assert
    assertTrue(actualReferenceValueResult instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", actualReferenceValueResult.getType());
    AnalyzedObject value = actualReferenceValueResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualReferenceValueResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualReferenceValueResult.isNotNull());
    assertEquals(0, actualReferenceValueResult.isNull());
    assertFalse(actualReferenceValueResult.isCategory2());
    assertFalse(actualReferenceValueResult.isParticular());
    assertFalse(actualReferenceValueResult.isSpecific());
  }

  /**
   * Test {@link TracingValue#referenceValue()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#referenceValue()}
   */
  @Test
  @DisplayName("Test referenceValue(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReferenceValue TracingValue.referenceValue()"})
  void testReferenceValue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)
                .referenceValue());
  }

  /**
   * Test {@link TracingValue#instructionOffsetValue()}.
   *
   * <ul>
   *   <li>Then return {@link InstructionOffsetValue#EMPTY_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#instructionOffsetValue()}
   */
  @Test
  @DisplayName("Test instructionOffsetValue(); then return EMPTY_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InstructionOffsetValue TracingValue.instructionOffsetValue()"})
  void testInstructionOffsetValue_thenReturnEmpty_value() {
    // Arrange, Act and Assert
    assertSame(
        InstructionOffsetValue.EMPTY_VALUE,
        new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE, InstructionOffsetValue.EMPTY_VALUE)
            .instructionOffsetValue());
  }

  /**
   * Test {@link TracingValue#instructionOffsetValue()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#instructionOffsetValue()}
   */
  @Test
  @DisplayName("Test instructionOffsetValue(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InstructionOffsetValue TracingValue.instructionOffsetValue()"})
  void testInstructionOffsetValue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TracingValue(
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                    BasicRangeValueFactory.INTEGER_VALUE_BYTE)
                .instructionOffsetValue());
  }

  /**
   * Test {@link TracingValue#isSpecific()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#isSpecific()}
   */
  @Test
  @DisplayName("Test isSpecific(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracingValue.isSpecific()"})
  void testIsSpecific_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .isSpecific());
  }

  /**
   * Test {@link TracingValue#isSpecific()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#isSpecific()}
   */
  @Test
  @DisplayName("Test isSpecific(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracingValue.isSpecific()"})
  void testIsSpecific_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE, InstructionOffsetValue.EMPTY_VALUE)
            .isSpecific());
  }

  /**
   * Test {@link TracingValue#isParticular()}.
   *
   * <p>Method under test: {@link TracingValue#isParticular()}
   */
  @Test
  @DisplayName("Test isParticular()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracingValue.isParticular()"})
  void testIsParticular() {
    // Arrange, Act and Assert
    assertFalse(
        new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .isParticular());
  }

  /**
   * Test {@link TracingValue#isParticular()}.
   *
   * <p>Method under test: {@link TracingValue#isParticular()}
   */
  @Test
  @DisplayName("Test isParticular()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracingValue.isParticular()"})
  void testIsParticular2() {
    // Arrange, Act and Assert
    assertFalse(
        new TracingValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicValueFactory.DOUBLE_VALUE)
            .isParticular());
  }

  /**
   * Test {@link TracingValue#isParticular()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#isParticular()}
   */
  @Test
  @DisplayName("Test isParticular(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracingValue.isParticular()"})
  void testIsParticular_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE, InstructionOffsetValue.EMPTY_VALUE)
            .isParticular());
  }

  /**
   * Test {@link TracingValue#computationalType()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#computationalType()}
   */
  @Test
  @DisplayName("Test computationalType(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TracingValue.computationalType()"})
  void testComputationalType_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .computationalType());
  }

  /**
   * Test {@link TracingValue#internalType()}.
   *
   * <ul>
   *   <li>Then return {@code I}.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#internalType()}
   */
  @Test
  @DisplayName("Test internalType(); then return 'I'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TracingValue.internalType()"})
  void testInternalType_thenReturnI() {
    // Arrange, Act and Assert
    assertEquals(
        "I",
        new TracingValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .internalType());
  }

  /**
   * Test {@link TracingValue#equals(Object)}, and {@link TracingValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TracingValue#equals(Object)}
   *   <li>{@link TracingValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracingValue.equals(Object)", "int TracingValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    TracingValue tracingValue2 =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(tracingValue, tracingValue2);
    assertEquals(tracingValue.hashCode(), tracingValue2.hashCode());
  }

  /**
   * Test {@link TracingValue#equals(Object)}, and {@link TracingValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TracingValue#equals(Object)}
   *   <li>{@link TracingValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracingValue.equals(Object)", "int TracingValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(tracingValue, tracingValue);
    int expectedHashCodeResult = tracingValue.hashCode();
    assertEquals(expectedHashCodeResult, tracingValue.hashCode());
  }

  /**
   * Test {@link TracingValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracingValue.equals(Object)", "int TracingValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_CHAR, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(
        tracingValue,
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link TracingValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracingValue.equals(Object)", "int TracingValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TracingValue tracingValue =
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(
        tracingValue,
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link TracingValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracingValue.equals(Object)", "int TracingValue.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        null);
  }

  /**
   * Test {@link TracingValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TracingValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TracingValue.equals(Object)", "int TracingValue.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TracingValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to TracingValue");
  }
}
