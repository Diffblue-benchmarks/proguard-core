package proguard.classfile.kotlin;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.io.kotlin.KotlinMetadataWriter;

class KotlinMetadataVersionDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.KotlinMetadataVersion.<init>(int, int, int)",
    "java.lang.String proguard.classfile.kotlin.KotlinMetadataVersion.toString()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("1.1.1", (new KotlinMetadataVersion(1, 1, 1)).toString());
  }

  /**
   * Test {@link KotlinMetadataVersion#KotlinMetadataVersion(int[])}.
   *
   * <p>Method under test: {@link KotlinMetadataVersion#KotlinMetadataVersion(int[])}
   */
  @Test
  @DisplayName("Test new KotlinMetadataVersion(int[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.classfile.kotlin.KotlinMetadataVersion.<init>(int[])"})
  void testNewKotlinMetadataVersion() {
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
  @DisplayName("Test canBeWritten()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.kotlin.KotlinMetadataVersion.canBeWritten()"})
  void testCanBeWritten() {
    // Arrange, Act and Assert
    assertFalse((new KotlinMetadataVersion(1, 1, 1)).canBeWritten());
  }

  /**
   * Test {@link KotlinMetadataVersion#canBeWritten()}.
   *
   * <p>Method under test: {@link KotlinMetadataVersion#canBeWritten()}
   */
  @Test
  @DisplayName("Test canBeWritten()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.kotlin.KotlinMetadataVersion.canBeWritten()"})
  void testCanBeWritten2() {
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
  @DisplayName("Test canBeWritten(); given HIGHEST_ALLOWED_TO_WRITE; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.kotlin.KotlinMetadataVersion.canBeWritten()"})
  void testCanBeWritten_givenHighest_allowed_to_write_thenReturnTrue() {
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
  @DisplayName("Test canBeWritten(); given UNKNOWN_VERSION; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.classfile.kotlin.KotlinMetadataVersion.canBeWritten()"})
  void testCanBeWritten_givenUnknown_version_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(KotlinMetadataVersion.UNKNOWN_VERSION.canBeWritten());
  }

  /**
   * Test {@link KotlinMetadataVersion#toArray()}.
   *
   * <p>Method under test: {@link KotlinMetadataVersion#toArray()}
   */
  @Test
  @DisplayName("Test toArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int[] proguard.classfile.kotlin.KotlinMetadataVersion.toArray()"})
  void testToArray() {
    // Arrange, Act and Assert
    assertArrayEquals(new int[] {-1, -1, 0}, KotlinMetadataVersion.UNKNOWN_VERSION.toArray());
  }
}
