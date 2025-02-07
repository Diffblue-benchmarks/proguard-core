package proguard.dexfile.reader.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
   *   <li>When wrap array of {@code byte} with minus one and {@code X}.
   *   <li>Then throw {@link UTFDataFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link Mutf8#decode(ByteBuffer, StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test decode(ByteBuffer, StringBuilder); when wrap array of byte with minus one and 'X'; then throw UTFDataFormatException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.dexfile.reader.util.Mutf8.decode(java.nio.ByteBuffer, java.lang.StringBuilder)"
  })
  void testDecode_whenWrapArrayOfByteWithMinusOneAndX_thenThrowUTFDataFormatException()
      throws UTFDataFormatException {
    // Arrange
    ByteBuffer in = ByteBuffer.wrap(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(UTFDataFormatException.class, () -> Mutf8.decode(in, new StringBuilder("foo")));
  }

  /**
   * Test {@link Mutf8#decode(ByteBuffer, StringBuilder)}.
   *
   * <ul>
   *   <li>When wrap array of {@code byte} with zero and {@code X}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Mutf8#decode(ByteBuffer, StringBuilder)}
   */
  @Test
  @DisplayName(
      "Test decode(ByteBuffer, StringBuilder); when wrap array of byte with zero and 'X'; then return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.dexfile.reader.util.Mutf8.decode(java.nio.ByteBuffer, java.lang.StringBuilder)"
  })
  void testDecode_whenWrapArrayOfByteWithZeroAndX_thenReturnFoo() throws UTFDataFormatException {
    // Arrange
    ByteBuffer in = ByteBuffer.wrap(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals("foo", Mutf8.decode(in, new StringBuilder("foo")));
    assertEquals(1, in.position());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.util.Mutf8.encode(byte[], int, java.lang.String)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] proguard.dexfile.reader.util.Mutf8.encode(java.lang.String)"})
  void testEncodeWithS() throws UTFDataFormatException, UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualEncodeResult = Mutf8.encode("foo");

    // Assert
    assertArrayEquals("foo".getBytes("UTF-8"), actualEncodeResult);
  }
}
