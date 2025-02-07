package proguard.util.kotlin.asserter.constraint;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SyntheticClassIntegrityDiffblueTest {
  /**
   * Test new {@link SyntheticClassIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link SyntheticClassIntegrity}
   */
  @Test
  @DisplayName("Test new SyntheticClassIntegrity (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.kotlin.asserter.constraint.SyntheticClassIntegrity.<init>()"
  })
  void testNewSyntheticClassIntegrity() {
    // Arrange and Act
    SyntheticClassIntegrity actualSyntheticClassIntegrity = new SyntheticClassIntegrity();

    // Assert
    assertNull(actualSyntheticClassIntegrity.libraryClassPool);
    assertNull(actualSyntheticClassIntegrity.programClassPool);
    assertNull(actualSyntheticClassIntegrity.reporter);
  }
}
