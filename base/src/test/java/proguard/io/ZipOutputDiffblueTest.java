package proguard.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.io.ZipOutput.LargeDataOutputStream;

class ZipOutputDiffblueTest {
  /**
   * Test LargeDataOutputStream getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LargeDataOutputStream#LargeDataOutputStream(OutputStream)}
   *   <li>{@link LargeDataOutputStream#getLongSize()}
   * </ul>
   */
  @Test
  @DisplayName("Test LargeDataOutputStream getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LargeDataOutputStream.<init>(OutputStream)",
    "long LargeDataOutputStream.getLongSize()"
  })
  void testLargeDataOutputStreamGettersAndSetters() {
    // Arrange and Act
    LargeDataOutputStream actualLargeDataOutputStream =
        new LargeDataOutputStream(new ByteArrayOutputStream());
    long actualLongSize = actualLargeDataOutputStream.getLongSize();

    // Assert
    assertEquals(0, actualLargeDataOutputStream.size());
    assertEquals(0L, actualLongSize);
  }

  /**
   * Test LargeDataOutputStream {@link LargeDataOutputStream#write(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link LargeDataOutputStream#write(byte[])}
   */
  @Test
  @DisplayName("Test LargeDataOutputStream write(byte[]) with 'byte[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LargeDataOutputStream.write(byte[])"})
  void testLargeDataOutputStreamWriteWithByte() throws IOException {
    // Arrange
    LargeDataOutputStream largeDataOutputStream =
        new LargeDataOutputStream(new ByteArrayOutputStream());

    // Act
    largeDataOutputStream.write("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8, largeDataOutputStream.size());
    assertEquals(8L, largeDataOutputStream.getLongSize());
  }

  /**
   * Test LargeDataOutputStream {@link LargeDataOutputStream#write(int)} with {@code int}.
   *
   * <p>Method under test: {@link LargeDataOutputStream#write(int)}
   */
  @Test
  @DisplayName("Test LargeDataOutputStream write(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LargeDataOutputStream.write(int)"})
  void testLargeDataOutputStreamWriteWithInt() throws IOException {
    // Arrange
    LargeDataOutputStream largeDataOutputStream =
        new LargeDataOutputStream(new ByteArrayOutputStream());

    // Act
    largeDataOutputStream.write(19088743);

    // Assert
    assertEquals(1, largeDataOutputStream.size());
    assertEquals(1L, largeDataOutputStream.getLongSize());
  }

  /**
   * Test {@link ZipOutput#ZipOutput(OutputStream)}.
   *
   * <p>Method under test: {@link ZipOutput#ZipOutput(OutputStream)}
   */
  @Test
  @DisplayName("Test new ZipOutput(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream)"})
  void testNewZipOutput() {
    // Arrange and Act
    ZipOutput actualZipOutput = new ZipOutput(new ByteArrayOutputStream());

    // Assert
    LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
  }

  /**
   * Test {@link ZipOutput#ZipOutput(OutputStream, int)}.
   *
   * <p>Method under test: {@link ZipOutput#ZipOutput(OutputStream, int)}
   */
  @Test
  @DisplayName("Test new ZipOutput(OutputStream, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream, int)"})
  void testNewZipOutput2() {
    // Arrange and Act
    ZipOutput actualZipOutput = new ZipOutput(new ByteArrayOutputStream(), 1);

    // Assert
    LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
  }

  /**
   * Test {@link ZipOutput#ZipOutput(OutputStream, int, boolean, String)}.
   *
   * <p>Method under test: {@link ZipOutput#ZipOutput(OutputStream, int, boolean, String)}
   */
  @Test
  @DisplayName("Test new ZipOutput(OutputStream, int, boolean, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream, int, boolean, String)"})
  void testNewZipOutput3() {
    // Arrange and Act
    ZipOutput actualZipOutput = new ZipOutput(new ByteArrayOutputStream(), 1, true, "Comment");

    // Assert
    LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
  }

  /**
   * Test {@link ZipOutput#ZipOutput(OutputStream, boolean)}.
   *
   * <p>Method under test: {@link ZipOutput#ZipOutput(OutputStream, boolean)}
   */
  @Test
  @DisplayName("Test new ZipOutput(OutputStream, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream, boolean)"})
  void testNewZipOutput4() {
    // Arrange and Act
    ZipOutput actualZipOutput = new ZipOutput(new ByteArrayOutputStream(), true);

    // Assert
    LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
  }

  /**
   * Test {@link ZipOutput#ZipOutput(OutputStream, boolean, int)}.
   *
   * <p>Method under test: {@link ZipOutput#ZipOutput(OutputStream, boolean, int)}
   */
  @Test
  @DisplayName("Test new ZipOutput(OutputStream, boolean, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream, boolean, int)"})
  void testNewZipOutput5() {
    // Arrange and Act
    ZipOutput actualZipOutput = new ZipOutput(new ByteArrayOutputStream(), true, 1);

    // Assert
    LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
  }

  /**
   * Test {@link ZipOutput#ZipOutput(OutputStream, byte[], int, boolean)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayOutputStream#ByteArrayOutputStream()} toByteArray is {@code
   *       AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ZipOutput#ZipOutput(OutputStream, byte[], int, boolean)}
   */
  @Test
  @DisplayName(
      "Test new ZipOutput(OutputStream, byte[], int, boolean); then ByteArrayOutputStream() toByteArray is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream, byte[], int, boolean)"})
  void testNewZipOutput_thenByteArrayOutputStreamToByteArrayIsAxaxaxaxBytesIsUtf8()
      throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    // Act
    ZipOutput actualZipOutput = new ZipOutput(outputStream, "AXAXAXAX".getBytes("UTF-8"), 1, true);

    // Assert
    LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, outputStream.toByteArray());
  }

  /**
   * Test {@link ZipOutput#ZipOutput(OutputStream, byte[], int, boolean, String)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayOutputStream#ByteArrayOutputStream()} toByteArray is {@code
   *       AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ZipOutput#ZipOutput(OutputStream, byte[], int, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test new ZipOutput(OutputStream, byte[], int, boolean, String); then ByteArrayOutputStream() toByteArray is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream, byte[], int, boolean, String)"})
  void testNewZipOutput_thenByteArrayOutputStreamToByteArrayIsAxaxaxaxBytesIsUtf82()
      throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    // Act
    ZipOutput actualZipOutput =
        new ZipOutput(outputStream, "AXAXAXAX".getBytes("UTF-8"), 1, true, "Comment");

    // Assert
    LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, outputStream.toByteArray());
  }

  /**
   * Test {@link ZipOutput#ZipOutput(OutputStream, byte[], int, boolean)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayOutputStream#ByteArrayOutputStream()} toByteArray is empty array of
   *       {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ZipOutput#ZipOutput(OutputStream, byte[], int, boolean)}
   */
  @Test
  @DisplayName(
      "Test new ZipOutput(OutputStream, byte[], int, boolean); then ByteArrayOutputStream() toByteArray is empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream, byte[], int, boolean)"})
  void testNewZipOutput_thenByteArrayOutputStreamToByteArrayIsEmptyArrayOfByte()
      throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    // Act
    ZipOutput actualZipOutput = new ZipOutput(outputStream, null, 1, true);

    // Assert
    LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
    assertArrayEquals(new byte[] {}, outputStream.toByteArray());
  }

  /**
   * Test {@link ZipOutput#ZipOutput(OutputStream, byte[], int, boolean, String)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayOutputStream#ByteArrayOutputStream()} toByteArray is empty array of
   *       {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ZipOutput#ZipOutput(OutputStream, byte[], int, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test new ZipOutput(OutputStream, byte[], int, boolean, String); then ByteArrayOutputStream() toByteArray is empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream, byte[], int, boolean, String)"})
  void testNewZipOutput_thenByteArrayOutputStreamToByteArrayIsEmptyArrayOfByte2()
      throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    // Act
    ZipOutput actualZipOutput = new ZipOutput(outputStream, null, 1, true, "Comment");

    // Assert
    LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
    assertArrayEquals(new byte[] {}, outputStream.toByteArray());
  }

  /**
   * Test {@link ZipOutput#close()}.
   *
   * <p>Method under test: {@link ZipOutput#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.close()"})
  void testClose() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(), true);

    // Act
    zipOutput.close();

    // Assert
    assertNull(zipOutput.outputStream);
  }

  /**
   * Test {@link ZipOutput#close(long)} with {@code long}.
   *
   * <p>Method under test: {@link ZipOutput#close(long)}
   */
  @Test
  @DisplayName("Test close(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.close(long)"})
  void testCloseWithLong() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream());

    // Act
    zipOutput.close(1L);

    // Assert
    assertNull(zipOutput.outputStream);
  }

  /**
   * Test {@link ZipOutput#close(long)} with {@code long}.
   *
   * <p>Method under test: {@link ZipOutput#close(long)}
   */
  @Test
  @DisplayName("Test close(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.close(long)"})
  void testCloseWithLong2() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(), true);

    // Act
    zipOutput.close(1L);

    // Assert
    assertNull(zipOutput.outputStream);
  }

  /**
   * Test {@link ZipOutput#close()}.
   *
   * <ul>
   *   <li>Then {@link ZipOutput#ZipOutput(OutputStream)} with outputStream is {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()} {@link ZipOutput#outputStream} is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ZipOutput#close()}
   */
  @Test
  @DisplayName(
      "Test close(); then ZipOutput(OutputStream) with outputStream is ByteArrayOutputStream() outputStream is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.close()"})
  void testClose_thenZipOutputWithOutputStreamIsByteArrayOutputStreamOutputStreamIsNull()
      throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream());

    // Act
    zipOutput.close();

    // Assert
    assertNull(zipOutput.outputStream);
  }

  /**
   * Test {@link ZipOutput#size()}.
   *
   * <p>Method under test: {@link ZipOutput#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ZipOutput.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0L, new ZipOutput(new ByteArrayOutputStream()).size());
  }

  /**
   * Test {@link ZipOutput#writeStartOfCentralDirectory()}.
   *
   * <p>Method under test: {@link ZipOutput#writeStartOfCentralDirectory()}
   */
  @Test
  @DisplayName("Test writeStartOfCentralDirectory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ZipOutput.writeStartOfCentralDirectory()"})
  void testWriteStartOfCentralDirectory() {
    // Arrange, Act and Assert
    assertEquals(0L, new ZipOutput(new ByteArrayOutputStream()).writeStartOfCentralDirectory());
  }

  /**
   * Test {@link ZipOutput#writeEntriesOfCentralDirectory()}.
   *
   * <p>Method under test: {@link ZipOutput#writeEntriesOfCentralDirectory()}
   */
  @Test
  @DisplayName("Test writeEntriesOfCentralDirectory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ZipOutput.writeEntriesOfCentralDirectory()"})
  void testWriteEntriesOfCentralDirectory() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, new ZipOutput(new ByteArrayOutputStream()).writeEntriesOfCentralDirectory());
  }

  /**
   * Test {@link ZipOutput#writeEndOfCentralDirectory(long, long)}.
   *
   * <p>Method under test: {@link ZipOutput#writeEndOfCentralDirectory(long, long)}
   */
  @Test
  @DisplayName("Test writeEndOfCentralDirectory(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.writeEndOfCentralDirectory(long, long)"})
  void testWriteEndOfCentralDirectory() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream());

    // Act
    zipOutput.writeEndOfCentralDirectory(81985529216486895L, 3L);

    // Assert
    LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(22, largeDataOutputStream.size());
    assertEquals(22L, zipOutput.size());
    assertEquals(22L, largeDataOutputStream.getLongSize());
  }

  /**
   * Test {@link ZipOutput#writeEndOfCentralDirectory(long, long)}.
   *
   * <p>Method under test: {@link ZipOutput#writeEndOfCentralDirectory(long, long)}
   */
  @Test
  @DisplayName("Test writeEndOfCentralDirectory(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.writeEndOfCentralDirectory(long, long)"})
  void testWriteEndOfCentralDirectory2() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(), true);

    // Act
    zipOutput.writeEndOfCentralDirectory(81985529216486895L, 3L);

    // Assert
    LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(22, largeDataOutputStream.size());
    assertEquals(22L, zipOutput.size());
    assertEquals(22L, largeDataOutputStream.getLongSize());
  }

  /**
   * Test {@link ZipOutput#writeZip64EndOfCentralDirectory(long, long)}.
   *
   * <p>Method under test: {@link ZipOutput#writeZip64EndOfCentralDirectory(long, long)}
   */
  @Test
  @DisplayName("Test writeZip64EndOfCentralDirectory(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.writeZip64EndOfCentralDirectory(long, long)"})
  void testWriteZip64EndOfCentralDirectory() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream());

    // Act
    zipOutput.writeZip64EndOfCentralDirectory(81985529216486895L, 3L);

    // Assert
    LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(56, largeDataOutputStream.size());
    assertEquals(56L, zipOutput.size());
    assertEquals(56L, largeDataOutputStream.getLongSize());
  }

  /**
   * Test {@link ZipOutput#writeZip64EndOfCentralDirectoryLocator(long)}.
   *
   * <p>Method under test: {@link ZipOutput#writeZip64EndOfCentralDirectoryLocator(long)}
   */
  @Test
  @DisplayName("Test writeZip64EndOfCentralDirectoryLocator(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.writeZip64EndOfCentralDirectoryLocator(long)"})
  void testWriteZip64EndOfCentralDirectoryLocator() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream());

    // Act
    zipOutput.writeZip64EndOfCentralDirectoryLocator(81985529216486895L);

    // Assert
    LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(20, largeDataOutputStream.size());
    assertEquals(20L, zipOutput.size());
    assertEquals(20L, largeDataOutputStream.getLongSize());
  }

  /**
   * Test {@link ZipOutput#writeShort(int)}.
   *
   * <p>Method under test: {@link ZipOutput#writeShort(int)}
   */
  @Test
  @DisplayName("Test writeShort(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.writeShort(int)"})
  void testWriteShort() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream());

    // Act
    zipOutput.writeShort(42);

    // Assert
    LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(2, largeDataOutputStream.size());
    assertEquals(2L, zipOutput.size());
    assertEquals(2L, largeDataOutputStream.getLongSize());
  }

  /**
   * Test {@link ZipOutput#writeInt(int)} with {@code int}.
   *
   * <p>Method under test: {@link ZipOutput#writeInt(int)}
   */
  @Test
  @DisplayName("Test writeInt(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.writeInt(int)"})
  void testWriteIntWithInt() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream());

    // Act
    zipOutput.writeInt(42);

    // Assert
    LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(4, largeDataOutputStream.size());
    assertEquals(4L, zipOutput.size());
    assertEquals(4L, largeDataOutputStream.getLongSize());
  }

  /**
   * Test {@link ZipOutput#writeInt(long)} with {@code long}.
   *
   * <p>Method under test: {@link ZipOutput#writeInt(long)}
   */
  @Test
  @DisplayName("Test writeInt(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.writeInt(long)"})
  void testWriteIntWithLong() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream());

    // Act
    zipOutput.writeInt(42L);

    // Assert
    LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(4, largeDataOutputStream.size());
    assertEquals(4L, zipOutput.size());
    assertEquals(4L, largeDataOutputStream.getLongSize());
  }

  /**
   * Test {@link ZipOutput#writeLong(long)}.
   *
   * <p>Method under test: {@link ZipOutput#writeLong(long)}
   */
  @Test
  @DisplayName("Test writeLong(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ZipOutput.writeLong(long)"})
  void testWriteLong() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream());

    // Act
    zipOutput.writeLong(42L);

    // Assert
    LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(8, largeDataOutputStream.size());
    assertEquals(8L, zipOutput.size());
    assertEquals(8L, largeDataOutputStream.getLongSize());
  }
}
