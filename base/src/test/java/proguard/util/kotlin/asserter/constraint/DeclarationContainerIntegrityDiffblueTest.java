package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class DeclarationContainerIntegrityDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link DeclarationContainerIntegrity}
   */
  @Test
  public void testNewDeclarationContainerIntegrity() {
    // Arrange and Act
    DeclarationContainerIntegrity actualDeclarationContainerIntegrity = new DeclarationContainerIntegrity();

    // Assert
    assertNull(actualDeclarationContainerIntegrity.libraryClassPool);
    assertNull(actualDeclarationContainerIntegrity.programClassPool);
    assertNull(actualDeclarationContainerIntegrity.reporter);
  }
}
