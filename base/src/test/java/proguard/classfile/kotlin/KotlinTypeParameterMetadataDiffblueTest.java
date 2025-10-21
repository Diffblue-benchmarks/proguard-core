package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.flags.KotlinTypeParameterFlags;

public class KotlinTypeParameterMetadataDiffblueTest {
  /**
   * Test {@link KotlinTypeParameterMetadata#KotlinTypeParameterMetadata(KotlinTypeParameterFlags,
   * String, int, KotlinTypeVariance)}.
   *
   * <p>Method under test: {@link
   * KotlinTypeParameterMetadata#KotlinTypeParameterMetadata(KotlinTypeParameterFlags, String, int,
   * KotlinTypeVariance)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinTypeParameterMetadata.<init>(KotlinTypeParameterFlags, String, int, KotlinTypeVariance)"
  })
  public void testNewKotlinTypeParameterMetadata() {
    // Arrange
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;

    // Act
    KotlinTypeParameterMetadata actualKotlinTypeParameterMetadata =
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT);

    // Assert
    assertNull(actualKotlinTypeParameterMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinTypeParameterMetadata.getProcessingFlags());
  }

  /**
   * Test {@link KotlinTypeParameterMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin constructor}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeParameterMetadata#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinTypeParameterMetadata.toString()"})
  public void testToString_thenReturnKotlinConstructor() {
    // Arrange
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;
    KotlinTypeParameterFlags kotlinTypeParameterFlags = new KotlinTypeParameterFlags();
    kotlinTypeParameterFlags.isReified = true;
    kotlinTypeParameterFlags.isReified = false;
    KotlinTypeParameterMetadata kotlinTypeParameterMetadata =
        new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT);
    kotlinTypeParameterMetadata.flags = kotlinTypeParameterFlags;

    // Act and Assert
    assertEquals("Kotlin constructor", kotlinTypeParameterMetadata.toString());
  }

  /**
   * Test {@link KotlinTypeParameterMetadata#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Kotlin primary constructor}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinTypeParameterMetadata#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinTypeParameterMetadata.toString()"})
  public void testToString_thenReturnKotlinPrimaryConstructor() {
    // Arrange
    KotlinTypeParameterFlags flags = new KotlinTypeParameterFlags();
    flags.isReified = true;

    // Act and Assert
    assertEquals(
        "Kotlin primary constructor",
        (new KotlinTypeParameterMetadata(flags, "Name", 1, KotlinTypeVariance.INVARIANT))
            .toString());
  }
}
