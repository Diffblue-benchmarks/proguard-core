package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UnsupportedKotlinMetadataDiffblueTest {
  /**
   * Test {@link UnsupportedKotlinMetadata#UnsupportedKotlinMetadata(int, int[], int, String,
   * String)}.
   *
   * <p>Method under test: {@link UnsupportedKotlinMetadata#UnsupportedKotlinMetadata(int, int[],
   * int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UnsupportedKotlinMetadata.<init>(int, int[], int, String, String)"})
  public void testNewUnsupportedKotlinMetadata() {
    // Arrange and Act
    UnsupportedKotlinMetadata actualUnsupportedKotlinMetadata =
        new UnsupportedKotlinMetadata(1, new int[] {1, -1, 1, -1}, 1, "Xs", "Pn");

    // Assert
    assertNull(actualUnsupportedKotlinMetadata.getProcessingInfo());
    assertEquals(0, actualUnsupportedKotlinMetadata.getProcessingFlags());
  }
}
