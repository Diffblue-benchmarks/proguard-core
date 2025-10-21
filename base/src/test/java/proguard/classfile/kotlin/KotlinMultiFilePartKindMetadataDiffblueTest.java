package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinMultiFilePartKindMetadataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinMultiFilePartKindMetadata#KotlinMultiFilePartKindMetadata(int[], int,
   *       String, String)}
   *   <li>{@link KotlinMultiFilePartKindMetadata#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinMultiFilePartKindMetadata.<init>(int[], int, String, String)",
    "String KotlinMultiFilePartKindMetadata.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    KotlinMultiFilePartKindMetadata actualKotlinMultiFilePartKindMetadata =
        new KotlinMultiFilePartKindMetadata(new int[] {1, 5, 1, 5}, 1, "Xs", "Pn");

    // Assert
    assertEquals("Kotlin file part", actualKotlinMultiFilePartKindMetadata.toString());
    assertNull(actualKotlinMultiFilePartKindMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinMultiFilePartKindMetadata.getProcessingFlags());
  }
}
