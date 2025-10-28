package proguard.classfile.kotlin;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.List;
import org.junit.Test;

public class KotlinMultiFileFacadeKindMetadataDiffblueTest {
  /**
   * Method under test:
   * {@link KotlinMultiFileFacadeKindMetadata#KotlinMultiFileFacadeKindMetadata(int[], String[], int, String, String)}
   */
  @Test
  public void testNewKotlinMultiFileFacadeKindMetadata() {
    // Arrange and Act
    KotlinMultiFileFacadeKindMetadata actualKotlinMultiFileFacadeKindMetadata = new KotlinMultiFileFacadeKindMetadata(
        new int[]{1, 4, 1, 4}, new String[]{"D1"}, 1, "Xs", "Pn");

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
    assertArrayEquals(new int[]{1, 4, 1, 4}, actualKotlinMultiFileFacadeKindMetadata.mv);
  }

  /**
   * Method under test: {@link KotlinMultiFileFacadeKindMetadata#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("Kotlin multi-file facade",
        (new KotlinMultiFileFacadeKindMetadata(new int[]{1, 4, 1, 4}, new String[]{"D1"}, 1, "Xs", "Pn")).toString());
  }
}
