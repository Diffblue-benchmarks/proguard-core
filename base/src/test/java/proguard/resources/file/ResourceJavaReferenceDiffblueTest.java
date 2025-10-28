package proguard.resources.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ResourceJavaReferenceDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceJavaReference#equals(Object)}
   *   <li>{@link ResourceJavaReference#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ResourceJavaReference resourceJavaReference = new ResourceJavaReference("External Class Name");
    ResourceJavaReference resourceJavaReference2 = new ResourceJavaReference("External Class Name");

    // Act and Assert
    assertEquals(resourceJavaReference, resourceJavaReference2);
    int expectedHashCodeResult = resourceJavaReference.hashCode();
    assertEquals(expectedHashCodeResult, resourceJavaReference2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceJavaReference#equals(Object)}
   *   <li>{@link ResourceJavaReference#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ResourceJavaReference resourceJavaReference = new ResourceJavaReference("External Class Name");

    // Act and Assert
    assertEquals(resourceJavaReference, resourceJavaReference);
    int expectedHashCodeResult = resourceJavaReference.hashCode();
    assertEquals(expectedHashCodeResult, resourceJavaReference.hashCode());
  }

  /**
   * Method under test: {@link ResourceJavaReference#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ResourceJavaReference resourceJavaReference = new ResourceJavaReference(
        "proguard.resources.file.ResourceJavaReference");

    // Act and Assert
    assertNotEquals(resourceJavaReference, new ResourceJavaReference("External Class Name"));
  }

  /**
   * Method under test: {@link ResourceJavaReference#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ResourceJavaReference("External Class Name"), null);
  }

  /**
   * Method under test: {@link ResourceJavaReference#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ResourceJavaReference("External Class Name"), "Different type to ResourceJavaReference");
  }

  /**
   * Method under test:
   * {@link ResourceJavaReference#ResourceJavaReference(String)}
   */
  @Test
  public void testNewResourceJavaReference() {
    // Arrange and Act
    ResourceJavaReference actualResourceJavaReference = new ResourceJavaReference("External Class Name");

    // Assert
    assertEquals("External Class Name", actualResourceJavaReference.externalClassName);
    assertNull(actualResourceJavaReference.referencedClass);
  }
}
