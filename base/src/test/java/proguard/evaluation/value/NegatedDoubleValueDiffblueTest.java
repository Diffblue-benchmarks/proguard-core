package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NegatedDoubleValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedDoubleValue#NegatedDoubleValue(DoubleValue)}
   *   <li>{@link NegatedDoubleValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.NegatedDoubleValue.<init>(proguard.evaluation.value.DoubleValue)",
    "java.lang.String proguard.evaluation.value.NegatedDoubleValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("-d", (new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE)).toString());
  }

  /**
   * Test {@link NegatedDoubleValue#negate()}.
   *
   * <p>Method under test: {@link NegatedDoubleValue#negate()}
   */
  @Test
  @DisplayName("Test negate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.DoubleValue proguard.evaluation.value.NegatedDoubleValue.negate()"
  })
  void testNegate() {
    // Arrange and Act
    DoubleValue actualNegateResult =
        (new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof UnknownDoubleValue);
    assertFalse(actualNegateResult.isParticular());
    assertFalse(actualNegateResult.isSpecific());
    assertTrue(actualNegateResult.isCategory2());
  }

  /**
   * Test {@link NegatedDoubleValue#equals(Object)}, and {@link NegatedDoubleValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedDoubleValue#equals(Object)}
   *   <li>{@link NegatedDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedDoubleValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedDoubleValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NegatedDoubleValue negatedDoubleValue = new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE);
    NegatedDoubleValue negatedDoubleValue2 = new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(negatedDoubleValue, negatedDoubleValue2);
    int expectedHashCodeResult = negatedDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedDoubleValue2.hashCode());
  }

  /**
   * Test {@link NegatedDoubleValue#equals(Object)}, and {@link NegatedDoubleValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedDoubleValue#equals(Object)}
   *   <li>{@link NegatedDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedDoubleValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedDoubleValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NegatedDoubleValue negatedDoubleValue = new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertEquals(negatedDoubleValue, negatedDoubleValue);
    int expectedHashCodeResult = negatedDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedDoubleValue.hashCode());
  }

  /**
   * Test {@link NegatedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedDoubleValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedDoubleValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NegatedDoubleValue negatedDoubleValue =
        new NegatedDoubleValue(ParticularValueFactory.DOUBLE_VALUE_0);

    // Act and Assert
    assertNotEquals(negatedDoubleValue, new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link NegatedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedDoubleValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedDoubleValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NegatedDoubleValue negatedDoubleValue =
        new NegatedDoubleValue(new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE));

    // Act and Assert
    assertNotEquals(negatedDoubleValue, new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE));
  }

  /**
   * Test {@link NegatedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedDoubleValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedDoubleValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE), null);
  }

  /**
   * Test {@link NegatedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedDoubleValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedDoubleValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new NegatedDoubleValue(BasicValueFactory.DOUBLE_VALUE),
        "Different type to NegatedDoubleValue");
  }
}
