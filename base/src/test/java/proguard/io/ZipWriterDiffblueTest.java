package proguard.io;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import org.junit.Test;
import proguard.util.EmptyStringMatcher;
import proguard.util.StringMatcher;

public class ZipWriterDiffblueTest {
  /**
   * Method under test: {@link ZipWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    ZipWriter zipWriter = new ZipWriter(uncompressedFilter, 1, true, 1,
        new FixedFileWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry("Name");

    // Act and Assert
    assertTrue(zipWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link ZipWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream2() throws IOException {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    ZipWriter zipWriter = new ZipWriter(uncompressedFilter, 1, true, 1,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertFalse(zipWriter.sameOutputStream(null, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link ZipWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream3() throws IOException {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    ZipWriter zipWriter = new ZipWriter(uncompressedFilter, 1, true, 1,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    Class<Object> clazz = Object.class;
    ClassPathDataEntry dataEntry1 = new ClassPathDataEntry(clazz);

    // Act and Assert
    assertFalse(zipWriter.sameOutputStream(dataEntry1, new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link ZipWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  public void testSameOutputStream4() throws IOException {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    ZipWriter zipWriter = new ZipWriter(uncompressedFilter, 1, true, 1,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act and Assert
    assertFalse(zipWriter.sameOutputStream(new ClassPathDataEntry("Name"), null));
  }

  /**
   * Method under test:
   * {@link ZipWriter#createZipOutput(OutputStream, byte[], int, boolean, String)}
   */
  @Test
  public void testCreateZipOutput() throws IOException {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    ZipWriter zipWriter = new ZipWriter(uncompressedFilter, 1, true, 1,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    ZipOutput actualCreateZipOutputResult = zipWriter.createZipOutput(outputStream, "AXAXAXAX".getBytes("UTF-8"), 1,
        true, "Comment");

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = actualCreateZipOutputResult.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0L, actualCreateZipOutputResult.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, outputStream.toByteArray());
  }

  /**
   * Method under test:
   * {@link ZipWriter#createZipOutput(OutputStream, byte[], int, boolean, String)}
   */
  @Test
  public void testCreateZipOutput2() throws IOException {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    ZipWriter zipWriter = new ZipWriter(uncompressedFilter, 1, true, 1,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    ZipOutput actualCreateZipOutputResult = zipWriter.createZipOutput(outputStream, null, 1, true, "Comment");

    // Assert
    ZipOutput.LargeDataOutputStream largeDataOutputStream = actualCreateZipOutputResult.outputStream;
    assertEquals(0, largeDataOutputStream.size());
    assertEquals(0, outputStream.toByteArray().length);
    assertEquals(0L, actualCreateZipOutputResult.size());
    assertEquals(0L, largeDataOutputStream.getLongSize());
  }

  /**
   * Method under test: {@link ZipWriter#ZipWriter(DataEntryWriter)}
   */
  @Test
  public void testNewZipWriter() {
    // Arrange, Act and Assert
    assertNull((new ZipWriter(
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))).currentZipOutput);
  }

  /**
   * Method under test:
   * {@link ZipWriter#ZipWriter(StringMatcher, int, StringMatcher, int, int, byte[], DataEntryWriter)}
   */
  @Test
  public void testNewZipWriter2() throws UnsupportedEncodingException {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    EmptyStringMatcher extraUncompressedAlignmentFilter = new EmptyStringMatcher();
    byte[] header = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull((new ZipWriter(uncompressedFilter, 1, extraUncompressedAlignmentFilter, 1, 1, header,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))).currentZipOutput);
  }

  /**
   * Method under test:
   * {@link ZipWriter#ZipWriter(StringMatcher, int, boolean, int, DataEntryWriter)}
   */
  @Test
  public void testNewZipWriter3() {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();

    // Act and Assert
    assertNull((new ZipWriter(uncompressedFilter, 1, true, 1,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))).currentZipOutput);
  }

  /**
   * Method under test:
   * {@link ZipWriter#ZipWriter(StringMatcher, int, boolean, int, byte[], DataEntryWriter)}
   */
  @Test
  public void testNewZipWriter4() throws UnsupportedEncodingException {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    byte[] header = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull((new ZipWriter(uncompressedFilter, 1, true, 1, header,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))).currentZipOutput);
  }

  /**
   * Method under test:
   * {@link ZipWriter#ZipWriter(StringMatcher, int, boolean, StringMatcher, int, int, DataEntryWriter)}
   */
  @Test
  public void testNewZipWriter5() {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    EmptyStringMatcher extraUncompressedAlignmentFilter = new EmptyStringMatcher();

    // Act and Assert
    assertNull((new ZipWriter(uncompressedFilter, 1, true, extraUncompressedAlignmentFilter, 1, 1,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))).currentZipOutput);
  }

  /**
   * Method under test:
   * {@link ZipWriter#ZipWriter(StringMatcher, int, boolean, StringMatcher, int, int, byte[], DataEntryWriter)}
   */
  @Test
  public void testNewZipWriter6() throws UnsupportedEncodingException {
    // Arrange
    EmptyStringMatcher uncompressedFilter = new EmptyStringMatcher();
    EmptyStringMatcher extraUncompressedAlignmentFilter = new EmptyStringMatcher();
    byte[] header = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertNull((new ZipWriter(uncompressedFilter, 1, true, extraUncompressedAlignmentFilter, 1, 1, header,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))).currentZipOutput);
  }
}
