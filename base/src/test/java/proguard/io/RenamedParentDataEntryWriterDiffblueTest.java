package proguard.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.util.AndMatcher;
import proguard.util.CollectionMatcher;
import proguard.util.ConstantMatcher;
import proguard.util.EmptyStringMatcher;

class RenamedParentDataEntryWriterDiffblueTest {
  /**
   * Test {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.RenamedParentDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    FilteredDataEntryWriter dataEntryWriter = new FilteredDataEntryWriter(dataEntryFilter, null);

    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            new EmptyStringMatcher(), "New Parent Name", dataEntryWriter);

    // Act
    boolean actualCreateDirectoryResult =
        renamedParentDataEntryWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    assertFalse(actualCreateDirectoryResult);
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.RenamedParentDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    FilteredDataEntryWriter dataEntryWriter = new FilteredDataEntryWriter(dataEntryFilter, null);

    EmptyStringMatcher matcher1 = new EmptyStringMatcher();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            new AndMatcher(matcher1, new EmptyStringMatcher()), "New Parent Name", dataEntryWriter);

    // Act
    boolean actualCreateDirectoryResult =
        renamedParentDataEntryWriter.createDirectory(
            new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    assertFalse(actualCreateDirectoryResult);
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link CollectionMatcher#CollectionMatcher(Set)} with set is {@link
   *       HashSet#HashSet()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test createDirectory(DataEntry); given CollectionMatcher(Set) with set is HashSet(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.RenamedParentDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory_givenCollectionMatcherWithSetIsHashSet_thenReturnFalse()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    FilteredDataEntryWriter dataEntryWriter = new FilteredDataEntryWriter(dataEntryFilter, null);

    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            new CollectionMatcher(new HashSet<>()), "New Parent Name", dataEntryWriter);

    // Act
    boolean actualCreateDirectoryResult =
        renamedParentDataEntryWriter.createDirectory(
            new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    assertFalse(actualCreateDirectoryResult);
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test createDirectory(DataEntry); given ConstantMatcher(boolean) with matches is 'true'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.RenamedParentDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory_givenConstantMatcherWithMatchesIsTrue_thenReturnFalse()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    FilteredDataEntryWriter dataEntryWriter = new FilteredDataEntryWriter(dataEntryFilter, null);

    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            new ConstantMatcher(true), "New Parent Name", dataEntryWriter);

    // Act
    boolean actualCreateDirectoryResult =
        renamedParentDataEntryWriter.createDirectory(
            new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    assertFalse(actualCreateDirectoryResult);
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.RenamedParentDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory_thenReturnTrue() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    EmptyStringMatcher matcher = new EmptyStringMatcher();
    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            matcher,
            "New Parent Name",
            new FixedFileWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(renamedParentDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#sameOutputStream(DataEntry,
   * DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.RenamedParentDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream() throws IOException {
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
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.RenamedParentDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream2() throws IOException {
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
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); given CollectionMatcher(Set) with set is HashSet(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.RenamedParentDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_givenCollectionMatcherWithSetIsHashSet_thenReturnTrue()
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
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); given ConstantMatcher(boolean) with matches is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.RenamedParentDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_givenConstantMatcherWithMatchesIsTrue_thenReturnTrue()
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
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); given Property is 'java.io.tmpdir' is array of String with 'test.txt' toFile")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.RenamedParentDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_givenPropertyIsJavaIoTmpdirIsArrayOfStringWithTestTxtToFile()
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
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); when ClassPathDataEntry(String) with name is '.class'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.RenamedParentDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse()
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

  /**
   * Test {@link RenamedParentDataEntryWriter#createOutputStream(DataEntry)}.
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  @DisplayName("Test createOutputStream(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.io.OutputStream proguard.io.RenamedParentDataEntryWriter.createOutputStream(proguard.io.DataEntry)"
  })
  void testCreateOutputStream() throws IOException {
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
    assertNull(renamedParentDataEntryWriter.createOutputStream(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#createOutputStream(DataEntry)}.
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  @DisplayName("Test createOutputStream(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.io.OutputStream proguard.io.RenamedParentDataEntryWriter.createOutputStream(proguard.io.DataEntry)"
  })
  void testCreateOutputStream2() throws IOException {
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
    assertNull(
        renamedParentDataEntryWriter.createOutputStream(
            new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)));
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#createOutputStream(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link CollectionMatcher#CollectionMatcher(Set)} with set is {@link
   *       HashSet#HashSet()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test createOutputStream(DataEntry); given CollectionMatcher(Set) with set is HashSet(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.io.OutputStream proguard.io.RenamedParentDataEntryWriter.createOutputStream(proguard.io.DataEntry)"
  })
  void testCreateOutputStream_givenCollectionMatcherWithSetIsHashSet_thenReturnNull()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    CollectionMatcher matcher = new CollectionMatcher(new HashSet<>());
    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            matcher,
            "New Parent Name",
            new NameFilteredDataEntryWriter(
                "Regular Expression",
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertNull(
        renamedParentDataEntryWriter.createOutputStream(
            new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)));
  }

  /**
   * Test {@link RenamedParentDataEntryWriter#createOutputStream(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RenamedParentDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test createOutputStream(DataEntry); given ConstantMatcher(boolean) with matches is 'true'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.io.OutputStream proguard.io.RenamedParentDataEntryWriter.createOutputStream(proguard.io.DataEntry)"
  })
  void testCreateOutputStream_givenConstantMatcherWithMatchesIsTrue_thenReturnNull()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ConstantMatcher matcher = new ConstantMatcher(true);
    RenamedParentDataEntryWriter renamedParentDataEntryWriter =
        new RenamedParentDataEntryWriter(
            matcher,
            "New Parent Name",
            new NameFilteredDataEntryWriter(
                "Regular Expression",
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Act and Assert
    assertNull(
        renamedParentDataEntryWriter.createOutputStream(
            new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)));
  }
}
