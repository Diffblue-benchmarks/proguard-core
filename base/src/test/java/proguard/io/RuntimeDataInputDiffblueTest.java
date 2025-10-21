package proguard.io;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RuntimeDataInputDiffblueTest {
  /**
   * Test {@link RuntimeDataInput#readBoolean()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readBoolean()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuntimeDataInput.readBoolean()"})
  public void testReadBoolean_givenA_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (new RuntimeDataInput(
                new DataInputStream(
                    new ByteArrayInputStream(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}))))
            .readBoolean());
  }

  /**
   * Test {@link RuntimeDataInput#readBoolean()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readBoolean()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuntimeDataInput.readBoolean()"})
  public void testReadBoolean_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(
        (new RuntimeDataInput(
                new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .readBoolean());
  }

  /**
   * Test {@link RuntimeDataInput#readBoolean()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readBoolean()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RuntimeDataInput.readBoolean()"})
  public void testReadBoolean_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[] {}))))
                .readBoolean());
  }

  /**
   * Test {@link RuntimeDataInput#readByte()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readByte()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte RuntimeDataInput.readByte()"})
  public void testReadByte_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnA()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        'A',
        (new RuntimeDataInput(
                new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .readByte());
  }

  /**
   * Test {@link RuntimeDataInput#readByte()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readByte()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte RuntimeDataInput.readByte()"})
  public void testReadByte_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[] {}))))
                .readByte());
  }

  /**
   * Test {@link RuntimeDataInput#readChar()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return {@code 䅘}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readChar()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char RuntimeDataInput.readChar()"})
  public void testReadChar_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturn()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        '䅘',
        (new RuntimeDataInput(
                new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .readChar());
  }

  /**
   * Test {@link RuntimeDataInput#readChar()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readChar()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"char RuntimeDataInput.readChar()"})
  public void testReadChar_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[] {}))))
                .readChar());
  }

  /**
   * Test {@link RuntimeDataInput#readDouble()}.
   *
   * <ul>
   *   <li>Then return {@code 6358369.021011673}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double RuntimeDataInput.readDouble()"})
  public void testReadDouble_thenReturn6358369021011673() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        6358369.021011673d,
        (new RuntimeDataInput(
                new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .readDouble(),
        0.0);
  }

  /**
   * Test {@link RuntimeDataInput#readDouble()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readDouble()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"double RuntimeDataInput.readDouble()"})
  public void testReadDouble_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[] {}))))
                .readDouble());
  }

  /**
   * Test {@link RuntimeDataInput#readFloat()}.
   *
   * <ul>
   *   <li>Then return {@code 13.515953}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readFloat()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"float RuntimeDataInput.readFloat()"})
  public void testReadFloat_thenReturn13515953() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        13.515953f,
        (new RuntimeDataInput(
                new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .readFloat(),
        0.0f);
  }

  /**
   * Test {@link RuntimeDataInput#readFloat()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readFloat()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"float RuntimeDataInput.readFloat()"})
  public void testReadFloat_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[] {}))))
                .readFloat());
  }

  /**
   * Test {@link RuntimeDataInput#readFully(byte[], int, int)} with {@code b}, {@code off}, {@code
   * len}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is {@code AAXAAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readFully(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataInput.readFully(byte[], int, int)"})
  public void testReadFullyWithBOffLen_thenAxaxaxaxBytesIsUtf8IsAaxaaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    RuntimeDataInput runtimeDataInput =
        new RuntimeDataInput(
            new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    runtimeDataInput.readFully(b, 1, 3);

    // Assert
    assertArrayEquals("AAXAAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Test {@link RuntimeDataInput#readFully(byte[], int, int)} with {@code b}, {@code off}, {@code
   * len}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readFully(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataInput.readFully(byte[], int, int)"})
  public void testReadFullyWithBOffLen_thenThrowRuntimeException()
      throws UnsupportedEncodingException {
    // Arrange
    RuntimeDataInput runtimeDataInput =
        new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[] {})));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> runtimeDataInput.readFully("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link RuntimeDataInput#readFully(byte[])} with {@code b}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readFully(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataInput.readFully(byte[])"})
  public void testReadFullyWithB_thenThrowRuntimeException() throws UnsupportedEncodingException {
    // Arrange
    RuntimeDataInput runtimeDataInput =
        new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[] {})));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> runtimeDataInput.readFully("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link RuntimeDataInput#readInt()}.
   *
   * <ul>
   *   <li>Then return {@code 1096302936}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readInt()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RuntimeDataInput.readInt()"})
  public void testReadInt_thenReturn1096302936() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        1096302936,
        (new RuntimeDataInput(
                new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .readInt());
  }

  /**
   * Test {@link RuntimeDataInput#readInt()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readInt()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RuntimeDataInput.readInt()"})
  public void testReadInt_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[] {}))))
                .readInt());
  }

  /**
   * Test {@link RuntimeDataInput#readLine()}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream#DataInputStream(InputStream)} with {@link
   *       ByteArrayInputStream#ByteArrayInputStream(byte[])}.
   *   <li>Then return {@code AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readLine()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String RuntimeDataInput.readLine()"})
  public void testReadLine_givenDataInputStreamWithByteArrayInputStream_thenReturnAxaxaxax()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "AXAXAXAX",
        (new RuntimeDataInput(
                new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .readLine());
  }

  /**
   * Test {@link RuntimeDataInput#readLine()}.
   *
   * <ul>
   *   <li>Given {@link FileInputStream#FileInputStream(FileDescriptor)} with {@link
   *       FileDescriptor#FileDescriptor()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readLine()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String RuntimeDataInput.readLine()"})
  public void testReadLine_givenFileInputStreamWithFileDescriptor_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataInput(new DataInputStream(new FileInputStream(new FileDescriptor()))))
                .readLine());
  }

  /**
   * Test {@link RuntimeDataInput#readLong()}.
   *
   * <ul>
   *   <li>Then return {@code 4708585257725083992}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readLong()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long RuntimeDataInput.readLong()"})
  public void testReadLong_thenReturn4708585257725083992() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        4708585257725083992L,
        (new RuntimeDataInput(
                new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .readLong());
  }

  /**
   * Test {@link RuntimeDataInput#readLong()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readLong()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long RuntimeDataInput.readLong()"})
  public void testReadLong_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[] {}))))
                .readLong());
  }

  /**
   * Test {@link RuntimeDataInput#readShort()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readShort()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"short RuntimeDataInput.readShort()"})
  public void testReadShort_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturn16728()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        (short) 16728,
        (new RuntimeDataInput(
                new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .readShort());
  }

  /**
   * Test {@link RuntimeDataInput#readShort()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readShort()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"short RuntimeDataInput.readShort()"})
  public void testReadShort_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[] {}))))
                .readShort());
  }

  /**
   * Test {@link RuntimeDataInput#readUnsignedByte()}.
   *
   * <ul>
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readUnsignedByte()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RuntimeDataInput.readUnsignedByte()"})
  public void testReadUnsignedByte_thenReturnSixtyFive() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        65,
        (new RuntimeDataInput(
                new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .readUnsignedByte());
  }

  /**
   * Test {@link RuntimeDataInput#readUnsignedByte()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readUnsignedByte()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RuntimeDataInput.readUnsignedByte()"})
  public void testReadUnsignedByte_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[] {}))))
                .readUnsignedByte());
  }

  /**
   * Test {@link RuntimeDataInput#readUnsignedShort()}.
   *
   * <ul>
   *   <li>Then return {@code 16728}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readUnsignedShort()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RuntimeDataInput.readUnsignedShort()"})
  public void testReadUnsignedShort_thenReturn16728() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        16728,
        (new RuntimeDataInput(
                new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .readUnsignedShort());
  }

  /**
   * Test {@link RuntimeDataInput#readUnsignedShort()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readUnsignedShort()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RuntimeDataInput.readUnsignedShort()"})
  public void testReadUnsignedShort_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[] {}))))
                .readUnsignedShort());
  }

  /**
   * Test {@link RuntimeDataInput#readUTF()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#readUTF()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String RuntimeDataInput.readUTF()"})
  public void testReadUTF_thenThrowRuntimeException() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataInput(
                    new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
                .readUTF());
  }

  /**
   * Test {@link RuntimeDataInput#skipBytes(int)}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream#DataInputStream(InputStream)} with {@link
   *       ByteArrayInputStream#ByteArrayInputStream(byte[])}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#skipBytes(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RuntimeDataInput.skipBytes(int)"})
  public void testSkipBytes_givenDataInputStreamWithByteArrayInputStream_thenReturnOne()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        1,
        (new RuntimeDataInput(
                new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .skipBytes(1));
  }

  /**
   * Test {@link RuntimeDataInput#skipBytes(int)}.
   *
   * <ul>
   *   <li>Given {@link FileInputStream#FileInputStream(FileDescriptor)} with {@link
   *       FileDescriptor#FileDescriptor()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataInput#skipBytes(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int RuntimeDataInput.skipBytes(int)"})
  public void testSkipBytes_givenFileInputStreamWithFileDescriptor_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataInput(new DataInputStream(new FileInputStream(new FileDescriptor()))))
                .skipBytes(1));
  }
}
