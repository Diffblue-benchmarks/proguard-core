package proguard.io;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.io.ZipOutput.LargeDataOutputStream;

public class ZipOutputDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LargeDataOutputStream.<init>(OutputStream)",
    "long LargeDataOutputStream.getLongSize()"
  })
  public void testLargeDataOutputStreamGettersAndSetters() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LargeDataOutputStream.write(byte[])"})
  public void testLargeDataOutputStreamWriteWithByte() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LargeDataOutputStream.write(int)"})
  public void testLargeDataOutputStreamWriteWithInt() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream)"})
  public void testNewZipOutput() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream, int)"})
  public void testNewZipOutput2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream, int, boolean, String)"})
  public void testNewZipOutput3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream, boolean)"})
  public void testNewZipOutput4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream, boolean, int)"})
  public void testNewZipOutput5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream, byte[], int, boolean)"})
  public void testNewZipOutput6() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream, byte[], int, boolean, String)"})
  public void testNewZipOutput7() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream, byte[], int, boolean)"})
  public void testNewZipOutput_thenByteArrayOutputStreamWithOneToByteArrayIsEmptyArrayOfByte()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.<init>(OutputStream, byte[], int, boolean, String)"})
  public void testNewZipOutput_thenByteArrayOutputStreamWithOneToByteArrayIsEmptyArrayOfByte2()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.close()"})
  public void testClose() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.close(long)"})
  public void testCloseWithLong() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.close(long)"})
  public void testCloseWithLong2() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.close()"})
  public void testClose_thenZipOutputWithOutputStreamIsByteArrayOutputStreamOutputStreamIsNull()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ZipOutput.size()"})
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ZipOutput(new ByteArrayOutputStream(1))).size());
  }

  /**
   * Test {@link ZipOutput#writeStartOfCentralDirectory()}.
   *
   * <p>Method under test: {@link ZipOutput#writeStartOfCentralDirectory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ZipOutput.writeStartOfCentralDirectory()"})
  public void testWriteStartOfCentralDirectory() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ZipOutput(new ByteArrayOutputStream(1))).writeStartOfCentralDirectory());
  }

  /**
   * Test {@link ZipOutput#writeEntriesOfCentralDirectory()}.
   *
   * <p>Method under test: {@link ZipOutput#writeEntriesOfCentralDirectory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long ZipOutput.writeEntriesOfCentralDirectory()"})
  public void testWriteEntriesOfCentralDirectory() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.writeEndOfCentralDirectory(long, long)"})
  public void testWriteEndOfCentralDirectory() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.writeEndOfCentralDirectory(long, long)"})
  public void testWriteEndOfCentralDirectory2() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.writeZip64EndOfCentralDirectory(long, long)"})
  public void testWriteZip64EndOfCentralDirectory() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.writeZip64EndOfCentralDirectoryLocator(long)"})
  public void testWriteZip64EndOfCentralDirectoryLocator() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.writeShort(int)"})
  public void testWriteShort() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.writeInt(int)"})
  public void testWriteIntWithInt() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.writeInt(long)"})
  public void testWriteIntWithLong() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ZipOutput.writeLong(long)"})
  public void testWriteLong() throws IOException {
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
