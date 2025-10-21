package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DeclarationContainerIntegrityDiffblueTest {
  /**
   * Test new {@link DeclarationContainerIntegrity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * DeclarationContainerIntegrity}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeclarationContainerIntegrity.<init>()"})
  public void testNewDeclarationContainerIntegrity() {
    // Arrange and Act
    DeclarationContainerIntegrity actualDeclarationContainerIntegrity =
        new DeclarationContainerIntegrity();

    // Assert
    assertNull(actualDeclarationContainerIntegrity.libraryClassPool);
    assertNull(actualDeclarationContainerIntegrity.programClassPool);
    assertNull(actualDeclarationContainerIntegrity.reporter);
  }
}
