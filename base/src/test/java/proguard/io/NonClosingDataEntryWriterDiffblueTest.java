package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;

public class NonClosingDataEntryWriterDiffblueTest {
  /**
   * Method under test:
   * {@link NonClosingDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    NonClosingDataEntryWriter nonClosingDataEntryWriter = new NonClosingDataEntryWriter(
        new FixedFileWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(nonClosingDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link NonClosingDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    NonClosingDataEntryWriter nonClosingDataEntryWriter = new NonClosingDataEntryWriter(new FilteredDataEntryWriter(
        dataEntryFilter, new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(nonClosingDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link NonClosingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream() throws IOException {
    // Arrange
    NonClosingDataEntryWriter nonClosingDataEntryWriter = new NonClosingDataEntryWriter(
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(nonClosingDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link NonClosingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream2() throws IOException {
    // Arrange
    NonClosingDataEntryWriter nonClosingDataEntryWriter = new NonClosingDataEntryWriter(
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(nonClosingDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }
}
