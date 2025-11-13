package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CompositeLongValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CompositeLongValue#CompositeLongValue(LongValue, byte, Value)}
   *   <li>{@link CompositeLongValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CompositeLongValue.<init>(LongValue, byte, Value)",
    "java.lang.String CompositeLongValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "(lAb)",
        new CompositeLongValue(
                BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE)
            .toString());
  }

  /**
   * Test {@link CompositeLongValue#equals(Object)}, and {@link CompositeLongValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CompositeLongValue#equals(Object)}
   *   <li>{@link CompositeLongValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CompositeLongValue.equals(Object)",
    "int CompositeLongValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    CompositeLongValue compositeLongValue2 =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(compositeLongValue, compositeLongValue2);
    assertEquals(compositeLongValue.hashCode(), compositeLongValue2.hashCode());
  }

  /**
   * Test {@link CompositeLongValue#equals(Object)}, and {@link CompositeLongValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CompositeLongValue#equals(Object)}
   *   <li>{@link CompositeLongValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CompositeLongValue.equals(Object)",
    "int CompositeLongValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(compositeLongValue, compositeLongValue);
    int expectedHashCodeResult = compositeLongValue.hashCode();
    assertEquals(expectedHashCodeResult, compositeLongValue.hashCode());
  }

  /**
   * Test {@link CompositeLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeLongValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CompositeLongValue.equals(Object)",
    "int CompositeLongValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            ParticularValueFactory.LONG_VALUE_0,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(
        compositeLongValue,
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link CompositeLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeLongValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CompositeLongValue.equals(Object)",
    "int CompositeLongValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(
        compositeLongValue,
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link CompositeLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeLongValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CompositeLongValue.equals(Object)",
    "int CompositeLongValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 1, BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(
        compositeLongValue,
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link CompositeLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeLongValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CompositeLongValue.equals(Object)",
    "int CompositeLongValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(
        compositeLongValue,
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link CompositeLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeLongValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CompositeLongValue.equals(Object)",
    "int CompositeLongValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CompositeLongValue compositeLongValue =
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE,
            (byte) 'A',
            new CompositeLongValue(
                BasicValueFactory.LONG_VALUE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(
        compositeLongValue,
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link CompositeLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeLongValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CompositeLongValue.equals(Object)",
    "int CompositeLongValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        null);
  }

  /**
   * Test {@link CompositeLongValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeLongValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CompositeLongValue.equals(Object)",
    "int CompositeLongValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CompositeLongValue(
            BasicValueFactory.LONG_VALUE, (byte) 'A', BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to CompositeLongValue");
  }
}
