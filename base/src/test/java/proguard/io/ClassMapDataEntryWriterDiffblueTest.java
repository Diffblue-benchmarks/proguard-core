package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import proguard.classfile.kotlin.KotlinConstants;

public class ClassMapDataEntryWriterDiffblueTest {
  /**
   * Method under test: {@link ClassMapDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassMapDataEntryWriter classMapDataEntryWriter = new ClassMapDataEntryWriter(KotlinConstants.dummyClassPool,
        new FixedFileWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(classMapDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link ClassMapDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    ClassMapDataEntryWriter classMapDataEntryWriter = new ClassMapDataEntryWriter(KotlinConstants.dummyClassPool,
        new FilteredDataEntryWriter(dataEntryFilter,
            new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(classMapDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link ClassMapDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory3() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassMapDataEntryWriter classMapDataEntryWriter = new ClassMapDataEntryWriter(KotlinConstants.dummyClassPool,
        new NameFilteredDataEntryWriter("Regular Expression",
            new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(classMapDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream() throws IOException {
    // Arrange
    ClassMapDataEntryWriter classMapDataEntryWriter = new ClassMapDataEntryWriter(KotlinConstants.dummyClassPool,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(classMapDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassMapDataEntryWriter classMapDataEntryWriter = new ClassMapDataEntryWriter(KotlinConstants.dummyClassPool,
        new ClassMapDataEntryWriter(KotlinConstants.dummyClassPool,
            new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(classMapDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream3() throws IOException {
    // Arrange
    ClassMapDataEntryWriter classMapDataEntryWriter = new ClassMapDataEntryWriter(KotlinConstants.dummyClassPool,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(classMapDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link ClassMapDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream4() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ClassMapDataEntryWriter classMapDataEntryWriter = new ClassMapDataEntryWriter(KotlinConstants.dummyClassPool,
        new NameFilteredDataEntryWriter("Regular Expression",
            new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(classMapDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }
}
