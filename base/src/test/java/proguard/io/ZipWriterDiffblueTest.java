package proguard.io;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.io.ZipOutput.LargeDataOutputStream;
import proguard.util.EmptyStringMatcher;
import proguard.util.StringMatcher;

public class ZipWriterDiffblueTest {
  /**
   * Test {@link ZipWriter#ZipWriter(DataEntryWriter)}.
   *
   * <p>Method under test: {@link ZipWriter#ZipWriter(DataEntryWriter)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ZipWriter.<init>(DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, StringMatcher, int, int, byte[], DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, int, DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, int, byte[], DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, StringMatcher, int, int, DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, StringMatcher, int, int, byte[], DataEntryWriter)"
  })
  public void testNewZipWriter() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ZipWriter.<init>(DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, StringMatcher, int, int, byte[], DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, int, DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, int, byte[], DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, StringMatcher, int, int, DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, StringMatcher, int, int, byte[], DataEntryWriter)"
  })
  public void testNewZipWriter_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ZipWriter.<init>(DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, StringMatcher, int, int, byte[], DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, int, DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, int, byte[], DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, StringMatcher, int, int, DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, StringMatcher, int, int, byte[], DataEntryWriter)"
  })
  public void testNewZipWriter_whenAxaxaxaxBytesIsUtf82() throws UnsupportedEncodingException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ZipWriter.<init>(DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, StringMatcher, int, int, byte[], DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, int, DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, int, byte[], DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, StringMatcher, int, int, DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, StringMatcher, int, int, byte[], DataEntryWriter)"
  })
  public void testNewZipWriter_whenAxaxaxaxBytesIsUtf83() throws UnsupportedEncodingException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ZipWriter.<init>(DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, StringMatcher, int, int, byte[], DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, int, DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, int, byte[], DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, StringMatcher, int, int, DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, StringMatcher, int, int, byte[], DataEntryWriter)"
  })
  public void testNewZipWriter_whenTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ZipWriter.<init>(DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, StringMatcher, int, int, byte[], DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, int, DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, int, byte[], DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, StringMatcher, int, int, DataEntryWriter)",
    "void ZipWriter.<init>(StringMatcher, int, boolean, StringMatcher, int, int, byte[], DataEntryWriter)"
  })
  public void testNewZipWriter_whenTrue2() {
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
   * Test {@link ZipWriter#sameOutputStream(DataEntry, DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ZipWriter#sameOutputStream(DataEntry, DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZipWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_thenReturnTrue() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZipWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_whenJavaLangObject_thenReturnFalse() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZipWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_whenNull_thenReturnFalse() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ZipWriter.sameOutputStream(DataEntry, DataEntry)"})
  public void testSameOutputStream_whenNull_thenReturnFalse2() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ZipOutput ZipWriter.createZipOutput(OutputStream, byte[], int, boolean, String)"
  })
  public void testCreateZipOutput() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ZipOutput ZipWriter.createZipOutput(OutputStream, byte[], int, boolean, String)"
  })
  public void testCreateZipOutput2() throws IOException {
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
