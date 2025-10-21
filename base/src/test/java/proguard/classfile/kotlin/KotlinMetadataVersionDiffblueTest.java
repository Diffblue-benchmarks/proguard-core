package proguard.classfile.kotlin;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.io.kotlin.KotlinMetadataWriter;

public class KotlinMetadataVersionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinMetadataVersion#KotlinMetadataVersion(int, int, int)}
   *   <li>{@link KotlinMetadataVersion#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinMetadataVersion.<init>(int, int, int)",
    "java.lang.String KotlinMetadataVersion.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("1.1.1", (new KotlinMetadataVersion(1, 1, 1)).toString());
  }

  /**
   * Test {@link KotlinMetadataVersion#KotlinMetadataVersion(int[])}.
   *
   * <p>Method under test: {@link KotlinMetadataVersion#KotlinMetadataVersion(int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinMetadataVersion.<init>(int[])"})
  public void testNewKotlinMetadataVersion() {
    // Arrange and Act
    KotlinMetadataVersion actualKotlinMetadataVersion =
        new KotlinMetadataVersion(new int[] {1, -1, 1, -1});

    // Assert
    assertEquals(-1, actualKotlinMetadataVersion.minor);
    assertEquals(1, actualKotlinMetadataVersion.major);
    assertEquals(1, actualKotlinMetadataVersion.patch);
    assertArrayEquals(new int[] {1, -1, 1}, actualKotlinMetadataVersion.toArray());
  }

  /**
   * Test {@link KotlinMetadataVersion#canBeWritten()}.
   *
   * <p>Method under test: {@link KotlinMetadataVersion#canBeWritten()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinMetadataVersion.canBeWritten()"})
  public void testCanBeWritten() {
    // Arrange, Act and Assert
    assertFalse((new KotlinMetadataVersion(1, 1, 1)).canBeWritten());
  }

  /**
   * Test {@link KotlinMetadataVersion#canBeWritten()}.
   *
   * <p>Method under test: {@link KotlinMetadataVersion#canBeWritten()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinMetadataVersion.canBeWritten()"})
  public void testCanBeWritten2() {
    // Arrange, Act and Assert
    assertTrue((new KotlinMetadataVersion(1, 4, 1)).canBeWritten());
  }

  /**
   * Test {@link KotlinMetadataVersion#canBeWritten()}.
   *
   * <ul>
   *   <li>Given {@link KotlinMetadataWriter#HIGHEST_ALLOWED_TO_WRITE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataVersion#canBeWritten()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinMetadataVersion.canBeWritten()"})
  public void testCanBeWritten_givenHighest_allowed_to_write_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(KotlinMetadataWriter.HIGHEST_ALLOWED_TO_WRITE.canBeWritten());
  }

  /**
   * Test {@link KotlinMetadataVersion#canBeWritten()}.
   *
   * <ul>
   *   <li>Given {@link KotlinMetadataVersion#UNKNOWN_VERSION}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinMetadataVersion#canBeWritten()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinMetadataVersion.canBeWritten()"})
  public void testCanBeWritten_givenUnknown_version_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(KotlinMetadataVersion.UNKNOWN_VERSION.canBeWritten());
  }

  /**
   * Test {@link KotlinMetadataVersion#toArray()}.
   *
   * <p>Method under test: {@link KotlinMetadataVersion#toArray()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int[] KotlinMetadataVersion.toArray()"})
  public void testToArray() {
    // Arrange, Act and Assert
    assertArrayEquals(new int[] {-1, -1, 0}, KotlinMetadataVersion.UNKNOWN_VERSION.toArray());
  }
}
