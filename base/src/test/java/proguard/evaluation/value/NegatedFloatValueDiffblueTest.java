package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NegatedFloatValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedFloatValue#NegatedFloatValue(FloatValue)}
   *   <li>{@link NegatedFloatValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.NegatedFloatValue.<init>(proguard.evaluation.value.FloatValue)",
    "java.lang.String proguard.evaluation.value.NegatedFloatValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("-f", (new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE)).toString());
  }

  /**
   * Test {@link NegatedFloatValue#negate()}.
   *
   * <p>Method under test: {@link NegatedFloatValue#negate()}
   */
  @Test
  @DisplayName("Test negate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.FloatValue proguard.evaluation.value.NegatedFloatValue.negate()"
  })
  void testNegate() {
    // Arrange and Act
    FloatValue actualNegateResult = (new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE)).negate();

    // Assert
    assertTrue(actualNegateResult instanceof UnknownFloatValue);
    assertFalse(actualNegateResult.isCategory2());
    assertFalse(actualNegateResult.isParticular());
    assertFalse(actualNegateResult.isSpecific());
  }

  /**
   * Test {@link NegatedFloatValue#equals(Object)}, and {@link NegatedFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedFloatValue#equals(Object)}
   *   <li>{@link NegatedFloatValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedFloatValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedFloatValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NegatedFloatValue negatedFloatValue = new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE);
    NegatedFloatValue negatedFloatValue2 = new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertEquals(negatedFloatValue, negatedFloatValue2);
    int expectedHashCodeResult = negatedFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedFloatValue2.hashCode());
  }

  /**
   * Test {@link NegatedFloatValue#equals(Object)}, and {@link NegatedFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NegatedFloatValue#equals(Object)}
   *   <li>{@link NegatedFloatValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedFloatValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedFloatValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NegatedFloatValue negatedFloatValue = new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE);

    // Act and Assert
    assertEquals(negatedFloatValue, negatedFloatValue);
    int expectedHashCodeResult = negatedFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, negatedFloatValue.hashCode());
  }

  /**
   * Test {@link NegatedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedFloatValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedFloatValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedFloatValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NegatedFloatValue negatedFloatValue =
        new NegatedFloatValue(ParticularValueFactory.FLOAT_VALUE_0);

    // Act and Assert
    assertNotEquals(negatedFloatValue, new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link NegatedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedFloatValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedFloatValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedFloatValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NegatedFloatValue negatedFloatValue =
        new NegatedFloatValue(new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE));

    // Act and Assert
    assertNotEquals(negatedFloatValue, new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE));
  }

  /**
   * Test {@link NegatedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedFloatValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedFloatValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedFloatValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE), null);
  }

  /**
   * Test {@link NegatedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NegatedFloatValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.NegatedFloatValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.NegatedFloatValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new NegatedFloatValue(BasicValueFactory.FLOAT_VALUE),
        "Different type to NegatedFloatValue");
  }
}
