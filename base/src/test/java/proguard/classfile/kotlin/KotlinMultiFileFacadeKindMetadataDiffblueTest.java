package proguard.classfile.kotlin;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinMultiFileFacadeKindMetadataDiffblueTest {
  /**
   * Test {@link KotlinMultiFileFacadeKindMetadata#KotlinMultiFileFacadeKindMetadata(int[],
   * String[], int, String, String)}.
   *
   * <p>Method under test: {@link
   * KotlinMultiFileFacadeKindMetadata#KotlinMultiFileFacadeKindMetadata(int[], String[], int,
   * String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinMultiFileFacadeKindMetadata.<init>(int[], String[], int, String, String)"
  })
  public void testNewKotlinMultiFileFacadeKindMetadata() {
    // Arrange and Act
    KotlinMultiFileFacadeKindMetadata actualKotlinMultiFileFacadeKindMetadata =
        new KotlinMultiFileFacadeKindMetadata(
            new int[] {1, 4, 1, 4}, new String[] {"D1"}, 1, "Xs", "Pn");

    // Assert
    List<String> stringList = actualKotlinMultiFileFacadeKindMetadata.partClassNames;
    assertEquals(1, stringList.size());
    assertEquals("D1", stringList.get(0));
    assertEquals("Pn", actualKotlinMultiFileFacadeKindMetadata.pn);
    assertEquals("Xs", actualKotlinMultiFileFacadeKindMetadata.xs);
    assertNull(actualKotlinMultiFileFacadeKindMetadata.getProcessingInfo());
    assertNull(actualKotlinMultiFileFacadeKindMetadata.referencedPartClasses);
    assertEquals(0, actualKotlinMultiFileFacadeKindMetadata.getProcessingFlags());
    assertEquals(1, actualKotlinMultiFileFacadeKindMetadata.xi);
    assertEquals(4, actualKotlinMultiFileFacadeKindMetadata.k);
    assertArrayEquals(new int[] {1, 4, 1, 4}, actualKotlinMultiFileFacadeKindMetadata.mv);
  }

  /**
   * Test {@link KotlinMultiFileFacadeKindMetadata#toString()}.
   *
   * <p>Method under test: {@link KotlinMultiFileFacadeKindMetadata#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String KotlinMultiFileFacadeKindMetadata.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "Kotlin multi-file facade",
        (new KotlinMultiFileFacadeKindMetadata(
                new int[] {1, 4, 1, 4}, new String[] {"D1"}, 1, "Xs", "Pn"))
            .toString());
  }
}
