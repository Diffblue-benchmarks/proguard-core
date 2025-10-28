package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinFileFacadeKindMetadata;

public class FileFacadeIntegrityDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FileFacadeIntegrity}
   *   <li>
   * {@link FileFacadeIntegrity#visitKotlinFileFacadeMetadata(Clazz, KotlinFileFacadeKindMetadata)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FileFacadeIntegrity actualFileFacadeIntegrity = new FileFacadeIntegrity();
    LibraryClass clazz = new LibraryClass();
    actualFileFacadeIntegrity.visitKotlinFileFacadeMetadata(clazz,
        new KotlinFileFacadeKindMetadata(new int[]{1, 2, 1, 2}, 1, "Xs", "Pn"));

    // Assert that nothing has changed
    assertNull(actualFileFacadeIntegrity.libraryClassPool);
    assertNull(actualFileFacadeIntegrity.programClassPool);
    assertNull(actualFileFacadeIntegrity.reporter);
  }
}
