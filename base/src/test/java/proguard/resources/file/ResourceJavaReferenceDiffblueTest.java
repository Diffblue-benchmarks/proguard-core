package proguard.resources.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ResourceJavaReferenceDiffblueTest {
  /**
   * Test {@link ResourceJavaReference#ResourceJavaReference(String)}.
   *
   * <p>Method under test: {@link ResourceJavaReference#ResourceJavaReference(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceJavaReference.<init>(String)"})
  public void testNewResourceJavaReference() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ResourceJavaReference.equals(Object)",
    "int ResourceJavaReference.hashCode()"
  })
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ResourceJavaReference.equals(Object)",
    "int ResourceJavaReference.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ResourceJavaReference.equals(Object)",
    "int ResourceJavaReference.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ResourceJavaReference.equals(Object)",
    "int ResourceJavaReference.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean ResourceJavaReference.equals(Object)",
    "int ResourceJavaReference.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ResourceJavaReference("External Class Name"),
        "Different type to ResourceJavaReference");
  }
}
