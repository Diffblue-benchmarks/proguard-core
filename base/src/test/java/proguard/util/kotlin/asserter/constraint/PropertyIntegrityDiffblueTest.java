package proguard.util.kotlin.asserter.constraint;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PropertyIntegrityDiffblueTest {
  /**
   * Test new {@link PropertyIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PropertyIntegrity}
   */
  @Test
  @DisplayName("Test new PropertyIntegrity (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PropertyIntegrity.<init>()"})
  void testNewPropertyIntegrity() {
    // Arrange and Act
    PropertyIntegrity actualPropertyIntegrity = new PropertyIntegrity();

    // Assert
    assertNull(actualPropertyIntegrity.libraryClassPool);
    assertNull(actualPropertyIntegrity.programClassPool);
    assertNull(actualPropertyIntegrity.reporter);
  }
}
