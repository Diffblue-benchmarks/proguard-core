package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DirectoryWriterDiffblueTest {
  /**
   * Test {@link DirectoryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with name is empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DirectoryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DirectoryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory_whenClassPathDataEntryWithNameIsEmptyString_thenReturnTrue()
      throws IOException {
    // Arrange
    DirectoryWriter directoryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertTrue(directoryWriter.createDirectory(new ClassPathDataEntry("")));
  }

  /**
   * Test {@link DirectoryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with name is {@code .class}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DirectoryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DirectoryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse()
      throws IOException {
    // Arrange
    DirectoryWriter directoryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(directoryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link DirectoryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with {@code Name}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DirectoryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DirectoryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_whenClassPathDataEntryWithName_thenReturnTrue()
      throws IOException {
    // Arrange
    DirectoryWriter directoryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(directoryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }
}
