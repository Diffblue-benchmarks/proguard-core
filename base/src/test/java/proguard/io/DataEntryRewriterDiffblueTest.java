package proguard.io;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Paths;
import org.junit.Test;
import proguard.classfile.kotlin.KotlinConstants;

public class DataEntryRewriterDiffblueTest {
  /**
   * Method under test: {@link DataEntryRewriter#copyData(Reader, Writer)}
   */
  @Test
  public void testCopyData() throws IOException {
    // Arrange
    DataEntryRewriter dataEntryRewriter = new DataEntryRewriter(KotlinConstants.dummyClassPool, null,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    StringReader reader = new StringReader("foo");
    StringWriter writer = new StringWriter();

    // Act
    dataEntryRewriter.copyData(reader, writer);

    // Assert
    assertEquals("foo", writer.toString());
  }
}
