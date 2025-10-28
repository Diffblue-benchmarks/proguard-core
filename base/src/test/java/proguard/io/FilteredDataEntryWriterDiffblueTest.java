package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.junit.Test;

public class FilteredDataEntryWriterDiffblueTest {
  /**
   * Method under test: {@link FilteredDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory() throws IOException {
    // Arrange
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    FilteredDataEntryWriter filteredDataEntryWriter = new FilteredDataEntryWriter(dataEntryFilter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertFalse(filteredDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link FilteredDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  public void testCreateDirectory2() throws IOException {
    // Arrange
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    FilteredDataEntryWriter filteredDataEntryWriter = new FilteredDataEntryWriter(dataEntryFilter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(filteredDataEntryWriter
        .createDirectory(new FileDataEntry(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
  }

  /**
   * Method under test:
   * {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream() throws IOException {
    // Arrange
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    FilteredDataEntryWriter filteredDataEntryWriter = new FilteredDataEntryWriter(dataEntryFilter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(filteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream2() throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    DirectoryWriter acceptedDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    FilteredDataEntryWriter filteredDataEntryWriter = new FilteredDataEntryWriter(dataEntryFilter,
        acceptedDataEntryWriter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(filteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream3() throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ArrayList<Object> regularExpressions = new ArrayList<>();
    NameFilteredDataEntryWriter nameFilteredDataEntryWriter = new NameFilteredDataEntryWriter(regularExpressions,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(nameFilteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream4() throws IOException {
    // Arrange
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    FilteredDataEntryWriter filteredDataEntryWriter = new FilteredDataEntryWriter(dataEntryFilter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    DummyDataEntry dataEntry1 = new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true);

    // Act and Assert
    assertTrue(filteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream5() throws IOException {
    // Arrange
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    FilteredDataEntryWriter filteredDataEntryWriter = new FilteredDataEntryWriter(dataEntryFilter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(filteredDataEntryWriter.sameOutputStream(dataEntry1,
        new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)));
  }

  /**
   * Method under test:
   * {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream6() throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    DirectoryWriter acceptedDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DataEntryDirectoryFilter dataEntryFilter2 = new DataEntryDirectoryFilter();
    FilteredDataEntryWriter filteredDataEntryWriter = new FilteredDataEntryWriter(dataEntryFilter,
        acceptedDataEntryWriter, new FilteredDataEntryWriter(dataEntryFilter2,
            new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(filteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream7() throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    DirectoryWriter acceptedDataEntryWriter = new DirectoryWriter(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    FilteredDataEntryWriter filteredDataEntryWriter = new FilteredDataEntryWriter(dataEntryFilter,
        acceptedDataEntryWriter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(filteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream8() throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    NameFilteredDataEntryWriter nameFilteredDataEntryWriter = new NameFilteredDataEntryWriter(new ArrayList<>(), null);
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(nameFilteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream9() throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ArrayList<Object> regularExpressions = new ArrayList<>();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    NameFilteredDataEntryWriter nameFilteredDataEntryWriter = new NameFilteredDataEntryWriter(regularExpressions,
        new FilteredDataEntryWriter(dataEntryFilter,
            new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(nameFilteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream10() throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ArrayList<Object> regularExpressions = new ArrayList<>();
    NameFilteredDataEntryWriter nameFilteredDataEntryWriter = new NameFilteredDataEntryWriter(regularExpressions,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(nameFilteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test:
   * {@link FilteredDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  public void testCreateOutputStream() throws IOException {
    // Arrange
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    FilteredDataEntryWriter filteredDataEntryWriter = new FilteredDataEntryWriter(dataEntryFilter,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertNull(filteredDataEntryWriter.createOutputStream(new ClassPathDataEntry("Name")));
  }
}
