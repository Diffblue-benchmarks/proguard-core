package proguard.util.kotlin.asserter.constraint;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConstructorIntegrityDiffblueTest {
  /**
   * Test new {@link ConstructorIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ConstructorIntegrity}
   */
  @Test
  @DisplayName("Test new ConstructorIntegrity (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstructorIntegrity.<init>()"})
  void testNewConstructorIntegrity() {
    // Arrange and Act
    ConstructorIntegrity actualConstructorIntegrity = new ConstructorIntegrity();

    // Assert
    assertNull(actualConstructorIntegrity.libraryClassPool);
    assertNull(actualConstructorIntegrity.programClassPool);
    assertNull(actualConstructorIntegrity.reporter);
  }
}
