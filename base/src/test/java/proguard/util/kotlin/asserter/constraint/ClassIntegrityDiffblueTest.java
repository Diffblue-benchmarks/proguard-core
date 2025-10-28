package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ClassIntegrityDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ClassIntegrity}
   */
  @Test
  public void testNewClassIntegrity() {
    // Arrange and Act
    ClassIntegrity actualClassIntegrity = new ClassIntegrity();

    // Assert
    assertNull(actualClassIntegrity.libraryClassPool);
    assertNull(actualClassIntegrity.programClassPool);
    assertNull(actualClassIntegrity.reporter);
  }
}
