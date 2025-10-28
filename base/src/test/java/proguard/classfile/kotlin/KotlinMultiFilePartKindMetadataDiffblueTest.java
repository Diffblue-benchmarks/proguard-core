package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class KotlinMultiFilePartKindMetadataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link KotlinMultiFilePartKindMetadata#KotlinMultiFilePartKindMetadata(int[], int, String, String)}
   *   <li>{@link KotlinMultiFilePartKindMetadata#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    KotlinMultiFilePartKindMetadata actualKotlinMultiFilePartKindMetadata = new KotlinMultiFilePartKindMetadata(
        new int[]{1, 5, 1, 5}, 1, "Xs", "Pn");

    // Assert
    assertEquals("Kotlin file part", actualKotlinMultiFilePartKindMetadata.toString());
    assertNull(actualKotlinMultiFilePartKindMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinMultiFilePartKindMetadata.getProcessingFlags());
  }
}
