package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.ParticularReferenceValueFactory;

class IdentifiedDoubleValueDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IdentifiedDoubleValue#IdentifiedDoubleValue(ValueFactory, int)}
   *   <li>{@link IdentifiedDoubleValue#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.IdentifiedDoubleValue.<init>(proguard.evaluation.value.ValueFactory, int)",
    "java.lang.String proguard.evaluation.value.IdentifiedDoubleValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "d1", (new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1)).toString());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.IdentifiedDoubleValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.IdentifiedDoubleValue.hashCode()"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.IdentifiedDoubleValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.IdentifiedDoubleValue.hashCode()"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.IdentifiedDoubleValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.IdentifiedDoubleValue.hashCode()"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.IdentifiedDoubleValue.equals(java.lang.Object)",
    "int proguard.evaluation.value.IdentifiedDoubleValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1),
        "Different type to IdentifiedDoubleValue");
  }
}
