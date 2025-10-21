package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinEffectMetadataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinEffectMetadata#KotlinEffectMetadata(KotlinEffectType,
   *       KotlinEffectInvocationKind)}
   *   <li>{@link KotlinEffectMetadata#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinEffectMetadata.<init>(KotlinEffectType, KotlinEffectInvocationKind)",
    "java.lang.String KotlinEffectMetadata.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    KotlinEffectMetadata actualKotlinEffectMetadata =
        new KotlinEffectMetadata(
            KotlinEffectType.RETURNS_CONSTANT, KotlinEffectInvocationKind.AT_MOST_ONCE);

    // Assert
    assertEquals("Kotlin contract effect", actualKotlinEffectMetadata.toString());
    assertNull(actualKotlinEffectMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinEffectMetadata.getProcessingFlags());
  }
}
