package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NegatedIntegerValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedIntegerValue#NegatedIntegerValue(IntegerValue)}
   *   <li>{@link NegatedIntegerValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.NegatedIntegerValue.<init>(proguard.evaluation.value.IntegerValue)",
    "java.lang.String proguard.evaluation.value.NegatedIntegerValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "-b", (new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }

  /**
   * Test {@link NegatedIntegerValue#negate()}.
   *
   * <p>Method under test: {@link NegatedIntegerValue#negate()}
   */
  @Test
  @DisplayName("Test negate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.IntegerValue proguard.evaluation.value.NegatedIntegerValue.negate()"
  })
  void testNegate() {
    // Arrange and Act
    IntegerValue actualNegateResult =
        (new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof RangeIntegerValue);
    assertFalse(actualNegateResult.isCategory2());
    assertFalse(actualNegateResult.isParticular());
    assertFalse(actualNegateResult.isSpecific());
  }

  /**
   * Test {@link NegatedIntegerValue#equals(Object)}, and {@link NegatedIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedIntegerValue#equals(Object)}
   *   <li>{@link NegatedIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedIntegerValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NegatedIntegerValue negatedIntegerValue =
        new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    NegatedIntegerValue negatedIntegerValue2 =
        new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(negatedIntegerValue, negatedIntegerValue2);
    int expectedHashCodeResult = negatedIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedIntegerValue2.hashCode());
  }

  /**
   * Test {@link NegatedIntegerValue#equals(Object)}, and {@link NegatedIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedIntegerValue#equals(Object)}
   *   <li>{@link NegatedIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedIntegerValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NegatedIntegerValue negatedIntegerValue =
        new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(negatedIntegerValue, negatedIntegerValue);
    int expectedHashCodeResult = negatedIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedIntegerValue.hashCode());
  }

  /**
   * Test {@link NegatedIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NegatedIntegerValue negatedIntegerValue =
        new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(
        negatedIntegerValue, new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link NegatedIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NegatedIntegerValue negatedIntegerValue =
        new NegatedIntegerValue(new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(
        negatedIntegerValue, new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link NegatedIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Test {@link NegatedIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new NegatedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to NegatedIntegerValue");
  }
}
