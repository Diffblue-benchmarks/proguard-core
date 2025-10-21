package proguard.io;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinConstants;

public class DataEntryRewriterDiffblueTest {
  /**
   * Test {@link DataEntryRewriter#copyData(InputStream, OutputStream)} with {@code inputStream},
   * {@code outputStream}.
   *
   * <p>Method under test: {@link DataEntryRewriter#copyData(InputStream, OutputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataEntryRewriter.copyData(InputStream, OutputStream)"})
  public void testCopyDataWithInputStreamOutputStream() throws IOException {
    // Arrange
    Charset charset = Charset.forName("UTF-8");
    DataEntryRewriter dataEntryRewriter =
        new DataEntryRewriter(
            KotlinConstants.dummyClassPool,
            charset,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    dataEntryRewriter.copyData(inputStream, outputStream);

    // Assert
    assertEquals(-1, inputStream.read(new byte[] {}));
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, outputStream.toByteArray());
  }

  /**
   * Test {@link DataEntryRewriter#copyData(InputStream, OutputStream)} with {@code inputStream},
   * {@code outputStream}.
   *
   * <p>Method under test: {@link DataEntryRewriter#copyData(InputStream, OutputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataEntryRewriter.copyData(InputStream, OutputStream)"})
  public void testCopyDataWithInputStreamOutputStream2() throws IOException {
    // Arrange
    Charset charset = Charset.forName("UTF-8");
    DataEntryRewriter dataEntryRewriter =
        new DataEntryRewriter(
            KotlinConstants.dummyClassPool,
            charset,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    dataEntryRewriter.copyData(inputStream, outputStream);

    // Assert
    assertEquals(-1, inputStream.read(new byte[] {}));
    assertArrayEquals(
        new byte[] {-17, -65, -67, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, outputStream.toByteArray());
  }

  /**
   * Test {@link DataEntryRewriter#copyData(InputStream, OutputStream)} with {@code inputStream},
   * {@code outputStream}.
   *
   * <p>Method under test: {@link DataEntryRewriter#copyData(InputStream, OutputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataEntryRewriter.copyData(InputStream, OutputStream)"})
  public void testCopyDataWithInputStreamOutputStream3() throws IOException {
    // Arrange
    Charset charset = Charset.forName("UTF-8");
    DataEntryRewriter dataEntryRewriter =
        new DataEntryRewriter(
            KotlinConstants.dummyClassPool,
            charset,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {-1, '.', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    dataEntryRewriter.copyData(inputStream, outputStream);

    // Assert
    assertEquals(-1, inputStream.read(new byte[] {}));
    assertArrayEquals(
        new byte[] {-17, -65, -67, '.', 'A', 'X', 'A', 'X', 'A', 'X'}, outputStream.toByteArray());
  }

  /**
   * Test {@link DataEntryRewriter#copyData(InputStream, OutputStream)} with {@code inputStream},
   * {@code outputStream}.
   *
   * <p>Method under test: {@link DataEntryRewriter#copyData(InputStream, OutputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataEntryRewriter.copyData(InputStream, OutputStream)"})
  public void testCopyDataWithInputStreamOutputStream4() throws IOException {
    // Arrange
    Charset charset = Charset.forName("UTF-8");
    DataEntryRewriter dataEntryRewriter =
        new DataEntryRewriter(
            KotlinConstants.dummyClassPool,
            charset,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {-1, '-', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    dataEntryRewriter.copyData(inputStream, outputStream);

    // Assert
    assertEquals(-1, inputStream.read(new byte[] {}));
    assertArrayEquals(
        new byte[] {-17, -65, -67, '-', 'A', 'X', 'A', 'X', 'A', 'X'}, outputStream.toByteArray());
  }

  /**
   * Test {@link DataEntryRewriter#copyData(Reader, Writer)} with {@code reader}, {@code writer}.
   *
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryRewriter#copyData(Reader, Writer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataEntryRewriter.copyData(Reader, Writer)"})
  public void testCopyDataWithReaderWriter_thenStringWriterToStringIsFoo() throws IOException {
    // Arrange
    Charset charset = Charset.forName("UTF-8");
    DataEntryRewriter dataEntryRewriter =
        new DataEntryRewriter(
            KotlinConstants.dummyClassPool,
            charset,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    StringReader reader = new StringReader("foo");
    StringWriter writer = new StringWriter();

    // Act
    dataEntryRewriter.copyData(reader, writer);

    // Assert
    assertEquals("foo", writer.toString());
  }
}
