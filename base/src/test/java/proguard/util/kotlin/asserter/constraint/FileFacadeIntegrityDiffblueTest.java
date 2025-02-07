package proguard.util.kotlin.asserter.constraint;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.kotlin.KotlinFileFacadeKindMetadata;

class FileFacadeIntegrityDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.kotlin.asserter.constraint.FileFacadeIntegrity.<init>()",
    "void proguard.util.kotlin.asserter.constraint.FileFacadeIntegrity.visitKotlinFileFacadeMetadata(proguard.classfile.Clazz, proguard.classfile.kotlin.KotlinFileFacadeKindMetadata)"
  })
  void testGettersAndSetters() {
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
