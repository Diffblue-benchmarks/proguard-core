package proguard.io;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FixedFileWriterDiffblueTest {
  /**
   * Test {@link FixedFileWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link FixedFileWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.FixedFileWriter.createDirectory(proguard.io.DataEntry)"})
  void testCreateDirectory() throws IOException {
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
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.FixedFileWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream() throws IOException {
    // Arrange
    FixedFileWriter fixedFileWriter =
        new FixedFileWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(fixedFileWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }
}
