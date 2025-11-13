package proguard.util.kotlin.asserter.constraint;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClassIntegrityDiffblueTest {
  /**
   * Test new {@link ClassIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ClassIntegrity}
   */
  @Test
  @DisplayName("Test new ClassIntegrity (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassIntegrity.<init>()"})
  void testNewClassIntegrity() {
    // Arrange and Act
    ClassIntegrity actualClassIntegrity = new ClassIntegrity();

    // Assert
    assertNull(actualClassIntegrity.libraryClassPool);
    assertNull(actualClassIntegrity.programClassPool);
    assertNull(actualClassIntegrity.reporter);
  }
}
