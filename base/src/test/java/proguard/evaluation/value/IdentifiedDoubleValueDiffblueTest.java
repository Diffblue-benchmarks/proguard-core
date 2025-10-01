package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.ParticularReferenceValueFactory;

class IdentifiedDoubleValueDiffblueTest {
  /**
   * Test {@link IdentifiedDoubleValue#IdentifiedDoubleValue(ValueFactory, int)}.
   *
   * <p>Method under test: {@link IdentifiedDoubleValue#IdentifiedDoubleValue(ValueFactory, int)}
   */
  @Test
  @DisplayName("Test new IdentifiedDoubleValue(ValueFactory, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IdentifiedDoubleValue.<init>(ValueFactory, int)",
    "java.lang.String IdentifiedDoubleValue.toString()"
  })
  void testNewIdentifiedDoubleValue() {
    // Arrange and Act
    IdentifiedDoubleValue actualIdentifiedDoubleValue =
        new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1);

    // Assert
    assertFalse(actualIdentifiedDoubleValue.isParticular());
    assertTrue(actualIdentifiedDoubleValue.isCategory2());
    assertTrue(actualIdentifiedDoubleValue.isSpecific());
  }

  /**
   * Test {@link IdentifiedDoubleValue#equals(Object)}, and {@link
   * IdentifiedDoubleValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IdentifiedDoubleValue#equals(Object)}
   *   <li>{@link IdentifiedDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IdentifiedDoubleValue.equals(Object)",
    "int IdentifiedDoubleValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IdentifiedDoubleValue identifiedDoubleValue =
        new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertEquals(identifiedDoubleValue, identifiedDoubleValue);
    int expectedHashCodeResult = identifiedDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, identifiedDoubleValue.hashCode());
  }

  /**
   * Test {@link IdentifiedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IdentifiedDoubleValue.equals(Object)",
    "int IdentifiedDoubleValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IdentifiedDoubleValue identifiedDoubleValue =
        new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertNotEquals(
        identifiedDoubleValue, new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1));
  }

  /**
   * Test {@link IdentifiedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IdentifiedDoubleValue.equals(Object)",
    "int IdentifiedDoubleValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1), null);
  }

  /**
   * Test {@link IdentifiedDoubleValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedDoubleValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IdentifiedDoubleValue.equals(Object)",
    "int IdentifiedDoubleValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1),
        "Different type to IdentifiedDoubleValue");
  }
}
