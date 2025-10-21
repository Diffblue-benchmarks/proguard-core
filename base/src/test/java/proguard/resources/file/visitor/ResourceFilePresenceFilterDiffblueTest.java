package proguard.resources.file.visitor;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.resources.file.FilePool;
import proguard.resources.file.ResourceFile;
import proguard.resources.file.ResourceFilePool;

public class ResourceFilePresenceFilterDiffblueTest {
  /**
   * Test {@link ResourceFilePresenceFilter#resourceFileVisitor(ResourceFile)}.
   *
   * <ul>
   *   <li>Given {@link ResourceFile#ResourceFile(String, long)} with fileName is {@code foo.txt}
   *       and fileSize is three.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePresenceFilter#resourceFileVisitor(ResourceFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ResourceFileVisitor ResourceFilePresenceFilter.resourceFileVisitor(ResourceFile)"
  })
  public void testResourceFileVisitor_givenResourceFileWithFileNameIsFooTxtAndFileSizeIsThree() {
    // Arrange
    ResourceFilePool filePool = new ResourceFilePool(new ResourceFile("foo.txt", 3L));
    ResourceJavaReferenceCleaner presentResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceFilePresenceFilter resourceFilePresenceFilter =
        new ResourceFilePresenceFilter(
            (FilePool) filePool, presentResourceFileVisitor, new ResourceJavaReferenceCleaner());

    // Act
    ResourceFileVisitor actualResourceFileVisitorResult =
        resourceFilePresenceFilter.resourceFileVisitor(new ResourceFile("foo.txt", 3L));

    // Assert
    assertTrue(actualResourceFileVisitorResult instanceof ResourceJavaReferenceCleaner);
    assertSame(presentResourceFileVisitor, actualResourceFileVisitorResult);
  }

  /**
   * Test {@link ResourceFilePresenceFilter#resourceFileVisitor(ResourceFile)}.
   *
   * <ul>
   *   <li>Then return {@link ResourceJavaReferenceCleaner}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceFilePresenceFilter#resourceFileVisitor(ResourceFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ResourceFileVisitor ResourceFilePresenceFilter.resourceFileVisitor(ResourceFile)"
  })
  public void testResourceFileVisitor_thenReturnResourceJavaReferenceCleaner() {
    // Arrange
    ResourceFilePool filePool = new ResourceFilePool();
    ResourceJavaReferenceCleaner presentResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceJavaReferenceCleaner missingResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceFilePresenceFilter resourceFilePresenceFilter =
        new ResourceFilePresenceFilter(
            (FilePool) filePool, presentResourceFileVisitor, missingResourceFileVisitor);

    // Act
    ResourceFileVisitor actualResourceFileVisitorResult =
        resourceFilePresenceFilter.resourceFileVisitor(new ResourceFile("foo.txt", 3L));

    // Assert
    assertTrue(actualResourceFileVisitorResult instanceof ResourceJavaReferenceCleaner);
    assertSame(missingResourceFileVisitor, actualResourceFileVisitorResult);
  }
}
