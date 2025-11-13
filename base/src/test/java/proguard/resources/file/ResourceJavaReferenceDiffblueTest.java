package proguard.resources.file;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ResourceJavaReferenceDiffblueTest {
  /**
   * Test {@link ResourceJavaReference#ResourceJavaReference(String)}.
   *
   * <p>Method under test: {@link ResourceJavaReference#ResourceJavaReference(String)}
   */
  @Test
  @DisplayName("Test new ResourceJavaReference(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceJavaReference.<init>(String)"})
  void testNewResourceJavaReference() {
    // Arrange and Act
    ResourceJavaReference actualResourceJavaReference =
        new ResourceJavaReference("External Class Name");

    // Assert
    assertEquals("External Class Name", actualResourceJavaReference.externalClassName);
    assertNull(actualResourceJavaReference.referencedClass);
  }

  /**
   * Test {@link ResourceJavaReference#equals(Object)}, and {@link
   * ResourceJavaReference#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceJavaReference#equals(Object)}
   *   <li>{@link ResourceJavaReference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceJavaReference.equals(Object)",
    "int ResourceJavaReference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ResourceJavaReference resourceJavaReference = new ResourceJavaReference("External Class Name");
    ResourceJavaReference resourceJavaReference2 = new ResourceJavaReference("External Class Name");

    // Act and Assert
    assertEquals(resourceJavaReference, resourceJavaReference2);
    assertEquals(resourceJavaReference.hashCode(), resourceJavaReference2.hashCode());
  }

  /**
   * Test {@link ResourceJavaReference#equals(Object)}, and {@link
   * ResourceJavaReference#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceJavaReference#equals(Object)}
   *   <li>{@link ResourceJavaReference#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceJavaReference.equals(Object)",
    "int ResourceJavaReference.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ResourceJavaReference resourceJavaReference = new ResourceJavaReference("External Class Name");

    // Act and Assert
    assertEquals(resourceJavaReference, resourceJavaReference);
    int expectedHashCodeResult = resourceJavaReference.hashCode();
    assertEquals(expectedHashCodeResult, resourceJavaReference.hashCode());
  }

  /**
   * Test {@link ResourceJavaReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceJavaReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceJavaReference.equals(Object)",
    "int ResourceJavaReference.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ResourceJavaReference resourceJavaReference =
        new ResourceJavaReference("proguard.resources.file.ResourceJavaReference");

    // Act and Assert
    assertNotEquals(resourceJavaReference, new ResourceJavaReference("External Class Name"));
  }

  /**
   * Test {@link ResourceJavaReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceJavaReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceJavaReference.equals(Object)",
    "int ResourceJavaReference.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ResourceJavaReference("External Class Name"), null);
  }

  /**
   * Test {@link ResourceJavaReference#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceJavaReference#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceJavaReference.equals(Object)",
    "int ResourceJavaReference.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ResourceJavaReference("External Class Name"),
        "Different type to ResourceJavaReference");
  }
}
