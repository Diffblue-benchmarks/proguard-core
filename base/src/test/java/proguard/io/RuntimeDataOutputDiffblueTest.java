package proguard.io;

import static org.junit.Assert.assertThrows;
import java.io.ByteArrayOutputStream;
import java.io.PipedOutputStream;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class RuntimeDataOutputDiffblueTest {
  /**
   * Method under test: {@link RuntimeDataOutput#write(int)}
   */
  @Test
  public void testWrite() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataOutput(new ZipOutput.LargeDataOutputStream(new PipedOutputStream()))).write(19088743));
  }

  /**
   * Method under test: {@link RuntimeDataOutput#write(byte[])}
   */
  @Test
  public void testWrite2() throws UnsupportedEncodingException {
    // Arrange
    RuntimeDataOutput runtimeDataOutput = new RuntimeDataOutput(
        new ZipOutput.LargeDataOutputStream(new PipedOutputStream()));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> runtimeDataOutput.write("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link RuntimeDataOutput#write(byte[], int, int)}
   */
  @Test
  public void testWrite3() throws UnsupportedEncodingException {
    // Arrange
    RuntimeDataOutput runtimeDataOutput = new RuntimeDataOutput(
        new ZipOutput.LargeDataOutputStream(new PipedOutputStream()));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> runtimeDataOutput.write("AXAXAXAX".getBytes("UTF-8"), 19088743, 3));
  }

  /**
   * Method under test: {@link RuntimeDataOutput#writeBoolean(boolean)}
   */
  @Test
  public void testWriteBoolean() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataOutput(new ZipOutput.LargeDataOutputStream(new PipedOutputStream()))).writeBoolean(true));
  }

  /**
   * Method under test: {@link RuntimeDataOutput#writeByte(int)}
   */
  @Test
  public void testWriteByte() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataOutput(new ZipOutput.LargeDataOutputStream(new PipedOutputStream())))
            .writeByte(19088743));
  }

  /**
   * Method under test: {@link RuntimeDataOutput#writeBytes(String)}
   */
  @Test
  public void testWriteBytes() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataOutput(new ZipOutput.LargeDataOutputStream(new PipedOutputStream()))).writeBytes("foo"));
  }

  /**
   * Method under test: {@link RuntimeDataOutput#writeChar(int)}
   */
  @Test
  public void testWriteChar() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataOutput(new ZipOutput.LargeDataOutputStream(new PipedOutputStream())))
            .writeChar(19088743));
  }

  /**
   * Method under test: {@link RuntimeDataOutput#writeChars(String)}
   */
  @Test
  public void testWriteChars() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataOutput(new ZipOutput.LargeDataOutputStream(new PipedOutputStream()))).writeChars("foo"));
  }

  /**
   * Method under test: {@link RuntimeDataOutput#writeDouble(double)}
   */
  @Test
  public void testWriteDouble() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataOutput(new ZipOutput.LargeDataOutputStream(new PipedOutputStream()))).writeDouble(10.0d));
  }

  /**
   * Method under test: {@link RuntimeDataOutput#writeFloat(float)}
   */
  @Test
  public void testWriteFloat() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataOutput(new ZipOutput.LargeDataOutputStream(new PipedOutputStream()))).writeFloat(10.0f));
  }

  /**
   * Method under test: {@link RuntimeDataOutput#writeInt(int)}
   */
  @Test
  public void testWriteInt() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataOutput(new ZipOutput.LargeDataOutputStream(new PipedOutputStream()))).writeInt(19088743));
  }

  /**
   * Method under test: {@link RuntimeDataOutput#writeLong(long)}
   */
  @Test
  public void testWriteLong() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataOutput(new ZipOutput.LargeDataOutputStream(new PipedOutputStream())))
            .writeLong(81985529216486895L));
  }

  /**
   * Method under test: {@link RuntimeDataOutput#writeUnsignedShort(int)}
   */
  @Test
  public void testWriteUnsignedShort() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new RuntimeDataOutput(new ZipOutput.LargeDataOutputStream(new ByteArrayOutputStream(1))))
            .writeUnsignedShort(19088743));
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataOutput(new ZipOutput.LargeDataOutputStream(new PipedOutputStream())))
            .writeUnsignedShort(65535));
  }

  /**
   * Method under test: {@link RuntimeDataOutput#writeSignedShort(int)}
   */
  @Test
  public void testWriteSignedShort() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new RuntimeDataOutput(new ZipOutput.LargeDataOutputStream(new ByteArrayOutputStream(1))))
            .writeSignedShort(19088743));
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataOutput(new ZipOutput.LargeDataOutputStream(new PipedOutputStream())))
            .writeSignedShort(17767));
  }

  /**
   * Method under test: {@link RuntimeDataOutput#writeShort(int)}
   */
  @Test
  public void testWriteShort() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataOutput(new ZipOutput.LargeDataOutputStream(new PipedOutputStream())))
            .writeShort(19088743));
  }

  /**
   * Method under test: {@link RuntimeDataOutput#writeUTF(String)}
   */
  @Test
  public void testWriteUTF() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataOutput(new ZipOutput.LargeDataOutputStream(new PipedOutputStream()))).writeUTF("Str"));
  }
}
