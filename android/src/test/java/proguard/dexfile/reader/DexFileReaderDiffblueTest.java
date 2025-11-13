package proguard.dexfile.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.DexFileReader.BadOpException;

class DexFileReaderDiffblueTest {
  /**
   * Test BadOpException {@link BadOpException#BadOpException(String, Object[])}.
   *
   * <p>Method under test: {@link BadOpException#BadOpException(String, Object[])}
   */
  @Test
  @DisplayName("Test BadOpException new BadOpException(String, Object[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BadOpException.<init>(String, Object[])"})
  void testBadOpExceptionNewBadOpException() {
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
  @DisplayName("Test new DexFileReader(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileReader.<init>(byte[])"})
  void testNewDexFileReader() throws UnsupportedEncodingException {
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
  @DisplayName(
      "Test new DexFileReader(ByteBuffer); when wrap 'AXAXAXAX' Bytes is 'UTF-8'; then throw DexException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileReader.<init>(ByteBuffer)"})
  void testNewDexFileReader_whenWrapAxaxaxaxBytesIsUtf8_thenThrowDexException()
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
  @DisplayName(
      "Test new DexFileReader(ByteBuffer, int); when wrap 'AXAXAXAX' Bytes is 'UTF-8'; then throw DexException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileReader.<init>(ByteBuffer, int)"})
  void testNewDexFileReader_whenWrapAxaxaxaxBytesIsUtf8_thenThrowDexException2()
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
  @DisplayName("Test sshort(byte[], int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return '22593'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DexFileReader.sshort(byte[], int)"})
  void testSshort_whenAxaxaxaxBytesIsUtf8_thenReturn22593() throws UnsupportedEncodingException {
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
  @DisplayName("Test ushort(byte[], int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return '22593'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DexFileReader.ushort(byte[], int)"})
  void testUshort_whenAxaxaxaxBytesIsUtf8_thenReturn22593() throws UnsupportedEncodingException {
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
  @DisplayName("Test sint(byte[], int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return '1480677441'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DexFileReader.sint(byte[], int)"})
  void testSint_whenAxaxaxaxBytesIsUtf8_thenReturn1480677441() throws UnsupportedEncodingException {
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
  @DisplayName("Test uint(byte[], int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return '1480677441'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DexFileReader.uint(byte[], int)"})
  void testUint_whenAxaxaxaxBytesIsUtf8_thenReturn1480677441() throws UnsupportedEncodingException {
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
  @DisplayName("Test ubyte(byte[], int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DexFileReader.ubyte(byte[], int)"})
  void testUbyte_whenAxaxaxaxBytesIsUtf8_thenReturnSixtyFive() throws UnsupportedEncodingException {
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
  @DisplayName("Test sbyte(byte[], int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DexFileReader.sbyte(byte[], int)"})
  void testSbyte_whenAxaxaxaxBytesIsUtf8_thenReturnSixtyFive() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, DexFileReader.sbyte("AXAXAXAX".getBytes("UTF-8"), 2));
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
  @DisplayName("Test readULeb128i(ByteBuffer); when 'A'; then return '11264'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DexFileReader.readULeb128i(ByteBuffer)"})
  void testReadULeb128i_whenA_thenReturn11264() {
    // Arrange, Act and Assert
    assertEquals(
        11264,
        DexFileReader.readULeb128i(
            ByteBuffer.wrap(new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
  }

  /**
   * Test {@link DexFileReader#readULeb128i(ByteBuffer)}.
   *
   * <ul>
   *   <li>When wrap {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link DexFileReader#readULeb128i(ByteBuffer)}
   */
  @Test
  @DisplayName(
      "Test readULeb128i(ByteBuffer); when wrap 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DexFileReader.readULeb128i(ByteBuffer)"})
  void testReadULeb128i_whenWrapAxaxaxaxBytesIsUtf8_thenReturnSixtyFive()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, DexFileReader.readULeb128i(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
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
  @DisplayName(
      "Test readLeb128i(ByteBuffer); when wrap array of byte with MIN_VALUE and 'X'; then return '-5120'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DexFileReader.readLeb128i(ByteBuffer)"})
  void testReadLeb128i_whenWrapArrayOfByteWithMin_valueAndX_thenReturn5120() {
    // Arrange, Act and Assert
    assertEquals(
        -5120,
        DexFileReader.readLeb128i(
            ByteBuffer.wrap(new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
  }

  /**
   * Test {@link DexFileReader#readLeb128i(ByteBuffer)}.
   *
   * <ul>
   *   <li>When wrap array of {@code byte} with one and {@code X}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link DexFileReader#readLeb128i(ByteBuffer)}
   */
  @Test
  @DisplayName(
      "Test readLeb128i(ByteBuffer); when wrap array of byte with one and 'X'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DexFileReader.readLeb128i(ByteBuffer)"})
  void testReadLeb128i_whenWrapArrayOfByteWithOneAndX_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        DexFileReader.readLeb128i(
            ByteBuffer.wrap(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})));
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
  @DisplayName(
      "Test readLeb128i(ByteBuffer); when wrap 'AXAXAXAX' Bytes is 'UTF-8'; then return minus sixty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DexFileReader.readLeb128i(ByteBuffer)"})
  void testReadLeb128i_whenWrapAxaxaxaxBytesIsUtf8_thenReturnMinusSixtyThree()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(-63, DexFileReader.readLeb128i(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8"))));
  }
}
