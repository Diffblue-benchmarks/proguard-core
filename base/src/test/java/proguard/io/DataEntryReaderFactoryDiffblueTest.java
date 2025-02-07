package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataEntryReaderFactoryDiffblueTest {
  /**
   * Test {@link DataEntryReaderFactory#createDataEntryReader(ClassPathEntry, DataEntryReader)}.
   *
   * <p>Method under test: {@link DataEntryReaderFactory#createDataEntryReader(ClassPathEntry,
   * DataEntryReader)}
   */
  @Test
  @DisplayName("Test createDataEntryReader(ClassPathEntry, DataEntryReader)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryReader proguard.io.DataEntryReaderFactory.createDataEntryReader(proguard.io.ClassPathEntry, proguard.io.DataEntryReader)"
  })
  void testCreateDataEntryReader() throws IOException {
    // Arrange
    DataEntryReaderFactory dataEntryReaderFactory = new DataEntryReaderFactory(true);
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    DataEntryReader reader = mock(DataEntryReader.class);
    doNothing().when(reader).read(Mockito.<DataEntry>any());

    // Act
    DataEntryReader actualCreateDataEntryReaderResult =
        dataEntryReaderFactory.createDataEntryReader(classPathEntry, reader);
    actualCreateDataEntryReaderResult.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(reader).read(isA(DataEntry.class));
    assertTrue(actualCreateDataEntryReaderResult instanceof FilteredDataEntryReader);
  }

  /**
   * Test {@link DataEntryReaderFactory#createDataEntryReader(ClassPathEntry, DataEntryReader)}.
   *
   * <p>Method under test: {@link DataEntryReaderFactory#createDataEntryReader(ClassPathEntry,
   * DataEntryReader)}
   */
  @Test
  @DisplayName("Test createDataEntryReader(ClassPathEntry, DataEntryReader)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.DataEntryReader proguard.io.DataEntryReaderFactory.createDataEntryReader(proguard.io.ClassPathEntry, proguard.io.DataEntryReader)"
  })
  void testCreateDataEntryReader2() throws IOException {
    // Arrange
    DataEntryReaderFactory dataEntryReaderFactory = new DataEntryReaderFactory(true);
    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);

    DataEntryReader reader = mock(DataEntryReader.class);
    doNothing().when(reader).read(Mockito.<DataEntry>any());

    // Act
    DataEntryReader actualCreateDataEntryReaderResult =
        dataEntryReaderFactory.createDataEntryReader(classPathEntry, reader);
    actualCreateDataEntryReaderResult.read(new ClassPathDataEntry(".class"));

    // Assert
    verify(reader).read(isA(DataEntry.class));
    assertTrue(actualCreateDataEntryReaderResult instanceof FilteredDataEntryReader);
  }

  /**
   * Test {@link DataEntryReaderFactory#getFilterExcludingVersionedClasses(ClassPathEntry)}.
   *
   * <p>Method under test: {@link
   * DataEntryReaderFactory#getFilterExcludingVersionedClasses(ClassPathEntry)}
   */
  @Test
  @DisplayName("Test getFilterExcludingVersionedClasses(ClassPathEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.io.DataEntryReaderFactory.getFilterExcludingVersionedClasses(proguard.io.ClassPathEntry)"
  })
  void testGetFilterExcludingVersionedClasses() {
    // Arrange and Act
    List<String> actualFilterExcludingVersionedClasses =
        DataEntryReaderFactory.getFilterExcludingVersionedClasses(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));

    // Assert
    assertEquals(1, actualFilterExcludingVersionedClasses.size());
    assertEquals("!META-INF/versions/**", actualFilterExcludingVersionedClasses.get(0));
  }

  /**
   * Test {@link DataEntryReaderFactory#getFilterExcludingVersionedClasses(ClassPathEntry)}.
   *
   * <ul>
   *   <li>Then return first is {@code META-INF/versions}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DataEntryReaderFactory#getFilterExcludingVersionedClasses(ClassPathEntry)}
   */
  @Test
  @DisplayName(
      "Test getFilterExcludingVersionedClasses(ClassPathEntry); then return first is 'META-INF/versions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.io.DataEntryReaderFactory.getFilterExcludingVersionedClasses(proguard.io.ClassPathEntry)"
  })
  void testGetFilterExcludingVersionedClasses_thenReturnFirstIsMetaInfVersions() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("META-INF/versions");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setFilter(filter);

    // Act
    List<String> actualFilterExcludingVersionedClasses =
        DataEntryReaderFactory.getFilterExcludingVersionedClasses(classPathEntry);

    // Assert
    assertEquals(1, actualFilterExcludingVersionedClasses.size());
    assertEquals("META-INF/versions", actualFilterExcludingVersionedClasses.get(0));
  }

  /**
   * Test {@link DataEntryReaderFactory#getFilterExcludingVersionedClasses(ClassPathEntry)}.
   *
   * <ul>
   *   <li>Then return second is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DataEntryReaderFactory#getFilterExcludingVersionedClasses(ClassPathEntry)}
   */
  @Test
  @DisplayName(
      "Test getFilterExcludingVersionedClasses(ClassPathEntry); then return second is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.io.DataEntryReaderFactory.getFilterExcludingVersionedClasses(proguard.io.ClassPathEntry)"
  })
  void testGetFilterExcludingVersionedClasses_thenReturnSecondIsFoo() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setFilter(filter);

    // Act
    List<String> actualFilterExcludingVersionedClasses =
        DataEntryReaderFactory.getFilterExcludingVersionedClasses(classPathEntry);

    // Assert
    assertEquals(2, actualFilterExcludingVersionedClasses.size());
    assertEquals("!META-INF/versions/**", actualFilterExcludingVersionedClasses.get(0));
    assertEquals("foo", actualFilterExcludingVersionedClasses.get(1));
  }

  /**
   * Test {@link DataEntryReaderFactory#getFilterExcludingVersionedClasses(ClassPathEntry)}.
   *
   * <ul>
   *   <li>Then return second is {@code META-INF/versions}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DataEntryReaderFactory#getFilterExcludingVersionedClasses(ClassPathEntry)}
   */
  @Test
  @DisplayName(
      "Test getFilterExcludingVersionedClasses(ClassPathEntry); then return second is 'META-INF/versions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.List proguard.io.DataEntryReaderFactory.getFilterExcludingVersionedClasses(proguard.io.ClassPathEntry)"
  })
  void testGetFilterExcludingVersionedClasses_thenReturnSecondIsMetaInfVersions() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");
    filter.add("META-INF/versions");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setFilter(filter);

    // Act
    List<String> actualFilterExcludingVersionedClasses =
        DataEntryReaderFactory.getFilterExcludingVersionedClasses(classPathEntry);

    // Assert
    assertEquals(2, actualFilterExcludingVersionedClasses.size());
    assertEquals("META-INF/versions", actualFilterExcludingVersionedClasses.get(1));
    assertEquals("foo", actualFilterExcludingVersionedClasses.get(0));
  }
}
