package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class KotlinEffectMetadataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link KotlinEffectMetadata#KotlinEffectMetadata(KotlinEffectType, KotlinEffectInvocationKind)}
   *   <li>{@link KotlinEffectMetadata#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    KotlinEffectMetadata actualKotlinEffectMetadata = new KotlinEffectMetadata(KotlinEffectType.RETURNS_CONSTANT,
        KotlinEffectInvocationKind.AT_MOST_ONCE);

    // Assert
    assertEquals("Kotlin contract effect", actualKotlinEffectMetadata.toString());
    assertNull(actualKotlinEffectMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinEffectMetadata.getProcessingFlags());
  }
}
