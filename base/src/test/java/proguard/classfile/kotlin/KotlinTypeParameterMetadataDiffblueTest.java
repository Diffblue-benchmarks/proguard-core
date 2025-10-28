package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.kotlin.flags.KotlinTypeParameterFlags;

public class KotlinTypeParameterMetadataDiffblueTest {
  /**
   * Method under test:
   * {@link KotlinTypeParameterMetadata#KotlinTypeParameterMetadata(KotlinTypeParameterFlags, String, int, KotlinTypeVariance)}
   */
  @Test
  public void testNewKotlinTypeParameterMetadata() {
    // Arrange
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;

    // Act
    KotlinTypeParameterMetadata actualKotlinTypeParameterMetadata = new KotlinTypeParameterMetadata(flags, "Name", 1,
        KotlinTypeVariance.INVARIANT);

    // Assert
    assertNull(actualKotlinTypeParameterMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinTypeParameterMetadata.getProcessingFlags());
  }

  /**
   * Method under test: {@link KotlinTypeParameterMetadata#toString()}
   */
  @Test
  public void testToString() {
    // Arrange
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;

    // Act and Assert
    assertEquals("Kotlin primary constructor",
        (new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT)).toString());
  }

  /**
   * Method under test: {@link KotlinTypeParameterMetadata#toString()}
   */
  @Test
  public void testToString2() {
    // Arrange
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;
    KotlinTypeParameterFlags kotlinTypeParameterFlags = new KotlinTypeParameterFlags();
    kotlinTypeParameterFlags.isReified = true;
    kotlinTypeParameterFlags.isReified = false;
    KotlinTypeParameterMetadata kotlinTypeParameterMetadata = new KotlinTypeParameterMetadata(flags, "Name", 1,
        KotlinTypeVariance.INVARIANT);
    kotlinTypeParameterMetadata.flags = kotlinTypeParameterFlags;

    // Act and Assert
    assertEquals("Kotlin constructor", kotlinTypeParameterMetadata.toString());
  }
}
