package proguard.resources.file;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ResourceFileDiffblueTest {
  /**
   * Test {@link ResourceFile#ResourceFile(String, long)}.
   *
   * <p>Method under test: {@link ResourceFile#ResourceFile(String, long)}
   */
  @Test
  @DisplayName("Test new ResourceFile(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceFile.<init>(String, long)"})
  void testNewResourceFile() {
    // Arrange and Act
    ResourceFile actualResourceFile = new ResourceFile("foo.txt", 3L);

    // Assert
    assertEquals("foo.txt", actualResourceFile.getFileName());
    assertNull(actualResourceFile.getProcessingInfo());
    assertNull(actualResourceFile.getFeatureName());
    assertEquals(0, actualResourceFile.getProcessingFlags());
    assertEquals(3L, actualResourceFile.getFileSize());
    assertTrue(actualResourceFile.getExtraFeatureNames().isEmpty());
    assertTrue(actualResourceFile.references.isEmpty());
  }

  /**
   * Test {@link ResourceFile#ResourceFile(String, long, int)}.
   *
   * <p>Method under test: {@link ResourceFile#ResourceFile(String, long, int)}
   */
  @Test
  @DisplayName("Test new ResourceFile(String, long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ResourceFile.<init>(String, long, int)"})
  void testNewResourceFile2() {
    // Arrange and Act
    ResourceFile actualResourceFile = new ResourceFile("foo.txt", 3L, 1);

    // Assert
    assertEquals("foo.txt", actualResourceFile.getFileName());
    assertNull(actualResourceFile.getProcessingInfo());
    assertNull(actualResourceFile.getFeatureName());
    assertEquals(1, actualResourceFile.getProcessingFlags());
    assertEquals(3L, actualResourceFile.getFileSize());
    assertTrue(actualResourceFile.getExtraFeatureNames().isEmpty());
    assertTrue(actualResourceFile.references.isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceFile#toString()}
   *   <li>{@link ResourceFile#getFileName()}
   *   <li>{@link ResourceFile#getFileSize()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ResourceFile.getFileName()",
    "long ResourceFile.getFileSize()",
    "String ResourceFile.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ResourceFile resourceFile = new ResourceFile("foo.txt", 3L);

    // Act
    String actualToStringResult = resourceFile.toString();
    String actualFileName = resourceFile.getFileName();

    // Assert
    assertEquals("ResourceFile(foo.txt)", actualToStringResult);
    assertEquals("foo.txt", actualFileName);
    assertEquals(3L, resourceFile.getFileSize());
  }
}
