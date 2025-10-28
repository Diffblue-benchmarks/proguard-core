package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class MultiFileFacadeIntegrityDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link MultiFileFacadeIntegrity}
   */
  @Test
  public void testNewMultiFileFacadeIntegrity() {
    // Arrange and Act
    MultiFileFacadeIntegrity actualMultiFileFacadeIntegrity = new MultiFileFacadeIntegrity();

    // Assert
    assertNull(actualMultiFileFacadeIntegrity.libraryClassPool);
    assertNull(actualMultiFileFacadeIntegrity.programClassPool);
    assertNull(actualMultiFileFacadeIntegrity.reporter);
  }
}
