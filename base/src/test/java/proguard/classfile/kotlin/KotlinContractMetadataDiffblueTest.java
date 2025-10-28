package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class KotlinContractMetadataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link KotlinContractMetadata}
   *   <li>{@link KotlinContractMetadata#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    KotlinContractMetadata actualKotlinContractMetadata = new KotlinContractMetadata();

    // Assert
    assertEquals("Kotlin contract", actualKotlinContractMetadata.toString());
    assertNull(actualKotlinContractMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinContractMetadata.getProcessingFlags());
  }
}
