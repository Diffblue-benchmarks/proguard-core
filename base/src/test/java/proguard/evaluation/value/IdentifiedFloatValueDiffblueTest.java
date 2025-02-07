package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.ParticularReferenceValueFactory;

class IdentifiedFloatValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IdentifiedFloatValue#IdentifiedFloatValue(ValueFactory, int)}
   *   <li>{@link IdentifiedFloatValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.IdentifiedFloatValue.<init>(proguard.evaluation.value.ValueFactory, int)",
    "java.lang.String proguard.evaluation.value.IdentifiedFloatValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "f1", (new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1)).toString());
  }

  /**
   * Test {@link IdentifiedFloatValue#equals(Object)}, and {@link IdentifiedFloatValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IdentifiedFloatValue#equals(Object)}
   *   <li>{@link IdentifiedFloatValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.IdentifiedFloatValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.IdentifiedFloatValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IdentifiedFloatValue identifiedFloatValue =
        new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertEquals(identifiedFloatValue, identifiedFloatValue);
    int expectedHashCodeResult = identifiedFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, identifiedFloatValue.hashCode());
  }

  /**
   * Test {@link IdentifiedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedFloatValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.IdentifiedFloatValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.IdentifiedFloatValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IdentifiedFloatValue identifiedFloatValue =
        new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertNotEquals(
        identifiedFloatValue, new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1));
  }

  /**
   * Test {@link IdentifiedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedFloatValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.IdentifiedFloatValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.IdentifiedFloatValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1), null);
  }

  /**
   * Test {@link IdentifiedFloatValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IdentifiedFloatValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.IdentifiedFloatValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.IdentifiedFloatValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1),
        "Different type to IdentifiedFloatValue");
  }
}
