package proguard.dexfile.reader.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;

public class InputStreamsDiffblueTest {
  /**
   * Method under test: {@link InputStreams#toByteArray(InputStream)}
   */
  @Test
  public void testToByteArray() throws IOException {
    // Arrange
    ByteArrayInputStream is = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualToByteArrayResult = InputStreams.toByteArray(is);

    // Assert
    assertEquals(-1, is.read(new byte[]{}));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualToByteArrayResult);
  }
}
