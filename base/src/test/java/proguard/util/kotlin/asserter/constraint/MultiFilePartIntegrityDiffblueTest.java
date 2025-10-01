package proguard.util.kotlin.asserter.constraint;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MultiFilePartIntegrityDiffblueTest {
  /**
   * Test new {@link MultiFilePartIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link MultiFilePartIntegrity}
   */
  @Test
  @DisplayName("Test new MultiFilePartIntegrity (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiFilePartIntegrity.<init>()"})
  void testNewMultiFilePartIntegrity() {
    // Arrange and Act
    MultiFilePartIntegrity actualMultiFilePartIntegrity = new MultiFilePartIntegrity();

    // Assert
    assertNull(actualMultiFilePartIntegrity.libraryClassPool);
    assertNull(actualMultiFilePartIntegrity.programClassPool);
    assertNull(actualMultiFilePartIntegrity.reporter);
  }
}
