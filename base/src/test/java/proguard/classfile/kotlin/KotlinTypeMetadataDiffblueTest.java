package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.kotlin.flags.KotlinTypeFlags;

public class KotlinTypeMetadataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinTypeMetadata#KotlinTypeMetadata(KotlinTypeFlags)}
   *   <li>{@link KotlinTypeMetadata#toString()}
   *   <li>{@link KotlinTypeMetadata#isStarProjection()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    KotlinTypeFlags flags = new KotlinTypeFlags();
    flags.isDefinitelyNonNull = true;
    flags.isNullable = true;
    flags.isSuspend = true;

    // Act
    KotlinTypeMetadata actualKotlinTypeMetadata = new KotlinTypeMetadata(flags);
    String actualToStringResult = actualKotlinTypeMetadata.toString();
    boolean actualIsStarProjectionResult = actualKotlinTypeMetadata.isStarProjection();

    // Assert
    assertEquals("Kotlin type", actualToStringResult);
    assertNull(actualKotlinTypeMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinTypeMetadata.getProcessingFlags());
    assertFalse(actualIsStarProjectionResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link KotlinTypeMetadata#KotlinTypeMetadata(KotlinTypeFlags, KotlinTypeVariance)}
   *   <li>{@link KotlinTypeMetadata#toString()}
   *   <li>{@link KotlinTypeMetadata#isStarProjection()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange
    KotlinTypeFlags flags = new KotlinTypeFlags();
    flags.isDefinitelyNonNull = true;
    flags.isNullable = true;
    flags.isSuspend = true;

    // Act
    KotlinTypeMetadata actualKotlinTypeMetadata = new KotlinTypeMetadata(flags, KotlinTypeVariance.INVARIANT);
    String actualToStringResult = actualKotlinTypeMetadata.toString();
    boolean actualIsStarProjectionResult = actualKotlinTypeMetadata.isStarProjection();

    // Assert
    assertEquals("Kotlin type", actualToStringResult);
    assertNull(actualKotlinTypeMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinTypeMetadata.getProcessingFlags());
    assertFalse(actualIsStarProjectionResult);
  }
}
