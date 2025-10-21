package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StreamingDataEntryDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void StreamingDataEntry.<init>(String, InputStream)",
    "InputStream StreamingDataEntry.getInputStream()",
    "String StreamingDataEntry.getName()",
    "DataEntry StreamingDataEntry.getParent()",
    "long StreamingDataEntry.getSize()",
    "boolean StreamingDataEntry.isDirectory()",
    "String StreamingDataEntry.toString()"
  })
  public void testGettersAndSetters() throws IOException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String StreamingDataEntry.getOriginalName()"})
  public void testGetOriginalName() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "Name",
        (new StreamingDataEntry("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))
            .getOriginalName());
  }
}
