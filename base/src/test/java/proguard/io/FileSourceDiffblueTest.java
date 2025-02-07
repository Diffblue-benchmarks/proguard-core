package proguard.io;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FileSourceDiffblueTest {
  /**
   * Test {@link FileSource#FileSource(File)}.
   *
   * <p>Method under test: {@link FileSource#FileSource(File)}
   */
  @Test
  @DisplayName("Test new FileSource(File)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.FileSource.<init>(java.io.File)"})
  void testNewFileSource() throws IOException {
    // Arrange and Act
    FileSource actualFileSource =
        new FileSource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    actualFileSource.pumpDataEntries(dataEntryReader);

    // Assert
    verify(dataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link FileSource#FileSource(File, File)}.
   *
   * <p>Method under test: {@link FileSource#FileSource(File, File)}
   */
  @Test
  @DisplayName("Test new FileSource(File, File)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.FileSource.<init>(java.io.File, java.io.File)"})
  void testNewFileSource2() throws IOException {
    // Arrange
    File directory = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act
    FileSource actualFileSource =
        new FileSource(
            directory, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    actualFileSource.pumpDataEntries(dataEntryReader);

    // Assert
    verify(dataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link FileSource#pumpDataEntries(DataEntryReader)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link FileSource#pumpDataEntries(DataEntryReader)}
   */
  @Test
  @DisplayName(
      "Test pumpDataEntries(DataEntryReader); given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.FileSource.pumpDataEntries(proguard.io.DataEntryReader)"})
  void testPumpDataEntries_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    FileSource fileSource =
        new FileSource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doThrow(new IOException("foo")).when(dataEntryReader).read(Mockito.<DataEntry>any());

    // Act and Assert
    assertThrows(IOException.class, () -> fileSource.pumpDataEntries(dataEntryReader));
    verify(dataEntryReader).read(isA(DataEntry.class));
  }

  /**
   * Test {@link FileSource#pumpDataEntries(DataEntryReader)}.
   *
   * <ul>
   *   <li>When {@link DataEntryReader} {@link DataEntryReader#read(DataEntry)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link FileSource#pumpDataEntries(DataEntryReader)}
   */
  @Test
  @DisplayName(
      "Test pumpDataEntries(DataEntryReader); when DataEntryReader read(DataEntry) does nothing")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.FileSource.pumpDataEntries(proguard.io.DataEntryReader)"})
  void testPumpDataEntries_whenDataEntryReaderReadDoesNothing() throws IOException {
    // Arrange
    FileSource fileSource =
        new FileSource(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());

    // Act
    fileSource.pumpDataEntries(dataEntryReader);

    // Assert
    verify(dataEntryReader).read(isA(DataEntry.class));
  }
}
