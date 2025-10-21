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
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DataEntryCopierDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataEntryCopier.copyData(InputStream, OutputStream)"})
  public void testCopyData_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne()
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
