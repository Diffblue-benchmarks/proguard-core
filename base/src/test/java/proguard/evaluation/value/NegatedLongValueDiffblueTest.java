package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NegatedLongValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedLongValue#NegatedLongValue(LongValue)}
   *   <li>{@link NegatedLongValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.NegatedLongValue.<init>(proguard.evaluation.value.LongValue)",
    "java.lang.String proguard.evaluation.value.NegatedLongValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("-l", (new NegatedLongValue(BasicValueFactory.LONG_VALUE)).toString());
  }

  /**
   * Test {@link NegatedLongValue#negate()}.
   *
   * <p>Method under test: {@link NegatedLongValue#negate()}
   */
  @Test
  @DisplayName("Test negate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.LongValue proguard.evaluation.value.NegatedLongValue.negate()"
  })
  void testNegate() {
    // Arrange and Act
    LongValue actualNegateResult = (new NegatedLongValue(BasicValueFactory.LONG_VALUE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof UnknownLongValue);
    assertFalse(actualNegateResult.isParticular());
    assertFalse(actualNegateResult.isSpecific());
    assertTrue(actualNegateResult.isCategory2());
  }

  /**
   * Test {@link NegatedLongValue#equals(Object)}, and {@link NegatedLongValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedLongValue#equals(Object)}
   *   <li>{@link NegatedLongValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedLongValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedLongValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NegatedLongValue negatedLongValue = new NegatedLongValue(BasicValueFactory.LONG_VALUE);
    NegatedLongValue negatedLongValue2 = new NegatedLongValue(BasicValueFactory.LONG_VALUE);

    // Act and Assert
    assertEquals(negatedLongValue, negatedLongValue2);
    int expectedHashCodeResult = negatedLongValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedLongValue2.hashCode());
  }

  /**
   * Test {@link NegatedLongValue#equals(Object)}, and {@link NegatedLongValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedLongValue#equals(Object)}
   *   <li>{@link NegatedLongValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedLongValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedLongValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NegatedLongValue negatedLongValue = new NegatedLongValue(BasicValueFactory.LONG_VALUE);

    // Act and Assert
    assertEquals(negatedLongValue, negatedLongValue);
    int expectedHashCodeResult = negatedLongValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedLongValue.hashCode());
  }

  /**
   * Test {@link NegatedLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedLongValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedLongValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedLongValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NegatedLongValue negatedLongValue = new NegatedLongValue(ParticularValueFactory.LONG_VALUE_0);

    // Act and Assert
    assertNotEquals(negatedLongValue, new NegatedLongValue(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Test {@link NegatedLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedLongValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedLongValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedLongValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NegatedLongValue negatedLongValue =
        new NegatedLongValue(new NegatedLongValue(BasicValueFactory.LONG_VALUE));

    // Act and Assert
    assertNotEquals(negatedLongValue, new NegatedLongValue(BasicValueFactory.LONG_VALUE));
  }

  /**
   * Test {@link NegatedLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedLongValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedLongValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedLongValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NegatedLongValue(BasicValueFactory.LONG_VALUE), null);
  }

  /**
   * Test {@link NegatedLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedLongValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedLongValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedLongValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new NegatedLongValue(BasicValueFactory.LONG_VALUE), "Different type to NegatedLongValue");
  }
}
