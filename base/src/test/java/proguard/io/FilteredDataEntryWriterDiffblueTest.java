package proguard.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FilteredDataEntryWriterDiffblueTest {
  /**
   * Test {@link FilteredDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryFilter} {@link DataEntryFilter#accepts(DataEntry)} return {@code
   *       false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test createDirectory(DataEntry); given DataEntryFilter accepts(DataEntry) return 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.FilteredDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory_givenDataEntryFilterAcceptsReturnFalse_thenReturnFalse()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(false);
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(dataEntryFilter, null);

    // Act
    boolean actualCreateDirectoryResult =
        filteredDataEntryWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    assertFalse(actualCreateDirectoryResult);
  }

  /**
   * Test {@link FilteredDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryFilter} {@link DataEntryFilter#accepts(DataEntry)} return {@code
   *       true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test createDirectory(DataEntry); given DataEntryFilter accepts(DataEntry) return 'true'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.FilteredDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory_givenDataEntryFilterAcceptsReturnTrue_thenReturnFalse()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(dataEntryFilter, null);

    // Act
    boolean actualCreateDirectoryResult =
        filteredDataEntryWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    assertFalse(actualCreateDirectoryResult);
  }

  /**
   * Test {@link FilteredDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir} is array of {@link String} with {@code foo}
   *       toFile.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test createDirectory(DataEntry); given Property is 'java.io.tmpdir' is array of String with 'foo' toFile")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.FilteredDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory_givenPropertyIsJavaIoTmpdirIsArrayOfStringWithFooToFile()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    DataEntryFilter dataEntryFilter2 = mock(DataEntryFilter.class);
    when(dataEntryFilter2.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter, new FilteredDataEntryWriter(dataEntryFilter2, null));

    // Act
    boolean actualCreateDirectoryResult =
        filteredDataEntryWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    verify(dataEntryFilter2).accepts(isA(DataEntry.class));
    assertFalse(actualCreateDirectoryResult);
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
  @DisplayName("Test createDirectory(DataEntry); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.FilteredDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory_thenReturnTrue() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            new FixedFileWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    boolean actualCreateDirectoryResult =
        filteredDataEntryWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    assertTrue(actualCreateDirectoryResult);
  }

  /**
   * Test {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.FilteredDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(dataEntryFilter, null);
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act
    boolean actualSameOutputStreamResult =
        filteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter, atLeast(1)).accepts(Mockito.<DataEntry>any());
    assertTrue(actualSameOutputStreamResult);
  }

  /**
   * Test {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.FilteredDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream2() throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(false);
    DirectoryWriter acceptedDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            acceptedDataEntryWriter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act
    boolean actualSameOutputStreamResult =
        filteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter, atLeast(1)).accepts(Mockito.<DataEntry>any());
    assertTrue(actualSameOutputStreamResult);
  }

  /**
   * Test {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryFilter} {@link DataEntryFilter#accepts(DataEntry)} return {@code
   *       false}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); given DataEntryFilter accepts(DataEntry) return 'false'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.FilteredDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_givenDataEntryFilterAcceptsReturnFalse_thenReturnTrue()
      throws IOException {
    // Arrange
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(false);
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act
    boolean actualSameOutputStreamResult =
        filteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter, atLeast(1)).accepts(Mockito.<DataEntry>any());
    assertTrue(actualSameOutputStreamResult);
  }

  /**
   * Test {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryFilter} {@link DataEntryFilter#accepts(DataEntry)} return {@code
   *       true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); given DataEntryFilter accepts(DataEntry) return 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.FilteredDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_givenDataEntryFilterAcceptsReturnTrue_thenReturnTrue()
      throws IOException {
    // Arrange
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act
    boolean actualSameOutputStreamResult =
        filteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter, atLeast(1)).accepts(Mockito.<DataEntry>any());
    assertTrue(actualSameOutputStreamResult);
  }

  /**
   * Test {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.FilteredDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_thenReturnTrue() throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    DataEntryFilter dataEntryFilter2 = mock(DataEntryFilter.class);
    when(dataEntryFilter2.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    FilteredDataEntryWriter acceptedDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter2,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            acceptedDataEntryWriter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act
    boolean actualSameOutputStreamResult =
        filteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter, atLeast(1)).accepts(Mockito.<DataEntry>any());
    verify(dataEntryFilter2, atLeast(1)).accepts(Mockito.<DataEntry>any());
    assertTrue(actualSameOutputStreamResult);
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
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); when ClassPathDataEntry(String) with name is '.class'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.FilteredDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse()
      throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    DataEntryFilter dataEntryFilter2 = mock(DataEntryFilter.class);
    when(dataEntryFilter2.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    FilteredDataEntryWriter acceptedDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter2,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            acceptedDataEntryWriter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act
    boolean actualSameOutputStreamResult =
        filteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter, atLeast(1)).accepts(Mockito.<DataEntry>any());
    verify(dataEntryFilter2, atLeast(1)).accepts(Mockito.<DataEntry>any());
    assertFalse(actualSameOutputStreamResult);
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
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); when ClassPathDataEntry(String) with name is '.class'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.FilteredDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_whenClassPathDataEntryWithNameIsClass_thenReturnFalse2()
      throws IOException {
    // Arrange
    new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(false);
    DataEntryFilter dataEntryFilter2 = mock(DataEntryFilter.class);
    when(dataEntryFilter2.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    FilteredDataEntryWriter acceptedDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter2,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            acceptedDataEntryWriter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(".class");

    // Act
    boolean actualSameOutputStreamResult =
        filteredDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter, atLeast(1)).accepts(Mockito.<DataEntry>any());
    assertFalse(actualSameOutputStreamResult);
  }

  /**
   * Test {@link FilteredDataEntryWriter#createOutputStream(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryFilter} {@link DataEntryFilter#accepts(DataEntry)} return {@code
   *       false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test createOutputStream(DataEntry); given DataEntryFilter accepts(DataEntry) return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.io.OutputStream proguard.io.FilteredDataEntryWriter.createOutputStream(proguard.io.DataEntry)"
  })
  void testCreateOutputStream_givenDataEntryFilterAcceptsReturnFalse_thenReturnNull()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(false);
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(dataEntryFilter, null);

    // Act
    OutputStream actualCreateOutputStreamResult =
        filteredDataEntryWriter.createOutputStream(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    assertNull(actualCreateOutputStreamResult);
  }

  /**
   * Test {@link FilteredDataEntryWriter#createOutputStream(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryFilter} {@link DataEntryFilter#accepts(DataEntry)} return {@code
   *       true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test createOutputStream(DataEntry); given DataEntryFilter accepts(DataEntry) return 'true'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.io.OutputStream proguard.io.FilteredDataEntryWriter.createOutputStream(proguard.io.DataEntry)"
  })
  void testCreateOutputStream_givenDataEntryFilterAcceptsReturnTrue_thenReturnNull()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(dataEntryFilter, null);

    // Act
    OutputStream actualCreateOutputStreamResult =
        filteredDataEntryWriter.createOutputStream(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    assertNull(actualCreateOutputStreamResult);
  }

  /**
   * Test {@link FilteredDataEntryWriter#createOutputStream(DataEntry)}.
   *
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir} is array of {@link String} with {@code foo}
   *       toFile.
   * </ul>
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test createOutputStream(DataEntry); given Property is 'java.io.tmpdir' is array of String with 'foo' toFile")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.io.OutputStream proguard.io.FilteredDataEntryWriter.createOutputStream(proguard.io.DataEntry)"
  })
  void testCreateOutputStream_givenPropertyIsJavaIoTmpdirIsArrayOfStringWithFooToFile()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    DataEntryFilter dataEntryFilter2 = mock(DataEntryFilter.class);
    when(dataEntryFilter2.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter, new FilteredDataEntryWriter(dataEntryFilter2, null));

    // Act
    OutputStream actualCreateOutputStreamResult =
        filteredDataEntryWriter.createOutputStream(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    verify(dataEntryFilter2).accepts(isA(DataEntry.class));
    assertNull(actualCreateOutputStreamResult);
  }

  /**
   * Test {@link FilteredDataEntryWriter#close()}.
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.FilteredDataEntryWriter.close()"})
  void testClose() throws IOException {
    // Arrange
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    filteredDataEntryWriter.close();

    // Assert that nothing has changed
    assertFalse(filteredDataEntryWriter.createDirectory(null));
  }

  /**
   * Test {@link FilteredDataEntryWriter#close()}.
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.FilteredDataEntryWriter.close()"})
  void testClose2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(mock(DataEntryFilter.class), null);

    // Act
    filteredDataEntryWriter.close();

    // Assert that nothing has changed
    assertFalse(filteredDataEntryWriter.createDirectory(null));
  }

  /**
   * Test {@link FilteredDataEntryWriter#close()}.
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.FilteredDataEntryWriter.close()"})
  void testClose3() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    CascadingDataEntryWriter acceptedDataEntryWriter = mock(CascadingDataEntryWriter.class);
    doThrow(new IOException("foo")).when(acceptedDataEntryWriter).close();

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            (new FilteredDataEntryWriter(mock(DataEntryFilter.class), acceptedDataEntryWriter))
                .close());
    verify(acceptedDataEntryWriter).close();
  }

  /**
   * Test {@link FilteredDataEntryWriter#close()}.
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.FilteredDataEntryWriter.close()"})
  void testClose4() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    new IOException("foo");
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    DirectoryWriter acceptedDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            acceptedDataEntryWriter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    filteredDataEntryWriter.close();

    // Assert
    assertNull(filteredDataEntryWriter.createOutputStream(null));
    assertFalse(filteredDataEntryWriter.createDirectory(null));
  }

  /**
   * Test {@link FilteredDataEntryWriter#close()}.
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.FilteredDataEntryWriter.close()"})
  void testClose5() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    new IOException("foo");
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    DataEntryFilter dataEntryFilter2 = mock(DataEntryFilter.class);
    FilteredDataEntryWriter acceptedDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter2,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    FilteredDataEntryWriter filteredDataEntryWriter =
        new FilteredDataEntryWriter(
            dataEntryFilter,
            acceptedDataEntryWriter,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    filteredDataEntryWriter.close();

    // Assert
    assertNull(filteredDataEntryWriter.createOutputStream(null));
    assertFalse(filteredDataEntryWriter.createDirectory(null));
  }

  /**
   * Test {@link FilteredDataEntryWriter#close()}.
   *
   * <p>Method under test: {@link FilteredDataEntryWriter#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.FilteredDataEntryWriter.close()"})
  void testClose6() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    new IOException("foo");
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    CascadingDataEntryWriter rejectedDataEntryWriter = mock(CascadingDataEntryWriter.class);
    doThrow(new IOException("foo")).when(rejectedDataEntryWriter).close();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            (new FilteredDataEntryWriter(
                    dataEntryFilter,
                    new DirectoryWriter(
                        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()),
                    rejectedDataEntryWriter))
                .close());
    verify(rejectedDataEntryWriter).close();
  }
}
