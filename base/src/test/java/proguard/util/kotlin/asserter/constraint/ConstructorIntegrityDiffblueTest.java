package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ConstructorIntegrityDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link ConstructorIntegrity}
   */
  @Test
  public void testNewConstructorIntegrity() {
    // Arrange and Act
    ConstructorIntegrity actualConstructorIntegrity = new ConstructorIntegrity();

    // Assert
    assertNull(actualConstructorIntegrity.libraryClassPool);
    assertNull(actualConstructorIntegrity.programClassPool);
    assertNull(actualConstructorIntegrity.reporter);
  }
}
