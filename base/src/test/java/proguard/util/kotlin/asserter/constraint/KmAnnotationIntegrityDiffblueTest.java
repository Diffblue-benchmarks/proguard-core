package proguard.util.kotlin.asserter.constraint;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class KmAnnotationIntegrityDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link KmAnnotationIntegrity}
   */
  @Test
  public void testNewKmAnnotationIntegrity() {
    // Arrange and Act
    KmAnnotationIntegrity actualKmAnnotationIntegrity = new KmAnnotationIntegrity();

    // Assert
    assertNull(actualKmAnnotationIntegrity.libraryClassPool);
    assertNull(actualKmAnnotationIntegrity.programClassPool);
    assertNull(actualKmAnnotationIntegrity.reporter);
  }
}
