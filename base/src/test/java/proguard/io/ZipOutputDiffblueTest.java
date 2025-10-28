package proguard.io;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.Test;

public class ZipOutputDiffblueTest {
  /**
   * Method under test: {@link ZipOutput#close()}
   */
  @Test
  public void testClose() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

    // Act
    zipOutput.close();

    // Assert
    assertNull(zipOutput.outputStream);
  }

  /**
   * Method under test: {@link ZipOutput#close()}
   */
  @Test
  public void testClose2() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(101010256), true);

    // Act
    zipOutput.close();

    // Assert
    assertNull(zipOutput.outputStream);
  }

  /**
   * Method under test: {@link ZipOutput#close(long)}
   */
  @Test
  public void testClose3() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

    // Act
    zipOutput.close(1L);

    // Assert
    assertNull(zipOutput.outputStream);
  }

  /**
   * Method under test: {@link ZipOutput#close(long)}
   */
  @Test
  public void testClose4() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(101010256), true);

    // Act
    zipOutput.close(1L);

    // Assert
    assertNull(zipOutput.outputStream);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ZipOutput.LargeDataOutputStream#LargeDataOutputStream(OutputStream)}
   *   <li>{@link ZipOutput.LargeDataOutputStream#getLongSize()}
   * </ul>
   */
  @Test
  public void testLargeDataOutputStreamGettersAndSetters() {
    // Arrange and Act
    ZipOutput.LargeDataOutputStream actualLargeDataOutputStream = new ZipOutput.LargeDataOutputStream(
        new ByteArrayOutputStream(1));
    long actualLongSize = actualLargeDataOutputStream.getLongSize();

    // Assert
    assertEquals(0, actualLargeDataOutputStream.size());
    assertEquals(0L, actualLongSize);
  }

  /**
   * Method under test: {@link ZipOutput.LargeDataOutputStream#write(int)}
   */
  @Test
  public void testLargeDataOutputStreamWrite() throws IOException {
    // Arrange
    ZipOutput.LargeDataOutputStream largeDataOutputStream = new ZipOutput.LargeDataOutputStream(
        new ByteArrayOutputStream(1));

    // Act
    largeDataOutputStream.write(19088743);

    // Assert
    assertEquals(1, largeDataOutputStream.size());
    assertEquals(1L, largeDataOutputStream.getLongSize());
  }

  /**
   * Method under test: {@link ZipOutput.LargeDataOutputStream#write(byte[])}
   */
  @Test
  public void testLargeDataOutputStreamWrite2() throws IOException {
    // Arrange
    ZipOutput.LargeDataOutputStream largeDataOutputStream = new ZipOutput.LargeDataOutputStream(
        new ByteArrayOutputStream(1));

    // Act
    largeDataOutputStream.write("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8, largeDataOutputStream.size());
    assertEquals(8L, largeDataOutputStream.getLongSize());
  }

  /**
   * Method under test: {@link ZipOutput#size()}
   */
  @Test
  public void testSize() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ZipOutput(new ByteArrayOutputStream(1))).size());
  }

  /**
   * Method under test: {@link ZipOutput#writeStartOfCentralDirectory()}
   */
  @Test
  public void testWriteStartOfCentralDirectory() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ZipOutput(new ByteArrayOutputStream(1))).writeStartOfCentralDirectory());
  }

  /**
   * Method under test: {@link ZipOutput#writeEntriesOfCentralDirectory()}
   */
  @Test
  public void testWriteEntriesOfCentralDirectory() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L, (new ZipOutput(new ByteArrayOutputStream(1))).writeEntriesOfCentralDirectory());
  }

  /**
   * Method under test: {@link ZipOutput#writeEndOfCentralDirectory(long, long)}
   */
  @Test
  public void testWriteEndOfCentralDirectory() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

    // Act
    zipOutput.writeEndOfCentralDirectory(81985529216486895L, 3L);

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(22, largeDataOutputStream.size());
    assertEquals(22L, zipOutput.size());
    assertEquals(22L, largeDataOutputStream.getLongSize());
  }

  /**
   * Method under test: {@link ZipOutput#writeEndOfCentralDirectory(long, long)}
   */
  @Test
  public void testWriteEndOfCentralDirectory2() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(101010256), true);

    // Act
    zipOutput.writeEndOfCentralDirectory(81985529216486895L, 3L);

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(22, largeDataOutputStream.size());
    assertEquals(22L, zipOutput.size());
    assertEquals(22L, largeDataOutputStream.getLongSize());
  }

  /**
   * Method under test:
   * {@link ZipOutput#writeZip64EndOfCentralDirectory(long, long)}
   */
  @Test
  public void testWriteZip64EndOfCentralDirectory() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

    // Act
    zipOutput.writeZip64EndOfCentralDirectory(81985529216486895L, 3L);

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(56, largeDataOutputStream.size());
    assertEquals(56L, zipOutput.size());
    assertEquals(56L, largeDataOutputStream.getLongSize());
  }

  /**
   * Method under test:
   * {@link ZipOutput#writeZip64EndOfCentralDirectoryLocator(long)}
   */
  @Test
  public void testWriteZip64EndOfCentralDirectoryLocator() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

    // Act
    zipOutput.writeZip64EndOfCentralDirectoryLocator(81985529216486895L);

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(20, largeDataOutputStream.size());
    assertEquals(20L, zipOutput.size());
    assertEquals(20L, largeDataOutputStream.getLongSize());
  }

  /**
   * Method under test: {@link ZipOutput#writeShort(int)}
   */
  @Test
  public void testWriteShort() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

    // Act
    zipOutput.writeShort(42);

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(2, largeDataOutputStream.size());
    assertEquals(2L, zipOutput.size());
    assertEquals(2L, largeDataOutputStream.getLongSize());
  }

  /**
   * Method under test: {@link ZipOutput#writeInt(int)}
   */
  @Test
  public void testWriteInt() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

    // Act
    zipOutput.writeInt(42);

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(4, largeDataOutputStream.size());
    assertEquals(4L, zipOutput.size());
    assertEquals(4L, largeDataOutputStream.getLongSize());
  }

  /**
   * Method under test: {@link ZipOutput#writeInt(long)}
   */
  @Test
  public void testWriteInt2() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

    // Act
    zipOutput.writeInt(42L);

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(4, largeDataOutputStream.size());
    assertEquals(4L, zipOutput.size());
    assertEquals(4L, largeDataOutputStream.getLongSize());
  }

  /**
   * Method under test: {@link ZipOutput#writeLong(long)}
   */
  @Test
  public void testWriteLong() throws IOException {
    // Arrange
    ZipOutput zipOutput = new ZipOutput(new ByteArrayOutputStream(1));

    // Act
    zipOutput.writeLong(42L);

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = zipOutput.outputStream;
    assertEquals(8, largeDataOutputStream.size());
    assertEquals(8L, zipOutput.size());
    assertEquals(8L, largeDataOutputStream.getLongSize());
  }

  /**
   * Method under test: {@link ZipOutput#ZipOutput(OutputStream)}
   */
  @Test
  public void testNewZipOutput() {
    // Arrange and Act
    ZipOutput actualZipOutput = new ZipOutput(new ByteArrayOutputStream(1));

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
  }

  /**
   * Method under test: {@link ZipOutput#ZipOutput(OutputStream, int)}
   */
  @Test
  public void testNewZipOutput2() {
    // Arrange and Act
    ZipOutput actualZipOutput = new ZipOutput(new ByteArrayOutputStream(1), 1);

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
  }

  /**
   * Method under test:
   * {@link ZipOutput#ZipOutput(OutputStream, int, boolean, String)}
   */
  @Test
  public void testNewZipOutput3() {
    // Arrange and Act
    ZipOutput actualZipOutput = new ZipOutput(new ByteArrayOutputStream(1), 1, true, "Comment");

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
  }

  /**
   * Method under test: {@link ZipOutput#ZipOutput(OutputStream, boolean)}
   */
  @Test
  public void testNewZipOutput4() {
    // Arrange and Act
    ZipOutput actualZipOutput = new ZipOutput(new ByteArrayOutputStream(1), true);

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
  }

  /**
   * Method under test: {@link ZipOutput#ZipOutput(OutputStream, boolean, int)}
   */
  @Test
  public void testNewZipOutput5() {
    // Arrange and Act
    ZipOutput actualZipOutput = new ZipOutput(new ByteArrayOutputStream(1), true, 1);

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
  }

  /**
   * Method under test:
   * {@link ZipOutput#ZipOutput(OutputStream, byte[], int, boolean)}
   */
  @Test
  public void testNewZipOutput6() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    ZipOutput actualZipOutput = new ZipOutput(outputStream, "AXAXAXAX".getBytes("UTF-8"), 1, true);

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, outputStream.toByteArray());
  }

  /**
   * Method under test:
   * {@link ZipOutput#ZipOutput(OutputStream, byte[], int, boolean)}
   */
  @Test
  public void testNewZipOutput7() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    ZipOutput actualZipOutput = new ZipOutput(outputStream, null, 1, true);

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0, outputStream.toByteArray().length);
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
  }

  /**
   * Method under test:
   * {@link ZipOutput#ZipOutput(OutputStream, byte[], int, boolean, String)}
   */
  @Test
  public void testNewZipOutput8() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    ZipOutput actualZipOutput = new ZipOutput(outputStream, "AXAXAXAX".getBytes("UTF-8"), 1, true, "Comment");

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, outputStream.toByteArray());
  }

  /**
   * Method under test:
   * {@link ZipOutput#ZipOutput(OutputStream, byte[], int, boolean, String)}
   */
  @Test
  public void testNewZipOutput9() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    ZipOutput actualZipOutput = new ZipOutput(outputStream, null, 1, true, "Comment");

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = actualZipOutput.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0, outputStream.toByteArray().length);
    assertEquals(0L, actualZipOutput.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
  }
}
