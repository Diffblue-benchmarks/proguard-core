package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CompositeIntegerValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CompositeIntegerValue#CompositeIntegerValue(IntegerValue, byte, IntegerValue)}
   *   <li>{@link CompositeIntegerValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.CompositeIntegerValue.<init>(proguard.evaluation.value.IntegerValue, byte, proguard.evaluation.value.IntegerValue)",
    "java.lang.String proguard.evaluation.value.CompositeIntegerValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "(bAb)",
        (new CompositeIntegerValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE))
            .toString());
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}, and {@link
   * CompositeIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CompositeIntegerValue#equals(Object)}
   *   <li>{@link CompositeIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.CompositeIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.CompositeIntegerValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue =
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    CompositeIntegerValue compositeIntegerValue2 =
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(compositeIntegerValue, compositeIntegerValue2);
    int expectedHashCodeResult = compositeIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, compositeIntegerValue2.hashCode());
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}, and {@link
   * CompositeIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CompositeIntegerValue#equals(Object)}
   *   <li>{@link CompositeIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.CompositeIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.CompositeIntegerValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue =
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(compositeIntegerValue, compositeIntegerValue);
    int expectedHashCodeResult = compositeIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, compositeIntegerValue.hashCode());
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.CompositeIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.CompositeIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue =
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_CHAR,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(
        compositeIntegerValue,
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.CompositeIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.CompositeIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue =
        new CompositeIntegerValue(
            new CompositeIntegerValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE),
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(
        compositeIntegerValue,
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.CompositeIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.CompositeIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue =
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 1,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertNotEquals(
        compositeIntegerValue,
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.CompositeIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.CompositeIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue =
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(
        compositeIntegerValue,
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.CompositeIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.CompositeIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CompositeIntegerValue compositeIntegerValue =
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            new CompositeIntegerValue(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE,
                (byte) 'A',
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(
        compositeIntegerValue,
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.CompositeIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.CompositeIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        null);
  }

  /**
   * Test {@link CompositeIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CompositeIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.CompositeIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.CompositeIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CompositeIntegerValue(
            BasicRangeValueFactory.INTEGER_VALUE_BYTE,
            (byte) 'A',
            BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to CompositeIntegerValue");
  }
}
