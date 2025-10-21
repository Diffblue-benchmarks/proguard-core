package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinEffectExpressionMetadataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link KotlinEffectExpressionMetadata}
   *   <li>{@link KotlinEffectExpressionMetadata#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinEffectExpressionMetadata.<init>()",
    "java.lang.String KotlinEffectExpressionMetadata.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    KotlinEffectExpressionMetadata actualKotlinEffectExpressionMetadata =
        new KotlinEffectExpressionMetadata();

    // Assert
    assertEquals("Kotlin contract effect", actualKotlinEffectExpressionMetadata.toString());
    assertNull(actualKotlinEffectExpressionMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinEffectExpressionMetadata.getProcessingFlags());
  }
}
