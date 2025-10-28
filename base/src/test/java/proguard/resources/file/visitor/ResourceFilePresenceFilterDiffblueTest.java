package proguard.resources.file.visitor;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.resources.file.FilePool;
import proguard.resources.file.ResourceFile;
import proguard.resources.file.ResourceFilePool;

public class ResourceFilePresenceFilterDiffblueTest {
  /**
   * Method under test:
   * {@link ResourceFilePresenceFilter#resourceFileVisitor(ResourceFile)}
   */
  @Test
  public void testResourceFileVisitor() {
    // Arrange
    ResourceFilePool filePool = new ResourceFilePool();
    ResourceJavaReferenceCleaner presentResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceJavaReferenceCleaner missingResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceFilePresenceFilter resourceFilePresenceFilter = new ResourceFilePresenceFilter((FilePool) filePool,
        presentResourceFileVisitor, missingResourceFileVisitor);

    // Act
    ResourceFileVisitor actualResourceFileVisitorResult = resourceFilePresenceFilter
        .resourceFileVisitor(new ResourceFile("foo.txt", 3L));

    // Assert
    assertTrue(actualResourceFileVisitorResult instanceof ResourceJavaReferenceCleaner);
    assertSame(missingResourceFileVisitor, actualResourceFileVisitorResult);
  }

  /**
   * Method under test:
   * {@link ResourceFilePresenceFilter#resourceFileVisitor(ResourceFile)}
   */
  @Test
  public void testResourceFileVisitor2() {
    // Arrange
    ResourceFilePool filePool = new ResourceFilePool(new ResourceFile("foo.txt", 3L));
    ResourceJavaReferenceCleaner presentResourceFileVisitor = new ResourceJavaReferenceCleaner();
    ResourceFilePresenceFilter resourceFilePresenceFilter = new ResourceFilePresenceFilter((FilePool) filePool,
        presentResourceFileVisitor, new ResourceJavaReferenceCleaner());

    // Act
    ResourceFileVisitor actualResourceFileVisitorResult = resourceFilePresenceFilter
        .resourceFileVisitor(new ResourceFile("foo.txt", 3L));

    // Assert
    assertTrue(actualResourceFileVisitorResult instanceof ResourceJavaReferenceCleaner);
    assertSame(presentResourceFileVisitor, actualResourceFileVisitorResult);
  }
}
