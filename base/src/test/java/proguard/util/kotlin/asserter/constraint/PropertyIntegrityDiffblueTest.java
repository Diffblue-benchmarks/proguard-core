package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class PropertyIntegrityDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link PropertyIntegrity}
   */
  @Test
  public void testNewPropertyIntegrity() {
    // Arrange and Act
    PropertyIntegrity actualPropertyIntegrity = new PropertyIntegrity();

    // Assert
    assertNull(actualPropertyIntegrity.libraryClassPool);
    assertNull(actualPropertyIntegrity.programClassPool);
    assertNull(actualPropertyIntegrity.reporter);
  }
}
