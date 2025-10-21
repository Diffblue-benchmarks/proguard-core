package proguard.dexfile.reader.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InputStreamsDiffblueTest {
  /**
   * Test {@link InputStreams#toByteArray(InputStream)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8} read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link InputStreams#toByteArray(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] InputStreams.toByteArray(InputStream)"})
  public void testToByteArray_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne()
      throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualToByteArrayResult = InputStreams.toByteArray(is);

    // Assert
    assertEquals(-1, is.read(new byte[] {}));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualToByteArrayResult);
  }
}
