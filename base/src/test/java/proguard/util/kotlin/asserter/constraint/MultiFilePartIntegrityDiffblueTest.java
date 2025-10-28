package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class MultiFilePartIntegrityDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link MultiFilePartIntegrity}
   */
  @Test
  public void testNewMultiFilePartIntegrity() {
    // Arrange and Act
    MultiFilePartIntegrity actualMultiFilePartIntegrity = new MultiFilePartIntegrity();

    // Assert
    assertNull(actualMultiFilePartIntegrity.libraryClassPool);
    assertNull(actualMultiFilePartIntegrity.programClassPool);
    assertNull(actualMultiFilePartIntegrity.reporter);
  }
}
