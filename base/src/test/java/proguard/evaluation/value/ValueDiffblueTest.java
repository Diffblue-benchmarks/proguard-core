package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValueDiffblueTest {
  /**
   * Test {@link Value#category1Value()}.
   *
   * <p>Method under test: {@link Value#category1Value()}
   */
  @Test
  @DisplayName("Test category1Value()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Category1Value proguard.evaluation.value.Value.category1Value()"
  })
  void testCategory1Value() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new UnknownDoubleValue()).category1Value());
  }

  /**
   * Test {@link Value#category2Value()}.
   *
   * <p>Method under test: {@link Value#category2Value()}
   */
  @Test
  @DisplayName("Test category2Value()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Category2Value proguard.evaluation.value.Value.category2Value()"
  })
  void testCategory2Value() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).category2Value());
  }

  /**
   * Test {@link Value#integerValue()}.
   *
   * <p>Method under test: {@link Value#integerValue()}
   */
  @Test
  @DisplayName("Test integerValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.Value.integerValue()"
  })
  void testIntegerValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).integerValue());
  }

  /**
   * Test {@link Value#longValue()}.
   *
   * <p>Method under test: {@link Value#longValue()}
   */
  @Test
  @DisplayName("Test longValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.Value.longValue()"
  })
  void testLongValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).longValue());
  }

  /**
   * Test {@link Value#floatValue()}.
   *
   * <p>Method under test: {@link Value#floatValue()}
   */
  @Test
  @DisplayName("Test floatValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.Value.floatValue()"
  })
  void testFloatValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).floatValue());
  }

  /**
   * Test {@link Value#doubleValue()}.
   *
   * <p>Method under test: {@link Value#doubleValue()}
   */
  @Test
  @DisplayName("Test doubleValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.Value.doubleValue()"
  })
  void testDoubleValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).doubleValue());
  }

  /**
   * Test {@link Value#referenceValue()}.
   *
   * <p>Method under test: {@link Value#referenceValue()}
   */
  @Test
  @DisplayName("Test referenceValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.value.Value.referenceValue()"
  })
  void testReferenceValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).referenceValue());
  }

  /**
   * Test {@link Value#instructionOffsetValue()}.
   *
   * <p>Method under test: {@link Value#instructionOffsetValue()}
   */
  @Test
  @DisplayName("Test instructionOffsetValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.InstructionOffsetValue proguard.evaluation.value.Value.instructionOffsetValue()"
  })
  void testInstructionOffsetValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new TopValue()).instructionOffsetValue());
  }

  /**
   * Test {@link Value#isSpecific()}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Value#isSpecific()}
   */
  @Test
  @DisplayName("Test isSpecific(); given INTEGER_VALUE_0; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.Value.isSpecific()"})
  void testIsSpecific_givenInteger_value_0_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ParticularValueFactory.INTEGER_VALUE_0.isSpecific());
  }

  /**
   * Test {@link Value#isSpecific()}.
   *
   * <ul>
   *   <li>Given {@link UnknownDoubleValue} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Value#isSpecific()}
   */
  @Test
  @DisplayName(
      "Test isSpecific(); given UnknownDoubleValue (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.Value.isSpecific()"})
  void testIsSpecific_givenUnknownDoubleValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new UnknownDoubleValue()).isSpecific());
  }

  /**
   * Test {@link Value#isParticular()}.
   *
   * <ul>
   *   <li>Given {@link ParticularValueFactory#INTEGER_VALUE_0}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Value#isParticular()}
   */
  @Test
  @DisplayName("Test isParticular(); given INTEGER_VALUE_0; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.Value.isParticular()"})
  void testIsParticular_givenInteger_value_0_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ParticularValueFactory.INTEGER_VALUE_0.isParticular());
  }

  /**
   * Test {@link Value#isParticular()}.
   *
   * <ul>
   *   <li>Given {@link UnknownDoubleValue} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Value#isParticular()}
   */
  @Test
  @DisplayName(
      "Test isParticular(); given UnknownDoubleValue (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.value.Value.isParticular()"})
  void testIsParticular_givenUnknownDoubleValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new UnknownDoubleValue()).isParticular());
  }

  /**
   * Test {@link Value#copyIfMutable()}.
   *
   * <p>Method under test: {@link Value#copyIfMutable()}
   */
  @Test
  @DisplayName("Test copyIfMutable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.value.Value.copyIfMutable()"
  })
  void testCopyIfMutable() {
    // Arrange
    TopValue topValue = new TopValue();

    // Act and Assert
    assertSame(topValue, topValue.copyIfMutable());
  }
}
