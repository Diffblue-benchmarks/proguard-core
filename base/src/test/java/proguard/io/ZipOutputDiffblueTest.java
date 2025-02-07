package proguard.io;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ZipOutput$LargeDataOutputStream.<init>(java.io.OutputStream)",
    "long proguard.io.ZipOutput$LargeDataOutputStream.getLongSize()"
  })
  void testLargeDataOutputStreamGettersAndSetters() {
    // Arrange and Act
    LargeDataOutputStream actualLargeDataOutputStream =
        new LargeDataOutputStream(new ByteArrayOutputStream(1));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput$LargeDataOutputStream.write(byte[])"})
  void testLargeDataOutputStreamWriteWithByte() throws IOException {
    // Arrange
    LargeDataOutputStream largeDataOutputStream =
        new LargeDataOutputStream(new ByteArrayOutputStream(1));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput$LargeDataOutputStream.write(int)"})
  void testLargeDataOutputStreamWriteWithInt() throws IOException {
    // Arrange
    LargeDataOutputStream largeDataOutputStream =
        new LargeDataOutputStream(new ByteArrayOutputStream(1));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput.<init>(java.io.OutputStream)"})
  void testNewZipOutput() {
    // Arrange and Act
    ZipOutput actualZipOutput = new ZipOutput(new ByteArrayOutputStream(1));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput.<init>(java.io.OutputStream, int)"})
  void testNewZipOutput2() {
    // Arrange and Act
    ZipOutput actualZipOutput = new ZipOutput(new ByteArrayOutputStream(1), 1);

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ZipOutput.<init>(java.io.OutputStream, int, boolean, java.lang.String)"
  })
  void testNewZipOutput3() {
    // Arrange and Act
    ZipOutput actualZipOutput = new ZipOutput(new ByteArrayOutputStream(1), 1, true, "Comment");

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput.<init>(java.io.OutputStream, boolean)"})
  void testNewZipOutput4() {
    // Arrange and Act
    ZipOutput actualZipOutput = new ZipOutput(new ByteArrayOutputStream(1), true);

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput.<init>(java.io.OutputStream, boolean, int)"})
  void testNewZipOutput5() {
    // Arrange and Act
    ZipOutput actualZipOutput = new ZipOutput(new ByteArrayOutputStream(1), true, 1);

    // Assert
    LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
  }

  /**
   * Test {@link ZipOutput#ZipOutput(OutputStream, byte[], int, boolean)}.
   *
   * <p>Method under test: {@link ZipOutput#ZipOutput(OutputStream, byte[], int, boolean)}
   */
  @Test
  @DisplayName("Test new ZipOutput(OutputStream, byte[], int, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ZipOutput.<init>(java.io.OutputStream, byte[], int, boolean)"
  })
  void testNewZipOutput6() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

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
   * <p>Method under test: {@link ZipOutput#ZipOutput(OutputStream, byte[], int, boolean, String)}
   */
  @Test
  @DisplayName("Test new ZipOutput(OutputStream, byte[], int, boolean, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ZipOutput.<init>(java.io.OutputStream, byte[], int, boolean, java.lang.String)"
  })
  void testNewZipOutput7() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

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
   *   <li>Then {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with one toByteArray is
   *       empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ZipOutput#ZipOutput(OutputStream, byte[], int, boolean)}
   */
  @Test
  @DisplayName(
      "Test new ZipOutput(OutputStream, byte[], int, boolean); then ByteArrayOutputStream(int) with one toByteArray is empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ZipOutput.<init>(java.io.OutputStream, byte[], int, boolean)"
  })
  void testNewZipOutput_thenByteArrayOutputStreamWithOneToByteArrayIsEmptyArrayOfByte()
      throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

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
   *   <li>Then {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with one toByteArray is
   *       empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link ZipOutput#ZipOutput(OutputStream, byte[], int, boolean, String)}
   */
  @Test
  @DisplayName(
      "Test new ZipOutput(OutputStream, byte[], int, boolean, String); then ByteArrayOutputStream(int) with one toByteArray is empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ZipOutput.<init>(java.io.OutputStream, byte[], int, boolean, java.lang.String)"
  })
  void testNewZipOutput_thenByteArrayOutputStreamWithOneToByteArrayIsEmptyArrayOfByte2()
      throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput.close()"})
  void testClose() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(101010256), true);

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput.close(long)"})
  void testCloseWithLong() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput.close(long)"})
  void testCloseWithLong2() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(101010256), true);

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
   *       ByteArrayOutputStream#ByteArrayOutputStream(int)} {@link ZipOutput#outputStream} is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ZipOutput#close()}
   */
  @Test
  @DisplayName(
      "Test close(); then ZipOutput(OutputStream) with outputStream is ByteArrayOutputStream(int) outputStream is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput.close()"})
  void testClose_thenZipOutputWithOutputStreamIsByteArrayOutputStreamOutputStreamIsNull()
      throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long proguard.io.ZipOutput.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ZipOutput(new ByteArrayOutputStream(1))).size());
  }

  /**
   * Test {@link ZipOutput#writeStartOfCentralDirectory()}.
   *
   * <p>Method under test: {@link ZipOutput#writeStartOfCentralDirectory()}
   */
  @Test
  @DisplayName("Test writeStartOfCentralDirectory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long proguard.io.ZipOutput.writeStartOfCentralDirectory()"})
  void testWriteStartOfCentralDirectory() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ZipOutput(new ByteArrayOutputStream(1))).writeStartOfCentralDirectory());
  }

  /**
   * Test {@link ZipOutput#writeEntriesOfCentralDirectory()}.
   *
   * <p>Method under test: {@link ZipOutput#writeEntriesOfCentralDirectory()}
   */
  @Test
  @DisplayName("Test writeEntriesOfCentralDirectory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long proguard.io.ZipOutput.writeEntriesOfCentralDirectory()"})
  void testWriteEntriesOfCentralDirectory() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        0L, (new ZipOutput(new ByteArrayOutputStream(1))).writeEntriesOfCentralDirectory());
  }

  /**
   * Test {@link ZipOutput#writeEndOfCentralDirectory(long, long)}.
   *
   * <p>Method under test: {@link ZipOutput#writeEndOfCentralDirectory(long, long)}
   */
  @Test
  @DisplayName("Test writeEndOfCentralDirectory(long, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput.writeEndOfCentralDirectory(long, long)"})
  void testWriteEndOfCentralDirectory() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput.writeEndOfCentralDirectory(long, long)"})
  void testWriteEndOfCentralDirectory2() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(101010256), true);

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput.writeZip64EndOfCentralDirectory(long, long)"})
  void testWriteZip64EndOfCentralDirectory() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput.writeZip64EndOfCentralDirectoryLocator(long)"})
  void testWriteZip64EndOfCentralDirectoryLocator() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput.writeShort(int)"})
  void testWriteShort() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput.writeInt(int)"})
  void testWriteIntWithInt() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput.writeInt(long)"})
  void testWriteIntWithLong() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ZipOutput.writeLong(long)"})
  void testWriteLong() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

    // Act
    zipOutput.writeLong(42L);

    // Assert
    LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(8, largeDataOutputStream.size());
    assertEquals(8L, zipOutput.size());
    assertEquals(8L, largeDataOutputStream.getLongSize());
  }
}
