package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.junit.Test;
import proguard.dexfile.ir.expr.Constant;

public class DexFileReaderDiffblueTest {
  /**
   * Method under test:
   * {@link DexFileReader.BadOpException#BadOpException(String, Object[])}
   */
  @Test
  public void testBadOpExceptionNewBadOpException() {
    // Arrange and Act
    DexFileReader.BadOpException actualBadOpException = new DexFileReader.BadOpException("Fmt", Constant.Null);

    // Assert
    assertEquals("Fmt", actualBadOpException.getLocalizedMessage());
    assertEquals("Fmt", actualBadOpException.getMessage());
    assertNull(actualBadOpException.getCause());
    assertEquals(0, actualBadOpException.getSuppressed().length);
  }

  /**
   * Method under test: {@link DexFileReader#sshort(byte[], int)}
   */
  @Test
  public void testSshort() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(22593, DexFileReader.sshort("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link DexFileReader#ushort(byte[], int)}
   */
  @Test
  public void testUshort() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(22593, DexFileReader.ushort("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link DexFileReader#sint(byte[], int)}
   */
  @Test
  public void testSint() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1480677441, DexFileReader.sint("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link DexFileReader#uint(byte[], int)}
   */
  @Test
  public void testUint() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1480677441, DexFileReader.uint("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link DexFileReader#ubyte(byte[], int)}
   */
  @Test
  public void testUbyte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, DexFileReader.ubyte("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link DexFileReader#sbyte(byte[], int)}
   */
  @Test
  public void testSbyte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, DexFileReader.sbyte("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test: {@link DexFileReader#readULeb128i(ByteBuffer)}
   */
  @Test
  public void testReadULeb128i() throws UnsupportedEncodingException {
    // Arrange
    ByteBuffer in = ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualReadULeb128iResult = DexFileReader.readULeb128i(in);

    // Assert
    assertEquals(1, in.position());
    assertEquals(65, actualReadULeb128iResult);
  }

  /**
   * Method under test: {@link DexFileReader#readULeb128i(ByteBuffer)}
   */
  @Test
  public void testReadULeb128i2() {
    // Arrange
    ByteBuffer in = ByteBuffer.wrap(new byte[]{Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(11264, DexFileReader.readULeb128i(in));
    assertEquals(2, in.position());
  }

  /**
   * Method under test: {@link DexFileReader#DexFileReader(ByteBuffer)}
   */
  @Test
  public void testNewDexFileReader() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(DexException.class, () -> new DexFileReader(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
    assertThrows(DexException.class, () -> new DexFileReader(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")), 1));
    assertThrows(DexException.class, () -> new DexFileReader("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link DexFileReader#readLeb128i(ByteBuffer)}
   */
  @Test
  public void testReadLeb128i() throws UnsupportedEncodingException {
    // Arrange
    ByteBuffer in = ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(-63, DexFileReader.readLeb128i(in));
    assertEquals(1, in.position());
  }

  /**
   * Method under test: {@link DexFileReader#readLeb128i(ByteBuffer)}
   */
  @Test
  public void testReadLeb128i2() {
    // Arrange
    ByteBuffer in = ByteBuffer.wrap(new byte[]{Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(-5120, DexFileReader.readLeb128i(in));
    assertEquals(2, in.position());
  }

  /**
   * Method under test: {@link DexFileReader#readLeb128i(ByteBuffer)}
   */
  @Test
  public void testReadLeb128i3() {
    // Arrange
    ByteBuffer in = ByteBuffer.wrap(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    int actualReadLeb128iResult = DexFileReader.readLeb128i(in);

    // Assert
    assertEquals(1, in.position());
    assertEquals(1, actualReadLeb128iResult);
  }
}
