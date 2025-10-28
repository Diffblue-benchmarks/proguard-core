package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class SyntheticClassIntegrityDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link SyntheticClassIntegrity}
   */
  @Test
  public void testNewSyntheticClassIntegrity() {
    // Arrange and Act
    SyntheticClassIntegrity actualSyntheticClassIntegrity = new SyntheticClassIntegrity();

    // Assert
    assertNull(actualSyntheticClassIntegrity.libraryClassPool);
    assertNull(actualSyntheticClassIntegrity.programClassPool);
    assertNull(actualSyntheticClassIntegrity.reporter);
  }
}
