package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class KotlinVersionRequirementMetadataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link KotlinVersionRequirementMetadata}
   *   <li>{@link KotlinVersionRequirementMetadata#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    KotlinVersionRequirementMetadata actualKotlinVersionRequirementMetadata = new KotlinVersionRequirementMetadata();

    // Assert
    assertEquals("Kotlin version req (0.0.0)", actualKotlinVersionRequirementMetadata.toString());
    assertNull(actualKotlinVersionRequirementMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinVersionRequirementMetadata.getProcessingFlags());
  }
}
