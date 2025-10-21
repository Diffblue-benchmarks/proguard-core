package proguard.util;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Base64UtilDiffblueTest {
  /**
   * Test {@link Base64Util#encode(byte[])}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code QQNBA0EDQQNBA0EDQQNBAw==}.
   * </ul>
   *
   * <p>Method under test: {@link Base64Util#encode(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Base64Util.encode(byte[])"})
  public void testEncode_whenA_thenReturnQQNBA0EDQQNBA0EDQQNBAw() {
    // Arrange, Act and Assert
    assertEquals(
        "QQNBA0EDQQNBA0EDQQNBAw==",
        Base64Util.encode(
            new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3}));
  }

  /**
   * Test {@link Base64Util#encode(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code QVhBWEFYQVg=}.
   * </ul>
   *
   * <p>Method under test: {@link Base64Util#encode(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String Base64Util.encode(byte[])"})
  public void testEncode_whenAxaxaxaxBytesIsUtf8_thenReturnQVhBWEFYQVg()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("QVhBWEFYQVg=", Base64Util.encode("AXAXAXAX".getBytes("UTF-8")));
  }
}
