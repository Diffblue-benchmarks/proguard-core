package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.util.CollectionMatcher;
import proguard.util.ConstantMatcher;
import proguard.util.EmptyStringMatcher;

public class RenamedParentDataEntryWriterDiffblueTest {
  /**
   * Test {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RenamedParentDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory() throws IOException {
    // Arrange
    EmptyStringMatcher matcher = new EmptyStringMatcher();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            matcher,
            "New Parent Name",
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(renamedParentDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RenamedParentDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    EmptyStringMatcher matcher = new EmptyStringMatcher();
    DataEntryDirectoryFilter dataEntryFilter = new DataEntryDirectoryFilter();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            matcher,
            "New Parent Name",
            new FilteredDataEntryWriter(
                dataEntryFilter,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(renamedParentDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RenamedParentDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory3() throws IOException {
    // Arrange
    EmptyStringMatcher matcher = new EmptyStringMatcher();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            matcher,
            "New Parent Name",
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(
        renamedParentDataEntryWriter.createDirectory(
            new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)));
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RenamedParentDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory4() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    EmptyStringMatcher matcher = new EmptyStringMatcher();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            matcher,
            "New Parent Name",
            new NameFilteredDataEntryWriter(
                "Regular Expression",
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertFalse(renamedParentDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link CollectionMatcher#CollectionMatcher(Set)} with set is {@link
   *       HashSet#HashSet()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RenamedParentDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory_givenCollectionMatcherWithSetIsHashSet_thenReturnTrue()
      throws IOException {
    // Arrange
    CollectionMatcher matcher = new CollectionMatcher(new HashSet<>());
    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            matcher,
            "New Parent Name",
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(
        renamedParentDataEntryWriter.createDirectory(
            new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)));
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RenamedParentDataEntryWriter.createDirectory(DataEntry)"})
  public void testCreateDirectory_givenConstantMatcherWithMatchesIsTrue_thenReturnTrue()
      throws IOException {
    // Arrange
    ConstantMatcher matcher = new ConstantMatcher(true);
    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            matcher,
            "New Parent Name",
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(
        renamedParentDataEntryWriter.createDirectory(
            new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)));
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry,
   * DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RenamedParentDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream() throws IOException {
    // Arrange
    EmptyStringMatcher matcher = new EmptyStringMatcher();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            matcher,
            "New Parent Name",
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        renamedParentDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry,
   * DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RenamedParentDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream2() throws IOException {
    // Arrange
    EmptyStringMatcher matcher = new EmptyStringMatcher();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            matcher,
            "New Parent Name",
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    DummyDataEntry dataEntry1 =
        new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true);

    // Act and Assert
    assertTrue(
        renamedParentDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link CollectionMatcher#CollectionMatcher(Set)} with set is {@link
   *       HashSet#HashSet()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry,
   * DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RenamedParentDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_givenCollectionMatcherWithSetIsHashSet_thenReturnTrue()
      throws IOException {
    // Arrange
    CollectionMatcher matcher = new CollectionMatcher(new HashSet<>());
    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            matcher,
            "New Parent Name",
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    DummyDataEntry dataEntry1 =
        new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true);

    // Act and Assert
    assertTrue(
        renamedParentDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry,
   * DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RenamedParentDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_givenConstantMatcherWithMatchesIsTrue_thenReturnTrue()
      throws IOException {
    // Arrange
    ConstantMatcher matcher = new ConstantMatcher(true);
    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            matcher,
            "New Parent Name",
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    DummyDataEntry dataEntry1 =
        new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true);

    // Act and Assert
    assertTrue(
        renamedParentDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir} is array of {@link String} with {@code test.txt}
   *       toFile.
   * </ul>
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry,
   * DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RenamedParentDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_givenPropertyIsJavaIoTmpdirIsArrayOfStringWithTestTxtToFile()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    EmptyStringMatcher matcher = new EmptyStringMatcher();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            matcher,
            "New Parent Name",
            new NameFilteredDataEntryWriter(
                "Regular Expression",
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(
        renamedParentDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with name is {@code .class}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry,
   * DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RenamedParentDataEntryWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse()
      throws IOException {
    // Arrange
    EmptyStringMatcher matcher = new EmptyStringMatcher();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            matcher,
            "New Parent Name",
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act and Assert
    assertFalse(
        renamedParentDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }
}
