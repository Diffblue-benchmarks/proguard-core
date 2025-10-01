package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ComparisonValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComparisonValue#ComparisonValue(Value, Value)}
   *   <li>{@link ComparisonValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ComparisonValue.<init>(Value, Value)",
    "java.lang.String ComparisonValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "(b~b)",
        new ComparisonValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .toString());
  }

  /**
   * Test {@link ComparisonValue#equals(Object)}, and {@link ComparisonValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComparisonValue#equals(Object)}
   *   <li>{@link ComparisonValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ComparisonValue.equals(Object)", "int ComparisonValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ComparisonValue comparisonValue2 =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(comparisonValue, comparisonValue2);
    assertEquals(comparisonValue.hashCode(), comparisonValue2.hashCode());
  }

  /**
   * Test {@link ComparisonValue#equals(Object)}, and {@link ComparisonValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ComparisonValue#equals(Object)}
   *   <li>{@link ComparisonValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ComparisonValue.equals(Object)", "int ComparisonValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(comparisonValue, comparisonValue);
    int expectedHashCodeResult = comparisonValue.hashCode();
    assertEquals(expectedHashCodeResult, comparisonValue.hashCode());
  }

  /**
   * Test {@link ComparisonValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComparisonValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ComparisonValue.equals(Object)", "int ComparisonValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_CHAR, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(
        comparisonValue,
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ComparisonValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComparisonValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ComparisonValue.equals(Object)", "int ComparisonValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            new ComparisonValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(
        comparisonValue,
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ComparisonValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComparisonValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ComparisonValue.equals(Object)", "int ComparisonValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(
        comparisonValue,
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ComparisonValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComparisonValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ComparisonValue.equals(Object)", "int ComparisonValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ComparisonValue comparisonValue =
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            new ComparisonValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(
        comparisonValue,
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ComparisonValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComparisonValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ComparisonValue.equals(Object)", "int ComparisonValue.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        null);
  }

  /**
   * Test {@link ComparisonValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ComparisonValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ComparisonValue.equals(Object)", "int ComparisonValue.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ComparisonValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ComparisonValue");
  }
}
