package proguard.io;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import org.junit.Test;

public class DataEntryCopierDiffblueTest {
  /**
   * Method under test:
   * {@link DataEntryCopier#copyData(InputStream, OutputStream)}
   */
  @Test
  public void testCopyData() throws IOException {
    // Arrange
    DataEntryCopier dataEntryCopier = new DataEntryCopier(
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    dataEntryCopier.copyData(inputStream, outputStream);

    // Assert that nothing has changed
    assertEquals(-1, inputStream.read(new byte[]{}));
    byte[] expectedToByteArrayResult = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, outputStream.toByteArray());
  }
}
