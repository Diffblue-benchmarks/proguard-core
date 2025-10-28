package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class KotlinSyntheticClassKindMetadataDiffblueTest {
  /**
   * Method under test:
   * {@link KotlinSyntheticClassKindMetadata#KotlinSyntheticClassKindMetadata(int[], int, String, String, KotlinSyntheticClassKindMetadata.Flavor)}
   */
  @Test
  public void testNewKotlinSyntheticClassKindMetadata() {
    // Arrange and Act
    KotlinSyntheticClassKindMetadata actualKotlinSyntheticClassKindMetadata = new KotlinSyntheticClassKindMetadata(
        new int[]{1, 3, 1, 3}, 1, "Xs", "Pn", KotlinSyntheticClassKindMetadata.Flavor.REGULAR);

    // Assert
    assertNull(actualKotlinSyntheticClassKindMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinSyntheticClassKindMetadata.getProcessingFlags());
  }
}
