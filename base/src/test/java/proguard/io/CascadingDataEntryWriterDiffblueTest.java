package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;

public class CascadingDataEntryWriterDiffblueTest {
  /**
   * Method under test:
   * {@link CascadingDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    FixedFileWriter dataEntryWriter1 = new FixedFileWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    CascadingDataEntryWriter cascadingDataEntryWriter = new CascadingDataEntryWriter(dataEntryWriter1,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(cascadingDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link CascadingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream() throws IOException {
    // Arrange
    DirectoryWriter dataEntryWriter1 = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    CascadingDataEntryWriter cascadingDataEntryWriter = new CascadingDataEntryWriter(dataEntryWriter1,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(cascadingDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link CascadingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DirectoryWriter dataEntryWriter1 = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    CascadingDataEntryWriter dataEntryWriter12 = new CascadingDataEntryWriter(dataEntryWriter1,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    CascadingDataEntryWriter cascadingDataEntryWriter = new CascadingDataEntryWriter(dataEntryWriter12,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(cascadingDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link CascadingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream3() throws IOException {
    // Arrange
    DirectoryWriter dataEntryWriter1 = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    CascadingDataEntryWriter cascadingDataEntryWriter = new CascadingDataEntryWriter(dataEntryWriter1,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(cascadingDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link CascadingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream4() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DirectoryWriter dataEntryWriter1 = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DirectoryWriter dataEntryWriter12 = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    CascadingDataEntryWriter cascadingDataEntryWriter = new CascadingDataEntryWriter(dataEntryWriter1,
        new CascadingDataEntryWriter(dataEntryWriter12,
            new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(cascadingDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link CascadingDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream5() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DirectoryWriter dataEntryWriter1 = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    CascadingDataEntryWriter cascadingDataEntryWriter = new CascadingDataEntryWriter(dataEntryWriter1,
        new FixedFileWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertTrue(cascadingDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }
}
