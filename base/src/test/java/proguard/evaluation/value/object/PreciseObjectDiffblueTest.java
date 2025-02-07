package proguard.evaluation.value.object;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PreciseObjectDiffblueTest {
  /**
   * Test {@link PreciseObject#PreciseObject(Object)}.
   *
   * <p>Method under test: {@link PreciseObject#PreciseObject(Object)}
   */
  @Test
  @DisplayName("Test new PreciseObject(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.object.PreciseObject.<init>(java.lang.Object)"
  })
  void testNewPreciseObject() {
    // Arrange and Act
    PreciseObject actualPreciseObject = new PreciseObject("Object");

    // Assert
    assertEquals("Ljava/lang/String;", actualPreciseObject.getType());
    assertEquals("Object", actualPreciseObject.getPreciseValue());
    assertFalse(actualPreciseObject.isModeled());
    assertFalse(actualPreciseObject.isNull());
    assertTrue(actualPreciseObject.isPrecise());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PreciseObject#toString()}
   *   <li>{@link PreciseObject#getPreciseValue()}
   *   <li>{@link PreciseObject#getType()}
   *   <li>{@link PreciseObject#isModeled()}
   *   <li>{@link PreciseObject#isNull()}
   *   <li>{@link PreciseObject#isPrecise()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.Object proguard.evaluation.value.object.PreciseObject.getPreciseValue()",
    "java.lang.String proguard.evaluation.value.object.PreciseObject.getType()",
    "boolean proguard.evaluation.value.object.PreciseObject.isModeled()",
    "boolean proguard.evaluation.value.object.PreciseObject.isNull()",
    "boolean proguard.evaluation.value.object.PreciseObject.isPrecise()",
    "java.lang.String proguard.evaluation.value.object.PreciseObject.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    PreciseObject preciseObject = new PreciseObject("Object");

    // Act
    String actualToStringResult = preciseObject.toString();
    Object actualPreciseValue = preciseObject.getPreciseValue();
    String actualType = preciseObject.getType();
    boolean actualIsModeledResult = preciseObject.isModeled();
    boolean actualIsNullResult = preciseObject.isNull();

    // Assert
    assertEquals("Ljava/lang/String;", actualType);
    assertEquals("Object", actualPreciseValue);
    assertEquals("PreciseObject(Object)", actualToStringResult);
    assertFalse(actualIsModeledResult);
    assertFalse(actualIsNullResult);
    assertTrue(preciseObject.isPrecise());
  }

  /**
   * Test {@link PreciseObject#equals(Object)}, and {@link PreciseObject#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PreciseObject#equals(Object)}
   *   <li>{@link PreciseObject#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.PreciseObject.equals(java.lang.Object)",
    "int proguard.evaluation.value.object.PreciseObject.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PreciseObject preciseObject = new PreciseObject("Object");
    PreciseObject preciseObject2 = new PreciseObject("Object");

    // Act and Assert
    assertEquals(preciseObject, preciseObject2);
    int expectedHashCodeResult = preciseObject.hashCode();
    assertEquals(expectedHashCodeResult, preciseObject2.hashCode());
  }

  /**
   * Test {@link PreciseObject#equals(Object)}, and {@link PreciseObject#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PreciseObject#equals(Object)}
   *   <li>{@link PreciseObject#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.PreciseObject.equals(java.lang.Object)",
    "int proguard.evaluation.value.object.PreciseObject.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PreciseObject preciseObject = new PreciseObject("Object");

    // Act and Assert
    assertEquals(preciseObject, preciseObject);
    int expectedHashCodeResult = preciseObject.hashCode();
    assertEquals(expectedHashCodeResult, preciseObject.hashCode());
  }

  /**
   * Test {@link PreciseObject#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PreciseObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.PreciseObject.equals(java.lang.Object)",
    "int proguard.evaluation.value.object.PreciseObject.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PreciseObject preciseObject = new PreciseObject(1);

    // Act and Assert
    assertNotEquals(preciseObject, new PreciseObject("Object"));
  }

  /**
   * Test {@link PreciseObject#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PreciseObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.PreciseObject.equals(java.lang.Object)",
    "int proguard.evaluation.value.object.PreciseObject.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PreciseObject preciseObject = new PreciseObject(new PreciseObject("Object"));

    // Act and Assert
    assertNotEquals(preciseObject, new PreciseObject("Object"));
  }

  /**
   * Test {@link PreciseObject#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PreciseObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.PreciseObject.equals(java.lang.Object)",
    "int proguard.evaluation.value.object.PreciseObject.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PreciseObject("Object"), null);
  }

  /**
   * Test {@link PreciseObject#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PreciseObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.PreciseObject.equals(java.lang.Object)",
    "int proguard.evaluation.value.object.PreciseObject.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PreciseObject("Object"), "Different type to PreciseObject");
  }
}
