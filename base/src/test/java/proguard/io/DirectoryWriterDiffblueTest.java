package proguard.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DirectoryWriterDiffblueTest {
  /**
   * Test {@link DirectoryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DirectoryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectoryWriter.createDirectory(DataEntry)"})
  void testCreateDirectory_thenReturnTrue() throws IOException {
    // Arrange
    File baseDirectory = Paths.get(System.getProperty("java.io.tmpdir")).toFile();
    DirectoryWriter directoryWriter = new DirectoryWriter(baseDirectory);

    // Act
    boolean actualCreateDirectoryResult =
        directoryWriter.createDirectory(
            new FileDataEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertTrue(actualCreateDirectoryResult);
  }

  /**
   * Test {@link DirectoryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(Class)} with clazz is {@link Object}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DirectoryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); when ClassPathDataEntry(Class) with clazz is Object; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectoryWriter.sameOutputStream(DataEntry, DataEntry)"})
  void testSameOutputStream_whenClassPathDataEntryWithClazzIsObject_thenReturnTrue()
      throws IOException {
    // Arrange
    DirectoryWriter directoryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    Class<Object> clazz = Object.class;
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(clazz);
    Class<Object> clazz2 = Object.class;

    // Act and Assert
    assertTrue(directoryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry(clazz2)));
  }

  /**
   * Test {@link DirectoryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DirectoryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); when ClassPathDataEntry(String) with 'Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DirectoryWriter.sameOutputStream(DataEntry, DataEntry)"})
  void testSameOutputStream_whenClassPathDataEntryWithName_thenReturnFalse() throws IOException {
    // Arrange
    DirectoryWriter directoryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(directoryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry(clazz)));
  }
}
