package proguard.dexfile.reader.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.junit.Test;

public class Mutf8DiffblueTest {
  /**
   * Method under test: {@link Mutf8#decode(ByteBuffer, StringBuilder)}
   */
  @Test
  public void testDecode() throws UTFDataFormatException {
    // Arrange
    ByteBuffer in = ByteBuffer.wrap(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(UTFDataFormatException.class, () -> Mutf8.decode(in, new StringBuilder("foo")));
  }

  /**
   * Method under test: {@link Mutf8#decode(ByteBuffer, StringBuilder)}
   */
  @Test
  public void testDecode2() throws UTFDataFormatException {
    // Arrange
    ByteBuffer in = ByteBuffer.wrap(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals("foo", Mutf8.decode(in, new StringBuilder("foo")));
    assertEquals(1, in.position());
  }

  /**
   * Method under test: {@link Mutf8#encode(String)}
   */
  @Test
  public void testEncode() throws UTFDataFormatException, UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualEncodeResult = Mutf8.encode("foo");

    // Assert
    assertArrayEquals("foo".getBytes("UTF-8"), actualEncodeResult);
  }

  /**
   * Method under test: {@link Mutf8#encode(byte[], int, String)}
   */
  @Test
  public void testEncode2() throws UnsupportedEncodingException {
    // Arrange
    byte[] dst = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Mutf8.encode(dst, 2, "foo");

    // Assert
    assertEquals(8, dst.length);
    assertEquals('f', dst[2]);
    assertEquals('o', dst[3]);
    assertEquals('o', dst[4]);
  }
}
