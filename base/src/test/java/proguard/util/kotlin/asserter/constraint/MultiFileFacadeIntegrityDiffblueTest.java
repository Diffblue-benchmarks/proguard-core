package proguard.util.kotlin.asserter.constraint;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MultiFileFacadeIntegrityDiffblueTest {
  /**
   * Test new {@link MultiFileFacadeIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link MultiFileFacadeIntegrity}
   */
  @Test
  @DisplayName("Test new MultiFileFacadeIntegrity (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiFileFacadeIntegrity.<init>()"})
  void testNewMultiFileFacadeIntegrity() {
    // Arrange and Act
    MultiFileFacadeIntegrity actualMultiFileFacadeIntegrity = new MultiFileFacadeIntegrity();

    // Assert
    assertNull(actualMultiFileFacadeIntegrity.libraryClassPool);
    assertNull(actualMultiFileFacadeIntegrity.programClassPool);
    assertNull(actualMultiFileFacadeIntegrity.reporter);
  }
}
