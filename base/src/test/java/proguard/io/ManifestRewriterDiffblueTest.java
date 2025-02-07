package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.ClassPool;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.visitor.ClassVisitor;
import proguard.io.util.IOUtil;

class ManifestRewriterDiffblueTest {
  /**
   * Test {@link ManifestRewriter#ManifestRewriter(ClassPool, Charset, DataEntryWriter)}.
   *
   * <ul>
   *   <li>Given {@link DataEntryReader} {@link DataEntryReader#read(DataEntry)} does nothing.
   *   <li>Then calls {@link BiFunction#apply(Object, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link ManifestRewriter#ManifestRewriter(ClassPool, Charset,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new ManifestRewriter(ClassPool, Charset, DataEntryWriter); given DataEntryReader read(DataEntry) does nothing; then calls apply(Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.ManifestRewriter.<init>(proguard.classfile.ClassPool, java.nio.charset.Charset, proguard.io.DataEntryWriter)"
  })
  void testNewManifestRewriter_givenDataEntryReaderReadDoesNothing_thenCallsApply()
      throws IOException {
    // Arrange
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);
    ClassPool classPool =
        IOUtil.read(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false)),
            "Class Name Filter",
            true,
            true,
            true,
            true,
            true,
            true,
            extraDataEntryReader);
    Charset charset = Charset.forName("UTF-8");
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();
    DataEntryFilter dataEntryFilter = mock(DataEntryFilter.class);
    when(dataEntryFilter.accepts(Mockito.<DataEntry>any())).thenReturn(true);

    // Act
    ManifestRewriter actualManifestRewriter =
        new ManifestRewriter(
            classPool, charset, new FilteredDataEntryWriter(dataEntryFilter, null));
    actualManifestRewriter.read(new ClassPathDataEntry("Name"));

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryFilter).accepts(isA(DataEntry.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
  }

  /**
   * Test {@link ManifestRewriter#copyData(Reader, Writer)} with {@code reader}, {@code writer}.
   *
   * <p>Method under test: {@link ManifestRewriter#copyData(Reader, Writer)}
   */
  @Test
  @DisplayName("Test copyData(Reader, Writer) with 'reader', 'writer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ManifestRewriter.copyData(java.io.Reader, java.io.Writer)"})
  void testCopyDataWithReaderWriter() throws IOException {
    // Arrange
    DataEntryReader dataEntryReader = mock(DataEntryReader.class);
    doNothing().when(dataEntryReader).read(Mockito.<DataEntry>any());
    BiFunction<DataEntryReader, ClassVisitor, DataEntryReader> extraDataEntryReader =
        mock(BiFunction.class);
    when(extraDataEntryReader.apply(Mockito.<DataEntryReader>any(), Mockito.<ClassVisitor>any()))
        .thenReturn(dataEntryReader);
    ClassPool classPool =
        IOUtil.read(
            new ClassPath(
                new ClassPathEntry(
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), false)),
            "Class Name Filter",
            true,
            true,
            true,
            true,
            true,
            true,
            extraDataEntryReader);
    Charset charset = Charset.forName("UTF-8");
    ManifestRewriter manifestRewriter =
        new ManifestRewriter(
            classPool,
            charset,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    InputStreamReader reader =
        new InputStreamReader(
            new ByteArrayInputStream(new byte[] {'A', -2, 'A', -2, 'A', -2, 'A', -2}));
    StringWriter writer = new StringWriter();

    // Act
    manifestRewriter.copyData(reader, writer);

    // Assert
    verify(extraDataEntryReader).apply(isA(DataEntryReader.class), isA(ClassVisitor.class));
    verify(dataEntryReader, atLeast(1)).read(Mockito.<DataEntry>any());
    Stream<String> linesResult = (new BufferedReader(reader)).lines();
    assertEquals("", linesResult.collect(Collectors.joining("\n")));
    assertEquals("A�A�A�A�", writer.toString());
  }

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
  @DisplayName(
      "Test copyData(Reader, Writer) with 'reader', 'writer'; then StringWriter() toString is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ManifestRewriter.copyData(java.io.Reader, java.io.Writer)"})
  void testCopyDataWithReaderWriter_thenStringWriterToStringIsFoo() throws IOException {
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

  /**
   * Test {@link ManifestRewriter#copyData(Reader, Writer)} with {@code reader}, {@code writer}.
   *
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code ￾ ￾}.
   * </ul>
   *
   * <p>Method under test: {@link ManifestRewriter#copyData(Reader, Writer)}
   */
  @Test
  @DisplayName(
      "Test copyData(Reader, Writer) with 'reader', 'writer'; then StringWriter() toString is '￾ ￾'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void proguard.io.ManifestRewriter.copyData(java.io.Reader, java.io.Writer)"})
  void testCopyDataWithReaderWriter_thenStringWriterToStringIsUfffeSpaceUfffe() throws IOException {
    // Arrange
    Charset charset = Charset.forName("UTF-8");
    ManifestRewriter manifestRewriter =
        new ManifestRewriter(
            KotlinConstants.dummyClassPool,
            charset,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    CharArrayReader reader = new CharArrayReader("￾\n￾\n".toCharArray());
    StringWriter writer = new StringWriter();

    // Act
    manifestRewriter.copyData(reader, writer);

    // Assert
    assertEquals("￾\n￾\n", writer.toString());
    assertFalse(reader.ready());
  }
}
