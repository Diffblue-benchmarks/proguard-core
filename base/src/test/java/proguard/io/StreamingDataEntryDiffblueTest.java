package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StreamingDataEntryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StreamingDataEntry#StreamingDataEntry(String, InputStream)}
   *   <li>{@link StreamingDataEntry#toString()}
   *   <li>{@link StreamingDataEntry#getInputStream()}
   *   <li>{@link StreamingDataEntry#getName()}
   *   <li>{@link StreamingDataEntry#getParent()}
   *   <li>{@link StreamingDataEntry#getSize()}
   *   <li>{@link StreamingDataEntry#isDirectory()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.StreamingDataEntry.<init>(java.lang.String, java.io.InputStream)",
    "java.io.InputStream proguard.io.StreamingDataEntry.getInputStream()",
    "java.lang.String proguard.io.StreamingDataEntry.getName()",
    "proguard.io.DataEntry proguard.io.StreamingDataEntry.getParent()",
    "long proguard.io.StreamingDataEntry.getSize()",
    "boolean proguard.io.StreamingDataEntry.isDirectory()",
    "java.lang.String proguard.io.StreamingDataEntry.toString()"
  })
  void testGettersAndSetters() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    StreamingDataEntry actualStreamingDataEntry = new StreamingDataEntry("Name", inputStream);
    String actualToStringResult = actualStreamingDataEntry.toString();
    InputStream actualInputStream = actualStreamingDataEntry.getInputStream();
    String actualName = actualStreamingDataEntry.getName();
    DataEntry actualParent = actualStreamingDataEntry.getParent();
    long actualSize = actualStreamingDataEntry.getSize();
    boolean actualIsDirectoryResult = actualStreamingDataEntry.isDirectory();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Name", actualToStringResult);
    assertNull(actualParent);
    assertEquals(-1L, actualSize);
    assertEquals(8, actualInputStream.read(new byte[8]));
    assertFalse(actualIsDirectoryResult);
    assertSame(inputStream, actualInputStream);
  }

  /**
   * Test {@link StreamingDataEntry#getOriginalName()}.
   *
   * <p>Method under test: {@link StreamingDataEntry#getOriginalName()}
   */
  @Test
  @DisplayName("Test getOriginalName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.io.StreamingDataEntry.getOriginalName()"})
  void testGetOriginalName() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "Name",
        (new StreamingDataEntry("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))
            .getOriginalName());
  }

  /**
   * Test {@link StreamingDataEntry#closeInputStream()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link StreamingDataEntry#closeInputStream()}
   */
  @Test
  @DisplayName("Test closeInputStream(); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.StreamingDataEntry.closeInputStream()"})
  void testCloseInputStream_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    doThrow(new IOException("foo")).when(inputStream).close();

    // Act and Assert
    assertThrows(
        IOException.class, () -> (new StreamingDataEntry("Name", inputStream)).closeInputStream());
    verify(inputStream).close();
  }
}
