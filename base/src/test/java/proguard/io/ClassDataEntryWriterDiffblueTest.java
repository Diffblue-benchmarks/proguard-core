package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinConstants;

public class ClassDataEntryWriterDiffblueTest {
  /**
   * Test {@link ClassDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link ClassDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    ClassDataEntryWriter classDataEntryWriter =
        new ClassDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new FilteredDataEntryWriter(
                dataEntryFilter,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(classDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link ClassDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassDataEntryWriter classDataEntryWriter =
        new ClassDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new NameFilteredDataEntryWriter(
                "Regular Expression",
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(classDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory_thenReturnTrue() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassDataEntryWriter classDataEntryWriter =
        new ClassDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new FixedFileWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(classDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link ClassDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassDataEntryWriter classDataEntryWriter =
        new ClassDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new ClassDataEntryWriter(
                KotlinConstants.dummyClassPool,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(classDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link ClassDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassDataEntryWriter classDataEntryWriter =
        new ClassDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new NameFilteredDataEntryWriter(
                "Regular Expression",
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(classDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ClassDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_thenReturnTrue() throws IOException {
    // Arrange
    ClassDataEntryWriter classDataEntryWriter =
        new ClassDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(classDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with name is {@code .class}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ClassDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse()
      throws IOException {
    // Arrange
    ClassDataEntryWriter classDataEntryWriter =
        new ClassDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(classDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ClassDataEntryWriter#createOutputStream(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.OutputStream ClassDataEntryWriter.createOutputStream(DataEntry)"})
  public void testCreateOutputStream_thenReturnNull() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassDataEntryWriter classDataEntryWriter =
        new ClassDataEntryWriter(
            KotlinConstants.dummyClassPool,
            new NameFilteredDataEntryWriter(
                "Regular Expression",
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertNull(classDataEntryWriter.createOutputStream(new ClassPathDataEntry("Name")));
  }
}
