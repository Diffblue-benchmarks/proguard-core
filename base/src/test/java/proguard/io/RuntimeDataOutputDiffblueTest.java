package proguard.io;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.PipedOutputStream;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.io.ZipOutput.LargeDataOutputStream;

public class RuntimeDataOutputDiffblueTest {
  /**
   * Test {@link RuntimeDataOutput#write(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#write(byte[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.write(byte[], int, int)"})
  public void testWriteWithByteIntInt_thenThrowRuntimeException()
      throws UnsupportedEncodingException {
    // Arrange
    RuntimeDataOutput runtimeDataOutput =
        new RuntimeDataOutput(new LargeDataOutputStream(new PipedOutputStream()));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> runtimeDataOutput.write("AXAXAXAX".getBytes("UTF-8"), 19088743, 3));
  }

  /**
   * Test {@link RuntimeDataOutput#write(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#write(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.write(byte[])"})
  public void testWriteWithByte_thenThrowRuntimeException() throws UnsupportedEncodingException {
    // Arrange
    RuntimeDataOutput runtimeDataOutput =
        new RuntimeDataOutput(new LargeDataOutputStream(new PipedOutputStream()));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> runtimeDataOutput.write("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link RuntimeDataOutput#write(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#write(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.write(int)"})
  public void testWriteWithInt_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataOutput(new LargeDataOutputStream(new PipedOutputStream())))
                .write(19088743));
  }

  /**
   * Test {@link RuntimeDataOutput#writeBoolean(boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeBoolean(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.writeBoolean(boolean)"})
  public void testWriteBoolean_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataOutput(new LargeDataOutputStream(new PipedOutputStream())))
                .writeBoolean(true));
  }

  /**
   * Test {@link RuntimeDataOutput#writeByte(int)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeByte(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.writeByte(int)"})
  public void testWriteByte_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataOutput(new LargeDataOutputStream(new PipedOutputStream())))
                .writeByte(19088743));
  }

  /**
   * Test {@link RuntimeDataOutput#writeBytes(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeBytes(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.writeBytes(String)"})
  public void testWriteBytes_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataOutput(new LargeDataOutputStream(new PipedOutputStream())))
                .writeBytes("foo"));
  }

  /**
   * Test {@link RuntimeDataOutput#writeChar(int)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeChar(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.writeChar(int)"})
  public void testWriteChar_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataOutput(new LargeDataOutputStream(new PipedOutputStream())))
                .writeChar(19088743));
  }

  /**
   * Test {@link RuntimeDataOutput#writeChars(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeChars(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.writeChars(String)"})
  public void testWriteChars_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataOutput(new LargeDataOutputStream(new PipedOutputStream())))
                .writeChars("foo"));
  }

  /**
   * Test {@link RuntimeDataOutput#writeDouble(double)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeDouble(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.writeDouble(double)"})
  public void testWriteDouble_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataOutput(new LargeDataOutputStream(new PipedOutputStream())))
                .writeDouble(10.0d));
  }

  /**
   * Test {@link RuntimeDataOutput#writeFloat(float)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeFloat(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.writeFloat(float)"})
  public void testWriteFloat_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataOutput(new LargeDataOutputStream(new PipedOutputStream())))
                .writeFloat(10.0f));
  }

  /**
   * Test {@link RuntimeDataOutput#writeInt(int)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeInt(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.writeInt(int)"})
  public void testWriteInt_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataOutput(new LargeDataOutputStream(new PipedOutputStream())))
                .writeInt(19088743));
  }

  /**
   * Test {@link RuntimeDataOutput#writeLong(long)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeLong(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.writeLong(long)"})
  public void testWriteLong_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataOutput(new LargeDataOutputStream(new PipedOutputStream())))
                .writeLong(81985529216486895L));
  }

  /**
   * Test {@link RuntimeDataOutput#writeUnsignedShort(int)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeUnsignedShort(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.writeUnsignedShort(int)"})
  public void testWriteUnsignedShort_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataOutput(new LargeDataOutputStream(new PipedOutputStream())))
                .writeUnsignedShort(65535));
  }

  /**
   * Test {@link RuntimeDataOutput#writeUnsignedShort(int)}.
   *
   * <ul>
   *   <li>When {@code 19088743}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeUnsignedShort(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.writeUnsignedShort(int)"})
  public void testWriteUnsignedShort_when19088743_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            (new RuntimeDataOutput(new LargeDataOutputStream(new ByteArrayOutputStream(1))))
                .writeUnsignedShort(19088743));
  }

  /**
   * Test {@link RuntimeDataOutput#writeSignedShort(int)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeSignedShort(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.writeSignedShort(int)"})
  public void testWriteSignedShort_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataOutput(new LargeDataOutputStream(new PipedOutputStream())))
                .writeSignedShort(17767));
  }

  /**
   * Test {@link RuntimeDataOutput#writeSignedShort(int)}.
   *
   * <ul>
   *   <li>When {@code 19088743}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeSignedShort(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.writeSignedShort(int)"})
  public void testWriteSignedShort_when19088743_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            (new RuntimeDataOutput(new LargeDataOutputStream(new ByteArrayOutputStream(1))))
                .writeSignedShort(19088743));
  }

  /**
   * Test {@link RuntimeDataOutput#writeShort(int)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeShort(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.writeShort(int)"})
  public void testWriteShort_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataOutput(new LargeDataOutputStream(new PipedOutputStream())))
                .writeShort(19088743));
  }

  /**
   * Test {@link RuntimeDataOutput#writeUTF(String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeUTF(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RuntimeDataOutput.writeUTF(String)"})
  public void testWriteUTF_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            (new RuntimeDataOutput(new LargeDataOutputStream(new PipedOutputStream())))
                .writeUTF("Str"));
  }
}
