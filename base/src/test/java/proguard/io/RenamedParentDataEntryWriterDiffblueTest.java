package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import org.junit.Test;
import proguard.util.CollectionMatcher;
import proguard.util.ConstantMatcher;
import proguard.util.EmptyStringMatcher;

public class RenamedParentDataEntryWriterDiffblueTest {
  /**
   * Method under test:
   * {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory() throws IOException {
    // Arrange
    EmptyStringMatcher matcher = new EmptyStringMatcher();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter = new RenamedParentDataEntryWriter(matcher,
        "New Parent Name", new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(renamedParentDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    EmptyStringMatcher matcher = new EmptyStringMatcher();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter = new RenamedParentDataEntryWriter(matcher,
        "New Parent Name", new FilteredDataEntryWriter(dataEntryFilter,
            new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(renamedParentDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory3() throws IOException {
    // Arrange
    EmptyStringMatcher matcher = new EmptyStringMatcher();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter = new RenamedParentDataEntryWriter(matcher,
        "New Parent Name", new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(renamedParentDataEntryWriter
        .createDirectory(new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)));
  }

  /**
   * Method under test:
   * {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory4() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    EmptyStringMatcher matcher = new EmptyStringMatcher();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter = new RenamedParentDataEntryWriter(matcher,
        "New Parent Name", new NameFilteredDataEntryWriter("Regular Expression",
            new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(renamedParentDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory5() throws IOException {
    // Arrange
    CollectionMatcher matcher = new CollectionMatcher(new HashSet<>());
    RenamedParentDataEntryWriter renamedParentDataEntryWriter = new RenamedParentDataEntryWriter(matcher,
        "New Parent Name", new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(renamedParentDataEntryWriter
        .createDirectory(new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)));
  }

  /**
   * Method under test:
   * {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory6() throws IOException {
    // Arrange
    ConstantMatcher matcher = new ConstantMatcher(true);
    RenamedParentDataEntryWriter renamedParentDataEntryWriter = new RenamedParentDataEntryWriter(matcher,
        "New Parent Name", new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(renamedParentDataEntryWriter
        .createDirectory(new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)));
  }

  /**
   * Method under test:
   * {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream() throws IOException {
    // Arrange
    EmptyStringMatcher matcher = new EmptyStringMatcher();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter = new RenamedParentDataEntryWriter(matcher,
        "New Parent Name", new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(renamedParentDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream2() throws IOException {
    // Arrange
    EmptyStringMatcher matcher = new EmptyStringMatcher();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter = new RenamedParentDataEntryWriter(matcher,
        "New Parent Name", new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(renamedParentDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream3() throws IOException {
    // Arrange
    EmptyStringMatcher matcher = new EmptyStringMatcher();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter = new RenamedParentDataEntryWriter(matcher,
        "New Parent Name", new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    DummyDataEntry dataEntry1 = new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true);

    // Act and Assert
    assertTrue(renamedParentDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream4() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    EmptyStringMatcher matcher = new EmptyStringMatcher();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter = new RenamedParentDataEntryWriter(matcher,
        "New Parent Name", new NameFilteredDataEntryWriter("Regular Expression",
            new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(renamedParentDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream5() throws IOException {
    // Arrange
    CollectionMatcher matcher = new CollectionMatcher(new HashSet<>());
    RenamedParentDataEntryWriter renamedParentDataEntryWriter = new RenamedParentDataEntryWriter(matcher,
        "New Parent Name", new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    DummyDataEntry dataEntry1 = new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true);

    // Act and Assert
    assertTrue(renamedParentDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream6() throws IOException {
    // Arrange
    ConstantMatcher matcher = new ConstantMatcher(true);
    RenamedParentDataEntryWriter renamedParentDataEntryWriter = new RenamedParentDataEntryWriter(matcher,
        "New Parent Name", new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    DummyDataEntry dataEntry1 = new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true);

    // Act and Assert
    assertTrue(renamedParentDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }
}
