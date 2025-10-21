package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.flags.KotlinTypeFlags;

public class KotlinTypeMetadataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code INVARIANT}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinTypeMetadata#KotlinTypeMetadata(KotlinTypeFlags, KotlinTypeVariance)}
   *   <li>{@link KotlinTypeMetadata#toString()}
   *   <li>{@link KotlinTypeMetadata#isStarProjection()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinTypeMetadata.<init>(KotlinTypeFlags)",
    "void KotlinTypeMetadata.<init>(KotlinTypeFlags, KotlinTypeVariance)",
    "boolean KotlinTypeMetadata.isStarProjection()",
    "String KotlinTypeMetadata.toString()"
  })
  public void testGettersAndSetters_whenInvariant() {
    // Arrange
    KotlinTypeFlags flags = new KotlinTypeFlags();
    flags.isDefinitelyNonNull = true;
    flags.isNullable = true;
    flags.isSuspend = true;

    // Act
    KotlinTypeMetadata actualKotlinTypeMetadata =
        new KotlinTypeMetadata(flags, KotlinTypeVariance.INVARIANT);
    String actualToStringResult = actualKotlinTypeMetadata.toString();
    boolean actualIsStarProjectionResult = actualKotlinTypeMetadata.isStarProjection();

    // Assert
    assertEquals("Kotlin type", actualToStringResult);
    assertNull(actualKotlinTypeMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinTypeMetadata.getProcessingFlags());
    assertFalse(actualIsStarProjectionResult);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link KotlinTypeFlags} (default constructor) {@link
   *       KotlinTypeFlags#isDefinitelyNonNull} is {@code true}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinTypeMetadata#KotlinTypeMetadata(KotlinTypeFlags)}
   *   <li>{@link KotlinTypeMetadata#toString()}
   *   <li>{@link KotlinTypeMetadata#isStarProjection()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinTypeMetadata.<init>(KotlinTypeFlags)",
    "void KotlinTypeMetadata.<init>(KotlinTypeFlags, KotlinTypeVariance)",
    "boolean KotlinTypeMetadata.isStarProjection()",
    "String KotlinTypeMetadata.toString()"
  })
  public void testGettersAndSetters_whenKotlinTypeFlagsIsDefinitelyNonNullIsTrue() {
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
}
