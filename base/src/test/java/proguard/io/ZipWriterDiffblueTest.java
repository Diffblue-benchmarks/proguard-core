package proguard.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.io.ZipOutput.LargeDataOutputStream;
import proguard.util.EmptyStringMatcher;
import proguard.util.StringMatcher;

class ZipWriterDiffblueTest {
  /**
   * Test {@link ZipWriter#ZipWriter(DataEntryWriter)}.
   *
   * <p>Method under test: {@link ZipWriter#ZipWriter(DataEntryWriter)}
   */
  @Test
  @DisplayName("Test new ZipWriter(DataEntryWriter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ZipWriter.<init>(proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, proguard.util.StringMatcher, int, int, byte[], proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, int, proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, int, byte[], proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, proguard.util.StringMatcher, int, int, proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, proguard.util.StringMatcher, int, int, byte[], proguard.io.DataEntryWriter)"
  })
  void testNewZipWriter() {
    // Arrange, Act and Assert
    assertNull(
        (new ZipWriter(
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))
            .currentZipOutput);
  }

  /**
   * Test {@link ZipWriter#ZipWriter(StringMatcher, int, StringMatcher, int, int, byte[],
   * DataEntryWriter)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ZipWriter#ZipWriter(StringMatcher, int, StringMatcher, int, int,
   * byte[], DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new ZipWriter(StringMatcher, int, StringMatcher, int, int, byte[], DataEntryWriter); when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ZipWriter.<init>(proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, proguard.util.StringMatcher, int, int, byte[], proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, int, proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, int, byte[], proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, proguard.util.StringMatcher, int, int, proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, proguard.util.StringMatcher, int, int, byte[], proguard.io.DataEntryWriter)"
  })
  void testNewZipWriter_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    EmptyStringMatcher extraUncompressedAlignmentFilter = new EmptyStringMatcher();
    byte[] header = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull(
        (new ZipWriter(
                uncompressedFilter,
                1,
                extraUncompressedAlignmentFilter,
                1,
                1,
                header,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))
            .currentZipOutput);
  }

  /**
   * Test {@link ZipWriter#ZipWriter(StringMatcher, int, boolean, int, byte[], DataEntryWriter)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ZipWriter#ZipWriter(StringMatcher, int, boolean, int, byte[],
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new ZipWriter(StringMatcher, int, boolean, int, byte[], DataEntryWriter); when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ZipWriter.<init>(proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, proguard.util.StringMatcher, int, int, byte[], proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, int, proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, int, byte[], proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, proguard.util.StringMatcher, int, int, proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, proguard.util.StringMatcher, int, int, byte[], proguard.io.DataEntryWriter)"
  })
  void testNewZipWriter_whenAxaxaxaxBytesIsUtf82() throws UnsupportedEncodingException {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    byte[] header = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull(
        (new ZipWriter(
                uncompressedFilter,
                1,
                true,
                1,
                header,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))
            .currentZipOutput);
  }

  /**
   * Test {@link ZipWriter#ZipWriter(StringMatcher, int, boolean, StringMatcher, int, int, byte[],
   * DataEntryWriter)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ZipWriter#ZipWriter(StringMatcher, int, boolean, StringMatcher,
   * int, int, byte[], DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new ZipWriter(StringMatcher, int, boolean, StringMatcher, int, int, byte[], DataEntryWriter); when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ZipWriter.<init>(proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, proguard.util.StringMatcher, int, int, byte[], proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, int, proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, int, byte[], proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, proguard.util.StringMatcher, int, int, proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, proguard.util.StringMatcher, int, int, byte[], proguard.io.DataEntryWriter)"
  })
  void testNewZipWriter_whenAxaxaxaxBytesIsUtf83() throws UnsupportedEncodingException {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    EmptyStringMatcher extraUncompressedAlignmentFilter = new EmptyStringMatcher();
    byte[] header = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull(
        (new ZipWriter(
                uncompressedFilter,
                1,
                true,
                extraUncompressedAlignmentFilter,
                1,
                1,
                header,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))
            .currentZipOutput);
  }

  /**
   * Test {@link ZipWriter#ZipWriter(StringMatcher, int, boolean, int, DataEntryWriter)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ZipWriter#ZipWriter(StringMatcher, int, boolean, int,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName("Test new ZipWriter(StringMatcher, int, boolean, int, DataEntryWriter); when 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ZipWriter.<init>(proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, proguard.util.StringMatcher, int, int, byte[], proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, int, proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, int, byte[], proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, proguard.util.StringMatcher, int, int, proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, proguard.util.StringMatcher, int, int, byte[], proguard.io.DataEntryWriter)"
  })
  void testNewZipWriter_whenTrue() {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();

    // Act and Assert
    assertNull(
        (new ZipWriter(
                uncompressedFilter,
                1,
                true,
                1,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))
            .currentZipOutput);
  }

  /**
   * Test {@link ZipWriter#ZipWriter(StringMatcher, int, boolean, StringMatcher, int, int,
   * DataEntryWriter)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ZipWriter#ZipWriter(StringMatcher, int, boolean, StringMatcher,
   * int, int, DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new ZipWriter(StringMatcher, int, boolean, StringMatcher, int, int, DataEntryWriter); when 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ZipWriter.<init>(proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, proguard.util.StringMatcher, int, int, byte[], proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, int, proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, int, byte[], proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, proguard.util.StringMatcher, int, int, proguard.io.DataEntryWriter)",
    "void proguard.io.ZipWriter.<init>(proguard.util.StringMatcher, int, boolean, proguard.util.StringMatcher, int, int, byte[], proguard.io.DataEntryWriter)"
  })
  void testNewZipWriter_whenTrue2() {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    EmptyStringMatcher extraUncompressedAlignmentFilter = new EmptyStringMatcher();

    // Act and Assert
    assertNull(
        (new ZipWriter(
                uncompressedFilter,
                1,
                true,
                extraUncompressedAlignmentFilter,
                1,
                1,
                new DirectoryWriter(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())))
            .currentZipOutput);
  }

  /**
   * Test {@link ZipWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link ZipWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.ZipWriter.createDirectory(proguard.io.DataEntry)"})
  void testCreateDirectory() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    CascadingDataEntryWriter dataEntryWriter = mock(CascadingDataEntryWriter.class);
    when(dataEntryWriter.createOutputStream(Mockito.<DataEntry>any()))
        .thenReturn(new ByteArrayOutputStream(1));
    ZipWriter zipWriter = new ZipWriter(new EmptyStringMatcher(), 1, true, 1, dataEntryWriter);

    // Act
    boolean actualCreateDirectoryResult = zipWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryWriter).createOutputStream(isNull());
    ZipOutput zipOutput = zipWriter.currentZipOutput;
    LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(35, largeDataOutputStream.size());
    assertEquals(35L, zipOutput.size());
    assertEquals(35L, largeDataOutputStream.getLongSize());
    assertTrue(actualCreateDirectoryResult);
  }

  /**
   * Test {@link ZipWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link ZipWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.ZipWriter.createDirectory(proguard.io.DataEntry)"})
  void testCreateDirectory2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    CascadingDataEntryWriter dataEntryWriter = mock(CascadingDataEntryWriter.class);
    when(dataEntryWriter.createOutputStream(Mockito.<DataEntry>any()))
        .thenReturn(new ByteArrayOutputStream(1));
    ZipWriter zipWriter = new ZipWriter(new EmptyStringMatcher(), 47, true, 1, dataEntryWriter);

    // Act
    boolean actualCreateDirectoryResult = zipWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryWriter).createOutputStream(isNull());
    ZipOutput zipOutput = zipWriter.currentZipOutput;
    LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(47, largeDataOutputStream.size());
    assertEquals(47L, zipOutput.size());
    assertEquals(47L, largeDataOutputStream.getLongSize());
    assertTrue(actualCreateDirectoryResult);
  }

  /**
   * Test {@link ZipWriter#createDirectory(DataEntry)}.
   *
   * <p>Method under test: {@link ZipWriter#createDirectory(DataEntry)}
   */
  @Test
  @DisplayName("Test createDirectory(DataEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.io.ZipWriter.createDirectory(proguard.io.DataEntry)"})
  void testCreateDirectory3() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    CascadingDataEntryWriter dataEntryWriter = mock(CascadingDataEntryWriter.class);
    when(dataEntryWriter.createOutputStream(Mockito.<DataEntry>any()))
        .thenReturn(new ByteArrayOutputStream(1));
    ZipWriter zipWriter = new ZipWriter(new EmptyStringMatcher(), 1, false, 1, dataEntryWriter);

    // Act
    boolean actualCreateDirectoryResult = zipWriter.createDirectory(new ClassPathDataEntry("Name"));

    // Assert
    verify(dataEntryWriter).createOutputStream(isNull());
    ZipOutput zipOutput = zipWriter.currentZipOutput;
    LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(35, largeDataOutputStream.size());
    assertEquals(35L, zipOutput.size());
    assertEquals(35L, largeDataOutputStream.getLongSize());
    assertTrue(actualCreateDirectoryResult);
  }

  /**
   * Test {@link ZipWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ZipWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.ZipWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_thenReturnTrue() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    ZipWriter zipWriter =
        new ZipWriter(
            uncompressedFilter,
            1,
            true,
            1,
            new FixedFileWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(zipWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ZipWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ZipWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName(
      "Test sameOutputStream(DataEntry, DataEntry); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.ZipWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_whenJavaLangObject_thenReturnFalse() throws IOException {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    ZipWriter zipWriter =
        new ZipWriter(
            uncompressedFilter,
            1,
            true,
            1,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    Class<Object> clazz = Object.class;
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(clazz);

    // Act and Assert
    assertFalse(zipWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ZipWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ZipWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.ZipWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_whenNull_thenReturnFalse() throws IOException {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    ZipWriter zipWriter =
        new ZipWriter(
            uncompressedFilter,
            1,
            true,
            1,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertFalse(zipWriter.sameOutputStream(null, new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link ZipWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ZipWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @DisplayName("Test sameOutputStream(DataEntry, DataEntry); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.io.ZipWriter.sameOutputStream(proguard.io.DataEntry, proguard.io.DataEntry)"
  })
  void testSameOutputStream_whenNull_thenReturnFalse2() throws IOException {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    ZipWriter zipWriter =
        new ZipWriter(
            uncompressedFilter,
            1,
            true,
            1,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertFalse(zipWriter.sameOutputStream(new ClassPathDataEntry("Name"), null));
  }

  /**
   * Test {@link ZipWriter#createZipOutput(OutputStream, byte[], int, boolean, String)}.
   *
   * <p>Method under test: {@link ZipWriter#createZipOutput(OutputStream, byte[], int, boolean,
   * String)}
   */
  @Test
  @DisplayName("Test createZipOutput(OutputStream, byte[], int, boolean, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.ZipOutput proguard.io.ZipWriter.createZipOutput(java.io.OutputStream, byte[], int, boolean, java.lang.String)"
  })
  void testCreateZipOutput() throws IOException {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    ZipWriter zipWriter =
        new ZipWriter(
            uncompressedFilter,
            1,
            true,
            1,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    ZipOutput actualCreateZipOutputResult =
        zipWriter.createZipOutput(outputStream, "AXAXAXAX".getBytes("UTF-8"), 1, true, "Comment");

    // Assert
    LargeDataOutputStream largeDataOutputStream = actualCreateZipOutputResult.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualCreateZipOutputResult.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, outputStream.toByteArray());
  }

  /**
   * Test {@link ZipWriter#createZipOutput(OutputStream, byte[], int, boolean, String)}.
   *
   * <p>Method under test: {@link ZipWriter#createZipOutput(OutputStream, byte[], int, boolean,
   * String)}
   */
  @Test
  @DisplayName("Test createZipOutput(OutputStream, byte[], int, boolean, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.io.ZipOutput proguard.io.ZipWriter.createZipOutput(java.io.OutputStream, byte[], int, boolean, java.lang.String)"
  })
  void testCreateZipOutput2() throws IOException {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    ZipWriter zipWriter =
        new ZipWriter(
            uncompressedFilter,
            1,
            true,
            1,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    ZipOutput actualCreateZipOutputResult =
        zipWriter.createZipOutput(outputStream, null, 1, true, "Comment");

    // Assert
    LargeDataOutputStream largeDataOutputStream = actualCreateZipOutputResult.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualCreateZipOutputResult.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
    assertArrayEquals(new byte[] {}, outputStream.toByteArray());
  }
}
