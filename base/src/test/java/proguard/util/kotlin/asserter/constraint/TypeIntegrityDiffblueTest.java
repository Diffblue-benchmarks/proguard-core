package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TypeIntegrityDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeIntegrity}
   */
  @Test
  public void testNewTypeIntegrity() {
    // Arrange and Act
    TypeIntegrity actualTypeIntegrity = new TypeIntegrity();

    // Assert
    assertNull(actualTypeIntegrity.libraryClassPool);
    assertNull(actualTypeIntegrity.programClassPool);
    assertNull(actualTypeIntegrity.reporter);
  }
}
