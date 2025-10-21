package proguard.dexfile.reader.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Mutf8DiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Mutf8.decode(ByteBuffer, StringBuilder)"})
  public void testDecode_whenWrapArrayOfByteWithMinusOneAndX_thenThrowUTFDataFormatException()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String Mutf8.decode(ByteBuffer, StringBuilder)"})
  public void testDecode_whenWrapArrayOfByteWithZeroAndX_thenReturnFoo()
      throws UTFDataFormatException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Mutf8.encode(byte[], int, String)"})
  public void testEncodeWithDstOffsetS_thenAxaxaxaxBytesIsUtf8IsAXfooXAXBytesIsUtf8()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] Mutf8.encode(String)"})
  public void testEncodeWithS() throws UTFDataFormatException, UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualEncodeResult = Mutf8.encode("foo");

    // Assert
    assertArrayEquals("foo".getBytes("UTF-8"), actualEncodeResult);
  }
}
