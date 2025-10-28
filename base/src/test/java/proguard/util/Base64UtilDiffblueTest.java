package proguard.util;

import static org.junit.Assert.assertEquals;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class Base64UtilDiffblueTest {
  /**
   * Method under test: {@link Base64Util#encode(byte[])}
   */
  @Test
  public void testEncode() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("QVhBWEFYQVg=", Base64Util.encode("AXAXAXAX".getBytes("UTF-8")));
    assertEquals("QQNBA0EDQQNBA0EDQQNBAw==",
        Base64Util.encode(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3}));
  }
}
