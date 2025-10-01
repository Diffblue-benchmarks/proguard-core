package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.zip.ZipEntry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ZipFileDataEntryDiffblueTest {
  /**
   * Test {@link ZipFileDataEntry#getName()}.
   *
   * <ul>
   *   <li>Given {@link ZipEntry#ZipEntry(String)} with empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ZipFileDataEntry#getName()}
   */
  @Test
  @DisplayName("Test getName(); given ZipEntry(String) with empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ZipFileDataEntry.getName()"})
  void testGetName_givenZipEntryWithEmptyString_thenReturnEmptyString() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipFileDataEntry zipFileDataEntry = new ZipFileDataEntry(parent, new ZipEntry(""), null);

    // Act and Assert
    assertEquals("", zipFileDataEntry.getName());
  }

  /**
   * Test {@link ZipFileDataEntry#getName()}.
   *
   * <ul>
   *   <li>Given {@link ZipEntry#ZipEntry(String)} with {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ZipFileDataEntry#getName()}
   */
  @Test
  @DisplayName("Test getName(); given ZipEntry(String) with 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ZipFileDataEntry.getName()"})
  void testGetName_givenZipEntryWithFoo_thenReturnFoo() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipFileDataEntry zipFileDataEntry = new ZipFileDataEntry(parent, new ZipEntry("foo"), null);

    // Act and Assert
    assertEquals("foo", zipFileDataEntry.getName());
  }

  /**
   * Test {@link ZipFileDataEntry#getOriginalName()}.
   *
   * <ul>
   *   <li>Given {@link ZipEntry#ZipEntry(String)} with empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ZipFileDataEntry#getOriginalName()}
   */
  @Test
  @DisplayName(
      "Test getOriginalName(); given ZipEntry(String) with empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ZipFileDataEntry.getOriginalName()"})
  void testGetOriginalName_givenZipEntryWithEmptyString_thenReturnEmptyString() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipFileDataEntry zipFileDataEntry = new ZipFileDataEntry(parent, new ZipEntry(""), null);

    // Act and Assert
    assertEquals("", zipFileDataEntry.getOriginalName());
  }

  /**
   * Test {@link ZipFileDataEntry#getOriginalName()}.
   *
   * <ul>
   *   <li>Given {@link ZipEntry#ZipEntry(String)} with {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ZipFileDataEntry#getOriginalName()}
   */
  @Test
  @DisplayName("Test getOriginalName(); given ZipEntry(String) with 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ZipFileDataEntry.getOriginalName()"})
  void testGetOriginalName_givenZipEntryWithFoo_thenReturnFoo() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipFileDataEntry zipFileDataEntry = new ZipFileDataEntry(parent, new ZipEntry("foo"), null);

    // Act and Assert
    assertEquals("foo", zipFileDataEntry.getOriginalName());
  }

  /**
   * Test {@link ZipFileDataEntry#getSize()}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ZipFileDataEntry#getSize()}
   */
  @Test
  @DisplayName("Test getSize(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ZipFileDataEntry.getSize()"})
  void testGetSize_thenReturnMinusOne() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipFileDataEntry zipFileDataEntry = new ZipFileDataEntry(parent, new ZipEntry("foo"), null);

    // Act and Assert
    assertEquals(-1L, zipFileDataEntry.getSize());
  }

  /**
   * Test {@link ZipFileDataEntry#isDirectory()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ZipFileDataEntry#isDirectory()}
   */
  @Test
  @DisplayName("Test isDirectory(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ZipFileDataEntry.isDirectory()"})
  void testIsDirectory_thenReturnFalse() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    ZipFileDataEntry zipFileDataEntry = new ZipFileDataEntry(parent, new ZipEntry("foo"), null);

    // Act and Assert
    assertFalse(zipFileDataEntry.isDirectory());
  }
}
