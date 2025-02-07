package proguard.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PrefixAddingDataEntryWriterDiffblueTest {
  /**
   * Test {@link PrefixAddingDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryFilter} {@link DataEntryFilter#accepts(DataEntry)} return {@code
   *       true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixAddingDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test createDirectory(DataEntry); given DataEntryFilter accepts(DataEntry) return 'true'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.PrefixAddingDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory_givenDataEntryFilterAcceptsReturnTrue_thenReturnFalse()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    PrefixAddingDataEntryWriter prefixAddingDataEntryWriter =
        new PrefixAddingDataEntryWriter(
            "Prefix", new FilteredDataEntryWriter(dataEntryFilter, null));

    // Act
    boolean actualCreateDirectoryResult =
        prefixAddingDataEntryWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    assertFalse(actualCreateDirectoryResult);
  }

  /**
   * Test {@link PrefixAddingDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixAddingDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.PrefixAddingDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory_thenReturnTrue() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    PrefixAddingDataEntryWriter prefixAddingDataEntryWriter =
        new PrefixAddingDataEntryWriter(
            "Prefix",
            new FixedFileWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(prefixAddingDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link PrefixAddingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixAddingDataEntryWriter#sameOutputStream(DataEntry,
   * DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.PrefixAddingDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_thenReturnTrue() throws IOException {
    // Arrange
    PrefixAddingDataEntryWriter prefixAddingDataEntryWriter =
        new PrefixAddingDataEntryWriter(
            "Prefix",
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        prefixAddingDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link PrefixAddingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with name is {@code .class}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixAddingDataEntryWriter#sameOutputStream(DataEntry,
   * DataEntry)}
   */
  @Test
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); when ClassPathDataEntry(String) with name is '.class'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.PrefixAddingDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse()
      throws IOException {
    // Arrange
    PrefixAddingDataEntryWriter prefixAddingDataEntryWriter =
        new PrefixAddingDataEntryWriter(
            "Prefix",
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(
        prefixAddingDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }
}
