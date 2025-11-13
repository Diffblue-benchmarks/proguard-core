package proguard.evaluation.value.object;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TypedNullObjectDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypedNullObject#TypedNullObject(String)}
   *   <li>{@link TypedNullObject#toString()}
   *   <li>{@link TypedNullObject#getPreciseValue()}
   *   <li>{@link TypedNullObject#getType()}
   *   <li>{@link TypedNullObject#isModeled()}
   *   <li>{@link TypedNullObject#isNull()}
   *   <li>{@link TypedNullObject#isPrecise()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TypedNullObject.<init>(String)",
    "Object TypedNullObject.getPreciseValue()",
    "String TypedNullObject.getType()",
    "boolean TypedNullObject.isModeled()",
    "boolean TypedNullObject.isNull()",
    "boolean TypedNullObject.isPrecise()",
    "String TypedNullObject.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TypedNullObject actualTypedNullObject = new TypedNullObject("Type");
    String actualToStringResult = actualTypedNullObject.toString();
    Object actualPreciseValue = actualTypedNullObject.getPreciseValue();
    String actualType = actualTypedNullObject.getType();
    boolean actualIsModeledResult = actualTypedNullObject.isModeled();
    boolean actualIsNullResult = actualTypedNullObject.isNull();

    // Assert
    assertEquals("Type", actualType);
    assertEquals("TypedNullObject(Type)", actualToStringResult);
    assertNull(actualPreciseValue);
    assertFalse(actualIsModeledResult);
    assertTrue(actualIsNullResult);
    assertTrue(actualTypedNullObject.isPrecise());
  }

  /**
   * Test {@link TypedNullObject#equals(Object)}, and {@link TypedNullObject#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypedNullObject#equals(Object)}
   *   <li>{@link TypedNullObject#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypedNullObject.equals(Object)", "int TypedNullObject.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TypedNullObject typedNullObject = new TypedNullObject("Type");
    TypedNullObject typedNullObject2 = new TypedNullObject("Type");

    // Act and Assert
    assertEquals(typedNullObject, typedNullObject2);
    assertEquals(typedNullObject.hashCode(), typedNullObject2.hashCode());
  }

  /**
   * Test {@link TypedNullObject#equals(Object)}, and {@link TypedNullObject#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypedNullObject#equals(Object)}
   *   <li>{@link TypedNullObject#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypedNullObject.equals(Object)", "int TypedNullObject.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TypedNullObject typedNullObject = new TypedNullObject("Type");

    // Act and Assert
    assertEquals(typedNullObject, typedNullObject);
    int expectedHashCodeResult = typedNullObject.hashCode();
    assertEquals(expectedHashCodeResult, typedNullObject.hashCode());
  }

  /**
   * Test {@link TypedNullObject#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypedNullObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypedNullObject.equals(Object)", "int TypedNullObject.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TypedNullObject typedNullObject =
        new TypedNullObject("proguard.evaluation.value.object.TypedNullObject");

    // Act and Assert
    assertNotEquals(typedNullObject, new TypedNullObject("Type"));
  }

  /**
   * Test {@link TypedNullObject#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypedNullObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypedNullObject.equals(Object)", "int TypedNullObject.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypedNullObject("Type"), null);
  }

  /**
   * Test {@link TypedNullObject#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypedNullObject#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypedNullObject.equals(Object)", "int TypedNullObject.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypedNullObject("Type"), "Different type to TypedNullObject");
  }
}
