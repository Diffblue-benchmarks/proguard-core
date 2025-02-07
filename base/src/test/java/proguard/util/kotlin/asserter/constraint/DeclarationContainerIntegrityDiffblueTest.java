package proguard.util.kotlin.asserter.constraint;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DeclarationContainerIntegrityDiffblueTest {
  /**
   * Test new {@link DeclarationContainerIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * DeclarationContainerIntegrity}
   */
  @Test
  @DisplayName("Test new DeclarationContainerIntegrity (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.util.kotlin.asserter.constraint.DeclarationContainerIntegrity.<init>()"
  })
  void testNewDeclarationContainerIntegrity() {
    // Arrange and Act
    DeclarationContainerIntegrity actualDeclarationContainerIntegrity =
        new DeclarationContainerIntegrity();

    // Assert
    assertNull(actualDeclarationContainerIntegrity.libraryClassPool);
    assertNull(actualDeclarationContainerIntegrity.programClassPool);
    assertNull(actualDeclarationContainerIntegrity.reporter);
  }
}
