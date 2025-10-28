package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;

public class ParentDataEntryWriterDiffblueTest {
  /**
   * Method under test: {@link ParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ParentDataEntryWriter parentDataEntryWriter = new ParentDataEntryWriter(
        new FixedFileWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(parentDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link ParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    ParentDataEntryWriter parentDataEntryWriter = new ParentDataEntryWriter(new FilteredDataEntryWriter(dataEntryFilter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(parentDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link ParentDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ParentDataEntryWriter parentDataEntryWriter = new ParentDataEntryWriter(
        new FixedFileWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(parentDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link ParentDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  public void testCreateOutputStream() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    ParentDataEntryWriter parentDataEntryWriter = new ParentDataEntryWriter(new FilteredDataEntryWriter(dataEntryFilter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertNull(parentDataEntryWriter.createOutputStream(new ClassPathDataEntry("Name")));
  }
}
