package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.DexFileReader.BadOpException;

public class DexFileReaderDiffblueTest {
  /**
   * Test BadOpException {@link BadOpException#BadOpException(String, Object[])}.
   *
   * <p>Method under test: {@link BadOpException#BadOpException(String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BadOpException.<init>(String, Object[])"})
  public void testBadOpExceptionNewBadOpException() {
    // Arrange and Act
    BadOpException actualBadOpException = new BadOpException("Fmt", Constant.Null);

    // Assert
    assertEquals("Fmt", actualBadOpException.getLocalizedMessage());
    assertEquals("Fmt", actualBadOpException.getMessage());
    assertNull(actualBadOpException.getCause());
    assertEquals(0, actualBadOpException.getSuppressed().length);
  }

  /**
   * Test {@link DexFileReader#DexFileReader(byte[])}.
   *
   * <p>Method under test: {@link DexFileReader#DexFileReader(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileReader.<init>(byte[])"})
  public void testNewDexFileReader() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(DexException.class, () -> new DexFileReader("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link DexFileReader#DexFileReader(ByteBuffer)}.
   *
   * <ul>
   *   <li>When wrap {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link DexException}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileReader#DexFileReader(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileReader.<init>(ByteBuffer)"})
  public void testNewDexFileReader_whenWrapAxaxaxaxBytesIsUtf8_thenThrowDexException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        DexException.class, () -> new DexFileReader(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link DexFileReader#DexFileReader(ByteBuffer, int)}.
   *
   * <ul>
   *   <li>When wrap {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link DexException}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileReader#DexFileReader(ByteBuffer, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexFileReader.<init>(ByteBuffer, int)"})
  public void testNewDexFileReader_whenWrapAxaxaxaxBytesIsUtf8_thenThrowDexException2()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        DexException.class,
        () -> new DexFileReader(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")), 1));
  }

  /**
   * Test {@link DexFileReader#sshort(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 22593}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileReader#sshort(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DexFileReader.sshort(byte[], int)"})
  public void testSshort_whenAxaxaxaxBytesIsUtf8_thenReturn22593()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(22593, DexFileReader.sshort("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link DexFileReader#ushort(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 22593}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileReader#ushort(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DexFileReader.ushort(byte[], int)"})
  public void testUshort_whenAxaxaxaxBytesIsUtf8_thenReturn22593()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(22593, DexFileReader.ushort("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link DexFileReader#sint(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 1480677441}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileReader#sint(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DexFileReader.sint(byte[], int)"})
  public void testSint_whenAxaxaxaxBytesIsUtf8_thenReturn1480677441()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1480677441, DexFileReader.sint("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link DexFileReader#uint(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 1480677441}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileReader#uint(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DexFileReader.uint(byte[], int)"})
  public void testUint_whenAxaxaxaxBytesIsUtf8_thenReturn1480677441()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1480677441, DexFileReader.uint("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link DexFileReader#ubyte(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link DexFileReader#ubyte(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DexFileReader.ubyte(byte[], int)"})
  public void testUbyte_whenAxaxaxaxBytesIsUtf8_thenReturnSixtyFive()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, DexFileReader.ubyte("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link DexFileReader#sbyte(byte[], int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link DexFileReader#sbyte(byte[], int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DexFileReader.sbyte(byte[], int)"})
  public void testSbyte_whenAxaxaxaxBytesIsUtf8_thenReturnSixtyFive()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, DexFileReader.sbyte("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link DexFileReader#readULeb128i(ByteBuffer)}.
   *
   * <ul>
   *   <li>Then wrap {@code AXAXAXAX} Bytes is {@code UTF-8} position is one.
   * </ul>
   *
   * <p>Method under test: {@link DexFileReader#readULeb128i(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DexFileReader.readULeb128i(ByteBuffer)"})
  public void testReadULeb128i_thenWrapAxaxaxaxBytesIsUtf8PositionIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    ByteBuffer in = ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualReadULeb128iResult = DexFileReader.readULeb128i(in);

    // Assert
    assertEquals(1, in.position());
    assertEquals(65, actualReadULeb128iResult);
  }

  /**
   * Test {@link DexFileReader#readULeb128i(ByteBuffer)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code 11264}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileReader#readULeb128i(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DexFileReader.readULeb128i(ByteBuffer)"})
  public void testReadULeb128i_whenA_thenReturn11264() {
    // Arrange
    ByteBuffer in = ByteBuffer.wrap(new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(11264, DexFileReader.readULeb128i(in));
    assertEquals(2, in.position());
  }

  /**
   * Test {@link DexFileReader#readLeb128i(ByteBuffer)}.
   *
   * <ul>
   *   <li>Then wrap array of {@code byte} with one and {@code X} position is one.
   * </ul>
   *
   * <p>Method under test: {@link DexFileReader#readLeb128i(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DexFileReader.readLeb128i(ByteBuffer)"})
  public void testReadLeb128i_thenWrapArrayOfByteWithOneAndXPositionIsOne() {
    // Arrange
    ByteBuffer in = ByteBuffer.wrap(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    int actualReadLeb128iResult = DexFileReader.readLeb128i(in);

    // Assert
    assertEquals(1, in.position());
    assertEquals(1, actualReadLeb128iResult);
  }

  /**
   * Test {@link DexFileReader#readLeb128i(ByteBuffer)}.
   *
   * <ul>
   *   <li>When wrap array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.
   *   <li>Then return {@code -5120}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileReader#readLeb128i(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DexFileReader.readLeb128i(ByteBuffer)"})
  public void testReadLeb128i_whenWrapArrayOfByteWithMin_valueAndX_thenReturn5120() {
    // Arrange
    ByteBuffer in = ByteBuffer.wrap(new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertEquals(-5120, DexFileReader.readLeb128i(in));
    assertEquals(2, in.position());
  }

  /**
   * Test {@link DexFileReader#readLeb128i(ByteBuffer)}.
   *
   * <ul>
   *   <li>When wrap {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return minus sixty-three.
   * </ul>
   *
   * <p>Method under test: {@link DexFileReader#readLeb128i(ByteBuffer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DexFileReader.readLeb128i(ByteBuffer)"})
  public void testReadLeb128i_whenWrapAxaxaxaxBytesIsUtf8_thenReturnMinusSixtyThree()
      throws UnsupportedEncodingException {
    // Arrange
    ByteBuffer in = ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(-63, DexFileReader.readLeb128i(in));
    assertEquals(1, in.position());
  }
}
