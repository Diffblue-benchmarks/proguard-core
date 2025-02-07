package proguard.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataEntryCopierDiffblueTest {
  /**
   * Test {@link DataEntryCopier#DataEntryCopier(DataEntryWriter)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link DataEntryFilter#accepts(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryCopier#DataEntryCopier(DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new DataEntryCopier(DataEntryWriter); given 'true'; then calls accepts(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.DataEntryCopier.<init>(proguard.io.DataEntryWriter)"})
  void testNewDataEntryCopier_givenTrue_thenCallsAccepts() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);

    // Act
    DataEntryCopier actualDataEntryCopier =
        new DataEntryCopier(new FilteredDataEntryWriter(dataEntryFilter, null));
    actualDataEntryCopier.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
  }

  /**
   * Test {@link DataEntryCopier#DataEntryCopier(DataEntryWriter)}.
   *
   * <ul>
   *   <li>Then calls {@link DataEntryFilter#accepts(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryCopier#DataEntryCopier(DataEntryWriter)}
   */
  @Test
  @DisplayName("Test new DataEntryCopier(DataEntryWriter); then calls accepts(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.DataEntryCopier.<init>(proguard.io.DataEntryWriter)"})
  void testNewDataEntryCopier_thenCallsAccepts() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);

    // Act
    DataEntryCopier actualDataEntryCopier =
        new DataEntryCopier(new FilteredDataEntryWriter(dataEntryFilter, null));
    actualDataEntryCopier.read(
        new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
  }

  /**
   * Test {@link DataEntryCopier#read(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryFilter} {@link DataEntryFilter#accepts(DataEntry)} return {@code
   *       true}.
   *   <li>Then calls {@link DataEntryFilter#accepts(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryCopier#read(DataEntry)}
   */
  @Test
  @DisplayName(
      "Test read(DataEntry); given DataEntryFilter accepts(DataEntry) return 'true'; then calls accepts(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.DataEntryCopier.read(proguard.io.DataEntry)"})
  void testRead_givenDataEntryFilterAcceptsReturnTrue_thenCallsAccepts() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    DataEntryCopier dataEntryCopier =
        new DataEntryCopier(new FilteredDataEntryWriter(dataEntryFilter, null));

    // Act
    dataEntryCopier.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
  }

  /**
   * Test {@link DataEntryCopier#read(DataEntry)}.
   *
   * <ul>
   *   <li>Then calls {@link DataEntryFilter#accepts(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryCopier#read(DataEntry)}
   */
  @Test
  @DisplayName("Test read(DataEntry); then calls accepts(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.DataEntryCopier.read(proguard.io.DataEntry)"})
  void testRead_thenCallsAccepts() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);
    DataEntryCopier dataEntryCopier =
        new DataEntryCopier(new FilteredDataEntryWriter(dataEntryFilter, null));

    // Act
    dataEntryCopier.read(new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true));

    // Assert
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
  }

  /**
   * Test {@link DataEntryCopier#copyData(InputStream, OutputStream)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8} read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryCopier#copyData(InputStream, OutputStream)}
   */
  @Test
  @DisplayName(
      "Test copyData(InputStream, OutputStream); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.DataEntryCopier.copyData(java.io.InputStream, java.io.OutputStream)"
  })
  void testCopyData_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne()
      throws IOException {
    // Arrange
    DataEntryCopier dataEntryCopier =
        new DataEntryCopier(
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    dataEntryCopier.copyData(inputStream, outputStream);

    // Assert
    assertEquals(-1, inputStream.read(new byte[] {}));
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, outputStream.toByteArray());
  }
}
