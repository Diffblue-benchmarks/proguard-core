package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;

public class DirectoryWriterDiffblueTest {
  /**
   * Method under test: {@link DirectoryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory() throws IOException {
    // Arrange
    DirectoryWriter directoryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(directoryWriter.createDirectory(new ClassPathDataEntry("")));
  }

  /**
   * Method under test:
   * {@link DirectoryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream() throws IOException {
    // Arrange
    DirectoryWriter directoryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(directoryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link DirectoryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream2() throws IOException {
    // Arrange
    DirectoryWriter directoryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(directoryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }
}
