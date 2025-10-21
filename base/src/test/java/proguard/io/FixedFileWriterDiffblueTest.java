package proguard.io;

import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FixedFileWriterDiffblueTest {
  /**
   * Test {@link FixedFileWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link FixedFileWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FixedFileWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory() throws IOException {
    // Arrange
    FixedFileWriter fixedFileWriter =
        new FixedFileWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(fixedFileWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link FixedFileWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link FixedFileWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FixedFileWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream() throws IOException {
    // Arrange
    FixedFileWriter fixedFileWriter =
        new FixedFileWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(fixedFileWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }
}
