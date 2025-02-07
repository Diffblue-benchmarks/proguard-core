package proguard.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
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

class ParentDataEntryWriterDiffblueTest {
  /**
   * Test {@link ParentDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.ParentDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory_thenReturnFalse() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    ParentDataEntryWriter parentDataEntryWriter =
        new ParentDataEntryWriter(new FilteredDataEntryWriter(dataEntryFilter, null));

    // Act
    boolean actualCreateDirectoryResult =
        parentDataEntryWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isNull());
    assertFalse(actualCreateDirectoryResult);
  }

  /**
   * Test {@link ParentDataEntryWriter#createDirectory(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ParentDataEntryWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.ParentDataEntryWriter.createDirectory(proguard.io.DataEntry)"
  })
  void testCreateDirectory_thenReturnTrue() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ParentDataEntryWriter parentDataEntryWriter =
        new ParentDataEntryWriter(
            new FixedFileWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertTrue(parentDataEntryWriter.createDirectory(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ParentDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ParentDataEntryWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.ParentDataEntryWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_thenReturnTrue() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    ParentDataEntryWriter parentDataEntryWriter =
        new ParentDataEntryWriter(
            new FixedFileWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(parentDataEntryWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ParentDataEntryWriter#createOutputStream(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ParentDataEntryWriter#createOutputStream(DataEntry)}
   */
  @Test
  @DisplayName("Test createOutputStream(DataEntry); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.io.OutputStream proguard.io.ParentDataEntryWriter.createOutputStream(proguard.io.DataEntry)"
  })
  void testCreateOutputStream_thenReturnNull() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    ParentDataEntryWriter parentDataEntryWriter =
        new ParentDataEntryWriter(new FilteredDataEntryWriter(dataEntryFilter, null));

    // Act
    OutputStream actualCreateOutputStreamResult =
        parentDataEntryWriter.createOutputStream(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isNull());
    assertNull(actualCreateOutputStreamResult);
  }

  /**
   * Test {@link ParentDataEntryWriter#close()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ParentDataEntryWriter#close()}
   */
  @Test
  @DisplayName("Test close(); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ParentDataEntryWriter.close()"})
  void testClose_thenThrowIOException() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    CascadingDataEntryWriter dataEntryWriter = mock(CascadingDataEntryWriter.class);
    doThrow(new IOException("foo")).when(dataEntryWriter).close();

    // Act and Assert
    assertThrows(IOException.class, () -> (new ParentDataEntryWriter(dataEntryWriter)).close());
    verify(dataEntryWriter).close();
  }
}
