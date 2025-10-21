package proguard.io;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinConstants;

public class ManifestRewriterDiffblueTest {
  /**
   * Test {@link ManifestRewriter#copyData(Reader, Writer)} with {@code reader}, {@code writer}.
   *
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ManifestRewriter#copyData(Reader, Writer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ManifestRewriter.copyData(Reader, Writer)"})
  public void testCopyDataWithReaderWriter_thenStringWriterToStringIsFoo() throws IOException {
    // Arrange
    Charset charset = Charset.forName("UTF-8");
    ManifestRewriter manifestRewriter =
        new ManifestRewriter(
            KotlinConstants.dummyClassPool,
            charset,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    StringReader reader = new StringReader("foo");
    StringWriter writer = new StringWriter();

    // Act
    manifestRewriter.copyData(reader, writer);

    // Assert
    assertEquals("foo", writer.toString());
  }
}
