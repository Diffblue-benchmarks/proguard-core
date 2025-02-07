package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConvertedIntegerValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedIntegerValue#ConvertedIntegerValue(Value)}
   *   <li>{@link ConvertedIntegerValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.ConvertedIntegerValue.<init>(proguard.evaluation.value.Value)",
    "java.lang.String proguard.evaluation.value.ConvertedIntegerValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "(int)(b)",
        (new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE)).toString());
  }

  /**
   * Test {@link ConvertedIntegerValue#equals(Object)}, and {@link
   * ConvertedIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedIntegerValue#equals(Object)}
   *   <li>{@link ConvertedIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ConvertedIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ConvertedIntegerValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConvertedIntegerValue convertedIntegerValue =
        new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedIntegerValue convertedIntegerValue2 =
        new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedIntegerValue, convertedIntegerValue2);
    int expectedHashCodeResult = convertedIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedIntegerValue2.hashCode());
  }

  /**
   * Test {@link ConvertedIntegerValue#equals(Object)}, and {@link
   * ConvertedIntegerValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedIntegerValue#equals(Object)}
   *   <li>{@link ConvertedIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ConvertedIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ConvertedIntegerValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConvertedIntegerValue convertedIntegerValue =
        new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedIntegerValue, convertedIntegerValue);
    int expectedHashCodeResult = convertedIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedIntegerValue.hashCode());
  }

  /**
   * Test {@link ConvertedIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ConvertedIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ConvertedIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConvertedIntegerValue convertedIntegerValue =
        new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(
        convertedIntegerValue,
        new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ConvertedIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ConvertedIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ConvertedIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Test {@link ConvertedIntegerValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedIntegerValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.ConvertedIntegerValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.ConvertedIntegerValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ConvertedIntegerValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ConvertedIntegerValue");
  }
}
