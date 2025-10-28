package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class KotlinFileFacadeKindMetadataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link KotlinFileFacadeKindMetadata#KotlinFileFacadeKindMetadata(int[], int, String, String)}
   *   <li>{@link KotlinFileFacadeKindMetadata#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    KotlinFileFacadeKindMetadata actualKotlinFileFacadeKindMetadata = new KotlinFileFacadeKindMetadata(
        new int[]{1, 2, 1, 2}, 1, "Xs", "Pn");

    // Assert
    assertEquals("Kotlin file facade(null)", actualKotlinFileFacadeKindMetadata.toString());
    assertNull(actualKotlinFileFacadeKindMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinFileFacadeKindMetadata.getProcessingFlags());
  }
}
