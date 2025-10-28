package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class UnsupportedKotlinMetadataDiffblueTest {
  /**
   * Method under test:
   * {@link UnsupportedKotlinMetadata#UnsupportedKotlinMetadata(int, int[], int, String, String)}
   */
  @Test
  public void testNewUnsupportedKotlinMetadata() {
    // Arrange and Act
    UnsupportedKotlinMetadata actualUnsupportedKotlinMetadata = new UnsupportedKotlinMetadata(1,
        new int[]{1, -1, 1, -1}, 1, "Xs", "Pn");

    // Assert
    assertNull(actualUnsupportedKotlinMetadata.getProcessingInfo());
    assertEquals(0, actualUnsupportedKotlinMetadata.getProcessingFlags());
  }
}
