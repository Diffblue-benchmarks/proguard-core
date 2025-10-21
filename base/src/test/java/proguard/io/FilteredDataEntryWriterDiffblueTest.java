package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FilteredDataEntryWriterDiffblueTest {
  /**
   * Test {@link FilteredDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir} is array of {@link String} with {@code test.txt}
   *       toFile.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FilteredDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory_givenPropertyIsJavaIoTmpdirIsArrayOfStringWithTestTxtToFile()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    DataEntryDirectoryFilter dataEntryFilter2 = new DataEntryDirectoryFilter();
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            new FilteredDataEntryWriter(
                dataEntryFilter2,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertTrue(
        filteredDataEntryWriter.createDirectory(
            new FileDataEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
  }

  /**
   * Test {@link FilteredDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FilteredDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory_thenReturnTrue() throws IOException {
    // Arrange
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(
        filteredDataEntryWriter.createDirectory(
            new FileDataEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
  }

  /**
   * Test {@link FilteredDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FilteredDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory_whenClassPathDataEntryWithName_thenReturnFalse()
      throws IOException {
    // Arrange
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertFalse(filteredDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FilteredDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream() throws IOException {
    // Arrange
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        filteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FilteredDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream2() throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    DirectoryWriter acceptedDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            acceptedDataEntryWriter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        filteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FilteredDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream3() throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ArrayList<Object> regularExpressions = new ArrayList<>();
    NameFilteredDataEntryWriter nameFilteredDataEntryWriter =
        new NameFilteredDataEntryWriter(
            regularExpressions,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        nameFilteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FilteredDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream4() throws IOException {
    // Arrange
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    DummyDataEntry dataEntry1 =
        new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true);

    // Act and Assert
    assertTrue(
        filteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FilteredDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream5() throws IOException {
    // Arrange
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        filteredDataEntryWriter.sameOutputStream(
            dataEntry1, new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)));
  }

  /**
   * Test {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FilteredDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream6() throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    DirectoryWriter acceptedDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DataEntryDirectoryFilter dataEntryFilter2 = new DataEntryDirectoryFilter();
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            acceptedDataEntryWriter,
            new FilteredDataEntryWriter(
                dataEntryFilter2,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        filteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FilteredDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream7() throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    NameFilteredDataEntryWriter nameFilteredDataEntryWriter =
        new NameFilteredDataEntryWriter(new ArrayList<>(), null);
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        nameFilteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FilteredDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream8() throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ArrayList<Object> regularExpressions = new ArrayList<>();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    NameFilteredDataEntryWriter nameFilteredDataEntryWriter =
        new NameFilteredDataEntryWriter(
            regularExpressions,
            new FilteredDataEntryWriter(
                dataEntryFilter,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        nameFilteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with name is {@code .class}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FilteredDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse()
      throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    DirectoryWriter acceptedDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            acceptedDataEntryWriter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(
        filteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with name is {@code .class}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FilteredDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse2()
      throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    ArrayList<Object> regularExpressions = new ArrayList<>();
    NameFilteredDataEntryWriter nameFilteredDataEntryWriter =
        new NameFilteredDataEntryWriter(
            regularExpressions,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(
        nameFilteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link FilteredDataEntryWriter#createOutputStream(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.OutputStream FilteredDataEntryWriter.createOutputStream(DataEntry)"})
  public void testCreateOutputStream_thenReturnNull() throws IOException {
    // Arrange
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertNull(filteredDataEntryWriter.createOutputStream(new ClassPathDataEntry("Name")));
  }
}
