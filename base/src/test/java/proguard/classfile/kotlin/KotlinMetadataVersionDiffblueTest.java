package proguard.classfile.kotlin;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.io.kotlin.KotlinMetadataWriter;

public class KotlinMetadataVersionDiffblueTest {
  /**
   * Method under test: {@link KotlinMetadataVersion#canBeWritten()}
   */
  @Test
  public void testCanBeWritten() {
    // Arrange, Act and Assert
    assertFalse(KotlinMetadataVersion.UNKNOWN_VERSION.canBeWritten());
    assertTrue(KotlinMetadataWriter.HIGHEST_ALLOWED_TO_WRITE.canBeWritten());
    assertFalse((new KotlinMetadataVersion(1, 1, 1)).canBeWritten());
    assertTrue((new KotlinMetadataVersion(1, 4, 1)).canBeWritten());
  }

  /**
   * Method under test: {@link KotlinMetadataVersion#toArray()}
   */
  @Test
  public void testToArray() {
    // Arrange, Act and Assert
    assertArrayEquals(new int[]{-1, -1, 0}, KotlinMetadataVersion.UNKNOWN_VERSION.toArray());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinMetadataVersion#KotlinMetadataVersion(int, int, int)}
   *   <li>{@link KotlinMetadataVersion#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("1.1.1", (new KotlinMetadataVersion(1, 1, 1)).toString());
  }

  /**
   * Method under test: {@link KotlinMetadataVersion#KotlinMetadataVersion(int[])}
   */
  @Test
  public void testNewKotlinMetadataVersion() {
    // Arrange and Act
    KotlinMetadataVersion actualKotlinMetadataVersion = new KotlinMetadataVersion(new int[]{1, -1, 1, -1});

    // Assert
    assertEquals(-1, actualKotlinMetadataVersion.minor);
    assertEquals(1, actualKotlinMetadataVersion.major);
    assertEquals(1, actualKotlinMetadataVersion.patch);
    assertArrayEquals(new int[]{1, -1, 1}, actualKotlinMetadataVersion.toArray());
  }
}
