package proguard.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Base64UtilDiffblueTest {
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
  @DisplayName("Test encode(byte[]); when 'A'; then return 'QQNBA0EDQQNBA0EDQQNBAw=='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Base64Util.encode(byte[])"})
  void testEncode_whenA_thenReturnQQNBA0EDQQNBA0EDQQNBAw() {
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
  @DisplayName("Test encode(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'QVhBWEFYQVg='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Base64Util.encode(byte[])"})
  void testEncode_whenAxaxaxaxBytesIsUtf8_thenReturnQVhBWEFYQVg()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("QVhBWEFYQVg=", Base64Util.encode("AXAXAXAX".getBytes("UTF-8")));
  }
}
