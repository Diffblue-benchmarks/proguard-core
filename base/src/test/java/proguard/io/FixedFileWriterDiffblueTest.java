package proguard.io;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;

public class FixedFileWriterDiffblueTest {
  /**
   * Method under test: {@link FixedFileWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory() throws IOException {
    // Arrange
    FixedFileWriter fixedFileWriter = new FixedFileWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(fixedFileWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link FixedFileWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream() throws IOException {
    // Arrange
    FixedFileWriter fixedFileWriter = new FixedFileWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(fixedFileWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }
}
