package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinFileFacadeKindMetadataDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinFileFacadeKindMetadata#KotlinFileFacadeKindMetadata(int[], int, String,
   *       String)}
   *   <li>{@link KotlinFileFacadeKindMetadata#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinFileFacadeKindMetadata.<init>(int[], int, String, String)",
    "String KotlinFileFacadeKindMetadata.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    KotlinFileFacadeKindMetadata actualKotlinFileFacadeKindMetadata =
        new KotlinFileFacadeKindMetadata(new int[] {1, 2, 1, 2}, 1, "Xs", "Pn");

    // Assert
    assertEquals("Kotlin file facade(null)", actualKotlinFileFacadeKindMetadata.toString());
    assertNull(actualKotlinFileFacadeKindMetadata.getProcessingInfo());
    assertEquals(0, actualKotlinFileFacadeKindMetadata.getProcessingFlags());
  }
}
