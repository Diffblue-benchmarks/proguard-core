package proguard.resources.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ResourceFileDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceFile#toString()}
   *   <li>{@link ResourceFile#getFileName()}
   *   <li>{@link ResourceFile#getFileSize()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
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

  /**
   * Method under test: {@link ResourceFile#ResourceFile(String, long)}
   */
  @Test
  public void testNewResourceFile() {
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
   * Method under test: {@link ResourceFile#ResourceFile(String, long, int)}
   */
  @Test
  public void testNewResourceFile2() {
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
}
