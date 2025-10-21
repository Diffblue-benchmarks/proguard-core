package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinSyntheticClassKindMetadata.Flavor;

public class KotlinSyntheticClassKindMetadataDiffblueTest {
  /**
   * Test {@link KotlinSyntheticClassKindMetadata#KotlinSyntheticClassKindMetadata(int[], int,
   * String, String, Flavor)}.
   *
   * <p>Method under test: {@link
   * KotlinSyntheticClassKindMetadata#KotlinSyntheticClassKindMetadata(int[], int, String, String,
   * Flavor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinSyntheticClassKindMetadata.<init>(int[], int, String, String, Flavor)"
  })
  public void testNewKotlinSyntheticClassKindMetadata() {
    // Arrange and Act
    KotlinSyntheticClassKindMetadata actualKotlinSyntheticClassKindMetadata =
        new KotlinSyntheticClassKindMetadata(new int[] {1, 3, 1, 3}, 1, "Xs", "Pn", Flavor.REGULAR);

    // Assert
    assertNull(actualKotlinSyntheticClassKindMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinSyntheticClassKindMetadata.getProcessingFlags());
  }
}
