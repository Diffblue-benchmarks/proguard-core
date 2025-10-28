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

public class ManifestRewriterDiffblueTest {
  /**
   * Method under test: {@link ManifestRewriter#copyData(Reader, Writer)}
   */
  @Test
  public void testCopyData() throws IOException {
    // Arrange
    ManifestRewriter manifestRewriter = new ManifestRewriter(KotlinConstants.dummyClassPool, null,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    StringReader reader = new StringReader("foo");
    StringWriter writer = new StringWriter();

    // Act
    manifestRewriter.copyData(reader, writer);

    // Assert
    assertEquals("foo", writer.toString());
  }
}
