package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class KotlinEffectExpressionMetadataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link KotlinEffectExpressionMetadata}
   *   <li>{@link KotlinEffectExpressionMetadata#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    KotlinEffectExpressionMetadata actualKotlinEffectExpressionMetadata = new KotlinEffectExpressionMetadata();

    // Assert
    assertEquals("Kotlin contract effect", actualKotlinEffectExpressionMetadata.toString());
    assertNull(actualKotlinEffectExpressionMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinEffectExpressionMetadata.getProcessingFlags());
  }
}
