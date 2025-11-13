package proguard.io;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.PipedOutputStream;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RuntimeDataOutputDiffblueTest {
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
  @DisplayName(
      "Test write(byte[], int, int) with 'byte[]', 'int', 'int'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.write(byte[], int, int)"})
  void testWriteWithByteIntInt_thenThrowRuntimeException() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new RuntimeDataOutput(new DataOutputStream(new PipedOutputStream()))
                .write("AXAXAXAX".getBytes("UTF-8"), 19088743, 3));
  }

  /**
   * Test {@link RuntimeDataOutput#write(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#write(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test write(byte[], int, int) with 'byte[]', 'int', 'int'; when one; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.write(byte[], int, int)"})
  void testWriteWithByteIntInt_whenOne_thenDoesNotThrow() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .write("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link RuntimeDataOutput#write(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#write(byte[])}
   */
  @Test
  @DisplayName("Test write(byte[]) with 'byte[]'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.write(byte[])"})
  void testWriteWithByte_thenDoesNotThrow() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .write("AXAXAXAX".getBytes("UTF-8")));
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
  @DisplayName("Test write(byte[]) with 'byte[]'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.write(byte[])"})
  void testWriteWithByte_thenThrowRuntimeException() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new RuntimeDataOutput(new DataOutputStream(new PipedOutputStream()))
                .write("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link RuntimeDataOutput#write(int)} with {@code int}.
   *
   * <ul>
   *   <li>Given {@link DataOutputStream#DataOutputStream(OutputStream)} with {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#write(int)}
   */
  @Test
  @DisplayName(
      "Test write(int) with 'int'; given DataOutputStream(OutputStream) with ByteArrayOutputStream(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.write(int)"})
  void testWriteWithInt_givenDataOutputStreamWithByteArrayOutputStream_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .write(19088743));
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
  @DisplayName("Test write(int) with 'int'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.write(int)"})
  void testWriteWithInt_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new RuntimeDataOutput(new DataOutputStream(new PipedOutputStream())).write(19088743));
  }

  /**
   * Test {@link RuntimeDataOutput#writeBoolean(boolean)}.
   *
   * <ul>
   *   <li>Given {@link DataOutputStream#DataOutputStream(OutputStream)} with {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeBoolean(boolean)}
   */
  @Test
  @DisplayName(
      "Test writeBoolean(boolean); given DataOutputStream(OutputStream) with ByteArrayOutputStream(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeBoolean(boolean)"})
  void testWriteBoolean_givenDataOutputStreamWithByteArrayOutputStream_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .writeBoolean(true));
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
  @DisplayName("Test writeBoolean(boolean); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeBoolean(boolean)"})
  void testWriteBoolean_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new RuntimeDataOutput(new DataOutputStream(new PipedOutputStream()))
                .writeBoolean(true));
  }

  /**
   * Test {@link RuntimeDataOutput#writeByte(int)}.
   *
   * <ul>
   *   <li>Given {@link DataOutputStream#DataOutputStream(OutputStream)} with {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeByte(int)}
   */
  @Test
  @DisplayName(
      "Test writeByte(int); given DataOutputStream(OutputStream) with ByteArrayOutputStream(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeByte(int)"})
  void testWriteByte_givenDataOutputStreamWithByteArrayOutputStream_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .writeByte(19088743));
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
  @DisplayName("Test writeByte(int); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeByte(int)"})
  void testWriteByte_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new RuntimeDataOutput(new DataOutputStream(new PipedOutputStream()))
                .writeByte(19088743));
  }

  /**
   * Test {@link RuntimeDataOutput#writeBytes(String)}.
   *
   * <ul>
   *   <li>Given {@link DataOutputStream#DataOutputStream(OutputStream)} with {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeBytes(String)}
   */
  @Test
  @DisplayName(
      "Test writeBytes(String); given DataOutputStream(OutputStream) with ByteArrayOutputStream(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeBytes(String)"})
  void testWriteBytes_givenDataOutputStreamWithByteArrayOutputStream_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .writeBytes("foo"));
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
  @DisplayName("Test writeBytes(String); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeBytes(String)"})
  void testWriteBytes_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new RuntimeDataOutput(new DataOutputStream(new PipedOutputStream())).writeBytes("foo"));
  }

  /**
   * Test {@link RuntimeDataOutput#writeChar(int)}.
   *
   * <ul>
   *   <li>Given {@link DataOutputStream#DataOutputStream(OutputStream)} with {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeChar(int)}
   */
  @Test
  @DisplayName(
      "Test writeChar(int); given DataOutputStream(OutputStream) with ByteArrayOutputStream(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeChar(int)"})
  void testWriteChar_givenDataOutputStreamWithByteArrayOutputStream_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .writeChar(19088743));
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
  @DisplayName("Test writeChar(int); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeChar(int)"})
  void testWriteChar_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new RuntimeDataOutput(new DataOutputStream(new PipedOutputStream()))
                .writeChar(19088743));
  }

  /**
   * Test {@link RuntimeDataOutput#writeChars(String)}.
   *
   * <ul>
   *   <li>Given {@link DataOutputStream#DataOutputStream(OutputStream)} with {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeChars(String)}
   */
  @Test
  @DisplayName(
      "Test writeChars(String); given DataOutputStream(OutputStream) with ByteArrayOutputStream(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeChars(String)"})
  void testWriteChars_givenDataOutputStreamWithByteArrayOutputStream_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .writeChars("foo"));
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
  @DisplayName("Test writeChars(String); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeChars(String)"})
  void testWriteChars_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new RuntimeDataOutput(new DataOutputStream(new PipedOutputStream())).writeChars("foo"));
  }

  /**
   * Test {@link RuntimeDataOutput#writeDouble(double)}.
   *
   * <ul>
   *   <li>Given {@link DataOutputStream#DataOutputStream(OutputStream)} with {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeDouble(double)}
   */
  @Test
  @DisplayName(
      "Test writeDouble(double); given DataOutputStream(OutputStream) with ByteArrayOutputStream(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeDouble(double)"})
  void testWriteDouble_givenDataOutputStreamWithByteArrayOutputStream_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .writeDouble(10.0d));
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
  @DisplayName("Test writeDouble(double); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeDouble(double)"})
  void testWriteDouble_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new RuntimeDataOutput(new DataOutputStream(new PipedOutputStream()))
                .writeDouble(10.0d));
  }

  /**
   * Test {@link RuntimeDataOutput#writeFloat(float)}.
   *
   * <ul>
   *   <li>Given {@link DataOutputStream#DataOutputStream(OutputStream)} with {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeFloat(float)}
   */
  @Test
  @DisplayName(
      "Test writeFloat(float); given DataOutputStream(OutputStream) with ByteArrayOutputStream(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeFloat(float)"})
  void testWriteFloat_givenDataOutputStreamWithByteArrayOutputStream_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .writeFloat(10.0f));
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
  @DisplayName("Test writeFloat(float); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeFloat(float)"})
  void testWriteFloat_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new RuntimeDataOutput(new DataOutputStream(new PipedOutputStream())).writeFloat(10.0f));
  }

  /**
   * Test {@link RuntimeDataOutput#writeInt(int)}.
   *
   * <ul>
   *   <li>Given {@link DataOutputStream#DataOutputStream(OutputStream)} with {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeInt(int)}
   */
  @Test
  @DisplayName(
      "Test writeInt(int); given DataOutputStream(OutputStream) with ByteArrayOutputStream(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeInt(int)"})
  void testWriteInt_givenDataOutputStreamWithByteArrayOutputStream_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .writeInt(19088743));
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
  @DisplayName("Test writeInt(int); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeInt(int)"})
  void testWriteInt_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new RuntimeDataOutput(new DataOutputStream(new PipedOutputStream()))
                .writeInt(19088743));
  }

  /**
   * Test {@link RuntimeDataOutput#writeLong(long)}.
   *
   * <ul>
   *   <li>Given {@link DataOutputStream#DataOutputStream(OutputStream)} with {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeLong(long)}
   */
  @Test
  @DisplayName(
      "Test writeLong(long); given DataOutputStream(OutputStream) with ByteArrayOutputStream(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeLong(long)"})
  void testWriteLong_givenDataOutputStreamWithByteArrayOutputStream_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .writeLong(81985529216486895L));
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
  @DisplayName("Test writeLong(long); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeLong(long)"})
  void testWriteLong_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new RuntimeDataOutput(new DataOutputStream(new PipedOutputStream()))
                .writeLong(81985529216486895L));
  }

  /**
   * Test {@link RuntimeDataOutput#writeUnsignedShort(int)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeUnsignedShort(int)}
   */
  @Test
  @DisplayName("Test writeUnsignedShort(int); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeUnsignedShort(int)"})
  void testWriteUnsignedShort_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .writeUnsignedShort(65535));
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
  @DisplayName("Test writeUnsignedShort(int); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeUnsignedShort(int)"})
  void testWriteUnsignedShort_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new RuntimeDataOutput(new DataOutputStream(new PipedOutputStream()))
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
  @DisplayName("Test writeUnsignedShort(int); when '19088743'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeUnsignedShort(int)"})
  void testWriteUnsignedShort_when19088743_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .writeUnsignedShort(19088743));
  }

  /**
   * Test {@link RuntimeDataOutput#writeSignedShort(int)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeSignedShort(int)}
   */
  @Test
  @DisplayName("Test writeSignedShort(int); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeSignedShort(int)"})
  void testWriteSignedShort_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .writeSignedShort(17767));
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
  @DisplayName("Test writeSignedShort(int); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeSignedShort(int)"})
  void testWriteSignedShort_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new RuntimeDataOutput(new DataOutputStream(new PipedOutputStream()))
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
  @DisplayName("Test writeSignedShort(int); when '19088743'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeSignedShort(int)"})
  void testWriteSignedShort_when19088743_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .writeSignedShort(19088743));
  }

  /**
   * Test {@link RuntimeDataOutput#writeShort(int)}.
   *
   * <ul>
   *   <li>Given {@link DataOutputStream#DataOutputStream(OutputStream)} with {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeShort(int)}
   */
  @Test
  @DisplayName(
      "Test writeShort(int); given DataOutputStream(OutputStream) with ByteArrayOutputStream(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeShort(int)"})
  void testWriteShort_givenDataOutputStreamWithByteArrayOutputStream_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .writeShort(19088743));
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
  @DisplayName("Test writeShort(int); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeShort(int)"})
  void testWriteShort_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new RuntimeDataOutput(new DataOutputStream(new PipedOutputStream()))
                .writeShort(19088743));
  }

  /**
   * Test {@link RuntimeDataOutput#writeUTF(String)}.
   *
   * <ul>
   *   <li>Given {@link DataOutputStream#DataOutputStream(OutputStream)} with {@link
   *       ByteArrayOutputStream#ByteArrayOutputStream()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RuntimeDataOutput#writeUTF(String)}
   */
  @Test
  @DisplayName(
      "Test writeUTF(String); given DataOutputStream(OutputStream) with ByteArrayOutputStream(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeUTF(String)"})
  void testWriteUTF_givenDataOutputStreamWithByteArrayOutputStream_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            new RuntimeDataOutput(new DataOutputStream(new ByteArrayOutputStream()))
                .writeUTF("Str"));
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
  @DisplayName("Test writeUTF(String); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuntimeDataOutput.writeUTF(String)"})
  void testWriteUTF_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new RuntimeDataOutput(new DataOutputStream(new PipedOutputStream())).writeUTF("Str"));
  }
}
