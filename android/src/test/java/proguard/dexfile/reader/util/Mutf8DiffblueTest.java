package proguard.dexfile.reader.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Mutf8DiffblueTest {
  /**
   * Test {@link Mutf8#decode(ByteBuffer, StringBuilder)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code Str} toString is {@code
   *       StrA}.
   * </ul>
   *
   * <p>Method under test: {@link Mutf8#decode(ByteBuffer, StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test decode(ByteBuffer, StringBuilder); then StringBuilder(String) with 'Str' toString is 'StrA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Mutf8.decode(ByteBuffer, StringBuilder)"})
  void testDecode_thenStringBuilderWithStrToStringIsStrA() throws UTFDataFormatException {
    // Arrange
    ByteBuffer in = ByteBuffer.wrap(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});
    StringBuilder sb = new StringBuilder("Str");

    // Act
    String actualDecodeResult = Mutf8.decode(in, sb);

    // Assert
    assertEquals("StrA", sb.toString());
    assertEquals("StrA", actualDecodeResult);
  }

  /**
   * Test {@link Mutf8#decode(ByteBuffer, StringBuilder)}.
   *
   * <ul>
   *   <li>When wrap array of {@code byte} with minus one and {@code X}.
   *   <li>Then throw {@link UTFDataFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link Mutf8#decode(ByteBuffer, StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test decode(ByteBuffer, StringBuilder); when wrap array of byte with minus one and 'X'; then throw UTFDataFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Mutf8.decode(ByteBuffer, StringBuilder)"})
  void testDecode_whenWrapArrayOfByteWithMinusOneAndX_thenThrowUTFDataFormatException()
      throws UTFDataFormatException {
    // Arrange
    ByteBuffer in = ByteBuffer.wrap(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(UTFDataFormatException.class, () -> Mutf8.decode(in, new StringBuilder("Str")));
  }

  /**
   * Test {@link Mutf8#decode(ByteBuffer, StringBuilder)}.
   *
   * <ul>
   *   <li>When wrap array of {@code byte} with zero and {@code X}.
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code Str} toString is {@code
   *       Str}.
   * </ul>
   *
   * <p>Method under test: {@link Mutf8#decode(ByteBuffer, StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test decode(ByteBuffer, StringBuilder); when wrap array of byte with zero and 'X'; then StringBuilder(String) with 'Str' toString is 'Str'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Mutf8.decode(ByteBuffer, StringBuilder)"})
  void testDecode_whenWrapArrayOfByteWithZeroAndX_thenStringBuilderWithStrToStringIsStr()
      throws UTFDataFormatException {
    // Arrange
    ByteBuffer in = ByteBuffer.wrap(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    StringBuilder sb = new StringBuilder("Str");

    // Act
    String actualDecodeResult = Mutf8.decode(in, sb);

    // Assert
    assertEquals("Str", sb.toString());
    assertEquals("Str", actualDecodeResult);
  }

  /**
   * Test {@link Mutf8#encode(byte[], int, String)} with {@code dst}, {@code offset}, {@code s}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is {@code AXfooXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link Mutf8#encode(byte[], int, String)}
   */
  @Test
  @DisplayName(
      "Test encode(byte[], int, String) with 'dst', 'offset', 's'; then 'AXAXAXAX' Bytes is 'UTF-8' is 'AXfooXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Mutf8.encode(byte[], int, String)"})
  void testEncodeWithDstOffsetS_thenAxaxaxaxBytesIsUtf8IsAXfooXAXBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] dst = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Mutf8.encode(dst, 2, "foo");

    // Assert
    assertArrayEquals("AXfooXAX".getBytes("UTF-8"), dst);
  }

  /**
   * Test {@link Mutf8#encode(String)} with {@code s}.
   *
   * <p>Method under test: {@link Mutf8#encode(String)}
   */
  @Test
  @DisplayName("Test encode(String) with 's'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] Mutf8.encode(String)"})
  void testEncodeWithS() throws UTFDataFormatException, UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals("foo".getBytes("UTF-8"), Mutf8.encode("foo"));
  }
}
