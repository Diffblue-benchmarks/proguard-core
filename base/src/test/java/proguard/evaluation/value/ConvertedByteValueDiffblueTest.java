package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConvertedByteValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedByteValue#ConvertedByteValue(IntegerValue)}
   *   <li>{@link ConvertedByteValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConvertedByteValue.<init>(IntegerValue)",
    "java.lang.String ConvertedByteValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "(byte)(b)", new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE).toString());
  }

  /**
   * Test {@link ConvertedByteValue#equals(Object)}, and {@link ConvertedByteValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedByteValue#equals(Object)}
   *   <li>{@link ConvertedByteValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConvertedByteValue.equals(Object)",
    "int ConvertedByteValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);
    ConvertedByteValue convertedByteValue2 =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedByteValue, convertedByteValue2);
    assertEquals(convertedByteValue.hashCode(), convertedByteValue2.hashCode());
  }

  /**
   * Test {@link ConvertedByteValue#equals(Object)}, and {@link ConvertedByteValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConvertedByteValue#equals(Object)}
   *   <li>{@link ConvertedByteValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConvertedByteValue.equals(Object)",
    "int ConvertedByteValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    // Act and Assert
    assertEquals(convertedByteValue, convertedByteValue);
    int expectedHashCodeResult = convertedByteValue.hashCode();
    assertEquals(expectedHashCodeResult, convertedByteValue.hashCode());
  }

  /**
   * Test {@link ConvertedByteValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedByteValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConvertedByteValue.equals(Object)",
    "int ConvertedByteValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_CHAR);

    // Act and Assert
    assertNotEquals(
        convertedByteValue, new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ConvertedByteValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedByteValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConvertedByteValue.equals(Object)",
    "int ConvertedByteValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ConvertedByteValue convertedByteValue =
        new ConvertedByteValue(new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act and Assert
    assertNotEquals(
        convertedByteValue, new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link ConvertedByteValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedByteValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConvertedByteValue.equals(Object)",
    "int ConvertedByteValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE), null);
  }

  /**
   * Test {@link ConvertedByteValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConvertedByteValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConvertedByteValue.equals(Object)",
    "int ConvertedByteValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ConvertedByteValue(BasicRangeValueFactory.INTEGER_VALUE_BYTE),
        "Different type to ConvertedByteValue");
  }
}
