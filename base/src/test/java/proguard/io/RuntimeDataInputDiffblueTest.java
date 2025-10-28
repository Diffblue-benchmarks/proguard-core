package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class RuntimeDataInputDiffblueTest {
  /**
   * Method under test: {@link RuntimeDataInput#readBoolean()}
   */
  @Test
  public void testReadBoolean() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue((new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
        .readBoolean());
    assertFalse((new RuntimeDataInput(
        new DataInputStream(new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}))))
            .readBoolean());
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[]{})))).readBoolean());
  }

  /**
   * Method under test: {@link RuntimeDataInput#readByte()}
   */
  @Test
  public void testReadByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals('A',
        (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readByte());
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[]{})))).readByte());
  }

  /**
   * Method under test: {@link RuntimeDataInput#readChar()}
   */
  @Test
  public void testReadChar() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals('䅘',
        (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readChar());
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[]{})))).readChar());
  }

  /**
   * Method under test: {@link RuntimeDataInput#readDouble()}
   */
  @Test
  public void testReadDouble() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(6358369.021011673d,
        (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .readDouble(),
        0.0);
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[]{})))).readDouble());
  }

  /**
   * Method under test: {@link RuntimeDataInput#readFloat()}
   */
  @Test
  public void testReadFloat() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(13.515953f,
        (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readFloat(),
        0.0f);
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[]{})))).readFloat());
  }

  /**
   * Method under test: {@link RuntimeDataInput#readFully(byte[])}
   */
  @Test
  public void testReadFully() throws UnsupportedEncodingException {
    // Arrange
    RuntimeDataInput runtimeDataInput = new RuntimeDataInput(
        new DataInputStream(new ByteArrayInputStream(new byte[]{})));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> runtimeDataInput.readFully("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link RuntimeDataInput#readFully(byte[], int, int)}
   */
  @Test
  public void testReadFully2() throws UnsupportedEncodingException {
    // Arrange
    RuntimeDataInput runtimeDataInput = new RuntimeDataInput(
        new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act
    runtimeDataInput.readFully(b, 1, 3);

    // Assert that nothing has changed
    assertEquals(8, b.length);
    assertEquals('A', b[1]);
    assertEquals('A', b[3]);
    assertEquals('X', b[2]);
  }

  /**
   * Method under test: {@link RuntimeDataInput#readFully(byte[], int, int)}
   */
  @Test
  public void testReadFully3() throws UnsupportedEncodingException {
    // Arrange
    RuntimeDataInput runtimeDataInput = new RuntimeDataInput(
        new DataInputStream(new ByteArrayInputStream(new byte[]{})));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> runtimeDataInput.readFully("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Method under test: {@link RuntimeDataInput#readInt()}
   */
  @Test
  public void testReadInt() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1096302936,
        (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readInt());
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[]{})))).readInt());
  }

  /**
   * Method under test: {@link RuntimeDataInput#readLine()}
   */
  @Test
  public void testReadLine() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("AXAXAXAX",
        (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readLine());
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataInput(new DataInputStream(new FileInputStream(new FileDescriptor())))).readLine());
  }

  /**
   * Method under test: {@link RuntimeDataInput#readLong()}
   */
  @Test
  public void testReadLong() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L,
        (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).readLong());
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[]{})))).readLong());
  }

  /**
   * Method under test: {@link RuntimeDataInput#readShort()}
   */
  @Test
  public void testReadShort() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals((short) 16728,
        (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .readShort());
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[]{})))).readShort());
  }

  /**
   * Method under test: {@link RuntimeDataInput#readUnsignedByte()}
   */
  @Test
  public void testReadUnsignedByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(65, (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
        .readUnsignedByte());
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[]{})))).readUnsignedByte());
  }

  /**
   * Method under test: {@link RuntimeDataInput#readUnsignedShort()}
   */
  @Test
  public void testReadUnsignedShort() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(16728,
        (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .readUnsignedShort());
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream(new byte[]{})))).readUnsignedShort());
  }

  /**
   * Method under test: {@link RuntimeDataInput#readUTF()}
   */
  @Test
  public void testReadUTF() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .readUTF());
  }

  /**
   * Method under test: {@link RuntimeDataInput#skipBytes(int)}
   */
  @Test
  public void testSkipBytes() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1, (new RuntimeDataInput(new DataInputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
        .skipBytes(1));
    assertThrows(RuntimeException.class,
        () -> (new RuntimeDataInput(new DataInputStream(new FileInputStream(new FileDescriptor())))).skipBytes(1));
  }
}
