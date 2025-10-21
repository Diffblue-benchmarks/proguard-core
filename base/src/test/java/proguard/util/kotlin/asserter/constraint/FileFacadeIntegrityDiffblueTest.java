package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinFileFacadeKindMetadata;

public class FileFacadeIntegrityDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FileFacadeIntegrity}
   *   <li>{@link FileFacadeIntegrity#visitKotlinFileFacadeMetadata(Clazz,
   *       KotlinFileFacadeKindMetadata)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void FileFacadeIntegrity.<init>()",
    "void FileFacadeIntegrity.visitKotlinFileFacadeMetadata(Clazz, KotlinFileFacadeKindMetadata)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    FileFacadeIntegrity actualFileFacadeIntegrity = new FileFacadeIntegrity();
    LibraryClass clazz = new LibraryClass();
    actualFileFacadeIntegrity.visitKotlinFileFacadeMetadata(
        clazz, new KotlinFileFacadeKindMetadata(new int[] {1, 2, 1, 2}, 1, "Xs", "Pn"));

    // Assert
    assertNull(actualFileFacadeIntegrity.libraryClassPool);
    assertNull(actualFileFacadeIntegrity.programClassPool);
    assertNull(actualFileFacadeIntegrity.reporter);
  }
}
