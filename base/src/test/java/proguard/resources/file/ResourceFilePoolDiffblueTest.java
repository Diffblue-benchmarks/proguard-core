package proguard.resources.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ResourceFilePoolDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceFilePool#ResourceFilePool()}
   *   <li>{@link ResourceFilePool#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceFilePool.<init>()", "String ResourceFilePool.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    ResourceFilePool actualResourceFilePool = new ResourceFilePool();

    // Assert
    assertEquals("{}", actualResourceFilePool.toString());
    assertTrue(actualResourceFilePool.resourceFileMap.isEmpty());
  }

  /**
   * Test {@link ResourceFilePool#ResourceFilePool(ResourceFile[])}.
   *
   * <ul>
   *   <li>Then return {@link ResourceFilePool#resourceFileMap} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePool#ResourceFilePool(ResourceFile[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceFilePool.<init>(ResourceFile[])"})
  public void testNewResourceFilePool_thenReturnResourceFileMapSizeIsOne() {
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

  /**
   * Test {@link ResourceFilePool#ResourceFilePool(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePool#ResourceFilePool(Iterable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceFilePool.<init>(Iterable)"})
  public void testNewResourceFilePool_whenArrayList_thenReturnSizeIsZero() {
    // Arrange and Act
    ResourceFilePool actualResourceFilePool = new ResourceFilePool(new ArrayList<>());

    // Assert
    assertEquals(0, actualResourceFilePool.size());
    assertTrue(actualResourceFilePool.resourceFileMap.isEmpty());
  }

  /**
   * Test {@link ResourceFilePool#addResourceFile(String, ResourceFile)} with {@code fileName},
   * {@code resourceFile}.
   *
   * <p>Method under test: {@link ResourceFilePool#addResourceFile(String, ResourceFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceFilePool.addResourceFile(String, ResourceFile)"})
  public void testAddResourceFileWithFileNameResourceFile() {
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
   * Test {@link ResourceFilePool#addResourceFile(ResourceFile)} with {@code resourceFile}.
   *
   * <ul>
   *   <li>Then {@link ResourceFilePool#ResourceFilePool()} {@link ResourceFilePool#resourceFileMap}
   *       size is one.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePool#addResourceFile(ResourceFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ResourceFilePool.addResourceFile(ResourceFile)"})
  public void testAddResourceFileWithResourceFile_thenResourceFilePoolResourceFileMapSizeIsOne() {
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
   * Test {@link ResourceFilePool#getResourceFile(String)}.
   *
   * <p>Method under test: {@link ResourceFilePool#getResourceFile(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceFile ResourceFilePool.getResourceFile(String)"})
  public void testGetResourceFile() {
    // Arrange, Act and Assert
    assertNull((new ResourceFilePool()).getResourceFile("foo.txt"));
  }

  /**
   * Test {@link ResourceFilePool#size()}.
   *
   * <p>Method under test: {@link ResourceFilePool#size()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ResourceFilePool.size()"})
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new ResourceFilePool()).size());
  }

  /**
   * Test {@link ResourceFilePool#refreshedCopy()}.
   *
   * <ul>
   *   <li>Given {@link ResourceFilePool#ResourceFilePool()}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePool#refreshedCopy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceFilePool ResourceFilePool.refreshedCopy()"})
  public void testRefreshedCopy_givenResourceFilePool_thenReturnSizeIsZero() {
    // Arrange and Act
    ResourceFilePool actualRefreshedCopyResult = (new ResourceFilePool()).refreshedCopy();

    // Assert
    assertEquals(0, actualRefreshedCopyResult.size());
    assertTrue(actualRefreshedCopyResult.resourceFileMap.isEmpty());
  }

  /**
   * Test {@link ResourceFilePool#refreshedCopy()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePool#refreshedCopy()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ResourceFilePool ResourceFilePool.refreshedCopy()"})
  public void testRefreshedCopy_thenReturnSizeIsOne() {
    // Arrange
    ResourceFilePool resourceFilePool = new ResourceFilePool(new ResourceFile("foo.txt", 3L));

    // Act
    ResourceFilePool actualRefreshedCopyResult = resourceFilePool.refreshedCopy();

    // Assert
    assertEquals(1, actualRefreshedCopyResult.size());
    assertEquals(resourceFilePool.resourceFileMap, actualRefreshedCopyResult.resourceFileMap);
  }

  /**
   * Test {@link ResourceFilePool#resourceFileNames()}.
   *
   * <p>Method under test: {@link ResourceFilePool#resourceFileNames()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Set ResourceFilePool.resourceFileNames()"})
  public void testResourceFileNames() {
    // Arrange, Act and Assert
    assertTrue((new ResourceFilePool()).resourceFileNames().isEmpty());
  }
}
