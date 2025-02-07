package proguard.dexfile.reader.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InputStreamsDiffblueTest {
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
  @DisplayName(
      "Test toByteArray(InputStream); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "byte[] proguard.dexfile.reader.util.InputStreams.toByteArray(java.io.InputStream)"
  })
  void testToByteArray_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne()
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
