package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinConstants;

public class ClassMapDataEntryWriterDiffblueTest {
  /**
   * Test {@link ClassMapDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link ClassMapDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassMapDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    ClassMapDataEntryWriter classMapDataEntryWriter =
        new ClassMapDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new FilteredDataEntryWriter(
                dataEntryFilter,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(classMapDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassMapDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link ClassMapDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassMapDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassMapDataEntryWriter classMapDataEntryWriter =
        new ClassMapDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new NameFilteredDataEntryWriter(
                "Regular Expression",
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(classMapDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassMapDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassMapDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassMapDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory_thenReturnTrue() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassMapDataEntryWriter classMapDataEntryWriter =
        new ClassMapDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new FixedFileWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(classMapDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassMapDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassMapDataEntryWriter classMapDataEntryWriter =
        new ClassMapDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new ClassMapDataEntryWriter(
                KotlinConstants.dummyClassPool,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        classMapDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassMapDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassMapDataEntryWriter classMapDataEntryWriter =
        new ClassMapDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new NameFilteredDataEntryWriter(
                "Regular Expression",
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        classMapDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassMapDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_thenReturnTrue() throws IOException {
    // Arrange
    ClassMapDataEntryWriter classMapDataEntryWriter =
        new ClassMapDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        classMapDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with name is {@code .class}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassMapDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse()
      throws IOException {
    // Arrange
    ClassMapDataEntryWriter classMapDataEntryWriter =
        new ClassMapDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(
        classMapDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }
}
