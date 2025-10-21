package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PrefixAddingDataEntryWriterDiffblueTest {
  /**
   * Test {@link PrefixAddingDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PrefixAddingDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PrefixAddingDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory_thenReturnFalse() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    PrefixAddingDataEntryWriter prefixAddingDataEntryWriter =
        new PrefixAddingDataEntryWriter(
            "Prefix",
            new FilteredDataEntryWriter(
                dataEntryFilter,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(prefixAddingDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PrefixAddingDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory_thenReturnTrue() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PrefixAddingDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_thenReturnTrue() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PrefixAddingDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse()
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
