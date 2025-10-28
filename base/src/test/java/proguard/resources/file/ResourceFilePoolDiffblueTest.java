package proguard.resources.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Map;
import org.junit.Test;

public class ResourceFilePoolDiffblueTest {
  /**
   * Method under test:
   * {@link ResourceFilePool#addResourceFile(String, ResourceFile)}
   */
  @Test
  public void testAddResourceFile() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    ResourceFile resourceFile = new ResourceFile("foo.txt", 3L);

    // Act
    resourceFilePool.addResourceFile("foo.txt", resourceFile);

    // Assert
    Map<String, ResourceFile> stringResourceFileMap = resourceFilePool.resourceFileMap;
    assertEquals(1, stringResourceFileMap.size());
    assertEquals(1, resourceFilePool.size());
    assertSame(resourceFile, stringResourceFileMap.get("foo.txt"));
  }

  /**
   * Method under test: {@link ResourceFilePool#addResourceFile(ResourceFile)}
   */
  @Test
  public void testAddResourceFile2() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool();
    ResourceFile resourceFile = new ResourceFile("foo.txt", 3L);

    // Act
    resourceFilePool.addResourceFile(resourceFile);

    // Assert
    Map<String, ResourceFile> stringResourceFileMap = resourceFilePool.resourceFileMap;
    assertEquals(1, stringResourceFileMap.size());
    assertEquals(1, resourceFilePool.size());
    assertSame(resourceFile, stringResourceFileMap.get("foo.txt"));
  }

  /**
   * Method under test: {@link ResourceFilePool#getResourceFile(String)}
   */
  @Test
  public void testGetResourceFile() {
    // Arrange, Act and Assert
    assertNull((new ResourceFilePool()).getResourceFile("foo.txt"));
  }

  /**
   * Method under test: {@link ResourceFilePool#size()}
   */
  @Test
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new ResourceFilePool()).size());
  }

  /**
   * Method under test: {@link ResourceFilePool#refreshedCopy()}
   */
  @Test
  public void testRefreshedCopy() {
    // Arrange and Act
    ResourceFilePool actualRefreshedCopyResult = (new ResourceFilePool()).refreshedCopy();

    // Assert
    assertEquals(0, actualRefreshedCopyResult.size());
    assertTrue(actualRefreshedCopyResult.resourceFileMap.isEmpty());
  }

  /**
   * Method under test: {@link ResourceFilePool#refreshedCopy()}
   */
  @Test
  public void testRefreshedCopy2() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool(new ResourceFile("foo.txt", 3L));

    // Act
    ResourceFilePool actualRefreshedCopyResult = resourceFilePool.refreshedCopy();

    // Assert
    assertEquals(1, actualRefreshedCopyResult.size());
    assertEquals(resourceFilePool.resourceFileMap, actualRefreshedCopyResult.resourceFileMap);
  }

  /**
   * Method under test: {@link ResourceFilePool#resourceFileNames()}
   */
  @Test
  public void testResourceFileNames() {
    // Arrange, Act and Assert
    assertTrue((new ResourceFilePool()).resourceFileNames().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceFilePool#ResourceFilePool()}
   *   <li>{@link ResourceFilePool#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ResourceFilePool actualResourceFilePool = new ResourceFilePool();

    // Assert
    assertEquals("{}", actualResourceFilePool.toString());
    assertTrue(actualResourceFilePool.resourceFileMap.isEmpty());
  }

  /**
   * Method under test: {@link ResourceFilePool#ResourceFilePool(Iterable)}
   */
  @Test
  public void testNewResourceFilePool() {
    // Arrange and Act
    ResourceFilePool actualResourceFilePool = new ResourceFilePool(new ArrayList<>());

    // Assert
    assertEquals(0, actualResourceFilePool.size());
    assertTrue(actualResourceFilePool.resourceFileMap.isEmpty());
  }

  /**
   * Method under test: {@link ResourceFilePool#ResourceFilePool(ResourceFile[])}
   */
  @Test
  public void testNewResourceFilePool2() {
    // Arrange
    ResourceFile resourceFile = new ResourceFile("foo.txt", 3L);

    // Act
    ResourceFilePool actualResourceFilePool = new ResourceFilePool(resourceFile);

    // Assert
    Map<String, ResourceFile> stringResourceFileMap = actualResourceFilePool.resourceFileMap;
    assertEquals(1, stringResourceFileMap.size());
    assertEquals(1, actualResourceFilePool.size());
    assertSame(resourceFile, stringResourceFileMap.get("foo.txt"));
  }
}
